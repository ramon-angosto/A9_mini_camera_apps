package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfug extends zzfue implements ListIterator {
    final /* synthetic */ zzfuh zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfug(zzfuh zzfuh) {
        super(zzfuh);
        this.zzd = zzfuh;
    }

    public final void add(Object obj) {
        boolean isEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzfui.zzd(this.zzd.zzf);
        if (isEmpty) {
            this.zzd.zza();
        }
    }

    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfug(zzfuh zzfuh, int i) {
        super(zzfuh, ((List) zzfuh.zzb).listIterator(i));
        this.zzd = zzfuh;
    }
}
