package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;

/* compiled from: PlayableReportUtils */
public final class b {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static void a(CampaignEx campaignEx, String str, String str2, String str3) {
        if (campaignEx != null && campaignEx.isMraid()) {
            int i = 1;
            if (!(!TextUtils.isEmpty(campaignEx.getMraid()))) {
                i = 3;
            }
            m mVar = new m("2000043", i, MBridgeConstans.ENDCARD_URL_TYPE_PL, "", campaignEx.getId(), str2, str, String.valueOf(campaignEx.getKeyIaRst()));
            mVar.n(campaignEx.getId());
            mVar.k(campaignEx.getRequestId());
            mVar.l(campaignEx.getRequestIdNotice());
            mVar.b(campaignEx.getAdSpaceT());
            mVar.h(str3);
            mVar.c(com.mbridge.msdk.foundation.tools.m.n(a.e().g()));
            mVar.a(campaignEx.isMraid() ? m.a : m.b);
            a(mVar, str2);
        }
    }

    public static void a(m mVar, String str) {
        if (mVar != null) {
            mVar.b(com.mbridge.msdk.foundation.tools.m.i());
            String d = m.d(mVar);
            if (a.a().c()) {
                a.a().a(d);
            } else {
                a(d, a.e().g(), str);
            }
        }
    }

    public static void a(m mVar, Context context, String str) {
        if (mVar != null) {
            mVar.o("2000060");
            mVar.m(str);
            mVar.c(com.mbridge.msdk.foundation.tools.m.n(context));
            String b = m.b(mVar);
            if (a.a().c()) {
                a.a().a(b);
            } else {
                a(b, context, str);
            }
        }
    }

    public static void b(m mVar, String str) {
        if (mVar != null) {
            mVar.o("2000059");
            mVar.m(str);
            mVar.c(com.mbridge.msdk.foundation.tools.m.n(a.e().g()));
            mVar.b(com.mbridge.msdk.foundation.tools.m.i());
            String c = m.c(mVar);
            if (a.a().c()) {
                a.a().a(c);
            } else {
                a(c, a.e().g(), str);
            }
        }
    }

    public static void a(String str, Context context, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a(new com.mbridge.msdk.foundation.same.f.a(str, str2));
        }
    }

    public static void b(m mVar, Context context, String str) {
        String g = m.g(mVar);
        if (a.a().c()) {
            a.a().a(g);
        } else {
            a(g, context, str);
        }
    }

    public static void c(m mVar, Context context, String str) {
        String h = m.h(mVar);
        if (a.a().c()) {
            a.a().a(h);
        } else {
            a(h, context, str);
        }
    }

    public static void d(m mVar, Context context, String str) {
        if (mVar != null) {
            mVar.o("2000063");
            mVar.m(str);
            mVar.c(com.mbridge.msdk.foundation.tools.m.n(context));
            String a2 = m.a(mVar);
            if (a.a().c()) {
                a.a().a(a2);
            } else {
                a(a2, context, str);
            }
        }
    }

    private static void a(Runnable runnable) {
        Handler handler = a;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
