package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import java.io.File;

class FindFileFromCache implements IDownloadTask {
    private final IDatabaseHelper databaseHelper;
    private final String downloadId;
    private DownloadMessage downloadMessage;
    private final DownloadModel downloadModel;
    private final DownloadRequest request;

    private FindFileFromCache(DownloadRequest downloadRequest, DownloadModel downloadModel2, IDatabaseHelper iDatabaseHelper, String str, DownloadMessage downloadMessage2) {
        this.request = downloadRequest;
        this.downloadModel = downloadModel2;
        this.databaseHelper = iDatabaseHelper;
        this.downloadId = str;
        this.downloadMessage = downloadMessage2;
    }

    public DownloadResponse run() {
        if (Objects.isNull(this.downloadModel)) {
            return null;
        }
        DownloadResponse downloadResponse = new DownloadResponse();
        File file = new File(this.request.getCacheDirectoryPath() + this.downloadMessage.getSaveFileName());
        if (!file.exists()) {
            this.request.setDownloadedBytes(0);
            this.databaseHelper.remove(this.downloadId);
            MBResourceManager.getInstance().deleteFile(file);
            downloadResponse.setSuccessful(false);
        } else if (MBResourceManager.getInstance().getFileSize(file) != this.downloadModel.getDownloadedBytes()) {
            this.request.setDownloadedBytes(0);
            this.databaseHelper.remove(this.downloadId);
            MBResourceManager.getInstance().deleteFile(file);
            downloadResponse.setSuccessful(false);
        } else if (Utils.getDownloadRate(this.downloadModel.getTotalBytes(), this.downloadModel.getDownloadedBytes()) >= this.downloadMessage.getDownloadRate()) {
            this.request.setTotalBytes(this.downloadModel.getTotalBytes());
            this.request.setDownloadedBytes(this.downloadModel.getDownloadedBytes());
            downloadResponse.setSuccessful(true);
        } else {
            this.request.setTotalBytes(this.downloadModel.getTotalBytes());
            this.request.setDownloadedBytes(this.downloadModel.getDownloadedBytes());
            downloadResponse.setSuccessful(false);
        }
        return downloadResponse;
    }

    static IDownloadTask create(DownloadRequest downloadRequest, DownloadModel downloadModel2, IDatabaseHelper iDatabaseHelper, String str, DownloadMessage downloadMessage2) {
        return new FindFileFromCache(downloadRequest, downloadModel2, iDatabaseHelper, str, downloadMessage2);
    }
}
