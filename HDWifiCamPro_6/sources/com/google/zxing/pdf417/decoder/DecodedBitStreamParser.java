package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

final class DecodedBitStreamParser {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = null;
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900 = new BigInteger[16];
    private static final int LL = 27;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|8|9|10|11|12|13|(2:14|15)|16|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode() {
        /*
            int[] r0 = $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode[] r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED     // Catch:{ NoSuchFieldError -> 0x0030 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0030 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0030 }
        L_0x0030:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT     // Catch:{ NoSuchFieldError -> 0x0039 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
        L_0x0039:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT     // Catch:{ NoSuchFieldError -> 0x0042 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0042 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0042 }
        L_0x0042:
            $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.$SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode():int[]");
    }

    static {
        EXP900[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr = EXP900;
            if (i < bigIntegerArr.length) {
                bigIntegerArr[i] = bigIntegerArr[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i;
        int i2 = 2;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i3 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        while (i2 < iArr[0]) {
            if (i3 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i3) {
                    case TEXT_COMPACTION_MODE_LATCH /*900*/:
                        i = textCompaction(iArr, i2, sb);
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        i = byteCompaction(i3, iArr, charset, i2, sb);
                        break;
                    case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                        i = numericCompaction(iArr, i2, sb);
                        break;
                    default:
                        switch (i3) {
                            case MACRO_PDF417_TERMINATOR /*922*/:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                break;
                            case ECI_USER_DEFINED /*925*/:
                                i = i2 + 1;
                                break;
                            case ECI_GENERAL_PURPOSE /*926*/:
                                i = i2 + 2;
                                break;
                            case ECI_CHARSET /*927*/:
                                Charset forName = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i2]).name());
                                i = i2 + 1;
                                charset = forName;
                                break;
                            case 928:
                                i = decodeMacroBlock(iArr, i2, pDF417ResultMetadata);
                                break;
                            default:
                                i = textCompaction(iArr, i2 - 1, sb);
                                break;
                        }
                        i = byteCompaction(i3, iArr, charset, i2, sb);
                        break;
                }
            } else {
                sb.append((char) iArr[i2]);
                i = i2 + 1;
            }
            if (i < iArr.length) {
                int i4 = i + 1;
                i3 = iArr[i];
                i2 = i4;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i2, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            int i4 = iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD ? textCompaction + 1 : -1;
            while (textCompaction < iArr[0]) {
                int i5 = iArr[textCompaction];
                if (i5 == MACRO_PDF417_TERMINATOR) {
                    textCompaction++;
                    pDF417ResultMetadata.setLastSegment(true);
                } else if (i5 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                    int i6 = textCompaction + 1;
                    switch (iArr[i6]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb2);
                            pDF417ResultMetadata.setFileName(sb2.toString());
                            break;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb3);
                            pDF417ResultMetadata.setSegmentCount(Integer.parseInt(sb3.toString()));
                            break;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb4);
                            pDF417ResultMetadata.setTimestamp(Long.parseLong(sb4.toString()));
                            break;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb5);
                            pDF417ResultMetadata.setSender(sb5.toString());
                            break;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb6);
                            pDF417ResultMetadata.setAddressee(sb6.toString());
                            break;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb7);
                            pDF417ResultMetadata.setFileSize(Long.parseLong(sb7.toString()));
                            break;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb8);
                            pDF417ResultMetadata.setChecksum(Integer.parseInt(sb8.toString()));
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i4 != -1) {
                int i7 = textCompaction - i4;
                if (pDF417ResultMetadata.isLastSegment()) {
                    i7--;
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i4, i7 + i4));
            }
            return textCompaction;
        }
        throw FormatException.getFormatInstance();
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[((iArr[0] - i) * 2)];
        int[] iArr3 = new int[((iArr[0] - i) * 2)];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != 928) {
                    switch (i4) {
                        case TEXT_COMPACTION_MODE_LATCH /*900*/:
                            iArr2[i2] = TEXT_COMPACTION_MODE_LATCH;
                            i2++;
                            break;
                        case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                            break;
                        default:
                            switch (i4) {
                                case MACRO_PDF417_TERMINATOR /*922*/:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                    break;
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cb, code lost:
        r4 = (char) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d7, code lost:
        r4 = 0;
        r11 = r3;
        r3 = r1;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e2, code lost:
        r4 = ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ee, code lost:
        if (r4 == 0) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00f0, code lost:
        r15.append(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00f3, code lost:
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decodeTextCompaction(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r2 = 0
            r3 = r1
            r1 = r0
            r0 = r2
        L_0x0008:
            if (r0 < r14) goto L_0x000b
            return
        L_0x000b:
            r4 = r12[r0]
            int[] r5 = $SWITCH_TABLE$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode()
            int r6 = r1.ordinal()
            r5 = r5[r6]
            r6 = 32
            r7 = 29
            r8 = 26
            r9 = 913(0x391, float:1.28E-42)
            r10 = 900(0x384, float:1.261E-42)
            switch(r5) {
                case 1: goto L_0x00c7;
                case 2: goto L_0x00a7;
                case 3: goto L_0x007b;
                case 4: goto L_0x005b;
                case 5: goto L_0x0044;
                case 6: goto L_0x0026;
                default: goto L_0x0024;
            }
        L_0x0024:
            goto L_0x00ed
        L_0x0026:
            if (r4 >= r7) goto L_0x002d
            char[] r1 = PUNCT_CHARS
            char r1 = r1[r4]
            goto L_0x0049
        L_0x002d:
            if (r4 == r7) goto L_0x0040
            if (r4 == r10) goto L_0x003c
            if (r4 == r9) goto L_0x0034
            goto L_0x003a
        L_0x0034:
            r1 = r13[r0]
            char r1 = (char) r1
            r15.append(r1)
        L_0x003a:
            r4 = r2
            goto L_0x004a
        L_0x003c:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ed
        L_0x0040:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ed
        L_0x0044:
            if (r4 >= r8) goto L_0x004d
            int r4 = r4 + 65
            char r1 = (char) r4
        L_0x0049:
            r4 = r1
        L_0x004a:
            r1 = r3
            goto L_0x00ee
        L_0x004d:
            if (r4 == r8) goto L_0x0058
            if (r4 == r10) goto L_0x0054
            r1 = r3
            goto L_0x00ed
        L_0x0054:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ed
        L_0x0058:
            r1 = r3
            goto L_0x00e2
        L_0x005b:
            if (r4 >= r7) goto L_0x0063
            char[] r5 = PUNCT_CHARS
            char r4 = r5[r4]
            goto L_0x00ee
        L_0x0063:
            if (r4 == r7) goto L_0x0077
            if (r4 == r10) goto L_0x0073
            if (r4 == r9) goto L_0x006b
            goto L_0x00ed
        L_0x006b:
            r4 = r13[r0]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00ed
        L_0x0073:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ed
        L_0x0077:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ed
        L_0x007b:
            r5 = 25
            if (r4 >= r5) goto L_0x0085
            char[] r5 = MIXED_CHARS
            char r4 = r5[r4]
            goto L_0x00ee
        L_0x0085:
            if (r4 == r10) goto L_0x00a4
            if (r4 == r9) goto L_0x009d
            switch(r4) {
                case 25: goto L_0x0099;
                case 26: goto L_0x00e2;
                case 27: goto L_0x0095;
                case 28: goto L_0x0091;
                case 29: goto L_0x008e;
                default: goto L_0x008c;
            }
        L_0x008c:
            goto L_0x00ed
        L_0x008e:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00d7
        L_0x0091:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ed
        L_0x0095:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00ed
        L_0x0099:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
            goto L_0x00ed
        L_0x009d:
            r4 = r13[r0]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00ed
        L_0x00a4:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ed
        L_0x00a7:
            if (r4 >= r8) goto L_0x00ac
            int r4 = r4 + 97
            goto L_0x00cb
        L_0x00ac:
            if (r4 == r10) goto L_0x00c4
            if (r4 == r9) goto L_0x00bd
            switch(r4) {
                case 26: goto L_0x00e2;
                case 27: goto L_0x00ba;
                case 28: goto L_0x00b7;
                case 29: goto L_0x00b4;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            goto L_0x00ed
        L_0x00b4:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00d7
        L_0x00b7:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00ed
        L_0x00ba:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
            goto L_0x00d7
        L_0x00bd:
            r4 = r13[r0]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00ed
        L_0x00c4:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00ed
        L_0x00c7:
            if (r4 >= r8) goto L_0x00cd
            int r4 = r4 + 65
        L_0x00cb:
            char r4 = (char) r4
            goto L_0x00ee
        L_0x00cd:
            if (r4 == r10) goto L_0x00eb
            if (r4 == r9) goto L_0x00e4
            switch(r4) {
                case 26: goto L_0x00e2;
                case 27: goto L_0x00df;
                case 28: goto L_0x00dc;
                case 29: goto L_0x00d5;
                default: goto L_0x00d4;
            }
        L_0x00d4:
            goto L_0x00ed
        L_0x00d5:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
        L_0x00d7:
            r4 = r2
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x00ee
        L_0x00dc:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00ed
        L_0x00df:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00ed
        L_0x00e2:
            r4 = r6
            goto L_0x00ee
        L_0x00e4:
            r4 = r13[r0]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00ed
        L_0x00eb:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
        L_0x00ed:
            r4 = r2
        L_0x00ee:
            if (r4 == 0) goto L_0x00f3
            r15.append(r4)
        L_0x00f3:
            int r0 = r0 + 1
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        int i4;
        long j;
        int i5;
        int i6;
        int i7 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j2 = 900;
        int i8 = 6;
        if (i7 == BYTE_COMPACTION_MODE_LATCH) {
            int[] iArr2 = new int[6];
            int i9 = i2 + 1;
            int i10 = iArr[i2];
            boolean z = false;
            int i11 = 0;
            while (true) {
                long j3 = 0;
                while (i5 < iArr[0] && !z) {
                    int i12 = i4 + 1;
                    iArr2[i4] = i10;
                    j3 = (j3 * j) + ((long) i10);
                    int i13 = i5 + 1;
                    i10 = iArr[i5];
                    if (i10 != 928) {
                        switch (i10) {
                            case TEXT_COMPACTION_MODE_LATCH /*900*/:
                            case BYTE_COMPACTION_MODE_LATCH /*901*/:
                            case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                                break;
                            default:
                                switch (i10) {
                                    case MACRO_PDF417_TERMINATOR /*922*/:
                                    case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                    case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                        break;
                                    default:
                                        if (i12 % 5 != 0 || i12 <= 0) {
                                            z = z;
                                            i5 = i13;
                                            i4 = i12;
                                            j = 900;
                                            i8 = 6;
                                            break;
                                        } else {
                                            int i14 = 0;
                                            while (i14 < i8) {
                                                byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i14) * 8))));
                                                i14++;
                                                i8 = 6;
                                                z = z;
                                            }
                                            i9 = i13;
                                            i11 = 0;
                                            j2 = 900;
                                        }
                                }
                                break;
                        }
                    }
                    i5 = i13 - 1;
                    i4 = i12;
                    j = 900;
                    i8 = 6;
                    z = true;
                }
            }
            if (i5 != iArr[0] || i10 >= TEXT_COMPACTION_MODE_LATCH) {
                i6 = i4;
            } else {
                i6 = i4 + 1;
                iArr2[i4] = i10;
            }
            for (int i15 = 0; i15 < i6; i15++) {
                Charset charset2 = charset;
                StringBuilder sb2 = sb;
                byteArrayOutputStream.write((byte) iArr2[i15]);
            }
            i3 = i5;
        } else if (i7 != BYTE_COMPACTION_MODE_LATCH_6) {
            i3 = i2;
        } else {
            i3 = i2;
            boolean z2 = false;
            int i16 = 0;
            while (true) {
                long j4 = 0;
                while (i3 < iArr[0] && !z2) {
                    int i17 = i3 + 1;
                    int i18 = iArr[i3];
                    if (i18 < TEXT_COMPACTION_MODE_LATCH) {
                        i16++;
                        j4 = (j4 * 900) + ((long) i18);
                    } else {
                        if (i18 != 928) {
                            switch (i18) {
                                case TEXT_COMPACTION_MODE_LATCH /*900*/:
                                case BYTE_COMPACTION_MODE_LATCH /*901*/:
                                case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                                    break;
                                default:
                                    switch (i18) {
                                        case MACRO_PDF417_TERMINATOR /*922*/:
                                        case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                        case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                            break;
                                    }
                            }
                        }
                        i3 = i17 - 1;
                        z2 = true;
                        if (i16 % 5 != 0 && i16 > 0) {
                            for (int i19 = 0; i19 < 6; i19++) {
                                byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i19) * 8))));
                            }
                            i16 = 0;
                        }
                    }
                    i3 = i17;
                    if (i16 % 5 != 0) {
                    }
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4;
                i2++;
            } else {
                if (!(i4 == TEXT_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == 928)) {
                    switch (i4) {
                        case MACRO_PDF417_TERMINATOR /*922*/:
                        case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                        case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                            break;
                    }
                }
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == NUMERIC_COMPACTION_MODE_LATCH || z) && i2 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
