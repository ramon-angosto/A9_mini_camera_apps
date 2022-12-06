package com.adcolony.sdk;

public class AdColonyCustomMessage {
    /* access modifiers changed from: private */
    public String a;
    /* access modifiers changed from: private */
    public String b;

    class a implements Runnable {
        a() {
        }

        public void run() {
            AdColony.b();
            f1 b = c0.b();
            c0.a(b, "type", AdColonyCustomMessage.this.a);
            c0.a(b, "message", AdColonyCustomMessage.this.b);
            new h0("CustomMessage.native_send", 1, b).c();
        }
    }

    public AdColonyCustomMessage(String str, String str2) {
        if (z0.e(str) || z0.e(str2)) {
            this.a = str;
            this.b = str2;
        }
    }

    public String getMessage() {
        return this.b;
    }

    public String getType() {
        return this.a;
    }

    public void send() {
        AdColony.a((Runnable) new a());
    }

    public AdColonyCustomMessage set(String str, String str2) {
        this.a = str;
        this.b = str2;
        return this;
    }
}
