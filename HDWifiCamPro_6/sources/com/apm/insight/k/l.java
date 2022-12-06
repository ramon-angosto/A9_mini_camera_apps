package com.apm.insight.k;

import org.json.JSONObject;

public class l {
    private final int a;
    private String b;
    private JSONObject c;
    private byte[] d;

    public l(int i) {
        this.a = i;
    }

    public l(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public l(int i, Throwable th) {
        this.a = i;
        if (th != null) {
            this.b = th.getMessage();
        }
    }

    public l(int i, JSONObject jSONObject) {
        this.a = i;
        this.c = jSONObject;
    }

    public l(int i, byte[] bArr) {
        this.a = i;
        this.d = bArr;
    }

    public boolean a() {
        return this.a != 207;
    }

    public byte[] b() {
        return this.d;
    }
}
