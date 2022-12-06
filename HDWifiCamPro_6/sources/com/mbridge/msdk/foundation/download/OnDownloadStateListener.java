package com.mbridge.msdk.foundation.download;

public interface OnDownloadStateListener<T> {
    void onDownloadComplete(DownloadMessage<T> downloadMessage);

    void onDownloadError(DownloadMessage<T> downloadMessage, DownloadError downloadError);

    void onDownloadStart(DownloadMessage<T> downloadMessage);
}
