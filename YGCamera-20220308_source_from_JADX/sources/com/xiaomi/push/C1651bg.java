package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.bg */
public class C1651bg {

    /* renamed from: a */
    public int f1864a;

    /* renamed from: a */
    public String f1865a;

    /* renamed from: a */
    public Map<String, String> f1866a = new HashMap();

    /* renamed from: a */
    public String mo17255a() {
        return this.f1865a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", new Object[]{Integer.valueOf(this.f1864a), this.f1866a.toString(), this.f1865a});
    }
}
