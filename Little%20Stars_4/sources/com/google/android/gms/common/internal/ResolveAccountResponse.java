package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzq;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzac();
    final int mVersionCode;
    private ConnectionResult zzakJ;
    private boolean zzamQ;
    IBinder zzaqo;
    private boolean zzasn;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.zzaqo = iBinder;
        this.zzakJ = connectionResult;
        this.zzamQ = z;
        this.zzasn = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.zzakJ.equals(resolveAccountResponse.zzakJ) && zztQ().equals(resolveAccountResponse.zztQ());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzac.zza(this, parcel, i);
    }

    public zzq zztQ() {
        return zzq.zza.zzaT(this.zzaqo);
    }

    public ConnectionResult zztR() {
        return this.zzakJ;
    }

    public boolean zztS() {
        return this.zzamQ;
    }

    public boolean zztT() {
        return this.zzasn;
    }
}
