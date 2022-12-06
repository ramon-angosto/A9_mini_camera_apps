package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

public class ac {
    private static ac a;
    private Context b;
    private int c = 0;

    private ac(Context context) {
        this.b = context.getApplicationContext();
    }

    public static ac a(Context context) {
        if (a == null) {
            a = new ac(context);
        }
        return a;
    }

    public boolean a() {
        return false;
    }

    @SuppressLint({"NewApi"})
    public int b() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        this.c = Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(this.b.getContentResolver(), "device_provisioned", 0) : Settings.Secure.getInt(this.b.getContentResolver(), "device_provisioned", 0);
        return this.c;
    }

    @SuppressLint({"NewApi"})
    public Uri c() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }
}
