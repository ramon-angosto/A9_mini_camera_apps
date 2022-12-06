package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

public final class ConnectionResult implements Parcelable {
    public static final int API_UNAVAILABLE = 1000;
    public static final int BINDFAIL_RESOLUTION_BACKGROUND = 7;
    public static final int BINDFAIL_RESOLUTION_REQUIRED = 6;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new C0617a();
    public static final int DEVELOPER_ERROR = 10;
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 9002;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 9000;
    public static final int RESOLUTION_REQUIRED = 9001;
    public static final int RESTRICTED_PROFILE = 9003;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UNSUPPORTED = 21;
    public static final int SERVICE_UPDATING = 9004;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 9005;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;

    /* renamed from: a */
    private int f276a;

    /* renamed from: b */
    private PendingIntent f277b;

    /* renamed from: c */
    private String f278c;

    /* renamed from: d */
    private int f279d;

    /* renamed from: com.huawei.hms.api.ConnectionResult$a */
    static class C0617a implements Parcelable.Creator<ConnectionResult> {
        C0617a() {
        }

        public ConnectionResult createFromParcel(Parcel parcel) {
            return new ConnectionResult(parcel, (C0617a) null);
        }

        public ConnectionResult[] newArray(int i) {
            return new ConnectionResult[i];
        }
    }

    /* synthetic */ ConnectionResult(Parcel parcel, C0617a aVar) {
        this(parcel);
    }

    /* renamed from: a */
    static String m209a(int i) {
        if (i == -1) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        if (i == 0) {
            return "SUCCESS";
        }
        if (i == 1) {
            return "SERVICE_MISSING";
        }
        if (i == 2) {
            return "SERVICE_VERSION_UPDATE_REQUIRED";
        }
        if (i == 3) {
            return "SERVICE_DISABLED";
        }
        if (i == 13) {
            return "CANCELED";
        }
        if (i == 14) {
            return "TIMEOUT";
        }
        if (i == 19) {
            return "SERVICE_MISSING_PERMISSION";
        }
        if (i == 21) {
            return "API_VERSION_UPDATE_REQUIRED";
        }
        switch (i) {
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (!(obj instanceof ConnectionResult) || this.f276a != ((ConnectionResult) obj).f276a || this.f279d != ((ConnectionResult) obj).f279d || !this.f278c.equals(((ConnectionResult) obj).f278c) || !this.f277b.equals(((ConnectionResult) obj).f277b)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int getErrorCode() {
        return this.f279d;
    }

    public final String getErrorMessage() {
        return this.f278c;
    }

    public final PendingIntent getResolution() {
        return this.f277b;
    }

    public final boolean hasResolution() {
        return HuaweiApiAvailability.getInstance().isUserResolvableError(this.f279d, this.f277b);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf((long) this.f276a), Long.valueOf((long) getErrorCode()), getErrorMessage(), this.f277b);
    }

    public final boolean isSuccess() {
        return this.f279d == 0;
    }

    public final void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            HuaweiApiAvailability.getInstance().resolveError(activity, this.f279d, i, this.f277b);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f276a);
        parcel.writeInt(this.f279d);
        parcel.writeString(this.f278c);
        this.f277b.writeToParcel(parcel, i);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f276a = 1;
        this.f277b = null;
        this.f278c = null;
        this.f276a = i;
        this.f279d = i2;
        this.f277b = pendingIntent;
        this.f278c = str;
    }

    public ConnectionResult(int i) {
        this(i, (PendingIntent) null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, (String) null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    private ConnectionResult(Parcel parcel) {
        this.f276a = 1;
        this.f277b = null;
        this.f278c = null;
        this.f276a = parcel.readInt();
        this.f279d = parcel.readInt();
        this.f278c = parcel.readString();
        Parcelable parcelable = (Parcelable) PendingIntent.CREATOR.createFromParcel(parcel);
        if (parcelable != null) {
            this.f277b = (PendingIntent) parcelable;
        }
    }
}
