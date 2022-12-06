package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbc;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzk;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzciz {
    private final Context zza;
    private final String zzb;
    private final zzcgv zzc;
    private final zzbjo zzd;
    private final zzbjr zze;
    private final zzbf zzf;
    private final long[] zzg;
    private final String[] zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm;
    private zzcie zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq = -1;

    public zzciz(Context context, zzcgv zzcgv, String str, zzbjr zzbjr, zzbjo zzbjo) {
        zzbd zzbd = new zzbd();
        zzbd zzbd2 = zzbd;
        zzbd2.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbd2.zza("1_5", 1.0d, 5.0d);
        zzbd2.zza("5_10", 5.0d, 10.0d);
        zzbd2.zza("10_20", 10.0d, 20.0d);
        zzbd2.zza("20_30", 20.0d, 30.0d);
        zzbd2.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzf = zzbd.zzb();
        this.zza = context;
        this.zzc = zzcgv;
        this.zzb = str;
        this.zze = zzbjr;
        this.zzd = zzbjo;
        String str2 = (String) zzay.zzc().zzb(zzbjc.zzy);
        if (str2 == null) {
            this.zzh = new String[0];
            this.zzg = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzh = new String[length];
        this.zzg = new long[length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzg[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zze.zzk("Unable to parse frame hash target time number.", e);
                this.zzg[i] = -1;
            }
        }
    }

    public final void zza(zzcie zzcie) {
        zzbjj.zza(this.zze, this.zzd, "vpc2");
        this.zzi = true;
        this.zze.zzd("vpn", zzcie.zzj());
        this.zzn = zzcie;
    }

    public final void zzb() {
        if (this.zzi && !this.zzj) {
            zzbjj.zza(this.zze, this.zzd, "vfr2");
            this.zzj = true;
        }
    }

    public final void zzc() {
        this.zzm = true;
        if (this.zzj && !this.zzk) {
            zzbjj.zza(this.zze, this.zzd, "vfp2");
            this.zzk = true;
        }
    }

    public final void zzd() {
        if (((Boolean) zzblg.zza.zze()).booleanValue() && !this.zzo) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzb);
            bundle.putString("player", this.zzn.zzj());
            for (zzbc zzbc : this.zzf.zza()) {
                bundle.putString("fps_c_".concat(String.valueOf(zzbc.zza)), Integer.toString(zzbc.zze));
                bundle.putString("fps_p_".concat(String.valueOf(zzbc.zza)), Double.toString(zzbc.zzd));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzg;
                if (i < jArr.length) {
                    String str = this.zzh[i];
                    if (str != null) {
                        Long valueOf = Long.valueOf(jArr[i]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("fh_");
                        sb.append(valueOf);
                        bundle.putString("fh_".concat(valueOf.toString()), str);
                    }
                    i++;
                } else {
                    zzt.zzp();
                    Context context = this.zza;
                    String str2 = this.zzc.zza;
                    zzt.zzp();
                    bundle.putString("device", zzs.zzq());
                    bundle.putString("eids", TextUtils.join(",", zzbjc.zza()));
                    zzaw.zzb();
                    zzcgi.zzv(context, str2, "gmob-apps", bundle, true, new zzk(context, str2));
                    this.zzo = true;
                    return;
                }
            }
        }
    }

    public final void zze() {
        this.zzm = false;
    }

    public final void zzf(zzcie zzcie) {
        if (this.zzk && !this.zzl) {
            if (zze.zzc() && !this.zzl) {
                zze.zza("VideoMetricsMixin first frame");
            }
            zzbjj.zza(this.zze, this.zzd, "vff2");
            this.zzl = true;
        }
        long nanoTime = zzt.zzB().nanoTime();
        if (this.zzm && this.zzp && this.zzq != -1) {
            this.zzf.zzb(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzq)));
        }
        this.zzp = this.zzm;
        this.zzq = nanoTime;
        long longValue = ((Long) zzay.zzc().zzb(zzbjc.zzz)).longValue();
        long zza2 = (long) zzcie.zza();
        int i = 0;
        while (true) {
            String[] strArr = this.zzh;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(zza2 - this.zzg[i])) {
                String[] strArr2 = this.zzh;
                int i2 = 8;
                Bitmap bitmap = zzcie.getBitmap(8, 8);
                int i3 = 0;
                long j = 63;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    long j4 = j2;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j4 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j2 = j4;
                    i2 = 8;
                    j = j3;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
            zzcie zzcie2 = zzcie;
            i++;
        }
    }
}
