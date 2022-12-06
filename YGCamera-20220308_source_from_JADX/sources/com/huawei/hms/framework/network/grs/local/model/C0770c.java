package com.huawei.hms.framework.network.grs.local.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.c */
public class C0770c {

    /* renamed from: a */
    private String f595a;

    /* renamed from: b */
    private String f596b;

    /* renamed from: c */
    private Map<String, C0771d> f597c = new HashMap(16);

    /* renamed from: d */
    private List<C0769b> f598d = new ArrayList(16);

    /* renamed from: a */
    public C0771d mo13911a(String str) {
        return this.f597c.get(str);
    }

    /* renamed from: a */
    public List<C0769b> mo13912a() {
        return this.f598d;
    }

    /* renamed from: a */
    public void mo13913a(String str, C0771d dVar) {
        this.f597c.put(str, dVar);
    }

    /* renamed from: a */
    public void mo13914a(List<C0769b> list) {
        this.f598d = list;
    }

    /* renamed from: b */
    public String mo13915b() {
        return this.f596b;
    }

    /* renamed from: b */
    public void mo13916b(String str) {
        this.f595a = str;
    }

    /* renamed from: c */
    public void mo13917c(String str) {
        this.f596b = str;
    }
}
