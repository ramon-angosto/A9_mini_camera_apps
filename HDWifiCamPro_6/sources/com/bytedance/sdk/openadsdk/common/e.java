package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.m;

/* compiled from: LandingPageLoadingStyle */
public abstract class e {
    protected final k b;
    protected String c;
    protected String[] d;
    protected View e;
    protected Context f;
    protected m g;

    /* access modifiers changed from: protected */
    public abstract void a();

    public abstract void a(int i);

    public abstract void b();

    public abstract void c();

    public e(Context context, String str, String[] strArr, k kVar, m mVar) {
        this.c = str;
        this.d = strArr;
        this.f = context;
        this.b = kVar;
        this.g = mVar;
        a();
    }

    public View e() {
        return this.e;
    }

    public void d() {
        c();
        this.e = null;
        this.f = null;
    }
}
