package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;

public final class zztw implements Api.ApiOptions.Optional {
    public static final zztw zzbnf = new zza().zzIS();
    private final boolean zzacA;
    private final boolean zzacC;
    private final String zzacD;
    private final String zzacE;
    private final boolean zzbng;
    private final boolean zzbnh;

    public static final class zza {
        public zztw zzIS() {
            return new zztw(false, false, (String) null, false, (String) null, false);
        }
    }

    private zztw(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4) {
        this.zzbng = z;
        this.zzacA = z2;
        this.zzacD = str;
        this.zzacC = z3;
        this.zzbnh = z4;
        this.zzacE = str2;
    }

    public boolean zzIQ() {
        return this.zzbng;
    }

    public boolean zzIR() {
        return this.zzbnh;
    }

    public boolean zzpk() {
        return this.zzacA;
    }

    public boolean zzpm() {
        return this.zzacC;
    }

    public String zzpn() {
        return this.zzacD;
    }

    @Nullable
    public String zzpo() {
        return this.zzacE;
    }
}
