package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.xiaomi.push.C1774et;
import com.xiaomi.push.C1776eu;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.xiaomi.mipush.sdk.a */
public class C1553a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private Set<String> f1640a = new HashSet();

    /* renamed from: a */
    private static void m2275a(Application application) {
        application.registerActivityLifecycleCallbacks(new C1553a());
    }

    /* renamed from: a */
    public static void m2276a(Context context) {
        m2275a((Application) context.getApplicationContext());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        C1776eu a;
        String packageName;
        String a2;
        int i;
        Intent intent = activity.getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (!TextUtils.isEmpty(stringExtra) && intExtra > 0 && !this.f1640a.contains(stringExtra)) {
                this.f1640a.add(stringExtra);
                if (intExtra == 3000) {
                    a = C1776eu.m3405a(activity.getApplicationContext());
                    packageName = activity.getPackageName();
                    a2 = C1774et.m3389a(intExtra);
                    i = 3008;
                } else if (intExtra == 1000) {
                    a = C1776eu.m3405a(activity.getApplicationContext());
                    packageName = activity.getPackageName();
                    a2 = C1774et.m3389a(intExtra);
                    i = PointerIconCompat.TYPE_TEXT;
                } else {
                    return;
                }
                a.mo17537a(packageName, a2, stringExtra, i, (String) null);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
