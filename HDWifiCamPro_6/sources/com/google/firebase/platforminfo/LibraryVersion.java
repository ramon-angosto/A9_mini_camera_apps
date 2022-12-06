package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
abstract class LibraryVersion {
    @Nonnull
    public abstract String getLibraryName();

    @Nonnull
    public abstract String getVersion();

    LibraryVersion() {
    }

    static LibraryVersion create(String str, String str2) {
        return new AutoValue_LibraryVersion(str, str2);
    }
}
