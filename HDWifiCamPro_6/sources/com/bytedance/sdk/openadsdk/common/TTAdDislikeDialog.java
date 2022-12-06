package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.dislike.d;
import com.bytedance.sdk.openadsdk.l.z;
import java.util.ArrayList;

public class TTAdDislikeDialog extends FrameLayout {
    private View a;
    private TTDislikeListView b;
    private TTDislikeListView c;
    private RelativeLayout d;
    private View e;
    private d.b f;
    private d.b g;
    /* access modifiers changed from: private */
    public n h;
    /* access modifiers changed from: private */
    public a i;
    private boolean j;

    public interface a {
        void a(int i, FilterWord filterWord);

        void a(View view);

        void b(View view);

        void c(View view);
    }

    public TTAdDislikeDialog(Context context, n nVar) {
        this(context.getApplicationContext());
        this.h = nVar;
        c();
    }

    public TTAdDislikeDialog(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTAdDislikeDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTAdDislikeDialog(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = false;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTAdDislikeDialog.this.b();
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.a = LayoutInflater.from(context).inflate(t.f(context, "tt_dislike_dialog_layout"), this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) z.b(getContext(), 20.0f);
        layoutParams.rightMargin = (int) z.b(getContext(), 20.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClickable(true);
        d();
        c();
    }

    private void c() {
        if (this.h != null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            this.f = new d.b(from, this.h.ae());
            this.b.setAdapter(this.f);
            this.g = new d.b(from, new ArrayList());
            this.g.a(false);
            this.c.setAdapter(this.g);
            this.b.setMaterialMeta(this.h.ac());
            this.c.setMaterialMeta(this.h.ac());
        }
    }

    private void d() {
        this.d = (RelativeLayout) this.a.findViewById(t.e(getContext(), "tt_dislike_title_content"));
        this.e = this.a.findViewById(t.e(getContext(), "tt_dislike_line1"));
        TextView textView = (TextView) this.a.findViewById(t.e(getContext(), "tt_dislike_header_back"));
        textView.setText(t.a(getContext(), "tt_dislike_header_tv_back"));
        ((TextView) this.a.findViewById(t.e(getContext(), "tt_dislike_header_tv"))).setText(t.a(getContext(), "tt_dislike_header_tv_title"));
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTAdDislikeDialog.this.e();
                if (TTAdDislikeDialog.this.i != null) {
                    TTAdDislikeDialog.this.i.c(view);
                }
            }
        });
        this.b = (TTDislikeListView) this.a.findViewById(t.e(getContext(), "tt_filer_words_lv"));
        this.b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    android.widget.Adapter r1 = r1.getAdapter()     // Catch:{ all -> 0x0027 }
                    java.lang.Object r1 = r1.getItem(r3)     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.FilterWord r1 = (com.bytedance.sdk.openadsdk.FilterWord) r1     // Catch:{ all -> 0x0027 }
                    boolean r2 = r1.hasSecondOptions()     // Catch:{ all -> 0x0027 }
                    if (r2 == 0) goto L_0x0027
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0027 }
                    r2.a((com.bytedance.sdk.openadsdk.FilterWord) r1)     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r2 = r2.i     // Catch:{ all -> 0x0027 }
                    if (r2 == 0) goto L_0x0026
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r2 = r2.i     // Catch:{ all -> 0x0027 }
                    r2.a(r3, r1)     // Catch:{ all -> 0x0027 }
                L_0x0026:
                    return
                L_0x0027:
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r1 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r1 = r1.i
                    if (r1 == 0) goto L_0x0048
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r1 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0048 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r1 = r1.i     // Catch:{ all -> 0x0048 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0048 }
                    com.bytedance.sdk.openadsdk.core.model.n r2 = r2.h     // Catch:{ all -> 0x0048 }
                    java.util.List r2 = r2.ae()     // Catch:{ all -> 0x0048 }
                    java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0048 }
                    com.bytedance.sdk.openadsdk.FilterWord r2 = (com.bytedance.sdk.openadsdk.FilterWord) r2     // Catch:{ all -> 0x0048 }
                    r1.a(r3, r2)     // Catch:{ all -> 0x0048 }
                L_0x0048:
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r1 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this
                    r1.b()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.AnonymousClass3.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
        this.c = (TTDislikeListView) this.a.findViewById(t.e(getContext(), "tt_filer_words_lv_second"));
        this.c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r2 = r2.i
                    if (r2 == 0) goto L_0x001b
                    android.widget.Adapter r1 = r1.getAdapter()     // Catch:{ all -> 0x001b }
                    java.lang.Object r1 = r1.getItem(r3)     // Catch:{ all -> 0x001b }
                    com.bytedance.sdk.openadsdk.FilterWord r1 = (com.bytedance.sdk.openadsdk.FilterWord) r1     // Catch:{ all -> 0x001b }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x001b }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r2 = r2.i     // Catch:{ all -> 0x001b }
                    r2.a(r3, r1)     // Catch:{ all -> 0x001b }
                L_0x001b:
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r1 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this
                    r1.b()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.AnonymousClass4.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
    }

    public void a() {
        if (this.a.getParent() == null) {
            addView(this.a);
        }
        e();
        setVisibility(0);
        this.j = true;
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void b() {
        setVisibility(8);
        this.j = false;
        a aVar = this.i;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void setCallback(a aVar) {
        this.i = aVar;
    }

    /* access modifiers changed from: private */
    public void e() {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.e;
        if (view != null) {
            view.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView = this.b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
        d.b bVar = this.g;
        if (bVar != null) {
            bVar.a();
        }
        TTDislikeListView tTDislikeListView2 = this.c;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void a(FilterWord filterWord) {
        if (filterWord != null) {
            d.b bVar = this.g;
            if (bVar != null) {
                bVar.a(filterWord.getOptions());
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            View view = this.e;
            if (view != null) {
                view.setVisibility(0);
            }
            TTDislikeListView tTDislikeListView = this.b;
            if (tTDislikeListView != null) {
                tTDislikeListView.setVisibility(8);
            }
            TTDislikeListView tTDislikeListView2 = this.c;
            if (tTDislikeListView2 != null) {
                tTDislikeListView2.setVisibility(0);
            }
        }
    }
}
