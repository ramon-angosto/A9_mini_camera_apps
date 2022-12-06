package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WorkDatabasePathHelper {
    private static final String[] DATABASE_EXTRA_FILES = {"-journal", "-shm", "-wal"};
    private static final String TAG = Logger.tagWithPrefix("WrkDbPathHelper");
    private static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    public static String getWorkDatabaseName() {
        return WORK_DATABASE_NAME;
    }

    private WorkDatabasePathHelper() {
    }

    public static void migrateDatabase(Context context) {
        String str;
        File defaultDatabasePath = getDefaultDatabasePath(context);
        if (Build.VERSION.SDK_INT >= 23 && defaultDatabasePath.exists()) {
            Logger.get().debug(TAG, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            Map<File, File> migrationPaths = migrationPaths(context);
            for (File next : migrationPaths.keySet()) {
                File file = migrationPaths.get(next);
                if (next.exists() && file != null) {
                    if (file.exists()) {
                        Logger.get().warning(TAG, String.format("Over-writing contents of %s", new Object[]{file}), new Throwable[0]);
                    }
                    if (next.renameTo(file)) {
                        str = String.format("Migrated %s to %s", new Object[]{next, file});
                    } else {
                        str = String.format("Renaming %s to %s failed", new Object[]{next, file});
                    }
                    Logger.get().debug(TAG, str, new Throwable[0]);
                }
            }
        }
    }

    public static Map<File, File> migrationPaths(Context context) {
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File defaultDatabasePath = getDefaultDatabasePath(context);
            File databasePath = getDatabasePath(context);
            hashMap.put(defaultDatabasePath, databasePath);
            for (String str : DATABASE_EXTRA_FILES) {
                hashMap.put(new File(defaultDatabasePath.getPath() + str), new File(databasePath.getPath() + str));
            }
        }
        return hashMap;
    }

    public static File getDefaultDatabasePath(Context context) {
        return context.getDatabasePath(WORK_DATABASE_NAME);
    }

    public static File getDatabasePath(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return getDefaultDatabasePath(context);
        }
        return getNoBackupPath(context, WORK_DATABASE_NAME);
    }

    private static File getNoBackupPath(Context context, String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }
}
