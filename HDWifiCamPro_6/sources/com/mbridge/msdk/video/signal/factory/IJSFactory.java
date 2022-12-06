package com.mbridge.msdk.video.signal.factory;

import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.h;
import com.mbridge.msdk.video.signal.i;

public interface IJSFactory {
    a getActivityProxy();

    h getIJSRewardVideoV1();

    b getJSBTModule();

    c getJSCommon();

    e getJSContainerModule();

    f getJSNotifyProxy();

    i getJSVideoModule();
}
