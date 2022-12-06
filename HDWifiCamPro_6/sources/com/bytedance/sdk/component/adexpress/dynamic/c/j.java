package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.c.a;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LayoutUnitSizeUtils */
public class j {
    private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"dislike", "close", "close-fill", "webview-close"})));
    private static String b;

    public static a.c a(String str, String str2, String str3, boolean z, boolean z2, int i) {
        float f;
        int i2;
        int i3;
        a.c cVar = new a.c();
        if (str.startsWith("<svg") || a.contains(str2)) {
            try {
                if ("close".equals(str2)) {
                    float optDouble = (float) new JSONObject(str3).optDouble(TtmlNode.ATTR_TTS_FONT_SIZE);
                    cVar.a = optDouble;
                    cVar.b = optDouble;
                    return cVar;
                }
            } catch (Exception unused) {
            }
            cVar.a = 10.0f;
            cVar.b = 10.0f;
            return cVar;
        } else if (!"logo".equals(str2)) {
            if ("development-name".equals(str2)) {
                str = t.a(d.a(), "tt_text_privacy_development") + str;
            }
            if ("app-version".equals(str2)) {
                str = t.a(d.a(), "tt_text_privacy_app_version") + str;
            }
            if ("score-count".equals(str2)) {
                try {
                    i3 = Integer.parseInt(str);
                } catch (NumberFormatException unused2) {
                    i3 = 0;
                }
                return a("(" + String.format(t.a(d.a(), "tt_comment_num"), new Object[]{Integer.valueOf(i3)}) + ")", str3);
            } else if ("score-count-type-2".equals(str2)) {
                try {
                    i2 = Integer.parseInt(str);
                } catch (NumberFormatException unused3) {
                    i2 = 0;
                }
                return a("(" + String.format(new DecimalFormat("###,###,###").format((long) i2), new Object[]{Integer.valueOf(i2)}) + ")", str3);
            } else if ("feedback-dislike".equals(str2)) {
                return a(t.a(d.a(), "tt_reward_feedback"), str3);
            } else {
                if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
                    return a("00S", str3);
                }
                if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
                    return a(" | " + t.a(d.a(), "tt_reward_screen_skip_tx"), str3);
                } else if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
                    return a(" | " + String.format(t.a(d.a(), "tt_reward_full_skip_count_down"), new Object[]{"00"}), str3);
                } else if ("skip-with-time-skip-btn".equals(str2)) {
                    return a(" |  " + t.a(d.a(), "tt_reward_screen_skip_tx"), str3);
                } else if ("skip".equals(str2)) {
                    return a(t.a(d.a(), "tt_reward_screen_skip_tx"), str3);
                } else {
                    if ("timedown".equals(str2)) {
                        return a("0.0", str3);
                    }
                    if ("text_star".equals(str2)) {
                        return a("0.0", str3);
                    }
                    if (TextUtils.equals("privacy-detail", str2)) {
                        return a("Permission list | Privacy policy", str3);
                    }
                    if ("arrowButton".equals(str2)) {
                        return a("Download", str3);
                    }
                    if (CampaignEx.JSON_KEY_TITLE.equals(str2)) {
                        try {
                            return a(str.replace(10, ' '), str3, true);
                        } catch (Exception unused4) {
                        }
                    }
                    if ("fillButton".equals(str2) || MimeTypes.BASE_TYPE_TEXT.equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || "source".equals(str2) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2)) {
                        return a(str, str3);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        int length = str.length();
                        float optDouble2 = (float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE);
                        float optDouble3 = (float) jSONObject.optDouble("letterSpacing");
                        float optDouble4 = (float) jSONObject.optDouble("lineHeight");
                        float optDouble5 = (float) jSONObject.optDouble("maxWidth");
                        float f2 = (((float) length) * (optDouble2 + optDouble3)) - optDouble3;
                        l.e("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + optDouble3 + ",lineHeight==" + optDouble4 + ",maxWidth ==" + optDouble5 + ",totalStrLength" + f2);
                        if ("muted".equals(str2)) {
                            cVar.a = optDouble2;
                            cVar.b = optDouble2;
                            return cVar;
                        } else if ("star".equals(str2)) {
                            a.c a2 = a("str", str3);
                            a2.a = optDouble2 * 5.0f;
                            return a2;
                        } else if (RewardPlus.ICON.equals(str2)) {
                            cVar.a = optDouble2;
                            cVar.b = optDouble2;
                            return cVar;
                        } else {
                            if (z) {
                                int i4 = ((int) (f2 / optDouble5)) + 1;
                                if (z2 && i4 >= i) {
                                    i4 = i;
                                }
                                f = (float) (((double) (optDouble4 * optDouble2 * ((float) i4))) * 1.2d);
                            } else {
                                float f3 = (float) (((double) (optDouble4 * optDouble2)) * 1.2d);
                                if (f2 <= optDouble5) {
                                    optDouble5 = f2;
                                }
                                f = f3;
                            }
                            cVar.a = optDouble5;
                            cVar.b = f;
                            return cVar;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (d.b() || ((TextUtils.isEmpty(str) || !str.contains("adx:")) && !b())) {
            cVar.a = "union".equals(str) ? 10.0f : 20.0f;
            cVar.b = 10.0f;
            if (d.b()) {
                if ((str2 + str).contains("logoad")) {
                    return a("AD", str3);
                }
            }
            return cVar;
        } else if (b()) {
            return a(cVar, str, str3, b);
        } else {
            return a(cVar, str, str3, "");
        }
    }

    public static String a(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("adx:")) != null && split.length >= 2) {
            return split[1];
        }
        return "";
    }

    private static a.c a(a.c cVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            cVar.a = 0.0f;
            cVar.b = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = a(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                return a(str3, str2);
            }
            cVar.a = 0.0f;
            cVar.b = 0.0f;
        }
        return cVar;
    }

    public static a.c a(String str, String str2) {
        return a(str, str2, false);
    }

    public static a.c a(String str, String str2, boolean z) {
        a.c cVar = new a.c();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] a2 = a(str, (float) Double.parseDouble(jSONObject.optString(TtmlNode.ATTR_TTS_FONT_SIZE)), z);
            cVar.a = (float) a2[0];
            cVar.b = (float) a2[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                cVar.b = 0.0f;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }

    public static int[] a(String str, float f, boolean z) {
        int[] b2 = b(str, f, z);
        return new int[]{b.b(d.a(), (float) b2[0]), b.b(d.a(), (float) b2[1])};
    }

    public static int[] b(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(d.a());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static String a() {
        return b;
    }

    public static boolean b() {
        return !TextUtils.isEmpty(b);
    }
}
