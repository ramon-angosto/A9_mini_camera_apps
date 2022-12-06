package com.xiaomi.channel.commonutils.file;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

public class c {
    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e) {
            b.a((Throwable) e);
            return true;
        }
    }

    public static boolean b() {
        try {
            return true ^ Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            b.a((Throwable) e);
            return true;
        }
    }

    public static boolean c() {
        return e() <= OSSConstants.MIN_PART_SIZE_LIMIT;
    }

    public static boolean d() {
        return !b() && !c() && !a();
    }

    public static long e() {
        File externalStorageDirectory;
        if (!b() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }
}
