package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzbyz;
import com.google.android.gms.internal.ads.zzccx;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgv;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzaw {
    private static final zzaw zza = new zzaw();
    private final zzcgi zzb;
    private final zzau zzc;
    private final String zzd;
    private final zzcgv zze;
    private final Random zzf;

    protected zzaw() {
        zzcgi zzcgi = new zzcgi();
        zzau zzau = new zzau(new zzk(), new zzi(), new zzek(), new zzbod(), new zzccx(), new zzbyz(), new zzboe());
        String zzd2 = zzcgi.zzd();
        zzcgv zzcgv = new zzcgv(0, 223104000, true, false, false);
        Random random = new Random();
        this.zzb = zzcgi;
        this.zzc = zzau;
        this.zzd = zzd2;
        this.zze = zzcgv;
        this.zzf = random;
    }

    public static zzau zza() {
        return zza.zzc;
    }

    public static zzcgi zzb() {
        return zza.zzb;
    }

    public static zzcgv zzc() {
        return zza.zze;
    }

    public static String zzd() {
        return zza.zzd;
    }

    public static Random zze() {
        return zza.zzf;
    }
}
