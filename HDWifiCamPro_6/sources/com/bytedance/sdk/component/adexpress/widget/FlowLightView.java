package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlowLightView extends View {
    Rect a;
    Rect b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int[] i;
    private Bitmap j;
    private Paint k;
    private Xfermode l;
    private PorterDuff.Mode m = PorterDuff.Mode.DST_IN;
    private LinearGradient n;
    private final List<a> o = new ArrayList();

    public FlowLightView(Context context) {
        super(context);
        a();
    }

    public FlowLightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FlowLightView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r4 = r4.toCharArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r2 >= r4.length) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        r4[r2] = (char) (r4[r2] ^ r2);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        return new java.lang.String(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r0 = 'J';
        r1 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        switch(r1) {
            case 55: goto L_0x0039;
            case 56: goto L_0x004f;
            case 57: goto L_0x0010;
            default: goto L_0x000f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        switch(1) {
            case 60: goto L_0x0017;
            case 61: goto L_0x0023;
            case 62: goto L_0x0030;
            default: goto L_0x0016;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0000;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String FlowLightView1667305730929dc(java.lang.String r4) {
        /*
        L_0x0000:
            r0 = 73
            r1 = 96
        L_0x0004:
            r2 = 0
            switch(r0) {
                case 72: goto L_0x004f;
                case 73: goto L_0x0009;
                case 74: goto L_0x000c;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0054
        L_0x0009:
            switch(r1) {
                case 94: goto L_0x0000;
                case 95: goto L_0x0010;
                case 96: goto L_0x004f;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r1) {
                case 55: goto L_0x0039;
                case 56: goto L_0x004f;
                case 57: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0000
        L_0x0010:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L_0x0017;
                case 61: goto L_0x0023;
                case 62: goto L_0x0030;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x004f
        L_0x0017:
            int r3 = 0 - r1
            int r3 = r3 * r2
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0000
        L_0x0023:
            int r2 = 18 - r1
            int r2 = r2 * r0
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x004f
        L_0x0030:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L_0x0000
        L_0x0039:
            char[] r4 = r4.toCharArray()
        L_0x003d:
            int r0 = r4.length
            if (r2 >= r0) goto L_0x0049
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L_0x003d
        L_0x0049:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L_0x004f:
            r0 = 74
            r1 = 55
            goto L_0x0004
        L_0x0054:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(java.lang.String):java.lang.String");
    }

    private void a() {
        this.c = t.d(getContext(), "tt_splash_unlock_image_arrow");
        this.d = Color.parseColor("#00ffffff");
        this.e = Color.parseColor("#ffffffff");
        this.f = Color.parseColor("#00ffffff");
        this.g = 10;
        this.h = 40;
        this.i = new int[]{this.d, this.e, this.f};
        setLayerType(1, (Paint) null);
        this.k = new Paint(1);
        this.j = BitmapFactory.decodeResource(getResources(), this.c);
        this.l = new PorterDuffXfermode(this.m);
    }

    public void a(int i2) {
        this.o.add(new a(i2));
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.j, this.a, this.b, this.k);
        canvas.save();
        Iterator<a> it = this.o.iterator();
        while (it.hasNext()) {
            a next = it.next();
            this.n = new LinearGradient((float) next.b, 0.0f, (float) (next.b + this.h), (float) this.g, this.i, (float[]) null, Shader.TileMode.CLAMP);
            this.k.setColor(-1);
            this.k.setShader(this.n);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.k);
            this.k.setShader((Shader) null);
            next.a();
            if (next.b > getWidth()) {
                it.remove();
            }
        }
        this.k.setXfermode(this.l);
        canvas.drawBitmap(this.j, this.a, this.b, this.k);
        this.k.setXfermode((Xfermode) null);
        canvas.restore();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.a = new Rect(0, 0, this.j.getWidth(), this.j.getHeight());
        this.b = new Rect(0, 0, getWidth(), getHeight());
    }

    public static class a {
        private final int a;
        /* access modifiers changed from: private */
        public int b = 0;

        public a(int i) {
            this.a = i;
        }

        public void a() {
            this.b += this.a;
        }
    }
}
