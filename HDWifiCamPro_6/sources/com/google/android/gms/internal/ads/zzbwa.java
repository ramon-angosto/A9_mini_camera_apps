package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzdn;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbwa extends zzdj {
    private final Object zza = new Object();
    private volatile zzdn zzb;

    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzf() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzg() throws RemoteException {
        throw new RemoteException();
    }

    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    public final zzdn zzi() throws RemoteException {
        zzdn zzdn;
        synchronized (this.zza) {
            zzdn = this.zzb;
        }
        return zzdn;
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

    public final void zzm(zzdn zzdn) throws RemoteException {
        synchronized (this.zza) {
            this.zzb = zzdn;
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
