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
import android.location.LocationListener;

/**
 * An abstract location provider, which periodically sends a location update to the provided {@link LocationListener}.
 */
public abstract class AbstractLocationProvider {
    private final LocationListener locationListener;

    public AbstractLocationProvider(final LocationListener locationListener) {
        this.locationListener = locationListener;
    }

    protected final LocationListener getLocationListener() {
        return this.locationListener;
    }

    /**
     * Start sending periodic location updates.
     *
     * @param context the {@link Context}.
     */
    abstract void start(final Context context);

    /**
     * Stop sending periodic location updates.
     *
     * @param context the {@link Context}.
     */
    abstract void stop(final Context context);
}
