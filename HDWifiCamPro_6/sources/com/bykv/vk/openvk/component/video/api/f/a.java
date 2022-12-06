package com.bykv.vk.openvk.component.video.api.f;

import android.content.Context;

/* compiled from: FileHelper */
public class a {
    static Context a;

    public static void a(Context context) {
        if (context != null) {
            a = context;
            return;
        }
        throw new NullPointerException();
    }
}
