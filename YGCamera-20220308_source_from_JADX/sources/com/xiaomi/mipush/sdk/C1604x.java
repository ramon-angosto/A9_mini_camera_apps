package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* renamed from: com.xiaomi.mipush.sdk.x */
class C1604x {

    /* renamed from: a */
    int f1745a = 0;

    /* renamed from: a */
    String f1746a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1604x)) {
            return false;
        }
        C1604x xVar = (C1604x) obj;
        return !TextUtils.isEmpty(xVar.f1746a) && xVar.f1746a.equals(this.f1746a);
    }
}
