/*  Copyright (C) 2022 José Rebelo

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
package nodomain.freeyourgadget.gadgetbridge.externalevents.gps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Handler;
import android.os.Looper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nodomain.freeyourgadget.gadgetbridge.service.devices.pebble.webview.CurrentPosition;

/**
 * A mock location provider which keeps updating the location at a constant speed, starting from the
 * last known location. Useful for local tests.
 */
public class MockLocationProvider extends AbstractLocationProvider {
    private static final Logger LOG = LoggerFactory.getLogger(MockLocationProvider.class);

    private Location previousLocation = new CurrentPosition().getLastKnownLocation();

    /**
     * Interval between location updates, in milliseconds.
     */
    private final int interval = 1000;

    /**
     * Difference between location updates, in degrees.
     */
    private final float coordDiff = 0.0002f;

    /**
     * Whether the handler is running.
     */
    private boolean running = false;

    private final Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable locationUpdateRunnable = new Runnable() {
        @Override
        public void run() {
            if (!running) {
                return;
            }

            final Location newLocation = new Location(previousLocation);
            newLocation.setLatitude(previousLocation.getLatitude() + coordDiff);
            newLocation.setTime(System.currentTimeMillis());

            getLocationListener().onLocationChanged(newLocation);

            previousLocation = newLocation;

            if (running) {
                handler.postDelayed(this, interval);
            }
        }
    };

    public MockLocationProvider(LocationListener locationListener) {
        super(locationListener);
    }

    @Override
    void start(final Context context) {
        LOG.info("Starting mock location provider");

        running = true;
        handler.postDelayed(locationUpdateRunnable, interval);
    }

    @Override
    void stop(final Context context) {
        LOG.info("Stopping mock location provider");

        running = false;
        handler.removeCallbacksAndMessages(null);
    }
}
