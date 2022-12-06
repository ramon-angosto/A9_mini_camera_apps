package sg.bigo.ads.common.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import sg.bigo.ads.common.b;
import sg.bigo.ads.common.k.a;

public final class c {
    public static Bitmap a(String str) {
        b b = b(str);
        if (b != null) {
            return b.a;
        }
        return null;
    }

    public static b b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        while (i < 8) {
            try {
                options.inSampleSize = i;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    return new b(decodeFile, options.outMimeType, str);
                }
                return null;
            } catch (OutOfMemoryError unused) {
                i *= 2;
                a.a(0, "BitmapUtils", "OutOfMemoryError:size = " + i + ",filePath=" + str);
            }
        }
        return null;
    }
}
