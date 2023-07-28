/*  Copyright (C) 2015-2020 Andreas Shimokawa, Carsten Pfeiffer

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
package nodomain.freeyourgadget.gadgetbridge.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nodomain.freeyourgadget.gadgetbridge.GBApplication;
import nodomain.freeyourgadget.gadgetbridge.R;
import nodomain.freeyourgadget.gadgetbridge.devices.DeviceCoordinator;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDeviceCandidate;
import nodomain.freeyourgadget.gadgetbridge.util.DeviceHelper;
import nodomain.freeyourgadget.gadgetbridge.util.GB;

/**
 * Adapter for displaying GBDeviceCandate instances.
 */
public class DeviceCandidateAdapter extends ArrayAdapter<GBDeviceCandidate> {

    private final Context context;

    public DeviceCandidateAdapter(Context context, List<GBDeviceCandidate> deviceCandidates) {
        super(context, 0, deviceCandidates);

        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        GBDeviceCandidate device = getItem(position);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_with_details, parent, false);
        }
        ImageView deviceImageView = view.findViewById(R.id.item_image);
        TextView deviceNameLabel = view.findViewById(R.id.item_name);
        TextView deviceAddressLabel = view.findViewById(R.id.item_details);
        TextView deviceStatus = view.findViewById(R.id.item_status);

        String name = formatDeviceCandidate(device);
        deviceNameLabel.setText(name);
        deviceAddressLabel.setText(device.getMacAddress());
        deviceImageView.setImageResource(device.getDeviceType().getIcon());

        final List<String> statusLines = new ArrayList<>();
        if (device.getDevice().getBondState() == BluetoothDevice.BOND_BONDED) {
            statusLines.add(getContext().getString(R.string.device_is_currently_bonded));
            if (!GBApplication.getPrefs().getBoolean("ignore_bonded_devices", true)) { // This could be passed to the constructor instead
                deviceImageView.setImageResource(device.getDeviceType().getDisabledIcon());
            }
        }

        if (!device.getDeviceType().isSupported()) {
            statusLines.add(getContext().getString(R.string.device_unsupported));
        }

        DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(device);
        if (coordinator.getBondingStyle() == DeviceCoordinator.BONDING_STYLE_REQUIRE_KEY) {
            statusLines.add(getContext().getString(R.string.device_requires_key));
        }

        deviceStatus.setText(TextUtils.join("\n", statusLines));
        return view;
    }

    private String formatDeviceCandidate(GBDeviceCandidate device) {
        if (device.getRssi() > GBDevice.RSSI_UNKNOWN) {
            return context.getString(R.string.device_with_rssi, device.getName(), GB.formatRssi(device.getRssi()));
        }
        return device.getName();
    }
}
