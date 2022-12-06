package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.q */
public class C1943q {

    /* renamed from: a */
    private static volatile C1943q f3573a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f3574a;

    /* renamed from: a */
    private Handler f3575a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private Map<String, Map<String, String>> f3576a = new HashMap();

    private C1943q(Context context) {
        this.f3574a = context;
    }

    /* renamed from: a */
    public static C1943q m4739a(Context context) {
        if (f3573a == null) {
            synchronized (C1943q.class) {
                if (f3573a == null) {
                    f3573a = new C1943q(context);
                }
            }
        }
        return f3573a;
    }

    /* renamed from: a */
    private synchronized String m4740a(String str, String str2) {
        if (this.f3576a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Map map = this.f3576a.get(str);
            if (map == null) {
                return "";
            }
            return (String) map.get(str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    private synchronized void m4741b(String str, String str2, String str3) {
        if (this.f3576a == null) {
            this.f3576a = new HashMap();
        }
        Map map = this.f3576a.get(str);
        if (map == null) {
            map = new HashMap();
        }
        map.put(str2, str3);
        this.f3576a.put(str, map);
    }

    /* renamed from: a */
    public synchronized String mo18380a(String str, String str2, String str3) {
        String a = m4740a(str, str2);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        return this.f3574a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a */
    public synchronized void m4743a(String str, String str2, String str3) {
        m4741b(str, str2, str3);
        this.f3575a.post(new C1944r(this, str, str2, str3));
    }
}
