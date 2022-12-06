package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.a.g;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: RewardFullBackUpEndCard */
public class a {
    LinearLayout a;
    FrameLayout b;
    TTRoundRectImageView c;
    TextView d;
    TTRatingBar2 e;
    TextView f;
    TextView g;
    /* access modifiers changed from: private */
    public final Activity h;
    private boolean i;
    private TextView j;
    private g k;

    public a(Activity activity) {
        this.h = activity;
    }

    public void a() {
        if (!this.i) {
            this.i = true;
            d();
        }
    }

    private void d() {
        Activity activity = this.h;
        this.b = (FrameLayout) activity.findViewById(t.e(activity, "tt_reward_full_endcard_backup_container"));
        Activity activity2 = this.h;
        this.a = (LinearLayout) activity2.findViewById(t.e(activity2, "tt_reward_full_endcard_backup"));
        Activity activity3 = this.h;
        this.c = (TTRoundRectImageView) activity3.findViewById(t.e(activity3, "tt_reward_ad_icon_backup"));
        Activity activity4 = this.h;
        this.d = (TextView) activity4.findViewById(t.e(activity4, "tt_reward_ad_appname_backup"));
        Activity activity5 = this.h;
        this.e = (TTRatingBar2) activity5.findViewById(t.e(activity5, "tt_rb_score_backup"));
        Activity activity6 = this.h;
        this.f = (TextView) activity6.findViewById(t.e(activity6, "tt_comment_backup"));
        Activity activity7 = this.h;
        this.g = (TextView) activity7.findViewById(t.e(activity7, "tt_reward_ad_download_backup"));
        Activity activity8 = this.h;
        this.j = (TextView) activity8.findViewById(t.e(activity8, "tt_ad_endcard_logo"));
    }

    public void a(e eVar) {
        z.a((View) this.b, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mFLEndCardBackupContainer");
        this.g.setOnClickListener(eVar);
        this.g.setOnTouchListener(eVar);
        if (this.k == null) {
            this.k = new g(this.h);
        }
        this.k.a(eVar);
    }

    public void b() {
        z.a((View) this.b, 0);
        z.a((View) this.a, 0);
        g gVar = this.k;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void c() {
        TTRoundRectImageView tTRoundRectImageView = this.c;
        if (tTRoundRectImageView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, (int) z.b((Context) this.h, 50.0f), 0, 0);
            this.c.setLayoutParams(layoutParams);
        }
    }

    public void a(n nVar) {
        if (nVar.aw()) {
            if (this.k == null) {
                this.k = new g(this.h);
            }
            this.k.a(nVar);
            return;
        }
        if (!(this.c == null || nVar.M() == null || TextUtils.isEmpty(nVar.M().a()))) {
            d.a().a(nVar.M(), (ImageView) this.c);
        }
        TTRatingBar2 tTRatingBar2 = this.e;
        if (tTRatingBar2 != null) {
            z.a((TextView) null, tTRatingBar2, nVar, (Context) this.h);
        }
        if (this.d != null) {
            if (nVar.aa() == null || TextUtils.isEmpty(nVar.aa().b())) {
                this.d.setText(nVar.U());
            } else {
                this.d.setText(nVar.aa().b());
            }
        }
        TextView textView = this.f;
        if (textView != null) {
            z.a(textView, nVar, (Context) this.h, "tt_comment_num_backup");
        }
    }

    public void a(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.g) != null) {
            textView.setText(str);
        }
    }

    public void a(final n nVar, final String str) {
        this.j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.a(a.this.h, nVar, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public boolean a(com.bytedance.sdk.openadsdk.component.reward.a.e eVar) {
        g gVar = this.k;
        if (gVar == null || !gVar.a(eVar)) {
            return false;
        }
        z.a((View) this.b, 0);
        z.a((View) this.a, 8);
        return true;
    }
}
