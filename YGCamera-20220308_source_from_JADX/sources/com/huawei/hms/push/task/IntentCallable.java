package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

public class IntentCallable implements Callable<Void> {

    /* renamed from: a */
    public Context f927a;

    /* renamed from: b */
    public Intent f928b;

    /* renamed from: c */
    public String f929c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f927a = context;
        this.f928b = intent;
        this.f929c = str;
    }

    public Void call() throws Exception {
        this.f927a.sendBroadcast(this.f928b);
        PushBiUtil.reportExit(this.f927a, PushNaming.SET_NOTIFY_FLAG, this.f929c, ErrorEnum.SUCCESS);
        return null;
    }
}
