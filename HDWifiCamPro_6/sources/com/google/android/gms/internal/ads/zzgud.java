package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgud extends AbstractList implements RandomAccess, zzgrw {
    /* access modifiers changed from: private */
    public final zzgrw zza;

    public zzgud(zzgrw zzgrw) {
        this.zza = zzgrw;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzgrv) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzguc(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzgub(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzgrw zze() {
        return this;
    }

    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzgpw zzgpw) {
        throw new UnsupportedOperationException();
    }
}
