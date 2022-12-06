package com.google.android.gms.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzp {
    static int zza(int i) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        int i2 = 0;
        while (i2 < 6) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            } else if (i4 == i) {
                return i3;
            } else {
                i2++;
            }
        }
        return 1;
    }
}
