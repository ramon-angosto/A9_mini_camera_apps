package com.ironsource.mediationsdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ironsource.mediationsdk.i  reason: case insensitive filesystem */
public final class C0156i {
    private ConcurrentHashMap<String, ArrayList<a>> a = new ConcurrentHashMap<>();
    private int b;

    /* renamed from: com.ironsource.mediationsdk.i$a */
    public enum a {
        ISAuctionPerformanceDidntAttemptToLoad,
        ISAuctionPerformanceFailedToLoad,
        ISAuctionPerformanceLoadedSuccessfully,
        ISAuctionPerformanceFailedToShow,
        ISAuctionPerformanceShowedSuccessfully,
        ISAuctionPerformanceNotPartOfWaterfall
    }

    public C0156i(List<String> list, int i) {
        this.b = i;
        for (String put : list) {
            ArrayList arrayList = new ArrayList();
            this.a.put(put, arrayList);
        }
    }

    public final String a(String str) {
        ArrayList arrayList = this.a.get(str);
        String str2 = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            StringBuilder sb = new StringBuilder();
            while (true) {
                sb.append(str2);
                sb.append(((a) it.next()).ordinal());
                str2 = sb.toString();
                if (!it.hasNext()) {
                    break;
                }
                str2 = str2 + ",";
                sb = new StringBuilder();
            }
        }
        return str2;
    }

    public final void a(ConcurrentHashMap<String, a> concurrentHashMap) {
        if (this.b != 0) {
            for (String next : this.a.keySet()) {
                a aVar = a.ISAuctionPerformanceNotPartOfWaterfall;
                if (concurrentHashMap.containsKey(next)) {
                    aVar = concurrentHashMap.get(next);
                }
                ArrayList arrayList = this.a.get(next);
                if (this.b != -1 && arrayList.size() == this.b) {
                    arrayList.remove(0);
                }
                arrayList.add(aVar);
            }
        }
    }
}
