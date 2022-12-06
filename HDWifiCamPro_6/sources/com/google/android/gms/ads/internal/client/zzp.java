package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzcgi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzp {
    public static final zzp zza = new zzp();

    protected zzp() {
    }

    public final zzl zza(Context context, zzdr zzdr) {
        List list;
        Context context2;
        zzc zzc;
        String str;
        zzdr zzdr2 = zzdr;
        Date zzo = zzdr.zzo();
        long time = zzo != null ? zzo.getTime() : -1;
        String zzl = zzdr.zzl();
        int zza2 = zzdr.zza();
        Set zzr = zzdr.zzr();
        if (!zzr.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(zzr));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean zzt = zzdr2.zzt(context2);
        Bundle zzf = zzdr2.zzf(AdMobAdapter.class);
        AdInfo zzi = zzdr.zzi();
        if (zzi != null) {
            QueryInfo queryInfo = zzi.getQueryInfo();
            zzc = new zzc(zzdr.zzi().getAdString(), queryInfo != null ? queryInfo.zza().zzc() : "");
        } else {
            zzc = null;
        }
        String zzm = zzdr.zzm();
        SearchAdRequest zzj = zzdr.zzj();
        zzfb zzfb = zzj != null ? new zzfb(zzj) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzaw.zzb();
            str = zzcgi.zzp(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean zzs = zzdr.zzs();
        RequestConfiguration zzc2 = zzed.zzf().zzc();
        return new zzl(8, time, zzf, zza2, list, zzt, Math.max(zzdr.zzc(), zzc2.getTagForChildDirectedTreatment()), false, zzm, zzfb, (Location) null, zzl, zzdr.zzg(), zzdr.zze(), Collections.unmodifiableList(new ArrayList(zzdr.zzq())), zzdr.zzn(), str, zzs, zzc, Math.max(-1, zzc2.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(new String[]{null, zzc2.getMaxAdContentRating()}), zzo.zza), zzdr.zzp(), zzdr.zzb(), zzdr.zzk());
    }
}
