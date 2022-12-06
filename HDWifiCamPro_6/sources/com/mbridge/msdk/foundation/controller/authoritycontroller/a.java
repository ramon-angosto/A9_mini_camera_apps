package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.tools.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKAuthorityController */
public class a {
    private static volatile a b;
    public ArrayList<String> a = new ArrayList<>();
    private AuthorityInfoBean c = new AuthorityInfoBean();
    private int d = 3;

    private a() {
        try {
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
                this.c.b(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
                this.c.c(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
                this.c.d(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_OTHER).equals("")) {
                this.c.e(1);
            }
            this.a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public final void a(String str, int i) {
        if (this.c == null) {
            return;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            this.c.b(i);
        } else if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            this.c.c(i);
        } else if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
            this.c.a(i);
        } else if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            this.c.d(i);
        } else if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            this.c.e(i);
        }
    }

    public final AuthorityInfoBean b() {
        AuthorityInfoBean authorityInfoBean = this.c;
        if (authorityInfoBean != null) {
            return authorityInfoBean;
        }
        return new AuthorityInfoBean().a(1);
    }

    private int b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String b2 = com.mbridge.msdk.foundation.a.a.a.a().b(str);
                if (TextUtils.isEmpty(b2)) {
                    return 0;
                }
                return Integer.parseInt(b2);
            }
        } catch (Exception e) {
            q.d("SDKAuthorityController", e.getMessage());
        }
        return 0;
    }

    private int c(String str) {
        com.mbridge.msdk.b.a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (b2 == null) {
            b2 = b.a().b();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return b2.m();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return b2.n();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return b2.l();
        }
        return -1;
    }

    public final boolean a(String str) {
        boolean z;
        boolean z2;
        com.mbridge.msdk.b.a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (b2 == null) {
            b2 = b.a().b();
            z = true;
        } else {
            z = false;
        }
        int o = b2.o();
        if (o != 0 ? !(o == 1 && c(str) == 1) : !(b(str) == 1 && c(str) == 1)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z2 = b(str) == 1;
        }
        if (!str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) || a().d != 2) {
            return z2;
        }
        return !b2.af() && !z && b(str) == 1;
    }

    public final String c() {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.a.size(); i++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.a.get(i)));
                jSONObject.put("client_status", b(this.a.get(i)));
                jSONObject.put("server_status", c(this.a.get(i)));
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final void a(int i) {
        if (this.c != null) {
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
            }
            this.d = i2;
        }
    }

    public final boolean d() {
        int i = this.d;
        return i == 1 || i == 3;
    }

    public final void b(int i) {
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DNT, i);
    }

    public final int e() {
        return this.d;
    }
}
