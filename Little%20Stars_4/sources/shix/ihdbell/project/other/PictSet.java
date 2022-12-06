package shix.ihdbell.project.other;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class PictSet {
    public static Bitmap readBitmapAutoSize(String str, int i, int i2) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 5;
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, (Rect) null, options);
                    try {
                        bufferedInputStream.close();
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return decodeStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        try {
                            bufferedInputStream.close();
                            fileInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            bufferedInputStream.close();
                            fileInputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                bufferedInputStream = null;
                e.printStackTrace();
                bufferedInputStream.close();
                fileInputStream.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
                bufferedInputStream.close();
                fileInputStream.close();
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedInputStream = null;
            fileInputStream = null;
            e.printStackTrace();
            bufferedInputStream.close();
            fileInputStream.close();
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            bufferedInputStream = null;
            bufferedInputStream.close();
            fileInputStream.close();
            throw th;
        }
    }

    private static BitmapFactory.Options setBitmapOption(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 1;
        if (!(i3 == 0 || i4 == 0 || i == 0 || i2 == 0)) {
            options.inSampleSize = ((i3 / i) + (i4 / i2)) / 2;
        }
        options.inJustDecodeBounds = false;
        return options;
    }
}
