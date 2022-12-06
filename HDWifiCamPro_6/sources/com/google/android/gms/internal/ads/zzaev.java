package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaev extends zzaex {
    public final long zza;
    public final List zzb = new ArrayList();
    public final List zzc = new ArrayList();

    public zzaev(int i, long j) {
        super(i);
        this.zza = j;
    }

    public final String toString() {
        String zzf = zzf(this.zzd);
        String arrays = Arrays.toString(this.zzb.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        return zzf + " leaves: " + arrays + " containers: " + arrays2;
    }

    public final zzaev zza(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzaev zzaev = (zzaev) this.zzc.get(i2);
            if (zzaev.zzd == i) {
                return zzaev;
            }
        }
        return null;
    }

    public final zzaew zzb(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzaew zzaew = (zzaew) this.zzb.get(i2);
            if (zzaew.zzd == i) {
                return zzaew;
            }
        }
        return null;
    }

    public final void zzc(zzaev zzaev) {
        this.zzc.add(zzaev);
    }

    public final void zzd(zzaew zzaew) {
        this.zzb.add(zzaew);
    }
}
