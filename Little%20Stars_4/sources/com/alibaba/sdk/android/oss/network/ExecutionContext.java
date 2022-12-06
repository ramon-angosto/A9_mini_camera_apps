package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.squareup.okhttp.OkHttpClient;

public class ExecutionContext<T extends OSSRequest> {
    private CancellationHandler cancellationHandler = new CancellationHandler();
    private OkHttpClient client;
    private OSSCompletedCallback completedCallback;
    private OSSProgressCallback progressCallback;
    private T request;

    public ExecutionContext(OkHttpClient okHttpClient, T t) {
        this.client = okHttpClient;
        this.request = t;
    }

    public T getRequest() {
        return this.request;
    }

    public void setRequest(T t) {
        this.request = t;
    }

    public OkHttpClient getClient() {
        return this.client;
    }

    public void setClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public CancellationHandler getCancellationHandler() {
        return this.cancellationHandler;
    }

    public void setCancellationHandler(CancellationHandler cancellationHandler2) {
        this.cancellationHandler = cancellationHandler2;
    }

    public OSSCompletedCallback getCompletedCallback() {
        return this.completedCallback;
    }

    public void setCompletedCallback(OSSCompletedCallback oSSCompletedCallback) {
        this.completedCallback = oSSCompletedCallback;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }
}
