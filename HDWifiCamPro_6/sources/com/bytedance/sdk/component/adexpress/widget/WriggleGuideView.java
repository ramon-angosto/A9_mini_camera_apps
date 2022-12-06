package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.List;

public class WriggleGuideView extends View {
    private int a;
    private int b;
    private Bitmap c;
    private Bitmap d;
    private Paint e;
    private int f;
    private final List<b> g;
    private boolean h;
    private boolean i;
    private a j;

    public interface a {
        void a();
    }

    public WriggleGuideView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WriggleGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WriggleGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 0;
        this.b = 0;
        this.f = 0;
        this.g = new ArrayList();
        this.h = true;
        this.i = false;
        setLayerType(1, (Paint) null);
        this.e = new Paint();
        this.e = new Paint(1);
        this.g.clear();
    }

    private Bitmap a(int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(BitmapFactory.decodeResource(getContext().getResources(), t.d(getContext(), "tt_wriggle_union")), (Rect) null, new RectF(0.0f, 0.0f, (float) i2, (float) i3), this.e);
        return createBitmap;
    }

    private Bitmap b(int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(BitmapFactory.decodeResource(getContext().getResources(), t.d(getContext(), "tt_wriggle_union_white")), (Rect) null, new RectF(0.0f, 0.0f, (float) i2, (float) i3), new Paint(1));
        return createBitmap;
    }

    private Bitmap c(int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        float f2 = ((float) this.f) / ((float) this.a);
        if (f2 >= 0.5f) {
            f2 = Math.abs(f2 - 1.0f);
        }
        int i4 = this.b;
        this.g.add(new b((float) (i2 - this.f), ((float) i3) - ((f2 * 2.0f) * ((float) i4)), ((float) Math.min(this.a, i4)) / 2.0f));
        for (b next : this.g) {
            canvas.drawCircle(next.a, next.b, next.c, paint);
        }
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            this.a = getWidth();
            this.b = getHeight();
            this.c = a(this.a, this.b);
            this.d = b(this.a, this.b);
            this.h = false;
        }
        canvas.drawBitmap(this.c, 0.0f, 0.0f, this.e);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (Paint) null, 31);
        canvas.drawBitmap(this.d, 0.0f, 0.0f, this.e);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(c(this.a, this.b), 0.0f, 0.0f, this.e);
        this.e.setXfermode((Xfermode) null);
        canvas.restoreToCount(saveLayer);
        if (this.i) {
            this.f += 2;
            invalidate();
            if (this.f >= this.a) {
                a aVar = this.j;
                if (aVar != null) {
                    aVar.a();
                }
                this.i = false;
            }
        }
    }

    private static class b {
        public float a;
        public float b;
        public float c;

        b(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j != null) {
            this.j = null;
        }
    }
}
