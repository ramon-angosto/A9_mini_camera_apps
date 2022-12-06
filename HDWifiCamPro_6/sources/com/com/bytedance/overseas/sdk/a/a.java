package com.com.bytedance.overseas.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.y;
import java.util.Map;

/* compiled from: AndroidRGPDownLoader */
class a extends b {
    public a(Context context, n nVar, String str) {
        super(context, nVar, str);
    }

    public boolean a() {
        Intent a;
        if ((this.b != null && this.b.as() == 0) || this.a == null) {
            return false;
        }
        try {
            String c = this.a.c();
            if (TextUtils.isEmpty(c) || (a = y.a(c(), c)) == null) {
                return false;
            }
            a.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(c() instanceof Activity)) {
                a.addFlags(268435456);
            }
            c().startActivity(a);
            c.d(c(), this.b, this.c, "click_open", (Map<String, Object>) null);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public boolean b() {
        if (this.b.ab() == null) {
            return false;
        }
        try {
            String a = this.b.ab().a();
            if (!TextUtils.isEmpty(a)) {
                Uri parse = Uri.parse(a);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (!(c() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                c.d(m.a(), this.b, this.c, "open_url_app", (Map<String, Object>) null);
                c().startActivity(intent);
                j.a().a(this.b, this.c);
                return true;
            }
        } catch (Throwable unused) {
        }
        if (this.d && !this.e.get()) {
            return false;
        }
        this.d = true;
        c.d(c(), this.b, this.c, "open_fallback_url", (Map<String, Object>) null);
        return false;
    }
}
