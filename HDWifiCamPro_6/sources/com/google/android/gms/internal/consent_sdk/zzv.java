package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
final class zzv {
    private final Application zza;
    private final zzac zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zzam zze;
    private final zzba zzf;
    private final zzn zzg;
    private final zzz zzh;
    private final zzh zzi;

    zzv(Application application, zzac zzac, Handler handler, Executor executor, zzam zzam, zzba zzba, zzn zzn, zzz zzz, zzh zzh2) {
        this.zza = application;
        this.zzb = zzac;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzam;
        this.zzf = zzba;
        this.zzg = zzn;
        this.zzh = zzz;
        this.zzi = zzh2;
    }

    private final zzbw zzd(zzbu zzbu) throws zzj {
        String str;
        JsonWriter jsonWriter;
        JsonReader jsonReader;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://fundingchoicesmessages.google.com/a/consent").openConnection();
            Application application = this.zza;
            if (Build.VERSION.SDK_INT >= 17) {
                str = WebSettings.getDefaultUserAgent(application);
            } else {
                str = new WebView(application).getSettings().getUserAgentString();
            }
            httpURLConnection.setRequestProperty("User-Agent", str);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
            try {
                jsonWriter = new JsonWriter(outputStreamWriter);
                jsonWriter.beginObject();
                String str2 = zzbu.zza;
                if (str2 != null) {
                    jsonWriter.name("admob_app_id");
                    jsonWriter.value(str2);
                }
                Boolean bool = zzbu.zzb;
                if (bool != null) {
                    jsonWriter.name("is_lat");
                    jsonWriter.value(bool.booleanValue());
                }
                String str3 = zzbu.zzc;
                if (str3 != null) {
                    jsonWriter.name("adid");
                    jsonWriter.value(str3);
                }
                zzbq zzbq = zzbu.zzd;
                if (zzbq != null) {
                    jsonWriter.name("device_info");
                    jsonWriter.beginObject();
                    int i = zzbq.zzc;
                    if (i != 1) {
                        jsonWriter.name("os_type");
                        if (i != 0) {
                            zzbp zzbp = zzbp.DEBUG_PARAM_UNKNOWN;
                            if (i - 1 != 0) {
                                jsonWriter.value("ANDROID");
                            } else {
                                jsonWriter.value("UNKNOWN");
                            }
                        } else {
                            throw null;
                        }
                    }
                    String str4 = zzbq.zza;
                    if (str4 != null) {
                        jsonWriter.name("model");
                        jsonWriter.value(str4);
                    }
                    Integer num = zzbq.zzb;
                    if (num != null) {
                        jsonWriter.name("android_api_level");
                        jsonWriter.value(num);
                    }
                    jsonWriter.endObject();
                }
                String str5 = zzbu.zze;
                if (str5 != null) {
                    jsonWriter.name("language_code");
                    jsonWriter.value(str5);
                }
                Boolean bool2 = zzbu.zzf;
                if (bool2 != null) {
                    jsonWriter.name("tag_for_under_age_of_consent");
                    jsonWriter.value(bool2.booleanValue());
                }
                Map<String, String> map = zzbu.zzg;
                if (!map.isEmpty()) {
                    jsonWriter.name("stored_infos_map");
                    jsonWriter.beginObject();
                    for (Map.Entry next : map.entrySet()) {
                        jsonWriter.name((String) next.getKey());
                        jsonWriter.value((String) next.getValue());
                    }
                    jsonWriter.endObject();
                }
                zzbs zzbs = zzbu.zzh;
                if (zzbs != null) {
                    jsonWriter.name("screen_info");
                    jsonWriter.beginObject();
                    Integer num2 = zzbs.zza;
                    if (num2 != null) {
                        jsonWriter.name("width");
                        jsonWriter.value(num2);
                    }
                    Integer num3 = zzbs.zzb;
                    if (num3 != null) {
                        jsonWriter.name("height");
                        jsonWriter.value(num3);
                    }
                    Double d = zzbs.zzc;
                    if (d != null) {
                        jsonWriter.name("density");
                        jsonWriter.value(d);
                    }
                    List<zzbr> list = zzbs.zzd;
                    if (!list.isEmpty()) {
                        jsonWriter.name("screen_insets");
                        jsonWriter.beginArray();
                        for (zzbr next2 : list) {
                            jsonWriter.beginObject();
                            Integer num4 = next2.zza;
                            if (num4 != null) {
                                jsonWriter.name("top");
                                jsonWriter.value(num4);
                            }
                            Integer num5 = next2.zzb;
                            if (num5 != null) {
                                jsonWriter.name(TtmlNode.LEFT);
                                jsonWriter.value(num5);
                            }
                            Integer num6 = next2.zzc;
                            if (num6 != null) {
                                jsonWriter.name(TtmlNode.RIGHT);
                                jsonWriter.value(num6);
                            }
                            Integer num7 = next2.zzd;
                            if (num7 != null) {
                                jsonWriter.name("bottom");
                                jsonWriter.value(num7);
                            }
                            jsonWriter.endObject();
                        }
                        jsonWriter.endArray();
                    }
                    jsonWriter.endObject();
                }
                zzbo zzbo = zzbu.zzi;
                if (zzbo != null) {
                    jsonWriter.name("app_info");
                    jsonWriter.beginObject();
                    String str6 = zzbo.zza;
                    if (str6 != null) {
                        jsonWriter.name(CampaignEx.JSON_KEY_PACKAGE_NAME);
                        jsonWriter.value(str6);
                    }
                    String str7 = zzbo.zzb;
                    if (str7 != null) {
                        jsonWriter.name("publisher_display_name");
                        jsonWriter.value(str7);
                    }
                    String str8 = zzbo.zzc;
                    if (str8 != null) {
                        jsonWriter.name("version");
                        jsonWriter.value(str8);
                    }
                    jsonWriter.endObject();
                }
                zzbt zzbt = zzbu.zzj;
                if (zzbt != null) {
                    jsonWriter.name("sdk_info");
                    jsonWriter.beginObject();
                    String str9 = zzbt.zza;
                    if (str9 != null) {
                        jsonWriter.name("version");
                        jsonWriter.value(str9);
                    }
                    jsonWriter.endObject();
                }
                List<zzbp> list2 = zzbu.zzk;
                if (!list2.isEmpty()) {
                    jsonWriter.name("debug_params");
                    jsonWriter.beginArray();
                    for (zzbp ordinal : list2) {
                        zzbp zzbp2 = zzbp.DEBUG_PARAM_UNKNOWN;
                        int ordinal2 = ordinal.ordinal();
                        if (ordinal2 == 0) {
                            jsonWriter.value("DEBUG_PARAM_UNKNOWN");
                        } else if (ordinal2 == 1) {
                            jsonWriter.value("ALWAYS_SHOW");
                        } else if (ordinal2 == 2) {
                            jsonWriter.value("GEO_OVERRIDE_EEA");
                        } else if (ordinal2 == 3) {
                            jsonWriter.value("GEO_OVERRIDE_NON_EEA");
                        } else if (ordinal2 == 4) {
                            jsonWriter.value("PREVIEWING_DEBUG_MESSAGES");
                        }
                    }
                    jsonWriter.endArray();
                }
                jsonWriter.endObject();
                jsonWriter.close();
                outputStreamWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    String headerField = httpURLConnection.getHeaderField("x-ump-using-header");
                    if (headerField != null) {
                        zzbw zza2 = zzbw.zza(new JsonReader(new StringReader(headerField)));
                        zza2.zza = new Scanner(httpURLConnection.getInputStream()).useDelimiter("\\A").next();
                        return zza2;
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    try {
                        bufferedReader.readLine();
                        jsonReader = new JsonReader(bufferedReader);
                        zzbw zza3 = zzbw.zza(jsonReader);
                        jsonReader.close();
                        bufferedReader.close();
                        return zza3;
                    } catch (Throwable th) {
                        bufferedReader.close();
                        throw th;
                    }
                } else {
                    String next3 = new Scanner(httpURLConnection.getErrorStream()).useDelimiter("\\A").next();
                    StringBuilder sb = new StringBuilder(String.valueOf(next3).length() + 31);
                    sb.append("Http error code - ");
                    sb.append(responseCode);
                    sb.append(".\n");
                    sb.append(next3);
                    throw new IOException(sb.toString());
                }
                throw th;
                throw th;
            } catch (Throwable th2) {
                outputStreamWriter.close();
                throw th2;
            }
        } catch (SocketTimeoutException e) {
            throw new zzj(4, "The server timed out.", e);
        } catch (IOException e2) {
            throw new zzj(2, "Error making request.", e2);
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
    }

    public final /* synthetic */ void zza(ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        Handler handler = this.zzc;
        onConsentInfoUpdateSuccessListener.getClass();
        handler.post(new zzu(onConsentInfoUpdateSuccessListener));
    }

    public final /* synthetic */ void zzb(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        try {
            ConsentDebugSettings consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
            if (consentDebugSettings == null || !consentDebugSettings.isTestDevice()) {
                String zza2 = zzbx.zza(this.zza);
                StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 95);
                sb.append("Use new ConsentDebugSettings.Builder().addTestDeviceHashedId(\"");
                sb.append(zza2);
                sb.append("\") to set this as a debug device.");
                Log.i("UserMessagingPlatform", sb.toString());
            }
            zzaa zza3 = new zzy(this.zzh, zzd(this.zzg.zzd(activity, consentRequestParameters))).zza();
            this.zze.zzf(zza3.zza);
            this.zzf.zzb(zza3.zzb);
            this.zzi.zza().execute(new zzr(this, onConsentInfoUpdateSuccessListener));
        } catch (zzj e) {
            this.zzc.post(new zzs(onConsentInfoUpdateFailureListener, e));
        } catch (RuntimeException e2) {
            String valueOf = String.valueOf(Log.getStackTraceString(e2));
            this.zzc.post(new zzt(onConsentInfoUpdateFailureListener, new zzj(1, valueOf.length() != 0 ? "Caught exception when trying to request consent info update: ".concat(valueOf) : new String("Caught exception when trying to request consent info update: "))));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zzd.execute(new zzq(this, activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener));
    }
}
