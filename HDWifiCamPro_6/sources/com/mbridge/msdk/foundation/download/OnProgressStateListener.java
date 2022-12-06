package com.mbridge.msdk.foundation.download;

public interface OnProgressStateListener<T> {
    void onProgress(DownloadMessage<T> downloadMessage, DownloadProgress downloadProgress);
}
