package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.vungle.warren.VungleApiClient;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzevt implements zzeve {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final zzcfp zze;

    public zzevt(zzcfp zzcfp, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, byte[] bArr) {
        this.zze = zzcfp;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
    }

    public final int zza() {
        return 40;
    }

    public final zzfzp zzb() {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzaO)).booleanValue()) {
            return zzfzg.zzh(new Exception("Did not ad Ad ID into query param."));
        }
        return zzfzg.zzf((zzfyx) zzfzg.zzo(zzfzg.zzm(zzfyx.zzv(this.zze.zza(this.zza, this.zzd)), zzevr.zza, this.zzc), ((Long) zzay.zzc().zzb(zzbjc.zzaP)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzevs(this), this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzevu zzc(Throwable th) {
        String str;
        zzaw.zzb();
        ContentResolver contentResolver = this.zza.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(contentResolver, VungleApiClient.ANDROID_ID);
        }
        return new zzevu((AdvertisingIdClient.Info) null, str);
    }
}
