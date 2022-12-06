package shix.ihdbell.project.other;

import android.graphics.Bitmap;

public class LoadedImage {
    Bitmap mBitmap;

    LoadedImage(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }
}
