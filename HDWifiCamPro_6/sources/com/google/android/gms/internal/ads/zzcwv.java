package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcwv extends zzcze {
    private final zzcmp zzc;
    private final int zzd;
    private final Context zze;
    private final zzcwd zzf;
    private final zzdmp zzg;
    private final zzdjw zzh;
    private final zzddn zzi;
    private final boolean zzj;
    private boolean zzk = false;

    zzcwv(zzczd zzczd, Context context, zzcmp zzcmp, int i, zzcwd zzcwd, zzdmp zzdmp, zzdjw zzdjw, zzddn zzddn) {
        super(zzczd);
        this.zzc = zzcmp;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcwd;
        this.zzg = zzdmp;
        this.zzh = zzdjw;
        this.zzi = zzddn;
        this.zzj = ((Boolean) zzay.zzc().zzb(zzbjc.zzet)).booleanValue();
    }

    public final void zzV() {
        super.zzV();
        zzcmp zzcmp = this.zzc;
        if (zzcmp != null) {
            zzcmp.destroy();
        }
    }

    public final int zza() {
        return this.zzd;
    }

    public final void zzc(zzbdd zzbdd) {
        zzcmp zzcmp = this.zzc;
        if (zzcmp != null) {
            zzcmp.zzaj(zzbdd);
        }
    }

    /* JADX WARNING: type inference failed for: r3v11, types: [android.content.Context] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.app.Activity r3, com.google.android.gms.internal.ads.zzbdq r4, boolean r5) throws android.os.RemoteException {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0004
            android.content.Context r3 = r2.zze
        L_0x0004:
            boolean r4 = r2.zzj
            if (r4 == 0) goto L_0x000d
            com.google.android.gms.internal.ads.zzdjw r4 = r2.zzh
            r4.zzb()
        L_0x000d:
            com.google.android.gms.internal.ads.zzbiu r4 = com.google.android.gms.internal.ads.zzbjc.zzay
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r4 = r0.zzb(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0061
            com.google.android.gms.ads.internal.zzt.zzp()
            boolean r4 = com.google.android.gms.ads.internal.util.zzs.zzC(r3)
            if (r4 == 0) goto L_0x0061
            java.lang.String r4 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.zze.zzj(r4)
            com.google.android.gms.internal.ads.zzddn r4 = r2.zzi
            r4.zzb()
            com.google.android.gms.internal.ads.zzbiu r4 = com.google.android.gms.internal.ads.zzbjc.zzaz
            com.google.android.gms.internal.ads.zzbja r5 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r4 = r5.zzb(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0094
            com.google.android.gms.internal.ads.zzfni r4 = new com.google.android.gms.internal.ads.zzfni
            android.content.Context r3 = r3.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbv r5 = com.google.android.gms.ads.internal.zzt.zzt()
            android.os.Looper r5 = r5.zzb()
            r4.<init>(r3, r5)
            com.google.android.gms.internal.ads.zzfdw r3 = r2.zza
            com.google.android.gms.internal.ads.zzfdv r3 = r3.zzb
            com.google.android.gms.internal.ads.zzfdn r3 = r3.zzb
            java.lang.String r3 = r3.zzb
            r4.zza(r3)
            return
        L_0x0061:
            boolean r4 = r2.zzk
            if (r4 == 0) goto L_0x0076
            java.lang.String r4 = "App open interstitial ad is already visible."
            com.google.android.gms.ads.internal.util.zze.zzj(r4)
            com.google.android.gms.internal.ads.zzddn r4 = r2.zzi
            r0 = 10
            r1 = 0
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzffe.zzd(r0, r1, r1)
            r4.zza(r0)
        L_0x0076:
            boolean r4 = r2.zzk
            if (r4 != 0) goto L_0x0094
            com.google.android.gms.internal.ads.zzdmp r4 = r2.zzg     // Catch:{ zzdmo -> 0x008e }
            com.google.android.gms.internal.ads.zzddn r0 = r2.zzi     // Catch:{ zzdmo -> 0x008e }
            r4.zza(r5, r3, r0)     // Catch:{ zzdmo -> 0x008e }
            boolean r3 = r2.zzj     // Catch:{ zzdmo -> 0x008e }
            if (r3 == 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzdjw r3 = r2.zzh     // Catch:{ zzdmo -> 0x008e }
            r3.zza()     // Catch:{ zzdmo -> 0x008e }
        L_0x008a:
            r3 = 1
            r2.zzk = r3
            return
        L_0x008e:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzddn r4 = r2.zzi
            r4.zzc(r3)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcwv.zzd(android.app.Activity, com.google.android.gms.internal.ads.zzbdq, boolean):void");
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
