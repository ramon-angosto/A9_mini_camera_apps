package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzm {
    static final zzk zza = new zze(zzi.zze("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));
    static final zzk zzb = new zzf(zzi.zze("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));
    static final zzk zzc = new zzg(zzi.zze("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));
    static final zzk zzd = new zzh(zzi.zze("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));
    private static volatile zzaf zze;
    private static final Object zzf = new Object();
    private static Context zzg;

    static zzw zza(String str, zzi zzi, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzf(str, zzi, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    static zzw zzb(String str, boolean z, boolean z2, boolean z3) {
        zzw zzw;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzg);
            try {
                zzg();
                zzq zze2 = zze.zze(new zzn(str, z, false, ObjectWrapper.wrap(zzg), false));
                if (zze2.zzb()) {
                    zzw = zzw.zzb();
                } else {
                    String zza2 = zze2.zza();
                    if (zza2 == null) {
                        zza2 = "error checking package certificate";
                    }
                    zzw = zze2.zzc() == 4 ? zzw.zzd(zza2, new PackageManager.NameNotFoundException()) : zzw.zzc(zza2);
                }
            } catch (DynamiteModule.LoadingException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                String valueOf = String.valueOf(e.getMessage());
                zzw = zzw.zzd(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e);
            }
        } catch (RemoteException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            zzw = zzw.zzd("module call", e2);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return zzw;
    }

    static /* synthetic */ String zzc(boolean z, String str, zzi zzi) throws Exception {
        String str2 = true != (!z && zzf(str, zzi, true, false).zza) ? "not allowed" : "debug cert rejected";
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-1");
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[]{str2, str, Hex.bytesToStringLowercase(zza2.digest(zzi.zzf())), Boolean.valueOf(z), "12451000.false"});
    }

    static synchronized void zzd(Context context) {
        synchronized (zzm.class) {
            if (zzg != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzg = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    static boolean zze() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            zzg();
            boolean zzg2 = zze.zzg();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zzg2;
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    private static zzw zzf(String str, zzi zzi, boolean z, boolean z2) {
        try {
            zzg();
            Preconditions.checkNotNull(zzg);
            try {
                return zze.zzf(new zzs(str, zzi, z, z2), ObjectWrapper.wrap(zzg.getPackageManager())) ? zzw.zzb() : new zzv(new zzd(z, str, zzi), (zzu) null);
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return zzw.zzd("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String valueOf = String.valueOf(e2.getMessage());
            return zzw.zzd(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e2);
        }
    }

    private static void zzg() throws DynamiteModule.LoadingException {
        if (zze == null) {
            Preconditions.checkNotNull(zzg);
            synchronized (zzf) {
                if (zze == null) {
                    zze = zzae.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }
}
