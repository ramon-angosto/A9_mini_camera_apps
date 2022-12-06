package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfo implements zzfsy {
    public static final /* synthetic */ zzfo zza = new zzfo();

    private /* synthetic */ zzfo() {
    }

    public final boolean zza(Object obj) {
        String str = (String) obj;
        if (str == null) {
            return false;
        }
        String zza2 = zzfse.zza(str);
        if (!TextUtils.isEmpty(zza2)) {
            return (!zza2.contains(MimeTypes.BASE_TYPE_TEXT) || zza2.contains(MimeTypes.TEXT_VTT)) && !zza2.contains("html") && !zza2.contains("xml");
        }
        return false;
    }
}
