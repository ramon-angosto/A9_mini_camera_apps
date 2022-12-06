package com.mbridge.msdk.foundation.download;

import android.os.Parcel;
import android.os.Parcelable;

public class DownloadProgress implements Parcelable {
    public static final Parcelable.Creator<DownloadProgress> CREATOR = new Parcelable.Creator<DownloadProgress>() {
        public final DownloadProgress createFromParcel(Parcel parcel) {
            return new DownloadProgress(parcel);
        }

        public final DownloadProgress[] newArray(int i) {
            return new DownloadProgress[i];
        }
    };
    private long current;
    private int currentDownloadRate;
    private long total;

    public int describeContents() {
        return 0;
    }

    public DownloadProgress(long j, long j2, int i) {
        this.current = j;
        this.total = j2;
        this.currentDownloadRate = i;
    }

    public long getCurrent() {
        return this.current;
    }

    public long getTotal() {
        return this.total;
    }

    public int getCurrentDownloadRate() {
        return this.currentDownloadRate;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.current);
        parcel.writeLong(this.total);
        parcel.writeInt(this.currentDownloadRate);
    }

    protected DownloadProgress(Parcel parcel) {
        this.current = parcel.readLong();
        this.total = parcel.readLong();
        this.currentDownloadRate = parcel.readInt();
    }
}
