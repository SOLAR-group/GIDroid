/*  Copyright (C) 2018-2021 Andreas Böhler, Sebastian Kranz, Taavi Eomäe

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
package nodomain.freeyourgadget.gadgetbridge.service.devices.casio;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.Toast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import nodomain.freeyourgadget.gadgetbridge.GBApplication;
import nodomain.freeyourgadget.gadgetbridge.deviceevents.GBDeviceEventCallControl;
import nodomain.freeyourgadget.gadgetbridge.deviceevents.GBDeviceEventFindPhone;
import nodomain.freeyourgadget.gadgetbridge.deviceevents.GBDeviceEventMusicControl;
import nodomain.freeyourgadget.gadgetbridge.devices.casio.CasioConstants;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.model.Alarm;
import nodomain.freeyourgadget.gadgetbridge.model.CalendarEventSpec;
import nodomain.freeyourgadget.gadgetbridge.model.CallSpec;
import nodomain.freeyourgadget.gadgetbridge.model.CannedMessagesSpec;
import nodomain.freeyourgadget.gadgetbridge.model.MusicSpec;
import nodomain.freeyourgadget.gadgetbridge.model.MusicStateSpec;
import nodomain.freeyourgadget.gadgetbridge.model.NotificationSpec;
import nodomain.freeyourgadget.gadgetbridge.model.WeatherSpec;
import nodomain.freeyourgadget.gadgetbridge.service.btle.AbstractBTLEDeviceSupport;
import nodomain.freeyourgadget.gadgetbridge.service.btle.GattCharacteristic;
import nodomain.freeyourgadget.gadgetbridge.service.btle.GattService;
import nodomain.freeyourgadget.gadgetbridge.service.btle.ServerTransactionBuilder;
import nodomain.freeyourgadget.gadgetbridge.service.btle.TransactionBuilder;
import nodomain.freeyourgadget.gadgetbridge.service.devices.casio.operations.InitOperationGB6900;
import nodomain.freeyourgadget.gadgetbridge.service.devices.casio.operations.SetAlarmOperation;
import nodomain.freeyourgadget.gadgetbridge.util.GB;
import nodomain.freeyourgadget.gadgetbridge.util.StringUtils;

import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DISCONNECTNOTIF_NOSHED;

public class CasioGB6900DeviceSupport extends CasioSupport {
    private static final Logger LOG = LoggerFactory.getLogger(CasioGB6900DeviceSupport.class);

    private final ArrayList<BluetoothGattCharacteristic> mCasioCharacteristics = new ArrayList<BluetoothGattCharacteristic>();
    private CasioHandlerThread mHandlerThread = null;
    private MusicSpec mBufferMusicSpec = null;
    private MusicStateSpec mBufferMusicStateSpec = null;
    private BluetoothGatt mBtGatt = null;
    private CasioConstants.Model mModel = CasioConstants.Model.MODEL_CASIO_GENERIC;

    private static final int mCasioSleepTime = 50;

    public CasioGB6900DeviceSupport() {
        super(LOG);
        addSupportedService(GattService.UUID_SERVICE_IMMEDIATE_ALERT);
        addSupportedService(CasioConstants.CASIO_VIRTUAL_SERVER_SERVICE);
        addSupportedService(CasioConstants.ALERT_SERVICE_UUID);
        addSupportedService(CasioConstants.CASIO_IMMEDIATE_ALERT_SERVICE_UUID);
        addSupportedService(CasioConstants.CURRENT_TIME_SERVICE_UUID);
        addSupportedService(CasioConstants.WATCH_CTRL_SERVICE_UUID);
        addSupportedService(CasioConstants.CASIO_PHONE_ALERT_STATUS_SERVICE);
        addSupportedService(CasioConstants.MORE_ALERT_SERVICE_UUID);
        addSupportedService(CasioConstants.TX_POWER_SERVICE_UUID);
        addSupportedService(CasioConstants.LINK_LOSS_SERVICE);
        addSupportedService(CasioConstants.IMMEDIATE_ALERT_SERVICE_UUID);

        BluetoothGattService casioGATTService = new BluetoothGattService(CasioConstants.WATCH_CTRL_SERVICE_UUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);
        BluetoothGattCharacteristic bluetoothGATTCharacteristic = new BluetoothGattCharacteristic(CasioConstants.KEY_CONTAINER_CHARACTERISTIC_UUID, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, BluetoothGattCharacteristic.PERMISSION_WRITE);
        bluetoothGATTCharacteristic.setValue(new byte[0]);

        BluetoothGattCharacteristic bluetoothGATTCharacteristic2 = new BluetoothGattCharacteristic(CasioConstants.NAME_OF_APP_CHARACTERISTIC_UUID, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_READ_ENCRYPTED);
        bluetoothGATTCharacteristic2.setValue(CasioConstants.MUSIC_MESSAGE.getBytes());

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CasioConstants.CCC_DESCRIPTOR_UUID, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

        bluetoothGATTCharacteristic2.addDescriptor(bluetoothGattDescriptor);

        casioGATTService.addCharacteristic(bluetoothGATTCharacteristic);
        casioGATTService.addCharacteristic(bluetoothGATTCharacteristic2);

        addSupportedServerService(casioGATTService);
    }

    @Override
    public boolean connectFirstTime() {
        GB.toast(getContext(), "After first connect, disable and enable bluetooth on your Casio watch to really connect", Toast.LENGTH_SHORT, GB.INFO);
        mFirstConnect = true;
        return super.connect();
    }

    @Override
    public void dispose() {
        LOG.info("Dispose");
        close();

        super.dispose();
    }

    private void close() {
        if (mHandlerThread != null) {
            mHandlerThread.quit();
            mHandlerThread.interrupt();
            mHandlerThread = null;
        }
    }

    @Override
    public void onServicesDiscovered(BluetoothGatt gatt) {
        mBtGatt = gatt;
        super.onServicesDiscovered(gatt);
    }

    @Override
    protected TransactionBuilder initializeDevice(TransactionBuilder builder) {
        LOG.info("Initializing");

        if(mFirstConnect) {
            setInitialized();
            getDevice().setFirmwareVersion("N/A");
            getDevice().setFirmwareVersion2("N/A");
            return builder;
        }

        String name = gbDevice.getName();

        if(name.contains("5600B")) {
            mModel = CasioConstants.Model.MODEL_CASIO_5600B;
        } else if(name.contains("6900B")) {
            mModel = CasioConstants.Model.MODEL_CASIO_6900B;
        } else if(name.contains("STB-1000")) {
            mModel = CasioConstants.Model.MODEL_CASIO_STB1000;
        } else {
            mModel = CasioConstants.Model.MODEL_CASIO_GENERIC;
        }

        // We skip configuring BLE settings for the STB-1000 since it powers off
        // BLE on the watch.
        if(mModel != CasioConstants.Model.MODEL_CASIO_STB1000) {
            try {
                new InitOperationGB6900(this, builder).perform();
            } catch (IOException e) {
                GB.toast(getContext(), "Initializing Casio watch failed", Toast.LENGTH_SHORT, GB.ERROR, e);
            }
        }

        getDevice().setFirmwareVersion("N/A");
        getDevice().setFirmwareVersion2("N/A");


        builder.setGattCallback(this);

        configureWatch(builder);

        addCharacteristics();
        enableNotifications(builder, true);

        LOG.info("Initialization Done");

        return builder;
    }

    CasioConstants.Model getModel() {
        return mModel;
    }

    private void configureWatch(TransactionBuilder builder) {
        if (mBtGatt == null) {
            return;
        }

        SharedPreferences sharedPreferences = GBApplication.getDeviceSpecificSharedPrefs(getDevice().getAddress());

        boolean enable = sharedPreferences.getBoolean(PREF_DISCONNECTNOTIF_NOSHED, false);

        byte[] value = new byte[1];

        if(enable)
            value[0] = GattCharacteristic.MILD_ALERT;
        else
            value[0] = GattCharacteristic.NO_ALERT;

        BluetoothGattService llService = mBtGatt.getService(CasioConstants.LINK_LOSS_SERVICE);
        BluetoothGattCharacteristic charact = llService.getCharacteristic(CasioConstants.ALERT_LEVEL_CHARACTERISTIC_UUID);
        builder.write(charact, value);
        builder.wait(mCasioSleepTime);
    }

    private void addCharacteristics() {
        mCasioCharacteristics.clear();
        mCasioCharacteristics.add(getCharacteristic(CasioConstants.CASIO_A_NOT_COM_SET_NOT));
        mCasioCharacteristics.add(getCharacteristic(CasioConstants.CASIO_A_NOT_W_REQ_NOT));
        mCasioCharacteristics.add(getCharacteristic(CasioConstants.ALERT_LEVEL_CHARACTERISTIC_UUID));
        mCasioCharacteristics.add(getCharacteristic(CasioConstants.RINGER_CONTROL_POINT));
    }

    public boolean enableNotifications(TransactionBuilder builder, boolean enable) {
        for(BluetoothGattCharacteristic charact : mCasioCharacteristics) {
            builder.notify(charact, enable);
            builder.wait(mCasioSleepTime);
        }
        return true;
    }

    public void readTxPowerLevel() {
        try {
            TransactionBuilder builder = performInitialized("readTxPowerLevel");
            builder.read(getCharacteristic(CasioConstants.TX_POWER_LEVEL_CHARACTERISTIC_UUID));
            builder.queue(getQueue());
        } catch (IOException e) {
            LOG.warn("readTxPowerLevel failed: " + e.getMessage());
        }
    }

    private void writeCasioCurrentTime(TransactionBuilder builder) {
        byte[] arr = prepareCurrentTime();

        BluetoothGattCharacteristic charact = getCharacteristic(CasioConstants.CURRENT_TIME_CHARACTERISTIC_UUID);
        if(charact != null) {
            charact.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
            builder.write(charact, arr);
        }
        else {
            LOG.warn("Characteristic not found: CURRENT_TIME_CHARACTERISTIC_UUID");
        }
    }

    private void writeCasioLocalTimeInformation(TransactionBuilder builder) {
        Calendar cal = Calendar.getInstance();
        int zoneOffset = (int)TimeUnit.MILLISECONDS.toMinutes(cal.get(Calendar.ZONE_OFFSET));
        int dstOffset = (int)TimeUnit.MILLISECONDS.toMinutes(cal.get(Calendar.DST_OFFSET));
        byte byte0 = (byte)(zoneOffset / 15);
        byte byte1 = (byte)(dstOffset / 15);
        BluetoothGattCharacteristic charact = getCharacteristic(CasioConstants.LOCAL_TIME_CHARACTERISTIC_UUID);
        if(charact != null) {
            builder.write(charact, new byte[]{byte0, byte1});
        }
        else {
            LOG.warn("Characteristic not found: LOCAL_TIME_CHARACTERISTIC_UUID");
        }

    }

    private void writeCasioVirtualServerFeature(TransactionBuilder builder) {
        byte byte0 = (byte)0;
        byte0 |= 1; // Casio Current Time Service
        byte0 |= 2; // Casio Alert Notification Service
        byte0 |= 4; // Casio Phone Alert Status Service
        byte0 |= 8; // Casio Immediate Alert Service

        BluetoothGattCharacteristic charact = getCharacteristic(CasioConstants.CASIO_VIRTUAL_SERVER_FEATURES);
        if(charact != null) {
            builder.write(charact, new byte[]{byte0, 0x00});
        }
        else {
            LOG.warn("Characteristic not found: CASIO_VIRTUAL_SERVER_FEATURES");
        }
    }

    private boolean handleInitResponse(byte data) {
        boolean handled = false;
        switch (data) {
            case (byte) 1:
                LOG.info("Initialization done, setting state to INITIALIZED");
                if (mHandlerThread != null) {
                    if (mHandlerThread.isAlive()) {
                        mHandlerThread.quit();
                        mHandlerThread.interrupt();
                    }
                }
                mHandlerThread = new CasioHandlerThread(getDevice(), getContext(), this);
                mHandlerThread.start();
                gbDevice.setState(GBDevice.State.INITIALIZED);
                gbDevice.sendDeviceUpdateIntent(getContext());
                handled = true;
                break;
            default:
                LOG.warn("handleInitResponse: Error initializing device, received unexpected value: " + data);
                gbDevice.setState(GBDevice.State.NOT_CONNECTED);
                gbDevice.sendDeviceUpdateIntent(getContext());
                handled = true;
                break;
        }
        return handled;
    }

    private boolean handleTimeRequests(byte data) {
        boolean handled = false;
        switch(data) // Request Type
        {
            case (byte) 1:
                try
                {
                    TransactionBuilder builder = createTransactionBuilder("writeCasioCurrentTime");
                    writeCasioCurrentTime(builder);
                    performConnected(builder.getTransaction());
                    handled = true;
                } catch (IOException e) {
                    LOG.warn("handleTimeRequests::writeCasioCurrentTime failed: " + e.getMessage());
                }
                break;
            case (byte) 2:
                try
                {
                    TransactionBuilder builder = createTransactionBuilder("writeCasioLocalTimeInformation");
                    writeCasioLocalTimeInformation(builder);
                    performConnected(builder.getTransaction());
                    handled = true;
                } catch (IOException e) {
                    LOG.warn("handleTimeRequests::writeCasioLocalTimeInformation failed: " + e.getMessage());
                }
                break;
        }
        return handled;
    }

    private boolean handleServerFeatureRequests(byte data) {
        try
        {
            TransactionBuilder builder = createTransactionBuilder("writeCasioVirtualServerFeature");
            writeCasioVirtualServerFeature(builder);
            performConnected(builder.getTransaction());
        } catch (IOException e) {
            LOG.warn("handleServerFeatureRequests failed: " + e.getMessage());
        }
        return true;
    }

    private boolean handleCasioCom(byte[] data, boolean handleTime) {
        boolean handled = false;

        if(data.length < 3) {
            LOG.warn("handleCasioCom failed: Received unexpected request (too short)");
            return false;
        }

        switch(data[0]) // ServiceID
        {
            case 0:
                handled = handleInitResponse(data[2]);
                break;
            case 2:
                if(handleTime) {
                    handled = handleTimeRequests(data[2]);
                } else {
                    handled = true;
                }
                break;
            case 7:
                handled = handleServerFeatureRequests(data[2]);
                break;
        }
        return handled;
    }

    @Override
    public boolean onCharacteristicRead(BluetoothGatt gatt,
                                        BluetoothGattCharacteristic characteristic, int status) {

        UUID characteristicUUID = characteristic.getUuid();
        byte[] data = characteristic.getValue();

        if(data.length == 0)
            return true;

        if(characteristicUUID.equals(CasioConstants.TX_POWER_LEVEL_CHARACTERISTIC_UUID)) {
            StringBuilder str = new StringBuilder("onCharacteristicRead: Received power level: ");
            for(int i=0; i<data.length; i++) {
                str.append(String.format("0x%1x ", data[i]));
            }
            LOG.info(str.toString());
        }
        else {
            return super.onCharacteristicRead(gatt, characteristic, status);
        }

        return true;
    }

    @Override
    public boolean onCharacteristicChanged(BluetoothGatt gatt,
                                           BluetoothGattCharacteristic characteristic) {
        boolean handled = false;

        UUID characteristicUUID = characteristic.getUuid();
        byte[] data = characteristic.getValue();
        if (data.length == 0)
            return true;

        if(characteristicUUID.equals(CasioConstants.CASIO_A_NOT_W_REQ_NOT)) {
            handled = handleCasioCom(data, true);
        }

        if(characteristicUUID.equals(CasioConstants.CASIO_A_NOT_COM_SET_NOT)) {
            handled = handleCasioCom(data, false);
        }

        if(characteristicUUID.equals(CasioConstants.ALERT_LEVEL_CHARACTERISTIC_UUID)) {
            GBDeviceEventFindPhone findPhoneEvent = new GBDeviceEventFindPhone();
            if(data[0] == 0x02) {
                findPhoneEvent.event = GBDeviceEventFindPhone.Event.START;
            }
            else {
                findPhoneEvent.event = GBDeviceEventFindPhone.Event.STOP;
            }
            evaluateGBDeviceEvent(findPhoneEvent);
            handled = true;
        }

        if(characteristicUUID.equals(CasioConstants.RINGER_CONTROL_POINT)) {
            if(data[0] == 0x02)
            {
                GBDeviceEventCallControl callControlEvent = new GBDeviceEventCallControl();
                callControlEvent.event = GBDeviceEventCallControl.Event.IGNORE;
                evaluateGBDeviceEvent(callControlEvent);
            }
            handled = true;
        }

        if(!handled) {
            LOG.info("Unhandled characteristic change: " + characteristicUUID + " code: " + String.format("0x%1x ...", data[0]));
            return super.onCharacteristicChanged(gatt, characteristic);
        }
        return true;
    }

    private void showNotification(byte icon, String title, String message) {
        if(!isConnected())
            return;
        try {
            TransactionBuilder builder = performInitialized("showNotification");
            int len;

            byte[] titleBytes = title.getBytes(StandardCharsets.US_ASCII);
            len = titleBytes.length > 18 ? 18 : titleBytes.length;
            byte[] msg = new byte[2 + len];
            msg[0] = icon;
            msg[1] = 1;
            System.arraycopy(titleBytes, 0, msg, 2, len);

            builder.write(getCharacteristic(CasioConstants.ALERT_CHARACTERISTIC_UUID), msg);
            LOG.info("Showing notification, title: " + title + " message (not sent): " + message);
            builder.queue(getQueue());
        } catch (IOException e) {
            LOG.warn("showNotification failed: " + e.getMessage());
        }
    }

    @Override
    public void onNotification(NotificationSpec notificationSpec) {
        String notificationTitle = StringUtils.getFirstOf(notificationSpec.sender, notificationSpec.title);
        byte icon;
        switch (notificationSpec.type.getGenericType()) {
            case "generic_sms":
                icon = CasioConstants.SMS_NOTIFICATION_ID;
                break;
            case "generic_calendar":
                icon = CasioConstants.CALENDAR_NOTIFICATION_ID;
                break;
            case "generic_email":
                icon = CasioConstants.MAIL_NOTIFICATION_ID;
                break;
            default:
                icon = CasioConstants.SNS_NOTIFICATION_ID;
                break;
        }
        showNotification(icon, notificationTitle, notificationSpec.body);
    }

    @Override
    public void onSetAlarms(ArrayList<? extends Alarm> alarms) {
        if(!isConnected())
            return;

        try {
            new SetAlarmOperation(this, alarms).perform();
        } catch (IOException e) {
            LOG.error("Setting alarm failed: " + e.getMessage());
        }
    }

    @Override
    public void onSetTime() {
        if(!isConnected())
            return;

        try {
            TransactionBuilder builder = performInitialized("SetTime");
            writeCasioLocalTimeInformation(builder);
            writeCasioCurrentTime(builder);
            builder.queue(getQueue());
        } catch(IOException e) {
            LOG.warn("onSetTime failed: " + e.getMessage());
        }
    }

    @Override
    public void onSetCallState(CallSpec callSpec) {
        switch (callSpec.command) {
            case CallSpec.CALL_INCOMING:
                showNotification(CasioConstants.CALL_NOTIFICATION_ID, callSpec.name, callSpec.number);
                break;
            default:
                LOG.info("not sending CallSpec since only CALL_INCOMING is handled");
                break;
        }
    }

    @Override
    public void onSetMusicState(MusicStateSpec stateSpec) {
        if(stateSpec != mBufferMusicStateSpec)
        {
            mBufferMusicStateSpec = stateSpec;
            sendMusicInfo();
        }
    }

    private void sendMusicInfo()
    {
        if(!isConnected())
            return;

        try {
            TransactionBuilder builder = performInitialized("sendMusicInfo");
            String info = "";
            if (mBufferMusicSpec.track != null && mBufferMusicSpec.track.length() > 0) {
                info += mBufferMusicSpec.track;
            }
            if (mBufferMusicSpec.album != null && mBufferMusicSpec.album.length() > 0) {
                info += mBufferMusicSpec.album;
            }
            if (mBufferMusicSpec.artist != null && mBufferMusicSpec.artist.length() > 0) {
                info += mBufferMusicSpec.artist;
            }
            byte[] bInfo = info.getBytes(StandardCharsets.US_ASCII);
            int len = bInfo.length > 17 ? 17 : bInfo.length;
            byte[] arr = new byte[len + 3];
            arr[0] = 0;
            arr[1] = 10;
            arr[2] = 1;
            System.arraycopy(bInfo, 0, arr, 3, len);
            builder.write(getCharacteristic(CasioConstants.MORE_ALERT_FOR_LONG_UUID), arr);
            builder.queue(getQueue());
        } catch (IOException e) {
            LOG.warn("sendMusicInfo failed: " + e.getMessage());
        }
    }

    @Override
    public void onSetMusicInfo(MusicSpec musicSpec) {
        if(musicSpec != mBufferMusicSpec)
        {
            mBufferMusicSpec = musicSpec;
            sendMusicInfo();
        }
    }

    @Override
    public void onFindDevice(boolean start) {
        if (!isConnected()) {
            return;
        }

        if (mBtGatt == null) {
            return;
        }

        if (start) {
            try {
                TransactionBuilder builder = performInitialized("findDevice");
                byte[] value = new byte[]{GattCharacteristic.HIGH_ALERT};

                BluetoothGattService service = mBtGatt.getService(CasioConstants.IMMEDIATE_ALERT_SERVICE_UUID);
                BluetoothGattCharacteristic charact = service.getCharacteristic(CasioConstants.ALERT_LEVEL_CHARACTERISTIC_UUID);
                builder.write(charact, value);
                LOG.info("onFindDevice sent");
                builder.queue(getQueue());
            } catch (IOException e) {
                LOG.warn("showNotification failed: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean onCharacteristicReadRequest(BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic) {

        if (!characteristic.getUuid().equals(CasioConstants.NAME_OF_APP_CHARACTERISTIC_UUID)) {
            LOG.warn("unexpected read request");
            return false;
        }

        LOG.info("will send response to read request from device: " + device.getAddress());

        try {
            ServerTransactionBuilder builder = performServer("sendNameOfApp");
            builder.writeServerResponse(device, requestId, 0, offset, CasioConstants.MUSIC_MESSAGE.getBytes());
            builder.queue(getQueue());
        } catch (IOException e) {
            LOG.warn("sendMusicInfo failed: " + e.getMessage());
        }
        return true;
    }

    private GBDeviceEventMusicControl.Event parse5Button(int button) {
        GBDeviceEventMusicControl.Event event;
        switch(button) {
            case 5:
                event = GBDeviceEventMusicControl.Event.PLAYPAUSE;
                break;
            case 4:
                event = GBDeviceEventMusicControl.Event.NEXT;
                break;
            case 3:
                event = GBDeviceEventMusicControl.Event.VOLUMEUP;
                break;
            case 2:
                event = GBDeviceEventMusicControl.Event.PREVIOUS;
                break;
            case 1:
                event = GBDeviceEventMusicControl.Event.VOLUMEDOWN;
                break;
            default:
                LOG.warn("Unhandled button received: " + button);
                event =  GBDeviceEventMusicControl.Event.UNKNOWN;
        }
        return event;
    }

    private GBDeviceEventMusicControl.Event parse3Button(int button) {
        GBDeviceEventMusicControl.Event event;
        switch(button) {
            case 3:
                event = GBDeviceEventMusicControl.Event.NEXT;
                break;
            case 2:
                event = GBDeviceEventMusicControl.Event.PREVIOUS;
                break;
            case 1:
                event = GBDeviceEventMusicControl.Event.PLAYPAUSE;
                break;
            default:
                LOG.warn("Unhandled button received: " + button);
                event =  GBDeviceEventMusicControl.Event.UNKNOWN;
        }
        return event;
    }

    private GBDeviceEventMusicControl.Event parse2Button(int button) {
        GBDeviceEventMusicControl.Event event;
        switch(button) {
            case 2:
                event = GBDeviceEventMusicControl.Event.PLAYPAUSE;
                break;
            case 1:
                event = GBDeviceEventMusicControl.Event.NEXT;
                break;
            default:
                LOG.warn("Unhandled button received: " + button);
                event =  GBDeviceEventMusicControl.Event.UNKNOWN;
        }
        return event;
    }

    @Override
    public boolean onCharacteristicWriteRequest(BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic,
                                                boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {

        GBDeviceEventMusicControl musicCmd = new GBDeviceEventMusicControl();
        if (!characteristic.getUuid().equals(CasioConstants.KEY_CONTAINER_CHARACTERISTIC_UUID)) {
            LOG.warn("unexpected write request");
            return false;
        }

        if((value[0] & 0x03) == 0) {
            int button = value[1] & 0x0f;
            LOG.info("Button pressed: " + button);
            switch(getModel())
            {
                case MODEL_CASIO_5600B:
                    musicCmd.event = parse2Button(button);
                    break;
                case MODEL_CASIO_6900B:
                case MODEL_CASIO_GENERIC:
                    musicCmd.event = parse3Button(button);
                    break;
                case MODEL_CASIO_STB1000:
                    musicCmd.event = parse5Button(button);
                    break;
                default:
                    LOG.warn("Unhandled device");
                    return false;
            }
            evaluateGBDeviceEvent(musicCmd);
        }
        else {
            LOG.info("received from device: " + value.toString());
        }
        return true;
    }
}
