package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.baidu.mapapi.MapView;
import com.google.android.gms.internal.zzag;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.IOException;
import object.p2pipcam.content.ContentCommon;

public interface zzaf {

    public static final class zza extends zzamd<zza> {
        public int level;
        public int zziC;
        public int zziD;

        public zza() {
            zzA();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.level == zza.level && this.zziC == zza.zziC && this.zziD == zza.zziD) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zza.zzcaa == null || zza.zzcaa.isEmpty() : this.zzcaa.equals(zza.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zziC) * 31) + this.zziD) * 31) + ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode());
        }

        public void writeTo(zzamc zzamc) throws IOException {
            int i = this.level;
            if (i != 1) {
                zzamc.zzE(1, i);
            }
            int i2 = this.zziC;
            if (i2 != 0) {
                zzamc.zzE(2, i2);
            }
            int i3 = this.zziD;
            if (i3 != 0) {
                zzamc.zzE(3, i3);
            }
            super.writeTo(zzamc);
        }

        public zza zzA() {
            this.level = 1;
            this.zziC = 0;
            this.zziD = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zza */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 8) {
                    int zzWG = zzamb.zzWG();
                    if (zzWG == 1 || zzWG == 2 || zzWG == 3) {
                        this.level = zzWG;
                    }
                } else if (zzWC == 16) {
                    this.zziC = zzamb.zzWG();
                } else if (zzWC == 24) {
                    this.zziD = zzamb.zzWG();
                } else if (!super.zza(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            int i = this.level;
            if (i != 1) {
                zzy += zzamc.zzG(1, i);
            }
            int i2 = this.zziC;
            if (i2 != 0) {
                zzy += zzamc.zzG(2, i2);
            }
            int i3 = this.zziD;
            return i3 != 0 ? zzy + zzamc.zzG(3, i3) : zzy;
        }
    }

    public static final class zzb extends zzamd<zzb> {
        private static volatile zzb[] zziE;
        public int name;
        public int[] zziF;
        public int zziG;
        public boolean zziH;
        public boolean zziI;

        public zzb() {
            zzC();
        }

        public static zzb[] zzB() {
            if (zziE == null) {
                synchronized (zzamh.zzcai) {
                    if (zziE == null) {
                        zziE = new zzb[0];
                    }
                }
            }
            return zziE;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (zzamh.equals(this.zziF, zzb.zziF) && this.zziG == zzb.zziG && this.name == zzb.name && this.zziH == zzb.zziH && this.zziI == zzb.zziI) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzb.zzcaa == null || zzb.zzcaa.isEmpty() : this.zzcaa.equals(zzb.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode(this.zziF)) * 31) + this.zziG) * 31) + this.name) * 31) + (this.zziH ? 1231 : 1237)) * 31;
            if (!this.zziI) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode());
        }

        public void writeTo(zzamc zzamc) throws IOException {
            boolean z = this.zziI;
            if (z) {
                zzamc.zzj(1, z);
            }
            zzamc.zzE(2, this.zziG);
            int[] iArr = this.zziF;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.zziF;
                    if (i >= iArr2.length) {
                        break;
                    }
                    zzamc.zzE(3, iArr2[i]);
                    i++;
                }
            }
            int i2 = this.name;
            if (i2 != 0) {
                zzamc.zzE(4, i2);
            }
            boolean z2 = this.zziH;
            if (z2) {
                zzamc.zzj(6, z2);
            }
            super.writeTo(zzamc);
        }

        public zzb zzC() {
            this.zziF = zzamm.zzcal;
            this.zziG = 0;
            this.name = 0;
            this.zziH = false;
            this.zziI = false;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzb */
        public zzb mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 8) {
                    this.zziI = zzamb.zzWI();
                } else if (zzWC == 16) {
                    this.zziG = zzamb.zzWG();
                } else if (zzWC == 24) {
                    int zzc = zzamm.zzc(zzamb, 24);
                    int[] iArr = this.zziF;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zziF, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = zzamb.zzWG();
                        zzamb.zzWC();
                        length++;
                    }
                    iArr2[length] = zzamb.zzWG();
                    this.zziF = iArr2;
                } else if (zzWC == 26) {
                    int zznW = zzamb.zznW(zzamb.zzWL());
                    int position = zzamb.getPosition();
                    int i = 0;
                    while (zzamb.zzWQ() > 0) {
                        zzamb.zzWG();
                        i++;
                    }
                    zzamb.zznY(position);
                    int[] iArr3 = this.zziF;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[(i + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zziF, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = zzamb.zzWG();
                        length2++;
                    }
                    this.zziF = iArr4;
                    zzamb.zznX(zznW);
                } else if (zzWC == 32) {
                    this.name = zzamb.zzWG();
                } else if (zzWC == 48) {
                    this.zziH = zzamb.zzWI();
                } else if (!super.zza(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int[] iArr;
            int zzy = super.zzy();
            boolean z = this.zziI;
            if (z) {
                zzy += zzamc.zzk(1, z);
            }
            int zzG = zzy + zzamc.zzG(2, this.zziG);
            int[] iArr2 = this.zziF;
            if (iArr2 != null && iArr2.length > 0) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    iArr = this.zziF;
                    if (i >= iArr.length) {
                        break;
                    }
                    i2 += zzamc.zzoc(iArr[i]);
                    i++;
                }
                zzG = zzG + i2 + (iArr.length * 1);
            }
            int i3 = this.name;
            if (i3 != 0) {
                zzG += zzamc.zzG(4, i3);
            }
            boolean z2 = this.zziH;
            return z2 ? zzG + zzamc.zzk(6, z2) : zzG;
        }
    }

    public static final class zzc extends zzamd<zzc> {
        private static volatile zzc[] zziJ;
        public String zzaB;
        public long zziK;
        public long zziL;
        public boolean zziM;
        public long zziN;

        public zzc() {
            zzE();
        }

        public static zzc[] zzD() {
            if (zziJ == null) {
                synchronized (zzamh.zzcai) {
                    if (zziJ == null) {
                        zziJ = new zzc[0];
                    }
                }
            }
            return zziJ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            String str = this.zzaB;
            if (str == null) {
                if (zzc.zzaB != null) {
                    return false;
                }
            } else if (!str.equals(zzc.zzaB)) {
                return false;
            }
            if (this.zziK == zzc.zziK && this.zziL == zzc.zziL && this.zziM == zzc.zziM && this.zziN == zzc.zziN) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzc.zzcaa == null || zzc.zzcaa.isEmpty() : this.zzcaa.equals(zzc.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            String str = this.zzaB;
            int i = 0;
            int hashCode2 = str == null ? 0 : str.hashCode();
            long j = this.zziK;
            long j2 = this.zziL;
            int i2 = (((((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            int i3 = this.zziM ? 1231 : 1237;
            long j3 = this.zziN;
            int i4 = (((i2 + i3) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return i4 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (!this.zzaB.equals("")) {
                zzamc.zzq(1, this.zzaB);
            }
            long j = this.zziK;
            if (j != 0) {
                zzamc.zzb(2, j);
            }
            long j2 = this.zziL;
            if (j2 != 2147483647L) {
                zzamc.zzb(3, j2);
            }
            boolean z = this.zziM;
            if (z) {
                zzamc.zzj(4, z);
            }
            long j3 = this.zziN;
            if (j3 != 0) {
                zzamc.zzb(5, j3);
            }
            super.writeTo(zzamc);
        }

        public zzc zzE() {
            this.zzaB = "";
            this.zziK = 0;
            this.zziL = 2147483647L;
            this.zziM = false;
            this.zziN = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzc */
        public zzc mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    this.zzaB = zzamb.readString();
                } else if (zzWC == 16) {
                    this.zziK = zzamb.zzWF();
                } else if (zzWC == 24) {
                    this.zziL = zzamb.zzWF();
                } else if (zzWC == 32) {
                    this.zziM = zzamb.zzWI();
                } else if (zzWC == 40) {
                    this.zziN = zzamb.zzWF();
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
            long j = this.zziK;
            if (j != 0) {
                zzy += zzamc.zze(2, j);
            }
            long j2 = this.zziL;
            if (j2 != 2147483647L) {
                zzy += zzamc.zze(3, j2);
            }
            boolean z = this.zziM;
            if (z) {
                zzy += zzamc.zzk(4, z);
            }
            long j3 = this.zziN;
            return j3 != 0 ? zzy + zzamc.zze(5, j3) : zzy;
        }
    }

    public static final class zzd extends zzamd<zzd> {
        public zzag.zza[] zziO;
        public zzag.zza[] zziP;
        public zzc[] zziQ;

        public zzd() {
            zzF();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            if (zzamh.equals((Object[]) this.zziO, (Object[]) zzd.zziO) && zzamh.equals((Object[]) this.zziP, (Object[]) zzd.zziP) && zzamh.equals((Object[]) this.zziQ, (Object[]) zzd.zziQ)) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzd.zzcaa == null || zzd.zzcaa.isEmpty() : this.zzcaa.equals(zzd.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zziO)) * 31) + zzamh.hashCode((Object[]) this.zziP)) * 31) + zzamh.hashCode((Object[]) this.zziQ)) * 31) + ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode());
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zzag.zza[] zzaArr = this.zziO;
            int i = 0;
            if (zzaArr != null && zzaArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zzag.zza[] zzaArr2 = this.zziO;
                    if (i2 >= zzaArr2.length) {
                        break;
                    }
                    zzag.zza zza = zzaArr2[i2];
                    if (zza != null) {
                        zzamc.zza(1, (zzamj) zza);
                    }
                    i2++;
                }
            }
            zzag.zza[] zzaArr3 = this.zziP;
            if (zzaArr3 != null && zzaArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    zzag.zza[] zzaArr4 = this.zziP;
                    if (i3 >= zzaArr4.length) {
                        break;
                    }
                    zzag.zza zza2 = zzaArr4[i3];
                    if (zza2 != null) {
                        zzamc.zza(2, (zzamj) zza2);
                    }
                    i3++;
                }
            }
            zzc[] zzcArr = this.zziQ;
            if (zzcArr != null && zzcArr.length > 0) {
                while (true) {
                    zzc[] zzcArr2 = this.zziQ;
                    if (i >= zzcArr2.length) {
                        break;
                    }
                    zzc zzc = zzcArr2[i];
                    if (zzc != null) {
                        zzamc.zza(3, (zzamj) zzc);
                    }
                    i++;
                }
            }
            super.writeTo(zzamc);
        }

        public zzd zzF() {
            this.zziO = zzag.zza.zzP();
            this.zziP = zzag.zza.zzP();
            this.zziQ = zzc.zzD();
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzd */
        public zzd mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    int zzc = zzamm.zzc(zzamb, 10);
                    zzag.zza[] zzaArr = this.zziO;
                    int length = zzaArr == null ? 0 : zzaArr.length;
                    zzag.zza[] zzaArr2 = new zzag.zza[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zziO, 0, zzaArr2, 0, length);
                    }
                    while (length < zzaArr2.length - 1) {
                        zzaArr2[length] = new zzag.zza();
                        zzamb.zza(zzaArr2[length]);
                        zzamb.zzWC();
                        length++;
                    }
                    zzaArr2[length] = new zzag.zza();
                    zzamb.zza(zzaArr2[length]);
                    this.zziO = zzaArr2;
                } else if (zzWC == 18) {
                    int zzc2 = zzamm.zzc(zzamb, 18);
                    zzag.zza[] zzaArr3 = this.zziP;
                    int length2 = zzaArr3 == null ? 0 : zzaArr3.length;
                    zzag.zza[] zzaArr4 = new zzag.zza[(zzc2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zziP, 0, zzaArr4, 0, length2);
                    }
                    while (length2 < zzaArr4.length - 1) {
                        zzaArr4[length2] = new zzag.zza();
                        zzamb.zza(zzaArr4[length2]);
                        zzamb.zzWC();
                        length2++;
                    }
                    zzaArr4[length2] = new zzag.zza();
                    zzamb.zza(zzaArr4[length2]);
                    this.zziP = zzaArr4;
                } else if (zzWC == 26) {
                    int zzc3 = zzamm.zzc(zzamb, 26);
                    zzc[] zzcArr = this.zziQ;
                    int length3 = zzcArr == null ? 0 : zzcArr.length;
                    zzc[] zzcArr2 = new zzc[(zzc3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zziQ, 0, zzcArr2, 0, length3);
                    }
                    while (length3 < zzcArr2.length - 1) {
                        zzcArr2[length3] = new zzc();
                        zzamb.zza(zzcArr2[length3]);
                        zzamb.zzWC();
                        length3++;
                    }
                    zzcArr2[length3] = new zzc();
                    zzamb.zza(zzcArr2[length3]);
                    this.zziQ = zzcArr2;
                } else if (!super.zza(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            zzag.zza[] zzaArr = this.zziO;
            int i = 0;
            if (zzaArr != null && zzaArr.length > 0) {
                int i2 = zzy;
                int i3 = 0;
                while (true) {
                    zzag.zza[] zzaArr2 = this.zziO;
                    if (i3 >= zzaArr2.length) {
                        break;
                    }
                    zzag.zza zza = zzaArr2[i3];
                    if (zza != null) {
                        i2 += zzamc.zzc(1, (zzamj) zza);
                    }
                    i3++;
                }
                zzy = i2;
            }
            zzag.zza[] zzaArr3 = this.zziP;
            if (zzaArr3 != null && zzaArr3.length > 0) {
                int i4 = zzy;
                int i5 = 0;
                while (true) {
                    zzag.zza[] zzaArr4 = this.zziP;
                    if (i5 >= zzaArr4.length) {
                        break;
                    }
                    zzag.zza zza2 = zzaArr4[i5];
                    if (zza2 != null) {
                        i4 += zzamc.zzc(2, (zzamj) zza2);
                    }
                    i5++;
                }
                zzy = i4;
            }
            zzc[] zzcArr = this.zziQ;
            if (zzcArr != null && zzcArr.length > 0) {
                while (true) {
                    zzc[] zzcArr2 = this.zziQ;
                    if (i >= zzcArr2.length) {
                        break;
                    }
                    zzc zzc = zzcArr2[i];
                    if (zzc != null) {
                        zzy += zzamc.zzc(3, (zzamj) zzc);
                    }
                    i++;
                }
            }
            return zzy;
        }
    }

    public static final class zze extends zzamd<zze> {
        private static volatile zze[] zziR;
        public int key;
        public int value;

        public zze() {
            zzH();
        }

        public static zze[] zzG() {
            if (zziR == null) {
                synchronized (zzamh.zzcai) {
                    if (zziR == null) {
                        zziR = new zze[0];
                    }
                }
            }
            return zziR;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.key == zze.key && this.value == zze.value) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zze.zzcaa == null || zze.zzcaa.isEmpty() : this.zzcaa.equals(zze.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            return ((((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31) + ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode());
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zzamc.zzE(1, this.key);
            zzamc.zzE(2, this.value);
            super.writeTo(zzamc);
        }

        public zze zzH() {
            this.key = 0;
            this.value = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zze */
        public zze mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 8) {
                    this.key = zzamb.zzWG();
                } else if (zzWC == 16) {
                    this.value = zzamb.zzWG();
                } else if (!super.zza(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            return super.zzy() + zzamc.zzG(1, this.key) + zzamc.zzG(2, this.value);
        }
    }

    public static final class zzf extends zzamd<zzf> {
        public String version;
        public String[] zziS;
        public String[] zziT;
        public zzag.zza[] zziU;
        public zze[] zziV;
        public zzb[] zziW;
        public zzb[] zziX;
        public zzb[] zziY;
        public zzg[] zziZ;
        public String zzja;
        public String zzjb;
        public String zzjc;
        public zza zzjd;
        public float zzje;
        public boolean zzjf;
        public String[] zzjg;
        public int zzjh;

        public zzf() {
            zzI();
        }

        public static zzf zzc(byte[] bArr) throws zzami {
            return (zzf) zzamj.mergeFrom(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (!zzamh.equals((Object[]) this.zziS, (Object[]) zzf.zziS) || !zzamh.equals((Object[]) this.zziT, (Object[]) zzf.zziT) || !zzamh.equals((Object[]) this.zziU, (Object[]) zzf.zziU) || !zzamh.equals((Object[]) this.zziV, (Object[]) zzf.zziV) || !zzamh.equals((Object[]) this.zziW, (Object[]) zzf.zziW) || !zzamh.equals((Object[]) this.zziX, (Object[]) zzf.zziX) || !zzamh.equals((Object[]) this.zziY, (Object[]) zzf.zziY) || !zzamh.equals((Object[]) this.zziZ, (Object[]) zzf.zziZ)) {
                return false;
            }
            String str = this.zzja;
            if (str == null) {
                if (zzf.zzja != null) {
                    return false;
                }
            } else if (!str.equals(zzf.zzja)) {
                return false;
            }
            String str2 = this.zzjb;
            if (str2 == null) {
                if (zzf.zzjb != null) {
                    return false;
                }
            } else if (!str2.equals(zzf.zzjb)) {
                return false;
            }
            String str3 = this.zzjc;
            if (str3 == null) {
                if (zzf.zzjc != null) {
                    return false;
                }
            } else if (!str3.equals(zzf.zzjc)) {
                return false;
            }
            String str4 = this.version;
            if (str4 == null) {
                if (zzf.version != null) {
                    return false;
                }
            } else if (!str4.equals(zzf.version)) {
                return false;
            }
            zza zza = this.zzjd;
            if (zza == null) {
                if (zzf.zzjd != null) {
                    return false;
                }
            } else if (!zza.equals(zzf.zzjd)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzje) == Float.floatToIntBits(zzf.zzje) && this.zzjf == zzf.zzjf && zzamh.equals((Object[]) this.zzjg, (Object[]) zzf.zzjg) && this.zzjh == zzf.zzjh) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzf.zzcaa == null || zzf.zzcaa.isEmpty() : this.zzcaa.equals(zzf.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = (((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zziS)) * 31) + zzamh.hashCode((Object[]) this.zziT)) * 31) + zzamh.hashCode((Object[]) this.zziU)) * 31) + zzamh.hashCode((Object[]) this.zziV)) * 31) + zzamh.hashCode((Object[]) this.zziW)) * 31) + zzamh.hashCode((Object[]) this.zziX)) * 31) + zzamh.hashCode((Object[]) this.zziY)) * 31) + zzamh.hashCode((Object[]) this.zziZ)) * 31;
            String str = this.zzja;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.zzjb;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzjc;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.version;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            zza zza = this.zzjd;
            int hashCode6 = (((((((((hashCode5 + (zza == null ? 0 : zza.hashCode())) * 31) + Float.floatToIntBits(this.zzje)) * 31) + (this.zzjf ? 1231 : 1237)) * 31) + zzamh.hashCode((Object[]) this.zzjg)) * 31) + this.zzjh) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode6 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            String[] strArr = this.zziT;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.zziT;
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
            zzag.zza[] zzaArr = this.zziU;
            if (zzaArr != null && zzaArr.length > 0) {
                int i3 = 0;
                while (true) {
                    zzag.zza[] zzaArr2 = this.zziU;
                    if (i3 >= zzaArr2.length) {
                        break;
                    }
                    zzag.zza zza = zzaArr2[i3];
                    if (zza != null) {
                        zzamc.zza(2, (zzamj) zza);
                    }
                    i3++;
                }
            }
            zze[] zzeArr = this.zziV;
            if (zzeArr != null && zzeArr.length > 0) {
                int i4 = 0;
                while (true) {
                    zze[] zzeArr2 = this.zziV;
                    if (i4 >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i4];
                    if (zze != null) {
                        zzamc.zza(3, (zzamj) zze);
                    }
                    i4++;
                }
            }
            zzb[] zzbArr = this.zziW;
            if (zzbArr != null && zzbArr.length > 0) {
                int i5 = 0;
                while (true) {
                    zzb[] zzbArr2 = this.zziW;
                    if (i5 >= zzbArr2.length) {
                        break;
                    }
                    zzb zzb = zzbArr2[i5];
                    if (zzb != null) {
                        zzamc.zza(4, (zzamj) zzb);
                    }
                    i5++;
                }
            }
            zzb[] zzbArr3 = this.zziX;
            if (zzbArr3 != null && zzbArr3.length > 0) {
                int i6 = 0;
                while (true) {
                    zzb[] zzbArr4 = this.zziX;
                    if (i6 >= zzbArr4.length) {
                        break;
                    }
                    zzb zzb2 = zzbArr4[i6];
                    if (zzb2 != null) {
                        zzamc.zza(5, (zzamj) zzb2);
                    }
                    i6++;
                }
            }
            zzb[] zzbArr5 = this.zziY;
            if (zzbArr5 != null && zzbArr5.length > 0) {
                int i7 = 0;
                while (true) {
                    zzb[] zzbArr6 = this.zziY;
                    if (i7 >= zzbArr6.length) {
                        break;
                    }
                    zzb zzb3 = zzbArr6[i7];
                    if (zzb3 != null) {
                        zzamc.zza(6, (zzamj) zzb3);
                    }
                    i7++;
                }
            }
            zzg[] zzgArr = this.zziZ;
            if (zzgArr != null && zzgArr.length > 0) {
                int i8 = 0;
                while (true) {
                    zzg[] zzgArr2 = this.zziZ;
                    if (i8 >= zzgArr2.length) {
                        break;
                    }
                    zzg zzg = zzgArr2[i8];
                    if (zzg != null) {
                        zzamc.zza(7, (zzamj) zzg);
                    }
                    i8++;
                }
            }
            if (!this.zzja.equals("")) {
                zzamc.zzq(9, this.zzja);
            }
            if (!this.zzjb.equals("")) {
                zzamc.zzq(10, this.zzjb);
            }
            if (!this.zzjc.equals(PushConstants.PUSH_TYPE_NOTIFY)) {
                zzamc.zzq(12, this.zzjc);
            }
            if (!this.version.equals("")) {
                zzamc.zzq(13, this.version);
            }
            zza zza2 = this.zzjd;
            if (zza2 != null) {
                zzamc.zza(14, (zzamj) zza2);
            }
            if (Float.floatToIntBits(this.zzje) != Float.floatToIntBits(0.0f)) {
                zzamc.zzb(15, this.zzje);
            }
            String[] strArr3 = this.zzjg;
            if (strArr3 != null && strArr3.length > 0) {
                int i9 = 0;
                while (true) {
                    String[] strArr4 = this.zzjg;
                    if (i9 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i9];
                    if (str2 != null) {
                        zzamc.zzq(16, str2);
                    }
                    i9++;
                }
            }
            int i10 = this.zzjh;
            if (i10 != 0) {
                zzamc.zzE(17, i10);
            }
            boolean z = this.zzjf;
            if (z) {
                zzamc.zzj(18, z);
            }
            String[] strArr5 = this.zziS;
            if (strArr5 != null && strArr5.length > 0) {
                while (true) {
                    String[] strArr6 = this.zziS;
                    if (i >= strArr6.length) {
                        break;
                    }
                    String str3 = strArr6[i];
                    if (str3 != null) {
                        zzamc.zzq(19, str3);
                    }
                    i++;
                }
            }
            super.writeTo(zzamc);
        }

        public zzf zzI() {
            this.zziS = zzamm.zzcaq;
            this.zziT = zzamm.zzcaq;
            this.zziU = zzag.zza.zzP();
            this.zziV = zze.zzG();
            this.zziW = zzb.zzB();
            this.zziX = zzb.zzB();
            this.zziY = zzb.zzB();
            this.zziZ = zzg.zzJ();
            this.zzja = "";
            this.zzjb = "";
            this.zzjc = PushConstants.PUSH_TYPE_NOTIFY;
            this.version = "";
            this.zzjd = null;
            this.zzje = 0.0f;
            this.zzjf = false;
            this.zzjg = zzamm.zzcaq;
            this.zzjh = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzf */
        public zzf mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        return this;
                    case 10:
                        int zzc = zzamm.zzc(zzamb, 10);
                        String[] strArr = this.zziT;
                        int length = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziT, 0, strArr2, 0, length);
                        }
                        while (length < strArr2.length - 1) {
                            strArr2[length] = zzamb.readString();
                            zzamb.zzWC();
                            length++;
                        }
                        strArr2[length] = zzamb.readString();
                        this.zziT = strArr2;
                        break;
                    case 18:
                        int zzc2 = zzamm.zzc(zzamb, 18);
                        zzag.zza[] zzaArr = this.zziU;
                        int length2 = zzaArr == null ? 0 : zzaArr.length;
                        zzag.zza[] zzaArr2 = new zzag.zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziU, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zzag.zza();
                            zzamb.zza(zzaArr2[length2]);
                            zzamb.zzWC();
                            length2++;
                        }
                        zzaArr2[length2] = new zzag.zza();
                        zzamb.zza(zzaArr2[length2]);
                        this.zziU = zzaArr2;
                        break;
                    case 26:
                        int zzc3 = zzamm.zzc(zzamb, 26);
                        zze[] zzeArr = this.zziV;
                        int length3 = zzeArr == null ? 0 : zzeArr.length;
                        zze[] zzeArr2 = new zze[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziV, 0, zzeArr2, 0, length3);
                        }
                        while (length3 < zzeArr2.length - 1) {
                            zzeArr2[length3] = new zze();
                            zzamb.zza(zzeArr2[length3]);
                            zzamb.zzWC();
                            length3++;
                        }
                        zzeArr2[length3] = new zze();
                        zzamb.zza(zzeArr2[length3]);
                        this.zziV = zzeArr2;
                        break;
                    case 34:
                        int zzc4 = zzamm.zzc(zzamb, 34);
                        zzb[] zzbArr = this.zziW;
                        int length4 = zzbArr == null ? 0 : zzbArr.length;
                        zzb[] zzbArr2 = new zzb[(zzc4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zziW, 0, zzbArr2, 0, length4);
                        }
                        while (length4 < zzbArr2.length - 1) {
                            zzbArr2[length4] = new zzb();
                            zzamb.zza(zzbArr2[length4]);
                            zzamb.zzWC();
                            length4++;
                        }
                        zzbArr2[length4] = new zzb();
                        zzamb.zza(zzbArr2[length4]);
                        this.zziW = zzbArr2;
                        break;
                    case 42:
                        int zzc5 = zzamm.zzc(zzamb, 42);
                        zzb[] zzbArr3 = this.zziX;
                        int length5 = zzbArr3 == null ? 0 : zzbArr3.length;
                        zzb[] zzbArr4 = new zzb[(zzc5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zziX, 0, zzbArr4, 0, length5);
                        }
                        while (length5 < zzbArr4.length - 1) {
                            zzbArr4[length5] = new zzb();
                            zzamb.zza(zzbArr4[length5]);
                            zzamb.zzWC();
                            length5++;
                        }
                        zzbArr4[length5] = new zzb();
                        zzamb.zza(zzbArr4[length5]);
                        this.zziX = zzbArr4;
                        break;
                    case 50:
                        int zzc6 = zzamm.zzc(zzamb, 50);
                        zzb[] zzbArr5 = this.zziY;
                        int length6 = zzbArr5 == null ? 0 : zzbArr5.length;
                        zzb[] zzbArr6 = new zzb[(zzc6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zziY, 0, zzbArr6, 0, length6);
                        }
                        while (length6 < zzbArr6.length - 1) {
                            zzbArr6[length6] = new zzb();
                            zzamb.zza(zzbArr6[length6]);
                            zzamb.zzWC();
                            length6++;
                        }
                        zzbArr6[length6] = new zzb();
                        zzamb.zza(zzbArr6[length6]);
                        this.zziY = zzbArr6;
                        break;
                    case 58:
                        int zzc7 = zzamm.zzc(zzamb, 58);
                        zzg[] zzgArr = this.zziZ;
                        int length7 = zzgArr == null ? 0 : zzgArr.length;
                        zzg[] zzgArr2 = new zzg[(zzc7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zziZ, 0, zzgArr2, 0, length7);
                        }
                        while (length7 < zzgArr2.length - 1) {
                            zzgArr2[length7] = new zzg();
                            zzamb.zza(zzgArr2[length7]);
                            zzamb.zzWC();
                            length7++;
                        }
                        zzgArr2[length7] = new zzg();
                        zzamb.zza(zzgArr2[length7]);
                        this.zziZ = zzgArr2;
                        break;
                    case 74:
                        this.zzja = zzamb.readString();
                        break;
                    case 82:
                        this.zzjb = zzamb.readString();
                        break;
                    case 98:
                        this.zzjc = zzamb.readString();
                        break;
                    case 106:
                        this.version = zzamb.readString();
                        break;
                    case 114:
                        if (this.zzjd == null) {
                            this.zzjd = new zza();
                        }
                        zzamb.zza(this.zzjd);
                        break;
                    case 125:
                        this.zzje = zzamb.readFloat();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        int zzc8 = zzamm.zzc(zzamb, TransportMediator.KEYCODE_MEDIA_RECORD);
                        String[] strArr3 = this.zzjg;
                        int length8 = strArr3 == null ? 0 : strArr3.length;
                        String[] strArr4 = new String[(zzc8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzjg, 0, strArr4, 0, length8);
                        }
                        while (length8 < strArr4.length - 1) {
                            strArr4[length8] = zzamb.readString();
                            zzamb.zzWC();
                            length8++;
                        }
                        strArr4[length8] = zzamb.readString();
                        this.zzjg = strArr4;
                        break;
                    case 136:
                        this.zzjh = zzamb.zzWG();
                        break;
                    case 144:
                        this.zzjf = zzamb.zzWI();
                        break;
                    case 154:
                        int zzc9 = zzamm.zzc(zzamb, 154);
                        String[] strArr5 = this.zziS;
                        int length9 = strArr5 == null ? 0 : strArr5.length;
                        String[] strArr6 = new String[(zzc9 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zziS, 0, strArr6, 0, length9);
                        }
                        while (length9 < strArr6.length - 1) {
                            strArr6[length9] = zzamb.readString();
                            zzamb.zzWC();
                            length9++;
                        }
                        strArr6[length9] = zzamb.readString();
                        this.zziS = strArr6;
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
            int zzy = super.zzy();
            String[] strArr = this.zziT;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.zziT;
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
            zzag.zza[] zzaArr = this.zziU;
            if (zzaArr != null && zzaArr.length > 0) {
                int i5 = zzy;
                int i6 = 0;
                while (true) {
                    zzag.zza[] zzaArr2 = this.zziU;
                    if (i6 >= zzaArr2.length) {
                        break;
                    }
                    zzag.zza zza = zzaArr2[i6];
                    if (zza != null) {
                        i5 += zzamc.zzc(2, (zzamj) zza);
                    }
                    i6++;
                }
                zzy = i5;
            }
            zze[] zzeArr = this.zziV;
            if (zzeArr != null && zzeArr.length > 0) {
                int i7 = zzy;
                int i8 = 0;
                while (true) {
                    zze[] zzeArr2 = this.zziV;
                    if (i8 >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i8];
                    if (zze != null) {
                        i7 += zzamc.zzc(3, (zzamj) zze);
                    }
                    i8++;
                }
                zzy = i7;
            }
            zzb[] zzbArr = this.zziW;
            if (zzbArr != null && zzbArr.length > 0) {
                int i9 = zzy;
                int i10 = 0;
                while (true) {
                    zzb[] zzbArr2 = this.zziW;
                    if (i10 >= zzbArr2.length) {
                        break;
                    }
                    zzb zzb = zzbArr2[i10];
                    if (zzb != null) {
                        i9 += zzamc.zzc(4, (zzamj) zzb);
                    }
                    i10++;
                }
                zzy = i9;
            }
            zzb[] zzbArr3 = this.zziX;
            if (zzbArr3 != null && zzbArr3.length > 0) {
                int i11 = zzy;
                int i12 = 0;
                while (true) {
                    zzb[] zzbArr4 = this.zziX;
                    if (i12 >= zzbArr4.length) {
                        break;
                    }
                    zzb zzb2 = zzbArr4[i12];
                    if (zzb2 != null) {
                        i11 += zzamc.zzc(5, (zzamj) zzb2);
                    }
                    i12++;
                }
                zzy = i11;
            }
            zzb[] zzbArr5 = this.zziY;
            if (zzbArr5 != null && zzbArr5.length > 0) {
                int i13 = zzy;
                int i14 = 0;
                while (true) {
                    zzb[] zzbArr6 = this.zziY;
                    if (i14 >= zzbArr6.length) {
                        break;
                    }
                    zzb zzb3 = zzbArr6[i14];
                    if (zzb3 != null) {
                        i13 += zzamc.zzc(6, (zzamj) zzb3);
                    }
                    i14++;
                }
                zzy = i13;
            }
            zzg[] zzgArr = this.zziZ;
            if (zzgArr != null && zzgArr.length > 0) {
                int i15 = zzy;
                int i16 = 0;
                while (true) {
                    zzg[] zzgArr2 = this.zziZ;
                    if (i16 >= zzgArr2.length) {
                        break;
                    }
                    zzg zzg = zzgArr2[i16];
                    if (zzg != null) {
                        i15 += zzamc.zzc(7, (zzamj) zzg);
                    }
                    i16++;
                }
                zzy = i15;
            }
            if (!this.zzja.equals("")) {
                zzy += zzamc.zzr(9, this.zzja);
            }
            if (!this.zzjb.equals("")) {
                zzy += zzamc.zzr(10, this.zzjb);
            }
            if (!this.zzjc.equals(PushConstants.PUSH_TYPE_NOTIFY)) {
                zzy += zzamc.zzr(12, this.zzjc);
            }
            if (!this.version.equals("")) {
                zzy += zzamc.zzr(13, this.version);
            }
            zza zza2 = this.zzjd;
            if (zza2 != null) {
                zzy += zzamc.zzc(14, (zzamj) zza2);
            }
            if (Float.floatToIntBits(this.zzje) != Float.floatToIntBits(0.0f)) {
                zzy += zzamc.zzc(15, this.zzje);
            }
            String[] strArr3 = this.zzjg;
            if (strArr3 != null && strArr3.length > 0) {
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    String[] strArr4 = this.zzjg;
                    if (i17 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i17];
                    if (str2 != null) {
                        i19++;
                        i18 += zzamc.zziZ(str2);
                    }
                    i17++;
                }
                zzy = zzy + i18 + (i19 * 2);
            }
            int i20 = this.zzjh;
            if (i20 != 0) {
                zzy += zzamc.zzG(17, i20);
            }
            boolean z = this.zzjf;
            if (z) {
                zzy += zzamc.zzk(18, z);
            }
            String[] strArr5 = this.zziS;
            if (strArr5 == null || strArr5.length <= 0) {
                return zzy;
            }
            int i21 = 0;
            int i22 = 0;
            while (true) {
                String[] strArr6 = this.zziS;
                if (i >= strArr6.length) {
                    return zzy + i21 + (i22 * 2);
                }
                String str3 = strArr6[i];
                if (str3 != null) {
                    i22++;
                    i21 += zzamc.zziZ(str3);
                }
                i++;
            }
        }
    }

    public static final class zzg extends zzamd<zzg> {
        private static volatile zzg[] zzji;
        public int[] zzjj;
        public int[] zzjk;
        public int[] zzjl;
        public int[] zzjm;
        public int[] zzjn;
        public int[] zzjo;
        public int[] zzjp;
        public int[] zzjq;
        public int[] zzjr;
        public int[] zzjs;

        public zzg() {
            zzK();
        }

        public static zzg[] zzJ() {
            if (zzji == null) {
                synchronized (zzamh.zzcai) {
                    if (zzji == null) {
                        zzji = new zzg[0];
                    }
                }
            }
            return zzji;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) obj;
            if (zzamh.equals(this.zzjj, zzg.zzjj) && zzamh.equals(this.zzjk, zzg.zzjk) && zzamh.equals(this.zzjl, zzg.zzjl) && zzamh.equals(this.zzjm, zzg.zzjm) && zzamh.equals(this.zzjn, zzg.zzjn) && zzamh.equals(this.zzjo, zzg.zzjo) && zzamh.equals(this.zzjp, zzg.zzjp) && zzamh.equals(this.zzjq, zzg.zzjq) && zzamh.equals(this.zzjr, zzg.zzjr) && zzamh.equals(this.zzjs, zzg.zzjs)) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzg.zzcaa == null || zzg.zzcaa.isEmpty() : this.zzcaa.equals(zzg.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode(this.zzjj)) * 31) + zzamh.hashCode(this.zzjk)) * 31) + zzamh.hashCode(this.zzjl)) * 31) + zzamh.hashCode(this.zzjm)) * 31) + zzamh.hashCode(this.zzjn)) * 31) + zzamh.hashCode(this.zzjo)) * 31) + zzamh.hashCode(this.zzjp)) * 31) + zzamh.hashCode(this.zzjq)) * 31) + zzamh.hashCode(this.zzjr)) * 31) + zzamh.hashCode(this.zzjs)) * 31) + ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode());
        }

        public void writeTo(zzamc zzamc) throws IOException {
            int[] iArr = this.zzjj;
            int i = 0;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.zzjj;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    zzamc.zzE(1, iArr2[i2]);
                    i2++;
                }
            }
            int[] iArr3 = this.zzjk;
            if (iArr3 != null && iArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    int[] iArr4 = this.zzjk;
                    if (i3 >= iArr4.length) {
                        break;
                    }
                    zzamc.zzE(2, iArr4[i3]);
                    i3++;
                }
            }
            int[] iArr5 = this.zzjl;
            if (iArr5 != null && iArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr6 = this.zzjl;
                    if (i4 >= iArr6.length) {
                        break;
                    }
                    zzamc.zzE(3, iArr6[i4]);
                    i4++;
                }
            }
            int[] iArr7 = this.zzjm;
            if (iArr7 != null && iArr7.length > 0) {
                int i5 = 0;
                while (true) {
                    int[] iArr8 = this.zzjm;
                    if (i5 >= iArr8.length) {
                        break;
                    }
                    zzamc.zzE(4, iArr8[i5]);
                    i5++;
                }
            }
            int[] iArr9 = this.zzjn;
            if (iArr9 != null && iArr9.length > 0) {
                int i6 = 0;
                while (true) {
                    int[] iArr10 = this.zzjn;
                    if (i6 >= iArr10.length) {
                        break;
                    }
                    zzamc.zzE(5, iArr10[i6]);
                    i6++;
                }
            }
            int[] iArr11 = this.zzjo;
            if (iArr11 != null && iArr11.length > 0) {
                int i7 = 0;
                while (true) {
                    int[] iArr12 = this.zzjo;
                    if (i7 >= iArr12.length) {
                        break;
                    }
                    zzamc.zzE(6, iArr12[i7]);
                    i7++;
                }
            }
            int[] iArr13 = this.zzjp;
            if (iArr13 != null && iArr13.length > 0) {
                int i8 = 0;
                while (true) {
                    int[] iArr14 = this.zzjp;
                    if (i8 >= iArr14.length) {
                        break;
                    }
                    zzamc.zzE(7, iArr14[i8]);
                    i8++;
                }
            }
            int[] iArr15 = this.zzjq;
            if (iArr15 != null && iArr15.length > 0) {
                int i9 = 0;
                while (true) {
                    int[] iArr16 = this.zzjq;
                    if (i9 >= iArr16.length) {
                        break;
                    }
                    zzamc.zzE(8, iArr16[i9]);
                    i9++;
                }
            }
            int[] iArr17 = this.zzjr;
            if (iArr17 != null && iArr17.length > 0) {
                int i10 = 0;
                while (true) {
                    int[] iArr18 = this.zzjr;
                    if (i10 >= iArr18.length) {
                        break;
                    }
                    zzamc.zzE(9, iArr18[i10]);
                    i10++;
                }
            }
            int[] iArr19 = this.zzjs;
            if (iArr19 != null && iArr19.length > 0) {
                while (true) {
                    int[] iArr20 = this.zzjs;
                    if (i >= iArr20.length) {
                        break;
                    }
                    zzamc.zzE(10, iArr20[i]);
                    i++;
                }
            }
            super.writeTo(zzamc);
        }

        public zzg zzK() {
            this.zzjj = zzamm.zzcal;
            this.zzjk = zzamm.zzcal;
            this.zzjl = zzamm.zzcal;
            this.zzjm = zzamm.zzcal;
            this.zzjn = zzamm.zzcal;
            this.zzjo = zzamm.zzcal;
            this.zzjp = zzamm.zzcal;
            this.zzjq = zzamm.zzcal;
            this.zzjr = zzamm.zzcal;
            this.zzjs = zzamm.zzcal;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzg */
        public zzg mergeFrom(zzamb zzamb) throws IOException {
            int i;
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        return this;
                    case 8:
                        int zzc = zzamm.zzc(zzamb, 8);
                        int[] iArr = this.zzjj;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjj, 0, iArr2, 0, length);
                        }
                        while (length < iArr2.length - 1) {
                            iArr2[length] = zzamb.zzWG();
                            zzamb.zzWC();
                            length++;
                        }
                        iArr2[length] = zzamb.zzWG();
                        this.zzjj = iArr2;
                        continue;
                    case 10:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i2 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i2++;
                        }
                        zzamb.zznY(position);
                        int[] iArr3 = this.zzjj;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[(i2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjj, 0, iArr4, 0, length2);
                        }
                        while (length2 < iArr4.length) {
                            iArr4[length2] = zzamb.zzWG();
                            length2++;
                        }
                        this.zzjj = iArr4;
                        break;
                    case 16:
                        int zzc2 = zzamm.zzc(zzamb, 16);
                        int[] iArr5 = this.zzjk;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjk, 0, iArr6, 0, length3);
                        }
                        while (length3 < iArr6.length - 1) {
                            iArr6[length3] = zzamb.zzWG();
                            zzamb.zzWC();
                            length3++;
                        }
                        iArr6[length3] = zzamb.zzWG();
                        this.zzjk = iArr6;
                        continue;
                    case 18:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position2 = zzamb.getPosition();
                        int i3 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i3++;
                        }
                        zzamb.zznY(position2);
                        int[] iArr7 = this.zzjk;
                        int length4 = iArr7 == null ? 0 : iArr7.length;
                        int[] iArr8 = new int[(i3 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzjk, 0, iArr8, 0, length4);
                        }
                        while (length4 < iArr8.length) {
                            iArr8[length4] = zzamb.zzWG();
                            length4++;
                        }
                        this.zzjk = iArr8;
                        break;
                    case 24:
                        int zzc3 = zzamm.zzc(zzamb, 24);
                        int[] iArr9 = this.zzjl;
                        int length5 = iArr9 == null ? 0 : iArr9.length;
                        int[] iArr10 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzjl, 0, iArr10, 0, length5);
                        }
                        while (length5 < iArr10.length - 1) {
                            iArr10[length5] = zzamb.zzWG();
                            zzamb.zzWC();
                            length5++;
                        }
                        iArr10[length5] = zzamb.zzWG();
                        this.zzjl = iArr10;
                        continue;
                    case 26:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position3 = zzamb.getPosition();
                        int i4 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i4++;
                        }
                        zzamb.zznY(position3);
                        int[] iArr11 = this.zzjl;
                        int length6 = iArr11 == null ? 0 : iArr11.length;
                        int[] iArr12 = new int[(i4 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjl, 0, iArr12, 0, length6);
                        }
                        while (length6 < iArr12.length) {
                            iArr12[length6] = zzamb.zzWG();
                            length6++;
                        }
                        this.zzjl = iArr12;
                        break;
                    case 32:
                        int zzc4 = zzamm.zzc(zzamb, 32);
                        int[] iArr13 = this.zzjm;
                        int length7 = iArr13 == null ? 0 : iArr13.length;
                        int[] iArr14 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzjm, 0, iArr14, 0, length7);
                        }
                        while (length7 < iArr14.length - 1) {
                            iArr14[length7] = zzamb.zzWG();
                            zzamb.zzWC();
                            length7++;
                        }
                        iArr14[length7] = zzamb.zzWG();
                        this.zzjm = iArr14;
                        continue;
                    case 34:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position4 = zzamb.getPosition();
                        int i5 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i5++;
                        }
                        zzamb.zznY(position4);
                        int[] iArr15 = this.zzjm;
                        int length8 = iArr15 == null ? 0 : iArr15.length;
                        int[] iArr16 = new int[(i5 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzjm, 0, iArr16, 0, length8);
                        }
                        while (length8 < iArr16.length) {
                            iArr16[length8] = zzamb.zzWG();
                            length8++;
                        }
                        this.zzjm = iArr16;
                        break;
                    case 40:
                        int zzc5 = zzamm.zzc(zzamb, 40);
                        int[] iArr17 = this.zzjn;
                        int length9 = iArr17 == null ? 0 : iArr17.length;
                        int[] iArr18 = new int[(zzc5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zzjn, 0, iArr18, 0, length9);
                        }
                        while (length9 < iArr18.length - 1) {
                            iArr18[length9] = zzamb.zzWG();
                            zzamb.zzWC();
                            length9++;
                        }
                        iArr18[length9] = zzamb.zzWG();
                        this.zzjn = iArr18;
                        continue;
                    case 42:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position5 = zzamb.getPosition();
                        int i6 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i6++;
                        }
                        zzamb.zznY(position5);
                        int[] iArr19 = this.zzjn;
                        int length10 = iArr19 == null ? 0 : iArr19.length;
                        int[] iArr20 = new int[(i6 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.zzjn, 0, iArr20, 0, length10);
                        }
                        while (length10 < iArr20.length) {
                            iArr20[length10] = zzamb.zzWG();
                            length10++;
                        }
                        this.zzjn = iArr20;
                        break;
                    case 48:
                        int zzc6 = zzamm.zzc(zzamb, 48);
                        int[] iArr21 = this.zzjo;
                        int length11 = iArr21 == null ? 0 : iArr21.length;
                        int[] iArr22 = new int[(zzc6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.zzjo, 0, iArr22, 0, length11);
                        }
                        while (length11 < iArr22.length - 1) {
                            iArr22[length11] = zzamb.zzWG();
                            zzamb.zzWC();
                            length11++;
                        }
                        iArr22[length11] = zzamb.zzWG();
                        this.zzjo = iArr22;
                        continue;
                    case 50:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position6 = zzamb.getPosition();
                        int i7 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i7++;
                        }
                        zzamb.zznY(position6);
                        int[] iArr23 = this.zzjo;
                        int length12 = iArr23 == null ? 0 : iArr23.length;
                        int[] iArr24 = new int[(i7 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.zzjo, 0, iArr24, 0, length12);
                        }
                        while (length12 < iArr24.length) {
                            iArr24[length12] = zzamb.zzWG();
                            length12++;
                        }
                        this.zzjo = iArr24;
                        break;
                    case ContentCommon.CMD_PTZ_PREFAB_BIT_SETD /*56*/:
                        int zzc7 = zzamm.zzc(zzamb, 56);
                        int[] iArr25 = this.zzjp;
                        int length13 = iArr25 == null ? 0 : iArr25.length;
                        int[] iArr26 = new int[(zzc7 + length13)];
                        if (length13 != 0) {
                            System.arraycopy(this.zzjp, 0, iArr26, 0, length13);
                        }
                        while (length13 < iArr26.length - 1) {
                            iArr26[length13] = zzamb.zzWG();
                            zzamb.zzWC();
                            length13++;
                        }
                        iArr26[length13] = zzamb.zzWG();
                        this.zzjp = iArr26;
                        continue;
                    case 58:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position7 = zzamb.getPosition();
                        int i8 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i8++;
                        }
                        zzamb.zznY(position7);
                        int[] iArr27 = this.zzjp;
                        int length14 = iArr27 == null ? 0 : iArr27.length;
                        int[] iArr28 = new int[(i8 + length14)];
                        if (length14 != 0) {
                            System.arraycopy(this.zzjp, 0, iArr28, 0, length14);
                        }
                        while (length14 < iArr28.length) {
                            iArr28[length14] = zzamb.zzWG();
                            length14++;
                        }
                        this.zzjp = iArr28;
                        break;
                    case 64:
                        int zzc8 = zzamm.zzc(zzamb, 64);
                        int[] iArr29 = this.zzjq;
                        int length15 = iArr29 == null ? 0 : iArr29.length;
                        int[] iArr30 = new int[(zzc8 + length15)];
                        if (length15 != 0) {
                            System.arraycopy(this.zzjq, 0, iArr30, 0, length15);
                        }
                        while (length15 < iArr30.length - 1) {
                            iArr30[length15] = zzamb.zzWG();
                            zzamb.zzWC();
                            length15++;
                        }
                        iArr30[length15] = zzamb.zzWG();
                        this.zzjq = iArr30;
                        continue;
                    case 66:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position8 = zzamb.getPosition();
                        int i9 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i9++;
                        }
                        zzamb.zznY(position8);
                        int[] iArr31 = this.zzjq;
                        int length16 = iArr31 == null ? 0 : iArr31.length;
                        int[] iArr32 = new int[(i9 + length16)];
                        if (length16 != 0) {
                            System.arraycopy(this.zzjq, 0, iArr32, 0, length16);
                        }
                        while (length16 < iArr32.length) {
                            iArr32[length16] = zzamb.zzWG();
                            length16++;
                        }
                        this.zzjq = iArr32;
                        break;
                    case 72:
                        int zzc9 = zzamm.zzc(zzamb, 72);
                        int[] iArr33 = this.zzjr;
                        int length17 = iArr33 == null ? 0 : iArr33.length;
                        int[] iArr34 = new int[(zzc9 + length17)];
                        if (length17 != 0) {
                            System.arraycopy(this.zzjr, 0, iArr34, 0, length17);
                        }
                        while (length17 < iArr34.length - 1) {
                            iArr34[length17] = zzamb.zzWG();
                            zzamb.zzWC();
                            length17++;
                        }
                        iArr34[length17] = zzamb.zzWG();
                        this.zzjr = iArr34;
                        continue;
                    case 74:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position9 = zzamb.getPosition();
                        int i10 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i10++;
                        }
                        zzamb.zznY(position9);
                        int[] iArr35 = this.zzjr;
                        int length18 = iArr35 == null ? 0 : iArr35.length;
                        int[] iArr36 = new int[(i10 + length18)];
                        if (length18 != 0) {
                            System.arraycopy(this.zzjr, 0, iArr36, 0, length18);
                        }
                        while (length18 < iArr36.length) {
                            iArr36[length18] = zzamb.zzWG();
                            length18++;
                        }
                        this.zzjr = iArr36;
                        break;
                    case MapView.LayoutParams.BOTTOM:
                        int zzc10 = zzamm.zzc(zzamb, 80);
                        int[] iArr37 = this.zzjs;
                        int length19 = iArr37 == null ? 0 : iArr37.length;
                        int[] iArr38 = new int[(zzc10 + length19)];
                        if (length19 != 0) {
                            System.arraycopy(this.zzjs, 0, iArr38, 0, length19);
                        }
                        while (length19 < iArr38.length - 1) {
                            iArr38[length19] = zzamb.zzWG();
                            zzamb.zzWC();
                            length19++;
                        }
                        iArr38[length19] = zzamb.zzWG();
                        this.zzjs = iArr38;
                        continue;
                    case 82:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position10 = zzamb.getPosition();
                        int i11 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i11++;
                        }
                        zzamb.zznY(position10);
                        int[] iArr39 = this.zzjs;
                        int length20 = iArr39 == null ? 0 : iArr39.length;
                        int[] iArr40 = new int[(i11 + length20)];
                        if (length20 != 0) {
                            System.arraycopy(this.zzjs, 0, iArr40, 0, length20);
                        }
                        while (length20 < iArr40.length) {
                            iArr40[length20] = zzamb.zzWG();
                            length20++;
                        }
                        this.zzjs = iArr40;
                        break;
                    default:
                        if (!super.zza(zzamb, zzWC)) {
                            return this;
                        }
                        continue;
                }
                zzamb.zznX(i);
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int[] iArr;
            int[] iArr2;
            int[] iArr3;
            int[] iArr4;
            int[] iArr5;
            int[] iArr6;
            int[] iArr7;
            int[] iArr8;
            int[] iArr9;
            int zzy = super.zzy();
            int[] iArr10 = this.zzjj;
            int i = 0;
            if (iArr10 != null && iArr10.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    iArr9 = this.zzjj;
                    if (i2 >= iArr9.length) {
                        break;
                    }
                    i3 += zzamc.zzoc(iArr9[i2]);
                    i2++;
                }
                zzy = zzy + i3 + (iArr9.length * 1);
            }
            int[] iArr11 = this.zzjk;
            if (iArr11 != null && iArr11.length > 0) {
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    iArr8 = this.zzjk;
                    if (i4 >= iArr8.length) {
                        break;
                    }
                    i5 += zzamc.zzoc(iArr8[i4]);
                    i4++;
                }
                zzy = zzy + i5 + (iArr8.length * 1);
            }
            int[] iArr12 = this.zzjl;
            if (iArr12 != null && iArr12.length > 0) {
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    iArr7 = this.zzjl;
                    if (i6 >= iArr7.length) {
                        break;
                    }
                    i7 += zzamc.zzoc(iArr7[i6]);
                    i6++;
                }
                zzy = zzy + i7 + (iArr7.length * 1);
            }
            int[] iArr13 = this.zzjm;
            if (iArr13 != null && iArr13.length > 0) {
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    iArr6 = this.zzjm;
                    if (i8 >= iArr6.length) {
                        break;
                    }
                    i9 += zzamc.zzoc(iArr6[i8]);
                    i8++;
                }
                zzy = zzy + i9 + (iArr6.length * 1);
            }
            int[] iArr14 = this.zzjn;
            if (iArr14 != null && iArr14.length > 0) {
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    iArr5 = this.zzjn;
                    if (i10 >= iArr5.length) {
                        break;
                    }
                    i11 += zzamc.zzoc(iArr5[i10]);
                    i10++;
                }
                zzy = zzy + i11 + (iArr5.length * 1);
            }
            int[] iArr15 = this.zzjo;
            if (iArr15 != null && iArr15.length > 0) {
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    iArr4 = this.zzjo;
                    if (i12 >= iArr4.length) {
                        break;
                    }
                    i13 += zzamc.zzoc(iArr4[i12]);
                    i12++;
                }
                zzy = zzy + i13 + (iArr4.length * 1);
            }
            int[] iArr16 = this.zzjp;
            if (iArr16 != null && iArr16.length > 0) {
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    iArr3 = this.zzjp;
                    if (i14 >= iArr3.length) {
                        break;
                    }
                    i15 += zzamc.zzoc(iArr3[i14]);
                    i14++;
                }
                zzy = zzy + i15 + (iArr3.length * 1);
            }
            int[] iArr17 = this.zzjq;
            if (iArr17 != null && iArr17.length > 0) {
                int i16 = 0;
                int i17 = 0;
                while (true) {
                    iArr2 = this.zzjq;
                    if (i16 >= iArr2.length) {
                        break;
                    }
                    i17 += zzamc.zzoc(iArr2[i16]);
                    i16++;
                }
                zzy = zzy + i17 + (iArr2.length * 1);
            }
            int[] iArr18 = this.zzjr;
            if (iArr18 != null && iArr18.length > 0) {
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    iArr = this.zzjr;
                    if (i18 >= iArr.length) {
                        break;
                    }
                    i19 += zzamc.zzoc(iArr[i18]);
                    i18++;
                }
                zzy = zzy + i19 + (iArr.length * 1);
            }
            int[] iArr19 = this.zzjs;
            if (iArr19 == null || iArr19.length <= 0) {
                return zzy;
            }
            int i20 = 0;
            while (true) {
                int[] iArr20 = this.zzjs;
                if (i >= iArr20.length) {
                    return zzy + i20 + (iArr20.length * 1);
                }
                i20 += zzamc.zzoc(iArr20[i]);
                i++;
            }
        }
    }

    public static final class zzh extends zzamd<zzh> {
        public static final zzame<zzag.zza, zzh> zzjt = zzame.zza(11, zzh.class, 810);
        private static final zzh[] zzju = new zzh[0];
        public int zzjA;
        public int zzjB;
        public int[] zzjv;
        public int[] zzjw;
        public int[] zzjx;
        public int zzjy;
        public int[] zzjz;

        public zzh() {
            zzL();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh zzh = (zzh) obj;
            if (zzamh.equals(this.zzjv, zzh.zzjv) && zzamh.equals(this.zzjw, zzh.zzjw) && zzamh.equals(this.zzjx, zzh.zzjx) && this.zzjy == zzh.zzjy && zzamh.equals(this.zzjz, zzh.zzjz) && this.zzjA == zzh.zzjA && this.zzjB == zzh.zzjB) {
                return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzh.zzcaa == null || zzh.zzcaa.isEmpty() : this.zzcaa.equals(zzh.zzcaa);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode(this.zzjv)) * 31) + zzamh.hashCode(this.zzjw)) * 31) + zzamh.hashCode(this.zzjx)) * 31) + this.zzjy) * 31) + zzamh.hashCode(this.zzjz)) * 31) + this.zzjA) * 31) + this.zzjB) * 31) + ((this.zzcaa == null || this.zzcaa.isEmpty()) ? 0 : this.zzcaa.hashCode());
        }

        public void writeTo(zzamc zzamc) throws IOException {
            int[] iArr = this.zzjv;
            int i = 0;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.zzjv;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    zzamc.zzE(1, iArr2[i2]);
                    i2++;
                }
            }
            int[] iArr3 = this.zzjw;
            if (iArr3 != null && iArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    int[] iArr4 = this.zzjw;
                    if (i3 >= iArr4.length) {
                        break;
                    }
                    zzamc.zzE(2, iArr4[i3]);
                    i3++;
                }
            }
            int[] iArr5 = this.zzjx;
            if (iArr5 != null && iArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr6 = this.zzjx;
                    if (i4 >= iArr6.length) {
                        break;
                    }
                    zzamc.zzE(3, iArr6[i4]);
                    i4++;
                }
            }
            int i5 = this.zzjy;
            if (i5 != 0) {
                zzamc.zzE(4, i5);
            }
            int[] iArr7 = this.zzjz;
            if (iArr7 != null && iArr7.length > 0) {
                while (true) {
                    int[] iArr8 = this.zzjz;
                    if (i >= iArr8.length) {
                        break;
                    }
                    zzamc.zzE(5, iArr8[i]);
                    i++;
                }
            }
            int i6 = this.zzjA;
            if (i6 != 0) {
                zzamc.zzE(6, i6);
            }
            int i7 = this.zzjB;
            if (i7 != 0) {
                zzamc.zzE(7, i7);
            }
            super.writeTo(zzamc);
        }

        public zzh zzL() {
            this.zzjv = zzamm.zzcal;
            this.zzjw = zzamm.zzcal;
            this.zzjx = zzamm.zzcal;
            this.zzjy = 0;
            this.zzjz = zzamm.zzcal;
            this.zzjA = 0;
            this.zzjB = 0;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzh */
        public zzh mergeFrom(zzamb zzamb) throws IOException {
            int i;
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        return this;
                    case 8:
                        int zzc = zzamm.zzc(zzamb, 8);
                        int[] iArr = this.zzjv;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjv, 0, iArr2, 0, length);
                        }
                        while (length < iArr2.length - 1) {
                            iArr2[length] = zzamb.zzWG();
                            zzamb.zzWC();
                            length++;
                        }
                        iArr2[length] = zzamb.zzWG();
                        this.zzjv = iArr2;
                        continue;
                    case 10:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i2 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i2++;
                        }
                        zzamb.zznY(position);
                        int[] iArr3 = this.zzjv;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[(i2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjv, 0, iArr4, 0, length2);
                        }
                        while (length2 < iArr4.length) {
                            iArr4[length2] = zzamb.zzWG();
                            length2++;
                        }
                        this.zzjv = iArr4;
                        break;
                    case 16:
                        int zzc2 = zzamm.zzc(zzamb, 16);
                        int[] iArr5 = this.zzjw;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int[] iArr6 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjw, 0, iArr6, 0, length3);
                        }
                        while (length3 < iArr6.length - 1) {
                            iArr6[length3] = zzamb.zzWG();
                            zzamb.zzWC();
                            length3++;
                        }
                        iArr6[length3] = zzamb.zzWG();
                        this.zzjw = iArr6;
                        continue;
                    case 18:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position2 = zzamb.getPosition();
                        int i3 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i3++;
                        }
                        zzamb.zznY(position2);
                        int[] iArr7 = this.zzjw;
                        int length4 = iArr7 == null ? 0 : iArr7.length;
                        int[] iArr8 = new int[(i3 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzjw, 0, iArr8, 0, length4);
                        }
                        while (length4 < iArr8.length) {
                            iArr8[length4] = zzamb.zzWG();
                            length4++;
                        }
                        this.zzjw = iArr8;
                        break;
                    case 24:
                        int zzc3 = zzamm.zzc(zzamb, 24);
                        int[] iArr9 = this.zzjx;
                        int length5 = iArr9 == null ? 0 : iArr9.length;
                        int[] iArr10 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzjx, 0, iArr10, 0, length5);
                        }
                        while (length5 < iArr10.length - 1) {
                            iArr10[length5] = zzamb.zzWG();
                            zzamb.zzWC();
                            length5++;
                        }
                        iArr10[length5] = zzamb.zzWG();
                        this.zzjx = iArr10;
                        continue;
                    case 26:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position3 = zzamb.getPosition();
                        int i4 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i4++;
                        }
                        zzamb.zznY(position3);
                        int[] iArr11 = this.zzjx;
                        int length6 = iArr11 == null ? 0 : iArr11.length;
                        int[] iArr12 = new int[(i4 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjx, 0, iArr12, 0, length6);
                        }
                        while (length6 < iArr12.length) {
                            iArr12[length6] = zzamb.zzWG();
                            length6++;
                        }
                        this.zzjx = iArr12;
                        break;
                    case 32:
                        this.zzjy = zzamb.zzWG();
                        continue;
                    case 40:
                        int zzc4 = zzamm.zzc(zzamb, 40);
                        int[] iArr13 = this.zzjz;
                        int length7 = iArr13 == null ? 0 : iArr13.length;
                        int[] iArr14 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzjz, 0, iArr14, 0, length7);
                        }
                        while (length7 < iArr14.length - 1) {
                            iArr14[length7] = zzamb.zzWG();
                            zzamb.zzWC();
                            length7++;
                        }
                        iArr14[length7] = zzamb.zzWG();
                        this.zzjz = iArr14;
                        continue;
                    case 42:
                        i = zzamb.zznW(zzamb.zzWL());
                        int position4 = zzamb.getPosition();
                        int i5 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWG();
                            i5++;
                        }
                        zzamb.zznY(position4);
                        int[] iArr15 = this.zzjz;
                        int length8 = iArr15 == null ? 0 : iArr15.length;
                        int[] iArr16 = new int[(i5 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzjz, 0, iArr16, 0, length8);
                        }
                        while (length8 < iArr16.length) {
                            iArr16[length8] = zzamb.zzWG();
                            length8++;
                        }
                        this.zzjz = iArr16;
                        break;
                    case 48:
                        this.zzjA = zzamb.zzWG();
                        continue;
                    case ContentCommon.CMD_PTZ_PREFAB_BIT_SETD /*56*/:
                        this.zzjB = zzamb.zzWG();
                        continue;
                    default:
                        if (!super.zza(zzamb, zzWC)) {
                            return this;
                        }
                        continue;
                }
                zzamb.zznX(i);
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int[] iArr;
            int[] iArr2;
            int[] iArr3;
            int[] iArr4;
            int zzy = super.zzy();
            int[] iArr5 = this.zzjv;
            int i = 0;
            if (iArr5 != null && iArr5.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    iArr4 = this.zzjv;
                    if (i2 >= iArr4.length) {
                        break;
                    }
                    i3 += zzamc.zzoc(iArr4[i2]);
                    i2++;
                }
                zzy = zzy + i3 + (iArr4.length * 1);
            }
            int[] iArr6 = this.zzjw;
            if (iArr6 != null && iArr6.length > 0) {
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    iArr3 = this.zzjw;
                    if (i4 >= iArr3.length) {
                        break;
                    }
                    i5 += zzamc.zzoc(iArr3[i4]);
                    i4++;
                }
                zzy = zzy + i5 + (iArr3.length * 1);
            }
            int[] iArr7 = this.zzjx;
            if (iArr7 != null && iArr7.length > 0) {
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    iArr2 = this.zzjx;
                    if (i6 >= iArr2.length) {
                        break;
                    }
                    i7 += zzamc.zzoc(iArr2[i6]);
                    i6++;
                }
                zzy = zzy + i7 + (iArr2.length * 1);
            }
            int i8 = this.zzjy;
            if (i8 != 0) {
                zzy += zzamc.zzG(4, i8);
            }
            int[] iArr8 = this.zzjz;
            if (iArr8 != null && iArr8.length > 0) {
                int i9 = 0;
                while (true) {
                    iArr = this.zzjz;
                    if (i >= iArr.length) {
                        break;
                    }
                    i9 += zzamc.zzoc(iArr[i]);
                    i++;
                }
                zzy = zzy + i9 + (iArr.length * 1);
            }
            int i10 = this.zzjA;
            if (i10 != 0) {
                zzy += zzamc.zzG(6, i10);
            }
            int i11 = this.zzjB;
            return i11 != 0 ? zzy + zzamc.zzG(7, i11) : zzy;
        }
    }

    public static final class zzi extends zzamd<zzi> {
        private static volatile zzi[] zzjC;
        public String name;
        public zzag.zza zzjD;
        public zzd zzjE;

        public zzi() {
            zzN();
        }

        public static zzi[] zzM() {
            if (zzjC == null) {
                synchronized (zzamh.zzcai) {
                    if (zzjC == null) {
                        zzjC = new zzi[0];
                    }
                }
            }
            return zzjC;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi zzi = (zzi) obj;
            String str = this.name;
            if (str == null) {
                if (zzi.name != null) {
                    return false;
                }
            } else if (!str.equals(zzi.name)) {
                return false;
            }
            zzag.zza zza = this.zzjD;
            if (zza == null) {
                if (zzi.zzjD != null) {
                    return false;
                }
            } else if (!zza.equals(zzi.zzjD)) {
                return false;
            }
            zzd zzd = this.zzjE;
            if (zzd == null) {
                if (zzi.zzjE != null) {
                    return false;
                }
            } else if (!zzd.equals(zzi.zzjE)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzi.zzcaa == null || zzi.zzcaa.isEmpty() : this.zzcaa.equals(zzi.zzcaa);
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            String str = this.name;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            zzag.zza zza = this.zzjD;
            int hashCode3 = (hashCode2 + (zza == null ? 0 : zza.hashCode())) * 31;
            zzd zzd = this.zzjE;
            int hashCode4 = (hashCode3 + (zzd == null ? 0 : zzd.hashCode())) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode4 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            if (!this.name.equals("")) {
                zzamc.zzq(1, this.name);
            }
            zzag.zza zza = this.zzjD;
            if (zza != null) {
                zzamc.zza(2, (zzamj) zza);
            }
            zzd zzd = this.zzjE;
            if (zzd != null) {
                zzamc.zza(3, (zzamj) zzd);
            }
            super.writeTo(zzamc);
        }

        public zzi zzN() {
            this.name = "";
            this.zzjD = null;
            this.zzjE = null;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzi */
        public zzi mergeFrom(zzamb zzamb) throws IOException {
            zzamj zzamj;
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC != 10) {
                    if (zzWC == 18) {
                        if (this.zzjD == null) {
                            this.zzjD = new zzag.zza();
                        }
                        zzamj = this.zzjD;
                    } else if (zzWC == 26) {
                        if (this.zzjE == null) {
                            this.zzjE = new zzd();
                        }
                        zzamj = this.zzjE;
                    } else if (!super.zza(zzamb, zzWC)) {
                        return this;
                    }
                    zzamb.zza(zzamj);
                } else {
                    this.name = zzamb.readString();
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (!this.name.equals("")) {
                zzy += zzamc.zzr(1, this.name);
            }
            zzag.zza zza = this.zzjD;
            if (zza != null) {
                zzy += zzamc.zzc(2, (zzamj) zza);
            }
            zzd zzd = this.zzjE;
            return zzd != null ? zzy + zzamc.zzc(3, (zzamj) zzd) : zzy;
        }
    }

    public static final class zzj extends zzamd<zzj> {
        public zzi[] zzjF;
        public zzf zzjG;
        public String zzjH;

        public zzj() {
            zzO();
        }

        public static zzj zzd(byte[] bArr) throws zzami {
            return (zzj) zzamj.mergeFrom(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj zzj = (zzj) obj;
            if (!zzamh.equals((Object[]) this.zzjF, (Object[]) zzj.zzjF)) {
                return false;
            }
            zzf zzf = this.zzjG;
            if (zzf == null) {
                if (zzj.zzjG != null) {
                    return false;
                }
            } else if (!zzf.equals(zzj.zzjG)) {
                return false;
            }
            String str = this.zzjH;
            if (str == null) {
                if (zzj.zzjH != null) {
                    return false;
                }
            } else if (!str.equals(zzj.zzjH)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zzj.zzcaa == null || zzj.zzcaa.isEmpty() : this.zzcaa.equals(zzj.zzcaa);
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zzjF)) * 31;
            zzf zzf = this.zzjG;
            int i = 0;
            int hashCode2 = (hashCode + (zzf == null ? 0 : zzf.hashCode())) * 31;
            String str = this.zzjH;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode3 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zzi[] zziArr = this.zzjF;
            if (zziArr != null && zziArr.length > 0) {
                int i = 0;
                while (true) {
                    zzi[] zziArr2 = this.zzjF;
                    if (i >= zziArr2.length) {
                        break;
                    }
                    zzi zzi = zziArr2[i];
                    if (zzi != null) {
                        zzamc.zza(1, (zzamj) zzi);
                    }
                    i++;
                }
            }
            zzf zzf = this.zzjG;
            if (zzf != null) {
                zzamc.zza(2, (zzamj) zzf);
            }
            if (!this.zzjH.equals("")) {
                zzamc.zzq(3, this.zzjH);
            }
            super.writeTo(zzamc);
        }

        public zzj zzO() {
            this.zzjF = zzi.zzM();
            this.zzjG = null;
            this.zzjH = "";
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzj */
        public zzj mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    int zzc = zzamm.zzc(zzamb, 10);
                    zzi[] zziArr = this.zzjF;
                    int length = zziArr == null ? 0 : zziArr.length;
                    zzi[] zziArr2 = new zzi[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzjF, 0, zziArr2, 0, length);
                    }
                    while (length < zziArr2.length - 1) {
                        zziArr2[length] = new zzi();
                        zzamb.zza(zziArr2[length]);
                        zzamb.zzWC();
                        length++;
                    }
                    zziArr2[length] = new zzi();
                    zzamb.zza(zziArr2[length]);
                    this.zzjF = zziArr2;
                } else if (zzWC == 18) {
                    if (this.zzjG == null) {
                        this.zzjG = new zzf();
                    }
                    zzamb.zza(this.zzjG);
                } else if (zzWC == 26) {
                    this.zzjH = zzamb.readString();
                } else if (!super.zza(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            zzi[] zziArr = this.zzjF;
            if (zziArr != null && zziArr.length > 0) {
                int i = 0;
                while (true) {
                    zzi[] zziArr2 = this.zzjF;
                    if (i >= zziArr2.length) {
                        break;
                    }
                    zzi zzi = zziArr2[i];
                    if (zzi != null) {
                        zzy += zzamc.zzc(1, (zzamj) zzi);
                    }
                    i++;
                }
            }
            zzf zzf = this.zzjG;
            if (zzf != null) {
                zzy += zzamc.zzc(2, (zzamj) zzf);
            }
            return !this.zzjH.equals("") ? zzy + zzamc.zzr(3, this.zzjH) : zzy;
        }
    }
}
