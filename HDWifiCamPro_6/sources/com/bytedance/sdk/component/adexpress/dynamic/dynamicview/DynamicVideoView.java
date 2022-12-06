package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.d;
import com.mbridge.msdk.MBridgeConstans;

public class DynamicVideoView extends DynamicBaseWidgetImp implements d {
    TextView a;
    boolean b = false;

    public boolean e() {
        return true;
    }

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new View(context);
        this.o.setTag(Integer.valueOf(getClickArea()));
        this.a = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) b.a(context, 40.0f), (int) b.a(context, 15.0f));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.a.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.a.setBackground(gradientDrawable);
        this.a.setTextSize(10.0f);
        this.a.setGravity(17);
        this.a.setTextColor(-1);
        this.a.setVisibility(8);
        addView(this.a);
        addView(this.o, getWidgetLayoutParams());
        dynamicRootView.setVideoListener(this);
    }

    public boolean i() {
        super.i();
        double d = 0.0d;
        double d2 = 0.0d;
        for (h hVar = this.m; hVar != null; hVar = hVar.k()) {
            double e = d2 + ((double) hVar.e());
            double f = d + ((double) hVar.f());
            d2 = e - ((double) hVar.c());
            d = f - ((double) hVar.d());
        }
        try {
            float f2 = (float) d2;
            float f3 = (float) d;
            ((DynamicRoot) this.n.getChildAt(0)).a.a((int) b.a(getContext(), f2), (int) b.a(getContext(), f3), (int) b.a(getContext(), f2 + this.e), (int) b.a(getContext(), f3 + this.f));
        } catch (Exception unused) {
        }
        this.n.a(d2, d, (double) this.e, (double) this.f, this.l.o());
        return true;
    }

    public void setTimeUpdate(int i) {
        String str;
        String str2;
        if (!this.m.i().e().al() || i <= 0 || this.b) {
            this.b = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                b(getChildAt(i2));
            }
            this.a.setVisibility(8);
            return;
        }
        if (i >= 60) {
            str = "" + MBridgeConstans.ENDCARD_URL_TYPE_PL + (i / 60);
        } else {
            str = "" + "00";
        }
        String str3 = str + ":";
        int i3 = i % 60;
        if (i3 > 9) {
            str2 = str3 + i3;
        } else {
            str2 = str3 + MBridgeConstans.ENDCARD_URL_TYPE_PL + i3;
        }
        this.a.setText(str2);
        this.a.setVisibility(0);
    }

    private void b(View view) {
        if (view != this.a) {
            int i = 0;
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i < viewGroup.getChildCount()) {
                        b(viewGroup.getChildAt(i));
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void a() {
        this.a.setVisibility(8);
    }
}
