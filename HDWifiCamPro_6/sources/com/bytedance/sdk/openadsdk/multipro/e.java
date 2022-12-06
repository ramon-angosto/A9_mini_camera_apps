package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.c.a.d;
import com.bytedance.sdk.openadsdk.multipro.a.b;
import com.bytedance.sdk.openadsdk.multipro.c.a;
import com.bytedance.sdk.openadsdk.multipro.d.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: TTProviderManager */
public class e implements a {
    private static volatile e a;
    private static WeakReference<Context> b;
    private static List<a> c = Collections.synchronizedList(new ArrayList());

    private boolean c(Uri uri) {
        return true;
    }

    public String a() {
        return "";
    }

    public void b() {
    }

    static {
        c.add(new c());
        c.add(new b());
        c.add(new a());
        c.add(new d(new com.bytedance.sdk.component.e.a.b.b.b()));
        for (a b2 : c) {
            b2.b();
        }
    }

    public static e a(Context context) {
        if (context != null) {
            b = new WeakReference<>(context.getApplicationContext());
        }
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    private e() {
    }

    private a b(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (!c(uri)) {
            l.b("TTProviderManager", "uri is error1");
            return null;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            l.b("TTProviderManager", "uri is error2");
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            l.b("TTProviderManager", "uri is error3");
            return null;
        }
        for (a next : c) {
            if (str.equals(next.a())) {
                return next;
            }
        }
        l.b("TTProviderManager", "uri is error4");
        return null;
    }

    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable th) {
            l.a("TTProviderManager", "==provider query error==", th);
            return null;
        }
    }

    public String a(Uri uri) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri);
            }
            return null;
        } catch (Throwable th) {
            l.a("TTProviderManager", "==provider getType error==", th);
            return null;
        }
    }

    public Uri a(Uri uri, ContentValues contentValues) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri, contentValues);
            }
            return null;
        } catch (Throwable th) {
            l.a("TTProviderManager", "==provider insert error==", th);
            return null;
        }
    }

    public int a(Uri uri, String str, String[] strArr) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            l.a("TTProviderManager", "==provider delete error==", th);
            return 0;
        }
    }

    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            l.a("TTProviderManager", "==provider update error==", th);
            return 0;
        }
    }
}
