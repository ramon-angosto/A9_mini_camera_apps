package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

/* renamed from: com.xiaomi.push.ab */
final class C1609ab implements FileFilter {
    C1609ab() {
    }

    public boolean accept(File file) {
        return file.isDirectory();
    }
}
