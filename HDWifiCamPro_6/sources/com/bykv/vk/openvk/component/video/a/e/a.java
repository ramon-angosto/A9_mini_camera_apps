package com.bykv.vk.openvk.component.video.a.e;

import android.os.Build;
import android.view.View;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* compiled from: MediaHelper */
public class a {
    private static final int a = Build.VERSION.SDK_INT;

    public static int a(long j, long j2) {
        return Math.min(Math.max(0, j2 > 0 ? (int) (((((double) j) * 1.0d) / ((double) j2)) * 100.0d) : 0), 100);
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        long j3 = ((j % 3600000) % ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) / 1000;
        if (j2 >= 10) {
            sb.append(j2);
        } else if (j2 > 0) {
            sb.append(0);
            sb.append(j2);
        } else {
            sb.append(0);
            sb.append(0);
        }
        sb.append(":");
        if (j3 >= 10) {
            sb.append(j3);
        } else if (j3 > 0) {
            sb.append(0);
            sb.append(j3);
        } else {
            sb.append(0);
            sb.append(0);
        }
        return sb.toString();
    }

    public static void a(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setSystemUiVisibility(0);
                return;
            }
            int i = a;
            if (i >= 19) {
                view.setSystemUiVisibility(3846);
            } else if (i >= 16) {
                view.setSystemUiVisibility(5);
            } else {
                view.setSystemUiVisibility(1);
            }
        }
    }
}
