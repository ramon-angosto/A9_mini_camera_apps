package com.xiaomi.push;

import android.content.SharedPreferences;

/* renamed from: com.xiaomi.push.r */
class C1944r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1943q f3577a;

    /* renamed from: a */
    final /* synthetic */ String f3578a;

    /* renamed from: b */
    final /* synthetic */ String f3579b;

    /* renamed from: c */
    final /* synthetic */ String f3580c;

    C1944r(C1943q qVar, String str, String str2, String str3) {
        this.f3577a = qVar;
        this.f3578a = str;
        this.f3579b = str2;
        this.f3580c = str3;
    }

    public void run() {
        SharedPreferences.Editor edit = this.f3577a.f3574a.getSharedPreferences(this.f3578a, 4).edit();
        edit.putString(this.f3579b, this.f3580c);
        edit.commit();
    }
}
