package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.xiaomi.push.C1611ad;

/* renamed from: com.xiaomi.push.service.bg */
public class C2019bg {

    /* renamed from: a */
    private static C2019bg f3810a;

    /* renamed from: a */
    private int f3811a = 0;

    /* renamed from: a */
    private Context f3812a;

    private C2019bg(Context context) {
        this.f3812a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C2019bg m5124a(Context context) {
        if (f3810a == null) {
            f3810a = new C2019bg(context);
        }
        return f3810a;
    }

    /* renamed from: a */
    public int mo18500a() {
        int i = this.f3811a;
        if (i != 0) {
            return i;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f3811a = Settings.Global.getInt(this.f3812a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception unused) {
            }
            return this.f3811a;
        }
        this.f3811a = Settings.Secure.getInt(this.f3812a.getContentResolver(), "device_provisioned", 0);
        return this.f3811a;
    }

    /* renamed from: a */
    public Uri m5126a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a */
    public boolean m5127a() {
        return C1611ad.f1755a.contains("xmsf") || C1611ad.f1755a.contains("xiaomi") || C1611ad.f1755a.contains("miui");
    }
}
