package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.opendevice.j */
/* compiled from: AAIDCallable */
public class C0856j implements Callable<AAIDResult> {

    /* renamed from: a */
    public Context f795a;

    public C0856j(Context context) {
        this.f795a = context;
    }

    public AAIDResult call() throws Exception {
        Context context = this.f795a;
        if (context != null) {
            String c = C0863o.m1173c(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(c);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
