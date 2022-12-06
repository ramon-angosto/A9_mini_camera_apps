package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzghp {
    @Nullable
    private ArrayList zza = new ArrayList();
    private zzghm zzb = zzghm.zza;
    @Nullable
    private Integer zzc = null;

    public final zzghp zza(zzgbc zzgbc, int i, zzgbl zzgbl) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzghr(zzgbc, i, zzgbl, (zzghq) null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzghp zzb(zzghm zzghm) {
        if (this.zza != null) {
            this.zzb = zzghm;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzghp zzc(int i) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzght zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    int i2 = i + 1;
                    if (((zzghr) arrayList.get(i)).zza() != intValue) {
                        i = i2;
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzght zzght = new zzght(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, (zzghs) null);
            this.zza = null;
            return zzght;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
