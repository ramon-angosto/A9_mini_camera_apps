package com.google.zxing.oned;

public class CodaBarWriter extends OneDimensionalCodeWriter {
    public CodaBarWriter() {
        super(20);
    }

    public byte[] encode(String str) {
        int i;
        if (!CodaBarReader.arrayContains(new char[]{'A', 'B', 'C', 'D'}, Character.toUpperCase(str.charAt(0)))) {
            throw new IllegalArgumentException("Codabar should start with one of the following: 'A', 'B', 'C' or 'D'");
        } else if (CodaBarReader.arrayContains(new char[]{'T', 'N', '*', 'E'}, Character.toUpperCase(str.charAt(str.length() - 1)))) {
            char[] cArr = {'/', ':', '+', '.'};
            int i2 = 20;
            for (int i3 = 1; i3 < str.length() - 1; i3++) {
                if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                    i2 += 9;
                } else if (CodaBarReader.arrayContains(cArr, str.charAt(i3))) {
                    i2 += 10;
                } else {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
                }
            }
            byte[] bArr = new byte[(i2 + (str.length() - 1))];
            int i4 = 0;
            for (int i5 = 0; i5 < str.length(); i5++) {
                char upperCase = Character.toUpperCase(str.charAt(i5));
                if (i5 == str.length() - 1) {
                    if (upperCase == '*') {
                        upperCase = 'C';
                    } else if (upperCase == 'E') {
                        upperCase = 'D';
                    }
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= CodaBarReader.ALPHABET.length) {
                        i = 0;
                        break;
                    } else if (upperCase == CodaBarReader.ALPHABET[i6]) {
                        i = CodaBarReader.CHARACTER_ENCODINGS[i6];
                        break;
                    } else {
                        i6++;
                    }
                }
                int i7 = i4;
                int i8 = 0;
                byte b = 1;
                while (true) {
                    int i9 = 0;
                    while (i8 < 7) {
                        bArr[i7] = b;
                        i7++;
                        if (((i >> (6 - i8)) & 1) == 0 || i9 == 1) {
                            b = (byte) (b ^ 1);
                            i8++;
                        } else {
                            i9++;
                        }
                    }
                    break;
                }
                if (i5 < str.length() - 1) {
                    bArr[i7] = 0;
                    i7++;
                }
                i4 = i7;
            }
            return bArr;
        } else {
            throw new IllegalArgumentException("Codabar should end with one of the following: 'T', 'N', '*' or 'E'");
        }
    }
}
