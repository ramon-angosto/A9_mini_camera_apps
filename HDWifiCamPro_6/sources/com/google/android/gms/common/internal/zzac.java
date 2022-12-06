package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzac implements IGmsServiceBroker {
    private final IBinder zza;

    zzac(IBinder iBinder) {
        this.zza = iBinder;
    }

    public final IBinder asBinder() {
        return this.zza;
    }

    public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                zzm.zza(getServiceRequest, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.zza.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
