package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzegg {
    private final zzbep zza;
    private final Context zzb;
    private final zzefk zzc;
    private final zzcgv zzd;
    private final String zze;
    private final zzfir zzf;
    private final zzg zzg = zzt.zzo().zzh();

    public zzegg(Context context, zzcgv zzcgv, zzbep zzbep, zzefk zzefk, String str, zzfir zzfir) {
        this.zzb = context;
        this.zzd = zzcgv;
        this.zza = zzbep;
        this.zzc = zzefk;
        this.zze = str;
        this.zzf = zzfir;
    }

    private static final void zzc(SQLiteDatabase sQLiteDatabase, ArrayList arrayList) {
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            zzbgy zzbgy = (zzbgy) arrayList.get(i);
            if (zzbgy.zzw() == 2 && zzbgy.zze() > j) {
                j = zzbgy.zze();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
        }
    }

    public final void zzb(boolean z) {
        try {
            this.zzc.zza(new zzegc(this, z));
        } catch (Exception e) {
            zze.zzg("Error in offline signals database startup: ".concat(String.valueOf(e.getMessage())));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        String str;
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
            return null;
        }
        int i = 2;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhs)).booleanValue()) {
            zzfiq zzb2 = zzfiq.zzb("oa_upload");
            zzb2.zza("oa_failed_reqs", String.valueOf(zzefz.zza(sQLiteDatabase, 0)));
            zzb2.zza("oa_total_reqs", String.valueOf(zzefz.zza(sQLiteDatabase, 1)));
            zzb2.zza("oa_upload_time", String.valueOf(zzt.zzB().currentTimeMillis()));
            zzb2.zza("oa_last_successful_time", String.valueOf(zzefz.zzb(sQLiteDatabase, 2)));
            zzb2.zza("oa_session_id", this.zzg.zzP() ? "" : this.zze);
            this.zzf.zzb(zzb2);
            ArrayList zzc2 = zzefz.zzc(sQLiteDatabase);
            zzc(sQLiteDatabase, zzc2);
            int size = zzc2.size();
            for (int i2 = 0; i2 < size; i2++) {
                zzbgy zzbgy = (zzbgy) zzc2.get(i2);
                zzfiq zzb3 = zzfiq.zzb("oa_signals");
                if (this.zzg.zzP()) {
                    str = "";
                } else {
                    str = this.zze;
                }
                zzb3.zza("oa_session_id", str);
                zzbgt zzf2 = zzbgy.zzf();
                String valueOf = zzf2.zzf() ? String.valueOf(zzf2.zzh() - 1) : "-1";
                String obj = zzfwb.zzb(zzbgy.zzk(), zzegf.zza).toString();
                zzb3.zza("oa_sig_ts", String.valueOf(zzbgy.zze()));
                zzb3.zza("oa_sig_status", String.valueOf(zzbgy.zzw() - 1));
                zzb3.zza("oa_sig_resp_lat", String.valueOf(zzbgy.zzd()));
                zzb3.zza("oa_sig_render_lat", String.valueOf(zzbgy.zzc()));
                zzb3.zza("oa_sig_formats", obj);
                zzb3.zza("oa_sig_nw_type", valueOf);
                zzb3.zza("oa_sig_wifi", String.valueOf(zzbgy.zzx() - 1));
                zzb3.zza("oa_sig_airplane", String.valueOf(zzbgy.zzt() - 1));
                zzb3.zza("oa_sig_data", String.valueOf(zzbgy.zzu() - 1));
                zzb3.zza("oa_sig_nw_resp", String.valueOf(zzbgy.zza()));
                zzb3.zza("oa_sig_offline", String.valueOf(zzbgy.zzv() - 1));
                zzb3.zza("oa_sig_nw_state", String.valueOf(zzbgy.zzj().zza()));
                if (zzf2.zze() && zzf2.zzf() && zzf2.zzh() == 2) {
                    zzb3.zza("oa_sig_cell_type", String.valueOf(zzf2.zzg() - 1));
                }
                this.zzf.zzb(zzb3);
            }
        } else {
            ArrayList zzc3 = zzefz.zzc(sQLiteDatabase);
            zzbgz zza2 = zzbhd.zza();
            zza2.zzb(this.zzb.getPackageName());
            zza2.zzd(Build.MODEL);
            zza2.zze(zzefz.zza(sQLiteDatabase, 0));
            zza2.zza(zzc3);
            zza2.zzg(zzefz.zza(sQLiteDatabase, 1));
            zza2.zzc(zzefz.zza(sQLiteDatabase, 3));
            zza2.zzh(zzt.zzB().currentTimeMillis());
            zza2.zzf(zzefz.zzb(sQLiteDatabase, 2));
            zzc(sQLiteDatabase, zzc3);
            this.zza.zzb(new zzegd((zzbhd) zza2.zzam()));
            zzbho zza3 = zzbhp.zza();
            zza3.zza(this.zzd.zzb);
            zza3.zzc(this.zzd.zzc);
            if (true == this.zzd.zzd) {
                i = 0;
            }
            zza3.zzb(i);
            this.zza.zzb(new zzege((zzbhp) zza3.zzam()));
            this.zza.zzc(10004);
        }
        zzefz.zzf(sQLiteDatabase);
        return null;
    }
}
