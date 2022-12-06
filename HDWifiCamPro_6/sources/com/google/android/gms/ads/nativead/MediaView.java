package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbmy;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class MediaView extends FrameLayout {
    private MediaContent zza;
    private boolean zzb;
    private ImageView.ScaleType zzc;
    private boolean zzd;
    private zzb zze;
    private zzc zzf;

    public MediaView(Context context) {
        super(context);
    }

    public MediaContent getMediaContent() {
        return this.zza;
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzd = true;
        this.zzc = scaleType;
        zzc zzc2 = this.zzf;
        if (zzc2 != null) {
            zzc2.zza.zzc(this.zzc);
        }
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzb = true;
        this.zza = mediaContent;
        zzb zzb2 = this.zze;
        if (zzb2 != null) {
            zzb2.zza.zzb(mediaContent);
        }
        if (mediaContent != null) {
            try {
                zzbmy zza2 = mediaContent.zza();
                if (zza2 != null && !zza2.zzr(ObjectWrapper.wrap(this))) {
                    removeAllViews();
                }
            } catch (RemoteException e) {
                removeAllViews();
                zzcgp.zzh("", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzb zzb2) {
        this.zze = zzb2;
        if (this.zzb) {
            zzb2.zza.zzb(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzb(zzc zzc2) {
        this.zzf = zzc2;
        if (this.zzd) {
            zzc2.zza.zzc(this.zzc);
        }
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
