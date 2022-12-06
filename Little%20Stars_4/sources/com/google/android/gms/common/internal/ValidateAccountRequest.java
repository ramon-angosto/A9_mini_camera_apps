package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzai();
    final int mVersionCode;
    private final Scope[] zzakD;
    final IBinder zzaqo;
    private final int zzasu;
    private final Bundle zzasv;
    private final String zzasw;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.mVersionCode = i;
        this.zzasu = i2;
        this.zzaqo = iBinder;
        this.zzakD = scopeArr;
        this.zzasv = bundle;
        this.zzasw = str;
    }

    public String getCallingPackage() {
        return this.zzasw;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzai.zza(this, parcel, i);
    }

    public Scope[] zztW() {
        return this.zzakD;
    }

    public int zztY() {
        return this.zzasu;
    }

    public Bundle zztZ() {
        return this.zzasv;
    }
}
