package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzf();
    final int mVersionCode;
    private final Account zzZB;
    private final String zzacD;
    private final Scope[] zzbnm;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.mVersionCode = i;
        this.zzZB = account;
        this.zzbnm = scopeArr;
        this.zzacD = str;
    }

    public Account getAccount() {
        return this.zzZB;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public Scope[] zzIV() {
        return this.zzbnm;
    }

    public String zzpn() {
        return this.zzacD;
    }
}
