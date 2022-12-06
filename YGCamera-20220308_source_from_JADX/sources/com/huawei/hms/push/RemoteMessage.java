package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new C0872b();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* renamed from: a */
    public static final String[] f835a = new String[0];

    /* renamed from: b */
    public static final int[] f836b = new int[0];

    /* renamed from: c */
    public static final long[] f837c = new long[0];

    /* renamed from: d */
    public static final HashMap<String, Object> f838d = new HashMap<>(8);

    /* renamed from: e */
    public static final HashMap<String, Object> f839e = new HashMap<>(8);

    /* renamed from: f */
    public static final HashMap<String, Object> f840f = new HashMap<>(8);

    /* renamed from: g */
    public static final HashMap<String, Object> f841g = new HashMap<>(8);

    /* renamed from: h */
    public static final HashMap<String, Object> f842h = new HashMap<>(3);

    /* renamed from: i */
    public Bundle f843i;

    /* renamed from: j */
    public Notification f844j;

    public static class Builder {

        /* renamed from: a */
        public final Bundle f845a = new Bundle();

        /* renamed from: b */
        public final Map<String, String> f846b = new HashMap();

        public Builder(String str) {
            this.f845a.putString(RemoteMessageConst.f875TO, str);
        }

        public Builder addData(String str, String str2) {
            if (str != null) {
                this.f846b.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("add data failed, key is null.");
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry next : this.f846b.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
                try {
                    String jSONObject2 = jSONObject.toString();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(RemoteMessageConst.COLLAPSE_KEY, this.f845a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject3.put(RemoteMessageConst.TTL, this.f845a.getInt(RemoteMessageConst.TTL));
                    jSONObject3.put(RemoteMessageConst.SEND_MODE, this.f845a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject3.put(RemoteMessageConst.RECEIPT_MODE, this.f845a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject4.put(RemoteMessageConst.DATA, jSONObject2);
                    }
                    jSONObject4.put(RemoteMessageConst.MSGID, this.f845a.getString(RemoteMessageConst.MSGID));
                    jSONObject3.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject4);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject3.toString().getBytes(C0896w.f942a));
                    bundle.putString(RemoteMessageConst.f875TO, this.f845a.getString(RemoteMessageConst.f875TO));
                    bundle.putString("message_type", this.f845a.getString("message_type"));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.m1380w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.m1380w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f846b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f845a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f846b.clear();
            for (Map.Entry next : map.entrySet()) {
                this.f846b.put(next.getKey(), next.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f845a.putString(RemoteMessageConst.MSGID, str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f845a.putString("message_type", str);
            return this;
        }

        public Builder setReceiptMode(int i) {
            if (i == 1 || i == 0) {
                this.f845a.putInt(RemoteMessageConst.RECEIPT_MODE, i);
                return this;
            }
            throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
        }

        public Builder setSendMode(int i) {
            if (i == 0 || i == 1) {
                this.f845a.putInt(RemoteMessageConst.SEND_MODE, i);
                return this;
            }
            throw new IllegalArgumentException("send mode can only be 0 or 1.");
        }

        public Builder setTtl(int i) {
            if (i < 1 || i > 1296000) {
                throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            this.f845a.putInt(RemoteMessageConst.TTL, i);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification implements Serializable {

        /* renamed from: A */
        public final long[] f847A;

        /* renamed from: B */
        public final String f848B;

        /* renamed from: a */
        public final String f849a;

        /* renamed from: b */
        public final String f850b;

        /* renamed from: c */
        public final String[] f851c;

        /* renamed from: d */
        public final String f852d;

        /* renamed from: e */
        public final String f853e;

        /* renamed from: f */
        public final String[] f854f;

        /* renamed from: g */
        public final String f855g;

        /* renamed from: h */
        public final String f856h;

        /* renamed from: i */
        public final String f857i;

        /* renamed from: j */
        public final String f858j;

        /* renamed from: k */
        public final String f859k;

        /* renamed from: l */
        public final String f860l;

        /* renamed from: m */
        public final String f861m;

        /* renamed from: n */
        public final Uri f862n;

        /* renamed from: o */
        public final int f863o;

        /* renamed from: p */
        public final String f864p;

        /* renamed from: q */
        public final int f865q;

        /* renamed from: r */
        public final int f866r;

        /* renamed from: s */
        public final int f867s;

        /* renamed from: t */
        public final int[] f868t;

        /* renamed from: u */
        public final String f869u;

        /* renamed from: v */
        public final int f870v;

        /* renamed from: w */
        public final String f871w;

        /* renamed from: x */
        public final int f872x;

        /* renamed from: y */
        public final String f873y;

        /* renamed from: z */
        public final String f874z;

        public /* synthetic */ Notification(Bundle bundle, C0872b bVar) {
            this(bundle);
        }

        /* renamed from: a */
        public final Integer mo14251a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.m1380w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return mo14251a(this.f871w);
        }

        public String getBody() {
            return this.f852d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f854f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f853e;
        }

        public String getChannelId() {
            return this.f861m;
        }

        public String getClickAction() {
            return this.f859k;
        }

        public String getColor() {
            return this.f858j;
        }

        public String getIcon() {
            return this.f855g;
        }

        public Uri getImageUrl() {
            String str = this.f864p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return mo14251a(this.f873y);
        }

        public String getIntentUri() {
            return this.f860l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.f868t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.f862n;
        }

        public int getNotifyId() {
            return this.f863o;
        }

        public String getSound() {
            return this.f856h;
        }

        public String getTag() {
            return this.f857i;
        }

        public String getTicker() {
            return this.f874z;
        }

        public String getTitle() {
            return this.f849a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f851c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f850b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.f847A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return mo14251a(this.f848B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.f869u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f869u));
                } catch (ParseException unused) {
                    HMSLog.m1380w("RemoteMessage", "ParseException: parse when failed.");
                } catch (StringIndexOutOfBoundsException unused2) {
                    HMSLog.m1380w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.f872x == 1;
        }

        public boolean isDefaultLight() {
            return this.f865q == 1;
        }

        public boolean isDefaultSound() {
            return this.f866r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.f867s == 1;
        }

        public boolean isLocalOnly() {
            return this.f870v == 1;
        }

        public Notification(Bundle bundle) {
            this.f849a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f852d = bundle.getString(RemoteMessageConst.Notification.CONTENT);
            this.f850b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f853e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f851c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f854f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f855g = bundle.getString(RemoteMessageConst.Notification.ICON);
            this.f858j = bundle.getString(RemoteMessageConst.Notification.COLOR);
            this.f856h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f857i = bundle.getString(RemoteMessageConst.Notification.TAG);
            this.f861m = bundle.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            this.f859k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f860l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f863o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString("url");
            this.f862n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.f864p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f865q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f866r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f867s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.f868t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f869u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.f870v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.f871w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, (String) null);
            this.f872x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f873y = bundle.getString(RemoteMessageConst.Notification.PRIORITY, (String) null);
            this.f874z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.f847A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.f848B = bundle.getString(RemoteMessageConst.Notification.VISIBILITY, (String) null);
        }
    }

    static {
        f838d.put(RemoteMessageConst.FROM, "");
        f838d.put(RemoteMessageConst.COLLAPSE_KEY, "");
        f838d.put(RemoteMessageConst.SEND_TIME, "");
        f838d.put(RemoteMessageConst.TTL, Integer.valueOf(RemoteMessageConst.DEFAULT_TTL));
        f838d.put(RemoteMessageConst.URGENCY, 2);
        f838d.put(RemoteMessageConst.ORI_URGENCY, 2);
        f838d.put(RemoteMessageConst.SEND_MODE, 0);
        f838d.put(RemoteMessageConst.RECEIPT_MODE, 0);
        f839e.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        f839e.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        f839e.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        f839e.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, f835a);
        f839e.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, f835a);
        f839e.put(RemoteMessageConst.Notification.TICKER, "");
        f839e.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        f839e.put(RemoteMessageConst.Notification.CONTENT, "");
        f840f.put(RemoteMessageConst.Notification.ICON, "");
        f840f.put(RemoteMessageConst.Notification.COLOR, "");
        f840f.put(RemoteMessageConst.Notification.SOUND, "");
        f840f.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        f840f.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, f836b);
        f840f.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        f840f.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        f840f.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, f837c);
        f841g.put(RemoteMessageConst.Notification.TAG, "");
        f841g.put(RemoteMessageConst.Notification.WHEN, "");
        f841g.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        f841g.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        f841g.put(RemoteMessageConst.Notification.PRIORITY, "");
        f841g.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        f841g.put(RemoteMessageConst.Notification.VISIBILITY, "");
        f841g.put(RemoteMessageConst.Notification.CHANNEL_ID, "");
        f842h.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        f842h.put(RemoteMessageConst.Notification.INTENT_URI, "");
        f842h.put("url", "");
    }

    public RemoteMessage(Bundle bundle) {
        this.f843i = mo14222a(bundle);
    }

    /* renamed from: b */
    public static JSONObject m1209b(Bundle bundle) {
        try {
            return new JSONObject(C0895v.m1334a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.m1380w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    /* renamed from: c */
    public static JSONObject m1211c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    /* renamed from: d */
    public static JSONObject m1212d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    /* renamed from: a */
    public final Bundle mo14222a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject b = m1209b(bundle);
        JSONObject a = m1208a(b);
        String string = JsonUtil.getString(a, RemoteMessageConst.DATA, (String) null);
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject d = m1212d(a);
        JSONObject b2 = m1210b(d);
        JSONObject c = m1211c(d);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) != 1 || !C0889s.m1317a(a, d, string)) {
            String string2 = bundle.getString(RemoteMessageConst.f875TO);
            String string3 = bundle.getString("message_type");
            String string4 = JsonUtil.getString(a, RemoteMessageConst.MSGID, (String) null);
            bundle2.putString(RemoteMessageConst.f875TO, string2);
            bundle2.putString(RemoteMessageConst.DATA, string);
            bundle2.putString(RemoteMessageConst.MSGID, string4);
            bundle2.putString("message_type", string3);
            JsonUtil.transferJsonObjectToBundle(b, bundle2, f838d);
            bundle2.putBundle(RemoteMessageConst.NOTIFICATION, mo14223a(b, a, d, b2, c));
            return bundle2;
        }
        bundle2.putString(RemoteMessageConst.DATA, C0895v.m1334a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        return bundle2;
    }

    public final int describeContents() {
        return 0;
    }

    public String getCollapseKey() {
        return this.f843i.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f843i.getString(RemoteMessageConst.DATA);
    }

    public Map<String, String> getDataOfMap() {
        HashMap hashMap = new HashMap();
        String string = this.f843i.getString(RemoteMessageConst.DATA);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.m1380w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public String getFrom() {
        return this.f843i.getString(RemoteMessageConst.FROM);
    }

    public String getMessageId() {
        return this.f843i.getString(RemoteMessageConst.MSGID);
    }

    public String getMessageType() {
        return this.f843i.getString("message_type");
    }

    public Notification getNotification() {
        Bundle bundle = this.f843i.getBundle(RemoteMessageConst.NOTIFICATION);
        if (this.f844j == null && bundle != null) {
            this.f844j = new Notification(bundle, (C0872b) null);
        }
        if (this.f844j == null) {
            this.f844j = new Notification(new Bundle(), (C0872b) null);
        }
        return this.f844j;
    }

    public int getOriginalUrgency() {
        int i = this.f843i.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i == 1 || i == 2) {
            return i;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f843i.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f843i.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f843i.getString(RemoteMessageConst.SEND_TIME);
            if (!TextUtils.isEmpty(string)) {
                return Long.parseLong(string);
            }
            return 0;
        } catch (NumberFormatException unused) {
            HMSLog.m1380w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0;
        }
    }

    public String getTo() {
        return this.f843i.getString(RemoteMessageConst.f875TO);
    }

    public String getToken() {
        return this.f843i.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f843i.getInt(RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int i = this.f843i.getInt(RemoteMessageConst.URGENCY);
        if (i == 1 || i == 2) {
            return i;
        }
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f843i);
        parcel.writeSerializable(this.f844j);
    }

    public RemoteMessage(Parcel parcel) {
        this.f843i = parcel.readBundle();
        this.f844j = (Notification) parcel.readSerializable();
    }

    /* renamed from: b */
    public static JSONObject m1210b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    /* renamed from: a */
    public final Bundle mo14223a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f839e);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f840f);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f841g);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f842h);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    /* renamed from: a */
    public static JSONObject m1208a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
