package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfmo extends zzfmj {
    public zzfmo(zzfmc zzfmc, HashSet hashSet, JSONObject jSONObject, long j, byte[] bArr) {
        super(zzfmc, hashSet, jSONObject, j, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzflw.zzj(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzflg zza;
        if (!TextUtils.isEmpty(str) && (zza = zzflg.zza()) != null) {
            for (zzfkv zzfkv : zza.zzc()) {
                if (this.zza.contains(zzfkv.zzh())) {
                    zzfkv.zzg().zze(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
