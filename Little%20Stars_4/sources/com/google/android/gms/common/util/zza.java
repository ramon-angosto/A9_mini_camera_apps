package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zza<E> extends AbstractSet<E> {
    private final ArrayMap<E, E> zzatZ;

    public zza() {
        this.zzatZ = new ArrayMap<>();
    }

    public zza(int i) {
        this.zzatZ = new ArrayMap<>(i);
    }

    public zza(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean add(E e) {
        if (this.zzatZ.containsKey(e)) {
            return false;
        }
        this.zzatZ.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zza ? zza((zza) collection) : super.addAll(collection);
    }

    public void clear() {
        this.zzatZ.clear();
    }

    public boolean contains(Object obj) {
        return this.zzatZ.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.zzatZ.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.zzatZ.containsKey(obj)) {
            return false;
        }
        this.zzatZ.remove(obj);
        return true;
    }

    public int size() {
        return this.zzatZ.size();
    }

    public boolean zza(zza<? extends E> zza) {
        int size = size();
        this.zzatZ.putAll(zza.zzatZ);
        return size() > size;
    }
}
