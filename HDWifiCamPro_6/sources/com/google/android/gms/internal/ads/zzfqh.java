package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfqh extends zzfrb {
    private IBinder zza;
    private String zzb;
    private int zzc;
    private float zzd;
    private int zze;
    private String zzf;
    private byte zzg;

    zzfqh() {
    }

    public final zzfrb zza(String str) {
        this.zzf = str;
        return this;
    }

    public final zzfrb zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfrb zzc(int i) {
        this.zzg = (byte) (this.zzg | 8);
        return this;
    }

    public final zzfrb zzd(int i) {
        this.zzc = i;
        this.zzg = (byte) (this.zzg | 2);
        return this;
    }

    public final zzfrb zze(float f) {
        this.zzd = f;
        this.zzg = (byte) (this.zzg | 4);
        return this;
    }

    public final zzfrb zzf(boolean z) {
        this.zzg = (byte) (this.zzg | 1);
        return this;
    }

    public final zzfrb zzg(IBinder iBinder) {
        if (iBinder != null) {
            this.zza = iBinder;
            return this;
        }
        throw new NullPointerException("Null windowToken");
    }

    public final zzfrb zzh(int i) {
        this.zze = i;
        this.zzg = (byte) (this.zzg | 16);
        return this;
    }

    public final zzfrc zzi() {
        IBinder iBinder;
        if (this.zzg == 31 && (iBinder = this.zza) != null) {
            return new zzfqj(iBinder, false, this.zzb, this.zzc, this.zzd, 0, (String) null, this.zze, this.zzf, (zzfqi) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" windowToken");
        }
        if ((this.zzg & 1) == 0) {
            sb.append(" stableSessionToken");
        }
        if ((this.zzg & 2) == 0) {
            sb.append(" layoutGravity");
        }
        if ((this.zzg & 4) == 0) {
            sb.append(" layoutVerticalMargin");
        }
        if ((this.zzg & 8) == 0) {
            sb.append(" displayMode");
        }
        if ((this.zzg & 16) == 0) {
            sb.append(" windowWidthPx");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
