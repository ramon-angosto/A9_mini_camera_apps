package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdt {
    private final zzde zza;
    private final zzdn zzb;
    private final zzdr zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private boolean zzg;

    public zzdt(Looper looper, zzde zzde, zzdr zzdr) {
        this(new CopyOnWriteArraySet(), looper, zzde, zzdr);
    }

    public static /* synthetic */ boolean zzg(zzdt zzdt, Message message) {
        Iterator it = zzdt.zzd.iterator();
        while (it.hasNext()) {
            ((zzds) it.next()).zzb(zzdt.zzc);
            if (zzdt.zzb.zzf(0)) {
                return true;
            }
        }
        return true;
    }

    public final zzdt zza(Looper looper, zzdr zzdr) {
        return new zzdt(this.zzd, looper, this.zza, zzdr);
    }

    public final void zzb(Object obj) {
        if (!this.zzg) {
            this.zzd.add(new zzds(obj));
        }
    }

    public final void zzc() {
        if (!this.zzf.isEmpty()) {
            if (!this.zzb.zzf(0)) {
                zzdn zzdn = this.zzb;
                zzdn.zzj(zzdn.zza(0));
            }
            boolean isEmpty = this.zze.isEmpty();
            this.zze.addAll(this.zzf);
            this.zzf.clear();
            if (!(!isEmpty)) {
                while (!this.zze.isEmpty()) {
                    ((Runnable) this.zze.peekFirst()).run();
                    this.zze.removeFirst();
                }
            }
        }
    }

    public final void zzd(int i, zzdq zzdq) {
        this.zzf.add(new zzdp(new CopyOnWriteArraySet(this.zzd), i, zzdq));
    }

    public final void zze() {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzds) it.next()).zzc(this.zzc);
        }
        this.zzd.clear();
        this.zzg = true;
    }

    public final void zzf(Object obj) {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            zzds zzds = (zzds) it.next();
            if (zzds.zza.equals(obj)) {
                zzds.zzc(this.zzc);
                this.zzd.remove(zzds);
            }
        }
    }

    private zzdt(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzde zzde, zzdr zzdr) {
        this.zza = zzde;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzdr;
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzde.zzb(looper, new zzdo(this));
    }
}
