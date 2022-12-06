package com.huawei.android.pushselfshow.richpush.html.a;

import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.a.f;
import com.huawei.android.pushselfshow.richpush.html.api.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;

class g implements Runnable {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void run() {
        try {
            e.e("PushSelfShowLog", "getPlayingStatusRb getPlayingStatus this.state = " + this.a.e);
            if (f.a.MEDIA_RUNNING.ordinal() == this.a.e.ordinal()) {
                long i = this.a.i();
                float b = this.a.k();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("current_postion", i);
                    jSONObject.put("duration", (double) b);
                    jSONObject.put(PushConstants.WEB_URL, this.a.f);
                    this.a.j.a(this.a.a, d.a.OK, "status", jSONObject);
                } catch (Exception e) {
                    e.d("PushSelfShowLog", "getPlayingStatus error", e);
                }
            }
        } catch (Exception e2) {
            e.d("PushSelfShowLog", "getPlayingStatusRb run error", e2);
        }
        if (f.a.MEDIA_NONE.ordinal() != this.a.e.ordinal() && f.a.MEDIA_STOPPED.ordinal() != this.a.e.ordinal()) {
            this.a.b.postDelayed(this, (long) this.a.g);
        }
    }
}
