package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.C1764ej;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.service.C1995at;

/* renamed from: com.xiaomi.mipush.sdk.q */
final class C1595q extends C1995at.C1996a {

    /* renamed from: a */
    final /* synthetic */ Context f1736a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1595q(int i, String str, Context context) {
        super(i, str);
        this.f1736a = context;
    }

    /* access modifiers changed from: protected */
    public void onCallback() {
        C1764ej.m3355a(this.f1736a).mo17524a(C1995at.m5047a(this.f1736a).mo18465a(C1873ht.AwakeInfoUploadWaySwitch.mo17806a(), 0));
    }
}
