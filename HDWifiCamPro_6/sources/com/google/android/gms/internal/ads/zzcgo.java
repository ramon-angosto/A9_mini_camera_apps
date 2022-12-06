package com.google.android.gms.internal.ads;

import android.content.Context;
import android.provider.Settings;
import android.util.JsonWriter;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcgo {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb = new Object();
    private static boolean zzc = false;
    private static boolean zzd = false;
    private static final Clock zze = DefaultClock.getInstance();
    private static final Set zzf = new HashSet(Arrays.asList(new String[0]));
    private final List zzg;

    public zzcgo() {
        this((String) null);
    }

    static /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zzs(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name(TtmlNode.TAG_BODY).value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    static /* synthetic */ void zzb(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        zzs(jsonWriter, map);
        jsonWriter.endObject();
    }

    public static void zzi() {
        synchronized (zzb) {
            zzc = false;
            zzd = false;
            zzcgp.zzj("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzj(boolean z) {
        synchronized (zzb) {
            zzc = true;
            zzd = z;
        }
    }

    public static boolean zzk(Context context) {
        if (!((Boolean) zzbko.zza.zze()).booleanValue()) {
            return false;
        }
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            zzcgp.zzk("Fail to determine debug setting.", e);
            return false;
        }
    }

    public static boolean zzl() {
        boolean z;
        synchronized (zzb) {
            z = false;
            if (zzc && zzd) {
                z = true;
            }
        }
        return z;
    }

    public static boolean zzm() {
        boolean z;
        synchronized (zzb) {
            z = zzc;
        }
        return z;
    }

    private static synchronized void zzn(String str) {
        synchronized (zzcgo.class) {
            zzcgp.zzi("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + PAGSdk.INIT_LOCAL_FAIL_CODE;
                zzcgp.zzi("GMA Debug CONTENT ".concat(String.valueOf(str.substring(i, Math.min(i2, str.length())))));
                i = i2;
            }
            zzcgp.zzi("GMA Debug FINISH");
        }
    }

    private final void zzo(String str, zzcgn zzcgn) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zze.currentTimeMillis());
            jsonWriter.name(NotificationCompat.CATEGORY_EVENT).value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.zzg) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            zzcgn.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzcgp.zzh("unable to log", e);
        }
        zzn(stringWriter.toString());
    }

    private final void zzp(String str) {
        zzo("onNetworkRequestError", new zzcgk(str));
    }

    private final void zzq(String str, String str2, Map map, byte[] bArr) {
        zzo("onNetworkRequest", new zzcgl(str, str2, map, bArr));
    }

    private final void zzr(Map map, int i) {
        zzo("onNetworkResponse", new zzcgj(i, map));
    }

    private static void zzs(JsonWriter jsonWriter, Map map) throws IOException {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            Iterator it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                if (!zzf.contains(str)) {
                    if (!(entry.getValue() instanceof List)) {
                        if (!(entry.getValue() instanceof String)) {
                            zzcgp.zzg("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value((String) entry.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String value : (List) entry.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(str);
                            jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value(value);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    public final void zzc(HttpURLConnection httpURLConnection, byte[] bArr) {
        HashMap hashMap;
        if (zzl()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            zzq(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    public final void zzd(String str, String str2, Map map, byte[] bArr) {
        if (zzl()) {
            zzq(str, ShareTarget.METHOD_GET, map, bArr);
        }
    }

    public final void zze(HttpURLConnection httpURLConnection, int i) {
        if (zzl()) {
            String str = null;
            zzr(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    zzcgp.zzj("Can not get error message from error HttpURLConnection\n".concat(String.valueOf(e.getMessage())));
                }
                zzp(str);
            }
        }
    }

    public final void zzf(Map map, int i) {
        if (zzl()) {
            zzr(map, i);
            if (i < 200 || i >= 300) {
                zzp((String) null);
            }
        }
    }

    public final void zzg(String str) {
        if (zzl() && str != null) {
            zzh(str.getBytes());
        }
    }

    public final void zzh(byte[] bArr) {
        zzo("onNetworkResponseBody", new zzcgm(bArr));
    }

    public zzcgo(String str) {
        List list;
        if (!zzl()) {
            list = new ArrayList();
        } else {
            list = Arrays.asList(new String[]{"network_request_".concat(String.valueOf(UUID.randomUUID().toString()))});
        }
        this.zzg = list;
    }
}
