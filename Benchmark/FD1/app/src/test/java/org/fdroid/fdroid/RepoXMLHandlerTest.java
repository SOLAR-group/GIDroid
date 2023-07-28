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


import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.httpclient.FakeHttp;

import android.content.Context;
import android.os.Environment;

import androidx.test.core.app.ApplicationProvider;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.Vector;

@RunWith(RobolectricTestRunner.class)
public class RepoXMLHandlerTest {

    @Test
    public void bandTest() throws IOException {
        FakeHttp.getFakeHttpLayer().interceptHttpRequests(false);
        FDroid fdroid = Robolectric.setupActivity(FDroid.class);
        RepoXMLHandler handler = new RepoXMLHandler(ApplicationProvider.getApplicationContext(), "https://f-droid.org/repo", null);
        DB.App app = new DB.App();
        app.icon = "org.tint.adblock.3.png";
        handler.getIcon(app);
        handler.getIcon(app);
        String destpath = Environment.getExternalStorageDirectory() + "/" + handler.mctx.getString(R.string.icons_path);
        destpath += app.icon;
        BufferedInputStream getit = new BufferedInputStream(new URL(handler.mserver
                + "/icons/" + app.icon).openStream());
        byte data[] = new byte[1024];
        byte data2[] = new byte[1024];
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File(destpath)));
        int readed = getit.read(data, 0, 1024);
        int readb = bin.read(data2,0,1024);
        long start = System.currentTimeMillis();
        while (readed != -1) {
            for (int i =0; i<1024; i++){
                assert data[i] == data2[i];
            }
            readb = bin.read(data2,0,1024);
            readed = getit.read(data, 0, 1024);
            if (System.currentTimeMillis() - start > 20000){
                assert false;
            }
        }
    }


}
