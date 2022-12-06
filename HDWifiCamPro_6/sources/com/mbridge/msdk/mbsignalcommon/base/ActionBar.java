package com.mbridge.msdk.mbsignalcommon.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class ActionBar extends LinearLayout implements View.OnClickListener {
    private WebView a;

    public interface a {
        View a();

        void a(View view, WebView webView);
    }

    public ActionBar(Context context) {
        super(context);
    }

    public ActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof a) {
            ((a) tag).a(view, this.a);
        }
    }

    public WebView getWebView() {
        return this.a;
    }

    public void setWebView(WebView webView) {
        this.a = webView;
    }

    public void addAction(a aVar) {
        addAction(aVar, getChildCount());
    }

    public void removeAllActions() {
        removeAllViews();
    }

    public void removeActionAt(int i) {
        if (i >= 0 && i < getChildCount()) {
            removeViewAt(i);
        }
    }

    public boolean removeAction(a aVar) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                Object tag = childAt.getTag();
                if ((tag instanceof a) && tag.equals(aVar)) {
                    removeView(childAt);
                    return true;
                }
            }
        }
        return false;
    }

    public int getActionCount() {
        return getChildCount();
    }

    public View newActionItem() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(frameLayout);
        return linearLayout;
    }

    public void addAction(a aVar, int i) {
        View view;
        View a2 = aVar.a();
        if (a2 != null) {
            view = newActionItem();
            ((ViewGroup) ((ViewGroup) view).getChildAt(0)).addView(a2);
            a2.setTag(aVar);
            a2.setOnClickListener(this);
        } else {
            view = null;
        }
        addView(view, i);
    }
}
