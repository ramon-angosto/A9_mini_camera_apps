package com.mbridge.msdk.advanced.js;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.mbsignalcommon.communication.b;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativeAdvancedJsUtils */
public final class a {
    private static String a = "NativeAdvancedJsUtils";

    public static void a(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        JSONArray jSONArray;
        String str3;
        int i;
        boolean z;
        String str4;
        Object obj2 = obj;
        JSONObject jSONObject2 = jSONObject;
        String str5 = "";
        JSONObject jSONObject3 = new JSONObject();
        String str6 = "message";
        int i2 = 1;
        if (jSONObject2 == null) {
            try {
                jSONObject3.put("code", 1);
                jSONObject3.put(str6, "params is null");
                g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (JSONException e) {
                q.a(a, e.getMessage());
            }
        } else {
            try {
                jSONObject3.put("code", 0);
                jSONObject3.put(str6, str5);
                JSONArray jSONArray2 = jSONObject2.getJSONArray("resource");
                if (jSONArray2 == null || jSONArray2.length() <= 0) {
                    String str7 = str6;
                    try {
                        jSONObject3.put("code", 1);
                        str = str7;
                        try {
                            jSONObject3.put(str, "resource is null");
                            g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                        } catch (JSONException e2) {
                            e = e2;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        str = str7;
                        try {
                            q.a(a, e.getMessage());
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                } else {
                    JSONArray jSONArray3 = new JSONArray();
                    int length = jSONArray2.length();
                    int i3 = 0;
                    while (i3 < length) {
                        JSONObject jSONObject4 = jSONArray2.getJSONObject(i3);
                        String optString = jSONObject4.optString("ref", str5);
                        int i4 = jSONObject4.getInt("type");
                        JSONObject jSONObject5 = new JSONObject();
                        if (i4 == i2) {
                            if (!TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject6 = new JSONObject();
                                l a2 = o.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g())).a(optString);
                                if (a2 != null) {
                                    jSONArray = jSONArray2;
                                    i = length;
                                    q.a(a, "VideoBean not null");
                                    jSONObject6.put("type", 1);
                                    jSONObject6.put("videoDataLength", a2.c());
                                    String e4 = a2.e();
                                    str2 = str6;
                                    if (TextUtils.isEmpty(e4)) {
                                        try {
                                            q.a(a, "VideoPath null");
                                            jSONObject6.put("path", str5);
                                            jSONObject6.put("path4Web", str5);
                                            str3 = str5;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str = str2;
                                            try {
                                                jSONObject3.put("code", 1);
                                                jSONObject3.put(str, th.getLocalizedMessage());
                                                g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                                            } catch (JSONException e5) {
                                                q.a(a, e5.getMessage());
                                                return;
                                            }
                                        }
                                    } else {
                                        str3 = str5;
                                        q.a(a, "VideoPath not null");
                                        jSONObject6.put("path", e4);
                                        jSONObject6.put("path4Web", e4);
                                    }
                                    if (a2.d() == 5) {
                                        jSONObject6.put("downloaded", 1);
                                        z = false;
                                    } else {
                                        z = false;
                                        jSONObject6.put("downloaded", 0);
                                    }
                                    jSONObject5.put(optString, jSONObject6);
                                    jSONArray3.put(jSONObject5);
                                } else {
                                    str3 = str5;
                                    str2 = str6;
                                    jSONArray = jSONArray2;
                                    i = length;
                                    z = false;
                                    q.a(a, "VideoBean null");
                                }
                                i3++;
                                jSONArray2 = jSONArray;
                                boolean z2 = z;
                                length = i;
                                str6 = str2;
                                str5 = str3;
                                i2 = 1;
                            }
                        }
                        str3 = str5;
                        str2 = str6;
                        jSONArray = jSONArray2;
                        i = length;
                        z = false;
                        if (i4 == 2 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("type", 2);
                            jSONObject7.put("path", com.mbridge.msdk.videocommon.download.g.a().b(optString) == null ? str3 : com.mbridge.msdk.videocommon.download.g.a().b(optString));
                            jSONObject5.put(optString, jSONObject7);
                            jSONArray3.put(jSONObject5);
                            i3++;
                            jSONArray2 = jSONArray;
                            boolean z22 = z;
                            length = i;
                            str6 = str2;
                            str5 = str3;
                            i2 = 1;
                        } else if (i4 != 3 || TextUtils.isEmpty(optString)) {
                            if (i4 == 4 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("type", 4);
                                jSONObject8.put("path", t.a(optString) == null ? str3 : t.a(optString));
                                jSONObject5.put(optString, jSONObject8);
                                jSONArray3.put(jSONObject5);
                            }
                            i3++;
                            jSONArray2 = jSONArray;
                            boolean z222 = z;
                            length = i;
                            str6 = str2;
                            str5 = str3;
                            i2 = 1;
                        } else {
                            File file = new File(optString);
                            if (file.exists() && file.isFile() && file.canRead()) {
                                q.a(a, "getFileInfo Mraid file " + optString);
                                str4 = "file:////" + optString;
                                JSONObject jSONObject9 = new JSONObject();
                                jSONObject9.put("type", 3);
                                jSONObject9.put("path", str4);
                                jSONObject5.put(optString, jSONObject9);
                                jSONArray3.put(jSONObject5);
                                i3++;
                                jSONArray2 = jSONArray;
                                boolean z2222 = z;
                                length = i;
                                str6 = str2;
                                str5 = str3;
                                i2 = 1;
                            }
                            str4 = str3;
                            JSONObject jSONObject92 = new JSONObject();
                            jSONObject92.put("type", 3);
                            jSONObject92.put("path", str4);
                            jSONObject5.put(optString, jSONObject92);
                            jSONArray3.put(jSONObject5);
                            i3++;
                            jSONArray2 = jSONArray;
                            boolean z22222 = z;
                            length = i;
                            str6 = str2;
                            str5 = str3;
                            i2 = 1;
                        }
                    }
                    String str8 = str6;
                    jSONObject3.put("resource", jSONArray3);
                    g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                }
            } catch (Throwable th3) {
                th = th3;
                str = str6;
                jSONObject3.put("code", 1);
                jSONObject3.put(str, th.getLocalizedMessage());
                g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            }
        }
    }

    public static void a(WebView webView, String str, String str2) {
        g.a().a(webView, str, str2);
    }

    public static void a(WebView webView, String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sq", 1);
            jSONObject.put("action", str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str2, obj);
                jSONObject.put("params", jSONObject2);
            }
            if (TextUtils.isEmpty(str2) && obj != null) {
                jSONObject.put("params", obj);
            }
            g.a().a(webView, "thirdPartyCalled", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void a(WebView webView) {
        q.d(a, "fireOnSignalCommunication");
        g.a().a(webView);
    }

    public static void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", b.b);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            q.a(a, e.getMessage());
        }
    }
}
