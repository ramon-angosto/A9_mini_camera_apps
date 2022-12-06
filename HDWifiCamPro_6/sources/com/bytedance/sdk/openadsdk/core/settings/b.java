package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.u;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdSlotSettings */
public class b {
    private static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();
    private static final Set<String> b = new HashSet();

    private static boolean a(int i) {
        return i == 1 || i == 2;
    }

    public static void a() {
        String str;
        File c = c();
        l.b("SdkSettings.AdSlot", "loadLocalData: " + c.getAbsolutePath() + ", exists = " + c.exists());
        if (!c.exists()) {
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                str = a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
            } else {
                str = u.a("tt_sdk_settings", m.a()).b("ad_slot_conf", (String) null);
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    HashMap<String, a> b2 = b(new JSONArray(str));
                    if (!b2.isEmpty()) {
                        a.clear();
                        a.putAll(b2);
                    }
                    l.b("SdkSettings.AdSlot", "loadLocalData: load from sp success, item count " + b2.size());
                } catch (Exception e) {
                    Log.e("SdkSettings.AdSlot", "loadLocalData: ", e);
                }
            }
        } else {
            try {
                HashMap<String, a> b3 = b(new JSONArray(new String(f.d(c))));
                if (!b3.isEmpty()) {
                    a.clear();
                    a.putAll(b3);
                }
                if (h.d().s()) {
                    l.b("SdkSettings.AdSlot", "loadLocalData: load from file success, item count " + a.size());
                }
            } catch (Exception e2) {
                Log.e("SdkSettings.AdSlot", "", e2);
            }
        }
    }

    private static HashMap<String, a> b(JSONArray jSONArray) {
        HashMap<String, a> hashMap = new HashMap<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                a a2 = a(jSONArray.getJSONObject(i));
                if (a2 != null) {
                    hashMap.put(a2.a, a2);
                }
                i++;
            } catch (Exception e) {
                l.c("SdkSettings.AdSlot", "", (Throwable) e);
            }
        }
        return hashMap;
    }

    private static File c() {
        return new File(m.a().getFilesDir(), "tt_ads_conf");
    }

    private static a a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            return null;
        }
        String optString = jSONObject2.optString("code_id");
        int optInt = jSONObject2.optInt("auto_play", 1);
        int optInt2 = jSONObject2.optInt("voice_control", 1);
        int optInt3 = jSONObject2.optInt("rv_preload", 2);
        int optInt4 = jSONObject2.optInt("nv_preload", 1);
        int optInt5 = jSONObject2.optInt("proportion_watching", 100);
        int optInt6 = jSONObject2.optInt("skip_time_displayed", 0);
        int optInt7 = jSONObject2.optInt("video_skip_result", 2);
        int optInt8 = jSONObject2.optInt("reg_creative_control", 1);
        int optInt9 = jSONObject2.optInt("play_bar_show_time", 3);
        int optInt10 = jSONObject2.optInt("rv_skip_time", -1);
        int optInt11 = jSONObject2.optInt("voice_control", 2);
        int optInt12 = jSONObject2.optInt("if_show_win", 1);
        int optInt13 = jSONObject2.optInt("sp_preload", 2);
        int optInt14 = jSONObject2.optInt("stop_time", 1500);
        int optInt15 = jSONObject2.optInt("native_playable_delay", 2);
        int optInt16 = jSONObject2.optInt("time_out_control", -1);
        int optInt17 = jSONObject2.optInt("playable_close_time", -1);
        int optInt18 = jSONObject2.optInt("playable_reward_type", 0);
        int optInt19 = jSONObject2.optInt("reward_is_callback", 0);
        int optInt20 = jSONObject2.optInt("iv_skip_time", 5);
        JSONArray optJSONArray = jSONObject2.optJSONArray("parent_tpl_ids");
        int i = optInt20;
        int optInt21 = jSONObject2.optInt("slot_type", 2);
        boolean optBoolean = jSONObject2.optBoolean("close_on_click", false);
        int optInt22 = jSONObject2.optInt("allow_system_back", 0);
        int optInt23 = jSONObject2.optInt("splash_skip_time", 0);
        int optInt24 = jSONObject2.optInt("splash_image_count_down_time", 5);
        if (!a(optInt2)) {
            optInt2 = 1;
        }
        if (!a(optInt11)) {
            optInt11 = 1;
        }
        return a.a().a(optString).k(optInt).l(optInt2).m(optInt3).n(optInt4).o(optInt5).p(optInt6).q(optInt7).r(optInt8).j(optInt9).i(optInt10).h(optInt11).s(optInt12).e(optInt13).f(optInt14).g(optInt15).d(optInt16).b(optInt18).c(optInt19).a(optInt17).t(optInt21).u(i).a(optJSONArray).a(optBoolean).v(optInt22).w(optInt23).x(optInt24);
    }

    public static a a(String str) {
        a aVar = a.get(str);
        return aVar == null ? c(str) : aVar;
    }

    private static a c(String str) {
        return a.a().a(str).k(1).l(b.contains(str) ^ true ? 1 : 0).m(2).n(1).o(100).p(0).r(1).j(3).i(-1).h(1).s(1).d(-1).a(-1).t(2).u(5).a((JSONArray) null).a(false).v(0).w(0).x(5);
    }

    public static void b(String str) {
        b.add(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(org.json.JSONArray r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "saveAdSlotToLocal() called with: adSlotListJson = ["
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = "]"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "SdkSettings.AdSlot"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            if (r7 != 0) goto L_0x0023
            java.lang.String r7 = "saveAdSlotToLocal: adSlotListJson is NULL"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r7)
            return
        L_0x0023:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "saveAdSlotToLocal: adSlotListJson size is "
            r0.append(r2)
            int r2 = r7.length()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            java.io.File r0 = c()
            java.io.File r2 = new java.io.File
            java.lang.String r3 = r0.getParent()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r0.getName()
            r4.append(r5)
            java.lang.String r5 = ".tmp"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.<init>(r3, r4)
            r3 = 0
            boolean r4 = r2.exists()     // Catch:{ Exception -> 0x00be }
            if (r4 == 0) goto L_0x0067
            r2.delete()     // Catch:{ Exception -> 0x00be }
        L_0x0067:
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ Exception -> 0x00be }
            r4.<init>(r2)     // Catch:{ Exception -> 0x00be }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r4.write(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r2.renameTo(r0)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r3.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r5 = "saveAdSlotToLocal: save to "
            r3.append(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r5 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r3.append(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r5 = ", file size "
            r3.append(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            long r5 = r0.length()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r3.append(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r0 = "tt_sdk_settings"
            android.content.Context r3 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            com.bytedance.sdk.openadsdk.l.u r0 = com.bytedance.sdk.openadsdk.l.u.a((java.lang.String) r0, (android.content.Context) r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r3 = "ad_slot_conf"
            r0.a(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x00b2
            r2.delete()
        L_0x00b2:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)
            goto L_0x00d0
        L_0x00b6:
            r7 = move-exception
            goto L_0x00e0
        L_0x00b8:
            r0 = move-exception
            r3 = r4
            goto L_0x00bf
        L_0x00bb:
            r7 = move-exception
            r4 = r3
            goto L_0x00e0
        L_0x00be:
            r0 = move-exception
        L_0x00bf:
            java.lang.String r4 = "saveAdSlotToLocal: "
            android.util.Log.e(r1, r4, r0)     // Catch:{ all -> 0x00bb }
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x00cd
            r2.delete()
        L_0x00cd:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
        L_0x00d0:
            java.util.HashMap r7 = b((org.json.JSONArray) r7)
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x00df
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bytedance.sdk.openadsdk.core.settings.a> r0 = a
            r0.putAll(r7)
        L_0x00df:
            return
        L_0x00e0:
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x00e9
            r2.delete()
        L_0x00e9:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.b.a(org.json.JSONArray):void");
    }

    public static void b() {
        File c = c();
        if (c.exists()) {
            c.delete();
        }
    }
}
