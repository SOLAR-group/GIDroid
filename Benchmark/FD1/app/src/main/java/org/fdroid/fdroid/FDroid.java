/*
 * Copyright (C) 2010  Ciaran Gultnieks, ciaran@ciarang.com
 * Copyright (C) 2009  Roberto Jacinto, roberto.jacinto@caixamagica.pt
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package org.fdroid.fdroid;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import org.fdroid.fdroid.R;

import android.Manifest;
import android.R.drawable;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabHost.TabSpec;

import androidx.core.content.ContextCompat;

public class FDroid extends TabActivity implements OnItemClickListener {

    private class AppListAdapter extends BaseAdapter {

        private List<DB.App> items = new ArrayList<DB.App>();

        public AppListAdapter(Context context) {
        }

        public void addItem(DB.App app) {
            items.add(app);
        }

        public void clear() {
            items.clear();
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.applistitem, null);
            }
            DB.App app = items.get(position);

            TextView name = (TextView) v.findViewById(R.id.name);
            name.setText(app.name);

            String vs = " versions available";
            int numav = app.apks.size();
            if (numav == 1)
                vs = " version available";
            TextView status = (TextView) v.findViewById(R.id.status);
            status.setText(numav + vs);

            TextView license = (TextView) v.findViewById(R.id.license);
            license.setText(app.license);

            TextView summary = (TextView) v.findViewById(R.id.summary);
            summary.setText(app.summary);

            ImageView icon = (ImageView) v.findViewById(R.id.icon);
            String iconpath = new String(FDroid.this
                    .getString(R.string.icons_path)
                    + app.icon);
            File icn = new File(iconpath);
            if (icn.exists() && icn.length() > 0) {
                new Uri.Builder().build();
                icon.setImageURI(Uri.parse(iconpath));
            } else {
                icon.setImageResource(android.R.drawable.sym_def_app_icon);
            }

            return v;
        }
    }

    private String LOCAL_PATH;
    private String XML_PATH;

    private static final int REQUEST_APPDETAILS = 0;
    private static final int REQUEST_MANAGEREPOS = 1;

    private static final int UPDATE_REPO = Menu.FIRST;
    private static final int MANAGE_REPO = Menu.FIRST + 1;
    private static final int RESET_DB = Menu.FIRST + 2;
    private static final int ABOUT = Menu.FIRST + 3;

    protected DB db = null;

    // Apps that are available to be installed
    private AppListAdapter apps_av = new AppListAdapter(this);

    // Apps that are installed
    private AppListAdapter apps_in = new AppListAdapter(this);

    // Apps that can be upgraded
    private AppListAdapter apps_up = new AppListAdapter(this);

    private ProgressDialog pd;

    private Context mctx = this;

    private static final String TAB_IN = "INST";
    private static final String TAB_UN = "UNIN";
    private static final String TAB_UP = "UPDT";
    private TabHost tabHost;
    private TabSpec ts;
    private TabSpec ts1;
    private TabSpec tsUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fdroid);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        LOCAL_PATH = getExternalFilesDir(null) + "/" + R.string.app_name;
        XML_PATH = LOCAL_PATH + "/remapklst.xml";
        File local_path = new File(LOCAL_PATH);
        boolean success;
        if (!local_path.exists())
            success = local_path.mkdir();

        File icon_path = new File(this.getString(R.string.icons_path));
        if (!icon_path.exists())
            icon_path.mkdir();

        db = new DB(this);

        tabHost = getTabHost();
        createTabs();

        Intent i = getIntent();
        if (i.hasExtra("uri")) {
            Intent call = new Intent(this, ManageRepo.class);
            call.putExtra("uri", i.getStringExtra("uri"));
            startActivityForResult(call, REQUEST_MANAGEREPOS);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        populateLists(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, UPDATE_REPO, 1, R.string.menu_update_repo).setIcon(
                android.R.drawable.ic_menu_rotate);
        menu.add(Menu.NONE, MANAGE_REPO, 2, R.string.menu_manage).setIcon(
                android.R.drawable.ic_menu_agenda);
        menu.add(Menu.NONE, RESET_DB, 3, "Reset DB").setIcon(
                android.R.drawable.ic_menu_revert);
        menu.add(Menu.NONE, ABOUT, 4, R.string.menu_about).setIcon(
                android.R.drawable.ic_menu_help);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

        case UPDATE_REPO:
            updateRepos();
            return true;

        case MANAGE_REPO:
            Intent i = new Intent(this, ManageRepo.class);
            startActivityForResult(i, REQUEST_MANAGEREPOS);
            return true;

        case RESET_DB:
            db.reset();
            populateLists(true);
            return true;

        case ABOUT:
            LayoutInflater li = LayoutInflater.from(this);
            View view = li.inflate(R.layout.about, null);
            Builder p = new AlertDialog.Builder(this).setView(view);
            final AlertDialog alrt = p.create();
            alrt.setIcon(R.drawable.icon);
            alrt.setTitle(getString(R.string.about_title));
            alrt.setButton(AlertDialog.BUTTON_NEUTRAL,
                    getString(R.string.about_website),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                int whichButton) {
                            Uri uri = Uri
                                    .parse(getString(R.string.url_website));
                            startActivity(new Intent(Intent.ACTION_VIEW, uri));
                        }
                    });
            alrt.setButton(AlertDialog.BUTTON_NEGATIVE, "Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                int whichButton) {
                        }
                    });
            alrt.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
        case REQUEST_APPDETAILS:
            populateLists(false);
            break;
        case REQUEST_MANAGEREPOS:
            if (data.hasExtra("update")) {
                AlertDialog.Builder ask_alrt = new AlertDialog.Builder(this);
                ask_alrt.setTitle(getString(R.string.repo_update_title));
                ask_alrt.setIcon(android.R.drawable.ic_menu_rotate);
                ask_alrt.setMessage(getString(R.string.repo_alrt));
                ask_alrt.setPositiveButton(getString(R.string.yes),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                    int whichButton) {
                                updateRepos();
                            }
                        });
                ask_alrt.setNegativeButton(getString(R.string.no),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                    int whichButton) {
                                return;
                            }
                        });
                AlertDialog alert = ask_alrt.create();
                alert.show();
            }
            break;

        }
    }

    private void createTabs() {
//        tabHost.clearAllTabs();

        // TabContentFactory that can generate the appropriate list for each
        // tab...
        TabHost.TabContentFactory tf = new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {

                AppListAdapter ad;
                if (tag.equals(TAB_IN))
                    ad = apps_in;
                else if (tag.equals(TAB_UP))
                    ad = apps_up;
                else
                    ad = apps_av;

                ListView lst = new ListView(FDroid.this);
                lst.setOnItemClickListener(FDroid.this);
                lst.setAdapter(ad);
                return lst;
            }
        };

        // Create the tab of installed apps...
        ts = tabHost.newTabSpec(TAB_IN);
        ts.setIndicator(getString(R.string.tab_installed), getResources()
                .getDrawable(drawable.star_off));
        ts.setContent(tf);

        // Create the tab of apps with updates...
        tsUp = tabHost.newTabSpec(TAB_UP);
        tsUp.setIndicator(getString(R.string.tab_updates), getResources()
                .getDrawable(drawable.star_on));
        tsUp.setContent(tf);

        // Create the tab of available apps...
        ts1 = tabHost.newTabSpec(TAB_UN);
        ts1.setIndicator(getString(R.string.tab_noninstalled), getResources()
                .getDrawable(drawable.ic_input_add));
        ts1.setContent(tf);

        tabHost.addTab(ts1);
        tabHost.addTab(ts);
        tabHost.addTab(tsUp);

    }

    // Populate the lists.
    // 'update' - true to update the installed status of the applications
    // by asking the system.
    private void populateLists(boolean update) {

        Vector<DB.App> apps = db.getApps(null, null, update);
        Log.d("FDroid", "Updating lists - " + apps.size() + " apps in total");

        apps_in.clear();
        apps_av.clear();
        apps_up.clear();
        for (DB.App app : apps) {
            if (app.installedVersion == null) {
                apps_av.addItem(app);
            } else {
                apps_in.addItem(app);
                if (app.hasUpdates)
                    apps_up.addItem(app);
            }
        }

        // Tell the lists that the data behind the adapter has changed, so
        // they can refresh...
        apps_av.notifyDataSetChanged();
        apps_in.notifyDataSetChanged();
        apps_up.notifyDataSetChanged();

    }

    public boolean updateRepos() {
        pd = ProgressDialog.show(this, getString(R.string.process_wait_title),
                getString(R.string.process_update_msg), true);
        pd.setIcon(android.R.drawable.ic_dialog_info);

        // Check for connection first!
        ConnectivityManager netstate = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (netstate.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED
                || netstate.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED) {
            new Thread() {
                public void run() {
                    try {
                        db.beginUpdate();
                        Vector<DB.Repo> repos = db.getRepos();
                        for (DB.Repo repo : repos) {
                            if (repo.inuse) {
                                downloadRepoIndex(repo.address);
                                xmlPass(repo.address);
                            }
                        }
                        db.endUpdate();
                    } catch (Exception e) {
                        Log.d("FDroid", "Exception while updating - "
                                + e.getMessage());
                    }
                    update_handler.sendEmptyMessage(0);
                }
            }.start();
            return true;
        } else {
            pd.dismiss();
            Toast.makeText(FDroid.this, getString(R.string.connection_error),
                    Toast.LENGTH_LONG).show();
            return false;
        }
    }

    /*
     * Pass XML info to BD a xml file must exists...
     */
    private void xmlPass(String srv) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            RepoXMLHandler handler = new RepoXMLHandler(this, srv, db);
            xr.setContentHandler(handler);
            File xmlFile = new File(XML_PATH);
            xmlFile.createNewFile();

            InputStreamReader isr = new FileReader(xmlFile);
            InputSource is = new InputSource(isr);
            xr.parse(is);
            File xml_file = new File(XML_PATH);
            xml_file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    // Download a repo index to a temporary file on the SD card.
    private void downloadRepoIndex(String srv) {
        try {
            BufferedInputStream getit = new BufferedInputStream(new URL(srv
                    + "/index.xml").openStream());

            File file_teste = new File(XML_PATH);
            if (file_teste.exists())
                file_teste.delete();

            FileOutputStream saveit = new FileOutputStream(XML_PATH);
            BufferedOutputStream bout = new BufferedOutputStream(saveit, 1024);
            byte data[] = new byte[1024];

            int readed = getit.read(data, 0, 1024);
            while (readed != -1) {
                bout.write(data, 0, readed);
                readed = getit.read(data, 0, 1024);
            }
            bout.close();
            getit.close();
            saveit.close();
        } catch (UnknownHostException e) {
            Message msg = new Message();
            msg.obj = new String(srv);
            error_handler.sendMessage(msg);
        } catch (Exception e) {
            Log.d("hi",e.getMessage());
        }
    }

    /*
     * Handlers for thread functions that need to access GUI
     */
    private Handler update_handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            populateLists(true);
            if (pd.isShowing())
                pd.dismiss();
        }
    };

    private Handler error_handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (pd.isShowing())
                pd.dismiss();
            AlertDialog p = new AlertDialog.Builder(mctx).create();
            p.setTitle(getString(R.string.connection_timeout));
            p.setIcon(android.R.drawable.ic_dialog_alert);
            p.setMessage(getString(R.string.connection_error_msg) + ": < "
                    + msg.obj.toString() + " >");
            p.setButton(getString(R.string.ok),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    });
            p.show();
        }
    };

    // Handler for a click on one of the items in an application list. Pops
    // up a dialog that shows the details of the application and all its
    // available versions, with buttons to allow installation etc.
    public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
            long arg3) {

        final DB.App app;
        String curtab = tabHost.getCurrentTabTag();
        if (curtab.equalsIgnoreCase(TAB_IN)) {
            app = (DB.App) apps_in.getItem(arg2);
        } else if (curtab.equalsIgnoreCase(TAB_UP)) {
            app = (DB.App) apps_up.getItem(arg2);
        } else {
            app = (DB.App) apps_av.getItem(arg2);
        }

        Intent intent = new Intent(this, AppDetails.class);
        intent.putExtra("appid", app.id);
        startActivityForResult(intent, REQUEST_APPDETAILS);

    }

}
