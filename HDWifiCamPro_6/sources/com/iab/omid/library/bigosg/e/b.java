package com.iab.omid.library.bigosg.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.iab.omid.library.bigosg.c.c;
import com.iab.omid.library.bigosg.h.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    static float a = Resources.getSystem().getDisplayMetrics().density;
    private static WindowManager b;
    private static String[] c = {"x", "y", "width", "height"};

    static class a {
        final float a;
        final float b;

        a(float f, float f2) {
            this.a = f;
            this.b = f2;
        }
    }

    public static JSONObject a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) (((float) i) / a));
            jSONObject.put("y", (double) (((float) i2) / a));
            jSONObject.put("width", (double) (((float) i3) / a));
            jSONObject.put("height", (double) (((float) i4) / a));
        } catch (JSONException e) {
            c.a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    public static void a(Context context) {
        if (context != null) {
            a = context.getResources().getDisplayMetrics().density;
            b = (WindowManager) context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject) {
        float f;
        JSONObject jSONObject2 = jSONObject;
        float f2 = 0.0f;
        if (Build.VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject2.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f3 = 0.0f;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble("width");
                        double optDouble4 = optJSONObject.optDouble("height");
                        f2 = Math.max(f2, (float) (optDouble + optDouble3));
                        f3 = Math.max(f3, (float) (optDouble2 + optDouble4));
                    }
                }
                f = f3;
                a aVar = new a(f2, f);
                jSONObject2.put("width", (double) aVar.a);
                jSONObject2.put("height", (double) aVar.b);
            }
        } else if (b != null) {
            Point point = new Point(0, 0);
            b.getDefaultDisplay().getRealSize(point);
            f2 = ((float) point.x) / a;
            f = ((float) point.y) / a;
            a aVar2 = new a(f2, f);
            jSONObject2.put("width", (double) aVar2.a);
            jSONObject2.put("height", (double) aVar2.b);
        }
        f = 0.0f;
        a aVar22 = new a(f2, f);
        try {
            jSONObject2.put("width", (double) aVar22.a);
            jSONObject2.put("height", (double) aVar22.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void a(JSONObject jSONObject, b.a aVar) {
        c cVar = aVar.a;
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.b) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", cVar.b);
            jSONObject.put("friendlyObstructionPurpose", cVar.c);
            jSONObject.put("friendlyObstructionReason", cVar.d);
        } catch (JSONException e) {
            c.a("Error with setting friendly obstruction", e);
        }
    }

    public static void a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            c.a("Error with setting ad session id", e);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            c.a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
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

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    public static void b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            c.a("Error with setting not visible reason", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(org.json.JSONObject r10, org.json.JSONObject r11) {
        /*
            r0 = 1
            if (r10 != 0) goto L_0x0006
            if (r11 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            if (r10 == 0) goto L_0x00a0
            if (r11 != 0) goto L_0x000d
            goto L_0x00a0
        L_0x000d:
            java.lang.String[] r2 = c
            int r3 = r2.length
            r4 = r1
        L_0x0011:
            if (r4 >= r3) goto L_0x0026
            r5 = r2[r4]
            double r6 = r10.optDouble(r5)
            double r8 = r11.optDouble(r5)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0023
            r2 = r1
            goto L_0x0027
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0026:
            r2 = r0
        L_0x0027:
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r10.optString(r2, r3)
            java.lang.String r2 = r11.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r10.optJSONArray(r2)
            org.json.JSONArray r2 = r11.optJSONArray(r2)
            if (r4 != 0) goto L_0x0049
            if (r2 == 0) goto L_0x006a
        L_0x0049:
            boolean r5 = a((org.json.JSONArray) r4, (org.json.JSONArray) r2)
            if (r5 != 0) goto L_0x0051
        L_0x004f:
            r2 = r1
            goto L_0x006b
        L_0x0051:
            r5 = r1
        L_0x0052:
            int r6 = r4.length()
            if (r5 >= r6) goto L_0x006a
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0067
            goto L_0x004f
        L_0x0067:
            int r5 = r5 + 1
            goto L_0x0052
        L_0x006a:
            r2 = r0
        L_0x006b:
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "childViews"
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            org.json.JSONArray r11 = r11.optJSONArray(r2)
            if (r10 != 0) goto L_0x007b
            if (r11 == 0) goto L_0x009c
        L_0x007b:
            boolean r2 = a((org.json.JSONArray) r10, (org.json.JSONArray) r11)
            if (r2 != 0) goto L_0x0083
        L_0x0081:
            r10 = r1
            goto L_0x009d
        L_0x0083:
            r2 = r1
        L_0x0084:
            int r3 = r10.length()
            if (r2 >= r3) goto L_0x009c
            org.json.JSONObject r3 = r10.optJSONObject(r2)
            org.json.JSONObject r4 = r11.optJSONObject(r2)
            boolean r3 = b((org.json.JSONObject) r3, (org.json.JSONObject) r4)
            if (r3 != 0) goto L_0x0099
            goto L_0x0081
        L_0x0099:
            int r2 = r2 + 1
            goto L_0x0084
        L_0x009c:
            r10 = r0
        L_0x009d:
            if (r10 == 0) goto L_0x00a0
            return r0
        L_0x00a0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iab.omid.library.bigosg.e.b.b(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
