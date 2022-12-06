package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class Encoder {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode = null;
    private static final int[] ALPHANUMERIC_TABLE;
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

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
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.$SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode():int[]");
    }

    static {
        int[] iArr = new int[96];
        iArr[0] = -1;
        iArr[1] = -1;
        iArr[2] = -1;
        iArr[3] = -1;
        iArr[4] = -1;
        iArr[5] = -1;
        iArr[6] = -1;
        iArr[7] = -1;
        iArr[8] = -1;
        iArr[9] = -1;
        iArr[10] = -1;
        iArr[11] = -1;
        iArr[12] = -1;
        iArr[13] = -1;
        iArr[14] = -1;
        iArr[15] = -1;
        iArr[16] = -1;
        iArr[17] = -1;
        iArr[18] = -1;
        iArr[19] = -1;
        iArr[20] = -1;
        iArr[21] = -1;
        iArr[22] = -1;
        iArr[23] = -1;
        iArr[24] = -1;
        iArr[25] = -1;
        iArr[26] = -1;
        iArr[27] = -1;
        iArr[28] = -1;
        iArr[29] = -1;
        iArr[30] = -1;
        iArr[31] = -1;
        iArr[32] = 36;
        iArr[33] = -1;
        iArr[34] = -1;
        iArr[35] = -1;
        iArr[36] = 37;
        iArr[37] = 38;
        iArr[38] = -1;
        iArr[39] = -1;
        iArr[40] = -1;
        iArr[41] = -1;
        iArr[42] = 39;
        iArr[43] = 40;
        iArr[44] = -1;
        iArr[45] = 41;
        iArr[46] = 42;
        iArr[47] = 43;
        iArr[49] = 1;
        iArr[50] = 2;
        iArr[51] = 3;
        iArr[52] = 4;
        iArr[53] = 5;
        iArr[54] = 6;
        iArr[55] = 7;
        iArr[56] = 8;
        iArr[57] = 9;
        iArr[58] = 44;
        iArr[59] = -1;
        iArr[60] = -1;
        iArr[61] = -1;
        iArr[62] = -1;
        iArr[63] = -1;
        iArr[64] = -1;
        iArr[65] = 10;
        iArr[66] = 11;
        iArr[67] = 12;
        iArr[68] = 13;
        iArr[69] = 14;
        iArr[70] = 15;
        iArr[71] = 16;
        iArr[72] = 17;
        iArr[73] = 18;
        iArr[74] = 19;
        iArr[75] = 20;
        iArr[76] = 21;
        iArr[77] = 22;
        iArr[78] = 23;
        iArr[79] = 24;
        iArr[80] = 25;
        iArr[81] = 26;
        iArr[82] = 27;
        iArr[83] = 28;
        iArr[84] = 29;
        iArr[85] = 30;
        iArr[86] = 31;
        iArr[87] = 32;
        iArr[88] = 33;
        iArr[89] = 34;
        iArr[90] = 35;
        iArr[91] = -1;
        iArr[92] = -1;
        iArr[93] = -1;
        iArr[94] = -1;
        iArr[95] = -1;
        ALPHANUMERIC_TABLE = iArr;
    }

    private Encoder() {
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return encode(str, errorCorrectionLevel, (Map<EncodeHintType, ?>) null);
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        Version version;
        CharacterSetECI characterSetECIByName;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(EncodeHintType.CHARACTER_SET);
        String obj = z2 ? map.get(EncodeHintType.CHARACTER_SET).toString() : DEFAULT_BYTE_MODE_ENCODING;
        Mode chooseMode = chooseMode(str, obj);
        BitArray bitArray = new BitArray();
        if (chooseMode == Mode.BYTE && z2 && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(obj)) != null) {
            appendECI(characterSetECIByName, bitArray);
        }
        if (map == null || !map.containsKey(EncodeHintType.GS1_FORMAT)) {
            z = false;
        }
        if (z && Boolean.valueOf(map.get(EncodeHintType.GS1_FORMAT).toString()).booleanValue()) {
            appendModeInfo(Mode.FNC1_FIRST_POSITION, bitArray);
        }
        appendModeInfo(chooseMode, bitArray);
        BitArray bitArray2 = new BitArray();
        appendBytes(str, chooseMode, bitArray2, obj);
        if (map == null || !map.containsKey(EncodeHintType.QR_VERSION)) {
            version = recommendVersion(errorCorrectionLevel, chooseMode, bitArray, bitArray2);
        } else {
            version = Version.getVersionForNumber(Integer.parseInt(map.get(EncodeHintType.QR_VERSION).toString()));
            if (!willFit(calculateBitsNeeded(chooseMode, bitArray, bitArray2, version), version, errorCorrectionLevel)) {
                throw new WriterException("Data too big for requested version");
            }
        }
        BitArray bitArray3 = new BitArray();
        bitArray3.appendBitArray(bitArray);
        appendLengthInfo(chooseMode == Mode.BYTE ? bitArray2.getSizeInBytes() : str.length(), version, chooseMode, bitArray3);
        bitArray3.appendBitArray(bitArray2);
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords = version.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
        terminateBits(totalCodewords, bitArray3);
        BitArray interleaveWithECBytes = interleaveWithECBytes(bitArray3, version.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
        QRCode qRCode = new QRCode();
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(chooseMode);
        qRCode.setVersion(version);
        int dimensionForVersion = version.getDimensionForVersion();
        ByteMatrix byteMatrix = new ByteMatrix(dimensionForVersion, dimensionForVersion);
        int chooseMaskPattern = chooseMaskPattern(interleaveWithECBytes, errorCorrectionLevel, version, byteMatrix);
        qRCode.setMaskPattern(chooseMaskPattern);
        MatrixUtil.buildMatrix(interleaveWithECBytes, errorCorrectionLevel, version, chooseMaskPattern, byteMatrix);
        qRCode.setMatrix(byteMatrix);
        return qRCode;
    }

    private static Version recommendVersion(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) throws WriterException {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    private static int calculateBitsNeeded(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }

    static int getAlphanumericCode(int i) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, (String) null);
    }

    private static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (getAlphanumericCode(charAt) == -1) {
                return Mode.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        if (z2) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            int i = 0;
            while (i < length) {
                byte b = bytes[i] & 255;
                if ((b >= 129 && b <= 159) || (b >= 224 && b <= 235)) {
                    i += 2;
                }
                return false;
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i) {
                i2 = i3;
                i = calculateMaskPenalty;
            }
        }
        return i2;
    }

    private static Version chooseVersion(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            Version versionForNumber = Version.getVersionForNumber(i2);
            if (willFit(i, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean willFit(int i, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i + 7) / 8;
    }

    static void terminateBits(int i, BitArray bitArray) throws WriterException {
        int i2 = i * 8;
        if (bitArray.getSize() <= i2) {
            for (int i3 = 0; i3 < 4 && bitArray.getSize() < i2; i3++) {
                bitArray.appendBit(false);
            }
            int size = bitArray.getSize() & 7;
            if (size > 0) {
                while (size < 8) {
                    bitArray.appendBit(false);
                    size++;
                }
            }
            int sizeInBytes = i - bitArray.getSizeInBytes();
            for (int i4 = 0; i4 < sizeInBytes; i4++) {
                bitArray.appendBits((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (bitArray.getSize() != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i2);
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new WriterException("EC bytes mismatch");
            } else if (i3 != i6 + i5) {
                throw new WriterException("RS blocks mismatch");
            } else if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
            } else {
                iArr[0] = i10;
                iArr2[0] = i12;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    static BitArray interleaveWithECBytes(BitArray bitArray, int i, int i2, int i3) throws WriterException {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (bitArray.getSizeInBytes() == i5) {
            ArrayList<BlockPair> arrayList = new ArrayList<>(i6);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                getNumDataBytesAndNumECBytesForBlockID(i, i2, i3, i10, iArr, iArr2);
                int i11 = iArr[0];
                byte[] bArr = new byte[i11];
                bitArray.toBytes(i7 * 8, bArr, 0, i11);
                byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
                arrayList.add(new BlockPair(bArr, generateECBytes));
                i8 = Math.max(i8, i11);
                i9 = Math.max(i9, generateECBytes.length);
                i7 += iArr[0];
            }
            if (i5 == i7) {
                BitArray bitArray2 = new BitArray();
                for (int i12 = 0; i12 < i8; i12++) {
                    for (BlockPair dataBytes : arrayList) {
                        byte[] dataBytes2 = dataBytes.getDataBytes();
                        if (i12 < dataBytes2.length) {
                            bitArray2.appendBits(dataBytes2[i12], 8);
                        }
                    }
                }
                for (int i13 = 0; i13 < i9; i13++) {
                    for (BlockPair errorCorrectionBytes : arrayList) {
                        byte[] errorCorrectionBytes2 = errorCorrectionBytes.getErrorCorrectionBytes();
                        if (i13 < errorCorrectionBytes2.length) {
                            bitArray2.appendBits(errorCorrectionBytes2[i13], 8);
                        }
                    }
                }
                if (i4 == bitArray2.getSizeInBytes()) {
                    return bitArray2;
                }
                throw new WriterException("Interleaving error: " + i4 + " and " + bitArray2.getSizeInBytes() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] generateECBytes(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    static void appendLengthInfo(int i, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i2 = 1 << characterCountBits;
        if (i < i2) {
            bitArray.appendBits(i, characterCountBits);
            return;
        }
        throw new WriterException(String.valueOf(i) + " is bigger than " + (i2 - 1));
    }

    static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        int i = $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode()[mode.ordinal()];
        if (i == 2) {
            appendNumericBytes(str, bitArray);
        } else if (i == 3) {
            appendAlphanumericBytes(str, bitArray);
        } else if (i == 5) {
            append8BitBytes(str, bitArray, str2);
        } else if (i == 7) {
            appendKanjiBytes(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                bitArray.appendBits((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bitArray.appendBits((charAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    bitArray.appendBits(charAt, 4);
                }
            }
        }
    }

    static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i));
            if (alphanumericCode != -1) {
                int i2 = i + 1;
                if (i2 < length) {
                    int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i2));
                    if (alphanumericCode2 != -1) {
                        bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                        i += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    bitArray.appendBits(alphanumericCode, 6);
                    i = i2;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    static void append8BitBytes(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte appendBits : str.getBytes(str2)) {
                bitArray.appendBits(appendBits, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException((Throwable) e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d A[LOOP:0: B:6:0x000f->B:20:0x003d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void appendKanjiBytes(java.lang.String r6, com.google.zxing.common.BitArray r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x005c }
            int r0 = r6.length
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0054
            int r0 = r6.length
            int r0 = r0 + -1
            r1 = 0
        L_0x000f:
            if (r1 < r0) goto L_0x0012
            return
        L_0x0012:
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L_0x002c
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L_0x002c
        L_0x002a:
            int r2 = r2 - r3
            goto L_0x003b
        L_0x002c:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L_0x003a
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L_0x003a
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L_0x002a
        L_0x003a:
            r2 = -1
        L_0x003b:
            if (r2 == r4) goto L_0x004c
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.appendBits(r3, r2)
            int r1 = r1 + 2
            goto L_0x000f
        L_0x004c:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x0054:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Kanji byte size not even"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x005c:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>((java.lang.Throwable) r6)
            goto L_0x0064
        L_0x0063:
            throw r7
        L_0x0064:
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.appendKanjiBytes(java.lang.String, com.google.zxing.common.BitArray):void");
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }
}
