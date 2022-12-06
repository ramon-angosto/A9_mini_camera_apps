package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;

public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    private TextView a = new TextView(this.k);
    private TextView b = new TextView(this.k);
    private TextView s = new TextView(this.k);
    private LinearLayout t = new LinearLayout(this.k);

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.a.setTag(9);
        this.b.setTag(10);
        this.t.addView(this.b);
        this.t.addView(this.s);
        this.t.addView(this.a);
        addView(this.t, getWidgetLayoutParams());
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        this.a.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.a.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.b.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.b.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.g, this.h);
    }

    public boolean i() {
        this.b.setText("Permission list");
        this.s.setText(" | ");
        this.a.setText("Privacy policy");
        if (this.l != null) {
            this.b.setTextColor(this.l.g());
            this.b.setTextSize(this.l.e());
            this.s.setTextColor(this.l.g());
            this.a.setTextColor(this.l.g());
            this.a.setTextSize(this.l.e());
            return false;
        }
        this.b.setTextColor(-1);
        this.b.setTextSize(12.0f);
        this.s.setTextColor(-1);
        this.a.setTextColor(-1);
        this.a.setTextSize(12.0f);
        return false;
    }
}
