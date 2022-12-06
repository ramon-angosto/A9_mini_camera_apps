package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.List;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Parcelable.Creator<CompositeDateValidator>() {
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            return new CompositeDateValidator((List) Preconditions.checkNotNull(parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader())));
        }

        public CompositeDateValidator[] newArray(int i) {
            return new CompositeDateValidator[i];
        }
    };
    private final List<CalendarConstraints.DateValidator> validators;

    public int describeContents() {
        return 0;
    }

    private CompositeDateValidator(List<CalendarConstraints.DateValidator> list) {
        this.validators = list;
    }

    public static CalendarConstraints.DateValidator allOf(List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list);
    }

    public boolean isValid(long j) {
        for (CalendarConstraints.DateValidator next : this.validators) {
            if (next != null && !next.isValid(j)) {
                return false;
            }
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.validators);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        return this.validators.equals(((CompositeDateValidator) obj).validators);
    }

    public int hashCode() {
        return this.validators.hashCode();
    }
}
