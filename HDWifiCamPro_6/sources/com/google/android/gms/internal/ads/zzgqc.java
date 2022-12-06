package com.google.android.gms.internal.ads;

import com.vungle.warren.downloader.DownloadRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgqc extends zzgqe {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl = Integer.MAX_VALUE;

    /* synthetic */ zzgqc(InputStream inputStream, int i, zzgqb zzgqb) {
        super((zzgqd) null);
        zzgro.zzf(inputStream, "input");
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        r6 = r6 - r3;
        r0.add(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List zzJ(int r6) throws java.io.IOException {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0005:
            if (r6 <= 0) goto L_0x002e
            r1 = 4096(0x1000, float:5.74E-42)
            int r1 = java.lang.Math.min(r6, r1)
            byte[] r1 = new byte[r1]
            r2 = 0
        L_0x0010:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x0029
            java.io.InputStream r4 = r5.zze
            int r3 = r3 - r2
            int r3 = r4.read(r1, r2, r3)
            r4 = -1
            if (r3 == r4) goto L_0x0024
            int r4 = r5.zzk
            int r4 = r4 + r3
            r5.zzk = r4
            int r2 = r2 + r3
            goto L_0x0010
        L_0x0024:
            com.google.android.gms.internal.ads.zzgrq r6 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r6
        L_0x0029:
            int r6 = r6 - r3
            r0.add(r1)
            goto L_0x0005
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqc.zzJ(int):java.util.List");
    }

    private final void zzK() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzh = i4;
            this.zzg = i - i4;
            return;
        }
        this.zzh = 0;
    }

    private final void zzL(int i) throws IOException {
        if (zzM(i)) {
            return;
        }
        if (i > (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw zzgrq.zzi();
        }
        throw zzgrq.zzj();
    }

    private final boolean zzM(int i) throws IOException {
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i2 + i > i3) {
            int i4 = this.zzk;
            if (i > (Integer.MAX_VALUE - i4) - i2 || i4 + i2 + i > this.zzl) {
                return false;
            }
            if (i2 > 0) {
                if (i3 > i2) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i2, bArr, 0, i3 - i2);
                }
                i4 = this.zzk + i2;
                this.zzk = i4;
                i3 = this.zzg - i2;
                this.zzg = i3;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i3, Math.min(4096 - i3, (Integer.MAX_VALUE - i4) - i3));
                if (read == 0 || read < -1 || read > 4096) {
                    throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzg += read;
                    zzK();
                    if (this.zzg >= i) {
                        return true;
                    }
                    return zzM(i);
                }
            } catch (zzgrq e) {
                e.zzk();
                throw e;
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
    }

    private final byte[] zzN(int i, boolean z) throws IOException {
        byte[] zzO = zzO(i);
        if (zzO != null) {
            return zzO;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int i4 = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzJ = zzJ(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzJ) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzO(int i) throws IOException {
        if (i == 0) {
            return zzgro.zzd;
        }
        if (i >= 0) {
            int i2 = this.zzk;
            int i3 = this.zzi;
            int i4 = i2 + i3 + i;
            if (DownloadRequest.Priority.CRITICAL + i4 <= 0) {
                int i5 = this.zzl;
                if (i4 <= i5) {
                    int i6 = this.zzg - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096) {
                        try {
                            if (i7 > this.zze.available()) {
                                return null;
                            }
                        } catch (zzgrq e) {
                            e.zzk();
                            throw e;
                        }
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.zzf, this.zzi, bArr, 0, i6);
                    this.zzk += this.zzg;
                    this.zzi = 0;
                    this.zzg = 0;
                    while (i6 < bArr.length) {
                        try {
                            int read = this.zze.read(bArr, i6, i - i6);
                            if (read != -1) {
                                this.zzk += read;
                                i6 += read;
                            } else {
                                throw zzgrq.zzj();
                            }
                        } catch (zzgrq e2) {
                            e2.zzk();
                            throw e2;
                        }
                    }
                    return bArr;
                }
                zzB((i5 - i2) - i3);
                throw zzgrq.zzj();
            }
            throw zzgrq.zzi();
        }
        throw zzgrq.zzf();
    }

    public final void zzA(int i) {
        this.zzl = i;
        zzK();
    }

    public final void zzB(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zzi;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzi = i3 + i;
        } else if (i >= 0) {
            int i5 = this.zzk;
            int i6 = i5 + i3;
            int i7 = this.zzl;
            if (i6 + i <= i7) {
                this.zzk = i6;
                this.zzg = 0;
                this.zzi = 0;
                while (i4 < i) {
                    try {
                        long j = (long) (i - i4);
                        long skip = this.zze.skip(j);
                        int i8 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i8 < 0 || skip > j) {
                            throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                        } else if (i8 == 0) {
                            break;
                        } else {
                            i4 += (int) skip;
                        }
                    } catch (zzgrq e) {
                        e.zzk();
                        throw e;
                    } catch (Throwable th) {
                        this.zzk += i4;
                        zzK();
                        throw th;
                    }
                }
                this.zzk += i4;
                zzK();
                if (i4 < i) {
                    int i9 = this.zzg;
                    int i10 = i9 - this.zzi;
                    this.zzi = i9;
                    zzL(1);
                    while (true) {
                        int i11 = i - i10;
                        int i12 = this.zzg;
                        if (i11 > i12) {
                            i10 += i12;
                            this.zzi = i12;
                            zzL(1);
                        } else {
                            this.zzi = i11;
                            return;
                        }
                    }
                }
            } else {
                zzB((i7 - i5) - i3);
                throw zzgrq.zzj();
            }
        } else {
            throw zzgrq.zzf();
        }
    }

    public final boolean zzC() throws IOException {
        return this.zzi == this.zzg && !zzM(1);
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final byte zza() throws IOException {
        if (this.zzi == this.zzg) {
            zzL(1);
        }
        byte[] bArr = this.zzf;
        int i = this.zzi;
        this.zzi = i + 1;
        return bArr[i];
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return this.zzk + this.zzi;
    }

    public final int zze(int i) throws zzgrq {
        if (i >= 0) {
            int i2 = i + this.zzk + this.zzi;
            int i3 = this.zzl;
            if (i2 <= i3) {
                this.zzl = i2;
                zzK();
                return i3;
            }
            throw zzgrq.zzj();
        }
        throw zzgrq.zzf();
    }

    public final int zzf() throws IOException {
        return zzj();
    }

    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzL(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    public final int zzk() throws IOException {
        return zzi();
    }

    public final int zzl() throws IOException {
        return zzF(zzj());
    }

    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int zzj2 = zzj();
        this.zzj = zzj2;
        if ((zzj2 >>> 3) != 0) {
            return zzj2;
        }
        throw zzgrq.zzc();
    }

    public final int zzn() throws IOException {
        return zzj();
    }

    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzL(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* access modifiers changed from: package-private */
    public final long zzs() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zza = zza();
            j |= ((long) (zza & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zza & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzgrq.zze();
    }

    public final long zzt() throws IOException {
        return zzq();
    }

    public final long zzu() throws IOException {
        return zzG(zzr());
    }

    public final long zzv() throws IOException {
        return zzr();
    }

    public final zzgpw zzw() throws IOException {
        int zzj2 = zzj();
        int i = this.zzg;
        int i2 = this.zzi;
        if (zzj2 <= i - i2 && zzj2 > 0) {
            zzgpw zzw = zzgpw.zzw(this.zzf, i2, zzj2);
            this.zzi += zzj2;
            return zzw;
        } else if (zzj2 == 0) {
            return zzgpw.zzb;
        } else {
            byte[] zzO = zzO(zzj2);
            if (zzO != null) {
                return zzgpw.zzv(zzO);
            }
            int i3 = this.zzi;
            int i4 = this.zzg;
            int i5 = i4 - i3;
            this.zzk += i4;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzJ = zzJ(zzj2 - i5);
            byte[] bArr = new byte[zzj2];
            System.arraycopy(this.zzf, i3, bArr, 0, i5);
            for (byte[] bArr2 : zzJ) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i5, length);
                i5 += length;
            }
            return zzgpw.zzz(bArr);
        }
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (zzj2 <= i - i2) {
                String str = new String(this.zzf, i2, zzj2, zzgro.zzb);
                this.zzi += zzj2;
                return str;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 > this.zzg) {
            return new String(zzN(zzj2, false), zzgro.zzb);
        }
        zzL(zzj2);
        String str2 = new String(this.zzf, this.zzi, zzj2, zzgro.zzb);
        this.zzi += zzj2;
        return str2;
    }

    public final String zzy() throws IOException {
        byte[] bArr;
        int zzj2 = zzj();
        int i = this.zzi;
        int i2 = this.zzg;
        int i3 = 0;
        if (zzj2 <= i2 - i && zzj2 > 0) {
            bArr = this.zzf;
            this.zzi = i + zzj2;
            i3 = i;
        } else if (zzj2 == 0) {
            return "";
        } else {
            if (zzj2 <= i2) {
                zzL(zzj2);
                bArr = this.zzf;
                this.zzi = zzj2;
            } else {
                bArr = zzN(zzj2, false);
            }
        }
        return zzgun.zzh(bArr, i3, zzj2);
    }

    public final void zzz(int i) throws zzgrq {
        if (this.zzj != i) {
            throw zzgrq.zzb();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] >= 0) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzj() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L_0x0007
            goto L_0x006c
        L_0x0007:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzi = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006c
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0069
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x0069
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0069
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006c
        L_0x0069:
            r5.zzi = r1
            return r0
        L_0x006c:
            long r0 = r5.zzs()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqc.zzj():int");
    }

    public final boolean zzE(int i) throws IOException {
        int zzm;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzf;
                    int i4 = this.zzi;
                    this.zzi = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzgrq.zze();
            }
            while (i3 < 10) {
                if (zza() < 0) {
                    i3++;
                }
            }
            throw zzgrq.zze();
            return true;
        } else if (i2 == 1) {
            zzB(8);
            return true;
        } else if (i2 == 2) {
            zzB(zzj());
            return true;
        } else if (i2 == 3) {
            do {
                zzm = zzm();
                if (zzm == 0 || !zzE(zzm)) {
                    zzz(((i >>> 3) << 3) | 4);
                }
                zzm = zzm();
                break;
            } while (!zzE(zzm));
            zzz(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzB(4);
                return true;
            }
            throw zzgrq.zza();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b1, code lost:
        if (((long) r2[r3]) >= 0) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzr() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.zzi
            int r1 = r11.zzg
            if (r1 != r0) goto L_0x0008
            goto L_0x00b7
        L_0x0008:
            byte[] r2 = r11.zzf
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0014
            r11.zzi = r3
            long r0 = (long) r0
            return r0
        L_0x0014:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b7
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x002a
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0024:
            long r2 = (long) r0
            r9 = r2
            r3 = r1
            r0 = r9
            goto L_0x00b4
        L_0x002a:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0038
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            goto L_0x00b4
        L_0x0038:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0046
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0024
        L_0x0046:
            int r3 = r1 + 1
            long r4 = (long) r0
            byte r0 = r2[r1]
            long r0 = (long) r0
            r6 = 28
            long r0 = r0 << r6
            long r0 = r0 ^ r4
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x005b
            r4 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0059:
            long r0 = r0 ^ r4
            goto L_0x00b4
        L_0x005b:
            int r6 = r3 + 1
            byte r3 = r2[r3]
            long r7 = (long) r3
            r3 = 35
            long r7 = r7 << r3
            long r0 = r0 ^ r7
            int r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0071
            r2 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r2 = r2 ^ r0
            r0 = r2
        L_0x006f:
            r3 = r6
            goto L_0x00b4
        L_0x0071:
            int r3 = r6 + 1
            byte r6 = r2[r6]
            long r6 = (long) r6
            r8 = 42
            long r6 = r6 << r8
            long r0 = r0 ^ r6
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0084
            r4 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0059
        L_0x0084:
            int r6 = r3 + 1
            byte r3 = r2[r3]
            long r7 = (long) r3
            r3 = 49
            long r7 = r7 << r3
            long r0 = r0 ^ r7
            int r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0097
            r2 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0097:
            int r3 = r6 + 1
            byte r6 = r2[r6]
            long r6 = (long) r6
            r8 = 56
            long r6 = r6 << r8
            long r0 = r0 ^ r6
            r6 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r0 = r0 ^ r6
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00b4
            int r6 = r3 + 1
            byte r2 = r2[r3]
            long r2 = (long) r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x00b7
            goto L_0x006f
        L_0x00b4:
            r11.zzi = r3
            return r0
        L_0x00b7:
            long r0 = r11.zzs()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqc.zzr():long");
    }
}
