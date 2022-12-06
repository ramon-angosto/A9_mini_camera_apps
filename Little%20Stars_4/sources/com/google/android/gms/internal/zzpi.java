package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class zzpi extends ImageView {
    private Uri zzaql;
    private int zzaqm;

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void zzbX(int i) {
        this.zzaqm = i;
    }

    public void zzn(Uri uri) {
        this.zzaql = uri;
    }

    public int zzte() {
        return this.zzaqm;
    }
}
