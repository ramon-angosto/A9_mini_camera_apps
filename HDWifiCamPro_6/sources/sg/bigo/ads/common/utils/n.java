package sg.bigo.ads.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import sg.bigo.ads.common.k.a;

public final class n {
    private static long a;
    private static long b;
    private static long c;
    private static long d;

    public static long a() {
        if (System.currentTimeMillis() - b > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            a = e();
            b = System.currentTimeMillis();
        }
        return a;
    }

    public static long a(Context context) {
        ActivityManager.MemoryInfo d2 = d(context);
        if (d2 == null) {
            return 0;
        }
        return e.a(d2.availMem, 3);
    }

    public static <T> Set<T> a(final int i) {
        return Collections.newSetFromMap(new LinkedHashMap<T, Boolean>() {
            /* access modifiers changed from: protected */
            public final boolean removeEldestEntry(Map.Entry<T, Boolean> entry) {
                return size() > i;
            }
        });
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo d2 = d(context);
        if (d2 == null) {
            return 0;
        }
        return e.a(d2.totalMem, 3);
    }

    public static boolean b() {
        return f() > 20971520;
    }

    public static int c(Context context) {
        try {
            return (int) Math.min(15728640, (((long) ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass()) / 8) * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
            return 15728640;
        }
    }

    public static long c() {
        if (System.currentTimeMillis() - d > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            try {
                c = f();
            } catch (Throwable th) {
                a.a(0, "StorageUtils", th.toString());
            }
            d = System.currentTimeMillis();
        }
        return c;
    }

    private static ActivityManager.MemoryInfo d(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public static File d() {
        return new File(Environment.getExternalStorageDirectory(), "Pictures");
    }

    private static long e() {
        long j;
        long j2;
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = statFs.getBlockSizeLong();
                j = statFs.getAvailableBlocksLong();
            } else {
                j2 = (long) statFs.getBlockSize();
                j = (long) statFs.getAvailableBlocks();
            }
            return j2 * j;
        } catch (Throwable th) {
            a.a(0, "StorageUtils", "getExternalStorageRemainSpace" + th.getMessage());
            return 0;
        }
    }

    private static long f() {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j = statFs.getBlockSizeLong();
            j2 = statFs.getAvailableBlocksLong();
        } else {
            j = (long) statFs.getBlockSize();
            j2 = (long) statFs.getAvailableBlocks();
        }
        return j * j2;
    }
}
