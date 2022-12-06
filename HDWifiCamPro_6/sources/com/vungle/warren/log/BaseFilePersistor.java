package com.vungle.warren.log;

import android.util.Log;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

class BaseFilePersistor {
    private static final String TAG = BaseFilePersistor.class.getSimpleName();
    protected File fileDir;
    protected String fileNamePrefix;
    protected String fileNameSuffix;
    protected String rootFileDirectory;

    interface FileSaveCallback {
        void onFailure();

        void onSuccess(File file, int i);
    }

    public BaseFilePersistor(File file, String str, String str2, String str3) {
        this.fileNamePrefix = str2;
        this.fileNameSuffix = str3;
        this.rootFileDirectory = str;
        if (file != null) {
            this.fileDir = getOrCreateDirectory(file, str);
        }
    }

    /* access modifiers changed from: protected */
    public File getOrCreateDirectory(File file, String str) {
        File createFileOrDirectory = createFileOrDirectory(file, str, true);
        if (createFileOrDirectory == null || !createFileOrDirectory.exists()) {
            return null;
        }
        return createFileOrDirectory;
    }

    protected static String getDateText(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j));
    }

    /* access modifiers changed from: protected */
    public boolean renameFile(File file, String str) {
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(this.fileDir, str);
        if (file2.exists()) {
            return false;
        }
        return file.renameTo(file2);
    }

    /* access modifiers changed from: protected */
    public File createFileOrDirectory(File file, String str, boolean z) {
        boolean z2;
        File file2 = new File(file, str);
        if (file2.exists()) {
            z2 = true;
        } else if (!z) {
            try {
                z2 = file2.createNewFile();
            } catch (IOException e) {
                String str2 = TAG;
                Log.e(str2, "Can't create new file " + file2.getName(), e);
                z2 = false;
            }
        } else {
            z2 = file2.mkdir();
        }
        if (z2) {
            return file2;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public File[] getFilesWithSuffix(final String str) {
        if (isRootDirInvalid()) {
            return null;
        }
        return this.fileDir.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(str);
            }
        });
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b A[SYNTHETIC, Splitter:B:19:0x002b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean appendLineToFile(java.io.File r5, java.lang.String r6, com.vungle.warren.log.BaseFilePersistor.FileSaveCallback r7) {
        /*
            r4 = this;
            r0 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch:{ IOException -> 0x0029 }
            r2 = 1
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x0029 }
            int r0 = r4.getLineCount(r5)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            if (r0 <= 0) goto L_0x0012
            java.lang.String r3 = "\n"
            r1.append(r3)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
        L_0x0012:
            r1.append(r6)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            r1.flush()     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            com.vungle.warren.utility.FileUtility.closeQuietly(r1)
            if (r7 == 0) goto L_0x0021
            int r0 = r0 + r2
            r7.onSuccess(r5, r0)
        L_0x0021:
            return r2
        L_0x0022:
            r5 = move-exception
            goto L_0x002f
        L_0x0024:
            r0 = r1
            goto L_0x0029
        L_0x0026:
            r5 = move-exception
            r1 = r0
            goto L_0x002f
        L_0x0029:
            if (r7 == 0) goto L_0x0033
            r7.onFailure()     // Catch:{ all -> 0x0026 }
            goto L_0x0033
        L_0x002f:
            com.vungle.warren.utility.FileUtility.closeQuietly(r1)
            throw r5
        L_0x0033:
            r5 = 0
            com.vungle.warren.utility.FileUtility.closeQuietly(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.BaseFilePersistor.appendLineToFile(java.io.File, java.lang.String, com.vungle.warren.log.BaseFilePersistor$FileSaveCallback):boolean");
    }

    /* access modifiers changed from: package-private */
    public File getNewFile(String str) {
        return createFileOrDirectory(this.fileDir, str, false);
    }

    public void sortFilesByNewest(File[] fileArr) {
        Arrays.sort(fileArr, new Comparator<File>() {
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
    }

    /* access modifiers changed from: protected */
    public int getLineCount(File file) {
        if (file == null) {
            return 0;
        }
        LineNumberReader lineNumberReader = null;
        try {
            LineNumberReader lineNumberReader2 = new LineNumberReader(new FileReader(file.getAbsolutePath()));
            while (lineNumberReader2.readLine() != null) {
                try {
                } catch (Exception unused) {
                    lineNumberReader = lineNumberReader2;
                    FileUtility.closeQuietly(lineNumberReader);
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    lineNumberReader = lineNumberReader2;
                    FileUtility.closeQuietly(lineNumberReader);
                    throw th;
                }
            }
            int lineNumber = lineNumberReader2.getLineNumber();
            FileUtility.closeQuietly(lineNumberReader2);
            return lineNumber;
        } catch (Exception unused2) {
            FileUtility.closeQuietly(lineNumberReader);
            return -1;
        } catch (Throwable th2) {
            th = th2;
            FileUtility.closeQuietly(lineNumberReader);
            throw th;
        }
    }

    public boolean isRootDirInvalid() {
        File file = this.fileDir;
        return file == null || !file.exists();
    }

    public void deleteFile(File file) {
        try {
            FileUtility.delete(file);
        } catch (IOException unused) {
            Log.e(TAG, "File failed to delete");
        }
    }
}
