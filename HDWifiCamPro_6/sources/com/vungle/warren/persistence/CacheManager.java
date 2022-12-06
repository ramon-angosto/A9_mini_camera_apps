package com.vungle.warren.persistence;

import android.content.Context;
import android.os.FileObserver;
import android.os.StatFs;
import android.util.Log;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CacheManager {
    private static final String PATH_ID = "cache_path";
    private static final String PATH_IDS = "cache_paths";
    private static final String TAG = CacheManager.class.getSimpleName();
    static final long UNKNOWN_SIZE = -1;
    private static final String VUNGLE_DIR = "vungle_cache";
    private boolean changed;
    private final Context context;
    private File current;
    private final Set<Listener> listeners = new HashSet();
    private final List<FileObserver> observers = new ArrayList();
    private final List<File> old = new ArrayList();
    private final FilePreferences prefs;

    public interface Listener {
        void onCacheChanged();
    }

    public CacheManager(Context context2, FilePreferences filePreferences) {
        this.context = context2;
        this.prefs = filePreferences;
        this.prefs.addSharedPrefsKey(PATH_ID, PATH_IDS).apply();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:67|68|69|70|91) */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0140, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0156 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void selectFileDest() {
        /*
            r10 = this;
            monitor-enter(r10)
            java.io.File r0 = r10.current     // Catch:{ all -> 0x0178 }
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.vungle.warren.persistence.FilePreferences r0 = r10.prefs     // Catch:{ all -> 0x0178 }
            java.lang.String r2 = "cache_path"
            java.lang.String r0 = r0.getString(r2, r1)     // Catch:{ all -> 0x0178 }
            if (r0 == 0) goto L_0x0016
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0178 }
            r2.<init>(r0)     // Catch:{ all -> 0x0178 }
            goto L_0x0017
        L_0x0016:
            r2 = r1
        L_0x0017:
            r10.current = r2     // Catch:{ all -> 0x0178 }
        L_0x0019:
            android.content.Context r0 = r10.context     // Catch:{ all -> 0x0178 }
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch:{ all -> 0x0178 }
            android.content.Context r2 = r10.context     // Catch:{ all -> 0x0178 }
            java.io.File r2 = r2.getFilesDir()     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch:{ all -> 0x0178 }
            java.lang.String r4 = "mounted"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0178 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0037
            if (r0 == 0) goto L_0x0037
            r3 = r5
            goto L_0x0038
        L_0x0037:
            r3 = r4
        L_0x0038:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0178 }
            r6.<init>()     // Catch:{ all -> 0x0178 }
            if (r3 == 0) goto L_0x004f
            java.io.File r7 = r0.getParentFile()     // Catch:{ all -> 0x0178 }
            if (r7 == 0) goto L_0x004f
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0178 }
            java.lang.String r9 = "no_backup"
            r8.<init>(r7, r9)     // Catch:{ all -> 0x0178 }
            r6.add(r8)     // Catch:{ all -> 0x0178 }
        L_0x004f:
            android.content.Context r7 = r10.context     // Catch:{ all -> 0x0178 }
            java.io.File r7 = r7.getNoBackupFilesDir()     // Catch:{ all -> 0x0178 }
            r6.add(r7)     // Catch:{ all -> 0x0178 }
            if (r3 == 0) goto L_0x005d
            r6.add(r0)     // Catch:{ all -> 0x0178 }
        L_0x005d:
            r6.add(r2)     // Catch:{ all -> 0x0178 }
            java.util.Iterator r2 = r6.iterator()     // Catch:{ all -> 0x0178 }
            r3 = r4
        L_0x0065:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x0099
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x0178 }
            java.io.File r6 = (java.io.File) r6     // Catch:{ all -> 0x0178 }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x0178 }
            java.lang.String r8 = "vungle_cache"
            r7.<init>(r6, r8)     // Catch:{ all -> 0x0178 }
            deleteIfFile(r7)     // Catch:{ all -> 0x0178 }
            boolean r6 = r7.exists()     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x0091
            boolean r6 = r7.isDirectory()     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x008f
            boolean r6 = r7.canWrite()     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x008f
            r6 = r5
            goto L_0x0096
        L_0x008f:
            r6 = r4
            goto L_0x0096
        L_0x0091:
            boolean r6 = r7.mkdirs()     // Catch:{ all -> 0x0178 }
            r3 = r6
        L_0x0096:
            if (r6 == 0) goto L_0x0065
            r1 = r7
        L_0x0099:
            android.content.Context r2 = r10.context     // Catch:{ all -> 0x0178 }
            java.io.File r2 = r2.getCacheDir()     // Catch:{ all -> 0x0178 }
            com.vungle.warren.persistence.FilePreferences r4 = r10.prefs     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = "cache_paths"
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ all -> 0x0178 }
            r7.<init>()     // Catch:{ all -> 0x0178 }
            java.util.HashSet r4 = r4.getStringSet(r6, r7)     // Catch:{ all -> 0x0178 }
            if (r1 == 0) goto L_0x00b5
            java.lang.String r6 = r1.getPath()     // Catch:{ all -> 0x0178 }
            com.vungle.warren.utility.CollectionsConcurrencyUtil.addToSet(r4, r6)     // Catch:{ all -> 0x0178 }
        L_0x00b5:
            java.lang.String r6 = r2.getPath()     // Catch:{ all -> 0x0178 }
            com.vungle.warren.utility.CollectionsConcurrencyUtil.addToSet(r4, r6)     // Catch:{ all -> 0x0178 }
            com.vungle.warren.persistence.FilePreferences r6 = r10.prefs     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = "cache_paths"
            com.vungle.warren.persistence.FilePreferences r6 = r6.put((java.lang.String) r7, (java.util.HashSet<java.lang.String>) r4)     // Catch:{ all -> 0x0178 }
            r6.apply()     // Catch:{ all -> 0x0178 }
            java.util.List<java.io.File> r6 = r10.old     // Catch:{ all -> 0x0178 }
            r6.clear()     // Catch:{ all -> 0x0178 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0178 }
        L_0x00d0:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x00f3
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0178 }
            if (r1 == 0) goto L_0x00e8
            java.lang.String r7 = r1.getPath()     // Catch:{ all -> 0x0178 }
            boolean r7 = r7.equals(r6)     // Catch:{ all -> 0x0178 }
            if (r7 != 0) goto L_0x00d0
        L_0x00e8:
            java.util.List<java.io.File> r7 = r10.old     // Catch:{ all -> 0x0178 }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0178 }
            r8.<init>(r6)     // Catch:{ all -> 0x0178 }
            r7.add(r8)     // Catch:{ all -> 0x0178 }
            goto L_0x00d0
        L_0x00f3:
            if (r3 != 0) goto L_0x010b
            if (r1 == 0) goto L_0x00ff
            java.io.File r3 = r10.current     // Catch:{ all -> 0x0178 }
            boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x0178 }
            if (r3 == 0) goto L_0x010b
        L_0x00ff:
            java.io.File r3 = r10.current     // Catch:{ all -> 0x0178 }
            if (r3 == 0) goto L_0x0173
            java.io.File r3 = r10.current     // Catch:{ all -> 0x0178 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0178 }
            if (r3 != 0) goto L_0x0173
        L_0x010b:
            r10.current = r1     // Catch:{ all -> 0x0178 }
            java.io.File r1 = r10.current     // Catch:{ all -> 0x0178 }
            if (r1 == 0) goto L_0x0122
            com.vungle.warren.persistence.FilePreferences r1 = r10.prefs     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = "cache_path"
            java.io.File r4 = r10.current     // Catch:{ all -> 0x0178 }
            java.lang.String r4 = r4.getPath()     // Catch:{ all -> 0x0178 }
            com.vungle.warren.persistence.FilePreferences r1 = r1.put((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0178 }
            r1.apply()     // Catch:{ all -> 0x0178 }
        L_0x0122:
            java.util.Set<com.vungle.warren.persistence.CacheManager$Listener> r1 = r10.listeners     // Catch:{ all -> 0x0178 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0178 }
        L_0x0128:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0178 }
            if (r3 == 0) goto L_0x0138
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0178 }
            com.vungle.warren.persistence.CacheManager$Listener r3 = (com.vungle.warren.persistence.CacheManager.Listener) r3     // Catch:{ all -> 0x0178 }
            r3.onCacheChanged()     // Catch:{ all -> 0x0178 }
            goto L_0x0128
        L_0x0138:
            r10.changed = r5     // Catch:{ all -> 0x0178 }
            java.util.List<java.io.File> r1 = r10.old     // Catch:{ all -> 0x0178 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0178 }
        L_0x0140:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0178 }
            if (r3 == 0) goto L_0x0173
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0178 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x0178 }
            boolean r4 = r3.equals(r2)     // Catch:{ all -> 0x0178 }
            if (r4 != 0) goto L_0x0140
            com.vungle.warren.utility.FileUtility.delete(r3)     // Catch:{ IOException -> 0x0156 }
            goto L_0x0140
        L_0x0156:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = "CacheManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0178 }
            r7.<init>()     // Catch:{ all -> 0x0178 }
            java.lang.String r8 = "Can't remove old cache:"
            r7.append(r8)     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = r3.getPath()     // Catch:{ all -> 0x0178 }
            r7.append(r3)     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0178 }
            com.vungle.warren.VungleLogger.error(r5, r4, r6, r3)     // Catch:{ all -> 0x0178 }
            goto L_0x0140
        L_0x0173:
            r10.observeDirectory(r0)     // Catch:{ all -> 0x0178 }
            monitor-exit(r10)
            return
        L_0x0178:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.persistence.CacheManager.selectFileDest():void");
    }

    private void check() {
        File file = this.current;
        if (file == null || !file.exists() || !this.current.isDirectory() || !this.current.canWrite()) {
            selectFileDest();
        }
    }

    private synchronized void observeDirectory(File file) {
        if (file != null) {
            this.observers.clear();
            this.observers.add(new FileObserver(file.getPath(), 1024) {
                public void onEvent(int i, String str) {
                    stopWatching();
                    CacheManager.this.selectFileDest();
                }
            });
            while (file.getParent() != null) {
                final String name = file.getName();
                this.observers.add(new FileObserver(file.getParent(), 256) {
                    public void onEvent(int i, String str) {
                        stopWatching();
                        if (name.equals(str)) {
                            CacheManager.this.selectFileDest();
                        }
                    }
                });
                file = file.getParentFile();
            }
            for (FileObserver startWatching : this.observers) {
                try {
                    startWatching.startWatching();
                } catch (Exception e) {
                    VungleLogger.warn(true, TAG, "ExceptionContext", Log.getStackTraceString(e));
                }
            }
        }
    }

    public synchronized File getCache() {
        check();
        return this.current;
    }

    public synchronized List<File> getOldCaches() {
        check();
        return this.old;
    }

    public synchronized void addListener(Listener listener) {
        check();
        this.listeners.add(listener);
        if (this.changed) {
            listener.onCacheChanged();
        }
    }

    public synchronized void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public long getBytesAvailable() {
        return getBytesAvailable(1);
    }

    private long getBytesAvailable(int i) {
        File cache = getCache();
        if (cache == null) {
            return -1;
        }
        StatFs statFs = null;
        try {
            statFs = new StatFs(cache.getPath());
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Failed to get available bytes", e);
            if (i > 0) {
                return getBytesAvailable(i - 1);
            }
        }
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        }
        return -1;
    }

    private static void deleteIfFile(File file) {
        if (file.exists() && file.isFile()) {
            FileUtility.deleteAndLogIfFailed(file);
        }
    }
}
