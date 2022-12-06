package com.mbridge.msdk.video.dynview.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* compiled from: BackgroundDrawable */
public final class a extends ShapeDrawable {
    private int a;
    private float b;
    private float c;
    private int d;
    private int e;
    private Bitmap f;
    private Bitmap g;
    private Paint h;

    /* compiled from: BackgroundDrawable */
    public interface b {
        b a(Bitmap bitmap);

        b b(float f);

        b b(Bitmap bitmap);
    }

    public final int getOpacity() {
        return -3;
    }

    private a(C0104a aVar) {
        super(aVar.a);
        this.f = aVar.b;
        this.g = aVar.c;
        this.a = aVar.d;
        this.d = aVar.e;
        this.e = aVar.f;
        this.b = aVar.g;
        this.c = aVar.h;
        this.h = new Paint();
        this.h.setStyle(Paint.Style.FILL);
        this.h.setAntiAlias(true);
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.a == 1) {
            float f2 = this.c / 2.0f;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (((float) this.d) + f2) - ((float) this.e));
            path.lineTo(this.b, (f2 - ((float) this.d)) - ((float) this.e));
            path.lineTo(this.b, 0.0f);
            Bitmap bitmap = this.f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, ((float) this.d) + f2 + ((float) this.e));
            path2.lineTo(0.0f, this.c);
            path2.lineTo(this.b, this.c);
            path2.lineTo(this.b, (f2 - ((float) this.d)) + ((float) this.e));
            Bitmap bitmap2 = this.g;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                try {
                    a(canvas, path2, this.g);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } else {
            float f3 = this.b / 2.0f;
            Path path3 = new Path();
            path3.moveTo(0.0f, 0.0f);
            path3.lineTo(0.0f, this.c);
            path3.lineTo((f3 - ((float) this.d)) - ((float) this.e), this.c);
            path3.lineTo((((float) this.d) + f3) - ((float) this.e), 0.0f);
            Bitmap bitmap3 = this.f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                try {
                    a(canvas, path3, this.f);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            Path path4 = new Path();
            path4.moveTo(((float) this.d) + f3 + ((float) this.e), 0.0f);
            path4.lineTo(this.b, 0.0f);
            path4.lineTo(this.b, this.c);
            path4.lineTo((f3 - ((float) this.d)) + ((float) this.e), this.c);
            Bitmap bitmap4 = this.g;
            if (bitmap4 != null && !bitmap4.isRecycled()) {
                try {
                    a(canvas, path4, this.g);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        this.h.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawPath(path, this.h);
    }

    public static C0104a a() {
        return new C0104a();
    }

    /* renamed from: com.mbridge.msdk.video.dynview.g.a$a  reason: collision with other inner class name */
    /* compiled from: BackgroundDrawable */
    public static class C0104a implements b {
        /* access modifiers changed from: private */
        public RectShape a;
        /* access modifiers changed from: private */
        public Bitmap b;
        /* access modifiers changed from: private */
        public Bitmap c;
        /* access modifiers changed from: private */
        public int d;
        /* access modifiers changed from: private */
        public int e;
        /* access modifiers changed from: private */
        public int f;
        /* access modifiers changed from: private */
        public float g;
        /* access modifiers changed from: private */
        public float h;

        private C0104a() {
            this.e = 100;
            this.f = 10;
            this.a = new RectShape();
        }

        public final b a(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public final b b(Bitmap bitmap) {
            this.c = bitmap;
            return this;
        }

        public final b a(int i) {
            this.d = i;
            return this;
        }

        public final b a(float f2) {
            this.g = f2;
            return this;
        }

        public final b b(float f2) {
            this.h = f2;
            return this;
        }

        public final a a() {
            return new a(this);
        }
    }
}
