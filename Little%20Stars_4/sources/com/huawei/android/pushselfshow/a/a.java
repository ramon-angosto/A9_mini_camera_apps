package com.huawei.android.pushselfshow.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.android.pushagent.c.a.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import object.p2pipcam.utils.DataBaseHelper;

public class a {
    private static final String[] a = {"phone", PushConstants.WEB_URL, "email", PushConstants.EXTRA_APPLICATION_PENDING_INTENT, "cosa", "rp"};
    private Context b;
    private com.huawei.android.pushselfshow.b.a c;

    public a(Context context, com.huawei.android.pushselfshow.b.a aVar) {
        this.b = context;
        this.c = aVar;
    }

    public static boolean a(String str) {
        int i = 0;
        while (true) {
            String[] strArr = a;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equals(str)) {
                return true;
            }
            i++;
        }
    }

    private void b() {
        e.a("PushSelfShowLog", "enter launchUrl");
        try {
            if (!(this.c.G == 0 || this.c.H == null || this.c.H.length() <= 0)) {
                if (this.c.B.indexOf("?") != -1) {
                    com.huawei.android.pushselfshow.b.a aVar = this.c;
                    aVar.B = this.c.B + "&" + this.c.H + "=" + com.huawei.android.pushselfshow.utils.a.a(com.huawei.android.pushselfshow.utils.a.b(this.b));
                } else {
                    com.huawei.android.pushselfshow.b.a aVar2 = this.c;
                    aVar2.B = this.c.B + "?" + this.c.H + "=" + com.huawei.android.pushselfshow.utils.a.a(com.huawei.android.pushselfshow.utils.a.b(this.b));
                }
            }
            e.a("PushSelfShowLog", "url =" + this.c.B);
            if (this.c.F == 0) {
                String str = this.c.B;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW").setFlags(268435456).setData(Uri.parse(str));
                this.b.startActivity(intent);
                return;
            }
            this.c.C = this.c.B;
            this.c.E = "text/html";
            this.c.D = "html";
            g();
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    private void c() {
        e.a("PushSelfShowLog", "enter launchCall");
        try {
            Intent intent = new Intent();
            Intent action = intent.setAction("android.intent.action.DIAL");
            action.setData(Uri.parse("tel:" + this.c.v)).setFlags(268435456);
            this.b.startActivity(intent);
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    private void d() {
        e.a("PushSelfShowLog", "enter launchMail");
        try {
            if (this.c.w != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SENDTO").setFlags(268435456).setData(Uri.fromParts("mailto", this.c.w, (String) null)).putExtra("android.intent.extra.SUBJECT", this.c.x).putExtra("android.intent.extra.TEXT", this.c.y).setPackage("com.android.email");
                this.b.startActivity(intent);
            }
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    private void e() {
        try {
            e.a("PushSelfShowLog", "enter launchApp, appPackageName =" + this.c.z);
            if (com.huawei.android.pushselfshow.utils.a.b(this.b, this.c.z)) {
                f();
                return;
            }
            try {
                e.e("PushSelfShowLog", "insert into db message.getMsgId() is " + this.c.a() + ",message.appPackageName is " + this.c.z);
                com.huawei.android.pushselfshow.utils.a.a.a(this.b, this.c.a(), this.c.z);
            } catch (Exception e) {
                e.d("PushSelfShowLog", "launchApp not exist ,insertAppinfo error", e);
            }
            Intent intent = null;
            if (com.huawei.android.pushselfshow.utils.a.a(this.b, "com.huawei.appmarket", new Intent("com.huawei.appmarket.intent.action.AppDetail")).booleanValue()) {
                e.a("PushSelfShowLog", "app not exist && appmarkt exist ,so open appmarket");
                intent = new Intent("com.huawei.appmarket.intent.action.AppDetail");
                intent.putExtra("APP_PACKAGENAME", this.c.z);
                intent.setPackage("com.huawei.appmarket");
                intent.setFlags(402653184);
                e.a("PushSelfShowLog", "hwAppmarket only support com.huawei.appmarket.intent.action.AppDetail!");
                com.huawei.android.pushselfshow.utils.a.a(this.b, "7", this.c);
            }
            if (intent != null) {
                e.a("PushSelfShowLog", "intent is not null " + intent.toURI());
                this.b.startActivity(intent);
                return;
            }
            e.a("PushSelfShowLog", "intent is null ");
        } catch (Exception e2) {
            e.d("PushSelfShowLog", "launchApp error:" + e2.toString());
        }
    }

    private void f() {
        e.e("PushSelfShowLog", "run into launchCosaApp ");
        try {
            e.a("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.c.z + ",and msg.intentUri is " + this.c.f);
            Intent a2 = com.huawei.android.pushselfshow.utils.a.a(this.b, this.c.z);
            if (this.c.f != null) {
                try {
                    Intent parseUri = Intent.parseUri(this.c.f, 0);
                    e.a("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0)，" + a2.toURI());
                    if (com.huawei.android.pushselfshow.utils.a.a(this.b, this.c.z, parseUri).booleanValue()) {
                        a2 = parseUri;
                    }
                } catch (Exception e) {
                    e.a("PushSelfShowLog", "intentUri error ", (Throwable) e);
                }
            } else {
                if (this.c.A != null) {
                    Intent intent = new Intent(this.c.A);
                    if (com.huawei.android.pushselfshow.utils.a.a(this.b, this.c.z, intent).booleanValue()) {
                        a2 = intent;
                    }
                }
                a2.setPackage(this.c.z);
            }
            if (a2 == null) {
                e.a("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            a2.setFlags(805437440);
            e.a("PushSelfShowLog", "start " + a2.toURI());
            this.b.startActivity(a2);
        } catch (Exception e2) {
            e.c("PushSelfShowLog", e2.toString(), e2);
        }
    }

    private void g() {
        try {
            e.e("PushSelfShowLog", "run into launchRichPush ");
            Intent intent = new Intent("com.huawei.android.push.intent.RICHPUSH");
            intent.putExtra(DataBaseHelper.KEY_TYPE, this.c.D);
            intent.putExtra("selfshow_info", this.c.c());
            intent.putExtra("selfshow_token", this.c.d());
            intent.setFlags(268468240);
            intent.setPackage(this.b.getPackageName());
            this.b.startActivity(intent);
        } catch (Exception e) {
            e.c("PushSelfShowLog", "launchRichPush failed", e);
        }
    }

    public void a() {
        com.huawei.android.pushselfshow.b.a aVar;
        e.a("PushSelfShowLog", "enter launchNotify()");
        if (this.b == null || (aVar = this.c) == null) {
            e.a("PushSelfShowLog", "launchNotify  context or msg is null");
        } else if (PushConstants.EXTRA_APPLICATION_PENDING_INTENT.equals(aVar.o)) {
            e();
        } else if ("cosa".equals(this.c.o)) {
            f();
        } else if ("email".equals(this.c.o)) {
            d();
        } else if ("phone".equals(this.c.o)) {
            c();
        } else if ("rp".equals(this.c.o)) {
            g();
        } else if (PushConstants.WEB_URL.equals(this.c.o)) {
            b();
        } else {
            e.a("PushSelfShowLog", this.c.o + " is not exist in hShowType");
        }
    }
}
