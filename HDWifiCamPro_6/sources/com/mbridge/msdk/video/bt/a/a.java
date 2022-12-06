package com.mbridge.msdk.video.bt.a;

import android.util.Base64;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.bt.module.MBridgeBTVideoView;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: H5MediaPlayerManager */
public class a {
    private static final String c = a.class.getSimpleName();
    private static LinkedHashMap<String, MBridgeBTVideoView> e = new LinkedHashMap<>();
    int a = 0;
    int b = 1;
    private String d = "handlerNativeResult";

    /* renamed from: com.mbridge.msdk.video.bt.a.a$a  reason: collision with other inner class name */
    /* compiled from: H5MediaPlayerManager */
    private static final class C0101a {
        /* access modifiers changed from: private */
        public static a a = new a();
    }

    public static a a() {
        return C0101a.a;
    }

    public final void a(String str, MBridgeBTVideoView mBridgeBTVideoView) {
        e.put(str, mBridgeBTVideoView);
    }

    public final void a(String str) {
        e.remove(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00db A[Catch:{ all -> 0x0153 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r11, java.lang.String r12, org.json.JSONArray r13, int r14) {
        /*
            r10 = this;
            java.lang.String r14 = ""
            java.lang.String r0 = "value"
            r1 = 7
            java.lang.String r2 = "type"
            java.lang.String r3 = "key"
            if (r13 == 0) goto L_0x002e
            int r4 = r13.length()     // Catch:{ all -> 0x0153 }
            if (r4 <= 0) goto L_0x002e
            r4 = 0
            org.json.JSONObject r4 = r13.optJSONObject(r4)     // Catch:{ all -> 0x0153 }
            if (r4 == 0) goto L_0x002e
            java.lang.String r5 = r4.optString(r3)     // Catch:{ all -> 0x0153 }
            int r6 = r4.optInt(r2, r1)     // Catch:{ all -> 0x0153 }
            java.lang.String r7 = "instanceId"
            boolean r5 = r7.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0153 }
            if (r5 == 0) goto L_0x002e
            if (r6 != 0) goto L_0x002e
            java.lang.String r14 = r4.optString(r0)     // Catch:{ all -> 0x0153 }
        L_0x002e:
            boolean r4 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0153 }
            if (r4 == 0) goto L_0x003c
            int r12 = r10.b     // Catch:{ all -> 0x0153 }
            java.lang.String r13 = "instanceId find error"
            r10.a(r12, r13, r11)     // Catch:{ all -> 0x0153 }
            return
        L_0x003c:
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.video.bt.module.MBridgeBTVideoView> r4 = e     // Catch:{ all -> 0x0153 }
            boolean r4 = r4.containsKey(r14)     // Catch:{ all -> 0x0153 }
            if (r4 != 0) goto L_0x004c
            int r12 = r10.b     // Catch:{ all -> 0x0153 }
            java.lang.String r13 = "can not find player"
            r10.a(r12, r13, r11)     // Catch:{ all -> 0x0153 }
            return
        L_0x004c:
            java.lang.String r4 = "play"
            boolean r4 = r4.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0153 }
            java.lang.String r5 = "player is null"
            if (r4 == 0) goto L_0x006a
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.video.bt.module.MBridgeBTVideoView> r12 = e     // Catch:{ all -> 0x0153 }
            java.lang.Object r12 = r12.get(r14)     // Catch:{ all -> 0x0153 }
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r12 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r12     // Catch:{ all -> 0x0153 }
            if (r12 == 0) goto L_0x0064
            r12.play()     // Catch:{ all -> 0x0153 }
            goto L_0x0069
        L_0x0064:
            int r12 = r10.b     // Catch:{ all -> 0x0153 }
            r10.a(r12, r5, r11)     // Catch:{ all -> 0x0153 }
        L_0x0069:
            return
        L_0x006a:
            java.lang.String r4 = "pause"
            boolean r4 = r4.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0153 }
            if (r4 == 0) goto L_0x0086
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.video.bt.module.MBridgeBTVideoView> r12 = e     // Catch:{ all -> 0x0153 }
            java.lang.Object r12 = r12.get(r14)     // Catch:{ all -> 0x0153 }
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r12 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r12     // Catch:{ all -> 0x0153 }
            if (r12 == 0) goto L_0x0080
            r12.pause()     // Catch:{ all -> 0x0153 }
            goto L_0x0085
        L_0x0080:
            int r12 = r10.b     // Catch:{ all -> 0x0153 }
            r10.a(r12, r5, r11)     // Catch:{ all -> 0x0153 }
        L_0x0085:
            return
        L_0x0086:
            java.lang.String r4 = "stop"
            boolean r4 = r4.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0153 }
            if (r4 == 0) goto L_0x00a2
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.video.bt.module.MBridgeBTVideoView> r12 = e     // Catch:{ all -> 0x0153 }
            java.lang.Object r12 = r12.get(r14)     // Catch:{ all -> 0x0153 }
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r12 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r12     // Catch:{ all -> 0x0153 }
            if (r12 == 0) goto L_0x009c
            r12.stop()     // Catch:{ all -> 0x0153 }
            goto L_0x00a1
        L_0x009c:
            int r12 = r10.b     // Catch:{ all -> 0x0153 }
            r10.a(r12, r5, r11)     // Catch:{ all -> 0x0153 }
        L_0x00a1:
            return
        L_0x00a2:
            java.lang.String r4 = "setVolume"
            boolean r4 = r4.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0153 }
            r6 = 3
            r7 = 1
            if (r4 == 0) goto L_0x0108
            r12 = 0
            if (r13 == 0) goto L_0x00f3
            int r4 = r13.length()     // Catch:{ all -> 0x0153 }
            r8 = 2
            if (r4 <= r8) goto L_0x00f3
            org.json.JSONObject r4 = r13.optJSONObject(r7)     // Catch:{ all -> 0x0153 }
            org.json.JSONObject r13 = r13.optJSONObject(r8)     // Catch:{ all -> 0x0153 }
            if (r4 == 0) goto L_0x00d8
            java.lang.String r7 = r4.optString(r3)     // Catch:{ all -> 0x0153 }
            int r8 = r4.optInt(r2, r1)     // Catch:{ all -> 0x0153 }
            java.lang.String r9 = "leftVolume"
            boolean r7 = r9.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0153 }
            if (r7 == 0) goto L_0x00d8
            if (r8 != r6) goto L_0x00d8
            double r7 = r4.optDouble(r0)     // Catch:{ all -> 0x0153 }
            float r4 = (float) r7     // Catch:{ all -> 0x0153 }
            goto L_0x00d9
        L_0x00d8:
            r4 = r12
        L_0x00d9:
            if (r13 == 0) goto L_0x00f4
            java.lang.String r3 = r13.optString(r3)     // Catch:{ all -> 0x0153 }
            int r1 = r13.optInt(r2, r1)     // Catch:{ all -> 0x0153 }
            java.lang.String r2 = "rightVolume"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0153 }
            if (r2 == 0) goto L_0x00f4
            if (r1 != r6) goto L_0x00f4
            double r12 = r13.optDouble(r0)     // Catch:{ all -> 0x0153 }
            float r12 = (float) r12     // Catch:{ all -> 0x0153 }
            goto L_0x00f4
        L_0x00f3:
            r4 = r12
        L_0x00f4:
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.video.bt.module.MBridgeBTVideoView> r13 = e     // Catch:{ all -> 0x0153 }
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x0153 }
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r13 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r13     // Catch:{ all -> 0x0153 }
            if (r13 == 0) goto L_0x0102
            r13.setVolume(r4, r12)     // Catch:{ all -> 0x0153 }
            goto L_0x0107
        L_0x0102:
            int r12 = r10.b     // Catch:{ all -> 0x0153 }
            r10.a(r12, r5, r11)     // Catch:{ all -> 0x0153 }
        L_0x0107:
            return
        L_0x0108:
            java.lang.String r4 = "setPlaybackParams"
            boolean r12 = r4.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0153 }
            if (r12 == 0) goto L_0x014b
            r12 = 1065353216(0x3f800000, float:1.0)
            if (r13 == 0) goto L_0x0137
            int r4 = r13.length()     // Catch:{ all -> 0x0153 }
            if (r4 <= r7) goto L_0x0137
            org.json.JSONObject r13 = r13.optJSONObject(r7)     // Catch:{ all -> 0x0153 }
            if (r13 == 0) goto L_0x0137
            java.lang.String r3 = r13.optString(r3)     // Catch:{ all -> 0x0153 }
            int r1 = r13.optInt(r2, r1)     // Catch:{ all -> 0x0153 }
            java.lang.String r2 = "speed"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0153 }
            if (r2 == 0) goto L_0x0137
            if (r1 != r6) goto L_0x0137
            double r12 = r13.optDouble(r0)     // Catch:{ all -> 0x0153 }
            float r12 = (float) r12     // Catch:{ all -> 0x0153 }
        L_0x0137:
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.video.bt.module.MBridgeBTVideoView> r13 = e     // Catch:{ all -> 0x0153 }
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x0153 }
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r13 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r13     // Catch:{ all -> 0x0153 }
            if (r13 == 0) goto L_0x0145
            r13.setPlaybackParams(r12)     // Catch:{ all -> 0x0153 }
            goto L_0x014a
        L_0x0145:
            int r12 = r10.b     // Catch:{ all -> 0x0153 }
            r10.a(r12, r5, r11)     // Catch:{ all -> 0x0153 }
        L_0x014a:
            return
        L_0x014b:
            int r12 = r10.b     // Catch:{ all -> 0x0153 }
            java.lang.String r13 = "method not found"
            r10.a(r12, r13, r11)     // Catch:{ all -> 0x0153 }
            goto L_0x0177
        L_0x0153:
            r12 = move-exception
            java.lang.String r13 = c
            java.lang.String r14 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r13, r14)
            int r13 = r10.b
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "exception："
            r14.append(r0)
            java.lang.String r12 = r12.getMessage()
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            r10.a(r13, r12, r11)
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.a.a(java.lang.Object, java.lang.String, org.json.JSONArray, int):void");
    }

    private void a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e2) {
            q.a(c, e2.getMessage());
        } catch (Throwable th) {
            q.a(c, th.getMessage());
        }
    }
}
