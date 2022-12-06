package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.C1618ak;

/* renamed from: com.xiaomi.push.service.ah */
final class C1979ah extends C1618ak.C1619a {

    /* renamed from: a */
    final /* synthetic */ int f3677a;

    /* renamed from: a */
    final /* synthetic */ Notification f3678a;

    /* renamed from: a */
    final /* synthetic */ Context f3679a;

    /* renamed from: a */
    final /* synthetic */ String f3680a;

    /* renamed from: b */
    final /* synthetic */ String f3681b;

    C1979ah(int i, String str, Context context, String str2, Notification notification) {
        this.f3677a = i;
        this.f3680a = str;
        this.f3679a = context;
        this.f3681b = str2;
        this.f3678a = notification;
    }

    /* renamed from: a */
    public String mo16986a() {
        return C1974af.m4937b(this.f3677a, this.f3680a);
    }

    public void run() {
        C1974af.m4909a(this.f3679a, this.f3681b, this.f3677a, this.f3680a, this.f3678a);
    }
}
