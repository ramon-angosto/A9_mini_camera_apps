package com.bytedance.sdk.component.d.c;

import android.content.Context;
import com.bytedance.sdk.component.d.b;
import com.bytedance.sdk.component.d.c;
import com.bytedance.sdk.component.d.d;
import com.bytedance.sdk.component.d.l;
import com.bytedance.sdk.component.d.m;
import com.bytedance.sdk.component.d.p;
import com.bytedance.sdk.component.d.q;
import com.bytedance.sdk.component.d.r;
import java.util.concurrent.ExecutorService;

/* compiled from: LoadConfig */
public class e implements m {
    private l a;
    private ExecutorService b;
    private d c;
    private q d;
    private r e;
    private c f;
    private p g;
    private b h;

    private e(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.h = aVar.h;
        this.g = aVar.g;
    }

    public l a() {
        return this.a;
    }

    public ExecutorService b() {
        return this.b;
    }

    public d c() {
        return this.c;
    }

    public q d() {
        return this.d;
    }

    public r e() {
        return this.e;
    }

    public c f() {
        return this.f;
    }

    public p g() {
        return this.g;
    }

    public b h() {
        return this.h;
    }

    public static e a(Context context) {
        return new a().a();
    }

    /* compiled from: LoadConfig */
    public static class a {
        /* access modifiers changed from: private */
        public l a;
        /* access modifiers changed from: private */
        public ExecutorService b;
        /* access modifiers changed from: private */
        public d c;
        /* access modifiers changed from: private */
        public q d;
        /* access modifiers changed from: private */
        public r e;
        /* access modifiers changed from: private */
        public c f;
        /* access modifiers changed from: private */
        public p g;
        /* access modifiers changed from: private */
        public b h;

        public a a(b bVar) {
            this.h = bVar;
            return this;
        }

        public a a(ExecutorService executorService) {
            this.b = executorService;
            return this;
        }

        public a a(d dVar) {
            this.c = dVar;
            return this;
        }

        public e a() {
            return new e(this);
        }
    }
}
