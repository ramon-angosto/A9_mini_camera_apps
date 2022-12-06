package com.mbridge.msdk.c;

import com.mbridge.msdk.c.a;

/* compiled from: TimerController */
public class b {

    /* compiled from: TimerController */
    static class a {
        static b a = new b();
    }

    private b() {
    }

    public static b getInstance() {
        return a.a;
    }

    public void start() {
        com.mbridge.msdk.b.a b = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (b == null) {
            b = com.mbridge.msdk.b.b.a().b();
        }
        int e = b.e();
        if (e > 0) {
            a.C0057a.a.a((long) (e * 1000));
        }
    }

    public void addRewardList(String str, String str2) {
        a.C0057a.a.a(str, str2);
    }

    public void addInterstitialList(String str, String str2) {
        a.C0057a.a.b(str, str2);
    }
}
