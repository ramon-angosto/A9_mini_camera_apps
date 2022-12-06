package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

class OriginalKey implements Key {

    /* renamed from: id */
    private final String f57id;
    private final Key signature;

    public OriginalKey(String str, Key key) {
        this.f57id = str;
        this.signature = key;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OriginalKey originalKey = (OriginalKey) obj;
        return this.f57id.equals(originalKey.f57id) && this.signature.equals(originalKey.signature);
    }

    public int hashCode() {
        return (this.f57id.hashCode() * 31) + this.signature.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f57id.getBytes(Key.STRING_CHARSET_NAME));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
