package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.service.C1999aw;

public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        C1894in inVar = new C1894in();
        inVar.mo18087c(C1878hy.VRUpload.f2959a);
        inVar.mo18084b(C1578b.m2373a(context).mo17163a());
        inVar.mo18091d(context.getPackageName());
        inVar.mo18083a(RemoteMessageConst.DATA, str);
        inVar.mo18078a(C1999aw.m5064a());
        C1568ao.m2317a(context).mo17141a(inVar, C1868ho.Notification, (C1882ib) null);
    }
}
