package com.mbridge.msdk.video.dynview.endcard.cloudview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.mbridge.msdk.video.dynview.endcard.cloudview.d;

public class TagCloudView extends ViewGroup implements d.a, Runnable {
    public static final int MODE_DECELERATE = 1;
    public static final int MODE_DISABLE = 0;
    public static final int MODE_UNIFORM = 2;
    private float a = 2.0f;
    /* access modifiers changed from: private */
    public c b;
    /* access modifiers changed from: private */
    public float c = 0.5f;
    /* access modifiers changed from: private */
    public float d = 0.5f;
    /* access modifiers changed from: private */
    public float e;
    /* access modifiers changed from: private */
    public float f;
    /* access modifiers changed from: private */
    public float g;
    /* access modifiers changed from: private */
    public float h = 0.9f;
    /* access modifiers changed from: private */
    public float[] i = {1.0f, 0.0f, 0.0f, 1.0f};
    /* access modifiers changed from: private */
    public float[] j = {0.9412f, 0.7686f, 0.2f, 1.0f};
    private boolean k;
    private ViewGroup.MarginLayoutParams l;
    private int m;
    public int mMode;
    private boolean n = false;
    private Handler o = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public d p = new b();
    private a q;
    private b r;

    public interface a {
    }

    public interface b {
    }

    public TagCloudView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public TagCloudView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public TagCloudView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        try {
            setFocusableInTouchMode(true);
            this.b = new c();
            this.mMode = 2;
            setManualScroll(true);
            setLightColor(Color.parseColor("#b1c914"));
            setDarkColor(Color.parseColor("#206fa1"));
            setRadiusPercent(0.6f);
            setScrollSpeed(1.0f);
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 13) {
                windowManager.getDefaultDisplay().getSize(point);
            } else {
                point.x = windowManager.getDefaultDisplay().getWidth();
                point.y = windowManager.getDefaultDisplay().getHeight();
            }
            int i2 = point.x;
            int i3 = point.y;
            if (i3 < i2) {
                i2 = i3;
            }
            this.m = i2;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setAutoScrollMode(int i2) {
        this.mMode = i2;
    }

    public int getAutoScrollMode() {
        return this.mMode;
    }

    public final void setAdapter(d dVar) {
        this.p = dVar;
        this.p.a((d.a) this);
        onChange();
    }

    public void setManualScroll(boolean z) {
        this.k = z;
    }

    public void setLightColor(int i2) {
        float[] fArr = new float[4];
        fArr[3] = (((float) Color.alpha(i2)) / 1.0f) / 255.0f;
        fArr[0] = (((float) Color.red(i2)) / 1.0f) / 255.0f;
        fArr[1] = (((float) Color.green(i2)) / 1.0f) / 255.0f;
        fArr[2] = (((float) Color.blue(i2)) / 1.0f) / 255.0f;
        this.j = (float[]) fArr.clone();
        onChange();
    }

    public void setDarkColor(int i2) {
        float[] fArr = new float[4];
        fArr[3] = (((float) Color.alpha(i2)) / 1.0f) / 255.0f;
        fArr[0] = (((float) Color.red(i2)) / 1.0f) / 255.0f;
        fArr[1] = (((float) Color.green(i2)) / 1.0f) / 255.0f;
        fArr[2] = (((float) Color.blue(i2)) / 1.0f) / 255.0f;
        this.i = (float[]) fArr.clone();
        onChange();
    }

    public void setRadiusPercent(float f2) {
        if (f2 > 1.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("percent value not in range 0 to 1");
        }
        this.h = f2;
        onChange();
    }

    public void setScrollSpeed(float f2) {
        this.a = f2;
    }

    /* access modifiers changed from: private */
    public void a() {
        removeAllViews();
        for (a e2 : this.b.b()) {
            addView(e2.e());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (this.l == null) {
            this.l = (ViewGroup.MarginLayoutParams) getLayoutParams();
        }
        if (mode != 1073741824) {
            size = (this.m - this.l.leftMargin) - this.l.rightMargin;
        }
        if (mode2 != 1073741824) {
            size2 = (this.m - this.l.leftMargin) - this.l.rightMargin;
        }
        setMeasuredDimension(size, size2);
        measureChildren(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.o.post(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            a a2 = this.b.a(i6);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                this.p.a(childAt, a2.j(), a2.i());
                childAt.setScaleX(a2.d());
                childAt.setScaleY(a2.d());
                int g2 = ((int) (this.e + a2.g())) - (childAt.getMeasuredWidth() / 2);
                int h2 = ((int) (this.f + a2.h())) - (childAt.getMeasuredHeight() / 2);
                childAt.layout(g2, h2, childAt.getMeasuredWidth() + g2, childAt.getMeasuredHeight() + h2);
            }
        }
    }

    public void reset() {
        this.b.c();
        a();
    }

    public void run() {
        int i2;
        if (!this.n && (i2 = this.mMode) != 0) {
            if (i2 == 1) {
                float f2 = this.c;
                if (f2 > 0.04f) {
                    this.c = f2 - 0.02f;
                }
                float f3 = this.d;
                if (f3 > 0.04f) {
                    this.d = f3 - 0.02f;
                }
                float f4 = this.c;
                if (f4 < -0.04f) {
                    this.c = f4 + 0.02f;
                }
                float f5 = this.d;
                if (f5 < -0.04f) {
                    this.d = f5 + 0.02f;
                }
            }
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(this.c, this.d);
                this.b.d();
            }
            a();
        }
        this.o.postDelayed(this, 16);
    }

    public void setOnTagClickListener(a aVar) {
        this.q = aVar;
    }

    public void setOnTagViewClickListener(b bVar) {
        this.r = bVar;
    }

    public void onChange() {
        postDelayed(new Runnable() {
            public final void run() {
                TagCloudView tagCloudView = TagCloudView.this;
                float unused = tagCloudView.e = (float) ((tagCloudView.getRight() - TagCloudView.this.getLeft()) / 2);
                TagCloudView tagCloudView2 = TagCloudView.this;
                float unused2 = tagCloudView2.f = (float) ((tagCloudView2.getBottom() - TagCloudView.this.getTop()) / 2);
                TagCloudView tagCloudView3 = TagCloudView.this;
                float unused3 = tagCloudView3.g = Math.min(tagCloudView3.e * TagCloudView.this.h, TagCloudView.this.f * TagCloudView.this.h);
                TagCloudView.this.b.b((int) TagCloudView.this.g);
                TagCloudView.this.b.a(TagCloudView.this.j);
                TagCloudView.this.b.b(TagCloudView.this.i);
                TagCloudView.this.b.a();
                TagCloudView.this.removeAllViews();
                for (int i = 0; i < TagCloudView.this.p.a(); i++) {
                    a aVar = new a(TagCloudView.this.p.a(i));
                    aVar.a(TagCloudView.this.p.a(TagCloudView.this.getContext(), i, (ViewGroup) TagCloudView.this));
                    TagCloudView.this.b.a(aVar);
                }
                TagCloudView.this.b.a(TagCloudView.this.c, TagCloudView.this.d);
                TagCloudView.this.b.a(true);
                TagCloudView.this.a();
            }
        }, 0);
    }
}
