package com.bykv.vk.openvk.component.video.a.b;

import android.content.Context;
import android.util.Log;
import com.bykv.vk.openvk.component.video.a.b.a.b;
import com.bykv.vk.openvk.component.video.a.b.a.c;
import com.bytedance.sdk.component.utils.l;
import java.util.Collection;
import java.util.Set;

/* compiled from: Proxy */
public class e {
    static volatile b a;
    static volatile c b;
    public static final boolean c = l.d();
    public static volatile boolean d;
    static volatile boolean e = true;
    static volatile boolean f;
    static volatile int g = 0;
    public static volatile int h = 3;
    public static volatile Integer i;
    /* access modifiers changed from: private */
    public static volatile com.bykv.vk.openvk.component.video.a.b.b.c j;
    private static volatile Context k;

    public static Context a() {
        return k;
    }

    public static void a(boolean z) {
        e = z;
    }

    public static void b(boolean z) {
        f = z;
    }

    public static void a(int i2) {
        g = i2;
    }

    public static void a(c cVar, Context context) {
        if (cVar == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        k = context.getApplicationContext();
        if (b == null) {
            b bVar = a;
            if (bVar == null || !bVar.a.getAbsolutePath().equals(cVar.a.getAbsolutePath())) {
                b = cVar;
                j = com.bykv.vk.openvk.component.video.a.b.b.c.a(context);
                b.a((c.a) new c.a() {
                    public void a(String str) {
                        if (e.c) {
                            Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
                        }
                    }

                    public void a(Set<String> set) {
                        e.j.a((Collection<String>) set, 0);
                        if (e.c) {
                            Log.i("TAG_PROXY_DiskLruCache", "cache file removed, " + set);
                        }
                    }
                });
                f a2 = f.a();
                a2.a(cVar);
                a2.a(j);
                d c2 = d.c();
                c2.a(cVar);
                c2.a(j);
                return;
            }
            throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
        }
    }

    public static c b() {
        return b;
    }

    public static b c() {
        return a;
    }
}
