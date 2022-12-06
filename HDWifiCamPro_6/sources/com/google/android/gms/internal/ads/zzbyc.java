package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbyc extends zzbyf {
    private final Map zza;
    /* access modifiers changed from: private */
    public final Context zzb;

    public zzbyc(zzcmp zzcmp, Map map) {
        super(zzcmp, "storePicture");
        this.zza = map;
        this.zzb = zzcmp.zzk();
    }

    public final void zzb() {
        if (this.zzb == null) {
            zzg("Activity context is not available");
            return;
        }
        zzt.zzp();
        if (!new zzbim(this.zzb).zzc()) {
            zzg("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzg("Image url cannot be empty.");
        } else if (URLUtil.isValidUrl(str)) {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzt.zzp();
            if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
                Resources zzd = zzt.zzo().zzd();
                zzt.zzp();
                AlertDialog.Builder zzG = zzs.zzG(this.zzb);
                zzG.setTitle(zzd != null ? zzd.getString(R.string.s1) : "Save image");
                zzG.setMessage(zzd != null ? zzd.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
                zzG.setPositiveButton(zzd != null ? zzd.getString(R.string.s3) : "Accept", new zzbya(this, str, lastPathSegment));
                zzG.setNegativeButton(zzd != null ? zzd.getString(R.string.s4) : "Decline", new zzbyb(this));
                zzG.create().show();
                return;
            }
            zzg("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
        } else {
            zzg("Invalid image url: ".concat(String.valueOf(str)));
        }
    }
}
