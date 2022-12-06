package com.bytedance.sdk.openadsdk.api.open;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.a.d.b;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import java.util.Map;

public abstract class PAGAppOpenAd implements PangleAd {
    public Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    public abstract void setAdInteractionListener(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener);

    public abstract void show(Activity activity);

    public static void loadAd(String str, PAGAppOpenRequest pAGAppOpenRequest, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
        new b().a(str, pAGAppOpenRequest, pAGAppOpenAdLoadListener);
    }
}
