package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzepx implements zzeve {
    private final zzeve zza;
    private final zzfef zzb;
    private final Context zzc;
    private final zzcfy zzd;

    public zzepx(zzero zzero, zzfef zzfef, Context context, zzcfy zzcfy) {
        this.zza = zzero;
        this.zzb = zzfef;
        this.zzc = context;
        this.zzd = zzcfy;
    }

    public final int zza() {
        return 7;
    }

    public final zzfzp zzb() {
        return zzfzg.zzm(this.zza.zzb(), new zzepw(this), zzchc.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepy zzc(zzevj zzevj) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        DisplayMetrics displayMetrics;
        zzq zzq = this.zzb.zze;
        zzq[] zzqArr = zzq.zzg;
        if (zzqArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzq zzq2 : zzqArr) {
                boolean z4 = zzq2.zzi;
                if (!z4 && !z2) {
                    str = zzq2.zza;
                    z2 = true;
                }
                if (z4) {
                    if (!z3) {
                        z3 = true;
                        z = true;
                    } else {
                        z3 = true;
                    }
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzq.zza;
            z = zzq.zzi;
        }
        Resources resources = this.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i4 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.zzd.zzh().zzm();
            i2 = i4;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        zzq[] zzqArr2 = zzq.zzg;
        if (zzqArr2 != null) {
            boolean z5 = false;
            for (zzq zzq3 : zzqArr2) {
                if (zzq3.zzi) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i5 = zzq3.zze;
                    if (i5 == -1) {
                        i5 = f != 0.0f ? (int) (((float) zzq3.zzf) / f) : -1;
                    }
                    sb.append(i5);
                    sb.append("x");
                    int i6 = zzq3.zzb;
                    if (i6 == -2) {
                        i6 = f != 0.0f ? (int) (((float) zzq3.zzc) / f) : -2;
                    }
                    sb.append(i6);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzepy(zzq, str, z, sb.toString(), f, i2, i, str2, this.zzb.zzp);
    }
}
