package com.google.android.gms.internal.ads;

import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfnh {
    public static zzfoq zza(Context context, int i, int i2, String str, String str2, String str3, zzfmx zzfmx) {
        return new zzfng(context, 1, i2, str, str2, "1", zzfmx).zzb(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
    }
}
