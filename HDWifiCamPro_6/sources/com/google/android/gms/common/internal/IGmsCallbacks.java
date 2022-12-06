package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzb(int i, Bundle bundle) throws RemoteException;

    void zzc(int i, IBinder iBinder, zzj zzj) throws RemoteException;
}
