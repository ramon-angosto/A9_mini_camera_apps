package com.bytedance.sdk.openadsdk.core.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.component.utils.l;
import java.lang.ref.WeakReference;

public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<a> a;

    public void onReceive(Context context, Intent intent) {
        l.b("ThemeStatusBroadcastReceiver", "====Theme status updated====");
        if (intent != null) {
            int intExtra = intent.getIntExtra("theme_status_change", 0);
            WeakReference<a> weakReference = this.a;
            if (weakReference != null && weakReference.get() != null) {
                ((a) this.a.get()).a(intExtra);
            }
        }
    }
}
