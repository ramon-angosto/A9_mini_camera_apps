package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.IntentFilter;
import com.mbridge.msdk.advanced.common.NetWorkStateReceiver;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

public class MBNativeAdvancedWebview extends WindVaneWebView {
    private static final String e = MBNativeAdvancedWebview.class.getSimpleName();
    private NetWorkStateReceiver f;

    public MBNativeAdvancedWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerNetWorkReceiver();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterNetWorkReceiver();
    }

    public void registerNetWorkReceiver() {
        try {
            if (this.f == null) {
                this.f = new NetWorkStateReceiver(this);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getContext().registerReceiver(this.f, intentFilter);
        } catch (Throwable th) {
            q.a(e, th.getMessage());
        }
    }

    public void unregisterNetWorkReceiver() {
        try {
            if (this.f != null) {
                this.f.a();
                getContext().unregisterReceiver(this.f);
            }
        } catch (Throwable th) {
            q.a(e, th.getMessage());
        }
    }
}
