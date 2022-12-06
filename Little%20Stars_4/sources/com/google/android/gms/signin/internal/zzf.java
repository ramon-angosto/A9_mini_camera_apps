package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Parcelable.Creator<RecordConsentRequest> {
    static void zza(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, recordConsentRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) recordConsentRequest.getAccount(), i, false);
        zzb.zza(parcel, 3, (T[]) recordConsentRequest.zzIV(), i, false);
        zzb.zza(parcel, 4, recordConsentRequest.zzpn(), false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzhm */
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        Account account = null;
        int i = 0;
        Scope[] scopeArr = null;
        String str = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                account = (Account) zza.zza(parcel, zzap, Account.CREATOR);
            } else if (zzcj == 3) {
                scopeArr = (Scope[]) zza.zzb(parcel, zzap, Scope.CREATOR);
            } else if (zzcj != 4) {
                zza.zzb(parcel, zzap);
            } else {
                str = zza.zzq(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzkK */
    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
