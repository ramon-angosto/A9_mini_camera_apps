package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.h;
import com.mbridge.msdk.MBridgeConstans;

public final class t {
    private String a = null;
    private int b = -1;

    public t(Context context) {
    }

    public String a() {
        if (!TextUtils.isEmpty(this.a) && !MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(this.a)) {
            return this.a;
        }
        this.a = h.a().d();
        if (!TextUtils.isEmpty(this.a) && !MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(this.a)) {
            return this.a;
        }
        this.a = s.a().b();
        return this.a;
    }

    public void a(String str) {
        this.a = str;
        s.a().b(str);
    }

    public boolean b() {
        return this.a != null;
    }
}
