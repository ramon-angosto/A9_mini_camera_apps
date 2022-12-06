package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcfz {
    long zza = -1;
    long zzb = -1;
    int zzc = -1;
    int zzd = -1;
    long zze = 0;
    final String zzf;
    int zzg = 0;
    int zzh = 0;
    private final Object zzi = new Object();
    private final zzg zzj;

    public zzcfz(String str, zzg zzg2) {
        this.zzf = str;
        this.zzj = zzg2;
    }

    private final void zzg() {
        if (((Boolean) zzbky.zza.zze()).booleanValue()) {
            synchronized (this.zzi) {
                this.zzc--;
                this.zzd--;
            }
        }
    }

    public final Bundle zza(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzi) {
            bundle = new Bundle();
            if (!this.zzj.zzP()) {
                bundle.putString("session_id", this.zzf);
            }
            bundle.putLong("basets", this.zzb);
            bundle.putLong("currts", this.zza);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzc);
            bundle.putInt("preqs_in_session", this.zzd);
            bundle.putLong("time_in_session", this.zze);
            bundle.putInt("pclick", this.zzg);
            bundle.putInt("pimp", this.zzh);
            Context zza2 = zzcbq.zza(context);
            int identifier = zza2.getResources().getIdentifier("Theme.Translucent", TtmlNode.TAG_STYLE, "android");
            boolean z = false;
            if (identifier == 0) {
                zze.zzi("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            } else {
                try {
                    if (identifier == zza2.getPackageManager().getActivityInfo(new ComponentName(zza2.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                        z = true;
                    } else {
                        zze.zzi("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    zze.zzj("Fail to fetch AdActivity theme");
                    zze.zzi("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                }
            }
            bundle.putBoolean("support_transparent_background", z);
        }
        return bundle;
    }

    public final void zzb() {
        synchronized (this.zzi) {
            this.zzg++;
        }
    }

    public final void zzc() {
        synchronized (this.zzi) {
            this.zzh++;
        }
    }

    public final void zzd() {
        zzg();
    }

    public final void zze() {
        zzg();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.ads.internal.client.zzl r10, long r11) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzi
            monitor-enter(r0)
            com.google.android.gms.ads.internal.util.zzg r1 = r9.zzj     // Catch:{ all -> 0x0074 }
            long r1 = r1.zzd()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ all -> 0x0074 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0074 }
            long r5 = r9.zzb     // Catch:{ all -> 0x0074 }
            r7 = -1
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0040
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzbiu r5 = com.google.android.gms.internal.ads.zzbjc.zzaN     // Catch:{ all -> 0x0074 }
            com.google.android.gms.internal.ads.zzbja r6 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0074 }
            java.lang.Object r5 = r6.zzb(r5)     // Catch:{ all -> 0x0074 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0074 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0074 }
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0033
            r1 = -1
            r9.zzd = r1     // Catch:{ all -> 0x0074 }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.ads.internal.util.zzg r1 = r9.zzj     // Catch:{ all -> 0x0074 }
            int r1 = r1.zzc()     // Catch:{ all -> 0x0074 }
            r9.zzd = r1     // Catch:{ all -> 0x0074 }
        L_0x003b:
            r9.zzb = r11     // Catch:{ all -> 0x0074 }
            r9.zza = r11     // Catch:{ all -> 0x0074 }
            goto L_0x0042
        L_0x0040:
            r9.zza = r11     // Catch:{ all -> 0x0074 }
        L_0x0042:
            android.os.Bundle r10 = r10.zzc     // Catch:{ all -> 0x0074 }
            r11 = 1
            if (r10 == 0) goto L_0x0053
            java.lang.String r12 = "gw"
            r1 = 2
            int r10 = r10.getInt(r12, r1)     // Catch:{ all -> 0x0074 }
            if (r10 == r11) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            return
        L_0x0053:
            int r10 = r9.zzc     // Catch:{ all -> 0x0074 }
            int r10 = r10 + r11
            r9.zzc = r10     // Catch:{ all -> 0x0074 }
            int r10 = r9.zzd     // Catch:{ all -> 0x0074 }
            int r10 = r10 + r11
            r9.zzd = r10     // Catch:{ all -> 0x0074 }
            if (r10 != 0) goto L_0x0069
            r10 = 0
            r9.zze = r10     // Catch:{ all -> 0x0074 }
            com.google.android.gms.ads.internal.util.zzg r10 = r9.zzj     // Catch:{ all -> 0x0074 }
            r10.zzD(r3)     // Catch:{ all -> 0x0074 }
            goto L_0x0072
        L_0x0069:
            com.google.android.gms.ads.internal.util.zzg r10 = r9.zzj     // Catch:{ all -> 0x0074 }
            long r10 = r10.zze()     // Catch:{ all -> 0x0074 }
            long r3 = r3 - r10
            r9.zze = r3     // Catch:{ all -> 0x0074 }
        L_0x0072:
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            return
        L_0x0074:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfz.zzf(com.google.android.gms.ads.internal.client.zzl, long):void");
    }
}
