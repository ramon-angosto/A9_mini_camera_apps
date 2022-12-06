package com.vungle.warren.ui.state;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

public class BundleOptionsState implements OptionsState, Parcelable {
    public static final Parcelable.Creator<BundleOptionsState> CREATOR = new Parcelable.Creator<BundleOptionsState>() {
        public BundleOptionsState createFromParcel(Parcel parcel) {
            return new BundleOptionsState(parcel);
        }

        public BundleOptionsState[] newArray(int i) {
            return new BundleOptionsState[i];
        }
    };
    private Map<String, Boolean> bools = new HashMap();
    private Map<String, Integer> ints = new HashMap();
    private Map<String, String> strings = new HashMap();

    public int describeContents() {
        return 0;
    }

    public BundleOptionsState() {
    }

    public void put(String str, String str2) {
        this.strings.put(str, str2);
    }

    public void put(String str, boolean z) {
        this.bools.put(str, Boolean.valueOf(z));
    }

    public void put(String str, int i) {
        this.ints.put(str, Integer.valueOf(i));
    }

    public boolean getBoolean(String str, boolean z) {
        Boolean bool = this.bools.get(str);
        return bool == null ? z : bool.booleanValue();
    }

    public String getString(String str) {
        return this.strings.get(str);
    }

    public Integer getInt(String str, int i) {
        Integer num = this.ints.get(str);
        if (num != null) {
            i = num.intValue();
        }
        return Integer.valueOf(i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ints.size());
        for (Map.Entry next : this.ints.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeValue(next.getValue());
        }
        parcel.writeInt(this.strings.size());
        for (Map.Entry next2 : this.strings.entrySet()) {
            parcel.writeString((String) next2.getKey());
            parcel.writeValue(next2.getValue());
        }
        parcel.writeInt(this.bools.size());
        for (Map.Entry next3 : this.bools.entrySet()) {
            parcel.writeString((String) next3.getKey());
            parcel.writeValue(next3.getValue());
        }
    }

    protected BundleOptionsState(Parcel parcel) {
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.ints.put(parcel.readString(), (Integer) parcel.readValue(String.class.getClassLoader()));
        }
        int readInt2 = parcel.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.strings.put(parcel.readString(), (String) parcel.readValue(String.class.getClassLoader()));
        }
        int readInt3 = parcel.readInt();
        for (int i3 = 0; i3 < readInt3; i3++) {
            this.bools.put(parcel.readString(), (Boolean) parcel.readValue(Boolean.class.getClassLoader()));
        }
    }
}
