package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzboj {
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zza;
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomClickListener zzb;
    private NativeCustomTemplateAd zzc;

    public zzboj(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomTemplateAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomTemplateAd zzf(zzbmy zzbmy) {
        NativeCustomTemplateAd nativeCustomTemplateAd = this.zzc;
        if (nativeCustomTemplateAd != null) {
            return nativeCustomTemplateAd;
        }
        zzbmz zzbmz = new zzbmz(zzbmy);
        this.zzc = zzbmz;
        return zzbmz;
    }

    public final zzbni zzd() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbog(this, (zzbof) null);
    }

    public final zzbnl zze() {
        return new zzboi(this, (zzboh) null);
    }
}
