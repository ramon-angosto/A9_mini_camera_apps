package com.mbridge.msdk.mbsignalcommon.base;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.controller.a;

/* compiled from: IntentFilter */
public final class c implements a {
    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equals("intent")) {
            return false;
        }
        return b.d(a.e().g(), str);
    }
}
