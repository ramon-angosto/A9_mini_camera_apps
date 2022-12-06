package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.push.k */
/* compiled from: PushSelfShowMessage */
public class C0881k {

    /* renamed from: A */
    public String f885A = "";

    /* renamed from: B */
    public int f886B;

    /* renamed from: C */
    public String f887C = "";

    /* renamed from: D */
    public String f888D;

    /* renamed from: E */
    public String f889E = "";

    /* renamed from: F */
    public String f890F = "";

    /* renamed from: a */
    public String f891a = "";

    /* renamed from: b */
    public int f892b;

    /* renamed from: c */
    public String f893c;

    /* renamed from: d */
    public String f894d;

    /* renamed from: e */
    public String f895e = "";

    /* renamed from: f */
    public String f896f = "";

    /* renamed from: g */
    public String f897g = "";

    /* renamed from: h */
    public String f898h = "";

    /* renamed from: i */
    public String f899i = "";

    /* renamed from: j */
    public String f900j = "";

    /* renamed from: k */
    public String f901k = "";

    /* renamed from: l */
    public String f902l;

    /* renamed from: m */
    public String f903m;

    /* renamed from: n */
    public String f904n;

    /* renamed from: o */
    public String f905o;

    /* renamed from: p */
    public String f906p;

    /* renamed from: q */
    public String f907q = "";

    /* renamed from: r */
    public String f908r;

    /* renamed from: s */
    public String f909s;

    /* renamed from: t */
    public int f910t = C0884n.STYLE_DEFAULT.ordinal();

    /* renamed from: u */
    public String f911u = "";

    /* renamed from: v */
    public String f912v = "";

    /* renamed from: w */
    public String f913w = "";

    /* renamed from: x */
    public int f914x = 0;

    /* renamed from: y */
    public int f915y = 0;

    /* renamed from: z */
    public String f916z;

    public C0881k(byte[] bArr, byte[] bArr2) {
        this.f908r = new String(bArr, C0896w.f942a);
        this.f909s = new String(bArr2, C0896w.f942a);
    }

    /* renamed from: a */
    public final JSONObject mo14292a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put("group", this.f891a);
        jSONObject2.put(RemoteMessageConst.Notification.TAG, this.f885A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f914x);
        jSONObject2.put(RemoteMessageConst.Notification.VISIBILITY, this.f915y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.f916z);
        return jSONObject2;
    }

    /* renamed from: b */
    public final JSONObject mo14296b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cmd", this.f897g);
        jSONObject2.put(RemoteMessageConst.Notification.CONTENT, this.f898h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f899i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f900j);
        jSONObject2.put("notifySummary", this.f901k);
        jSONObject2.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
        return jSONObject2;
    }

    /* renamed from: c */
    public final void mo14298c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(string) || string.length() >= 48) {
                this.f894d = string.substring(0, 48);
                return;
            }
            int length = 48 - string.length();
            for (int i = 0; i < length; i++) {
                sb.append("0");
            }
            sb.append(string);
            this.f894d = sb.toString();
        }
    }

    /* renamed from: d */
    public final boolean mo14300d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f903m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f893c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.f902l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.m1374d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    /* renamed from: e */
    public final boolean mo14302e(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MSGID)) {
            Object obj = jSONObject.get(RemoteMessageConst.MSGID);
            if (obj instanceof String) {
                this.f895e = (String) obj;
                return true;
            } else if (!(obj instanceof Integer)) {
                return true;
            } else {
                this.f895e = String.valueOf(((Integer) obj).intValue());
                return true;
            }
        } else {
            HMSLog.m1379i("PushSelfShowLog", "msgId == null");
            return false;
        }
    }

    /* renamed from: f */
    public final boolean mo14304f(JSONObject jSONObject) {
        HMSLog.m1374d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.f910t = jSONObject2.getInt("style");
            }
            this.f911u = jSONObject2.optString("bigTitle");
            this.f912v = jSONObject2.optString("bigContent");
            this.f889E = jSONObject2.optString(RemoteMessageConst.Notification.ICON);
            return true;
        } catch (JSONException e) {
            HMSLog.m1379i("PushSelfShowLog", e.toString());
            return false;
        }
    }

    /* renamed from: g */
    public final void mo14306g(JSONObject jSONObject) {
        this.f891a = jSONObject.optString("group");
        HMSLog.m1374d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f891a);
        this.f914x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.m1374d("PushSelfShowLog", "autoCancel: " + this.f914x);
        this.f915y = jSONObject.optInt(RemoteMessageConst.Notification.VISIBILITY, 0);
        this.f916z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.f885A = jSONObject.optString(RemoteMessageConst.Notification.TAG);
    }

    /* renamed from: h */
    public final boolean mo14308h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.f892b = jSONObject2.getInt("autoClear");
            } else {
                this.f892b = 0;
            }
            if (!"app".equals(this.f897g)) {
                if (!"cosa".equals(this.f897g)) {
                    if ("url".equals(this.f897g)) {
                        mo14314k(jSONObject2);
                        return true;
                    } else if (!"rp".equals(this.f897g)) {
                        return true;
                    } else {
                        mo14312j(jSONObject2);
                        return true;
                    }
                }
            }
            mo14300d(jSONObject2);
            return true;
        } catch (Exception e) {
            HMSLog.m1378e("PushSelfShowLog", "ParseParam error ", (Throwable) e);
            return false;
        }
    }

    /* renamed from: i */
    public final boolean mo14310i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f897g = jSONObject2.getString("cmd");
            this.f898h = jSONObject2.optString(RemoteMessageConst.Notification.CONTENT);
            this.f899i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f900j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f901k = jSONObject2.optString("notifySummary");
            this.f888D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || mo14304f(jSONObject2)) && jSONObject2.has(RemoteMessageConst.MessageBody.PARAM)) {
                return mo14308h(jSONObject2);
            }
        }
        return false;
    }

    /* renamed from: j */
    public final boolean mo14312j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.f902l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            HMSLog.m1374d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        this.f905o = jSONObject.getString("rpl");
        this.f906p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.f907q = jSONObject.getString("rpct");
        return true;
    }

    /* renamed from: k */
    public final boolean mo14314k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("url")) {
            this.f904n = jSONObject.getString("url");
            if (jSONObject.has("appPackageName")) {
                this.f902l = jSONObject.getString("appPackageName");
            }
            if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
                return true;
            }
            this.f905o = jSONObject.getString("rpl");
            this.f906p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.f907q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.m1374d("PushSelfShowLog", "url is null");
        return false;
    }

    /* renamed from: l */
    public String mo14315l() {
        return this.f891a;
    }

    /* renamed from: m */
    public String mo14316m() {
        return this.f889E;
    }

    /* renamed from: n */
    public String mo14317n() {
        return this.f893c;
    }

    /* renamed from: o */
    public byte[] mo14318o() {
        try {
            return mo14292a(mo14293a(mo14296b(mo14325v()), mo14321r())).toString().getBytes(C0896w.f942a);
        } catch (JSONException e) {
            HMSLog.m1378e("PushSelfShowLog", "getMsgData failed JSONException:", (Throwable) e);
            return new byte[0];
        }
    }

    /* renamed from: p */
    public String mo14319p() {
        HMSLog.m1374d("PushSelfShowLog", "msgId =" + this.f895e);
        return this.f895e;
    }

    /* renamed from: q */
    public String mo14320q() {
        return this.f885A;
    }

    /* renamed from: r */
    public final JSONObject mo14321r() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.f910t);
        jSONObject.put("bigTitle", this.f911u);
        jSONObject.put("bigContent", this.f912v);
        jSONObject.put("bigPic", this.f913w);
        return jSONObject;
    }

    /* renamed from: s */
    public int mo14322s() {
        return this.f886B;
    }

    /* renamed from: t */
    public String mo14323t() {
        return this.f901k;
    }

    /* renamed from: u */
    public String mo14324u() {
        return this.f900j;
    }

    /* renamed from: v */
    public final JSONObject mo14325v() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f892b);
        jSONObject.put("url", this.f904n);
        jSONObject.put("rpl", this.f905o);
        jSONObject.put("rpt", this.f906p);
        jSONObject.put("rpct", this.f907q);
        jSONObject.put("appPackageName", this.f902l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f903m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f893c);
        return jSONObject;
    }

    /* renamed from: w */
    public int mo14326w() {
        return this.f910t;
    }

    /* renamed from: x */
    public String mo14327x() {
        return this.f888D;
    }

    /* renamed from: y */
    public byte[] mo14328y() {
        return this.f909s.getBytes(C0896w.f942a);
    }

    /* renamed from: z */
    public boolean mo14329z() {
        try {
            if (TextUtils.isEmpty(this.f908r)) {
                HMSLog.m1374d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f908r);
            mo14306g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!mo14302e(jSONObject2)) {
                return false;
            }
            this.f896f = jSONObject2.optString("dispPkgName");
            mo14298c(jSONObject2);
            this.f886B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.f887C = jSONObject2.optString(RemoteMessageConst.DATA);
            this.f890F = jSONObject2.optString("analyticInfo");
            return mo14310i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.m1374d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e) {
            HMSLog.m1374d("PushSelfShowLog", e.toString());
            return false;
        }
    }

    /* renamed from: a */
    public final JSONObject mo14293a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f896f);
        jSONObject3.put(RemoteMessageConst.MSGID, this.f895e);
        jSONObject3.put("ap", this.f894d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.f886B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.f888D);
        jSONObject3.put(RemoteMessageConst.DATA, this.f887C);
        return jSONObject3;
    }

    /* renamed from: b */
    public String mo14295b() {
        return this.f890F;
    }

    /* renamed from: d */
    public String mo14299d() {
        return this.f902l;
    }

    /* renamed from: g */
    public String mo14305g() {
        return this.f912v;
    }

    /* renamed from: e */
    public int mo14301e() {
        return this.f914x;
    }

    /* renamed from: f */
    public int mo14303f() {
        return this.f892b;
    }

    /* renamed from: j */
    public String mo14311j() {
        return this.f898h;
    }

    /* renamed from: c */
    public String mo14297c() {
        return this.f894d;
    }

    /* renamed from: k */
    public String mo14313k() {
        return this.f896f;
    }

    /* renamed from: h */
    public String mo14307h() {
        return this.f911u;
    }

    /* renamed from: i */
    public String mo14309i() {
        return this.f897g;
    }

    /* renamed from: a */
    public String mo14291a() {
        return this.f903m;
    }

    /* renamed from: a */
    public void mo14294a(int i) {
        this.f886B = i;
    }
}
