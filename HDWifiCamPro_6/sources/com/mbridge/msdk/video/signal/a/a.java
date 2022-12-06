package com.mbridge.msdk.video.signal.a;

import android.content.res.Configuration;
import com.mbridge.msdk.foundation.tools.q;

/* compiled from: DefaultJSActivity */
public class a implements com.mbridge.msdk.video.signal.a {
    public void a() {
        q.a("js", "DefaultJSActivity-onPause");
    }

    public void b() {
        q.a("js", "DefaultJSActivity-onResume");
    }

    public void f() {
        q.a("js", "DefaultJSActivity-onDestory");
    }

    public final void c() {
        q.a("js", "DefaultJSActivity-onStop");
    }

    public final void d() {
        q.a("js", "DefaultJSActivity-onStart");
    }

    public final void e() {
        q.a("js", "DefaultJSActivity-onRestart");
    }

    public void a(Configuration configuration) {
        q.a("js", "DefaultJSActivity-onConfigurationChanged:" + configuration.orientation);
    }

    public void g() {
        q.a("js", "DefaultJSActivity-onBackPressed");
    }

    public int h() {
        q.a("js", "isSystemResume");
        return 0;
    }

    public void a(int i) {
        q.a("js", "setSystemResume,isResume:" + i);
    }
}
