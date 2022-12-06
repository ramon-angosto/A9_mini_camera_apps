package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DynamicLayoutBrick */
public class e {
    public static final Map<String, Integer> a = new HashMap();
    private String b;
    private String c;
    private f d;
    private f e;
    private String f;

    static {
        a.put("root", 8);
        a.put("footer", 6);
        a.put("empty", 6);
        a.put(CampaignEx.JSON_KEY_TITLE, 0);
        a.put("subtitle", 0);
        a.put("source", 0);
        a.put("score-count", 0);
        a.put("text_star", 0);
        a.put(MimeTypes.BASE_TYPE_TEXT, 0);
        a.put("tag-group", 17);
        a.put("app-version", 0);
        a.put("development-name", 0);
        a.put("privacy-detail", 23);
        a.put("image", 1);
        a.put("image-wide", 1);
        a.put("image-square", 1);
        a.put("image-long", 1);
        a.put("image-splash", 1);
        a.put("image-cover", 1);
        a.put("app-icon", 1);
        a.put("icon-download", 1);
        a.put("logoad", 4);
        a.put("logounion", 5);
        a.put("logo-union", 9);
        a.put("dislike", 3);
        a.put("close", 3);
        a.put("close-fill", 3);
        a.put("webview-close", 22);
        a.put("feedback-dislike", 12);
        a.put("button", 2);
        a.put("downloadWithIcon", 2);
        a.put("downloadButton", 2);
        a.put("fillButton", 2);
        a.put("laceButton", 2);
        a.put("cardButton", 2);
        a.put("colourMixtureButton", 2);
        a.put("arrowButton", 1);
        a.put("download-progress-button", 2);
        a.put("vessel", 6);
        a.put("image-group", 6);
        a.put("custom-component-vessel", 6);
        a.put("carousel", 24);
        a.put("video-hd", 7);
        a.put("video", 7);
        a.put("video-vd", 7);
        a.put("video-sq", 7);
        a.put("muted", 10);
        a.put("star", 11);
        a.put("skip-countdowns", 19);
        a.put("skip-with-countdowns-skip-btn", 21);
        a.put("skip-with-countdowns-video-countdown", 13);
        a.put("skip-with-countdowns-skip-countdown", 20);
        a.put("skip-with-time", 14);
        a.put("skip-with-time-countdown", 13);
        a.put("skip-with-time-skip-btn", 15);
        a.put("skip", 15);
        a.put("timedown", 13);
        a.put(RewardPlus.ICON, 16);
        a.put("scoreCountWithIcon", 6);
        a.put("split-line", 18);
        a.put("creative-playable-bait", 0);
        a.put("score-count-type-2", 0);
    }

    public int a() {
        if (TextUtils.isEmpty(this.b)) {
            return 0;
        }
        if (this.b.equals("logo")) {
            this.b += this.c;
            if (this.b.contains("logoad")) {
                return 4;
            }
            if (this.b.contains("logounion")) {
                return 5;
            }
        }
        if (a.get(this.b) != null) {
            return a.get(this.b).intValue();
        }
        return -1;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.f;
    }

    public f e() {
        return this.d;
    }

    public void a(f fVar) {
        this.d = fVar;
    }

    public void b(f fVar) {
        this.e = fVar;
    }

    public f f() {
        return this.e;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.b + '\'' + ", data='" + this.c + '\'' + ", value=" + this.d + ", themeValue=" + this.e + ", dataExtraInfo='" + this.f + '\'' + '}';
    }
}
