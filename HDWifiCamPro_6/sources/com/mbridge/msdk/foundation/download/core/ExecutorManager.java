package com.mbridge.msdk.foundation.download.core;

public class ExecutorManager {
    private static ExecutorManager instance;
    private final ExecutorSupplier executorSupplier;

    private ExecutorManager() {
        this.executorSupplier = new DefaultExecutorSupplier();
    }

    public static ExecutorManager getInstance() {
        return ClassHolder.EXECUTOR_MANAGER;
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.executorSupplier;
    }

    private static final class ClassHolder {
        /* access modifiers changed from: private */
        public static final ExecutorManager EXECUTOR_MANAGER = new ExecutorManager();

        private ClassHolder() {
        }
    }

    public static void shutDown() {
        if (instance != null) {
            instance = null;
        }
    }
}
