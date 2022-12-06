package sg.bigo.ads.controller.b;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.a;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.common.d;

final class e implements g, d {
    String a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private boolean m;
    private String n;
    private List<a> o;
    private String p;
    private String q;
    private h r;
    private int s;
    private int t;
    private boolean u;
    private int v;

    e() {
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (this.c == 4 && !jSONObject.has("interstitial_video_style")) {
                    jSONObject = new JSONObject().put("interstitial_video_style", jSONObject);
                }
                this.r = new f(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final String a() {
        return this.b;
    }

    public final void a(Parcel parcel) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l);
        parcel.writeString(this.a);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeString(this.n);
        sg.bigo.ads.common.h.a(parcel, this.o);
        parcel.writeInt(this.s);
        parcel.writeString(this.q);
        h hVar = this.r;
        parcel.writeString(hVar == null ? null : hVar.toString());
        parcel.writeInt(this.u ? 1 : 0);
        parcel.writeInt(this.t);
        parcel.writeInt(this.v);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0145 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(org.json.JSONObject r13) {
        /*
            r12 = this;
            java.lang.String r0 = "parseData error, jsonObject is null."
            r1 = 0
            if (r13 != 0) goto L_0x000b
            java.lang.String r13 = "Slot"
            sg.bigo.ads.common.k.a.a(r1, r13, r0)
            return r1
        L_0x000b:
            r2 = 5
            java.lang.String r3 = "countdown"
            int r2 = r13.optInt(r3, r2)
            r12.d = r2
            r2 = -1
            java.lang.String r3 = "ad_type"
            int r2 = r13.optInt(r3, r2)
            r12.c = r2
            java.lang.String r2 = ""
            java.lang.String r3 = "strategy_id"
            java.lang.String r3 = r13.optString(r3, r2)
            r12.b = r3
            r3 = 15
            java.lang.String r4 = "req_once_load_timeout"
            int r3 = r13.optInt(r4, r3)
            r12.e = r3
            java.lang.String r3 = "media_strategy"
            int r3 = r13.optInt(r3, r1)
            r12.f = r3
            java.lang.String r3 = "webview_enforce_duration"
            int r3 = r13.optInt(r3, r1)
            int r3 = r3 * 1000
            r12.g = r3
            java.lang.String r3 = "video_direction"
            int r3 = r13.optInt(r3, r1)
            r12.h = r3
            int r3 = r12.c
            boolean r3 = sg.bigo.ads.api.core.b.c(r3)
            r4 = 1
            if (r3 != 0) goto L_0x005f
            java.lang.String r3 = "video_replay"
            int r3 = r13.optInt(r3, r4)
            if (r3 != r4) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r3 = r1
            goto L_0x0060
        L_0x005f:
            r3 = r4
        L_0x0060:
            r12.i = r3
            int r3 = r12.c
            boolean r3 = sg.bigo.ads.api.core.b.c(r3)
            if (r3 != 0) goto L_0x0075
            java.lang.String r3 = "video_mute"
            int r3 = r13.optInt(r3, r1)
            if (r3 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r3 = r1
            goto L_0x0076
        L_0x0075:
            r3 = r4
        L_0x0076:
            r12.j = r3
            java.lang.String r3 = "banner_auto_refresh"
            int r3 = r13.optInt(r3, r1)
            if (r3 != r4) goto L_0x0082
            r3 = r4
            goto L_0x0083
        L_0x0082:
            r3 = r1
        L_0x0083:
            r12.k = r3
            r3 = 20
            java.lang.String r5 = "banner_refresh_interval"
            int r3 = r13.optInt(r5, r3)
            r12.l = r3
            java.lang.String r3 = "slot"
            java.lang.String r3 = r13.optString(r3, r2)
            r12.a = r3
            java.lang.String r3 = "state"
            int r3 = r13.optInt(r3, r4)
            if (r3 != r4) goto L_0x00a1
            r3 = r4
            goto L_0x00a2
        L_0x00a1:
            r3 = r1
        L_0x00a2:
            r12.m = r3
            java.lang.String r3 = "placement_id"
            java.lang.String r3 = r13.optString(r3, r2)
            r12.n = r3
            java.lang.String r3 = "express_list"
            org.json.JSONArray r3 = r13.optJSONArray(r3)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r12.o = r5
            if (r3 == 0) goto L_0x0149
            r5 = r1
        L_0x00bc:
            int r6 = r3.length()
            if (r5 >= r6) goto L_0x0149
            org.json.JSONObject r6 = r3.optJSONObject(r5)
            sg.bigo.ads.controller.b.a r7 = new sg.bigo.ads.controller.b.a
            r7.<init>()
            if (r6 != 0) goto L_0x00d3
            java.lang.String r6 = "AdExpress"
            sg.bigo.ads.common.k.a.a(r1, r6, r0)
            goto L_0x013d
        L_0x00d3:
            r8 = 0
            java.lang.String r10 = "id"
            long r10 = r6.optLong(r10, r8)
            r7.a = r10
            java.lang.String r10 = "name"
            java.lang.String r10 = r6.optString(r10, r2)
            r7.b = r10
            java.lang.String r10 = "url"
            java.lang.String r10 = r6.optString(r10, r2)
            r7.c = r10
            java.lang.String r10 = "md5"
            java.lang.String r10 = r6.optString(r10, r2)
            r7.d = r10
            java.lang.String r10 = "style"
            java.lang.String r10 = r6.optString(r10, r2)
            r7.e = r10
            java.lang.String r10 = "ad_types"
            java.lang.String r10 = r6.optString(r10, r2)
            r7.f = r10
            java.lang.String r10 = "file_id"
            java.lang.String r6 = r6.optString(r10, r2)
            r7.g = r6
            long r10 = r7.a
            int r6 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x013d
            java.lang.String r6 = r7.b
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x013d
            java.lang.String r6 = r7.c
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x013d
            java.lang.String r6 = r7.d
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x013d
            java.lang.String r6 = r7.f
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x013d
            java.lang.String r6 = r7.g
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x013d
            r6 = r4
            goto L_0x013e
        L_0x013d:
            r6 = r1
        L_0x013e:
            if (r6 == 0) goto L_0x0145
            java.util.List<sg.bigo.ads.api.a.a> r6 = r12.o
            r6.add(r7)
        L_0x0145:
            int r5 = r5 + 1
            goto L_0x00bc
        L_0x0149:
            java.lang.String r0 = "abflags"
            java.lang.String r0 = r13.optString(r0)
            r12.p = r0
            java.lang.String r0 = "playable"
            int r0 = r13.optInt(r0, r1)
            r12.s = r0
            java.lang.String r0 = "style_id"
            java.lang.String r0 = r13.optString(r0)
            r12.q = r0
            java.lang.String r0 = "interstitial_style_config"
            java.lang.String r0 = r13.optString(r0)
            r12.a((java.lang.String) r0)
            java.lang.String r0 = "banner_multiple_click"
            int r0 = r13.optInt(r0, r4)
            if (r0 != r4) goto L_0x0174
            r0 = r4
            goto L_0x0175
        L_0x0174:
            r0 = r1
        L_0x0175:
            r12.u = r0
            java.lang.String r0 = "companion_render"
            int r0 = r13.optInt(r0, r1)
            r12.t = r0
            java.lang.String r0 = "auc_mode"
            int r13 = r13.optInt(r0, r1)
            r12.v = r13
            boolean r13 = r12.m
            if (r13 != 0) goto L_0x018c
            return r4
        L_0x018c:
            java.lang.String r13 = r12.a
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x019d
            java.lang.String r13 = r12.n
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x019d
            return r4
        L_0x019d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.b.e.a(org.json.JSONObject):boolean");
    }

    public final int b() {
        return this.c;
    }

    public final void b(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        boolean z = true;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readInt() != 0;
        this.l = parcel.readInt();
        this.a = parcel.readString();
        this.m = parcel.readInt() != 0;
        this.n = parcel.readString();
        this.o = sg.bigo.ads.common.h.a(parcel, new d.a<a>() {
            public final /* synthetic */ d a() {
                return new a();
            }
        });
        this.s = sg.bigo.ads.common.h.a(parcel);
        this.q = sg.bigo.ads.common.h.a(parcel, "");
        a(sg.bigo.ads.common.h.a(parcel, ""));
        if (parcel.dataAvail() > 0 && parcel.readInt() == 0) {
            z = false;
        }
        this.u = z;
        this.t = sg.bigo.ads.common.h.a(parcel);
        this.v = sg.bigo.ads.common.h.a(parcel);
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.f;
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return this.h;
    }

    public final boolean g() {
        return this.i;
    }

    public final boolean h() {
        return this.j;
    }

    public final boolean i() {
        return this.k;
    }

    public final int j() {
        return this.l;
    }

    public final String k() {
        return this.a;
    }

    public final boolean l() {
        return this.m;
    }

    public final String m() {
        return this.n;
    }

    public final String n() {
        return this.p;
    }

    public final String o() {
        return this.q;
    }

    public final h p() {
        if (this.r == null) {
            this.r = new f(new JSONObject());
        }
        return this.r;
    }

    public final int q() {
        return this.s;
    }

    public final boolean r() {
        return this.s == 1;
    }

    public final boolean s() {
        return this.t == 1;
    }

    public final boolean t() {
        return this.u;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        List<a> list = this.o;
        if (list != null) {
            for (a next : list) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(next);
            }
        }
        return "{strategyId=" + this.b + ", adType=" + this.c + ", countdown=" + this.d + ", reqTimeout=" + this.e + ", mediaStrategy=" + this.f + ", webViewEnforceDuration=" + this.g + ", videoDirection=" + this.h + ", videoReplay=" + this.i + ", videoMute=" + this.j + ", bannerAutoRefresh=" + this.k + ", bannerRefreshInterval=" + this.l + ", slotId='" + this.a + '\'' + ", state=" + this.m + ", placementId='" + this.n + '\'' + ", express=[" + sb.toString() + "], styleId=" + this.q + ", playable=" + this.s + ", isCompanionRenderSupport=" + this.t + ", aucMode=" + this.v + '}';
    }

    public final int u() {
        return this.v;
    }
}
