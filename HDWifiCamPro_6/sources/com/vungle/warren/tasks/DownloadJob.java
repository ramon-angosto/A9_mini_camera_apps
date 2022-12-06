package com.vungle.warren.tasks;

import android.os.Bundle;
import com.vungle.warren.AdLoader;
import com.vungle.warren.AdRequest;
import com.vungle.warren.VungleStaticApi;
import java.util.Collection;

public class DownloadJob implements Job {
    private static final String REQUEST_KEY_EXTRA = "request";
    static final String TAG = DownloadJob.class.getCanonicalName();
    private final AdLoader adLoader;
    private final VungleStaticApi vungleApi;

    public DownloadJob(AdLoader adLoader2, VungleStaticApi vungleStaticApi) {
        this.adLoader = adLoader2;
        this.vungleApi = vungleStaticApi;
    }

    public static JobInfo makeJobInfo(AdRequest adRequest) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(REQUEST_KEY_EXTRA, adRequest);
        return new JobInfo(TAG + " " + adRequest).setUpdateCurrent(true).setExtras(bundle).setPriority(4);
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        AdRequest adRequest = (AdRequest) bundle.getSerializable(REQUEST_KEY_EXTRA);
        Collection<String> validPlacements = this.vungleApi.getValidPlacements();
        if (adRequest == null || !validPlacements.contains(adRequest.getPlacementId())) {
            return 1;
        }
        this.adLoader.loadPendingInternal(adRequest);
        return 0;
    }
}
