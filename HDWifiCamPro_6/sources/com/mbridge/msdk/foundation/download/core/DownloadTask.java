package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DownloadTask implements IDownloadTask {
    private IDatabaseHelper databaseHelper;
    private volatile DownloadMessage downloadMessage;
    /* access modifiers changed from: private */
    public volatile DownloadModel downloadModel = null;
    /* access modifiers changed from: private */
    public volatile boolean needUpdateDownloadModel = true;
    private volatile DownloadRequest request;

    private DownloadTask(DownloadRequest downloadRequest, DownloadMessage downloadMessage2, IDatabaseHelper iDatabaseHelper) {
        this.request = downloadRequest;
        this.downloadMessage = downloadMessage2;
        this.databaseHelper = iDatabaseHelper;
    }

    static IDownloadTask create(DownloadRequest downloadRequest, DownloadMessage downloadMessage2, IDatabaseHelper iDatabaseHelper) {
        return new DownloadTask(downloadRequest, downloadMessage2, iDatabaseHelper);
    }

    public DownloadResponse run() {
        String downloadId = this.request.getDownloadId();
        if (this.request.getStatus() == DownloadStatus.CANCELLED) {
            DownloadResponse downloadResponse = new DownloadResponse();
            downloadResponse.setCancelled(true);
            return downloadResponse;
        } else if (this.downloadMessage.getDownloadRate() == 0) {
            DownloadResponse downloadResponse2 = new DownloadResponse();
            downloadResponse2.setSuccessful(true);
            return downloadResponse2;
        } else {
            String cacheDirectoryPath = this.request.getCacheDirectoryPath();
            int cacheDirectorPathType = this.request.getCacheDirectorPathType();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.databaseHelper.find(downloadId, cacheDirectoryPath, new IDatabaseHelper.IDatabaseListener() {
                public void onDatabase(DownloadModel downloadModel) {
                    if (DownloadTask.this.needUpdateDownloadModel) {
                        DownloadModel unused = DownloadTask.this.downloadModel = downloadModel;
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                ILogger logger = GlobalComponent.getInstance().getLogger();
                logger.log(IDownloadTask.TAG, "" + e.getMessage());
                countDownLatch.countDown();
            }
            this.needUpdateDownloadModel = false;
            DownloadResponse run = FindFileFromCache.create(this.request, this.downloadModel, this.databaseHelper, downloadId, this.downloadMessage).run();
            if (cacheDirectorPathType != 0) {
                if (cacheDirectorPathType != 1) {
                    return run == null ? OkHTTPFileDownloadTask.create(this.request, this.downloadModel, this.databaseHelper, this.downloadMessage).run() : run;
                }
                if (!Objects.isNotNull(run) || !run.isSuccessful()) {
                    String directoryPathInternal = this.request.getDirectoryPathInternal();
                    final CountDownLatch countDownLatch2 = new CountDownLatch(1);
                    this.databaseHelper.find(downloadId, directoryPathInternal, new IDatabaseHelper.IDatabaseListener() {
                        public void onDatabase(DownloadModel downloadModel) {
                            DownloadModel unused = DownloadTask.this.downloadModel = downloadModel;
                            countDownLatch2.countDown();
                        }
                    });
                    try {
                        countDownLatch2.await(60, TimeUnit.SECONDS);
                    } catch (InterruptedException unused) {
                        countDownLatch2.countDown();
                    }
                    DownloadResponse run2 = FindFileFromCache.create(this.request, this.downloadModel, this.databaseHelper, downloadId, this.downloadMessage).run();
                    if (!Objects.isNotNull(run2) || !run2.isSuccessful()) {
                        return OkHTTPFileDownloadTask.create(this.request, this.downloadModel, this.databaseHelper, this.downloadMessage).run();
                    }
                    long totalBytes = this.request.getTotalBytes();
                    long downloadedBytes = this.request.getDownloadedBytes();
                    sendProgress(this.request, this.downloadMessage, new DownloadProgress(downloadedBytes, totalBytes, Utils.getDownloadRate(totalBytes, downloadedBytes)));
                    this.downloadModel = DownloadModel.create(this.downloadModel.getDownloadId(), this.downloadModel.getDownloadUrl(), this.downloadModel.getResourceUrl(), this.downloadModel.getEtag(), this.downloadModel.getSaveDirectorPath(), this.downloadModel.getSaveFileName(), this.request.getTotalBytes(), this.downloadModel.getDownloadedBytes(), this.downloadModel.getDownloadRate(), this.downloadModel.getUsageCounter() + 1, this.downloadModel.getDownloadResourceType());
                    this.databaseHelper.update(this.downloadModel, cacheDirectoryPath);
                    if (this.request.getStatus() == DownloadStatus.CANCELLED) {
                        run2.setCancelled(true);
                    }
                    return run2;
                }
                long totalBytes2 = this.request.getTotalBytes();
                long downloadedBytes2 = this.request.getDownloadedBytes();
                sendProgress(this.request, this.downloadMessage, new DownloadProgress(downloadedBytes2, totalBytes2, Utils.getDownloadRate(totalBytes2, downloadedBytes2)));
                this.downloadModel = DownloadModel.create(this.downloadModel.getDownloadId(), this.downloadModel.getDownloadUrl(), this.downloadModel.getResourceUrl(), this.downloadModel.getEtag(), this.downloadModel.getSaveDirectorPath(), this.downloadModel.getSaveFileName(), this.request.getTotalBytes(), this.downloadModel.getDownloadedBytes(), this.downloadModel.getDownloadRate(), this.downloadModel.getUsageCounter() + 1, this.downloadModel.getDownloadResourceType());
                this.databaseHelper.update(this.downloadModel, cacheDirectoryPath);
                if (this.request.getStatus() == DownloadStatus.CANCELLED) {
                    run.setCancelled(true);
                }
                return run;
            } else if (!Objects.isNotNull(run) || !run.isSuccessful()) {
                return OkHTTPFileDownloadTask.create(this.request, this.downloadModel, this.databaseHelper, this.downloadMessage).run();
            } else {
                long downloadedBytes3 = this.request.getDownloadedBytes();
                long totalBytes3 = this.request.getTotalBytes();
                sendProgress(this.request, this.downloadMessage, new DownloadProgress(downloadedBytes3, totalBytes3, Utils.getDownloadRate(totalBytes3, downloadedBytes3)));
                this.downloadModel = DownloadModel.create(this.downloadModel.getDownloadId(), this.downloadModel.getDownloadUrl(), this.downloadModel.getResourceUrl(), this.downloadModel.getEtag(), this.downloadModel.getSaveDirectorPath(), this.downloadModel.getSaveFileName(), this.request.getTotalBytes(), this.downloadModel.getDownloadedBytes(), this.downloadModel.getDownloadRate(), this.downloadModel.getUsageCounter() + 1, this.downloadModel.getDownloadResourceType());
                this.databaseHelper.update(this.downloadModel, cacheDirectoryPath);
                if (this.request.getStatus() == DownloadStatus.CANCELLED) {
                    run.setCancelled(true);
                }
                return run;
            }
        }
    }

    private void sendProgress(DownloadRequest downloadRequest, DownloadMessage downloadMessage2, DownloadProgress downloadProgress) {
        if (downloadRequest.getStatus() != DownloadStatus.CANCELLED) {
            downloadRequest.handlerProcessEvent(downloadMessage2, downloadProgress);
        }
    }
}
