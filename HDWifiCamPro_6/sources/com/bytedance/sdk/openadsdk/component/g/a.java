package com.bytedance.sdk.openadsdk.component.g;

import android.content.Context;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.component.c;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.io.File;
import org.json.JSONObject;

/* compiled from: TTAppOpenUtils */
public class a {
    public static File a(String str) {
        return new File(CacheDirFactory.getICacheDir(0).b() + File.separator + str);
    }

    public static String a() {
        return g.a();
    }

    public static File b(String str) {
        return a(m.a(), c.a(m.a()).b(), str);
    }

    public static File a(Context context, String str, String str2) {
        return f.a(context, b.c(), str, str2);
    }

    public static void a(File file) {
        if (file != null) {
            try {
                f.b(file);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        try {
            c.a(context).a();
        } catch (Throwable unused) {
        }
    }

    public static String b() {
        return f.a(m.a(), b.c(), c.a(m.a()).b()).getAbsolutePath();
    }

    public static void a(JSONObject jSONObject, int i) {
        try {
            String g = h.d().g();
            int h = h.d().h();
            JSONObject jSONObject2 = jSONObject.getJSONObject(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_name", g);
            jSONObject3.put("app_icon_id", "@" + h);
            jSONObject2.put("open_app_info", jSONObject3);
            if (jSONObject2.optJSONObject("video") == null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("video_duration", m.d().t(String.valueOf(i)));
                jSONObject2.put("video", jSONObject4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int a(n nVar, int i) {
        return i - nVar.aF();
    }
}
