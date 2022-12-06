package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbjd {
    static List zza() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbke.zzc("gad:dynamite_module:experiment_id", ""));
        zzc(arrayList, zzbkp.zza);
        zzc(arrayList, zzbkp.zzb);
        zzc(arrayList, zzbkp.zzc);
        zzc(arrayList, zzbkp.zzd);
        zzc(arrayList, zzbkp.zze);
        zzc(arrayList, zzbkp.zzu);
        zzc(arrayList, zzbkp.zzf);
        zzc(arrayList, zzbkp.zzm);
        zzc(arrayList, zzbkp.zzn);
        zzc(arrayList, zzbkp.zzo);
        zzc(arrayList, zzbkp.zzp);
        zzc(arrayList, zzbkp.zzq);
        zzc(arrayList, zzbkp.zzr);
        zzc(arrayList, zzbkp.zzs);
        zzc(arrayList, zzbkp.zzt);
        zzc(arrayList, zzbkp.zzg);
        zzc(arrayList, zzbkp.zzh);
        zzc(arrayList, zzbkp.zzi);
        zzc(arrayList, zzbkp.zzj);
        zzc(arrayList, zzbkp.zzk);
        zzc(arrayList, zzbkp.zzl);
        return arrayList;
    }

    static List zzb() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzblc.zza);
        return arrayList;
    }

    private static void zzc(List list, zzbke zzbke) {
        String str = (String) zzbke.zze();
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }
}
