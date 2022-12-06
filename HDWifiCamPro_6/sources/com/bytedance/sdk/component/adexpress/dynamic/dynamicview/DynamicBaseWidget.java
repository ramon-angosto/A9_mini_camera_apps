package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.a;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.f;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.List;

public abstract class DynamicBaseWidget extends FrameLayout implements b, c, d {
    private static final View.OnTouchListener u = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener v = new View.OnClickListener() {
        public void onClick(View view) {
        }
    };
    private float a;
    private float b;
    protected float c;
    protected float d;
    protected float e;
    protected float f;
    protected int g = ((int) com.bytedance.sdk.component.adexpress.c.b.a(this.k, this.e));
    protected int h = ((int) com.bytedance.sdk.component.adexpress.c.b.a(this.k, this.f));
    protected int i = ((int) com.bytedance.sdk.component.adexpress.c.b.a(this.k, this.c));
    protected int j = ((int) com.bytedance.sdk.component.adexpress.c.b.a(this.k, this.d));
    protected Context k;
    protected g l;
    protected h m;
    protected DynamicRootView n;
    protected View o;
    protected boolean p;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.a.b q;
    a r;
    private float s;
    private float t;

    public float getShineValue() {
        return this.b;
    }

    public void setShineValue(float f2) {
        this.b = f2;
        postInvalidate();
    }

    public float getRippleValue() {
        return this.a;
    }

    public void setRippleValue(float f2) {
        this.a = f2;
        postInvalidate();
    }

    public float getMarqueeValue() {
        return this.s;
    }

    public void setMarqueeValue(float f2) {
        this.s = f2;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.t;
    }

    public void setStretchValue(float f2) {
        this.t = f2;
        this.r.a(this, f2);
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context);
        this.k = context;
        this.n = dynamicRootView;
        this.m = hVar;
        this.c = hVar.e();
        this.d = hVar.f();
        this.e = hVar.g();
        this.f = hVar.h();
        this.l = new g(hVar.i());
        if (this.l.r() > 0) {
            this.g += this.l.r() * 2;
            this.h += this.l.r() * 2;
            this.i -= this.l.r();
            this.j -= this.l.r();
            List<h> j2 = hVar.j();
            if (j2 != null) {
                for (h next : j2) {
                    next.c(next.e() + ((float) com.bytedance.sdk.component.adexpress.c.b.b(this.k, (float) this.l.r())));
                    next.d(next.f() + ((float) com.bytedance.sdk.component.adexpress.c.b.b(this.k, (float) this.l.r())));
                    next.a((float) com.bytedance.sdk.component.adexpress.c.b.b(this.k, (float) this.l.r()));
                    next.b((float) com.bytedance.sdk.component.adexpress.c.b.b(this.k, (float) this.l.r()));
                }
            }
        }
        this.p = this.l.n() > 0.0d;
        this.r = new a();
    }

    public void setShouldInvisible(boolean z) {
        this.p = z;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.p;
    }

    public boolean c() {
        i();
        f();
        d();
        return true;
    }

    public void a(int i2) {
        g gVar = this.l;
        if (gVar != null && gVar.a(i2)) {
            i();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (getChildAt(i3) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).a(i2);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v13, types: [com.bytedance.sdk.component.adexpress.dynamic.d.a] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r4 = this;
            android.view.View r0 = r4.o
            if (r0 != 0) goto L_0x0005
            r0 = r4
        L_0x0005:
            boolean r1 = r4.e()
            r2 = 0
            if (r1 == 0) goto L_0x001a
            com.bytedance.sdk.component.adexpress.dynamic.d.a r1 = r4.getDynamicClickListener()
            r2 = r1
            android.view.View$OnTouchListener r2 = (android.view.View.OnTouchListener) r2
            com.bytedance.sdk.component.adexpress.dynamic.d.a r1 = r4.getDynamicClickListener()
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            goto L_0x0038
        L_0x001a:
            boolean r1 = com.bytedance.sdk.component.adexpress.d.b()
            if (r1 == 0) goto L_0x0037
            com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView r1 = r4.n
            com.bytedance.sdk.component.adexpress.b.l r1 = r1.getRenderRequest()
            java.lang.String r1 = r1.b()
            java.lang.String r3 = "open_ad"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0037
            android.view.View$OnTouchListener r2 = u
            android.view.View$OnClickListener r1 = v
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            if (r2 == 0) goto L_0x0042
            if (r1 == 0) goto L_0x0042
            r0.setOnTouchListener(r2)
            r0.setOnClickListener(r1)
        L_0x0042:
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "tt_id_click_tag"
            int r1 = com.bytedance.sdk.component.utils.t.e(r1, r2)
            com.bytedance.sdk.component.adexpress.dynamic.b.g r2 = r4.l
            java.lang.String r2 = r2.B()
            r0.setTag(r1, r2)
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "tt_id_click_area_type"
            int r1 = com.bytedance.sdk.component.utils.t.e(r1, r2)
            com.bytedance.sdk.component.adexpress.dynamic.b.h r2 = r4.m
            com.bytedance.sdk.component.adexpress.dynamic.b.e r2 = r2.i()
            java.lang.String r2 = r2.b()
            r0.setTag(r1, r2)
            r4.a((android.view.View) r0)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.d():boolean");
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        f e2;
        h hVar = this.m;
        if (hVar != null && (e2 = hVar.i().e()) != null) {
            view.setTag(t.e(getContext(), "tt_id_open_landing_page"), Boolean.valueOf(e2.ao()));
        }
    }

    public boolean e() {
        g gVar = this.l;
        return (gVar == null || gVar.x() == 0) ? false : true;
    }

    public void f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.g, this.h);
        layoutParams.topMargin = this.j;
        layoutParams.leftMargin = this.i;
        setLayoutParams(layoutParams);
    }

    public int getClickArea() {
        return this.l.x();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.d.a getDynamicClickListener() {
        return this.n.getDynamicClickListener();
    }

    /* access modifiers changed from: protected */
    public Drawable getBackgroundDrawable() {
        return a(false, "");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:2|3|(1:8)(1:7)|9|10|11|(1:15)|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x00d2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable a(boolean r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = ","
            java.lang.String r1 = "%"
            com.bytedance.sdk.component.adexpress.dynamic.b.g r2 = r8.l
            java.lang.String r2 = r2.A()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 0
            if (r2 != 0) goto L_0x00f6
            com.bytedance.sdk.component.adexpress.dynamic.b.g r2 = r8.l     // Catch:{ Exception -> 0x00ef }
            java.lang.String r2 = r2.A()     // Catch:{ Exception -> 0x00ef }
            java.lang.String r4 = "("
            int r4 = r2.indexOf(r4)     // Catch:{ Exception -> 0x00ef }
            r5 = 1
            int r4 = r4 + r5
            int r6 = r2.length()     // Catch:{ Exception -> 0x00ef }
            int r6 = r6 - r5
            java.lang.String r2 = r2.substring(r4, r6)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r4 = "rgba"
            boolean r4 = r2.contains(r4)     // Catch:{ Exception -> 0x00ef }
            r6 = 2
            if (r4 == 0) goto L_0x007e
            boolean r4 = r2.contains(r1)     // Catch:{ Exception -> 0x00ef }
            if (r4 == 0) goto L_0x007e
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00ef }
            int r7 = r2.indexOf(r0)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r7 = r2.substring(r3, r7)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r7 = r7.trim()     // Catch:{ Exception -> 0x00ef }
            r4[r3] = r7     // Catch:{ Exception -> 0x00ef }
            int r0 = r2.indexOf(r0)     // Catch:{ Exception -> 0x00ef }
            int r0 = r0 + r5
            int r7 = r2.indexOf(r1)     // Catch:{ Exception -> 0x00ef }
            int r7 = r7 + r5
            java.lang.String r0 = r2.substring(r0, r7)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00ef }
            r4[r5] = r0     // Catch:{ Exception -> 0x00ef }
            int r0 = r2.indexOf(r1)     // Catch:{ Exception -> 0x00ef }
            int r0 = r0 + r6
            java.lang.String r0 = r2.substring(r0)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00ef }
            r4[r6] = r0     // Catch:{ Exception -> 0x00ef }
            int[] r0 = new int[r6]     // Catch:{ Exception -> 0x00ef }
            r1 = r4[r5]     // Catch:{ Exception -> 0x00ef }
            int r1 = com.bytedance.sdk.component.adexpress.dynamic.b.g.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00ef }
            r0[r3] = r1     // Catch:{ Exception -> 0x00ef }
            r1 = r4[r6]     // Catch:{ Exception -> 0x00ef }
            int r1 = com.bytedance.sdk.component.adexpress.dynamic.b.g.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00ef }
            r0[r5] = r1     // Catch:{ Exception -> 0x00ef }
            goto L_0x009f
        L_0x007e:
            java.lang.String r0 = ", "
            java.lang.String[] r4 = r2.split(r0)     // Catch:{ Exception -> 0x00ef }
            int[] r0 = new int[r6]     // Catch:{ Exception -> 0x00ef }
            r1 = r4[r5]     // Catch:{ Exception -> 0x00ef }
            r7 = 7
            java.lang.String r1 = r1.substring(r3, r7)     // Catch:{ Exception -> 0x00ef }
            int r1 = com.bytedance.sdk.component.adexpress.dynamic.b.g.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00ef }
            r0[r3] = r1     // Catch:{ Exception -> 0x00ef }
            r1 = r4[r6]     // Catch:{ Exception -> 0x00ef }
            java.lang.String r1 = r1.substring(r3, r7)     // Catch:{ Exception -> 0x00ef }
            int r1 = com.bytedance.sdk.component.adexpress.dynamic.b.g.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00ef }
            r0[r5] = r1     // Catch:{ Exception -> 0x00ef }
        L_0x009f:
            java.lang.String r1 = "linear-gradient("
            int r1 = r2.indexOf(r1)     // Catch:{ Exception -> 0x00d2 }
            int r1 = r1 + r5
            java.lang.String r6 = "deg"
            int r6 = r2.indexOf(r6)     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r1 = r2.substring(r1, r6)     // Catch:{ Exception -> 0x00d2 }
            double r1 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00d2 }
            r6 = 4642120500284227584(0x406c200000000000, double:225.0)
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00d2
            r6 = 4644249154795601920(0x4073b00000000000, double:315.0)
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x00d2
            int r1 = r0.length     // Catch:{ Exception -> 0x00d2 }
            int r1 = r1 - r5
            r1 = r0[r1]     // Catch:{ Exception -> 0x00d2 }
            int r2 = r0.length     // Catch:{ Exception -> 0x00d2 }
            int r2 = r2 - r5
            r5 = r0[r3]     // Catch:{ Exception -> 0x00d2 }
            r0[r2] = r5     // Catch:{ Exception -> 0x00d2 }
            r0[r3] = r1     // Catch:{ Exception -> 0x00d2 }
        L_0x00d2:
            r1 = r4[r3]     // Catch:{ Exception -> 0x00ef }
            android.graphics.drawable.GradientDrawable$Orientation r1 = r8.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00ef }
            android.graphics.drawable.GradientDrawable r0 = r8.a((android.graphics.drawable.GradientDrawable.Orientation) r1, (int[]) r0)     // Catch:{ Exception -> 0x00ef }
            r0.setShape(r3)     // Catch:{ Exception -> 0x00ef }
            android.content.Context r1 = r8.k     // Catch:{ Exception -> 0x00ef }
            com.bytedance.sdk.component.adexpress.dynamic.b.g r2 = r8.l     // Catch:{ Exception -> 0x00ef }
            float r2 = r2.o()     // Catch:{ Exception -> 0x00ef }
            float r1 = com.bytedance.sdk.component.adexpress.c.b.a(r1, r2)     // Catch:{ Exception -> 0x00ef }
            r0.setCornerRadius(r1)     // Catch:{ Exception -> 0x00ef }
            return r0
        L_0x00ef:
            android.graphics.drawable.Drawable r0 = r8.getMutilBackgroundDrawable()
            if (r0 == 0) goto L_0x00f6
            return r0
        L_0x00f6:
            android.graphics.drawable.GradientDrawable r0 = r8.getDrawable()
            r0.setShape(r3)
            android.content.Context r1 = r8.k
            com.bytedance.sdk.component.adexpress.dynamic.b.g r2 = r8.l
            float r2 = r2.o()
            float r1 = com.bytedance.sdk.component.adexpress.c.b.a(r1, r2)
            r0.setCornerRadius(r1)
            if (r9 == 0) goto L_0x0113
            int r9 = android.graphics.Color.parseColor(r10)
            goto L_0x0119
        L_0x0113:
            com.bytedance.sdk.component.adexpress.dynamic.b.g r9 = r8.l
            int r9 = r9.y()
        L_0x0119:
            r0.setColor(r9)
            com.bytedance.sdk.component.adexpress.dynamic.b.g r9 = r8.l
            float r9 = r9.q()
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x013e
            android.content.Context r9 = r8.k
            com.bytedance.sdk.component.adexpress.dynamic.b.g r10 = r8.l
            float r10 = r10.q()
            float r9 = com.bytedance.sdk.component.adexpress.c.b.a(r9, r10)
            int r9 = (int) r9
            com.bytedance.sdk.component.adexpress.dynamic.b.g r10 = r8.l
            int r10 = r10.p()
            r0.setStroke(r9, r10)
            goto L_0x015a
        L_0x013e:
            com.bytedance.sdk.component.adexpress.dynamic.b.g r9 = r8.l
            int r9 = r9.r()
            if (r9 <= 0) goto L_0x015a
            com.bytedance.sdk.component.adexpress.dynamic.b.g r9 = r8.l
            int r9 = r9.r()
            com.bytedance.sdk.component.adexpress.dynamic.b.g r10 = r8.l
            int r10 = r10.p()
            r0.setStroke(r9, r10)
            r9 = 50
            r0.setAlpha(r9)
        L_0x015a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.a(boolean, java.lang.String):android.graphics.drawable.Drawable");
    }

    /* access modifiers changed from: protected */
    public b a(Bitmap bitmap) {
        return new a(bitmap, (b) null);
    }

    /* access modifiers changed from: protected */
    public Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(a(b(this.l.A().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    private Drawable[] a(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (str.contains("linear-gradient")) {
                String[] split = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int[] iArr = new int[(split.length - 1)];
                int i3 = 0;
                while (i3 < iArr.length) {
                    int i4 = i3 + 1;
                    iArr[i3] = g.a(split[i4].substring(0, 7));
                    i3 = i4;
                }
                GradientDrawable a2 = a(a(split[0]), iArr);
                a2.setShape(0);
                a2.setCornerRadius(com.bytedance.sdk.component.adexpress.c.b.a(this.k, this.l.o()));
                drawableArr[(list.size() - 1) - i2] = a2;
            }
        }
        return drawableArr;
    }

    private List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) == '(') {
                i2++;
                z = true;
            } else if (str.charAt(i4) == ')' && i2 - 1 == 0 && z) {
                int i5 = i4 + 1;
                arrayList.add(str.substring(i3, i5));
                i3 = i5;
                z = false;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    /* access modifiers changed from: protected */
    public GradientDrawable a(GradientDrawable.Orientation orientation, int[] iArr) {
        return new GradientDrawable(orientation, iArr);
    }

    /* access modifiers changed from: protected */
    public GradientDrawable.Orientation a(String str) {
        try {
            int parseInt = Integer.parseInt(str.substring(0, str.length() - 3));
            if (parseInt <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (parseInt <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (parseInt <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.r.a(canvas, (b) this, (View) this);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a aVar = this.r;
        View view = this.o;
        if (view == null) {
            view = this;
        }
        aVar.a(view, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public void g() {
        if (!h()) {
            View view = this.o;
            if (view == null) {
                view = this;
            }
            this.q = new com.bytedance.sdk.component.adexpress.dynamic.animation.a.b(view, this.m.i().e().af());
            this.q.a();
        }
    }

    public void b() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.a.b bVar = this.q;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        h hVar = this.m;
        return hVar == null || hVar.i() == null || this.m.i().e() == null || this.m.i().e().af() == null;
    }

    public int getDynamicWidth() {
        return this.g;
    }

    public int getDynamicHeight() {
        return this.h;
    }

    public f getDynamicLayoutBrickValue() {
        e i2;
        h hVar = this.m;
        if (hVar == null || (i2 = hVar.i()) == null) {
            return null;
        }
        return i2.e();
    }
}
