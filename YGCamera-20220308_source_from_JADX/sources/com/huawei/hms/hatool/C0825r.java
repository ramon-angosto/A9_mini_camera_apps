package com.huawei.hms.hatool;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.load.Key;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.r */
public class C0825r implements C0827s {

    /* renamed from: a */
    public List<C0823q> f737a;

    /* renamed from: b */
    public C0819o f738b;

    /* renamed from: c */
    public C0821p f739c;

    /* renamed from: d */
    public C0827s f740d;

    /* renamed from: e */
    public String f741e = "";

    /* renamed from: f */
    public String f742f;

    public C0825r(String str) {
        this.f742f = str;
    }

    /* renamed from: a */
    public JSONObject mo13931a() {
        String str;
        List<C0823q> list = this.f737a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f738b == null || this.f739c == null || this.f740d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f738b.mo13931a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a = this.f740d.mo13931a();
            a.put("properties", this.f739c.mo13931a());
            try {
                a.put("events_global_properties", new JSONObject(this.f741e));
            } catch (JSONException unused) {
                a.put("events_global_properties", this.f741e);
            }
            jSONObject2.put("events_common", a);
            JSONArray jSONArray = new JSONArray();
            for (C0823q a2 : this.f737a) {
                JSONObject a3 = a2.mo13931a();
                if (a3 != null) {
                    jSONArray.put(a3);
                } else {
                    C0841y.m1091e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String byteArray2HexStr = HexUtil.byteArray2HexStr(AesCbc.encrypt(C0826r0.m1019a(jSONObject2.toString().getBytes(Key.STRING_CHARSET_NAME)), HexUtil.hexStr2ByteArray(this.f742f)));
                if (TextUtils.isEmpty(byteArray2HexStr)) {
                    C0841y.m1091e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, byteArray2HexStr);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        C0841y.m1091e("hmsSdk", str);
        return null;
    }

    /* renamed from: a */
    public void mo14108a(C0783c1 c1Var) {
        this.f740d = c1Var;
    }

    /* renamed from: a */
    public void mo14109a(C0819o oVar) {
        this.f738b = oVar;
    }

    /* renamed from: a */
    public void mo14110a(C0821p pVar) {
        this.f739c = pVar;
    }

    /* renamed from: a */
    public void mo14111a(String str) {
        if (str != null) {
            this.f741e = str;
        }
    }

    /* renamed from: a */
    public void mo14112a(List<C0823q> list) {
        this.f737a = list;
    }
}
