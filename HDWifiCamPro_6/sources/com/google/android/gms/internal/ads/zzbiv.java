package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbiv {
    private final Collection zza = new ArrayList();
    private final Collection zzb = new ArrayList();
    private final Collection zzc = new ArrayList();

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (zzbiu zzb2 : this.zzb) {
            String str = (String) zzay.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbjd.zza());
        return arrayList;
    }

    public final List zzb() {
        List zza2 = zza();
        for (zzbiu zzb2 : this.zzc) {
            String str = (String) zzay.zzc().zzb(zzb2);
            if (!TextUtils.isEmpty(str)) {
                zza2.add(str);
            }
        }
        zza2.addAll(zzbjd.zzb());
        return zza2;
    }

    public final void zzc(zzbiu zzbiu) {
        this.zzb.add(zzbiu);
    }

    public final void zzd(zzbiu zzbiu) {
        this.zza.add(zzbiu);
    }

    public final void zze(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzbiu zzbiu : this.zza) {
            if (zzbiu.zze() == 1) {
                zzbiu.zzd(editor, zzbiu.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzcgp.zzg("Flag Json is null.");
        }
    }
}
