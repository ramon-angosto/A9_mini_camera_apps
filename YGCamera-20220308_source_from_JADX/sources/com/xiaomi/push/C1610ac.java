package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.io.File;

/* renamed from: com.xiaomi.push.ac */
public class C1610ac {
    /* renamed from: a */
    public static long m2499a() {
        File externalStorageDirectory;
        if (!m2501b() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static boolean m2500a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m2501b() {
        try {
            return true ^ Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            Log.e("XMPush-", "check SDCard is busy: " + e);
            return true;
        }
    }

    /* renamed from: c */
    public static boolean m2502c() {
        return m2499a() <= OSSConstants.MIN_PART_SIZE_LIMIT;
    }

    /* renamed from: d */
    public static boolean m2503d() {
        return !m2501b() && !m2502c() && !m2499a();
    }
}
