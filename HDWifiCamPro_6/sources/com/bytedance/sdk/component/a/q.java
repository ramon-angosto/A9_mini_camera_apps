package com.bytedance.sdk.component.a;

import android.text.TextUtils;

/* compiled from: Js2JavaCall */
public class q {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public static a a() {
        return new a();
    }

    public static q a(String str, int i) {
        return new q(str, i);
    }

    private q(String str, int i) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = str;
        this.g = null;
        this.a = i;
        this.h = null;
    }

    private q(a aVar) {
        this.b = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.a = 1;
        this.h = aVar.g;
    }

    public static boolean a(q qVar) {
        if (qVar == null || qVar.a != 1 || TextUtils.isEmpty(qVar.d) || TextUtils.isEmpty(qVar.e)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "methodName: " + this.d + ", params: " + this.e + ", callbackId: " + this.f + ", type: " + this.c + ", version: " + this.b + ", ";
    }

    /* compiled from: Js2JavaCall */
    public static final class a {
        /* access modifiers changed from: private */
        public String a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public String e;
        /* access modifiers changed from: private */
        public String f;
        /* access modifiers changed from: private */
        public String g;

        private a() {
        }

        public a a(String str) {
            this.a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a d(String str) {
            this.d = str;
            return this;
        }

        public a e(String str) {
            this.e = str;
            return this;
        }

        public a f(String str) {
            this.f = str;
            return this;
        }

        public a g(String str) {
            this.g = str;
            return this;
        }

        public q a() {
            return new q(this);
        }
    }
}
