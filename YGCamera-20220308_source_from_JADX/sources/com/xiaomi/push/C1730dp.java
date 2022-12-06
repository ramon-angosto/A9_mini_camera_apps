package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import java.util.Date;
import java.util.List;

/* renamed from: com.xiaomi.push.dp */
class C1730dp implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1729do f2067a;

    /* renamed from: a */
    final /* synthetic */ String f2068a;

    /* renamed from: a */
    final /* synthetic */ Throwable f2069a;

    C1730dp(C1729do doVar, String str, Throwable th) {
        this.f2067a = doVar;
        this.f2068a = str;
        this.f2069a = th;
    }

    public void run() {
        C1729do.m3033a().add(new Pair(String.format("%1$s %2$s %3$s ", new Object[]{C1729do.m3033a().format(new Date()), C1729do.m3032a(this.f2067a), this.f2068a}), this.f2069a));
        if (C1729do.m3033a().size() > 20000) {
            int size = (C1729do.m3033a().size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    if (C1729do.m3033a().size() > 0) {
                        C1729do.m3033a().remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            List a = C1729do.m3033a();
            a.add(new Pair(String.format("%1$s %2$s %3$s ", new Object[]{C1729do.m3033a().format(new Date()), C1729do.m3032a(this.f2067a), "flush " + size + " lines logs."}), (Object) null));
        }
        try {
            if (!C1610ac.m2503d()) {
                Log.w(C1729do.m3032a(this.f2067a), "SDCard is unavailable.");
            } else {
                C1729do.m3032a(this.f2067a);
            }
        } catch (Exception e) {
            Log.e(C1729do.m3032a(this.f2067a), "", e);
        }
    }
}
