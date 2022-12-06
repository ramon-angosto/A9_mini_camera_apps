package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class WifiResultParser extends ResultParser {
    public WifiParsedResult parse(Result result) {
        String matchSinglePrefixedField;
        String text = result.getText();
        if (!text.startsWith("WIFI:") || (matchSinglePrefixedField = matchSinglePrefixedField("S:", text, ';', false)) == null || matchSinglePrefixedField.length() == 0) {
            return null;
        }
        String matchSinglePrefixedField2 = matchSinglePrefixedField("P:", text, ';', false);
        String matchSinglePrefixedField3 = matchSinglePrefixedField("T:", text, ';', false);
        if (matchSinglePrefixedField3 == null) {
            matchSinglePrefixedField3 = "nopass";
        }
        return new WifiParsedResult(matchSinglePrefixedField3, matchSinglePrefixedField, matchSinglePrefixedField2);
    }
}
