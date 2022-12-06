package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c.j;
import com.bytedance.sdk.component.utils.t;

public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new TextView(context);
        this.o.setTag(Integer.valueOf(getClickArea()));
        addView(this.o, getWidgetLayoutParams());
    }

    public boolean i() {
        super.i();
        if (Build.VERSION.SDK_INT >= 17) {
            this.o.setTextAlignment(this.l.h());
        }
        ((TextView) this.o).setTextColor(this.l.g());
        ((TextView) this.o).setTextSize(this.l.e());
        if (d.b()) {
            ((TextView) this.o).setIncludeFontPadding(false);
            ((TextView) this.o).setTextSize(Math.min(((float) ((b.b(d.a(), (float) this.h) - this.l.b()) - this.l.a())) - 0.5f, this.l.e()));
            ((TextView) this.o).setText(t.b(getContext(), "tt_logo_en"));
            return true;
        } else if (!a()) {
            ((TextView) this.o).setText(t.b(getContext(), "tt_logo_cn"));
            return true;
        } else if (j.b()) {
            ((TextView) this.o).setText(j.a());
            return true;
        } else {
            ((TextView) this.o).setText(j.a(this.l.b));
            return true;
        }
    }

    private boolean a() {
        if (d.b()) {
            return false;
        }
        if ((TextUtils.isEmpty(this.l.b) || !this.l.b.contains("adx:")) && !j.b()) {
            return false;
        }
        return true;
    }
}
