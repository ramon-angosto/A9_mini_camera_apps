package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationButton;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;

public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new AnimationButton(context);
        this.o.setTag(Integer.valueOf(getClickArea()));
        addView(this.o, getWidgetLayoutParams());
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (!d.b() || !"fillButton".equals(this.m.i().b())) {
            return super.getWidgetLayoutParams();
        }
        ((TextView) this.o).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView) this.o).setMaxLines(1);
        FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
        widgetLayoutParams.width -= this.l.r() * 2;
        widgetLayoutParams.height -= this.l.r() * 2;
        widgetLayoutParams.topMargin += this.l.r();
        widgetLayoutParams.leftMargin += this.l.r();
        return widgetLayoutParams;
    }

    public boolean i() {
        super.i();
        if (!TextUtils.equals("download-progress-button", this.m.i().b()) || !TextUtils.isEmpty(this.l.j())) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.o.setTextAlignment(this.l.h());
            }
            ((TextView) this.o).setText(this.l.j());
            ((TextView) this.o).setTextColor(this.l.g());
            ((TextView) this.o).setTextSize(this.l.e());
            ((TextView) this.o).setGravity(17);
            ((TextView) this.o).setIncludeFontPadding(false);
            if ("fillButton".equals(this.m.i().b())) {
                this.o.setPadding(0, 0, 0, 0);
            } else {
                this.o.setPadding(this.l.c(), this.l.b(), this.l.d(), this.l.a());
            }
            return true;
        }
        this.o.setVisibility(4);
        return true;
    }
}
