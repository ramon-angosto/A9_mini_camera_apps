package com.bytedance.sdk.component.b.a;

import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: OkHttpClient */
public abstract class i implements Cloneable {
    public List<g> a;
    public long b;
    public TimeUnit c;
    public long d;
    public TimeUnit e;
    public long f;
    public TimeUnit g;

    public abstract b a(k kVar);

    public abstract d a();

    public i(a aVar) {
        this.b = aVar.b;
        this.d = aVar.d;
        this.f = aVar.f;
        this.a = aVar.a;
        this.c = aVar.c;
        this.e = aVar.e;
        this.g = aVar.g;
        this.a = aVar.a;
    }

    /* compiled from: OkHttpClient */
    public static final class a {
        public final List<g> a = new ArrayList();
        public long b = WorkRequest.MIN_BACKOFF_MILLIS;
        public TimeUnit c = TimeUnit.MILLISECONDS;
        public long d = WorkRequest.MIN_BACKOFF_MILLIS;
        public TimeUnit e = TimeUnit.MILLISECONDS;
        public long f = WorkRequest.MIN_BACKOFF_MILLIS;
        public TimeUnit g = TimeUnit.MILLISECONDS;

        public a() {
        }

        public a(String str) {
        }

        public a(i iVar) {
            this.b = iVar.b;
            this.c = iVar.c;
            this.d = iVar.d;
            this.e = iVar.e;
            this.f = iVar.f;
            this.g = iVar.g;
        }

        public a a(long j, TimeUnit timeUnit) {
            this.b = j;
            this.c = timeUnit;
            return this;
        }

        public a b(long j, TimeUnit timeUnit) {
            this.d = j;
            this.e = timeUnit;
            return this;
        }

        public a c(long j, TimeUnit timeUnit) {
            this.f = j;
            this.g = timeUnit;
            return this;
        }

        public a a(g gVar) {
            this.a.add(gVar);
            return this;
        }

        public i a() {
            return com.bytedance.sdk.component.b.a.a.a.a(this);
        }
    }

    public a b() {
        return new a(this);
    }
}
