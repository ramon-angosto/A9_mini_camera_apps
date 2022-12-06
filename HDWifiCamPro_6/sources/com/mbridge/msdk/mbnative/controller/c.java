package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.q;
import java.util.List;

/* compiled from: NativeVideoTrackingReport */
public class c {
    /* access modifiers changed from: private */
    public static final String a = c.class.getName();

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                p a2 = p.a((f) g.a(context));
                if (!TextUtils.isEmpty(str) && a2 != null && a2.a() > 0) {
                    List<m> a3 = a2.a("2000022");
                    List<m> a4 = a2.a("2000021");
                    List<m> a5 = a2.a("2000043");
                    String a6 = m.a(a4);
                    String b = m.b(a3);
                    String c = m.c(a5);
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(a6)) {
                        sb.append(a6);
                    }
                    if (!TextUtils.isEmpty(b)) {
                        sb.append(b);
                    }
                    if (!TextUtils.isEmpty(c)) {
                        sb.append(c);
                    }
                    if (!TextUtils.isEmpty(sb.toString())) {
                        String sb2 = sb.toString();
                        if (context != null && !TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(str)) {
                            try {
                                new a(context).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(sb2, context, str), new b() {
                                    public final void a(String str) {
                                        q.d(c.a, str);
                                    }

                                    public final void b(String str) {
                                        q.d(c.a, str);
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                                q.d(a, e.getMessage());
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
