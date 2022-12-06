package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;

public final class BizcardResultParser extends AbstractDoCoMoResultParser {
    public AddressBookParsedResult parse(Result result) {
        String text = result.getText();
        if (!text.startsWith("BIZCARD:")) {
            return null;
        }
        String buildName = buildName(matchSingleDoCoMoPrefixedField("N:", text, true), matchSingleDoCoMoPrefixedField("X:", text, true));
        String matchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("T:", text, true);
        String matchSingleDoCoMoPrefixedField2 = matchSingleDoCoMoPrefixedField("C:", text, true);
        String[] matchDoCoMoPrefixedField = matchDoCoMoPrefixedField("A:", text, true);
        String matchSingleDoCoMoPrefixedField3 = matchSingleDoCoMoPrefixedField("B:", text, true);
        String matchSingleDoCoMoPrefixedField4 = matchSingleDoCoMoPrefixedField("M:", text, true);
        String matchSingleDoCoMoPrefixedField5 = matchSingleDoCoMoPrefixedField("F:", text, true);
        String matchSingleDoCoMoPrefixedField6 = matchSingleDoCoMoPrefixedField("E:", text, true);
        return new AddressBookParsedResult(maybeWrap(buildName), (String) null, buildPhoneNumbers(matchSingleDoCoMoPrefixedField3, matchSingleDoCoMoPrefixedField4, matchSingleDoCoMoPrefixedField5), (String[]) null, maybeWrap(matchSingleDoCoMoPrefixedField6), (String[]) null, (String) null, (String) null, matchDoCoMoPrefixedField, (String[]) null, matchSingleDoCoMoPrefixedField2, (String) null, matchSingleDoCoMoPrefixedField, (String) null);
    }

    private static String[] buildPhoneNumbers(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    private static String buildName(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }
}
