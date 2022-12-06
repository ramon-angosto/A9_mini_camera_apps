package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadResponse;

public interface IDownloadTask {
    public static final String TAG = "DownloadTask";

    DownloadResponse run();
}
