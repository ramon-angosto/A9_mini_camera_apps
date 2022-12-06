package com.adcolony.sdk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;

public class AdColonyAdViewActivity extends b {
    AdColonyAdView j;

    public AdColonyAdViewActivity() {
        AdColonyAdView adColonyAdView;
        if (!a.d()) {
            adColonyAdView = null;
        } else {
            adColonyAdView = a.b().k();
        }
        this.j = adColonyAdView;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        ViewParent parent = this.a.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.a);
        }
        this.j.a();
        a.b().a((AdColonyAdView) null);
        finish();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.j.b();
    }

    public void onBackPressed() {
        b();
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        AdColonyAdView adColonyAdView;
        if (!a.d() || (adColonyAdView = this.j) == null) {
            a.b().a((AdColonyAdView) null);
            finish();
            return;
        }
        this.b = adColonyAdView.getOrientation();
        super.onCreate(bundle);
        this.j.b();
        AdColonyAdViewListener listener = this.j.getListener();
        if (listener != null) {
            listener.onOpened(this.j);
        }
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
