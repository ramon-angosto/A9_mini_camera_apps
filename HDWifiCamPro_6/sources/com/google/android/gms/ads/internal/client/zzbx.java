package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzarz;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbx extends zzarz implements zzbz {
    zzbx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public final void zzc(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbl(1, zza);
    }
}
