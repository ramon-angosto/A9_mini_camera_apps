package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfji {
    public static zzfjj zza(Context context, int i) {
        boolean z;
        if (zzfjw.zza()) {
            int i2 = i - 2;
            if (i2 != 20 && i2 != 21) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        z = ((Boolean) zzbkl.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        z = ((Boolean) zzbkl.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        z = ((Boolean) zzbkl.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                z = ((Boolean) zzbkl.zze.zze()).booleanValue();
            }
            if (z) {
                return new zzfjl(context, i);
            }
        }
        return new zzfkf();
    }

    public static zzfjj zzb(Context context, int i, int i2, zzl zzl) {
        zzfjj zza = zza(context, i);
        if (!(zza instanceof zzfjl)) {
            return zza;
        }
        zza.zzf();
        zza.zzk(i2);
        if (zzfjt.zze(zzl.zzp)) {
            zza.zzd(zzl.zzp);
        }
        return zza;
    }
}
