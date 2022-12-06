package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mbridge.msdk.foundation.tools.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImpressionTracker */
public final class a {
    private WeakReference<ViewTreeObserver> a;
    private List<View> b = new ArrayList();
    private ViewTreeObserver.OnPreDrawListener c = null;
    private C0066a d;
    private Handler e;
    private boolean f;

    /* renamed from: com.mbridge.msdk.mbnative.controller.a$a  reason: collision with other inner class name */
    /* compiled from: ImpressionTracker */
    public interface C0066a {
        void a(ArrayList<View> arrayList, ArrayList<View> arrayList2);
    }

    public a(List<View> list, C0066a aVar, Handler handler) {
        this.d = aVar;
        this.e = handler;
        if (list != null) {
            this.b = list;
        } else {
            this.b.clear();
        }
        try {
            b();
        } catch (Throwable th) {
            q.a("ImpressionTracker", th.getMessage(), th);
        }
        try {
            this.c = new ViewTreeObserver.OnPreDrawListener() {
                public final boolean onPreDraw() {
                    a.this.b();
                    return true;
                }
            };
        } catch (Throwable th2) {
            q.a("ImpressionTracker", th2.getMessage(), th2);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (!this.f) {
            Handler handler = this.e;
            if (handler != null) {
                handler.postDelayed(new Runnable() {
                    public final void run() {
                        a.b(a.this);
                    }
                }, 100);
            }
            this.f = true;
        }
    }

    public final void a(View view) {
        View view2 = null;
        if (view != null) {
            view2 = d.a(view.getContext(), view);
            this.b.add(view);
        } else {
            List<View> list = this.b;
            if (list != null && list.size() > 0) {
                int i = 0;
                while (i < this.b.size() && ((r1 = this.b.get(i)) == null || (view2 = d.a(r1.getContext(), r1)) == null)) {
                    i++;
                }
            }
        }
        if (view2 != null) {
            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
            if (viewTreeObserver == null || viewTreeObserver.isAlive()) {
                this.a = new WeakReference<>(viewTreeObserver);
                ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.c;
                if (onPreDrawListener != null && viewTreeObserver != null) {
                    viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
                }
            }
        }
    }

    public final void a() {
        try {
            this.f = false;
            if (!(this.a == null || this.a.get() == null)) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.a.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.c);
                }
                this.a.clear();
            }
            this.d = null;
            this.c = null;
            if (this.b != null) {
                this.b.clear();
            }
            this.b = null;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b A[Catch:{ Exception -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f A[Catch:{ Exception -> 0x008d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.mbridge.msdk.mbnative.controller.a r11) {
        /*
            r0 = 0
            r11.f = r0     // Catch:{ Exception -> 0x008d }
            java.util.List<android.view.View> r1 = r11.b     // Catch:{ Exception -> 0x008d }
            if (r1 == 0) goto L_0x008d
            java.util.List<android.view.View> r1 = r11.b     // Catch:{ Exception -> 0x008d }
            int r1 = r1.size()     // Catch:{ Exception -> 0x008d }
            if (r1 <= 0) goto L_0x008d
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x008d }
            r1.<init>()     // Catch:{ Exception -> 0x008d }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x008d }
            r2.<init>()     // Catch:{ Exception -> 0x008d }
            r3 = r0
        L_0x001a:
            java.util.List<android.view.View> r4 = r11.b     // Catch:{ Exception -> 0x008d }
            int r4 = r4.size()     // Catch:{ Exception -> 0x008d }
            if (r3 >= r4) goto L_0x0075
            java.util.List<android.view.View> r4 = r11.b     // Catch:{ Exception -> 0x008d }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ Exception -> 0x008d }
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x008d }
            if (r4 == 0) goto L_0x0068
            int r5 = r4.getVisibility()     // Catch:{ Exception -> 0x008d }
            if (r5 == 0) goto L_0x0033
            goto L_0x0068
        L_0x0033:
            android.graphics.Rect r5 = new android.graphics.Rect     // Catch:{ Exception -> 0x008d }
            r5.<init>()     // Catch:{ Exception -> 0x008d }
            boolean r6 = r4.getGlobalVisibleRect(r5)     // Catch:{ Exception -> 0x008d }
            if (r6 != 0) goto L_0x003f
            goto L_0x0068
        L_0x003f:
            int r6 = r5.height()     // Catch:{ Exception -> 0x008d }
            int r5 = r5.width()     // Catch:{ Exception -> 0x008d }
            int r6 = r6 * r5
            long r5 = (long) r6     // Catch:{ Exception -> 0x008d }
            int r7 = r4.getHeight()     // Catch:{ Exception -> 0x008d }
            int r8 = r4.getWidth()     // Catch:{ Exception -> 0x008d }
            int r7 = r7 * r8
            long r7 = (long) r7     // Catch:{ Exception -> 0x008d }
            r9 = 0
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 > 0) goto L_0x005a
            goto L_0x0068
        L_0x005a:
            double r5 = (double) r5     // Catch:{ Exception -> 0x008d }
            double r7 = (double) r7     // Catch:{ Exception -> 0x008d }
            r9 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            double r7 = r7 * r9
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0068
            r5 = 1
            goto L_0x0069
        L_0x0068:
            r5 = r0
        L_0x0069:
            if (r5 == 0) goto L_0x006f
            r1.add(r4)     // Catch:{ Exception -> 0x008d }
            goto L_0x0072
        L_0x006f:
            r2.add(r4)     // Catch:{ Exception -> 0x008d }
        L_0x0072:
            int r3 = r3 + 1
            goto L_0x001a
        L_0x0075:
            com.mbridge.msdk.mbnative.controller.a$a r0 = r11.d     // Catch:{ Exception -> 0x008d }
            if (r0 == 0) goto L_0x007e
            com.mbridge.msdk.mbnative.controller.a$a r0 = r11.d     // Catch:{ Exception -> 0x008d }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x008d }
        L_0x007e:
            int r0 = r1.size()     // Catch:{ Exception -> 0x008d }
            if (r0 <= 0) goto L_0x0087
            r11.a()     // Catch:{ Exception -> 0x008d }
        L_0x0087:
            r1.clear()     // Catch:{ Exception -> 0x008d }
            r2.clear()     // Catch:{ Exception -> 0x008d }
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.a.b(com.mbridge.msdk.mbnative.controller.a):void");
    }
}
