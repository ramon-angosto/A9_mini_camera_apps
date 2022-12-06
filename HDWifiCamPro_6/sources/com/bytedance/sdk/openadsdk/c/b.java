package com.bytedance.sdk.openadsdk.c;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: AdEventConstants */
public class b {
    public static final Set<String> a = new HashSet(Arrays.asList(new String[]{CampaignEx.JSON_NATIVE_VIDEO_CLICK, "show", "insight_log"}));

    public static boolean a(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
