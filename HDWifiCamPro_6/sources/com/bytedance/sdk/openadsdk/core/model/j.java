package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import com.bytedance.sdk.component.adexpress.c;
import com.bytedance.sdk.openadsdk.core.b.c;
import org.json.JSONObject;

/* compiled from: DynamicClickInfo */
public class j implements c {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final long e;
    public final long f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final String k;
    public int l;
    public JSONObject m;
    public SparseArray<c.a> n;
    public final boolean o;
    public int p;

    private j(a aVar) {
        this.a = aVar.g;
        this.b = aVar.f;
        this.c = aVar.e;
        this.d = aVar.d;
        this.e = aVar.c;
        this.f = aVar.b;
        this.g = aVar.h;
        this.h = aVar.i;
        this.i = aVar.j;
        this.j = aVar.k;
        this.k = aVar.l;
        this.n = aVar.a;
        this.o = aVar.p;
        this.l = aVar.m;
        this.m = aVar.n;
        this.p = aVar.o;
    }

    /* compiled from: DynamicClickInfo */
    public static class a {
        protected SparseArray<c.a> a = new SparseArray<>();
        /* access modifiers changed from: private */
        public long b;
        /* access modifiers changed from: private */
        public long c;
        /* access modifiers changed from: private */
        public float d;
        /* access modifiers changed from: private */
        public float e;
        /* access modifiers changed from: private */
        public float f;
        /* access modifiers changed from: private */
        public float g;
        /* access modifiers changed from: private */
        public int h;
        /* access modifiers changed from: private */
        public int i;
        /* access modifiers changed from: private */
        public int j;
        /* access modifiers changed from: private */
        public int k;
        /* access modifiers changed from: private */
        public String l;
        /* access modifiers changed from: private */
        public int m;
        /* access modifiers changed from: private */
        public JSONObject n;
        /* access modifiers changed from: private */
        public int o;
        /* access modifiers changed from: private */
        public boolean p;

        public a a(int i2) {
            this.o = i2;
            return this;
        }

        public a b(int i2) {
            this.m = i2;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.n = jSONObject;
            return this;
        }

        public a a(boolean z) {
            this.p = z;
            return this;
        }

        public a a(long j2) {
            this.b = j2;
            return this;
        }

        public a b(long j2) {
            this.c = j2;
            return this;
        }

        public a a(float f2) {
            this.d = f2;
            return this;
        }

        public a b(float f2) {
            this.e = f2;
            return this;
        }

        public a c(float f2) {
            this.f = f2;
            return this;
        }

        public a d(float f2) {
            this.g = f2;
            return this;
        }

        public a c(int i2) {
            this.h = i2;
            return this;
        }

        public a d(int i2) {
            this.i = i2;
            return this;
        }

        public a e(int i2) {
            this.j = i2;
            return this;
        }

        public a f(int i2) {
            this.k = i2;
            return this;
        }

        public a a(String str) {
            this.l = str;
            return this;
        }

        public a a(SparseArray<c.a> sparseArray) {
            this.a = sparseArray;
            return this;
        }

        public j a() {
            return new j(this);
        }
    }
}
