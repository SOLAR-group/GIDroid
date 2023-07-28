/*  Copyright (C) 2019-2021 Daniel Dakhno

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
package nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil.file;

import android.bluetooth.BluetoothGattCharacteristic;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.file.FileHandle;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.Request;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil.FossilRequest;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil_hr.file.ResultCode;

public class FileCloseRequest extends FossilRequest {
    private boolean isFinished = false;
    private FileHandle handle;

    public FileCloseRequest(FileHandle fileHandle) {
        this.handle = fileHandle;
        ByteBuffer buffer = this.createBuffer();
        buffer.putShort(fileHandle.getHandle());

        this.data = buffer.array();
    }

    public FileHandle getHandle() {
        return handle;
    }

    @Override
    public void handleResponse(BluetoothGattCharacteristic characteristic) {
        super.handleResponse(characteristic);

        if(!characteristic.getUuid().toString().equals(this.getRequestUUID().toString())){
            throw new RuntimeException("wrong response UUID");
        }

        byte[] value = characteristic.getValue();

        byte type = (byte)(value[0] & 0x0F);

        if(type != 9) throw new RuntimeException("wrong response type");

        if(value.length != 4) throw new RuntimeException("wrong response length");

        ByteBuffer buffer = ByteBuffer.wrap(value);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        if(this.handle.getHandle() != buffer.getShort(1)) throw new RuntimeException("wrong response handle");

        byte status = buffer.get(3);

        ResultCode code = ResultCode.fromCode(status);
        if(!code.inidicatesSuccess()) throw new RuntimeException("wrong response status: " + code + "   (" + status + ")");

        this.isFinished = true;

        this.onPrepare();
    }

    public void onPrepare(){}

    @Override
    public byte[] getStartSequence() {
        return new byte[]{9};
    }

    @Override
    public int getPayloadLength() {
        return 3;
    }

    @Override
    public boolean isFinished(){
        return this.isFinished;
    }

    @Override
    public UUID getRequestUUID() {
        return UUID.fromString("3dda0003-957f-7d4a-34a6-74696673696d");
    }
}
