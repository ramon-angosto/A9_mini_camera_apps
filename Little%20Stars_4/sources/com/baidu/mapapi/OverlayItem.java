package com.baidu.mapapi;

import android.graphics.drawable.Drawable;

public class OverlayItem {
    public static final int ITEM_STATE_FOCUSED_MASK = 4;
    public static final int ITEM_STATE_NORMAL_MASK = 0;
    public static final int ITEM_STATE_PRESSED_MASK = 1;
    public static final int ITEM_STATE_SELECTED_MASK = 2;
    protected Drawable mMarker = null;
    protected final GeoPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;

    public OverlayItem(GeoPoint geoPoint, String str, String str2) {
        this.mPoint = geoPoint;
        this.mTitle = str;
        this.mSnippet = str2;
    }

    private static int[] a(int i) {
        int i2;
        int[] iArr = new int[3];
        if ((i & 1) != 0) {
            iArr[0] = 16842919;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if ((i & 2) != 0) {
            iArr[i2] = 16842913;
            i2++;
        }
        if ((i & 4) != 0) {
            iArr[i2] = 16842908;
            i2++;
        }
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[i3] = iArr[i3];
        }
        return iArr2;
    }

    public static void setState(Drawable drawable, int i) {
        int[] a = a(i);
        if (a.length != 0) {
            drawable.setState(a);
        }
    }

    public Drawable getMarker(int i) {
        Drawable drawable = this.mMarker;
        if (drawable == null) {
            return null;
        }
        int[] state = drawable.getState();
        this.mMarker.setState(a(i));
        Drawable current = this.mMarker.getCurrent();
        this.mMarker.setState(state);
        return current;
    }

    public GeoPoint getPoint() {
        return this.mPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String routableAddress() {
        return null;
    }

    public void setMarker(Drawable drawable) {
        this.mMarker = drawable;
        Drawable drawable2 = this.mMarker;
        if (drawable2 != null) {
            drawable2.setState(new int[0]);
        }
    }
}
