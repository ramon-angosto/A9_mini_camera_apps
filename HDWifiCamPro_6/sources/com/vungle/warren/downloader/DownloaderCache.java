package com.vungle.warren.downloader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DownloaderCache {
    void clear();

    boolean deleteAndRemove(File file);

    boolean deleteContents(File file);

    long getCacheUpdateTimestamp(File file);

    File getFile(String str) throws IOException;

    File getMetaFile(File file);

    void init();

    void onCacheHit(File file, long j);

    List<File> purge();

    void setCacheLastUpdateTimestamp(File file, long j);

    void startTracking(File file);

    void stopTracking(File file);
}
