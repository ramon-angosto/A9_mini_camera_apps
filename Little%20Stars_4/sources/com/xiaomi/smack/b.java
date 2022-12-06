package com.xiaomi.smack;

import com.xiaomi.channel.commonutils.misc.a;
import java.util.Map;

public class b implements Cloneable {
    public static String b = "wcc-ml-test10.bj";
    public static String c;
    private String a;
    private String d;
    private int e;
    private boolean f = a.a;
    private boolean g = true;
    private String h;
    private e i;

    public b(Map<String, Integer> map, int i2, String str, e eVar) {
        a(map, i2, str, eVar);
    }

    private void a(Map<String, Integer> map, int i2, String str, e eVar) {
        this.d = b();
        this.e = i2;
        this.a = str;
        this.i = eVar;
    }

    public static final String b() {
        String str = c;
        return str != null ? str : a.a() ? "sandbox.xmpush.xiaomi.com" : a.b() ? "10.237.14.141" : "app.chat.xiaomi.net";
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public byte[] a() {
        return null;
    }

    public void b(String str) {
        this.h = str;
    }

    public String c() {
        return this.a;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.h;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return this.f;
    }
}
