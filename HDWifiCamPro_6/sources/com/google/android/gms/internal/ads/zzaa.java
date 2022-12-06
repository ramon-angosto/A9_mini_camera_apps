package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaa {
    private final SparseBooleanArray zza;

    /* synthetic */ zzaa(SparseBooleanArray sparseBooleanArray, zzz zzz) {
        this.zza = sparseBooleanArray;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaa)) {
            return false;
        }
        zzaa zzaa = (zzaa) obj;
        if (zzen.zza >= 24) {
            return this.zza.equals(zzaa.zza);
        }
        if (this.zza.size() != zzaa.zza.size()) {
            return false;
        }
        for (int i = 0; i < this.zza.size(); i++) {
            if (zza(i) != zzaa.zza(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (zzen.zza >= 24) {
            return this.zza.hashCode();
        }
        int size = this.zza.size();
        for (int i = 0; i < this.zza.size(); i++) {
            size = (size * 31) + zza(i);
        }
        return size;
    }

    public final int zza(int i) {
        zzdd.zza(i, 0, this.zza.size());
        return this.zza.keyAt(i);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final boolean zzc(int i) {
        return this.zza.get(i);
    }
}
