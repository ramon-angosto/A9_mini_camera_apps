package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzayi implements zzaye {
    private final zzaye[] zza;
    private final ArrayList zzb;
    private final zzatg zzc = new zzatg();
    private zzayd zzd;
    private zzath zze;
    private int zzf = -1;
    private zzayh zzg;

    public zzayi(zzaye... zzayeArr) {
        this.zza = zzayeArr;
        this.zzb = new ArrayList(Arrays.asList(zzayeArr));
    }

    static /* bridge */ /* synthetic */ void zzf(zzayi zzayi, int i, zzath zzath, Object obj) {
        zzayh zzayh;
        if (zzayi.zzg == null) {
            for (int i2 = 0; i2 <= 0; i2++) {
                zzath.zzg(i2, zzayi.zzc, false);
            }
            int i3 = zzayi.zzf;
            if (i3 == -1) {
                zzayi.zzf = 1;
            } else if (i3 != 1) {
                zzayh = new zzayh(1);
                zzayi.zzg = zzayh;
            }
            zzayh = null;
            zzayi.zzg = zzayh;
        }
        if (zzayi.zzg == null) {
            zzayi.zzb.remove(zzayi.zza[i]);
            if (i == 0) {
                zzayi.zze = zzath;
            }
            if (zzayi.zzb.isEmpty()) {
                zzayi.zzd.zzg(zzayi.zze, (Object) null);
            }
        }
    }

    public final void zza() throws IOException {
        zzayh zzayh = this.zzg;
        if (zzayh == null) {
            for (zzaye zza2 : this.zza) {
                zza2.zza();
            }
            return;
        }
        throw zzayh;
    }

    public final void zzb(zzasm zzasm, boolean z, zzayd zzayd) {
        this.zzd = zzayd;
        int i = 0;
        while (true) {
            zzaye[] zzayeArr = this.zza;
            if (i < zzayeArr.length) {
                zzayeArr[i].zzb(zzasm, false, new zzayg(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzc(zzayc zzayc) {
        zzayf zzayf = (zzayf) zzayc;
        int i = 0;
        while (true) {
            zzaye[] zzayeArr = this.zza;
            if (i < zzayeArr.length) {
                zzayeArr[i].zzc(zzayf.zza[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzd() {
        for (zzaye zzd2 : this.zza) {
            zzd2.zzd();
        }
    }

    public final zzayc zze(int i, zzazp zzazp) {
        zzayc[] zzaycArr = new zzayc[this.zza.length];
        for (int i2 = 0; i2 < zzaycArr.length; i2++) {
            zzaycArr[i2] = this.zza[i2].zze(i, zzazp);
        }
        return new zzayf(zzaycArr);
    }
}
