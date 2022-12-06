package com.vungle.warren.tasks;

import android.os.Bundle;
import android.util.Log;
import com.vungle.warren.AdLoader;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Designer;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class CleanupJob implements Job {
    static final String TAG = CleanupJob.class.getCanonicalName();
    private final AdLoader adLoader;
    private final Designer designer;
    private final Repository repository;

    CleanupJob(Designer designer2, Repository repository2, AdLoader adLoader2) {
        this.designer = designer2;
        this.repository = repository2;
        this.adLoader = adLoader2;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        if (this.designer == null || this.repository == null) {
            return 1;
        }
        Log.d(TAG, "CleanupJob: Current directory snapshot");
        FileUtility.printDirectoryTree(this.designer.getCacheDirectory());
        File[] listFiles = this.designer.getCacheDirectory().listFiles();
        List<Placement> list = this.repository.loadAll(Placement.class).get();
        if (list == null || list.size() == 0) {
            return 0;
        }
        Collection collection = this.repository.loadValidPlacements().get();
        HashSet hashSet = new HashSet();
        try {
            for (Placement placement : list) {
                if (collection == null || collection.isEmpty() || collection.contains(placement)) {
                    List<String> list2 = this.repository.findAdsForPlacement(placement.getId()).get();
                    if (list2 != null) {
                        for (String str : list2) {
                            Advertisement advertisement = this.repository.load(str, Advertisement.class).get();
                            if (advertisement != null) {
                                if (advertisement.getExpireTime() > System.currentTimeMillis() || advertisement.getState() == 2) {
                                    hashSet.add(advertisement.getId());
                                    Log.w(TAG, "setting valid adv " + str + " for placement " + placement.getId());
                                } else {
                                    this.repository.deleteAdvertisement(str);
                                    SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.AD_EXPIRED).addData(SessionAttribute.EVENT_ID, str).build());
                                    this.adLoader.loadEndlessIfNeeded(placement, placement.getAdSize(), 1000, false);
                                }
                            }
                        }
                    }
                } else {
                    Log.d(TAG, String.format(Locale.ENGLISH, "Placement %s is no longer valid, deleting it and its advertisement", new Object[]{placement.getId()}));
                    this.repository.delete(placement);
                }
            }
            List<Advertisement> list3 = this.repository.loadAll(Advertisement.class).get();
            if (list3 != null) {
                for (Advertisement advertisement2 : list3) {
                    if (advertisement2.getState() == 2) {
                        hashSet.add(advertisement2.getId());
                        Log.d(TAG, "found adv in viewing state " + advertisement2.getId());
                    } else if (!hashSet.contains(advertisement2.getId())) {
                        Log.e(TAG, "    delete ad " + advertisement2.getId());
                        this.repository.deleteAdvertisement(advertisement2.getId());
                    }
                }
            }
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!hashSet.contains(file.getName())) {
                        Log.v(TAG, String.format(Locale.ENGLISH, "Deleting assets under directory %s", new Object[]{file.getName()}));
                        FileUtility.delete(file);
                    }
                }
            }
            return 0;
        } catch (DatabaseHelper.DBException unused) {
            return 1;
        } catch (IOException e) {
            Log.e(TAG, "Failed to delete asset directory!", e);
            return 1;
        }
    }

    public static JobInfo makeJobInfo() {
        return new JobInfo(TAG).setPriority(0).setUpdateCurrent(true);
    }
}
