package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* renamed from: a */
    public static boolean f1008a = false;

    /* renamed from: b */
    public static ScheduledExecutorService f1009b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: com.huawei.hms.utils.FileUtil$a */
    public static class C0922a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ File f1010a;

        /* renamed from: b */
        public final /* synthetic */ long f1011b;

        /* renamed from: c */
        public final /* synthetic */ String f1012c;

        public C0922a(File file, long j, String str) {
            this.f1010a = file;
            this.f1011b = j;
            this.f1012c = str;
        }

        public void run() {
            File file = this.f1010a;
            if (file == null) {
                HMSLog.m1377e("FileUtil", "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || (!parentFile.mkdirs() && !parentFile.isDirectory())) {
                HMSLog.m1377e("FileUtil", "In writeFile, Failed to create directory.");
                return;
            }
            RandomAccessFile randomAccessFile = null;
            try {
                long length = this.f1010a.length();
                if (length > this.f1011b) {
                    String canonicalPath = this.f1010a.getCanonicalPath();
                    if (!this.f1010a.delete()) {
                        HMSLog.m1377e("FileUtil", "last file delete failed.");
                    }
                    randomAccessFile = new RandomAccessFile(new File(canonicalPath), "rw");
                } else {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.f1010a, "rw");
                    try {
                        randomAccessFile2.seek(length);
                        randomAccessFile = randomAccessFile2;
                    } catch (IOException e) {
                        e = e;
                        randomAccessFile = randomAccessFile2;
                        try {
                            HMSLog.m1378e("FileUtil", "writeFile exception:", (Throwable) e);
                            IOUtils.closeQuietly((Closeable) randomAccessFile);
                        } catch (Throwable th) {
                            th = th;
                            IOUtils.closeQuietly((Closeable) randomAccessFile);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile = randomAccessFile2;
                        IOUtils.closeQuietly((Closeable) randomAccessFile);
                        throw th;
                    }
                }
                randomAccessFile.writeBytes(this.f1012c + System.getProperty("line.separator"));
            } catch (IOException e2) {
                e = e2;
            }
            IOUtils.closeQuietly((Closeable) randomAccessFile);
        }
    }

    public static boolean verifyHash(String str, File file) {
        byte[] digest = SHA256.digest(file);
        if (digest == null || !HEX.encodeHexString(digest, true).equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static void writeFile(File file, String str, long j) {
        f1009b.execute(new C0922a(file, j, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j, int i) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f1008a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.m1377e("FileUtil", "file delete failed.");
                }
                f1008a = true;
            }
            writeFile(file2, str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + j + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i, LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}
