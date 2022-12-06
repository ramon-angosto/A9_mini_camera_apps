package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.b.a.i;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: VideoConfig */
public class b {
    public static boolean a = false;
    private static Executor b = null;
    private static Context c = null;
    private static String d = null;
    private static boolean e = false;
    private static i f;
    private static volatile Handler g;

    public static Context a() {
        return c;
    }

    public static String b() {
        if (TextUtils.isEmpty(d)) {
            try {
                File file = new File(a().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                d = file.getAbsolutePath();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return d;
    }

    public static void a(Context context, String str, Executor executor, Handler handler) {
        c = context;
        b = executor;
        d = str;
        g = handler;
    }

    public static boolean c() {
        return e;
    }

    public static void a(boolean z) {
        e = z;
    }

    public static i d() {
        if (f == null) {
            f = new i.a("v_config").a(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).b(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).c(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).a();
        }
        return f;
    }

    public static void a(i iVar) {
        f = iVar;
    }

    public static boolean e() {
        return a;
    }
}
