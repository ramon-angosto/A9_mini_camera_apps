package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;

public final class ExpandedProductResultParser extends ResultParser {
    public ExpandedProductParsedResult parse(Result result) {
        String text;
        int i;
        String str;
        String str2;
        String str3;
        ExpandedProductParsedResult expandedProductParsedResult = null;
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED || (text = result.getText()) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        int i2 = 0;
        while (i2 < text.length()) {
            String findAIvalue = findAIvalue(i2, text);
            if (findAIvalue == null) {
                return expandedProductParsedResult;
            }
            int length = i2 + findAIvalue.length() + 2;
            String findValue = findValue(length, text);
            int length2 = length + findValue.length();
            String str17 = text;
            if ("00".equals(findAIvalue)) {
                str5 = findValue;
            } else if ("01".equals(findAIvalue)) {
                str4 = findValue;
            } else if ("10".equals(findAIvalue)) {
                str6 = findValue;
            } else if ("11".equals(findAIvalue)) {
                str7 = findValue;
            } else if ("13".equals(findAIvalue)) {
                str8 = findValue;
            } else if ("15".equals(findAIvalue)) {
                str9 = findValue;
            } else if ("17".equals(findAIvalue)) {
                str10 = findValue;
            } else {
                i = length2;
                if ("3100".equals(findAIvalue) || "3101".equals(findAIvalue) || "3102".equals(findAIvalue) || "3103".equals(findAIvalue) || "3104".equals(findAIvalue) || "3105".equals(findAIvalue) || "3106".equals(findAIvalue) || "3107".equals(findAIvalue) || "3108".equals(findAIvalue) || "3109".equals(findAIvalue)) {
                    str2 = findAIvalue.substring(3);
                    str = ExpandedProductParsedResult.KILOGRAM;
                } else if ("3200".equals(findAIvalue) || "3201".equals(findAIvalue) || "3202".equals(findAIvalue) || "3203".equals(findAIvalue) || "3204".equals(findAIvalue) || "3205".equals(findAIvalue) || "3206".equals(findAIvalue) || "3207".equals(findAIvalue) || "3208".equals(findAIvalue) || "3209".equals(findAIvalue)) {
                    str2 = findAIvalue.substring(3);
                    str = ExpandedProductParsedResult.POUND;
                } else {
                    if ("3920".equals(findAIvalue) || "3921".equals(findAIvalue) || "3922".equals(findAIvalue) || "3923".equals(findAIvalue)) {
                        str3 = findAIvalue.substring(3);
                        str14 = findValue;
                    } else if (!"3930".equals(findAIvalue) && !"3931".equals(findAIvalue) && !"3932".equals(findAIvalue) && !"3933".equals(findAIvalue)) {
                        hashMap.put(findAIvalue, findValue);
                        text = str17;
                        i2 = i;
                        expandedProductParsedResult = null;
                    } else if (findValue.length() < 4) {
                        return null;
                    } else {
                        str14 = findValue.substring(3);
                        String substring = findValue.substring(0, 3);
                        str3 = findAIvalue.substring(3);
                        str16 = substring;
                    }
                    str15 = str3;
                    text = str17;
                    i2 = i;
                    expandedProductParsedResult = null;
                }
                str11 = findValue;
                str13 = str2;
                str12 = str;
                text = str17;
                i2 = i;
                expandedProductParsedResult = null;
            }
            i = length2;
            text = str17;
            i2 = i;
            expandedProductParsedResult = null;
        }
        return new ExpandedProductParsedResult(str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, hashMap);
    }

    private static String findAIvalue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        if (str.charAt(i) != '(') {
            return null;
        }
        String substring = str.substring(i + 1);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String findValue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (findAIvalue(i2, substring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
