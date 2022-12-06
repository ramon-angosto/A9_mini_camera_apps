package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab implements Parcelable.Creator<ResolveAccountRequest> {
    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, resolveAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) resolveAccountRequest.getAccount(), i, false);
        zzb.zzc(parcel, 3, resolveAccountRequest.getSessionId());
        zzb.zza(parcel, 4, (Parcelable) resolveAccountRequest.zztP(), i, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzal */
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        Account account = null;
        int i = 0;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                account = (Account) zza.zza(parcel, zzap, Account.CREATOR);
            } else if (zzcj == 3) {
                i2 = zza.zzg(parcel, zzap);
            } else if (zzcj != 4) {
                zza.zzb(parcel, zzap);
            } else {
                googleSignInAccount = (GoogleSignInAccount) zza.zza(parcel, zzap, GoogleSignInAccount.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new ResolveAccountRequest(i, account, i2, googleSignInAccount);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzcf */
    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
