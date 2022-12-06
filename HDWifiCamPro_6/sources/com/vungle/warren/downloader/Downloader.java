package com.vungle.warren.downloader;

import java.util.List;

public interface Downloader {

    public @interface NetworkType {
        public static final int ANY = 3;
        public static final int CELLULAR = 1;
        public static final int WIFI = 2;
    }

    void cancel(DownloadRequest downloadRequest);

    void cancelAll();

    boolean cancelAndAwait(DownloadRequest downloadRequest, long j);

    void clearCache();

    void download(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener);

    boolean dropCache(String str);

    List<DownloadRequest> getAllRequests();

    void init();

    boolean isCacheEnabled();

    void setCacheEnabled(boolean z);

    void setProgressStep(int i);

    void updatePriority(DownloadRequest downloadRequest);

    public static class RequestException extends Exception {
        RequestException(String str) {
            super(str);
        }
    }
}
