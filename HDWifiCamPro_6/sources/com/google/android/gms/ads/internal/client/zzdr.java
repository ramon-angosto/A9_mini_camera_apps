package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzcgi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzdr {
    private final Date zza;
    private final String zzb;
    private final List zzc;
    private final int zzd;
    private final Set zze;
    private final Bundle zzf;
    private final Map zzg;
    private final String zzh;
    private final String zzi;
    @NotOnlyInitialized
    private final SearchAdRequest zzj;
    private final int zzk;
    private final Set zzl;
    private final Bundle zzm;
    private final Set zzn;
    private final boolean zzo;
    private final AdInfo zzp;
    private final String zzq;
    private final int zzr;

    public zzdr(zzdq zzdq, SearchAdRequest searchAdRequest) {
        this.zza = zzdq.zzg;
        this.zzb = zzdq.zzh;
        this.zzc = zzdq.zzi;
        this.zzd = zzdq.zzj;
        this.zze = Collections.unmodifiableSet(zzdq.zza);
        this.zzf = zzdq.zzb;
        this.zzg = Collections.unmodifiableMap(zzdq.zzc);
        this.zzh = zzdq.zzk;
        this.zzi = zzdq.zzl;
        this.zzj = searchAdRequest;
        this.zzk = zzdq.zzm;
        this.zzl = Collections.unmodifiableSet(zzdq.zzd);
        this.zzm = zzdq.zze;
        this.zzn = Collections.unmodifiableSet(zzdq.zzf);
        this.zzo = zzdq.zzn;
        this.zzp = zzdq.zzo;
        this.zzq = zzdq.zzp;
        this.zzr = zzdq.zzq;
    }

    @Deprecated
    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzr;
    }

    public final int zzc() {
        return this.zzk;
    }

    public final Bundle zzd(Class cls) {
        Bundle bundle = this.zzf.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle zze() {
        return this.zzm;
    }

    public final Bundle zzf(Class cls) {
        return this.zzf.getBundle(cls.getName());
    }

    public final Bundle zzg() {
        return this.zzf;
    }

    @Deprecated
    public final NetworkExtras zzh(Class cls) {
        return (NetworkExtras) this.zzg.get(cls);
    }

    public final AdInfo zzi() {
        return this.zzp;
    }

    public final SearchAdRequest zzj() {
        return this.zzj;
    }

    public final String zzk() {
        return this.zzq;
    }

    public final String zzl() {
        return this.zzb;
    }

    public final String zzm() {
        return this.zzh;
    }

    public final String zzn() {
        return this.zzi;
    }

    @Deprecated
    public final Date zzo() {
        return this.zza;
    }

    public final List zzp() {
        return new ArrayList(this.zzc);
    }

    public final Set zzq() {
        return this.zzn;
    }

    public final Set zzr() {
        return this.zze;
    }

    @Deprecated
    public final boolean zzs() {
        return this.zzo;
    }

    public final boolean zzt(Context context) {
        RequestConfiguration zzc2 = zzed.zzf().zzc();
        zzaw.zzb();
        String zzx = zzcgi.zzx(context);
        return this.zzl.contains(zzx) || zzc2.getTestDeviceIds().contains(zzx);
    }
}
