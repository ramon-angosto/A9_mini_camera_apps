package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C2060h;

/* renamed from: com.xiaomi.push.eh */
class C1762eh implements C1767em {
    C1762eh() {
    }

    /* renamed from: a */
    private void m3341a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = C1759ee.m3333b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                C1760ef.m3335a(activity.getApplicationContext(), b, PointerIconCompat.TYPE_CROSSHAIR, "play with activity successfully");
                return;
            }
        }
        C1760ef.m3335a(activity.getApplicationContext(), "activity", PointerIconCompat.TYPE_TEXT, "B get incorrect message");
    }

    /* renamed from: b */
    private void m3342b(Context context, C1763ei eiVar) {
        String a = eiVar.mo17514a();
        String b = eiVar.mo17517b();
        String d = eiVar.mo17521d();
        int a2 = eiVar.mo17514a();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                C1760ef.m3335a(context, "activity", PointerIconCompat.TYPE_TEXT, "argument error");
            } else {
                C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "argument error");
            }
        } else if (!C2060h.m5234b(context, a, b)) {
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_HELP, "B is not ready");
        } else {
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_HAND, "B is ready");
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_WAIT, "A is ready");
            Intent intent = new Intent(b);
            intent.setPackage(a);
            intent.putExtra("awake_info", C1759ee.m3331a(d));
            intent.addFlags(276824064);
            intent.setAction(b);
            if (a2 == 1) {
                try {
                    if (!C1764ej.m3355a(context)) {
                        C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "A not in foreground");
                        return;
                    }
                } catch (Exception e) {
                    C1524b.m2155a((Throwable) e);
                    C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "A meet a exception when help B's activity");
                    return;
                }
            }
            context.startActivity(intent);
            C1760ef.m3335a(context, d, 1005, "A is successful");
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_CELL, "The job is finished");
        }
    }

    /* renamed from: a */
    public void mo17512a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            C1760ef.m3335a(context, "activity", PointerIconCompat.TYPE_TEXT, "B receive incorrect message");
        } else {
            m3341a((Activity) context, intent);
        }
    }

    /* renamed from: a */
    public void mo17513a(Context context, C1763ei eiVar) {
        if (eiVar != null) {
            m3342b(context, eiVar);
        } else {
            C1760ef.m3335a(context, "activity", PointerIconCompat.TYPE_TEXT, "A receive incorrect message");
        }
    }
}
