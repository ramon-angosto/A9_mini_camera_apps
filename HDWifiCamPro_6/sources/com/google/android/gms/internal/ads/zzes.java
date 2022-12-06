package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzes extends zzer {
    private final byte[] zza;
    private Uri zzb;
    private int zzc;
    private int zzd;
    private boolean zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzes(byte[] bArr) {
        super(false);
        boolean z = false;
        if (bArr != null) {
            zzdd.zzd(bArr.length > 0 ? true : z);
            this.zza = bArr;
            return;
        }
        throw null;
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
        System.arraycopy(this.zza, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzfc zzfc) throws IOException {
        this.zzb = zzfc.zza;
        zzi(zzfc);
        long j = zzfc.zzf;
        int length = this.zza.length;
        if (j <= ((long) length)) {
            int i = (int) j;
            this.zzc = i;
            int i2 = length - i;
            this.zzd = i2;
            long j2 = zzfc.zzg;
            if (j2 != -1) {
                this.zzd = (int) Math.min((long) i2, j2);
            }
            this.zze = true;
            zzj(zzfc);
            long j3 = zzfc.zzg;
            return j3 != -1 ? j3 : (long) this.zzd;
        }
        throw new zzey(AdError.REMOTE_ADS_SERVICE_ERROR);
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zzb = null;
    }
}
