package com.google.android.gms.internal;

import java.io.IOException;

public interface zzsn {

    public static final class zza extends zzamj {
        private static volatile zza[] zzbgh;
        public Integer zzbgi;
        public zze[] zzbgj;
        public zzb[] zzbgk;

        public zza() {
            zzGN();
        }

        public static zza[] zzGM() {
            if (zzbgh == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgh == null) {
                        zzbgh = new zza[0];
                    }
                }
            }
            return zzbgh;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            Integer num = this.zzbgi;
            if (num == null) {
                if (zza.zzbgi != null) {
                    return false;
                }
            } else if (!num.equals(zza.zzbgi)) {
                return false;
            }
            return zzamh.equals((Object[]) this.zzbgj, (Object[]) zza.zzbgj) && zzamh.equals((Object[]) this.zzbgk, (Object[]) zza.zzbgk);
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            Integer num = this.zzbgi;
            return ((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzamh.hashCode((Object[]) this.zzbgj)) * 31) + zzamh.hashCode((Object[]) this.zzbgk);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            Integer num = this.zzbgi;
            if (num != null) {
                zzamc.zzE(1, num.intValue());
            }
            zze[] zzeArr = this.zzbgj;
            int i = 0;
            if (zzeArr != null && zzeArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zze[] zzeArr2 = this.zzbgj;
                    if (i2 >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i2];
                    if (zze != null) {
                        zzamc.zza(2, (zzamj) zze);
                    }
                    i2++;
                }
            }
            zzb[] zzbArr = this.zzbgk;
            if (zzbArr != null && zzbArr.length > 0) {
                while (true) {
                    zzb[] zzbArr2 = this.zzbgk;
                    if (i >= zzbArr2.length) {
                        break;
                    }
                    zzb zzb = zzbArr2[i];
                    if (zzb != null) {
                        zzamc.zza(3, (zzamj) zzb);
                    }
                    i++;
                }
            }
            super.writeTo(zzamc);
        }

        public zza zzGN() {
            this.zzbgi = null;
            this.zzbgj = zze.zzGT();
            this.zzbgk = zzb.zzGO();
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzt */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 8) {
                    this.zzbgi = Integer.valueOf(zzamb.zzWG());
                } else if (zzWC == 18) {
                    int zzc = zzamm.zzc(zzamb, 18);
                    zze[] zzeArr = this.zzbgj;
                    int length = zzeArr == null ? 0 : zzeArr.length;
                    zze[] zzeArr2 = new zze[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbgj, 0, zzeArr2, 0, length);
                    }
                    while (length < zzeArr2.length - 1) {
                        zzeArr2[length] = new zze();
                        zzamb.zza(zzeArr2[length]);
                        zzamb.zzWC();
                        length++;
                    }
                    zzeArr2[length] = new zze();
                    zzamb.zza(zzeArr2[length]);
                    this.zzbgj = zzeArr2;
                } else if (zzWC == 26) {
                    int zzc2 = zzamm.zzc(zzamb, 26);
                    zzb[] zzbArr = this.zzbgk;
                    int length2 = zzbArr == null ? 0 : zzbArr.length;
                    zzb[] zzbArr2 = new zzb[(zzc2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzbgk, 0, zzbArr2, 0, length2);
                    }
                    while (length2 < zzbArr2.length - 1) {
                        zzbArr2[length2] = new zzb();
                        zzamb.zza(zzbArr2[length2]);
                        zzamb.zzWC();
                        length2++;
                    }
                    zzbArr2[length2] = new zzb();
                    zzamb.zza(zzbArr2[length2]);
                    this.zzbgk = zzbArr2;
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            Integer num = this.zzbgi;
            if (num != null) {
                zzy += zzamc.zzG(1, num.intValue());
            }
            zze[] zzeArr = this.zzbgj;
            int i = 0;
            if (zzeArr != null && zzeArr.length > 0) {
                int i2 = zzy;
                int i3 = 0;
                while (true) {
                    zze[] zzeArr2 = this.zzbgj;
                    if (i3 >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i3];
                    if (zze != null) {
                        i2 += zzamc.zzc(2, (zzamj) zze);
                    }
                    i3++;
                }
                zzy = i2;
            }
            zzb[] zzbArr = this.zzbgk;
            if (zzbArr != null && zzbArr.length > 0) {
                while (true) {
                    zzb[] zzbArr2 = this.zzbgk;
                    if (i >= zzbArr2.length) {
                        break;
                    }
                    zzb zzb = zzbArr2[i];
                    if (zzb != null) {
                        zzy += zzamc.zzc(3, (zzamj) zzb);
                    }
                    i++;
                }
            }
            return zzy;
        }
    }

    public static final class zzb extends zzamj {
        private static volatile zzb[] zzbgl;
        public Integer zzbgm;
        public String zzbgn;
        public zzc[] zzbgo;
        public Boolean zzbgp;
        public zzd zzbgq;

        public zzb() {
            zzGP();
        }

        public static zzb[] zzGO() {
            if (zzbgl == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgl == null) {
                        zzbgl = new zzb[0];
                    }
                }
            }
            return zzbgl;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            Integer num = this.zzbgm;
            if (num == null) {
                if (zzb.zzbgm != null) {
                    return false;
                }
            } else if (!num.equals(zzb.zzbgm)) {
                return false;
            }
            String str = this.zzbgn;
            if (str == null) {
                if (zzb.zzbgn != null) {
                    return false;
                }
            } else if (!str.equals(zzb.zzbgn)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzbgo, (Object[]) zzb.zzbgo)) {
                return false;
            }
            Boolean bool = this.zzbgp;
            if (bool == null) {
                if (zzb.zzbgp != null) {
                    return false;
                }
            } else if (!bool.equals(zzb.zzbgp)) {
                return false;
            }
            zzd zzd = this.zzbgq;
            if (zzd == null) {
                if (zzb.zzbgq != null) {
                    return false;
                }
            } else if (!zzd.equals(zzb.zzbgq)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            Integer num = this.zzbgm;
            int i = 0;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.zzbgn;
            int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + zzamh.hashCode((Object[]) this.zzbgo)) * 31;
            Boolean bool = this.zzbgp;
            int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            zzd zzd = this.zzbgq;
            if (zzd != null) {
                i = zzd.hashCode();
            }
            return hashCode4 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            Integer num = this.zzbgm;
            if (num != null) {
                zzamc.zzE(1, num.intValue());
            }
            String str = this.zzbgn;
            if (str != null) {
                zzamc.zzq(2, str);
            }
            zzc[] zzcArr = this.zzbgo;
            if (zzcArr != null && zzcArr.length > 0) {
                int i = 0;
                while (true) {
                    zzc[] zzcArr2 = this.zzbgo;
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
            Boolean bool = this.zzbgp;
            if (bool != null) {
                zzamc.zzj(4, bool.booleanValue());
            }
            zzd zzd = this.zzbgq;
            if (zzd != null) {
                zzamc.zza(5, (zzamj) zzd);
            }
            super.writeTo(zzamc);
        }

        public zzb zzGP() {
            this.zzbgm = null;
            this.zzbgn = null;
            this.zzbgo = zzc.zzGQ();
            this.zzbgp = null;
            this.zzbgq = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzu */
        public zzb mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 8) {
                    this.zzbgm = Integer.valueOf(zzamb.zzWG());
                } else if (zzWC == 18) {
                    this.zzbgn = zzamb.readString();
                } else if (zzWC == 26) {
                    int zzc = zzamm.zzc(zzamb, 26);
                    zzc[] zzcArr = this.zzbgo;
                    int length = zzcArr == null ? 0 : zzcArr.length;
                    zzc[] zzcArr2 = new zzc[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbgo, 0, zzcArr2, 0, length);
                    }
                    while (length < zzcArr2.length - 1) {
                        zzcArr2[length] = new zzc();
                        zzamb.zza(zzcArr2[length]);
                        zzamb.zzWC();
                        length++;
                    }
                    zzcArr2[length] = new zzc();
                    zzamb.zza(zzcArr2[length]);
                    this.zzbgo = zzcArr2;
                } else if (zzWC == 32) {
                    this.zzbgp = Boolean.valueOf(zzamb.zzWI());
                } else if (zzWC == 42) {
                    if (this.zzbgq == null) {
                        this.zzbgq = new zzd();
                    }
                    zzamb.zza(this.zzbgq);
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            Integer num = this.zzbgm;
            if (num != null) {
                zzy += zzamc.zzG(1, num.intValue());
            }
            String str = this.zzbgn;
            if (str != null) {
                zzy += zzamc.zzr(2, str);
            }
            zzc[] zzcArr = this.zzbgo;
            if (zzcArr != null && zzcArr.length > 0) {
                int i = 0;
                while (true) {
                    zzc[] zzcArr2 = this.zzbgo;
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
            Boolean bool = this.zzbgp;
            if (bool != null) {
                zzy += zzamc.zzk(4, bool.booleanValue());
            }
            zzd zzd = this.zzbgq;
            return zzd != null ? zzy + zzamc.zzc(5, (zzamj) zzd) : zzy;
        }
    }

    public static final class zzc extends zzamj {
        private static volatile zzc[] zzbgr;
        public zzf zzbgs;
        public zzd zzbgt;
        public Boolean zzbgu;
        public String zzbgv;

        public zzc() {
            zzGR();
        }

        public static zzc[] zzGQ() {
            if (zzbgr == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgr == null) {
                        zzbgr = new zzc[0];
                    }
                }
            }
            return zzbgr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            zzf zzf = this.zzbgs;
            if (zzf == null) {
                if (zzc.zzbgs != null) {
                    return false;
                }
            } else if (!zzf.equals(zzc.zzbgs)) {
                return false;
            }
            zzd zzd = this.zzbgt;
            if (zzd == null) {
                if (zzc.zzbgt != null) {
                    return false;
                }
            } else if (!zzd.equals(zzc.zzbgt)) {
                return false;
            }
            Boolean bool = this.zzbgu;
            if (bool == null) {
                if (zzc.zzbgu != null) {
                    return false;
                }
            } else if (!bool.equals(zzc.zzbgu)) {
                return false;
            }
            String str = this.zzbgv;
            if (str == null) {
                if (zzc.zzbgv != null) {
                    return false;
                }
            } else if (!str.equals(zzc.zzbgv)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            zzf zzf = this.zzbgs;
            int i = 0;
            int hashCode2 = (hashCode + (zzf == null ? 0 : zzf.hashCode())) * 31;
            zzd zzd = this.zzbgt;
            int hashCode3 = (hashCode2 + (zzd == null ? 0 : zzd.hashCode())) * 31;
            Boolean bool = this.zzbgu;
            int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str = this.zzbgv;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode4 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zzf zzf = this.zzbgs;
            if (zzf != null) {
                zzamc.zza(1, (zzamj) zzf);
            }
            zzd zzd = this.zzbgt;
            if (zzd != null) {
                zzamc.zza(2, (zzamj) zzd);
            }
            Boolean bool = this.zzbgu;
            if (bool != null) {
                zzamc.zzj(3, bool.booleanValue());
            }
            String str = this.zzbgv;
            if (str != null) {
                zzamc.zzq(4, str);
            }
            super.writeTo(zzamc);
        }

        public zzc zzGR() {
            this.zzbgs = null;
            this.zzbgt = null;
            this.zzbgu = null;
            this.zzbgv = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzv */
        public zzc mergeFrom(zzamb zzamb) throws IOException {
            zzamj zzamj;
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    if (this.zzbgs == null) {
                        this.zzbgs = new zzf();
                    }
                    zzamj = this.zzbgs;
                } else if (zzWC == 18) {
                    if (this.zzbgt == null) {
                        this.zzbgt = new zzd();
                    }
                    zzamj = this.zzbgt;
                } else if (zzWC == 24) {
                    this.zzbgu = Boolean.valueOf(zzamb.zzWI());
                } else if (zzWC == 34) {
                    this.zzbgv = zzamb.readString();
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
                zzamb.zza(zzamj);
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            zzf zzf = this.zzbgs;
            if (zzf != null) {
                zzy += zzamc.zzc(1, (zzamj) zzf);
            }
            zzd zzd = this.zzbgt;
            if (zzd != null) {
                zzy += zzamc.zzc(2, (zzamj) zzd);
            }
            Boolean bool = this.zzbgu;
            if (bool != null) {
                zzy += zzamc.zzk(3, bool.booleanValue());
            }
            String str = this.zzbgv;
            return str != null ? zzy + zzamc.zzr(4, str) : zzy;
        }
    }

    public static final class zzd extends zzamj {
        public String zzbgA;
        public Integer zzbgw;
        public Boolean zzbgx;
        public String zzbgy;
        public String zzbgz;

        public zzd() {
            zzGS();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            Integer num = this.zzbgw;
            if (num == null) {
                if (zzd.zzbgw != null) {
                    return false;
                }
            } else if (!num.equals(zzd.zzbgw)) {
                return false;
            }
            Boolean bool = this.zzbgx;
            if (bool == null) {
                if (zzd.zzbgx != null) {
                    return false;
                }
            } else if (!bool.equals(zzd.zzbgx)) {
                return false;
            }
            String str = this.zzbgy;
            if (str == null) {
                if (zzd.zzbgy != null) {
                    return false;
                }
            } else if (!str.equals(zzd.zzbgy)) {
                return false;
            }
            String str2 = this.zzbgz;
            if (str2 == null) {
                if (zzd.zzbgz != null) {
                    return false;
                }
            } else if (!str2.equals(zzd.zzbgz)) {
                return false;
            }
            String str3 = this.zzbgA;
            if (str3 == null) {
                if (zzd.zzbgA != null) {
                    return false;
                }
            } else if (!str3.equals(zzd.zzbgA)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            Integer num = this.zzbgw;
            int i = 0;
            int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
            Boolean bool = this.zzbgx;
            int hashCode2 = (intValue + (bool == null ? 0 : bool.hashCode())) * 31;
            String str = this.zzbgy;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.zzbgz;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzbgA;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode4 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            Integer num = this.zzbgw;
            if (num != null) {
                zzamc.zzE(1, num.intValue());
            }
            Boolean bool = this.zzbgx;
            if (bool != null) {
                zzamc.zzj(2, bool.booleanValue());
            }
            String str = this.zzbgy;
            if (str != null) {
                zzamc.zzq(3, str);
            }
            String str2 = this.zzbgz;
            if (str2 != null) {
                zzamc.zzq(4, str2);
            }
            String str3 = this.zzbgA;
            if (str3 != null) {
                zzamc.zzq(5, str3);
            }
            super.writeTo(zzamc);
        }

        public zzd zzGS() {
            this.zzbgx = null;
            this.zzbgy = null;
            this.zzbgz = null;
            this.zzbgA = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzw */
        public zzd mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 8) {
                    int zzWG = zzamb.zzWG();
                    if (zzWG == 0 || zzWG == 1 || zzWG == 2 || zzWG == 3 || zzWG == 4) {
                        this.zzbgw = Integer.valueOf(zzWG);
                    }
                } else if (zzWC == 16) {
                    this.zzbgx = Boolean.valueOf(zzamb.zzWI());
                } else if (zzWC == 26) {
                    this.zzbgy = zzamb.readString();
                } else if (zzWC == 34) {
                    this.zzbgz = zzamb.readString();
                } else if (zzWC == 42) {
                    this.zzbgA = zzamb.readString();
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            Integer num = this.zzbgw;
            if (num != null) {
                zzy += zzamc.zzG(1, num.intValue());
            }
            Boolean bool = this.zzbgx;
            if (bool != null) {
                zzy += zzamc.zzk(2, bool.booleanValue());
            }
            String str = this.zzbgy;
            if (str != null) {
                zzy += zzamc.zzr(3, str);
            }
            String str2 = this.zzbgz;
            if (str2 != null) {
                zzy += zzamc.zzr(4, str2);
            }
            String str3 = this.zzbgA;
            return str3 != null ? zzy + zzamc.zzr(5, str3) : zzy;
        }
    }

    public static final class zze extends zzamj {
        private static volatile zze[] zzbgB;
        public String zzbgC;
        public zzc zzbgD;
        public Integer zzbgm;

        public zze() {
            zzGU();
        }

        public static zze[] zzGT() {
            if (zzbgB == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgB == null) {
                        zzbgB = new zze[0];
                    }
                }
            }
            return zzbgB;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            Integer num = this.zzbgm;
            if (num == null) {
                if (zze.zzbgm != null) {
                    return false;
                }
            } else if (!num.equals(zze.zzbgm)) {
                return false;
            }
            String str = this.zzbgC;
            if (str == null) {
                if (zze.zzbgC != null) {
                    return false;
                }
            } else if (!str.equals(zze.zzbgC)) {
                return false;
            }
            zzc zzc = this.zzbgD;
            if (zzc == null) {
                if (zze.zzbgD != null) {
                    return false;
                }
            } else if (!zzc.equals(zze.zzbgD)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            Integer num = this.zzbgm;
            int i = 0;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.zzbgC;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            zzc zzc = this.zzbgD;
            if (zzc != null) {
                i = zzc.hashCode();
            }
            return hashCode3 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            Integer num = this.zzbgm;
            if (num != null) {
                zzamc.zzE(1, num.intValue());
            }
            String str = this.zzbgC;
            if (str != null) {
                zzamc.zzq(2, str);
            }
            zzc zzc = this.zzbgD;
            if (zzc != null) {
                zzamc.zza(3, (zzamj) zzc);
            }
            super.writeTo(zzamc);
        }

        public zze zzGU() {
            this.zzbgm = null;
            this.zzbgC = null;
            this.zzbgD = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzx */
        public zze mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 8) {
                    this.zzbgm = Integer.valueOf(zzamb.zzWG());
                } else if (zzWC == 18) {
                    this.zzbgC = zzamb.readString();
                } else if (zzWC == 26) {
                    if (this.zzbgD == null) {
                        this.zzbgD = new zzc();
                    }
                    zzamb.zza(this.zzbgD);
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            Integer num = this.zzbgm;
            if (num != null) {
                zzy += zzamc.zzG(1, num.intValue());
            }
            String str = this.zzbgC;
            if (str != null) {
                zzy += zzamc.zzr(2, str);
            }
            zzc zzc = this.zzbgD;
            return zzc != null ? zzy + zzamc.zzc(3, (zzamj) zzc) : zzy;
        }
    }

    public static final class zzf extends zzamj {
        public Integer zzbgE;
        public String zzbgF;
        public Boolean zzbgG;
        public String[] zzbgH;

        public zzf() {
            zzGV();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            Integer num = this.zzbgE;
            if (num == null) {
                if (zzf.zzbgE != null) {
                    return false;
                }
            } else if (!num.equals(zzf.zzbgE)) {
                return false;
            }
            String str = this.zzbgF;
            if (str == null) {
                if (zzf.zzbgF != null) {
                    return false;
                }
            } else if (!str.equals(zzf.zzbgF)) {
                return false;
            }
            Boolean bool = this.zzbgG;
            if (bool == null) {
                if (zzf.zzbgG != null) {
                    return false;
                }
            } else if (!bool.equals(zzf.zzbgG)) {
                return false;
            }
            return zzamh.equals((Object[]) this.zzbgH, (Object[]) zzf.zzbgH);
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            Integer num = this.zzbgE;
            int i = 0;
            int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
            String str = this.zzbgF;
            int hashCode2 = (intValue + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.zzbgG;
            if (bool != null) {
                i = bool.hashCode();
            }
            return ((hashCode2 + i) * 31) + zzamh.hashCode((Object[]) this.zzbgH);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            Integer num = this.zzbgE;
            if (num != null) {
                zzamc.zzE(1, num.intValue());
            }
            String str = this.zzbgF;
            if (str != null) {
                zzamc.zzq(2, str);
            }
            Boolean bool = this.zzbgG;
            if (bool != null) {
                zzamc.zzj(3, bool.booleanValue());
            }
            String[] strArr = this.zzbgH;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.zzbgH;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str2 = strArr2[i];
                    if (str2 != null) {
                        zzamc.zzq(4, str2);
                    }
                    i++;
                }
            }
            super.writeTo(zzamc);
        }

        public zzf zzGV() {
            this.zzbgF = null;
            this.zzbgG = null;
            this.zzbgH = zzamm.zzcaq;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            Integer num = this.zzbgE;
            if (num != null) {
                zzy += zzamc.zzG(1, num.intValue());
            }
            String str = this.zzbgF;
            if (str != null) {
                zzy += zzamc.zzr(2, str);
            }
            Boolean bool = this.zzbgG;
            if (bool != null) {
                zzy += zzamc.zzk(3, bool.booleanValue());
            }
            String[] strArr = this.zzbgH;
            if (strArr == null || strArr.length <= 0) {
                return zzy;
            }
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.zzbgH;
                if (i >= strArr2.length) {
                    return zzy + i2 + (i3 * 1);
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    i3++;
                    i2 += zzamc.zziZ(str2);
                }
                i++;
            }
        }

        /* renamed from: zzy */
        public zzf mergeFrom(zzamb zzamb) throws IOException {
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
                                this.zzbgE = Integer.valueOf(zzWG);
                                break;
                        }
                    } else if (zzWC == 18) {
                        this.zzbgF = zzamb.readString();
                    } else if (zzWC == 24) {
                        this.zzbgG = Boolean.valueOf(zzamb.zzWI());
                    } else if (zzWC == 34) {
                        int zzc = zzamm.zzc(zzamb, 34);
                        String[] strArr = this.zzbgH;
                        int length = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbgH, 0, strArr2, 0, length);
                        }
                        while (length < strArr2.length - 1) {
                            strArr2[length] = zzamb.readString();
                            zzamb.zzWC();
                            length++;
                        }
                        strArr2[length] = zzamb.readString();
                        this.zzbgH = strArr2;
                    } else if (!zzamm.zzb(zzamb, zzWC)) {
                        return this;
                    }
                } else {
                    return this;
                }
            }
        }
    }
}
