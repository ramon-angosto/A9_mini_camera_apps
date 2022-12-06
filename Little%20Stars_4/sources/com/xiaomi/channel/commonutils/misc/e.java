package com.xiaomi.channel.commonutils.misc;

import com.xiaomi.channel.commonutils.misc.d;

class e extends d.b {
    final /* synthetic */ String a;
    final /* synthetic */ d b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e(d dVar, d.a aVar, String str) {
        super(aVar);
        this.b = dVar;
        this.a = str;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        super.a();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.b.e.edit().putLong(this.a, System.currentTimeMillis()).commit();
    }
}
