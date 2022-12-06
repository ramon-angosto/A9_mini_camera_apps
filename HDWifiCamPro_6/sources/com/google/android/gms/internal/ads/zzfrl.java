package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfrl extends zzasa implements zzfrm {
    public zzfrl() {
        super("com.google.android.play.core.lmd.protocol.ILmdOverlayServiceListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzasb.zzc(parcel);
        zzb((Bundle) zzasb.zza(parcel, Bundle.CREATOR));
        return true;
    }
}
