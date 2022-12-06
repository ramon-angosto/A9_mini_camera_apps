package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzggj {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public zzggj() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzggj zza(zzgfl zzgfl) throws GeneralSecurityException {
        zzggl zzggl = new zzggl(zzgfl.zzb(), zzgfl.zza(), (zzggk) null);
        if (this.zzb.containsKey(zzggl)) {
            zzgfl zzgfl2 = (zzgfl) this.zzb.get(zzggl);
            if (!zzgfl2.equals(zzgfl) || !zzgfl.equals(zzgfl2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzggl.toString()));
            }
        } else {
            this.zzb.put(zzggl, zzgfl);
        }
        return this;
    }

    public final zzggj zzb(zzgfo zzgfo) throws GeneralSecurityException {
        zzggn zzggn = new zzggn(zzgfo.zza(), zzgfo.zzb(), (zzggm) null);
        if (this.zza.containsKey(zzggn)) {
            zzgfo zzgfo2 = (zzgfo) this.zza.get(zzggn);
            if (!zzgfo2.equals(zzgfo) || !zzgfo.equals(zzgfo2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzggn.toString()));
            }
        } else {
            this.zza.put(zzggn, zzgfo);
        }
        return this;
    }

    public final zzggj zzc(zzggb zzggb) throws GeneralSecurityException {
        zzggl zzggl = new zzggl(zzggb.zzb(), zzggb.zza(), (zzggk) null);
        if (this.zzd.containsKey(zzggl)) {
            zzggb zzggb2 = (zzggb) this.zzd.get(zzggl);
            if (!zzggb2.equals(zzggb) || !zzggb.equals(zzggb2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzggl.toString()));
            }
        } else {
            this.zzd.put(zzggl, zzggb);
        }
        return this;
    }

    public final zzggj zzd(zzgge zzgge) throws GeneralSecurityException {
        zzggn zzggn = new zzggn(zzgge.zza(), zzgge.zzb(), (zzggm) null);
        if (this.zzc.containsKey(zzggn)) {
            zzgge zzgge2 = (zzgge) this.zzc.get(zzggn);
            if (!zzgge2.equals(zzgge) || !zzgge.equals(zzgge2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzggn.toString()));
            }
        } else {
            this.zzc.put(zzggn, zzgge);
        }
        return this;
    }

    public zzggj(zzggp zzggp) {
        this.zza = new HashMap(zzggp.zza);
        this.zzb = new HashMap(zzggp.zzb);
        this.zzc = new HashMap(zzggp.zzc);
        this.zzd = new HashMap(zzggp.zzd);
    }
}
