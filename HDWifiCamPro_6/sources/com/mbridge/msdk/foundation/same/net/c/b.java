package com.mbridge.msdk.foundation.same.net.c;

import android.text.TextUtils;

/* compiled from: Header */
public final class b {
    private final String a;
    private final String b;

    public b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!TextUtils.equals(this.a, bVar.a) || !TextUtils.equals(this.b, bVar.b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.a + ",value=" + this.b + "]";
    }
}
