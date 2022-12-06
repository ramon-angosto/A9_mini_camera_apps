package com.mbridge.msdk.splash.a.a;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* compiled from: FastBlurUtil */
public final class a {
    public static int a = 2048;

    public static Bitmap a(Bitmap bitmap, int i) {
        int i2;
        int[] iArr;
        int i3 = i <= 0 ? 10 : i;
        int width = bitmap.getWidth() / i3;
        int height = bitmap.getHeight() / i3;
        int i4 = 0;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        int width2 = createScaledBitmap.getWidth();
        int height2 = createScaledBitmap.getHeight();
        int i5 = width2 * height2;
        int[] iArr2 = new int[i5];
        createScaledBitmap.getPixels(iArr2, 0, width2, 0, 0, width2, height2);
        int i6 = width2 - 1;
        int i7 = height2 - 1;
        int[] iArr3 = new int[i5];
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[i5];
        int[] iArr6 = new int[Math.max(width2, height2)];
        int[] iArr7 = new int[20736];
        for (int i8 = 0; i8 < 20736; i8++) {
            iArr7[i8] = i8 / 81;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, new int[]{17, 3});
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i9 >= height2) {
                break;
            }
            int i12 = i4;
            int i13 = i12;
            int i14 = i13;
            int i15 = i14;
            int i16 = i15;
            int i17 = i16;
            int i18 = i17;
            int i19 = i18;
            int i20 = -8;
            int i21 = i19;
            for (int i22 = 8; i20 <= i22; i22 = 8) {
                Bitmap bitmap2 = createScaledBitmap;
                int i23 = iArr2[Math.min(i6, Math.max(i20, 0)) + i10];
                int[] iArr9 = iArr8[i20 + 8];
                iArr9[0] = (i23 & 16711680) >> 16;
                iArr9[1] = (i23 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i23 & 255;
                int abs = 9 - Math.abs(i20);
                i21 += iArr9[0] * abs;
                i12 += iArr9[1] * abs;
                i13 += iArr9[2] * abs;
                if (i20 > 0) {
                    i17 += iArr9[0];
                    i18 += iArr9[1];
                    i19 += iArr9[2];
                } else {
                    i14 += iArr9[0];
                    i15 += iArr9[1];
                    i16 += iArr9[2];
                }
                i20++;
                createScaledBitmap = bitmap2;
            }
            Bitmap bitmap3 = createScaledBitmap;
            int i24 = 0;
            int i25 = 8;
            while (i24 < width2) {
                iArr3[i10] = iArr7[i21];
                iArr4[i10] = iArr7[i12];
                iArr5[i10] = iArr7[i13];
                int i26 = i21 - i14;
                int i27 = i12 - i15;
                int i28 = i13 - i16;
                int[] iArr10 = iArr8[((i25 - 8) + 17) % 17];
                int i29 = i14 - iArr10[0];
                int i30 = i15 - iArr10[1];
                int i31 = i16 - iArr10[2];
                if (i9 == 0) {
                    iArr = iArr7;
                    iArr6[i24] = Math.min(i24 + 8 + 1, i6);
                } else {
                    iArr = iArr7;
                }
                int i32 = iArr2[i11 + iArr6[i24]];
                iArr10[0] = (i32 & 16711680) >> 16;
                iArr10[1] = (i32 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i32 & 255;
                int i33 = i17 + iArr10[0];
                int i34 = i18 + iArr10[1];
                int i35 = i19 + iArr10[2];
                i21 = i26 + i33;
                i12 = i27 + i34;
                i13 = i28 + i35;
                i25 = (i25 + 1) % 17;
                int[] iArr11 = iArr8[i25 % 17];
                i14 = i29 + iArr11[0];
                i15 = i30 + iArr11[1];
                i16 = i31 + iArr11[2];
                i17 = i33 - iArr11[0];
                i18 = i34 - iArr11[1];
                i19 = i35 - iArr11[2];
                i10++;
                i24++;
                iArr7 = iArr;
            }
            int[] iArr12 = iArr7;
            i11 += width2;
            i9++;
            createScaledBitmap = bitmap3;
            i4 = 0;
        }
        Bitmap bitmap4 = createScaledBitmap;
        int[] iArr13 = iArr7;
        int i36 = 0;
        while (i36 < width2) {
            int i37 = -8 * width2;
            int[] iArr14 = iArr6;
            int i38 = -8;
            int i39 = 0;
            int i40 = 0;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            for (int i48 = 8; i38 <= i48; i48 = 8) {
                int max = Math.max(0, i37) + i36;
                int[] iArr15 = iArr8[i38 + 8];
                iArr15[0] = iArr3[max];
                iArr15[1] = iArr4[max];
                iArr15[2] = iArr5[max];
                int abs2 = 9 - Math.abs(i38);
                i39 += iArr3[max] * abs2;
                i40 += iArr4[max] * abs2;
                i41 += iArr5[max] * abs2;
                if (i38 > 0) {
                    i45 += iArr15[0];
                    i46 += iArr15[1];
                    i47 += iArr15[2];
                } else {
                    i42 += iArr15[0];
                    i43 += iArr15[1];
                    i44 += iArr15[2];
                }
                if (i38 < i7) {
                    i37 += width2;
                }
                i38++;
            }
            int i49 = i36;
            int i50 = 0;
            int i51 = 8;
            while (i50 < height2) {
                iArr2[i49] = (iArr2[i49] & -16777216) | (iArr13[i39] << 16) | (iArr13[i40] << 8) | iArr13[i41];
                int i52 = i39 - i42;
                int i53 = i40 - i43;
                int i54 = i41 - i44;
                int[] iArr16 = iArr8[((i51 - 8) + 17) % 17];
                int i55 = i42 - iArr16[0];
                int i56 = i43 - iArr16[1];
                int i57 = i44 - iArr16[2];
                if (i36 == 0) {
                    i2 = height2;
                    iArr14[i50] = Math.min(i50 + 9, i7) * width2;
                } else {
                    i2 = height2;
                }
                int i58 = iArr14[i50] + i36;
                iArr16[0] = iArr3[i58];
                iArr16[1] = iArr4[i58];
                iArr16[2] = iArr5[i58];
                int i59 = i45 + iArr16[0];
                int i60 = i46 + iArr16[1];
                int i61 = i47 + iArr16[2];
                i39 = i52 + i59;
                i40 = i53 + i60;
                i41 = i54 + i61;
                i51 = (i51 + 1) % 17;
                int[] iArr17 = iArr8[i51];
                i42 = i55 + iArr17[0];
                i43 = i56 + iArr17[1];
                i44 = i57 + iArr17[2];
                i45 = i59 - iArr17[0];
                i46 = i60 - iArr17[1];
                i47 = i61 - iArr17[2];
                i49 += width2;
                i50++;
                height2 = i2;
            }
            i36++;
            iArr6 = iArr14;
            height2 = height2;
        }
        bitmap4.setPixels(iArr2, 0, width2, 0, 0, width2, height2);
        return bitmap4;
    }
}
