package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzasb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzdi extends zzarz implements zzdk {
    zzdi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final float zze() throws RemoteException {
        throw null;
    }

    public final float zzf() throws RemoteException {
        throw null;
    }

    public final float zzg() throws RemoteException {
        throw null;
    }

    public final int zzh() throws RemoteException {
        Parcel zzbk = zzbk(5, zza());
        int readInt = zzbk.readInt();
        zzbk.recycle();
        return readInt;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzdn zzi() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 11
            android.os.Parcel r0 = r4.zzbk(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzdn
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzdn r1 = (com.google.android.gms.ads.internal.client.zzdn) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzdl r2 = new com.google.android.gms.ads.internal.client.zzdl
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzdi.zzi():com.google.android.gms.ads.internal.client.zzdn");
    }

    public final void zzj(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzd(zza, z);
        zzbl(3, zza);
    }

    public final void zzk() throws RemoteException {
        zzbl(2, zza());
    }

    public final void zzl() throws RemoteException {
        zzbl(1, zza());
    }

    public final void zzm(zzdn zzdn) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzdn);
        zzbl(8, zza);
    }

    public final void zzn() throws RemoteException {
        zzbl(13, zza());
    }

    public final boolean zzo() throws RemoteException {
        Parcel zzbk = zzbk(12, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzbk = zzbk(10, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    public final boolean zzq() throws RemoteException {
        Parcel zzbk = zzbk(4, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }
}
