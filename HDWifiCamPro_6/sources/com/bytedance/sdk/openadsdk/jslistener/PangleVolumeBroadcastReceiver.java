package com.bytedance.sdk.openadsdk.jslistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.component.utils.l;
import java.lang.ref.WeakReference;

public class PangleVolumeBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<g> a;

    public PangleVolumeBroadcastReceiver(g gVar) {
        this.a = new WeakReference<>(gVar);
    }

    public void onReceive(Context context, Intent intent) {
        f h;
        int g;
        try {
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                l.b("VolumeChangeObserver", "Media volume change notification.......");
                g gVar = (g) this.a.get();
                if (gVar != null && (h = gVar.h()) != null && (g = gVar.g()) != gVar.a()) {
                    gVar.a(g);
                    if (g >= 0) {
                        h.b(g);
                    }
                }
            }
        } catch (Throwable th) {
            l.a("VolumeChangeObserver", "onVolumeChangedError: ", th);
        }
    }
}
