package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* renamed from: com.huawei.hms.base.log.d */
/* compiled from: LogCatNode */
public class C0687d implements C0685b {

    /* renamed from: a */
    public C0685b f432a;

    /* renamed from: a */
    public void mo13319a(Context context, String str) {
        C0685b bVar = this.f432a;
        if (bVar != null) {
            bVar.mo13319a(context, str);
        }
    }

    /* renamed from: a */
    public void mo13320a(String str, int i, String str2, String str3) {
        Log.println(i, "HMSSDK_" + str2, str3);
        C0685b bVar = this.f432a;
        if (bVar != null) {
            bVar.mo13320a(str, i, str2, str3);
        }
    }
}
