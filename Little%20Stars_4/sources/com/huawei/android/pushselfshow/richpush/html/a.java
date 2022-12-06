package com.huawei.android.pushselfshow.richpush.html;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.pushselfshow.utils.d;

public class a implements View.OnTouchListener {
    private static int j = 0;
    private static int k = 1;
    private static int l = 2;
    private View a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private Activity m;

    public a(Activity activity) {
        this.m = activity;
    }

    @SuppressLint({"NewApi"})
    private void a(View view, int i2) {
        TextView textView;
        if (view != null && view.isClickable()) {
            if (view == this.c) {
                textView = this.g;
            } else if (view == this.b) {
                textView = this.f;
            } else if (view == this.d) {
                textView = this.h;
            } else if (view == this.e) {
                textView = this.i;
            } else {
                return;
            }
            if (textView != null) {
                float f2 = k == i2 ? 0.5f : l == i2 ? 0.3f : 1.0f;
                view.setAlpha(f2);
                textView.setAlpha(f2);
            }
        }
    }

    private void a(ImageView imageView, boolean z) {
        if (imageView != null) {
            imageView.setClickable(z);
        }
    }

    public void a() {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnTouchListener(this);
        }
        ImageView imageView2 = this.c;
        if (imageView2 != null) {
            imageView2.setOnTouchListener(this);
        }
        ImageView imageView3 = this.d;
        if (imageView3 != null) {
            imageView3.setOnTouchListener(this);
        }
        ImageView imageView4 = this.e;
        if (imageView4 != null) {
            imageView4.setOnTouchListener(this);
        }
    }

    public void a(View view) {
        this.a = view.findViewById(d.d(this.m, "hwpush_bottom_bar"));
        this.b = (ImageView) this.a.findViewById(d.d(this.m, "hwpush_bt_back_img"));
        this.c = (ImageView) this.a.findViewById(d.d(this.m, "hwpush_bt_forward_img"));
        this.d = (ImageView) this.a.findViewById(d.d(this.m, "hwpush_bt_refresh_img"));
        this.e = (ImageView) this.a.findViewById(d.d(this.m, "hwpush_bt_collect_img"));
        this.f = (TextView) this.a.findViewById(d.d(this.m, "hwpush_bt_back_txt"));
        this.g = (TextView) this.a.findViewById(d.d(this.m, "hwpush_bt_forward_txt"));
        this.h = (TextView) this.a.findViewById(d.d(this.m, "hwpush_bt_refresh_txt"));
        this.i = (TextView) this.a.findViewById(d.d(this.m, "hwpush_bt_collect_txt"));
        a((View) this.b, l);
        a((View) this.c, l);
        com.huawei.android.pushselfshow.utils.a.a((Context) this.m, this.f);
        com.huawei.android.pushselfshow.utils.a.a((Context) this.m, this.g);
        com.huawei.android.pushselfshow.utils.a.a((Context) this.m, this.h);
        com.huawei.android.pushselfshow.utils.a.a((Context) this.m, this.i);
    }

    public void a(ImageView imageView) {
        a((View) imageView, l);
        a(imageView, false);
    }

    public void b(ImageView imageView) {
        a(imageView, true);
        a((View) imageView, j);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent.getAction() == 1 ? j : k);
        return false;
    }
}
