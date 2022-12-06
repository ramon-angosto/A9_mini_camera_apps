package com.mbridge.msdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mbridge.msdk.b.a.b;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.q;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SettingRequestController */
public class c {
    /* access modifiers changed from: private */
    public static final String a = c.class.getSimpleName();

    public final void a(final Context context, final String str, final String str2) {
        if (context != null) {
            b bVar = new b(context);
            d dVar = new d();
            dVar.a("app_id", str);
            dVar.a("sign", SameMD5.getMD5(str + str2));
            bVar.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().i, dVar, new com.mbridge.msdk.foundation.same.net.h.c() {
                public final void a(String str) {
                    com.mbridge.msdk.foundation.same.report.c cVar = new com.mbridge.msdk.foundation.same.report.c(context);
                    cVar.a();
                    cVar.a(str, com.mbridge.msdk.foundation.same.net.g.d.c().c);
                    com.mbridge.msdk.foundation.same.net.g.d.c().m++;
                    c.this.b(context, str, str2);
                }

                public final void a(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        try {
                            SharedPreferences.Editor edit = a.e().g().getApplicationContext().getSharedPreferences("cv", 0).edit();
                            edit.clear();
                            edit.commit();
                            jSONObject.put("current_time", System.currentTimeMillis());
                            jSONObject.put("host_setting", com.mbridge.msdk.foundation.same.net.g.d.c().c);
                            b.a().b(str, jSONObject.toString());
                            com.mbridge.msdk.foundation.same.net.g.d.c().d();
                            if (!TextUtils.isEmpty(jSONObject.optString("mraid_js"))) {
                                com.mbridge.msdk.b.b.a.a().a(context, jSONObject.optString("mraid_js"));
                            }
                            if (!TextUtils.isEmpty(jSONObject.optString("web_env_url"))) {
                                com.mbridge.msdk.b.b.b.a().a(context, jSONObject.optString("web_env_url"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    new com.mbridge.msdk.foundation.same.report.c(context).a();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(final Context context, final String str, final String str2) {
        if (!com.mbridge.msdk.foundation.same.net.g.d.c().a()) {
            try {
                if (!com.mbridge.msdk.foundation.same.net.g.d.c().n) {
                    com.mbridge.msdk.foundation.same.net.g.d.c().n = true;
                    if (System.currentTimeMillis() >= com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts").longValue() + 86400000) {
                        String b = com.mbridge.msdk.foundation.a.a.a.a().b("mkey_spare_host");
                        if (!TextUtils.isEmpty(b)) {
                            for (String str3 : b.split("\n")) {
                                if (!TextUtils.isEmpty(str3.trim()) && !com.mbridge.msdk.foundation.same.net.g.d.c().o.contains(str3.trim())) {
                                    com.mbridge.msdk.foundation.same.net.g.d.c().o.add(str3.trim());
                                }
                            }
                            b(context, str, str2);
                            return;
                        }
                    }
                    new com.mbridge.msdk.foundation.same.net.h.b(context.getApplicationContext()).a(0, com.mbridge.msdk.foundation.same.net.g.d.c().l, (d) null, new com.mbridge.msdk.foundation.same.net.b.a() {
                        public final void a(String str) {
                            q.a(c.a, "fetch CNDSettingHost success, content = " + str);
                            if (!TextUtils.isEmpty(str)) {
                                com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts", System.currentTimeMillis());
                                com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host", str);
                                for (String str2 : str.split("\n")) {
                                    if (!TextUtils.isEmpty(str2.trim()) && !com.mbridge.msdk.foundation.same.net.g.d.c().o.contains(str2.trim())) {
                                        com.mbridge.msdk.foundation.same.net.g.d.c().o.add(str2.trim());
                                    }
                                }
                                c.this.b(context, str, str2);
                            }
                        }

                        public final void b(String str) {
                            String a2 = c.a;
                            q.a(a2, "fetch CNDSettingHost failed, errorCode = " + str);
                        }
                    });
                }
            } catch (Throwable th) {
                q.d(a, th.getMessage());
            }
        } else {
            a(context, str, str2);
        }
    }

    public final void a(Context context, final String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = a.e().h();
            str2 = a.e().i();
        }
        if (b.a().a(str3, str) && b.a().a(str, 2, str3)) {
            b bVar = new b(context);
            d dVar = new d();
            dVar.a("unit_ids", "[" + str3 + "]");
            dVar.a("app_id", str);
            dVar.a("sign", SameMD5.getMD5(str + str2));
            bVar.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().i, dVar, new com.mbridge.msdk.foundation.same.net.h.c() {
                public final void a(String str) {
                }

                public final void a(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        try {
                            JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                                optJSONObject.put("current_time", System.currentTimeMillis());
                                b.a().a(str, str3, optJSONObject.toString());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
