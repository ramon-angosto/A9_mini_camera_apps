package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.com.bytedance.overseas.sdk.a.c;
import com.com.bytedance.overseas.sdk.a.d;
import org.json.JSONObject;

/* compiled from: RewardFullDownloadManager */
public class a {
    c a;
    private Activity b;
    private n c;
    private String d;
    private boolean e = false;

    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.a.a$a  reason: collision with other inner class name */
    /* compiled from: RewardFullDownloadManager */
    public interface C0041a {
        void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3);

        void a(String str, JSONObject jSONObject);
    }

    public a(Activity activity) {
        this.b = activity;
    }

    public void a(n nVar, String str) {
        if (!this.e) {
            this.e = true;
            this.c = nVar;
            this.d = str;
            d();
        }
    }

    private void d() {
        if (b.c()) {
            n nVar = this.c;
            if (nVar != null && nVar.L() == 4) {
                this.a = d.a(this.b, this.c, this.d);
                return;
            }
            return;
        }
        this.a = r.a().g();
    }

    public void a() {
        n nVar;
        if (this.a == null && (nVar = this.c) != null) {
            this.a = d.a(this.b, nVar, this.d);
        }
    }

    public void b() {
        com.com.bytedance.overseas.sdk.a.c cVar = this.a;
        if (cVar != null) {
            cVar.d();
        }
    }

    public com.com.bytedance.overseas.sdk.a.c c() {
        return this.a;
    }

    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3, C0041a aVar) {
        C0041a aVar2 = aVar;
        if (this.a == null) {
            aVar.a(view, f, f2, f3, f4, sparseArray, i, i2, i3);
        } else if (view.getId() == t.e(this.b, "tt_rb_score")) {
            aVar2.a("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == t.e(this.b, "tt_comment_vertical")) {
            aVar2.a("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == t.e(this.b, "tt_reward_ad_appname")) {
            aVar2.a("click_play_source", (JSONObject) null);
        } else if (view.getId() == t.e(this.b, "tt_reward_ad_icon")) {
            aVar2.a("click_play_logo", (JSONObject) null);
        }
    }
}
