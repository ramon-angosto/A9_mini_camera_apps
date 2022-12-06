package com.google.android.gms.ads.internal.client;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbmb;
import com.google.android.gms.internal.ads.zzbmy;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzej implements MediaContent {
    private final zzbmb zza;
    private final VideoController zzb = new VideoController();
    private final zzbmy zzc;

    public zzej(zzbmb zzbmb, zzbmy zzbmy) {
        this.zza = zzbmb;
        this.zzc = zzbmy;
    }

    public final float getAspectRatio() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return 0.0f;
        }
    }

    public final float getCurrentTime() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return 0.0f;
        }
    }

    public final float getDuration() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return 0.0f;
        }
    }

    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzi = this.zza.zzi();
            if (zzi != null) {
                return (Drawable) ObjectWrapper.unwrap(zzi);
            }
            return null;
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzh() != null) {
                this.zzb.zzb(this.zza.zzh());
            }
        } catch (RemoteException e) {
            zzcgp.zzh("Exception occurred while getting video controller", e);
        }
        return this.zzb;
    }

    public final boolean hasVideoContent() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return false;
        }
    }

    public final void setMainImage(Drawable drawable) {
        try {
            this.zza.zzj(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final zzbmy zza() {
        return this.zzc;
    }

    public final zzbmb zzb() {
        return this.zza;
    }
}
