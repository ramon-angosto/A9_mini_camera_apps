package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;

public class Downloader implements Runnable {
    private static final String TAG = "DownloadTask";
    private IDatabaseHelper databaseHelper;
    private volatile DownloadMessage downloadMessage;
    public final DownloadPriority downloadPriority;
    public volatile DownloadRequest downloadRequest;
    public final int sequence;

    Downloader(DownloadRequest downloadRequest2) {
        this.downloadRequest = downloadRequest2;
        this.downloadPriority = downloadRequest2.getDownloadPriority();
        this.sequence = downloadRequest2.getSequence();
    }

    public void run() {
        if (this.downloadRequest.getStatus() != DownloadStatus.RETRY) {
            this.downloadRequest.handlerStartEvent(this.downloadRequest.getDownloadMessage());
        }
        this.downloadRequest.setStatus(DownloadStatus.RUNNING);
        this.downloadMessage = this.downloadRequest.getDownloadMessage();
        this.databaseHelper = GlobalComponent.getInstance().getDatabaseHelper();
        SynchronizeAvailableDirectorPath.create(this.downloadRequest).run();
        String cacheDirectoryPath = this.downloadRequest.getCacheDirectoryPath();
        this.downloadRequest.getCacheDirectorPathType();
        DownloadMessage downloadMessage2 = this.downloadMessage;
        downloadMessage2.setSaveFilePath(cacheDirectoryPath + this.downloadMessage.getSaveFileName());
        DownloadResponse run = DownloadTask.create(this.downloadRequest, this.downloadMessage, this.databaseHelper).run();
        if (run.isSuccessful()) {
            this.downloadRequest.handlerSuccessEvent(this.downloadMessage);
        } else if (run.getError() != null) {
            this.downloadRequest.handlerErrorEvent(this.downloadMessage, run.getError());
        } else if (run.isCancelled()) {
            this.downloadRequest.handlerCancelEvent(this.downloadMessage);
        }
    }
}
