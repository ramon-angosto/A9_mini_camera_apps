package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgqa extends zzgqe {
    private final Iterable zze;
    private final Iterator zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj = Integer.MAX_VALUE;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    /* synthetic */ zzgqa(Iterable iterable, int i, boolean z, zzgpz zzgpz) {
        super((zzgqd) null);
        this.zzh = i;
        this.zze = iterable;
        this.zzf = this.zze.iterator();
        this.zzl = 0;
        if (i == 0) {
            this.zzg = zzgro.zze;
            this.zzm = 0;
            this.zzn = 0;
            this.zzo = 0;
            return;
        }
        zzN();
    }

    private final int zzJ() {
        return (int) ((((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn);
    }

    private final void zzK() throws zzgrq {
        if (this.zzf.hasNext()) {
            zzN();
            return;
        }
        throw zzgrq.zzj();
    }

    private final void zzL(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= zzJ()) {
            int i3 = i2;
            while (i3 > 0) {
                if (this.zzo - this.zzm == 0) {
                    zzK();
                }
                int min = Math.min(i3, (int) (this.zzo - this.zzm));
                long j = (long) min;
                zzgui.zzo(this.zzm, bArr, (long) (i2 - i3), j);
                i3 -= min;
                this.zzm += j;
            }
        } else if (i2 > 0) {
            throw zzgrq.zzj();
        }
    }

    private final void zzM() {
        int i = this.zzh + this.zzi;
        this.zzh = i;
        int i2 = this.zzj;
        if (i > i2) {
            int i3 = i - i2;
            this.zzi = i3;
            this.zzh = i - i3;
            return;
        }
        this.zzi = 0;
    }

    private final void zzN() {
        this.zzg = (ByteBuffer) this.zzf.next();
        this.zzl += (int) (this.zzm - this.zzn);
        long position = (long) this.zzg.position();
        this.zzm = position;
        this.zzn = position;
        this.zzo = (long) this.zzg.limit();
        long zze2 = zzgui.zze(this.zzg);
        this.zzm += zze2;
        this.zzn += zze2;
        this.zzo += zze2;
    }

    public final void zzA(int i) {
        this.zzj = i;
        zzM();
    }

    public final boolean zzC() throws IOException {
        return (((long) this.zzl) + this.zzm) - this.zzn == ((long) this.zzh);
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final byte zza() throws IOException {
        if (this.zzo - this.zzm == 0) {
            zzK();
        }
        long j = this.zzm;
        this.zzm = 1 + j;
        return zzgui.zza(j);
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return (int) ((((long) this.zzl) + this.zzm) - this.zzn);
    }

    public final int zze(int i) throws zzgrq {
        if (i >= 0) {
            int zzd = i + zzd();
            int i2 = this.zzj;
            if (zzd <= i2) {
                this.zzj = zzd;
                zzM();
                return i2;
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
        byte zza;
        byte zza2;
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 >= 4) {
            this.zzm = 4 + j2;
            zza = (zzgui.zza(j2) & UByte.MAX_VALUE) | ((zzgui.zza(1 + j2) & UByte.MAX_VALUE) << 8) | ((zzgui.zza(2 + j2) & UByte.MAX_VALUE) << 16);
            zza2 = zzgui.zza(j2 + 3);
        } else {
            zza = (zza() & UByte.MAX_VALUE) | ((zza() & UByte.MAX_VALUE) << 8) | ((zza() & UByte.MAX_VALUE) << 16);
            zza2 = zza();
        }
        return zza | ((zza2 & UByte.MAX_VALUE) << 24);
    }

    public final int zzk() throws IOException {
        return zzi();
    }

    public final int zzl() throws IOException {
        return zzF(zzj());
    }

    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzk = 0;
            return 0;
        }
        int zzj2 = zzj();
        this.zzk = zzj2;
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
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 >= 8) {
            this.zzm = 8 + j2;
            return ((((long) zzgui.zza(j2 + 7)) & 255) << 56) | (((long) zzgui.zza(j2)) & 255) | ((((long) zzgui.zza(1 + j2)) & 255) << 8) | ((((long) zzgui.zza(2 + j2)) & 255) << 16) | ((((long) zzgui.zza(3 + j2)) & 255) << 24) | ((((long) zzgui.zza(4 + j2)) & 255) << 32) | ((((long) zzgui.zza(5 + j2)) & 255) << 40) | ((((long) zzgui.zza(6 + j2)) & 255) << 48);
        }
        return ((((long) zza()) & 255) << 56) | (((long) zza()) & 255) | ((((long) zza()) & 255) << 8) | ((((long) zza()) & 255) << 16) | ((((long) zza()) & 255) << 24) | ((((long) zza()) & 255) << 32) | ((((long) zza()) & 255) << 40) | ((((long) zza()) & 255) << 48);
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
        if (zzj2 > 0) {
            long j = (long) zzj2;
            long j2 = this.zzo;
            long j3 = this.zzm;
            if (j <= j2 - j3) {
                byte[] bArr = new byte[zzj2];
                zzgui.zzo(j3, bArr, 0, j);
                this.zzm += j;
                return zzgpw.zzz(bArr);
            }
        }
        if (zzj2 > 0 && zzj2 <= zzJ()) {
            byte[] bArr2 = new byte[zzj2];
            zzL(bArr2, 0, zzj2);
            return zzgpw.zzz(bArr2);
        } else if (zzj2 == 0) {
            return zzgpw.zzb;
        } else {
            if (zzj2 < 0) {
                throw zzgrq.zzf();
            }
            throw zzgrq.zzj();
        }
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            long j = (long) zzj2;
            long j2 = this.zzo;
            long j3 = this.zzm;
            if (j <= j2 - j3) {
                byte[] bArr = new byte[zzj2];
                zzgui.zzo(j3, bArr, 0, j);
                String str = new String(bArr, zzgro.zzb);
                this.zzm += j;
                return str;
            }
        }
        if (zzj2 > 0 && zzj2 <= zzJ()) {
            byte[] bArr2 = new byte[zzj2];
            zzL(bArr2, 0, zzj2);
            return new String(bArr2, zzgro.zzb);
        } else if (zzj2 == 0) {
            return "";
        } else {
            if (zzj2 < 0) {
                throw zzgrq.zzf();
            }
            throw zzgrq.zzj();
        }
    }

    public final String zzy() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            long j = (long) zzj2;
            long j2 = this.zzo;
            long j3 = this.zzm;
            if (j <= j2 - j3) {
                String zzg2 = zzgun.zzg(this.zzg, (int) (j3 - this.zzn), zzj2);
                this.zzm += j;
                return zzg2;
            }
        }
        if (zzj2 >= 0 && zzj2 <= zzJ()) {
            byte[] bArr = new byte[zzj2];
            zzL(bArr, 0, zzj2);
            return zzgun.zzh(bArr, 0, zzj2);
        } else if (zzj2 == 0) {
            return "";
        } else {
            if (zzj2 <= 0) {
                throw zzgrq.zzf();
            }
            throw zzgrq.zzj();
        }
    }

    public final void zzz(int i) throws zzgrq {
        if (this.zzk != i) {
            throw zzgrq.zzb();
        }
    }

    public final void zzB(int i) throws IOException {
        if (i >= 0 && ((long) i) <= (((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn) {
            while (i > 0) {
                if (this.zzo - this.zzm == 0) {
                    zzK();
                }
                int min = Math.min(i, (int) (this.zzo - this.zzm));
                i -= min;
                this.zzm += (long) min;
            }
        } else if (i < 0) {
            throw zzgrq.zzf();
        } else {
            throw zzgrq.zzj();
        }
    }

    public final boolean zzE(int i) throws IOException {
        int zzm2;
        int i2 = i & 7;
        if (i2 == 0) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (zza() >= 0) {
                    return true;
                }
            }
            throw zzgrq.zze();
        } else if (i2 == 1) {
            zzB(8);
            return true;
        } else if (i2 == 2) {
            zzB(zzj());
            return true;
        } else if (i2 == 3) {
            do {
                zzm2 = zzm();
                if (zzm2 == 0 || !zzE(zzm2)) {
                    zzz(((i >>> 3) << 3) | 4);
                }
                zzm2 = zzm();
                break;
            } while (!zzE(zzm2));
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

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
        if (com.google.android.gms.internal.ads.zzgui.zza(r4) >= 0) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzj() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzm
            long r2 = r10.zzo
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000a
            goto L_0x008c
        L_0x000a:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzgui.zza(r0)
            if (r0 < 0) goto L_0x001a
            long r4 = r10.zzm
            long r4 = r4 + r2
            r10.zzm = r4
            return r0
        L_0x001a:
            long r6 = r10.zzo
            long r8 = r10.zzm
            long r6 = r6 - r8
            r8 = 10
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x008c
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgui.zza(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0033
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0089
        L_0x0033:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgui.zza(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0042
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x0040:
            r6 = r4
            goto L_0x0089
        L_0x0042:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgui.zza(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0052
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x0089
        L_0x0052:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgui.zza(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgui.zza(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgui.zza(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgui.zza(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgui.zza(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgui.zza(r4)
            if (r1 < 0) goto L_0x008c
        L_0x0089:
            r10.zzm = r6
            return r0
        L_0x008c:
            long r0 = r10.zzs()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgqa.zzj():int");
    }

    public final long zzr() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        byte b;
        long j5 = this.zzm;
        if (this.zzo != j5) {
            long j6 = j5 + 1;
            byte zza = zzgui.zza(j5);
            if (zza >= 0) {
                this.zzm++;
                return (long) zza;
            } else if (this.zzo - this.zzm >= 10) {
                long j7 = j6 + 1;
                byte zza2 = zza ^ (zzgui.zza(j6) << 7);
                if (zza2 < 0) {
                    b = zza2 ^ ByteCompanionObject.MIN_VALUE;
                } else {
                    j = j7 + 1;
                    byte zza3 = zza2 ^ (zzgui.zza(j7) << 14);
                    if (zza3 >= 0) {
                        j2 = (long) (zza3 ^ ByteCompanionObject.MIN_VALUE);
                    } else {
                        j7 = j + 1;
                        byte zza4 = zza3 ^ (zzgui.zza(j) << 21);
                        if (zza4 < 0) {
                            b = zza4 ^ ByteCompanionObject.MIN_VALUE;
                        } else {
                            j = j7 + 1;
                            long zza5 = ((long) zza4) ^ (((long) zzgui.zza(j7)) << 28);
                            if (zza5 >= 0) {
                                j4 = 266354560;
                            } else {
                                long j8 = j + 1;
                                long zza6 = zza5 ^ (((long) zzgui.zza(j)) << 35);
                                if (zza6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    j = j8 + 1;
                                    zza5 = zza6 ^ (((long) zzgui.zza(j8)) << 42);
                                    if (zza5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        j8 = j + 1;
                                        zza6 = zza5 ^ (((long) zzgui.zza(j)) << 49);
                                        if (zza6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            j = j8 + 1;
                                            j2 = (zza6 ^ (((long) zzgui.zza(j8)) << 56)) ^ 71499008037633920L;
                                            if (j2 < 0) {
                                                long j9 = 1 + j;
                                                if (((long) zzgui.zza(j)) >= 0) {
                                                    j = j9;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = zza6 ^ j3;
                                j = j8;
                            }
                            j2 = zza5 ^ j4;
                        }
                    }
                    this.zzm = j;
                    return j2;
                }
                j2 = (long) b;
                j = j7;
                this.zzm = j;
                return j2;
            }
        }
        return zzs();
    }
}
