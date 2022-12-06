package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadPriority;
import java.util.concurrent.FutureTask;

public class DownloadFutureTask extends FutureTask<Downloader> implements Comparable<DownloadFutureTask> {
    private final Downloader downloader;

    DownloadFutureTask(Downloader downloader2) {
        super(downloader2, (Object) null);
        this.downloader = downloader2;
    }

    public int compareTo(DownloadFutureTask downloadFutureTask) {
        DownloadPriority downloadPriority = this.downloader.downloadPriority;
        DownloadPriority downloadPriority2 = downloadFutureTask.downloader.downloadPriority;
        return downloadPriority == downloadPriority2 ? this.downloader.sequence - downloadFutureTask.downloader.sequence : downloadPriority2.ordinal() - downloadPriority.ordinal();
    }
}
