package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzbs;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbdr {
    private zzbs zza;
    private final Context zzb;
    private final String zzc;
    private final zzdr zzd;
    private final int zze;
    private final AppOpenAd.AppOpenAdLoadCallback zzf;
    private final zzbvh zzg = new zzbvh();
    private final zzp zzh;

    public zzbdr(Context context, String str, zzdr zzdr, int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzdr;
        this.zze = i;
        this.zzf = appOpenAdLoadCallback;
        this.zzh = zzp.zza;
    }

    public final void zza() {
        try {
            this.zza = zzaw.zza().zzd(this.zzb, zzq.zzb(), this.zzc, this.zzg);
            zzw zzw = new zzw(this.zze);
            zzbs zzbs = this.zza;
            if (zzbs != null) {
                zzbs.zzI(zzw);
                this.zza.zzH(new zzbde(this.zzf, this.zzc));
                this.zza.zzaa(this.zzh.zza(this.zzb, this.zzd));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }
}
