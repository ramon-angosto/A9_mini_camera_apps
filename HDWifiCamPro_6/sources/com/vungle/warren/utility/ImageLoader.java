package com.vungle.warren.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.vungle.warren.model.Advertisement;
import java.util.concurrent.Executor;

public class ImageLoader {
    /* access modifiers changed from: private */
    public static final String TAG = ImageLoader.class.getSimpleName();
    private static final ImageLoader sInstance = new ImageLoader();
    private Executor ioExecutor;
    /* access modifiers changed from: private */
    public final LruCache<String, Bitmap> lruCache;

    public interface ImageLoaderListener {
        void onImageLoaded(Bitmap bitmap);
    }

    private ImageLoader() {
        this.lruCache = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8) {
            /* access modifiers changed from: protected */
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    ImageLoader(LruCache<String, Bitmap> lruCache2) {
        this.lruCache = lruCache2;
    }

    public static ImageLoader getInstance() {
        return sInstance;
    }

    public void init(Executor executor) {
        this.ioExecutor = executor;
    }

    public void displayImage(final String str, final ImageLoaderListener imageLoaderListener) {
        if (this.ioExecutor == null) {
            Log.w(TAG, "ImageLoader not initialized.");
        } else if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "the uri is required.");
        } else {
            this.ioExecutor.execute(new Runnable() {
                public void run() {
                    if (str.startsWith(Advertisement.FILE_SCHEME)) {
                        Bitmap bitmap = (Bitmap) ImageLoader.this.lruCache.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            Bitmap decodeFile = BitmapFactory.decodeFile(str.substring(7));
                            if (decodeFile != null) {
                                ImageLoader.this.lruCache.put(str, decodeFile);
                                ImageLoaderListener imageLoaderListener = imageLoaderListener;
                                if (imageLoaderListener != null) {
                                    imageLoaderListener.onImageLoaded(decodeFile);
                                    return;
                                }
                                return;
                            }
                            Log.w(ImageLoader.TAG, "decode bitmap failed.");
                            return;
                        }
                        ImageLoaderListener imageLoaderListener2 = imageLoaderListener;
                        if (imageLoaderListener2 != null) {
                            imageLoaderListener2.onImageLoaded(bitmap);
                        }
                    }
                }
            });
        }
    }
}
