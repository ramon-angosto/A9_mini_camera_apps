package com.huawei.android.pushselfshow.richpush.html;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.huawei.android.pushagent.c.a.e;

class b implements DownloadListener {
    final /* synthetic */ HtmlViewer a;

    b(HtmlViewer htmlViewer) {
        this.a = htmlViewer;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            e.a("PushSelfShowLog", "url=" + str);
            e.a("PushSelfShowLog", "userAgent=" + str2);
            e.a("PushSelfShowLog", "contentDisposition=" + str3);
            e.a("PushSelfShowLog", "mimetype=" + str4);
            e.a("PushSelfShowLog", "contentLength=" + j);
            this.a.d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            e.a("PushSelfShowLog", "onDownloadStart err", (Throwable) e);
        }
    }
}
