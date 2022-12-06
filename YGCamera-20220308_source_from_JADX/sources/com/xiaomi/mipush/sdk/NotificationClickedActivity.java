package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.xiaomi.channel.commonutils.logger.C1524b;

public final class NotificationClickedActivity extends Activity {

    /* renamed from: a */
    private BroadcastReceiver f1635a;

    /* renamed from: a */
    private Handler f1636a;

    /* renamed from: a */
    private void m2254a(Intent intent) {
        if (intent != null) {
            try {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.putExtra("is_clicked_activity_call", true);
                    C1524b.m2158b("clicked activity start service.");
                    startService(intent2);
                }
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 8388659;
        window.setAttributes(attributes);
        this.f1636a = new Handler();
        this.f1636a.postDelayed(new C1556ac(this), 3000);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        this.f1635a = new C1557ad(this);
        try {
            registerReceiver(this.f1635a, intentFilter, C1581d.m2417a(this), (Handler) null);
        } catch (Exception unused) {
        }
        m2254a(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f1636a.removeCallbacksAndMessages((Object) null);
        try {
            unregisterReceiver(this.f1635a);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m2254a(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }
}
