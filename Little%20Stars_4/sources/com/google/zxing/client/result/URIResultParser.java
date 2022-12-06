package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class URIResultParser extends ResultParser {
    private static final String PATTERN_END = "(:\\d{1,5})?(/|\\?|$)";
    private static final Pattern URL_WITHOUT_PROTOCOL_PATTERN = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9\\-]{2,}(:\\d{1,5})?(/|\\?|$)");
    private static final Pattern URL_WITH_PROTOCOL_PATTERN = Pattern.compile("[a-zA-Z0-9]{2,}://[a-zA-Z0-9\\-]+(\\.[a-zA-Z0-9\\-]+)*(:\\d{1,5})?(/|\\?|$)");

    public URIParsedResult parse(Result result) {
        String text = result.getText();
        if (text.startsWith("URL:")) {
            text = text.substring(4);
        }
        String trim = text.trim();
        if (isBasicallyValidURI(trim)) {
            return new URIParsedResult(trim, (String) null);
        }
        return null;
    }

    static boolean isBasicallyValidURI(CharSequence charSequence) {
        Matcher matcher = URL_WITH_PROTOCOL_PATTERN.matcher(charSequence);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = URL_WITHOUT_PROTOCOL_PATTERN.matcher(charSequence);
        if (!matcher2.find() || matcher2.start() != 0) {
            return false;
        }
        return true;
    }
}
