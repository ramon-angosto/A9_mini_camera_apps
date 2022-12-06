package com.google.android.gms.internal.ads;

import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfnf {
    public static zzana zza(Context context, String str, String str2) {
        return new zzfne(context, str, str2).zzb(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
    }
}
