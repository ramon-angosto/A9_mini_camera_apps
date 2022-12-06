package com.google.android.gms.internal.ads;

import android.util.JsonWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzcgk implements zzcgn {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzcgk(String str) {
        this.zza = str;
    }

    public final void zza(JsonWriter jsonWriter) {
        String str = this.zza;
        int i = zzcgo.zza;
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }
}
