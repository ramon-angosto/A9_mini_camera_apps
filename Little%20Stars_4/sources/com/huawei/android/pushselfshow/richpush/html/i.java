package com.huawei.android.pushselfshow.richpush.html;

import android.app.Activity;
import android.content.DialogInterface;
import com.huawei.android.pushagent.c.a.e;

class i implements DialogInterface.OnDismissListener {
    final /* synthetic */ Activity a;
    final /* synthetic */ HtmlViewer b;

    i(HtmlViewer htmlViewer, Activity activity) {
        this.b = htmlViewer;
        this.a = activity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        e.a("PushSelfShowLog", "DialogInterface onDismiss,mClickDialogOkBtn:" + this.b.r);
        if (this.b.r) {
            this.b.d(this.a);
            return;
        }
        this.b.o.b(this.b.m);
        boolean unused = this.b.u = false;
    }
}
