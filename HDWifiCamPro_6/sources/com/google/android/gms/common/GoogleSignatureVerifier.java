package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    private final Context zzb;
    private volatile String zzc;

    public GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzm.zzd(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @Nullable
    static final zzi zza(PackageInfo packageInfo, zzi... zziArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzj zzj = new zzj(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zziArr.length; i++) {
            if (zziArr[i].equals(zzj)) {
                return zziArr[i];
            }
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo, boolean z) {
        zzi zzi;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzi = zza(packageInfo, zzl.zza);
            } else {
                zzi = zza(packageInfo, zzl.zza[0]);
            }
            if (zzi != null) {
                return true;
            }
        }
        return false;
    }

    private final zzw zzc(String str, boolean z, boolean z2) {
        zzw zzw;
        if (str == null) {
            return zzw.zzc("null pkg");
        }
        if (str.equals(this.zzc)) {
            return zzw.zzb();
        }
        if (zzm.zze()) {
            zzw = zzm.zzb(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.zzb.getPackageManager().getPackageInfo(str, 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
                if (packageInfo == null) {
                    zzw = zzw.zzc("null pkg");
                } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                    zzw = zzw.zzc("single cert required");
                } else {
                    zzj zzj = new zzj(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzw zza2 = zzm.zza(str2, zzj, honorsDebugCertificates, false);
                    zzw = (!zza2.zza || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzm.zza(str2, zzj, false, true).zza) ? zza2 : zzw.zzc("debuggable release cert app rejected");
                }
            } catch (PackageManager.NameNotFoundException e) {
                return zzw.zzd(str.length() != 0 ? "no pkg ".concat(str) : new String("no pkg "), e);
            }
        }
        if (zzw.zza) {
            this.zzc = str;
        }
        return zzw;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(String str) {
        zzw zzc2 = zzc(str, false, false);
        zzc2.zze();
        return zzc2.zza;
    }

    public boolean isUidGoogleSigned(int i) {
        zzw zzw;
        int length;
        String[] packagesForUid = this.zzb.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzw = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Preconditions.checkNotNull(zzw);
                    break;
                }
                zzw = zzc(packagesForUid[i2], false, false);
                if (zzw.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzw = zzw.zzc("no pkgs");
        }
        zzw.zze();
        return zzw.zza;
    }
}
