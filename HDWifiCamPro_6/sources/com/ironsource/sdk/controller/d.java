package com.ironsource.sdk.controller;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.ironsource.sdk.controller.x;
import com.ironsource.sdk.utils.Logger;
import java.lang.reflect.Method;
import java.security.AccessControlException;

class d {
    private static final String b = d.class.getSimpleName();
    final x.d a;

    d(x.d dVar) {
        this.a = dVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(String str, String str2) {
        if (this.a == null) {
            Logger.e(b, "!!! nativeAPI == null !!!");
            return;
        }
        Method declaredMethod = x.d.class.getDeclaredMethod(str, new Class[]{String.class});
        if (Build.VERSION.SDK_INT >= 17) {
            if (!declaredMethod.isAnnotationPresent(JavascriptInterface.class)) {
                throw new AccessControlException("Trying to access a private function: " + str);
            }
        }
        declaredMethod.invoke(this.a, new Object[]{str2});
    }
}
