package com.apm.insight.j;

import android.os.Handler;
import android.text.TextUtils;
import com.apm.insight.h;
import com.apm.insight.l.q;
import com.mbridge.msdk.MBridgeConstans;

public class c extends a {
    c(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    public void run() {
        String str;
        if (!h.c().b()) {
            String d = h.a().d();
            if (TextUtils.isEmpty(d) || MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(d)) {
                a(c());
                str = "[DeviceIdTask] did is null, continue check.";
            } else {
                h.c().a(d);
                str = "[DeviceIdTask] did is " + d;
            }
            q.a((Object) str);
        }
    }
}
