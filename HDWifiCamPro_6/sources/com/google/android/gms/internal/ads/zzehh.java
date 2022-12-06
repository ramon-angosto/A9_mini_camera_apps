package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzehh {
    private final List zza = Collections.synchronizedList(new ArrayList());
    private final Map zzb = Collections.synchronizedMap(new HashMap());
    private final String zzc;
    private zzfdn zzd = null;
    private zzfdk zze = null;
    private zzu zzf = null;

    public zzehh(String str) {
        this.zzc = str;
    }

    private final void zzh(zzfdk zzfdk, long j, zze zze2, boolean z) {
        String str = zzfdk.zzx;
        if (this.zzb.containsKey(str)) {
            if (this.zze == null) {
                this.zze = zzfdk;
            }
            zzu zzu = (zzu) this.zzb.get(str);
            zzu.zzb = j;
            zzu.zzc = zze2;
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzfS)).booleanValue() && z) {
                this.zzf = zzu;
            }
        }
    }

    public final zzu zza() {
        return this.zzf;
    }

    public final zzdct zzb() {
        return new zzdct(this.zze, "", this, this.zzd, this.zzc);
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zzfdk zzfdk) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = zzfdk.zzx;
        if (!this.zzb.containsKey(str5)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzfdk.zzw.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzfdk.zzw.getString(next));
                } catch (JSONException unused) {
                }
            }
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzfR)).booleanValue()) {
                String str6 = zzfdk.zzG;
                String str7 = zzfdk.zzH;
                str4 = str6;
                str3 = str7;
                str2 = zzfdk.zzI;
                str = zzfdk.zzJ;
            } else {
                str4 = "";
                str3 = str4;
                str2 = str3;
                str = str2;
            }
            zzu zzu = new zzu(zzfdk.zzF, 0, (zze) null, bundle, str4, str3, str2, str);
            this.zza.add(zzu);
            this.zzb.put(str5, zzu);
        }
    }

    public final void zze(zzfdk zzfdk, long j, zze zze2) {
        zzh(zzfdk, j, zze2, false);
    }

    public final void zzf(zzfdk zzfdk, long j, zze zze2) {
        zzh(zzfdk, j, (zze) null, true);
    }

    public final void zzg(zzfdn zzfdn) {
        this.zzd = zzfdn;
    }
}
