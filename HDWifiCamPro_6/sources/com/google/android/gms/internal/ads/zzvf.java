package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzvf extends zzcu {
    public static final zzvf zzD = new zzvf(new zzvd());
    @Deprecated
    public static final zzvf zzE = zzD;
    public static final zzn zzF = zzvb.zza;
    public final boolean zzG;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final boolean zzS;
    /* access modifiers changed from: private */
    public final SparseArray zzT;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzU;

    private zzvf(zzvd zzvd) {
        super(zzvd);
        this.zzG = zzvd.zza;
        this.zzH = false;
        this.zzI = zzvd.zzb;
        this.zzJ = false;
        this.zzK = zzvd.zzc;
        this.zzL = false;
        this.zzM = false;
        this.zzN = false;
        this.zzO = false;
        this.zzP = zzvd.zzd;
        this.zzQ = zzvd.zze;
        this.zzR = false;
        this.zzS = zzvd.zzf;
        this.zzT = zzvd.zzg;
        this.zzU = zzvd.zzh;
    }

    public static zzvf zzd(Context context) {
        return new zzvf(new zzvd(context));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzvf zzvf = (zzvf) obj;
            if (super.equals(zzvf) && this.zzG == zzvf.zzG && this.zzI == zzvf.zzI && this.zzK == zzvf.zzK && this.zzP == zzvf.zzP && this.zzQ == zzvf.zzQ && this.zzS == zzvf.zzS) {
                SparseBooleanArray sparseBooleanArray = this.zzU;
                SparseBooleanArray sparseBooleanArray2 = zzvf.zzU;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            SparseArray sparseArray = this.zzT;
                            SparseArray sparseArray2 = zzvf.zzT;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                int i2 = 0;
                                while (i2 < size2) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i2);
                                        Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                zzuh zzuh = (zzuh) entry.getKey();
                                                if (map2.containsKey(zzuh)) {
                                                    if (!zzen.zzT(entry.getValue(), map2.get(zzuh))) {
                                                    }
                                                }
                                            }
                                            i2++;
                                        }
                                    }
                                }
                                return true;
                            }
                        } else if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((super.hashCode() + 31) * 31) + (this.zzG ? 1 : 0)) * 961) + (this.zzI ? 1 : 0)) * 961) + (this.zzK ? 1 : 0)) * 28629151) + (this.zzP ? 1 : 0)) * 31) + (this.zzQ ? 1 : 0)) * 961) + (this.zzS ? 1 : 0);
    }

    public final zzvd zzc() {
        return new zzvd(this, (zzvc) null);
    }

    @Deprecated
    public final zzvh zze(int i, zzuh zzuh) {
        Map map = (Map) this.zzT.get(i);
        if (map != null) {
            return (zzvh) map.get(zzuh);
        }
        return null;
    }

    public final boolean zzf(int i) {
        return this.zzU.get(i);
    }

    @Deprecated
    public final boolean zzg(int i, zzuh zzuh) {
        Map map = (Map) this.zzT.get(i);
        return map != null && map.containsKey(zzuh);
    }
}
