package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.data.ByteArrayFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import java.io.InputStream;

public class StreamByteArrayLoader implements StreamModelLoader<byte[]> {

    /* renamed from: id */
    private final String f59id;

    public StreamByteArrayLoader() {
        this("");
    }

    @Deprecated
    public StreamByteArrayLoader(String str) {
        this.f59id = str;
    }

    public DataFetcher<InputStream> getResourceFetcher(byte[] bArr, int i, int i2) {
        return new ByteArrayFetcher(bArr, this.f59id);
    }

    public static class Factory implements ModelLoaderFactory<byte[], InputStream> {
        public void teardown() {
        }

        public ModelLoader<byte[], InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamByteArrayLoader();
        }
    }
}
