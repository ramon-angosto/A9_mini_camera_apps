package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzbzy;
import com.google.android.gms.internal.ads.zzbzz;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class ReportingInfo {
    private final zzbzz zza;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzbzy zza = new zzbzy();

        public Builder(View view) {
            this.zza.zzb(view);
        }

        public ReportingInfo build() {
            return new ReportingInfo(this, (zzb) null);
        }

        public Builder setAssetViews(Map<String, View> map) {
            this.zza.zzc(map);
            return this;
        }
    }

    /* synthetic */ ReportingInfo(Builder builder, zzb zzb) {
        this.zza = new zzbzz(builder.zza);
    }

    public void recordClick(List<Uri> list) {
        this.zza.zza(list);
    }

    public void recordImpression(List<Uri> list) {
        this.zza.zzb(list);
    }

    public void reportTouchEvent(MotionEvent motionEvent) {
        this.zza.zzc(motionEvent);
    }

    public void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza.zzd(uri, updateClickUrlCallback);
    }

    public void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza.zze(list, updateImpressionUrlsCallback);
    }
}
