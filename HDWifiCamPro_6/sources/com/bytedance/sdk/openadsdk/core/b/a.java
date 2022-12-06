package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.l.y;
import java.lang.ref.WeakReference;

/* compiled from: ClickCreativeListener */
public class a extends b {
    private boolean F = false;
    private boolean G = false;
    private WeakReference<C0043a> H;
    private int I;
    private boolean a = true;

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* compiled from: ClickCreativeListener */
    public interface C0043a {
        long getVideoProgress();
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public a(Context context, n nVar, String str, int i) {
        super(context, nVar, str, i);
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void b(boolean z) {
        this.F = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02ac, code lost:
        if ((r2 instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView) == false) goto L_0x02ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02c4, code lost:
        if (((java.lang.Boolean) r2.getTag(com.bytedance.sdk.component.utils.t.e(com.bytedance.sdk.openadsdk.core.m.a(), "tt_id_is_video_picture"))).booleanValue() != false) goto L_0x02c6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r24, float r25, float r26, float r27, float r28, android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c.a> r29, boolean r30) {
        /*
            r23 = this;
            r11 = r23
            r10 = r24
            r9 = r30
            r2 = 2
            r0 = r23
            r1 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            boolean r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r0 == 0) goto L_0x001e
            return
        L_0x001e:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r11.d
            if (r0 == 0) goto L_0x00c0
            com.bytedance.sdk.openadsdk.core.model.n r0 = r11.d
            boolean r0 = r0.aw()
            if (r0 == 0) goto L_0x00c0
            if (r10 == 0) goto L_0x003f
            android.content.Context r0 = r11.b
            java.lang.String r1 = "tt_id_vast_click_type"
            int r0 = com.bytedance.sdk.component.utils.t.e(r0, r1)
            java.lang.Object r0 = r10.getTag(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x003f
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0041
        L_0x003f:
            java.lang.String r0 = "VAST_ACTION_BUTTON"
        L_0x0041:
            com.bytedance.sdk.openadsdk.core.model.n r1 = r11.d
            com.bytedance.sdk.openadsdk.core.f.a r1 = r1.ax()
            r1.e(r0)
            java.lang.String r1 = r23.f()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0057
            r11.a((java.lang.String) r0)
        L_0x0057:
            r1 = 0
            java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.b.a$a> r3 = r11.H
            if (r3 == 0) goto L_0x006f
            java.lang.Object r3 = r3.get()
            if (r3 == 0) goto L_0x006f
            java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.b.a$a> r1 = r11.H
            java.lang.Object r1 = r1.get()
            com.bytedance.sdk.openadsdk.core.b.a$a r1 = (com.bytedance.sdk.openadsdk.core.b.a.C0043a) r1
            long r1 = r1.getVideoProgress()
        L_0x006f:
            java.lang.String r3 = "VAST_ICON"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0091
            com.bytedance.sdk.openadsdk.core.model.n r0 = r11.d
            com.bytedance.sdk.openadsdk.core.f.a r0 = r0.ax()
            com.bytedance.sdk.openadsdk.core.f.b r0 = r0.b()
            if (r0 == 0) goto L_0x00c0
            com.bytedance.sdk.openadsdk.core.model.n r0 = r11.d
            com.bytedance.sdk.openadsdk.core.f.a r0 = r0.ax()
            com.bytedance.sdk.openadsdk.core.f.b r0 = r0.b()
            r0.a((long) r1)
            goto L_0x00c0
        L_0x0091:
            java.lang.String r3 = "VAST_END_CARD"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b3
            com.bytedance.sdk.openadsdk.core.model.n r0 = r11.d
            com.bytedance.sdk.openadsdk.core.f.a r0 = r0.ax()
            com.bytedance.sdk.openadsdk.core.f.c r0 = r0.c()
            if (r0 == 0) goto L_0x00c0
            com.bytedance.sdk.openadsdk.core.model.n r0 = r11.d
            com.bytedance.sdk.openadsdk.core.f.a r0 = r0.ax()
            com.bytedance.sdk.openadsdk.core.f.c r0 = r0.c()
            r0.a((long) r1)
            goto L_0x00c0
        L_0x00b3:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r11.d
            com.bytedance.sdk.openadsdk.core.f.a r0 = r0.ax()
            com.bytedance.sdk.openadsdk.core.f.d r0 = r0.a()
            r0.g((long) r1)
        L_0x00c0:
            boolean r0 = r23.i()
            java.lang.String r1 = "ClickCreativeListener"
            if (r0 == 0) goto L_0x00db
            boolean r0 = r23.d(r24)
            if (r0 == 0) goto L_0x00db
            boolean r0 = r11.G
            if (r0 != 0) goto L_0x00db
            java.lang.String r0 = "Intercept the native video view , Select the normal click event....."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            super.a(r24, r25, r26, r27, r28, r29, r30)
            return
        L_0x00db:
            java.lang.String r0 = "Select creative area click event....."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            android.content.Context r0 = r11.b
            if (r0 != 0) goto L_0x00ea
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.m.a()
            r11.b = r0
        L_0x00ea:
            android.content.Context r0 = r11.b
            if (r0 != 0) goto L_0x00ef
            return
        L_0x00ef:
            boolean r0 = r11.a(r10, r9)
            if (r0 != 0) goto L_0x00f6
            return
        L_0x00f6:
            org.json.JSONObject r0 = com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.a((android.view.View) r24)
            com.bytedance.sdk.openadsdk.core.model.j r1 = r11.c
            r18 = -1
            if (r1 == 0) goto L_0x010d
            com.bytedance.sdk.openadsdk.core.model.j r0 = r11.c
            int r0 = r0.l
            com.bytedance.sdk.openadsdk.core.model.j r1 = r11.c
            org.json.JSONObject r1 = r1.m
            r16 = r0
            r17 = r1
            goto L_0x0111
        L_0x010d:
            r17 = r0
            r16 = r18
        L_0x0111:
            long r6 = r11.w
            long r4 = r11.x
            java.lang.ref.WeakReference r0 = r11.g
            if (r0 != 0) goto L_0x011e
            android.view.View r0 = r23.d()
            goto L_0x0126
        L_0x011e:
            java.lang.ref.WeakReference r0 = r11.g
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
        L_0x0126:
            r19 = r0
            java.lang.ref.WeakReference r0 = r11.h
            if (r0 != 0) goto L_0x0131
            android.view.View r0 = r23.e()
            goto L_0x0139
        L_0x0131:
            java.lang.ref.WeakReference r0 = r11.h
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
        L_0x0139:
            r20 = r0
            java.lang.String r12 = r23.f()
            android.content.Context r0 = r11.b
            float r13 = com.bytedance.sdk.openadsdk.l.z.e((android.content.Context) r0)
            android.content.Context r0 = r11.b
            int r14 = com.bytedance.sdk.openadsdk.l.z.g(r0)
            android.content.Context r0 = r11.b
            float r15 = com.bytedance.sdk.openadsdk.l.z.f((android.content.Context) r0)
            r0 = r23
            r1 = r25
            r2 = r26
            r3 = r27
            r21 = r4
            r4 = r28
            r5 = r29
            r8 = r21
            r10 = r19
            r11 = r20
            com.bytedance.sdk.openadsdk.core.model.g r0 = r0.a(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17)
            r1 = r23
            r1.i = r0
            com.bytedance.sdk.openadsdk.core.model.n r0 = r1.d
            int r0 = r0.L()
            r2 = 4
            r3 = 3
            r4 = 1
            r5 = 2
            if (r0 == r5) goto L_0x0235
            if (r0 == r3) goto L_0x0235
            if (r0 == r2) goto L_0x01c9
            r2 = 5
            if (r0 == r2) goto L_0x0186
            r2 = r24
            r0 = r18
            goto L_0x0306
        L_0x0186:
            java.lang.String r2 = r1.e
            java.lang.String r10 = r1.b((java.lang.String) r2)
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 != 0) goto L_0x01a5
            android.content.Context r6 = r1.b
            com.bytedance.sdk.openadsdk.core.model.n r8 = r1.d
            com.bytedance.sdk.openadsdk.core.model.g r9 = r1.i
            r11 = 1
            java.util.Map r12 = r1.o
            if (r30 == 0) goto L_0x019f
            r13 = r4
            goto L_0x01a0
        L_0x019f:
            r13 = r5
        L_0x01a0:
            java.lang.String r7 = "click_call"
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r6, (java.lang.String) r7, (com.bytedance.sdk.openadsdk.core.model.n) r8, (com.bytedance.sdk.openadsdk.core.model.g) r9, (java.lang.String) r10, (boolean) r11, (java.util.Map<java.lang.String, java.lang.Object>) r12, (int) r13)
        L_0x01a5:
            android.content.Context r2 = r24.getContext()
            com.bytedance.sdk.openadsdk.core.model.n r3 = r1.d
            java.lang.String r3 = r3.Q()
            boolean r11 = com.bytedance.sdk.openadsdk.l.y.c(r2, r3)
            android.content.Context r6 = r1.b
            com.bytedance.sdk.openadsdk.core.model.n r8 = r1.d
            com.bytedance.sdk.openadsdk.core.model.g r9 = r1.i
            java.lang.String r10 = r1.e
            java.util.Map r12 = r1.o
            if (r30 == 0) goto L_0x01c1
            r13 = r4
            goto L_0x01c2
        L_0x01c1:
            r13 = r5
        L_0x01c2:
            java.lang.String r7 = "click"
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r6, (java.lang.String) r7, (com.bytedance.sdk.openadsdk.core.model.n) r8, (com.bytedance.sdk.openadsdk.core.model.g) r9, (java.lang.String) r10, (boolean) r11, (java.util.Map<java.lang.String, java.lang.Object>) r12, (int) r13)
            goto L_0x0231
        L_0x01c9:
            com.bytedance.sdk.openadsdk.core.model.n r2 = r1.d
            boolean r2 = com.bytedance.sdk.openadsdk.core.model.p.a((com.bytedance.sdk.openadsdk.core.model.n) r2)
            if (r2 == 0) goto L_0x020f
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r2 = r1.k
            if (r2 != 0) goto L_0x01d9
            com.bytedance.sdk.openadsdk.api.PangleAd r2 = r1.p
            if (r2 == 0) goto L_0x020f
        L_0x01d9:
            android.content.Context r6 = r1.b
            com.bytedance.sdk.openadsdk.core.model.n r7 = r1.d
            int r8 = r1.f
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r9 = r1.k
            com.bytedance.sdk.openadsdk.api.PangleAd r10 = r1.p
            java.lang.String r11 = r1.e
            com.com.bytedance.overseas.sdk.a.c r12 = r1.n
            r13 = 1
            boolean r19 = com.bytedance.sdk.openadsdk.core.w.a((android.content.Context) r6, (com.bytedance.sdk.openadsdk.core.model.n) r7, (int) r8, (com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd) r9, (com.bytedance.sdk.openadsdk.api.PangleAd) r10, (java.lang.String) r11, (com.com.bytedance.overseas.sdk.a.c) r12, (boolean) r13)
            boolean r2 = r1.a
            if (r2 == 0) goto L_0x0231
            android.content.Context r14 = r1.b
            com.bytedance.sdk.openadsdk.core.model.n r2 = r1.d
            com.bytedance.sdk.openadsdk.core.model.g r3 = r1.i
            java.lang.String r6 = r1.e
            java.util.Map r7 = r1.o
            if (r30 == 0) goto L_0x01ff
            r21 = r4
            goto L_0x0201
        L_0x01ff:
            r21 = r5
        L_0x0201:
            java.lang.String r15 = "click"
            r16 = r2
            r17 = r3
            r18 = r6
            r20 = r7
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r14, (java.lang.String) r15, (com.bytedance.sdk.openadsdk.core.model.n) r16, (com.bytedance.sdk.openadsdk.core.model.g) r17, (java.lang.String) r18, (boolean) r19, (java.util.Map<java.lang.String, java.lang.Object>) r20, (int) r21)
            goto L_0x0231
        L_0x020f:
            com.com.bytedance.overseas.sdk.a.c r2 = r1.n
            if (r2 == 0) goto L_0x0231
            com.com.bytedance.overseas.sdk.a.c r2 = r1.n
            r2.d()
            boolean r2 = r1.a
            if (r2 == 0) goto L_0x0231
            android.content.Context r6 = r1.b
            com.bytedance.sdk.openadsdk.core.model.n r8 = r1.d
            com.bytedance.sdk.openadsdk.core.model.g r9 = r1.i
            java.lang.String r10 = r1.e
            r11 = 1
            java.util.Map r12 = r1.o
            if (r30 == 0) goto L_0x022b
            r13 = r4
            goto L_0x022c
        L_0x022b:
            r13 = r5
        L_0x022c:
            java.lang.String r7 = "click"
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r6, (java.lang.String) r7, (com.bytedance.sdk.openadsdk.core.model.n) r8, (com.bytedance.sdk.openadsdk.core.model.g) r9, (java.lang.String) r10, (boolean) r11, (java.util.Map<java.lang.String, java.lang.Object>) r12, (int) r13)
        L_0x0231:
            r2 = r24
            goto L_0x0306
        L_0x0235:
            if (r0 != r3) goto L_0x0278
            com.bytedance.sdk.openadsdk.core.model.n r3 = r1.d
            java.lang.String r3 = r3.O()
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 != 0) goto L_0x0278
            java.lang.String r6 = "play.google.com/store/apps/details?id="
            boolean r6 = r3.contains(r6)
            if (r6 == 0) goto L_0x0278
            java.lang.String r6 = "?id="
            int r6 = r3.indexOf(r6)
            int r6 = r6 + r2
            java.lang.String r2 = r3.substring(r6)
            android.content.Context r3 = r1.b
            boolean r2 = com.com.bytedance.overseas.sdk.a.b.b(r3, r2)
            if (r2 == 0) goto L_0x0278
            boolean r2 = r1.a
            if (r2 == 0) goto L_0x0231
            android.content.Context r6 = r1.b
            com.bytedance.sdk.openadsdk.core.model.n r8 = r1.d
            com.bytedance.sdk.openadsdk.core.model.g r9 = r1.i
            java.lang.String r10 = r1.e
            r11 = 1
            java.util.Map r12 = r1.o
            if (r30 == 0) goto L_0x0271
            r13 = r4
            goto L_0x0272
        L_0x0271:
            r13 = r5
        L_0x0272:
            java.lang.String r7 = "click"
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r6, (java.lang.String) r7, (com.bytedance.sdk.openadsdk.core.model.n) r8, (com.bytedance.sdk.openadsdk.core.model.g) r9, (java.lang.String) r10, (boolean) r11, (java.util.Map<java.lang.String, java.lang.Object>) r12, (int) r13)
            goto L_0x0231
        L_0x0278:
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r2 = r1.k
            if (r2 != 0) goto L_0x0284
            boolean r2 = r1.F
            if (r2 == 0) goto L_0x0281
            goto L_0x0284
        L_0x0281:
            r2 = r24
            goto L_0x029a
        L_0x0284:
            android.content.Context r6 = r1.b
            com.bytedance.sdk.openadsdk.core.model.n r8 = r1.d
            com.bytedance.sdk.openadsdk.core.model.g r9 = r1.i
            java.lang.String r10 = r1.e
            r11 = 1
            java.util.Map r12 = r1.o
            if (r30 == 0) goto L_0x0293
            r13 = r4
            goto L_0x0294
        L_0x0293:
            r13 = r5
        L_0x0294:
            java.lang.String r7 = "click_button"
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r6, (java.lang.String) r7, (com.bytedance.sdk.openadsdk.core.model.n) r8, (com.bytedance.sdk.openadsdk.core.model.g) r9, (java.lang.String) r10, (boolean) r11, (java.util.Map<java.lang.String, java.lang.Object>) r12, (int) r13)
            goto L_0x0281
        L_0x029a:
            if (r2 == 0) goto L_0x02ae
            int r3 = r24.getId()     // Catch:{ Exception -> 0x02c9 }
            android.content.Context r6 = r1.b     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r7 = "tt_root_view"
            int r6 = com.bytedance.sdk.component.utils.t.e(r6, r7)     // Catch:{ Exception -> 0x02c9 }
            if (r3 == r6) goto L_0x02c6
            boolean r3 = r2 instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView     // Catch:{ Exception -> 0x02c9 }
            if (r3 != 0) goto L_0x02c6
        L_0x02ae:
            android.content.Context r3 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r6 = "tt_id_is_video_picture"
            int r3 = com.bytedance.sdk.component.utils.t.e(r3, r6)     // Catch:{ Exception -> 0x02c9 }
            java.lang.Object r3 = r2.getTag(r3)     // Catch:{ Exception -> 0x02c9 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x02c9 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x02c9 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x02c9 }
            if (r3 == 0) goto L_0x02c9
        L_0x02c6:
            com.bytedance.sdk.openadsdk.core.w.a(r4)     // Catch:{ Exception -> 0x02c9 }
        L_0x02c9:
            android.content.Context r6 = r1.b
            com.bytedance.sdk.openadsdk.core.model.n r7 = r1.d
            int r8 = r1.f
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r9 = r1.k
            com.bytedance.sdk.openadsdk.api.PangleAd r10 = r1.p
            int r3 = r1.f
            java.lang.String r11 = com.bytedance.sdk.openadsdk.l.y.a((int) r3)
            com.com.bytedance.overseas.sdk.a.c r12 = r1.n
            r13 = 1
            boolean r19 = com.bytedance.sdk.openadsdk.core.w.a((android.content.Context) r6, (com.bytedance.sdk.openadsdk.core.model.n) r7, (int) r8, (com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd) r9, (com.bytedance.sdk.openadsdk.api.PangleAd) r10, (java.lang.String) r11, (com.com.bytedance.overseas.sdk.a.c) r12, (boolean) r13)
            r3 = 0
            com.bytedance.sdk.openadsdk.core.w.a(r3)
            boolean r3 = r1.a
            if (r3 == 0) goto L_0x0306
            android.content.Context r14 = r1.b
            com.bytedance.sdk.openadsdk.core.model.n r3 = r1.d
            com.bytedance.sdk.openadsdk.core.model.g r6 = r1.i
            java.lang.String r7 = r1.e
            java.util.Map r8 = r1.o
            if (r30 == 0) goto L_0x02f7
            r21 = r4
            goto L_0x02f9
        L_0x02f7:
            r21 = r5
        L_0x02f9:
            java.lang.String r15 = "click"
            r16 = r3
            r17 = r6
            r18 = r7
            r20 = r8
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r14, (java.lang.String) r15, (com.bytedance.sdk.openadsdk.core.model.n) r16, (com.bytedance.sdk.openadsdk.core.model.g) r17, (java.lang.String) r18, (boolean) r19, (java.util.Map<java.lang.String, java.lang.Object>) r20, (int) r21)
        L_0x0306:
            com.bytedance.sdk.openadsdk.core.b.b$a r3 = r1.j
            if (r3 == 0) goto L_0x030f
            com.bytedance.sdk.openadsdk.core.b.b$a r3 = r1.j
            r3.a(r2, r0)
        L_0x030f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.b.a.a(android.view.View, float, float, float, float, android.util.SparseArray, boolean):void");
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        if (this.d == null) {
            return true;
        }
        int a2 = m.d().a(this.d.aW());
        int c = o.c(m.a());
        if (a2 == 1) {
            return y.c(c);
        }
        if (a2 != 2) {
            if (a2 == 3) {
                return false;
            }
            if (a2 == 4 || a2 != 5 || y.c(c) || y.e(c)) {
                return true;
            }
            return false;
        } else if (y.d(c) || y.c(c) || y.e(c)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean g() {
        return n.c(this.d) && this.d.p() == 1;
    }

    private boolean d(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoTsView) {
            l.c("ClickCreativeListener", "NativeVideoTsView....");
            return true;
        } else if (view.getId() == t.e(this.b, "tt_video_ad_cover_center_layout") || view.getId() == t.e(this.b, "tt_video_ad_logo_image") || view.getId() == t.e(this.b, "tt_video_btn_ad_image_tv") || view.getId() == t.e(this.b, "tt_video_ad_name") || view.getId() == t.e(this.b, "tt_video_ad_button")) {
            l.c("ClickCreativeListener", "tt_video_ad_cover_center_layout....");
            return true;
        } else if (view.getId() == t.e(this.b, "tt_root_view") || view.getId() == t.e(this.b, "tt_video_play")) {
            l.c("ClickCreativeListener", "tt_root_view....");
            return true;
        } else if (!(view instanceof ViewGroup)) {
            return false;
        } else {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return false;
                }
                if (d(viewGroup.getChildAt(i))) {
                    return true;
                }
                i++;
            }
        }
    }

    private boolean h() {
        return this instanceof d;
    }

    private boolean i() {
        if (this.d == null || h()) {
            return false;
        }
        if (this.d.ad() != 5 && this.d.ad() != 15) {
            return false;
        }
        if (this.I == 0) {
            this.I = this.d.aR();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("!isViewVisibility()=");
        sb.append(!b());
        sb.append(",isAutoPlay()=");
        sb.append(a());
        sb.append(",!isCoverPageVisibility()=");
        sb.append(!c());
        l.b("ClickCreativeListener", sb.toString());
        if (this.I == 5 && g() && a() && !b() && !c()) {
            return false;
        }
        int i = this.I;
        if (i == 1 || i == 2 || i == 5) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            java.lang.String r1 = "open_ad"
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -1695837674: goto L_0x003f;
                case -1263194568: goto L_0x0037;
                case -712491894: goto L_0x002d;
                case 1844104722: goto L_0x0023;
                case 1912999166: goto L_0x0019;
                case 2091589896: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0049
        L_0x000f:
            java.lang.String r0 = "slide_banner_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = r4
            goto L_0x004a
        L_0x0019:
            java.lang.String r0 = "draw_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = r6
            goto L_0x004a
        L_0x0023:
            java.lang.String r0 = "interaction"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = r3
            goto L_0x004a
        L_0x002d:
            java.lang.String r0 = "embeded_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = 0
            goto L_0x004a
        L_0x0037:
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0049
            r8 = r2
            goto L_0x004a
        L_0x003f:
            java.lang.String r0 = "banner_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = r5
            goto L_0x004a
        L_0x0049:
            r8 = -1
        L_0x004a:
            if (r8 == 0) goto L_0x0060
            if (r8 == r6) goto L_0x0060
            java.lang.String r0 = "banner_call"
            if (r8 == r5) goto L_0x005f
            if (r8 == r4) goto L_0x005f
            if (r8 == r3) goto L_0x005c
            if (r8 == r2) goto L_0x005b
            java.lang.String r8 = ""
            return r8
        L_0x005b:
            return r1
        L_0x005c:
            java.lang.String r8 = "interaction_call"
            return r8
        L_0x005f:
            return r0
        L_0x0060:
            java.lang.String r8 = "feed_call"
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.b.a.b(java.lang.String):java.lang.String");
    }

    public void c(boolean z) {
        this.G = z;
    }

    public void a(C0043a aVar) {
        this.H = new WeakReference<>(aVar);
    }
}
