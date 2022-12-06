package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbs;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcxf extends zzcxc {
    private final Context zzc;
    private final View zzd;
    private final zzcmp zze;
    private final zzfdl zzf;
    private final zzczc zzg;
    private final zzdpb zzh;
    private final zzdkp zzi;
    private final zzgxc zzj;
    private final Executor zzk;
    private zzq zzl;

    zzcxf(zzczd zzczd, Context context, zzfdl zzfdl, View view, zzcmp zzcmp, zzczc zzczc, zzdpb zzdpb, zzdkp zzdkp, zzgxc zzgxc, Executor executor) {
        super(zzczd);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcmp;
        this.zzf = zzfdl;
        this.zzg = zzczc;
        this.zzh = zzdpb;
        this.zzi = zzdkp;
        this.zzj = zzgxc;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzi(zzcxf zzcxf) {
        zzdpb zzdpb = zzcxf.zzh;
        if (zzdpb.zze() != null) {
            try {
                zzdpb.zze().zze((zzbs) zzcxf.zzj.zzb(), ObjectWrapper.wrap(zzcxf.zzc));
            } catch (RemoteException e) {
                zze.zzh("RemoteException when notifyAdLoad is called", e);
            }
        }
    }

    public final void zzW() {
        this.zzk.execute(new zzcxe(this));
        super.zzW();
    }

    public final int zza() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgJ)).booleanValue() && this.zzb.zzai) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgK)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    public final View zzc() {
        return this.zzd;
    }

    public final zzdk zzd() {
        try {
            return this.zzg.zza();
        } catch (zzfek unused) {
            return null;
        }
    }

    public final zzfdl zze() {
        zzq zzq = this.zzl;
        if (zzq != null) {
            return zzfej.zzc(zzq);
        }
        zzfdk zzfdk = this.zzb;
        if (zzfdk.zzad) {
            for (String str : zzfdk.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            return new zzfdl(this.zzd.getWidth(), this.zzd.getHeight(), false);
        }
        return zzfej.zzb(this.zzb.zzs, this.zzf);
    }

    public final zzfdl zzf() {
        return this.zzf;
    }

    public final void zzg() {
        this.zzi.zza();
    }

    public final void zzh(ViewGroup viewGroup, zzq zzq) {
        zzcmp zzcmp;
        if (viewGroup != null && (zzcmp = this.zze) != null) {
            zzcmp.zzai(zzcoe.zzc(zzq));
            viewGroup.setMinimumHeight(zzq.zzc);
            viewGroup.setMinimumWidth(zzq.zzf);
            this.zzl = zzq;
        }
    }
}
