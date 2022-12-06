package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
class zzfuh extends zzfuf implements List {
    final /* synthetic */ zzfui zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfuh(zzfui zzfui, Object obj, @CheckForNull List list, zzfuf zzfuf) {
        super(zzfui, obj, list, zzfuf);
        this.zzf = zzfui;
    }

    public final void add(int i, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        zzfui.zzd(this.zzf);
        if (isEmpty) {
            zza();
        }
    }

    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i, collection);
        if (!addAll) {
            return addAll;
        }
        zzfui.zzf(this.zzf, this.zzb.size() - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final Object get(int i) {
        zzb();
        return ((List) this.zzb).get(i);
    }

    public final int indexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        zzb();
        return new zzfug(this);
    }

    public final Object remove(int i) {
        zzb();
        Object remove = ((List) this.zzb).remove(i);
        zzfui.zze(this.zzf);
        zzc();
        return remove;
    }

    public final Object set(int i, Object obj) {
        zzb();
        return ((List) this.zzb).set(i, obj);
    }

    public final List subList(int i, int i2) {
        zzb();
        zzfui zzfui = this.zzf;
        Object obj = this.zza;
        List subList = ((List) this.zzb).subList(i, i2);
        zzfuf zzfuf = this.zzc;
        if (zzfuf == null) {
            zzfuf = this;
        }
        return zzfui.zzk(obj, subList, zzfuf);
    }

    public final ListIterator listIterator(int i) {
        zzb();
        return new zzfug(this, i);
    }
}
