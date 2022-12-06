package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzduc extends zzcze {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdmp zze;
    private final zzdjw zzf;
    private final zzddn zzg;
    private final zzdeu zzh;
    private final zzczy zzi;
    private final zzcci zzj;
    private final zzfni zzk;
    private final zzfdy zzl;
    private boolean zzm = false;

    zzduc(zzczd zzczd, Context context, zzcmp zzcmp, zzdmp zzdmp, zzdjw zzdjw, zzddn zzddn, zzdeu zzdeu, zzczy zzczy, zzfdk zzfdk, zzfni zzfni, zzfdy zzfdy) {
        super(zzczd);
        this.zzc = context;
        this.zze = zzdmp;
        this.zzd = new WeakReference(zzcmp);
        this.zzf = zzdjw;
        this.zzg = zzddn;
        this.zzh = zzdeu;
        this.zzi = zzczy;
        this.zzk = zzfni;
        zzcce zzcce = zzfdk.zzm;
        this.zzj = new zzcdc(zzcce != null ? zzcce.zza : "", zzcce != null ? zzcce.zzb : 1);
        this.zzl = zzfdy;
    }

    public final void finalize() throws Throwable {
        try {
            zzcmp zzcmp = (zzcmp) this.zzd.get();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzfO)).booleanValue()) {
                if (!this.zzm && zzcmp != null) {
                    zzchc.zze.execute(new zzdub(zzcmp));
                }
            } else if (zzcmp != null) {
                zzcmp.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzcci zzc() {
        return this.zzj;
    }

    public final zzfdy zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcmp zzcmp = (zzcmp) this.zzd.get();
        return zzcmp != null && !zzcmp.zzaD();
    }

    public final boolean zzh(boolean z, Activity activity) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzay)).booleanValue()) {
            zzt.zzp();
            if (zzs.zzC(this.zzc)) {
                zze.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzaz)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            zze.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzffe.zzd(10, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdmo e) {
            this.zzg.zzc(e);
            return false;
        }
    }
}
