package com.mbridge.msdk.foundation.download;

public enum DownloadStatus {
    QUEUED,
    RUNNING,
    PAUSED,
    COMPLETED,
    CANCELLED,
    FAILED,
    DELAY,
    RETRY,
    UNKNOWN
}
