package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.video.signal.h;

/* compiled from: DefaultJSRewardVideoV1 */
public class f implements h {
    public String a() {
        q.a("js", "getEndScreenInfo");
        return "{}";
    }

    public void notifyCloseBtn(int i) {
        q.a("js", "notifyCloseBtn,state=" + i);
    }

    public void toggleCloseBtn(int i) {
        q.a("js", "toggleCloseBtn,state=" + i);
    }

    public void a(String str) {
        q.a("js", "triggerCloseBtn,state=" + str);
    }

    public void b(String str) {
        q.a("js", "setOrientation,landscape=" + str);
    }

    public void c(String str) {
        q.a("js", "handlerPlayableException，msg=" + str);
    }
}
