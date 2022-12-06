package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

public class CircleRippleView extends View {
    private int a;
    private int b;
    private float c;
    private int d;
    private float e;
    private int f;
    private boolean g;
    private List<Integer> h;
    private List<Integer> i;
    private Paint j;
    private Paint k;
    private float l;
    private float m;
    private int n;

    public CircleRippleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = -1;
        this.b = SupportMenu.CATEGORY_MASK;
        this.c = 18.0f;
        this.d = 3;
        this.e = 50.0f;
        this.f = 2;
        this.g = false;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.n = 24;
        c();
    }

    private void c() {
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.j.setStrokeWidth((float) this.n);
        this.h.add(255);
        this.i.add(0);
        this.k = new Paint();
        this.k.setAntiAlias(true);
        this.k.setColor(Color.parseColor("#0FFFFFFF"));
        this.k.setStyle(Paint.Style.FILL);
    }

    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float f2 = ((float) i2) / 2.0f;
        this.l = f2;
        this.m = ((float) i3) / 2.0f;
        this.e = f2 - (((float) this.n) / 2.0f);
        this.c = this.e / 4.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    public void onDraw(Canvas canvas) {
        this.j.setShader(new LinearGradient(this.l, 0.0f, this.m, (float) getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i2 >= this.h.size()) {
                break;
            }
            Integer num = this.h.get(i2);
            this.j.setAlpha(num.intValue());
            Integer num2 = this.i.get(i2);
            if (this.c + ((float) num2.intValue()) < this.e) {
                canvas.drawCircle(this.l, this.m, this.c + ((float) num2.intValue()), this.j);
            }
            if (num.intValue() > 0 && ((float) num2.intValue()) < this.e) {
                List<Integer> list = this.h;
                if (num.intValue() - this.f > 0) {
                    i3 = num.intValue() - (this.f * 3);
                }
                list.set(i2, Integer.valueOf(i3));
                this.i.set(i2, Integer.valueOf(num2.intValue() + this.f));
            }
            i2++;
        }
        List<Integer> list2 = this.i;
        if (((float) list2.get(list2.size() - 1).intValue()) >= this.e / ((float) this.d)) {
            this.h.add(255);
            this.i.add(0);
        }
        if (this.i.size() >= 3) {
            this.i.remove(0);
            this.h.remove(0);
        }
        this.j.setAlpha(255);
        this.j.setColor(this.b);
        canvas.drawCircle(this.l, this.m, this.c, this.k);
        if (this.g) {
            invalidate();
        }
    }

    public void a() {
        this.g = true;
        invalidate();
    }

    public void b() {
        this.g = false;
        this.i.clear();
        this.h.clear();
        this.h.add(255);
        this.i.add(0);
        invalidate();
    }

    public void setColor(int i2) {
        this.a = i2;
    }

    public void setCoreColor(int i2) {
        this.b = i2;
    }

    public void setCoreRadius(int i2) {
        this.c = (float) i2;
    }

    public void setDiffuseWidth(int i2) {
        this.d = i2;
    }

    public void setMaxWidth(int i2) {
        this.e = (float) i2;
    }

    public void setDiffuseSpeed(int i2) {
        this.f = i2;
    }
}
