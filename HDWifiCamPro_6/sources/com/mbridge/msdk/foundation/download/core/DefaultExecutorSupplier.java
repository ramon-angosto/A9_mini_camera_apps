package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.b.a;
import com.mbridge.msdk.b.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class DefaultExecutorSupplier implements ExecutorSupplier {
    private int DEFAULT_MAX_NUM_THREADS = 10;
    private final ExecutorService backgroundExecutor;
    private final ExecutorService downloadResultExecutor;
    private final DownloadExecutor networkExecutor;

    DefaultExecutorSupplier() {
        a f = b.a().f(com.mbridge.msdk.foundation.controller.a.e().h());
        if (f != null) {
            this.DEFAULT_MAX_NUM_THREADS = f.a();
            if (this.DEFAULT_MAX_NUM_THREADS <= 0) {
                this.DEFAULT_MAX_NUM_THREADS = 10;
            }
        }
        this.networkExecutor = new DownloadExecutor(this.DEFAULT_MAX_NUM_THREADS, new PriorityThreadFactory(10), new ThreadPoolExecutor.DiscardPolicy());
        this.backgroundExecutor = Executors.newSingleThreadExecutor();
        this.downloadResultExecutor = Executors.newSingleThreadExecutor();
    }

    public DownloadExecutor getDownloadTasks() {
        return this.networkExecutor;
    }

    public ExecutorService getDownloadResultTasks() {
        return this.downloadResultExecutor;
    }

    public ExecutorService getBackgroundTasks() {
        return this.backgroundExecutor;
    }

    public ExecutorService getLruCacheThreadTasks() {
        return this.backgroundExecutor;
    }
}
