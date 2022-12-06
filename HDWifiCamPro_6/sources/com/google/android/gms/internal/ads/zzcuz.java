package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcuz implements zzdda, zzdeo, zzddu, zza, zzddq {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    /* access modifiers changed from: private */
    public final zzfdw zze;
    /* access modifiers changed from: private */
    public final zzfdk zzf;
    /* access modifiers changed from: private */
    public final zzfki zzg;
    /* access modifiers changed from: private */
    public final zzfeo zzh;
    private final zzape zzi;
    private final zzbkb zzj;
    private final zzfju zzk;
    private final WeakReference zzl;
    private final WeakReference zzm;
    private boolean zzn;
    private final AtomicBoolean zzo = new AtomicBoolean();
    private final zzbkd zzp;

    zzcuz(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfdw zzfdw, zzfdk zzfdk, zzfki zzfki, zzfeo zzfeo, View view, zzcmp zzcmp, zzape zzape, zzbkb zzbkb, zzbkd zzbkd, zzfju zzfju, byte[] bArr) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfdw;
        this.zzf = zzfdk;
        this.zzg = zzfki;
        this.zzh = zzfeo;
        this.zzi = zzape;
        this.zzl = new WeakReference(view);
        this.zzm = new WeakReference(zzcmp);
        this.zzj = zzbkb;
        this.zzp = zzbkd;
        this.zzk = zzfju;
    }

    /* access modifiers changed from: private */
    public final void zzs() {
        int i;
        String zzh2 = ((Boolean) zzay.zzc().zzb(zzbjc.zzcI)).booleanValue() ? this.zzi.zzc().zzh(this.zza, (View) this.zzl.get(), (Activity) null) : null;
        if ((!((Boolean) zzay.zzc().zzb(zzbjc.zzal)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbkr.zzh.zze()).booleanValue()) {
            if (((Boolean) zzbkr.zzg.zze()).booleanValue() && ((i = this.zzf.zzb) == 1 || i == 2 || i == 5)) {
                zzcmp zzcmp = (zzcmp) this.zzm.get();
            }
            zzfzg.zzr((zzfyx) zzfzg.zzo(zzfyx.zzv(zzfzg.zzi((Object) null)), ((Long) zzay.zzc().zzb(zzbjc.zzaP)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcuy(this, zzh2), this.zzb);
            return;
        }
        zzfeo zzfeo = this.zzh;
        zzfki zzfki = this.zzg;
        zzfdw zzfdw = this.zze;
        zzfdk zzfdk = this.zzf;
        zzfeo.zza(zzfki.zzd(zzfdw, zzfdk, false, zzh2, (String) null, zzfdk.zzd));
    }

    private final void zzt(int i, int i2) {
        View view;
        if (i <= 0 || !((view = (View) this.zzl.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzs();
        } else {
            this.zzd.schedule(new zzcus(this, i, i2), (long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public final void onAdClicked() {
        if ((!((Boolean) zzay.zzc().zzb(zzbjc.zzal)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbkr.zzd.zze()).booleanValue()) {
            zzfzg.zzr(zzfzg.zzf(zzfyx.zzv(this.zzj.zza()), Throwable.class, zzcut.zza, zzchc.zzf), new zzcux(this), this.zzb);
            return;
        }
        zzfeo zzfeo = this.zzh;
        zzfki zzfki = this.zzg;
        zzfdw zzfdw = this.zze;
        zzfdk zzfdk = this.zzf;
        List zzc2 = zzfki.zzc(zzfdw, zzfdk, zzfdk.zzc);
        int i = 1;
        if (true == zzt.zzo().zzv(this.zza)) {
            i = 2;
        }
        zzfeo.zzc(zzc2, i);
    }

    public final void zzbv() {
        zzfeo zzfeo = this.zzh;
        zzfki zzfki = this.zzg;
        zzfdw zzfdw = this.zze;
        zzfdk zzfdk = this.zzf;
        zzfeo.zza(zzfki.zzc(zzfdw, zzfdk, zzfdk.zzj));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzb.execute(new zzcuw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(int i, int i2) {
        zzt(i - 1, i2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(int i, int i2) {
        this.zzb.execute(new zzcuu(this, i, i2));
    }

    public final void zzj() {
    }

    public final void zzk(zze zze2) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbo)).booleanValue()) {
            this.zzh.zza(this.zzg.zzc(this.zze, this.zzf, zzfki.zzf(2, zze2.zza, this.zzf.zzp)));
        }
    }

    public final void zzl() {
        if (this.zzo.compareAndSet(false, true)) {
            int intValue = ((Integer) zzay.zzc().zzb(zzbjc.zzcM)).intValue();
            if (intValue > 0) {
                zzt(intValue, ((Integer) zzay.zzc().zzb(zzbjc.zzcN)).intValue());
                return;
            }
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzcL)).booleanValue()) {
                this.zzc.execute(new zzcuv(this));
            } else {
                zzs();
            }
        }
    }

    public final void zzm() {
    }

    public final synchronized void zzn() {
        if (this.zzn) {
            ArrayList arrayList = new ArrayList(this.zzf.zzd);
            arrayList.addAll(this.zzf.zzg);
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, true, (String) null, (String) null, arrayList));
        } else {
            zzfeo zzfeo = this.zzh;
            zzfki zzfki = this.zzg;
            zzfdw zzfdw = this.zze;
            zzfdk zzfdk = this.zzf;
            zzfeo.zza(zzfki.zzc(zzfdw, zzfdk, zzfdk.zzn));
            zzfeo zzfeo2 = this.zzh;
            zzfki zzfki2 = this.zzg;
            zzfdw zzfdw2 = this.zze;
            zzfdk zzfdk2 = this.zzf;
            zzfeo2.zza(zzfki2.zzc(zzfdw2, zzfdk2, zzfdk2.zzg));
        }
        this.zzn = true;
    }

    public final void zzo() {
    }

    public final void zzp(zzcbs zzcbs, String str, String str2) {
        zzfeo zzfeo = this.zzh;
        zzfki zzfki = this.zzg;
        zzfdk zzfdk = this.zzf;
        zzfeo.zza(zzfki.zze(zzfdk, zzfdk.zzi, zzcbs));
    }

    public final void zzr() {
        zzfeo zzfeo = this.zzh;
        zzfki zzfki = this.zzg;
        zzfdw zzfdw = this.zze;
        zzfdk zzfdk = this.zzf;
        zzfeo.zza(zzfki.zzc(zzfdw, zzfdk, zzfdk.zzh));
    }
}
