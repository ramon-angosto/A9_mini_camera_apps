package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

public class BaseException extends Exception {

    /* renamed from: a */
    public final int f825a = this.f826b.getExternalCode();

    /* renamed from: b */
    public final ErrorEnum f826b;

    public BaseException(int i) {
        this.f826b = ErrorEnum.fromCode(i);
    }

    public int getErrorCode() {
        return this.f825a;
    }

    public String getMessage() {
        return this.f826b.getMessage();
    }
}
