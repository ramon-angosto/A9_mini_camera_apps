package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Parcelable.Creator<SignInButtonConfig> {
    static void zza(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, signInButtonConfig.mVersionCode);
        zzb.zzc(parcel, 2, signInButtonConfig.zztU());
        zzb.zzc(parcel, 3, signInButtonConfig.zztV());
        zzb.zza(parcel, 4, (T[]) signInButtonConfig.zztW(), i, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzan */
    public SignInButtonConfig createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                i2 = zza.zzg(parcel, zzap);
            } else if (zzcj == 3) {
                i3 = zza.zzg(parcel, zzap);
            } else if (zzcj != 4) {
                zza.zzb(parcel, zzap);
            } else {
                scopeArr = (Scope[]) zza.zzb(parcel, zzap, Scope.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new SignInButtonConfig(i, i2, i3, scopeArr);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzch */
    public SignInButtonConfig[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
