package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import object.p2pipcam.content.ContentCommon;

public interface zzsp {

    public static final class zza extends zzamj {
        private static volatile zza[] zzbgR;
        public zzf zzbgS;
        public zzf zzbgT;
        public Boolean zzbgU;
        public Integer zzbgi;

        public zza() {
            zzHc();
        }

        public static zza[] zzHb() {
            if (zzbgR == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgR == null) {
                        zzbgR = new zza[0];
                    }
                }
            }
            return zzbgR;
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
            zzf zzf = this.zzbgS;
            if (zzf == null) {
                if (zza.zzbgS != null) {
                    return false;
                }
            } else if (!zzf.equals(zza.zzbgS)) {
                return false;
            }
            zzf zzf2 = this.zzbgT;
            if (zzf2 == null) {
                if (zza.zzbgT != null) {
                    return false;
                }
            } else if (!zzf2.equals(zza.zzbgT)) {
                return false;
            }
            Boolean bool = this.zzbgU;
            if (bool == null) {
                if (zza.zzbgU != null) {
                    return false;
                }
            } else if (!bool.equals(zza.zzbgU)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            Integer num = this.zzbgi;
            int i = 0;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            zzf zzf = this.zzbgS;
            int hashCode3 = (hashCode2 + (zzf == null ? 0 : zzf.hashCode())) * 31;
            zzf zzf2 = this.zzbgT;
            int hashCode4 = (hashCode3 + (zzf2 == null ? 0 : zzf2.hashCode())) * 31;
            Boolean bool = this.zzbgU;
            if (bool != null) {
                i = bool.hashCode();
            }
            return hashCode4 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            Integer num = this.zzbgi;
            if (num != null) {
                zzamc.zzE(1, num.intValue());
            }
            zzf zzf = this.zzbgS;
            if (zzf != null) {
                zzamc.zza(2, (zzamj) zzf);
            }
            zzf zzf2 = this.zzbgT;
            if (zzf2 != null) {
                zzamc.zza(3, (zzamj) zzf2);
            }
            Boolean bool = this.zzbgU;
            if (bool != null) {
                zzamc.zzj(4, bool.booleanValue());
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzC */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            zzf zzf;
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC != 8) {
                    if (zzWC == 18) {
                        if (this.zzbgS == null) {
                            this.zzbgS = new zzf();
                        }
                        zzf = this.zzbgS;
                    } else if (zzWC == 26) {
                        if (this.zzbgT == null) {
                            this.zzbgT = new zzf();
                        }
                        zzf = this.zzbgT;
                    } else if (zzWC == 32) {
                        this.zzbgU = Boolean.valueOf(zzamb.zzWI());
                    } else if (!zzamm.zzb(zzamb, zzWC)) {
                        return this;
                    }
                    zzamb.zza(zzf);
                } else {
                    this.zzbgi = Integer.valueOf(zzamb.zzWG());
                }
            }
        }

        public zza zzHc() {
            this.zzbgi = null;
            this.zzbgS = null;
            this.zzbgT = null;
            this.zzbgU = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            Integer num = this.zzbgi;
            if (num != null) {
                zzy += zzamc.zzG(1, num.intValue());
            }
            zzf zzf = this.zzbgS;
            if (zzf != null) {
                zzy += zzamc.zzc(2, (zzamj) zzf);
            }
            zzf zzf2 = this.zzbgT;
            if (zzf2 != null) {
                zzy += zzamc.zzc(3, (zzamj) zzf2);
            }
            Boolean bool = this.zzbgU;
            return bool != null ? zzy + zzamc.zzk(4, bool.booleanValue()) : zzy;
        }
    }

    public static final class zzb extends zzamj {
        private static volatile zzb[] zzbgV;
        public Integer count;
        public String name;
        public zzc[] zzbgW;
        public Long zzbgX;
        public Long zzbgY;

        public zzb() {
            zzHe();
        }

        public static zzb[] zzHd() {
            if (zzbgV == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgV == null) {
                        zzbgV = new zzb[0];
                    }
                }
            }
            return zzbgV;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (!zzamh.equals((Object[]) this.zzbgW, (Object[]) zzb.zzbgW)) {
                return false;
            }
            String str = this.name;
            if (str == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!str.equals(zzb.name)) {
                return false;
            }
            Long l = this.zzbgX;
            if (l == null) {
                if (zzb.zzbgX != null) {
                    return false;
                }
            } else if (!l.equals(zzb.zzbgX)) {
                return false;
            }
            Long l2 = this.zzbgY;
            if (l2 == null) {
                if (zzb.zzbgY != null) {
                    return false;
                }
            } else if (!l2.equals(zzb.zzbgY)) {
                return false;
            }
            Integer num = this.count;
            if (num == null) {
                if (zzb.count != null) {
                    return false;
                }
            } else if (!num.equals(zzb.count)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zzbgW)) * 31;
            String str = this.name;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.zzbgX;
            int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.zzbgY;
            int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Integer num = this.count;
            if (num != null) {
                i = num.hashCode();
            }
            return hashCode4 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zzc[] zzcArr = this.zzbgW;
            if (zzcArr != null && zzcArr.length > 0) {
                int i = 0;
                while (true) {
                    zzc[] zzcArr2 = this.zzbgW;
                    if (i >= zzcArr2.length) {
                        break;
                    }
                    zzc zzc = zzcArr2[i];
                    if (zzc != null) {
                        zzamc.zza(1, (zzamj) zzc);
                    }
                    i++;
                }
            }
            String str = this.name;
            if (str != null) {
                zzamc.zzq(2, str);
            }
            Long l = this.zzbgX;
            if (l != null) {
                zzamc.zzb(3, l.longValue());
            }
            Long l2 = this.zzbgY;
            if (l2 != null) {
                zzamc.zzb(4, l2.longValue());
            }
            Integer num = this.count;
            if (num != null) {
                zzamc.zzE(5, num.intValue());
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzD */
        public zzb mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    int zzc = zzamm.zzc(zzamb, 10);
                    zzc[] zzcArr = this.zzbgW;
                    int length = zzcArr == null ? 0 : zzcArr.length;
                    zzc[] zzcArr2 = new zzc[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbgW, 0, zzcArr2, 0, length);
                    }
                    while (length < zzcArr2.length - 1) {
                        zzcArr2[length] = new zzc();
                        zzamb.zza(zzcArr2[length]);
                        zzamb.zzWC();
                        length++;
                    }
                    zzcArr2[length] = new zzc();
                    zzamb.zza(zzcArr2[length]);
                    this.zzbgW = zzcArr2;
                } else if (zzWC == 18) {
                    this.name = zzamb.readString();
                } else if (zzWC == 24) {
                    this.zzbgX = Long.valueOf(zzamb.zzWF());
                } else if (zzWC == 32) {
                    this.zzbgY = Long.valueOf(zzamb.zzWF());
                } else if (zzWC == 40) {
                    this.count = Integer.valueOf(zzamb.zzWG());
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        public zzb zzHe() {
            this.zzbgW = zzc.zzHf();
            this.name = null;
            this.zzbgX = null;
            this.zzbgY = null;
            this.count = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            zzc[] zzcArr = this.zzbgW;
            if (zzcArr != null && zzcArr.length > 0) {
                int i = 0;
                while (true) {
                    zzc[] zzcArr2 = this.zzbgW;
                    if (i >= zzcArr2.length) {
                        break;
                    }
                    zzc zzc = zzcArr2[i];
                    if (zzc != null) {
                        zzy += zzamc.zzc(1, (zzamj) zzc);
                    }
                    i++;
                }
            }
            String str = this.name;
            if (str != null) {
                zzy += zzamc.zzr(2, str);
            }
            Long l = this.zzbgX;
            if (l != null) {
                zzy += zzamc.zze(3, l.longValue());
            }
            Long l2 = this.zzbgY;
            if (l2 != null) {
                zzy += zzamc.zze(4, l2.longValue());
            }
            Integer num = this.count;
            return num != null ? zzy + zzamc.zzG(5, num.intValue()) : zzy;
        }
    }

    public static final class zzc extends zzamj {
        private static volatile zzc[] zzbgZ;
        public String name;
        public String zzasH;
        public Float zzbge;
        public Double zzbgf;
        public Long zzbha;

        public zzc() {
            zzHg();
        }

        public static zzc[] zzHf() {
            if (zzbgZ == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbgZ == null) {
                        zzbgZ = new zzc[0];
                    }
                }
            }
            return zzbgZ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            String str = this.name;
            if (str == null) {
                if (zzc.name != null) {
                    return false;
                }
            } else if (!str.equals(zzc.name)) {
                return false;
            }
            String str2 = this.zzasH;
            if (str2 == null) {
                if (zzc.zzasH != null) {
                    return false;
                }
            } else if (!str2.equals(zzc.zzasH)) {
                return false;
            }
            Long l = this.zzbha;
            if (l == null) {
                if (zzc.zzbha != null) {
                    return false;
                }
            } else if (!l.equals(zzc.zzbha)) {
                return false;
            }
            Float f = this.zzbge;
            if (f == null) {
                if (zzc.zzbge != null) {
                    return false;
                }
            } else if (!f.equals(zzc.zzbge)) {
                return false;
            }
            Double d = this.zzbgf;
            if (d == null) {
                if (zzc.zzbgf != null) {
                    return false;
                }
            } else if (!d.equals(zzc.zzbgf)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            String str = this.name;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.zzasH;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l = this.zzbha;
            int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
            Float f = this.zzbge;
            int hashCode5 = (hashCode4 + (f == null ? 0 : f.hashCode())) * 31;
            Double d = this.zzbgf;
            if (d != null) {
                i = d.hashCode();
            }
            return hashCode5 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            String str = this.name;
            if (str != null) {
                zzamc.zzq(1, str);
            }
            String str2 = this.zzasH;
            if (str2 != null) {
                zzamc.zzq(2, str2);
            }
            Long l = this.zzbha;
            if (l != null) {
                zzamc.zzb(3, l.longValue());
            }
            Float f = this.zzbge;
            if (f != null) {
                zzamc.zzb(4, f.floatValue());
            }
            Double d = this.zzbgf;
            if (d != null) {
                zzamc.zza(5, d.doubleValue());
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzE */
        public zzc mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    this.name = zzamb.readString();
                } else if (zzWC == 18) {
                    this.zzasH = zzamb.readString();
                } else if (zzWC == 24) {
                    this.zzbha = Long.valueOf(zzamb.zzWF());
                } else if (zzWC == 37) {
                    this.zzbge = Float.valueOf(zzamb.readFloat());
                } else if (zzWC == 41) {
                    this.zzbgf = Double.valueOf(zzamb.readDouble());
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        public zzc zzHg() {
            this.name = null;
            this.zzasH = null;
            this.zzbha = null;
            this.zzbge = null;
            this.zzbgf = null;
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
            String str2 = this.zzasH;
            if (str2 != null) {
                zzy += zzamc.zzr(2, str2);
            }
            Long l = this.zzbha;
            if (l != null) {
                zzy += zzamc.zze(3, l.longValue());
            }
            Float f = this.zzbge;
            if (f != null) {
                zzy += zzamc.zzc(4, f.floatValue());
            }
            Double d = this.zzbgf;
            return d != null ? zzy + zzamc.zzb(5, d.doubleValue()) : zzy;
        }
    }

    public static final class zzd extends zzamj {
        public zze[] zzbhb;

        public zzd() {
            zzHh();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof zzd) && zzamh.equals((Object[]) this.zzbhb, (Object[]) ((zzd) obj).zzbhb);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode((Object[]) this.zzbhb);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zze[] zzeArr = this.zzbhb;
            if (zzeArr != null && zzeArr.length > 0) {
                int i = 0;
                while (true) {
                    zze[] zzeArr2 = this.zzbhb;
                    if (i >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i];
                    if (zze != null) {
                        zzamc.zza(1, (zzamj) zze);
                    }
                    i++;
                }
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzF */
        public zzd mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 10) {
                    int zzc = zzamm.zzc(zzamb, 10);
                    zze[] zzeArr = this.zzbhb;
                    int length = zzeArr == null ? 0 : zzeArr.length;
                    zze[] zzeArr2 = new zze[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbhb, 0, zzeArr2, 0, length);
                    }
                    while (length < zzeArr2.length - 1) {
                        zzeArr2[length] = new zze();
                        zzamb.zza(zzeArr2[length]);
                        zzamb.zzWC();
                        length++;
                    }
                    zzeArr2[length] = new zze();
                    zzamb.zza(zzeArr2[length]);
                    this.zzbhb = zzeArr2;
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        public zzd zzHh() {
            this.zzbhb = zze.zzHi();
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            zze[] zzeArr = this.zzbhb;
            if (zzeArr != null && zzeArr.length > 0) {
                int i = 0;
                while (true) {
                    zze[] zzeArr2 = this.zzbhb;
                    if (i >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i];
                    if (zze != null) {
                        zzy += zzamc.zzc(1, (zzamj) zze);
                    }
                    i++;
                }
            }
            return zzy;
        }
    }

    public static final class zze extends zzamj {
        private static volatile zze[] zzbhc;
        public String appId;
        public String osVersion;
        public String zzaUf;
        public String zzbbK;
        public String zzbbL;
        public String zzbbO;
        public String zzbbS;
        public Integer zzbhA;
        public String zzbhB;
        public Integer zzbhd;
        public zzb[] zzbhe;
        public zzg[] zzbhf;
        public Long zzbhg;
        public Long zzbhh;
        public Long zzbhi;
        public Long zzbhj;
        public Long zzbhk;
        public String zzbhl;
        public String zzbhm;
        public String zzbhn;
        public Integer zzbho;
        public Long zzbhp;
        public Long zzbhq;
        public String zzbhr;
        public Boolean zzbhs;
        public String zzbht;
        public Long zzbhu;
        public Integer zzbhv;
        public Boolean zzbhw;
        public zza[] zzbhx;
        public Integer zzbhy;
        public Integer zzbhz;

        public zze() {
            zzHj();
        }

        public static zze[] zzHi() {
            if (zzbhc == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbhc == null) {
                        zzbhc = new zze[0];
                    }
                }
            }
            return zzbhc;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            Integer num = this.zzbhd;
            if (num == null) {
                if (zze.zzbhd != null) {
                    return false;
                }
            } else if (!num.equals(zze.zzbhd)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzbhe, (Object[]) zze.zzbhe) || !zzamh.equals((Object[]) this.zzbhf, (Object[]) zze.zzbhf)) {
                return false;
            }
            Long l = this.zzbhg;
            if (l == null) {
                if (zze.zzbhg != null) {
                    return false;
                }
            } else if (!l.equals(zze.zzbhg)) {
                return false;
            }
            Long l2 = this.zzbhh;
            if (l2 == null) {
                if (zze.zzbhh != null) {
                    return false;
                }
            } else if (!l2.equals(zze.zzbhh)) {
                return false;
            }
            Long l3 = this.zzbhi;
            if (l3 == null) {
                if (zze.zzbhi != null) {
                    return false;
                }
            } else if (!l3.equals(zze.zzbhi)) {
                return false;
            }
            Long l4 = this.zzbhj;
            if (l4 == null) {
                if (zze.zzbhj != null) {
                    return false;
                }
            } else if (!l4.equals(zze.zzbhj)) {
                return false;
            }
            Long l5 = this.zzbhk;
            if (l5 == null) {
                if (zze.zzbhk != null) {
                    return false;
                }
            } else if (!l5.equals(zze.zzbhk)) {
                return false;
            }
            String str = this.zzbhl;
            if (str == null) {
                if (zze.zzbhl != null) {
                    return false;
                }
            } else if (!str.equals(zze.zzbhl)) {
                return false;
            }
            String str2 = this.osVersion;
            if (str2 == null) {
                if (zze.osVersion != null) {
                    return false;
                }
            } else if (!str2.equals(zze.osVersion)) {
                return false;
            }
            String str3 = this.zzbhm;
            if (str3 == null) {
                if (zze.zzbhm != null) {
                    return false;
                }
            } else if (!str3.equals(zze.zzbhm)) {
                return false;
            }
            String str4 = this.zzbhn;
            if (str4 == null) {
                if (zze.zzbhn != null) {
                    return false;
                }
            } else if (!str4.equals(zze.zzbhn)) {
                return false;
            }
            Integer num2 = this.zzbho;
            if (num2 == null) {
                if (zze.zzbho != null) {
                    return false;
                }
            } else if (!num2.equals(zze.zzbho)) {
                return false;
            }
            String str5 = this.zzbbL;
            if (str5 == null) {
                if (zze.zzbbL != null) {
                    return false;
                }
            } else if (!str5.equals(zze.zzbbL)) {
                return false;
            }
            String str6 = this.appId;
            if (str6 == null) {
                if (zze.appId != null) {
                    return false;
                }
            } else if (!str6.equals(zze.appId)) {
                return false;
            }
            String str7 = this.zzaUf;
            if (str7 == null) {
                if (zze.zzaUf != null) {
                    return false;
                }
            } else if (!str7.equals(zze.zzaUf)) {
                return false;
            }
            Long l6 = this.zzbhp;
            if (l6 == null) {
                if (zze.zzbhp != null) {
                    return false;
                }
            } else if (!l6.equals(zze.zzbhp)) {
                return false;
            }
            Long l7 = this.zzbhq;
            if (l7 == null) {
                if (zze.zzbhq != null) {
                    return false;
                }
            } else if (!l7.equals(zze.zzbhq)) {
                return false;
            }
            String str8 = this.zzbhr;
            if (str8 == null) {
                if (zze.zzbhr != null) {
                    return false;
                }
            } else if (!str8.equals(zze.zzbhr)) {
                return false;
            }
            Boolean bool = this.zzbhs;
            if (bool == null) {
                if (zze.zzbhs != null) {
                    return false;
                }
            } else if (!bool.equals(zze.zzbhs)) {
                return false;
            }
            String str9 = this.zzbht;
            if (str9 == null) {
                if (zze.zzbht != null) {
                    return false;
                }
            } else if (!str9.equals(zze.zzbht)) {
                return false;
            }
            Long l8 = this.zzbhu;
            if (l8 == null) {
                if (zze.zzbhu != null) {
                    return false;
                }
            } else if (!l8.equals(zze.zzbhu)) {
                return false;
            }
            Integer num3 = this.zzbhv;
            if (num3 == null) {
                if (zze.zzbhv != null) {
                    return false;
                }
            } else if (!num3.equals(zze.zzbhv)) {
                return false;
            }
            String str10 = this.zzbbO;
            if (str10 == null) {
                if (zze.zzbbO != null) {
                    return false;
                }
            } else if (!str10.equals(zze.zzbbO)) {
                return false;
            }
            String str11 = this.zzbbK;
            if (str11 == null) {
                if (zze.zzbbK != null) {
                    return false;
                }
            } else if (!str11.equals(zze.zzbbK)) {
                return false;
            }
            Boolean bool2 = this.zzbhw;
            if (bool2 == null) {
                if (zze.zzbhw != null) {
                    return false;
                }
            } else if (!bool2.equals(zze.zzbhw)) {
                return false;
            }
            if (!zzamh.equals((Object[]) this.zzbhx, (Object[]) zze.zzbhx)) {
                return false;
            }
            String str12 = this.zzbbS;
            if (str12 == null) {
                if (zze.zzbbS != null) {
                    return false;
                }
            } else if (!str12.equals(zze.zzbbS)) {
                return false;
            }
            Integer num4 = this.zzbhy;
            if (num4 == null) {
                if (zze.zzbhy != null) {
                    return false;
                }
            } else if (!num4.equals(zze.zzbhy)) {
                return false;
            }
            Integer num5 = this.zzbhz;
            if (num5 == null) {
                if (zze.zzbhz != null) {
                    return false;
                }
            } else if (!num5.equals(zze.zzbhz)) {
                return false;
            }
            Integer num6 = this.zzbhA;
            if (num6 == null) {
                if (zze.zzbhA != null) {
                    return false;
                }
            } else if (!num6.equals(zze.zzbhA)) {
                return false;
            }
            String str13 = this.zzbhB;
            if (str13 == null) {
                if (zze.zzbhB != null) {
                    return false;
                }
            } else if (!str13.equals(zze.zzbhB)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            Integer num = this.zzbhd;
            int i = 0;
            int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzamh.hashCode((Object[]) this.zzbhe)) * 31) + zzamh.hashCode((Object[]) this.zzbhf)) * 31;
            Long l = this.zzbhg;
            int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.zzbhh;
            int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.zzbhi;
            int hashCode5 = (hashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Long l4 = this.zzbhj;
            int hashCode6 = (hashCode5 + (l4 == null ? 0 : l4.hashCode())) * 31;
            Long l5 = this.zzbhk;
            int hashCode7 = (hashCode6 + (l5 == null ? 0 : l5.hashCode())) * 31;
            String str = this.zzbhl;
            int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.osVersion;
            int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzbhm;
            int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzbhn;
            int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num2 = this.zzbho;
            int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str5 = this.zzbbL;
            int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.appId;
            int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.zzaUf;
            int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Long l6 = this.zzbhp;
            int hashCode16 = (hashCode15 + (l6 == null ? 0 : l6.hashCode())) * 31;
            Long l7 = this.zzbhq;
            int hashCode17 = (hashCode16 + (l7 == null ? 0 : l7.hashCode())) * 31;
            String str8 = this.zzbhr;
            int hashCode18 = (hashCode17 + (str8 == null ? 0 : str8.hashCode())) * 31;
            Boolean bool = this.zzbhs;
            int hashCode19 = (hashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str9 = this.zzbht;
            int hashCode20 = (hashCode19 + (str9 == null ? 0 : str9.hashCode())) * 31;
            Long l8 = this.zzbhu;
            int hashCode21 = (hashCode20 + (l8 == null ? 0 : l8.hashCode())) * 31;
            Integer num3 = this.zzbhv;
            int hashCode22 = (hashCode21 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str10 = this.zzbbO;
            int hashCode23 = (hashCode22 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.zzbbK;
            int hashCode24 = (hashCode23 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Boolean bool2 = this.zzbhw;
            int hashCode25 = (((hashCode24 + (bool2 == null ? 0 : bool2.hashCode())) * 31) + zzamh.hashCode((Object[]) this.zzbhx)) * 31;
            String str12 = this.zzbbS;
            int hashCode26 = (hashCode25 + (str12 == null ? 0 : str12.hashCode())) * 31;
            Integer num4 = this.zzbhy;
            int hashCode27 = (hashCode26 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.zzbhz;
            int hashCode28 = (hashCode27 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.zzbhA;
            int hashCode29 = (hashCode28 + (num6 == null ? 0 : num6.hashCode())) * 31;
            String str13 = this.zzbhB;
            if (str13 != null) {
                i = str13.hashCode();
            }
            return hashCode29 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            Integer num = this.zzbhd;
            if (num != null) {
                zzamc.zzE(1, num.intValue());
            }
            zzb[] zzbArr = this.zzbhe;
            int i = 0;
            if (zzbArr != null && zzbArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zzb[] zzbArr2 = this.zzbhe;
                    if (i2 >= zzbArr2.length) {
                        break;
                    }
                    zzb zzb = zzbArr2[i2];
                    if (zzb != null) {
                        zzamc.zza(2, (zzamj) zzb);
                    }
                    i2++;
                }
            }
            zzg[] zzgArr = this.zzbhf;
            if (zzgArr != null && zzgArr.length > 0) {
                int i3 = 0;
                while (true) {
                    zzg[] zzgArr2 = this.zzbhf;
                    if (i3 >= zzgArr2.length) {
                        break;
                    }
                    zzg zzg = zzgArr2[i3];
                    if (zzg != null) {
                        zzamc.zza(3, (zzamj) zzg);
                    }
                    i3++;
                }
            }
            Long l = this.zzbhg;
            if (l != null) {
                zzamc.zzb(4, l.longValue());
            }
            Long l2 = this.zzbhh;
            if (l2 != null) {
                zzamc.zzb(5, l2.longValue());
            }
            Long l3 = this.zzbhi;
            if (l3 != null) {
                zzamc.zzb(6, l3.longValue());
            }
            Long l4 = this.zzbhk;
            if (l4 != null) {
                zzamc.zzb(7, l4.longValue());
            }
            String str = this.zzbhl;
            if (str != null) {
                zzamc.zzq(8, str);
            }
            String str2 = this.osVersion;
            if (str2 != null) {
                zzamc.zzq(9, str2);
            }
            String str3 = this.zzbhm;
            if (str3 != null) {
                zzamc.zzq(10, str3);
            }
            String str4 = this.zzbhn;
            if (str4 != null) {
                zzamc.zzq(11, str4);
            }
            Integer num2 = this.zzbho;
            if (num2 != null) {
                zzamc.zzE(12, num2.intValue());
            }
            String str5 = this.zzbbL;
            if (str5 != null) {
                zzamc.zzq(13, str5);
            }
            String str6 = this.appId;
            if (str6 != null) {
                zzamc.zzq(14, str6);
            }
            String str7 = this.zzaUf;
            if (str7 != null) {
                zzamc.zzq(16, str7);
            }
            Long l5 = this.zzbhp;
            if (l5 != null) {
                zzamc.zzb(17, l5.longValue());
            }
            Long l6 = this.zzbhq;
            if (l6 != null) {
                zzamc.zzb(18, l6.longValue());
            }
            String str8 = this.zzbhr;
            if (str8 != null) {
                zzamc.zzq(19, str8);
            }
            Boolean bool = this.zzbhs;
            if (bool != null) {
                zzamc.zzj(20, bool.booleanValue());
            }
            String str9 = this.zzbht;
            if (str9 != null) {
                zzamc.zzq(21, str9);
            }
            Long l7 = this.zzbhu;
            if (l7 != null) {
                zzamc.zzb(22, l7.longValue());
            }
            Integer num3 = this.zzbhv;
            if (num3 != null) {
                zzamc.zzE(23, num3.intValue());
            }
            String str10 = this.zzbbO;
            if (str10 != null) {
                zzamc.zzq(24, str10);
            }
            String str11 = this.zzbbK;
            if (str11 != null) {
                zzamc.zzq(25, str11);
            }
            Long l8 = this.zzbhj;
            if (l8 != null) {
                zzamc.zzb(26, l8.longValue());
            }
            Boolean bool2 = this.zzbhw;
            if (bool2 != null) {
                zzamc.zzj(28, bool2.booleanValue());
            }
            zza[] zzaArr = this.zzbhx;
            if (zzaArr != null && zzaArr.length > 0) {
                while (true) {
                    zza[] zzaArr2 = this.zzbhx;
                    if (i >= zzaArr2.length) {
                        break;
                    }
                    zza zza = zzaArr2[i];
                    if (zza != null) {
                        zzamc.zza(29, (zzamj) zza);
                    }
                    i++;
                }
            }
            String str12 = this.zzbbS;
            if (str12 != null) {
                zzamc.zzq(30, str12);
            }
            Integer num4 = this.zzbhy;
            if (num4 != null) {
                zzamc.zzE(31, num4.intValue());
            }
            Integer num5 = this.zzbhz;
            if (num5 != null) {
                zzamc.zzE(32, num5.intValue());
            }
            Integer num6 = this.zzbhA;
            if (num6 != null) {
                zzamc.zzE(33, num6.intValue());
            }
            String str13 = this.zzbhB;
            if (str13 != null) {
                zzamc.zzq(34, str13);
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzG */
        public zze mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                switch (zzWC) {
                    case 0:
                        return this;
                    case 8:
                        this.zzbhd = Integer.valueOf(zzamb.zzWG());
                        break;
                    case 18:
                        int zzc = zzamm.zzc(zzamb, 18);
                        zzb[] zzbArr = this.zzbhe;
                        int length = zzbArr == null ? 0 : zzbArr.length;
                        zzb[] zzbArr2 = new zzb[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbhe, 0, zzbArr2, 0, length);
                        }
                        while (length < zzbArr2.length - 1) {
                            zzbArr2[length] = new zzb();
                            zzamb.zza(zzbArr2[length]);
                            zzamb.zzWC();
                            length++;
                        }
                        zzbArr2[length] = new zzb();
                        zzamb.zza(zzbArr2[length]);
                        this.zzbhe = zzbArr2;
                        break;
                    case 26:
                        int zzc2 = zzamm.zzc(zzamb, 26);
                        zzg[] zzgArr = this.zzbhf;
                        int length2 = zzgArr == null ? 0 : zzgArr.length;
                        zzg[] zzgArr2 = new zzg[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbhf, 0, zzgArr2, 0, length2);
                        }
                        while (length2 < zzgArr2.length - 1) {
                            zzgArr2[length2] = new zzg();
                            zzamb.zza(zzgArr2[length2]);
                            zzamb.zzWC();
                            length2++;
                        }
                        zzgArr2[length2] = new zzg();
                        zzamb.zza(zzgArr2[length2]);
                        this.zzbhf = zzgArr2;
                        break;
                    case 32:
                        this.zzbhg = Long.valueOf(zzamb.zzWF());
                        break;
                    case 40:
                        this.zzbhh = Long.valueOf(zzamb.zzWF());
                        break;
                    case 48:
                        this.zzbhi = Long.valueOf(zzamb.zzWF());
                        break;
                    case ContentCommon.CMD_PTZ_PREFAB_BIT_SETD /*56*/:
                        this.zzbhk = Long.valueOf(zzamb.zzWF());
                        break;
                    case 66:
                        this.zzbhl = zzamb.readString();
                        break;
                    case 74:
                        this.osVersion = zzamb.readString();
                        break;
                    case 82:
                        this.zzbhm = zzamb.readString();
                        break;
                    case 90:
                        this.zzbhn = zzamb.readString();
                        break;
                    case 96:
                        this.zzbho = Integer.valueOf(zzamb.zzWG());
                        break;
                    case 106:
                        this.zzbbL = zzamb.readString();
                        break;
                    case 114:
                        this.appId = zzamb.readString();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        this.zzaUf = zzamb.readString();
                        break;
                    case 136:
                        this.zzbhp = Long.valueOf(zzamb.zzWF());
                        break;
                    case 144:
                        this.zzbhq = Long.valueOf(zzamb.zzWF());
                        break;
                    case 154:
                        this.zzbhr = zzamb.readString();
                        break;
                    case 160:
                        this.zzbhs = Boolean.valueOf(zzamb.zzWI());
                        break;
                    case 170:
                        this.zzbht = zzamb.readString();
                        break;
                    case 176:
                        this.zzbhu = Long.valueOf(zzamb.zzWF());
                        break;
                    case 184:
                        this.zzbhv = Integer.valueOf(zzamb.zzWG());
                        break;
                    case 194:
                        this.zzbbO = zzamb.readString();
                        break;
                    case 202:
                        this.zzbbK = zzamb.readString();
                        break;
                    case 208:
                        this.zzbhj = Long.valueOf(zzamb.zzWF());
                        break;
                    case 224:
                        this.zzbhw = Boolean.valueOf(zzamb.zzWI());
                        break;
                    case 234:
                        int zzc3 = zzamm.zzc(zzamb, 234);
                        zza[] zzaArr = this.zzbhx;
                        int length3 = zzaArr == null ? 0 : zzaArr.length;
                        zza[] zzaArr2 = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbhx, 0, zzaArr2, 0, length3);
                        }
                        while (length3 < zzaArr2.length - 1) {
                            zzaArr2[length3] = new zza();
                            zzamb.zza(zzaArr2[length3]);
                            zzamb.zzWC();
                            length3++;
                        }
                        zzaArr2[length3] = new zza();
                        zzamb.zza(zzaArr2[length3]);
                        this.zzbhx = zzaArr2;
                        break;
                    case 242:
                        this.zzbbS = zzamb.readString();
                        break;
                    case 248:
                        this.zzbhy = Integer.valueOf(zzamb.zzWG());
                        break;
                    case 256:
                        this.zzbhz = Integer.valueOf(zzamb.zzWG());
                        break;
                    case 264:
                        this.zzbhA = Integer.valueOf(zzamb.zzWG());
                        break;
                    case 274:
                        this.zzbhB = zzamb.readString();
                        break;
                    default:
                        if (zzamm.zzb(zzamb, zzWC)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public zze zzHj() {
            this.zzbhd = null;
            this.zzbhe = zzb.zzHd();
            this.zzbhf = zzg.zzHl();
            this.zzbhg = null;
            this.zzbhh = null;
            this.zzbhi = null;
            this.zzbhj = null;
            this.zzbhk = null;
            this.zzbhl = null;
            this.osVersion = null;
            this.zzbhm = null;
            this.zzbhn = null;
            this.zzbho = null;
            this.zzbbL = null;
            this.appId = null;
            this.zzaUf = null;
            this.zzbhp = null;
            this.zzbhq = null;
            this.zzbhr = null;
            this.zzbhs = null;
            this.zzbht = null;
            this.zzbhu = null;
            this.zzbhv = null;
            this.zzbbO = null;
            this.zzbbK = null;
            this.zzbhw = null;
            this.zzbhx = zza.zzHb();
            this.zzbbS = null;
            this.zzbhy = null;
            this.zzbhz = null;
            this.zzbhA = null;
            this.zzbhB = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            Integer num = this.zzbhd;
            if (num != null) {
                zzy += zzamc.zzG(1, num.intValue());
            }
            zzb[] zzbArr = this.zzbhe;
            int i = 0;
            if (zzbArr != null && zzbArr.length > 0) {
                int i2 = zzy;
                int i3 = 0;
                while (true) {
                    zzb[] zzbArr2 = this.zzbhe;
                    if (i3 >= zzbArr2.length) {
                        break;
                    }
                    zzb zzb = zzbArr2[i3];
                    if (zzb != null) {
                        i2 += zzamc.zzc(2, (zzamj) zzb);
                    }
                    i3++;
                }
                zzy = i2;
            }
            zzg[] zzgArr = this.zzbhf;
            if (zzgArr != null && zzgArr.length > 0) {
                int i4 = zzy;
                int i5 = 0;
                while (true) {
                    zzg[] zzgArr2 = this.zzbhf;
                    if (i5 >= zzgArr2.length) {
                        break;
                    }
                    zzg zzg = zzgArr2[i5];
                    if (zzg != null) {
                        i4 += zzamc.zzc(3, (zzamj) zzg);
                    }
                    i5++;
                }
                zzy = i4;
            }
            Long l = this.zzbhg;
            if (l != null) {
                zzy += zzamc.zze(4, l.longValue());
            }
            Long l2 = this.zzbhh;
            if (l2 != null) {
                zzy += zzamc.zze(5, l2.longValue());
            }
            Long l3 = this.zzbhi;
            if (l3 != null) {
                zzy += zzamc.zze(6, l3.longValue());
            }
            Long l4 = this.zzbhk;
            if (l4 != null) {
                zzy += zzamc.zze(7, l4.longValue());
            }
            String str = this.zzbhl;
            if (str != null) {
                zzy += zzamc.zzr(8, str);
            }
            String str2 = this.osVersion;
            if (str2 != null) {
                zzy += zzamc.zzr(9, str2);
            }
            String str3 = this.zzbhm;
            if (str3 != null) {
                zzy += zzamc.zzr(10, str3);
            }
            String str4 = this.zzbhn;
            if (str4 != null) {
                zzy += zzamc.zzr(11, str4);
            }
            Integer num2 = this.zzbho;
            if (num2 != null) {
                zzy += zzamc.zzG(12, num2.intValue());
            }
            String str5 = this.zzbbL;
            if (str5 != null) {
                zzy += zzamc.zzr(13, str5);
            }
            String str6 = this.appId;
            if (str6 != null) {
                zzy += zzamc.zzr(14, str6);
            }
            String str7 = this.zzaUf;
            if (str7 != null) {
                zzy += zzamc.zzr(16, str7);
            }
            Long l5 = this.zzbhp;
            if (l5 != null) {
                zzy += zzamc.zze(17, l5.longValue());
            }
            Long l6 = this.zzbhq;
            if (l6 != null) {
                zzy += zzamc.zze(18, l6.longValue());
            }
            String str8 = this.zzbhr;
            if (str8 != null) {
                zzy += zzamc.zzr(19, str8);
            }
            Boolean bool = this.zzbhs;
            if (bool != null) {
                zzy += zzamc.zzk(20, bool.booleanValue());
            }
            String str9 = this.zzbht;
            if (str9 != null) {
                zzy += zzamc.zzr(21, str9);
            }
            Long l7 = this.zzbhu;
            if (l7 != null) {
                zzy += zzamc.zze(22, l7.longValue());
            }
            Integer num3 = this.zzbhv;
            if (num3 != null) {
                zzy += zzamc.zzG(23, num3.intValue());
            }
            String str10 = this.zzbbO;
            if (str10 != null) {
                zzy += zzamc.zzr(24, str10);
            }
            String str11 = this.zzbbK;
            if (str11 != null) {
                zzy += zzamc.zzr(25, str11);
            }
            Long l8 = this.zzbhj;
            if (l8 != null) {
                zzy += zzamc.zze(26, l8.longValue());
            }
            Boolean bool2 = this.zzbhw;
            if (bool2 != null) {
                zzy += zzamc.zzk(28, bool2.booleanValue());
            }
            zza[] zzaArr = this.zzbhx;
            if (zzaArr != null && zzaArr.length > 0) {
                while (true) {
                    zza[] zzaArr2 = this.zzbhx;
                    if (i >= zzaArr2.length) {
                        break;
                    }
                    zza zza = zzaArr2[i];
                    if (zza != null) {
                        zzy += zzamc.zzc(29, (zzamj) zza);
                    }
                    i++;
                }
            }
            String str12 = this.zzbbS;
            if (str12 != null) {
                zzy += zzamc.zzr(30, str12);
            }
            Integer num4 = this.zzbhy;
            if (num4 != null) {
                zzy += zzamc.zzG(31, num4.intValue());
            }
            Integer num5 = this.zzbhz;
            if (num5 != null) {
                zzy += zzamc.zzG(32, num5.intValue());
            }
            Integer num6 = this.zzbhA;
            if (num6 != null) {
                zzy += zzamc.zzG(33, num6.intValue());
            }
            String str13 = this.zzbhB;
            return str13 != null ? zzy + zzamc.zzr(34, str13) : zzy;
        }
    }

    public static final class zzf extends zzamj {
        public long[] zzbhC;
        public long[] zzbhD;

        public zzf() {
            zzHk();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            return zzamh.equals(this.zzbhC, zzf.zzbhC) && zzamh.equals(this.zzbhD, zzf.zzbhD);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + zzamh.hashCode(this.zzbhC)) * 31) + zzamh.hashCode(this.zzbhD);
        }

        public void writeTo(zzamc zzamc) throws IOException {
            long[] jArr = this.zzbhC;
            int i = 0;
            if (jArr != null && jArr.length > 0) {
                int i2 = 0;
                while (true) {
                    long[] jArr2 = this.zzbhC;
                    if (i2 >= jArr2.length) {
                        break;
                    }
                    zzamc.zza(1, jArr2[i2]);
                    i2++;
                }
            }
            long[] jArr3 = this.zzbhD;
            if (jArr3 != null && jArr3.length > 0) {
                while (true) {
                    long[] jArr4 = this.zzbhD;
                    if (i >= jArr4.length) {
                        break;
                    }
                    zzamc.zza(2, jArr4[i]);
                    i++;
                }
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzH */
        public zzf mergeFrom(zzamb zzamb) throws IOException {
            int i;
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC != 8) {
                    if (zzWC == 10) {
                        i = zzamb.zznW(zzamb.zzWL());
                        int position = zzamb.getPosition();
                        int i2 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWE();
                            i2++;
                        }
                        zzamb.zznY(position);
                        long[] jArr = this.zzbhC;
                        int length = jArr == null ? 0 : jArr.length;
                        long[] jArr2 = new long[(i2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbhC, 0, jArr2, 0, length);
                        }
                        while (length < jArr2.length) {
                            jArr2[length] = zzamb.zzWE();
                            length++;
                        }
                        this.zzbhC = jArr2;
                    } else if (zzWC == 16) {
                        int zzc = zzamm.zzc(zzamb, 16);
                        long[] jArr3 = this.zzbhD;
                        int length2 = jArr3 == null ? 0 : jArr3.length;
                        long[] jArr4 = new long[(zzc + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbhD, 0, jArr4, 0, length2);
                        }
                        while (length2 < jArr4.length - 1) {
                            jArr4[length2] = zzamb.zzWE();
                            zzamb.zzWC();
                            length2++;
                        }
                        jArr4[length2] = zzamb.zzWE();
                        this.zzbhD = jArr4;
                    } else if (zzWC == 18) {
                        i = zzamb.zznW(zzamb.zzWL());
                        int position2 = zzamb.getPosition();
                        int i3 = 0;
                        while (zzamb.zzWQ() > 0) {
                            zzamb.zzWE();
                            i3++;
                        }
                        zzamb.zznY(position2);
                        long[] jArr5 = this.zzbhD;
                        int length3 = jArr5 == null ? 0 : jArr5.length;
                        long[] jArr6 = new long[(i3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbhD, 0, jArr6, 0, length3);
                        }
                        while (length3 < jArr6.length) {
                            jArr6[length3] = zzamb.zzWE();
                            length3++;
                        }
                        this.zzbhD = jArr6;
                    } else if (!zzamm.zzb(zzamb, zzWC)) {
                        return this;
                    }
                    zzamb.zznX(i);
                } else {
                    int zzc2 = zzamm.zzc(zzamb, 8);
                    long[] jArr7 = this.zzbhC;
                    int length4 = jArr7 == null ? 0 : jArr7.length;
                    long[] jArr8 = new long[(zzc2 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzbhC, 0, jArr8, 0, length4);
                    }
                    while (length4 < jArr8.length - 1) {
                        jArr8[length4] = zzamb.zzWE();
                        zzamb.zzWC();
                        length4++;
                    }
                    jArr8[length4] = zzamb.zzWE();
                    this.zzbhC = jArr8;
                }
            }
        }

        public zzf zzHk() {
            this.zzbhC = zzamm.zzcam;
            this.zzbhD = zzamm.zzcam;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            long[] jArr;
            int zzy = super.zzy();
            long[] jArr2 = this.zzbhC;
            int i = 0;
            if (jArr2 != null && jArr2.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    jArr = this.zzbhC;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    i3 += zzamc.zzaT(jArr[i2]);
                    i2++;
                }
                zzy = zzy + i3 + (jArr.length * 1);
            }
            long[] jArr3 = this.zzbhD;
            if (jArr3 == null || jArr3.length <= 0) {
                return zzy;
            }
            int i4 = 0;
            while (true) {
                long[] jArr4 = this.zzbhD;
                if (i >= jArr4.length) {
                    return zzy + i4 + (jArr4.length * 1);
                }
                i4 += zzamc.zzaT(jArr4[i]);
                i++;
            }
        }
    }

    public static final class zzg extends zzamj {
        private static volatile zzg[] zzbhE;
        public String name;
        public String zzasH;
        public Float zzbge;
        public Double zzbgf;
        public Long zzbhF;
        public Long zzbha;

        public zzg() {
            zzHm();
        }

        public static zzg[] zzHl() {
            if (zzbhE == null) {
                synchronized (zzamh.zzcai) {
                    if (zzbhE == null) {
                        zzbhE = new zzg[0];
                    }
                }
            }
            return zzbhE;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) obj;
            Long l = this.zzbhF;
            if (l == null) {
                if (zzg.zzbhF != null) {
                    return false;
                }
            } else if (!l.equals(zzg.zzbhF)) {
                return false;
            }
            String str = this.name;
            if (str == null) {
                if (zzg.name != null) {
                    return false;
                }
            } else if (!str.equals(zzg.name)) {
                return false;
            }
            String str2 = this.zzasH;
            if (str2 == null) {
                if (zzg.zzasH != null) {
                    return false;
                }
            } else if (!str2.equals(zzg.zzasH)) {
                return false;
            }
            Long l2 = this.zzbha;
            if (l2 == null) {
                if (zzg.zzbha != null) {
                    return false;
                }
            } else if (!l2.equals(zzg.zzbha)) {
                return false;
            }
            Float f = this.zzbge;
            if (f == null) {
                if (zzg.zzbge != null) {
                    return false;
                }
            } else if (!f.equals(zzg.zzbge)) {
                return false;
            }
            Double d = this.zzbgf;
            if (d == null) {
                if (zzg.zzbgf != null) {
                    return false;
                }
            } else if (!d.equals(zzg.zzbgf)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            Long l = this.zzbhF;
            int i = 0;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.name;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.zzasH;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l2 = this.zzbha;
            int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Float f = this.zzbge;
            int hashCode6 = (hashCode5 + (f == null ? 0 : f.hashCode())) * 31;
            Double d = this.zzbgf;
            if (d != null) {
                i = d.hashCode();
            }
            return hashCode6 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            Long l = this.zzbhF;
            if (l != null) {
                zzamc.zzb(1, l.longValue());
            }
            String str = this.name;
            if (str != null) {
                zzamc.zzq(2, str);
            }
            String str2 = this.zzasH;
            if (str2 != null) {
                zzamc.zzq(3, str2);
            }
            Long l2 = this.zzbha;
            if (l2 != null) {
                zzamc.zzb(4, l2.longValue());
            }
            Float f = this.zzbge;
            if (f != null) {
                zzamc.zzb(5, f.floatValue());
            }
            Double d = this.zzbgf;
            if (d != null) {
                zzamc.zza(6, d.doubleValue());
            }
            super.writeTo(zzamc);
        }

        public zzg zzHm() {
            this.zzbhF = null;
            this.name = null;
            this.zzasH = null;
            this.zzbha = null;
            this.zzbge = null;
            this.zzbgf = null;
            this.zzcaj = -1;
            return this;
        }

        /* renamed from: zzI */
        public zzg mergeFrom(zzamb zzamb) throws IOException {
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC == 8) {
                    this.zzbhF = Long.valueOf(zzamb.zzWF());
                } else if (zzWC == 18) {
                    this.name = zzamb.readString();
                } else if (zzWC == 26) {
                    this.zzasH = zzamb.readString();
                } else if (zzWC == 32) {
                    this.zzbha = Long.valueOf(zzamb.zzWF());
                } else if (zzWC == 45) {
                    this.zzbge = Float.valueOf(zzamb.readFloat());
                } else if (zzWC == 49) {
                    this.zzbgf = Double.valueOf(zzamb.readDouble());
                } else if (!zzamm.zzb(zzamb, zzWC)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            Long l = this.zzbhF;
            if (l != null) {
                zzy += zzamc.zze(1, l.longValue());
            }
            String str = this.name;
            if (str != null) {
                zzy += zzamc.zzr(2, str);
            }
            String str2 = this.zzasH;
            if (str2 != null) {
                zzy += zzamc.zzr(3, str2);
            }
            Long l2 = this.zzbha;
            if (l2 != null) {
                zzy += zzamc.zze(4, l2.longValue());
            }
            Float f = this.zzbge;
            if (f != null) {
                zzy += zzamc.zzc(5, f.floatValue());
            }
            Double d = this.zzbgf;
            return d != null ? zzy + zzamc.zzb(6, d.doubleValue()) : zzy;
        }
    }
}
