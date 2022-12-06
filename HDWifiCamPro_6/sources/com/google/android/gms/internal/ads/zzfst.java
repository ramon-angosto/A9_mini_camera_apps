package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzfst implements Serializable {
    zzfst() {
    }

    public static zzfst zzc() {
        return zzfsc.zza;
    }

    public static zzfst zzd(@CheckForNull Object obj) {
        return obj == null ? zzfsc.zza : new zzftc(obj);
    }

    public abstract zzfst zza(zzfsm zzfsm);

    public abstract Object zzb(Object obj);
}
