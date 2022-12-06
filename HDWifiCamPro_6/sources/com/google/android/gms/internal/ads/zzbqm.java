package com.google.android.gms.internal.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbqm implements zzbpu {
    private final Context zza;

    public zzbqm(Context context) {
        this.zza = context;
    }

    public final void zza(Object obj, Map map) {
        if (map.containsKey(MimeTypes.BASE_TYPE_TEXT) && !TextUtils.isEmpty((CharSequence) map.get(MimeTypes.BASE_TYPE_TEXT))) {
            zze.zza("Opening Share Sheet with text: ".concat(String.valueOf((String) map.get(MimeTypes.BASE_TYPE_TEXT))));
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", (String) map.get(MimeTypes.BASE_TYPE_TEXT));
            if (map.containsKey(CampaignEx.JSON_KEY_TITLE)) {
                intent.putExtra("android.intent.extra.TITLE", (String) map.get(CampaignEx.JSON_KEY_TITLE));
            }
            try {
                zzt.zzp();
                zzs.zzJ(this.zza, intent);
            } catch (ActivityNotFoundException e) {
                zzt.zzo().zzt(e, "ShareSheetGmsgHandler.onGmsg");
            }
        }
    }
}
