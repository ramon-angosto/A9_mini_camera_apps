package com.ironsource.b;

import android.util.Pair;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.ironsource.mediationsdk.a.c;
import java.util.ArrayList;

public final class b implements Runnable {
    private c a;
    private String b;
    private String c;
    private ArrayList<c> d;

    public b(c cVar, String str, String str2, ArrayList<c> arrayList) {
        this.a = cVar;
        this.b = str;
        this.c = str2;
        this.d = arrayList;
    }

    public final void run() {
        boolean z = false;
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(HttpHeaders.CONTENT_TYPE, "application/json"));
            com.ironsource.d.c a2 = com.ironsource.d.b.a(this.c, this.b, arrayList);
            if (a2.a == 200 || a2.a == 204) {
                z = true;
            }
        } catch (Exception unused) {
        }
        c cVar = this.a;
        if (cVar != null) {
            cVar.a((ArrayList<c>) null, z);
        }
    }
}
