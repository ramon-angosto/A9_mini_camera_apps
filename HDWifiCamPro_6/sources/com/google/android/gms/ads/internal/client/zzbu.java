package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzarz;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbu extends zzarz implements zzbw {
    zzbu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }

    public final void zze() throws RemoteException {
        zzbl(1, zza());
    }
}
