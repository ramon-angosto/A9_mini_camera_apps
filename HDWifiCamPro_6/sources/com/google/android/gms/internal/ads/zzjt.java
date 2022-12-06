package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzjt {
    private final zznb zza;
    private final List zzb = new ArrayList();
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final zzjs zze;
    /* access modifiers changed from: private */
    public final zzsr zzf = new zzsr();
    /* access modifiers changed from: private */
    public final zzpk zzg = new zzpk();
    private final HashMap zzh = new HashMap();
    private final Set zzi = new HashSet();
    private boolean zzj;
    private zzfz zzk;
    private zzuc zzl = new zzuc(0);

    public zzjt(zzjs zzjs, zzko zzko, Handler handler, zznb zznb) {
        this.zza = zznb;
        this.zze = zzjs;
        this.zzf.zzb(handler, zzko);
        this.zzg.zzb(handler, zzko);
    }

    private final void zzp(int i, int i2) {
        while (i < this.zzb.size()) {
            ((zzjr) this.zzb.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzq(zzjr zzjr) {
        zzjq zzjq = (zzjq) this.zzh.get(zzjr);
        if (zzjq != null) {
            zzjq.zza.zzi(zzjq.zzb);
        }
    }

    private final void zzr() {
        Iterator it = this.zzi.iterator();
        while (it.hasNext()) {
            zzjr zzjr = (zzjr) it.next();
            if (zzjr.zzc.isEmpty()) {
                zzq(zzjr);
                it.remove();
            }
        }
    }

    private final void zzs(zzjr zzjr) {
        if (zzjr.zze && zzjr.zzc.isEmpty()) {
            zzjq zzjq = (zzjq) this.zzh.remove(zzjr);
            if (zzjq != null) {
                zzjq.zza.zzp(zzjq.zzb);
                zzjq.zza.zzs(zzjq.zzc);
                zzjq.zza.zzr(zzjq.zzc);
                this.zzi.remove(zzjr);
                return;
            }
            throw null;
        }
    }

    private final void zzt(zzjr zzjr) {
        zzsd zzsd = zzjr.zza;
        zzjo zzjo = new zzjo(this);
        zzjp zzjp = new zzjp(this, zzjr);
        this.zzh.put(zzjr, new zzjq(zzsd, zzjo, zzjp));
        zzsd.zzh(new Handler(zzen.zzE(), (Handler.Callback) null), zzjp);
        zzsd.zzg(new Handler(zzen.zzE(), (Handler.Callback) null), zzjp);
        zzsd.zzm(zzjo, this.zzk, this.zza);
    }

    private final void zzu(int i, int i2) {
        while (true) {
            i2--;
            if (i2 >= i) {
                zzjr zzjr = (zzjr) this.zzb.remove(i2);
                this.zzd.remove(zzjr.zzb);
                zzp(i2, -zzjr.zza.zzA().zzc());
                zzjr.zze = true;
                if (this.zzj) {
                    zzs(zzjr);
                }
            } else {
                return;
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzcn zzb() {
        if (this.zzb.isEmpty()) {
            return zzcn.zza;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            zzjr zzjr = (zzjr) this.zzb.get(i2);
            zzjr.zzd = i;
            i += zzjr.zza.zzA().zzc();
        }
        return new zzjy(this.zzb, this.zzl, (byte[]) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzsk zzsk, zzcn zzcn) {
        this.zze.zzh();
    }

    public final void zzf(zzfz zzfz) {
        zzdd.zzf(!this.zzj);
        this.zzk = zzfz;
        for (int i = 0; i < this.zzb.size(); i++) {
            zzjr zzjr = (zzjr) this.zzb.get(i);
            zzt(zzjr);
            this.zzi.add(zzjr);
        }
        this.zzj = true;
    }

    public final void zzg() {
        for (zzjq zzjq : this.zzh.values()) {
            try {
                zzjq.zza.zzp(zzjq.zzb);
            } catch (RuntimeException e) {
                zzdw.zzc("MediaSourceList", "Failed to release child source.", e);
            }
            zzjq.zza.zzs(zzjq.zzc);
            zzjq.zza.zzr(zzjq.zzc);
        }
        this.zzh.clear();
        this.zzi.clear();
        this.zzj = false;
    }

    public final void zzh(zzsg zzsg) {
        zzjr zzjr = (zzjr) this.zzc.remove(zzsg);
        if (zzjr != null) {
            zzjr.zza.zzB(zzsg);
            zzjr.zzc.remove(((zzsa) zzsg).zza);
            if (!this.zzc.isEmpty()) {
                zzr();
            }
            zzs(zzjr);
            return;
        }
        throw null;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final zzcn zzj(int i, List list, zzuc zzuc) {
        if (!list.isEmpty()) {
            this.zzl = zzuc;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzjr zzjr = (zzjr) list.get(i2 - i);
                if (i2 > 0) {
                    zzjr zzjr2 = (zzjr) this.zzb.get(i2 - 1);
                    zzjr.zzc(zzjr2.zzd + zzjr2.zza.zzA().zzc());
                } else {
                    zzjr.zzc(0);
                }
                zzp(i2, zzjr.zza.zzA().zzc());
                this.zzb.add(i2, zzjr);
                this.zzd.put(zzjr.zzb, zzjr);
                if (this.zzj) {
                    zzt(zzjr);
                    if (this.zzc.isEmpty()) {
                        this.zzi.add(zzjr);
                    } else {
                        zzq(zzjr);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcn zzk(int i, int i2, int i3, zzuc zzuc) {
        zzdd.zzd(zza() >= 0);
        this.zzl = null;
        return zzb();
    }

    public final zzcn zzl(int i, int i2, zzuc zzuc) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zza()) {
            z = true;
        }
        zzdd.zzd(z);
        this.zzl = zzuc;
        zzu(i, i2);
        return zzb();
    }

    public final zzcn zzm(List list, zzuc zzuc) {
        zzu(0, this.zzb.size());
        return zzj(this.zzb.size(), list, zzuc);
    }

    public final zzcn zzn(zzuc zzuc) {
        int zza2 = zza();
        if (zzuc.zzc() != zza2) {
            zzuc = zzuc.zzf().zzg(0, zza2);
        }
        this.zzl = zzuc;
        return zzb();
    }

    public final zzsg zzo(zzsi zzsi, zzwi zzwi, long j) {
        Object obj = ((Pair) zzsi.zza).first;
        zzsi zzc2 = zzsi.zzc(((Pair) zzsi.zza).second);
        zzjr zzjr = (zzjr) this.zzd.get(obj);
        if (zzjr != null) {
            this.zzi.add(zzjr);
            zzjq zzjq = (zzjq) this.zzh.get(zzjr);
            if (zzjq != null) {
                zzjq.zza.zzk(zzjq.zzb);
            }
            zzjr.zzc.add(zzc2);
            zzsa zzC = zzjr.zza.zzD(zzc2, zzwi, j);
            this.zzc.put(zzC, zzjr);
            zzr();
            return zzC;
        }
        throw null;
    }
}
