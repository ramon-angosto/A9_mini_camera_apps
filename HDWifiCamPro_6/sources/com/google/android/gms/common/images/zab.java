package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zab implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final zag zab;

    public zab(ImageManager imageManager, zag zag) {
        this.zaa = imageManager;
        this.zab = zag;
    }

    public final void run() {
        Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.zaa.zah.get(this.zab);
        if (imageReceiver != null) {
            this.zaa.zah.remove(this.zab);
            imageReceiver.zac(this.zab);
        }
        zag zag = this.zab;
        zad zad = zag.zaa;
        Uri uri = zad.zaa;
        if (uri != null) {
            Long l = (Long) this.zaa.zaj.get(uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    zag zag2 = this.zab;
                    ImageManager imageManager = this.zaa;
                    zag2.zab(imageManager.zad, imageManager.zag, true);
                    return;
                }
                this.zaa.zaj.remove(zad.zaa);
            }
            this.zab.zaa((Drawable) null, false, true, false);
            ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) this.zaa.zai.get(zad.zaa);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageManager.ImageReceiver(zad.zaa);
                this.zaa.zai.put(zad.zaa, imageReceiver2);
            }
            imageReceiver2.zab(this.zab);
            zag zag3 = this.zab;
            if (!(zag3 instanceof zaf)) {
                this.zaa.zah.put(zag3, imageReceiver2);
            }
            synchronized (ImageManager.zaa) {
                if (!ImageManager.zab.contains(zad.zaa)) {
                    ImageManager.zab.add(zad.zaa);
                    imageReceiver2.zad();
                }
            }
            return;
        }
        ImageManager imageManager2 = this.zaa;
        zag.zab(imageManager2.zad, imageManager2.zag, true);
    }
}
