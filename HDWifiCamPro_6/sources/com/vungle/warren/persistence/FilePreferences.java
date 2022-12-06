package com.vungle.warren.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.utility.CollectionsConcurrencyUtil;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class FilePreferences {
    static final String FILENAME = "vungle_settings";
    static final String OLD_SHARED_PREFS = "com.vungle.sdk";
    /* access modifiers changed from: private */
    public final File file;
    private final Executor ioExecutor;
    private final SharedPreferences preferences;
    private final HashSet<String> sharedPrefValues = new HashSet<>();
    private final ConcurrentHashMap<String, Object> values = new ConcurrentHashMap<>();

    public FilePreferences(Context context, Executor executor) {
        this.ioExecutor = executor;
        this.file = new File(context.getNoBackupFilesDir(), FILENAME);
        File file2 = new File(context.getFilesDir(), FILENAME);
        if (file2.exists() && !file2.renameTo(this.file)) {
            VungleLogger.error("FilePreferences", "Can't move old FilePreferences");
        }
        Object readSerializable = FileUtility.readSerializable(this.file);
        if (readSerializable instanceof HashMap) {
            this.values.putAll((HashMap) readSerializable);
        }
        this.preferences = context.getSharedPreferences(OLD_SHARED_PREFS, 0);
        migrateFromSharedPrefs();
    }

    public void apply() {
        final HashMap hashMap = new HashMap(this.values);
        this.ioExecutor.execute(new Runnable() {
            public void run() {
                FileUtility.writeSerializable(FilePreferences.this.file, hashMap);
            }
        });
    }

    public FilePreferences addSharedPrefsKey(String... strArr) {
        this.sharedPrefValues.addAll(Arrays.asList(strArr));
        return this;
    }

    private void migrateFromSharedPrefs() {
        for (Map.Entry next : this.preferences.getAll().entrySet()) {
            Object value = next.getValue();
            if (value instanceof Boolean) {
                put((String) next.getKey(), ((Boolean) value).booleanValue());
            } else if (value instanceof String) {
                put((String) next.getKey(), (String) value);
            } else if (value instanceof Integer) {
                put((String) next.getKey(), ((Integer) value).intValue());
            } else if (value instanceof HashSet) {
                put((String) next.getKey(), (HashSet<String>) (HashSet) value);
            }
        }
        this.preferences.edit().clear().apply();
        apply();
    }

    public FilePreferences put(String str, boolean z) {
        this.values.put(str, Boolean.valueOf(z));
        if (this.sharedPrefValues.contains(str)) {
            this.preferences.edit().putBoolean(str, z).apply();
        }
        return this;
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = this.values.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public FilePreferences put(String str, String str2) {
        this.values.put(str, str2);
        if (this.sharedPrefValues.contains(str)) {
            this.preferences.edit().putString(str, str2).apply();
        }
        return this;
    }

    public String getString(String str, String str2) {
        Object obj = this.values.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public FilePreferences put(String str, int i) {
        this.values.put(str, Integer.valueOf(i));
        if (this.sharedPrefValues.contains(str)) {
            this.preferences.edit().putInt(str, i).apply();
        }
        return this;
    }

    public int getInt(String str, int i) {
        Object obj = this.values.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i;
    }

    public FilePreferences put(String str, HashSet<String> hashSet) {
        this.values.put(str, CollectionsConcurrencyUtil.getNewHashSet(hashSet));
        if (this.sharedPrefValues.contains(str)) {
            this.preferences.edit().putStringSet(str, CollectionsConcurrencyUtil.getNewHashSet(hashSet)).apply();
        }
        return this;
    }

    public HashSet<String> getStringSet(String str, HashSet<String> hashSet) {
        Object obj = this.values.get(str);
        return obj instanceof HashSet ? CollectionsConcurrencyUtil.getNewHashSet((HashSet) obj) : hashSet;
    }
}
