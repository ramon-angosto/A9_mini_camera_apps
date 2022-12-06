package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbz;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.zzs;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfef {
    public final zzff zza;
    public final zzbsc zzb;
    public final zzeof zzc;
    public final zzl zzd;
    public final zzq zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbls zzi;
    public final zzw zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final zzbz zzn;
    public final zzfds zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final zzcd zzr;

    /* synthetic */ zzfef(zzfed zzfed, zzfee zzfee) {
        zzff zzff;
        zzbls zzbls;
        this.zze = zzfed.zzb;
        this.zzf = zzfed.zzc;
        this.zzr = zzfed.zzs;
        int i = zzfed.zza.zza;
        long j = zzfed.zza.zzb;
        Bundle bundle = zzfed.zza.zzc;
        int i2 = zzfed.zza.zzd;
        List list = zzfed.zza.zze;
        boolean z = zzfed.zza.zzf;
        int i3 = zzfed.zza.zzg;
        boolean z2 = true;
        if (!zzfed.zza.zzh && !zzfed.zze) {
            z2 = false;
        }
        this.zzd = new zzl(i, j, bundle, i2, list, z, i3, z2, zzfed.zza.zzi, zzfed.zza.zzj, zzfed.zza.zzk, zzfed.zza.zzl, zzfed.zza.zzm, zzfed.zza.zzn, zzfed.zza.zzo, zzfed.zza.zzp, zzfed.zza.zzq, zzfed.zza.zzr, zzfed.zza.zzs, zzfed.zza.zzt, zzfed.zza.zzu, zzfed.zza.zzv, zzs.zza(zzfed.zza.zzw), zzfed.zza.zzx);
        if (zzfed.zzd != null) {
            zzff = zzfed.zzd;
        } else {
            zzff = zzfed.zzh != null ? zzfed.zzh.zzf : null;
        }
        this.zza = zzff;
        this.zzg = zzfed.zzf;
        this.zzh = zzfed.zzg;
        if (zzfed.zzf == null) {
            zzbls = null;
        } else {
            zzbls = zzfed.zzh == null ? new zzbls(new NativeAdOptions.Builder().build()) : zzfed.zzh;
        }
        this.zzi = zzbls;
        this.zzj = zzfed.zzi;
        this.zzk = zzfed.zzm;
        this.zzl = zzfed.zzj;
        this.zzm = zzfed.zzk;
        this.zzn = zzfed.zzl;
        this.zzb = zzfed.zzn;
        this.zzo = new zzfds(zzfed.zzo, (zzfdr) null);
        this.zzp = zzfed.zzp;
        this.zzc = zzfed.zzq;
        this.zzq = zzfed.zzr;
    }

    public final zzbnv zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzb();
        }
        return this.zzl.zza();
    }
}
