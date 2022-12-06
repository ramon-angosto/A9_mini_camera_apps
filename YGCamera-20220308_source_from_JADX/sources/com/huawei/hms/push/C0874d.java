package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.d */
/* compiled from: TokenUtil */
public class C0874d {
    /* renamed from: a */
    public static ErrorEnum m1219a(Context context) {
        if (!TextUtils.isEmpty(BaseUtils.getLocalToken(context, (String) null))) {
            return ErrorEnum.SUCCESS;
        }
        if (AutoInitHelper.isAutoInitEnabled(context)) {
            HMSLog.m1377e("TokenUtil", "Token not exist, try auto init");
            AutoInitHelper.doAutoInit(context);
            return ErrorEnum.ERROR_AUTO_INITIALIZING;
        }
        HMSLog.m1377e("TokenUtil", "Token not exist");
        return ErrorEnum.ERROR_NO_TOKEN;
    }
}
