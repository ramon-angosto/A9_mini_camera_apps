package com.mbridge.msdk.foundation.same.net.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.d.f;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.g.c;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.same.net.m;
import com.mbridge.msdk.foundation.same.net.n;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.CustomInfoManager;
import java.io.File;
import org.json.JSONArray;

/* compiled from: CommonAsyncHttpRequest */
public class b {
    private static final String b = b.class.getSimpleName();
    protected Context a;

    public b(Context context) {
        if (context == null) {
            this.a = a.e().g();
        } else {
            this.a = context.getApplicationContext();
        }
    }

    public void a(String str, d dVar) {
        if (dVar != null) {
            dVar.a("open", com.mbridge.msdk.foundation.same.a.u);
            String a2 = Aa.a();
            if (a2 == null) {
                a2 = "";
            }
            dVar.a("channel", a2);
            dVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.a().b() + "");
            String str2 = dVar.b().get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (str2 != null) {
                String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str2, str);
                if (!TextUtils.isEmpty(customInfoByUnitId)) {
                    dVar.a("ch_info", customInfoByUnitId);
                }
                d e = com.mbridge.msdk.b.b.a().e(a.e().h(), str2);
                if (e != null && !TextUtils.isEmpty(e.a())) {
                    dVar.a("u_stid", e.a());
                }
            }
        }
    }

    public final void a(int i, String str, d dVar, e eVar) {
        a(i, str, dVar, (l) new com.mbridge.msdk.foundation.same.net.b(), eVar);
    }

    public final void a(int i, String str, d dVar, l lVar, e eVar) {
        i iVar;
        if (dVar == null) {
            try {
                dVar = new d();
            } catch (Exception e) {
                q.a(b, e.getMessage());
            }
        }
        a(str, dVar);
        e.c(dVar);
        String str2 = dVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        dVar.a(CampaignEx.JSON_KEY_ST_TS, currentTimeMillis + "");
        dVar.a("st", SameMD5.getMD5(currentTimeMillis + str2));
        k a2 = c.a().a(dVar);
        if (!(a2 == null || eVar == null)) {
            eVar.a(a2);
            return;
        }
        String str3 = str + "?" + dVar.toString();
        if (i == 0) {
            iVar = new f(0, str3, (String) null, eVar);
        } else if (i == 1) {
            iVar = new com.mbridge.msdk.foundation.same.net.d.d(0, str3, (String) null, eVar);
        } else if (i != 2) {
            iVar = null;
        } else {
            iVar = new com.mbridge.msdk.foundation.same.net.d.c(0, str3, (String) null, eVar);
        }
        if (iVar != null) {
            iVar.a(lVar);
            iVar.b(iVar.g());
            n.a(iVar);
        }
    }

    public static void a(File file, String str, e eVar) {
        n.a().a(file, str, eVar);
    }

    public final void b(int i, String str, d dVar, e eVar) {
        String str2 = dVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        dVar.a(CampaignEx.JSON_KEY_ST_TS, currentTimeMillis + "");
        dVar.a("st", SameMD5.getMD5(currentTimeMillis + str2));
        b(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar);
    }

    public final void a(int i, String str, d dVar, e eVar, l lVar) {
        String str2 = dVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        dVar.a(CampaignEx.JSON_KEY_ST_TS, currentTimeMillis + "");
        dVar.a("st", SameMD5.getMD5(currentTimeMillis + str2));
        if (lVar != null) {
            b(i, str, dVar, lVar, eVar);
            return;
        }
        b(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar);
    }

    public final void c(int i, String str, d dVar, e eVar) {
        b(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar);
    }

    private void b(int i, String str, d dVar, l lVar, e eVar) {
        String str2;
        if (dVar == null) {
            try {
                dVar = new d();
            } catch (Exception e) {
                q.a(b, e.getMessage());
            }
        }
        a(str, dVar);
        e.c(dVar);
        if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.c().a)) {
            com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(a.e().h());
            int i2 = 0;
            if (b2 != null) {
                i2 = b2.V();
                str2 = b2.ak();
            } else {
                str2 = "UNKNOWN";
            }
            dVar.a("country_code", str2);
            if (i2 != 2) {
                if (i2 == 1) {
                    m.a().a(dVar.toString(), eVar);
                    return;
                }
            } else {
                return;
            }
        } else if (str.contains(com.mbridge.msdk.foundation.same.net.g.d.c().h)) {
            if (dVar != null) {
                str = str + "?" + dVar.toString();
            }
            JSONArray b3 = com.mbridge.msdk.foundation.db.a.a.a().b();
            if (b3 != null) {
                dVar = new d();
                dVar.a(d.e, b3.toString());
            }
        }
        i iVar = null;
        if (i == 0) {
            iVar = new f(1, str, dVar.toString(), eVar);
            iVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
        } else if (i == 1) {
            iVar = new com.mbridge.msdk.foundation.same.net.d.d(1, str, dVar.toString(), eVar);
            iVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
        } else if (i == 2) {
            iVar = new com.mbridge.msdk.foundation.same.net.d.c(1, str, dVar.toString(), eVar);
            iVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
        }
        if (iVar != null) {
            iVar.a(lVar);
            n.a(iVar);
        }
    }
}
