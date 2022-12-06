package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbyq implements NativeCustomFormatAd {
    private final zzbmy zza;
    private final MediaView zzb;
    private final VideoController zzc = new VideoController();
    private NativeCustomFormatAd.DisplayOpenMeasurement zzd;

    public zzbyq(zzbmy zzbmy) {
        Context context;
        this.zza = zzbmy;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbmy.zzh());
        } catch (RemoteException | NullPointerException e) {
            zzcgp.zzh("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (true == this.zza.zzr(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzcgp.zzh("", e2);
            }
        }
        this.zzb = mediaView;
    }

    public final void destroy() {
        try {
            this.zza.zzl();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final String getCustomFormatId() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final NativeCustomFormatAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzd == null && this.zza.zzq()) {
                this.zzd = new zzbyi(this.zza);
            }
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
        return this.zzd;
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzbme zzg = this.zza.zzg(str);
            if (zzg != null) {
                return new zzbyj(zzg);
            }
            return null;
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zza.zzf() != null) {
                return new zzej(this.zza.zzf(), this.zza);
            }
            return null;
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zza.zzj(str);
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzdk zze = this.zza.zze();
            if (zze != null) {
                this.zzc.zzb(zze);
            }
        } catch (RemoteException e) {
            zzcgp.zzh("Exception occurred while getting video controller", e);
        }
        return this.zzc;
    }

    public final MediaView getVideoMediaView() {
        return this.zzb;
    }

    public final void performClick(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }
}
