package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzmq extends AbstractList implements RandomAccess, zzkr {
    /* access modifiers changed from: private */
    public final zzkr zza;

    public zzmq(zzkr zzkr) {
        this.zza = zzkr;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzkq) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzmp(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzmo(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzkr zze() {
        return this;
    }

    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzjb zzjb) {
        throw new UnsupportedOperationException();
    }
}
