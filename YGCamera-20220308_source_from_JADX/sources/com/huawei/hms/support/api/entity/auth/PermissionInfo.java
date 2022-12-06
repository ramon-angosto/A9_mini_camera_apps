package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class PermissionInfo implements IMessageEntity, Parcelable {
    public static final Parcelable.Creator<PermissionInfo> CREATOR = new C0910a();
    @Packed
    private String appID;
    @Packed
    private String packageName;
    @Packed
    private String permission;

    /* renamed from: com.huawei.hms.support.api.entity.auth.PermissionInfo$a */
    static class C0910a implements Parcelable.Creator<PermissionInfo> {
        C0910a() {
        }

        public PermissionInfo createFromParcel(Parcel parcel) {
            return new PermissionInfo(parcel);
        }

        public PermissionInfo[] newArray(int i) {
            return new PermissionInfo[i];
        }
    }

    public PermissionInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAppID() {
        return this.appID;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPermission(String str) {
        this.permission = str;
    }

    public PermissionInfo setPermissionUri(String str) {
        this.permission = str;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appID);
        parcel.writeString(this.packageName);
        parcel.writeString(this.permission);
    }

    public PermissionInfo(String str, String str2, String str3) {
        this.appID = str;
        this.packageName = str2;
        this.permission = str3;
    }

    public PermissionInfo(Parcel parcel) {
        this.appID = parcel.readString();
        this.packageName = parcel.readString();
        this.permission = parcel.readString();
    }
}
