package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsn;
import java.io.IOException;

public interface zzso {

    public static final class zza extends zzamj {
        private static volatile zza[] zzbgI;
        public String name;
        public Boolean zzbgJ;
        public Boolean zzbgK;

        public zza() {
            zzGX();
        }

        public static zza[] zzGW() {
            if (zzbgI == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgI == null) {
                        zzbgI = new zza[0];
                    }
                }
            }
            return zzbgI;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            String str = this.name;
            if (str == null) {
                if (zza.name != null) {
                    return false;
                }
            } else if (!str.equals(zza.name)) {
                return false;
            }
            Boolean bool = this.zzbgJ;
            if (bool == null) {
                if (zza.zzbgJ != null) {
                    return false;
                }
            } else if (!bool.equals(zza.zzbgJ)) {
                return false;
            }
            Boolean bool2 = this.zzbgK;
            if (bool2 == null) {
                if (zza.zzbgK != null) {
                    return false;
                }
            } else if (!bool2.equals(zza.zzbgK)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            String str = this.name;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.zzbgJ;
            int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.zzbgK;
            if (bool2 != null) {
                i = bool2.hashCode();
            }
            return hashCode3 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            String str = this.name;
            if (str != null) {
                zzamc.zzq(1, str);
            }
            Boolean bool = this.zzbgJ;
            if (bool != null) {
                zzamc.zzj(2, bool.booleanValue());
            }
            Boolean bool2 = this.zzbgK;
            if (bool2 != null) {
                zzamc.zzj(3, bool2.booleanValue());
            }
            super.writeTo(zzamc);
        }

        public zza zzGX() {
            this.name = null;
            this.zzbgJ = null;
            this.zzbgK = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            String str = this.name;
            if (str != null) {
                zzy += zzamc.zzr(1, str);
            }
            Boolean bool = this.zzbgJ;
            if (bool != null) {
                zzy += zzamc.zzk(2, bool.booleanValue());
            }
            Boolean bool2 = this.zzbgK;
            return bool2 != null ? zzy + zzamc.zzk(3, bool2.booleanValue()) : zzy;
        }

        /* renamed from: zzz */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    this.name = zzamb.readString();
                } else if (zzWC == 16) {
                    this.zzbgJ = Boolean.valueOf(zzamb.zzWI());
                } else if (zzWC == 24) {
                    this.zzbgK = Boolean.valueOf(zzamb.zzWI());
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }
    }

    public static final class zzb extends zzamj {
        public String zzbbK;
        public Long zzbgL;
        public Integer zzbgM;
        public zzc[] zzbgN;
        public zza[] zzbgO;
        public zzsn.zza[] zzbgP;

        public zzb() {
            zzGY();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            Long l = this.zzbgL;
            if (l == null) {
                if (zzb.zzbgL != null) {
                    return false;
                }
            } else if (!l.equals(zzb.zzbgL)) {
                return false;
            }
            String str = this.zzbbK;
            if (str == null) {
                if (zzb.zzbbK != null) {
                    return false;
                }
            } else if (!str.equals(zzb.zzbbK)) {
                return false;
            }
            Integer num = this.zzbgM;
            if (num == null) {
                if (zzb.zzbgM != null) {
                    return false;
                }
            } else if (!num.equals(zzb.zzbgM)) {
                return false;
            }
            return zzamh.equals((Object[]) this.zzbgN, (Object[]) zzb.zzbgN) && zzamh.equals((Object[]) this.zzbgO, (Object[]) zzb.zzbgO) && zzamh.equals((Object[]) this.zzbgP, (Object[]) zzb.zzbgP);
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            Long l = this.zzbgL;
            int i = 0;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.zzbbK;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.zzbgM;
            if (num != null) {
                i = num.hashCode();
            }
            return ((((((hashCode3 + i) * 31) + zzamh.hashCode((Object[]) this.zzbgN)) * 31) + zzamh.hashCode((Object[]) this.zzbgO)) * 31) + zzamh.hashCode((Object[]) this.zzbgP);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            Long l = this.zzbgL;
            if (l != null) {
                zzamc.zzb(1, l.longValue());
            }
            String str = this.zzbbK;
            if (str != null) {
                zzamc.zzq(2, str);
            }
            Integer num = this.zzbgM;
            if (num != null) {
                zzamc.zzE(3, num.intValue());
            }
            zzc[] zzcArr = this.zzbgN;
            int i = 0;
            if (zzcArr != null && zzcArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zzc[] zzcArr2 = this.zzbgN;
                    if (i2 >= zzcArr2.length) {
                        break;
                    }
                    zzc zzc = zzcArr2[i2];
                    if (zzc != null) {
                        zzamc.zza(4, (zzamj) zzc);
                    }
                    i2++;
                }
            }
            zza[] zzaArr = this.zzbgO;
            if (zzaArr != null && zzaArr.length > 0) {
                int i3 = 0;
                while (true) {
                    zza[] zzaArr2 = this.zzbgO;
                    if (i3 >= zzaArr2.length) {
                        break;
                    }
                    zza zza = zzaArr2[i3];
                    if (zza != null) {
                        zzamc.zza(5, (zzamj) zza);
                    }
                    i3++;
                }
            }
            zzsn.zza[] zzaArr3 = this.zzbgP;
            if (zzaArr3 != null && zzaArr3.length > 0) {
                while (true) {
                    zzsn.zza[] zzaArr4 = this.zzbgP;
                    if (i >= zzaArr4.length) {
                        break;
                    }
                    zzsn.zza zza2 = zzaArr4[i];
                    if (zza2 != null) {
                        zzamc.zza(6, (zzamj) zza2);
                    }
                    i++;
                }
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzA */
        public zzb mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 8) {
                    this.zzbgL = Long.valueOf(zzamb.zzWF());
                } else if (zzWC == 18) {
                    this.zzbbK = zzamb.readString();
                } else if (zzWC == 24) {
                    this.zzbgM = Integer.valueOf(zzamb.zzWG());
                } else if (zzWC == 34) {
                    int zzc = zzamm.zzc(zzamb, 34);
                    zzc[] zzcArr = this.zzbgN;
                    int length = zzcArr == null ? 0 : zzcArr.length;
                    zzc[] zzcArr2 = new zzc[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbgN, 0, zzcArr2, 0, length);
                    }
                    while (length < zzcArr2.length - 1) {
                        zzcArr2[length] = new zzc();
                        zzamb.zza(zzcArr2[length]);
                        zzamb.zzWC();
                        length++;
                    }
                    zzcArr2[length] = new zzc();
                    zzamb.zza(zzcArr2[length]);
                    this.zzbgN = zzcArr2;
                } else if (zzWC == 42) {
                    int zzc2 = zzamm.zzc(zzamb, 42);
                    zza[] zzaArr = this.zzbgO;
                    int length2 = zzaArr == null ? 0 : zzaArr.length;
                    zza[] zzaArr2 = new zza[(zzc2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzbgO, 0, zzaArr2, 0, length2);
                    }
                    while (length2 < zzaArr2.length - 1) {
                        zzaArr2[length2] = new zza();
                        zzamb.zza(zzaArr2[length2]);
                        zzamb.zzWC();
                        length2++;
                    }
                    zzaArr2[length2] = new zza();
                    zzamb.zza(zzaArr2[length2]);
                    this.zzbgO = zzaArr2;
                } else if (zzWC == 50) {
                    int zzc3 = zzamm.zzc(zzamb, 50);
                    zzsn.zza[] zzaArr3 = this.zzbgP;
                    int length3 = zzaArr3 == null ? 0 : zzaArr3.length;
                    zzsn.zza[] zzaArr4 = new zzsn.zza[(zzc3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzbgP, 0, zzaArr4, 0, length3);
                    }
                    while (length3 < zzaArr4.length - 1) {
                        zzaArr4[length3] = new zzsn.zza();
                        zzamb.zza(zzaArr4[length3]);
                        zzamb.zzWC();
                        length3++;
                    }
                    zzaArr4[length3] = new zzsn.zza();
                    zzamb.zza(zzaArr4[length3]);
                    this.zzbgP = zzaArr4;
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        public zzb zzGY() {
            this.zzbgL = null;
            this.zzbbK = null;
            this.zzbgM = null;
            this.zzbgN = zzc.zzGZ();
            this.zzbgO = zza.zzGW();
            this.zzbgP = zzsn.zza.zzGM();
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            Long l = this.zzbgL;
            if (l != null) {
                zzy += zzamc.zze(1, l.longValue());
            }
            String str = this.zzbbK;
            if (str != null) {
                zzy += zzamc.zzr(2, str);
            }
            Integer num = this.zzbgM;
            if (num != null) {
                zzy += zzamc.zzG(3, num.intValue());
            }
            zzc[] zzcArr = this.zzbgN;
            int i = 0;
            if (zzcArr != null && zzcArr.length > 0) {
                int i2 = zzy;
                int i3 = 0;
                while (true) {
                    zzc[] zzcArr2 = this.zzbgN;
                    if (i3 >= zzcArr2.length) {
                        break;
                    }
                    zzc zzc = zzcArr2[i3];
                    if (zzc != null) {
                        i2 += zzamc.zzc(4, (zzamj) zzc);
                    }
                    i3++;
                }
                zzy = i2;
            }
            zza[] zzaArr = this.zzbgO;
            if (zzaArr != null && zzaArr.length > 0) {
                int i4 = zzy;
                int i5 = 0;
                while (true) {
                    zza[] zzaArr2 = this.zzbgO;
                    if (i5 >= zzaArr2.length) {
                        break;
                    }
                    zza zza = zzaArr2[i5];
                    if (zza != null) {
                        i4 += zzamc.zzc(5, (zzamj) zza);
                    }
                    i5++;
                }
                zzy = i4;
            }
            zzsn.zza[] zzaArr3 = this.zzbgP;
            if (zzaArr3 != null && zzaArr3.length > 0) {
                while (true) {
                    zzsn.zza[] zzaArr4 = this.zzbgP;
                    if (i >= zzaArr4.length) {
                        break;
                    }
                    zzsn.zza zza2 = zzaArr4[i];
                    if (zza2 != null) {
                        zzy += zzamc.zzc(6, (zzamj) zza2);
                    }
                    i++;
                }
            }
            return zzy;
        }
    }

    public static final class zzc extends zzamj {
        private static volatile zzc[] zzbgQ;
        public String value;
        public String zzaB;

        public zzc() {
            zzHa();
        }

        public static zzc[] zzGZ() {
            if (zzbgQ == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgQ == null) {
                        zzbgQ = new zzc[0];
                    }
                }
            }
            return zzbgQ;
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
            String str2 = this.value;
            if (str2 == null) {
                if (zzc.value != null) {
                    return false;
                }
            } else if (!str2.equals(zzc.value)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            String str = this.zzaB;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            String str = this.zzaB;
            if (str != null) {
                zzamc.zzq(1, str);
            }
            String str2 = this.value;
            if (str2 != null) {
                zzamc.zzq(2, str2);
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzB */
        public zzc mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    this.zzaB = zzamb.readString();
                } else if (zzWC == 18) {
                    this.value = zzamb.readString();
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        public zzc zzHa() {
            this.zzaB = null;
            this.value = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            String str = this.zzaB;
            if (str != null) {
                zzy += zzamc.zzr(1, str);
            }
            String str2 = this.value;
            return str2 != null ? zzy + zzamc.zzr(2, str2) : zzy;
        }
    }
}
