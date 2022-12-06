package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.component.utils.l;
import java.lang.ref.WeakReference;

public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<a> a;

    public void onReceive(Context context, Intent intent) {
        l.b("ThemeStatusBroadcastReceiver", "====ubject status update====");
        if (intent != null) {
            int intExtra = intent.getIntExtra("theme_status_change", 0);
            WeakReference<a> weakReference = this.a;
            if (weakReference != null && weakReference.get() != null) {
                ((a) this.a.get()).b(intExtra);
            }
        }
    }

    public void a(a aVar) {
        this.a = new WeakReference<>(aVar);
    }
}
