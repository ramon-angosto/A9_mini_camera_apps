package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;

/* compiled from: SameBase64Tool */
public class l {
    private static final String a = l.class.getSimpleName();
    private static Map<Character, Character> b;
    private static Map<Character, Character> c;
    private static char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    static {
        b = null;
        c = null;
        c = new HashMap();
        c.put('v', 'A');
        c.put('S', 'B');
        c.put('o', 'C');
        c.put('a', 'D');
        c.put('j', 'E');
        c.put('c', 'F');
        c.put('7', 'G');
        c.put('d', 'H');
        c.put('R', 'I');
        c.put('z', 'J');
        c.put('p', 'K');
        c.put('W', 'L');
        c.put('i', 'M');
        c.put('f', 'N');
        c.put('G', 'O');
        c.put('y', 'P');
        c.put('N', 'Q');
        c.put('x', 'R');
        c.put('Z', 'S');
        c.put('n', 'T');
        c.put('V', 'U');
        c.put('5', 'V');
        c.put('k', 'W');
        c.put('+', 'X');
        c.put('D', 'Y');
        c.put('H', 'Z');
        c.put('L', 'a');
        c.put('Y', 'b');
        c.put('h', 'c');
        c.put('J', 'd');
        c.put('4', 'e');
        c.put('6', 'f');
        c.put('l', 'g');
        c.put('t', 'h');
        c.put('0', 'i');
        c.put('U', 'j');
        c.put('3', 'k');
        c.put('Q', 'l');
        c.put('r', 'm');
        c.put('g', 'n');
        c.put('E', 'o');
        c.put('u', 'p');
        c.put('q', 'q');
        c.put('8', 'r');
        c.put('s', 's');
        c.put('w', 't');
        c.put('/', 'u');
        c.put('X', 'v');
        c.put('M', 'w');
        c.put('e', 'x');
        c.put('B', 'y');
        c.put('A', 'z');
        c.put('T', '0');
        c.put('2', '1');
        c.put('F', '2');
        c.put('b', '3');
        c.put('9', '4');
        c.put('P', '5');
        c.put('1', '6');
        c.put('O', '7');
        c.put('I', '8');
        c.put('K', '9');
        c.put('m', '+');
        c.put('C', '/');
        b = new HashMap();
        b.put('A', 'v');
        b.put('B', 'S');
        b.put('C', 'o');
        b.put('D', 'a');
        b.put('E', 'j');
        b.put('F', 'c');
        b.put('G', '7');
        b.put('H', 'd');
        b.put('I', 'R');
        b.put('J', 'z');
        b.put('K', 'p');
        b.put('L', 'W');
        b.put('M', 'i');
        b.put('N', 'f');
        b.put('O', 'G');
        b.put('P', 'y');
        b.put('Q', 'N');
        b.put('R', 'x');
        b.put('S', 'Z');
        b.put('T', 'n');
        b.put('U', 'V');
        b.put('V', '5');
        b.put('W', 'k');
        b.put('X', '+');
        b.put('Y', 'D');
        b.put('Z', 'H');
        b.put('a', 'L');
        b.put('b', 'Y');
        b.put('c', 'h');
        b.put('d', 'J');
        b.put('e', '4');
        b.put('f', '6');
        b.put('g', 'l');
        b.put('h', 't');
        b.put('i', '0');
        b.put('j', 'U');
        b.put('k', '3');
        b.put('l', 'Q');
        b.put('m', 'r');
        b.put('n', 'g');
        b.put('o', 'E');
        b.put('p', 'u');
        b.put('q', 'q');
        b.put('r', '8');
        b.put('s', 's');
        b.put('t', 'w');
        b.put('u', '/');
        b.put('v', 'X');
        b.put('w', 'M');
        b.put('x', 'e');
        b.put('y', 'B');
        b.put('z', 'A');
        b.put('0', 'T');
        b.put('1', '2');
        b.put('2', 'F');
        b.put('3', 'b');
        b.put('4', '9');
        b.put('5', 'P');
        b.put('6', '1');
        b.put('7', 'O');
        b.put('8', 'I');
        b.put('9', 'K');
        b.put('+', 'm');
        b.put('/', 'C');
    }

    private l() {
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            byte b2 = bArr[i] & UByte.MAX_VALUE;
            if (i2 == length) {
                stringBuffer.append(d[b2 >>> 2]);
                stringBuffer.append(d[(b2 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i3 = i2 + 1;
            byte b3 = bArr[i2] & UByte.MAX_VALUE;
            if (i3 == length) {
                stringBuffer.append(d[b2 >>> 2]);
                stringBuffer.append(d[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
                stringBuffer.append(d[(b3 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i4 = i3 + 1;
            byte b4 = bArr[i3] & UByte.MAX_VALUE;
            stringBuffer.append(d[b2 >>> 2]);
            stringBuffer.append(d[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
            stringBuffer.append(d[((b3 & 15) << 2) | ((b4 & 192) >>> 6)]);
            stringBuffer.append(d[b4 & 63]);
            i = i4;
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return r.b(str);
    }

    public static String b(String str) {
        return r.a(str);
    }
}
