package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfnq {
    private final Context zza;
    private final Executor zzb;
    private final zzfmx zzc;
    private final zzfmz zzd;
    private final zzfnp zze;
    private final zzfnp zzf;
    private Task zzg;
    private Task zzh;

    zzfnq(Context context, Executor executor, zzfmx zzfmx, zzfmz zzfmz, zzfnn zzfnn, zzfno zzfno) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfmx;
        this.zzd = zzfmz;
        this.zze = zzfnn;
        this.zzf = zzfno;
    }

    public static zzfnq zze(Context context, Executor executor, zzfmx zzfmx, zzfmz zzfmz) {
        zzfnq zzfnq = new zzfnq(context, executor, zzfmx, zzfmz, new zzfnn(), new zzfno());
        if (zzfnq.zzd.zzd()) {
            zzfnq.zzg = zzfnq.zzh(new zzfnk(zzfnq));
        } else {
            zzfnq.zzg = Tasks.forResult(zzfnq.zze.zza());
        }
        zzfnq.zzh = zzfnq.zzh(new zzfnl(zzfnq));
        return zzfnq;
    }

    private static zzana zzg(Task task, zzana zzana) {
        if (!task.isSuccessful()) {
            return zzana;
        }
        return (zzana) task.getResult();
    }

    private final Task zzh(Callable callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, (OnFailureListener) new zzfnm(this));
    }

    public final zzana zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzana zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzana zzc() throws Exception {
        Context context = this.zza;
        zzamk zza2 = zzana.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        String id = advertisingIdInfo.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zza2.zzs(id);
            zza2.zzr(advertisingIdInfo.isLimitAdTrackingEnabled());
            zza2.zzab(6);
        }
        return (zzana) zza2.zzam();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzana zzd() throws Exception {
        Context context = this.zza;
        return zzfnf.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1, exc);
    }
}
