package com.bytedance.sdk.component.f;

import java.io.File;
import java.util.Map;

/* compiled from: NetResponse */
public class b {
    final int a;
    final String b;
    final Map<String, String> c;
    final String d;
    final long e;
    final long f;
    private File g = null;
    private final boolean h;
    private byte[] i = null;

    public b(boolean z, int i2, String str, Map<String, String> map, String str2, long j, long j2) {
        this.h = z;
        this.a = i2;
        this.b = str;
        this.c = map;
        this.d = str2;
        this.e = j;
        this.f = j2;
    }

    public int a() {
        return this.a;
    }

    public void a(File file) {
        this.g = file;
    }

    public String b() {
        return this.b;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public File e() {
        return this.g;
    }

    public boolean f() {
        return this.h;
    }

    public long g() {
        return this.e - this.f;
    }
}
