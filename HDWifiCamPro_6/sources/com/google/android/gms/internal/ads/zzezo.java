package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbf;
import com.google.android.gms.ads.internal.client.zzbi;
import com.google.android.gms.ads.internal.client.zzbr;
import com.google.android.gms.ads.internal.client.zzbw;
import com.google.android.gms.ads.internal.client.zzbz;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzcg;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzdo;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzezo extends zzbr implements zzo, zzbdd {
    protected zzcwv zza;
    private final zzcom zzb;
    private final Context zzc;
    private AtomicBoolean zzd = new AtomicBoolean();
    private final String zze;
    private final zzezi zzf;
    /* access modifiers changed from: private */
    public final zzezg zzg;
    private final zzcgv zzh;
    private long zzi = -1;
    private zzcvw zzj;

    public zzezo(zzcom zzcom, Context context, String str, zzezi zzezi, zzezg zzezg, zzcgv zzcgv) {
        this.zzb = zzcom;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzezi;
        this.zzg = zzezg;
        this.zzh = zzcgv;
        zzezg.zzo(this);
    }

    private final synchronized void zzp(int i) {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzg.zzj();
            zzcvw zzcvw = this.zzj;
            if (zzcvw != null) {
                zzt.zzb().zze(zzcvw);
            }
            if (this.zza != null) {
                long j = -1;
                if (this.zzi != -1) {
                    j = zzt.zzB().elapsedRealtime() - this.zzi;
                }
                this.zza.zze(j, i);
            }
            zzx();
        }
    }

    public final synchronized void zzA() {
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzC(zzbc zzbc) {
    }

    public final void zzD(zzbf zzbf) {
    }

    public final void zzE(zzbw zzbw) {
    }

    public final synchronized void zzF(zzq zzq) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final void zzG(zzbz zzbz) {
    }

    public final void zzH(zzbdm zzbdm) {
        this.zzg.zzr(zzbdm);
    }

    public final void zzI(zzw zzw) {
        this.zzf.zzl(zzw);
    }

    public final void zzJ(zzcg zzcg) {
    }

    public final void zzK(zzdo zzdo) {
    }

    public final void zzL(boolean z) {
    }

    public final void zzM(zzbzl zzbzl) {
    }

    public final synchronized void zzN(boolean z) {
    }

    public final synchronized void zzO(zzbjx zzbjx) {
    }

    public final void zzP(zzde zzde) {
    }

    public final void zzQ(zzbzo zzbzo, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzcby zzcby) {
    }

    public final void zzT(String str) {
    }

    public final synchronized void zzU(zzff zzff) {
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final synchronized void zzX() {
    }

    public final synchronized boolean zzY() {
        return this.zzf.zza();
    }

    public final boolean zzZ() {
        return false;
    }

    public final void zza() {
        zzp(3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c A[SYNTHETIC, Splitter:B:25:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzaa(com.google.android.gms.ads.internal.client.zzl r6) throws android.os.RemoteException {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzbke r0 = com.google.android.gms.internal.ads.zzbkq.zzd     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x0087 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0087 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0087 }
            r1 = 0
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zziM     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ all -> 0x0087 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0087 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            com.google.android.gms.internal.ads.zzcgv r2 = r5.zzh     // Catch:{ all -> 0x0087 }
            int r2 = r2.zzc     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zziN     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0087 }
            java.lang.Object r3 = r4.zzb(r3)     // Catch:{ all -> 0x0087 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0087 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0087 }
            if (r2 < r3) goto L_0x003d
            if (r0 != 0) goto L_0x0042
        L_0x003d:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0087 }
        L_0x0042:
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0087 }
            android.content.Context r0 = r5.zzc     // Catch:{ all -> 0x0087 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.zzD(r0)     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0064
            com.google.android.gms.ads.internal.client.zzc r0 = r6.zzs     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0052
            goto L_0x0064
        L_0x0052:
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.zze.zzg(r6)     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzezg r6 = r5.zzg     // Catch:{ all -> 0x0087 }
            r0 = 4
            r2 = 0
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzffe.zzd(r0, r2, r2)     // Catch:{ all -> 0x0087 }
            r6.zza(r0)     // Catch:{ all -> 0x0087 }
            monitor-exit(r5)
            return r1
        L_0x0064:
            boolean r0 = r5.zzY()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x006c
            monitor-exit(r5)
            return r1
        L_0x006c:
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ all -> 0x0087 }
            r0.<init>()     // Catch:{ all -> 0x0087 }
            r5.zzd = r0     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzezm r0 = new com.google.android.gms.internal.ads.zzezm     // Catch:{ all -> 0x0087 }
            r0.<init>(r5)     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzezi r1 = r5.zzf     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r5.zze     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzezn r3 = new com.google.android.gms.internal.ads.zzezn     // Catch:{ all -> 0x0087 }
            r3.<init>(r5)     // Catch:{ all -> 0x0087 }
            boolean r6 = r1.zzb(r6, r2, r0, r3)     // Catch:{ all -> 0x0087 }
            monitor-exit(r5)
            return r6
        L_0x0087:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzezo.zzaa(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    public final synchronized void zzab(zzcd zzcd) {
    }

    public final synchronized void zzb() {
        if (this.zza != null) {
            this.zzi = zzt.zzB().elapsedRealtime();
            int zza2 = this.zza.zza();
            if (zza2 > 0) {
                this.zzj = new zzcvw(this.zzb.zzB(), zzt.zzB());
                this.zzj.zzd(zza2, new zzezl(this));
            }
        }
    }

    public final void zzbC() {
    }

    public final void zzbK() {
    }

    public final void zzbr() {
    }

    public final Bundle zzd() {
        return new Bundle();
    }

    public final synchronized void zze() {
        zzcwv zzcwv = this.zza;
        if (zzcwv != null) {
            zzcwv.zze(zzt.zzB().elapsedRealtime() - this.zzi, 1);
        }
    }

    public final synchronized zzq zzg() {
        return null;
    }

    public final zzbf zzi() {
        return null;
    }

    public final zzbz zzj() {
        return null;
    }

    public final synchronized zzdh zzk() {
        return null;
    }

    public final synchronized zzdk zzl() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        zzp(5);
    }

    public final IObjectWrapper zzn() {
        return null;
    }

    public final void zzo() {
        this.zzb.zzA().execute(new zzezk(this));
    }

    public final synchronized String zzr() {
        return this.zze;
    }

    public final synchronized String zzs() {
        return null;
    }

    public final synchronized String zzt() {
        return null;
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcwv zzcwv = this.zza;
        if (zzcwv != null) {
            zzcwv.zzV();
        }
    }

    public final void zzy(zzl zzl, zzbi zzbi) {
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final void zzf(int i) {
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        } else if (i2 == 0) {
            zzp(2);
        } else if (i2 == 1) {
            zzp(4);
        } else if (i2 == 2) {
            zzp(3);
        } else if (i2 == 3) {
            zzp(6);
        }
    }
}
