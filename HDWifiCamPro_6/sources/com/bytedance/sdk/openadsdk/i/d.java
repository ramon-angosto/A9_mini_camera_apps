package com.bytedance.sdk.openadsdk.i;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.f.a;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.i.a.c;
import java.util.concurrent.TimeUnit;

/* compiled from: TTNetClient */
public class d {
    private static volatile d a;
    private Context b;
    private final a c;
    private c d;

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(m.a());
                }
            }
        }
        return a;
    }

    private d(Context context) {
        this.b = context == null ? m.a() : context.getApplicationContext();
        this.c = new a.C0035a().a(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).b(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).c(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).a(true).a();
        com.bytedance.sdk.component.b.a.d a2 = this.c.e().a();
        if (a2 != null) {
            a2.a(32);
        }
    }

    public a b() {
        return this.c;
    }

    public c c() {
        d();
        return this.d;
    }

    public void a(String str, ImageView imageView) {
        com.bytedance.sdk.openadsdk.e.a.a(str).a(imageView);
    }

    public void a(k kVar, ImageView imageView) {
        if (kVar != null && !TextUtils.isEmpty(kVar.a()) && imageView != null) {
            com.bytedance.sdk.openadsdk.e.a.a(kVar).a(imageView);
        }
    }

    private void d() {
        if (this.d == null) {
            this.d = new c();
        }
    }
}
