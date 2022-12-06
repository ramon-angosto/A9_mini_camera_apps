package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzekn implements zzfzc {
    final /* synthetic */ long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzfdk zzc;
    final /* synthetic */ zzfdn zzd;
    final /* synthetic */ zzfki zze;
    final /* synthetic */ zzfdw zzf;
    final /* synthetic */ zzeko zzg;

    zzekn(zzeko zzeko, long j, String str, zzfdk zzfdk, zzfdn zzfdn, zzfki zzfki, zzfdw zzfdw) {
        this.zzg = zzeko;
        this.zza = j;
        this.zzb = str;
        this.zzc = zzfdk;
        this.zzd = zzfdn;
        this.zze = zzfki;
        this.zzf = zzfdw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.Throwable r14) {
        /*
            r13 = this;
            com.google.android.gms.internal.ads.zzeko r0 = r13.zzg
            com.google.android.gms.common.util.Clock r0 = r0.zza
            long r0 = r0.elapsedRealtime()
            long r2 = r13.zza
            long r0 = r0 - r2
            boolean r2 = r14 instanceof java.util.concurrent.TimeoutException
            r3 = 6
            r11 = 3
            r12 = 0
            if (r2 == 0) goto L_0x0018
            r2 = 2
        L_0x0015:
            r3 = r2
        L_0x0016:
            r10 = r12
            goto L_0x005d
        L_0x0018:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzekd
            if (r2 == 0) goto L_0x001e
            r3 = r11
            goto L_0x0016
        L_0x001e:
            boolean r2 = r14 instanceof java.util.concurrent.CancellationException
            if (r2 == 0) goto L_0x0024
            r2 = 4
            goto L_0x0015
        L_0x0024:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzfek
            if (r2 == 0) goto L_0x002a
            r2 = 5
            goto L_0x0015
        L_0x002a:
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzebh
            if (r2 == 0) goto L_0x0016
            com.google.android.gms.ads.internal.client.zze r2 = com.google.android.gms.internal.ads.zzffe.zza(r14)
            int r2 = r2.zza
            if (r2 != r11) goto L_0x0037
            r3 = 1
        L_0x0037:
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzbu
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r2 = r4.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0016
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzehg
            if (r2 == 0) goto L_0x0016
            r2 = r14
            com.google.android.gms.internal.ads.zzehg r2 = (com.google.android.gms.internal.ads.zzehg) r2
            com.google.android.gms.ads.internal.client.zze r2 = r2.zzb()
            if (r2 == 0) goto L_0x0016
            int r2 = r2.zza
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10 = r2
        L_0x005d:
            com.google.android.gms.internal.ads.zzeko r4 = r13.zzg
            java.lang.String r5 = r13.zzb
            com.google.android.gms.internal.ads.zzfdk r2 = r13.zzc
            java.lang.String r9 = r2.zzah
            r6 = r3
            r7 = r0
            com.google.android.gms.internal.ads.zzeko.zzg(r4, r5, r6, r7, r9, r10)
            com.google.android.gms.internal.ads.zzeko r2 = r13.zzg
            boolean r4 = r2.zze
            if (r4 == 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzekp r4 = r2.zzb
            com.google.android.gms.internal.ads.zzfdn r5 = r13.zzd
            com.google.android.gms.internal.ads.zzfdk r6 = r13.zzc
            boolean r2 = r14 instanceof com.google.android.gms.internal.ads.zzehg
            if (r2 == 0) goto L_0x0083
            r2 = r14
            com.google.android.gms.internal.ads.zzehg r2 = (com.google.android.gms.internal.ads.zzehg) r2
            r8 = r2
            goto L_0x0084
        L_0x0083:
            r8 = r12
        L_0x0084:
            r7 = r3
            r9 = r0
            r4.zza(r5, r6, r7, r8, r9)
        L_0x0089:
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzhi
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r2 = r3.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00b0
            com.google.android.gms.internal.ads.zzeko r2 = r13.zzg
            com.google.android.gms.internal.ads.zzfkm r2 = r2.zzc
            com.google.android.gms.internal.ads.zzfki r3 = r13.zze
            com.google.android.gms.internal.ads.zzfdw r4 = r13.zzf
            com.google.android.gms.internal.ads.zzfdk r5 = r13.zzc
            java.util.List r6 = r5.zzo
            java.util.List r3 = r3.zzc(r4, r5, r6)
            r2.zzd(r3)
        L_0x00b0:
            com.google.android.gms.ads.internal.client.zze r14 = com.google.android.gms.internal.ads.zzffe.zza(r14)
            int r2 = r14.zza
            if (r2 == r11) goto L_0x00ba
            if (r2 != 0) goto L_0x00d5
        L_0x00ba:
            com.google.android.gms.ads.internal.client.zze r2 = r14.zzd
            if (r2 == 0) goto L_0x00d5
            java.lang.String r2 = r2.zzc
            java.lang.String r3 = "com.google.android.gms.ads"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzehg r2 = new com.google.android.gms.internal.ads.zzehg
            r3 = 13
            com.google.android.gms.ads.internal.client.zze r14 = r14.zzd
            r2.<init>(r3, r14)
            com.google.android.gms.ads.internal.client.zze r14 = com.google.android.gms.internal.ads.zzffe.zza(r2)
        L_0x00d5:
            com.google.android.gms.internal.ads.zzeko r2 = r13.zzg
            com.google.android.gms.internal.ads.zzehh r2 = r2.zzf
            com.google.android.gms.internal.ads.zzfdk r3 = r13.zzc
            r2.zze(r3, r0, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekn.zza(java.lang.Throwable):void");
    }

    public final void zzb(Object obj) {
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        zzeko.zzg(this.zzg, this.zzb, 0, elapsedRealtime, this.zzc.zzah, (Integer) null);
        zzeko zzeko = this.zzg;
        if (zzeko.zze) {
            zzeko.zzb.zza(this.zzd, this.zzc, 0, (zzehg) null, elapsedRealtime);
        }
        this.zzg.zzf.zzf(this.zzc, elapsedRealtime, (zze) null);
    }
}
