package com.huawei.secure.android.common.util;

/* renamed from: com.huawei.secure.android.common.util.a */
public class C0952a {
    private int index = 0;
    private int mark = 0;

    /* renamed from: q */
    private String f1280q;

    /* renamed from: r */
    private Character f1281r;

    /* renamed from: s */
    private Character f1282s;

    public C0952a(String str) {
        this.f1280q = str;
    }

    /* renamed from: a */
    public void mo14817a(Character ch) {
        this.f1281r = ch;
    }

    /* renamed from: a */
    public int mo14816a() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.f1281r != null) {
            return true;
        }
        String str = this.f1280q;
        if (str == null || str.length() == 0 || this.index >= this.f1280q.length()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public Character mo14818b() {
        Character ch = this.f1281r;
        if (ch != null) {
            this.f1281r = null;
            return ch;
        }
        String str = this.f1280q;
        if (str == null || str.length() == 0 || this.index >= this.f1280q.length()) {
            return null;
        }
        String str2 = this.f1280q;
        int i = this.index;
        this.index = i + 1;
        return Character.valueOf(str2.charAt(i));
    }

    /* renamed from: c */
    public Character mo14819c() {
        Character b = mo14818b();
        if (b != null && m1651b(b)) {
            return b;
        }
        return null;
    }

    /* renamed from: d */
    public Character mo14821d() {
        Character b = mo14818b();
        if (b != null && m1652c(b)) {
            return b;
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m1651b(Character ch) {
        if (ch == null) {
            return false;
        }
        char charValue = ch.charValue();
        return (charValue >= '0' && charValue <= '9') || (charValue >= 'a' && charValue <= 'f') || (charValue >= 'A' && charValue <= 'F');
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r2 = r2.charValue();
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m1652c(java.lang.Character r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            char r2 = r2.charValue()
            r1 = 48
            if (r2 < r1) goto L_0x0011
            r1 = 55
            if (r2 > r1) goto L_0x0011
            r0 = 1
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.C0952a.m1652c(java.lang.Character):boolean");
    }

    /* renamed from: e */
    public Character mo14822e() {
        Character ch = this.f1281r;
        if (ch != null) {
            return ch;
        }
        String str = this.f1280q;
        if (str == null || str.length() == 0 || this.index >= this.f1280q.length()) {
            return null;
        }
        return Character.valueOf(this.f1280q.charAt(this.index));
    }

    /* renamed from: c */
    public boolean mo14820c(char c) {
        Character ch = this.f1281r;
        if (ch != null && ch.charValue() == c) {
            return true;
        }
        String str = this.f1280q;
        if (str != null && str.length() != 0 && this.index < this.f1280q.length() && this.f1280q.charAt(this.index) == c) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public void mo14823f() {
        this.f1282s = this.f1281r;
        this.mark = this.index;
    }

    public void reset() {
        this.f1281r = this.f1282s;
        this.index = this.mark;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public String mo14824g() {
        String substring = this.f1280q.substring(this.index);
        if (this.f1281r == null) {
            return substring;
        }
        return this.f1281r + substring;
    }
}
