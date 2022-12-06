package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzcev {
    static zzcev zza;

    public static synchronized zzcev zzd(Context context) {
        synchronized (zzcev.class) {
            zzcev zzcev = zza;
            if (zzcev != null) {
                return zzcev;
            }
            Context applicationContext = context.getApplicationContext();
            zzbjc.zzc(applicationContext);
            zzg zzh = zzt.zzo().zzh();
            zzh.zzr(applicationContext);
            zzcdz zzcdz = new zzcdz((zzcdy) null);
            zzcdz.zzb(applicationContext);
            zzcdz.zzc(zzt.zzB());
            zzcdz.zza(zzh);
            zzcdz.zzd(zzt.zzn());
            zza = zzcdz.zze();
            zza.zza().zza();
            zza.zzb().zzc();
            zzcez zzc = zza.zzc();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzao)).booleanValue()) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject((String) zzay.zzc().zzb(zzbjc.zzaq));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashSet hashSet = new HashSet();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                String optString = optJSONArray.optString(i);
                                if (optString != null) {
                                    hashSet.add(optString);
                                }
                            }
                            hashMap.put(next, hashSet);
                        }
                    }
                    for (String zzc2 : hashMap.keySet()) {
                        zzc.zzc(zzc2);
                    }
                    zzc.zzd(new zzcex(zzc, hashMap));
                } catch (JSONException e) {
                    zze.zzf("Failed to parse listening list", e);
                }
            }
            zzcev zzcev2 = zza;
            return zzcev2;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract zzcds zza();

    /* access modifiers changed from: package-private */
    public abstract zzcdw zzb();

    /* access modifiers changed from: package-private */
    public abstract zzcez zzc();
}
