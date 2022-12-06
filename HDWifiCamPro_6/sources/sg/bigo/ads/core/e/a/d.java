package sg.bigo.ads.core.e.a;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.utils.p;

public final class d {
    int a;
    String b;
    JSONObject c;
    private String d;
    private String e;
    private String[] f;
    private String[] g;
    private String h;
    private int i;
    private final Map<String, String> j;
    private e k;

    d(JSONObject jSONObject) {
        this(jSONObject, (e) null);
    }

    public d(JSONObject jSONObject, e eVar) {
        this.k = eVar;
        this.c = jSONObject;
        this.j = new HashMap();
        this.a = jSONObject.optInt("type", 0);
        this.d = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
        this.b = jSONObject.optString("name", "");
        this.e = jSONObject.optString("uuid", "");
        this.i = jSONObject.optInt("expired");
        JSONArray optJSONArray = jSONObject.optJSONArray("reg");
        if (optJSONArray != null) {
            this.f = new String[optJSONArray.length()];
            this.g = new String[optJSONArray.length()];
            a(optJSONArray);
        }
        this.h = jSONObject.optString("real_url");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
        return java.lang.String.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:?, code lost:
        return java.lang.String.valueOf(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            switch(r0) {
                case -2138759690: goto L_0x0245;
                case -2076227591: goto L_0x023a;
                case -1795462070: goto L_0x022f;
                case -1600030548: goto L_0x0224;
                case -1273393189: goto L_0x0219;
                case -1229750878: goto L_0x020e;
                case -1182905495: goto L_0x0203;
                case -1174888717: goto L_0x01f9;
                case -1007979832: goto L_0x01ee;
                case -986522696: goto L_0x01e2;
                case -986522112: goto L_0x01d6;
                case -934795532: goto L_0x01ca;
                case -906980142: goto L_0x01be;
                case -820075192: goto L_0x01b2;
                case -793620671: goto L_0x01a7;
                case -777008198: goto L_0x019b;
                case -693230854: goto L_0x018f;
                case -613897138: goto L_0x0183;
                case -517414224: goto L_0x0177;
                case -424587677: goto L_0x016b;
                case 3556: goto L_0x015f;
                case 99677: goto L_0x0153;
                case 104582: goto L_0x0147;
                case 106905: goto L_0x013b;
                case 106911: goto L_0x012f;
                case 107301: goto L_0x0123;
                case 107855: goto L_0x0117;
                case 108957: goto L_0x010b;
                case 115792: goto L_0x00ff;
                case 3053931: goto L_0x00f3;
                case 3165045: goto L_0x00e8;
                case 3184265: goto L_0x00dd;
                case 3197719: goto L_0x00d1;
                case 3236040: goto L_0x00c5;
                case 3236474: goto L_0x00b9;
                case 25209764: goto L_0x00ad;
                case 55126294: goto L_0x00a2;
                case 92714869: goto L_0x0096;
                case 104069929: goto L_0x008a;
                case 109254796: goto L_0x007e;
                case 109757585: goto L_0x0072;
                case 440309782: goto L_0x0067;
                case 957831062: goto L_0x005b;
                case 1139786014: goto L_0x0050;
                case 1139954915: goto L_0x0044;
                case 1505024451: goto L_0x0039;
                case 1583758243: goto L_0x002d;
                case 1793985248: goto L_0x0021;
                case 1845546289: goto L_0x0015;
                case 1948386846: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0250
        L_0x0009:
            java.lang.String r0 = "sdk_ver"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 22
            goto L_0x0251
        L_0x0015:
            java.lang.String r0 = "new_uid"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 47
            goto L_0x0251
        L_0x0021:
            java.lang.String r0 = "loss_reason"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 39
            goto L_0x0251
        L_0x002d:
            java.lang.String r0 = "action_type"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 31
            goto L_0x0251
        L_0x0039:
            java.lang.String r0 = "local_timestamp_ms"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 1
            goto L_0x0251
        L_0x0044:
            java.lang.String r0 = "pkg_sver"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 40
            goto L_0x0251
        L_0x0050:
            java.lang.String r0 = "pkg_name"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 7
            goto L_0x0251
        L_0x005b:
            java.lang.String r0 = "country"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 24
            goto L_0x0251
        L_0x0067:
            java.lang.String r0 = "advertising_id"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 4
            goto L_0x0251
        L_0x0072:
            java.lang.String r0 = "state"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 25
            goto L_0x0251
        L_0x007e:
            java.lang.String r0 = "scene"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 34
            goto L_0x0251
        L_0x008a:
            java.lang.String r0 = "model"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 15
            goto L_0x0251
        L_0x0096:
            java.lang.String r0 = "af_id"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 29
            goto L_0x0251
        L_0x00a2:
            java.lang.String r0 = "timestamp"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 0
            goto L_0x0251
        L_0x00ad:
            java.lang.String r0 = "device_id"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 49
            goto L_0x0251
        L_0x00b9:
            java.lang.String r0 = "imsi"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 42
            goto L_0x0251
        L_0x00c5:
            java.lang.String r0 = "imei"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 41
            goto L_0x0251
        L_0x00d1:
            java.lang.String r0 = "hdid"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 44
            goto L_0x0251
        L_0x00dd:
            java.lang.String r0 = "guid"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 2
            goto L_0x0251
        L_0x00e8:
            java.lang.String r0 = "gaid"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 3
            goto L_0x0251
        L_0x00f3:
            java.lang.String r0 = "city"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 26
            goto L_0x0251
        L_0x00ff:
            java.lang.String r0 = "uid"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 48
            goto L_0x0251
        L_0x010b:
            java.lang.String r0 = "net"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 20
            goto L_0x0251
        L_0x0117:
            java.lang.String r0 = "mac"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 43
            goto L_0x0251
        L_0x0123:
            java.lang.String r0 = "lng"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 28
            goto L_0x0251
        L_0x012f:
            java.lang.String r0 = "lat"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 27
            goto L_0x0251
        L_0x013b:
            java.lang.String r0 = "lan"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 19
            goto L_0x0251
        L_0x0147:
            java.lang.String r0 = "isp"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 16
            goto L_0x0251
        L_0x0153:
            java.lang.String r0 = "dpi"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 18
            goto L_0x0251
        L_0x015f:
            java.lang.String r0 = "os"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 11
            goto L_0x0251
        L_0x016b:
            java.lang.String r0 = "first_bidder"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 38
            goto L_0x0251
        L_0x0177:
            java.lang.String r0 = "pkg_ver"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 8
            goto L_0x0251
        L_0x0183:
            java.lang.String r0 = "support_om"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 30
            goto L_0x0251
        L_0x018f:
            java.lang.String r0 = "first_price"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 37
            goto L_0x0251
        L_0x019b:
            java.lang.String r0 = "click_prop"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 32
            goto L_0x0251
        L_0x01a7:
            java.lang.String r0 = "app_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 6
            goto L_0x0251
        L_0x01b2:
            java.lang.String r0 = "vendor"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 14
            goto L_0x0251
        L_0x01be:
            java.lang.String r0 = "sdk_vc"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 23
            goto L_0x0251
        L_0x01ca:
            java.lang.String r0 = "region"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 45
            goto L_0x0251
        L_0x01d6:
            java.lang.String r0 = "pkg_vc"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 9
            goto L_0x0251
        L_0x01e2:
            java.lang.String r0 = "pkg_ch"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 10
            goto L_0x0251
        L_0x01ee:
            java.lang.String r0 = "os_ver"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 12
            goto L_0x0251
        L_0x01f9:
            java.lang.String r0 = "gps_adid"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 5
            goto L_0x0251
        L_0x0203:
            java.lang.String r0 = "os_lang"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 13
            goto L_0x0251
        L_0x020e:
            java.lang.String r0 = "sec_bidder"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 36
            goto L_0x0251
        L_0x0219:
            java.lang.String r0 = "sec_price"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 35
            goto L_0x0251
        L_0x0224:
            java.lang.String r0 = "resolution"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 17
            goto L_0x0251
        L_0x022f:
            java.lang.String r0 = "express_id"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 33
            goto L_0x0251
        L_0x023a:
            java.lang.String r0 = "timezone"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 21
            goto L_0x0251
        L_0x0245:
            java.lang.String r0 = "regist_time"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0250
            r0 = 46
            goto L_0x0251
        L_0x0250:
            r0 = -1
        L_0x0251:
            java.lang.String r1 = ""
            switch(r0) {
                case 0: goto L_0x0333;
                case 1: goto L_0x032e;
                case 2: goto L_0x0327;
                case 3: goto L_0x0320;
                case 4: goto L_0x0320;
                case 5: goto L_0x0320;
                case 6: goto L_0x0319;
                case 7: goto L_0x0312;
                case 8: goto L_0x0307;
                case 9: goto L_0x02fc;
                case 10: goto L_0x02f5;
                case 11: goto L_0x02ee;
                case 12: goto L_0x02e7;
                case 13: goto L_0x02e0;
                case 14: goto L_0x02d9;
                case 15: goto L_0x02d2;
                case 16: goto L_0x02ca;
                case 17: goto L_0x02c2;
                case 18: goto L_0x02bb;
                case 19: goto L_0x02e0;
                case 20: goto L_0x02b3;
                case 21: goto L_0x02ab;
                case 22: goto L_0x02a3;
                case 23: goto L_0x029f;
                case 24: goto L_0x0297;
                case 25: goto L_0x028f;
                case 26: goto L_0x0287;
                case 27: goto L_0x027f;
                case 28: goto L_0x0277;
                case 29: goto L_0x026f;
                case 30: goto L_0x026b;
                case 31: goto L_0x0258;
                case 32: goto L_0x0258;
                case 33: goto L_0x0258;
                case 34: goto L_0x0258;
                case 35: goto L_0x0258;
                case 36: goto L_0x0258;
                case 37: goto L_0x0258;
                case 38: goto L_0x0258;
                case 39: goto L_0x0258;
                default: goto L_0x0256;
            }
        L_0x0256:
            goto L_0x033b
        L_0x0258:
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.j
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x033b
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.j
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r1 = r3
            goto L_0x033b
        L_0x026b:
            java.lang.String r1 = "1"
            goto L_0x033b
        L_0x026f:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.A()
            goto L_0x033b
        L_0x0277:
            sg.bigo.ads.common.e r3 = r2.k
            int r3 = r3.r()
            goto L_0x0302
        L_0x027f:
            sg.bigo.ads.common.e r3 = r2.k
            int r3 = r3.q()
            goto L_0x0302
        L_0x0287:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.w()
            goto L_0x033b
        L_0x028f:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.v()
            goto L_0x033b
        L_0x0297:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.s()
            goto L_0x033b
        L_0x029f:
            java.lang.String r1 = "20401"
            goto L_0x033b
        L_0x02a3:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.x()
            goto L_0x033b
        L_0x02ab:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.o()
            goto L_0x033b
        L_0x02b3:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.n()
            goto L_0x033b
        L_0x02bb:
            sg.bigo.ads.common.e r3 = r2.k
            int r3 = r3.m()
            goto L_0x0302
        L_0x02c2:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.l()
            goto L_0x033b
        L_0x02ca:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.k()
            goto L_0x033b
        L_0x02d2:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.j()
            goto L_0x033b
        L_0x02d9:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.i()
            goto L_0x033b
        L_0x02e0:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.h()
            goto L_0x033b
        L_0x02e7:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.g()
            goto L_0x033b
        L_0x02ee:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.f()
            goto L_0x033b
        L_0x02f5:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.e()
            goto L_0x033b
        L_0x02fc:
            sg.bigo.ads.common.e r3 = r2.k
            int r3 = r3.d()
        L_0x0302:
            java.lang.String r1 = java.lang.String.valueOf(r3)
            goto L_0x033b
        L_0x0307:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r3 = r3.c()
            java.lang.String r1 = java.lang.String.valueOf(r3)
            goto L_0x033b
        L_0x0312:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.b()
            goto L_0x033b
        L_0x0319:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.a()
            goto L_0x033b
        L_0x0320:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.z()
            goto L_0x033b
        L_0x0327:
            sg.bigo.ads.common.e r3 = r2.k
            java.lang.String r1 = r3.B()
            goto L_0x033b
        L_0x032e:
            long r0 = java.lang.System.currentTimeMillis()
            goto L_0x0337
        L_0x0333:
            long r0 = sg.bigo.ads.common.utils.p.a()
        L_0x0337:
            java.lang.String r1 = java.lang.String.valueOf(r0)
        L_0x033b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.e.a.d.a(java.lang.String):java.lang.String");
    }

    private void a(JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.optJSONObject(i2) != null) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                this.f[i2] = optJSONObject.optString("token", "");
                this.g[i2] = optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
            }
        }
    }

    private String f() {
        if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.b)) {
            return "";
        }
        String trim = this.d.trim();
        if (!(this.f == null || this.g == null || this.k == null)) {
            for (int i2 = 0; i2 < this.f.length; i2++) {
                String a2 = a(this.g[i2]);
                String str = this.f[i2];
                if (a2 == null) {
                    a2 = "";
                }
                trim = trim.replace(str, a2);
            }
        }
        return trim;
    }

    public final void a(String str, String str2) {
        this.j.put(str, str2);
    }

    public final boolean a() {
        return "bigo_tracker".equals(this.e);
    }

    public final boolean b() {
        return this.i != 0 && p.a() / 1000 > ((long) this.i);
    }

    public final boolean c() {
        return this.a == 0;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.h)) {
            e();
            a.a(0, 3, "ThirdTrack", "getRealUrl url = " + this.h);
        }
        return this.h;
    }

    public final void e() {
        this.h = f();
        a.a(0, 3, "ThirdTrack", "updateRealUrl url = " + this.h);
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            try {
                jSONObject.putOpt("real_url", this.h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final String toString() {
        return "type=" + this.a + ",name=" + this.b + ",url=" + this.h;
    }
}
