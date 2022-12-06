package com.bytedance.sdk.openadsdk.l;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.b;
import java.io.File;

/* compiled from: FileCacheUtils */
public class g {
    private static String a;

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = b.a().getCacheDir() + File.separator + "proxy_cache";
        }
        return a;
    }
}
