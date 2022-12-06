package com.google.zxing.client.result;

import java.util.List;

public final class VEventResultParser extends ResultParser {
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.client.result.CalendarParsedResult parse(com.google.zxing.Result r15) {
        /*
            r14 = this;
            java.lang.String r15 = r15.getText()
            r0 = 0
            if (r15 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.lang.String r1 = "BEGIN:VEVENT"
            int r1 = r15.indexOf(r1)
            if (r1 >= 0) goto L_0x0011
            return r0
        L_0x0011:
            r1 = 1
            java.lang.String r2 = "SUMMARY"
            java.lang.String r4 = matchSingleVCardPrefixedField(r2, r15, r1)
            java.lang.String r2 = "DTSTART"
            java.lang.String r5 = matchSingleVCardPrefixedField(r2, r15, r1)
            if (r5 != 0) goto L_0x0021
            return r0
        L_0x0021:
            java.lang.String r2 = "DTEND"
            java.lang.String r6 = matchSingleVCardPrefixedField(r2, r15, r1)
            java.lang.String r2 = "LOCATION"
            java.lang.String r7 = matchSingleVCardPrefixedField(r2, r15, r1)
            java.lang.String r2 = "DESCRIPTION"
            java.lang.String r9 = matchSingleVCardPrefixedField(r2, r15, r1)
            java.lang.String r2 = "GEO"
            java.lang.String r15 = matchSingleVCardPrefixedField(r2, r15, r1)
            r2 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            if (r15 != 0) goto L_0x0040
            r10 = r2
            r12 = r10
            goto L_0x0059
        L_0x0040:
            r2 = 59
            int r2 = r15.indexOf(r2)
            r3 = 0
            java.lang.String r3 = r15.substring(r3, r2)     // Catch:{ NumberFormatException -> 0x0061 }
            double r10 = java.lang.Double.parseDouble(r3)     // Catch:{ NumberFormatException -> 0x0061 }
            int r2 = r2 + r1
            java.lang.String r15 = r15.substring(r2)     // Catch:{ NumberFormatException -> 0x0061 }
            double r1 = java.lang.Double.parseDouble(r15)     // Catch:{ NumberFormatException -> 0x0061 }
            r12 = r1
        L_0x0059:
            com.google.zxing.client.result.CalendarParsedResult r15 = new com.google.zxing.client.result.CalendarParsedResult     // Catch:{  }
            r8 = 0
            r3 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r12)     // Catch:{  }
            return r15
        L_0x0061:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.VEventResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.CalendarParsedResult");
    }

    private static String matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        List<String> matchSingleVCardPrefixedField = VCardResultParser.matchSingleVCardPrefixedField(charSequence, str, z);
        if (matchSingleVCardPrefixedField == null || matchSingleVCardPrefixedField.isEmpty()) {
            return null;
        }
        return matchSingleVCardPrefixedField.get(0);
    }
}
