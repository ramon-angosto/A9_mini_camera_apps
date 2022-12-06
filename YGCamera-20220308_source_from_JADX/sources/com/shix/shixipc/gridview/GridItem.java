package com.shix.shixipc.gridview;

import android.os.Parcel;
import android.os.Parcelable;

public class GridItem implements Parcelable {
    public static final Parcelable.Creator<GridItem> CREATOR = new Parcelable.Creator<GridItem>() {
        public GridItem createFromParcel(Parcel parcel) {
            return new GridItem(parcel);
        }

        public GridItem[] newArray(int i) {
            return new GridItem[i];
        }
    };
    private String path;
    private int section;
    private String time;

    public int describeContents() {
        return 0;
    }

    public GridItem(String str, String str2) {
        this.path = str;
        this.time = str2;
    }

    public GridItem(Parcel parcel) {
        this.path = parcel.readString();
        this.time = parcel.readString();
        this.section = parcel.readInt();
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public int getSection() {
        return this.section;
    }

    public void setSection(int i) {
        this.section = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.path);
        parcel.writeString(this.time);
        parcel.writeInt(this.section);
    }
}
