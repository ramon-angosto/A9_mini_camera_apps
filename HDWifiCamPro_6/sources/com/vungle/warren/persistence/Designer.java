package com.vungle.warren.persistence;

import java.io.File;
import java.io.IOException;

public interface Designer {
    void clearCache();

    void deleteAssets(String str) throws IOException;

    File getAssetDirectory(String str) throws IllegalStateException;

    File getCacheDirectory() throws IllegalStateException;
}
