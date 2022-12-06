package com.huawei.hms.push;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.huawei.hms.push.b */
/* compiled from: RemoteMessage */
class C0872b implements Parcelable.Creator<RemoteMessage> {
    public RemoteMessage createFromParcel(Parcel parcel) {
        return new RemoteMessage(parcel);
    }

    public RemoteMessage[] newArray(int i) {
        return new RemoteMessage[i];
    }
}
