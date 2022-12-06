package com.vungle.warren.tasks;

import android.text.TextUtils;
import com.vungle.warren.AdLoader;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.VungleStaticApi;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.log.LogManager;
import com.vungle.warren.persistence.Designer;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.ReconfigJob;

public class VungleJobCreator implements JobCreator {
    private final AdAnalytics adAnalytics;
    private final AdLoader adLoader;
    private final VungleApiClient apiClient;
    private final Designer designer;
    private final LogManager logManager;
    private final ReconfigJob.ReconfigCall reconfigCall;
    private final Repository repository;
    private final VungleStaticApi vungleApi;

    public VungleJobCreator(Repository repository2, Designer designer2, VungleApiClient vungleApiClient, AdAnalytics adAnalytics2, ReconfigJob.ReconfigCall reconfigCall2, AdLoader adLoader2, VungleStaticApi vungleStaticApi, LogManager logManager2) {
        this.repository = repository2;
        this.designer = designer2;
        this.reconfigCall = reconfigCall2;
        this.apiClient = vungleApiClient;
        this.adAnalytics = adAnalytics2;
        this.adLoader = adLoader2;
        this.vungleApi = vungleStaticApi;
        this.logManager = logManager2;
    }

    public Job create(String str) throws UnknownTagException {
        if (TextUtils.isEmpty(str)) {
            throw new UnknownTagException("Job tag is null");
        } else if (str.startsWith(ReconfigJob.TAG)) {
            return new ReconfigJob(this.reconfigCall);
        } else {
            if (str.startsWith(DownloadJob.TAG)) {
                return new DownloadJob(this.adLoader, this.vungleApi);
            }
            if (str.startsWith(SendReportsJob.TAG)) {
                return new SendReportsJob(this.repository, this.apiClient);
            }
            if (str.startsWith(CleanupJob.TAG)) {
                return new CleanupJob(this.designer, this.repository, this.adLoader);
            }
            if (str.startsWith(AnalyticsJob.TAG)) {
                return new AnalyticsJob(this.adAnalytics);
            }
            if (str.startsWith(SendLogsJob.TAG)) {
                return new SendLogsJob(this.logManager);
            }
            if (str.startsWith(CacheBustJob.TAG)) {
                return new CacheBustJob(this.apiClient, this.repository, this.adLoader);
            }
            throw new UnknownTagException("Unknown Job Type " + str);
        }
    }
}
