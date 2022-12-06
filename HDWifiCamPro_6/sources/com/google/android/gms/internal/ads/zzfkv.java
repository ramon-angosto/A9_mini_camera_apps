package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfkv extends zzfkr {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final zzfkt zzb;
    private final zzfks zzc;
    private final List zzd = new ArrayList();
    private zzfmp zze;
    private zzfls zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final String zzi;

    zzfkv(zzfks zzfks, zzfkt zzfkt) {
        this.zzc = zzfks;
        this.zzb = zzfkt;
        this.zzi = UUID.randomUUID().toString();
        zzk((View) null);
        if (zzfkt.zzd() == zzfku.HTML || zzfkt.zzd() == zzfku.JAVASCRIPT) {
            this.zzf = new zzflt(zzfkt.zza());
        } else {
            this.zzf = new zzflv(zzfkt.zzi(), (String) null);
        }
        this.zzf.zzj();
        zzflg.zza().zzd(this);
        zzfll.zza().zzd(this.zzf.zza(), zzfks.zzb());
    }

    private final void zzk(View view) {
        this.zze = new zzfmp(view);
    }

    public final void zzb(View view, zzfkx zzfkx, String str) {
        zzfli zzfli;
        if (this.zzh) {
            return;
        }
        if (zza.matcher("Ad overlay").matches()) {
            Iterator it = this.zzd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzfli = null;
                    break;
                }
                zzfli = (zzfli) it.next();
                if (zzfli.zzb().get() == view) {
                    break;
                }
            }
            if (zzfli == null) {
                this.zzd.add(new zzfli(view, zzfkx, "Ad overlay"));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
    }

    public final void zzc() {
        if (!this.zzh) {
            this.zze.clear();
            if (!this.zzh) {
                this.zzd.clear();
            }
            this.zzh = true;
            zzfll.zza().zzc(this.zzf.zza());
            zzflg.zza().zze(this);
            this.zzf.zzc();
            this.zzf = null;
        }
    }

    public final void zzd(View view) {
        if (!this.zzh && zzf() != view) {
            zzk(view);
            this.zzf.zzb();
            Collection<zzfkv> zzc2 = zzflg.zza().zzc();
            if (zzc2 != null && !zzc2.isEmpty()) {
                for (zzfkv zzfkv : zzc2) {
                    if (zzfkv != this && zzfkv.zzf() == view) {
                        zzfkv.zze.clear();
                    }
                }
            }
        }
    }

    public final void zze() {
        if (!this.zzg) {
            this.zzg = true;
            zzflg.zza().zzf(this);
            this.zzf.zzh(zzflm.zzb().zza());
            this.zzf.zzf(this, this.zzb);
        }
    }

    public final View zzf() {
        return (View) this.zze.get();
    }

    public final zzfls zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return this.zzd;
    }

    public final boolean zzj() {
        return this.zzg && !this.zzh;
    }
}
