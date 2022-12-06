package com.huawei.android.pushselfshow.richpush.html;

import com.meizu.cloud.pushsdk.constants.PushConstants;

class f implements Runnable {
    final /* synthetic */ HtmlViewer a;

    f(HtmlViewer htmlViewer) {
        this.a = htmlViewer;
    }

    public void run() {
        HtmlViewer htmlViewer = this.a;
        if (htmlViewer.b(htmlViewer.d) < 1000) {
            this.a.f.b();
        } else {
            this.a.b.sendEmptyMessage(PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE);
        }
    }
}
