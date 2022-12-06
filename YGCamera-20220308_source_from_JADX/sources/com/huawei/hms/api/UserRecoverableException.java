package com.huawei.hms.api;

import android.content.Intent;

public class UserRecoverableException extends Exception {

    /* renamed from: a */
    private final Intent f339a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f339a = intent;
    }

    public Intent getIntent() {
        return new Intent(this.f339a);
    }
}
