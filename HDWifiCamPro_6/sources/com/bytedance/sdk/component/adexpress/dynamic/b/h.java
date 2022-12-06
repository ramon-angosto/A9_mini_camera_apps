package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DynamicLayoutUnit */
public class h {
    private String a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private e i;
    private List<h> j;
    private h k;
    private List<List<h>> l;
    private String m;

    public String a() {
        return this.m;
    }

    public void a(String str) {
        this.m = str;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public float c() {
        return this.d;
    }

    public void a(float f2) {
        this.d = f2;
    }

    public float d() {
        return this.e;
    }

    public void b(float f2) {
        this.e = f2;
    }

    public float e() {
        return this.b;
    }

    public void c(float f2) {
        this.b = f2;
    }

    public float f() {
        return this.c;
    }

    public void d(float f2) {
        this.c = f2;
    }

    public float g() {
        return this.f;
    }

    public void e(float f2) {
        this.f = f2;
    }

    public float h() {
        return this.g;
    }

    public void f(float f2) {
        this.g = f2;
    }

    public void g(float f2) {
        this.h = f2;
    }

    public e i() {
        return this.i;
    }

    public void a(e eVar) {
        this.i = eVar;
    }

    public List<h> j() {
        return this.j;
    }

    public void a(List<h> list) {
        this.j = list;
    }

    public void a(h hVar) {
        this.k = hVar;
    }

    public h k() {
        return this.k;
    }

    public int l() {
        f e2 = this.i.e();
        return e2.F() + e2.G();
    }

    public int m() {
        f e2 = this.i.e();
        return e2.D() + e2.E();
    }

    public float n() {
        f e2 = this.i.e();
        return ((float) l()) + e2.i() + e2.j() + (e2.f() * 2.0f);
    }

    public float o() {
        f e2 = this.i.e();
        return ((float) m()) + e2.k() + e2.h() + (e2.f() * 2.0f);
    }

    public void b(List<List<h>> list) {
        this.l = list;
    }

    public List<List<h>> p() {
        return this.l;
    }

    public boolean q() {
        List<h> list = this.j;
        return list == null || list.size() <= 0;
    }

    public void r() {
        List<List<h>> list = this.l;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (List next : this.l) {
                if (next != null && next.size() > 0) {
                    arrayList.add(next);
                }
            }
            this.l = arrayList;
        }
    }

    public boolean s() {
        return TextUtils.equals(this.i.e().u(), "flex");
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.a + '\'' + ", x=" + this.b + ", y=" + this.c + ", width=" + this.f + ", height=" + this.g + ", remainWidth=" + this.h + ", rootBrick=" + this.i + ", childrenBrickUnits=" + this.j + '}';
    }

    public boolean t() {
        return this.i.e().Z() < 0 || this.i.e().aa() < 0 || this.i.e().X() < 0 || this.i.e().Y() < 0;
    }

    public String a(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.i.b());
        sb.append(":");
        sb.append(this.a);
        if (this.i.e() != null) {
            sb.append(":");
            sb.append(this.i.e().ag());
        }
        sb.append(":");
        sb.append(i2);
        return sb.toString();
    }
}
