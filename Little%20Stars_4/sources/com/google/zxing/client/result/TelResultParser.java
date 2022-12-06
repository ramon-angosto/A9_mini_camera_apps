package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class TelResultParser extends ResultParser {
    public TelParsedResult parse(Result result) {
        String str;
        String text = result.getText();
        if (!text.startsWith("tel:") && !text.startsWith("TEL:")) {
            return null;
        }
        if (text.startsWith("TEL:")) {
            str = "tel:" + text.substring(4);
        } else {
            str = text;
        }
        int indexOf = text.indexOf(63, 4);
        return new TelParsedResult(indexOf < 0 ? text.substring(4) : text.substring(4, indexOf), str, (String) null);
    }
}
