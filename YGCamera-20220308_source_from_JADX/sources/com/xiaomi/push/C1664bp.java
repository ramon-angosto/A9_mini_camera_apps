package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.manager.C1528a;
import com.xiaomi.push.C1618ak;

/* renamed from: com.xiaomi.push.bp */
public class C1664bp extends C1618ak.C1619a {

    /* renamed from: a */
    private Context f1884a;

    public C1664bp(Context context) {
        this.f1884a = context;
    }

    /* renamed from: a */
    private boolean mo16986a() {
        return C1528a.m2164a(this.f1884a).mo16975a().isEventUploadSwitchOpen();
    }

    /* renamed from: a */
    public String m2740a() {
        return "100886";
    }

    public void run() {
        try {
            if (mo16986a()) {
                C1524b.m2159c(this.f1884a.getPackageName() + " begin upload event");
                C1528a.m2164a(this.f1884a).mo16982b();
            }
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
        }
    }
}
