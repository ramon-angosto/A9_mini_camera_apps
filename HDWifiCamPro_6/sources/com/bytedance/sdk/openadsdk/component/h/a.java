package com.bytedance.sdk.openadsdk.component.h;

import com.bytedance.sdk.component.utils.l;

/* compiled from: OpenAdDisplayStat */
public final class a {
    private float a;
    private long b;

    public float a() {
        return this.a;
    }

    public void a(float f) {
        l.a("OpenAdDisplayStat", "open_ad", "setTotalTime() called with: time = [" + f + "]");
        this.a = f;
    }

    public long b() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }
}
