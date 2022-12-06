package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzd implements Parcelable.Creator<LogEventParcelable> {
    static void zza(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, logEventParcelable.versionCode);
        zzb.zza(parcel, 2, (Parcelable) logEventParcelable.zzajL, i, false);
        zzb.zza(parcel, 3, logEventParcelable.zzajM, false);
        zzb.zza(parcel, 4, logEventParcelable.zzajN, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzab */
    public LogEventParcelable createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        PlayLoggerContext playLoggerContext = null;
        int i = 0;
        byte[] bArr = null;
        int[] iArr = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                playLoggerContext = (PlayLoggerContext) zza.zza(parcel, zzap, PlayLoggerContext.CREATOR);
            } else if (zzcj == 3) {
                bArr = zza.zzt(parcel, zzap);
            } else if (zzcj != 4) {
                zza.zzb(parcel, zzap);
            } else {
                iArr = zza.zzw(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new LogEventParcelable(i, playLoggerContext, bArr, iArr);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzbz */
    public LogEventParcelable[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
