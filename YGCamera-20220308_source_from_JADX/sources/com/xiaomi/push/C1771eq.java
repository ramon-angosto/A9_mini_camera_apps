package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C2060h;

/* renamed from: com.xiaomi.push.eq */
class C1771eq implements C1767em {
    C1771eq() {
    }

    /* renamed from: a */
    private void m3383a(Service service, Intent intent) {
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("waker_pkgname");
            String stringExtra2 = intent.getStringExtra("awake_info");
            if (TextUtils.isEmpty(stringExtra)) {
                C1760ef.m3335a(service.getApplicationContext(), "service", PointerIconCompat.TYPE_CROSSHAIR, "old version message");
            } else if (!TextUtils.isEmpty(stringExtra2)) {
                String b = C1759ee.m3333b(stringExtra2);
                boolean isEmpty = TextUtils.isEmpty(b);
                Context applicationContext = service.getApplicationContext();
                if (!isEmpty) {
                    C1760ef.m3335a(applicationContext, b, PointerIconCompat.TYPE_CROSSHAIR, "old version message ");
                } else {
                    C1760ef.m3335a(applicationContext, "service", PointerIconCompat.TYPE_TEXT, "B get a incorrect message");
                }
            } else {
                C1760ef.m3335a(service.getApplicationContext(), stringExtra, PointerIconCompat.TYPE_CROSSHAIR, "play with service ");
            }
        }
    }

    /* renamed from: a */
    private void m3384a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                C1760ef.m3335a(context, "service", PointerIconCompat.TYPE_TEXT, "argument error");
            } else {
                C1760ef.m3335a(context, str3, PointerIconCompat.TYPE_TEXT, "argument error");
            }
        } else if (!C2060h.m5231a(context, str)) {
            C1760ef.m3335a(context, str3, PointerIconCompat.TYPE_HELP, "B is not ready");
        } else {
            C1760ef.m3335a(context, str3, PointerIconCompat.TYPE_HAND, "B is ready");
            C1760ef.m3335a(context, str3, PointerIconCompat.TYPE_WAIT, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                intent.putExtra("waker_pkgname", context.getPackageName());
                intent.putExtra("awake_info", C1759ee.m3331a(str3));
                if (context.startService(intent) != null) {
                    C1760ef.m3335a(context, str3, 1005, "A is successful");
                    C1760ef.m3335a(context, str3, PointerIconCompat.TYPE_CELL, "The job is finished");
                    return;
                }
                C1760ef.m3335a(context, str3, PointerIconCompat.TYPE_TEXT, "A is fail to help B's service");
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
                C1760ef.m3335a(context, str3, PointerIconCompat.TYPE_TEXT, "A meet a exception when help B's service");
            }
        }
    }

    /* renamed from: a */
    public void mo17512a(Context context, Intent intent, String str) {
        if (context != null && (context instanceof Service)) {
            m3383a((Service) context, intent);
        }
    }

    /* renamed from: a */
    public void mo17513a(Context context, C1763ei eiVar) {
        if (eiVar != null) {
            m3384a(context, eiVar.mo17514a(), eiVar.mo17519c(), eiVar.mo17521d());
        }
    }
}
