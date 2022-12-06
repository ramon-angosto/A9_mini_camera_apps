package com.huawei.android.pushagent.b.e;

import com.huawei.android.pushagent.c.a.e;
import object.p2pipcam.utils.DataBaseHelper;
import org.json.JSONObject;

public class c {

    private static class a {
        String a;
        int b;
        String c;
        Object d;

        private a() {
            this.a = "";
            this.b = -1;
            this.c = "";
            this.d = null;
        }
    }

    private static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("file")) {
                aVar.a = jSONObject.getString("file");
                e.a("PushLogAC2705", "ModifyStruct mFileName is " + aVar.a);
            }
            if (jSONObject.has(DataBaseHelper.KEY_TYPE)) {
                aVar.b = jSONObject.getInt(DataBaseHelper.KEY_TYPE);
                e.a("PushLogAC2705", "ModifyStruct mModifyType is " + aVar.b);
            }
            if (jSONObject.has(DataBaseHelper.KEY_NAME)) {
                aVar.c = jSONObject.getString(DataBaseHelper.KEY_NAME);
                e.a("PushLogAC2705", "ModifyStruct mName is " + aVar.c);
            }
            if (jSONObject.has("val")) {
                aVar.d = jSONObject.get("val");
                e.a("PushLogAC2705", "ModifyStruct mVal is " + aVar.d);
            }
            return aVar;
        } catch (Exception e) {
            e.c("PushLogAC2705", e.toString(), e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01da, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.Class<com.huawei.android.pushagent.b.e.c> r0 = com.huawei.android.pushagent.b.e.c.class
            monitor-enter(r0)
            java.lang.String r1 = "PushLogAC2705"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r2.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r3 = "enter ModifyConfigs modify jsonStr is : "
            r2.append(r3)     // Catch:{ all -> 0x01db }
            r2.append(r5)     // Catch:{ all -> 0x01db }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01db }
            com.huawei.android.pushagent.c.a.e.a(r1, r2)     // Catch:{ all -> 0x01db }
            com.huawei.android.pushagent.b.e.c$a r5 = a(r5)     // Catch:{ all -> 0x01db }
            if (r5 != 0) goto L_0x0028
            java.lang.String r4 = "PushLogAC2705"
            java.lang.String r5 = "enter ModifyConfigs struct is null !"
            com.huawei.android.pushagent.c.a.e.d(r4, r5)     // Catch:{ all -> 0x01db }
            monitor-exit(r0)
            return
        L_0x0028:
            java.lang.String r1 = r5.a     // Catch:{ all -> 0x01db }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01db }
            if (r1 == 0) goto L_0x0039
            java.lang.String r4 = "PushLogAC2705"
            java.lang.String r5 = "enter ModifyConfigs struct failed to create sharepreference file!"
            com.huawei.android.pushagent.c.a.e.d(r4, r5)     // Catch:{ all -> 0x01db }
            monitor-exit(r0)
            return
        L_0x0039:
            int r1 = r5.b     // Catch:{ all -> 0x01db }
            r2 = 1
            if (r1 == r2) goto L_0x0187
            r2 = 2
            if (r1 == r2) goto L_0x00eb
            r2 = 3
            if (r1 == r2) goto L_0x0063
            java.lang.String r4 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r2 = "the modifyType:"
            r1.append(r2)     // Catch:{ all -> 0x01db }
            int r5 = r5.b     // Catch:{ all -> 0x01db }
            r1.append(r5)     // Catch:{ all -> 0x01db }
            java.lang.String r5 = " is not supported! "
            r1.append(r5)     // Catch:{ all -> 0x01db }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x01db }
        L_0x005e:
            com.huawei.android.pushagent.c.a.e.d(r4, r5)     // Catch:{ all -> 0x01db }
            goto L_0x01d9
        L_0x0063:
            java.io.File r4 = r4.getCacheDir()     // Catch:{ all -> 0x01db }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r4 = r4.getParent()     // Catch:{ all -> 0x01db }
            r1.append(r4)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = java.io.File.separator     // Catch:{ all -> 0x01db }
            r1.append(r4)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = "shared_prefs"
            r1.append(r4)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = java.io.File.separator     // Catch:{ all -> 0x01db }
            r1.append(r4)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = r5.a     // Catch:{ all -> 0x01db }
            r1.append(r4)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = ".xml"
            r1.append(r4)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x01db }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x01db }
            r5.<init>(r4)     // Catch:{ all -> 0x01db }
            boolean r1 = r5.isFile()     // Catch:{ all -> 0x01db }
            if (r1 == 0) goto L_0x00d7
            boolean r1 = r5.exists()     // Catch:{ all -> 0x01db }
            if (r1 == 0) goto L_0x00d7
            boolean r5 = r5.delete()     // Catch:{ all -> 0x01db }
            if (r5 == 0) goto L_0x00bf
            java.lang.String r5 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r2 = "delete success! file path is "
            r1.append(r2)     // Catch:{ all -> 0x01db }
            r1.append(r4)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x01db }
            com.huawei.android.pushagent.c.a.e.a(r5, r4)     // Catch:{ all -> 0x01db }
            goto L_0x01d9
        L_0x00bf:
            java.lang.String r5 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r2 = "delete failed! file path is "
            r1.append(r2)     // Catch:{ all -> 0x01db }
            r1.append(r4)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x01db }
        L_0x00d2:
            com.huawei.android.pushagent.c.a.e.d(r5, r4)     // Catch:{ all -> 0x01db }
            goto L_0x01d9
        L_0x00d7:
            java.lang.String r5 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r2 = "the file is not exist! file path is"
            r1.append(r2)     // Catch:{ all -> 0x01db }
            r1.append(r4)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x01db }
            goto L_0x00d2
        L_0x00eb:
            java.lang.String r1 = r5.c     // Catch:{ all -> 0x01db }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01db }
            if (r1 == 0) goto L_0x00fc
            java.lang.String r4 = "PushLogAC2705"
            java.lang.String r5 = "enter ModifyConfigs removeKey failed! mName is null"
            com.huawei.android.pushagent.c.a.e.d(r4, r5)     // Catch:{ all -> 0x01db }
            monitor-exit(r0)
            return
        L_0x00fc:
            java.io.File r1 = r4.getCacheDir()     // Catch:{ all -> 0x01db }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r2.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r1 = r1.getParent()     // Catch:{ all -> 0x01db }
            r2.append(r1)     // Catch:{ all -> 0x01db }
            java.lang.String r1 = java.io.File.separator     // Catch:{ all -> 0x01db }
            r2.append(r1)     // Catch:{ all -> 0x01db }
            java.lang.String r1 = "shared_prefs"
            r2.append(r1)     // Catch:{ all -> 0x01db }
            java.lang.String r1 = java.io.File.separator     // Catch:{ all -> 0x01db }
            r2.append(r1)     // Catch:{ all -> 0x01db }
            java.lang.String r1 = r5.a     // Catch:{ all -> 0x01db }
            r2.append(r1)     // Catch:{ all -> 0x01db }
            java.lang.String r1 = ".xml"
            r2.append(r1)     // Catch:{ all -> 0x01db }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01db }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x01db }
            r2.<init>(r1)     // Catch:{ all -> 0x01db }
            boolean r1 = r2.isFile()     // Catch:{ all -> 0x01db }
            if (r1 == 0) goto L_0x0172
            boolean r1 = r2.exists()     // Catch:{ all -> 0x01db }
            if (r1 == 0) goto L_0x0172
            com.huawei.android.pushagent.c.a.h r1 = new com.huawei.android.pushagent.c.a.h     // Catch:{ all -> 0x01db }
            java.lang.String r2 = r5.a     // Catch:{ all -> 0x01db }
            r1.<init>(r4, r2)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = r5.c     // Catch:{ all -> 0x01db }
            boolean r4 = r1.f(r4)     // Catch:{ all -> 0x01db }
            if (r4 == 0) goto L_0x016c
            java.lang.String r4 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r2 = "enter ModifyConfigs removeKey sucessfully! the fileName is "
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r2 = r5.a     // Catch:{ all -> 0x01db }
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r2 = ",the key is "
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r5 = r5.c     // Catch:{ all -> 0x01db }
            r1.append(r5)     // Catch:{ all -> 0x01db }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x01db }
        L_0x0168:
            com.huawei.android.pushagent.c.a.e.a(r4, r5)     // Catch:{ all -> 0x01db }
            goto L_0x01d9
        L_0x016c:
            java.lang.String r4 = "PushLogAC2705"
            java.lang.String r5 = "enter ModifyConfigs removeKey failed, maybe the key is not exist!"
            goto L_0x005e
        L_0x0172:
            java.lang.String r4 = "PushLogAC2705"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r5.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r1 = "the file is not exist! file path is"
            r5.append(r1)     // Catch:{ all -> 0x01db }
            r5.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01db }
            goto L_0x005e
        L_0x0187:
            java.lang.String r1 = r5.c     // Catch:{ all -> 0x01db }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01db }
            if (r1 == 0) goto L_0x0198
            java.lang.String r4 = "PushLogAC2705"
            java.lang.String r5 = "enter ModifyConfigs saveString failed! mName or mVal is null"
            com.huawei.android.pushagent.c.a.e.d(r4, r5)     // Catch:{ all -> 0x01db }
            monitor-exit(r0)
            return
        L_0x0198:
            com.huawei.android.pushagent.c.a.h r1 = new com.huawei.android.pushagent.c.a.h     // Catch:{ all -> 0x01db }
            java.lang.String r2 = r5.a     // Catch:{ all -> 0x01db }
            r1.<init>(r4, r2)     // Catch:{ all -> 0x01db }
            java.lang.String r4 = r5.c     // Catch:{ all -> 0x01db }
            java.lang.Object r2 = r5.d     // Catch:{ all -> 0x01db }
            boolean r4 = r1.a((java.lang.String) r4, (java.lang.Object) r2)     // Catch:{ all -> 0x01db }
            if (r4 == 0) goto L_0x01d3
            java.lang.String r4 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r2 = "enter ModifyConfigs saveString sucessfully! filename is "
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r2 = r5.a     // Catch:{ all -> 0x01db }
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r2 = ",itemName is "
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r2 = r5.c     // Catch:{ all -> 0x01db }
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r2 = ",itemValue is "
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.Object r5 = r5.d     // Catch:{ all -> 0x01db }
            r1.append(r5)     // Catch:{ all -> 0x01db }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x01db }
            goto L_0x0168
        L_0x01d3:
            java.lang.String r4 = "PushLogAC2705"
            java.lang.String r5 = "enter ModifyConfigs saveString failed!"
            goto L_0x005e
        L_0x01d9:
            monitor-exit(r0)
            return
        L_0x01db:
            r4 = move-exception
            monitor-exit(r0)
            goto L_0x01df
        L_0x01de:
            throw r4
        L_0x01df:
            goto L_0x01de
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.e.c.a(android.content.Context, java.lang.String):void");
    }
}
