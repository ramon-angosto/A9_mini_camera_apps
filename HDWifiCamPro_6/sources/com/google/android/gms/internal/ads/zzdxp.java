package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxp {
    final /* synthetic */ zzdxq zza;
    private final Map zzb = new ConcurrentHashMap();

    zzdxp(zzdxq zzdxq) {
        this.zza = zzdxq;
    }

    public final zzdxp zzb(String str, String str2) {
        this.zzb.put(str, str2);
        return this;
    }

    public final zzdxp zzc(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdxp zzd(zzfdk zzfdk) {
        this.zzb.put("aai", zzfdk.zzx);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgd)).booleanValue()) {
            zzc("rid", zzfdk.zzap);
        }
        return this;
    }

    public final zzdxp zze(zzfdn zzfdn) {
        this.zzb.put("gqi", zzfdn.zzb);
        return this;
    }

    public final String zzf() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzg() {
        this.zza.zzb.execute(new zzdxo(this));
    }

    public final void zzh() {
        this.zza.zzb.execute(new zzdxn(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zza.zza.zze(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj() {
        this.zza.zza.zzd(this.zzb);
    }
}
