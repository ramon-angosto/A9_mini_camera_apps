package com.bytedance.sdk.openadsdk.core.model;

import androidx.work.WorkRequest;

/* compiled from: LoadingInfo */
public class m {
    private long a = WorkRequest.MIN_BACKOFF_MILLIS;
    private long b = WorkRequest.MIN_BACKOFF_MILLIS;
    private String c = "";

    public long a() {
        return this.a;
    }

    public void a(long j) {
        if (j <= 0) {
            this.a = 10;
        } else {
            this.a = j;
        }
    }

    public long b() {
        return this.b;
    }

    public void b(long j) {
        if (j < 0) {
            this.b = 20;
        } else {
            this.b = j;
        }
    }

    public String c() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
