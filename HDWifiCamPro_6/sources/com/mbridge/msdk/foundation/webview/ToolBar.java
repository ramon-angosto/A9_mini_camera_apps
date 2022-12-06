package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.tools.u;

public class ToolBar extends LinearLayout {
    public ToolBar(Context context) {
        super(context);
        a();
    }

    public ToolBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setOnClickListener(onClickListener);
        }
    }

    public View getItem(String str) {
        return findViewWithTag(str);
    }

    private void a() {
        setOrientation(0);
        int b = u.b(getContext(), 10.0f);
        setPadding(0, b, 0, b);
        ImageView imageView = (ImageView) b();
        imageView.setTag("backward");
        imageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_cm_backward", "drawable", a.e().b())));
        addView(imageView);
        ImageView imageView2 = (ImageView) b();
        imageView2.setTag("forward");
        imageView2.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_cm_forward", "drawable", a.e().b())));
        addView(imageView2);
        ImageView imageView3 = (ImageView) b();
        imageView3.setTag("refresh");
        imageView3.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_cm_refresh", "drawable", a.e().b())));
        addView(imageView3);
        ImageView imageView4 = (ImageView) b();
        imageView4.setTag("exits");
        imageView4.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_cm_exits", "drawable", a.e().b())));
        addView(imageView4);
    }

    private View b() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(true);
        return imageView;
    }
}
