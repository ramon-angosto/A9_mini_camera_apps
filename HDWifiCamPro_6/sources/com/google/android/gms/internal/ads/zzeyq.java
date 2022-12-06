package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzw;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzeyq implements zzeov {
    protected final zzcom zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public final zzezg zzd;
    /* access modifiers changed from: private */
    public final zzfaz zze;
    private final zzcgv zzf;
    private final ViewGroup zzg;
    /* access modifiers changed from: private */
    public final zzfjw zzh;
    private final zzfed zzi;
    /* access modifiers changed from: private */
    @Nullable
    public zzfzp zzj;

    protected zzeyq(Context context, Executor executor, zzcom zzcom, zzfaz zzfaz, zzezg zzezg, zzfed zzfed, zzcgv zzcgv) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcom;
        this.zze = zzfaz;
        this.zzd = zzezg;
        this.zzi = zzfed;
        this.zzf = zzcgv;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcom.zzy();
    }

    /* access modifiers changed from: private */
    public final synchronized zzdci zzm(zzfax zzfax) {
        zzeyp zzeyp = (zzeyp) zzfax;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgZ)).booleanValue()) {
            zzcwz zzcwz = new zzcwz(this.zzg);
            zzdck zzdck = new zzdck();
            zzdck.zzc(this.zzb);
            zzdck.zzf(zzeyp.zza);
            zzdcm zzg2 = zzdck.zzg();
            zzdik zzdik = new zzdik();
            zzdik.zzc(this.zzd, this.zzc);
            zzdik.zzl(this.zzd, this.zzc);
            return zzc(zzcwz, zzg2, zzdik.zzn());
        }
        zzezg zzi2 = zzezg.zzi(this.zzd);
        zzdik zzdik2 = new zzdik();
        zzdik2.zzb(zzi2, this.zzc);
        zzdik2.zzg(zzi2, this.zzc);
        zzdik2.zzh(zzi2, this.zzc);
        zzdik2.zzi(zzi2, this.zzc);
        zzdik2.zzc(zzi2, this.zzc);
        zzdik2.zzl(zzi2, this.zzc);
        zzdik2.zzm(zzi2);
        zzcwz zzcwz2 = new zzcwz(this.zzg);
        zzdck zzdck2 = new zzdck();
        zzdck2.zzc(this.zzb);
        zzdck2.zzf(zzeyp.zza);
        return zzc(zzcwz2, zzdck2.zzg(), zzdik2.zzn());
    }

    public final boolean zza() {
        zzfzp zzfzp = this.zzj;
        return zzfzp != null && !zzfzp.isDone();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[SYNTHETIC, Splitter:B:16:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzb(com.google.android.gms.ads.internal.client.zzl r8, java.lang.String r9, com.google.android.gms.internal.ads.zzeot r10, com.google.android.gms.internal.ads.zzeou r11) throws android.os.RemoteException {
        /*
            r7 = this;
            monitor-enter(r7)
            com.google.android.gms.internal.ads.zzbke r10 = com.google.android.gms.internal.ads.zzbkq.zzd     // Catch:{ all -> 0x00f6 }
            java.lang.Object r10 = r10.zze()     // Catch:{ all -> 0x00f6 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00f6 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00f6 }
            r0 = 1
            r1 = 0
            if (r10 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzbiu r10 = com.google.android.gms.internal.ads.zzbjc.zziM     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x00f6 }
            java.lang.Object r10 = r2.zzb(r10)     // Catch:{ all -> 0x00f6 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00f6 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00f6 }
            if (r10 == 0) goto L_0x0025
            r10 = r0
            goto L_0x0026
        L_0x0025:
            r10 = r1
        L_0x0026:
            com.google.android.gms.internal.ads.zzcgv r2 = r7.zzf     // Catch:{ all -> 0x00f6 }
            int r2 = r2.zzc     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zziN     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x00f6 }
            java.lang.Object r3 = r4.zzb(r3)     // Catch:{ all -> 0x00f6 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x00f6 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x00f6 }
            if (r2 < r3) goto L_0x003e
            if (r10 != 0) goto L_0x0043
        L_0x003e:
            java.lang.String r10 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r10)     // Catch:{ all -> 0x00f6 }
        L_0x0043:
            if (r9 != 0) goto L_0x0056
            java.lang.String r8 = "Ad unit ID should not be null for app open ad."
            com.google.android.gms.ads.internal.util.zze.zzg(r8)     // Catch:{ all -> 0x00f6 }
            java.util.concurrent.Executor r8 = r7.zzc     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzeyk r9 = new com.google.android.gms.internal.ads.zzeyk     // Catch:{ all -> 0x00f6 }
            r9.<init>(r7)     // Catch:{ all -> 0x00f6 }
            r8.execute(r9)     // Catch:{ all -> 0x00f6 }
            monitor-exit(r7)
            return r1
        L_0x0056:
            com.google.android.gms.internal.ads.zzfzp r10 = r7.zzj     // Catch:{ all -> 0x00f6 }
            if (r10 == 0) goto L_0x005c
            monitor-exit(r7)
            return r1
        L_0x005c:
            com.google.android.gms.internal.ads.zzbke r10 = com.google.android.gms.internal.ads.zzbkl.zzc     // Catch:{ all -> 0x00f6 }
            java.lang.Object r10 = r10.zze()     // Catch:{ all -> 0x00f6 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00f6 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00f6 }
            r1 = 7
            r2 = 0
            if (r10 == 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzfaz r10 = r7.zze     // Catch:{ all -> 0x00f6 }
            java.lang.Object r3 = r10.zzd()     // Catch:{ all -> 0x00f6 }
            if (r3 == 0) goto L_0x0088
            java.lang.Object r10 = r10.zzd()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzcwk r10 = (com.google.android.gms.internal.ads.zzcwk) r10     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzfju r10 = r10.zzh()     // Catch:{ all -> 0x00f6 }
            r10.zzh(r1)     // Catch:{ all -> 0x00f6 }
            java.lang.String r3 = r8.zzp     // Catch:{ all -> 0x00f6 }
            r10.zzb(r3)     // Catch:{ all -> 0x00f6 }
            r4 = r10
            goto L_0x0089
        L_0x0088:
            r4 = r2
        L_0x0089:
            android.content.Context r10 = r7.zzb     // Catch:{ all -> 0x00f6 }
            boolean r3 = r8.zzf     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzfez.zza(r10, r3)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzbiu r10 = com.google.android.gms.internal.ads.zzbjc.zzhE     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x00f6 }
            java.lang.Object r10 = r3.zzb(r10)     // Catch:{ all -> 0x00f6 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00f6 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00f6 }
            if (r10 == 0) goto L_0x00af
            boolean r10 = r8.zzf     // Catch:{ all -> 0x00f6 }
            if (r10 == 0) goto L_0x00af
            com.google.android.gms.internal.ads.zzcom r10 = r7.zza     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzeak r10 = r10.zzk()     // Catch:{ all -> 0x00f6 }
            r10.zzm(r0)     // Catch:{ all -> 0x00f6 }
        L_0x00af:
            com.google.android.gms.internal.ads.zzfed r10 = r7.zzi     // Catch:{ all -> 0x00f6 }
            r10.zzs(r9)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.ads.internal.client.zzq r9 = com.google.android.gms.ads.internal.client.zzq.zzb()     // Catch:{ all -> 0x00f6 }
            r10.zzr(r9)     // Catch:{ all -> 0x00f6 }
            r10.zzE(r8)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzfef r9 = r10.zzG()     // Catch:{ all -> 0x00f6 }
            android.content.Context r10 = r7.zzb     // Catch:{ all -> 0x00f6 }
            int r3 = com.google.android.gms.internal.ads.zzfjt.zzf(r9)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzfjj r5 = com.google.android.gms.internal.ads.zzfji.zzb(r10, r3, r1, r8)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzeyp r6 = new com.google.android.gms.internal.ads.zzeyp     // Catch:{ all -> 0x00f6 }
            r6.<init>(r2)     // Catch:{ all -> 0x00f6 }
            r6.zza = r9     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzfaz r8 = r7.zze     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzfba r9 = new com.google.android.gms.internal.ads.zzfba     // Catch:{ all -> 0x00f6 }
            r9.<init>(r6, r2)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzeyl r10 = new com.google.android.gms.internal.ads.zzeyl     // Catch:{ all -> 0x00f6 }
            r10.<init>(r7)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzfzp r8 = r8.zzc(r9, r10, r2)     // Catch:{ all -> 0x00f6 }
            r7.zzj = r8     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzfzp r8 = r7.zzj     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzeyn r9 = new com.google.android.gms.internal.ads.zzeyn     // Catch:{ all -> 0x00f6 }
            r1 = r9
            r2 = r7
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00f6 }
            java.util.concurrent.Executor r10 = r7.zzc     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.ads.zzfzg.zzr(r8, r9, r10)     // Catch:{ all -> 0x00f6 }
            monitor-exit(r7)
            return r0
        L_0x00f6:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyq.zzb(com.google.android.gms.ads.internal.client.zzl, java.lang.String, com.google.android.gms.internal.ads.zzeot, com.google.android.gms.internal.ads.zzeou):boolean");
    }

    /* access modifiers changed from: protected */
    public abstract zzdci zzc(zzcwz zzcwz, zzdcm zzdcm, zzdim zzdim);

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        this.zzd.zza(zzffe.zzd(6, (String) null, (zze) null));
    }

    public final void zzl(zzw zzw) {
        this.zzi.zzt(zzw);
    }
}
