package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class AdvanceSetting implements Parcelable {
    public static final String ADVANCE_SETTING = "as";
    public static final String CLEAR_NOTIFICATION = "cn";
    public static final Parcelable.Creator<AdvanceSetting> CREATOR = new Parcelable.Creator<AdvanceSetting>() {
        public AdvanceSetting createFromParcel(Parcel parcel) {
            return new AdvanceSetting(parcel);
        }

        public AdvanceSetting[] newArray(int i) {
            return new AdvanceSetting[i];
        }
    };
    public static final String HEAD_UP_NOTIFICATION = "hn";
    public static final String NETWORK_TYPE = "it";
    public static final String NOTIFY_TYPE = "nt";
    public static final String TAG = "advance_setting";
    private boolean clearNotification = true;
    private boolean headUpNotification = true;
    private int netWorkType = 1;
    private NotifyType notifyType;

    public int describeContents() {
        return 0;
    }

    public AdvanceSetting() {
    }

    public AdvanceSetting(Parcel parcel) {
        boolean z = true;
        this.netWorkType = parcel.readInt();
        this.notifyType = (NotifyType) parcel.readParcelable(NotifyType.class.getClassLoader());
        this.clearNotification = parcel.readByte() != 0;
        this.headUpNotification = parcel.readByte() == 0 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.netWorkType);
        parcel.writeParcelable(this.notifyType, i);
        parcel.writeByte(this.clearNotification ? (byte) 1 : 0);
        parcel.writeByte(this.headUpNotification ? (byte) 1 : 0);
    }

    public int getNetWorkType() {
        return this.netWorkType;
    }

    public void setNetWorkType(int i) {
        this.netWorkType = i;
    }

    public NotifyType getNotifyType() {
        return this.notifyType;
    }

    public void setNotifyType(NotifyType notifyType2) {
        this.notifyType = notifyType2;
    }

    public boolean isClearNotification() {
        return this.clearNotification;
    }

    public void setClearNotification(boolean z) {
        this.clearNotification = z;
    }

    public boolean isHeadUpNotification() {
        return this.headUpNotification;
    }

    public void setHeadUpNotification(boolean z) {
        this.headUpNotification = z;
    }

    public static AdvanceSetting parse(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                DebugLogger.e(TAG, "parse json string error " + e.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static AdvanceSetting parse(JSONObject jSONObject) {
        AdvanceSetting advanceSetting = new AdvanceSetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(NETWORK_TYPE)) {
                    advanceSetting.setNetWorkType(jSONObject.getInt(NETWORK_TYPE));
                }
                if (!jSONObject.isNull("nt")) {
                    advanceSetting.setNotifyType(NotifyType.parse(jSONObject.getJSONObject("nt")));
                }
                boolean z = true;
                if (!jSONObject.isNull(CLEAR_NOTIFICATION)) {
                    advanceSetting.setClearNotification(jSONObject.getInt(CLEAR_NOTIFICATION) != 0);
                }
                if (!jSONObject.isNull(HEAD_UP_NOTIFICATION)) {
                    if (jSONObject.getInt(HEAD_UP_NOTIFICATION) == 0) {
                        z = false;
                    }
                    advanceSetting.setHeadUpNotification(z);
                }
            } catch (JSONException e) {
                DebugLogger.e(TAG, "parse json obj error " + e.getMessage());
            }
        } else {
            DebugLogger.e(TAG, "no such tag advance_setting");
        }
        return advanceSetting;
    }

    public String toString() {
        return "AdvanceSetting{netWorkType=" + this.netWorkType + ", notifyType=" + this.notifyType + ", clearNotification=" + this.clearNotification + ", headUpNotification=" + this.headUpNotification + '}';
    }
}
