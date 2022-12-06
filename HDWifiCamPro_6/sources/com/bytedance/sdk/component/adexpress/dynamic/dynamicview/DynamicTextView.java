package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c.j;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        if (this.l.C()) {
            this.o = new AnimationText(context, this.l.g(), this.l.e(), 1, this.l.h());
            ((AnimationText) this.o).setMaxLines(1);
        } else {
            this.o = new TextView(context);
            ((TextView) this.o).setIncludeFontPadding(false);
        }
        this.o.setTag(Integer.valueOf(getClickArea()));
        addView(this.o, getWidgetLayoutParams());
    }

    public boolean i() {
        int i;
        super.i();
        if (TextUtils.isEmpty(getText())) {
            this.o.setVisibility(4);
            return true;
        } else if (this.l.C()) {
            k();
            return true;
        } else {
            ((TextView) this.o).setText(this.l.f());
            if (Build.VERSION.SDK_INT >= 17) {
                this.o.setTextAlignment(this.l.h());
            }
            ((TextView) this.o).setTextColor(this.l.g());
            ((TextView) this.o).setTextSize(this.l.e());
            if (!this.l.v()) {
                ((TextView) this.o).setMaxLines(1);
                ((TextView) this.o).setGravity(17);
                ((TextView) this.o).setEllipsize(TextUtils.TruncateAt.END);
            } else {
                int w = this.l.w();
                if (w > 0) {
                    ((TextView) this.o).setLines(w);
                    ((TextView) this.o).setEllipsize(TextUtils.TruncateAt.END);
                }
            }
            if (!(this.m == null || this.m.i() == null)) {
                if (!d.b() || !a() || (!TextUtils.equals(this.m.i().b(), "text_star") && !TextUtils.equals(this.m.i().b(), "score-count") && !TextUtils.equals(this.m.i().b(), "score-count-type-1") && !TextUtils.equals(this.m.i().b(), "score-count-type-2"))) {
                    if (TextUtils.equals(this.m.i().b(), "score-count") || TextUtils.equals(this.m.i().b(), "score-count-type-2")) {
                        try {
                            i = Integer.parseInt(getText());
                        } catch (NumberFormatException unused) {
                            i = -1;
                        }
                        if (i < 0) {
                            try {
                                if (d.b()) {
                                    setVisibility(8);
                                    return true;
                                }
                                this.o.setVisibility(0);
                            } catch (Exception unused2) {
                            }
                        }
                        if (TextUtils.equals(this.m.i().b(), "score-count-type-2")) {
                            ((TextView) this.o).setText(String.format(new DecimalFormat("(###,###,###)").format((long) i), new Object[]{Integer.valueOf(i)}));
                            ((TextView) this.o).setGravity(17);
                            return true;
                        }
                        a((TextView) this.o, i, getContext(), "tt_comment_num");
                    } else if (TextUtils.equals(this.m.i().b(), "text_star")) {
                        double d = -1.0d;
                        try {
                            d = Double.parseDouble(getText());
                        } catch (Exception e) {
                            l.e("DynamicStarView applyNativeStyle", e.toString());
                        }
                        if (d < 0.0d || d > 5.0d) {
                            if (d.b()) {
                                setVisibility(8);
                                return true;
                            }
                            this.o.setVisibility(0);
                        }
                        ((TextView) this.o).setIncludeFontPadding(false);
                        ((TextView) this.o).setText(String.format("%.1f", new Object[]{Double.valueOf(d)}));
                    } else if (TextUtils.equals("privacy-detail", this.m.i().b())) {
                        ((TextView) this.o).setText("Permission list | Privacy policy");
                    } else if (TextUtils.equals(this.m.i().b(), "development-name")) {
                        ((TextView) this.o).setText(t.a(d.a(), "tt_text_privacy_development") + getText());
                    } else if (TextUtils.equals(this.m.i().b(), "app-version")) {
                        ((TextView) this.o).setText(t.a(d.a(), "tt_text_privacy_app_version") + getText());
                    } else {
                        ((TextView) this.o).setText(getText());
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.o.setTextAlignment(this.l.h());
                        ((TextView) this.o).setGravity(this.l.i());
                    }
                    if (d.b()) {
                        j();
                    }
                } else {
                    setVisibility(8);
                    return true;
                }
            }
            return true;
        }
    }

    private boolean a() {
        return (this.n == null || this.n.getRenderRequest() == null || this.n.getRenderRequest().g() == 4) ? false : true;
    }

    private void j() {
        if (TextUtils.equals(this.m.i().b(), "source") || TextUtils.equals(this.m.i().b(), CampaignEx.JSON_KEY_TITLE) || TextUtils.equals(this.m.i().b(), "text_star")) {
            int[] b = j.b(this.l.f(), this.l.e(), true);
            int a = (int) b.a(getContext(), (float) this.l.b());
            int a2 = (int) b.a(getContext(), (float) this.l.c());
            int a3 = (int) b.a(getContext(), (float) this.l.d());
            int a4 = (int) b.a(getContext(), (float) this.l.a());
            int i = (((b[1] + a) + a4) - this.h) - 2;
            int min = Math.min(a, a4);
            if (i > 1) {
                if (i <= min * 2) {
                    int i2 = i / 2;
                    this.o.setPadding(a2, a - i2, a3, a4 - (i - i2));
                } else if (i > a + a4) {
                    final int i3 = (i - a) - a4;
                    this.o.setPadding(a2, 0, a3, 0);
                    if (i3 <= ((int) b.a(getContext(), 1.0f)) + 1) {
                        ((TextView) this.o).setTextSize(this.l.e() - 1.0f);
                    } else if (i3 <= (((int) b.a(getContext(), 1.0f)) + 1) * 2) {
                        ((TextView) this.o).setTextSize(this.l.e() - 2.0f);
                    } else {
                        post(new Runnable() {
                            public void run() {
                                try {
                                    ViewGroup.LayoutParams layoutParams = DynamicTextView.this.o.getLayoutParams();
                                    layoutParams.height = DynamicTextView.this.h + i3;
                                    DynamicTextView.this.o.setLayoutParams(layoutParams);
                                    DynamicTextView.this.o.setTranslationY((float) (-i3));
                                    ((ViewGroup) DynamicTextView.this.o.getParent()).setClipChildren(false);
                                    ((ViewGroup) DynamicTextView.this.o.getParent().getParent()).setClipChildren(false);
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                } else if (a > a4) {
                    this.o.setPadding(a2, a - (i - min), a3, a4 - min);
                } else {
                    this.o.setPadding(a2, a - min, a3, a4 - (i - min));
                }
            } else {
                return;
            }
        }
        if (TextUtils.equals(this.m.i().b(), "fillButton") && Build.VERSION.SDK_INT >= 17) {
            this.o.setTextAlignment(2);
            ((TextView) this.o).setGravity(17);
        }
    }

    public String getText() {
        String f = this.l.f();
        if (TextUtils.isEmpty(f)) {
            if (!d.b() && TextUtils.equals(this.m.i().b(), "text_star")) {
                f = "5";
            }
            if (!d.b() && TextUtils.equals(this.m.i().b(), "score-count")) {
                f = "6870";
            }
        }
        return (TextUtils.equals(this.m.i().b(), CampaignEx.JSON_KEY_TITLE) || TextUtils.equals(this.m.i().b(), "subtitle")) ? f.replace("\n", "") : f;
    }

    public void a(TextView textView, int i, Context context, String str) {
        String format = String.format(t.a(context, str), new Object[]{Integer.valueOf(i)});
        textView.setText("(" + format + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void k() {
        if (this.o instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                arrayList.add(text);
            }
            ((AnimationText) this.o).setMaxLines(1);
            ((AnimationText) this.o).setTextColor(this.l.g());
            ((AnimationText) this.o).setTextSize(this.l.e());
            ((AnimationText) this.o).setAnimationText(arrayList);
            ((AnimationText) this.o).setAnimationType(this.l.E());
            ((AnimationText) this.o).setAnimationDuration(this.l.D() * 1000);
            ((AnimationText) this.o).a();
        }
    }
}
