package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C2060h;

/* renamed from: com.xiaomi.push.ep */
class C1770ep implements C1767em {
    C1770ep() {
    }

    /* renamed from: a */
    private void m3379a(Service service, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = C1759ee.m3333b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                C1760ef.m3335a(service.getApplicationContext(), b, PointerIconCompat.TYPE_CROSSHAIR, "play with service successfully");
                return;
            }
        }
        C1760ef.m3335a(service.getApplicationContext(), "service", PointerIconCompat.TYPE_TEXT, "B get a incorrect message");
    }

    /* renamed from: b */
    private void m3380b(Context context, C1763ei eiVar) {
        String a = eiVar.mo17514a();
        String b = eiVar.mo17517b();
        String d = eiVar.mo17521d();
        int a2 = eiVar.mo17514a();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                C1760ef.m3335a(context, "service", PointerIconCompat.TYPE_TEXT, "argument error");
            } else {
                C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "argument error");
            }
        } else if (!C2060h.m5232a(context, a, b)) {
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_HELP, "B is not ready");
        } else {
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_HAND, "B is ready");
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_WAIT, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setAction(b);
                intent.setPackage(a);
                intent.putExtra("awake_info", C1759ee.m3331a(d));
                if (a2 == 1 && !C1764ej.m3355a(context)) {
                    C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "A not in foreground");
                } else if (context.startService(intent) != null) {
                    C1760ef.m3335a(context, d, 1005, "A is successful");
                    C1760ef.m3335a(context, d, PointerIconCompat.TYPE_CELL, "The job is finished");
                } else {
                    C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "A is fail to help B's service");
                }
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
                C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "A meet a exception when help B's service");
            }
        }
    }

    /* renamed from: a */
    public void mo17512a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            C1760ef.m3335a(context, "service", PointerIconCompat.TYPE_TEXT, "A receive incorrect message");
        } else {
            m3379a((Service) context, intent);
        }
    }

    /* renamed from: a */
    public void mo17513a(Context context, C1763ei eiVar) {
        if (eiVar != null) {
            m3380b(context, eiVar);
        } else {
            C1760ef.m3335a(context, "service", PointerIconCompat.TYPE_TEXT, "A receive incorrect message");
        }
    }
}
