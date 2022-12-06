package com.vungle.warren.downloader;

import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class LRUCachePolicy implements CachePolicy<File> {
    static final String CACHE_POLICY_JOURNAL = "cache_policy_journal";
    private final CacheManager cacheManager;
    private final String dirName;
    private LinkedHashSet<File> files = new LinkedHashSet<>();

    public LRUCachePolicy(CacheManager cacheManager2, String str) {
        this.cacheManager = cacheManager2;
        this.dirName = str;
    }

    public void put(File file, long j) {
        if (j > 0) {
            this.files.remove(file);
        }
        this.files.add(file);
    }

    public List<File> getOrderedCacheItems() {
        return new ArrayList(this.files);
    }

    public void remove(File file) {
        this.files.remove(file);
    }

    public void clean() {
        this.files.clear();
    }

    public void save() {
        FileUtility.writeSerializable(getPolicyFile(), this.files);
    }

    private File getPolicyFile() {
        File file = new File(this.cacheManager.getCache(), this.dirName);
        if (file.exists() && !file.isDirectory()) {
            FileUtility.deleteAndLogIfFailed(file);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, CACHE_POLICY_JOURNAL);
    }

    public void load() {
        File policyFile = getPolicyFile();
        Serializable serializable = (Serializable) FileUtility.readSerializable(policyFile);
        if (serializable != null) {
            if (serializable instanceof Collection) {
                this.files.addAll((Collection) serializable);
            } else {
                FileUtility.deleteAndLogIfFailed(policyFile);
            }
        }
    }
}
