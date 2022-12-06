package com.mbridge.msdk.video.dynview.i.b;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.mbridge.msdk.foundation.tools.u;

/* compiled from: UIDrawableUtil */
public final class a {
    public static void a(View view, float f, float f2, String str, String[] strArr, GradientDrawable.Orientation orientation) {
        if (view != null && strArr != null) {
            int[] iArr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                iArr[i] = Color.parseColor(strArr[i]);
            }
            GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
            gradientDrawable.setCornerRadius((float) u.b(view.getContext(), f2));
            gradientDrawable.setStroke(u.b(view.getContext(), f), Color.parseColor(str));
            view.setBackground(gradientDrawable);
        }
    }
}
