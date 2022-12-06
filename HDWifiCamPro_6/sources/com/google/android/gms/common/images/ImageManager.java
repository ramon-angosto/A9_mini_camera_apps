package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zaq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class ImageManager {
    /* access modifiers changed from: private */
    public static final Object zaa = new Object();
    /* access modifiers changed from: private */
    public static HashSet<Uri> zab = new HashSet<>();
    private static ImageManager zac;
    /* access modifiers changed from: private */
    public final Context zad;
    /* access modifiers changed from: private */
    public final Handler zae = new zaq(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final ExecutorService zaf = zap.zaa().zab(4, 2);
    /* access modifiers changed from: private */
    public final zak zag = new zak();
    /* access modifiers changed from: private */
    public final Map<zag, ImageReceiver> zah = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> zai = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Uri, Long> zaj = new HashMap();

    /* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
    private final class ImageReceiver extends ResultReceiver {
        private final Uri zab;
        /* access modifiers changed from: private */
        public final ArrayList<zag> zac = new ArrayList<>();

        ImageReceiver(Uri uri) {
            super(new zaq(Looper.getMainLooper()));
            this.zab = uri;
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            ImageManager imageManager = ImageManager.this;
            imageManager.zaf.execute(new zaa(imageManager, this.zab, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zab(zag zag) {
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zac.add(zag);
        }

        public final void zac(zag zag) {
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zac.remove(zag);
        }

        public final void zad() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(Constants.EXTRA_URI, this.zab);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.zad.sendBroadcast(intent);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private ImageManager(Context context, boolean z) {
        this.zad = context.getApplicationContext();
    }

    public static ImageManager create(Context context) {
        if (zac == null) {
            zac = new ImageManager(context, false);
        }
        return zac;
    }

    public void loadImage(ImageView imageView, int i) {
        zaj(new zae(imageView, i));
    }

    public final void zaj(zag zag2) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new zab(this, zag2).run();
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zaj(new zae(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zae zae2 = new zae(imageView, uri);
        zae2.zab = i;
        zaj(zae2);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zaj(new zaf(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zaf zaf2 = new zaf(onImageLoadedListener, uri);
        zaf2.zab = i;
        zaj(zaf2);
    }
}
