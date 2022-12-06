package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.flags.impl.zza;
import com.google.android.gms.internal.zzsg;

@DynamiteApi
public class FlagProviderImpl extends zzsg.zza {
    private boolean zzru = false;
    private SharedPreferences zzwV;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return zza.C0014zza.zza(this.zzwV, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return zza.zzb.zza(this.zzwV, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return zza.zzc.zza(this.zzwV, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return zza.zzd.zza(this.zzwV, str, str2);
    }

    public void init(zzd zzd) {
        Context context = (Context) zze.zzx(zzd);
        if (!this.zzru) {
            try {
                this.zzwV = zzb.zzn(context.createPackageContext("com.google.android.gms", 0));
                this.zzru = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }
}
