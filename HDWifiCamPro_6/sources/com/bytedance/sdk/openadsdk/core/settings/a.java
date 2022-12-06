package com.bytedance.sdk.openadsdk.core.settings;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: AdSlotSetter */
public class a {
    public int A = 5;
    public String a;
    public int b = 1;
    public int c = 1;
    public int d = 2;
    public int e = 1;
    public int f = 100;
    public int g = 0;
    public int h = 2;
    public int i = 1;
    public int j = 3;
    public int k = -1;
    public int l = 1;
    public int m = 1;
    public int n = 2;
    public int o = 1500;
    public int p = 2;
    public int q = -1;
    public int r = 0;
    public int s = 5;
    public boolean t = false;
    public int u = 0;
    public List<String> v;
    public int w = 2;
    public int x = -1;
    public int y = 0;
    public int z = 0;

    public static a a() {
        return new a();
    }

    private a() {
    }

    public a a(int i2) {
        this.x = i2;
        return this;
    }

    public a b(int i2) {
        this.r = i2;
        return this;
    }

    public a c(int i2) {
        this.u = i2;
        return this;
    }

    public a d(int i2) {
        this.q = i2;
        return this;
    }

    public a e(int i2) {
        this.n = i2;
        return this;
    }

    public a f(int i2) {
        this.o = i2;
        return this;
    }

    public a g(int i2) {
        this.p = i2;
        return this;
    }

    public a h(int i2) {
        this.l = i2;
        return this;
    }

    public a i(int i2) {
        this.k = i2;
        return this;
    }

    public a j(int i2) {
        this.j = i2;
        return this;
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public a k(int i2) {
        this.b = i2;
        return this;
    }

    public a l(int i2) {
        this.c = i2;
        return this;
    }

    public a m(int i2) {
        this.d = i2;
        return this;
    }

    public a n(int i2) {
        this.e = i2;
        return this;
    }

    public a o(int i2) {
        this.f = i2;
        return this;
    }

    public a p(int i2) {
        this.g = i2;
        return this;
    }

    public a q(int i2) {
        this.h = i2;
        return this;
    }

    public a r(int i2) {
        this.i = i2;
        return this;
    }

    public a s(int i2) {
        this.m = i2;
        return this;
    }

    public a t(int i2) {
        this.w = i2;
        return this;
    }

    public a a(JSONArray jSONArray) {
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            this.v = new ArrayList();
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                try {
                    this.v.add(jSONArray.get(i2).toString());
                    i2++;
                } catch (Exception unused) {
                }
            }
        }
        return this;
    }

    public a u(int i2) {
        this.s = i2;
        return this;
    }

    public a a(boolean z2) {
        this.t = z2;
        return this;
    }

    public a v(int i2) {
        this.y = i2;
        return this;
    }

    public a w(int i2) {
        this.z = i2;
        return this;
    }

    public a x(int i2) {
        this.A = i2;
        return this;
    }
}
