package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcfy {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final zzj zzb = new zzj();
    private final zzcgc zzc = new zzcgc(zzaw.zzd(), this.zzb);
    private boolean zzd = false;
    /* access modifiers changed from: private */
    public Context zze;
    /* access modifiers changed from: private */
    public zzcgv zzf;
    /* access modifiers changed from: private */
    public zzbjh zzg = null;
    private Boolean zzh = null;
    private final AtomicInteger zzi = new AtomicInteger(0);
    private final zzcfx zzj = new zzcfx((zzcfw) null);
    private final Object zzk = new Object();
    private zzfzp zzl;
    /* access modifiers changed from: private */
    public final AtomicBoolean zzm = new AtomicBoolean();

    public final int zza() {
        return this.zzi.get();
    }

    public final Context zzc() {
        return this.zze;
    }

    public final Resources zzd() {
        if (this.zzf.zzd) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zziy)).booleanValue()) {
                return zzcgt.zza(this.zze).getResources();
            }
            zzcgt.zza(this.zze).getResources();
            return null;
        } catch (zzcgs e) {
            zze.zzk("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final zzbjh zzf() {
        zzbjh zzbjh;
        synchronized (this.zza) {
            zzbjh = this.zzg;
        }
        return zzbjh;
    }

    public final zzcgc zzg() {
        return this.zzc;
    }

    public final zzg zzh() {
        zzj zzj2;
        synchronized (this.zza) {
            zzj2 = this.zzb;
        }
        return zzj2;
    }

    public final zzfzp zzj() {
        if (this.zze != null) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzcl)).booleanValue()) {
                synchronized (this.zzk) {
                    zzfzp zzfzp = this.zzl;
                    if (zzfzp != null) {
                        return zzfzp;
                    }
                    zzfzp zzb2 = zzchc.zza.zzb(new zzcft(this));
                    this.zzl = zzb2;
                    return zzb2;
                }
            }
        }
        return zzfzg.zzi(new ArrayList());
    }

    public final Boolean zzk() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzh;
        }
        return bool;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzm() throws Exception {
        Context zza2 = zzcbq.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(zza2).getPackageInfo(zza2.getApplicationInfo().packageName, 4096);
            if (!(packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null)) {
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(packageInfo.requestedPermissions[i]);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final void zzo() {
        this.zzj.zza();
    }

    public final void zzp() {
        this.zzi.decrementAndGet();
    }

    public final void zzq() {
        this.zzi.incrementAndGet();
    }

    public final void zzr(Context context, zzcgv zzcgv) {
        zzbjh zzbjh;
        synchronized (this.zza) {
            if (!this.zzd) {
                this.zze = context.getApplicationContext();
                this.zzf = zzcgv;
                zzt.zzb().zzc(this.zzc);
                this.zzb.zzr(this.zze);
                zzcaf.zzb(this.zze, this.zzf);
                zzt.zze();
                if (!((Boolean) zzbkm.zzc.zze()).booleanValue()) {
                    zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzbjh = null;
                } else {
                    zzbjh = new zzbjh();
                }
                this.zzg = zzbjh;
                if (this.zzg != null) {
                    zzchf.zza(new zzcfu(this).zzb(), "AppState.registerCsiReporter");
                }
                if (PlatformVersion.isAtLeastO()) {
                    if (((Boolean) zzay.zzc().zzb(zzbjc.zzhl)).booleanValue()) {
                        ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzcfv(this));
                    }
                }
                this.zzd = true;
                zzj();
            }
        }
        zzt.zzp().zzc(context, zzcgv.zza);
    }

    public final void zzs(Throwable th, String str) {
        zzcaf.zzb(this.zze, this.zzf).zze(th, str, ((Double) zzbla.zzg.zze()).floatValue());
    }

    public final void zzt(Throwable th, String str) {
        zzcaf.zzb(this.zze, this.zzf).zzd(th, str);
    }

    public final void zzu(Boolean bool) {
        synchronized (this.zza) {
            this.zzh = bool;
        }
    }

    public final boolean zzv(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzhl)).booleanValue()) {
                return this.zzm.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
