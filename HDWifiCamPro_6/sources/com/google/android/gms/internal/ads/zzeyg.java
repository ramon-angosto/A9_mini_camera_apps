package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
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
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.overlay.zzad;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeyg extends zzbr implements zzad, zzbdd, zzdez {
    protected zzcwl zza;
    private final zzcom zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final ViewGroup zzd;
    private AtomicBoolean zze = new AtomicBoolean();
    private final String zzf;
    private final zzeya zzg;
    /* access modifiers changed from: private */
    public final zzezg zzh;
    /* access modifiers changed from: private */
    public final zzcgv zzi;
    private long zzj = -1;
    private zzcvw zzk;

    public zzeyg(zzcom zzcom, Context context, String str, zzeya zzeya, zzezg zzezg, zzcgv zzcgv) {
        this.zzd = new FrameLayout(context);
        this.zzb = zzcom;
        this.zzc = context;
        this.zzf = str;
        this.zzg = zzeya;
        this.zzh = zzezg;
        zzezg.zzn(this);
        this.zzi = zzcgv;
    }

    static /* bridge */ /* synthetic */ zzr zze(zzeyg zzeyg, zzcwl zzcwl) {
        boolean zzh2 = zzcwl.zzh();
        int intValue = ((Integer) zzay.zzc().zzb(zzbjc.zzdZ)).intValue();
        zzq zzq = new zzq();
        zzq.zzd = 50;
        int i = 0;
        zzq.zza = true != zzh2 ? 0 : intValue;
        if (true != zzh2) {
            i = intValue;
        }
        zzq.zzb = i;
        zzq.zzc = intValue;
        return new zzr(zzeyg.zzc, zzq, zzeyg);
    }

    private final synchronized void zzq(int i) {
        if (this.zze.compareAndSet(false, true)) {
            zzcwl zzcwl = this.zza;
            if (!(zzcwl == null || zzcwl.zzj() == null)) {
                this.zzh.zzt(zzcwl.zzj());
            }
            this.zzh.zzj();
            this.zzd.removeAllViews();
            zzcvw zzcvw = this.zzk;
            if (zzcvw != null) {
                zzt.zzb().zze(zzcvw);
            }
            if (this.zza != null) {
                long j = -1;
                if (this.zzj != -1) {
                    j = zzt.zzB().elapsedRealtime() - this.zzj;
                }
                this.zza.zzi(j, i);
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

    public final synchronized void zzF(com.google.android.gms.ads.internal.client.zzq zzq) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final void zzG(zzbz zzbz) {
    }

    public final void zzH(zzbdm zzbdm) {
        this.zzh.zzr(zzbdm);
    }

    public final void zzI(zzw zzw) {
        this.zzg.zzl(zzw);
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

    public final void zzX() {
    }

    public final synchronized boolean zzY() {
        return this.zzg.zza();
    }

    public final boolean zzZ() {
        return false;
    }

    public final void zza() {
        zzq(3);
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
            com.google.android.gms.internal.ads.zzcgv r2 = r5.zzi     // Catch:{ all -> 0x0087 }
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
            com.google.android.gms.internal.ads.zzezg r6 = r5.zzh     // Catch:{ all -> 0x0087 }
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
            r5.zze = r0     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzeye r0 = new com.google.android.gms.internal.ads.zzeye     // Catch:{ all -> 0x0087 }
            r0.<init>(r5)     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzeya r1 = r5.zzg     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r5.zzf     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzeyf r3 = new com.google.android.gms.internal.ads.zzeyf     // Catch:{ all -> 0x0087 }
            r3.<init>(r5)     // Catch:{ all -> 0x0087 }
            boolean r6 = r1.zzb(r6, r2, r0, r3)     // Catch:{ all -> 0x0087 }
            monitor-exit(r5)
            return r6
        L_0x0087:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyg.zzaa(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    public final synchronized void zzab(zzcd zzcd) {
    }

    public final void zzbJ() {
        zzq(4);
    }

    public final Bundle zzd() {
        return new Bundle();
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzq zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcwl zzcwl = this.zza;
        if (zzcwl == null) {
            return null;
        }
        return zzfej.zza(this.zzc, Collections.singletonList(zzcwl.zzc()));
    }

    public final void zzh() {
        if (this.zza != null) {
            this.zzj = zzt.zzB().elapsedRealtime();
            int zza2 = this.zza.zza();
            if (zza2 > 0) {
                this.zzk = new zzcvw(this.zzb.zzB(), zzt.zzB());
                this.zzk.zzd(zza2, new zzeyd(this));
            }
        }
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

    public final IObjectWrapper zzn() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo() {
        zzq(5);
    }

    public final void zzp() {
        zzaw.zzb();
        if (zzcgi.zzt()) {
            zzq(5);
        } else {
            this.zzb.zzA().execute(new zzeyc(this));
        }
    }

    public final synchronized String zzr() {
        return this.zzf;
    }

    public final synchronized String zzs() {
        return null;
    }

    public final synchronized String zzt() {
        return null;
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcwl zzcwl = this.zza;
        if (zzcwl != null) {
            zzcwl.zzV();
        }
    }

    public final void zzy(zzl zzl, zzbi zzbi) {
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }
}
