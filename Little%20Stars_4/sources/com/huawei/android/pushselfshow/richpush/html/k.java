package com.huawei.android.pushselfshow.richpush.html;

import android.content.DialogInterface;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushselfshow.richpush.html.HtmlViewer;

class k implements DialogInterface.OnClickListener {
    final /* synthetic */ h a;
    final /* synthetic */ HtmlViewer.b b;

    k(HtmlViewer.b bVar, h hVar) {
        this.b = bVar;
        this.a = hVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.a("isFirstCollect", true);
        HtmlViewer.this.a(HtmlViewer.this.d);
    }
}
