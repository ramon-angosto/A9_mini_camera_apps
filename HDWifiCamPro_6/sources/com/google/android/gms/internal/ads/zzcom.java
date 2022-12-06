package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzaa;
import com.google.android.gms.ads.nonagon.signalgeneration.zzc;
import com.google.android.gms.ads.nonagon.signalgeneration.zzg;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzcom implements zzctt {
    @Nullable
    private static zzcom zza;

    private static synchronized zzcom zzC(Context context, @Nullable zzbvk zzbvk, int i, boolean z, int i2, zzcpo zzcpo) {
        synchronized (zzcom.class) {
            zzcom zzcom = zza;
            if (zzcom != null) {
                return zzcom;
            }
            zzbjc.zzc(context);
            zzfey zzd = zzfey.zzd(context);
            zzcgv zzc = zzd.zzc(223104000, false, i2);
            zzd.zze(zzbvk);
            zzcqy zzcqy = new zzcqy((zzcqx) null);
            zzcon zzcon = new zzcon();
            zzcon.zzd(zzc);
            zzcon.zzc(context);
            zzcqy.zzb(new zzcop(zzcon, (zzcoo) null));
            zzcqy.zzc(new zzcsl(zzcpo, (byte[]) null));
            zzcom zza2 = zzcqy.zza();
            zzt.zzo().zzr(context, zzc);
            zzt.zzc().zzi(context);
            zzt.zzp().zzj(context);
            zzt.zzp().zzi(context);
            zzd.zza(context);
            zzt.zzb().zzd(context);
            zzt.zzv().zzb(context);
            zzcev.zzd(context);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzfm)).booleanValue()) {
                if (!((Boolean) zzay.zzc().zzb(zzbjc.zzas)).booleanValue()) {
                    zzbep zzbep = new zzbep(new zzbev(context));
                    zzefk zzefk = new zzefk(new zzefg(context), zza2.zzz());
                    zzt.zzp();
                    new zzegg(context, zzc, zzbep, zzefk, UUID.randomUUID().toString(), zza2.zzx()).zzb(zzt.zzo().zzh().zzP());
                }
            }
            zza = zza2;
            return zza2;
        }
    }

    public static zzcom zza(Context context, @Nullable zzbvk zzbvk, int i) {
        return zzC(context, zzbvk, 223104000, false, i, new zzcpo());
    }

    public abstract Executor zzA();

    public abstract ScheduledExecutorService zzB();

    public abstract zzcsw zzb();

    public abstract zzcwe zzc();

    public abstract zzcwp zzd();

    public abstract zzcxy zze();

    public abstract zzdfp zzf();

    public abstract zzdmg zzg();

    public abstract zzdnc zzh();

    public abstract zzdug zzi();

    public abstract zzdyy zzj();

    public abstract zzeak zzk();

    public abstract zzegw zzl();

    public abstract zzc zzm();

    public abstract zzg zzn();

    public abstract zzaa zzo();

    public final zzevw zzp(zzcbc zzcbc, int i) {
        return zzq(new zzexi(zzcbc, i));
    }

    /* access modifiers changed from: protected */
    public abstract zzevw zzq(zzexi zzexi);

    public abstract zzeyi zzr();

    public abstract zzezw zzs();

    public abstract zzfbp zzt();

    public abstract zzfdd zzu();

    public abstract zzfer zzv();

    public abstract zzffb zzw();

    public abstract zzfir zzx();

    public abstract zzfjw zzy();

    public abstract zzfzq zzz();
}
