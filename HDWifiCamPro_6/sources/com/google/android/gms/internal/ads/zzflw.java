package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzflw {
    static float zza = Resources.getSystem().getDisplayMetrics().density;
    private static WindowManager zzb;
    private static final String[] zzc = {"x", "y", "width", "height"};

    public static JSONObject zza(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) (((float) i) / zza));
            jSONObject.put("y", (double) (((float) i2) / zza));
            jSONObject.put("width", (double) (((float) i3) / zza));
            jSONObject.put("height", (double) (((float) i4) / zza));
        } catch (JSONException e) {
            zzflx.zza("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    public static void zzb(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            zzflx.zza("Error with setting ad session id", e);
        }
    }

    public static void zzc(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void zzd(JSONObject jSONObject, zzfma zzfma) {
        zzfli zza2 = zzfma.zza();
        JSONArray jSONArray = new JSONArray();
        ArrayList zzb2 = zzfma.zzb();
        int size = zzb2.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put((String) zzb2.get(i));
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", zza2.zzd());
            jSONObject.put("friendlyObstructionPurpose", zza2.zza());
            jSONObject.put("friendlyObstructionReason", zza2.zzc());
        } catch (JSONException e) {
            zzflx.zza("Error with setting friendly obstruction", e);
        }
    }

    public static void zze(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e) {
            zzflx.zza("Error with setting not visible reason", e);
        }
    }

    public static void zzf(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            zzflx.zza("Error with setting not visible reason", e);
        }
    }

    public static void zzg(Context context) {
        if (context != null) {
            zza = context.getResources().getDisplayMetrics().density;
            zzb = (WindowManager) context.getSystemService("window");
        }
    }

    public static void zzh(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e) {
            zzflx.zza("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    public static void zzi(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (zzb != null) {
            Point point = new Point(0, 0);
            zzb.getDefaultDisplay().getRealSize(point);
            f2 = ((float) point.x) / zza;
            f = ((float) point.y) / zza;
        } else {
            f = 0.0f;
        }
        try {
            jSONObject.put("width", (double) f2);
            jSONObject.put("height", (double) f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean zzj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject != null && jSONObject2 != null) {
            String[] strArr = zzc;
            int i = 0;
            while (true) {
                if (i < 4) {
                    String str = strArr[i];
                    if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                        break;
                    }
                    i++;
                } else if (jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", "")) && Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")))) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
                    if (optJSONArray != null || optJSONArray2 != null) {
                        if (zzk(optJSONArray, optJSONArray2)) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < optJSONArray.length()) {
                                    if (!optJSONArray.optString(i2, "").equals(optJSONArray2.optString(i2, ""))) {
                                        break;
                                    }
                                    i2++;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("childViews");
                    JSONArray optJSONArray4 = jSONObject2.optJSONArray("childViews");
                    if (!(optJSONArray3 == null && optJSONArray4 == null)) {
                        if (zzk(optJSONArray3, optJSONArray4)) {
                            int i3 = 0;
                            while (i3 < optJSONArray3.length()) {
                                if (zzj(optJSONArray3.optJSONObject(i3), optJSONArray4.optJSONObject(i3))) {
                                    i3++;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzk(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
