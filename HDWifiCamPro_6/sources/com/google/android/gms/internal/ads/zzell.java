package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzell implements zzdmp {
    private final Context zza;
    private final zzduy zzb;
    private final zzfef zzc;
    private final zzcgv zzd;
    private final zzfdk zze;
    private final zzfzp zzf;
    private final zzcmp zzg;
    private final zzbpx zzh;
    private final boolean zzi;

    zzell(Context context, zzduy zzduy, zzfef zzfef, zzcgv zzcgv, zzfdk zzfdk, zzfzp zzfzp, zzcmp zzcmp, zzbpx zzbpx, boolean z) {
        this.zza = context;
        this.zzb = zzduy;
        this.zzc = zzfef;
        this.zzd = zzcgv;
        this.zze = zzfdk;
        this.zzf = zzfzp;
        this.zzg = zzcmp;
        this.zzh = zzbpx;
        this.zzi = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r22, android.content.Context r23, com.google.android.gms.internal.ads.zzddn r24) {
        /*
            r21 = this;
            r1 = r21
            com.google.android.gms.internal.ads.zzfzp r0 = r1.zzf
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzfzg.zzq(r0)
            com.google.android.gms.internal.ads.zzdud r0 = (com.google.android.gms.internal.ads.zzdud) r0
            com.google.android.gms.internal.ads.zzfdk r2 = r1.zze     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzcmp r3 = r1.zzg     // Catch:{ zzcna -> 0x00f8 }
            boolean r3 = r3.zzaD()     // Catch:{ zzcna -> 0x00f8 }
            r4 = 1
            if (r3 != 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzcmp r2 = r1.zzg     // Catch:{ zzcna -> 0x00f8 }
        L_0x0017:
            r11 = r2
            goto L_0x007e
        L_0x0019:
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzaG     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzbja r5 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ zzcna -> 0x00f8 }
            java.lang.Object r3 = r5.zzb(r3)     // Catch:{ zzcna -> 0x00f8 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzcna -> 0x00f8 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzcna -> 0x00f8 }
            if (r3 != 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzcmp r2 = r1.zzg     // Catch:{ zzcna -> 0x00f8 }
            goto L_0x0017
        L_0x002e:
            com.google.android.gms.internal.ads.zzduy r3 = r1.zzb     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzfef r5 = r1.zzc     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.ads.internal.client.zzq r5 = r5.zze     // Catch:{ zzcna -> 0x00f8 }
            r6 = 0
            com.google.android.gms.internal.ads.zzcmp r3 = r3.zza(r5, r6, r6)     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzdkw r5 = r0.zzg()     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzbql.zzb(r3, r5)     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzdvc r5 = new com.google.android.gms.internal.ads.zzdvc     // Catch:{ zzcna -> 0x00f8 }
            r5.<init>()     // Catch:{ zzcna -> 0x00f8 }
            android.content.Context r7 = r1.zza     // Catch:{ zzcna -> 0x00f8 }
            r8 = r3
            android.view.View r8 = (android.view.View) r8     // Catch:{ zzcna -> 0x00f8 }
            r5.zza(r7, r8)     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzdux r7 = r0.zzl()     // Catch:{ zzcna -> 0x00f8 }
            boolean r8 = r1.zzi     // Catch:{ zzcna -> 0x00f8 }
            if (r8 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzbpx r8 = r1.zzh     // Catch:{ zzcna -> 0x00f8 }
            goto L_0x0059
        L_0x0058:
            r8 = r6
        L_0x0059:
            r7.zzi(r3, r4, r8)     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzcoc r7 = r3.zzP()     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzelj r8 = new com.google.android.gms.internal.ads.zzelj     // Catch:{ zzcna -> 0x00f8 }
            r8.<init>(r5, r3)     // Catch:{ zzcna -> 0x00f8 }
            r7.zzz(r8)     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzcoc r5 = r3.zzP()     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzelk r7 = new com.google.android.gms.internal.ads.zzelk     // Catch:{ zzcna -> 0x00f8 }
            r7.<init>(r3)     // Catch:{ zzcna -> 0x00f8 }
            r5.zzF(r7)     // Catch:{ zzcna -> 0x00f8 }
            com.google.android.gms.internal.ads.zzfdp r2 = r2.zzt     // Catch:{ zzcna -> 0x00f8 }
            java.lang.String r5 = r2.zzb     // Catch:{ zzcna -> 0x00f8 }
            java.lang.String r2 = r2.zza     // Catch:{ zzcna -> 0x00f8 }
            r3.zzad(r5, r2, r6)     // Catch:{ zzcna -> 0x00f8 }
            r11 = r3
        L_0x007e:
            r11.zzap(r4)
            com.google.android.gms.ads.internal.zzj r2 = new com.google.android.gms.ads.internal.zzj
            boolean r3 = r1.zzi
            r5 = 0
            if (r3 == 0) goto L_0x0090
            com.google.android.gms.internal.ads.zzbpx r3 = r1.zzh
            boolean r3 = r3.zze(r5)
            r13 = r3
            goto L_0x0091
        L_0x0090:
            r13 = r5
        L_0x0091:
            com.google.android.gms.ads.internal.zzt.zzp()
            android.content.Context r3 = r1.zza
            boolean r14 = com.google.android.gms.ads.internal.util.zzs.zzE(r3)
            boolean r3 = r1.zzi
            if (r3 == 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzbpx r5 = r1.zzh
            boolean r5 = r5.zzd()
        L_0x00a4:
            r15 = r5
            if (r3 == 0) goto L_0x00ae
            com.google.android.gms.internal.ads.zzbpx r3 = r1.zzh
            float r3 = r3.zza()
            goto L_0x00af
        L_0x00ae:
            r3 = 0
        L_0x00af:
            r16 = r3
            com.google.android.gms.internal.ads.zzfdk r3 = r1.zze
            r17 = -1
            boolean r5 = r3.zzP
            boolean r3 = r3.zzQ
            r12 = r2
            r18 = r22
            r19 = r5
            r20 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            if (r24 == 0) goto L_0x00c8
            r24.zzf()
        L_0x00c8:
            com.google.android.gms.ads.internal.zzt.zzi()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzdme r9 = r0.zzj()
            com.google.android.gms.internal.ads.zzfdk r0 = r1.zze
            int r12 = r0.zzR
            com.google.android.gms.internal.ads.zzcgv r13 = r1.zzd
            java.lang.String r14 = r0.zzC
            com.google.android.gms.internal.ads.zzfdp r0 = r0.zzt
            r8 = 0
            r10 = 0
            java.lang.String r5 = r0.zzb
            java.lang.String r0 = r0.zza
            com.google.android.gms.internal.ads.zzfef r6 = r1.zzc
            java.lang.String r6 = r6.zzf
            r7 = r3
            r15 = r2
            r16 = r5
            r17 = r0
            r18 = r6
            r19 = r24
            r7.<init>((com.google.android.gms.ads.internal.client.zza) r8, (com.google.android.gms.ads.internal.overlay.zzo) r9, (com.google.android.gms.ads.internal.overlay.zzz) r10, (com.google.android.gms.internal.ads.zzcmp) r11, (int) r12, (com.google.android.gms.internal.ads.zzcgv) r13, (java.lang.String) r14, (com.google.android.gms.ads.internal.zzj) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (com.google.android.gms.internal.ads.zzddn) r19)
            r0 = r23
            com.google.android.gms.ads.internal.overlay.zzm.zza(r0, r3, r4)
            return
        L_0x00f8:
            r0 = move-exception
            java.lang.String r2 = ""
            com.google.android.gms.internal.ads.zzcgp.zzh(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzell.zza(boolean, android.content.Context, com.google.android.gms.internal.ads.zzddn):void");
    }
}
