package com.google.gson.internal;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public final class StringMap<V> extends AbstractMap<String, V> {
    private static final Map.Entry[] EMPTY_TABLE = new LinkedEntry[2];
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final int MINIMUM_CAPACITY = 4;
    private static final int seed = new Random().nextInt();
    private Set<Map.Entry<String, V>> entrySet;
    /* access modifiers changed from: private */
    public LinkedEntry<V> header = new LinkedEntry<>();
    private Set<String> keySet;
    /* access modifiers changed from: private */
    public int size;
    private LinkedEntry<V>[] table = ((LinkedEntry[]) EMPTY_TABLE);
    private int threshold = -1;
    private Collection<V> values;

    public int size() {
        return this.size;
    }

    public boolean containsKey(Object obj) {
        return (obj instanceof String) && getEntry((String) obj) != null;
    }

    public V get(Object obj) {
        LinkedEntry entry;
        if (!(obj instanceof String) || (entry = getEntry((String) obj)) == null) {
            return null;
        }
        return entry.value;
    }

    private LinkedEntry<V> getEntry(String str) {
        if (str == null) {
            return null;
        }
        int hash = hash(str);
        LinkedEntry<V>[] linkedEntryArr = this.table;
        for (LinkedEntry<V> linkedEntry = linkedEntryArr[(linkedEntryArr.length - 1) & hash]; linkedEntry != null; linkedEntry = linkedEntry.next) {
            String str2 = linkedEntry.key;
            if (str2 == str || (linkedEntry.hash == hash && str.equals(str2))) {
                return linkedEntry;
            }
        }
        return null;
    }

    public V put(String str, V v) {
        if (str != null) {
            int hash = hash(str);
            LinkedEntry<V>[] linkedEntryArr = this.table;
            int length = (linkedEntryArr.length - 1) & hash;
            LinkedEntry<V> linkedEntry = linkedEntryArr[length];
            while (linkedEntry != null) {
                if (linkedEntry.hash != hash || !str.equals(linkedEntry.key)) {
                    linkedEntry = linkedEntry.next;
                } else {
                    V v2 = linkedEntry.value;
                    linkedEntry.value = v;
                    return v2;
                }
            }
            int i = this.size;
            this.size = i + 1;
            if (i > this.threshold) {
                length = hash & (doubleCapacity().length - 1);
            }
            addNewEntry(str, v, hash, length);
            return null;
        }
        throw new NullPointerException("key == null");
    }

    private void addNewEntry(String str, V v, int i, int i2) {
        LinkedEntry<V> linkedEntry = this.header;
        LinkedEntry<V> linkedEntry2 = linkedEntry.prv;
        LinkedEntry<V> linkedEntry3 = new LinkedEntry<>(str, v, i, this.table[i2], linkedEntry, linkedEntry2);
        LinkedEntry<V>[] linkedEntryArr = this.table;
        linkedEntry.prv = linkedEntry3;
        linkedEntry2.nxt = linkedEntry3;
        linkedEntryArr[i2] = linkedEntry3;
    }

    private LinkedEntry<V>[] makeTable(int i) {
        LinkedEntry<V>[] linkedEntryArr = (LinkedEntry[]) new LinkedEntry[i];
        this.table = linkedEntryArr;
        this.threshold = (i >> 1) + (i >> 2);
        return linkedEntryArr;
    }

    private LinkedEntry<V>[] doubleCapacity() {
        LinkedEntry<V>[] linkedEntryArr = this.table;
        int length = linkedEntryArr.length;
        if (length == MAXIMUM_CAPACITY) {
            return linkedEntryArr;
        }
        LinkedEntry<V>[] makeTable = makeTable(length * 2);
        if (this.size == 0) {
            return makeTable;
        }
        for (int i = 0; i < length; i++) {
            LinkedEntry<V> linkedEntry = linkedEntryArr[i];
            if (linkedEntry != null) {
                int i2 = linkedEntry.hash & length;
                makeTable[i | i2] = linkedEntry;
                LinkedEntry<V> linkedEntry2 = linkedEntry;
                int i3 = i2;
                LinkedEntry<V> linkedEntry3 = null;
                for (LinkedEntry<V> linkedEntry4 = linkedEntry.next; linkedEntry4 != null; linkedEntry4 = linkedEntry4.next) {
                    int i4 = linkedEntry4.hash & length;
                    if (i4 != i3) {
                        if (linkedEntry3 == null) {
                            makeTable[i | i4] = linkedEntry4;
                        } else {
                            linkedEntry3.next = linkedEntry4;
                        }
                        linkedEntry3 = linkedEntry2;
                        i3 = i4;
                    }
                    linkedEntry2 = linkedEntry4;
                }
                if (linkedEntry3 != null) {
                    linkedEntry3.next = null;
                }
            }
        }
        return makeTable;
    }

    public V remove(Object obj) {
        if (obj != null && (obj instanceof String)) {
            int hash = hash((String) obj);
            LinkedEntry<V>[] linkedEntryArr = this.table;
            int length = (linkedEntryArr.length - 1) & hash;
            LinkedEntry<V> linkedEntry = linkedEntryArr[length];
            LinkedEntry<V> linkedEntry2 = null;
            while (linkedEntry != null) {
                if (linkedEntry.hash != hash || !obj.equals(linkedEntry.key)) {
                    linkedEntry2 = linkedEntry;
                    linkedEntry = linkedEntry.next;
                } else {
                    if (linkedEntry2 == null) {
                        linkedEntryArr[length] = linkedEntry.next;
                    } else {
                        linkedEntry2.next = linkedEntry.next;
                    }
                    this.size--;
                    unlink(linkedEntry);
                    return linkedEntry.value;
                }
            }
        }
        return null;
    }

    private void unlink(LinkedEntry<V> linkedEntry) {
        linkedEntry.prv.nxt = linkedEntry.nxt;
        linkedEntry.nxt.prv = linkedEntry.prv;
        linkedEntry.prv = null;
        linkedEntry.nxt = null;
    }

    public void clear() {
        if (this.size != 0) {
            Arrays.fill(this.table, (Object) null);
            this.size = 0;
        }
        LinkedEntry<V> linkedEntry = this.header;
        LinkedEntry<V> linkedEntry2 = linkedEntry.nxt;
        while (linkedEntry2 != linkedEntry) {
            LinkedEntry<V> linkedEntry3 = linkedEntry2.nxt;
            linkedEntry2.prv = null;
            linkedEntry2.nxt = null;
            linkedEntry2 = linkedEntry3;
        }
        linkedEntry.prv = linkedEntry;
        linkedEntry.nxt = linkedEntry;
    }

    public Set<String> keySet() {
        Set<String> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values2 = new Values();
        this.values = values2;
        return values2;
    }

    public Set<Map.Entry<String, V>> entrySet() {
        Set<Map.Entry<String, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    static class LinkedEntry<V> implements Map.Entry<String, V> {
        final int hash;
        final String key;
        LinkedEntry<V> next;
        LinkedEntry<V> nxt;
        LinkedEntry<V> prv;
        V value;

        LinkedEntry() {
            this((String) null, (Object) null, 0, (LinkedEntry) null, (LinkedEntry) null, (LinkedEntry) null);
            this.prv = this;
            this.nxt = this;
        }

        LinkedEntry(String str, V v, int i, LinkedEntry<V> linkedEntry, LinkedEntry<V> linkedEntry2, LinkedEntry<V> linkedEntry3) {
            this.key = str;
            this.value = v;
            this.hash = i;
            this.next = linkedEntry;
            this.nxt = linkedEntry2;
            this.prv = linkedEntry3;
        }

        public final String getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        public final V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0025 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getValue()
                java.lang.String r2 = r3.key
                java.lang.Object r4 = r4.getKey()
                boolean r4 = r2.equals(r4)
                if (r4 == 0) goto L_0x0026
                V r4 = r3.value
                if (r4 != 0) goto L_0x001f
                if (r0 != 0) goto L_0x0026
                goto L_0x0025
            L_0x001f:
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x0026
            L_0x0025:
                r1 = 1
            L_0x0026:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.StringMap.LinkedEntry.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            String str = this.key;
            int i = 0;
            int hashCode = str == null ? 0 : str.hashCode();
            V v = this.value;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }
    }

    /* access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2) {
        if (obj != null && (obj instanceof String)) {
            int hash = hash((String) obj);
            LinkedEntry<V>[] linkedEntryArr = this.table;
            int length = (linkedEntryArr.length - 1) & hash;
            LinkedEntry<V> linkedEntry = linkedEntryArr[length];
            LinkedEntry<V> linkedEntry2 = null;
            while (true) {
                LinkedEntry<V> linkedEntry3 = linkedEntry2;
                linkedEntry2 = linkedEntry;
                LinkedEntry<V> linkedEntry4 = linkedEntry3;
                if (linkedEntry2 == null) {
                    break;
                } else if (linkedEntry2.hash != hash || !obj.equals(linkedEntry2.key)) {
                    linkedEntry = linkedEntry2.next;
                } else if (obj2 != null ? !obj2.equals(linkedEntry2.value) : linkedEntry2.value != null) {
                    return false;
                } else {
                    if (linkedEntry4 == null) {
                        linkedEntryArr[length] = linkedEntry2.next;
                    } else {
                        linkedEntry4.next = linkedEntry2.next;
                    }
                    this.size--;
                    unlink(linkedEntry2);
                    return true;
                }
            }
        }
        return false;
    }

    private abstract class LinkedHashIterator<T> implements Iterator<T> {
        LinkedEntry<V> lastReturned;
        LinkedEntry<V> next;

        private LinkedHashIterator() {
            this.next = StringMap.this.header.nxt;
            this.lastReturned = null;
        }

        public final boolean hasNext() {
            return this.next != StringMap.this.header;
        }

        /* access modifiers changed from: package-private */
        public final LinkedEntry<V> nextEntry() {
            LinkedEntry<V> linkedEntry = this.next;
            if (linkedEntry != StringMap.this.header) {
                this.next = linkedEntry.nxt;
                this.lastReturned = linkedEntry;
                return linkedEntry;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            LinkedEntry<V> linkedEntry = this.lastReturned;
            if (linkedEntry != null) {
                StringMap.this.remove(linkedEntry.key);
                this.lastReturned = null;
                return;
            }
            throw new IllegalStateException();
        }
    }

    private final class KeySet extends AbstractSet<String> {
        private KeySet() {
        }

        public Iterator<String> iterator() {
            return new StringMap<V>.LinkedHashIterator<String>() {
                {
                    StringMap stringMap = StringMap.this;
                }

                public final String next() {
                    return nextEntry().key;
                }
            };
        }

        public int size() {
            return StringMap.this.size;
        }

        public boolean contains(Object obj) {
            return StringMap.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            int access$500 = StringMap.this.size;
            StringMap.this.remove(obj);
            return StringMap.this.size != access$500;
        }

        public void clear() {
            StringMap.this.clear();
        }
    }

    private final class Values extends AbstractCollection<V> {
        private Values() {
        }

        public Iterator<V> iterator() {
            return new StringMap<V>.LinkedHashIterator<V>() {
                {
                    StringMap stringMap = StringMap.this;
                }

                public final V next() {
                    return nextEntry().value;
                }
            };
        }

        public int size() {
            return StringMap.this.size;
        }

        public boolean contains(Object obj) {
            return StringMap.this.containsValue(obj);
        }

        public void clear() {
            StringMap.this.clear();
        }
    }

    private final class EntrySet extends AbstractSet<Map.Entry<String, V>> {
        private EntrySet() {
        }

        public Iterator<Map.Entry<String, V>> iterator() {
            return new StringMap<V>.LinkedHashIterator<Map.Entry<String, V>>() {
                {
                    StringMap stringMap = StringMap.this;
                }

                public final Map.Entry<String, V> next() {
                    return nextEntry();
                }
            };
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = StringMap.this.get(entry.getKey());
            if (obj2 == null || !obj2.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return StringMap.this.removeMapping(entry.getKey(), entry.getValue());
        }

        public int size() {
            return StringMap.this.size;
        }

        public void clear() {
            StringMap.this.clear();
        }
    }

    private static int hash(String str) {
        int i = seed;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int charAt = i + str.charAt(i2);
            int i3 = (charAt + charAt) << 10;
            i = i3 ^ (i3 >>> 6);
        }
        int i4 = ((i >>> 20) ^ (i >>> 12)) ^ i;
        return (i4 >>> 4) ^ ((i4 >>> 7) ^ i4);
    }
}
