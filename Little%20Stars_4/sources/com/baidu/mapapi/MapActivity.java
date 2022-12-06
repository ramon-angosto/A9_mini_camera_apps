package com.baidu.mapapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import java.util.List;

public abstract class MapActivity extends Activity {
    private MapView a = null;

    /* access modifiers changed from: package-private */
    public boolean a(MapView mapView) {
        if (this.a == null) {
            this.a = mapView;
            Mj.d = mapView;
            return true;
        }
        throw new RuntimeException("A mapview has been created!!");
    }

    public boolean initMapActivity(BMapManager bMapManager) {
        if (bMapManager == null) {
            return false;
        }
        if (this.a == null) {
            throw new RuntimeException("A mapview has not been created!!");
        } else if (Mj.InitMapControlCC(20, 40) != 1) {
            return false;
        } else {
            this.a.a();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isLocationDisplayed() {
        MapView mapView = this.a;
        if (mapView != null) {
            return mapView.b.d();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean isRouteDisplayed();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Mj.g = defaultDisplay.getWidth();
        Mj.h = defaultDisplay.getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        MapView mapView = this.a;
        if (mapView != null) {
            List<Overlay> overlays = mapView.getOverlays();
            if (overlays != null) {
                for (int size = overlays.size() - 1; size >= 0; size--) {
                    Overlay overlay = overlays.get(size);
                    if (overlay instanceof MyLocationOverlay) {
                        MyLocationOverlay myLocationOverlay = (MyLocationOverlay) overlay;
                        myLocationOverlay.disableMyLocation();
                        myLocationOverlay.disableCompass();
                    }
                }
                overlays.clear();
            }
            this.a.b();
        }
        this.a = null;
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        MapView mapView = Mj.d;
        MapView mapView2 = this.a;
        if (mapView != mapView2) {
            Mj.d = mapView2;
            if (mapView2 != null) {
                mapView2.b.a(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
            }
        }
        super.onResume();
    }
}
