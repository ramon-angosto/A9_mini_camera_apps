package com.mbridge.msdk.foundation.download.core;

import java.util.concurrent.ExecutorService;

public interface ExecutorSupplier {
    ExecutorService getBackgroundTasks();

    ExecutorService getDownloadResultTasks();

    DownloadExecutor getDownloadTasks();

    ExecutorService getLruCacheThreadTasks();
}
