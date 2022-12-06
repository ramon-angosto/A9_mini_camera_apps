package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.common.utils.s;

public final class q {
    final WeakReference<View> a;
    final a b;
    final Handler c;
    b d;
    boolean e;
    float f = -1.0f;
    Rect g = new Rect();
    boolean h = false;
    private final ViewTreeObserver.OnPreDrawListener i;
    private WeakReference<ViewTreeObserver> j;

    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r13 = this;
                sg.bigo.ads.core.mraid.q r0 = sg.bigo.ads.core.mraid.q.this
                r1 = 0
                r0.e = r1
                sg.bigo.ads.core.mraid.q$b r0 = r0.d
                if (r0 == 0) goto L_0x0106
                sg.bigo.ads.core.mraid.q r0 = sg.bigo.ads.core.mraid.q.this
                java.lang.ref.WeakReference<android.view.View> r0 = r0.a
                java.lang.Object r0 = r0.get()
                android.view.View r0 = (android.view.View) r0
                if (r0 == 0) goto L_0x0106
                android.graphics.Rect r2 = new android.graphics.Rect
                r2.<init>()
                r0.getLocalVisibleRect(r2)
                android.graphics.Rect r3 = new android.graphics.Rect
                r3.<init>()
                boolean r4 = r0.getGlobalVisibleRect(r3)
                r5 = 2
                int[] r5 = new int[r5]
                r0.getLocationOnScreen(r5)
                boolean r6 = r0.isShown()
                float r7 = r0.getAlpha()
                r8 = 0
                int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
                r9 = 1
                if (r7 != 0) goto L_0x003c
                r7 = r9
                goto L_0x003d
            L_0x003c:
                r7 = r1
            L_0x003d:
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                if (r4 == 0) goto L_0x008d
                if (r6 == 0) goto L_0x008d
                if (r7 == 0) goto L_0x0049
                goto L_0x008d
            L_0x0049:
                android.util.Pair r3 = sg.bigo.ads.core.mraid.q.a((android.graphics.Rect) r3, (android.view.View) r0)
                java.lang.Object r11 = r3.first
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto L_0x0058
                goto L_0x008d
            L_0x0058:
                java.lang.Object r3 = r3.second
                java.util.List r3 = (java.util.List) r3
                sg.bigo.ads.core.mraid.m r10 = new sg.bigo.ads.core.mraid.m
                r10.<init>(r3, r5)
                float r3 = r10.a()
                int r5 = r0.getWidth()
                int r11 = r0.getHeight()
                int r5 = r5 * r11
                float r5 = (float) r5
                int r11 = r2.width()
                int r12 = r2.height()
                int r11 = r11 * r12
                float r11 = (float) r11
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 <= 0) goto L_0x0087
                r8 = 1120403456(0x42c80000, float:100.0)
                float r12 = r11 * r8
                float r12 = r12 / r5
                float r11 = r11 - r3
                float r11 = r11 * r8
                float r11 = r11 / r5
                r8 = r11
                goto L_0x0088
            L_0x0087:
                r12 = r8
            L_0x0088:
                java.util.List<android.graphics.Rect> r10 = r10.a
                r3 = r8
                r8 = r12
                goto L_0x008e
            L_0x008d:
                r3 = r8
            L_0x008e:
                sg.bigo.ads.core.mraid.q r5 = sg.bigo.ads.core.mraid.q.this
                float r5 = r5.f
                int r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
                if (r5 != 0) goto L_0x00a0
                sg.bigo.ads.core.mraid.q r5 = sg.bigo.ads.core.mraid.q.this
                android.graphics.Rect r5 = r5.g
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L_0x0106
            L_0x00a0:
                sg.bigo.ads.core.mraid.q r5 = sg.bigo.ads.core.mraid.q.this
                boolean r11 = r5.h
                if (r11 == 0) goto L_0x00a7
                goto L_0x00a8
            L_0x00a7:
                r3 = r8
            L_0x00a8:
                r5.f = r3
                sg.bigo.ads.core.mraid.q r3 = sg.bigo.ads.core.mraid.q.this
                r3.g = r2
                android.content.res.Resources r0 = r0.getResources()
                android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
                sg.bigo.ads.core.mraid.q r2 = sg.bigo.ads.core.mraid.q.this
                boolean r2 = r2.h
                if (r2 == 0) goto L_0x00e4
                sg.bigo.ads.core.mraid.q r2 = sg.bigo.ads.core.mraid.q.this
                sg.bigo.ads.core.mraid.q$b r2 = r2.d
                if (r4 == 0) goto L_0x00c7
                if (r6 == 0) goto L_0x00c7
                if (r7 != 0) goto L_0x00c7
                r1 = r9
            L_0x00c7:
                sg.bigo.ads.core.mraid.b r3 = new sg.bigo.ads.core.mraid.b
                sg.bigo.ads.core.mraid.q r4 = sg.bigo.ads.core.mraid.q.this
                float r4 = r4.f
                sg.bigo.ads.core.mraid.q r5 = sg.bigo.ads.core.mraid.q.this
                android.graphics.Rect r5 = r5.g
                int r6 = r0.densityDpi
                android.graphics.Rect r5 = sg.bigo.ads.core.mraid.q.a((android.graphics.Rect) r5, (int) r6)
                int r0 = r0.densityDpi
                java.util.List r0 = sg.bigo.ads.core.mraid.q.a((java.util.List) r10, (int) r0)
                r3.<init>(r4, r5, r0)
                r2.a(r1, r3)
                return
            L_0x00e4:
                sg.bigo.ads.core.mraid.q r2 = sg.bigo.ads.core.mraid.q.this
                sg.bigo.ads.core.mraid.q$b r2 = r2.d
                if (r4 == 0) goto L_0x00ef
                if (r6 == 0) goto L_0x00ef
                if (r7 != 0) goto L_0x00ef
                r1 = r9
            L_0x00ef:
                sg.bigo.ads.core.mraid.b r3 = new sg.bigo.ads.core.mraid.b
                sg.bigo.ads.core.mraid.q r4 = sg.bigo.ads.core.mraid.q.this
                float r4 = r4.f
                sg.bigo.ads.core.mraid.q r5 = sg.bigo.ads.core.mraid.q.this
                android.graphics.Rect r5 = r5.g
                int r0 = r0.densityDpi
                android.graphics.Rect r0 = sg.bigo.ads.core.mraid.q.a((android.graphics.Rect) r5, (int) r0)
                r5 = 0
                r3.<init>(r4, r0, r5)
                r2.a(r1, r3)
            L_0x0106:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.mraid.q.a.run():void");
        }
    }

    public interface b {
        void a(boolean z, b bVar);
    }

    public q(View view) {
        String str;
        this.a = new WeakReference<>(view);
        this.c = new Handler();
        this.b = new a();
        this.i = new ViewTreeObserver.OnPreDrawListener() {
            public final boolean onPreDraw() {
                q qVar = q.this;
                if (!qVar.e) {
                    qVar.e = true;
                    qVar.c.postDelayed(qVar.b, 500);
                }
                return true;
            }
        };
        this.j = new WeakReference<>((Object) null);
        Context context = view.getContext();
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.j.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View a2 = s.a(context, view);
            if (a2 == null) {
                str = "Unable to set Visibility Tracker due to no available root view.";
            } else {
                ViewTreeObserver viewTreeObserver2 = a2.getViewTreeObserver();
                if (!viewTreeObserver2.isAlive()) {
                    str = "Visibility Tracker was unable to track views because the root view tree observer was not alive";
                } else {
                    this.j = new WeakReference<>(viewTreeObserver2);
                    viewTreeObserver2.addOnPreDrawListener(this.i);
                    return;
                }
            }
            sg.bigo.ads.common.k.a.a(0, "VisibilityTracker", str);
        }
    }

    static Rect a(Rect rect, int i2) {
        return new Rect((rect.left * 160) / i2, (rect.top * 160) / i2, (rect.right * 160) / i2, (rect.bottom * 160) / i2);
    }

    static /* synthetic */ Pair a(Rect rect, View view) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        ViewGroup viewGroup2 = view;
        loop0:
        while (true) {
            View view2 = viewGroup2;
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            while (true) {
                z = true;
                if (viewGroup3 == null) {
                    z = false;
                    break loop0;
                } else if (viewGroup3.getAlpha() == 0.0f) {
                    break loop0;
                } else {
                    for (int indexOfChild = viewGroup3.indexOfChild(view2) + 1; indexOfChild < viewGroup3.getChildCount(); indexOfChild++) {
                        View childAt = viewGroup3.getChildAt(indexOfChild);
                        if (childAt.getVisibility() == 0) {
                            Rect rect2 = new Rect();
                            childAt.getGlobalVisibleRect(rect2);
                            if (Rect.intersects(rect, rect2)) {
                                arrayList.add(new Rect(Math.max(rect.left, rect2.left), Math.max(rect.top, rect2.top), Math.min(rect.right, rect2.right), Math.min(rect.bottom, rect2.bottom)));
                            }
                        }
                    }
                    if (viewGroup3 != viewGroup) {
                        viewGroup2 = viewGroup3;
                    } else {
                        viewGroup3 = null;
                    }
                }
            }
        }
        return new Pair(Boolean.valueOf(z), arrayList);
    }

    static /* synthetic */ List a(List list, int i2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((Rect) it.next(), i2));
        }
        return arrayList;
    }
}
