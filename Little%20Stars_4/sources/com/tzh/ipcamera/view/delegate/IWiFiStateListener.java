package com.tzh.ipcamera.view.delegate;

public interface IWiFiStateListener {
    void onConnectChange(String str);

    void onConnected(int i, String str);

    void onLocationClosed();

    void onStateChange(int i);
}
