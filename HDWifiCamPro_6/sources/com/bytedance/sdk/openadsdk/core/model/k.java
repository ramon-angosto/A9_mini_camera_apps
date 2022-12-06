package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;

/* compiled from: Image */
public class k {
    private String a;
    private int b;
    private int c;
    private double d;
    private boolean e;
    private String f;

    public static TTImage a(k kVar) {
        if (kVar == null || !kVar.e()) {
            return null;
        }
        return new TTImage(kVar.c(), kVar.b(), kVar.a(), kVar.d());
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.c = i;
    }

    public void b(String str) {
        this.f = str;
    }

    public int c() {
        return this.c;
    }

    public double d() {
        return this.d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.a) && this.b > 0 && this.c > 0;
    }

    public boolean f() {
        return this.e;
    }

    public String g() {
        return this.f;
    }
}
