package com.mbridge.msdk.foundation.b;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.b.a.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* compiled from: FeedbackManager */
public final class b {
    public static int a = -2;
    public static int b = -2;
    public static volatile boolean c = false;
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.b.a.a> d;
    private final RelativeLayout.LayoutParams e;
    private com.mbridge.msdk.b.a f;

    /* compiled from: FeedbackManager */
    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b();
    }

    private b() {
        this.d = new ConcurrentHashMap<>();
        this.e = new RelativeLayout.LayoutParams(a, b);
    }

    public static b a() {
        return a.a;
    }

    public final Activity a(Context context) {
        Activity activity;
        Exception e2;
        Activity activity2;
        Context c2 = com.mbridge.msdk.foundation.controller.a.e().c();
        try {
            Activity activity3 = c2 instanceof Activity ? (Activity) c2 : null;
            try {
                activity = (!(context instanceof Activity) || (Build.VERSION.SDK_INT >= 17 && ((Activity) context).isDestroyed())) ? activity3 : (Activity) context;
            } catch (Exception e3) {
                Activity activity4 = activity3;
                e2 = e3;
                activity = activity4;
                e2.printStackTrace();
                return activity;
            }
            try {
                WeakReference<Activity> a2 = com.mbridge.msdk.foundation.controller.a.e().a();
                if (a2 != null && (activity2 = (Activity) a2.get()) != null && !activity2.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity2.isDestroyed())) {
                    activity = activity2;
                }
                if (activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
                    return null;
                }
                return activity;
            } catch (Exception e4) {
                e2 = e4;
                e2.printStackTrace();
                return activity;
            }
        } catch (Exception e5) {
            e2 = e5;
            activity = null;
            e2.printStackTrace();
            return activity;
        }
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity a2 = a(context);
        if (a2 == null || mBFeedBackDialog == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17 && a2.isDestroyed()) {
            return false;
        }
        try {
            if (mBFeedBackDialog.isShowing() || a2.isFinishing()) {
                return false;
            }
            mBFeedBackDialog.show();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog != null) {
            return a(context, mBFeedBackDialog);
        }
        q.b("", "mbAlertDialog  is null");
        return false;
    }

    public final void a(String str, int i, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.b.a.a c2 = c(str);
        if (c2.c() != null) {
            c2.a(i);
            if (i == 0) {
                a(str, com.mbridge.msdk.foundation.controller.a.e().g(), viewGroup, (ViewGroup.LayoutParams) null, (a) null);
            }
        }
    }

    public final void a(String str, int i, int i2, int i3, float f2, float f3, float f4, String str2, String str3, float f5, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.b.a.a c2 = c(str);
        Context g = com.mbridge.msdk.foundation.controller.a.e().g();
        c2.a(u.b(g, f2), u.b(g, f3), u.b(g, (float) i), u.b(g, (float) i2), u.b(g, (float) i3), f4, str2, str3, f5, jSONArray);
    }

    public final boolean b() {
        this.f = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (this.f == null) {
            this.f = com.mbridge.msdk.b.b.a().b();
        }
        return this.f.Z() != 0;
    }

    public final void a(String str, a aVar) {
        com.mbridge.msdk.foundation.b.a.a c2 = c(str);
        if (aVar != null) {
            c2.a(new a.C0058a(str, aVar));
        }
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3, android.content.Context r4, android.view.ViewGroup r5, android.view.ViewGroup.LayoutParams r6, com.mbridge.msdk.foundation.b.a r7) {
        /*
            r2 = this;
            boolean r0 = r2.b()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.mbridge.msdk.foundation.b.a.a r0 = r2.c(r3)
            if (r7 == 0) goto L_0x0015
            com.mbridge.msdk.foundation.b.a.a$a r1 = new com.mbridge.msdk.foundation.b.a.a$a
            r1.<init>(r3, r7)
            r0.a((com.mbridge.msdk.foundation.b.a.a.C0058a) r1)
        L_0x0015:
            com.mbridge.msdk.widget.FeedBackButton r3 = r0.c()
            if (r3 == 0) goto L_0x0057
            if (r6 != 0) goto L_0x0032
            com.mbridge.msdk.foundation.controller.a r6 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r6 = r6.g()
            r7 = 1092616192(0x41200000, float:10.0)
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r6, (float) r7)
            android.widget.RelativeLayout$LayoutParams r7 = r2.e
            r7.setMargins(r6, r6, r6, r6)
            android.widget.RelativeLayout$LayoutParams r6 = r2.e
        L_0x0032:
            android.view.ViewParent r7 = r3.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            if (r7 == 0) goto L_0x003d
            r7.removeView(r3)
        L_0x003d:
            android.app.Activity r4 = r2.a((android.content.Context) r4)
            if (r4 == 0) goto L_0x004f
            if (r5 != 0) goto L_0x004f
            r5 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r4 = r4.findViewById(r5)
            r5 = r4
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
        L_0x004f:
            if (r5 == 0) goto L_0x0057
            r5.removeView(r3)
            r5.addView(r3, r6)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.b.b.a(java.lang.String, android.content.Context, android.view.ViewGroup, android.view.ViewGroup$LayoutParams, com.mbridge.msdk.foundation.b.a):void");
    }

    public final void a(String str, int i) {
        com.mbridge.msdk.foundation.b.a.a c2 = c(str);
        if (i == 1) {
            c2.b();
        } else {
            c2.a();
        }
    }

    public final void a(String str, CampaignEx campaignEx) {
        c(str).a(campaignEx);
    }

    public final void b(String str, int i) {
        c(str).b(i);
    }

    public final void c(String str, int i) {
        c(str).c(i);
    }

    private com.mbridge.msdk.foundation.b.a.a c(String str) {
        com.mbridge.msdk.foundation.b.a.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.a.e().h();
        }
        if (!this.d.containsKey(str)) {
            aVar = new com.mbridge.msdk.foundation.b.a.a(str);
            this.d.put(str, aVar);
        } else {
            aVar = this.d.get(str);
        }
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.b.a.a aVar2 = new com.mbridge.msdk.foundation.b.a.a(str);
        this.d.put(str, aVar2);
        return aVar2;
    }

    public final void a(String str, FeedBackButton feedBackButton) {
        c(str).a(feedBackButton);
    }

    public final FeedBackButton a(String str) {
        return c(str).c();
    }

    public final void a(String str, int i, int i2, String str2) {
        String str3;
        String str4;
        com.mbridge.msdk.foundation.b.a.a c2 = c(str);
        CampaignEx e2 = c2.e();
        if (e2 != null) {
            str3 = e2.getCampaignUnitId();
        } else {
            str3 = "";
        }
        int f2 = c2.f();
        int g = c2.g();
        if (!TextUtils.isEmpty(str2)) {
            str4 = str2;
        } else {
            str4 = "";
        }
        d.a(e2, str3, f2, g, str4, i, e2 != null ? e2.getAdType() : 0, i2);
    }

    public final void b(String str) {
        com.mbridge.msdk.foundation.b.a.a aVar = null;
        try {
            String h = TextUtils.isEmpty(str) ? com.mbridge.msdk.foundation.controller.a.e().h() : str;
            if (this.d.containsKey(h)) {
                aVar = this.d.get(h);
            }
            if (aVar != null) {
                aVar.d();
            }
            this.d.remove(str);
            c = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
