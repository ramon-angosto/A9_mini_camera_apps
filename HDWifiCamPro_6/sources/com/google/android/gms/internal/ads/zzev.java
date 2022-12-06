package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import com.facebook.ads.AdError;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzev extends zzer {
    private zzfc zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzev() {
        super(false);
    }

    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(zzen.zzH(this.zzb), this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzfc zzfc) throws IOException {
        zzi(zzfc);
        this.zza = zzfc;
        Uri uri = zzfc.zza;
        String scheme = uri.getScheme();
        zzdd.zze(DataSchemeDataSource.SCHEME_DATA.equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String[] zzag = zzen.zzag(uri.getSchemeSpecificPart(), ",");
        if (zzag.length == 2) {
            String str = zzag[1];
            if (zzag[0].contains(";base64")) {
                try {
                    this.zzb = Base64.decode(str, 0);
                } catch (IllegalArgumentException e) {
                    throw zzbu.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e);
                }
            } else {
                this.zzb = zzen.zzaa(URLDecoder.decode(str, zzfsk.zza.name()));
            }
            long j = zzfc.zzf;
            int length = this.zzb.length;
            if (j <= ((long) length)) {
                int i = (int) j;
                this.zzc = i;
                int i2 = length - i;
                this.zzd = i2;
                long j2 = zzfc.zzg;
                if (j2 != -1) {
                    this.zzd = (int) Math.min((long) i2, j2);
                }
                zzj(zzfc);
                long j3 = zzfc.zzg;
                return j3 != -1 ? j3 : (long) this.zzd;
            }
            this.zzb = null;
            throw new zzey(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        throw zzbu.zzb("Unexpected URI format: ".concat(String.valueOf(String.valueOf(uri))), (Throwable) null);
    }

    public final Uri zzc() {
        zzfc zzfc = this.zza;
        if (zzfc != null) {
            return zzfc.zza;
        }
        return null;
    }

    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
