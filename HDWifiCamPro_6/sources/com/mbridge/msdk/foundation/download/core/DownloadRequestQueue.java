package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadRequestQueue<T> {
    private static final String TAG = "DownloadRequestQueue";
    private final Map<String, DownloadRequest<T>> currentRequestMap;
    private final Map<String, CopyOnWriteArrayList<DownloadRequest<T>>> delayRequestMap;
    private final AtomicInteger sequenceGenerator;

    public void initialize() {
    }

    private DownloadRequestQueue() {
        this.currentRequestMap = new ConcurrentHashMap();
        this.sequenceGenerator = new AtomicInteger();
        this.delayRequestMap = new ConcurrentHashMap();
    }

    public static DownloadRequestQueue getInstance() {
        return ClassHolder.DOWNLOAD_REQUEST_QUEUE;
    }

    private int getSequenceNumber() {
        return this.sequenceGenerator.incrementAndGet();
    }

    private void cancelAndRemoveFromMap(DownloadRequest downloadRequest, String str) {
        if (downloadRequest != null) {
            downloadRequest.cancel(downloadRequest.getDownloadMessage());
        }
    }

    public synchronized void cancel(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && this.delayRequestMap.containsKey(str) && (copyOnWriteArrayList = this.delayRequestMap.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                DownloadRequest downloadRequest = (DownloadRequest) it.next();
                copyOnWriteArrayList.remove(downloadRequest);
                downloadRequest.handlerCancelEvent(downloadRequest.getDownloadMessage());
            }
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                this.delayRequestMap.remove(str);
            } else {
                this.delayRequestMap.remove(str);
                this.delayRequestMap.put(str, copyOnWriteArrayList);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            cancelAndRemoveFromMap(this.currentRequestMap.get(str), str);
        }
    }

    public synchronized void cancelAll() {
        for (Map.Entry<String, CopyOnWriteArrayList<DownloadRequest<T>>> value : this.delayRequestMap.entrySet()) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) value.getValue();
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    DownloadRequest downloadRequest = (DownloadRequest) it.next();
                    if (downloadRequest != null) {
                        downloadRequest.handlerCancelEvent(downloadRequest.getDownloadMessage());
                    }
                }
            }
        }
        this.delayRequestMap.clear();
        for (Map.Entry<String, DownloadRequest<T>> value2 : this.currentRequestMap.entrySet()) {
            DownloadRequest downloadRequest2 = (DownloadRequest) value2.getValue();
            cancelAndRemoveFromMap(downloadRequest2, downloadRequest2.getDownloadId());
        }
    }

    public synchronized DownloadStatus getStatus(String str) {
        DownloadRequest downloadRequest = this.currentRequestMap.get(str);
        if (downloadRequest != null) {
            return downloadRequest.getStatus();
        }
        return DownloadStatus.UNKNOWN;
    }

    public synchronized void addRequest(DownloadRequest<T> downloadRequest) {
        String downloadId = downloadRequest.getDownloadId();
        downloadRequest.setSequence(getSequenceNumber());
        if (this.currentRequestMap.containsKey(downloadId)) {
            downloadRequest.setStatus(downloadRequest.getStatus() != DownloadStatus.RETRY ? DownloadStatus.DELAY : DownloadStatus.RETRY);
            if (this.delayRequestMap.containsKey(downloadId)) {
                CopyOnWriteArrayList copyOnWriteArrayList = this.delayRequestMap.get(downloadId);
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.add(downloadRequest);
                    this.delayRequestMap.remove(downloadId);
                    this.delayRequestMap.put(downloadId, copyOnWriteArrayList);
                }
            } else {
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                copyOnWriteArrayList2.add(downloadRequest);
                this.delayRequestMap.put(downloadId, copyOnWriteArrayList2);
            }
        } else {
            downloadRequest.setStatus(downloadRequest.getStatus() != DownloadStatus.RETRY ? DownloadStatus.QUEUED : DownloadStatus.RETRY);
            this.currentRequestMap.put(downloadId, downloadRequest);
            downloadRequest.setFuture(ExecutorManager.getInstance().getExecutorSupplier().getDownloadTasks().submit(new Downloader(downloadRequest)));
        }
    }

    public synchronized void finish(DownloadRequest downloadRequest) {
        CopyOnWriteArrayList remove;
        String downloadId = downloadRequest.getDownloadId();
        this.currentRequestMap.remove(downloadId);
        if (this.delayRequestMap.containsKey(downloadId) && (remove = this.delayRequestMap.remove(downloadId)) != null && remove.size() > 0) {
            DownloadRequest downloadRequest2 = (DownloadRequest) remove.remove(0);
            downloadRequest2.setStatus(DownloadStatus.QUEUED);
            this.currentRequestMap.put(downloadId, downloadRequest2);
            downloadRequest2.setFuture(ExecutorManager.getInstance().getExecutorSupplier().getDownloadTasks().submit(new Downloader(downloadRequest2)));
            if (remove != null && remove.size() > 0) {
                this.delayRequestMap.put(downloadId, remove);
            }
        }
    }

    private static final class ClassHolder {
        /* access modifiers changed from: private */
        public static final DownloadRequestQueue DOWNLOAD_REQUEST_QUEUE = new DownloadRequestQueue();

        private ClassHolder() {
        }
    }
}
