package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

final class a extends ContentObserver {
    private float a = -1.0f;
    private final Context b;
    private final C0141a c;

    /* renamed from: sg.bigo.ads.core.mraid.a$a  reason: collision with other inner class name */
    public interface C0141a {
        void a(float f);
    }

    a(Handler handler, Context context, C0141a aVar) {
        super(handler);
        this.b = context.getApplicationContext();
        this.c = aVar;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        AudioManager audioManager = (AudioManager) this.b.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        float f = 100.0f;
        if (audioManager != null) {
            f = 100.0f * (((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3)));
        }
        if (f != this.a) {
            this.a = f;
            sg.bigo.ads.common.k.a.a(0, 3, "AudioVolumeContentObserver", String.format("Volume change, current value: %s", new Object[]{Float.valueOf(this.a)}));
            C0141a aVar = this.c;
            if (aVar != null) {
                aVar.a(this.a);
            }
        }
    }
}
