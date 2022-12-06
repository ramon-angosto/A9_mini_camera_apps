package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.ek */
class C1765ek implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f2229a;

    /* renamed from: a */
    final /* synthetic */ C1764ej f2230a;

    /* renamed from: a */
    final /* synthetic */ String f2231a;

    /* renamed from: b */
    final /* synthetic */ String f2232b;

    /* renamed from: c */
    final /* synthetic */ String f2233c;

    C1765ek(C1764ej ejVar, String str, Context context, String str2, String str3) {
        this.f2230a = ejVar;
        this.f2231a = str;
        this.f2229a = context;
        this.f2232b = str2;
        this.f2233c = str3;
    }

    public void run() {
        String str;
        String str2;
        Context context;
        Context context2;
        String str3;
        String str4;
        C1764ej ejVar;
        C1766el elVar;
        Context context3;
        if (!TextUtils.isEmpty(this.f2231a)) {
            try {
                C1760ef.m3335a(this.f2229a, this.f2231a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f2231a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.f2232b.equals(optString3)) {
                    if (this.f2233c.equals(optString4)) {
                        if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                            context2 = this.f2229a;
                            str3 = this.f2231a;
                            str4 = "A receive a incorrect message with empty type";
                        } else {
                            this.f2230a.mo17531b(optString3);
                            this.f2230a.mo17528a(optString4);
                            C1763ei eiVar = new C1763ei();
                            eiVar.mo17518b(optString);
                            eiVar.mo17516a(optString2);
                            eiVar.mo17515a(optInt);
                            eiVar.mo17522d(this.f2231a);
                            if ("service".equals(optString5)) {
                                if (!TextUtils.isEmpty(optString)) {
                                    ejVar = this.f2230a;
                                    elVar = C1766el.SERVICE_ACTION;
                                    context3 = this.f2229a;
                                } else {
                                    eiVar.mo17520c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                    ejVar = this.f2230a;
                                    elVar = C1766el.SERVICE_COMPONENT;
                                    context3 = this.f2229a;
                                }
                            } else if (C1766el.ACTIVITY.f2239a.equals(optString5)) {
                                ejVar = this.f2230a;
                                elVar = C1766el.ACTIVITY;
                                context3 = this.f2229a;
                            } else if (C1766el.PROVIDER.f2239a.equals(optString5)) {
                                ejVar = this.f2230a;
                                elVar = C1766el.PROVIDER;
                                context3 = this.f2229a;
                            } else {
                                context2 = this.f2229a;
                                str3 = this.f2231a;
                                str4 = "A receive a incorrect message with unknown type " + optString5;
                            }
                            ejVar.m3357a(elVar, context3, eiVar);
                            return;
                        }
                        C1760ef.m3335a(context2, str3, PointerIconCompat.TYPE_TEXT, str4);
                        return;
                    }
                }
                C1760ef.m3335a(this.f2229a, this.f2231a, PointerIconCompat.TYPE_TEXT, "A receive a incorrect message with incorrect package info" + optString3);
            } catch (JSONException e) {
                C1524b.m2155a((Throwable) e);
                context = this.f2229a;
                str2 = this.f2231a;
                str = "A meet a exception when receive the message";
            }
        } else {
            context = this.f2229a;
            str2 = "null";
            str = "A receive a incorrect message with empty info";
            C1760ef.m3335a(context, str2, PointerIconCompat.TYPE_TEXT, str);
        }
    }
}
