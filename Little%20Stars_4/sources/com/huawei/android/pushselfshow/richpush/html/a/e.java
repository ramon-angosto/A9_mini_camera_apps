package com.huawei.android.pushselfshow.richpush.html.a;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.huawei.android.pushselfshow.utils.a;

class e extends Thread {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        try {
            Looper.prepare();
            Toast.makeText(this.a.f, a.a((Context) this.a.f, "手机上没有安装应用市场，建议安装智汇云应用市场", "Not Found App Market"), 0).show();
            Looper.loop();
            try {
                Looper.myLooper().quit();
            } catch (Exception e) {
                com.huawei.android.pushagent.c.a.e.c("PushSelfShowLog", e.toString(), e);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Looper.myLooper().quit();
        } catch (Throwable th) {
            try {
                Looper.myLooper().quit();
            } catch (Exception e3) {
                com.huawei.android.pushagent.c.a.e.c("PushSelfShowLog", e3.toString(), e3);
            }
            throw th;
        }
    }
}
