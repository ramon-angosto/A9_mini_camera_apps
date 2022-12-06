package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfmn extends zzfmj {
    public zzfmn(zzfmc zzfmc, HashSet hashSet, JSONObject jSONObject, long j, byte[] bArr) {
        super(zzfmc, hashSet, jSONObject, j, (byte[]) null);
    }

    private final void zzc(String str) {
        zzflg zza = zzflg.zza();
        if (zza != null) {
            for (zzfkv zzfkv : zza.zzc()) {
                if (this.zza.contains(zzfkv.zzh())) {
                    zzfkv.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
