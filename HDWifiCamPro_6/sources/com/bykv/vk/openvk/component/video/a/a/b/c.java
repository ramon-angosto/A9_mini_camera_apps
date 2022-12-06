package com.bykv.vk.openvk.component.video.a.a.b;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.component.video.api.e.a;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: VideoFileManager */
public class c {
    public static final ConcurrentHashMap<String, b> a = new ConcurrentHashMap<>();

    public static synchronized void a(Context context, com.bykv.vk.openvk.component.video.api.c.c cVar, a.C0022a aVar) {
        synchronized (c.class) {
            if (cVar == null) {
                com.bykv.vk.openvk.component.video.api.f.c.b(" url、dir and hash is must property   in VideoInfoModel");
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                b bVar = a.get(cVar.l());
                if (bVar == null) {
                    bVar = new b(context, cVar);
                    a.put(cVar.l(), bVar);
                    com.bykv.vk.openvk.component.video.api.f.c.b("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(cVar.b()), cVar.l());
                }
                bVar.a(aVar);
            }
            com.bykv.vk.openvk.component.video.api.f.c.b("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(cVar.b()), cVar.l());
        }
    }

    public static synchronized void a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        synchronized (c.class) {
            if (Build.VERSION.SDK_INT >= 23) {
                b remove = a.remove(cVar.l());
                if (remove != null) {
                    remove.a(true);
                }
                com.bykv.vk.openvk.component.video.api.f.c.b("VideoFileManager", "removePreload:  cache size = ", Integer.valueOf(cVar.b()), cVar.l());
            }
        }
    }
}
