package com.huawei.hms.api;

import android.content.Intent;

public class HuaweiServicesRepairableException extends UserRecoverableException {

    /* renamed from: b */
    private final int f329b;

    public HuaweiServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.f329b = i;
    }

    public int getConnectionStatusCode() {
        return this.f329b;
    }
}
