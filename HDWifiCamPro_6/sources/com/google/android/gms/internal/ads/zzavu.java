package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzavu extends zzavw {
    public final long zza;
    public final List zzb = new ArrayList();
    public final List zzc = new ArrayList();

    public zzavu(int i, long j) {
        super(i);
        this.zza = j;
    }

    public final String toString() {
        String zzg = zzg(this.zzaR);
        String arrays = Arrays.toString(this.zzb.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        return zzg + " leaves: " + arrays + " containers: " + arrays2;
    }

    public final zzavu zza(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzavu zzavu = (zzavu) this.zzc.get(i2);
            if (zzavu.zzaR == i) {
                return zzavu;
            }
        }
        return null;
    }

    public final zzavv zzb(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzavv zzavv = (zzavv) this.zzb.get(i2);
            if (zzavv.zzaR == i) {
                return zzavv;
            }
        }
        return null;
    }

    public final void zzc(zzavu zzavu) {
        this.zzc.add(zzavu);
    }

    public final void zzd(zzavv zzavv) {
        this.zzb.add(zzavv);
    }
}
