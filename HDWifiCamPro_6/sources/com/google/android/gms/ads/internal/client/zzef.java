package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzef extends zzct {
    private final String zza;
    private final String zzb;

    public zzef(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final String zze() throws RemoteException {
        return this.zza;
    }

    public final String zzf() throws RemoteException {
        return this.zzb;
    }
}
