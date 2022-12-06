package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zzad();
    final int mVersionCode;
    private final Scope[] zzakD;
    private final int zzaso;
    private final int zzasp;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.mVersionCode = i;
        this.zzaso = i2;
        this.zzasp = i3;
        this.zzakD = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, scopeArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }

    public int zztU() {
        return this.zzaso;
    }

    public int zztV() {
        return this.zzasp;
    }

    public Scope[] zztW() {
        return this.zzakD;
    }
}
