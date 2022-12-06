package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.c.j;
import com.bytedance.sdk.component.utils.t;

public class TTRatingBar2 extends FrameLayout {
    private static final int i = ((j.b("", 0.0f, true)[1] / 2) + 1);
    private static final int j = ((j.b("", 0.0f, true)[1] / 2) + 3);
    LinearLayout a = new LinearLayout(getContext());
    LinearLayout b = new LinearLayout(getContext());
    private float c;
    private float d;
    private Drawable e;
    private Drawable f;
    private double g;
    private float h;

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

    public void a(double d2, int i2, int i3, int i4) {
        float f2 = (float) i3;
        this.c = (float) ((int) b.c(getContext(), f2));
        this.d = (float) ((int) b.c(getContext(), f2));
        this.g = d2;
        this.h = (float) i4;
        removeAllViews();
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.b.addView(starImageView);
        }
        for (int i6 = 0; i6 < 5; i6++) {
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
        imageView.setPadding(1, i, 1, j);
        return imageView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.a.measure(i2, i3);
        double d2 = this.g;
        float f2 = this.c;
        this.b.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((float) ((int) d2)) * f2) + 1.0f)) + (((double) (f2 - 2.0f)) * (d2 - ((double) ((int) d2))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredHeight(), 1073741824));
        if (this.h > 0.0f) {
            LinearLayout linearLayout = this.a;
            linearLayout.setPadding(0, ((int) (((float) linearLayout.getMeasuredHeight()) - this.h)) / 2, 0, 0);
            this.b.setPadding(0, ((int) (((float) this.a.getMeasuredHeight()) - this.h)) / 2, 0, 0);
        }
    }
}
