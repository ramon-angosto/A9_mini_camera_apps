package com.google.zxing.client.result;

public final class CalendarParsedResult extends ParsedResult {
    private final String attendee;
    private final String description;
    private final String end;
    private final double latitude;
    private final String location;
    private final double longitude;
    private final String start;
    private final String summary;

    public CalendarParsedResult(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, str4, str5, str6, Double.NaN, Double.NaN);
    }

    public CalendarParsedResult(String str, String str2, String str3, String str4, String str5, String str6, double d, double d2) {
        super(ParsedResultType.CALENDAR);
        validateDate(str2);
        this.summary = str;
        this.start = str2;
        if (str3 != null) {
            validateDate(str3);
            this.end = str3;
        } else {
            this.end = null;
        }
        this.location = str4;
        this.attendee = str5;
        this.description = str6;
        this.latitude = d;
        this.longitude = d2;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getStart() {
        return this.start;
    }

    public String getEnd() {
        return this.end;
    }

    public String getLocation() {
        return this.location;
    }

    public String getAttendee() {
        return this.attendee;
    }

    public String getDescription() {
        return this.description;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        maybeAppend(this.summary, sb);
        maybeAppend(this.start, sb);
        maybeAppend(this.end, sb);
        maybeAppend(this.location, sb);
        maybeAppend(this.attendee, sb);
        maybeAppend(this.description, sb);
        return sb.toString();
    }

    private static void validateDate(CharSequence charSequence) {
        if (charSequence != null) {
            int length = charSequence.length();
            if (length == 8 || length == 15 || length == 16) {
                int i = 0;
                while (i < 8) {
                    if (Character.isDigit(charSequence.charAt(i))) {
                        i++;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                if (length <= 8) {
                    return;
                }
                if (charSequence.charAt(8) == 'T') {
                    int i2 = 9;
                    while (i2 < 15) {
                        if (Character.isDigit(charSequence.charAt(i2))) {
                            i2++;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                    if (length == 16 && charSequence.charAt(15) != 'Z') {
                        throw new IllegalArgumentException();
                    }
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
    }
}
