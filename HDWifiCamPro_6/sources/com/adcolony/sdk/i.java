package com.adcolony.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

class i extends ContentObserver {
    private AudioManager a;
    private AdColonyInterstitial b;

    i(Handler handler, AdColonyInterstitial adColonyInterstitial) {
        super(handler);
        Context a2 = a.a();
        if (a2 != null) {
            this.a = (AudioManager) a2.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            this.b = adColonyInterstitial;
            a2.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Context a2 = a.a();
        if (a2 != null) {
            a2.getApplicationContext().getContentResolver().unregisterContentObserver(this);
        }
        this.b = null;
        this.a = null;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z) {
        AdColonyInterstitial adColonyInterstitial;
        if (this.a != null && (adColonyInterstitial = this.b) != null && adColonyInterstitial.d() != null) {
            double streamVolume = (double) ((((float) this.a.getStreamVolume(3)) / 15.0f) * 100.0f);
            f1 b2 = c0.b();
            c0.a(b2, "audio_percentage", streamVolume);
            c0.a(b2, "ad_session_id", this.b.d().a());
            c0.b(b2, "id", this.b.d().c());
            new h0("AdContainer.on_audio_change", this.b.d().k(), b2).c();
        }
    }
}
