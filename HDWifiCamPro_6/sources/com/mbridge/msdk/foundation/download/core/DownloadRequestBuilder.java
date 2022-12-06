package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DownloadRequestBuilder<T> implements RequestBuilder<T> {
    long connectTimeout;
    String directoryPathExternal;
    String directoryPathInternal;
    DownloadMessage<T> downloadMessage;
    DownloadPriority downloadPriority = DownloadPriority.MEDIUM;
    OnDownloadStateListener downloadStateListener;
    HashMap<String, List<String>> headerMap;
    OnProgressStateListener progressStateListener;
    long readTimeout;
    int retry;
    long timeout;
    String userAgent;
    long writeTimeout;

    public DownloadRequestBuilder(DownloadMessage<T> downloadMessage2) {
        this.downloadMessage = downloadMessage2;
    }

    public DownloadRequestBuilder<T> withHeader(String str, String str2) {
        if (this.headerMap == null) {
            this.headerMap = new HashMap<>(4);
        }
        List list = this.headerMap.get(str);
        if (list == null) {
            list = new ArrayList();
            this.headerMap.put(str, list);
        }
        if (!list.contains(str2)) {
            list.add(str2);
        }
        return this;
    }

    public DownloadRequestBuilder<T> withReadTimeout(long j) {
        this.readTimeout = j;
        return this;
    }

    public RequestBuilder<T> withWriteTimeout(long j) {
        this.writeTimeout = j;
        return this;
    }

    public DownloadRequestBuilder<T> withConnectTimeout(long j) {
        this.connectTimeout = j;
        return this;
    }

    public DownloadRequestBuilder<T> withHttpRetryCounter(int i) {
        this.retry = i;
        return this;
    }

    public DownloadRequestBuilder<T> withUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    public RequestBuilder<T> withDownloadStateListener(OnDownloadStateListener onDownloadStateListener) {
        this.downloadStateListener = onDownloadStateListener;
        return this;
    }

    public RequestBuilder<T> withProgressStateListener(OnProgressStateListener onProgressStateListener) {
        this.progressStateListener = onProgressStateListener;
        return this;
    }

    public RequestBuilder<T> withDownloadPriority(DownloadPriority downloadPriority2) {
        this.downloadPriority = downloadPriority2;
        return this;
    }

    public RequestBuilder<T> withDirectoryPathExternal(String str) {
        this.directoryPathExternal = str;
        return this;
    }

    public RequestBuilder<T> withDirectoryPathInternal(String str) {
        this.directoryPathInternal = str;
        return this;
    }

    public RequestBuilder<T> withTimeout(long j) {
        this.timeout = j;
        return this;
    }

    public DownloadRequest<T> build() {
        return DownloadRequest.create(this);
    }
}
