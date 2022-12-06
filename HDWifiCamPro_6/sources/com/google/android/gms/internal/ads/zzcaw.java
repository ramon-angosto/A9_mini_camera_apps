package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzaz;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcaw extends zzarz implements zzcay {
    zzcaw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    public final void zze(zzaz zzaz) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzaz);
        zzbl(2, zza);
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, parcelFileDescriptor);
        zzbl(1, zza);
    }
}
