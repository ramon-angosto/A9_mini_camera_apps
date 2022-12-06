package com.google.android.gms.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class zzald<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> zzbXf = new Comparator<Comparable>() {
        /* renamed from: zza */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    int modCount;
    int size;
    Comparator<? super K> zzbIf;
    zzd<K, V> zzbXg;
    final zzd<K, V> zzbXh;
    private zza zzbXi;
    private zzb zzbXj;

    class zza extends AbstractSet<Map.Entry<K, V>> {
        zza() {
        }

        public void clear() {
            zzald.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && zzald.this.zzc((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new zzc<Map.Entry<K, V>>() {
                {
                    zzald zzald = zzald.this;
                }

                public Map.Entry<K, V> next() {
                    return zzVV();
                }
            };
        }

        public boolean remove(Object obj) {
            zzd zzc;
            if (!(obj instanceof Map.Entry) || (zzc = zzald.this.zzc((Map.Entry) obj)) == null) {
                return false;
            }
            zzald.this.zza(zzc, true);
            return true;
        }

        public int size() {
            return zzald.this.size;
        }
    }

    final class zzb extends AbstractSet<K> {
        zzb() {
        }

        public void clear() {
            zzald.this.clear();
        }

        public boolean contains(Object obj) {
            return zzald.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new zzc<K>() {
                {
                    zzald zzald = zzald.this;
                }

                public K next() {
                    return zzVV().zzbIt;
                }
            };
        }

        public boolean remove(Object obj) {
            return zzald.this.zzaN(obj) != null;
        }

        public int size() {
            return zzald.this.size;
        }
    }

    private abstract class zzc<T> implements Iterator<T> {
        zzd<K, V> zzbXn;
        zzd<K, V> zzbXo;
        int zzbXp;

        private zzc() {
            this.zzbXn = zzald.this.zzbXh.zzbXn;
            this.zzbXo = null;
            this.zzbXp = zzald.this.modCount;
        }

        public final boolean hasNext() {
            return this.zzbXn != zzald.this.zzbXh;
        }

        public final void remove() {
            zzd<K, V> zzd = this.zzbXo;
            if (zzd != null) {
                zzald.this.zza(zzd, true);
                this.zzbXo = null;
                this.zzbXp = zzald.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }

        /* access modifiers changed from: package-private */
        public final zzd<K, V> zzVV() {
            zzd<K, V> zzd = this.zzbXn;
            if (zzd == zzald.this.zzbXh) {
                throw new NoSuchElementException();
            } else if (zzald.this.modCount == this.zzbXp) {
                this.zzbXn = zzd.zzbXn;
                this.zzbXo = zzd;
                return zzd;
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    static final class zzd<K, V> implements Map.Entry<K, V> {
        int height;
        final K zzbIt;
        V zzbIu;
        zzd<K, V> zzbXn;
        zzd<K, V> zzbXq;
        zzd<K, V> zzbXr;
        zzd<K, V> zzbXs;
        zzd<K, V> zzbXt;

        zzd() {
            this.zzbIt = null;
            this.zzbXt = this;
            this.zzbXn = this;
        }

        zzd(zzd<K, V> zzd, K k, zzd<K, V> zzd2, zzd<K, V> zzd3) {
            this.zzbXq = zzd;
            this.zzbIt = k;
            this.height = 1;
            this.zzbXn = zzd2;
            this.zzbXt = zzd3;
            zzd3.zzbXn = this;
            zzd2.zzbXt = this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.zzbIt
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.zzbIu
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzald.zzd.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.zzbIt;
        }

        public V getValue() {
            return this.zzbIu;
        }

        public int hashCode() {
            K k = this.zzbIt;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.zzbIu;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            V v2 = this.zzbIu;
            this.zzbIu = v;
            return v2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.zzbIt);
            String valueOf2 = String.valueOf(this.zzbIu);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
            sb.append(valueOf);
            sb.append("=");
            sb.append(valueOf2);
            return sb.toString();
        }

        public zzd<K, V> zzVW() {
            zzd<K, V> zzd = this;
            for (zzd<K, V> zzd2 = this.zzbXr; zzd2 != null; zzd2 = zzd2.zzbXr) {
                zzd = zzd2;
            }
            return zzd;
        }

        public zzd<K, V> zzVX() {
            zzd<K, V> zzd = this;
            for (zzd<K, V> zzd2 = this.zzbXs; zzd2 != null; zzd2 = zzd2.zzbXs) {
                zzd = zzd2;
            }
            return zzd;
        }
    }

    public zzald() {
        this(zzbXf);
    }

    public zzald(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.zzbXh = new zzd<>();
        this.zzbIf = comparator == null ? zzbXf : comparator;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void zza(zzd<K, V> zzd2) {
        zzd<K, V> zzd3 = zzd2.zzbXr;
        zzd<K, V> zzd4 = zzd2.zzbXs;
        zzd<K, V> zzd5 = zzd4.zzbXr;
        zzd<K, V> zzd6 = zzd4.zzbXs;
        zzd2.zzbXs = zzd5;
        if (zzd5 != null) {
            zzd5.zzbXq = zzd2;
        }
        zza(zzd2, zzd4);
        zzd4.zzbXr = zzd2;
        zzd2.zzbXq = zzd4;
        int i = 0;
        zzd2.height = Math.max(zzd3 != null ? zzd3.height : 0, zzd5 != null ? zzd5.height : 0) + 1;
        int i2 = zzd2.height;
        if (zzd6 != null) {
            i = zzd6.height;
        }
        zzd4.height = Math.max(i2, i) + 1;
    }

    private void zza(zzd<K, V> zzd2, zzd<K, V> zzd3) {
        zzd<K, V> zzd4 = zzd2.zzbXq;
        zzd2.zzbXq = null;
        if (zzd3 != null) {
            zzd3.zzbXq = zzd4;
        }
        if (zzd4 == null) {
            this.zzbXg = zzd3;
        } else if (zzd4.zzbXr == zzd2) {
            zzd4.zzbXr = zzd3;
        } else {
            zzd4.zzbXs = zzd3;
        }
    }

    private void zzb(zzd<K, V> zzd2) {
        zzd<K, V> zzd3 = zzd2.zzbXr;
        zzd<K, V> zzd4 = zzd2.zzbXs;
        zzd<K, V> zzd5 = zzd3.zzbXr;
        zzd<K, V> zzd6 = zzd3.zzbXs;
        zzd2.zzbXr = zzd6;
        if (zzd6 != null) {
            zzd6.zzbXq = zzd2;
        }
        zza(zzd2, zzd3);
        zzd3.zzbXs = zzd2;
        zzd2.zzbXq = zzd3;
        int i = 0;
        zzd2.height = Math.max(zzd4 != null ? zzd4.height : 0, zzd6 != null ? zzd6.height : 0) + 1;
        int i2 = zzd2.height;
        if (zzd5 != null) {
            i = zzd5.height;
        }
        zzd3.height = Math.max(i2, i) + 1;
    }

    private void zzb(zzd<K, V> zzd2, boolean z) {
        while (zzd2 != null) {
            zzd<K, V> zzd3 = zzd2.zzbXr;
            zzd<K, V> zzd4 = zzd2.zzbXs;
            int i = 0;
            int i2 = zzd3 != null ? zzd3.height : 0;
            int i3 = zzd4 != null ? zzd4.height : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                zzd<K, V> zzd5 = zzd4.zzbXr;
                zzd<K, V> zzd6 = zzd4.zzbXs;
                int i5 = zzd6 != null ? zzd6.height : 0;
                if (zzd5 != null) {
                    i = zzd5.height;
                }
                int i6 = i - i5;
                if (i6 != -1 && (i6 != 0 || z)) {
                    zzb(zzd4);
                }
                zza(zzd2);
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                zzd<K, V> zzd7 = zzd3.zzbXr;
                zzd<K, V> zzd8 = zzd3.zzbXs;
                int i7 = zzd8 != null ? zzd8.height : 0;
                if (zzd7 != null) {
                    i = zzd7.height;
                }
                int i8 = i - i7;
                if (i8 != 1 && (i8 != 0 || z)) {
                    zza(zzd3);
                }
                zzb(zzd2);
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                zzd2.height = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                zzd2.height = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            zzd2 = zzd2.zzbXq;
        }
    }

    public void clear() {
        this.zzbXg = null;
        this.size = 0;
        this.modCount++;
        zzd<K, V> zzd2 = this.zzbXh;
        zzd2.zzbXt = zzd2;
        zzd2.zzbXn = zzd2;
    }

    public boolean containsKey(Object obj) {
        return zzaM(obj) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        zza zza2 = this.zzbXi;
        if (zza2 != null) {
            return zza2;
        }
        zza zza3 = new zza();
        this.zzbXi = zza3;
        return zza3;
    }

    public V get(Object obj) {
        zzd zzaM = zzaM(obj);
        if (zzaM != null) {
            return zzaM.zzbIu;
        }
        return null;
    }

    public Set<K> keySet() {
        zzb zzb2 = this.zzbXj;
        if (zzb2 != null) {
            return zzb2;
        }
        zzb zzb3 = new zzb();
        this.zzbXj = zzb3;
        return zzb3;
    }

    public V put(K k, V v) {
        if (k != null) {
            zzd zza2 = zza(k, true);
            V v2 = zza2.zzbIu;
            zza2.zzbIu = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object obj) {
        zzd zzaN = zzaN(obj);
        if (zzaN != null) {
            return zzaN.zzbIu;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public zzd<K, V> zza(K k, boolean z) {
        int i;
        zzd<K, V> zzd2;
        Comparator<? super K> comparator = this.zzbIf;
        zzd<K, V> zzd3 = this.zzbXg;
        if (zzd3 != null) {
            Comparable comparable = comparator == zzbXf ? (Comparable) k : null;
            while (true) {
                i = comparable != null ? comparable.compareTo(zzd3.zzbIt) : comparator.compare(k, zzd3.zzbIt);
                if (i == 0) {
                    return zzd3;
                }
                zzd<K, V> zzd4 = i < 0 ? zzd3.zzbXr : zzd3.zzbXs;
                if (zzd4 == null) {
                    break;
                }
                zzd3 = zzd4;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        zzd<K, V> zzd5 = this.zzbXh;
        if (zzd3 != null) {
            zzd2 = new zzd<>(zzd3, k, zzd5, zzd5.zzbXt);
            if (i < 0) {
                zzd3.zzbXr = zzd2;
            } else {
                zzd3.zzbXs = zzd2;
            }
            zzb(zzd3, true);
        } else if (comparator != zzbXf || (k instanceof Comparable)) {
            zzd2 = new zzd<>(zzd3, k, zzd5, zzd5.zzbXt);
            this.zzbXg = zzd2;
        } else {
            throw new ClassCastException(String.valueOf(k.getClass().getName()).concat(" is not Comparable"));
        }
        this.size++;
        this.modCount++;
        return zzd2;
    }

    /* access modifiers changed from: package-private */
    public void zza(zzd<K, V> zzd2, boolean z) {
        int i;
        if (z) {
            zzd2.zzbXt.zzbXn = zzd2.zzbXn;
            zzd2.zzbXn.zzbXt = zzd2.zzbXt;
        }
        zzd<K, V> zzd3 = zzd2.zzbXr;
        zzd<K, V> zzd4 = zzd2.zzbXs;
        zzd<K, V> zzd5 = zzd2.zzbXq;
        int i2 = 0;
        if (zzd3 == null || zzd4 == null) {
            if (zzd3 != null) {
                zza(zzd2, zzd3);
                zzd2.zzbXr = null;
            } else if (zzd4 != null) {
                zza(zzd2, zzd4);
                zzd2.zzbXs = null;
            } else {
                zza(zzd2, (zzd<K, V>) null);
            }
            zzb(zzd5, false);
            this.size--;
            this.modCount++;
            return;
        }
        zzd<K, V> zzVX = zzd3.height > zzd4.height ? zzd3.zzVX() : zzd4.zzVW();
        zza(zzVX, false);
        zzd<K, V> zzd6 = zzd2.zzbXr;
        if (zzd6 != null) {
            i = zzd6.height;
            zzVX.zzbXr = zzd6;
            zzd6.zzbXq = zzVX;
            zzd2.zzbXr = null;
        } else {
            i = 0;
        }
        zzd<K, V> zzd7 = zzd2.zzbXs;
        if (zzd7 != null) {
            i2 = zzd7.height;
            zzVX.zzbXs = zzd7;
            zzd7.zzbXq = zzVX;
            zzd2.zzbXs = null;
        }
        zzVX.height = Math.max(i, i2) + 1;
        zza(zzd2, zzVX);
    }

    /* access modifiers changed from: package-private */
    public zzd<K, V> zzaM(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return zza(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public zzd<K, V> zzaN(Object obj) {
        zzd<K, V> zzaM = zzaM(obj);
        if (zzaM != null) {
            zza(zzaM, true);
        }
        return zzaM;
    }

    /* access modifiers changed from: package-private */
    public zzd<K, V> zzc(Map.Entry<?, ?> entry) {
        zzd<K, V> zzaM = zzaM(entry.getKey());
        if (zzaM != null && equal(zzaM.zzbIu, entry.getValue())) {
            return zzaM;
        }
        return null;
    }
}
