package com.bykv.vk.openvk.component.video.api.c;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* compiled from: VideoUrlModel */
public class c implements Serializable {
    public String a;
    public int b;
    public final HashMap<String, Object> c = new HashMap<>();
    private b d;
    private b e;
    private String f;
    private int g = 204800;
    private String h;
    private int i;
    private int j;
    private List<String> k;
    private String l;
    private long m;
    private boolean n;
    private boolean o;
    private int p = 0;
    private int q = 0;
    private int r = 10000;
    private int s = 10000;
    private int t = 10000;
    private int u = 0;

    public c(String str, b bVar, b bVar2, int i2, int i3) {
        this.f = str;
        this.d = bVar;
        this.e = bVar2;
        this.p = i2;
        this.q = i3;
    }

    public String a() {
        return this.f;
    }

    public void a(String str) {
        this.f = str;
    }

    public int b() {
        if (j()) {
            return this.e.m();
        }
        b bVar = this.d;
        if (bVar != null) {
            return bVar.m();
        }
        return 0;
    }

    public boolean c() {
        return this.o;
    }

    public void b(String str) {
        this.h = str;
    }

    public int d() {
        return this.i;
    }

    public void a(int i2) {
        this.i = i2;
    }

    public int e() {
        return this.j;
    }

    public void b(int i2) {
        this.j = i2;
    }

    public void a(List<String> list) {
        this.k = list;
    }

    public void c(String str) {
        this.l = str;
    }

    public long f() {
        return this.m;
    }

    public void a(long j2) {
        this.m = j2;
    }

    public boolean g() {
        return this.n;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public long h() {
        if (j()) {
            return this.e.e();
        }
        b bVar = this.d;
        if (bVar != null) {
            return bVar.e();
        }
        return 0;
    }

    public boolean i() {
        if (j()) {
            return this.e.t();
        }
        b bVar = this.d;
        if (bVar != null) {
            return bVar.t();
        }
        return true;
    }

    public void d(String str) {
        this.a = str;
    }

    public void c(int i2) {
        this.b = i2;
    }

    public boolean j() {
        return this.p == 1 && this.q == 1 && this.e != null;
    }

    public String k() {
        if (j()) {
            return this.e.i();
        }
        b bVar = this.d;
        if (bVar != null) {
            return bVar.i();
        }
        return null;
    }

    public String l() {
        if (j()) {
            return this.e.l();
        }
        b bVar = this.d;
        if (bVar != null) {
            return bVar.l();
        }
        return null;
    }

    public int m() {
        return this.p;
    }

    public synchronized void a(String str, Object obj) {
        this.c.put(str, obj);
    }

    public synchronized Object e(String str) {
        return this.c.get(str);
    }

    public int n() {
        return this.r;
    }

    public void d(int i2) {
        this.r = i2;
    }

    public int o() {
        return this.s;
    }

    public void e(int i2) {
        this.s = i2;
    }

    public int p() {
        return this.t;
    }

    public void f(int i2) {
        this.t = i2;
    }

    public int q() {
        return this.u;
    }

    public void g(int i2) {
        this.u = i2;
    }

    public b r() {
        return this.d;
    }

    public b s() {
        return this.e;
    }
}
