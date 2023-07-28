package com.aaronjwood.portauthority.runnable;

import com.aaronjwood.portauthority.response.MainAsyncResponse;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ScanHostsRunnable implements Runnable {
    private String[] ipParts;
    private int start;
    private int stop;
    private MainAsyncResponse delegate;

    /**
     * Constructor to set the necessary data to scan for hosts
     *
     * @param ipParts  IP address split up by the segments
     * @param start    Host to start scanning at
     * @param stop     Host to stop scanning at
     * @param delegate Called when host discovery has finished
     */
    public ScanHostsRunnable(String[] ipParts, int start, int stop, MainAsyncResponse delegate) {
        this.ipParts = ipParts;
        this.start = start;
        this.stop = stop;
        this.delegate = delegate;
    }

    /**
     * Starts the host discovery
     */
    @Override
    public void run() {
        for (int i = this.start; i <= this.stop; i++) {
            String ip = this.ipParts[0] + "." + this.ipParts[1] + "." + this.ipParts[2] + "." + i;
            Socket socket = new Socket();
            socket.setPerformancePreferences(1, 0, 0);

            try {
                socket.setTcpNoDelay(true);
                socket.connect(new InetSocketAddress(ip, 7), 250);
                socket.close();
            } catch (IOException ignored) {
            } finally {
                this.delegate.processFinish(1);
            }
        }
    }
}