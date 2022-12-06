package com.bykv.vk.openvk.component.video.a.b.a;

import android.content.Context;
import com.bykv.vk.openvk.component.video.a.b.b.c;
import com.bykv.vk.openvk.component.video.a.b.d;
import com.bykv.vk.openvk.component.video.a.b.e;
import com.bykv.vk.openvk.component.video.a.c.a;
import com.bytedance.sdk.component.g.g;
import java.io.File;

/* compiled from: DiskCache */
public class b extends a {
    public final File a;

    public void a() {
        a.a((g) new g("clear") {
            public void run() {
                b.this.b();
            }
        });
    }

    public void b() {
        d.c().d();
        Context a2 = e.a();
        if (a2 != null) {
            c.a(a2).a(1);
        }
        for (File delete : this.a.listFiles()) {
            try {
                delete.delete();
            } catch (Throwable unused) {
            }
        }
    }

    public File c(String str) {
        return e(str);
    }

    public File d(String str) {
        return e(str);
    }

    /* access modifiers changed from: package-private */
    public File e(String str) {
        return new File(this.a, str);
    }
}
