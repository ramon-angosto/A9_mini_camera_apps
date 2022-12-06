package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C2060h;

/* renamed from: com.xiaomi.push.eo */
class C1769eo implements C1767em {
    C1769eo() {
    }

    /* renamed from: a */
    private void m3375a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                String[] split = str.split("/");
                if (split.length > 0 && !TextUtils.isEmpty(split[split.length - 1])) {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        C1760ef.m3335a(context, "provider", PointerIconCompat.TYPE_TEXT, "B get a incorrect message");
                        return;
                    }
                    String decode = Uri.decode(str2);
                    if (TextUtils.isEmpty(decode)) {
                        C1760ef.m3335a(context, "provider", PointerIconCompat.TYPE_TEXT, "B get a incorrect message");
                        return;
                    }
                    String b = C1759ee.m3333b(decode);
                    if (!TextUtils.isEmpty(b)) {
                        C1760ef.m3335a(context, b, PointerIconCompat.TYPE_CROSSHAIR, "play with provider successfully");
                        return;
                    }
                }
            }
            C1760ef.m3335a(context, "provider", PointerIconCompat.TYPE_TEXT, "B get a incorrect message");
        } catch (Exception e) {
            C1760ef.m3335a(context, "provider", PointerIconCompat.TYPE_TEXT, "B meet a exception" + e.getMessage());
        }
    }

    /* renamed from: b */
    private void m3376b(Context context, C1763ei eiVar) {
        String b = eiVar.mo17517b();
        String d = eiVar.mo17521d();
        int a = eiVar.mo17514a();
        if (context == null || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                C1760ef.m3335a(context, "provider", PointerIconCompat.TYPE_TEXT, "argument error");
            } else {
                C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "argument error");
            }
        } else if (!C2060h.m5233b(context, b)) {
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_HELP, "B is not ready");
        } else {
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_HAND, "B is ready");
            C1760ef.m3335a(context, d, PointerIconCompat.TYPE_WAIT, "A is ready");
            String a2 = C1759ee.m3331a(d);
            try {
                if (TextUtils.isEmpty(a2)) {
                    C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "info is empty");
                } else if (a != 1 || C1764ej.m3355a(context)) {
                    String type = context.getContentResolver().getType(C1759ee.m3330a(b, a2));
                    if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                        C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "A is fail to help B's provider");
                        return;
                    }
                    C1760ef.m3335a(context, d, 1005, "A is successful");
                    C1760ef.m3335a(context, d, PointerIconCompat.TYPE_CELL, "The job is finished");
                } else {
                    C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "A not in foreground");
                }
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
                C1760ef.m3335a(context, d, PointerIconCompat.TYPE_TEXT, "A meet a exception when help B's provider");
            }
        }
    }

    /* renamed from: a */
    public void mo17512a(Context context, Intent intent, String str) {
        m3375a(context, str);
    }

    /* renamed from: a */
    public void mo17513a(Context context, C1763ei eiVar) {
        if (eiVar != null) {
            m3376b(context, eiVar);
        } else {
            C1760ef.m3335a(context, "provider", PointerIconCompat.TYPE_TEXT, "A receive incorrect message");
        }
    }
}
