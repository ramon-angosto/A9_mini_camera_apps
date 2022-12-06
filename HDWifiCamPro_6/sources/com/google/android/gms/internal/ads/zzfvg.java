package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
class zzfvg extends zzfvh {
    Object[] zza;
    int zzb = 0;
    boolean zzc;

    zzfvg(int i) {
        this.zza = new Object[i];
    }

    private final void zze(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i) {
            this.zza = Arrays.copyOf(objArr, zzd(length, i));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
    }

    public /* bridge */ /* synthetic */ zzfvh zzb(Object obj) {
        throw null;
    }

    public final zzfvh zzc(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zze(this.zzb + collection.size());
            if (collection instanceof zzfvi) {
                this.zzb = ((zzfvi) collection).zza(this.zza, this.zzb);
                return this;
            }
        }
        for (Object zzb2 : iterable) {
            zzb(zzb2);
        }
        return this;
    }

    public final zzfvg zza(Object obj) {
        if (obj != null) {
            zze(this.zzb + 1);
            Object[] objArr = this.zza;
            int i = this.zzb;
            this.zzb = i + 1;
            objArr[i] = obj;
            return this;
        }
        throw null;
    }
}
