package com.bytedance.sdk.openadsdk.core.f.c;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.List;

/* compiled from: VastUtils */
public class d {
    public static final List<String> a = Arrays.asList(new String[]{MimeTypes.VIDEO_MP4, MimeTypes.VIDEO_H263});

    public static double a(int i, double d, int i2, int i3, int i4, String str) {
        double a2 = a(i, d, i2, i3);
        return a(str) * (1.0d / ((a2 + 1.0d) + a(i4)));
    }

    private static double a(int i, double d, int i2, int i3) {
        double d2 = 0.0d;
        double abs = d > 0.0d ? Math.abs(d - (i3 > 0 ? ((double) i2) / ((double) i3) : 0.0d)) : 0.0d;
        if (i > 0) {
            d2 = (double) Math.abs((i - i2) / i);
        }
        return abs + d2;
    }

    private static double a(int i) {
        int max = Math.max(i, 0);
        if (700 > max || max > 1500) {
            return Math.min((double) (((float) Math.abs(700 - max)) / 700.0f), (double) (((float) Math.abs(1500 - max)) / 1500.0f));
        }
        return 0.0d;
    }

    private static double a(String str) {
        if (str == null) {
            str = "";
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1664118616) {
            if (hashCode == 1331848029 && str.equals(MimeTypes.VIDEO_MP4)) {
                c = 0;
            }
        } else if (str.equals(MimeTypes.VIDEO_H263)) {
            c = 1;
        }
        return c != 0 ? 1.0d : 1.5d;
    }
}
