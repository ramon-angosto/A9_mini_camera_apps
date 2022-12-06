package com.huawei.hms.framework.network.grs.local.model;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.a */
public class C0768a {

    /* renamed from: a */
    private String f588a;

    /* renamed from: b */
    private long f589b;

    /* renamed from: c */
    private Map<String, C0770c> f590c = new HashMap(16);

    /* renamed from: a */
    public C0770c mo13899a(String str) {
        return this.f590c.get(str);
    }

    /* renamed from: a */
    public void mo13900a() {
        Map<String, C0770c> map = this.f590c;
        if (map != null) {
            map.clear();
        }
    }

    /* renamed from: a */
    public void mo13901a(long j) {
        this.f589b = j;
    }

    /* renamed from: a */
    public void mo13902a(String str, C0770c cVar) {
        this.f590c.put(str, cVar);
    }

    /* renamed from: b */
    public String mo13903b() {
        return this.f588a;
    }

    /* renamed from: b */
    public void mo13904b(String str) {
        this.f588a = str;
    }
}
