package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* renamed from: com.xiaomi.push.cn */
public class C1695cn {

    /* renamed from: a */
    private static String f1947a = f1948a.format(Long.valueOf(System.currentTimeMillis()));

    /* renamed from: a */
    private static SimpleDateFormat f1948a = new SimpleDateFormat("yyyy/MM/dd");

    /* renamed from: a */
    public static C1872hs m2869a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1872hs hsVar = new C1872hs();
        hsVar.mo17791d("category_push_stat");
        hsVar.mo17779a("push_sdk_stat_channel");
        hsVar.mo17778a(1);
        hsVar.mo17784b(str);
        hsVar.mo17781a(true);
        hsVar.mo17783b(System.currentTimeMillis());
        hsVar.mo17798g(C1671bw.m2760a(context).mo17270a());
        hsVar.mo17793e("com.xiaomi.xmsf");
        hsVar.mo17796f("");
        hsVar.mo17787c("push_stat");
        return hsVar;
    }
}
