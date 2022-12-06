package com.huawei.android.pushselfshow.richpush.favorites;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;

class c implements Runnable {
    final /* synthetic */ FavoritesActivity a;

    c(FavoritesActivity favoritesActivity) {
        this.a = favoritesActivity;
    }

    public void run() {
        e.a("PushSelfShowLog", "onCreate mThread run");
        if (!this.a.m) {
            FavoritesActivity favoritesActivity = this.a;
            favoritesActivity.a((Context) favoritesActivity.b);
        }
        this.a.i.b();
        this.a.a.sendEmptyMessage(PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE);
    }
}
