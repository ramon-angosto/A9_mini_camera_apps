package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* renamed from: com.huawei.hms.hatool.u0 */
public class C0832u0 {

    /* renamed from: c */
    public static C0832u0 f753c = new C0832u0();

    /* renamed from: a */
    public boolean f754a = false;

    /* renamed from: b */
    public Context f755b = C0777b.m729f();

    /* renamed from: b */
    public static C0832u0 m1039b() {
        return f753c;
    }

    /* renamed from: a */
    public boolean mo14121a() {
        boolean z;
        if (!this.f754a) {
            Context context = this.f755b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService("user");
                if (userManager != null) {
                    z = userManager.isUserUnlocked();
                } else {
                    this.f754a = false;
                }
            } else {
                z = true;
            }
            this.f754a = z;
        }
        return this.f754a;
    }
}
