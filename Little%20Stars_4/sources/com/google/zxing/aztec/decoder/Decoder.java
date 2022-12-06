package com.google.zxing.aztec.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

public final class Decoder {
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", PushConstants.PUSH_TYPE_NOTIFY, "1", "2", "3", "4", "5", "6", "7", "8", "9", Constants.ACCEPT_TIME_SEPARATOR_SP, ".", "CTRL_UL", "CTRL_US"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", NotifyType.LIGHTS, "m", "n", "o", "p", "q", "r", NotifyType.SOUND, "t", "u", NotifyType.VIBRATE, "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final int[] NB_BITS = {0, 128, 288, 480, 704, 960, 1248, 1568, 1920, 2304, 2720, 3168, 3648, 4160, 4704, 5280, 5888, 6528, 7200, 7904, 8640, 9408, 10208, 11040, 11904, 12800, 13728, 14688, 15680, 16704, 17760, 18848, 19968};
    private static final int[] NB_BITS_COMPACT = {0, 104, 240, 408, 608};
    private static final int[] NB_DATABLOCK = {0, 21, 48, 60, 88, 120, 156, 196, 240, 230, 272, 316, 364, 416, 470, 528, 588, 652, 720, 790, 864, 940, 1020, 920, 992, 1066, 1144, 1224, 1306, 1392, 1480, 1570, 1664};
    private static final int[] NB_DATABLOCK_COMPACT = {0, 17, 40, 51, 76};
    private static final String[] PUNCT_TABLE = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER, ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private int codewordSize;
    private AztecDetectorResult ddata;
    private int invertedBitCount;
    private int numCodewords;

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        BitMatrix bits = aztecDetectorResult.getBits();
        if (!this.ddata.isCompact()) {
            bits = removeDashedLines(this.ddata.getBits());
        }
        return new DecoderResult((byte[]) null, getEncodedData(correctBits(extractBits(bits))), (List<byte[]>) null, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getEncodedData(boolean[] r14) throws com.google.zxing.FormatException {
        /*
            r13 = this;
            int r0 = r13.codewordSize
            com.google.zxing.aztec.AztecDetectorResult r1 = r13.ddata
            int r1 = r1.getNbDatablocks()
            int r0 = r0 * r1
            int r1 = r13.invertedBitCount
            int r0 = r0 - r1
            int r1 = r14.length
            if (r0 > r1) goto L_0x0085
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.UPPER
            com.google.zxing.aztec.decoder.Decoder$Table r2 = com.google.zxing.aztec.decoder.Decoder.Table.UPPER
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 20
            r3.<init>(r4)
            r4 = 0
            r7 = r1
            r5 = r2
            r1 = 0
            r2 = 0
            r6 = 0
        L_0x0021:
            r8 = 0
        L_0x0022:
            if (r1 != 0) goto L_0x0080
            r9 = 1
            if (r2 == 0) goto L_0x0029
            r8 = 1
            goto L_0x002a
        L_0x0029:
            r7 = r5
        L_0x002a:
            int[] r10 = com.google.zxing.aztec.decoder.Decoder.AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table
            int r11 = r5.ordinal()
            r10 = r10[r11]
            if (r10 == r9) goto L_0x0069
            com.google.zxing.aztec.decoder.Decoder$Table r10 = com.google.zxing.aztec.decoder.Decoder.Table.DIGIT
            r11 = 5
            if (r5 != r10) goto L_0x003b
            r10 = 4
            goto L_0x003c
        L_0x003b:
            r10 = 5
        L_0x003c:
            int r12 = r0 - r6
            if (r12 >= r10) goto L_0x0041
            goto L_0x006f
        L_0x0041:
            int r12 = readCode(r14, r6, r10)
            int r6 = r6 + r10
            java.lang.String r10 = getCharacter(r5, r12)
            java.lang.String r12 = "CTRL_"
            boolean r12 = r10.startsWith(r12)
            if (r12 == 0) goto L_0x0065
            char r5 = r10.charAt(r11)
            com.google.zxing.aztec.decoder.Decoder$Table r5 = getTable(r5)
            r11 = 6
            char r10 = r10.charAt(r11)
            r11 = 83
            if (r10 != r11) goto L_0x007b
            r2 = 1
            goto L_0x007b
        L_0x0065:
            r3.append(r10)
            goto L_0x007b
        L_0x0069:
            int r10 = r0 - r6
            r11 = 8
            if (r10 >= r11) goto L_0x0071
        L_0x006f:
            r1 = 1
            goto L_0x007b
        L_0x0071:
            int r9 = readCode(r14, r6, r11)
            int r6 = r6 + 8
            char r9 = (char) r9
            r3.append(r9)
        L_0x007b:
            if (r8 == 0) goto L_0x0022
            r5 = r7
            r2 = 0
            goto L_0x0021
        L_0x0080:
            java.lang.String r14 = r3.toString()
            return r14
        L_0x0085:
            com.google.zxing.FormatException r14 = com.google.zxing.FormatException.getFormatInstance()
            goto L_0x008b
        L_0x008a:
            throw r14
        L_0x008b:
            goto L_0x008a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.getEncodedData(boolean[]):java.lang.String");
    }

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = new int[Table.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.zxing.aztec.decoder.Decoder$Table[] r0 = com.google.zxing.aztec.decoder.Decoder.Table.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = r0
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.BINARY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.UPPER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.LOWER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.MIXED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.PUNCT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.DIGIT     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.AnonymousClass1.<clinit>():void");
        }
    }

    private static Table getTable(char c) {
        if (c == 'B') {
            return Table.BINARY;
        }
        if (c == 'D') {
            return Table.DIGIT;
        }
        if (c == 'P') {
            return Table.PUNCT;
        }
        if (c == 'L') {
            return Table.LOWER;
        }
        if (c != 'M') {
            return Table.UPPER;
        }
        return Table.MIXED;
    }

    private static String getCharacter(Table table, int i) {
        int i2 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i2 == 2) {
            return UPPER_TABLE[i];
        }
        if (i2 == 3) {
            return LOWER_TABLE[i];
        }
        if (i2 == 4) {
            return MIXED_TABLE[i];
        }
        if (i2 == 5) {
            return PUNCT_TABLE[i];
        }
        if (i2 != 6) {
            return "";
        }
        return DIGIT_TABLE[i];
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int i;
        int i2;
        if (this.ddata.getNbLayers() <= 2) {
            this.codewordSize = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            this.codewordSize = 8;
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            this.codewordSize = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            this.codewordSize = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        if (this.ddata.isCompact()) {
            i2 = NB_BITS_COMPACT[this.ddata.getNbLayers()] - (this.numCodewords * this.codewordSize);
            i = NB_DATABLOCK_COMPACT[this.ddata.getNbLayers()];
        } else {
            i2 = NB_BITS[this.ddata.getNbLayers()] - (this.numCodewords * this.codewordSize);
            i = NB_DATABLOCK[this.ddata.getNbLayers()];
        }
        int i3 = i - nbDatablocks;
        int[] iArr = new int[this.numCodewords];
        int i4 = 0;
        while (true) {
            int i5 = 1;
            if (i4 < this.numCodewords) {
                int i6 = 1;
                while (true) {
                    int i7 = this.codewordSize;
                    if (i5 > i7) {
                        break;
                    }
                    if (zArr[(((i7 * i4) + i7) - i5) + i2]) {
                        iArr[i4] = iArr[i4] + i6;
                    }
                    i6 <<= 1;
                    i5++;
                }
                i4++;
            } else {
                try {
                    break;
                } catch (ReedSolomonException unused) {
                    throw FormatException.getFormatInstance();
                }
            }
        }
        new ReedSolomonDecoder(genericGF).decode(iArr, i3);
        this.invertedBitCount = 0;
        boolean[] zArr2 = new boolean[(this.codewordSize * nbDatablocks)];
        int i8 = 0;
        int i9 = 0;
        while (i8 < nbDatablocks) {
            int i10 = 1 << (this.codewordSize - 1);
            int i11 = i9;
            int i12 = 0;
            boolean z = false;
            for (int i13 = 0; i13 < this.codewordSize; i13++) {
                boolean z2 = (iArr[i8] & i10) == i10;
                if (i12 != this.codewordSize - 1) {
                    if (z == z2) {
                        i12++;
                    } else {
                        z = z2;
                        i12 = 1;
                    }
                    zArr2[((this.codewordSize * i8) + i13) - i11] = z2;
                } else if (z2 != z) {
                    i11++;
                    this.invertedBitCount++;
                    i12 = 0;
                    z = false;
                } else {
                    throw FormatException.getFormatInstance();
                }
                i10 >>>= 1;
            }
            i8++;
            i9 = i11;
        }
        return zArr2;
    }

    private boolean[] extractBits(BitMatrix bitMatrix) throws FormatException {
        boolean[] zArr;
        int i;
        if (this.ddata.isCompact()) {
            int nbLayers = this.ddata.getNbLayers();
            int[] iArr = NB_BITS_COMPACT;
            if (nbLayers <= iArr.length) {
                zArr = new boolean[iArr[this.ddata.getNbLayers()]];
                this.numCodewords = NB_DATABLOCK_COMPACT[this.ddata.getNbLayers()];
            } else {
                throw FormatException.getFormatInstance();
            }
        } else {
            int nbLayers2 = this.ddata.getNbLayers();
            int[] iArr2 = NB_BITS;
            if (nbLayers2 <= iArr2.length) {
                zArr = new boolean[iArr2[this.ddata.getNbLayers()]];
                this.numCodewords = NB_DATABLOCK[this.ddata.getNbLayers()];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        int nbLayers3 = this.ddata.getNbLayers();
        int height = bitMatrix.getHeight();
        int i2 = 0;
        int i3 = 0;
        while (nbLayers3 != 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = height * 2;
                if (i4 >= i - 4) {
                    break;
                }
                int i6 = (i4 / 2) + i3;
                zArr[i2 + i4] = bitMatrix.get(i3 + i5, i6);
                zArr[((i + i2) - 4) + i4] = bitMatrix.get(i6, ((i3 + height) - 1) - i5);
                i5 = (i5 + 1) % 2;
                i4++;
            }
            int i7 = 0;
            for (int i8 = i + 1; i8 > 5; i8--) {
                int i9 = i - i8;
                int i10 = ((i8 / 2) + i3) - 1;
                zArr[(((height * 4) + i2) - 8) + i9 + 1] = bitMatrix.get(((i3 + height) - 1) - i7, i10);
                zArr[(((height * 6) + i2) - 12) + i9 + 1] = bitMatrix.get(i10, i3 + i7);
                i7 = (i7 + 1) % 2;
            }
            i3 += 2;
            i2 += (height * 8) - 16;
            nbLayers3--;
            height -= 4;
        }
        return zArr;
    }

    private static BitMatrix removeDashedLines(BitMatrix bitMatrix) {
        int width = ((((bitMatrix.getWidth() - 1) / 2) / 16) * 2) + 1;
        BitMatrix bitMatrix2 = new BitMatrix(bitMatrix.getWidth() - width, bitMatrix.getHeight() - width);
        int i = 0;
        for (int i2 = 0; i2 < bitMatrix.getWidth(); i2++) {
            if (((bitMatrix.getWidth() / 2) - i2) % 16 != 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < bitMatrix.getHeight(); i4++) {
                    if (((bitMatrix.getWidth() / 2) - i4) % 16 != 0) {
                        if (bitMatrix.get(i2, i4)) {
                            bitMatrix2.set(i, i3);
                        }
                        i3++;
                    }
                }
                i++;
            }
        }
        return bitMatrix2;
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3++;
            }
        }
        return i3;
    }
}
