package com.google.android.gms.internal;

import com.baidu.mapapi.MapView;
import java.io.IOException;

public interface zzag {

    public static final class zza extends zzamd<zza> {
        private static volatile zza[] zzjI;
        public int type;
        public String zzjJ;
        public zza[] zzjK;
        public zza[] zzjL;
        public zza[] zzjM;
        public String zzjN;
        public String zzjO;
        public long zzjP;
        public boolean zzjQ;
        public zza[] zzjR;
        public int[] zzjS;
        public boolean zzjT;

        public zza() {
            zzQ();
        }

        public static zza[] zzP() {
            if (zzjI == null) {
                synchronized (zzamh.zzcai) {
                    if (zzjI == null) {
                        zzjI = new zza[0];
                    }
                }
            }
            return zzjI;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.type != zza.type) {
                return false;
            }
            String str = this.zzjJ;
            if (str == null) {
                if (zza.zzjJ != null) {
                    return false;
                }
            } else if (!str.equals(zza.zzjJ)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzjK, (Object[]) zza.zzjK) || !zzamh.equals((Object[]) this.zzjL, (Object[]) zza.zzjL) || !zzamh.equals((Object[]) this.zzjM, (Object[]) zza.zzjM)) {
                return false;
            }
            String str2 = this.zzjN;
            if (str2 == null) {
                if (zza.zzjN != null) {
                    return false;
                }
            } else if (!str2.equals(zza.zzjN)) {
                return false;
            }
            String str3 = this.zzjO;
            if (str3 == null) {
                if (zza.zzjO != null) {
                    return false;
                }
            } else if (!str3.equals(zza.zzjO)) {
                return false;
            }
            if (this.zzjP == zza.zzjP && this.zzjQ == zza.zzjQ && zzamh.equals((Object[]) this.zzjR, (Object[]) zza.zzjR) && zzamh.equals(this.zzjS, zza.zzjS) && this.zzjT == zza.zzjT) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zza.zzcaa == null || zza.zzcaa.isEmpty() : this.zzcaa.equals(zza.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.type) * 31;
            String str = this.zzjJ;
            int i = 0;
            int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + zzamh.hashCode((Object[]) this.zzjK)) * 31) + zzamh.hashCode((Object[]) this.zzjL)) * 31) + zzamh.hashCode((Object[]) this.zzjM)) * 31;
            String str2 = this.zzjN;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzjO;
            int hashCode4 = str3 == null ? 0 : str3.hashCode();
            long j = this.zzjP;
            int i2 = (((hashCode3 + hashCode4) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            int i3 = 1231;
            int hashCode5 = (((((i2 + (this.zzjQ ? 1231 : 1237)) * 31) + zzamh.hashCode((Object[]) this.zzjR)) * 31) + zzamh.hashCode(this.zzjS)) * 31;
            if (!this.zzjT) {
                i3 = 1237;
            }
            int i4 = (hashCode5 + i3) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return i4 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zzamc.zzE(1, this.type);
            if (!this.zzjJ.equals("")) {
                zzamc.zzq(2, this.zzjJ);
            }
            zza[] zzaArr = this.zzjK;
            int i = 0;
            if (zzaArr != null && zzaArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zza[] zzaArr2 = this.zzjK;
                    if (i2 >= zzaArr2.length) {
                        break;
                    }
                    zza zza = zzaArr2[i2];
                    if (zza != null) {
                        zzamc.zza(3, (zzamj) zza);
                    }
                    i2++;
                }
            }
            zza[] zzaArr3 = this.zzjL;
            if (zzaArr3 != null && zzaArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    zza[] zzaArr4 = this.zzjL;
                    if (i3 >= zzaArr4.length) {
                        break;
                    }
                    zza zza2 = zzaArr4[i3];
                    if (zza2 != null) {
                        zzamc.zza(4, (zzamj) zza2);
                    }
                    i3++;
                }
            }
            zza[] zzaArr5 = this.zzjM;
            if (zzaArr5 != null && zzaArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    zza[] zzaArr6 = this.zzjM;
                    if (i4 >= zzaArr6.length) {
                        break;
                    }
                    zza zza3 = zzaArr6[i4];
                    if (zza3 != null) {
                        zzamc.zza(5, (zzamj) zza3);
                    }
                    i4++;
                }
            }
            if (!this.zzjN.equals("")) {
                zzamc.zzq(6, this.zzjN);
            }
            if (!this.zzjO.equals("")) {
                zzamc.zzq(7, this.zzjO);
            }
            long j = this.zzjP;
            if (j != 0) {
                zzamc.zzb(8, j);
            }
            boolean z = this.zzjT;
            if (z) {
                zzamc.zzj(9, z);
            }
            int[] iArr = this.zzjS;
            if (iArr != null && iArr.length > 0) {
                int i5 = 0;
                while (true) {
                    int[] iArr2 = this.zzjS;
                    if (i5 >= iArr2.length) {
                        break;
                    }
                    zzamc.zzE(10, iArr2[i5]);
                    i5++;
                }
            }
            zza[] zzaArr7 = this.zzjR;
            if (zzaArr7 != null && zzaArr7.length > 0) {
                while (true) {
                    zza[] zzaArr8 = this.zzjR;
                    if (i >= zzaArr8.length) {
                        break;
                    }
                    zza zza4 = zzaArr8[i];
                    if (zza4 != null) {
                        zzamc.zza(11, (zzamj) zza4);
                    }
                    i++;
                }
            }
            boolean z2 = this.zzjQ;
            if (z2) {
                zzamc.zzj(12, z2);
            }
            super.writeTo(zzamc);
        }

        public zza zzQ() {
            this.type = 1;
            this.zzjJ = "";
            this.zzjK = zzP();
            this.zzjL = zzP();
            this.zzjM = zzP();
            this.zzjN = "";
            this.zzjO = "";
            this.zzjP = 0;
            this.zzjQ = false;
            this.zzjR = zzP();
            this.zzjS = zzamm.zzcal;
            this.zzjT = false;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzk */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        return this;
                    case 8:
                        int zzWG = zzamb.zzWG();
                        switch (zzWG) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = zzWG;
                                break;
                        }
                    case 18:
                        this.zzjJ = zzamb.readString();
                        break;
                    case 26:
                        int zzc = zzamm.zzc(zzamb, 26);
                        zza[] zzaArr = this.zzjK;
                        int length = zzaArr == null ? 0 : zzaArr.length;
                        zza[] zzaArr2 = new zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjK, 0, zzaArr2, 0, length);
                        }
                        while (length < zzaArr2.length - 1) {
                            zzaArr2[length] = new zza();
                            zzamb.zza(zzaArr2[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zzaArr2[length] = new zza();
                        zzamb.zza(zzaArr2[length]);
                        this.zzjK = zzaArr2;
                        break;
                    case 34:
                        int zzc2 = zzamm.zzc(zzamb, 34);
                        zza[] zzaArr3 = this.zzjL;
                        int length2 = zzaArr3 == null ? 0 : zzaArr3.length;
                        zza[] zzaArr4 = new zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjL, 0, zzaArr4, 0, length2);
                        }
                        while (length2 < zzaArr4.length - 1) {
                            zzaArr4[length2] = new zza();
                            zzamb.zza(zzaArr4[length2]);
                            zzamb.zzWC();
                            length2++;
                        }
                        zzaArr4[length2] = new zza();
                        zzamb.zza(zzaArr4[length2]);
                        this.zzjL = zzaArr4;
                        break;
                    case 42:
                        int zzc3 = zzamm.zzc(zzamb, 42);
                        zza[] zzaArr5 = this.zzjM;
                        int length3 = zzaArr5 == null ? 0 : zzaArr5.length;
                        zza[] zzaArr6 = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjM, 0, zzaArr6, 0, length3);
                        }
                        while (length3 < zzaArr6.length - 1) {
                            zzaArr6[length3] = new zza();
                            zzamb.zza(zzaArr6[length3]);
                            zzamb.zzWC();
                            length3++;
                        }
                        zzaArr6[length3] = new zza();
                        zzamb.zza(zzaArr6[length3]);
                        this.zzjM = zzaArr6;
                        break;
                    case 50:
                        this.zzjN = zzamb.readString();
                        break;
                    case 58:
                        this.zzjO = zzamb.readString();
                        break;
                    case 64:
                        this.zzjP = zzamb.zzWF();
                        break;
                    case 72:
                        this.zzjT = zzamb.zzWI();
                        break;
                    case MapView.LayoutParams.BOTTOM:
                        int zzc4 = zzamm.zzc(zzamb, 80);
                        int[] iArr = new int[zzc4];
                        int i = 0;
                        for (int i2 = 0; i2 < zzc4; i2++) {
                            if (i2 != 0) {
                                zzamb.zzWC();
                            }
                            int zzWG2 = zzamb.zzWG();
                            switch (zzWG2) {
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
                                    iArr[i] = zzWG2;
                                    i++;
                                    break;
                            }
                        }
                        if (i != 0) {
                            int[] iArr2 = this.zzjS;
                            int length4 = iArr2 == null ? 0 : iArr2.length;
                            if (length4 != 0 || i != zzc4) {
                                int[] iArr3 = new int[(length4 + i)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzjS, 0, iArr3, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr3, length4, i);
                                this.zzjS = iArr3;
                                break;
                            } else {
                                this.zzjS = iArr;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 82:
                        int zznW = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i3 = 0;
                        while (zzamb.zzWQ() > 0) {
                            switch (zzamb.zzWG()) {
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
                                    i3++;
                                    break;
                            }
                        }
                        if (i3 != 0) {
                            zzamb.zznY(position);
                            int[] iArr4 = this.zzjS;
                            int length5 = iArr4 == null ? 0 : iArr4.length;
                            int[] iArr5 = new int[(i3 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.zzjS, 0, iArr5, 0, length5);
                            }
                            while (zzamb.zzWQ() > 0) {
                                int zzWG3 = zzamb.zzWG();
                                switch (zzWG3) {
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
                                        iArr5[length5] = zzWG3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzjS = iArr5;
                        }
                        zzamb.zznX(zznW);
                        break;
                    case 90:
                        int zzc5 = zzamm.zzc(zzamb, 90);
                        zza[] zzaArr7 = this.zzjR;
                        int length6 = zzaArr7 == null ? 0 : zzaArr7.length;
                        zza[] zzaArr8 = new zza[(zzc5 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjR, 0, zzaArr8, 0, length6);
                        }
                        while (length6 < zzaArr8.length - 1) {
                            zzaArr8[length6] = new zza();
                            zzamb.zza(zzaArr8[length6]);
                            zzamb.zzWC();
                            length6++;
                        }
                        zzaArr8[length6] = new zza();
                        zzamb.zza(zzaArr8[length6]);
                        this.zzjR = zzaArr8;
                        break;
                    case 96:
                        this.zzjQ = zzamb.zzWI();
                        break;
                    default:
                        if (super.zza(zzamb, zzWC)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int[] iArr;
            int zzy = super.zzy() + zzamc.zzG(1, this.type);
            if (!this.zzjJ.equals("")) {
                zzy += zzamc.zzr(2, this.zzjJ);
            }
            zza[] zzaArr = this.zzjK;
            int i = 0;
            if (zzaArr != null && zzaArr.length > 0) {
                int i2 = zzy;
                int i3 = 0;
                while (true) {
                    zza[] zzaArr2 = this.zzjK;
                    if (i3 >= zzaArr2.length) {
                        break;
                    }
                    zza zza = zzaArr2[i3];
                    if (zza != null) {
                        i2 += zzamc.zzc(3, (zzamj) zza);
                    }
                    i3++;
                }
                zzy = i2;
            }
            zza[] zzaArr3 = this.zzjL;
            if (zzaArr3 != null && zzaArr3.length > 0) {
                int i4 = zzy;
                int i5 = 0;
                while (true) {
                    zza[] zzaArr4 = this.zzjL;
                    if (i5 >= zzaArr4.length) {
                        break;
                    }
                    zza zza2 = zzaArr4[i5];
                    if (zza2 != null) {
                        i4 += zzamc.zzc(4, (zzamj) zza2);
                    }
                    i5++;
                }
                zzy = i4;
            }
            zza[] zzaArr5 = this.zzjM;
            if (zzaArr5 != null && zzaArr5.length > 0) {
                int i6 = zzy;
                int i7 = 0;
                while (true) {
                    zza[] zzaArr6 = this.zzjM;
                    if (i7 >= zzaArr6.length) {
                        break;
                    }
                    zza zza3 = zzaArr6[i7];
                    if (zza3 != null) {
                        i6 += zzamc.zzc(5, (zzamj) zza3);
                    }
                    i7++;
                }
                zzy = i6;
            }
            if (!this.zzjN.equals("")) {
                zzy += zzamc.zzr(6, this.zzjN);
            }
            if (!this.zzjO.equals("")) {
                zzy += zzamc.zzr(7, this.zzjO);
            }
            long j = this.zzjP;
            if (j != 0) {
                zzy += zzamc.zze(8, j);
            }
            boolean z = this.zzjT;
            if (z) {
                zzy += zzamc.zzk(9, z);
            }
            int[] iArr2 = this.zzjS;
            if (iArr2 != null && iArr2.length > 0) {
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    iArr = this.zzjS;
                    if (i8 >= iArr.length) {
                        break;
                    }
                    i9 += zzamc.zzoc(iArr[i8]);
                    i8++;
                }
                zzy = zzy + i9 + (iArr.length * 1);
            }
            zza[] zzaArr7 = this.zzjR;
            if (zzaArr7 != null && zzaArr7.length > 0) {
                while (true) {
                    zza[] zzaArr8 = this.zzjR;
                    if (i >= zzaArr8.length) {
                        break;
                    }
                    zza zza4 = zzaArr8[i];
                    if (zza4 != null) {
                        zzy += zzamc.zzc(11, (zzamj) zza4);
                    }
                    i++;
                }
            }
            boolean z2 = this.zzjQ;
            return z2 ? zzy + zzamc.zzk(12, z2) : zzy;
        }
    }
}
