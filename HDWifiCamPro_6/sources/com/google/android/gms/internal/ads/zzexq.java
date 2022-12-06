package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzexq implements zzgxi {
    public static zzevh zza(Context context, zzcfm zzcfm, zzcfn zzcfn, Object obj, zzevz zzevz, zzexc zzexc, zzgxc zzgxc, zzgxc zzgxc2, zzgxc zzgxc3, zzgxc zzgxc4, zzgxc zzgxc5, zzgxc zzgxc6, zzgxc zzgxc7, zzgxc zzgxc8, zzgxc zzgxc9, Executor executor, zzfju zzfju, zzdxq zzdxq) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzewv) obj);
        zzevz zzevz2 = zzevz;
        hashSet.add(zzevz);
        zzexc zzexc2 = zzexc;
        hashSet.add(zzexc);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeO)).booleanValue()) {
            hashSet.add((zzeve) zzgxc.zzb());
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeP)).booleanValue()) {
            hashSet.add((zzeve) zzgxc2.zzb());
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeQ)).booleanValue()) {
            hashSet.add((zzeve) zzgxc3.zzb());
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeR)).booleanValue()) {
            hashSet.add((zzeve) zzgxc4.zzb());
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeV)).booleanValue()) {
            hashSet.add((zzeve) zzgxc6.zzb());
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeW)).booleanValue()) {
            hashSet.add((zzeve) zzgxc7.zzb());
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcs)).booleanValue()) {
            hashSet.add((zzeve) zzgxc9.zzb());
        }
        return new zzevh(context, executor, hashSet, zzfju, zzdxq);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
