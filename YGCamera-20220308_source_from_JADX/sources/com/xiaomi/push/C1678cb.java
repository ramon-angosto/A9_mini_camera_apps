package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1685ci;
import java.lang.ref.WeakReference;

/* renamed from: com.xiaomi.push.cb */
public class C1678cb implements Runnable {

    /* renamed from: a */
    private String f1913a;

    /* renamed from: a */
    private WeakReference<Context> f1914a;

    public C1678cb(String str, WeakReference<Context> weakReference) {
        this.f1913a = str;
        this.f1914a = weakReference;
    }

    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f1914a;
        if (weakReference != null && (context = (Context) weakReference.get()) != null) {
            if (C1696co.m2870a(this.f1913a) > C1677ca.f1911a) {
                C1681ce a = C1681ce.m2833a(this.f1913a);
                C1680cd a2 = C1680cd.m2828a(this.f1913a);
                a.mo17319a((C1685ci.C1686a) a2);
                a2.mo17319a((C1685ci.C1686a) C1679cc.m2825a(context, this.f1913a, 1000));
                C1685ci.m2838a(context).mo17312a((C1685ci.C1686a) a);
                return;
            }
            C1524b.m2158b("=====> do not need clean db");
        }
    }
}
