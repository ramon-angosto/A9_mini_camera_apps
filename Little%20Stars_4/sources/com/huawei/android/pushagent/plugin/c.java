package com.huawei.android.pushagent.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.pushagent.PushReceiver;
import com.huawei.android.pushagent.c.a.b;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.plugin.a.e;
import com.huawei.android.pushagent.plugin.a.f;
import com.huawei.android.pushagent.plugin.a.g;
import com.huawei.android.pushagent.plugin.a.i;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import com.huawei.android.pushagent.plugin.tools.b.a;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    /* access modifiers changed from: private */
    public Context a;
    private int b = 0;
    private e c;

    public c(Context context) {
        this.a = context;
        this.c = new e(context);
    }

    private String a(Context context) {
        com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "begin to fetch salt");
        String a2 = a.a(context, com.huawei.android.pushagent.plugin.tools.c.b(context));
        if (a2 == null) {
            return null;
        }
        i iVar = new i();
        iVar.a(a2);
        com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, " saltValue reponse");
        if (iVar.c() > 0) {
            this.c.a("minUp", (Object) Long.valueOf(iVar.c()));
        }
        if (iVar.d() > 0) {
            this.c.a("maxUp", (Object) Long.valueOf(iVar.d()));
        }
        if (iVar.b() > -1) {
            this.c.a("belongId", (Object) Integer.valueOf(iVar.b()));
        }
        if (TextUtils.isEmpty(iVar.a())) {
            com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "fetch salt fail");
            return null;
        }
        this.c.a(iVar.a());
        return String.valueOf(iVar.a().hashCode());
    }

    private void a(Context context, int i, boolean z) {
        context.sendBroadcast(new Intent("com.huawei.android.push.plugin.RESPONSE").putExtra(PushReceiver.BOUND_KEY.PLUGINREPORTTYPE, i).putExtra(PushReceiver.BOUND_KEY.PLUGINREPORTRESULT, z).putExtra("reportExtra", new Bundle()).setPackage(this.a.getPackageName()));
    }

    private void a(String str) {
        com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "add tags failed, need remove local tags");
        a(str, 1);
    }

    private void a(String str, int i) {
        try {
            JSONArray b2 = b.b(str);
            if (b2 != null) {
                h hVar = new h(this.a, "tags_info");
                int length = b2.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = b2.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("tagKey");
                        if (i == optJSONObject.optInt("opType")) {
                            hVar.f(optString);
                            com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "delete local tags:" + optJSONObject.toString());
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.huawei.android.pushagent.c.a.e.c(BLocation.TAG, "delete tags error:" + e.getMessage(), e);
        }
    }

    private boolean a() {
        return !TextUtils.isEmpty(this.c.a());
    }

    private void b(String str) {
        com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "delect tags success, need remove local tags");
        a(str, 2);
    }

    public void a(String str, int i, int i2) {
        String str2;
        try {
            int i3 = -1;
            if (-1 == b.a(this.a)) {
                com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "network unavailable");
                a(this.a, i, false);
                if (f.TAG.b() == i) {
                    a(str);
                    return;
                }
                return;
            }
            long c2 = this.c.c("delayTime", 0);
            if (0 == c2 || c2 <= System.currentTimeMillis()) {
                this.c.e("delayTime");
                if (TextUtils.isEmpty(str)) {
                    a(this.a, i, false);
                    return;
                }
                String b2 = com.huawei.android.pushagent.plugin.tools.c.b(this.a);
                if (TextUtils.isEmpty(b2)) {
                    com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "token is null, need to register and get deviceToken");
                    com.huawei.android.pushagent.plugin.tools.c.a(this.a, new d(this, str, i, i2));
                    return;
                }
                if (!a()) {
                    com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "salt is null, need to get salt");
                    str2 = a(this.a);
                } else {
                    str2 = String.valueOf(this.c.a().hashCode());
                }
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    a(this.a, i, false);
                    if (f.TAG.b() == i) {
                        a(str);
                        return;
                    }
                    return;
                }
                String a2 = a.a(this.a, new g(com.huawei.android.pushagent.c.a.a.h.a(b2), i2, str3, str, this.a));
                com.huawei.android.pushagent.plugin.a.h hVar = new com.huawei.android.pushagent.plugin.a.h();
                if (a2 != null) {
                    hVar.a(a2);
                    i3 = hVar.a();
                    com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "ReportRsp is " + hVar.toString());
                }
                if (1 != i3 || this.b >= 3) {
                    this.b = 0;
                    if (i3 == 0) {
                        a(this.a, i, true);
                        if (f.LBS.b() == i) {
                            this.c.b(System.currentTimeMillis());
                        } else if (f.TAG.b() == i) {
                            b(str);
                        }
                    } else if (3 == i3) {
                        a(this.a, i, true);
                        int parseInt = Integer.parseInt(hVar.b());
                        this.c.a("delayTime", (Object) Long.valueOf((((long) parseInt) * 60000) + System.currentTimeMillis()));
                        com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "please report after " + parseInt + "min");
                    } else {
                        a(this.a, i, false);
                        if (f.TAG.b() == i) {
                            a(str);
                        }
                    }
                } else {
                    com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "salt has expired, need re-fetch");
                    this.b++;
                    this.c.b();
                    a(str, i, i2);
                }
            } else {
                com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "you can not repotr before " + new Date(c2));
                a(this.a, i, false);
                if (f.TAG.b() == i) {
                    a(str);
                }
            }
        } catch (Exception e) {
            a(this.a, i, false);
            if (f.TAG.b() == i) {
                a(str);
            }
            com.huawei.android.pushagent.c.a.e.c(BLocation.TAG, e.getMessage(), e);
        }
    }
}
