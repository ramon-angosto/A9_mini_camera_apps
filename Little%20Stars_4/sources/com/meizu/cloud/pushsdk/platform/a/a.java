package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.a.e.k;
import com.meizu.cloud.pushsdk.common.b.h;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.b;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class a {
    public String a = "https://api-push.meizu.com/garcia/api/client/";
    private String b = (this.a + "message/registerPush");
    private String c = (this.a + "message/unRegisterPush");
    private String d = (this.a + "advance/unRegisterPush");
    private String e = (this.a + "message/getRegisterSwitch");
    private String f = (this.a + "message/changeRegisterSwitch");
    private String g = (this.a + "message/subscribeTags");
    private String h = (this.a + "message/unSubscribeTags");
    private String i = (this.a + "message/getSubTags");
    private String j = (this.a + "message/subscribeAlias");
    private String k = (this.a + "message/unSubscribeAlias");
    private String l = (this.a + "message/getSubAlias");

    public a(Context context) {
        com.meizu.cloud.pushsdk.a.a.a();
        if (h.b() || h.c()) {
            this.a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.b = this.a + "message/registerPush";
            this.c = this.a + "message/unRegisterPush";
            this.d = this.a + "advance/unRegisterPush";
            this.e = this.a + "message/getRegisterSwitch";
            this.f = this.a + "message/changeRegisterSwitch";
            this.g = this.a + "message/subscribeTags";
            this.h = this.a + "message/unSubscribeTags";
            this.i = this.a + "message/getSubTags";
            this.j = this.a + "message/subscribeAlias";
            this.k = this.a + "message/unSubscribeAlias";
            this.l = this.a + "message/getSubAlias";
        }
    }

    public void a(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "register post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.b).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void b(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "unregister post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.a(this.c).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void a(String str, String str2, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("packageName", str);
        linkedHashMap.put("deviceId", str2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, "4a2ca769d79f4856bb3bd982d30de790"));
        DebugLogger.i("PushAPI", "advance unregister post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.d).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void c(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "checkPush post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.a(this.e).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void a(String str, String str2, String str3, int i2, boolean z, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("msgType", String.valueOf(i2));
        linkedHashMap.put("subSwitch", z ? "1" : PushConstants.PUSH_TYPE_NOTIFY);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "swithPush post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.f).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void a(String str, String str2, String str3, String str4, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("tags", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.g).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void b(String str, String str2, String str3, String str4, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("tags", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.h).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void d(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "checkPush post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.a(this.i).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void c(String str, String str2, String str3, String str4, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("appKey", str2);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.j).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void d(String str, String str2, String str3, String str4, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.b(this.k).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }

    public void e(String str, String str2, String str3, k kVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "checkPush post map " + linkedHashMap2);
        com.meizu.cloud.pushsdk.a.a.a(this.l).a((HashMap<String, String>) linkedHashMap2).a().a(kVar);
    }
}
