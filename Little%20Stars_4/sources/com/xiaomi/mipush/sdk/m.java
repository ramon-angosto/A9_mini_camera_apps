package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.service.r;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.h;
import com.xiaomi.xmpush.thrift.i;
import com.xiaomi.xmpush.thrift.j;
import com.xiaomi.xmpush.thrift.l;
import com.xiaomi.xmpush.thrift.p;
import com.xiaomi.xmpush.thrift.s;
import com.xiaomi.xmpush.thrift.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TimeZone;
import org.apache.thrift.a;
import org.apache.thrift.f;

public class m {
    private static m a;
    private static Queue<String> c;
    private static Object d = new Object();
    private Context b;

    private m(Context context) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(android.content.Context r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            java.lang.String r0 = "intent_flag"
            r1 = 0
            if (r8 == 0) goto L_0x0166
            java.lang.String r2 = "notify_effect"
            boolean r3 = r8.containsKey(r2)
            if (r3 != 0) goto L_0x000f
            goto L_0x0166
        L_0x000f:
            java.lang.Object r2 = r8.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = com.xiaomi.push.service.aa.a
            boolean r3 = r3.equals(r2)
            java.lang.String r4 = "Cause: "
            if (r3 == 0) goto L_0x0043
            android.content.pm.PackageManager r8 = r6.getPackageManager()     // Catch:{ Exception -> 0x002a }
            android.content.Intent r7 = r8.getLaunchIntentForPackage(r7)     // Catch:{ Exception -> 0x002a }
            r8 = r7
            goto L_0x013b
        L_0x002a:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r7)
            goto L_0x013a
        L_0x0043:
            java.lang.String r3 = com.xiaomi.push.service.aa.b
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x00c2
            java.lang.String r2 = "intent_uri"
            boolean r3 = r8.containsKey(r2)
            if (r3 == 0) goto L_0x0077
            java.lang.Object r8 = r8.get(r2)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x013a
            r0 = 1
            android.content.Intent r8 = android.content.Intent.parseUri(r8, r0)     // Catch:{ URISyntaxException -> 0x0067 }
            r8.setPackage(r7)     // Catch:{ URISyntaxException -> 0x0065 }
            goto L_0x013b
        L_0x0065:
            r7 = move-exception
            goto L_0x0069
        L_0x0067:
            r7 = move-exception
            r8 = r1
        L_0x0069:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r7 = r7.getMessage()
            goto L_0x012f
        L_0x0077:
            java.lang.String r2 = "class_name"
            boolean r3 = r8.containsKey(r2)
            if (r3 == 0) goto L_0x013a
            java.lang.Object r2 = r8.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            android.content.ComponentName r5 = new android.content.ComponentName
            r5.<init>(r7, r2)
            r3.setComponent(r5)
            boolean r7 = r8.containsKey(r0)     // Catch:{ NumberFormatException -> 0x00a6 }
            if (r7 == 0) goto L_0x00bf
            java.lang.Object r7 = r8.get(r0)     // Catch:{ NumberFormatException -> 0x00a6 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x00a6 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x00a6 }
            r3.setFlags(r7)     // Catch:{ NumberFormatException -> 0x00a6 }
            goto L_0x00bf
        L_0x00a6:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Cause by intent_flag: "
            r8.append(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r7)
        L_0x00bf:
            r8 = r3
            goto L_0x013b
        L_0x00c2:
            java.lang.String r7 = com.xiaomi.push.service.aa.c
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x013a
            java.lang.String r7 = "web_uri"
            java.lang.Object r7 = r8.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x013a
            java.lang.String r7 = r7.trim()
            java.lang.String r8 = "http://"
            boolean r0 = r7.startsWith(r8)
            if (r0 != 0) goto L_0x00f7
            java.lang.String r0 = "https://"
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L_0x00f7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L_0x00f7:
            java.net.URL r8 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0121 }
            r8.<init>(r7)     // Catch:{ MalformedURLException -> 0x0121 }
            java.lang.String r8 = r8.getProtocol()     // Catch:{ MalformedURLException -> 0x0121 }
            java.lang.String r0 = "http"
            boolean r0 = r0.equals(r8)     // Catch:{ MalformedURLException -> 0x0121 }
            if (r0 != 0) goto L_0x0110
            java.lang.String r0 = "https"
            boolean r8 = r0.equals(r8)     // Catch:{ MalformedURLException -> 0x0121 }
            if (r8 == 0) goto L_0x013a
        L_0x0110:
            android.content.Intent r8 = new android.content.Intent     // Catch:{ MalformedURLException -> 0x0121 }
            java.lang.String r0 = "android.intent.action.VIEW"
            r8.<init>(r0)     // Catch:{ MalformedURLException -> 0x0121 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ MalformedURLException -> 0x011f }
            r8.setData(r7)     // Catch:{ MalformedURLException -> 0x011f }
            goto L_0x013b
        L_0x011f:
            r7 = move-exception
            goto L_0x0123
        L_0x0121:
            r7 = move-exception
            r8 = r1
        L_0x0123:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r7 = r7.getMessage()
        L_0x012f:
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r7)
            goto L_0x013b
        L_0x013a:
            r8 = r1
        L_0x013b:
            if (r8 == 0) goto L_0x0166
            r7 = 268435456(0x10000000, float:2.5243549E-29)
            r8.addFlags(r7)
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ Exception -> 0x014f }
            r7 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r6 = r6.resolveActivity(r8, r7)     // Catch:{ Exception -> 0x014f }
            if (r6 == 0) goto L_0x0166
            return r8
        L_0x014f:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r6 = r6.getMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r6)
        L_0x0166:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.m.a(android.content.Context, java.lang.String, java.util.Map):android.content.Intent");
    }

    /* JADX WARNING: type inference failed for: r3v19, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r3v20, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r3v21, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.xiaomi.mipush.sdk.PushMessageHandler.a a(com.xiaomi.xmpush.thrift.p r13, boolean r14, byte[] r15) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = r12.b     // Catch:{ c -> 0x048c, f -> 0x0482 }
            org.apache.thrift.a r1 = com.xiaomi.mipush.sdk.k.a((android.content.Context) r1, (com.xiaomi.xmpush.thrift.p) r13)     // Catch:{ c -> 0x048c, f -> 0x0482 }
            if (r1 != 0) goto L_0x0020
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ c -> 0x048c, f -> 0x0482 }
            r14.<init>()     // Catch:{ c -> 0x048c, f -> 0x0482 }
            java.lang.String r15 = "receiving an un-recognized message. "
            r14.append(r15)     // Catch:{ c -> 0x048c, f -> 0x0482 }
            com.xiaomi.xmpush.thrift.a r15 = r13.a     // Catch:{ c -> 0x048c, f -> 0x0482 }
            r14.append(r15)     // Catch:{ c -> 0x048c, f -> 0x0482 }
            java.lang.String r14 = r14.toString()     // Catch:{ c -> 0x048c, f -> 0x0482 }
            com.xiaomi.channel.commonutils.logger.b.d(r14)     // Catch:{ c -> 0x048c, f -> 0x0482 }
            return r0
        L_0x0020:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ c -> 0x048c, f -> 0x0482 }
            r2.<init>()     // Catch:{ c -> 0x048c, f -> 0x0482 }
            java.lang.String r3 = "receive a message."
            r2.append(r3)     // Catch:{ c -> 0x048c, f -> 0x0482 }
            r2.append(r1)     // Catch:{ c -> 0x048c, f -> 0x0482 }
            java.lang.String r2 = r2.toString()     // Catch:{ c -> 0x048c, f -> 0x0482 }
            com.xiaomi.channel.commonutils.logger.b.c(r2)     // Catch:{ c -> 0x048c, f -> 0x0482 }
            com.xiaomi.xmpush.thrift.a r2 = r13.a()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "processing a message, action="
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r3)
            int[] r3 = com.xiaomi.mipush.sdk.n.a
            int r2 = r2.ordinal()
            r2 = r3[r2]
            r3 = 0
            r5 = 0
            switch(r2) {
                case 1: goto L_0x02fa;
                case 2: goto L_0x02bd;
                case 3: goto L_0x02a2;
                case 4: goto L_0x026b;
                case 5: goto L_0x0234;
                case 6: goto L_0x014c;
                case 7: goto L_0x005c;
                default: goto L_0x005a;
            }
        L_0x005a:
            goto L_0x0481
        L_0x005c:
            com.xiaomi.xmpush.thrift.s r1 = (com.xiaomi.xmpush.thrift.s) r1
            java.lang.String r13 = r1.e
            java.lang.String r14 = "registration id expired"
            boolean r13 = r14.equalsIgnoreCase(r13)
            if (r13 == 0) goto L_0x0071
            android.content.Context r13 = r12.b
            com.xiaomi.xmpush.thrift.j r14 = com.xiaomi.xmpush.thrift.j.RegIdExpired
            com.xiaomi.mipush.sdk.MiPushClient.reInitialize(r13, r14)
            goto L_0x0481
        L_0x0071:
            java.lang.String r13 = r1.e
            java.lang.String r14 = "client_info_update_ok"
            boolean r13 = r14.equalsIgnoreCase(r13)
            if (r13 == 0) goto L_0x00a2
            java.util.Map r13 = r1.h()
            if (r13 == 0) goto L_0x0481
            java.util.Map r13 = r1.h()
            java.lang.String r14 = "app_version"
            boolean r13 = r13.containsKey(r14)
            if (r13 == 0) goto L_0x0481
            java.util.Map r13 = r1.h()
            java.lang.Object r13 = r13.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            android.content.Context r14 = r12.b
            com.xiaomi.mipush.sdk.a r14 = com.xiaomi.mipush.sdk.a.a((android.content.Context) r14)
            r14.a((java.lang.String) r13)
            goto L_0x0481
        L_0x00a2:
            java.lang.String r13 = r1.e
            java.lang.String r14 = "awake_app"
            boolean r13 = r14.equalsIgnoreCase(r13)
            if (r13 == 0) goto L_0x00d5
            java.util.Map r13 = r1.h()
            if (r13 == 0) goto L_0x0481
            java.util.Map r13 = r1.h()
            java.lang.String r14 = "packages"
            boolean r13 = r13.containsKey(r14)
            if (r13 == 0) goto L_0x0481
            java.util.Map r13 = r1.h()
            java.lang.Object r13 = r13.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = ","
            java.lang.String[] r13 = r13.split(r14)
            android.content.Context r14 = r12.b
            com.xiaomi.mipush.sdk.MiPushClient.awakeApps(r14, r13)
            goto L_0x0481
        L_0x00d5:
            com.xiaomi.xmpush.thrift.f r13 = com.xiaomi.xmpush.thrift.f.NormalClientConfigUpdate
            java.lang.String r13 = r13.z
            java.lang.String r14 = r1.e
            boolean r13 = r13.equalsIgnoreCase(r14)
            if (r13 == 0) goto L_0x00fe
            com.xiaomi.xmpush.thrift.r r13 = new com.xiaomi.xmpush.thrift.r
            r13.<init>()
            byte[] r14 = r1.l()     // Catch:{ f -> 0x00f8 }
            com.xiaomi.xmpush.thrift.ae.a(r13, (byte[]) r14)     // Catch:{ f -> 0x00f8 }
            android.content.Context r14 = r12.b     // Catch:{ f -> 0x00f8 }
            com.xiaomi.push.service.v r14 = com.xiaomi.push.service.v.a((android.content.Context) r14)     // Catch:{ f -> 0x00f8 }
            com.xiaomi.push.service.w.a((com.xiaomi.push.service.v) r14, (com.xiaomi.xmpush.thrift.r) r13)     // Catch:{ f -> 0x00f8 }
            goto L_0x0481
        L_0x00f8:
            r13 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r13)
            goto L_0x0481
        L_0x00fe:
            com.xiaomi.xmpush.thrift.f r13 = com.xiaomi.xmpush.thrift.f.CustomClientConfigUpdate
            java.lang.String r13 = r13.z
            java.lang.String r14 = r1.e
            boolean r13 = r13.equalsIgnoreCase(r14)
            if (r13 == 0) goto L_0x0121
            com.xiaomi.xmpush.thrift.q r13 = new com.xiaomi.xmpush.thrift.q
            r13.<init>()
            byte[] r14 = r1.l()     // Catch:{ f -> 0x00f8 }
            com.xiaomi.xmpush.thrift.ae.a(r13, (byte[]) r14)     // Catch:{ f -> 0x00f8 }
            android.content.Context r14 = r12.b     // Catch:{ f -> 0x00f8 }
            com.xiaomi.push.service.v r14 = com.xiaomi.push.service.v.a((android.content.Context) r14)     // Catch:{ f -> 0x00f8 }
            com.xiaomi.push.service.w.a((com.xiaomi.push.service.v) r14, (com.xiaomi.xmpush.thrift.q) r13)     // Catch:{ f -> 0x00f8 }
            goto L_0x0481
        L_0x0121:
            com.xiaomi.xmpush.thrift.f r13 = com.xiaomi.xmpush.thrift.f.SyncInfoResult
            java.lang.String r13 = r13.z
            java.lang.String r14 = r1.e
            boolean r13 = r13.equalsIgnoreCase(r14)
            if (r13 == 0) goto L_0x0134
            android.content.Context r13 = r12.b
            com.xiaomi.mipush.sdk.q.a((android.content.Context) r13, (com.xiaomi.xmpush.thrift.s) r1)
            goto L_0x0481
        L_0x0134:
            com.xiaomi.xmpush.thrift.f r13 = com.xiaomi.xmpush.thrift.f.ForceSync
            java.lang.String r13 = r13.z
            java.lang.String r14 = r1.e
            boolean r13 = r13.equalsIgnoreCase(r14)
            if (r13 == 0) goto L_0x0481
            java.lang.String r13 = "receive force sync notification"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r13)
            android.content.Context r13 = r12.b
            com.xiaomi.mipush.sdk.q.a((android.content.Context) r13, (boolean) r5)
            goto L_0x0481
        L_0x014c:
            com.xiaomi.xmpush.thrift.o r1 = (com.xiaomi.xmpush.thrift.o) r1
            java.lang.String r6 = r1.e()
            java.util.List r13 = r1.k()
            long r14 = r1.g
            int r0 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0226
            java.lang.String r14 = "accept-time"
            boolean r14 = android.text.TextUtils.equals(r6, r14)
            if (r14 == 0) goto L_0x01b7
            if (r13 == 0) goto L_0x01b7
            int r14 = r13.size()
            r15 = 1
            if (r14 <= r15) goto L_0x01b7
            android.content.Context r14 = r12.b
            java.lang.Object r0 = r13.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r13.get(r15)
            java.lang.String r2 = (java.lang.String) r2
            com.xiaomi.mipush.sdk.MiPushClient.addAcceptTime(r14, r0, r2)
            java.lang.Object r14 = r13.get(r5)
            java.lang.String r0 = "00:00"
            boolean r14 = r0.equals(r14)
            if (r14 == 0) goto L_0x019e
            java.lang.Object r14 = r13.get(r15)
            boolean r14 = r0.equals(r14)
            if (r14 == 0) goto L_0x019e
            android.content.Context r14 = r12.b
            com.xiaomi.mipush.sdk.a r14 = com.xiaomi.mipush.sdk.a.a((android.content.Context) r14)
            r14.a((boolean) r15)
            goto L_0x01a7
        L_0x019e:
            android.content.Context r14 = r12.b
            com.xiaomi.mipush.sdk.a r14 = com.xiaomi.mipush.sdk.a.a((android.content.Context) r14)
            r14.a((boolean) r5)
        L_0x01a7:
            java.lang.String r14 = "GMT+08"
            java.util.TimeZone r14 = java.util.TimeZone.getTimeZone(r14)
            java.util.TimeZone r15 = java.util.TimeZone.getDefault()
            java.util.List r13 = r12.a((java.util.TimeZone) r14, (java.util.TimeZone) r15, (java.util.List<java.lang.String>) r13)
            goto L_0x0226
        L_0x01b7:
            java.lang.String r14 = "set-alias"
            boolean r14 = android.text.TextUtils.equals(r6, r14)
            if (r14 == 0) goto L_0x01d3
            if (r13 == 0) goto L_0x01d3
            int r14 = r13.size()
            if (r14 <= 0) goto L_0x01d3
            android.content.Context r14 = r12.b
            java.lang.Object r15 = r13.get(r5)
            java.lang.String r15 = (java.lang.String) r15
            com.xiaomi.mipush.sdk.MiPushClient.addAlias(r14, r15)
            goto L_0x0226
        L_0x01d3:
            java.lang.String r14 = "unset-alias"
            boolean r14 = android.text.TextUtils.equals(r6, r14)
            if (r14 == 0) goto L_0x01ef
            if (r13 == 0) goto L_0x01ef
            int r14 = r13.size()
            if (r14 <= 0) goto L_0x01ef
            android.content.Context r14 = r12.b
            java.lang.Object r15 = r13.get(r5)
            java.lang.String r15 = (java.lang.String) r15
            com.xiaomi.mipush.sdk.MiPushClient.removeAlias(r14, r15)
            goto L_0x0226
        L_0x01ef:
            java.lang.String r14 = "set-account"
            boolean r14 = android.text.TextUtils.equals(r6, r14)
            if (r14 == 0) goto L_0x020b
            if (r13 == 0) goto L_0x020b
            int r14 = r13.size()
            if (r14 <= 0) goto L_0x020b
            android.content.Context r14 = r12.b
            java.lang.Object r15 = r13.get(r5)
            java.lang.String r15 = (java.lang.String) r15
            com.xiaomi.mipush.sdk.MiPushClient.addAccount(r14, r15)
            goto L_0x0226
        L_0x020b:
            java.lang.String r14 = "unset-account"
            boolean r14 = android.text.TextUtils.equals(r6, r14)
            if (r14 == 0) goto L_0x0226
            if (r13 == 0) goto L_0x0226
            int r14 = r13.size()
            if (r14 <= 0) goto L_0x0226
            android.content.Context r14 = r12.b
            java.lang.Object r15 = r13.get(r5)
            java.lang.String r15 = (java.lang.String) r15
            com.xiaomi.mipush.sdk.MiPushClient.removeAccount(r14, r15)
        L_0x0226:
            r7 = r13
            long r8 = r1.g
            java.lang.String r10 = r1.h
            java.lang.String r11 = r1.m()
            com.xiaomi.mipush.sdk.MiPushCommandMessage r13 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r6, r7, r8, r10, r11)
            return r13
        L_0x0234:
            com.xiaomi.xmpush.thrift.ad r1 = (com.xiaomi.xmpush.thrift.ad) r1
            long r13 = r1.f
            int r15 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r15 != 0) goto L_0x0245
            android.content.Context r13 = r12.b
            java.lang.String r14 = r1.h()
            com.xiaomi.mipush.sdk.MiPushClient.removeTopic(r13, r14)
        L_0x0245:
            java.lang.String r13 = r1.h()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x025b
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r13 = r1.h()
            r0.add(r13)
        L_0x025b:
            r3 = r0
            long r4 = r1.f
            java.lang.String r6 = r1.g
            java.lang.String r7 = r1.k()
            java.lang.String r2 = "unsubscibe-topic"
            com.xiaomi.mipush.sdk.MiPushCommandMessage r13 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r2, r3, r4, r6, r7)
            return r13
        L_0x026b:
            com.xiaomi.xmpush.thrift.z r1 = (com.xiaomi.xmpush.thrift.z) r1
            long r13 = r1.f
            int r15 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r15 != 0) goto L_0x027c
            android.content.Context r13 = r12.b
            java.lang.String r14 = r1.h()
            com.xiaomi.mipush.sdk.MiPushClient.addTopic(r13, r14)
        L_0x027c:
            java.lang.String r13 = r1.h()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x0292
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r13 = r1.h()
            r0.add(r13)
        L_0x0292:
            r3 = r0
            long r4 = r1.f
            java.lang.String r6 = r1.g
            java.lang.String r7 = r1.k()
            java.lang.String r2 = "subscribe-topic"
            com.xiaomi.mipush.sdk.MiPushCommandMessage r13 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r2, r3, r4, r6, r7)
            return r13
        L_0x02a2:
            com.xiaomi.xmpush.thrift.ab r1 = (com.xiaomi.xmpush.thrift.ab) r1
            long r13 = r1.f
            int r15 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r15 != 0) goto L_0x02b8
            android.content.Context r13 = r12.b
            com.xiaomi.mipush.sdk.a r13 = com.xiaomi.mipush.sdk.a.a((android.content.Context) r13)
            r13.h()
            android.content.Context r13 = r12.b
            com.xiaomi.mipush.sdk.MiPushClient.clearExtras(r13)
        L_0x02b8:
            com.xiaomi.mipush.sdk.PushMessageHandler.a()
            goto L_0x0481
        L_0x02bd:
            com.xiaomi.xmpush.thrift.u r1 = (com.xiaomi.xmpush.thrift.u) r1
            long r13 = r1.f
            int r15 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r15 != 0) goto L_0x02d2
            android.content.Context r13 = r12.b
            com.xiaomi.mipush.sdk.a r13 = com.xiaomi.mipush.sdk.a.a((android.content.Context) r13)
            java.lang.String r14 = r1.h
            java.lang.String r15 = r1.i
            r13.b(r14, r15)
        L_0x02d2:
            java.lang.String r13 = r1.h
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x02e4
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r13 = r1.h
            r0.add(r13)
        L_0x02e4:
            r3 = r0
            long r4 = r1.f
            java.lang.String r6 = r1.g
            r7 = 0
            java.lang.String r2 = "register"
            com.xiaomi.mipush.sdk.MiPushCommandMessage r13 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r2, r3, r4, r6, r7)
            android.content.Context r14 = r12.b
            com.xiaomi.mipush.sdk.o r14 = com.xiaomi.mipush.sdk.o.a((android.content.Context) r14)
            r14.d()
            return r13
        L_0x02fa:
            android.content.Context r2 = r12.b
            com.xiaomi.mipush.sdk.a r2 = com.xiaomi.mipush.sdk.a.a((android.content.Context) r2)
            boolean r2 = r2.l()
            if (r2 == 0) goto L_0x030e
            if (r14 != 0) goto L_0x030e
            java.lang.String r13 = "receive a message in pause state. drop it"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r13)
            return r0
        L_0x030e:
            com.xiaomi.xmpush.thrift.x r1 = (com.xiaomi.xmpush.thrift.x) r1
            com.xiaomi.xmpush.thrift.h r2 = r1.l()
            if (r2 != 0) goto L_0x031c
            java.lang.String r13 = "receive an empty message without push content, drop it"
            com.xiaomi.channel.commonutils.logger.b.d(r13)
            return r0
        L_0x031c:
            if (r14 == 0) goto L_0x0349
            boolean r5 = com.xiaomi.push.service.r.b(r13)
            if (r5 == 0) goto L_0x0338
            android.content.Context r5 = r12.b
            java.lang.String r6 = r2.b()
            com.xiaomi.xmpush.thrift.i r7 = r13.m()
            java.lang.String r8 = r13.f
            java.lang.String r9 = r2.d()
            com.xiaomi.mipush.sdk.MiPushClient.reportIgnoreRegMessageClicked(r5, r6, r7, r8, r9)
            goto L_0x0349
        L_0x0338:
            android.content.Context r5 = r12.b
            java.lang.String r6 = r2.b()
            com.xiaomi.xmpush.thrift.i r7 = r13.m()
            java.lang.String r8 = r2.d()
            com.xiaomi.mipush.sdk.MiPushClient.reportMessageClicked(r5, r6, r7, r8)
        L_0x0349:
            if (r14 != 0) goto L_0x038e
            java.lang.String r5 = r1.j()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x036d
            android.content.Context r5 = r12.b
            java.lang.String r6 = r1.j()
            long r5 = com.xiaomi.mipush.sdk.MiPushClient.aliasSetTime(r5, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x036d
            android.content.Context r3 = r12.b
            java.lang.String r4 = r1.j()
            com.xiaomi.mipush.sdk.MiPushClient.addAlias(r3, r4)
            goto L_0x038e
        L_0x036d:
            java.lang.String r5 = r1.h()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x038e
            android.content.Context r5 = r12.b
            java.lang.String r6 = r1.h()
            long r5 = com.xiaomi.mipush.sdk.MiPushClient.topicSubscribedTime(r5, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x038e
            android.content.Context r3 = r12.b
            java.lang.String r4 = r1.h()
            com.xiaomi.mipush.sdk.MiPushClient.addTopic(r3, r4)
        L_0x038e:
            com.xiaomi.xmpush.thrift.i r3 = r13.h
            if (r3 == 0) goto L_0x03a7
            com.xiaomi.xmpush.thrift.i r3 = r13.h
            java.util.Map r3 = r3.s()
            if (r3 == 0) goto L_0x03a7
            com.xiaomi.xmpush.thrift.i r3 = r13.h
            java.util.Map<java.lang.String, java.lang.String> r3 = r3.j
            java.lang.String r4 = "jobkey"
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x03a8
        L_0x03a7:
            r3 = r0
        L_0x03a8:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x03b2
            java.lang.String r3 = r2.b()
        L_0x03b2:
            if (r14 != 0) goto L_0x03d2
            android.content.Context r4 = r12.b
            boolean r4 = a((android.content.Context) r4, (java.lang.String) r3)
            if (r4 == 0) goto L_0x03d2
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "drop a duplicate message, key="
            r15.append(r2)
            r15.append(r3)
            java.lang.String r15 = r15.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r15)
            goto L_0x0476
        L_0x03d2:
            com.xiaomi.xmpush.thrift.i r4 = r13.m()
            com.xiaomi.mipush.sdk.MiPushMessage r4 = com.xiaomi.mipush.sdk.PushMessageHelper.generateMessage(r1, r4, r14)
            int r5 = r4.getPassThrough()
            if (r5 != 0) goto L_0x03f2
            if (r14 != 0) goto L_0x03f2
            java.util.Map r5 = r4.getExtra()
            boolean r5 = com.xiaomi.push.service.r.a((java.util.Map<java.lang.String, java.lang.String>) r5)
            if (r5 == 0) goto L_0x03f2
            android.content.Context r14 = r12.b
            com.xiaomi.push.service.r.a((android.content.Context) r14, (com.xiaomi.xmpush.thrift.p) r13, (byte[]) r15)
            return r0
        L_0x03f2:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r5 = "receive a message, msgid="
            r15.append(r5)
            java.lang.String r5 = r2.b()
            r15.append(r5)
            java.lang.String r5 = ", jobkey="
            r15.append(r5)
            r15.append(r3)
            java.lang.String r15 = r15.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r15)
            if (r14 == 0) goto L_0x0475
            java.util.Map r15 = r4.getExtra()
            if (r15 == 0) goto L_0x0475
            java.util.Map r15 = r4.getExtra()
            java.lang.String r3 = "notify_effect"
            boolean r15 = r15.containsKey(r3)
            if (r15 == 0) goto L_0x0475
            java.util.Map r14 = r4.getExtra()
            java.lang.Object r15 = r14.get(r3)
            java.lang.String r15 = (java.lang.String) r15
            boolean r1 = com.xiaomi.push.service.r.b(r13)
            if (r1 == 0) goto L_0x0456
            android.content.Context r15 = r12.b
            java.lang.String r13 = r13.f
            android.content.Intent r13 = a((android.content.Context) r15, (java.lang.String) r13, (java.util.Map<java.lang.String, java.lang.String>) r14)
            if (r13 != 0) goto L_0x0446
            java.lang.String r13 = "Getting Intent fail from ignore reg message. "
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r13)
            return r0
        L_0x0446:
            java.lang.String r14 = r2.f()
            boolean r15 = android.text.TextUtils.isEmpty(r14)
            if (r15 != 0) goto L_0x046f
            java.lang.String r15 = "payload"
            r13.putExtra(r15, r14)
            goto L_0x046f
        L_0x0456:
            android.content.Context r13 = r12.b
            java.lang.String r1 = r13.getPackageName()
            android.content.Intent r13 = a((android.content.Context) r13, (java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.String>) r14)
            if (r13 == 0) goto L_0x0474
            java.lang.String r14 = com.xiaomi.push.service.aa.c
            boolean r14 = r15.equals(r14)
            if (r14 != 0) goto L_0x046f
            java.lang.String r14 = "key_message"
            r13.putExtra(r14, r4)
        L_0x046f:
            android.content.Context r14 = r12.b
            r14.startActivity(r13)
        L_0x0474:
            return r0
        L_0x0475:
            r0 = r4
        L_0x0476:
            com.xiaomi.xmpush.thrift.i r15 = r13.m()
            if (r15 != 0) goto L_0x0481
            if (r14 != 0) goto L_0x0481
            r12.a((com.xiaomi.xmpush.thrift.x) r1, (com.xiaomi.xmpush.thrift.p) r13)
        L_0x0481:
            return r0
        L_0x0482:
            r13 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r13)
            java.lang.String r13 = "receive a message which action string is not valid. is the reg expired?"
            com.xiaomi.channel.commonutils.logger.b.d(r13)
            return r0
        L_0x048c:
            r14 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r14)
            r12.a((com.xiaomi.xmpush.thrift.p) r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.m.a(com.xiaomi.xmpush.thrift.p, boolean, byte[]):com.xiaomi.mipush.sdk.PushMessageHandler$a");
    }

    private PushMessageHandler.a a(p pVar, byte[] bArr) {
        String str;
        String str2 = null;
        try {
            a a2 = k.a(this.b, pVar);
            if (a2 == null) {
                b.d("message arrived: receiving an un-recognized message. " + pVar.a);
                return null;
            }
            b.c("message arrived: receive a message." + a2);
            com.xiaomi.xmpush.thrift.a a3 = pVar.a();
            b.a("message arrived: processing an arrived message, action=" + a3);
            if (n.a[a3.ordinal()] != 1) {
                return null;
            }
            x xVar = (x) a2;
            h l = xVar.l();
            if (l == null) {
                str = "message arrived: receive an empty message without push content, drop it";
                b.d(str);
                return null;
            }
            if (!(pVar.h == null || pVar.h.s() == null)) {
                str2 = pVar.h.j.get("jobkey");
            }
            MiPushMessage generateMessage = PushMessageHelper.generateMessage(xVar, pVar.m(), false);
            generateMessage.setArrivedMessage(true);
            b.a("message arrived: receive a message, msgid=" + l.b() + ", jobkey=" + str2);
            return generateMessage;
        } catch (c e) {
            b.a((Throwable) e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (f e2) {
            b.a((Throwable) e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
    }

    public static m a(Context context) {
        if (a == null) {
            a = new m(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0)) > 1800000) {
            MiPushClient.reInitialize(this.b, j.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    private void a(p pVar) {
        b.a("receive a message but decrypt failed. report now.");
        s sVar = new s(pVar.m().a, false);
        sVar.c(com.xiaomi.xmpush.thrift.f.DecryptMessageFail.z);
        sVar.b(pVar.h());
        sVar.d(pVar.f);
        sVar.h = new HashMap();
        sVar.h.put("regid", MiPushClient.getRegId(this.b));
        o.a(this.b).a(sVar, com.xiaomi.xmpush.thrift.a.Notification, false, (i) null);
    }

    private void a(x xVar, p pVar) {
        i m = pVar.m();
        l lVar = new l();
        lVar.b(xVar.e());
        lVar.a(xVar.c());
        lVar.a(xVar.l().h());
        if (!TextUtils.isEmpty(xVar.h())) {
            lVar.c(xVar.h());
        }
        if (!TextUtils.isEmpty(xVar.j())) {
            lVar.d(xVar.j());
        }
        lVar.a(ae.a(this.b, pVar.f));
        o.a(this.b).a(lVar, com.xiaomi.xmpush.thrift.a.AckMessage, m);
    }

    private static boolean a(Context context, String str) {
        synchronized (d) {
            SharedPreferences j = a.a(context).j();
            if (c == null) {
                String[] split = j.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                c = new LinkedList();
                for (String add : split) {
                    c.add(add);
                }
            }
            if (c.contains(str)) {
                return true;
            }
            c.add(str);
            if (c.size() > 25) {
                c.poll();
            }
            String a2 = d.a((Collection<?>) c, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = j.edit();
            edit.putString("pref_msg_ids", a2);
            edit.commit();
            return false;
        }
    }

    private void b(p pVar) {
        i m = pVar.m();
        l lVar = new l();
        lVar.b(pVar.h());
        lVar.a(m.b());
        lVar.a(m.d());
        if (!TextUtils.isEmpty(m.f())) {
            lVar.c(m.f());
        }
        lVar.a(ae.a(this.b, pVar.f));
        o.a(this.b).a(lVar, com.xiaomi.xmpush.thrift.a.AckMessage, false, pVar.m());
    }

    public PushMessageHandler.a a(Intent intent) {
        String str;
        String str2;
        String action = intent.getAction();
        b.a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                str2 = "receiving an empty message, drop";
            } else {
                p pVar = new p();
                try {
                    ae.a(pVar, byteArrayExtra);
                    a a2 = a.a(this.b);
                    i m = pVar.m();
                    if (pVar.a() == com.xiaomi.xmpush.thrift.a.SendMessage && m != null && !a2.l() && !booleanExtra) {
                        if (m != null) {
                            pVar.m().a("mrt", stringExtra);
                            pVar.m().a("mat", Long.toString(System.currentTimeMillis()));
                        }
                        b(pVar);
                    }
                    if (pVar.a() == com.xiaomi.xmpush.thrift.a.SendMessage && !pVar.c()) {
                        if (!r.b(pVar)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = pVar.j();
                            objArr[1] = m != null ? m.b() : "";
                            b.a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr));
                            return null;
                        } else if (!booleanExtra || m.s() == null || !m.s().containsKey("notify_effect")) {
                            b.a(String.format("drop an un-encrypted messages. %1$s, %2$s", new Object[]{pVar.j(), m.b()}));
                            return null;
                        }
                    }
                    if (a2.i() || pVar.a == com.xiaomi.xmpush.thrift.a.Registration) {
                        if (!a2.i() || !a2.n()) {
                            return a(pVar, booleanExtra, byteArrayExtra);
                        }
                        if (pVar.a == com.xiaomi.xmpush.thrift.a.UnRegistration) {
                            a2.h();
                            MiPushClient.clearExtras(this.b);
                            PushMessageHandler.a();
                        } else {
                            MiPushClient.unregisterPush(this.b);
                        }
                        return null;
                    } else if (r.b(pVar)) {
                        return a(pVar, booleanExtra, byteArrayExtra);
                    } else {
                        b.d("receive message without registration. need re-register!");
                        a();
                        return null;
                    }
                } catch (Exception | f e) {
                    b.a(e);
                }
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            p pVar2 = new p();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    ae.a(pVar2, byteArrayExtra2);
                }
            } catch (f unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(pVar2.a()));
            miPushCommandMessage.setResultCode((long) intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else {
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    str2 = "message arrived: receiving an empty message, drop";
                } else {
                    p pVar3 = new p();
                    ae.a(pVar3, byteArrayExtra3);
                    a a3 = a.a(this.b);
                    if (r.b(pVar3)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!a3.i()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else if (!a3.i() || !a3.n()) {
                        return a(pVar3, byteArrayExtra3);
                    } else {
                        str = "message arrived: app info is invalidated";
                    }
                    b.d(str);
                }
            }
            return null;
        }
        b.d(str2);
        return null;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        List<String> list2 = list;
        if (timeZone.equals(timeZone2)) {
            return list2;
        }
        long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE) / 60);
        long parseLong = Long.parseLong(list2.get(0).split(":")[0]);
        long parseLong2 = Long.parseLong(list2.get(0).split(":")[1]);
        long j = ((((parseLong * 60) + parseLong2) - rawOffset) + 1440) % 1440;
        long parseLong3 = ((((Long.parseLong(list2.get(1).split(":")[0]) * 60) + Long.parseLong(list2.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)}));
        return arrayList;
    }
}
