package com.apm.insight.e.a;

public class a {
    public String a;
    public long b;

    public static a a(String str) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = System.currentTimeMillis();
        return aVar;
    }
}
