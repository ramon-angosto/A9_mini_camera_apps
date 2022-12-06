package com.meizu.cloud.pushsdk.common.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.common.a.a;

public abstract class WorkReceiver extends BroadcastReceiver {
    public abstract void onHandleIntent(Context context, Intent intent);

    public void onReceive(final Context context, final Intent intent) {
        a.d().a(context);
        a.d().a(new Runnable() {
            public void run() {
                WorkReceiver.this.onHandleIntent(context, intent);
                a.d().c();
            }
        });
    }
}
