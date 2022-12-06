package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzevl implements zzeve {
    private final zzfzq zza;
    private final Context zzb;

    public zzevl(zzfzq zzfzq, Context context) {
        this.zza = zzfzq;
        this.zzb = context;
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    public final int zza() {
        return 38;
    }

    public final zzfzp zzb() {
        return this.zza.zzb(new zzevk(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00aa A[Catch:{ Exception -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzevj zzc() throws java.lang.Exception {
        /*
            r23 = this;
            r0 = r23
            android.content.Context r1 = r0.zzb
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "geo:0,0?q=donuts"
            android.content.pm.ResolveInfo r3 = zzd(r1, r3)
            r5 = 0
            if (r3 == 0) goto L_0x0017
            r7 = 1
            goto L_0x0018
        L_0x0017:
            r7 = r5
        L_0x0018:
            java.lang.String r3 = "http://www.google.com"
            android.content.pm.ResolveInfo r3 = zzd(r1, r3)
            if (r3 == 0) goto L_0x0022
            r8 = 1
            goto L_0x0023
        L_0x0022:
            r8 = r5
        L_0x0023:
            java.lang.String r9 = r2.getCountry()
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.client.zzaw.zzb()
            boolean r10 = com.google.android.gms.internal.ads.zzcgi.zzq()
            android.content.Context r3 = r0.zzb
            boolean r11 = com.google.android.gms.common.util.DeviceProperties.isLatchsky(r3)
            android.content.Context r3 = r0.zzb
            boolean r12 = com.google.android.gms.common.util.DeviceProperties.isSidewinder(r3)
            java.lang.String r13 = r2.getLanguage()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0065
            android.os.LocaleList r2 = android.os.LocaleList.getDefault()
            r3 = r5
        L_0x0051:
            int r6 = r2.size()
            if (r3 >= r6) goto L_0x0065
            java.util.Locale r6 = r2.get(r3)
            java.lang.String r6 = r6.getLanguage()
            r14.add(r6)
            int r3 = r3 + 1
            goto L_0x0051
        L_0x0065:
            android.content.Context r2 = r0.zzb
            java.lang.String r3 = "market://details?id=com.google.android.gms.ads"
            android.content.pm.ResolveInfo r3 = zzd(r1, r3)
            java.lang.String r6 = "."
            if (r3 != 0) goto L_0x0073
        L_0x0071:
            r2 = 0
            goto L_0x009a
        L_0x0073:
            android.content.pm.ActivityInfo r3 = r3.activityInfo
            if (r3 != 0) goto L_0x0078
            goto L_0x0071
        L_0x0078:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r2 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r2)     // Catch:{ NameNotFoundException -> 0x0071 }
            java.lang.String r4 = r3.packageName     // Catch:{ NameNotFoundException -> 0x0071 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x0071 }
            if (r2 == 0) goto L_0x0071
            int r2 = r2.versionCode     // Catch:{ NameNotFoundException -> 0x0071 }
            java.lang.String r3 = r3.packageName     // Catch:{ NameNotFoundException -> 0x0071 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0071 }
            r4.<init>()     // Catch:{ NameNotFoundException -> 0x0071 }
            r4.append(r2)     // Catch:{ NameNotFoundException -> 0x0071 }
            r4.append(r6)     // Catch:{ NameNotFoundException -> 0x0071 }
            r4.append(r3)     // Catch:{ NameNotFoundException -> 0x0071 }
            java.lang.String r2 = r4.toString()     // Catch:{ NameNotFoundException -> 0x0071 }
        L_0x009a:
            android.content.Context r3 = r0.zzb
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r4 = "com.android.vending"
            r15 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r15)     // Catch:{ Exception -> 0x00c3 }
            if (r3 == 0) goto L_0x00c3
            int r4 = r3.versionCode     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x00c3 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c3 }
            r15.<init>()     // Catch:{ Exception -> 0x00c3 }
            r15.append(r4)     // Catch:{ Exception -> 0x00c3 }
            r15.append(r6)     // Catch:{ Exception -> 0x00c3 }
            r15.append(r3)     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r3 = r15.toString()     // Catch:{ Exception -> 0x00c3 }
            r17 = r3
            goto L_0x00c5
        L_0x00c3:
            r17 = 0
        L_0x00c5:
            java.lang.String r3 = android.os.Build.FINGERPRINT
            android.content.Context r4 = r0.zzb
            if (r1 != 0) goto L_0x00ce
            r18 = r3
            goto L_0x0118
        L_0x00ce:
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r15 = "http://www.example.com"
            android.net.Uri r15 = android.net.Uri.parse(r15)
            r18 = r3
            java.lang.String r3 = "android.intent.action.VIEW"
            r6.<init>(r3, r15)
            android.content.pm.ResolveInfo r3 = r1.resolveActivity(r6, r5)
            r15 = 65536(0x10000, float:9.18355E-41)
            java.util.List r1 = r1.queryIntentActivities(r6, r15)
            if (r1 == 0) goto L_0x0117
            if (r3 == 0) goto L_0x0117
            r6 = r5
        L_0x00ec:
            int r15 = r1.size()
            if (r6 >= r15) goto L_0x0117
            java.lang.Object r15 = r1.get(r6)
            android.content.pm.ResolveInfo r15 = (android.content.pm.ResolveInfo) r15
            android.content.pm.ActivityInfo r5 = r3.activityInfo
            java.lang.String r5 = r5.name
            android.content.pm.ActivityInfo r15 = r15.activityInfo
            java.lang.String r15 = r15.name
            boolean r5 = r5.equals(r15)
            if (r5 == 0) goto L_0x0113
            android.content.pm.ActivityInfo r1 = r3.activityInfo
            java.lang.String r1 = r1.packageName
            java.lang.String r3 = com.google.android.gms.internal.ads.zzgxw.zza(r4)
            boolean r5 = r1.equals(r3)
            goto L_0x0118
        L_0x0113:
            int r6 = r6 + 1
            r5 = 0
            goto L_0x00ec
        L_0x0117:
            r5 = 0
        L_0x0118:
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.StatFs r1 = new android.os.StatFs
            java.io.File r3 = android.os.Environment.getDataDirectory()
            java.lang.String r3 = r3.getAbsolutePath()
            r1.<init>(r3)
            long r3 = r1.getAvailableBytes()
            r20 = 1024(0x400, double:5.06E-321)
            long r20 = r3 / r20
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zziR
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r3.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x014d
            android.content.Context r1 = r0.zzb
            boolean r1 = com.google.android.gms.common.util.DeviceProperties.isBstar(r1)
            if (r1 == 0) goto L_0x014d
            r22 = 1
            goto L_0x014f
        L_0x014d:
            r22 = 0
        L_0x014f:
            com.google.android.gms.internal.ads.zzevj r1 = new com.google.android.gms.internal.ads.zzevj
            r6 = r1
            java.lang.String r19 = android.os.Build.MODEL
            r15 = r2
            r16 = r17
            r17 = r18
            r18 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzevl.zzc():com.google.android.gms.internal.ads.zzevj");
    }
}
