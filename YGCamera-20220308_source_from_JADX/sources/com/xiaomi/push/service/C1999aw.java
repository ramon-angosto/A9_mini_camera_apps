package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.C1663bo;

/* renamed from: com.xiaomi.push.service.aw */
public class C1999aw {

    /* renamed from: a */
    private static long f3722a = 0;

    /* renamed from: a */
    private static String f3723a = "";

    /* renamed from: a */
    public static String m5064a() {
        if (TextUtils.isEmpty(f3723a)) {
            f3723a = C1663bo.m2726a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f3723a);
        long j = f3722a;
        f3722a = 1 + j;
        sb.append(j);
        return sb.toString();
    }
}
