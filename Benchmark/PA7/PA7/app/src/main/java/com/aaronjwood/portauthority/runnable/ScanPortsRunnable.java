package com.aaronjwood.portauthority.runnable;

import com.aaronjwood.portauthority.response.HostAsyncResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;

public class ScanPortsRunnable implements Runnable {
    private String ip;
    private int startPort;
    private int stopPort;
    private HostAsyncResponse delegate;

    /**
     * Constructor to set the necessary data to perform a port scan
     *
     * @param ip        IP address
     * @param startPort Port to start scanning at
     * @param stopPort  Port to stop scanning at
     * @param delegate  Called when this chunk of ports has finished scanning
     */
    public ScanPortsRunnable(String ip, int startPort, int stopPort, HostAsyncResponse delegate) {
        this.ip = ip;
        this.startPort = startPort;
        this.stopPort = stopPort;
        this.delegate = delegate;
    }

    /**
     * Starts the port scan
     */
    @Override
    public void run() {
        for (int i = this.startPort; i <= this.stopPort; i++) {
            this.delegate.processFinish(1);

            HashMap<Integer, String> portData = new HashMap<>();
            BufferedReader in;
            String data = null;
            Socket socket = new Socket();
            socket.setPerformancePreferences(1, 0, 0);

            try {
                socket.setTcpNoDelay(true);
                socket.connect(new InetSocketAddress(this.ip, i), 4000);

                if (i == 22) {
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    data = in.readLine();
                    in.close();
                } else if (i == 80 || i == 443 || i == 8080) {
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("GET / HTTP/1.1\r\nHost: " + this.ip + "\r\n");

                    char[] buffer = new char[1024];
                    in.read(buffer, 0, 1024);
                    out.close();
                    in.close();
                    data = new String(buffer).toLowerCase();
                    if (data.contains("apache") || data.contains("httpd")) {
                        data = "Apache";
                    } else if (data.contains("iis") || data.contains("microsoft")) {
                        data = "IIS";
                    } else if (data.contains("nginx")) {
                        data = "Nginx";
                    } else {
                        data = null;
                    }
                }

                portData.put(i, data);
                socket.close();

                this.delegate.processFinish(portData);
            } catch (IOException ignored) {
            }
        }
    }
}
