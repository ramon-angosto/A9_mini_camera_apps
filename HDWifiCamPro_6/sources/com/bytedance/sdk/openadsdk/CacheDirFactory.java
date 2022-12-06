package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.a.a.a.a;
import com.bykv.vk.openvk.component.video.api.a.b;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.core.m;
import java.io.File;

public class CacheDirFactory {
    public static volatile b MEDIA_CACHE_DIR = null;
    public static String ROOT_DIR = null;
    public static final int SPLASH_USE_INTERNAL_STORAGE = 1;
    public static volatile b TTVIDEO_CACHE_DIR = null;
    private static String a = null;
    private static int b = 1;

    private static b a() {
        if (MEDIA_CACHE_DIR == null) {
            synchronized (CacheDirFactory.class) {
                if (MEDIA_CACHE_DIR == null) {
                    MEDIA_CACHE_DIR = new a();
                    MEDIA_CACHE_DIR.a(getRootDir());
                    MEDIA_CACHE_DIR.d();
                }
            }
        }
        return MEDIA_CACHE_DIR;
    }

    public static String getRootDir() {
        if (!TextUtils.isEmpty(ROOT_DIR)) {
            return ROOT_DIR;
        }
        File a2 = f.a(m.a(), com.bytedance.sdk.openadsdk.multipro.b.c(), "tt_ad");
        if (a2.isFile()) {
            a2.delete();
        }
        if (!a2.exists()) {
            a2.mkdirs();
        }
        ROOT_DIR = a2.getAbsolutePath();
        return ROOT_DIR;
    }

    public static b getICacheDir(int i) {
        return a();
    }

    public static String getBrandCacheDir() {
        return getRootDir() + File.separator + "video_brand";
    }

    public static int getCacheType() {
        return b;
    }

    public static String getImageCacheDir() {
        if (a == null) {
            a = getDiskCacheDirPath("image");
        }
        return a;
    }

    public static String getDiskCacheDirPath(String str) {
        return getRootDir() + File.separator + str;
    }
}
