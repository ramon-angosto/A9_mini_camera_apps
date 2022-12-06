package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcix {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;
    public final boolean zzl;
    public final boolean zzm;
    public final boolean zzn;
    public final boolean zzo;
    public final long zzp;
    public final long zzq;

    public zzcix(String str) {
        String str2;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzbjc.zzG);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzbjc.zzj);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzbjc.zzu);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzbjc.zzf);
        zzbiu zzbiu = zzbjc.zze;
        if (jSONObject != null) {
            try {
                str2 = jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
            this.zze = str2;
            this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbjc.zzg);
            this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbjc.zzh);
            this.zzh = zzb(jSONObject, "player_precache_limit", zzbjc.zzi);
            this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbjc.zzk);
            this.zzj = zza(jSONObject, "use_cache_data_source", zzbjc.zzdt);
            this.zzk = zzb(jSONObject, "min_retry_count", zzbjc.zzl);
            this.zzl = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbjc.zzo);
            this.zzm = zza(jSONObject, "using_official_simple_exo_player", zzbjc.zzbE);
            this.zzn = zza(jSONObject, "enable_multiple_video_playback", zzbjc.zzbF);
            this.zzo = zza(jSONObject, "use_range_http_data_source", zzbjc.zzbH);
            this.zzp = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbjc.zzbI);
            this.zzq = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbjc.zzbJ);
        }
        str2 = (String) zzay.zzc().zzb(zzbiu);
        this.zze = str2;
        this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbjc.zzg);
        this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbjc.zzh);
        this.zzh = zzb(jSONObject, "player_precache_limit", zzbjc.zzi);
        this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbjc.zzk);
        this.zzj = zza(jSONObject, "use_cache_data_source", zzbjc.zzdt);
        this.zzk = zzb(jSONObject, "min_retry_count", zzbjc.zzl);
        this.zzl = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbjc.zzo);
        this.zzm = zza(jSONObject, "using_official_simple_exo_player", zzbjc.zzbE);
        this.zzn = zza(jSONObject, "enable_multiple_video_playback", zzbjc.zzbF);
        this.zzo = zza(jSONObject, "use_range_http_data_source", zzbjc.zzbH);
        this.zzp = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbjc.zzbI);
        this.zzq = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbjc.zzbJ);
    }

    private static final boolean zza(JSONObject jSONObject, String str, zzbiu zzbiu) {
        boolean booleanValue = ((Boolean) zzay.zzc().zzb(zzbiu)).booleanValue();
        if (jSONObject == null) {
            return booleanValue;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return booleanValue;
        }
    }

    private static final int zzb(JSONObject jSONObject, String str, zzbiu zzbiu) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzay.zzc().zzb(zzbiu)).intValue();
    }

    private static final long zzc(JSONObject jSONObject, String str, zzbiu zzbiu) {
        if (jSONObject != null) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException unused) {
            }
        }
        return ((Long) zzay.zzc().zzb(zzbiu)).longValue();
    }
}
