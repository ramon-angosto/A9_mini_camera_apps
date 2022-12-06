package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfnb extends zzfmy {
    private String zza;
    private boolean zzb;
    private boolean zzc;
    private byte zzd;

    zzfnb() {
    }

    public final zzfmy zza(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }

    public final zzfmy zzb(boolean z) {
        this.zzc = true;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    public final zzfmy zzc(boolean z) {
        this.zzb = z;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    public final zzfmz zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzfnd(str, this.zzb, this.zzc, (zzfnc) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" clientVersion");
        }
        if ((this.zzd & 1) == 0) {
            sb.append(" shouldGetAdvertisingId");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" isGooglePlayServicesAvailable");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
