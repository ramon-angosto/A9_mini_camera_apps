package com.shix.shixipc.gridview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.LruCache;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NativeImageLoader {
    private static final String TAG = NativeImageLoader.class.getSimpleName();
    private static NativeImageLoader mInstance = new NativeImageLoader();
    private static LruCache<String, Bitmap> mMemoryCache;
    private ExecutorService mImageThreadPool = Executors.newFixedThreadPool(1);

    public interface NativeImageCallBack {
        void onImageLoader(Bitmap bitmap, String str);
    }

    private NativeImageLoader() {
        mMemoryCache = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 4) {
            /* access modifiers changed from: protected */
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    public static NativeImageLoader getInstance() {
        return mInstance;
    }

    public Bitmap loadNativeImage(String str, NativeImageCallBack nativeImageCallBack) {
        return loadNativeImage(str, (Point) null, nativeImageCallBack);
    }

    public Bitmap loadNativeImage(final String str, final Point point, final NativeImageCallBack nativeImageCallBack) {
        Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
        final AnonymousClass2 r1 = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                nativeImageCallBack.onImageLoader((Bitmap) message.obj, str);
            }
        };
        if (bitmapFromMemCache == null) {
            this.mImageThreadPool.execute(new Runnable() {
                public void run() {
                    NativeImageLoader nativeImageLoader = NativeImageLoader.this;
                    String str = str;
                    Point point = point;
                    int i = 0;
                    int i2 = point == null ? 0 : point.x;
                    Point point2 = point;
                    if (point2 != null) {
                        i = point2.y;
                    }
                    Bitmap access$000 = nativeImageLoader.decodeThumbBitmapForFile(str, i2, i);
                    Message obtainMessage = r1.obtainMessage();
                    obtainMessage.obj = access$000;
                    r1.sendMessage(obtainMessage);
                    NativeImageLoader.this.addBitmapToMemoryCache(str, access$000);
                }
            });
        }
        return bitmapFromMemCache;
    }

    /* access modifiers changed from: private */
    public void addBitmapToMemoryCache(String str, Bitmap bitmap) {
        if (getBitmapFromMemCache(str) == null && bitmap != null) {
            mMemoryCache.put(str, bitmap);
        }
    }

    private Bitmap getBitmapFromMemCache(String str) {
        Bitmap bitmap = mMemoryCache.get(str);
        if (bitmap != null) {
            String str2 = TAG;
            Log.i(str2, "get image for MemCache , path = " + str);
        }
        return bitmap;
    }

    /* access modifiers changed from: private */
    public Bitmap decodeThumbBitmapForFile(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = computeScale(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private int computeScale(BitmapFactory.Options options, int i, int i2) {
        if (i == 0 || i == 0) {
            return 1;
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 <= i && i4 <= i) {
            return 1;
        }
        float f = (float) i;
        int round = Math.round(((float) i3) / f);
        int round2 = Math.round(((float) i4) / f);
        return round < round2 ? round : round2;
    }
}
