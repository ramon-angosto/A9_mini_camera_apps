package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbxx extends zzbyf {
    private final Map zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    private final String zzc = zze("description");
    private final long zzd = zzd("start_ticks");
    private final long zze = zzd("end_ticks");
    private final String zzf = zze("summary");
    private final String zzg = zze(RequestParameters.SUBRESOURCE_LOCATION);

    public zzbxx(zzcmp zzcmp, Map map) {
        super(zzcmp, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcmp.zzk();
    }

    private final long zzd(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final String zze(String str) {
        return TextUtils.isEmpty((CharSequence) this.zza.get(str)) ? "" : (String) this.zza.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra(CampaignEx.JSON_KEY_TITLE, this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j = this.zzd;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zze;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void zzc() {
        if (this.zzb == null) {
            zzg("Activity context is not available.");
            return;
        }
        zzt.zzp();
        if (!new zzbim(this.zzb).zzb()) {
            zzg("This feature is not available on the device.");
            return;
        }
        zzt.zzp();
        AlertDialog.Builder zzG = zzs.zzG(this.zzb);
        Resources zzd2 = zzt.zzo().zzd();
        zzG.setTitle(zzd2 != null ? zzd2.getString(R.string.s5) : "Create calendar event");
        zzG.setMessage(zzd2 != null ? zzd2.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzG.setPositiveButton(zzd2 != null ? zzd2.getString(R.string.s3) : "Accept", new zzbxv(this));
        zzG.setNegativeButton(zzd2 != null ? zzd2.getString(R.string.s4) : "Decline", new zzbxw(this));
        zzG.create().show();
    }
}
