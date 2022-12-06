package com.vungle.warren.log;

import android.util.Log;
import com.vungle.warren.log.BaseFilePersistor;
import com.vungle.warren.log.LogManager;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.UUID;

class LogPersister extends BaseFilePersistor {
    private static final String SDK_CRASH_LOG_FILE_PATTERN = "crash_";
    private static final String SDK_LOGS_DIR = "sdk_logs";
    private static final String SDK_LOG_FILE_CRASH = "_crash";
    private static final String SDK_LOG_FILE_PATTERN = "log_";
    private static final String SDK_LOG_FILE_PENDING = "_pending";
    /* access modifiers changed from: private */
    public static final String TAG = LogPersister.class.getSimpleName();
    /* access modifiers changed from: private */
    public File currentFile;
    /* access modifiers changed from: private */
    public LogManager.SdkLoggingEventListener listener;
    /* access modifiers changed from: private */
    public int maximumEntries = 100;

    LogPersister(File file) {
        super(file, SDK_LOGS_DIR, SDK_LOG_FILE_PATTERN, SDK_LOG_FILE_PENDING);
        if (this.fileDir != null) {
            this.currentFile = getOrCreateLastFile();
        }
    }

    /* access modifiers changed from: package-private */
    public void setSdkLoggingEventListener(LogManager.SdkLoggingEventListener sdkLoggingEventListener) {
        this.listener = sdkLoggingEventListener;
    }

    /* access modifiers changed from: package-private */
    public void setMaximumEntries(int i) {
        this.maximumEntries = i;
    }

    /* access modifiers changed from: package-private */
    public void saveLogData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        saveEntryToFile(this.currentFile, new LogEntry(str, str2, str3, str4, str5, str6, TimeZone.getDefault().getID(), getDateText(System.currentTimeMillis()), str7, str8, str9).toJsonString(), new BaseFilePersistor.FileSaveCallback() {
            public void onSuccess(File file, int i) {
                if (i >= LogPersister.this.maximumEntries) {
                    LogPersister logPersister = LogPersister.this;
                    File access$100 = logPersister.currentFile;
                    if (logPersister.renameFile(access$100, file.getName() + LogPersister.SDK_LOG_FILE_PENDING)) {
                        LogPersister logPersister2 = LogPersister.this;
                        File unused = logPersister2.currentFile = logPersister2.getOrCreateLastFile();
                        if (LogPersister.this.listener != null) {
                            LogPersister.this.listener.sendPendingLogs();
                        }
                    }
                }
            }

            public void onFailure() {
                Log.e(LogPersister.TAG, "Failed to write sdk logs.");
            }
        });
    }

    /* access modifiers changed from: package-private */
    public File[] getPendingFiles() {
        return getFilesWithSuffix(SDK_LOG_FILE_PENDING);
    }

    /* access modifiers changed from: package-private */
    public File[] getCrashReportFiles(int i) {
        File[] filesWithSuffix = getFilesWithSuffix(SDK_LOG_FILE_CRASH);
        if (filesWithSuffix == null || filesWithSuffix.length == 0) {
            return null;
        }
        sortFilesByNewest(filesWithSuffix);
        return (File[]) Arrays.copyOfRange(filesWithSuffix, 0, Math.min(filesWithSuffix.length, i));
    }

    /* access modifiers changed from: protected */
    public boolean saveEntryToFile(File file, String str, BaseFilePersistor.FileSaveCallback fileSaveCallback) {
        if (file == null || !file.exists()) {
            Log.d(TAG, "current log file maybe deleted, create new one.");
            this.currentFile = getOrCreateLastFile();
            file = this.currentFile;
            if (file == null || !file.exists()) {
                Log.w(TAG, "Can't create log file, maybe no space left.");
                return false;
            }
        }
        return appendLineToFile(file, str, fileSaveCallback);
    }

    /* access modifiers changed from: package-private */
    public File getOrCreateLastFile() {
        File file = null;
        if (this.fileDir == null || !this.fileDir.exists()) {
            Log.w(TAG, "No log cache dir found.");
            return null;
        }
        File[] listFiles = this.fileDir.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return !str.endsWith(LogPersister.this.fileNameSuffix);
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            return getNewFile(this.fileNamePrefix + System.currentTimeMillis() + UUID.randomUUID().toString());
        }
        sortFilesByNewest(listFiles);
        File file2 = listFiles[0];
        int lineCount = getLineCount(file2);
        if (lineCount <= 0 || lineCount < this.maximumEntries) {
            return file2;
        }
        try {
            if (renameFile(file2, file2.getName() + this.fileNameSuffix)) {
                file = getOrCreateLastFile();
            }
        } catch (Exception unused) {
        }
        return file == null ? file2 : file;
    }

    public void saveCrashLogData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (this.fileDir == null) {
            Log.w(TAG, "No log cache dir found.");
            return;
        }
        LogEntry logEntry = new LogEntry(str, str2, str3, str4, str5, str6, TimeZone.getDefault().getID(), getDateText(System.currentTimeMillis()), str7, str8, str9);
        final File createFileOrDirectory = createFileOrDirectory(this.fileDir, SDK_CRASH_LOG_FILE_PATTERN + System.currentTimeMillis(), false);
        if (createFileOrDirectory != null) {
            appendLineToFile(createFileOrDirectory, logEntry.toJsonString(), new BaseFilePersistor.FileSaveCallback() {
                public void onSuccess(File file, int i) {
                    LogPersister logPersister = LogPersister.this;
                    File file2 = createFileOrDirectory;
                    logPersister.renameFile(file2, createFileOrDirectory.getName() + LogPersister.SDK_LOG_FILE_CRASH);
                }

                public void onFailure() {
                    Log.e(LogPersister.TAG, "Failed to write crash log.");
                }
            });
        }
    }
}
