package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdmq implements zzdeo, zzo, zzddu {
    IObjectWrapper zza;
    private final Context zzb;
    private final zzcmp zzc;
    private final zzfdk zzd;
    private final zzcgv zze;
    private final zzbez zzf;

    public zzdmq(Context context, zzcmp zzcmp, zzfdk zzfdk, zzcgv zzcgv, zzbez zzbez) {
        this.zzb = context;
        this.zzc = zzcmp;
        this.zzd = zzfdk;
        this.zze = zzcgv;
        this.zzf = zzbez;
    }

    public final void zzb() {
        if (this.zza != null && this.zzc != null) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzel)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    public final void zzbC() {
    }

    public final void zzbK() {
    }

    public final void zzbr() {
    }

    public final void zze() {
    }

    public final void zzf(int i) {
        this.zza = null;
    }

    public final void zzl() {
        if (this.zza != null && this.zzc != null) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzel)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    public final void zzn() {
        zzeha zzeha;
        zzehb zzehb;
        zzehb zzehb2;
        zzbez zzbez;
        if ((this.zzf == zzbez.REWARD_BASED_VIDEO_AD || (zzbez = this.zzf) == zzbez.INTERSTITIAL || zzbez == zzbez.APP_OPEN) && this.zzd.zzU && this.zzc != null && zzt.zzA().zze(this.zzb)) {
            zzcgv zzcgv = this.zze;
            String str = zzcgv.zzb + "." + zzcgv.zzc;
            String zza2 = this.zzd.zzW.zza();
            if (this.zzd.zzW.zzb() == 1) {
                zzeha = zzeha.VIDEO;
                zzehb = zzehb.DEFINED_BY_JAVASCRIPT;
            } else {
                if (this.zzd.zzZ == 2) {
                    zzehb2 = zzehb.UNSPECIFIED;
                } else {
                    zzehb2 = zzehb.BEGIN_TO_RENDER;
                }
                zzehb = zzehb2;
                zzeha = zzeha.HTML_DISPLAY;
            }
            this.zza = zzt.zzA().zza(str, this.zzc.zzI(), "", "javascript", zza2, zzehb, zzeha, this.zzd.zzan);
            if (this.zza != null) {
                zzt.zzA().zzc(this.zza, (View) this.zzc);
                this.zzc.zzar(this.zza);
                zzt.zzA().zzd(this.zza);
                this.zzc.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }
}
