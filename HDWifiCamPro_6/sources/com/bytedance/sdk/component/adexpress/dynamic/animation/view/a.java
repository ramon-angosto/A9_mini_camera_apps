package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import com.bytedance.sdk.component.utils.t;

/* compiled from: AnimationWrapper */
public class a {
    Paint a = new Paint();
    Path b = new Path();
    private int c;
    private int d;
    private int e;

    public a() {
        this.a.setAntiAlias(true);
    }

    public void a(Canvas canvas, b bVar, View view) {
        int i;
        int i2;
        Canvas canvas2 = canvas;
        View view2 = view;
        if (bVar.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.a.a.a.a().c() != null) {
                float[] fArr = null;
                try {
                    fArr = g.b((String) view2.getTag(t.e(com.bytedance.sdk.component.adexpress.a.a.a.a().c().b(), "tt_id_ripple_bg")));
                } catch (Exception unused) {
                }
                if (fArr != null) {
                    this.a.setColor(b.a(fArr[3] * (1.0f - bVar.getRippleValue()), fArr[0] / 256.0f, fArr[1] / 256.0f, fArr[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            int i3 = this.c;
            int i4 = this.d;
            canvas2.drawCircle((float) i3, (float) i4, ((float) (Math.min(i3, i4) * 2)) * bVar.getRippleValue(), this.a);
        }
        if (bVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.b.reset();
            try {
                i2 = ((Integer) view2.getTag(t.e(view.getContext(), "tt_id_shine_width"))).intValue();
            } catch (Exception unused2) {
                i2 = 0;
            }
            if (i2 >= 0) {
                int a2 = (int) b.a(view.getContext(), (float) i2);
                Path path = this.b;
                float shineValue = ((float) ((this.c * 2) + a2 + (this.d * 2))) * bVar.getShineValue();
                int i5 = this.d;
                path.moveTo((shineValue - ((float) ((i5 * 2) + a2))) + ((float) (i5 * 2)), 0.0f);
                Path path2 = this.b;
                float shineValue2 = ((float) ((this.c * 2) + a2 + (this.d * 2))) * bVar.getShineValue();
                int i6 = this.d;
                float f = (float) a2;
                path2.lineTo((shineValue2 - ((float) ((i6 * 2) + a2))) + f + ((float) (i6 * 2)), 0.0f);
                Path path3 = this.b;
                float shineValue3 = ((float) ((this.c * 2) + a2 + (this.d * 2))) * bVar.getShineValue();
                int i7 = this.d;
                path3.lineTo((shineValue3 - ((float) ((i7 * 2) + a2))) + f, (float) (i7 * 2));
                Path path4 = this.b;
                float shineValue4 = ((float) ((this.c * 2) + a2 + (this.d * 2))) * bVar.getShineValue();
                int i8 = this.d;
                path4.lineTo(shineValue4 - ((float) ((i8 * 2) + a2)), (float) (i8 * 2));
                this.b.close();
                float shineValue5 = ((float) ((this.c * 2) + a2 + (this.d * 2))) * bVar.getShineValue();
                int i9 = this.d;
                float f2 = ((float) i9) + (shineValue5 - ((float) ((i9 * 2) + a2)));
                float shineValue6 = ((float) ((this.c * 2) + a2 + (i9 * 2))) * bVar.getShineValue();
                int i10 = this.d;
                this.a.setShader(new LinearGradient(f2, 0.0f, ((float) (a2 / 2)) + (shineValue6 - ((float) ((i10 * 2) + a2))) + ((float) i10), (float) i10, Color.parseColor("#10ffffff"), Color.parseColor("#50ffffff"), Shader.TileMode.MIRROR));
                canvas2.drawPath(this.b, this.a);
            }
        }
        if (bVar.getMarqueeValue() != 0.0f) {
            try {
                i = ((Integer) view2.getTag(t.e(view.getContext(), "tt_id_width"))).intValue();
            } catch (Exception unused3) {
                i = 0;
            }
            if (i >= 0) {
                this.b.reset();
                this.b.moveTo(0.0f, 0.0f);
                this.b.lineTo((float) (this.c * 2), 0.0f);
                this.b.lineTo((float) (this.c * 2), (float) (this.d * 2));
                this.b.lineTo(0.0f, (float) (this.d * 2));
                this.b.lineTo(0.0f, 0.0f);
                this.a.setShader(new LinearGradient(0.0f, 0.0f, (float) (this.c * 2), (float) (this.d * 2), new int[]{(int) (bVar.getMarqueeValue() * -65536.0f), (int) ((1.0f - bVar.getMarqueeValue()) * -65536.0f)}, (float[]) null, Shader.TileMode.CLAMP));
                this.a.setColor(SupportMenu.CATEGORY_MASK);
                this.a.setStyle(Paint.Style.STROKE);
                this.a.setStrokeWidth((float) i);
                canvas2.drawPath(this.b, this.a);
            }
        }
    }

    public void a(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = this.e;
        layoutParams.width = (int) (((float) i) * f);
        view.setTranslationX((float) ((i - layoutParams.width) / 2));
        if (view instanceof DynamicImageView) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i2).setTranslationX((float) ((-(this.e - layoutParams.width)) / 2));
                i2++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void a(View view, int i, int i2) {
        String str;
        this.c = i / 2;
        this.d = i2 / 2;
        if (this.e == 0 && view.getLayoutParams().width > 0) {
            this.e = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(t.e(view.getContext(), "tt_id_direction"));
        } catch (Exception unused) {
            str = "";
        }
        if (TtmlNode.RIGHT.equals(str)) {
            view.setPivotX((float) (this.c * 2));
            view.setPivotY((float) this.d);
        } else if (TtmlNode.LEFT.equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY((float) this.d);
        } else {
            view.setPivotX((float) this.c);
            view.setPivotY((float) this.d);
        }
    }
}
