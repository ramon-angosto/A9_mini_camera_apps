package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.manager.C1528a;
import com.xiaomi.push.C1618ak;

/* renamed from: com.xiaomi.push.bq */
public class C1665bq extends C1618ak.C1619a {

    /* renamed from: a */
    private Context f1885a;

    public C1665bq(Context context) {
        this.f1885a = context;
    }

    /* renamed from: a */
    private boolean mo16986a() {
        return C1528a.m2164a(this.f1885a).mo16975a().isPerfUploadSwitchOpen();
    }

    /* renamed from: a */
    public String m2742a() {
        return "100887";
    }

    public void run() {
        try {
            if (mo16986a()) {
                C1528a.m2164a(this.f1885a).mo16983c();
                C1524b.m2159c(this.f1885a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            C1524b.m2160d("fail to send perf data. " + e);
        }
    }
}
