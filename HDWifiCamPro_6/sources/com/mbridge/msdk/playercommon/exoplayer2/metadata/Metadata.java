package com.mbridge.msdk.playercommon.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        public final Metadata[] newArray(int i) {
            return new Metadata[0];
        }

        public final Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }
    };
    private final Entry[] entries;

    public interface Entry extends Parcelable {
    }

    public final int describeContents() {
        return 0;
    }

    public Metadata(Entry... entryArr) {
        this.entries = entryArr == null ? new Entry[0] : entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        if (list != null) {
            this.entries = new Entry[list.size()];
            list.toArray(this.entries);
            return;
        }
        this.entries = new Entry[0];
    }

    Metadata(Parcel parcel) {
        this.entries = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.entries;
            if (i < entryArr.length) {
                entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public final int length() {
        return this.entries.length;
    }

    public final Entry get(int i) {
        return this.entries[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.entries, ((Metadata) obj).entries);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.entries);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.entries.length);
        for (Entry writeParcelable : this.entries) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
