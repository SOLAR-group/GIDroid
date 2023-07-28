/*  Copyright (C) 2015-2020 abettenburg, Andreas Shimokawa, Carsten Pfeiffer,
    Daniele Gobbetti, Lem Dulfo

    This file is part of Gadgetbridge.

    Gadgetbridge is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Gadgetbridge is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>. */
package nodomain.freeyourgadget.gadgetbridge.activities;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import nodomain.freeyourgadget.gadgetbridge.BuildConfig;

import nodomain.freeyourgadget.gadgetbridge.R;

public class AboutActivity extends AbstractGBActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView about_version = findViewById(R.id.about_version);
        TextView about_hash = findViewById(R.id.about_hash);
        String versionName = BuildConfig.VERSION_NAME;
        String versionHASH = BuildConfig.GIT_HASH_SHORT;
        about_version.setText(String.format(getString(R.string.about_version), versionName));
        about_hash.setText(String.format(getString(R.string.about_hash), versionHASH));

        TextView link1 = findViewById(R.id.links1);
        link1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView link2 = findViewById(R.id.links2);
        link2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView link3 = findViewById(R.id.links3);
        link3.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
