package com.google.gson.stream;

final class StringPool {
    private final String[] pool = new String[512];

    StringPool() {
    }

    public String get(char[] cArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 = (i3 * 31) + cArr[i4];
        }
        int i5 = ((i3 >>> 20) ^ (i3 >>> 12)) ^ i3;
        String[] strArr = this.pool;
        int length = (i5 ^ ((i5 >>> 7) ^ (i5 >>> 4))) & (strArr.length - 1);
        String str = strArr[length];
        if (str == null || str.length() != i2) {
            String str2 = new String(cArr, i, i2);
            this.pool[length] = str2;
            return str2;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            if (str.charAt(i6) != cArr[i + i6]) {
                String str3 = new String(cArr, i, i2);
                this.pool[length] = str3;
                return str3;
            }
        }
        return str;
    }
}
