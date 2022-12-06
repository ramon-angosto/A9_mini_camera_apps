package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;

public final class AddressBookAUResultParser extends ResultParser {
    public AddressBookParsedResult parse(Result result) {
        String text = result.getText();
        String[] strArr = null;
        if (!text.contains("MEMORY") || !text.contains("\r\n")) {
            return null;
        }
        String matchSinglePrefixedField = matchSinglePrefixedField("NAME1:", text, 13, true);
        String matchSinglePrefixedField2 = matchSinglePrefixedField("NAME2:", text, 13, true);
        String[] matchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, text, true);
        String[] matchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, text, true);
        String matchSinglePrefixedField3 = matchSinglePrefixedField("MEMORY:", text, 13, false);
        String matchSinglePrefixedField4 = matchSinglePrefixedField("ADD:", text, 13, true);
        if (matchSinglePrefixedField4 != null) {
            strArr = new String[]{matchSinglePrefixedField4};
        }
        return new AddressBookParsedResult(maybeWrap(matchSinglePrefixedField), matchSinglePrefixedField2, matchMultipleValuePrefix, (String[]) null, matchMultipleValuePrefix2, (String[]) null, (String) null, matchSinglePrefixedField3, strArr, (String[]) null, (String) null, (String) null, (String) null, (String) null);
    }

    private static String[] matchMultipleValuePrefix(String str, int i, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String matchSinglePrefixedField = matchSinglePrefixedField(str + i2 + ':', str2, 13, z);
            if (matchSinglePrefixedField == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i);
            }
            arrayList.add(matchSinglePrefixedField);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
