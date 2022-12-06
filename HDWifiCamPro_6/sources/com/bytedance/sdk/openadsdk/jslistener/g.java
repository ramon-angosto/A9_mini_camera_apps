package com.bytedance.sdk.openadsdk.jslistener;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.bytedance.sdk.component.utils.l;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: VolumeChangeObserver */
public class g {
    private int a = -1;
    private f b;
    private PangleVolumeBroadcastReceiver c;
    private Context d;
    private AudioManager e;
    private boolean f = false;
    private boolean g = false;
    private int h = -1;

    public g(Context context) {
        this.d = context;
        this.e = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public int b() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    public boolean c() {
        if (!this.g) {
            return false;
        }
        this.g = false;
        return true;
    }

    public int d() {
        try {
            if (this.e != null) {
                return this.e.getStreamMaxVolume(3);
            }
            return 15;
        } catch (Throwable th) {
            l.a("VolumeChangeObserver", "getMaxMusicVolumeError: ", th);
            return 15;
        }
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        if (this.e != null) {
            int i = 0;
            if (z) {
                int g2 = g();
                if (g2 != 0) {
                    this.a = g2;
                }
                l.b("VolumeChangeObserver", "mute set volume to 0");
                this.e.setStreamVolume(3, 0, 0);
                this.g = true;
                return;
            }
            int i2 = this.a;
            if (i2 == 0) {
                i2 = d() / 15;
            } else {
                if (i2 == -1) {
                    if (z2) {
                        i2 = d() / 15;
                    } else {
                        return;
                    }
                }
                l.b("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.a);
                this.a = -1;
                this.e.setStreamVolume(3, i2, i);
                this.g = true;
            }
            i = 1;
            l.b("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.a);
            this.a = -1;
            this.e.setStreamVolume(3, i2, i);
            this.g = true;
        }
    }

    public void a(f fVar) {
        this.b = fVar;
    }

    public void e() {
        if (this.f) {
            try {
                this.d.unregisterReceiver(this.c);
                this.b = null;
                this.f = false;
            } catch (Throwable th) {
                l.a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public void f() {
        try {
            this.c = new PangleVolumeBroadcastReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.d.registerReceiver(this.c, intentFilter);
            this.f = true;
        } catch (Throwable th) {
            l.a("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    public int g() {
        try {
            if (this.e != null) {
                return this.e.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            l.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    public f h() {
        return this.b;
    }
}
