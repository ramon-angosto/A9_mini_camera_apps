package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.eg */
final class C1761eg implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2213a;

    /* renamed from: a */
    final /* synthetic */ Context f2214a;

    /* renamed from: a */
    final /* synthetic */ String f2215a;

    /* renamed from: b */
    final /* synthetic */ String f2216b;

    C1761eg(Context context, String str, int i, String str2) {
        this.f2214a = context;
        this.f2215a = str;
        this.f2213a = i;
        this.f2216b = str2;
    }

    public void run() {
        C1760ef.m3339c(this.f2214a, this.f2215a, this.f2213a, this.f2216b);
    }
}
