package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.C1589l;
import com.xiaomi.push.C1656bj;

/* renamed from: com.xiaomi.mipush.sdk.ak */
public class C1564ak {
    /* renamed from: a */
    public static AbstractPushManager m2292a(Context context, C1582e eVar) {
        return m2293b(context, eVar);
    }

    /* renamed from: b */
    private static AbstractPushManager m2293b(Context context, C1582e eVar) {
        C1589l.C1590a a = C1589l.m2448a(eVar);
        if (a == null || TextUtils.isEmpty(a.f1730a) || TextUtils.isEmpty(a.f1731b)) {
            return null;
        }
        return (AbstractPushManager) C1656bj.m2699a(a.f1730a, a.f1731b, context);
    }
}
