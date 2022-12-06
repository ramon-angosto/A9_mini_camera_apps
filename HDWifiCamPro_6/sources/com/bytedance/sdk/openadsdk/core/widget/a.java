package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.m;

/* compiled from: CustomCommonDialog */
public class a extends Dialog {
    public C0050a a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private Button e;
    private Button f;
    private View g;
    private Context h;
    private String i;
    private String j;
    private String k;
    private String l;
    private int m = -1;
    private boolean n = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a  reason: collision with other inner class name */
    /* compiled from: CustomCommonDialog */
    public interface C0050a {
        void a();

        void b();
    }

    public void onBackPressed() {
    }

    public a(Context context) {
        super(context, t.g(context, "tt_custom_dialog"));
        this.h = context;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f(this.h, "tt_custom_dailog_layout"));
        setCanceledOnTouchOutside(false);
        c();
        b();
        a();
    }

    private void a() {
        this.f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.a != null) {
                    a.this.a.a();
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.a != null) {
                    a.this.a.b();
                }
            }
        });
    }

    private void b() {
        if (!TextUtils.isEmpty(this.j)) {
            this.c.setText(this.j);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.d.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f.setText(this.k);
        } else {
            this.f.setText(t.a(m.a(), "tt_postive_txt"));
        }
        if (!TextUtils.isEmpty(this.l)) {
            this.e.setText(this.l);
        } else {
            this.e.setText(t.a(m.a(), "tt_negtive_txt"));
        }
        int i2 = this.m;
        if (i2 != -1) {
            this.b.setImageResource(i2);
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        if (this.n) {
            this.g.setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.g.setVisibility(0);
    }

    public void show() {
        super.show();
        b();
    }

    private void c() {
        this.e = (Button) findViewById(t.e(this.h, "tt_negtive"));
        this.f = (Button) findViewById(t.e(this.h, "tt_positive"));
        this.c = (TextView) findViewById(t.e(this.h, "tt_title"));
        this.d = (TextView) findViewById(t.e(this.h, "tt_message"));
        this.b = (ImageView) findViewById(t.e(this.h, "tt_image"));
        this.g = findViewById(t.e(this.h, "tt_column_line"));
    }

    public a a(C0050a aVar) {
        this.a = aVar;
        return this;
    }

    public a a(String str) {
        this.i = str;
        return this;
    }

    public a b(String str) {
        this.k = str;
        return this;
    }

    public a c(String str) {
        this.l = str;
        return this;
    }
}
