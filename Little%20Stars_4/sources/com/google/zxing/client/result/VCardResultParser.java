package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import object.p2pipcam.zxingtwodimensioncode.Intents;

public final class VCardResultParser extends ResultParser {
    private static final Pattern BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
    private static final Pattern EQUALS = Pattern.compile("=");
    private static final Pattern NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
    private static final Pattern SEMICOLON = Pattern.compile(";");
    private static final Pattern VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    public AddressBookParsedResult parse(Result result) {
        String text = result.getText();
        Matcher matcher = BEGIN_VCARD.matcher(text);
        List<String> list = null;
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField("FN", text, true);
        if (matchVCardPrefixedField == null) {
            matchVCardPrefixedField = matchVCardPrefixedField("N", text, true);
            formatNames(matchVCardPrefixedField);
        }
        List<List<String>> matchVCardPrefixedField2 = matchVCardPrefixedField("TEL", text, true);
        List<List<String>> matchVCardPrefixedField3 = matchVCardPrefixedField("EMAIL", text, true);
        List<String> matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NOTE", text, false);
        List<List<String>> matchVCardPrefixedField4 = matchVCardPrefixedField("ADR", text, true);
        if (matchVCardPrefixedField4 != null) {
            for (List next : matchVCardPrefixedField4) {
                next.set(0, next.get(0));
            }
        }
        List<String> matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("ORG", text, true);
        List<String> matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("BDAY", text, true);
        if (matchSingleVCardPrefixedField3 == null || isLikeVCardDate(matchSingleVCardPrefixedField3.get(0))) {
            list = matchSingleVCardPrefixedField3;
        }
        List<String> matchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("TITLE", text, true);
        List<String> matchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("URL", text, true);
        return new AddressBookParsedResult(toPrimaryValues(matchVCardPrefixedField), (String) null, toPrimaryValues(matchVCardPrefixedField2), toTypes(matchVCardPrefixedField2), toPrimaryValues(matchVCardPrefixedField3), toTypes(matchVCardPrefixedField3), toPrimaryValue(matchSingleVCardPrefixedField("IMPP", text, true)), toPrimaryValue(matchSingleVCardPrefixedField), toPrimaryValues(matchVCardPrefixedField4), toTypes(matchVCardPrefixedField4), toPrimaryValue(matchSingleVCardPrefixedField2), toPrimaryValue(list), toPrimaryValue(matchSingleVCardPrefixedField4), toPrimaryValue(matchSingleVCardPrefixedField5));
    }

    private static List<List<String>> matchVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        String str2;
        boolean z2;
        ArrayList arrayList;
        int indexOf;
        String str3;
        String str4 = str;
        int length = str.length();
        int i = 0;
        ArrayList arrayList2 = null;
        while (i < length) {
            int i2 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + charSequence + "(?:;([^:]*))?:", 2).matcher(str4);
            if (i > 0) {
                i--;
            }
            if (!matcher.find(i)) {
                break;
            }
            int end = matcher.end(0);
            String group = matcher.group(1);
            if (group != null) {
                String[] split = SEMICOLON.split(group);
                int length2 = split.length;
                int i3 = 0;
                arrayList = null;
                z2 = false;
                str2 = null;
                while (i3 < length2) {
                    String str5 = split[i3];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str5);
                    String[] split2 = EQUALS.split(str5, i2);
                    if (split2.length > 1) {
                        String str6 = split2[0];
                        String str7 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str6) && "QUOTED-PRINTABLE".equalsIgnoreCase(str7)) {
                            z2 = true;
                        } else if ("CHARSET".equalsIgnoreCase(str6)) {
                            str2 = str7;
                        }
                    }
                    i3++;
                    i2 = 2;
                }
            } else {
                arrayList = null;
                z2 = false;
                str2 = null;
            }
            int i4 = end;
            while (true) {
                indexOf = str4.indexOf(10, i4);
                if (indexOf >= 0) {
                    if (indexOf < str.length() - 1) {
                        int i5 = indexOf + 1;
                        if (str4.charAt(i5) == ' ' || str4.charAt(i5) == 9) {
                            i4 = indexOf + 2;
                        }
                    }
                    if (!z2 || (str4.charAt(indexOf - 1) != '=' && str4.charAt(indexOf - 2) != '=')) {
                        break;
                    }
                    i4 = indexOf + 1;
                } else {
                    break;
                }
            }
            if (indexOf < 0) {
                i = length;
            } else {
                if (indexOf > end) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (str4.charAt(indexOf - 1) == 13) {
                        indexOf--;
                    }
                    String substring = str4.substring(end, indexOf);
                    if (z) {
                        substring = substring.trim();
                    }
                    if (z2) {
                        str3 = decodeQuotedPrintable(substring, str2);
                    } else {
                        str3 = VCARD_ESCAPES.matcher(NEWLINE_ESCAPE.matcher(CR_LF_SPACE_TAB.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(str3);
                        arrayList2.add(arrayList3);
                    } else {
                        arrayList.add(0, str3);
                        arrayList2.add(arrayList);
                    }
                }
                i = indexOf + 1;
            }
        }
        return arrayList2;
    }

    private static String decodeQuotedPrintable(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char charAt2 = charSequence.charAt(i);
            if (!(charAt2 == 10 || charAt2 == 13)) {
                if (charAt2 != '=') {
                    maybeAppendFragment(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (!(i >= length - 2 || (charAt = charSequence.charAt(i + 1)) == 13 || charAt == 10)) {
                    i += 2;
                    char charAt3 = charSequence.charAt(i);
                    int parseHexDigit = parseHexDigit(charAt);
                    int parseHexDigit2 = parseHexDigit(charAt3);
                    if (parseHexDigit >= 0 && parseHexDigit2 >= 0) {
                        byteArrayOutputStream.write((parseHexDigit << 4) + parseHexDigit2);
                    }
                }
            }
            i++;
        }
        maybeAppendFragment(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void maybeAppendFragment(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    static List<String> matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField(charSequence, str, z);
        if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
            return null;
        }
        return matchVCardPrefixedField.get(0);
    }

    private static String toPrimaryValue(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] toPrimaryValues(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            arrayList.add(list.get(0));
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    private static String[] toTypes(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List next : collection) {
            int i = 1;
            while (true) {
                if (i >= next.size()) {
                    str = null;
                    break;
                }
                String str2 = (String) next.get(i);
                int indexOf = str2.indexOf(61);
                if (indexOf < 0) {
                    str = str2;
                    break;
                } else if (Intents.WifiConnect.TYPE.equalsIgnoreCase(str2.substring(0, indexOf))) {
                    str = str2.substring(indexOf + 1);
                    break;
                } else {
                    i++;
                }
            }
            arrayList.add(str);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    private static boolean isLikeVCardDate(CharSequence charSequence) {
        return charSequence == null || VCARD_LIKE_DATE.matcher(charSequence).matches();
    }

    private static void formatNames(Iterable<List<String>> iterable) {
        if (iterable != null) {
            for (List next : iterable) {
                String str = (String) next.get(0);
                String[] strArr = new String[5];
                int i = 0;
                int i2 = 0;
                while (true) {
                    int indexOf = str.indexOf(59, i);
                    if (indexOf <= 0) {
                        break;
                    }
                    strArr[i2] = str.substring(i, indexOf);
                    i2++;
                    i = indexOf + 1;
                }
                strArr[i2] = str.substring(i);
                StringBuilder sb = new StringBuilder(100);
                maybeAppendComponent(strArr, 3, sb);
                maybeAppendComponent(strArr, 1, sb);
                maybeAppendComponent(strArr, 2, sb);
                maybeAppendComponent(strArr, 0, sb);
                maybeAppendComponent(strArr, 4, sb);
                next.set(0, sb.toString().trim());
            }
        }
    }

    private static void maybeAppendComponent(String[] strArr, int i, StringBuilder sb) {
        if (strArr[i] != null) {
            sb.append(' ');
            sb.append(strArr[i]);
        }
    }
}
