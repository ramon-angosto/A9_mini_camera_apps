package com.bytedance.sdk.openadsdk.core;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: VisibilityChecker */
public class v {
    private static boolean a(View view, int i) {
        float a = a(view);
        return a > 0.0f && a >= ((float) i) / 100.0f;
    }

    public static float a(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0) {
                    if (view.getParent() != null) {
                        Rect rect = new Rect();
                        if (!view.getGlobalVisibleRect(rect)) {
                            return -1.0f;
                        }
                        long height = ((long) rect.height()) * ((long) rect.width());
                        long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
                        if (height2 <= 0) {
                            return -1.0f;
                        }
                        return ((float) height) / ((float) height2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    private static boolean b(View view) {
        return view != null && view.isShown();
    }

    private static boolean b(View view, int i) {
        return view.getWidth() >= c(view, i) && view.getHeight() >= d(view, i);
    }

    private static int c(View view, int i) {
        if (i == 3) {
            return (int) (((double) z.c(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    private static int d(View view, int i) {
        if (i == 3) {
            return z.d(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static int b(View view, int i, int i2) throws Throwable {
        if (view.getWindowVisibility() != 0) {
            return 4;
        }
        if (!b(view)) {
            return 1;
        }
        if (!b(view, i2)) {
            return 6;
        }
        return !a(view, i) ? 3 : 0;
    }

    public static boolean a(View view, int i, int i2) {
        if (i2 == 1) {
            while (true) {
                if (view == null) {
                    break;
                }
                try {
                    if (view.getVisibility() != 0) {
                        return false;
                    }
                    if (view instanceof NativeExpressView) {
                        break;
                    } else if (view instanceof BannerExpressView) {
                        break;
                    } else {
                        view = (View) view.getParent();
                    }
                } catch (Throwable unused) {
                    return false;
                }
            }
        }
        if (b(view, i, i2) == 0) {
            return true;
        }
        return false;
    }
}
