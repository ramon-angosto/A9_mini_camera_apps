package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjc;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    public static AdSize findClosestSize(Context context, AdSize adSize, List<AdSize> list) {
        AdSize adSize2 = null;
        if (!(list == null || adSize == null)) {
            if (!adSize.zzh() && !adSize.zzi()) {
                float f = context.getResources().getDisplayMetrics().density;
                adSize = new AdSize(Math.round(((float) adSize.getWidthInPixels(context)) / f), Math.round(((float) adSize.getHeightInPixels(context)) / f));
            }
            for (AdSize next : list) {
                if (next != null) {
                    int width = adSize.getWidth();
                    int width2 = next.getWidth();
                    int height = adSize.getHeight();
                    int height2 = next.getHeight();
                    if (((double) width) * MIN_WIDTH_RATIO <= ((double) width2) && width >= width2) {
                        if (adSize.zzi()) {
                            int zza = adSize.zza();
                            if (((Integer) zzay.zzc().zzb(zzbjc.zzgL)).intValue() <= width2) {
                                if (((Integer) zzay.zzc().zzb(zzbjc.zzgM)).intValue() <= height2) {
                                    if (zza < height2) {
                                    }
                                }
                            }
                        } else if (adSize.zzh()) {
                            if (adSize.zzb() < height2) {
                            }
                        } else if (((double) height) * MIN_HEIGHT_RATIO <= ((double) height2)) {
                            if (height < height2) {
                            }
                        }
                        if (adSize2 == null || adSize2.getWidth() * adSize2.getHeight() <= next.getWidth() * next.getHeight()) {
                            adSize2 = next;
                        }
                    }
                }
            }
        }
        return adSize2;
    }
}
