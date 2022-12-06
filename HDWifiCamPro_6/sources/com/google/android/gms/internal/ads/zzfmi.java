package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfmi implements zzfln {
    private static final zzfmi zza = new zzfmi();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler zzc = null;
    /* access modifiers changed from: private */
    public static final Runnable zzd = new zzfme();
    /* access modifiers changed from: private */
    public static final Runnable zze = new zzfmf();
    private final List zzf = new ArrayList();
    private int zzg;
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzflp zzj = new zzflp();
    private final zzfmb zzk = new zzfmb();
    /* access modifiers changed from: private */
    public final zzfmc zzl = new zzfmc(new zzfml());
    private long zzm;

    zzfmi() {
    }

    public static zzfmi zzd() {
        return zza;
    }

    static /* bridge */ /* synthetic */ void zzg(zzfmi zzfmi) {
        zzfmi.zzg = 0;
        zzfmi.zzi.clear();
        zzfmi.zzh = false;
        for (zzfkv zzfkv : zzflg.zza().zzb()) {
        }
        zzfmi.zzm = System.nanoTime();
        zzfmi.zzk.zzi();
        long nanoTime = System.nanoTime();
        zzflo zza2 = zzfmi.zzj.zza();
        if (zzfmi.zzk.zze().size() > 0) {
            Iterator it = zzfmi.zzk.zze().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject zza3 = zzflw.zza(0, 0, 0, 0);
                View zza4 = zzfmi.zzk.zza(str);
                zzflo zzb2 = zzfmi.zzj.zzb();
                String zzc2 = zzfmi.zzk.zzc(str);
                if (zzc2 != null) {
                    JSONObject zza5 = zzb2.zza(zza4);
                    zzflw.zzb(zza5, str);
                    zzflw.zzf(zza5, zzc2);
                    zzflw.zzc(zza3, zza5);
                }
                zzflw.zzi(zza3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfmi.zzl.zzc(zza3, hashSet, nanoTime);
            }
        }
        if (zzfmi.zzk.zzf().size() > 0) {
            JSONObject zza6 = zzflw.zza(0, 0, 0, 0);
            zzfmi.zzk((View) null, zza2, zza6, 1, false);
            zzflw.zzi(zza6);
            zzfmi.zzl.zzd(zza6, zzfmi.zzk.zzf(), nanoTime);
            boolean z = zzfmi.zzh;
        } else {
            zzfmi.zzl.zzb();
        }
        zzfmi.zzk.zzg();
        long nanoTime2 = System.nanoTime() - zzfmi.zzm;
        if (zzfmi.zzf.size() > 0) {
            for (zzfmh zzfmh : zzfmi.zzf) {
                int i = zzfmi.zzg;
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                zzfmh.zzb();
                if (zzfmh instanceof zzfmg) {
                    int i2 = zzfmi.zzg;
                    ((zzfmg) zzfmh).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzflo zzflo, JSONObject jSONObject, int i, boolean z) {
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        zzflo.zzb(view, jSONObject, this, z2, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    public final void zza(View view, zzflo zzflo, JSONObject jSONObject, boolean z) {
        int zzk2;
        boolean z2;
        if (zzflz.zzb(view) == null && (zzk2 = this.zzk.zzk(view)) != 3) {
            JSONObject zza2 = zzflo.zza(view);
            zzflw.zzc(jSONObject, zza2);
            String zzd2 = this.zzk.zzd(view);
            if (zzd2 != null) {
                zzflw.zzb(zza2, zzd2);
                zzflw.zze(zza2, Boolean.valueOf(this.zzk.zzj(view)));
                this.zzk.zzh();
            } else {
                zzfma zzb2 = this.zzk.zzb(view);
                if (zzb2 != null) {
                    zzflw.zzd(zza2, zzb2);
                    z2 = true;
                } else {
                    z2 = false;
                }
                zzk(view, zzflo, zza2, zzk2, z || z2);
            }
            this.zzg++;
        }
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            zzc = new Handler(Looper.getMainLooper());
            zzc.post(zzd);
            zzc.postDelayed(zze, 200);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfmd(this));
    }
}
