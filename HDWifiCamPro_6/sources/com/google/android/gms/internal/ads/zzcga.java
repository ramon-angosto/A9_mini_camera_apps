package com.google.android.gms.internal.ads;

import com.mbridge.msdk.MBridgeConstans;
import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcga {
    private BigInteger zza = BigInteger.ONE;
    private String zzb = MBridgeConstans.ENDCARD_URL_TYPE_PL;

    public final synchronized String zza() {
        String bigInteger;
        bigInteger = this.zza.toString();
        this.zza = this.zza.add(BigInteger.ONE);
        this.zzb = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzb() {
        return this.zzb;
    }
}
