package com.mbridge.msdk.foundation.b.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.mbridge.msdk.b.a;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: FeedBackBtnBean */
public final class a {
    private static int t = -1;
    /* access modifiers changed from: private */
    public static String y;
    private String a;
    private CampaignEx b;
    private FeedBackButton c;
    private int d;
    private int e;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private float j = -1.0f;
    private JSONArray k;
    private int l = -1;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private String p;
    private String q;
    private float r = 1.0f;
    private int s = u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 20.0f);
    private int u = t;
    /* access modifiers changed from: private */
    public MBFeedBackDialog v;
    private List<C0058a> w = new ArrayList();
    private com.mbridge.msdk.widget.dialog.a x = new com.mbridge.msdk.widget.dialog.a() {
        public final void a() {
            a.a(a.this);
        }

        public final void b() {
            a.b(a.this);
        }
    };

    public a(String str) {
        this.a = str;
        if (this.w == null) {
            this.w = new ArrayList();
        }
        i();
        l();
        j();
    }

    private void i() {
        if (this.x == null) {
            this.x = new com.mbridge.msdk.widget.dialog.a() {
                public final void a() {
                    a.a(a.this);
                }

                public final void b() {
                    a.b(a.this);
                }
            };
        }
    }

    public final void a() {
        b.a().a(this.a, 0, 1, y);
        Activity a2 = b.a().a(com.mbridge.msdk.foundation.controller.a.e().g());
        MBFeedBackDialog mBFeedBackDialog = this.v;
        if (mBFeedBackDialog == null || mBFeedBackDialog.getContext() != a2) {
            j();
        }
        Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            g2 = feedBackButton.getContext();
        }
        int i2 = b.a().a(this.a, g2, this.v) ? 2 : 3;
        if (i2 == 2) {
            b.a().a(this.a, 0, 2, y);
        } else {
            b.a().a(this.a, 0, 3, y);
        }
        List<C0058a> list = this.w;
        if (list != null) {
            for (C0058a next : list) {
                if (next != null) {
                    next.a(i2);
                }
            }
        }
    }

    public final void b() {
        MBFeedBackDialog mBFeedBackDialog = this.v;
        if (mBFeedBackDialog != null && mBFeedBackDialog.isShowing()) {
            this.v.cancel();
        }
    }

    private void j() {
        try {
            if (b.a().a(com.mbridge.msdk.foundation.controller.a.e().g()) != null) {
                com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
                if (b2 == null) {
                    b2 = com.mbridge.msdk.b.b.a().b();
                }
                a.b aa = b2.aa();
                if (aa == null) {
                    q.b("", "feedback fbk is null");
                    return;
                }
                i();
                this.v = new MBFeedBackDialog(b.a().a(com.mbridge.msdk.foundation.controller.a.e().g()), this.x);
                FeedbackRadioGroup a2 = a(aa);
                this.v.setCancelText(aa.c());
                this.v.setConfirmText(aa.b());
                this.v.setTitle(aa.a());
                this.v.setContent(a2);
                this.v.setCancelButtonClickable(!TextUtils.isEmpty(y));
                a(a2, aa);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(int i2) {
        this.u = i2;
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.mbridge.msdk.widget.FeedbackRadioGroup r12, com.mbridge.msdk.b.a.b r13) {
        /*
            r11 = this;
            org.json.JSONArray r13 = r13.d()
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r0 = r0.g()
            if (r13 == 0) goto L_0x007e
            int r1 = r13.length()
            if (r1 <= 0) goto L_0x007e
            if (r0 == 0) goto L_0x007e
            java.lang.String r1 = "mbridge_cm_feedback_choice_btn_bg"
            java.lang.String r2 = "drawable"
            int r1 = com.mbridge.msdk.foundation.tools.k.a(r0, r1, r2)
            android.content.res.Resources r2 = com.mbridge.msdk.foundation.tools.k.a(r0)
            java.lang.String r3 = "mbridge_cm_feedback_rb_text_color_color_list"
            java.lang.String r4 = "color"
            int r3 = com.mbridge.msdk.foundation.tools.k.a(r0, r3, r4)
            r4 = 0
            if (r2 == 0) goto L_0x0036
            android.content.res.ColorStateList r2 = r2.getColorStateList(r3)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0037
        L_0x0032:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0036:
            r2 = r4
        L_0x0037:
            r3 = 1096810496(0x41600000, float:14.0)
            int r3 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r0, (float) r3)
            r5 = 1088421888(0x40e00000, float:7.0)
            int r5 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r0, (float) r5)
            r6 = 1086324736(0x40c00000, float:6.0)
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r0, (float) r6)
            r7 = 0
        L_0x004a:
            int r8 = r13.length()
            if (r7 >= r8) goto L_0x007e
            java.lang.String r8 = r13.optString(r7)
            android.widget.RadioButton r9 = new android.widget.RadioButton
            r9.<init>(r0)
            r9.setButtonDrawable(r4)
            r9.setBackgroundResource(r1)
            r9.setText(r8)
            if (r2 == 0) goto L_0x0067
            r9.setTextColor(r2)
        L_0x0067:
            r9.setPadding(r3, r5, r3, r5)
            android.widget.RadioGroup$LayoutParams r8 = new android.widget.RadioGroup$LayoutParams
            r10 = -2
            r8.<init>(r10, r10)
            int r10 = r6 / 4
            r8.setMargins(r6, r10, r6, r10)
            r11.a((android.widget.RadioButton) r9)
            r12.addView(r9, r8)
            int r7 = r7 + 1
            goto L_0x004a
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.b.a.a.a(com.mbridge.msdk.widget.FeedbackRadioGroup, com.mbridge.msdk.b.a$b):void");
    }

    private FeedbackRadioGroup a(a.b bVar) {
        JSONArray d2 = bVar.d();
        Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
        if (d2 == null || d2.length() <= 0 || g2 == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(g2);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        String unused = a.y = (String) compoundButton.getText();
                    }
                    if (a.this.v != null) {
                        a.this.v.setCancelButtonClickable(!TextUtils.isEmpty(a.y));
                    }
                }
            });
        }
    }

    public final void a(C0058a aVar) {
        if (this.w == null) {
            this.w = new ArrayList();
        }
        this.w.add(aVar);
    }

    private void k() {
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            int i2 = this.f;
            if (i2 > -1) {
                feedBackButton.setX((float) i2);
            }
            int i3 = this.g;
            if (i3 > -1) {
                this.c.setY((float) i3);
            }
            float f2 = this.r;
            if (f2 >= 0.0f) {
                this.c.setAlpha(f2);
                this.c.setEnabled(this.r != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            int i4 = this.h;
            if (i4 > 0) {
                this.c.setWidth(i4);
                if (layoutParams != null) {
                    layoutParams.width = this.h;
                }
            }
            int i5 = this.i;
            if (i5 > 0) {
                this.c.setHeight(i5);
                if (layoutParams != null) {
                    layoutParams.height = this.i;
                }
            }
            if (layoutParams != null) {
                this.c.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.p)) {
                    this.c.setTextColor(Color.parseColor(this.p));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            float f3 = this.j;
            if (f3 > 0.0f) {
                this.c.setTextSize(f3);
            }
            JSONArray jSONArray = this.k;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                this.c.setPadding(u.b(g2, (float) this.k.optDouble(0)), u.b(g2, (float) this.k.optDouble(1)), u.b(g2, (float) this.k.optDouble(2)), u.b(g2, (float) this.k.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i6 = this.s;
            if (i6 > 0) {
                gradientDrawable.setCornerRadius((float) i6);
            }
            if (!TextUtils.isEmpty(this.q)) {
                gradientDrawable.setColor(Color.parseColor(this.q));
            } else {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            }
            this.c.setBackground(gradientDrawable);
        }
    }

    public final void a(int i2, int i3, int i4, int i5, int i6, float f2, String str, String str2, float f3, JSONArray jSONArray) {
        if (i2 > -1) {
            this.f = i2;
        }
        if (i3 > -1) {
            this.g = i3;
        }
        if (i4 > -1) {
            this.h = i4;
        }
        if (i5 > -1) {
            this.i = i5;
        }
        if (f3 > -1.0f) {
            this.j = f3;
        }
        if (jSONArray != null) {
            this.k = jSONArray;
        }
        this.p = str;
        this.q = str2;
        this.r = f2;
        this.s = i6;
        k();
    }

    private void l() {
        Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
        if (g2 != null) {
            try {
                this.c = new FeedBackButton(g2);
                FeedBackButton feedBackButton = this.c;
                int i2 = 8;
                if (this.u != 8) {
                    i2 = 0;
                }
                feedBackButton.setVisibility(i2);
                this.c.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.this.a();
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final FeedBackButton c() {
        if (this.c == null) {
            l();
        }
        return this.c;
    }

    public final void d() {
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener((View.OnClickListener) null);
            this.c.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.c.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.c);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.v;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.v.setListener((com.mbridge.msdk.widget.dialog.a) null);
        }
        this.v = null;
        this.w = null;
        this.c = null;
        this.x = null;
    }

    public final CampaignEx e() {
        return this.b;
    }

    public final void a(CampaignEx campaignEx) {
        this.b = campaignEx;
    }

    public final int f() {
        return this.d;
    }

    public final void b(int i2) {
        this.d = i2;
    }

    public final int g() {
        return this.e;
    }

    public final void c(int i2) {
        this.e = i2;
    }

    /* renamed from: com.mbridge.msdk.foundation.b.a.a$a  reason: collision with other inner class name */
    /* compiled from: FeedBackBtnBean */
    public static class C0058a implements com.mbridge.msdk.widget.dialog.a {
        private com.mbridge.msdk.foundation.b.a a;
        private String b;

        public C0058a(String str, com.mbridge.msdk.foundation.b.a aVar) {
            this.a = aVar;
            this.b = str;
        }

        public final void a() {
            b.c = false;
            com.mbridge.msdk.foundation.b.a aVar = this.a;
            if (aVar != null) {
                aVar.a(a.y);
            }
        }

        public final void b() {
            b.c = false;
            com.mbridge.msdk.foundation.b.a aVar = this.a;
            if (aVar != null) {
                aVar.b();
            }
        }

        public final void a(int i) {
            b.c = true;
            com.mbridge.msdk.foundation.b.a aVar = this.a;
            if (aVar != null && i == 2) {
                aVar.a();
            }
        }
    }

    public final void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.c;
        int i2 = 8;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.r);
            feedBackButton.setEnabled(this.r != 0.0f);
            if (this.u != 8) {
                i2 = 0;
            }
            feedBackButton.setVisibility(i2);
            this.c = feedBackButton;
            k();
            feedBackButton.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.a();
                }
            });
        }
    }

    static /* synthetic */ void a(a aVar) {
        b.a().a(aVar.a, 1, 4, y);
        List<C0058a> list = aVar.w;
        if (list != null) {
            for (C0058a next : list) {
                if (next != null) {
                    next.a();
                }
            }
        }
        y = "";
    }

    static /* synthetic */ void b(a aVar) {
        b.a().a(aVar.a, 0, 4, y);
        List<C0058a> list = aVar.w;
        if (list != null) {
            for (C0058a next : list) {
                if (next != null) {
                    next.b();
                }
            }
        }
        y = "";
    }
}
