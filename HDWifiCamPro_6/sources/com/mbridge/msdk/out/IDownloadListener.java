package com.mbridge.msdk.out;

public interface IDownloadListener {
    void onEnd(int i, int i2, String str);

    void onProgressUpdate(int i);

    void onStart();

    void onStatus(int i);
}
