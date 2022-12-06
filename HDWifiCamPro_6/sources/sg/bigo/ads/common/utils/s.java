package sg.bigo.ads.common.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.p.b;

public final class s {
    public static View a(Context context, View view) {
        View view2 = null;
        View findViewById = !(context instanceof Activity) ? null : ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        if (view != null) {
            if (!(Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null)) {
                a.b("Views", "Attempting to call View#getRootView() on an unattached View.");
            }
            View rootView = view.getRootView();
            if (rootView != null && (view2 = rootView.findViewById(16908290)) == null) {
                view2 = rootView;
            }
        }
        return findViewById != null ? findViewById : view2;
    }

    public static void a(View view) {
        if (view != null && view.getParent() != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
                return;
            }
            a.a(0, "Views", "parent is not a view group, parent:" + view.getParent());
        }
    }

    public static void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (view != null && viewGroup != null) {
            if (view.getParent() == null) {
                if (layoutParams == null) {
                    viewGroup.addView(view, i);
                } else {
                    viewGroup.addView(view, i, layoutParams);
                }
            } else if (view.getParent() != viewGroup) {
                a(view);
                if (layoutParams == null) {
                    viewGroup.addView(view, i);
                } else {
                    viewGroup.addView(view, i, layoutParams);
                }
            }
        }
    }

    public static boolean a(int i, int i2, View view) {
        return i >= view.getLeft() && i <= view.getRight() && i2 >= view.getTop() && i2 <= view.getBottom();
    }

    public static boolean a(View view, int i, int i2) {
        return i >= 0 && i <= view.getWidth() && i2 >= 0 && i2 <= view.getHeight();
    }

    public static boolean b(View view) {
        ViewParent parent;
        if (b.c() || view.getWindowVisibility() != 0) {
            return false;
        }
        while (view.getVisibility() == 0 && view.getAlpha() >= 0.9f && (parent = view.getParent()) != null) {
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
            if (view == null) {
                return false;
            }
        }
        return false;
    }
}
