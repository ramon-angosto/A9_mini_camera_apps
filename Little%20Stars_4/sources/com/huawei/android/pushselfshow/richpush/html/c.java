package com.huawei.android.pushselfshow.richpush.html;

import android.view.MotionEvent;
import android.view.View;
import com.huawei.android.pushagent.c.a.e;

class c implements View.OnTouchListener {
    final /* synthetic */ HtmlViewer a;

    c(HtmlViewer htmlViewer) {
        this.a = htmlViewer;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a.e == null || !this.a.e.requestFocus()) {
            return false;
        }
        e.e("PushSelfShowLog", "webView.requestFocus");
        return false;
    }
}
