package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.baidu.mapapi.MapView;
import java.io.IOException;
import java.util.Arrays;

public interface zzamo {

    public static final class zza extends zzamd<zza> {
        public long[] zzcaA;
        public String[] zzcax;
        public String[] zzcay;
        public int[] zzcaz;

        public zza() {
            zzXh();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (zzamh.equals((Object[]) this.zzcax, (Object[]) zza.zzcax) && zzamh.equals((Object[]) this.zzcay, (Object[]) zza.zzcay) && zzamh.equals(this.zzcaz, zza.zzcaz) && zzamh.equals(this.zzcaA, zza.zzcaA)) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zza.zzcaa == null || zza.zzcaa.isEmpty() : this.zzcaa.equals(zza.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zzcax)) * 31) + zzamh.hashCode((Object[]) this.zzcay)) * 31) + zzamh.hashCode(this.zzcaz)) * 31) + zzamh.hashCode(this.zzcaA)) * 31) + ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode());
        }

        public void writeTo(zzamc zzamc) throws IOException {
            String[] strArr = this.zzcax;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.zzcax;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        zzamc.zzq(1, str);
                    }
                    i2++;
                }
            }
            String[] strArr3 = this.zzcay;
            if (strArr3 != null && strArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr4 = this.zzcay;
                    if (i3 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i3];
                    if (str2 != null) {
                        zzamc.zzq(2, str2);
                    }
                    i3++;
                }
            }
            int[] iArr = this.zzcaz;
            if (iArr != null && iArr.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = this.zzcaz;
                    if (i4 >= iArr2.length) {
                        break;
                    }
                    zzamc.zzE(3, iArr2[i4]);
                    i4++;
                }
            }
            long[] jArr = this.zzcaA;
            if (jArr != null && jArr.length > 0) {
                while (true) {
                    long[] jArr2 = this.zzcaA;
                    if (i >= jArr2.length) {
                        break;
                    }
                    zzamc.zzb(4, jArr2[i]);
                    i++;
                }
            }
            super.writeTo(zzamc);
        }

        public zza zzXh() {
            this.zzcax = zzamm.zzcaq;
            this.zzcay = zzamm.zzcaq;
            this.zzcaz = zzamm.zzcal;
            this.zzcaA = zzamm.zzcam;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzY */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            int i;
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    int zzc = zzamm.zzc(zzamb, 10);
                    String[] strArr = this.zzcax;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzcax, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = zzamb.readString();
                        zzamb.zzWC();
                        length++;
                    }
                    strArr2[length] = zzamb.readString();
                    this.zzcax = strArr2;
                } else if (zzWC == 18) {
                    int zzc2 = zzamm.zzc(zzamb, 18);
                    String[] strArr3 = this.zzcay;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    String[] strArr4 = new String[(zzc2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzcay, 0, strArr4, 0, length2);
                    }
                    while (length2 < strArr4.length - 1) {
                        strArr4[length2] = zzamb.readString();
                        zzamb.zzWC();
                        length2++;
                    }
                    strArr4[length2] = zzamb.readString();
                    this.zzcay = strArr4;
                } else if (zzWC != 24) {
                    if (zzWC == 26) {
                        i = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i2 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i2++;
                        }
                        zzamb.zznY(position);
                        int[] iArr = this.zzcaz;
                        int length3 = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[(i2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzcaz, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzamb.zzWG();
                            length3++;
                        }
                        this.zzcaz = iArr2;
                    } else if (zzWC == 32) {
                        int zzc3 = zzamm.zzc(zzamb, 32);
                        long[] jArr = this.zzcaA;
                        int length4 = jArr == null ? 0 : jArr.length;
                        long[] jArr2 = new long[(zzc3 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzcaA, 0, jArr2, 0, length4);
                        }
                        while (length4 < jArr2.length - 1) {
                            jArr2[length4] = zzamb.zzWF();
                            zzamb.zzWC();
                            length4++;
                        }
                        jArr2[length4] = zzamb.zzWF();
                        this.zzcaA = jArr2;
                    } else if (zzWC == 34) {
                        i = zzamb.zznW(zzamb.zzWL());
                        int position2 = zzamb.getPosition();
                        int i3 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWF();
                            i3++;
                        }
                        zzamb.zznY(position2);
                        long[] jArr3 = this.zzcaA;
                        int length5 = jArr3 == null ? 0 : jArr3.length;
                        long[] jArr4 = new long[(i3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzcaA, 0, jArr4, 0, length5);
                        }
                        while (length5 < jArr4.length) {
                            jArr4[length5] = zzamb.zzWF();
                            length5++;
                        }
                        this.zzcaA = jArr4;
                    } else if (!super.zza(zzamb, zzWC)) {
                        return this;
                    }
                    zzamb.zznX(i);
                } else {
                    int zzc4 = zzamm.zzc(zzamb, 24);
                    int[] iArr3 = this.zzcaz;
                    int length6 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[(zzc4 + length6)];
                    if (length6 != 0) {
                        System.arraycopy(this.zzcaz, 0, iArr4, 0, length6);
                    }
                    while (length6 < iArr4.length - 1) {
                        iArr4[length6] = zzamb.zzWG();
                        zzamb.zzWC();
                        length6++;
                    }
                    iArr4[length6] = zzamb.zzWG();
                    this.zzcaz = iArr4;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int[] iArr;
            int zzy = super.zzy();
            String[] strArr = this.zzcax;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.zzcax;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i4++;
                        i3 += zzamc.zziZ(str);
                    }
                    i2++;
                }
                zzy = zzy + i3 + (i4 * 1);
            }
            String[] strArr3 = this.zzcay;
            if (strArr3 != null && strArr3.length > 0) {
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    String[] strArr4 = this.zzcay;
                    if (i5 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i5];
                    if (str2 != null) {
                        i7++;
                        i6 += zzamc.zziZ(str2);
                    }
                    i5++;
                }
                zzy = zzy + i6 + (i7 * 1);
            }
            int[] iArr2 = this.zzcaz;
            if (iArr2 != null && iArr2.length > 0) {
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    iArr = this.zzcaz;
                    if (i8 >= iArr.length) {
                        break;
                    }
                    i9 += zzamc.zzoc(iArr[i8]);
                    i8++;
                }
                zzy = zzy + i9 + (iArr.length * 1);
            }
            long[] jArr = this.zzcaA;
            if (jArr == null || jArr.length <= 0) {
                return zzy;
            }
            int i10 = 0;
            while (true) {
                long[] jArr2 = this.zzcaA;
                if (i >= jArr2.length) {
                    return zzy + i10 + (jArr2.length * 1);
                }
                i10 += zzamc.zzaU(jArr2[i]);
                i++;
            }
        }
    }

    public static final class zzb extends zzamd<zzb> {
        public String version;
        public int zzcaB;
        public String zzcaC;

        public zzb() {
            zzXi();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.zzcaB != zzb.zzcaB) {
                return false;
            }
            String str = this.zzcaC;
            if (str == null) {
                if (zzb.zzcaC != null) {
                    return false;
                }
            } else if (!str.equals(zzb.zzcaC)) {
                return false;
            }
            String str2 = this.version;
            if (str2 == null) {
                if (zzb.version != null) {
                    return false;
                }
            } else if (!str2.equals(zzb.version)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzb.zzcaa == null || zzb.zzcaa.isEmpty() : this.zzcaa.equals(zzb.zzcaa);
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.zzcaB) * 31;
            String str = this.zzcaC;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.version;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode3 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            int i = this.zzcaB;
            if (i != 0) {
                zzamc.zzE(1, i);
            }
            if (!this.zzcaC.equals("")) {
                zzamc.zzq(2, this.zzcaC);
            }
            if (!this.version.equals("")) {
                zzamc.zzq(3, this.version);
            }
            super.writeTo(zzamc);
        }

        public zzb zzXi() {
            this.zzcaB = 0;
            this.zzcaC = "";
            this.version = "";
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzZ */
        public zzb mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC != 0) {
                    if (zzWC == 8) {
                        int zzWG = zzamb.zzWG();
                        switch (zzWG) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzcaB = zzWG;
                                break;
                        }
                    } else if (zzWC == 18) {
                        this.zzcaC = zzamb.readString();
                    } else if (zzWC == 26) {
                        this.version = zzamb.readString();
                    } else if (!super.zza(zzamb, zzWC)) {
                        return this;
                    }
                } else {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            int i = this.zzcaB;
            if (i != 0) {
                zzy += zzamc.zzG(1, i);
            }
            if (!this.zzcaC.equals("")) {
                zzy += zzamc.zzr(2, this.zzcaC);
            }
            return !this.version.equals("") ? zzy + zzamc.zzr(3, this.version) : zzy;
        }
    }

    public static final class zzc extends zzamd<zzc> {
        public byte[] zzcaD;
        public byte[][] zzcaE;
        public boolean zzcaF;

        public zzc() {
            zzXj();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (Arrays.equals(this.zzcaD, zzc.zzcaD) && zzamh.zza(this.zzcaE, zzc.zzcaE) && this.zzcaF == zzc.zzcaF) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzc.zzcaa == null || zzc.zzcaa.isEmpty() : this.zzcaa.equals(zzc.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzcaD)) * 31) + zzamh.zza(this.zzcaE)) * 31) + (this.zzcaF ? 1231 : 1237)) * 31) + ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode());
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (!Arrays.equals(this.zzcaD, zzamm.zzcas)) {
                zzamc.zza(1, this.zzcaD);
            }
            byte[][] bArr = this.zzcaE;
            if (bArr != null && bArr.length > 0) {
                int i = 0;
                while (true) {
                    byte[][] bArr2 = this.zzcaE;
                    if (i >= bArr2.length) {
                        break;
                    }
                    byte[] bArr3 = bArr2[i];
                    if (bArr3 != null) {
                        zzamc.zza(2, bArr3);
                    }
                    i++;
                }
            }
            boolean z = this.zzcaF;
            if (z) {
                zzamc.zzj(3, z);
            }
            super.writeTo(zzamc);
        }

        public zzc zzXj() {
            this.zzcaD = zzamm.zzcas;
            this.zzcaE = zzamm.zzcar;
            this.zzcaF = false;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzaa */
        public zzc mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    this.zzcaD = zzamb.readBytes();
                } else if (zzWC == 18) {
                    int zzc = zzamm.zzc(zzamb, 18);
                    byte[][] bArr = this.zzcaE;
                    int length = bArr == null ? 0 : bArr.length;
                    byte[][] bArr2 = new byte[(zzc + length)][];
                    if (length != 0) {
                        System.arraycopy(this.zzcaE, 0, bArr2, 0, length);
                    }
                    while (length < bArr2.length - 1) {
                        bArr2[length] = zzamb.readBytes();
                        zzamb.zzWC();
                        length++;
                    }
                    bArr2[length] = zzamb.readBytes();
                    this.zzcaE = bArr2;
                } else if (zzWC == 24) {
                    this.zzcaF = zzamb.zzWI();
                } else if (!super.zza(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (!Arrays.equals(this.zzcaD, zzamm.zzcas)) {
                zzy += zzamc.zzb(1, this.zzcaD);
            }
            byte[][] bArr = this.zzcaE;
            if (bArr != null && bArr.length > 0) {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    byte[][] bArr2 = this.zzcaE;
                    if (i >= bArr2.length) {
                        break;
                    }
                    byte[] bArr3 = bArr2[i];
                    if (bArr3 != null) {
                        i3++;
                        i2 += zzamc.zzQ(bArr3);
                    }
                    i++;
                }
                zzy = zzy + i2 + (i3 * 1);
            }
            boolean z = this.zzcaF;
            return z ? zzy + zzamc.zzk(3, z) : zzy;
        }
    }

    public static final class zzd extends zzamd<zzd> {
        public String tag;
        public boolean zzbLB;
        public long zzcaG;
        public long zzcaH;
        public long zzcaI;
        public int zzcaJ;
        public zze[] zzcaK;
        public zzb zzcaL;
        public byte[] zzcaM;
        public byte[] zzcaN;
        public byte[] zzcaO;
        public zza zzcaP;
        public String zzcaQ;
        public long zzcaR;
        public zzc zzcaS;
        public byte[] zzcaT;
        public int zzcaU;
        public int[] zzcaV;
        public long zzcaW;
        public zzf zzcaX;
        public int zzoZ;

        public zzd() {
            zzXk();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            if (this.zzcaG != zzd.zzcaG || this.zzcaH != zzd.zzcaH || this.zzcaI != zzd.zzcaI) {
                return false;
            }
            String str = this.tag;
            if (str == null) {
                if (zzd.tag != null) {
                    return false;
                }
            } else if (!str.equals(zzd.tag)) {
                return false;
            }
            if (this.zzcaJ != zzd.zzcaJ || this.zzoZ != zzd.zzoZ || this.zzbLB != zzd.zzbLB || !zzamh.equals((Object[]) this.zzcaK, (Object[]) zzd.zzcaK)) {
                return false;
            }
            zzb zzb = this.zzcaL;
            if (zzb == null) {
                if (zzd.zzcaL != null) {
                    return false;
                }
            } else if (!zzb.equals(zzd.zzcaL)) {
                return false;
            }
            if (!Arrays.equals(this.zzcaM, zzd.zzcaM) || !Arrays.equals(this.zzcaN, zzd.zzcaN) || !Arrays.equals(this.zzcaO, zzd.zzcaO)) {
                return false;
            }
            zza zza = this.zzcaP;
            if (zza == null) {
                if (zzd.zzcaP != null) {
                    return false;
                }
            } else if (!zza.equals(zzd.zzcaP)) {
                return false;
            }
            String str2 = this.zzcaQ;
            if (str2 == null) {
                if (zzd.zzcaQ != null) {
                    return false;
                }
            } else if (!str2.equals(zzd.zzcaQ)) {
                return false;
            }
            if (this.zzcaR != zzd.zzcaR) {
                return false;
            }
            zzc zzc = this.zzcaS;
            if (zzc == null) {
                if (zzd.zzcaS != null) {
                    return false;
                }
            } else if (!zzc.equals(zzd.zzcaS)) {
                return false;
            }
            if (!Arrays.equals(this.zzcaT, zzd.zzcaT) || this.zzcaU != zzd.zzcaU || !zzamh.equals(this.zzcaV, zzd.zzcaV) || this.zzcaW != zzd.zzcaW) {
                return false;
            }
            zzf zzf = this.zzcaX;
            if (zzf == null) {
                if (zzd.zzcaX != null) {
                    return false;
                }
            } else if (!zzf.equals(zzd.zzcaX)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzd.zzcaa == null || zzd.zzcaa.isEmpty() : this.zzcaa.equals(zzd.zzcaa);
        }

        public int hashCode() {
            long j = this.zzcaG;
            long j2 = this.zzcaH;
            long j3 = this.zzcaI;
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            String str = this.tag;
            int i = 0;
            int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.zzcaJ) * 31) + this.zzoZ) * 31) + (this.zzbLB ? 1231 : 1237)) * 31) + zzamh.hashCode((Object[]) this.zzcaK)) * 31;
            zzb zzb = this.zzcaL;
            int hashCode3 = (((((((hashCode2 + (zzb == null ? 0 : zzb.hashCode())) * 31) + Arrays.hashCode(this.zzcaM)) * 31) + Arrays.hashCode(this.zzcaN)) * 31) + Arrays.hashCode(this.zzcaO)) * 31;
            zza zza = this.zzcaP;
            int hashCode4 = (hashCode3 + (zza == null ? 0 : zza.hashCode())) * 31;
            String str2 = this.zzcaQ;
            int hashCode5 = str2 == null ? 0 : str2.hashCode();
            long j4 = this.zzcaR;
            int i2 = (((hashCode4 + hashCode5) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            zzc zzc = this.zzcaS;
            int hashCode6 = zzc == null ? 0 : zzc.hashCode();
            long j5 = this.zzcaW;
            int hashCode7 = (((((((((i2 + hashCode6) * 31) + Arrays.hashCode(this.zzcaT)) * 31) + this.zzcaU) * 31) + zzamh.hashCode(this.zzcaV)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31;
            zzf zzf = this.zzcaX;
            int hashCode8 = (hashCode7 + (zzf == null ? 0 : zzf.hashCode())) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode8 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            long j = this.zzcaG;
            if (j != 0) {
                zzamc.zzb(1, j);
            }
            if (!this.tag.equals("")) {
                zzamc.zzq(2, this.tag);
            }
            zze[] zzeArr = this.zzcaK;
            int i = 0;
            if (zzeArr != null && zzeArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zze[] zzeArr2 = this.zzcaK;
                    if (i2 >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i2];
                    if (zze != null) {
                        zzamc.zza(3, (zzamj) zze);
                    }
                    i2++;
                }
            }
            if (!Arrays.equals(this.zzcaM, zzamm.zzcas)) {
                zzamc.zza(6, this.zzcaM);
            }
            zza zza = this.zzcaP;
            if (zza != null) {
                zzamc.zza(7, (zzamj) zza);
            }
            if (!Arrays.equals(this.zzcaN, zzamm.zzcas)) {
                zzamc.zza(8, this.zzcaN);
            }
            zzb zzb = this.zzcaL;
            if (zzb != null) {
                zzamc.zza(9, (zzamj) zzb);
            }
            boolean z = this.zzbLB;
            if (z) {
                zzamc.zzj(10, z);
            }
            int i3 = this.zzcaJ;
            if (i3 != 0) {
                zzamc.zzE(11, i3);
            }
            int i4 = this.zzoZ;
            if (i4 != 0) {
                zzamc.zzE(12, i4);
            }
            if (!Arrays.equals(this.zzcaO, zzamm.zzcas)) {
                zzamc.zza(13, this.zzcaO);
            }
            if (!this.zzcaQ.equals("")) {
                zzamc.zzq(14, this.zzcaQ);
            }
            long j2 = this.zzcaR;
            if (j2 != 180000) {
                zzamc.zzd(15, j2);
            }
            zzc zzc = this.zzcaS;
            if (zzc != null) {
                zzamc.zza(16, (zzamj) zzc);
            }
            long j3 = this.zzcaH;
            if (j3 != 0) {
                zzamc.zzb(17, j3);
            }
            if (!Arrays.equals(this.zzcaT, zzamm.zzcas)) {
                zzamc.zza(18, this.zzcaT);
            }
            int i5 = this.zzcaU;
            if (i5 != 0) {
                zzamc.zzE(19, i5);
            }
            int[] iArr = this.zzcaV;
            if (iArr != null && iArr.length > 0) {
                while (true) {
                    int[] iArr2 = this.zzcaV;
                    if (i >= iArr2.length) {
                        break;
                    }
                    zzamc.zzE(20, iArr2[i]);
                    i++;
                }
            }
            long j4 = this.zzcaI;
            if (j4 != 0) {
                zzamc.zzb(21, j4);
            }
            long j5 = this.zzcaW;
            if (j5 != 0) {
                zzamc.zzb(22, j5);
            }
            zzf zzf = this.zzcaX;
            if (zzf != null) {
                zzamc.zza(23, (zzamj) zzf);
            }
            super.writeTo(zzamc);
        }

        public zzd zzXk() {
            this.zzcaG = 0;
            this.zzcaH = 0;
            this.zzcaI = 0;
            this.tag = "";
            this.zzcaJ = 0;
            this.zzoZ = 0;
            this.zzbLB = false;
            this.zzcaK = zze.zzXl();
            this.zzcaL = null;
            this.zzcaM = zzamm.zzcas;
            this.zzcaN = zzamm.zzcas;
            this.zzcaO = zzamm.zzcas;
            this.zzcaP = null;
            this.zzcaQ = "";
            this.zzcaR = 180000;
            this.zzcaS = null;
            this.zzcaT = zzamm.zzcas;
            this.zzcaU = 0;
            this.zzcaV = zzamm.zzcal;
            this.zzcaW = 0;
            this.zzcaX = null;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzab */
        public zzd mergeFrom(zzamb zzamb) throws IOException {
            zzamj zzamj;
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        return this;
                    case 8:
                        this.zzcaG = zzamb.zzWF();
                        continue;
                    case 18:
                        this.tag = zzamb.readString();
                        continue;
                    case 26:
                        int zzc = zzamm.zzc(zzamb, 26);
                        zze[] zzeArr = this.zzcaK;
                        int length = zzeArr == null ? 0 : zzeArr.length;
                        zze[] zzeArr2 = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzcaK, 0, zzeArr2, 0, length);
                        }
                        while (length < zzeArr2.length - 1) {
                            zzeArr2[length] = new zze();
                            zzamb.zza(zzeArr2[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zzeArr2[length] = new zze();
                        zzamb.zza(zzeArr2[length]);
                        this.zzcaK = zzeArr2;
                        continue;
                    case 50:
                        this.zzcaM = zzamb.readBytes();
                        continue;
                    case 58:
                        if (this.zzcaP == null) {
                            this.zzcaP = new zza();
                        }
                        zzamj = this.zzcaP;
                        break;
                    case 66:
                        this.zzcaN = zzamb.readBytes();
                        continue;
                    case 74:
                        if (this.zzcaL == null) {
                            this.zzcaL = new zzb();
                        }
                        zzamj = this.zzcaL;
                        break;
                    case MapView.LayoutParams.BOTTOM:
                        this.zzbLB = zzamb.zzWI();
                        continue;
                    case 88:
                        this.zzcaJ = zzamb.zzWG();
                        continue;
                    case 96:
                        this.zzoZ = zzamb.zzWG();
                        continue;
                    case 106:
                        this.zzcaO = zzamb.readBytes();
                        continue;
                    case 114:
                        this.zzcaQ = zzamb.readString();
                        continue;
                    case 120:
                        this.zzcaR = zzamb.zzWK();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        if (this.zzcaS == null) {
                            this.zzcaS = new zzc();
                        }
                        zzamj = this.zzcaS;
                        break;
                    case 136:
                        this.zzcaH = zzamb.zzWF();
                        continue;
                    case 146:
                        this.zzcaT = zzamb.readBytes();
                        continue;
                    case 152:
                        int zzWG = zzamb.zzWG();
                        if (zzWG == 0 || zzWG == 1 || zzWG == 2) {
                            this.zzcaU = zzWG;
                            break;
                        } else {
                            continue;
                        }
                    case 160:
                        int zzc2 = zzamm.zzc(zzamb, 160);
                        int[] iArr = this.zzcaV;
                        int length2 = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzcaV, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length - 1) {
                            iArr2[length2] = zzamb.zzWG();
                            zzamb.zzWC();
                            length2++;
                        }
                        iArr2[length2] = zzamb.zzWG();
                        this.zzcaV = iArr2;
                        continue;
                    case 162:
                        int zznW = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i++;
                        }
                        zzamb.zznY(position);
                        int[] iArr3 = this.zzcaV;
                        int length3 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[(i + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzcaV, 0, iArr4, 0, length3);
                        }
                        while (length3 < iArr4.length) {
                            iArr4[length3] = zzamb.zzWG();
                            length3++;
                        }
                        this.zzcaV = iArr4;
                        zzamb.zznX(zznW);
                        continue;
                    case 168:
                        this.zzcaI = zzamb.zzWF();
                        continue;
                    case 176:
                        this.zzcaW = zzamb.zzWF();
                        continue;
                    case 186:
                        if (this.zzcaX == null) {
                            this.zzcaX = new zzf();
                        }
                        zzamj = this.zzcaX;
                        break;
                    default:
                        if (!super.zza(zzamb, zzWC)) {
                            return this;
                        }
                        continue;
                }
                zzamb.zza(zzamj);
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int[] iArr;
            int zzy = super.zzy();
            long j = this.zzcaG;
            if (j != 0) {
                zzy += zzamc.zze(1, j);
            }
            if (!this.tag.equals("")) {
                zzy += zzamc.zzr(2, this.tag);
            }
            zze[] zzeArr = this.zzcaK;
            int i = 0;
            if (zzeArr != null && zzeArr.length > 0) {
                int i2 = zzy;
                int i3 = 0;
                while (true) {
                    zze[] zzeArr2 = this.zzcaK;
                    if (i3 >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i3];
                    if (zze != null) {
                        i2 += zzamc.zzc(3, (zzamj) zze);
                    }
                    i3++;
                }
                zzy = i2;
            }
            if (!Arrays.equals(this.zzcaM, zzamm.zzcas)) {
                zzy += zzamc.zzb(6, this.zzcaM);
            }
            zza zza = this.zzcaP;
            if (zza != null) {
                zzy += zzamc.zzc(7, (zzamj) zza);
            }
            if (!Arrays.equals(this.zzcaN, zzamm.zzcas)) {
                zzy += zzamc.zzb(8, this.zzcaN);
            }
            zzb zzb = this.zzcaL;
            if (zzb != null) {
                zzy += zzamc.zzc(9, (zzamj) zzb);
            }
            boolean z = this.zzbLB;
            if (z) {
                zzy += zzamc.zzk(10, z);
            }
            int i4 = this.zzcaJ;
            if (i4 != 0) {
                zzy += zzamc.zzG(11, i4);
            }
            int i5 = this.zzoZ;
            if (i5 != 0) {
                zzy += zzamc.zzG(12, i5);
            }
            if (!Arrays.equals(this.zzcaO, zzamm.zzcas)) {
                zzy += zzamc.zzb(13, this.zzcaO);
            }
            if (!this.zzcaQ.equals("")) {
                zzy += zzamc.zzr(14, this.zzcaQ);
            }
            long j2 = this.zzcaR;
            if (j2 != 180000) {
                zzy += zzamc.zzg(15, j2);
            }
            zzc zzc = this.zzcaS;
            if (zzc != null) {
                zzy += zzamc.zzc(16, (zzamj) zzc);
            }
            long j3 = this.zzcaH;
            if (j3 != 0) {
                zzy += zzamc.zze(17, j3);
            }
            if (!Arrays.equals(this.zzcaT, zzamm.zzcas)) {
                zzy += zzamc.zzb(18, this.zzcaT);
            }
            int i6 = this.zzcaU;
            if (i6 != 0) {
                zzy += zzamc.zzG(19, i6);
            }
            int[] iArr2 = this.zzcaV;
            if (iArr2 != null && iArr2.length > 0) {
                int i7 = 0;
                while (true) {
                    iArr = this.zzcaV;
                    if (i >= iArr.length) {
                        break;
                    }
                    i7 += zzamc.zzoc(iArr[i]);
                    i++;
                }
                zzy = zzy + i7 + (iArr.length * 2);
            }
            long j4 = this.zzcaI;
            if (j4 != 0) {
                zzy += zzamc.zze(21, j4);
            }
            long j5 = this.zzcaW;
            if (j5 != 0) {
                zzy += zzamc.zze(22, j5);
            }
            zzf zzf = this.zzcaX;
            return zzf != null ? zzy + zzamc.zzc(23, (zzamj) zzf) : zzy;
        }
    }

    public static final class zze extends zzamd<zze> {
        private static volatile zze[] zzcaY;
        public String value;
        public String zzaB;

        public zze() {
            zzXm();
        }

        public static zze[] zzXl() {
            if (zzcaY == null) {
                synchronized (zzamh.zzcai) {
                    if (zzcaY == null) {
                        zzcaY = new zze[0];
                    }
                }
            }
            return zzcaY;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            String str = this.zzaB;
            if (str == null) {
                if (zze.zzaB != null) {
                    return false;
                }
            } else if (!str.equals(zze.zzaB)) {
                return false;
            }
            String str2 = this.value;
            if (str2 == null) {
                if (zze.value != null) {
                    return false;
                }
            } else if (!str2.equals(zze.value)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zze.zzcaa == null || zze.zzcaa.isEmpty() : this.zzcaa.equals(zze.zzcaa);
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            String str = this.zzaB;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.value;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode3 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (!this.zzaB.equals("")) {
                zzamc.zzq(1, this.zzaB);
            }
            if (!this.value.equals("")) {
                zzamc.zzq(2, this.value);
            }
            super.writeTo(zzamc);
        }

        public zze zzXm() {
            this.zzaB = "";
            this.value = "";
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzac */
        public zze mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    this.zzaB = zzamb.readString();
                } else if (zzWC == 18) {
                    this.value = zzamb.readString();
                } else if (!super.zza(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (!this.zzaB.equals("")) {
                zzy += zzamc.zzr(1, this.zzaB);
            }
            return !this.value.equals("") ? zzy + zzamc.zzr(2, this.value) : zzy;
        }
    }

    public static final class zzf extends zzamd<zzf> {
        public int zzcaZ;

        public zzf() {
            zzXn();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (this.zzcaZ != zzf.zzcaZ) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzf.zzcaa == null || zzf.zzcaa.isEmpty() : this.zzcaa.equals(zzf.zzcaa);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + this.zzcaZ) * 31) + ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode());
        }

        public void writeTo(zzamc zzamc) throws IOException {
            int i = this.zzcaZ;
            if (i != -1) {
                zzamc.zzE(1, i);
            }
            super.writeTo(zzamc);
        }

        public zzf zzXn() {
            this.zzcaZ = -1;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzad */
        public zzf mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC != 0) {
                    if (zzWC == 8) {
                        int zzWG = zzamb.zzWG();
                        switch (zzWG) {
                            case -1:
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                                this.zzcaZ = zzWG;
                                break;
                        }
                    } else if (!super.zza(zzamb, zzWC)) {
                        return this;
                    }
                } else {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            int i = this.zzcaZ;
            return i != -1 ? zzy + zzamc.zzG(1, i) : zzy;
        }
    }
}
