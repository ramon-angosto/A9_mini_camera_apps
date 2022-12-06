package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class SMTPResultParser extends ResultParser {
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String text = result.getText();
        String str2 = null;
        if (!text.startsWith("smtp:") && !text.startsWith("SMTP:")) {
            return null;
        }
        String substring = text.substring(5);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            String substring2 = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
            int indexOf2 = substring2.indexOf(58);
            if (indexOf2 >= 0) {
                str2 = substring2.substring(indexOf2 + 1);
                str = substring2.substring(0, indexOf2);
            } else {
                str = substring2;
            }
        } else {
            str = null;
        }
        return new EmailAddressParsedResult(substring, str, str2, "mailto:" + substring);
    }
}
