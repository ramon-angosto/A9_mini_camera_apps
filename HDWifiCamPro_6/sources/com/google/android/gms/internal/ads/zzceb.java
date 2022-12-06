package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzceb extends zzcev {
    private final Clock zzb;
    private final zzceb zzc = this;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;
    private final zzgxv zzk;

    /* synthetic */ zzceb(Context context, Clock clock, zzg zzg2, zzceu zzceu, zzcea zzcea) {
        this.zzb = clock;
        this.zzd = zzgxj.zza(context);
        this.zze = zzgxj.zza(zzg2);
        this.zzf = zzgxj.zza(zzceu);
        this.zzg = zzgxh.zzc(new zzcdt(this.zzd, this.zze, this.zzf));
        this.zzh = zzgxj.zza(clock);
        this.zzi = zzgxh.zzc(new zzcdv(this.zzh, this.zze, this.zzf));
        this.zzj = new zzcdx(this.zzh, this.zzi);
        this.zzk = zzgxh.zzc(new zzcfa(this.zzd, this.zzj));
    }

    /* access modifiers changed from: package-private */
    public final zzcds zza() {
        return (zzcds) this.zzg.zzb();
    }

    /* access modifiers changed from: package-private */
    public final zzcdw zzb() {
        return new zzcdw(this.zzb, (zzcdu) this.zzi.zzb());
    }

    /* access modifiers changed from: package-private */
    public final zzcez zzc() {
        return (zzcez) this.zzk.zzb();
    }
}
