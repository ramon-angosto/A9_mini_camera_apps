package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzdn;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdop extends zzdj {
    private final Object zza = new Object();
    @Nullable
    private final zzdk zzb;
    @Nullable
    private final zzbvz zzc;

    public zzdop(@Nullable zzdk zzdk, @Nullable zzbvz zzbvz) {
        this.zzb = zzdk;
        this.zzc = zzbvz;
    }

    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzf() throws RemoteException {
        zzbvz zzbvz = this.zzc;
        if (zzbvz != null) {
            return zzbvz.zzg();
        }
        return 0.0f;
    }

    public final float zzg() throws RemoteException {
        zzbvz zzbvz = this.zzc;
        if (zzbvz != null) {
            return zzbvz.zzh();
        }
        return 0.0f;
    }

    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    @Nullable
    public final zzdn zzi() throws RemoteException {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk == null) {
                return null;
            }
            zzdn zzi = zzdk.zzi();
            return zzi;
        }
    }

    public final void zzj(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final void zzk() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzm(@Nullable zzdn zzdn) throws RemoteException {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk != null) {
                zzdk.zzm(zzdn);
            }
        }
    }

    public final void zzn() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzo() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzq() throws RemoteException {
        throw new RemoteException();
    }
}
