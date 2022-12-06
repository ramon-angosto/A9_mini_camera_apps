package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeth implements zzeve {
    private final zzfzq zza;
    private final zzfef zzb;
    private final PackageInfo zzc;
    private final zzg zzd;

    public zzeth(zzfzq zzfzq, zzfef zzfef, PackageInfo packageInfo, zzg zzg) {
        this.zza = zzfzq;
        this.zzb = zzfef;
        this.zzc = packageInfo;
        this.zzd = zzg;
    }

    public static /* synthetic */ zzeti zzc(zzeth zzeth) {
        ArrayList arrayList = zzeth.zzb.zzg;
        if (arrayList == null) {
            return zzetd.zza;
        }
        return arrayList.isEmpty() ? zzete.zza : new zzetf(zzeth, arrayList);
    }

    public final int zza() {
        return 26;
    }

    public final zzfzp zzb() {
        return this.zza.zzb(new zzetg(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        if (r9 == 3) goto L_0x0105;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzd(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            r8 = this;
            r0 = 3
            java.lang.String r1 = "native_version"
            r10.putInt(r1, r0)
            java.lang.String r1 = "native_templates"
            r10.putStringArrayList(r1, r9)
            com.google.android.gms.internal.ads.zzfef r9 = r8.zzb
            java.util.ArrayList r9 = r9.zzh
            java.lang.String r1 = "native_custom_templates"
            r10.putStringArrayList(r1, r9)
            com.google.android.gms.internal.ads.zzfef r9 = r8.zzb
            com.google.android.gms.internal.ads.zzbls r9 = r9.zzi
            int r9 = r9.zza
            java.lang.String r1 = "landscape"
            java.lang.String r2 = "portrait"
            java.lang.String r3 = "any"
            java.lang.String r4 = "unknown"
            r5 = 2
            r6 = 1
            if (r9 <= r0) goto L_0x004f
            java.lang.String r9 = "enable_native_media_orientation"
            r10.putBoolean(r9, r6)
            com.google.android.gms.internal.ads.zzfef r9 = r8.zzb
            com.google.android.gms.internal.ads.zzbls r9 = r9.zzi
            int r9 = r9.zzh
            if (r9 == r6) goto L_0x0043
            if (r9 == r5) goto L_0x0041
            if (r9 == r0) goto L_0x003f
            r7 = 4
            if (r9 == r7) goto L_0x003c
            r9 = r4
            goto L_0x0044
        L_0x003c:
            java.lang.String r9 = "square"
            goto L_0x0044
        L_0x003f:
            r9 = r2
            goto L_0x0044
        L_0x0041:
            r9 = r1
            goto L_0x0044
        L_0x0043:
            r9 = r3
        L_0x0044:
            boolean r7 = r4.equals(r9)
            if (r7 != 0) goto L_0x004f
            java.lang.String r7 = "native_media_orientation"
            r10.putString(r7, r9)
        L_0x004f:
            com.google.android.gms.internal.ads.zzfef r9 = r8.zzb
            com.google.android.gms.internal.ads.zzbls r9 = r9.zzi
            int r9 = r9.zzc
            if (r9 == 0) goto L_0x005f
            if (r9 == r6) goto L_0x005d
            if (r9 == r5) goto L_0x0060
            r1 = r4
            goto L_0x0060
        L_0x005d:
            r1 = r2
            goto L_0x0060
        L_0x005f:
            r1 = r3
        L_0x0060:
            boolean r9 = r4.equals(r1)
            if (r9 != 0) goto L_0x006b
            java.lang.String r9 = "native_image_orientation"
            r10.putString(r9, r1)
        L_0x006b:
            com.google.android.gms.internal.ads.zzfef r9 = r8.zzb
            com.google.android.gms.internal.ads.zzbls r9 = r9.zzi
            boolean r9 = r9.zzd
            java.lang.String r1 = "native_multiple_images"
            r10.putBoolean(r1, r9)
            com.google.android.gms.internal.ads.zzfef r9 = r8.zzb
            com.google.android.gms.internal.ads.zzbls r9 = r9.zzi
            boolean r9 = r9.zzg
            java.lang.String r1 = "use_custom_mute"
            r10.putBoolean(r1, r9)
            android.content.pm.PackageInfo r9 = r8.zzc
            if (r9 != 0) goto L_0x0087
            r9 = 0
            goto L_0x0089
        L_0x0087:
            int r9 = r9.versionCode
        L_0x0089:
            com.google.android.gms.ads.internal.util.zzg r1 = r8.zzd
            int r1 = r1.zza()
            if (r9 <= r1) goto L_0x009b
            com.google.android.gms.ads.internal.util.zzg r1 = r8.zzd
            r1.zzs()
            com.google.android.gms.ads.internal.util.zzg r1 = r8.zzd
            r1.zzv(r9)
        L_0x009b:
            com.google.android.gms.ads.internal.util.zzg r9 = r8.zzd
            org.json.JSONObject r9 = r9.zzp()
            r1 = 0
            if (r9 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzfef r2 = r8.zzb
            java.lang.String r2 = r2.zzf
            org.json.JSONArray r9 = r9.optJSONArray(r2)
            if (r9 == 0) goto L_0x00b2
            java.lang.String r1 = r9.toString()
        L_0x00b2:
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 != 0) goto L_0x00bd
            java.lang.String r9 = "native_advanced_settings"
            r10.putString(r9, r1)
        L_0x00bd:
            com.google.android.gms.internal.ads.zzfef r9 = r8.zzb
            int r9 = r9.zzk
            if (r9 <= r6) goto L_0x00c8
            java.lang.String r1 = "max_num_ads"
            r10.putInt(r1, r9)
        L_0x00c8:
            com.google.android.gms.internal.ads.zzfef r9 = r8.zzb
            com.google.android.gms.internal.ads.zzbsc r9 = r9.zzb
            if (r9 == 0) goto L_0x0118
            java.lang.String r1 = r9.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x010c
            int r1 = r9.zza
            java.lang.String r2 = "p"
            java.lang.String r3 = "l"
            if (r1 < r5) goto L_0x00e5
            int r9 = r9.zzd
            if (r9 == r5) goto L_0x0106
            if (r9 == r0) goto L_0x0105
            goto L_0x0106
        L_0x00e5:
            int r9 = r9.zzb
            if (r9 == r6) goto L_0x0106
            if (r9 == r5) goto L_0x0105
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Instream ad video aspect ratio "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = " is wrong."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.google.android.gms.internal.ads.zzcgp.zzg(r9)
            goto L_0x0106
        L_0x0105:
            r3 = r2
        L_0x0106:
            java.lang.String r9 = "ia_var"
            r10.putString(r9, r3)
            goto L_0x0113
        L_0x010c:
            java.lang.String r9 = r9.zzc
            java.lang.String r0 = "ad_tag"
            r10.putString(r0, r9)
        L_0x0113:
            java.lang.String r9 = "instr"
            r10.putBoolean(r9, r6)
        L_0x0118:
            com.google.android.gms.internal.ads.zzfef r9 = r8.zzb
            com.google.android.gms.internal.ads.zzbnv r9 = r9.zza()
            if (r9 == 0) goto L_0x0125
            java.lang.String r9 = "has_delayed_banner_listener"
            r10.putBoolean(r9, r6)
        L_0x0125:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeth.zzd(java.util.ArrayList, android.os.Bundle):void");
    }
}
