package com.bytedance.sdk.component.e.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.d.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdLogManager */
public class b {
    private static volatile List<e> a = new ArrayList();

    public static void a(a aVar, Context context) {
        d.a.a(aVar, context);
        c.a("init  end");
    }

    public static List<e> a() {
        return a;
    }

    public static boolean b() {
        return i.e().m() == null || i.e().d() == null;
    }

    public static void c() {
        c.a("AppLogManager#start");
        d.a.a();
    }

    public static void d() {
        d.a.b();
    }

    public static void a(String str) {
        d.a.a(str);
    }

    public static void a(String str, List<String> list, boolean z) {
        d.a.a(str, list, z);
    }

    public static void e() {
        d.a.c();
    }

    public static void a(a aVar) {
        d.a.a(aVar);
    }
}
