package com.huawei.android.pushagent;

public class PushException extends RuntimeException {
    public PushException() {
    }

    public PushException(String str) {
        super(str);
    }

    public PushException(String str, Throwable th) {
        super(str, th);
    }

    public PushException(Throwable th) {
        super(th);
    }
}
