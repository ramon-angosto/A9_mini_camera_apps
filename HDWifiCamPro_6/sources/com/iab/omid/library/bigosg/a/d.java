package com.iab.omid.library.bigosg.a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

public final class d extends ContentObserver {
    public final Context a;
    private final AudioManager b;
    private final a c;
    private final c d;
    private float e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.a = context;
        this.b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.c = aVar;
        this.d = cVar;
    }

    private float b() {
        return a.a(this.b.getStreamVolume(3), this.b.getStreamMaxVolume(3));
    }

    private void c() {
        this.d.a(this.e);
    }

    public final void a() {
        this.e = b();
        c();
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float b2 = b();
        if (b2 != this.e) {
            this.e = b2;
            c();
        }
    }
}
