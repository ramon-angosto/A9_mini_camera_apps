package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzvd extends zzct {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;
    /* access modifiers changed from: private */
    public boolean zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public final SparseArray zzg;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzh;

    @Deprecated
    public zzvd() {
        this.zzg = new SparseArray();
        this.zzh = new SparseBooleanArray();
        zzv();
    }

    private final void zzv() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
    }

    public final /* synthetic */ zzct zze(int i, int i2, boolean z) {
        super.zze(i, i2, true);
        return this;
    }

    public final zzvd zzo(int i, boolean z) {
        if (this.zzh.get(i) == z) {
            return this;
        }
        if (z) {
            this.zzh.put(i, true);
        } else {
            this.zzh.delete(i);
        }
        return this;
    }

    public zzvd(Context context) {
        super.zzd(context);
        Point zzB = zzen.zzB(context);
        zze(zzB.x, zzB.y, true);
        this.zzg = new SparseArray();
        this.zzh = new SparseBooleanArray();
        zzv();
    }

    /* synthetic */ zzvd(zzvf zzvf, zzvc zzvc) {
        super(zzvf);
        this.zza = zzvf.zzG;
        this.zzb = zzvf.zzI;
        this.zzc = zzvf.zzK;
        this.zzd = zzvf.zzP;
        this.zze = zzvf.zzQ;
        this.zzf = zzvf.zzS;
        SparseArray zza2 = zzvf.zzT;
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < zza2.size(); i++) {
            sparseArray.put(zza2.keyAt(i), new HashMap((Map) zza2.valueAt(i)));
        }
        this.zzg = sparseArray;
        this.zzh = zzvf.zzU.clone();
    }
}
