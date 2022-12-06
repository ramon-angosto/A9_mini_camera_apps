package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.zze;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdmu implements zzdda, zzdjx {
    private final zzcec zza;
    private final Context zzb;
    private final zzceu zzc;
    private final View zzd;
    private String zze;
    private final zzbez zzf;

    public zzdmu(zzcec zzcec, Context context, zzceu zzceu, View view, zzbez zzbez) {
        this.zza = zzcec;
        this.zzb = context;
        this.zzc = zzceu;
        this.zzd = view;
        this.zzf = zzbez;
    }

    public final void zzbv() {
    }

    public final void zzf() {
    }

    public final void zzg() {
        if (this.zzf != zzbez.APP_OPEN) {
            this.zze = this.zzc.zzd(this.zzb);
            this.zze = String.valueOf(this.zze).concat(this.zzf == zzbez.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
        }
    }

    public final void zzj() {
        this.zza.zzb(false);
    }

    public final void zzm() {
    }

    public final void zzo() {
        View view = this.zzd;
        if (!(view == null || this.zze == null)) {
            this.zzc.zzs(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @ParametersAreNonnullByDefault
    public final void zzp(zzcbs zzcbs, String str, String str2) {
        if (this.zzc.zzu(this.zzb)) {
            try {
                zzceu zzceu = this.zzc;
                Context context = this.zzb;
                zzceu.zzo(context, zzceu.zza(context), this.zza.zza(), zzcbs.zzc(), zzcbs.zzb());
            } catch (RemoteException e) {
                zze.zzk("Remote Exception to get reward item.", e);
            }
        }
    }

    public final void zzr() {
    }
}
