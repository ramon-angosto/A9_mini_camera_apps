package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

public final class ISBNResultParser extends ResultParser {
    public ISBNParsedResult parse(Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.EAN_13) {
            return null;
        }
        String text = result.getText();
        if (text.length() != 13) {
            return null;
        }
        if (text.startsWith("978") || text.startsWith("979")) {
            return new ISBNParsedResult(text);
        }
        return null;
    }
}
