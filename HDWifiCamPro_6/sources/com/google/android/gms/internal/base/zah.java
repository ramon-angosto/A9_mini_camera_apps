package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zah extends Drawable.ConstantState {
    int zaa;
    int zab;

    zah(zah zah) {
        if (zah != null) {
            this.zaa = zah.zaa;
            this.zab = zah.zab;
        }
    }

    public final int getChangingConfigurations() {
        return this.zaa;
    }

    public final Drawable newDrawable() {
        return new zai(this);
    }
}
