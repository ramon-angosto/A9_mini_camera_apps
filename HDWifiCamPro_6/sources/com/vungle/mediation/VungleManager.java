package com.vungle.mediation;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.ads.mediation.vungle.VungleBannerAd;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.ads.mediation.vungle.VungleNativeAd;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MediationUtils;
import com.vungle.warren.AdConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class VungleManager {
    private static final String PLAYING_PLACEMENT = "placementID";
    private static VungleManager sInstance;
    private final ConcurrentHashMap<String, VungleBannerAd> mVungleBanners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, VungleNativeAd> mVungleNativeAds = new ConcurrentHashMap<>();

    public static synchronized VungleManager getInstance() {
        VungleManager vungleManager;
        synchronized (VungleManager.class) {
            if (sInstance == null) {
                sInstance = new VungleManager();
            }
            vungleManager = sInstance;
        }
        return vungleManager;
    }

    private VungleManager() {
    }

    public String findPlacement(Bundle bundle, Bundle bundle2) {
        String string = (bundle == null || !bundle.containsKey("playPlacement")) ? null : bundle.getString("playPlacement");
        if (bundle2 != null && bundle2.containsKey(PLAYING_PLACEMENT)) {
            if (string != null) {
                Log.i(VungleMediationAdapter.TAG, "'placementID' had a value in both serverParameters and networkExtras. Used one from serverParameters");
            }
            string = bundle2.getString(PLAYING_PLACEMENT);
        }
        if (string == null) {
            Log.e(VungleMediationAdapter.TAG, "placementID not provided from serverParameters.");
        }
        return string;
    }

    private void cleanLeakedBannerAdapters() {
        Iterator it = new HashSet(this.mVungleBanners.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            VungleBannerAd vungleBannerAd = this.mVungleBanners.get(str);
            if (vungleBannerAd != null && vungleBannerAd.getAdapter() == null) {
                removeActiveBannerAd(str, vungleBannerAd);
            }
        }
    }

    public synchronized boolean canRequestBannerAd(String str, String str2) {
        cleanLeakedBannerAdapters();
        VungleBannerAd vungleBannerAd = this.mVungleBanners.get(str);
        if (vungleBannerAd == null) {
            return true;
        }
        if (vungleBannerAd.getAdapter() == null) {
            this.mVungleBanners.remove(str);
            return true;
        }
        String uniqueRequestId = vungleBannerAd.getAdapter().getUniqueRequestId();
        String str3 = VungleMediationAdapter.TAG;
        Log.d(str3, "activeUniqueId: " + uniqueRequestId + " ###  RequestId: " + str2);
        if (uniqueRequestId == null) {
            String str4 = VungleMediationAdapter.TAG;
            Log.w(str4, "Ad already loaded for placement ID: " + str + ", and cannot determine if this is a refresh. Set Vungle extras when making an ad request to support refresh on Vungle banner ads.");
            return false;
        } else if (uniqueRequestId.equals(str2)) {
            return true;
        } else {
            String str5 = VungleMediationAdapter.TAG;
            Log.w(str5, "Ad already loaded for placement ID: " + str);
            return false;
        }
    }

    public void removeActiveBannerAd(String str, VungleBannerAd vungleBannerAd) {
        String str2 = VungleMediationAdapter.TAG;
        Log.d(str2, "try to removeActiveBannerAd: " + str);
        if (this.mVungleBanners.remove(str, vungleBannerAd) && vungleBannerAd != null) {
            String str3 = VungleMediationAdapter.TAG;
            Log.d(str3, "removeActiveBannerAd: " + vungleBannerAd + "; size=" + this.mVungleBanners.size());
            vungleBannerAd.detach();
            vungleBannerAd.destroyAd();
        }
    }

    public void registerBannerAd(String str, VungleBannerAd vungleBannerAd) {
        removeActiveBannerAd(str, this.mVungleBanners.get(str));
        if (!this.mVungleBanners.containsKey(str)) {
            this.mVungleBanners.put(str, vungleBannerAd);
            String str2 = VungleMediationAdapter.TAG;
            Log.d(str2, "registerBannerAd: " + vungleBannerAd + "; size=" + this.mVungleBanners.size());
        }
    }

    public VungleBannerAd getVungleBannerAd(String str) {
        return this.mVungleBanners.get(str);
    }

    public void removeActiveNativeAd(String str, VungleNativeAd vungleNativeAd) {
        String str2 = VungleMediationAdapter.TAG;
        Log.d(str2, "try to removeActiveNativeAd: " + str);
        if (this.mVungleNativeAds.remove(str, vungleNativeAd) && vungleNativeAd != null) {
            String str3 = VungleMediationAdapter.TAG;
            Log.d(str3, "removeActiveNativeAd: " + vungleNativeAd + "; size=" + this.mVungleNativeAds.size());
            vungleNativeAd.destroyAd();
        }
    }

    public void registerNativeAd(String str, VungleNativeAd vungleNativeAd) {
        removeActiveNativeAd(str, this.mVungleNativeAds.get(str));
        if (!this.mVungleNativeAds.containsKey(str)) {
            this.mVungleNativeAds.put(str, vungleNativeAd);
            String str2 = VungleMediationAdapter.TAG;
            Log.d(str2, "registerNativeAd: " + vungleNativeAd + "; size=" + this.mVungleNativeAds.size());
        }
    }

    public boolean hasBannerSizeAd(Context context, AdSize adSize, AdConfig adConfig) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AdSize(AdConfig.AdSize.BANNER_SHORT.getWidth(), AdConfig.AdSize.BANNER_SHORT.getHeight()));
        arrayList.add(new AdSize(AdConfig.AdSize.BANNER.getWidth(), AdConfig.AdSize.BANNER.getHeight()));
        arrayList.add(new AdSize(AdConfig.AdSize.BANNER_LEADERBOARD.getWidth(), AdConfig.AdSize.BANNER_LEADERBOARD.getHeight()));
        arrayList.add(new AdSize(AdConfig.AdSize.VUNGLE_MREC.getWidth(), AdConfig.AdSize.VUNGLE_MREC.getHeight()));
        AdSize findClosestSize = MediationUtils.findClosestSize(context, adSize, arrayList);
        if (findClosestSize == null) {
            String str = VungleMediationAdapter.TAG;
            Log.i(str, "Not found closest ad size: " + adSize);
            return false;
        }
        String str2 = VungleMediationAdapter.TAG;
        Log.i(str2, "Found closest ad size: " + findClosestSize + " for requested ad size: " + adSize);
        if (findClosestSize.getWidth() == AdConfig.AdSize.BANNER_SHORT.getWidth() && findClosestSize.getHeight() == AdConfig.AdSize.BANNER_SHORT.getHeight()) {
            adConfig.setAdSize(AdConfig.AdSize.BANNER_SHORT);
            return true;
        } else if (findClosestSize.getWidth() == AdConfig.AdSize.BANNER.getWidth() && findClosestSize.getHeight() == AdConfig.AdSize.BANNER.getHeight()) {
            adConfig.setAdSize(AdConfig.AdSize.BANNER);
            return true;
        } else if (findClosestSize.getWidth() == AdConfig.AdSize.BANNER_LEADERBOARD.getWidth() && findClosestSize.getHeight() == AdConfig.AdSize.BANNER_LEADERBOARD.getHeight()) {
            adConfig.setAdSize(AdConfig.AdSize.BANNER_LEADERBOARD);
            return true;
        } else if (findClosestSize.getWidth() != AdConfig.AdSize.VUNGLE_MREC.getWidth() || findClosestSize.getHeight() != AdConfig.AdSize.VUNGLE_MREC.getHeight()) {
            return true;
        } else {
            adConfig.setAdSize(AdConfig.AdSize.VUNGLE_MREC);
            return true;
        }
    }
}
