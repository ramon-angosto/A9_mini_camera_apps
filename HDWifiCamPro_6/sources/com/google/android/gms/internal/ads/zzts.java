package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzts {
    private final zzef zza = new zzef(32);
    private zztr zzb = new zztr(0, 65536);
    private zztr zzc;
    private zztr zzd;
    private long zze;
    private final zzwi zzf;

    public zzts(zzwi zzwi, byte[] bArr) {
        this.zzf = zzwi;
        zztr zztr = this.zzb;
        this.zzc = zztr;
        this.zzd = zztr;
    }

    private final int zzi(int i) {
        zztr zztr = this.zzd;
        if (zztr.zzc == null) {
            zzwb zzb2 = this.zzf.zzb();
            zztr zztr2 = new zztr(this.zzd.zzb, 65536);
            zztr.zzc = zzb2;
            zztr.zzd = zztr2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zztr zzj(zztr zztr, long j) {
        while (j >= zztr.zzb) {
            zztr = zztr.zzd;
        }
        return zztr;
    }

    private static zztr zzk(zztr zztr, long j, ByteBuffer byteBuffer, int i) {
        zztr zzj = zzj(zztr, j);
        while (i > 0) {
            int min = Math.min(i, (int) (zzj.zzb - j));
            byteBuffer.put(zzj.zzc.zza, zzj.zza(j), min);
            i -= min;
            j += (long) min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zztr zzl(zztr zztr, long j, byte[] bArr, int i) {
        long j2 = j;
        zztr zzj = zzj(zztr, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (zzj.zzb - j2));
            System.arraycopy(zzj.zzc.zza, zzj.zza(j2), bArr, i - i2, min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zztr zzm(zztr zztr, zzgi zzgi, zztu zztu, zzef zzef) {
        zztr zztr2;
        zzgi zzgi2 = zzgi;
        zztu zztu2 = zztu;
        zzef zzef2 = zzef;
        if (zzgi.zzk()) {
            long j = zztu2.zzb;
            int i = 1;
            zzef2.zzC(1);
            zztr zzl = zzl(zztr, j, zzef.zzH(), 1);
            long j2 = j + 1;
            byte b = zzef.zzH()[0];
            byte b2 = b & ByteCompanionObject.MIN_VALUE;
            byte b3 = b & ByteCompanionObject.MAX_VALUE;
            zzgf zzgf = zzgi2.zza;
            byte[] bArr = zzgf.zza;
            if (bArr == null) {
                zzgf.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            zztr2 = zzl(zzl, j2, zzgf.zza, b3);
            long j3 = j2 + ((long) b3);
            if (b2 != 0) {
                zzef2.zzC(2);
                zztr2 = zzl(zztr2, j3, zzef.zzH(), 2);
                j3 += 2;
                i = zzef.zzo();
            }
            int i2 = i;
            int[] iArr = zzgf.zzd;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzgf.zze;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (b2 != 0) {
                int i3 = i2 * 6;
                zzef2.zzC(i3);
                zztr2 = zzl(zztr2, j3, zzef.zzH(), i3);
                j3 += (long) i3;
                zzef2.zzF(0);
                for (int i4 = 0; i4 < i2; i4++) {
                    iArr2[i4] = zzef.zzo();
                    iArr4[i4] = zzef.zzn();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zztu2.zza - ((int) (j3 - zztu2.zzb));
            }
            zzaao zzaao = zztu2.zzc;
            int i5 = zzen.zza;
            zzgf.zzc(i2, iArr2, iArr4, zzaao.zzb, zzgf.zza, zzaao.zza, zzaao.zzc, zzaao.zzd);
            long j4 = zztu2.zzb;
            int i6 = (int) (j3 - j4);
            zztu2.zzb = j4 + ((long) i6);
            zztu2.zza -= i6;
        } else {
            zztr2 = zztr;
        }
        if (zzgi.zze()) {
            zzef2.zzC(4);
            zztr zzl2 = zzl(zztr2, zztu2.zzb, zzef.zzH(), 4);
            int zzn = zzef.zzn();
            zztu2.zzb += 4;
            zztu2.zza -= 4;
            zzgi2.zzi(zzn);
            zztr zzk = zzk(zzl2, zztu2.zzb, zzgi2.zzb, zzn);
            zztu2.zzb += (long) zzn;
            int i7 = zztu2.zza - zzn;
            zztu2.zza = i7;
            ByteBuffer byteBuffer = zzgi2.zze;
            if (byteBuffer == null || byteBuffer.capacity() < i7) {
                zzgi2.zze = ByteBuffer.allocate(i7);
            } else {
                zzgi2.zze.clear();
            }
            return zzk(zzk, zztu2.zzb, zzgi2.zze, zztu2.zza);
        }
        zzgi2.zzi(zztu2.zza);
        return zzk(zztr2, zztu2.zzb, zzgi2.zzb, zztu2.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zztr zztr = this.zzd;
        if (j == zztr.zzb) {
            this.zzd = zztr.zzd;
        }
    }

    public final int zza(zzr zzr, int i, boolean z) throws IOException {
        int zzi = zzi(i);
        zztr zztr = this.zzd;
        int zza2 = zzr.zza(zztr.zzc.zza, zztr.zza(this.zze), zzi);
        if (zza2 != -1) {
            zzn(zza2);
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zztr zztr;
        if (j != -1) {
            while (true) {
                zztr = this.zzb;
                if (j < zztr.zzb) {
                    break;
                }
                this.zzf.zzc(zztr.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zztr.zza) {
                this.zzc = zztr;
            }
        }
    }

    public final void zzd(zzgi zzgi, zztu zztu) {
        zzm(this.zzc, zzgi, zztu, this.zza);
    }

    public final void zze(zzgi zzgi, zztu zztu) {
        this.zzc = zzm(this.zzc, zzgi, zztu, this.zza);
    }

    public final void zzf() {
        zztr zztr = this.zzb;
        if (zztr.zzc != null) {
            this.zzf.zzd(zztr);
            zztr.zzb();
        }
        this.zzb.zze(0, 65536);
        zztr zztr2 = this.zzb;
        this.zzc = zztr2;
        this.zzd = zztr2;
        this.zze = 0;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzef zzef, int i) {
        while (i > 0) {
            int zzi = zzi(i);
            zztr zztr = this.zzd;
            zzef.zzB(zztr.zzc.zza, zztr.zza(this.zze), zzi);
            i -= zzi;
            zzn(zzi);
        }
    }
}
