package com.bytedance.sdk.openadsdk.c.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.d.a;
import com.bytedance.sdk.component.e.a.e.c;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.g;
import com.bytedance.sdk.component.e.a.h;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.y;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: OverSeaLogDepend */
public class i implements f {
    public a a(JSONObject jSONObject) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public String c() {
        return null;
    }

    public boolean d() {
        return true;
    }

    public int g() {
        return 1;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return true;
    }

    public h m() {
        return null;
    }

    public boolean a(Context context) {
        return o.a(context);
    }

    public String a(String str) {
        return com.bytedance.sdk.component.c.a.b(str, com.bytedance.sdk.openadsdk.core.a.a());
    }

    public String b(String str) {
        return com.bytedance.sdk.component.c.a.a(str, com.bytedance.sdk.openadsdk.core.a.a());
    }

    public String j() {
        return y.c();
    }

    public c k() {
        return new e();
    }

    public Executor e() {
        return e.b();
    }

    public Executor f() {
        return e.a();
    }

    public g l() {
        g a;
        synchronized (this) {
            a = com.bytedance.sdk.openadsdk.multipro.a.a.a(m.a());
        }
        return a;
    }

    public void a(boolean z, int i, long j) {
        a.a(a.c, z, i, j);
    }

    public void a(boolean z) {
        a.a(a.f, z);
    }

    public void n() {
        a.a(a.f);
    }
}
