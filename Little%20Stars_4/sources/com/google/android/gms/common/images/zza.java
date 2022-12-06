package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;
import java.lang.ref.WeakReference;

public abstract class zza {
    final C0001zza zzapK;
    protected int zzapL = 0;
    protected int zzapM = 0;
    protected boolean zzapN = false;
    private boolean zzapO = true;
    private boolean zzapP = false;
    private boolean zzapQ = true;

    /* renamed from: com.google.android.gms.common.images.zza$zza  reason: collision with other inner class name */
    static final class C0001zza {
        public final Uri uri;

        public C0001zza(Uri uri2) {
            this.uri = uri2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0001zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return zzz.equal(((C0001zza) obj).uri, this.uri);
        }

        public int hashCode() {
            return zzz.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> zzapR;

        public zzb(ImageView imageView, int i) {
            super((Uri) null, i);
            com.google.android.gms.common.internal.zzb.zzv(imageView);
            this.zzapR = new WeakReference<>(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzv(imageView);
            this.zzapR = new WeakReference<>(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            int i = 0;
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof zzpi)) {
                int zzte = ((zzpi) imageView).zzte();
                if (this.zzapM != 0 && zzte == this.zzapM) {
                    return;
                }
            }
            boolean zzb = zzb(z, z2);
            if (zzb) {
                drawable = zza(imageView.getDrawable(), drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zzpi) {
                zzpi zzpi = (zzpi) imageView;
                zzpi.zzn(z3 ? this.zzapK.uri : null);
                if (z4) {
                    i = this.zzapM;
                }
                zzpi.zzbX(i);
            }
            if (zzb) {
                ((zzph) drawable).startTransition(250);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.zzapR.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).zzapR.get();
            return (imageView2 == null || imageView == null || !zzz.equal(imageView2, imageView)) ? false : true;
        }

        public int hashCode() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.zzapR.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {
        private WeakReference<ImageManager.OnImageLoadedListener> zzapS;

        public zzc(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzv(onImageLoadedListener);
            this.zzapS = new WeakReference<>(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzc = (zzc) obj;
            ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.zzapS.get();
            ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) zzc.zzapS.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzz.equal(onImageLoadedListener2, onImageLoadedListener) && zzz.equal(zzc.zzapK, this.zzapK);
        }

        public int hashCode() {
            return zzz.hashCode(this.zzapK);
        }

        /* access modifiers changed from: protected */
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            if (!z2 && (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.zzapS.get()) != null) {
                onImageLoadedListener.onImageLoaded(this.zzapK.uri, drawable, z3);
            }
        }
    }

    public zza(Uri uri, int i) {
        this.zzapK = new C0001zza(uri);
        this.zzapM = i;
    }

    private Drawable zza(Context context, zzpj zzpj, int i) {
        return context.getResources().getDrawable(i);
    }

    /* access modifiers changed from: protected */
    public zzph zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzph) {
            drawable = ((zzph) drawable).zztc();
        }
        return new zzph(drawable, drawable2);
    }

    /* access modifiers changed from: package-private */
    public void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzv(bitmap);
        zza(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* access modifiers changed from: package-private */
    public void zza(Context context, zzpj zzpj) {
        if (this.zzapQ) {
            zza((Drawable) null, false, true, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(Context context, zzpj zzpj, boolean z) {
        int i = this.zzapM;
        zza(i != 0 ? zza(context, zzpj, i) : null, z, false, false);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: protected */
    public boolean zzb(boolean z, boolean z2) {
        return this.zzapO && !z2 && !z;
    }

    public void zzbV(int i) {
        this.zzapM = i;
    }
}
