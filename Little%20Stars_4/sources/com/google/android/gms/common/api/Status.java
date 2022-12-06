package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;

public final class Status extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<Status> CREATOR = new zzf();
    public static final Status zzalA = new Status(16);
    public static final Status zzalB = new Status(17);
    public static final Status zzalw = new Status(0);
    public static final Status zzalx = new Status(14);
    public static final Status zzaly = new Status(8);
    public static final Status zzalz = new Status(15);
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int zzahG;
    private final String zzakk;

    public Status(int i) {
        this(i, (String) null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.zzahG = i2;
        this.zzakk = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, (PendingIntent) null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String zzry() {
        String str = this.zzakk;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.zzahG);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.zzahG == status.zzahG && zzz.equal(this.zzakk, status.zzakk) && zzz.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzahG;
    }

    @Nullable
    public String getStatusMessage() {
        return this.zzakk;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzz.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzahG), this.zzakk, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzahG == 16;
    }

    public boolean isInterrupted() {
        return this.zzahG == 14;
    }

    public boolean isSuccess() {
        return this.zzahG <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzz.zzy(this).zzg("statusCode", zzry()).zzg("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public PendingIntent zzrx() {
        return this.mPendingIntent;
    }
}
