package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzffr implements zzffq {
    private final ConcurrentHashMap zza;
    private final zzffx zzb;
    private final zzfft zzc = new zzfft();

    public zzffr(zzffx zzffx) {
        this.zza = new ConcurrentHashMap(zzffx.zzd);
        this.zzb = zzffx;
    }

    private final void zzf() {
        Parcelable.Creator<zzffx> creator = zzffx.CREATOR;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfv)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfga) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzffp) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int zzb2 = ((zzffp) entry.getValue()).zzb(); zzb2 < this.zzb.zzd; zzb2++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzffp) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zze.zze(sb.toString());
        }
    }

    public final zzffx zza() {
        return this.zzb;
    }

    public final synchronized zzffz zzb(zzfga zzfga) {
        zzffz zzffz;
        zzffp zzffp = (zzffp) this.zza.get(zzfga);
        if (zzffp != null) {
            zzffz = zzffp.zze();
            if (zzffz == null) {
                this.zzc.zze();
            }
            zzfgn zzf = zzffp.zzf();
            if (zzffz != null) {
                zzbfe zza2 = zzbfk.zza();
                zzbfc zza3 = zzbfd.zza();
                zza3.zzd(2);
                zzbfg zza4 = zzbfh.zza();
                zza4.zza(zzf.zza);
                zza4.zzb(zzf.zzb);
                zza3.zza(zza4);
                zza2.zza(zza3);
                zzffz.zza.zzb().zzc().zze((zzbfk) zza2.zzam());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzffz = null;
        }
        return zzffz;
    }

    @Deprecated
    public final zzfga zzc(zzl zzl, String str, zzw zzw) {
        return new zzfgb(zzl, str, new zzcbg(this.zzb.zza).zza().zzk, this.zzb.zzf, zzw);
    }

    public final synchronized boolean zzd(zzfga zzfga, zzffz zzffz) {
        boolean zzh;
        zzffp zzffp = (zzffp) this.zza.get(zzfga);
        zzffz.zzd = zzt.zzB().currentTimeMillis();
        if (zzffp == null) {
            zzffx zzffx = this.zzb;
            zzffp = new zzffp(zzffx.zzd, zzffx.zze * 1000);
            int size = this.zza.size();
            zzffx zzffx2 = this.zzb;
            if (size == zzffx2.zzc) {
                int i = zzffx2.zzg;
                int i2 = i - 1;
                zzfga zzfga2 = null;
                if (i != 0) {
                    long j = Long.MAX_VALUE;
                    if (i2 == 0) {
                        for (Map.Entry entry : this.zza.entrySet()) {
                            if (((zzffp) entry.getValue()).zzc() < j) {
                                j = ((zzffp) entry.getValue()).zzc();
                                zzfga2 = (zzfga) entry.getKey();
                            }
                        }
                        if (zzfga2 != null) {
                            this.zza.remove(zzfga2);
                        }
                    } else if (i2 == 1) {
                        for (Map.Entry entry2 : this.zza.entrySet()) {
                            if (((zzffp) entry2.getValue()).zzd() < j) {
                                j = ((zzffp) entry2.getValue()).zzd();
                                zzfga2 = (zzfga) entry2.getKey();
                            }
                        }
                        if (zzfga2 != null) {
                            this.zza.remove(zzfga2);
                        }
                    } else if (i2 == 2) {
                        int i3 = Integer.MAX_VALUE;
                        for (Map.Entry entry3 : this.zza.entrySet()) {
                            if (((zzffp) entry3.getValue()).zza() < i3) {
                                i3 = ((zzffp) entry3.getValue()).zza();
                                zzfga2 = (zzfga) entry3.getKey();
                            }
                        }
                        if (zzfga2 != null) {
                            this.zza.remove(zzfga2);
                        }
                    }
                    this.zzc.zzg();
                } else {
                    throw null;
                }
            }
            this.zza.put(zzfga, zzffp);
            this.zzc.zzd();
        }
        zzh = zzffp.zzh(zzffz);
        this.zzc.zzc();
        zzffs zza2 = this.zzc.zza();
        zzfgn zzf = zzffp.zzf();
        if (zzffz != null) {
            zzbfe zza3 = zzbfk.zza();
            zzbfc zza4 = zzbfd.zza();
            zza4.zzd(2);
            zzbfi zza5 = zzbfj.zza();
            zza5.zza(zza2.zza);
            zza5.zzb(zza2.zzb);
            zza5.zzc(zzf.zzb);
            zza4.zzc(zza5);
            zza3.zza(zza4);
            zzffz.zza.zzb().zzc().zzf((zzbfk) zza3.zzam());
        }
        zzf();
        return zzh;
    }

    public final synchronized boolean zze(zzfga zzfga) {
        zzffp zzffp = (zzffp) this.zza.get(zzfga);
        if (zzffp == null) {
            return true;
        }
        if (zzffp.zzb() < this.zzb.zzd) {
            return true;
        }
        return false;
    }
}
