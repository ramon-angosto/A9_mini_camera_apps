package com.alibaba.sdk.android.oss.common;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OSSLogToFileUtils {
    private static final String LOG_DIR_NAME = "OSSLog";
    /* access modifiers changed from: private */
    public static long LOG_MAX_SIZE = 5242880;
    /* access modifiers changed from: private */
    public static OSSLogToFileUtils instance;
    private static LogThreadPoolManager logService = LogThreadPoolManager.newInstance();
    private static Context sContext;
    /* access modifiers changed from: private */
    public static File sLogFile;
    /* access modifiers changed from: private */
    public static SimpleDateFormat sLogSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Uri sLogUri;
    private boolean useSdCard = true;

    private OSSLogToFileUtils() {
    }

    public static void init(Context context, ClientConfiguration clientConfiguration) {
        File file;
        OSSLog.logDebug("init ...", false);
        if (clientConfiguration != null) {
            LOG_MAX_SIZE = clientConfiguration.getMaxLogSize();
        }
        if (sContext == null || instance == null || (file = sLogFile) == null || !file.exists()) {
            sContext = context.getApplicationContext();
            instance = getInstance();
            logService.addExecuteTask(new Runnable() {
                public void run() {
                    File unused = OSSLogToFileUtils.sLogFile = OSSLogToFileUtils.instance.getLogFile();
                    if (OSSLogToFileUtils.sLogFile != null) {
                        OSSLog.logInfo("LogFilePath is: " + OSSLogToFileUtils.sLogFile.getPath(), false);
                        if (OSSLogToFileUtils.LOG_MAX_SIZE < OSSLogToFileUtils.getLogFileSize(OSSLogToFileUtils.sLogFile)) {
                            OSSLog.logInfo("init reset log file", false);
                            OSSLogToFileUtils.instance.resetLogFile();
                        }
                    }
                }
            });
            return;
        }
        OSSLog.logDebug("LogToFileUtils has been init ...", false);
    }

    public static OSSLogToFileUtils getInstance() {
        if (instance == null) {
            synchronized (OSSLogToFileUtils.class) {
                if (instance == null) {
                    instance = new OSSLogToFileUtils();
                }
            }
        }
        return instance;
    }

    public static void reset() {
        sContext = null;
        instance = null;
        sLogFile = null;
    }

    public static long getLogFileSize(File file) {
        if (file == null || !file.exists()) {
            return 0;
        }
        return file.length();
    }

    public static long getLocalLogFileSize() {
        return getLogFileSize(sLogFile);
    }

    private long readSDCardSpace() {
        long j;
        long j2 = 0;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockSize = (long) statFs.getBlockSize();
                if (Build.VERSION.SDK_INT >= 18) {
                    j = statFs.getAvailableBlocksLong();
                } else {
                    j = (long) statFs.getAvailableBlocks();
                }
                j2 = j * blockSize;
            } catch (Exception unused) {
            }
        }
        OSSLog.logDebug("sd卡存储空间:" + String.valueOf(j2) + "kb", false);
        return j2;
    }

    private long readSystemSpace() {
        long j;
        long j2;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = statFs.getAvailableBlocksLong();
            } else {
                j2 = (long) statFs.getAvailableBlocks();
            }
            j = (j2 * blockSize) / 1024;
        } catch (Exception unused) {
            j = 0;
        }
        OSSLog.logDebug("内部存储空间:" + String.valueOf(j) + "kb", false);
        return j;
    }

    public void setUseSdCard(boolean z) {
        this.useSdCard = z;
    }

    public void resetLogFile() {
        OSSLog.logDebug("Reset Log File ... ", false);
        if (!sLogFile.getParentFile().exists()) {
            OSSLog.logDebug("Reset Log make File dir ... ", false);
            sLogFile.getParentFile().mkdir();
        }
        File file = new File(sLogFile.getParent() + "/logs.csv");
        if (file.exists()) {
            file.delete();
        }
        createNewFile(file);
    }

    public void deleteLogFile() {
        File file = new File(sLogFile.getParent() + "/logs.csv");
        if (file.exists()) {
            OSSLog.logDebug("delete Log File ... ", false);
            file.delete();
        }
    }

    public void deleteLogFileDir() {
        deleteLogFile();
        File file = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + LOG_DIR_NAME);
        if (file.exists()) {
            OSSLog.logDebug("delete Log FileDir ... ", false);
            file.delete();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File getLogFile() {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            boolean r2 = r11.useSdCard     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "OSSLog"
            r4 = 1
            r5 = 1024(0x400, double:5.06E-321)
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x007e }
            java.lang.String r7 = "mounted"
            boolean r2 = r2.equals(r7)     // Catch:{ Exception -> 0x007e }
            if (r2 == 0) goto L_0x004c
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x007e }
            r7 = 29
            if (r2 >= r7) goto L_0x004c
            long r7 = r11.readSDCardSpace()     // Catch:{ Exception -> 0x007e }
            long r9 = LOG_MAX_SIZE     // Catch:{ Exception -> 0x007e }
            long r9 = r9 / r5
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r4 = r1
        L_0x002a:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x007e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007e }
            r5.<init>()     // Catch:{ Exception -> 0x007e }
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x007e }
            r5.append(r6)     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x007e }
            r5.append(r6)     // Catch:{ Exception -> 0x007e }
            r5.append(r3)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x007e }
            r2.<init>(r3)     // Catch:{ Exception -> 0x007e }
            goto L_0x007c
        L_0x004c:
            long r7 = r11.readSystemSpace()     // Catch:{ Exception -> 0x007e }
            long r9 = LOG_MAX_SIZE     // Catch:{ Exception -> 0x007e }
            long r9 = r9 / r5
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r4 = r1
        L_0x0059:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x007e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007e }
            r5.<init>()     // Catch:{ Exception -> 0x007e }
            android.content.Context r6 = sContext     // Catch:{ Exception -> 0x007e }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x007e }
            r5.append(r6)     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x007e }
            r5.append(r6)     // Catch:{ Exception -> 0x007e }
            r5.append(r3)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x007e }
            r2.<init>(r3)     // Catch:{ Exception -> 0x007e }
        L_0x007c:
            r1 = r4
            goto L_0x007f
        L_0x007e:
            r2 = r0
        L_0x007f:
            if (r1 == 0) goto L_0x00ad
            boolean r0 = r2.exists()
            if (r0 != 0) goto L_0x008a
            r2.mkdirs()
        L_0x008a:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r2.getPath()
            r1.append(r2)
            java.lang.String r2 = "/logs.csv"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x00ad
            r11.createNewFile(r0)
        L_0x00ad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.getLogFile():java.io.File");
    }

    private Uri getLogUri() {
        ContentResolver contentResolver = sContext.getContentResolver();
        Uri queryLogUri = queryLogUri();
        if (queryLogUri == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", "logs.csv");
            contentValues.put("mime_type", "file/csv");
            contentValues.put(CampaignEx.JSON_KEY_TITLE, "logs.csv");
            contentValues.put("relative_path", "Documents/OSSLog");
            queryLogUri = contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues);
            try {
                contentResolver.openFileDescriptor(queryLogUri, "w");
            } catch (Exception unused) {
                return null;
            }
        }
        return queryLogUri;
    }

    private Uri queryLogUri() {
        ContentResolver contentResolver = sContext.getContentResolver();
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Uri uri = contentUri;
        Cursor query = contentResolver.query(uri, new String[]{"_id"}, "relative_path like ? AND _display_name=?", new String[]{"Documents/OSSLog%", "logs.csv"}, (String) null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        Uri withAppendedId = ContentUris.withAppendedId(contentUri, query.getLong(0));
        query.close();
        return withAppendedId;
    }

    public void createNewFile(File file) {
        try {
            file.createNewFile();
        } catch (Exception e) {
            OSSLog.logError("Create log file failure !!! " + e.toString(), false);
        }
    }

    /* access modifiers changed from: private */
    public String getFunctionInfo(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            return null;
        }
        return "[" + sLogSDF.format(new Date()) + "]";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void write(java.lang.Object r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002c
            android.content.Context r0 = sContext     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002a
            com.alibaba.sdk.android.oss.common.OSSLogToFileUtils r0 = instance     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002a
            java.io.File r0 = sLogFile     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0014
            goto L_0x002a
        L_0x0014:
            java.io.File r0 = sLogFile     // Catch:{ all -> 0x002e }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x001f
            r1.resetLogFile()     // Catch:{ all -> 0x002e }
        L_0x001f:
            com.alibaba.sdk.android.oss.common.OSSLogToFileUtils$WriteCall r0 = new com.alibaba.sdk.android.oss.common.OSSLogToFileUtils$WriteCall     // Catch:{ all -> 0x002e }
            r0.<init>(r2)     // Catch:{ all -> 0x002e }
            com.alibaba.sdk.android.oss.common.LogThreadPoolManager r2 = logService     // Catch:{ all -> 0x002e }
            r2.addExecuteTask(r0)     // Catch:{ all -> 0x002e }
            goto L_0x002c
        L_0x002a:
            monitor-exit(r1)
            return
        L_0x002c:
            monitor-exit(r1)
            return
        L_0x002e:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.write(java.lang.Object):void");
    }

    private static class WriteCall implements Runnable {
        private Object mStr;

        public WriteCall(Object obj) {
            this.mStr = obj;
        }

        public void run() {
            if (OSSLogToFileUtils.sLogFile != null) {
                OSSLogToFileUtils.getInstance();
                if (OSSLogToFileUtils.getLogFileSize(OSSLogToFileUtils.sLogFile) > OSSLogToFileUtils.LOG_MAX_SIZE) {
                    OSSLogToFileUtils.getInstance().resetLogFile();
                }
                try {
                    PrintWriter printWriter = new PrintWriter(new FileWriter(OSSLogToFileUtils.sLogFile, true), true);
                    if (this.mStr instanceof Throwable) {
                        printEx(printWriter);
                    } else {
                        printWriter.println(OSSLogToFileUtils.getInstance().getFunctionInfo((StackTraceElement[]) null) + " - " + this.mStr.toString());
                    }
                    printWriter.println("------>end of log");
                    printWriter.println();
                    printWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private PrintWriter printEx(PrintWriter printWriter) {
            printWriter.println("crash_time：" + OSSLogToFileUtils.sLogSDF.format(new Date()));
            ((Throwable) this.mStr).printStackTrace(printWriter);
            return printWriter;
        }
    }
}
