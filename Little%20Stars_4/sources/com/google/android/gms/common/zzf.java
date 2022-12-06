package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zzd;

public class zzf {
    private static zzf zzakC;
    private final Context mContext;

    private zzf(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static zzf zzaq(Context context) {
        zzaa.zzz(context);
        synchronized (zzf.class) {
            if (zzakC == null) {
                zzd.zzah(context);
                zzakC = new zzf(context);
            }
        }
        return zzakC;
    }

    /* access modifiers changed from: package-private */
    public zzd.zza zza(PackageInfo packageInfo, zzd.zza... zzaArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzd.zzb zzb = new zzd.zzb(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzaArr.length; i++) {
            if (zzaArr[i].equals(zzb)) {
                return zzaArr[i];
            }
        }
        String valueOf = String.valueOf(packageInfo.packageName);
        String valueOf2 = String.valueOf(Base64.encodeToString(zzb.getBytes(), 0));
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append(" signature not valid.  Found: \n");
        sb.append(valueOf2);
        Log.v("GoogleSignatureVerifier", sb.toString());
        return null;
    }

    public boolean zza(PackageInfo packageInfo, boolean z) {
        zzd.zza zza;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zza = zza(packageInfo, zzd.C0010zzd.zzakt);
            } else {
                zza = zza(packageInfo, zzd.C0010zzd.zzakt[0]);
            }
            if (zza != null) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zze.zzal(this.mContext)) {
            return zza(packageInfo, true);
        }
        boolean zza = zza(packageInfo, false);
        if (!zza && zza(packageInfo, true)) {
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return zza;
    }
}
