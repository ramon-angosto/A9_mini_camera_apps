package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

/* compiled from: MraidVolumeChangeReceiver */
public final class d {
    public static double a = -1.0d;
    private Context b;
    private AudioManager c;
    private boolean d = false;
    private b e;
    private a f;

    /* compiled from: MraidVolumeChangeReceiver */
    public interface b {
        void a(double d);
    }

    public d(Context context) {
        this.b = context;
        this.c = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public final double a() {
        AudioManager audioManager = this.c;
        int i = -1;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.c;
        if (audioManager2 != null) {
            i = audioManager2.getStreamVolume(3);
        }
        double d2 = (((double) i) * 100.0d) / ((double) streamMaxVolume);
        a = d2;
        return d2;
    }

    public final b b() {
        return this.e;
    }

    public final void a(b bVar) {
        this.e = bVar;
    }

    public final void c() {
        if (this.b != null) {
            this.f = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.b.registerReceiver(this.f, intentFilter);
            this.d = true;
        }
    }

    public final void d() {
        Context context;
        if (this.d && (context = this.b) != null) {
            try {
                context.unregisterReceiver(this.f);
                this.e = null;
                this.d = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: MraidVolumeChangeReceiver */
    private static class a extends BroadcastReceiver {
        private WeakReference<d> a;

        public a(d dVar) {
            this.a = new WeakReference<>(dVar);
        }

        public final void onReceive(Context context, Intent intent) {
            d dVar;
            b b;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3 && (dVar = (d) this.a.get()) != null && (b = dVar.b()) != null) {
                double a2 = dVar.a();
                if (a2 >= 0.0d) {
                    b.a(a2);
                }
            }
        }
    }
}
