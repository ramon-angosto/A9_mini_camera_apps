package com.huawei.android.pushagent.a;

public class c extends Exception {
    public a a;

    public enum a {
        Err_unKnown,
        Err_Device,
        Err_Connect,
        Err_Read
    }

    public c() {
        this.a = a.Err_unKnown;
    }

    public c(String str) {
        super(str);
        this.a = a.Err_unKnown;
    }

    public c(String str, a aVar) {
        this(str);
        this.a = aVar;
    }

    public c(Throwable th) {
        super(th);
        this.a = a.Err_unKnown;
    }

    public c(Throwable th, a aVar) {
        this(th);
        this.a = aVar;
    }
}
