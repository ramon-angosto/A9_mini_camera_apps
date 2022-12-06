package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new Parcelable.Creator<InternalFrame>() {
        public final InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        public final InternalFrame[] newArray(int i) {
            return new InternalFrame[i];
        }
    };
    public static final String ID = "----";
    public final String description;
    public final String domain;
    public final String text;

    public InternalFrame(String str, String str2, String str3) {
        super(ID);
        this.domain = str;
        this.description = str2;
        this.text = str3;
    }

    InternalFrame(Parcel parcel) {
        super(ID);
        this.domain = (String) Assertions.checkNotNull(parcel.readString());
        this.description = (String) Assertions.checkNotNull(parcel.readString());
        this.text = (String) Assertions.checkNotNull(parcel.readString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        if (!Util.areEqual(this.description, internalFrame.description) || !Util.areEqual(this.domain, internalFrame.domain) || !Util.areEqual(this.text, internalFrame.text)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.domain;
        int i = 0;
        int hashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final String toString() {
        return this.id + ": domain=" + this.domain + ", description=" + this.description;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.domain);
        parcel.writeString(this.text);
    }
}
