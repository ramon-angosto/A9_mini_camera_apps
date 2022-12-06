package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<PlayLoggerContext> {
    static void zza(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, playLoggerContext.versionCode);
        zzb.zza(parcel, 2, playLoggerContext.packageName, false);
        zzb.zzc(parcel, 3, playLoggerContext.zzbkZ);
        zzb.zzc(parcel, 4, playLoggerContext.zzbla);
        zzb.zza(parcel, 5, playLoggerContext.zzblb, false);
        zzb.zza(parcel, 6, playLoggerContext.zzblc, false);
        zzb.zza(parcel, 7, playLoggerContext.zzbld);
        zzb.zza(parcel, 8, playLoggerContext.zzble, false);
        zzb.zza(parcel, 9, playLoggerContext.zzblf);
        zzb.zzc(parcel, 10, playLoggerContext.zzblg);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzgU */
    public PlayLoggerContext createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzaq = zza.zzaq(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = true;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    i = zza.zzg(parcel2, zzap);
                    break;
                case 2:
                    str = zza.zzq(parcel2, zzap);
                    break;
                case 3:
                    i2 = zza.zzg(parcel2, zzap);
                    break;
                case 4:
                    i3 = zza.zzg(parcel2, zzap);
                    break;
                case 5:
                    str2 = zza.zzq(parcel2, zzap);
                    break;
                case 6:
                    str3 = zza.zzq(parcel2, zzap);
                    break;
                case 7:
                    z = zza.zzc(parcel2, zzap);
                    break;
                case 8:
                    str4 = zza.zzq(parcel2, zzap);
                    break;
                case 9:
                    z2 = zza.zzc(parcel2, zzap);
                    break;
                case 10:
                    i4 = zza.zzg(parcel2, zzap);
                    break;
                default:
                    zza.zzb(parcel2, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new PlayLoggerContext(i, str, i2, i3, str2, str3, z, str4, z2, i4);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel2);
    }

    /* renamed from: zzkq */
    public PlayLoggerContext[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
