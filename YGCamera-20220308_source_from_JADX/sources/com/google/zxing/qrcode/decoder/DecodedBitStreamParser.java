package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

final class DecodedBitStreamParser {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode = null;
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    /* JADX WARNING: Can't wrap try/catch for region: R(22:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|(2:22|23)|24|26) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0045 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0057 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode() {
        /*
            int[] r0 = $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.google.zxing.qrcode.decoder.Mode[] r0 = com.google.zxing.qrcode.decoder.Mode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.BYTE     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ECI     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION     // Catch:{ NoSuchFieldError -> 0x0031 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0031 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0031 }
        L_0x0031:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.FNC1_SECOND_POSITION     // Catch:{ NoSuchFieldError -> 0x003b }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
            r2 = 9
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
        L_0x003b:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.HANZI     // Catch:{ NoSuchFieldError -> 0x0045 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
            r2 = 10
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0045 }
        L_0x0045:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.KANJI     // Catch:{ NoSuchFieldError -> 0x004e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
        L_0x004e:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0057 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0057 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0057 }
        L_0x0057:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.STRUCTURED_APPEND     // Catch:{ NoSuchFieldError -> 0x0060 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
        L_0x0060:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.TERMINATOR     // Catch:{ NoSuchFieldError -> 0x0069 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0069 }
        L_0x0069:
            $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.DecodedBitStreamParser.$SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode():int[]");
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode forBits;
        Mode mode;
        String str;
        Version version2 = version;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        boolean z = false;
        CharacterSetECI characterSetECI = null;
        int i = -1;
        int i2 = -1;
        do {
            try {
                if (bitSource.available() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(bitSource.readBits(4));
                }
                Mode mode2 = forBits;
                int i3 = $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode()[mode2.ordinal()];
                if (i3 != 1) {
                    if (i3 == 4) {
                        mode = mode2;
                        if (bitSource.available() >= 16) {
                            int readBits = bitSource.readBits(8);
                            i2 = bitSource.readBits(8);
                            i = readBits;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    } else if (i3 != 6) {
                        switch (i3) {
                            case 8:
                            case 9:
                                mode = mode2;
                                z = true;
                                break;
                            case 10:
                                mode = mode2;
                                int readBits2 = bitSource.readBits(4);
                                int readBits3 = bitSource.readBits(mode.getCharacterCountBits(version2));
                                if (readBits2 == 1) {
                                    decodeHanziSegment(bitSource, sb, readBits3);
                                    break;
                                }
                                break;
                            default:
                                int readBits4 = bitSource.readBits(mode2.getCharacterCountBits(version2));
                                int i4 = $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode()[mode2.ordinal()];
                                if (i4 != 2) {
                                    if (i4 != 3) {
                                        if (i4 == 5) {
                                            mode = mode2;
                                            decodeByteSegment(bitSource, sb, readBits4, characterSetECI, arrayList, map);
                                            break;
                                        } else if (i4 == 7) {
                                            decodeKanjiSegment(bitSource, sb, readBits4);
                                            break;
                                        } else {
                                            throw FormatException.getFormatInstance();
                                        }
                                    } else {
                                        mode = mode2;
                                        decodeAlphanumericSegment(bitSource, sb, readBits4, z);
                                        break;
                                    }
                                } else {
                                    mode = mode2;
                                    decodeNumericSegment(bitSource, sb, readBits4);
                                    break;
                                }
                        }
                    } else {
                        mode = mode2;
                        characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                        if (characterSetECI == null) {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
                mode = mode2;
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        } while (mode != Mode.TERMINATOR);
        String sb2 = sb.toString();
        ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
        if (errorCorrectionLevel == null) {
            str = null;
        } else {
            str = errorCorrectionLevel.toString();
        }
        return new DecoderResult(bArr, sb2, arrayList2, str, i, i2);
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int readBits = bitSource.readBits(13);
                int i3 = (readBits % 96) | ((readBits / 96) << 8);
                int i4 = i3 + (i3 < 2560 ? 41377 : 42657);
                bArr[i2] = (byte) ((i4 >> 8) & 255);
                bArr[i2 + 1] = (byte) (i4 & 255);
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, StringUtils.GB2312));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int readBits = bitSource.readBits(13);
                int i3 = (readBits % 192) | ((readBits / 192) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, StringUtils.SHIFT_JIS));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String str;
        if (i * 8 <= bitSource.available()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) bitSource.readBits(8);
            }
            if (characterSetECI == null) {
                str = StringUtils.guessEncoding(bArr, map);
            } else {
                str = characterSetECI.name();
            }
            try {
                sb.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static char toAlphaNumericChar(int i) throws FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.getFormatInstance();
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (bitSource.available() >= 11) {
                int readBits = bitSource.readBits(11);
                sb.append(toAlphaNumericChar(readBits / 45));
                sb.append(toAlphaNumericChar(readBits % 45));
                i -= 2;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i == 1) {
            if (bitSource.available() >= 6) {
                sb.append(toAlphaNumericChar(bitSource.readBits(6)));
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.available() >= 10) {
                int readBits = bitSource.readBits(10);
                if (readBits < 1000) {
                    sb.append(toAlphaNumericChar(readBits / 100));
                    sb.append(toAlphaNumericChar((readBits / 10) % 10));
                    sb.append(toAlphaNumericChar(readBits % 10));
                    i -= 3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i == 2) {
            if (bitSource.available() >= 7) {
                int readBits2 = bitSource.readBits(7);
                if (readBits2 < 100) {
                    sb.append(toAlphaNumericChar(readBits2 / 10));
                    sb.append(toAlphaNumericChar(readBits2 % 10));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        } else if (i != 1) {
        } else {
            if (bitSource.available() >= 4) {
                int readBits3 = bitSource.readBits(4);
                if (readBits3 < 10) {
                    sb.append(toAlphaNumericChar(readBits3));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
    }

    private static int parseECIValue(BitSource bitSource) throws FormatException {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return bitSource.readBits(8) | ((readBits & 63) << 8);
        }
        if ((readBits & 224) == 192) {
            return bitSource.readBits(16) | ((readBits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }
}
