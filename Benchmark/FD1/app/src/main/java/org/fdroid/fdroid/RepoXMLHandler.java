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
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import org.fdroid.fdroid.R;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class RepoXMLHandler extends DefaultHandler {

    Context mctx;
    String mserver;

    private DB db;

    private DB.App curapp;
    private DB.Apk curapk;
    private String curel;

    public RepoXMLHandler(Context ctx, String srv, DB db) {
        mctx = ctx;
        mserver = srv;
        this.db = db;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        super.characters(ch, start, length);

        String str = new String(ch).substring(start, start + length);
        if (curapk != null && curel != null) {
            if (curel == "version") {
                curapk.version = str;
            } else if (curel == "versioncode") {
                try {
                    curapk.vercode = Integer.parseInt(str);
                } catch (NumberFormatException ex) {
                    curapk.vercode = 0;
                }
            } else if (curel == "hash") {
                curapk.hash = str;
            } else if (curel == "apkname") {
                curapk.apkName = str;
            }
        } else if (curapp != null && curel != null) {
            if (curel == "id")
                curapp.id = str;
            else if (curel == "name")
                curapp.name = str;
            else if (curel == "icon")
                curapp.icon = str;
            else if (curel == "description")
                curapp.description = str;
            else if (curel == "summary")
                curapp.summary = str;
            else if (curel == "license")
                curapp.license = str;
            else if (curel == "source")
                curapp.sourceURL = str;
            else if (curel == "web")
                curapp.webURL = str;
            else if (curel == "tracker")
                curapp.trackerURL = str;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        super.endElement(uri, localName, qName);

        if (localName == "application" && curapp != null) {
            Log.d("FDroid", "Repo: Updating application " + curapp.id);
            db.updateApplication(curapp);
            getIcon(curapp);
            curapp = null;
        } else if (localName == "package" && curapk != null && curapp != null) {
            Log.d("FDroid", "Repo: Package added (" + curapk.version + ")");
            curapp.apks.add(curapk);
            curapk = null;
        } else {
            curel = null;
        }

    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {

        super.startElement(uri, localName, qName, attributes);
        if (localName == "application" && curapp == null) {
            Log.d("FDroid", "Repo: Found application at " + mserver);
            curapp = new DB.App();
        } else if (localName == "package" && curapp != null && curapk == null) {
            Log.d("FDroid", "Repo: Found package for " + curapp.id);
            curapk = new DB.Apk();
            curapk.id = curapp.id;
            curapk.server = mserver;
        } else {
            curel = localName;
        }
    }

    protected void getIcon(DB.App app) {
        try {

            StringBuilder builder = new StringBuilder((CharSequence) Environment.getExternalStorageDirectory().toString()).append('/').append(mctx.getString(R.string.icons_path));

            File f = new File(builder.toString());
            f.mkdirs();
            builder.append(app.icon);
            BufferedInputStream getit = new BufferedInputStream(new URL(mserver
                    + "/icons/" + app.icon).openStream());
            f = new File(builder.toString());
            if (f.exists()){
                return;
            }

            boolean success  = f.createNewFile();
//            if (f.exists())
//                f.delete();
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                try (
                        FileOutputStream saveit = new FileOutputStream(f);
                        BufferedOutputStream bout = new BufferedOutputStream(saveit, 1024);){
                byte data[] = new byte[1024];

                int readed = getit.read(data, 0, 1024);
                while (readed != -1) {
                    System.out.print("\nGin Network: "); // GinProtect
                    System.out.println(data.length); // GinProtect
                    bout.write(data, 0, readed);
                    readed = getit.read(data, 0, 1024);
                }
                bout.close();
                getit.close();
                saveit.close();}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
