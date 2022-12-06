package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.k;

public class StarLevelView extends LinearLayout {
    public StarLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    public StarLevelView(Context context) {
        super(context);
        setOrientation(0);
    }

    public StarLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
    }

    public void initScore(double d) {
        for (int i = 0; i < ((int) d); i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(k.a(getContext(), "mbridge_video_common_full_star", "drawable"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i != 0) {
                layoutParams.setMargins(5, 0, 5, 0);
            }
            addView(imageView, layoutParams);
        }
        int i2 = (int) (50.0d - (d * 10.0d));
        if (i2 > 0) {
            if (i2 > 1 && i2 < 10) {
                if (i2 <= 0 || i2 >= 5) {
                    ImageView imageView2 = new ImageView(getContext());
                    imageView2.setImageResource(k.a(getContext(), "mbridge_video_common_full_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(5, 0, 5, 0);
                    addView(imageView2, layoutParams2);
                } else {
                    ImageView imageView3 = new ImageView(getContext());
                    imageView3.setImageResource(k.a(getContext(), "mbridge_video_common_full_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.setMargins(5, 0, 5, 0);
                    addView(imageView3, layoutParams3);
                }
            }
            int i3 = i2 / 10;
            if (i3 >= 1) {
                int i4 = i2 % (i3 * 10);
                if (i4 > 0 && i4 < 5) {
                    ImageView imageView4 = new ImageView(getContext());
                    imageView4.setImageResource(k.a(getContext(), "mbridge_video_common_full_while_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams4.setMargins(5, 0, 5, 0);
                    addView(imageView4, layoutParams4);
                } else if (i4 >= 5 && i4 <= 9) {
                    ImageView imageView5 = new ImageView(getContext());
                    imageView5.setImageResource(k.a(getContext(), "mbridge_video_common_half_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams5.setMargins(5, 0, 5, 0);
                    addView(imageView5, layoutParams5);
                }
                for (int i5 = 0; i5 < i3; i5++) {
                    ImageView imageView6 = new ImageView(getContext());
                    imageView6.setImageResource(k.a(getContext(), "mbridge_video_common_full_while_star", "drawable"));
                    LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams6.setMargins(5, 0, 5, 0);
                    addView(imageView6, layoutParams6);
                }
            }
        }
    }
}
