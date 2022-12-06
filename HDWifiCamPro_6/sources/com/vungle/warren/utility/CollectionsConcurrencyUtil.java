package com.vungle.warren.utility;

import java.util.HashSet;

public class CollectionsConcurrencyUtil {
    public static synchronized HashSet<String> getNewHashSet(HashSet<String> hashSet) {
        HashSet<String> hashSet2;
        synchronized (CollectionsConcurrencyUtil.class) {
            hashSet2 = new HashSet<>(hashSet);
        }
        return hashSet2;
    }

    public static synchronized void addToSet(HashSet hashSet, String str) {
        synchronized (CollectionsConcurrencyUtil.class) {
            hashSet.add(str);
        }
    }
}
