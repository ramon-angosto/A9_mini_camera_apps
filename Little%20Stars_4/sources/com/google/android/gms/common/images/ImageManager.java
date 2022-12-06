package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzpj;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    /* access modifiers changed from: private */
    public static final Object zzapv = new Object();
    /* access modifiers changed from: private */
    public static HashSet<Uri> zzapw = new HashSet<>();
    private static ImageManager zzapx;
    private static ImageManager zzapy;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final zzb zzapA;
    /* access modifiers changed from: private */
    public final zzpj zzapB;
    /* access modifiers changed from: private */
    public final Map<zza, ImageReceiver> zzapC;
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> zzapD;
    /* access modifiers changed from: private */
    public final Map<Uri, Long> zzapE;
    /* access modifiers changed from: private */
    public final ExecutorService zzapz = Executors.newFixedThreadPool(4);

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        /* access modifiers changed from: private */
        public final ArrayList<zza> zzapF = new ArrayList<>();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zzapz.execute(new zzc(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(zza zza) {
            com.google.android.gms.common.internal.zzb.zzdc("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzapF.add(zza);
        }

        public void zzc(zza zza) {
            com.google.android.gms.common.internal.zzb.zzdc("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzapF.remove(zza);
        }

        public void zztb() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends LruCache<zza.C0001zza, Bitmap> {
        public zzb(Context context) {
            super(zzat(context));
        }

        @TargetApi(11)
        private static int zzat(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            return (int) (((float) (((!((context.getApplicationInfo().flags & 1048576) != 0) || !zzs.zzuX()) ? activityManager.getMemoryClass() : zza.zza(activityManager)) * 1048576)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public int sizeOf(zza.C0001zza zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void entryRemoved(boolean z, zza.C0001zza zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, zza, bitmap, bitmap2);
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzapH;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzapH = parcelFileDescriptor;
        }

        public void run() {
            boolean z;
            Bitmap bitmap;
            com.google.android.gms.common.internal.zzb.zzdd("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.zzapH;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.mUri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z2 = true;
                }
                try {
                    this.zzapH.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zzf(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.mUri);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    private final class zzd implements Runnable {
        private final zza zzapI;

        public zzd(zza zza) {
            this.zzapI = zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzdc("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzapC.get(this.zzapI);
            if (imageReceiver != null) {
                ImageManager.this.zzapC.remove(this.zzapI);
                imageReceiver.zzc(this.zzapI);
            }
            zza.C0001zza zza = this.zzapI.zzapK;
            if (zza.uri == null) {
                this.zzapI.zza(ImageManager.this.mContext, ImageManager.this.zzapB, true);
                return;
            }
            Bitmap zza2 = ImageManager.this.zza(zza);
            if (zza2 != null) {
                this.zzapI.zza(ImageManager.this.mContext, zza2, true);
                return;
            }
            Long l = (Long) ImageManager.this.zzapE.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzapI.zza(ImageManager.this.mContext, ImageManager.this.zzapB, true);
                    return;
                }
                ImageManager.this.zzapE.remove(zza.uri);
            }
            this.zzapI.zza(ImageManager.this.mContext, ImageManager.this.zzapB);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zzapD.get(zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zza.uri);
                ImageManager.this.zzapD.put(zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.zzapI);
            if (!(this.zzapI instanceof zza.zzc)) {
                ImageManager.this.zzapC.put(this.zzapI, imageReceiver2);
            }
            synchronized (ImageManager.zzapv) {
                if (!ImageManager.zzapw.contains(zza.uri)) {
                    ImageManager.zzapw.add(zza.uri);
                    imageReceiver2.zztb();
                }
            }
        }
    }

    @TargetApi(14)
    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzapA;

        public zze(zzb zzb) {
            this.zzapA = zzb;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.zzapA.evictAll();
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.zzapA.evictAll();
            } else if (i >= 20) {
                zzb zzb = this.zzapA;
                zzb.trimToSize(zzb.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private boolean zzapJ;
        private final CountDownLatch zzqF;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzapJ = z;
            this.zzqF = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.zzapF;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza zza2 = (zza) zza.get(i);
                if (z) {
                    zza2.zza(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.zzapE.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza2.zza(ImageManager.this.mContext, ImageManager.this.zzapB, false);
                }
                if (!(zza2 instanceof zza.zzc)) {
                    ImageManager.this.zzapC.remove(zza2);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzdc("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zzapA != null) {
                if (this.zzapJ) {
                    ImageManager.this.zzapA.evictAll();
                    System.gc();
                    this.zzapJ = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.zzapA.put(new zza.C0001zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzapD.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzqF.countDown();
            synchronized (ImageManager.zzapv) {
                ImageManager.zzapw.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.zzapA = new zzb(this.mContext);
            if (zzs.zzva()) {
                zzsZ();
            }
        } else {
            this.zzapA = null;
        }
        this.zzapB = new zzpj();
        this.zzapC = new HashMap();
        this.zzapD = new HashMap();
        this.zzapE = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzg(context, false);
    }

    /* access modifiers changed from: private */
    public Bitmap zza(zza.C0001zza zza2) {
        zzb zzb2 = this.zzapA;
        if (zzb2 == null) {
            return null;
        }
        return (Bitmap) zzb2.get(zza2);
    }

    public static ImageManager zzg(Context context, boolean z) {
        if (z) {
            if (zzapy == null) {
                zzapy = new ImageManager(context, true);
            }
            return zzapy;
        }
        if (zzapx == null) {
            zzapx = new ImageManager(context, false);
        }
        return zzapx;
    }

    @TargetApi(14)
    private void zzsZ() {
        this.mContext.registerComponentCallbacks(new zze(this.zzapA));
    }

    public void loadImage(ImageView imageView, int i) {
        zza((zza) new zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza((zza) new zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza.zzb zzb2 = new zza.zzb(imageView, uri);
        zzb2.zzbV(i);
        zza((zza) zzb2);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza((zza) new zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza.zzc zzc2 = new zza.zzc(onImageLoadedListener, uri);
        zzc2.zzbV(i);
        zza((zza) zzc2);
    }

    public void zza(zza zza2) {
        com.google.android.gms.common.internal.zzb.zzdc("ImageManager.loadImage() must be called in the main thread");
        new zzd(zza2).run();
    }
}
