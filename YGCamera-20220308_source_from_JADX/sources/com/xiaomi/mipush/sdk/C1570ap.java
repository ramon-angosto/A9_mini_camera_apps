package com.xiaomi.mipush.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

/* renamed from: com.xiaomi.mipush.sdk.ap */
class C1570ap extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1568ao f1680a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1570ap(C1568ao aoVar, Looper looper) {
        super(looper);
        this.f1680a = aoVar;
    }

    public void dispatchMessage(Message message) {
        C1568ao aoVar;
        C1575au auVar;
        HashMap<String, String> a;
        C1568ao aoVar2;
        C1575au auVar2;
        if (message.what == 19) {
            String str = (String) message.obj;
            int i = message.arg1;
            synchronized (C1559af.class) {
                if (C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17125a(str)) {
                    if (C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17125a(str) < 10) {
                        if (C1575au.DISABLE_PUSH.ordinal() == i && "syncing".equals(C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17126a(C1575au.DISABLE_PUSH))) {
                            aoVar2 = this.f1680a;
                            auVar2 = C1575au.DISABLE_PUSH;
                        } else if (C1575au.ENABLE_PUSH.ordinal() != i || !"syncing".equals(C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17126a(C1575au.ENABLE_PUSH))) {
                            if (C1575au.UPLOAD_HUAWEI_TOKEN.ordinal() == i && "syncing".equals(C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17126a(C1575au.UPLOAD_HUAWEI_TOKEN))) {
                                aoVar = this.f1680a;
                                auVar = C1575au.UPLOAD_HUAWEI_TOKEN;
                                a = C1586i.m2433a(C1568ao.m2312a(this.f1680a), C1582e.ASSEMBLE_PUSH_HUAWEI);
                            } else if (C1575au.UPLOAD_FCM_TOKEN.ordinal() == i && "syncing".equals(C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17126a(C1575au.UPLOAD_FCM_TOKEN))) {
                                aoVar = this.f1680a;
                                auVar = C1575au.UPLOAD_FCM_TOKEN;
                                a = C1586i.m2433a(C1568ao.m2312a(this.f1680a), C1582e.ASSEMBLE_PUSH_FCM);
                            } else if (C1575au.UPLOAD_COS_TOKEN.ordinal() != i || !"syncing".equals(C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17126a(C1575au.UPLOAD_COS_TOKEN))) {
                                if (C1575au.UPLOAD_FTOS_TOKEN.ordinal() == i && "syncing".equals(C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17126a(C1575au.UPLOAD_FTOS_TOKEN))) {
                                    aoVar = this.f1680a;
                                    auVar = C1575au.UPLOAD_FTOS_TOKEN;
                                    a = C1586i.m2433a(C1568ao.m2312a(this.f1680a), C1582e.ASSEMBLE_PUSH_FTOS);
                                }
                                C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17128b(str);
                            } else {
                                aoVar = this.f1680a;
                                auVar = C1575au.UPLOAD_COS_TOKEN;
                                a = C1586i.m2433a(C1568ao.m2312a(this.f1680a), C1582e.ASSEMBLE_PUSH_COS);
                            }
                            aoVar.m2323a(str, auVar, false, a);
                            C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17128b(str);
                        } else {
                            aoVar2 = this.f1680a;
                            auVar2 = C1575au.ENABLE_PUSH;
                        }
                        aoVar2.m2323a(str, auVar2, true, (HashMap<String, String>) null);
                        C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17128b(str);
                    } else {
                        C1559af.m2278a(C1568ao.m2312a(this.f1680a)).mo17129c(str);
                    }
                }
            }
        }
    }
}
