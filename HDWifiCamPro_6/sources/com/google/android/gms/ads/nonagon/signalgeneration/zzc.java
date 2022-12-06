package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzdxl;
import com.google.android.gms.internal.ads.zzdxv;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzc {
    /* access modifiers changed from: private */
    public final int zza;
    private final long zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final Map zze;
    /* access modifiers changed from: private */
    public final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();
    private final zzdxv zzh;
    private Map zzi;

    public zzc(zzdxv zzdxv) {
        this.zzh = zzdxv;
        this.zza = ((Integer) zzay.zzc().zzb(zzbjc.zzgb)).intValue();
        this.zzb = ((Long) zzay.zzc().zzb(zzbjc.zzgc)).longValue();
        this.zzc = ((Boolean) zzay.zzc().zzb(zzbjc.zzgh)).booleanValue();
        this.zzd = ((Boolean) zzay.zzc().zzb(zzbjc.zzgf)).booleanValue();
        this.zze = Collections.synchronizedMap(new zzb(this));
    }

    private final synchronized void zzg(zzdxl zzdxl) {
        if (this.zzc) {
            ArrayDeque clone = this.zzg.clone();
            this.zzg.clear();
            ArrayDeque clone2 = this.zzf.clone();
            this.zzf.clear();
            zzchc.zza.execute(new zza(this, zzdxl, clone, clone2));
        }
    }

    private final void zzh(zzdxl zzdxl, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            this.zzi = new ConcurrentHashMap(zzdxl.zza());
            this.zzi.put("action", "ev");
            this.zzi.put("e_r", str);
            this.zzi.put("e_id", (String) pair2.first);
            if (this.zzd) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(zzf.zza(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                zzj(this.zzi, "e_type", (String) pair.first);
                zzj(this.zzi, "e_agent", (String) pair.second);
            }
            this.zzh.zze(this.zzi);
        }
    }

    private final synchronized void zzi() {
        long currentTimeMillis = zzt.zzB().currentTimeMillis();
        try {
            Iterator it = this.zze.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (currentTimeMillis - ((Long) ((Pair) entry.getValue()).first).longValue() <= this.zzb) {
                    break;
                }
                this.zzg.add(new Pair((String) entry.getKey(), (String) ((Pair) entry.getValue()).second));
                it.remove();
            }
        } catch (ConcurrentModificationException e) {
            zzt.zzo().zzt(e, "QueryJsonMap.removeExpiredEntries");
        }
    }

    private static final void zzj(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public final synchronized String zzb(String str, zzdxl zzdxl) {
        Pair pair = (Pair) this.zze.get(str);
        zzdxl.zza().put("rid", str);
        if (pair != null) {
            String str2 = (String) pair.second;
            this.zze.remove(str);
            zzdxl.zza().put("mhit", "true");
            return str2;
        }
        zzdxl.zza().put("mhit", "false");
        return null;
    }

    public final synchronized void zzd(String str, String str2, zzdxl zzdxl) {
        this.zze.put(str, new Pair(Long.valueOf(zzt.zzB().currentTimeMillis()), str2));
        zzi();
        zzg(zzdxl);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzdxl zzdxl, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        zzh(zzdxl, arrayDeque, "to");
        zzh(zzdxl, arrayDeque2, "of");
    }

    public final synchronized void zzf(String str) {
        this.zze.remove(str);
    }
}
