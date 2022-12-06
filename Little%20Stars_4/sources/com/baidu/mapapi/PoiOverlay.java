package com.baidu.mapapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.Toast;
import java.util.ArrayList;

public class PoiOverlay extends ItemizedOverlay<OverlayItem> {
    private MapView a;
    private Context b;
    private int c;
    private MKSearch d;
    public ArrayList<MKPoiInfo> mList;
    public boolean mUseToast;

    public PoiOverlay(Activity activity, MapView mapView) {
        super((Drawable) null);
        int i;
        this.mList = null;
        this.a = null;
        this.b = null;
        this.c = 1;
        this.mUseToast = true;
        this.b = activity;
        this.a = mapView;
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        if (Mj.i <= 120) {
            i = 0;
        } else if (Mj.i <= 180) {
            this.c = 1;
            return;
        } else {
            i = 2;
        }
        this.c = i;
    }

    public PoiOverlay(Activity activity, MapView mapView, MKSearch mKSearch) {
        this(activity, mapView);
        this.d = mKSearch;
    }

    public void animateTo() {
        if (size() > 0) {
            onTap(0);
        }
    }

    /* access modifiers changed from: protected */
    public OverlayItem createItem(int i) {
        Drawable drawable;
        char[] cArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        char[] cArr2 = {'l', 'm', 'h'};
        MKPoiInfo mKPoiInfo = this.mList.get(i);
        OverlayItem overlayItem = new OverlayItem(mKPoiInfo.pt, mKPoiInfo.name, mKPoiInfo.address);
        if (i < 10) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("icon_mark");
            sb.append(cArr[i]);
            sb.append('_');
            sb.append(cArr2[this.c]);
            sb.append(".png");
            drawable = n.a(this.b, sb.toString());
        } else {
            drawable = null;
        }
        overlayItem.setMarker(boundCenterBottom(drawable));
        return overlayItem;
    }

    public MKPoiInfo getPoi(int i) {
        ArrayList<MKPoiInfo> arrayList = this.mList;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i);
    }

    /* access modifiers changed from: protected */
    public boolean onTap(int i) {
        OverlayItem item = getItem(i);
        this.a.getController().animateTo(item.mPoint);
        if (this.mUseToast && item.mTitle != null) {
            MKPoiInfo poi = getPoi(i);
            if (poi.hasCaterDetails) {
                this.d.poiDetailSearch(poi.uid);
            }
            Toast.makeText(this.b, item.mTitle, 1).show();
        }
        super.onTap(i);
        return true;
    }

    public void setData(ArrayList<MKPoiInfo> arrayList) {
        if (arrayList != null) {
            this.mList = arrayList;
            super.populate();
        }
    }

    public int size() {
        ArrayList<MKPoiInfo> arrayList = this.mList;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList.size() > 10) {
            return 10;
        }
        return this.mList.size();
    }
}
