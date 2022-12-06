package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbty implements zzbsp, zzbtx {
    private final zzbtx zza;
    private final HashSet zzb = new HashSet();

    public zzbty(zzbtx zzbtx) {
        this.zza = zzbtx;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbso.zzc(this, str, str2);
    }

    public final void zzc() {
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it.next();
            zze.zza("Unregistering eventhandler: ".concat(String.valueOf(((zzbpu) simpleEntry.getValue()).toString())));
            this.zza.zzr((String) simpleEntry.getKey(), (zzbpu) simpleEntry.getValue());
        }
        this.zzb.clear();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbso.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbso.zzb(this, str, jSONObject);
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbso.zzd(this, str, jSONObject);
    }

    public final void zzq(String str, zzbpu zzbpu) {
        this.zza.zzq(str, zzbpu);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbpu));
    }

    public final void zzr(String str, zzbpu zzbpu) {
        this.zza.zzr(str, zzbpu);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbpu));
    }
}
