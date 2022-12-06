package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationStyle implements Parcelable {
    public static final String BANNER_IMAGE_URL = "bi";
    public static final String BASE_STYLE = "bs";
    public static final Parcelable.Creator<NotificationStyle> CREATOR = new Parcelable.Creator<NotificationStyle>() {
        public NotificationStyle createFromParcel(Parcel parcel) {
            return new NotificationStyle(parcel);
        }

        public NotificationStyle[] newArray(int i) {
            return new NotificationStyle[i];
        }
    };
    public static final String EXPANDABLE_IMAGE_URL = "ei";
    public static final String EXPANDABLE_TEXT = "et";
    public static final String INNER_STYLE = "is";
    public static final String NOTIFICATION_STYLE = "ns";
    public static final String TAG = "notification_style";
    private String bannerImageUrl;
    private int baseStyle = 0;
    private String expandableImageUrl;
    private String expandableText;
    private int innerStyle = 0;

    public int describeContents() {
        return 0;
    }

    public NotificationStyle(Parcel parcel) {
        this.baseStyle = parcel.readInt();
        this.innerStyle = parcel.readInt();
        this.expandableText = parcel.readString();
        this.expandableImageUrl = parcel.readString();
        this.bannerImageUrl = parcel.readString();
    }

    public NotificationStyle() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.baseStyle);
        parcel.writeInt(this.innerStyle);
        parcel.writeString(this.expandableText);
        parcel.writeString(this.expandableImageUrl);
        parcel.writeString(this.bannerImageUrl);
    }

    public int getBaseStyle() {
        return this.baseStyle;
    }

    public void setBaseStyle(int i) {
        this.baseStyle = i;
    }

    public int getInnerStyle() {
        return this.innerStyle;
    }

    public void setInnerStyle(int i) {
        this.innerStyle = i;
    }

    public String getExpandableText() {
        return this.expandableText;
    }

    public void setExpandableText(String str) {
        this.expandableText = str;
    }

    public String getExpandableImageUrl() {
        return this.expandableImageUrl;
    }

    public void setExpandableImageUrl(String str) {
        this.expandableImageUrl = str;
    }

    public String getBannerImageUrl() {
        return this.bannerImageUrl;
    }

    public void setBannerImageUrl(String str) {
        this.bannerImageUrl = str;
    }

    public static NotificationStyle parse(String str) {
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

    public static NotificationStyle parse(JSONObject jSONObject) {
        NotificationStyle notificationStyle = new NotificationStyle();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(BASE_STYLE)) {
                    notificationStyle.setBaseStyle(jSONObject.getInt(BASE_STYLE));
                }
                if (!jSONObject.isNull("is")) {
                    notificationStyle.setInnerStyle(jSONObject.getInt("is"));
                }
                if (!jSONObject.isNull("et")) {
                    notificationStyle.setExpandableText(jSONObject.getString("et"));
                }
                if (!jSONObject.isNull(EXPANDABLE_IMAGE_URL)) {
                    notificationStyle.setExpandableImageUrl(jSONObject.getString(EXPANDABLE_IMAGE_URL));
                }
                if (!jSONObject.isNull(BANNER_IMAGE_URL)) {
                    notificationStyle.setBannerImageUrl(jSONObject.getString(BANNER_IMAGE_URL));
                }
            } catch (JSONException e) {
                DebugLogger.e(TAG, "parse json obj error " + e.getMessage());
            }
        } else {
            DebugLogger.e(TAG, "no such tag notification_style");
        }
        return notificationStyle;
    }

    public String toString() {
        return "NotificationStyle{baseStyle=" + this.baseStyle + ", innerStyle=" + this.innerStyle + ", expandableText='" + this.expandableText + '\'' + ", expandableImageUrl='" + this.expandableImageUrl + '\'' + ", bannerImageUrl='" + this.bannerImageUrl + '\'' + '}';
    }
}
