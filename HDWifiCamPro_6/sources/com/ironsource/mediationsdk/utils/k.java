package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.f;
import com.ironsource.mediationsdk.model.l;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class k {
    private static k a;
    private final HashSet<ImpressionDataListener> b = new HashSet<>();
    private ConcurrentHashMap<String, List<String>> c = new ConcurrentHashMap<>();

    /* renamed from: com.ironsource.mediationsdk.utils.k$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[l.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.ironsource.mediationsdk.model.l[] r0 = com.ironsource.mediationsdk.model.l.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.ironsource.mediationsdk.model.l r1 = com.ironsource.mediationsdk.model.l.PER_DAY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.ironsource.mediationsdk.model.l r1 = com.ironsource.mediationsdk.model.l.PER_HOUR     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.k.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;

        static {
            e = new int[]{1, 2, 3, 4};
        }

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    k() {
    }

    private static int a(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_DELIVERY_ENABLED", str2), true)) {
            return a.a;
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_PACING_ENABLED", str2), false)) {
            if (currentTimeMillis - IronSourceUtils.getLongFromSharedPrefs(context, a(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), 0) < ((long) (IronSourceUtils.getIntFromSharedPrefs(context, a(str, "CappingManager.SECONDS_BETWEEN_SHOWS", str2), 0) * 1000))) {
                return a.c;
            }
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_CAPPING_ENABLED", str2), false)) {
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String a2 = a(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int intFromSharedPrefs2 = IronSourceUtils.getIntFromSharedPrefs(context, a2, 0);
            String a3 = a(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2);
            if (currentTimeMillis >= IronSourceUtils.getLongFromSharedPrefs(context, a3, 0)) {
                IronSourceUtils.saveIntToSharedPrefs(context, a2, 0);
                IronSourceUtils.saveLongToSharedPrefs(context, a3, 0);
            } else if (intFromSharedPrefs2 >= intFromSharedPrefs) {
                return a.b;
            }
        }
        return a.d;
    }

    private static long a(l lVar) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i = AnonymousClass1.a[lVar.ordinal()];
        if (i == 1) {
            instance.set(14, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.set(11, 0);
            instance.add(6, 1);
        } else if (i == 2) {
            instance.set(14, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.add(11, 1);
        }
        return instance.getTimeInMillis();
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                a = new k();
            }
            kVar = a;
        }
        return kVar;
    }

    private static String a(IronSource.AD_UNIT ad_unit) {
        return ad_unit == IronSource.AD_UNIT.INTERSTITIAL ? IronSourceConstants.INTERSTITIAL_AD_UNIT : ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO ? IronSourceConstants.REWARDED_VIDEO_AD_UNIT : ad_unit == IronSource.AD_UNIT.BANNER ? IronSourceConstants.BANNER_AD_UNIT : ad_unit.toString();
    }

    private static String a(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    public static synchronized void a(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (k.class) {
            if (context != null) {
                com.ironsource.mediationsdk.model.k placementAvailabilitySettings = interstitialPlacement.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    a(context, IronSourceConstants.INTERSTITIAL_AD_UNIT, interstitialPlacement.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    public static synchronized void a(Context context, Placement placement) {
        synchronized (k.class) {
            if (context != null) {
                com.ironsource.mediationsdk.model.k placementAvailabilitySettings = placement.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    a(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    public static synchronized void a(Context context, f fVar) {
        synchronized (k.class) {
            if (context != null) {
                com.ironsource.mediationsdk.model.k placementAvailabilitySettings = fVar.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    a(context, IronSourceConstants.BANNER_AD_UNIT, fVar.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    private static void a(Context context, String str, String str2, com.ironsource.mediationsdk.model.k kVar) {
        boolean z = kVar.a;
        IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, "CappingManager.IS_DELIVERY_ENABLED", str2), z);
        if (z) {
            boolean z2 = kVar.b;
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, "CappingManager.IS_CAPPING_ENABLED", str2), z2);
            if (z2) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), kVar.e);
                IronSourceUtils.saveStringToSharedPrefs(context, a(str, "CappingManager.CAPPING_TYPE", str2), kVar.d.toString());
            }
            boolean z3 = kVar.c;
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, "CappingManager.IS_PACING_ENABLED", str2), z3);
            if (z3) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, "CappingManager.SECONDS_BETWEEN_SHOWS", str2), kVar.f);
            }
        }
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z;
        synchronized (k.class) {
            z = a(context, IronSourceConstants.INTERSTITIAL_AD_UNIT, str) != a.d;
        }
        return z;
    }

    public static synchronized boolean a(Context context, String str, IronSource.AD_UNIT ad_unit) {
        boolean z;
        synchronized (k.class) {
            z = a(context, a(ad_unit), str) != a.d;
        }
        return z;
    }

    public static synchronized int b(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (k.class) {
            if (!(context == null || interstitialPlacement == null)) {
                if (interstitialPlacement.getPlacementAvailabilitySettings() != null) {
                    int a2 = a(context, IronSourceConstants.INTERSTITIAL_AD_UNIT, interstitialPlacement.getPlacementName());
                    return a2;
                }
            }
            int i = a.d;
            return i;
        }
    }

    public static synchronized int b(Context context, Placement placement) {
        synchronized (k.class) {
            if (!(context == null || placement == null)) {
                if (placement.getPlacementAvailabilitySettings() != null) {
                    int a2 = a(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName());
                    return a2;
                }
            }
            int i = a.d;
            return i;
        }
    }

    public static synchronized void b(Context context, String str, IronSource.AD_UNIT ad_unit) {
        synchronized (k.class) {
            b(context, a(ad_unit), str);
        }
    }

    private static void b(Context context, String str, String str2) {
        int i = 0;
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_PACING_ENABLED", str2), false)) {
            IronSourceUtils.saveLongToSharedPrefs(context, a(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), System.currentTimeMillis());
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_CAPPING_ENABLED", str2), false)) {
            IronSourceUtils.getIntFromSharedPrefs(context, a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String a2 = a(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a2, 0);
            if (intFromSharedPrefs == 0) {
                String stringFromSharedPrefs = IronSourceUtils.getStringFromSharedPrefs(context, a(str, "CappingManager.CAPPING_TYPE", str2), l.PER_DAY.toString());
                l lVar = null;
                l[] values = l.values();
                int length = values.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    l lVar2 = values[i];
                    if (lVar2.c.equals(stringFromSharedPrefs)) {
                        lVar = lVar2;
                        break;
                    }
                    i++;
                }
                IronSourceUtils.saveLongToSharedPrefs(context, a(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2), a(lVar));
            }
            IronSourceUtils.saveIntToSharedPrefs(context, a2, intFromSharedPrefs + 1);
        }
    }

    public static synchronized boolean b(Context context, String str) {
        boolean z;
        synchronized (k.class) {
            z = a(context, IronSourceConstants.BANNER_AD_UNIT, str) != a.d;
        }
        return z;
    }

    public static synchronized void c(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (k.class) {
            if (interstitialPlacement != null) {
                b(context, IronSourceConstants.INTERSTITIAL_AD_UNIT, interstitialPlacement.getPlacementName());
            }
        }
    }

    public static synchronized void c(Context context, Placement placement) {
        synchronized (k.class) {
            if (placement != null) {
                b(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName());
            }
        }
    }

    public static synchronized boolean c(Context context, String str) {
        boolean z;
        synchronized (k.class) {
            z = a(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str) != a.d;
        }
        return z;
    }

    public static synchronized void d(Context context, String str) {
        synchronized (k.class) {
            b(context, IronSourceConstants.INTERSTITIAL_AD_UNIT, str);
        }
    }

    public static synchronized void e(Context context, String str) {
        synchronized (k.class) {
            b(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str);
        }
    }

    public static synchronized void f(Context context, String str) {
        synchronized (k.class) {
            if (!TextUtils.isEmpty(str)) {
                b(context, IronSourceConstants.BANNER_AD_UNIT, str);
            }
        }
    }

    public void a(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.b.add(impressionDataListener);
        }
    }

    public void a(String str, List<String> list) {
        this.c.put(str, list);
    }

    public HashSet<ImpressionDataListener> b() {
        return this.b;
    }

    public void b(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.b.remove(impressionDataListener);
        }
    }

    public void c() {
        synchronized (this) {
            this.b.clear();
        }
    }

    public ConcurrentHashMap<String, List<String>> d() {
        return this.c;
    }
}
