package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MBridgeDirContext */
public final class d extends b {
    public d(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    public final List<a> b() {
        ArrayList arrayList = new ArrayList();
        a(arrayList, c.MBRIDGE_RES_MANAGER_DIR, "mb/res");
        a(arrayList, c.AD_MOVIES, "mb/res/Movies").a(c.MBRIDGE_VC, "mb/res/.MBridge_VC");
        a a = a(arrayList, c.AD_MBRIDGE_700, "mb/res/.mbridge700");
        a.a(c.MBRIDGE_700_IMG, "mb/res/img");
        a.a(c.MBRIDGE_700_RES, "mb/res/res");
        a.a(c.MBRIDGE_700_HTML, "mb/res/html");
        a(arrayList, c.MBRIDGE_OTHER, "mb/other");
        a(arrayList, c.MBRIDGE_CRASH_INFO, "mb/crashinfo");
        a(arrayList, c.MBRIDGE_OTHER, "mb/other");
        return arrayList;
    }
}
