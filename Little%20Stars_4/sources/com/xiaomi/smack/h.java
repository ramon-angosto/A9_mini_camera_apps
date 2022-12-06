package com.xiaomi.smack;

class h extends Thread {
    final /* synthetic */ g a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    h(g gVar, String str) {
        super(str);
        this.a = gVar;
    }

    public void run() {
        this.a.f();
    }
}
