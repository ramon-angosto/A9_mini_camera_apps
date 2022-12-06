package com.mbridge.msdk.video.signal.factory;

import com.mbridge.msdk.video.signal.a.d;
import com.mbridge.msdk.video.signal.a.g;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.h;
import com.mbridge.msdk.video.signal.i;

/* compiled from: DefaultJSFactory */
public class a implements IJSFactory {
    protected com.mbridge.msdk.video.signal.a a;
    protected c b;
    protected i c;
    protected f d;
    protected e e;
    protected h f;
    protected b g;

    public com.mbridge.msdk.video.signal.a getActivityProxy() {
        if (this.a == null) {
            this.a = new com.mbridge.msdk.video.signal.a.a();
        }
        return this.a;
    }

    public c getJSCommon() {
        if (this.b == null) {
            this.b = new com.mbridge.msdk.video.signal.a.c();
        }
        return this.b;
    }

    public i getJSVideoModule() {
        if (this.c == null) {
            this.c = new g();
        }
        return this.c;
    }

    public f getJSNotifyProxy() {
        if (this.d == null) {
            this.d = new com.mbridge.msdk.video.signal.a.e();
        }
        return this.d;
    }

    public e getJSContainerModule() {
        if (this.e == null) {
            this.e = new d();
        }
        return this.e;
    }

    public h getIJSRewardVideoV1() {
        if (this.f == null) {
            this.f = new com.mbridge.msdk.video.signal.a.f();
        }
        return this.f;
    }

    public b getJSBTModule() {
        if (this.g == null) {
            this.g = new com.mbridge.msdk.video.signal.a.b();
        }
        return this.g;
    }
}
