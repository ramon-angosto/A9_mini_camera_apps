package com.xiaomi.push;

import com.xiaomi.push.C1685ci;

/* renamed from: com.xiaomi.push.ce */
public class C1681ce extends C1685ci.C1689d {

    /* renamed from: a */
    protected String f1917a = "MessageDeleteJob";

    public C1681ce(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f1917a = str3;
    }

    /* renamed from: a */
    public static C1681ce m2833a(String str) {
        return new C1681ce(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
