package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class zzw extends zza implements ICancelToken {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
    }

    public final void cancel() throws RemoteException {
        zzD(2, zza());
    }
}
