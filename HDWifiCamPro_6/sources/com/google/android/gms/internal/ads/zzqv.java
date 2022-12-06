package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzqv implements zzre {
    public static final /* synthetic */ zzqv zza = new zzqv();

    private /* synthetic */ zzqv() {
    }

    public final int zza(Object obj) {
        int i = zzrf.zza;
        String str = ((zzqn) obj).zza;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        if (zzen.zza >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
            return 0;
        }
        return -1;
    }
}
