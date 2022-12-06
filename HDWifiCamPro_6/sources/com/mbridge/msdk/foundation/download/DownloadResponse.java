package com.mbridge.msdk.foundation.download;

public class DownloadResponse {
    private DownloadError error;
    private boolean isCancelled;
    private boolean isSuccessful;

    public DownloadError getError() {
        return this.error;
    }

    public void setError(DownloadError downloadError) {
        this.error = downloadError;
    }

    public boolean isSuccessful() {
        return this.isSuccessful;
    }

    public void setSuccessful(boolean z) {
        this.isSuccessful = z;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean z) {
        this.isCancelled = z;
    }
}
