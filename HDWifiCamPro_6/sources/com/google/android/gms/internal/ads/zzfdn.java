package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbu;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfdn {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final long zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzfdm zzi;
    public final Bundle zzj;
    public final String zzk;
    public final String zzl;

    zzfdn(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String str;
        List emptyList = Collections.emptyList();
        Bundle bundle = new Bundle();
        jsonReader.beginObject();
        int i = 0;
        String str2 = "";
        Bundle bundle2 = bundle;
        boolean z = false;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        zzfdm zzfdm = null;
        long j = 0;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("nofill_urls".equals(nextName)) {
                emptyList = zzbu.zzd(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str3 = jsonReader.nextString();
            } else if ("is_idless".equals(nextName)) {
                z = jsonReader.nextBoolean();
            } else if ("response_code".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j = jsonReader.nextLong();
            } else {
                str = str6;
                if (!((Boolean) zzay.zzc().zzb(zzbjc.zzhf)).booleanValue() || !"public_error".equals(nextName) || jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                    JsonReader jsonReader2 = jsonReader;
                    if ("bidding_data".equals(nextName)) {
                        str4 = jsonReader.nextString();
                    } else if ("response_info_extras".equals(nextName)) {
                        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfT)).booleanValue()) {
                            try {
                                Bundle zza2 = zzbu.zza(zzbu.zzh(jsonReader));
                                bundle2 = zza2 == null ? bundle2 : zza2;
                            } catch (IOException | JSONException unused) {
                            } catch (IllegalStateException unused2) {
                                jsonReader.skipValue();
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestPostBody".equals(nextName)) {
                        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhX)).booleanValue()) {
                            str = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestUrl".equals(nextName)) {
                        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhX)).booleanValue()) {
                            str5 = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                    str6 = str;
                } else {
                    zzfdm = new zzfdm(jsonReader);
                    str6 = str;
                }
            }
            str = str6;
            JsonReader jsonReader3 = jsonReader;
            str6 = str;
        }
        String str7 = str6;
        JsonReader jsonReader4 = jsonReader;
        jsonReader.endObject();
        this.zza = emptyList;
        this.zzc = i;
        this.zzb = str2;
        this.zzd = str3;
        this.zze = i2;
        this.zzf = j;
        this.zzi = zzfdm;
        this.zzg = z;
        this.zzh = str4;
        this.zzj = bundle2;
        this.zzk = str5;
        this.zzl = str7;
    }
}
