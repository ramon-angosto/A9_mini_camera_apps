package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* compiled from: NetworkUtils */
public class o {
    public static boolean a(Context context) {
        return c(context) != 0;
    }

    public static int b(Context context) {
        int c = c(context);
        if (c == 1) {
            return 0;
        }
        if (c == 4) {
            return 1;
        }
        if (c == 5) {
            return 4;
        }
        if (c != 6) {
            return c;
        }
        return 6;
    }

    public static int c(Context context) {
        return v.a(context, (long) ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
    }

    public static boolean d(Context context) {
        return c(context) == 4;
    }

    public static boolean e(Context context) {
        return c(context) == 5;
    }

    public static boolean f(Context context) {
        return c(context) == 6;
    }

    public static String g(Context context) {
        int c = c(context);
        if (c == 2) {
            return "2g";
        }
        if (c == 3) {
            return "3g";
        }
        if (c == 4) {
            return "wifi";
        }
        if (c != 5) {
            return c != 6 ? "mobile" : "5g";
        }
        return "4g";
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }
}
