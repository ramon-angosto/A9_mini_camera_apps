package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzcgi;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzr extends FrameLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final ImageButton zza;
    private final zzad zzb;

    public zzr(Context context, zzq zzq, zzad zzad) {
        super(context);
        this.zzb = zzad;
        setOnClickListener(this);
        this.zza = new ImageButton(context);
        zzc();
        this.zza.setBackgroundColor(0);
        this.zza.setOnClickListener(this);
        ImageButton imageButton = this.zza;
        zzaw.zzb();
        int zzw = zzcgi.zzw(context, zzq.zza);
        zzaw.zzb();
        int zzw2 = zzcgi.zzw(context, 0);
        zzaw.zzb();
        int zzw3 = zzcgi.zzw(context, zzq.zzb);
        zzaw.zzb();
        imageButton.setPadding(zzw, zzw2, zzw3, zzcgi.zzw(context, zzq.zzc));
        this.zza.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.zza;
        zzaw.zzb();
        int zzw4 = zzcgi.zzw(context, zzq.zzd + zzq.zza + zzq.zzb);
        zzaw.zzb();
        addView(imageButton2, new FrameLayout.LayoutParams(zzw4, zzcgi.zzw(context, zzq.zzd + zzq.zzc), 17));
        long longValue = ((Long) zzay.zzc().zzb(zzbjc.zzaW)).longValue();
        if (longValue > 0) {
            zzp zzp = ((Boolean) zzay.zzc().zzb(zzbjc.zzaX)).booleanValue() ? new zzp(this) : null;
            this.zza.setAlpha(0.0f);
            this.zza.animate().alpha(1.0f).setDuration(longValue).setListener(zzp);
        }
    }

    private final void zzc() {
        String str = (String) zzay.zzc().zzb(zzbjc.zzaV);
        if (!PlatformVersion.isAtLeastLollipop() || TextUtils.isEmpty(str) || "default".equals(str)) {
            this.zza.setImageResource(17301527);
            return;
        }
        Resources zzd = zzt.zzo().zzd();
        if (zzd != null) {
            Drawable drawable = null;
            try {
                if ("white".equals(str)) {
                    drawable = zzd.getDrawable(R.drawable.admob_close_button_white_circle_black_cross);
                } else if ("black".equals(str)) {
                    drawable = zzd.getDrawable(R.drawable.admob_close_button_black_circle_white_cross);
                }
            } catch (Resources.NotFoundException unused) {
                zze.zze("Close button resource not found, falling back to default.");
            }
            if (drawable == null) {
                this.zza.setImageResource(17301527);
                return;
            }
            this.zza.setImageDrawable(drawable);
            this.zza.setScaleType(ImageView.ScaleType.CENTER);
            return;
        }
        this.zza.setImageResource(17301527);
    }

    public final void onClick(View view) {
        zzad zzad = this.zzb;
        if (zzad != null) {
            zzad.zzbJ();
        }
    }

    public final void zzb(boolean z) {
        if (z) {
            this.zza.setVisibility(8);
            if (((Long) zzay.zzc().zzb(zzbjc.zzaW)).longValue() > 0) {
                this.zza.animate().cancel();
                this.zza.clearAnimation();
                return;
            }
            return;
        }
        this.zza.setVisibility(0);
    }
}
