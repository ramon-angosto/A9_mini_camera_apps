package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class URIResultParser extends ResultParser {
    private static final Pattern ALLOWED_URI_CHARS_PATTERN = Pattern.compile("[-._~:/?#\\[\\]@!$&'()*+,;=%A-Za-z0-9]+");
    private static final Pattern URL_WITHOUT_PROTOCOL_PATTERN = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");
    private static final Pattern URL_WITH_PROTOCOL_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
    private static final Pattern USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");

    public URIParsedResult parse(Result result) {
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("URL:") || massagedText.startsWith("URI:")) {
            return new URIParsedResult(massagedText.substring(4).trim(), (String) null);
        }
        String trim = massagedText.trim();
        if (!isBasicallyValidURI(trim) || isPossiblyMaliciousURI(trim)) {
            return null;
        }
        return new URIParsedResult(trim, (String) null);
    }

    static boolean isPossiblyMaliciousURI(String str) {
        return !ALLOWED_URI_CHARS_PATTERN.matcher(str).matches() || USER_IN_HOST.matcher(str).find();
    }

    static boolean isBasicallyValidURI(String str) {
        if (str.contains(" ")) {
            return false;
        }
        Matcher matcher = URL_WITH_PROTOCOL_PATTERN.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = URL_WITHOUT_PROTOCOL_PATTERN.matcher(str);
        if (!matcher2.find() || matcher2.start() != 0) {
            return false;
        }
        return true;
    }
}
