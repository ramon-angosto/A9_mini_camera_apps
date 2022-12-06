package com.apm.insight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
    private Map<CrashType, List<AttachUserData>> a = new HashMap();
    private Map<CrashType, List<AttachUserData>> b = new HashMap();
    private Map<String, String> c = new HashMap();
    private ICrashFilter d = null;

    private void c(CrashType crashType, AttachUserData attachUserData) {
        List list;
        if (this.a.get(crashType) == null) {
            list = new ArrayList();
            this.a.put(crashType, list);
        } else {
            list = this.a.get(crashType);
        }
        list.add(attachUserData);
    }

    private void d(CrashType crashType, AttachUserData attachUserData) {
        List list;
        if (this.b.get(crashType) == null) {
            list = new ArrayList();
            this.b.put(crashType, list);
        } else {
            list = this.b.get(crashType);
        }
        list.add(attachUserData);
    }

    private void e(CrashType crashType, AttachUserData attachUserData) {
        List list = this.a.get(crashType);
        if (list != null) {
            list.remove(attachUserData);
        }
    }

    private void f(CrashType crashType, AttachUserData attachUserData) {
        List list = this.b.get(crashType);
        if (list != null) {
            list.remove(attachUserData);
        }
    }

    public List<AttachUserData> a(CrashType crashType) {
        return this.a.get(crashType);
    }

    public Map<String, String> a() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void a(AttachUserData attachUserData, CrashType crashType) {
        if (crashType == CrashType.ALL) {
            c(CrashType.LAUNCH, attachUserData);
            c(CrashType.JAVA, attachUserData);
            c(CrashType.CUSTOM_JAVA, attachUserData);
            c(CrashType.NATIVE, attachUserData);
            c(CrashType.ANR, attachUserData);
            crashType = CrashType.DART;
        }
        c(crashType, attachUserData);
    }

    /* access modifiers changed from: package-private */
    public void a(CrashType crashType, AttachUserData attachUserData) {
        if (crashType == CrashType.ALL) {
            e(CrashType.LAUNCH, attachUserData);
            e(CrashType.JAVA, attachUserData);
            e(CrashType.CUSTOM_JAVA, attachUserData);
            e(CrashType.NATIVE, attachUserData);
            e(CrashType.ANR, attachUserData);
            crashType = CrashType.DART;
        }
        e(crashType, attachUserData);
    }

    /* access modifiers changed from: package-private */
    public void a(ICrashFilter iCrashFilter) {
        this.d = iCrashFilter;
    }

    /* access modifiers changed from: package-private */
    public void a(Map<? extends String, ? extends String> map) {
        this.c.putAll(map);
    }

    public ICrashFilter b() {
        return this.d;
    }

    public List<AttachUserData> b(CrashType crashType) {
        return this.b.get(crashType);
    }

    /* access modifiers changed from: package-private */
    public void b(AttachUserData attachUserData, CrashType crashType) {
        if (crashType == CrashType.ALL) {
            d(CrashType.LAUNCH, attachUserData);
            d(CrashType.JAVA, attachUserData);
            d(CrashType.CUSTOM_JAVA, attachUserData);
            d(CrashType.NATIVE, attachUserData);
            d(CrashType.ANR, attachUserData);
            crashType = CrashType.DART;
        }
        d(crashType, attachUserData);
    }

    /* access modifiers changed from: package-private */
    public void b(CrashType crashType, AttachUserData attachUserData) {
        if (crashType == CrashType.ALL) {
            f(CrashType.LAUNCH, attachUserData);
            f(CrashType.JAVA, attachUserData);
            f(CrashType.CUSTOM_JAVA, attachUserData);
            f(CrashType.NATIVE, attachUserData);
            f(CrashType.ANR, attachUserData);
            crashType = CrashType.DART;
        }
        f(crashType, attachUserData);
    }
}
