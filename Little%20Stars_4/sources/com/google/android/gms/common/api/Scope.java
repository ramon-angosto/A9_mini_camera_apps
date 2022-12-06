package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public final class Scope extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zze();
    final int mVersionCode;
    private final String zzalv;

    Scope(int i, String str) {
        zzaa.zzh(str, "scopeUri must not be null or empty");
        this.mVersionCode = i;
        this.zzalv = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.zzalv.equals(((Scope) obj).zzalv);
    }

    public int hashCode() {
        return this.zzalv.hashCode();
    }

    public String toString() {
        return this.zzalv;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public String zzrw() {
        return this.zzalv;
    }
}
