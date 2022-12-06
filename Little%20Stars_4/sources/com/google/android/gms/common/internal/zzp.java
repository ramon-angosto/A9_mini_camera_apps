package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzp {
    public static final int zzase = 15;
    private static final String zzasf = null;
    private final String zzasg;
    private final String zzash;

    public zzp(String str) {
        this(str, (String) null);
    }

    public zzp(String str, String str2) {
        zzaa.zzb(str, (Object) "log tag cannot be null");
        zzaa.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zzasg = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzash = null;
        } else {
            this.zzash = str2;
        }
    }

    private String zzdj(String str) {
        String str2 = this.zzash;
        return str2 == null ? str : str2.concat(str);
    }

    public void zzC(String str, String str2) {
        if (zzcd(3)) {
            Log.d(str, zzdj(str2));
        }
    }

    public void zzD(String str, String str2) {
        if (zzcd(5)) {
            Log.w(str, zzdj(str2));
        }
    }

    public void zzE(String str, String str2) {
        if (zzcd(6)) {
            Log.e(str, zzdj(str2));
        }
    }

    public void zza(String str, String str2, Throwable th) {
        if (zzcd(4)) {
            Log.i(str, zzdj(str2), th);
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzcd(5)) {
            Log.w(str, zzdj(str2), th);
        }
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzcd(6)) {
            Log.e(str, zzdj(str2), th);
        }
    }

    public boolean zzcd(int i) {
        return Log.isLoggable(this.zzasg, i);
    }

    public void zzd(String str, String str2, Throwable th) {
        if (zzcd(7)) {
            Log.e(str, zzdj(str2), th);
            Log.wtf(str, zzdj(str2), th);
        }
    }
}
