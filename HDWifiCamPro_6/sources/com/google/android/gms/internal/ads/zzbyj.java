package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbyj extends NativeAd.Image {
    private final zzbme zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;

    public zzbyj(zzbme zzbme) {
        Drawable drawable;
        double d;
        this.zza = zzbme;
        Uri uri = null;
        try {
            IObjectWrapper zzf = this.zza.zzf();
            if (zzf != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzf);
                this.zzb = drawable;
                uri = this.zza.zze();
                this.zzc = uri;
                d = this.zza.zzb();
                this.zzd = d;
                this.zza.zzd();
                this.zza.zzc();
            }
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
        drawable = null;
        this.zzb = drawable;
        try {
            uri = this.zza.zze();
        } catch (RemoteException e2) {
            zzcgp.zzh("", e2);
        }
        this.zzc = uri;
        try {
            d = this.zza.zzb();
        } catch (RemoteException e3) {
            zzcgp.zzh("", e3);
            d = 1.0d;
        }
        this.zzd = d;
        try {
            this.zza.zzd();
        } catch (RemoteException e4) {
            zzcgp.zzh("", e4);
        }
        try {
            this.zza.zzc();
        } catch (RemoteException e5) {
            zzcgp.zzh("", e5);
        }
    }

    public final Drawable getDrawable() {
        return this.zzb;
    }

    public final double getScale() {
        return this.zzd;
    }

    public final Uri getUri() {
        return this.zzc;
    }
}
