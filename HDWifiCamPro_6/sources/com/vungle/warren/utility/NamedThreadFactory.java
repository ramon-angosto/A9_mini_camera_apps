package com.vungle.warren.utility;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private final String name;
    private ThreadFactory threadFactory = Executors.defaultThreadFactory();

    public NamedThreadFactory(String str) {
        this.name = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.threadFactory.newThread(runnable);
        newThread.setName(this.name + "-th-" + this.atomicInteger.incrementAndGet());
        return newThread;
    }
}
