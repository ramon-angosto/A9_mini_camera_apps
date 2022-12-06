package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgbn {
    private final Class zza;
    private ConcurrentMap zzb = new ConcurrentHashMap();
    private zzgbo zzc;
    private zzghm zzd;

    /* synthetic */ zzgbn(Class cls, zzgbm zzgbm) {
        this.zza = cls;
        this.zzd = zzghm.zza;
    }

    private final zzgbn zze(Object obj, zzgmj zzgmj, boolean z) throws GeneralSecurityException {
        byte[] bArr;
        if (this.zzb == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        } else if (zzgmj.zzi() == 3) {
            zzgbs zzgbs = new zzgbs(zzgmj.zzc().zzf(), zzgmj.zzj(), (zzgbr) null);
            int zzj = zzgmj.zzj() - 2;
            if (zzj != 1) {
                if (zzj != 2) {
                    if (zzj == 3) {
                        bArr = zzgap.zza;
                    } else if (zzj != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgmj.zza()).array();
            } else {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgmj.zza()).array();
            }
            zzgbo zzgbo = new zzgbo(obj, bArr, zzgmj.zzi(), zzgmj.zzj(), zzgmj.zza(), zzgbs);
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzgbo);
            zzgbq zzgbq = new zzgbq(zzgbo.zzd(), (zzgbp) null);
            List list = (List) this.zzb.put(zzgbq, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzgbo);
                this.zzb.put(zzgbq, Collections.unmodifiableList(arrayList2));
            }
            if (z) {
                if (this.zzc == null) {
                    this.zzc = zzgbo;
                } else {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
            }
            return this;
        } else {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
    }

    public final zzgbn zza(Object obj, zzgmj zzgmj) throws GeneralSecurityException {
        zze(obj, zzgmj, true);
        return this;
    }

    public final zzgbn zzb(Object obj, zzgmj zzgmj) throws GeneralSecurityException {
        zze(obj, zzgmj, false);
        return this;
    }

    public final zzgbn zzc(zzghm zzghm) {
        if (this.zzb != null) {
            this.zzd = zzghm;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzgbu zzd() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.zzb;
        if (concurrentMap != null) {
            zzgbu zzgbu = new zzgbu(concurrentMap, this.zzc, this.zzd, this.zza, (zzgbt) null);
            this.zzb = null;
            return zzgbu;
        }
        throw new IllegalStateException("build cannot be called twice");
    }
}
