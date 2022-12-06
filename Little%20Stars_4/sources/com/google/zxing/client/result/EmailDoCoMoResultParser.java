package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Pattern;

public final class EmailDoCoMoResultParser extends AbstractDoCoMoResultParser {
    private static final Pattern ATEXT_ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public EmailAddressParsedResult parse(Result result) {
        String[] matchDoCoMoPrefixedField;
        String text = result.getText();
        if (!text.startsWith("MATMSG:") || (matchDoCoMoPrefixedField = matchDoCoMoPrefixedField("TO:", text, true)) == null) {
            return null;
        }
        String str = matchDoCoMoPrefixedField[0];
        if (!isBasicallyValidEmailAddress(str)) {
            return null;
        }
        String matchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("SUB:", text, false);
        String matchSingleDoCoMoPrefixedField2 = matchSingleDoCoMoPrefixedField("BODY:", text, false);
        return new EmailAddressParsedResult(str, matchSingleDoCoMoPrefixedField, matchSingleDoCoMoPrefixedField2, "mailto:" + str);
    }

    static boolean isBasicallyValidEmailAddress(String str) {
        return str != null && ATEXT_ALPHANUMERIC.matcher(str).matches() && str.indexOf(64) >= 0;
    }
}
