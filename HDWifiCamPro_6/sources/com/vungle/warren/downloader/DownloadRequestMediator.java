package com.vungle.warren.downloader;

import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

class DownloadRequestMediator {
    private Map<String, Pair<DownloadRequest, AssetDownloadListener>> children = new ConcurrentHashMap(1);
    private AtomicBoolean connectedAtomic = new AtomicBoolean(true);
    public final String filePath;
    public final boolean isCacheable;
    public final String key;
    private final ReentrantLock lock = new ReentrantLock();
    public final String metaPath;
    public final AssetPriority priority;
    private AtomicReference<Runnable> runnable = new AtomicReference<>();
    private AtomicInteger statusAtomic = new AtomicInteger(0);
    public final String url;

    DownloadRequestMediator(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener, String str, String str2, boolean z, String str3) {
        this.url = downloadRequest.url;
        this.filePath = str;
        this.metaPath = str2;
        this.isCacheable = z;
        this.key = str3;
        this.priority = downloadRequest.getPriority();
        this.children.put(downloadRequest.id, new Pair(downloadRequest, assetDownloadListener));
    }

    /* access modifiers changed from: package-private */
    public synchronized void add(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        this.children.put(downloadRequest.id, new Pair(downloadRequest, assetDownloadListener));
    }

    /* access modifiers changed from: package-private */
    public synchronized Pair<DownloadRequest, AssetDownloadListener> remove(DownloadRequest downloadRequest) {
        return this.children.remove(downloadRequest.id);
    }

    /* access modifiers changed from: package-private */
    public synchronized List<Pair<DownloadRequest, AssetDownloadListener>> values() {
        return new ArrayList(this.children.values());
    }

    /* access modifiers changed from: package-private */
    public synchronized List<DownloadRequest> requests() {
        ArrayList arrayList;
        List<Pair<DownloadRequest, AssetDownloadListener>> values = values();
        arrayList = new ArrayList();
        for (Pair<DownloadRequest, AssetDownloadListener> pair : values) {
            arrayList.add(pair.first);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void lock() {
        this.lock.lock();
    }

    /* access modifiers changed from: package-private */
    public void unlock() {
        this.lock.unlock();
    }

    /* access modifiers changed from: package-private */
    public AssetPriority getPriority() {
        AssetPriority priority2;
        AssetPriority assetPriority = new AssetPriority(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Pair next : values()) {
            if (!(next.first == null || (priority2 = ((DownloadRequest) next.first).getPriority()) == null || assetPriority.compareTo(priority2) < 0)) {
                assetPriority = priority2;
            }
        }
        return assetPriority;
    }

    /* access modifiers changed from: package-private */
    public boolean isPausable() {
        for (Pair next : values()) {
            if (next.first != null && ((DownloadRequest) next.first).pauseOnConnectionLost) {
                return true;
            }
        }
        return false;
    }

    public int getStatus() {
        return this.statusAtomic.get();
    }

    /* access modifiers changed from: package-private */
    public boolean is(int i) {
        return this.statusAtomic.get() == i;
    }

    /* access modifiers changed from: package-private */
    public void set(int i) {
        if (this.statusAtomic.get() != 3) {
            this.statusAtomic.set(i);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.connectedAtomic.get();
    }

    /* access modifiers changed from: package-private */
    public void setConnected(boolean z) {
        this.connectedAtomic.set(z);
    }

    public void setRunnable(Runnable runnable2) {
        this.runnable.set(runnable2);
    }

    public Runnable getRunnable() {
        return this.runnable.get();
    }
}
