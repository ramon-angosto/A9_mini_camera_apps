package com.huawei.hms.p023ui;

import android.os.Bundle;
import com.huawei.hms.base.p013ui.C0690a;

/* renamed from: com.huawei.hms.ui.SafeBundle */
public class SafeBundle {

    /* renamed from: a */
    public final Bundle f998a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f998a.containsKey(str);
        } catch (Exception unused) {
            C0690a.m416a("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f998a.get(str);
        } catch (Exception e) {
            C0690a.m417a("SafeBundle", "get exception: " + e.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f998a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f998a.getString(str);
        } catch (Exception e) {
            C0690a.m417a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f998a.isEmpty();
        } catch (Exception unused) {
            C0690a.m416a("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f998a.size();
        } catch (Exception unused) {
            C0690a.m416a("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f998a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f998a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i) {
        try {
            return this.f998a.getInt(str, i);
        } catch (Exception e) {
            C0690a.m417a("SafeBundle", "getInt exception: " + e.getMessage(), true);
            return i;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f998a.getString(str, str2);
        } catch (Exception e) {
            C0690a.m417a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return str2;
        }
    }
}
