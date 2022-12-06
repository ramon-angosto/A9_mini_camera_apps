package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.z;

public class TTRatingBar2 extends FrameLayout {
    private static final int h = ((int) z.a(m.a(), 1.0f, false));
    private static final int i = ((int) z.a(m.a(), 0.0f, false));
    private static final int j = ((int) z.a(m.a(), 1.0f, false));
    private static final int k = ((int) z.a(m.a(), 3.0f, false));
    LinearLayout a = new LinearLayout(getContext());
    LinearLayout b = new LinearLayout(getContext());
    private float c;
    private float d;
    private final Drawable e;
    private final Drawable f;
    private double g;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a.setOrientation(0);
        this.a.setGravity(GravityCompat.START);
        this.b.setOrientation(0);
        this.b.setGravity(GravityCompat.START);
        this.e = t.c(context, "tt_star_thick");
        this.f = t.c(context, "tt_star");
    }

    public Drawable getStarEmptyDrawable() {
        return this.e;
    }

    public Drawable getStarFillDrawable() {
        return this.f;
    }

    public void a(double d2, int i2, int i3) {
        float f2 = (float) i3;
        this.c = (float) ((int) z.a(m.a(), f2, false));
        this.d = (float) ((int) z.a(m.a(), f2, false));
        this.g = d2;
        this.a.removeAllViews();
        this.b.removeAllViews();
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i2);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.b.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.a.addView(starImageView2);
        }
        addView(this.a);
        addView(this.b);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.c, (int) this.d));
        imageView.setPadding(h, i, j, k);
        return imageView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.a.measure(i2, i3);
        double d2 = this.g;
        float f2 = this.c;
        int i4 = h;
        this.b.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((float) ((int) d2)) * f2) + ((float) i4))) + (((double) (f2 - ((float) (i4 + j)))) * (d2 - ((double) ((int) d2))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredHeight(), 1073741824));
    }
}
