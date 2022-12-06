package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfjw implements Runnable {
    public static Boolean zza;
    private final Context zzb;
    private final zzcgv zzc;
    private final zzfkb zzd = zzfke.zzc();
    private String zze;
    private int zzf;
    private final zzdvi zzg;
    private boolean zzh = false;
    private final zzeep zzi;
    private final zzcbo zzj;

    public zzfjw(Context context, zzcgv zzcgv, zzdvi zzdvi, zzeep zzeep, zzcbo zzcbo, byte[] bArr) {
        this.zzb = context;
        this.zzc = zzcgv;
        this.zzg = zzdvi;
        this.zzi = zzeep;
        this.zzj = zzcbo;
    }

    public static synchronized boolean zza() {
        boolean booleanValue;
        synchronized (zzfjw.class) {
            if (zza == null) {
                boolean z = false;
                if (!((Boolean) zzbkl.zzb.zze()).booleanValue()) {
                    zza = false;
                } else {
                    if (Math.random() < ((Double) zzbkl.zza.zze()).doubleValue()) {
                        z = true;
                    }
                    zza = Boolean.valueOf(z);
                }
            }
            booleanValue = zza.booleanValue();
        }
        return booleanValue;
    }

    private final synchronized void zzc() {
        if (!this.zzh) {
            this.zzh = true;
            if (zza()) {
                zzt.zzp();
                this.zze = zzs.zzo(this.zzb);
                this.zzf = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzb);
                long intValue = (long) ((Integer) zzay.zzc().zzb(zzbjc.zzhx)).intValue();
                zzchc.zzd.scheduleAtFixedRate(this, intValue, intValue, TimeUnit.MILLISECONDS);
            }
        }
    }

    private final synchronized void zzd() {
        try {
            new zzeeo(this.zzb, this.zzc.zza, this.zzj, Binder.getCallingUid(), (byte[]) null).zza(new zzeem((String) zzay.zzc().zzb(zzbjc.zzhw), 60000, new HashMap(), ((zzfke) this.zzd.zzam()).zzax(), "application/x-protobuf"));
            this.zzd.zzc();
        } catch (Exception e) {
            if (!(e instanceof zzebh) || ((zzebh) e).zza() != 3) {
                zzt.zzo().zzs(e, "CuiMonitor.sendCuiPing");
            } else {
                this.zzd.zzc();
            }
        }
    }

    public final synchronized void run() {
        if (zza()) {
            if (this.zzd.zza() != 0) {
                zzd();
            }
        }
    }

    public final synchronized void zzb(zzfjn zzfjn) {
        if (!this.zzh) {
            zzc();
        }
        if (zza()) {
            if (zzfjn != null) {
                if (this.zzd.zza() < ((Integer) zzay.zzc().zzb(zzbjc.zzhy)).intValue()) {
                    zzfkb zzfkb = this.zzd;
                    zzfkc zza2 = zzfkd.zza();
                    zzfjy zza3 = zzfjz.zza();
                    zza3.zzo(zzfjn.zzh());
                    zza3.zzl(zzfjn.zzg());
                    zza3.zze(zzfjn.zzb());
                    zza3.zzq(3);
                    zza3.zzk(this.zzc.zza);
                    zza3.zza(this.zze);
                    zza3.zzi(Build.VERSION.RELEASE);
                    zza3.zzm(Build.VERSION.SDK_INT);
                    zza3.zzp(zzfjn.zzj());
                    zza3.zzh(zzfjn.zza());
                    zza3.zzc((long) this.zzf);
                    zza3.zzn(zzfjn.zzi());
                    zza3.zzb(zzfjn.zzc());
                    zza3.zzd(zzfjn.zzd());
                    zza3.zzf(zzfjn.zze());
                    zza3.zzg(this.zzg.zzc(zzfjn.zze()));
                    zza3.zzj(zzfjn.zzf());
                    zza2.zza(zza3);
                    zzfkb.zzb(zza2);
                }
            }
        }
    }
}
