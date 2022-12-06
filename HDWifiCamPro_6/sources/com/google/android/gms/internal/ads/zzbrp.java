package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbrp implements zzajw {
    /* access modifiers changed from: private */
    public volatile zzbrc zza;
    private final Context zzb;

    public zzbrp(Context context) {
        this.zzb = context;
    }

    static /* bridge */ /* synthetic */ void zzc(zzbrp zzbrp) {
        if (zzbrp.zza != null) {
            zzbrp.zza.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzajz zza(zzakd zzakd) throws zzakm {
        Parcelable.Creator<zzbrd> creator = zzbrd.CREATOR;
        Map zzl = zzakd.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry entry : zzl.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzbrd zzbrd = new zzbrd(zzakd.zzk(), strArr, strArr2);
        long elapsedRealtime = zzt.zzB().elapsedRealtime();
        try {
            zzchh zzchh = new zzchh();
            this.zza = new zzbrc(this.zzb, zzt.zzt().zzb(), new zzbrn(this, zzchh), new zzbro(this, zzchh));
            this.zza.checkAvailabilityAndConnect();
            zzfzp zzo = zzfzg.zzo(zzfzg.zzn(zzchh, new zzbrl(this, zzbrd), zzchc.zza), (long) ((Integer) zzay.zzc().zzb(zzbjc.zzdE)).intValue(), TimeUnit.MILLISECONDS, zzchc.zzd);
            zzo.zzc(new zzbrm(this), zzchc.zza);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzo.get();
            long elapsedRealtime2 = zzt.zzB().elapsedRealtime();
            zze.zza("Http assets remote cache took " + (elapsedRealtime2 - elapsedRealtime) + "ms");
            zzbrf zzbrf = (zzbrf) new zzcba(parcelFileDescriptor).zza(zzbrf.CREATOR);
            if (zzbrf == null) {
                return null;
            }
            if (zzbrf.zza) {
                throw new zzakm(zzbrf.zzb);
            } else if (zzbrf.zze.length != zzbrf.zzf.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzbrf.zze;
                    if (i >= strArr3.length) {
                        return new zzajz(zzbrf.zzc, zzbrf.zzd, (Map) hashMap, zzbrf.zzg, zzbrf.zzh);
                    }
                    hashMap.put(strArr3[i], zzbrf.zzf[i]);
                    i++;
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
            long elapsedRealtime3 = zzt.zzB().elapsedRealtime();
            zze.zza("Http assets remote cache took " + (elapsedRealtime3 - elapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            long elapsedRealtime4 = zzt.zzB().elapsedRealtime();
            zze.zza("Http assets remote cache took " + (elapsedRealtime4 - elapsedRealtime) + "ms");
            throw th;
        }
    }
}
