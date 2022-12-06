package com.google.ads.mediation.adcolony;

import android.content.Context;
import android.content.res.Resources;
import com.adcolony.sdk.AdColonyAdSize;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MediationUtils;
import java.util.ArrayList;

public class AdColonyAdapterUtils {
    public static final String KEY_ADCOLONY_BID_RESPONSE = "adm";
    public static final String KEY_APP_ID = "app_id";
    public static final String KEY_ZONE_ID = "zone_id";
    public static final String KEY_ZONE_IDS = "zone_ids";

    public static AdColonyAdSize adColonyAdSizeFromAdMobAdSize(Context context, AdSize adSize) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AdSize.BANNER);
        arrayList.add(AdSize.LEADERBOARD);
        arrayList.add(AdSize.MEDIUM_RECTANGLE);
        arrayList.add(AdSize.WIDE_SKYSCRAPER);
        AdSize findClosestSize = MediationUtils.findClosestSize(context, adSize, arrayList);
        if (AdSize.BANNER.equals(findClosestSize)) {
            return AdColonyAdSize.BANNER;
        }
        if (AdSize.MEDIUM_RECTANGLE.equals(findClosestSize)) {
            return AdColonyAdSize.MEDIUM_RECTANGLE;
        }
        if (AdSize.LEADERBOARD.equals(findClosestSize)) {
            return AdColonyAdSize.LEADERBOARD;
        }
        if (AdSize.WIDE_SKYSCRAPER.equals(findClosestSize)) {
            return AdColonyAdSize.SKYSCRAPER;
        }
        return null;
    }

    public static int convertPixelsToDp(int i) {
        return (int) (((float) i) / Resources.getSystem().getDisplayMetrics().density);
    }
}
