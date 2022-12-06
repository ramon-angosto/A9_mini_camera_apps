package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzjr implements zzjn {
    public final zzsd zza;
    public final Object zzb = new Object();
    public final List zzc = new ArrayList();
    public int zzd;
    public boolean zze;

    public zzjr(zzsk zzsk, boolean z) {
        this.zza = new zzsd(zzsk, z);
    }

    public final zzcn zza() {
        return this.zza.zzA();
    }

    public final Object zzb() {
        return this.zzb;
    }

    public final void zzc(int i) {
        this.zzd = i;
        this.zze = false;
        this.zzc.clear();
    }
}
