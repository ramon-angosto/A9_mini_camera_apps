package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbnd extends zzarz implements zzbnf {
    zzbnd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zze(zzbmv zzbmv) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbmv);
        zzbl(1, zza);
    }
}
