package com.huawei.android.pushselfshow.richpush.favorites;

import com.huawei.android.pushselfshow.utils.a.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;

class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "deleteTipDialog mThread run");
        boolean z = false;
        for (f fVar : FavoritesActivity.this.i.a()) {
            if (fVar.a()) {
                c.a(this.a.a.b, fVar.c());
                z = true;
            }
        }
        if (z) {
            if (!FavoritesActivity.this.m) {
                FavoritesActivity.this.i.b();
            }
            FavoritesActivity.this.a.sendEmptyMessage(PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_BROADCAST);
        }
    }
}
