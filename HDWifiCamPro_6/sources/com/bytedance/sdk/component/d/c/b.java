package com.bytedance.sdk.component.d.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.m;
import com.bytedance.sdk.component.d.n;
import com.bytedance.sdk.component.d.r;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;

/* compiled from: ImageLoader */
public class b implements n {
    private volatile f a;

    private b() {
    }

    public static n a(Context context, m mVar) {
        b bVar = new b();
        bVar.b(context, mVar);
        return bVar;
    }

    private void b(Context context, m mVar) {
        if (this.a != null) {
            Log.w("ImageLoader", "already init!");
        }
        if (mVar == null) {
            mVar = e.a(context);
        }
        this.a = new f(context, mVar);
    }

    public j a(String str) {
        return new c.b(this.a).c(str);
    }

    public InputStream a(String str, String str2) {
        if (this.a != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.d.c.c.c.a(str);
            }
            Collection<r> a2 = this.a.a();
            if (a2 != null) {
                for (r a3 : a2) {
                    byte[] bArr = (byte[]) a3.a(str2);
                    if (bArr != null) {
                        return new ByteArrayInputStream(bArr);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.d.c> b = this.a.b();
            if (b != null) {
                for (com.bytedance.sdk.component.d.c a4 : b) {
                    InputStream a5 = a4.a(str2);
                    if (a5 != null) {
                        return a5;
                    }
                }
            }
        }
        return null;
    }

    public boolean a(String str, String str2, String str3) {
        if (this.a == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.d.c.c.c.a(str);
        }
        com.bytedance.sdk.component.d.c a2 = this.a.a(str3);
        if (a2 != null) {
            return a2.b(str2);
        }
        return false;
    }
}
