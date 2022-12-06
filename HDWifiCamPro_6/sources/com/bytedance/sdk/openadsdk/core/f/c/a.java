package com.bytedance.sdk.openadsdk.core.f.c;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.z;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ResourceHelper */
public class a {
    public static final Set<String> a = new HashSet<String>() {
        {
            add("image/jpeg");
            add("image/png");
            add("image/bmp");
            add("image/gif");
            add("image/jpg");
        }
    };
    public static Set<String> b = new HashSet<String>() {
        {
            add("application/x-javascript");
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.f.c.a$a  reason: collision with other inner class name */
    /* compiled from: ResourceHelper */
    public enum C0048a {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    /* compiled from: ResourceHelper */
    public enum b {
        HTML_RESOURCE,
        STATIC_RESOURCE,
        IFRAME_RESOURCE
    }

    public static Point a(Context context, int i, int i2, b bVar) {
        if (context == null) {
            context = m.a();
        }
        Point point = new Point(i, i2);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int b2 = (int) z.b(context, (float) i);
        int b3 = (int) z.b(context, (float) i2);
        if (b2 <= width && b3 <= height) {
            return point;
        }
        Point point2 = new Point();
        if (b.HTML_RESOURCE == bVar) {
            point2.x = Math.min(width, b2);
            point2.y = Math.min(height, b3);
        } else {
            float f = (float) b2;
            float f2 = f / ((float) width);
            float f3 = (float) b3;
            float f4 = f3 / ((float) height);
            if (f2 >= f4) {
                point2.x = width;
                point2.y = (int) (f3 / f2);
            } else {
                point2.x = (int) (f / f4);
                point2.y = height;
            }
        }
        if (point2.x < 0 || point2.y < 0) {
            return point;
        }
        point2.x = z.c(context, (float) point2.x);
        point2.y = z.c(context, (float) point2.y);
        return point2;
    }
}
