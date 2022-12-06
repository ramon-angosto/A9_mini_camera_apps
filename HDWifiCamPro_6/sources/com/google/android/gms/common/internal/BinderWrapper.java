package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzh();
    private IBinder zza;

    public BinderWrapper(IBinder iBinder) {
        this.zza = iBinder;
    }

    /* synthetic */ BinderWrapper(Parcel parcel, zzi zzi) {
        this.zza = parcel.readStrongBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zza);
    }
}
