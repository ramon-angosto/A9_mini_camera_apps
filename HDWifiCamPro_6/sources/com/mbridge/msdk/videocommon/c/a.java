package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.h.c;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.videocommon.d.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RewardSettingController */
public class a {
    /* access modifiers changed from: private */
    public static final String a = a.class.getName();

    public final void a(Context context, final String str, String str2) {
        b bVar = new b(context);
        d dVar = new d();
        dVar.a("app_id", str);
        dVar.a("sign", SameMD5.getMD5(str + str2));
        bVar.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().k, dVar, new c() {
            public final void a(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        jSONObject.put("current_time", System.currentTimeMillis());
                        b.a();
                        String str = str;
                        String jSONObject2 = jSONObject.toString();
                        com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str, jSONObject2);
                        b.a = com.mbridge.msdk.videocommon.d.a.a(jSONObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            public final void a(String str) {
                q.d(a.a, str);
            }
        });
    }

    public final void a(Context context, final String str, String str2, String str3, final c cVar) {
        b bVar = new b(context);
        d dVar = new d();
        dVar.a("app_id", str);
        dVar.a("sign", SameMD5.getMD5(str + str2));
        dVar.a("unit_ids", "[" + str3 + "]");
        AnonymousClass2 r5 = new c() {
            public final void a(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        if (b.b(jSONObject.toString())) {
                            jSONObject.put("current_time", System.currentTimeMillis());
                            b.a().a(str, this.d, jSONObject.toString());
                            if (cVar != null) {
                                cVar.a("request success");
                            }
                        } else if (cVar != null) {
                            cVar.b("data error");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            public final void a(String str) {
                if (!TextUtils.isEmpty(str)) {
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.b(str);
                        return;
                    }
                    return;
                }
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.b("request error");
                }
            }
        };
        r5.d = str3;
        bVar.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().k, dVar, r5);
    }
}
