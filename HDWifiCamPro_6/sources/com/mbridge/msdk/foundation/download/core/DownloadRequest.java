package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.tools.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

public class DownloadRequest<T> {
    private static final String TAG = "DownloadRequest";
    private DownloadRequestBuilder<T> builder;
    private int cacheDirectorPathType;
    private String cacheDirectoryPath;
    private long connectTimeout;
    private String directoryPathExternal;
    private String directoryPathInternal;
    private String downloadId;
    private DownloadMessage<T> downloadMessage;
    private DownloadPriority downloadPriority;
    private long downloadedBytes;
    private Future future;
    private HashMap<String, List<String>> headerMap;
    /* access modifiers changed from: private */
    public volatile OnDownloadStateListener onDownloadListener;
    /* access modifiers changed from: private */
    public volatile OnProgressStateListener onProgressListener;
    private long readTimeout;
    /* access modifiers changed from: private */
    public int retry;
    /* access modifiers changed from: private */
    public volatile int retryedCount = 0;
    private int sequence;
    private DownloadStatus status;
    private long timeout;
    private long totalBytes = 0;
    private String userAgent;
    private long writeTimeout;

    DownloadRequest(DownloadRequestBuilder<T> downloadRequestBuilder) {
        this.headerMap = downloadRequestBuilder.headerMap;
        this.downloadPriority = downloadRequestBuilder.downloadPriority;
        this.readTimeout = downloadRequestBuilder.readTimeout;
        this.connectTimeout = downloadRequestBuilder.connectTimeout;
        this.userAgent = downloadRequestBuilder.userAgent;
        this.downloadMessage = downloadRequestBuilder.downloadMessage;
        this.writeTimeout = downloadRequestBuilder.writeTimeout;
        this.onDownloadListener = downloadRequestBuilder.downloadStateListener;
        this.onProgressListener = downloadRequestBuilder.progressStateListener;
        this.directoryPathExternal = downloadRequestBuilder.directoryPathExternal;
        this.directoryPathInternal = downloadRequestBuilder.directoryPathInternal;
        this.retry = downloadRequestBuilder.retry;
        this.timeout = downloadRequestBuilder.timeout;
        this.builder = downloadRequestBuilder;
    }

    public static DownloadRequest create(DownloadRequestBuilder downloadRequestBuilder) {
        return new DownloadRequest(downloadRequestBuilder);
    }

    public DownloadPriority getDownloadPriority() {
        return this.downloadPriority;
    }

    public HashMap<String, List<String>> getHeaders() {
        return this.headerMap;
    }

    public void setFuture(Future future2) {
        this.future = future2;
    }

    public long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public void setDownloadedBytes(long j) {
        this.downloadedBytes = j;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public long getReadTimeout() {
        return this.readTimeout;
    }

    public long getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getDownloadId() {
        return this.downloadId;
    }

    public DownloadStatus getStatus() {
        return this.status;
    }

    public void setStatus(DownloadStatus downloadStatus) {
        this.status = downloadStatus;
    }

    public String start() {
        this.downloadId = MBResourceManager.getInstance().getDownloadId(this.downloadMessage.getResourceUrl());
        DownloadRequestQueue.getInstance().addRequest(this);
        return this.downloadId;
    }

    public void handlerErrorEvent(final DownloadMessage<T> downloadMessage2, final DownloadError downloadError) {
        if (this.status != DownloadStatus.CANCELLED) {
            ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
                public void run() {
                    try {
                        if (DownloadRequest.this.retryedCount < DownloadRequest.this.retry) {
                            DownloadRequest.this.setStatus(DownloadStatus.RETRY);
                            int unused = DownloadRequest.this.retryedCount = DownloadRequest.this.retryedCount + 1;
                            DownloadRequestQueue.getInstance().finish(DownloadRequest.this);
                            DownloadRequestQueue.getInstance().addRequest(DownloadRequest.this);
                            return;
                        }
                        DownloadRequest.this.setStatus(DownloadStatus.FAILED);
                        if (DownloadRequest.this.onDownloadListener != null) {
                            DownloadRequest.this.onDownloadListener.onDownloadError(downloadMessage2, downloadError);
                        }
                        DownloadRequest.this.finish();
                    } catch (Exception e) {
                        q.d(DownloadRequest.TAG, e.getMessage());
                    }
                }
            });
        }
    }

    public void handlerSuccessEvent(final DownloadMessage<T> downloadMessage2) {
        if (this.status != DownloadStatus.CANCELLED) {
            setStatus(DownloadStatus.COMPLETED);
            ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
                public void run() {
                    try {
                        if (DownloadRequest.this.onDownloadListener != null) {
                            DownloadRequest.this.onDownloadListener.onDownloadComplete(downloadMessage2);
                        }
                        DownloadRequest.this.finish();
                    } catch (Exception e) {
                        q.d(DownloadRequest.TAG, e.getMessage());
                    }
                }
            });
        }
    }

    public void handlerStartEvent(final DownloadMessage<T> downloadMessage2) {
        if (this.status != DownloadStatus.CANCELLED) {
            ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
                public void run() {
                    try {
                        if (DownloadRequest.this.onDownloadListener != null) {
                            DownloadRequest.this.onDownloadListener.onDownloadStart(downloadMessage2);
                        }
                    } catch (Exception e) {
                        q.d(DownloadRequest.TAG, e.getMessage());
                    }
                }
            });
        }
    }

    public void handlerCancelEvent(final DownloadMessage<T> downloadMessage2) {
        ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
            public void run() {
                try {
                    if (DownloadRequest.this.onDownloadListener != null) {
                        DownloadRequest.this.onDownloadListener.onDownloadError(downloadMessage2, new DownloadError(new IOException("Download task is cancelled")));
                    }
                    DownloadRequest.this.finish();
                } catch (Exception e) {
                    q.d(DownloadRequest.TAG, e.getMessage());
                }
            }
        });
    }

    public void handlerProcessEvent(final DownloadMessage<T> downloadMessage2, final DownloadProgress downloadProgress) {
        if (this.status != DownloadStatus.CANCELLED) {
            ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
                public void run() {
                    try {
                        if (DownloadRequest.this.onProgressListener != null) {
                            DownloadRequest.this.onProgressListener.onProgress(downloadMessage2, downloadProgress);
                        }
                    } catch (Exception e) {
                        q.d(DownloadRequest.TAG, e.getMessage());
                    }
                }
            });
        }
    }

    public void cancel(DownloadMessage<T> downloadMessage2) {
        this.status = DownloadStatus.CANCELLED;
        Future future2 = this.future;
        if (future2 != null) {
            future2.cancel(false);
        }
    }

    /* access modifiers changed from: private */
    public void finish() {
        destroy();
        DownloadRequestQueue.getInstance().finish(this);
    }

    private void destroy() {
        this.onProgressListener = null;
        this.onDownloadListener = null;
    }

    public DownloadMessage<T> getDownloadMessage() {
        return this.downloadMessage;
    }

    public String getCacheDirectoryPath() {
        return this.cacheDirectoryPath;
    }

    public int getCacheDirectorPathType() {
        return this.cacheDirectorPathType;
    }

    public long getWriteTimeout() {
        return this.writeTimeout;
    }

    public String getDirectoryPathExternal() {
        return this.directoryPathExternal;
    }

    public String getDirectoryPathInternal() {
        return this.directoryPathInternal;
    }

    public void setCacheDirectoryPath(String str) {
        this.cacheDirectoryPath = str;
    }

    public void setCacheDirectorPathType(int i) {
        this.cacheDirectorPathType = i;
    }

    public int getSequence() {
        return this.sequence;
    }

    public void setSequence(int i) {
        this.sequence = i;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public int getRetry() {
        return this.retry;
    }
}
