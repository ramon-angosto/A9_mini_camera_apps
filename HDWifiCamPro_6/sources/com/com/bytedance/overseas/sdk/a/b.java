package com.com.bytedance.overseas.sdk.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.c;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.l.y;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: GPDownLoader */
public class b implements c {
    protected c a;
    protected n b;
    protected String c;
    protected boolean d = false;
    protected final AtomicBoolean e = new AtomicBoolean(false);
    private WeakReference<Context> f;
    private boolean g = false;

    public b(Context context, n nVar, String str) {
        this.f = new WeakReference<>(context);
        this.b = nVar;
        this.a = nVar.aa();
        this.c = str;
        l.b("GPDownLoader", str, "====tag===" + str);
        if (m.a() == null) {
            m.a(context);
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean a(Context context, String str) {
        return b(context, str);
    }

    public static boolean b(Context context, String str) {
        if (!(context == null || str == null || TextUtils.isEmpty(str))) {
            l.c("GPDownLoader", "gotoGooglePlay :market://details?id=" + str);
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri parse = Uri.parse("market://details?id=" + str);
                intent.setData(parse);
                for (ResolveInfo next : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                    if (next.activityInfo.packageName.equals("com.android.vending")) {
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.android.vending");
                        if (launchIntentForPackage != null) {
                            launchIntentForPackage.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
                            launchIntentForPackage.setData(parse);
                            if (Build.VERSION.SDK_INT >= 33) {
                                launchIntentForPackage.setAction("android.intent.action.VIEW");
                                launchIntentForPackage.removeCategory("android.intent.category.LAUNCHER");
                            }
                            if (!(context instanceof Activity)) {
                                launchIntentForPackage.setFlags(268435456);
                            }
                            context.startActivity(launchIntentForPackage);
                            return true;
                        }
                    }
                }
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
                    intent2.setFlags(268435456);
                    context.startActivity(intent2);
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Context c() {
        WeakReference<Context> weakReference = this.f;
        return (weakReference == null || weakReference.get() == null) ? m.a() : (Context) this.f.get();
    }

    public void d() {
        if (c() != null) {
            if (b()) {
                this.e.set(true);
            } else if (!a() && !e() && this.b.aa() == null && this.b.O() != null) {
                w.a(c(), this.b.O(), this.b, y.a(this.c), this.c, true);
            }
        }
    }

    public boolean b() {
        if (this.b.ab() == null) {
            return false;
        }
        String a2 = this.b.ab().a();
        if (!TextUtils.isEmpty(a2)) {
            Uri parse = Uri.parse(a2);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            if (y.a(c(), intent)) {
                if (!(c() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                try {
                    com.bytedance.sdk.openadsdk.c.c.d(m.a(), this.b, this.c, "open_url_app", (Map<String, Object>) null);
                    c().startActivity(intent);
                    j.a().a(this.b, this.c);
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (this.d && !this.e.get()) {
            return false;
        }
        this.d = true;
        com.bytedance.sdk.openadsdk.c.c.d(c(), this.b, this.c, "open_fallback_url", (Map<String, Object>) null);
        return false;
    }

    public boolean e() {
        this.e.set(true);
        if (this.a == null || !a(c(), this.a.c())) {
            return false;
        }
        return true;
    }

    public boolean a() {
        Intent a2;
        if (this.a == null) {
            return false;
        }
        n nVar = this.b;
        if (nVar != null && nVar.as() == 0) {
            return false;
        }
        String c2 = this.a.c();
        if (TextUtils.isEmpty(c2) || !y.b(c(), c2) || (a2 = y.a(c(), c2)) == null) {
            return false;
        }
        a2.putExtra("START_ONLY_FOR_ANDROID", true);
        try {
            c().startActivity(a2);
            com.bytedance.sdk.openadsdk.c.c.d(c(), this.b, this.c, "click_open", (Map<String, Object>) null);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
