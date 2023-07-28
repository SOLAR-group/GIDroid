package com.aaronjwood.portauthority.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.aaronjwood.portauthority.R;
import com.aaronjwood.portauthority.listener.ScanPortsListener;
import com.aaronjwood.portauthority.network.Host;
import com.aaronjwood.portauthority.utils.Constants;
import com.aaronjwood.portauthority.utils.UserPreference;

public final class WanHostActivity extends HostActivity {
    private EditText wanHost;

    /**
     * Activity created
     *
     * @param savedInstanceState Data from a saved state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.layout = R.layout.activity_wanhost;
        super.onCreate(savedInstanceState);

        this.wanHost = findViewById(R.id.hostAddress);
        this.portList = findViewById(R.id.portList);

        this.wanHost.setText(UserPreference.getLastUsedHostAddress(this));
        this.setupPortScan();
    }

    /**
     * Clean up
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        UserPreference.saveLastUsedHostAddress(this, this.wanHost.getText().toString());
    }

    /**
     * Event handler for when the well known port scan is initiated
     */
    private void scanWellKnownPortsClick() {
        Button scanWellKnownPortsButton = findViewById(R.id.scanWellKnownPorts);
        scanWellKnownPortsButton.setOnClickListener(new ScanPortsListener(ports, adapter) {

            /**
             * Click handler for scanning well known ports
             * @param v
             */
            @Override
            public void onClick(View v) {
                super.onClick(v);

                int startPort = 1;
                int stopPort = 1024;
                scanProgressDialog = new ProgressDialog(WanHostActivity.this, R.style.DialogTheme);
                scanProgressDialog.setCancelable(false);
                scanProgressDialog.setTitle("Scanning Port " + startPort + " to " + stopPort);
                scanProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                scanProgressDialog.setProgress(0);
                scanProgressDialog.setMax(1024);
                scanProgressDialog.show();

                Host.scanPorts(wanHost.getText().toString(), startPort, stopPort, UserPreference.getWanSocketTimeout(getApplicationContext()), WanHostActivity.this);
                portListClick(wanHost.getText().toString());
            }
        });
    }

    /**
     * Event handler for when a port range scan is requested
     */
    private void scanPortRangeClick() {
        Button scanPortRangeButton = findViewById(R.id.scanPortRange);
        scanPortRangeButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Click handler for scanning a port range
             * @param v
             */
            @Override
            public void onClick(View v) {

                portRangeDialog = new Dialog(WanHostActivity.this, R.style.DialogTheme);
                portRangeDialog.setTitle("Select Port Range");
                portRangeDialog.setContentView(R.layout.port_range);
                portRangeDialog.show();

                NumberPicker portRangePickerStart = portRangeDialog.findViewById(R.id.portRangePickerStart);
                NumberPicker portRangePickerStop = portRangeDialog.findViewById(R.id.portRangePickerStop);

                portRangePickerStart.setMinValue(Constants.MIN_PORT_VALUE);
                portRangePickerStart.setMaxValue(Constants.MAX_PORT_VALUE);
                portRangePickerStart.setValue(UserPreference.getPortRangeStart(WanHostActivity.this));
                portRangePickerStart.setWrapSelectorWheel(false);
                portRangePickerStop.setMinValue(Constants.MIN_PORT_VALUE);
                portRangePickerStop.setMaxValue(Constants.MAX_PORT_VALUE);
                portRangePickerStop.setValue(UserPreference.getPortRangeHigh(WanHostActivity.this));
                portRangePickerStop.setWrapSelectorWheel(false);

                startPortRangeScanClick(portRangePickerStart, portRangePickerStop, UserPreference.getWanSocketTimeout(getApplicationContext()), WanHostActivity.this, wanHost.getText().toString());
                resetPortRangeScanClick(portRangePickerStart, portRangePickerStop);
                portListClick(wanHost.getText().toString());
            }
        });
    }


    /**
     * Sets up event handlers and functionality for various port scanning features
     */
    private void setupPortScan() {
        this.scanWellKnownPortsClick();
        this.scanPortRangeClick();
    }

    /**
     * Delegate to determine if the progress dialog should be dismissed or not
     *
     * @param output True if the dialog should be dismissed
     */
    @Override
    public void processFinish(boolean output) {
        if (this.scanProgressDialog != null && this.scanProgressDialog.isShowing()) {
            this.scanProgressDialog.dismiss();
        }

        if (this.portRangeDialog != null && this.portRangeDialog.isShowing()) {
            this.portRangeDialog.dismiss();
        }

        if (!output) {
            handler.post(new Runnable() {

                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Please enter a valid URL or IP address", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
