/*  Copyright (C) 2017-2021 Andreas Shimokawa, Carsten Pfeiffer, Dmytro
    Bielik, pangwalla

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
package nodomain.freeyourgadget.gadgetbridge.service.devices.huami.amazfitbipu;

import android.content.Context;
import android.net.Uri;

import java.io.IOException;

import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiFWHelper;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.amazfitbipu.AmazfitBipUFWHelper;
import nodomain.freeyourgadget.gadgetbridge.service.btle.TransactionBuilder;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.HuamiSupport;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.amazfitbips.AmazfitBipSSupport;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.operations.UpdateFirmwareOperation;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.operations.UpdateFirmwareOperation2020;

public class AmazfitBipUSupport extends AmazfitBipSSupport {

    @Override
    protected HuamiSupport setLanguage(TransactionBuilder builder) {
        return setLanguageByIdNew(builder);
    }

    @Override
    public boolean supportsSunriseSunsetWindHumidity() {
        return true;
    }

    @Override
    public HuamiFWHelper createFWHelper(Uri uri, Context context) throws IOException {
        return new AmazfitBipUFWHelper(uri, context);
    }

    @Override
    public UpdateFirmwareOperation createUpdateFirmwareOperation(Uri uri) {
        return new UpdateFirmwareOperation2020(uri, this);
    }

    @Override
    public int getActivitySampleSize() {
        return 8;
    }
}
