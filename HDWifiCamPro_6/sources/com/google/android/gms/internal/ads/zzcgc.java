package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Clock;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcgc implements zzbcj {
    final zzcfz zza;
    final HashSet zzb = new HashSet();
    final HashSet zzc = new HashSet();
    private final Object zzd = new Object();
    private final zzg zze;
    private final zzcga zzf;
    private boolean zzg = false;

    public zzcgc(String str, zzg zzg2) {
        this.zza = new zzcfz(str, zzg2);
        this.zze = zzg2;
        this.zzf = new zzcga();
    }

    public final void zza(boolean z) {
        long currentTimeMillis = zzt.zzB().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zze.zzd() > ((Long) zzay.zzc().zzb(zzbjc.zzaN)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = this.zze.zzc();
            }
            this.zzg = true;
            return;
        }
        this.zze.zzt(currentTimeMillis);
        this.zze.zzJ(this.zza.zzd);
    }

    public final zzcfr zzb(Clock clock, String str) {
        return new zzcfr(clock, this, this.zzf.zza(), str);
    }

    public final void zzc(zzcfr zzcfr) {
        synchronized (this.zzd) {
            this.zzb.add(zzcfr);
        }
    }

    public final void zzd() {
        synchronized (this.zzd) {
            this.zza.zzb();
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            this.zza.zzc();
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zze();
        }
    }

    public final void zzh(zzl zzl, long j) {
        synchronized (this.zzd) {
            this.zza.zzf(zzl, j);
        }
    }

    public final void zzi(HashSet hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final boolean zzj() {
        return this.zzg;
    }

    public final Bundle zzk(Context context, zzffk zzffk) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zza(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator it = this.zzc.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzcfr) it2.next()).zza());
            }
            bundle.putParcelableArrayList(CampaignUnit.JSON_KEY_ADS, arrayList);
            zzffk.zzc(hashSet);
            return bundle;
        }
        zzcgb zzcgb = (zzcgb) it.next();
        throw null;
    }
}
