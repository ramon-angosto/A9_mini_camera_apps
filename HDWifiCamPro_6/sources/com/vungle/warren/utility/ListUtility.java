package com.vungle.warren.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListUtility {
    public static <T> List<List<T>> partition(Collection<T> collection, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T add : collection) {
            arrayList2.add(add);
            if (arrayList2.size() == i) {
                arrayList.add(arrayList2);
                arrayList2 = new ArrayList();
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(arrayList2);
        }
        return arrayList;
    }
}
