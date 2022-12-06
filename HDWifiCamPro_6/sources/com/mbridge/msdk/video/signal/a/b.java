package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;

/* compiled from: DefaultJSBTModule */
public class b implements com.mbridge.msdk.video.signal.b {
    private static final String a = b.class.getSimpleName();

    public void click(int i, String str) {
        q.a(a, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
    }

    public void handlerH5Exception(int i, String str) {
        q.a(a, "handlerH5Exception");
    }

    public void reactDeveloper(Object obj, String str) {
        q.a(a, "reactDeveloper");
    }
}
