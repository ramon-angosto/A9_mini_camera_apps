package com.meizu.cloud.pushsdk.notification.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.meizu.cloud.pushinternal.DebugLogger;

public class c {
    private static c b;
    private Context a;
    private AssetManager c;

    private c(Context context) {
        this.a = context;
        a();
    }

    public static c a(Context context) {
        if (b == null) {
            b = new c(context);
        }
        return b;
    }

    private void a() {
        this.c = this.a.getAssets();
    }

    public int a(String str, String str2) {
        DebugLogger.i("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.a.getResources().getIdentifier(str, str2, this.a.getApplicationInfo().packageName);
    }
}
