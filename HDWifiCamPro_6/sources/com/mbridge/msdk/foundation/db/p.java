package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.x;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.net.URLEncoder;

/* compiled from: VideoReportDataDao */
public class p extends a<m> {
    private static final String a = p.class.getName();
    private static p b = null;

    private p(f fVar) {
        super(fVar);
    }

    public static synchronized p a(f fVar) {
        p pVar;
        synchronized (p.class) {
            if (b == null) {
                b = new p(fVar);
            }
            pVar = b;
        }
        return pVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0324, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0325, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0326, code lost:
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x034e, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0130, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0131, code lost:
        r10 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x021a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0314, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0325 A[ExcHandler: all (th java.lang.Throwable), PHI: r13 
      PHI: (r13v2 android.database.Cursor) = (r13v0 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor), (r13v3 android.database.Cursor) binds: [B:8:0x0021, B:22:0x013a, B:29:0x0171, B:36:0x018c, B:42:0x019c, B:50:0x01b5, B:46:0x01a4, B:47:?, B:39:0x0192, B:40:?, B:32:0x0177, B:33:?, B:25:0x0140, B:26:?, B:16:0x0112, B:17:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:8:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0346 A[SYNTHETIC, Splitter:B:117:0x0346] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x034e A[Catch:{ all -> 0x034a }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0314 A[ExcHandler: all (th java.lang.Throwable), PHI: r16 
      PHI: (r16v3 android.database.Cursor) = (r16v4 android.database.Cursor), (r16v8 android.database.Cursor) binds: [B:70:0x0238, B:57:0x01ec] A[DONT_GENERATE, DONT_INLINE], Splitter:B:57:0x01ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.m> a(java.lang.String r26) {
        /*
            r25 = this;
            r0 = r26
            monitor-enter(r25)
            boolean r1 = android.text.TextUtils.isEmpty(r26)     // Catch:{ all -> 0x0355 }
            if (r1 != 0) goto L_0x0352
            android.database.sqlite.SQLiteDatabase r2 = r25.getReadableDatabase()     // Catch:{ Exception -> 0x0336, all -> 0x0333 }
            java.lang.String r3 = "reward_report"
            r4 = 0
            java.lang.String r5 = "key=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ Exception -> 0x0336, all -> 0x0333 }
            r12 = 0
            r6[r12] = r0     // Catch:{ Exception -> 0x0336, all -> 0x0333 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0336, all -> 0x0333 }
            if (r13 == 0) goto L_0x032c
            int r1 = r13.getCount()     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            if (r1 <= 0) goto L_0x032c
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            r14.<init>()     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
        L_0x002c:
            boolean r1 = r13.moveToNext()     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            if (r1 == 0) goto L_0x031c
            java.lang.String r1 = "key"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r3 = r13.getString(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "networkType"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            int r4 = r13.getInt(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "network_str"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r7 = r13.getString(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "isCompleteView"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            r13.getInt(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "watchedMillis"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            r13.getInt(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "videoLength"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            int r18 = r13.getInt(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "offerUrl"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r5 = r13.getString(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "reason"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r8 = r13.getString(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "result"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            int r6 = r13.getInt(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "duration"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r21 = r13.getString(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "videoSize"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            int r22 = r13.getInt(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "campaignId"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r9 = r13.getString(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = "video_url"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r2 = "unitId"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r15 = r13.getString(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r2 = "rid"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r10 = "rid_n"
            int r10 = r13.getColumnIndex(r10)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r10 = r13.getString(r10)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r12 = "ad_type"
            int r12 = r13.getColumnIndex(r12)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r12 = r13.getString(r12)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r11 = "resource_type"
            int r11 = r13.getColumnIndex(r11)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r11 = r13.getString(r11)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            r16 = r2
            java.lang.String r2 = "device_id"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            r17 = r2
            java.lang.String r2 = "creative"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            r19 = r2
            java.lang.String r2 = "adspace_t"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            int r2 = r13.getInt(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            r20 = r2
            java.lang.String r2 = "2000021"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            if (r2 == 0) goto L_0x0134
            com.mbridge.msdk.foundation.entity.m r11 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r12 = r16
            r2 = r11
            r6 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.n(r9)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.e((java.lang.String) r1)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.k(r12)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.l(r10)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.m(r15)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r1 = r11
            r7 = r13
            r24 = r14
            goto L_0x02d4
        L_0x0130:
            r0 = move-exception
            r10 = r13
            goto L_0x0338
        L_0x0134:
            r2 = r16
            r16 = r15
            java.lang.String r15 = "2000022"
            boolean r15 = r0.equals(r15)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            if (r15 == 0) goto L_0x016b
            com.mbridge.msdk.foundation.entity.m r11 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r24 = r14
            r14 = r16
            r15 = r11
            r16 = r3
            r17 = r4
            r19 = r5
            r20 = r6
            r23 = r7
            r15.<init>((java.lang.String) r16, (int) r17, (int) r18, (java.lang.String) r19, (int) r20, (java.lang.String) r21, (int) r22, (java.lang.String) r23)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.n(r9)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.e((java.lang.String) r1)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.k(r2)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.l(r10)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.m(r14)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.p(r8)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r11.h((java.lang.String) r12)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r1 = r11
            goto L_0x0187
        L_0x016b:
            r24 = r14
            r14 = r16
            java.lang.String r1 = "2000025"
            boolean r1 = r0.equals(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            if (r1 == 0) goto L_0x018a
            com.mbridge.msdk.foundation.entity.m r1 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r15 = r1
            r16 = r3
            r17 = r4
            r19 = r5
            r20 = r6
            r23 = r7
            r15.<init>((java.lang.String) r16, (int) r17, (int) r18, (java.lang.String) r19, (int) r20, (java.lang.String) r21, (int) r22, (java.lang.String) r23)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
        L_0x0187:
            r7 = r13
            goto L_0x02d4
        L_0x018a:
            java.lang.String r1 = "2000024"
            boolean r1 = r0.equals(r1)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            if (r1 == 0) goto L_0x019a
            com.mbridge.msdk.foundation.entity.m r1 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r2 = r1
            r6 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            goto L_0x0187
        L_0x019a:
            java.lang.String r1 = "2000039"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            if (r1 == 0) goto L_0x01b3
            java.lang.String r1 = "h5_click_data"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            com.mbridge.msdk.foundation.entity.m r10 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r10.<init>(r1)     // Catch:{ Exception -> 0x0130, all -> 0x0325 }
            r1 = r10
            goto L_0x0187
        L_0x01b3:
            java.lang.String r1 = "2000043"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x0328, all -> 0x0325 }
            if (r1 == 0) goto L_0x0228
            java.lang.String r1 = "type"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0221, all -> 0x021c }
            java.lang.String r15 = r13.getString(r1)     // Catch:{ Exception -> 0x0221, all -> 0x021c }
            java.lang.String r1 = "endcard_url"
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x0221, all -> 0x021c }
            java.lang.String r5 = r13.getString(r1)     // Catch:{ Exception -> 0x0221, all -> 0x021c }
            com.mbridge.msdk.foundation.entity.m r7 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0221, all -> 0x021c }
            r1 = r7
            r4 = r2
            r16 = r13
            r3 = r17
            r13 = r19
            r0 = r20
            r2 = r26
            r13 = r3
            r3 = r6
            r6 = r4
            r4 = r21
            r17 = r13
            r13 = r6
            r6 = r9
            r18 = r11
            r11 = r7
            r7 = r14
            r14 = r9
            r9 = r15
            r1.<init>((java.lang.String) r2, (int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
            r11.k(r13)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
            r11.l(r10)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
            if (r1 != 0) goto L_0x01fe
            r11.n(r14)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
        L_0x01fe:
            r11.b((int) r0)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
            r11.h((java.lang.String) r12)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
            r1 = r18
            r11.a((java.lang.String) r1)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
            r2 = r17
            r11.b((java.lang.String) r2)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
            r3 = r19
            r11.c((java.lang.String) r3)     // Catch:{ Exception -> 0x021a, all -> 0x0314 }
            r0 = r26
            r1 = r11
            r7 = r16
            goto L_0x02d4
        L_0x021a:
            r0 = move-exception
            goto L_0x0224
        L_0x021c:
            r0 = move-exception
            r16 = r13
            goto L_0x0315
        L_0x0221:
            r0 = move-exception
            r16 = r13
        L_0x0224:
            r10 = r16
            goto L_0x0338
        L_0x0228:
            r5 = r9
            r1 = r11
            r16 = r13
            r3 = r19
            r0 = r20
            r13 = r2
            r2 = r17
            java.lang.String r7 = "2000045"
            r9 = r0
            r0 = r26
            boolean r7 = r7.equals(r0)     // Catch:{ Exception -> 0x0318, all -> 0x0314 }
            if (r7 == 0) goto L_0x026b
            com.mbridge.msdk.foundation.entity.m r1 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0318, all -> 0x0314 }
            r1.<init>()     // Catch:{ Exception -> 0x0318, all -> 0x0314 }
            r1.o(r0)     // Catch:{ Exception -> 0x0318, all -> 0x0314 }
            r1.c((int) r4)     // Catch:{ Exception -> 0x0318, all -> 0x0314 }
            r1.d((int) r6)     // Catch:{ Exception -> 0x0318, all -> 0x0314 }
            r1.n(r5)     // Catch:{ Exception -> 0x0318, all -> 0x0314 }
            java.lang.String r2 = "template_url"
            r7 = r16
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.i(r2)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.p(r8)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.k(r13)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.l(r10)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.m(r14)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            goto L_0x02d4
        L_0x026b:
            r7 = r16
            java.lang.String r11 = "2000044"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            if (r11 == 0) goto L_0x029d
            com.mbridge.msdk.foundation.entity.m r1 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.<init>()     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.o(r0)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.c((int) r4)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.n(r5)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            java.lang.String r2 = "image_url"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.d((java.lang.String) r2)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.p(r8)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.k(r13)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.l(r10)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1.m(r14)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            goto L_0x02d4
        L_0x029d:
            java.lang.String r11 = "2000054"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            if (r11 == 0) goto L_0x02d3
            com.mbridge.msdk.foundation.entity.m r11 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.<init>()     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.o(r0)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.m(r14)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.b((java.lang.String) r2)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.h((java.lang.String) r12)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.n(r5)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.k(r13)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.l(r10)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.d((int) r6)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.p(r8)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.c((int) r4)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.c((java.lang.String) r3)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r11.b((int) r9)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r1 = r11
            goto L_0x02d4
        L_0x02d3:
            r1 = 0
        L_0x02d4:
            if (r1 == 0) goto L_0x02dc
            r2 = r24
            r2.add(r1)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            goto L_0x02de
        L_0x02dc:
            r2 = r24
        L_0x02de:
            java.lang.String r1 = "id"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            int r1 = r7.getInt(r1)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            android.database.sqlite.SQLiteDatabase r3 = r25.getWritableDatabase()     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            java.lang.String r4 = "reward_report"
            java.lang.String r5 = "id = ?"
            r6 = 1
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r9.<init>()     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r9.append(r1)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            java.lang.String r1 = ""
            r9.append(r1)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            java.lang.String r1 = r9.toString()     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r9 = 0
            r8[r9] = r1     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r3.delete(r4, r5, r8)     // Catch:{ Exception -> 0x0312, all -> 0x0310 }
            r14 = r2
            r11 = r6
            r13 = r7
            r12 = r9
            goto L_0x002c
        L_0x0310:
            r0 = move-exception
            goto L_0x034c
        L_0x0312:
            r0 = move-exception
            goto L_0x032a
        L_0x0314:
            r0 = move-exception
        L_0x0315:
            r7 = r16
            goto L_0x034c
        L_0x0318:
            r0 = move-exception
            r7 = r16
            goto L_0x032a
        L_0x031c:
            r7 = r13
            r2 = r14
            if (r7 == 0) goto L_0x0323
            r7.close()     // Catch:{ all -> 0x0355 }
        L_0x0323:
            monitor-exit(r25)
            return r2
        L_0x0325:
            r0 = move-exception
            r7 = r13
            goto L_0x034c
        L_0x0328:
            r0 = move-exception
            r7 = r13
        L_0x032a:
            r10 = r7
            goto L_0x0338
        L_0x032c:
            r7 = r13
            if (r7 == 0) goto L_0x0352
            r7.close()     // Catch:{ all -> 0x0355 }
            goto L_0x0352
        L_0x0333:
            r0 = move-exception
            r7 = 0
            goto L_0x034c
        L_0x0336:
            r0 = move-exception
            r10 = 0
        L_0x0338:
            r0.printStackTrace()     // Catch:{ all -> 0x034a }
            java.lang.String r1 = a     // Catch:{ all -> 0x034a }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x034a }
            com.mbridge.msdk.foundation.tools.q.d(r1, r0)     // Catch:{ all -> 0x034a }
            if (r10 == 0) goto L_0x0352
            r10.close()     // Catch:{ all -> 0x0355 }
            goto L_0x0352
        L_0x034a:
            r0 = move-exception
            r7 = r10
        L_0x034c:
            if (r7 == 0) goto L_0x0351
            r7.close()     // Catch:{ all -> 0x0355 }
        L_0x0351:
            throw r0     // Catch:{ all -> 0x0355 }
        L_0x0352:
            monitor-exit(r25)
            r1 = 0
            return r1
        L_0x0355:
            r0 = move-exception
            monitor-exit(r25)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.p.a(java.lang.String):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        if (r0 == 0) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r0 != 0) goto L_0x001b;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from reward_report"
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x0021 }
            android.database.Cursor r0 = r3.rawQuery(r2, r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x0019
            boolean r2 = r0.moveToFirst()     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0019
            int r1 = r0.getInt(r1)     // Catch:{ Exception -> 0x0021 }
        L_0x0019:
            if (r0 == 0) goto L_0x0028
        L_0x001b:
            r0.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0028
        L_0x001f:
            r1 = move-exception
            goto L_0x002a
        L_0x0021:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0028
            goto L_0x001b
        L_0x0028:
            monitor-exit(r4)
            return r1
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ all -> 0x0030 }
        L_0x002f:
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.p.a():int");
    }

    public final synchronized long a(m mVar) {
        if (mVar != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", mVar.o());
                contentValues.put("networkType", Integer.valueOf(mVar.v()));
                contentValues.put("network_str", mVar.w());
                contentValues.put("isCompleteView", Integer.valueOf(mVar.x()));
                contentValues.put("watchedMillis", Integer.valueOf(mVar.p()));
                contentValues.put("videoLength", Integer.valueOf(mVar.q()));
                if (!TextUtils.isEmpty(mVar.r())) {
                    contentValues.put("offerUrl", mVar.r());
                }
                if (!TextUtils.isEmpty(mVar.s())) {
                    contentValues.put(IronSourceConstants.EVENTS_ERROR_REASON, URLEncoder.encode(mVar.s(), "utf-8"));
                }
                contentValues.put(IronSourceConstants.EVENTS_RESULT, Integer.valueOf(mVar.y()));
                contentValues.put(IronSourceConstants.EVENTS_DURATION, mVar.t());
                contentValues.put("videoSize", Long.valueOf(mVar.u()));
                contentValues.put("type", mVar.g());
                String f = mVar.f();
                if (!TextUtils.isEmpty(f)) {
                    contentValues.put(CampaignEx.ENDCARD_URL, f);
                }
                String e = mVar.e();
                if (!TextUtils.isEmpty(e)) {
                    contentValues.put("video_url", e);
                }
                String k = mVar.k();
                if (!TextUtils.isEmpty(k)) {
                    contentValues.put("rid", k);
                }
                String l = mVar.l();
                if (!TextUtils.isEmpty(l)) {
                    contentValues.put("rid_n", l);
                }
                String i = mVar.i();
                if (!TextUtils.isEmpty(i)) {
                    contentValues.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_TEMPLATE_URL, i);
                }
                String d = mVar.d();
                if (!TextUtils.isEmpty(d)) {
                    contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, d);
                }
                String h = mVar.h();
                if (!TextUtils.isEmpty(h)) {
                    contentValues.put("ad_type", URLEncoder.encode(h, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, mVar.m());
                contentValues.put("campaignId", mVar.n());
                if ("2000039".equals(mVar.o())) {
                    String f2 = m.f(mVar);
                    if (x.b(f2)) {
                        contentValues.put("h5_click_data", f2);
                    }
                }
                String a2 = mVar.a();
                if (!TextUtils.isEmpty(a2)) {
                    contentValues.put("resource_type", URLEncoder.encode(a2, "utf-8"));
                }
                String b2 = mVar.b();
                if (!TextUtils.isEmpty(b2)) {
                    contentValues.put("device_id", URLEncoder.encode(b2, "utf-8"));
                }
                String c = mVar.c();
                if (!TextUtils.isEmpty(c)) {
                    contentValues.put(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE, URLEncoder.encode(c, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(mVar.j()));
                return getWritableDatabase().insert("reward_report", (String) null, contentValues);
            } catch (Exception e2) {
                e2.printStackTrace();
                q.d(a, e2.getMessage());
            }
        }
        return -1;
    }
}
