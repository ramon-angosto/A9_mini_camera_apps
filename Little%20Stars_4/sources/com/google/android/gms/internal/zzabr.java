package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.io.IOException;

public interface zzabr {

    public static final class zza extends zzamd<zza> {
        public long zzbvZ;
        public zzaf.zzj zzbwa;
        public zzaf.zzf zzjG;

        public zza() {
            zzMy();
        }

        public static zza zzD(byte[] bArr) throws zzami {
            return (zza) zzamj.mergeFrom(new zza(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.zzbvZ != zza.zzbvZ) {
                return false;
            }
            zzaf.zzf zzf = this.zzjG;
            if (zzf == null) {
                if (zza.zzjG != null) {
                    return false;
                }
            } else if (!zzf.equals(zza.zzjG)) {
                return false;
            }
            zzaf.zzj zzj = this.zzbwa;
            if (zzj == null) {
                if (zza.zzbwa != null) {
                    return false;
                }
            } else if (!zzj.equals(zza.zzbwa)) {
                return false;
            }
            return (this.zzcaa == null || this.zzcaa.isEmpty()) ? zza.zzcaa == null || zza.zzcaa.isEmpty() : this.zzcaa.equals(zza.zzcaa);
        }

        public int hashCode() {
            long j = this.zzbvZ;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            zzaf.zzf zzf = this.zzjG;
            int i = 0;
            int hashCode2 = (hashCode + (zzf == null ? 0 : zzf.hashCode())) * 31;
            zzaf.zzj zzj = this.zzbwa;
            int hashCode3 = (hashCode2 + (zzj == null ? 0 : zzj.hashCode())) * 31;
            if (this.zzcaa != null && !this.zzcaa.isEmpty()) {
                i = this.zzcaa.hashCode();
            }
            return hashCode3 + i;
        }

        public void writeTo(zzamc zzamc) throws IOException {
            zzamc.zzb(1, this.zzbvZ);
            zzaf.zzf zzf = this.zzjG;
            if (zzf != null) {
                zzamc.zza(2, (zzamj) zzf);
            }
            zzaf.zzj zzj = this.zzbwa;
            if (zzj != null) {
                zzamc.zza(3, (zzamj) zzj);
            }
            super.writeTo(zzamc);
        }

        /* renamed from: zzJ */
        public zza mergeFrom(zzamb zzamb) throws IOException {
            zzamj zzamj;
            while (true) {
                int zzWC = zzamb.zzWC();
                if (zzWC == 0) {
                    return this;
                }
                if (zzWC != 8) {
                    if (zzWC == 18) {
                        if (this.zzjG == null) {
                            this.zzjG = new zzaf.zzf();
                        }
                        zzamj = this.zzjG;
                    } else if (zzWC == 26) {
                        if (this.zzbwa == null) {
                            this.zzbwa = new zzaf.zzj();
                        }
                        zzamj = this.zzbwa;
                    } else if (!super.zza(zzamb, zzWC)) {
                        return this;
                    }
                    zzamb.zza(zzamj);
                } else {
                    this.zzbvZ = zzamb.zzWF();
                }
            }
        }

        public zza zzMy() {
            this.zzbvZ = 0;
            this.zzjG = null;
            this.zzbwa = null;
            this.zzcaa = null;
            this.zzcaj = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy() + zzamc.zze(1, this.zzbvZ);
            zzaf.zzf zzf = this.zzjG;
            if (zzf != null) {
                zzy += zzamc.zzc(2, (zzamj) zzf);
            }
            zzaf.zzj zzj = this.zzbwa;
            return zzj != null ? zzy + zzamc.zzc(3, (zzamj) zzj) : zzy;
        }
    }
}
