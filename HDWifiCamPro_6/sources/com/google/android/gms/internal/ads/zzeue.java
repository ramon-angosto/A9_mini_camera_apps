package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeue implements zzeve {
    final String zza;
    private final zzfzq zzb;
    private final ScheduledExecutorService zzc;
    private final zzenc zzd;
    private final Context zze;
    private final zzfef zzf;
    private final zzemy zzg;
    private final zzdvl zzh;

    public zzeue(zzfzq zzfzq, ScheduledExecutorService scheduledExecutorService, String str, zzenc zzenc, Context context, zzfef zzfef, zzemy zzemy, zzdvl zzdvl) {
        this.zzb = zzfzq;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzenc;
        this.zze = context;
        this.zzf = zzfef;
        this.zzg = zzemy;
        this.zzh = zzdvl;
    }

    public static /* synthetic */ zzfzp zzc(zzeue zzeue) {
        Map zza2 = zzeue.zzd.zza(zzeue.zza, ((Boolean) zzay.zzc().zzb(zzbjc.zziz)).booleanValue() ? zzeue.zzf.zzf.toLowerCase(Locale.ROOT) : zzeue.zzf.zzf);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((zzfvq) zza2).entrySet().iterator();
        while (true) {
            Bundle bundle = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            Bundle bundle2 = zzeue.zzf.zzd.zzm;
            if (bundle2 != null) {
                bundle = bundle2.getBundle(str);
            }
            arrayList.add(zzeue.zze(str, list, bundle, true, true));
        }
        for (Map.Entry value : ((zzfvq) zzeue.zzd.zzb()).entrySet()) {
            zzeng zzeng = (zzeng) value.getValue();
            String str2 = zzeng.zza;
            Bundle bundle3 = zzeue.zzf.zzd.zzm;
            arrayList.add(zzeue.zze(str2, Collections.singletonList(zzeng.zzd), bundle3 != null ? bundle3.getBundle(str2) : null, zzeng.zzb, zzeng.zzc));
        }
        return zzfzg.zzc(arrayList).zza(new zzeub(arrayList), zzeue.zzb);
    }

    private final zzfyx zze(String str, List list, Bundle bundle, boolean z, boolean z2) {
        zzfyx zzv = zzfyx.zzv(zzfzg.zzl(new zzeuc(this, str, list, bundle, z, z2), this.zzb));
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzbs)).booleanValue()) {
            zzv = (zzfyx) zzfzg.zzo(zzv, ((Long) zzay.zzc().zzb(zzbjc.zzbl)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzfyx) zzfzg.zzf(zzv, Throwable.class, new zzeud(str), this.zzb);
    }

    public final int zza() {
        return 32;
    }

    public final zzfzp zzb() {
        return zzfzg.zzl(new zzetz(this), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzd(String str, List list, Bundle bundle, boolean z, boolean z2) throws Exception {
        zzbxd zzbxd;
        zzbxd zzb2;
        zzchh zzchh = new zzchh();
        if (z2) {
            this.zzg.zzb(str);
            zzb2 = this.zzg.zza(str);
        } else {
            try {
                zzb2 = this.zzh.zzb(str);
            } catch (RemoteException e) {
                zze.zzh("Couldn't create RTB adapter : ", e);
                zzbxd = null;
            }
        }
        zzbxd = zzb2;
        if (zzbxd == null) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzbn)).booleanValue()) {
                zzenf.zzb(str, zzchh);
            } else {
                throw null;
            }
        } else {
            zzenf zzenf = new zzenf(str, zzbxd, zzchh);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzbs)).booleanValue()) {
                this.zzc.schedule(new zzeua(zzenf), ((Long) zzay.zzc().zzb(zzbjc.zzbl)).longValue(), TimeUnit.MILLISECONDS);
            }
            if (z) {
                zzbxd.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzenf);
            } else {
                zzenf.zzd();
            }
        }
        return zzchh;
    }
}
