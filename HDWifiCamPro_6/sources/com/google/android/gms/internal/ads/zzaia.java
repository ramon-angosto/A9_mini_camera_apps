package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaia implements zzzi {
    public static final zzzp zza = zzahy.zza;
    private final zzel zzb = new zzel(0);
    private final SparseArray zzc = new SparseArray();
    private final zzef zzd = new zzef(4096);
    private final zzahx zze = new zzahx();
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private long zzi;
    private zzahw zzj;
    private zzzl zzk;
    private boolean zzl;

    public final int zza(zzzj zzzj, zzaai zzaai) throws IOException {
        zzahc zzahc;
        zzzj zzzj2 = zzzj;
        zzaai zzaai2 = zzaai;
        zzdd.zzb(this.zzk);
        long zzd2 = zzzj.zzd();
        int i = (zzd2 > -1 ? 1 : (zzd2 == -1 ? 0 : -1));
        if (i != 0) {
            zzahx zzahx = this.zze;
            if (!zzahx.zze()) {
                return zzahx.zza(zzzj2, zzaai2);
            }
        }
        if (!this.zzl) {
            this.zzl = true;
            zzahx zzahx2 = this.zze;
            if (zzahx2.zzb() != C.TIME_UNSET) {
                this.zzj = new zzahw(zzahx2.zzd(), zzahx2.zzb(), zzd2);
                this.zzk.zzN(this.zzj.zzb());
            } else {
                this.zzk.zzN(new zzaak(zzahx2.zzb(), 0));
            }
        }
        zzahw zzahw = this.zzj;
        if (zzahw != null && zzahw.zze()) {
            return zzahw.zza(zzzj2, zzaai2);
        }
        zzzj.zzj();
        long zze2 = i != 0 ? zzd2 - zzzj.zze() : -1;
        if ((zze2 != -1 && zze2 < 4) || !zzzj2.zzm(this.zzd.zzH(), 0, 4, true)) {
            return -1;
        }
        this.zzd.zzF(0);
        int zze3 = this.zzd.zze();
        if (zze3 == 441) {
            return -1;
        }
        if (zze3 == 442) {
            zzyy zzyy = (zzyy) zzzj2;
            zzyy.zzm(this.zzd.zzH(), 0, 10, false);
            this.zzd.zzF(9);
            zzyy.zzo((this.zzd.zzk() & 7) + 14, false);
            return 0;
        } else if (zze3 == 443) {
            zzyy zzyy2 = (zzyy) zzzj2;
            zzyy2.zzm(this.zzd.zzH(), 0, 2, false);
            this.zzd.zzF(0);
            zzyy2.zzo(this.zzd.zzo() + 6, false);
            return 0;
        } else if ((zze3 >> 8) != 1) {
            ((zzyy) zzzj2).zzo(1, false);
            return 0;
        } else {
            int i2 = zze3 & 255;
            zzahz zzahz = (zzahz) this.zzc.get(i2);
            if (!this.zzf) {
                if (zzahz == null) {
                    if (i2 == 189) {
                        zzahc = new zzags((String) null);
                        this.zzg = true;
                        this.zzi = zzzj.zzf();
                    } else if ((i2 & 224) == 192) {
                        zzahc = new zzahq((String) null);
                        this.zzg = true;
                        this.zzi = zzzj.zzf();
                    } else if ((i2 & PsExtractor.VIDEO_STREAM_MASK) == 224) {
                        zzahc = new zzahe((zzair) null);
                        this.zzh = true;
                        this.zzi = zzzj.zzf();
                    } else {
                        zzahc = null;
                    }
                    if (zzahc != null) {
                        zzahc.zzb(this.zzk, new zzaio(Integer.MIN_VALUE, i2, 256));
                        zzahz = new zzahz(zzahc, this.zzb);
                        this.zzc.put(i2, zzahz);
                    }
                }
                long j = 1048576;
                if (this.zzg && this.zzh) {
                    j = this.zzi + 8192;
                }
                if (zzzj.zzf() > j) {
                    this.zzf = true;
                    this.zzk.zzC();
                }
            }
            zzyy zzyy3 = (zzyy) zzzj2;
            zzyy3.zzm(this.zzd.zzH(), 0, 2, false);
            this.zzd.zzF(0);
            int zzo = this.zzd.zzo() + 6;
            if (zzahz == null) {
                zzyy3.zzo(zzo, false);
            } else {
                this.zzd.zzC(zzo);
                zzyy3.zzn(this.zzd.zzH(), 0, zzo, false);
                this.zzd.zzF(6);
                zzahz.zza(this.zzd);
                zzef zzef = this.zzd;
                zzef.zzE(zzef.zzb());
            }
            return 0;
        }
    }

    public final void zzb(zzzl zzzl) {
        this.zzk = zzzl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r0 != r7) goto L_0x0021;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[LOOP:0: B:12:0x002c->B:14:0x0034, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(long r5, long r7) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzel r5 = r4.zzb
            long r0 = r5.zze()
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0021
            long r0 = r5.zzc()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            int r6 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
        L_0x0021:
            r5.zzf(r7)
        L_0x0024:
            com.google.android.gms.internal.ads.zzahw r5 = r4.zzj
            r6 = 0
            if (r5 == 0) goto L_0x002c
            r5.zzd(r7)
        L_0x002c:
            android.util.SparseArray r5 = r4.zzc
            int r5 = r5.size()
            if (r6 >= r5) goto L_0x0042
            android.util.SparseArray r5 = r4.zzc
            java.lang.Object r5 = r5.valueAt(r6)
            com.google.android.gms.internal.ads.zzahz r5 = (com.google.android.gms.internal.ads.zzahz) r5
            r5.zzb()
            int r6 = r6 + 1
            goto L_0x002c
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaia.zzc(long, long):void");
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        byte[] bArr = new byte[14];
        zzyy zzyy = (zzyy) zzzj;
        zzyy.zzm(bArr, 0, 14, false);
        if ((((bArr[0] & UByte.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzyy.zzl(bArr[13] & 7, false);
        zzyy.zzm(bArr, 0, 3, false);
        return ((((bArr[0] & UByte.MAX_VALUE) << 16) | ((bArr[1] & UByte.MAX_VALUE) << 8)) | (bArr[2] & UByte.MAX_VALUE)) == 1;
    }
}
