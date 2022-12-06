package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.utils.t;

public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new TextView(context);
        this.o.setTag(3);
        addView(this.o, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.o);
        if (dynamicRootView.getRenderRequest() != null && !dynamicRootView.getRenderRequest().e()) {
            this.o.setVisibility(8);
            setVisibility(8);
        }
    }

    public boolean i() {
        super.i();
        ((TextView) this.o).setText(getText());
        if (Build.VERSION.SDK_INT >= 17) {
            this.o.setTextAlignment(this.l.h());
        }
        ((TextView) this.o).setTextColor(this.l.g());
        ((TextView) this.o).setTextSize(this.l.e());
        if (Build.VERSION.SDK_INT >= 16) {
            this.o.setBackground(getBackgroundDrawable());
        }
        if (!this.l.v()) {
            ((TextView) this.o).setMaxLines(1);
            ((TextView) this.o).setGravity(17);
            ((TextView) this.o).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int w = this.l.w();
            if (w > 0) {
                ((TextView) this.o).setLines(w);
                ((TextView) this.o).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.o.setPadding((int) b.a(d.a(), (float) this.l.c()), (int) b.a(d.a(), (float) this.l.b()), (int) b.a(d.a(), (float) this.l.d()), (int) b.a(d.a(), (float) this.l.a()));
        ((TextView) this.o).setGravity(17);
        return true;
    }

    public String getText() {
        return t.a(d.a(), "tt_reward_feedback");
    }
}
