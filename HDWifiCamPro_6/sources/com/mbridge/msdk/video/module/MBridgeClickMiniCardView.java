package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.download.g;
import org.json.JSONObject;

public class MBridgeClickMiniCardView extends MBridgeH5EndCardView {
    private boolean x = false;

    public MBridgeClickMiniCardView(Context context) {
        super(context);
    }

    public MBridgeClickMiniCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        if (this.f) {
            a(this.m);
        }
        super.onSelfConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    public final void e() {
        super.e();
        if (this.f) {
            setBackgroundResource(findColor("mbridge_reward_minicard_bg"));
            a(this.m);
            setClickable(true);
        }
    }

    /* access modifiers changed from: protected */
    public final String a() {
        String str = null;
        if (this.b == null) {
            return null;
        }
        CampaignEx.c rewardTemplateMode = this.b.getRewardTemplateMode();
        if (rewardTemplateMode != null) {
            str = rewardTemplateMode.d();
        }
        if (TextUtils.isEmpty(str) || !str.contains(".zip")) {
            return str;
        }
        String b = g.a().b(str);
        return !TextUtils.isEmpty(b) ? b : str;
    }

    public void preLoadData(b bVar) {
        super.preLoadData(bVar);
        setCloseVisible(0);
    }

    public void webviewshow() {
        if (this.p != null) {
            this.p.post(new Runnable() {
                public final void run() {
                    try {
                        q.a(MBridgeBaseView.TAG, "webviewshow");
                        String str = "";
                        try {
                            int[] iArr = new int[2];
                            MBridgeClickMiniCardView.this.p.getLocationOnScreen(iArr);
                            q.d(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", u.a(a.e().g(), (float) iArr[0]));
                            jSONObject.put("startY", u.a(a.e().g(), (float) iArr[1]));
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            q.a(MBridgeBaseView.TAG, th.getMessage(), th);
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeClickMiniCardView.this.p, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void a(View view) {
        int h = u.h(this.a);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) ((((float) h) * 0.7f) + 0.5f);
        layoutParams.height = (int) ((((float) u.g(this.a)) * 0.7f) + 0.5f);
        view.setLayoutParams(layoutParams);
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        setBackgroundColor(0);
    }

    public void setMBridgeClickMiniCardViewClickable(boolean z) {
        setClickable(z);
    }

    public void setMiniCardLocation(int i, int i2, int i3, int i4) {
        this.x = true;
        resizeMiniCard(i3, i4);
    }

    public void resizeMiniCard(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 11) {
            View findViewById = ((Activity) this.a).getWindow().findViewById(16908290);
            int width = findViewById.getWidth();
            int height = findViewById.getHeight();
            if (i > 0 && i2 > 0 && i <= width && i2 <= height) {
                ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.m.setLayoutParams(layoutParams);
            }
        }
    }

    public void setRadius(int i) {
        if (i > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) u.b(getContext(), (float) i));
            gradientDrawable.setColor(-1);
            if (Build.VERSION.SDK_INT >= 16) {
                this.p.setBackground(gradientDrawable);
            } else {
                this.p.setBackgroundDrawable(gradientDrawable);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.p.setClipToOutline(true);
            }
        }
    }
}
