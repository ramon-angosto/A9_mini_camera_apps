package com.mbridge.msdk.video.signal.activity;

import android.content.res.Configuration;
import com.mbridge.msdk.activity.MBBaseActivity;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.h;
import com.mbridge.msdk.video.signal.i;

public abstract class AbstractJSActivity extends MBBaseActivity implements IJSFactory {
    protected static final String TAG = "AbstractJSActivity";
    protected IJSFactory jsFactory = new a();

    public boolean canBackPress() {
        return false;
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.jsFactory = iJSFactory;
    }

    public void onResume() {
        super.onResume();
        if (!b.c) {
            if (getJSCommon().b()) {
                getActivityProxy().b();
            }
            getActivityProxy().a(0);
        }
    }

    public void onPause() {
        super.onPause();
        if (getJSCommon().b()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getJSCommon().b()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onBackPressed() {
        if (getJSCommon().b()) {
            if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                getActivityProxy().g();
            }
        } else if (canBackPress()) {
            super.onBackPressed();
        } else {
            q.a(TAG, "onBackPressed can't excute");
        }
    }

    public com.mbridge.msdk.video.signal.a getActivityProxy() {
        return this.jsFactory.getActivityProxy();
    }

    public c getJSCommon() {
        return this.jsFactory.getJSCommon();
    }

    public i getJSVideoModule() {
        return this.jsFactory.getJSVideoModule();
    }

    public f getJSNotifyProxy() {
        return this.jsFactory.getJSNotifyProxy();
    }

    public e getJSContainerModule() {
        return this.jsFactory.getJSContainerModule();
    }

    public h getIJSRewardVideoV1() {
        return this.jsFactory.getIJSRewardVideoV1();
    }

    public com.mbridge.msdk.video.signal.b getJSBTModule() {
        return this.jsFactory.getJSBTModule();
    }
}
