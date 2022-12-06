package com.bytedance.sdk.openadsdk.component.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: TTAppOpenAdUserInfoLayoutHelper */
public class a {
    private static boolean a;
    private static Drawable b;
    private LinearLayout c;
    private TTRoundRectImageView d;
    private TextView e;

    public void a(Activity activity, OpenScreenAdBackupView openScreenAdBackupView, n nVar, float f, float f2, boolean z) {
        this.c = (LinearLayout) openScreenAdBackupView.findViewById(t.e(activity, "tt_user_info"));
        this.d = (TTRoundRectImageView) openScreenAdBackupView.findViewById(t.e(activity, "tt_app_icon"));
        this.e = (TextView) openScreenAdBackupView.findViewById(t.e(activity, "tt_app_name"));
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        a(nVar, f, f2, z);
    }

    public void a() {
        String g = h.d().g();
        if (TextUtils.isEmpty(g)) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(g);
        }
        b();
        try {
            if (b == null) {
                this.d.setVisibility(8);
                return;
            }
            this.d.setImageDrawable(b);
            if (this.e.getVisibility() == 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, 0);
                this.d.setLayoutParams(marginLayoutParams);
            }
        } catch (Throwable unused) {
            this.d.setVisibility(8);
        }
    }

    public void b() {
        if (!a) {
            try {
                int h = h.d().h();
                if (h != 0) {
                    b = m.a().getResources().getDrawable(h);
                }
            } catch (Throwable unused) {
            }
            a = true;
        }
    }

    public static Drawable c() {
        return b;
    }

    private void a(n nVar, float f, float f2, boolean z) {
        int i;
        int i2;
        int d2 = nVar.d();
        if (d2 == 1 || d2 == 3) {
            if (z) {
                i = nVar.J().c();
                i2 = nVar.J().b();
            } else {
                i = nVar.P().get(0).b();
                i2 = nVar.P().get(0).c();
            }
            if (i > 0 && i2 > 0) {
                float f3 = (float) i2;
                float min = f2 - (f3 * Math.min(f / ((float) i), f2 / f3));
                try {
                    float b2 = (float) ((int) z.b(m.a(), 60.0f));
                    if (min >= b2) {
                        b2 = min;
                    }
                    this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) b2));
                } catch (Throwable unused) {
                }
            }
        }
    }
}
