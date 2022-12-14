package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;

public class TopLayoutDislike2 extends FrameLayout implements a<TopLayoutDislike2> {
    private View a;
    /* access modifiers changed from: private */
    public ImageView b;
    private TextView c;
    private boolean d;
    private n e;
    /* access modifiers changed from: private */
    public boolean f;
    /* access modifiers changed from: private */
    public b g;
    private CharSequence h;
    private CharSequence i;

    public TopLayoutDislike2(Context context) {
        this(context, (AttributeSet) null);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.h = "";
        this.i = "";
    }

    public TopLayoutDislike2 a(boolean z, n nVar) {
        this.d = z;
        this.e = nVar;
        LayoutInflater.from(getContext()).inflate(t.f(getContext(), "tt_top_reward_dislike_2"), this, true);
        this.a = findViewById(t.e(getContext(), "tt_top_dislike"));
        if (nVar.aw()) {
            this.a.setVisibility(8);
        }
        ((TextView) this.a).setText(t.a(m.a(), "tt_reward_feedback"));
        this.b = (ImageView) findViewById(t.e(getContext(), "tt_top_mute"));
        this.c = (TextView) findViewById(t.e(getContext(), "tt_top_skip"));
        this.c.setVisibility(0);
        this.c.setText("");
        this.c.setEnabled(false);
        this.c.setClickable(false);
        d();
        return this;
    }

    private void d() {
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.c(view);
                    }
                }
            });
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int i;
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    boolean unused = topLayoutDislike2.f = !topLayoutDislike2.f;
                    if (TopLayoutDislike2.this.f) {
                        i = t.d(TopLayoutDislike2.this.getContext(), "tt_mute");
                    } else {
                        i = t.d(TopLayoutDislike2.this.getContext(), "tt_unmute");
                    }
                    TopLayoutDislike2.this.b.setImageResource(i);
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.b(view);
                    }
                }
            });
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.a(view);
                    }
                }
            });
        }
    }

    public void setShowSkip(boolean z) {
        TextView textView = this.c;
        if (textView != null) {
            if (!z) {
                textView.setText("");
            }
            if (this.c.getVisibility() != 4) {
                this.c.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void setSkipEnable(boolean z) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setEnabled(z);
            this.c.setClickable(z);
        }
    }

    public void setShowSound(boolean z) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void setSoundMute(boolean z) {
        int i2;
        this.f = z;
        if (this.f) {
            i2 = t.d(getContext(), "tt_mute");
        } else {
            i2 = t.d(getContext(), "tt_unmute");
        }
        this.b.setImageResource(i2);
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.h = charSequence;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.i = charSequence2;
        }
        if (this.c != null) {
            CharSequence charSequence3 = this.h;
            if (!TextUtils.isEmpty(this.i)) {
                charSequence3 = charSequence3 + " | " + this.i;
            }
            this.c.setText(charSequence3);
        }
    }

    public void setShowDislike(boolean z) {
        View view = this.a;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setListener(b bVar) {
        this.g = bVar;
    }

    public void a() {
        TextView textView = this.c;
        if (textView != null) {
            textView.performClick();
        }
    }

    public void b() {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    public void c() {
        this.c.setWidth(20);
        this.c.setVisibility(4);
    }
}
