package com.huawei.android.pushselfshow.richpush.html;

import android.app.Activity;
import com.meizu.cloud.pushsdk.constants.PushConstants;

class h implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ HtmlViewer b;

    h(HtmlViewer htmlViewer, Activity activity) {
        this.b = htmlViewer;
        this.a = activity;
    }

    public void run() {
        if (this.b.b(this.a) < 1000) {
            this.b.f.b();
        } else {
            this.b.b.sendEmptyMessage(PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE);
        }
    }
}
