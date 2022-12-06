package com.adcolony.sdk;

class m implements j0 {

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(m mVar, String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            try {
                AdColonyCustomMessageListener adColonyCustomMessageListener = a.b().m().get(this.a);
                if (adColonyCustomMessageListener != null) {
                    adColonyCustomMessageListener.onAdColonyCustomMessage(new AdColonyCustomMessage(this.a, this.b));
                }
            } catch (RuntimeException unused) {
            }
        }
    }

    m() {
        a.a("CustomMessage.controller_send", (j0) this);
    }

    public void a(h0 h0Var) {
        f1 a2 = h0Var.a();
        z0.b((Runnable) new a(this, c0.h(a2, "type"), c0.h(a2, "message")));
    }
}
