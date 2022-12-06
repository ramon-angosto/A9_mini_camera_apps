package com.vungle.warren.persistence;

import android.util.Log;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;

public class GraphicDesigner implements Designer, CacheManager.Listener {
    private static final String FOLDER_NAME = "vungle";
    private static final String TAG = GraphicDesigner.class.getSimpleName();
    private CacheManager cacheManager;

    public GraphicDesigner(CacheManager cacheManager2) {
        this.cacheManager = cacheManager2;
        this.cacheManager.addListener(this);
        FileUtility.printDirectoryTree(getCacheDirectory());
    }

    public File getAssetDirectory(String str) throws IllegalStateException {
        File file = new File(getCacheDirectory().getPath() + File.separator + str);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public void deleteAssets(String str) throws IOException, IllegalStateException {
        File[] listFiles = getCacheDirectory().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory() && file.getName().equals(str)) {
                    FileUtility.delete(file);
                }
            }
        }
    }

    public File getCacheDirectory() throws IllegalStateException {
        if (this.cacheManager != null) {
            File file = new File(this.cacheManager.getCache() + File.separator + FOLDER_NAME);
            if (!file.exists()) {
                file.mkdir();
            }
            return file;
        }
        throw new IllegalStateException("Context has expired, cannot continue.");
    }

    public void clearCache() {
        CacheManager cacheManager2 = this.cacheManager;
        if (cacheManager2 != null && cacheManager2.getCache() != null) {
            File file = new File(this.cacheManager.getCache().getPath() + File.separator + FOLDER_NAME);
            if (file.exists()) {
                try {
                    FileUtility.delete(file);
                } catch (IOException e) {
                    String str = TAG;
                    Log.e(str, "Failed to delete cached files. Reason: " + e.getLocalizedMessage());
                }
            }
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public void onCacheChanged() {
        CacheManager cacheManager2 = this.cacheManager;
        if (cacheManager2 != null) {
            for (File next : cacheManager2.getOldCaches()) {
                try {
                    FileUtility.delete(new File(next.getPath() + File.separator + FOLDER_NAME));
                } catch (IOException e) {
                    String str = TAG;
                    Log.e(str, "Failed to delete cached files. Reason: " + e.getLocalizedMessage());
                }
            }
        }
    }
}
