package com.vungle.warren.utility;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SDKExecutors implements Executors {
    private static final VungleThreadPoolExecutor API_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_api"));
    private static final VungleThreadPoolExecutor BACKGROUND_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_background"));
    private static final VungleThreadPoolExecutor DOWNLOADER_EXECUTOR = new VungleThreadPoolExecutor(4, 4, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(), new NamedThreadFactory("vng_down"));
    private static final VungleThreadPoolExecutor IO_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_io"));
    private static final int IO_KEEP_ALIVE_TIME_SECONDS = 5;
    private static final int JOBS_KEEP_ALIVE_TIME_SECONDS = 1;
    private static final VungleThreadPoolExecutor JOB_EXECUTOR;
    private static final VungleThreadPoolExecutor LOGGER_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_logger"));
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final VungleThreadPoolExecutor OFFLOAD_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_ol"));
    private static final VungleThreadPoolExecutor SESSION_DATA_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_session"));
    private static final int SINGLE_CORE_POOL_SIZE = 1;
    private static final VungleThreadPoolExecutor TASK_EXECUTOR = new VungleThreadPoolExecutor(1, 20, 10, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory("vng_task"));
    private static final VungleThreadPoolExecutor UA_EXECUTOR = new VungleThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_ua"));
    private static final ExecutorService UI_EXECUTOR = new AbstractExecutorService() {
        private final Handler UIHandler = new Handler(Looper.getMainLooper());

        public boolean awaitTermination(long j, TimeUnit timeUnit) {
            return false;
        }

        public boolean isShutdown() {
            return false;
        }

        public boolean isTerminated() {
            return false;
        }

        public void shutdown() {
        }

        public List<Runnable> shutdownNow() {
            return null;
        }

        public void execute(Runnable runnable) {
            this.UIHandler.post(runnable);
        }
    };
    private static final int VUNGLE_KEEP_ALIVE_TIME_SECONDS = 10;

    static {
        int i = NUMBER_OF_CORES;
        JOB_EXECUTOR = new VungleThreadPoolExecutor(i, i, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(), new NamedThreadFactory("vng_jr"));
    }

    public ExecutorService getUIExecutor() {
        return UI_EXECUTOR;
    }

    public VungleThreadPoolExecutor getBackgroundExecutor() {
        return BACKGROUND_EXECUTOR;
    }

    public VungleThreadPoolExecutor getIOExecutor() {
        return IO_EXECUTOR;
    }

    public VungleThreadPoolExecutor getJobExecutor() {
        return JOB_EXECUTOR;
    }

    public VungleThreadPoolExecutor getApiExecutor() {
        return API_EXECUTOR;
    }

    public VungleThreadPoolExecutor getLoggerExecutor() {
        return LOGGER_EXECUTOR;
    }

    public VungleThreadPoolExecutor getTaskExecutor() {
        return TASK_EXECUTOR;
    }

    public VungleThreadPoolExecutor getOffloadExecutor() {
        return OFFLOAD_EXECUTOR;
    }

    public VungleThreadPoolExecutor getUAExecutor() {
        return UA_EXECUTOR;
    }

    public VungleThreadPoolExecutor getDownloaderExecutor() {
        return DOWNLOADER_EXECUTOR;
    }

    public VungleThreadPoolExecutor getSessionDataExecutor() {
        return SESSION_DATA_EXECUTOR;
    }
}
