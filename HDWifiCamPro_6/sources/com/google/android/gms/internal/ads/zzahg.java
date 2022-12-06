package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzahg {
    private final zzaap zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    public zzahg(zzaap zzaap) {
        this.zza = zzaap;
    }

    public final void zza(byte[] bArr, int i, int i2) {
        if (this.zzc) {
            int i3 = this.zzf;
            int i4 = (i + 1) - i3;
            if (i4 < i2) {
                this.zzd = ((bArr[i4] & 192) >> 6) == 0;
                this.zzc = false;
                return;
            }
            this.zzf = i3 + (i2 - i);
        }
    }

    public final void zzb(long j, int i, boolean z) {
        if (this.zze == 182 && z && this.zzb) {
            long j2 = this.zzh;
            if (j2 != C.TIME_UNSET) {
                long j3 = this.zzg;
                int i2 = (int) (j - j3);
                this.zza.zzs(j2, this.zzd ? 1 : 0, i2, i, (zzaao) null);
            }
        }
        if (this.zze != 179) {
            this.zzg = j;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(int r5, long r6) {
        /*
            r4 = this;
            r4.zze = r5
            r0 = 0
            r4.zzd = r0
            r1 = 179(0xb3, float:2.51E-43)
            r2 = 182(0xb6, float:2.55E-43)
            r3 = 1
            if (r5 == r2) goto L_0x0012
            if (r5 != r1) goto L_0x000f
            goto L_0x0013
        L_0x000f:
            r1 = r5
            r5 = r0
            goto L_0x0014
        L_0x0012:
            r1 = r5
        L_0x0013:
            r5 = r3
        L_0x0014:
            r4.zzb = r5
            if (r1 != r2) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r3 = r0
        L_0x001a:
            r4.zzc = r3
            r4.zzf = r0
            r4.zzh = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahg.zzc(int, long):void");
    }

    public final void zzd() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }
}
