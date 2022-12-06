package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.meizu.cloud.pushsdk.constants.PushConstants;

public class zze implements Parcelable.Creator<DataHolder> {
    static void zza(DataHolder dataHolder, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zza(parcel, 1, dataHolder.zzsU(), false);
        zzb.zza(parcel, 2, (T[]) dataHolder.zzsV(), i, false);
        zzb.zzc(parcel, 3, dataHolder.getStatusCode());
        zzb.zza(parcel, 4, dataHolder.zzsO(), false);
        zzb.zzc(parcel, PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE, dataHolder.getVersionCode());
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzag */
    public DataHolder createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                strArr = zza.zzC(parcel, zzap);
            } else if (zzcj == 2) {
                cursorWindowArr = (CursorWindow[]) zza.zzb(parcel, zzap, CursorWindow.CREATOR);
            } else if (zzcj == 3) {
                i2 = zza.zzg(parcel, zzap);
            } else if (zzcj == 4) {
                bundle = zza.zzs(parcel, zzap);
            } else if (zzcj != 1000) {
                zza.zzb(parcel, zzap);
            } else {
                i = zza.zzg(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            DataHolder dataHolder = new DataHolder(i, strArr, cursorWindowArr, i2, bundle);
            dataHolder.zzsT();
            return dataHolder;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzbS */
    public DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
