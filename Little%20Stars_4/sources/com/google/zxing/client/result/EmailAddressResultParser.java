package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;

public final class EmailAddressResultParser extends ResultParser {
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String text = result.getText();
        String str2 = null;
        if (text.startsWith("mailto:") || text.startsWith("MAILTO:")) {
            String substring = text.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            Map<String, String> parseNameValuePairs = parseNameValuePairs(text);
            if (parseNameValuePairs != null) {
                if (substring.length() == 0) {
                    substring = parseNameValuePairs.get("to");
                }
                str2 = parseNameValuePairs.get("subject");
                str = parseNameValuePairs.get("body");
            } else {
                str = null;
            }
            return new EmailAddressParsedResult(substring, str2, str, text);
        } else if (!EmailDoCoMoResultParser.isBasicallyValidEmailAddress(text)) {
            return null;
        } else {
            return new EmailAddressParsedResult(text, (String) null, (String) null, "mailto:" + text);
        }
    }
}
