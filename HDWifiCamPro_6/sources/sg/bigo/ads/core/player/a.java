package sg.bigo.ads.core.player;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.d.b;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.core.player.a.d;

public final class a implements b.a {
    public static a a = new a();
    public final AtomicBoolean b = new AtomicBoolean(false);
    public List<n> c;
    public Map<String, C0146a> d;
    public b e;
    public sg.bigo.ads.common.d.a.a f;
    private long g = 0;
    private d h;

    /* renamed from: sg.bigo.ads.core.player.a$a  reason: collision with other inner class name */
    public interface C0146a {
        void a();

        void a(boolean z);
    }

    private a() {
    }

    public static a a() {
        return a;
    }

    /* access modifiers changed from: private */
    public void a(File file) {
        b.a("filterAdFiles dir = " + file.getAbsolutePath(), (sg.bigo.ads.common.d.a) null);
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            String c2 = i.c();
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles, new Comparator<File>() {
                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        int i = ((((File) obj).lastModified() - ((File) obj2).lastModified()) > 0 ? 1 : ((((File) obj).lastModified() - ((File) obj2).lastModified()) == 0 ? 0 : -1));
                        if (i > 0) {
                            return -1;
                        }
                        return i == 0 ? 0 : 1;
                    }
                });
                for (int i = 0; i < listFiles.length; i++) {
                    File file2 = listFiles[i];
                    sg.bigo.ads.common.d.a.a aVar = this.f;
                    long lastModified = file2.lastModified();
                    int a2 = aVar.a();
                    boolean z = true;
                    if (!(aVar.b + lastModified < currentTimeMillis) && i < a2) {
                        z = false;
                    }
                    sg.bigo.ads.common.k.a.a(0, 3, "DownloadConfig", "needDelete lastModifiedTs=" + lastModified + ", numTmp=" + a2);
                    if (z) {
                        b.a("delete expired file name = " + file2.getName(), (sg.bigo.ads.common.d.a) null);
                        File file3 = new File(c2, file2.getName());
                        if (file3.exists()) {
                            b.a("delete expired cover name = " + file2.getName(), (sg.bigo.ads.common.d.a) null);
                            file3.delete();
                        }
                        file2.delete();
                    }
                }
            }
        }
    }

    private static boolean a(n nVar, sg.bigo.ads.common.d.a aVar) {
        return TextUtils.equals(nVar.ac(), aVar.a());
    }

    private static d d() {
        b.a("start HttpProxyCacheServer ServerSocket", (sg.bigo.ads.common.d.a) null);
        return new d();
    }

    private void e() {
        if (System.currentTimeMillis() - this.g > 3600000) {
            c();
        }
    }

    public final void a(n nVar, C0146a aVar) {
        String Z = nVar.Z();
        String aa = nVar.aa();
        if (o.b(Z) || o.b(aa)) {
            aVar.a();
            return;
        }
        this.c.add(nVar);
        this.d.put(nVar.U(), aVar);
        sg.bigo.ads.common.d.a aVar2 = new sg.bigo.ads.common.d.a(Z, nVar.ab(), aa, nVar.ad());
        b.a("downloadMedia", aVar2);
        this.e.a(aVar2, false);
    }

    public final void a(sg.bigo.ads.common.d.a aVar) {
        Iterator<n> it = this.c.iterator();
        boolean z = !o.b(aVar.o);
        while (z && it.hasNext()) {
            n next = it.next();
            if (a(next, aVar)) {
                next.a(aVar.o);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0208  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(sg.bigo.ads.common.d.a r29, int r30, long r31) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            r14 = r30
            java.lang.String r0 = java.lang.String.valueOf(r30)
            java.lang.String r3 = "callback download completed source="
            java.lang.String r0 = r3.concat(r0)
            sg.bigo.ads.common.d.b.a((java.lang.String) r0, (sg.bigo.ads.common.d.a) r2)
            r13 = 1
            r0 = 2
            if (r14 != r0) goto L_0x0019
            r12 = r13
            goto L_0x001a
        L_0x0019:
            r12 = 0
        L_0x001a:
            sg.bigo.ads.api.core.m r11 = new sg.bigo.ads.api.core.m
            r11.<init>()
            java.lang.String r0 = r2.c
            boolean r0 = sg.bigo.ads.common.i.a(r0)
            r16 = 0
            if (r0 == 0) goto L_0x00f7
            int r0 = r2.e
            if (r0 != r13) goto L_0x002f
            r0 = r13
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            if (r0 == 0) goto L_0x00f7
            java.io.File r0 = new java.io.File
            java.lang.String r3 = sg.bigo.ads.common.i.c()
            java.lang.String r4 = r2.d
            r0.<init>(r3, r4)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x004b
            long r3 = r0.length()
            int r0 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a4
        L_0x004b:
            if (r2 == 0) goto L_0x00a4
            java.lang.String r0 = r29.a()
            if (r0 == 0) goto L_0x00a4
            java.lang.String r0 = r2.d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x005c
            goto L_0x00a4
        L_0x005c:
            java.lang.String r0 = r29.a()
            if (r12 == 0) goto L_0x0066
            java.lang.String r0 = sg.bigo.ads.common.utils.e.d(r0)
        L_0x0066:
            android.graphics.Bitmap r0 = android.media.ThumbnailUtils.createVideoThumbnail(r0, r13)
            if (r0 == 0) goto L_0x00a4
            java.lang.String r3 = sg.bigo.ads.common.i.c()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = r2.d
            sg.bigo.ads.common.utils.e.a((java.lang.String) r4, (java.lang.String) r5)
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r5 = r2.d     // Catch:{ Exception -> 0x00a0 }
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x00a0 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a0 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00a0 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00a0 }
            r5 = 100
            r0.compress(r4, r5, r3)     // Catch:{ Exception -> 0x00a0 }
            r3.flush()     // Catch:{ Exception -> 0x00a0 }
            r3.close()     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a4
        L_0x00a0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a4:
            android.media.MediaMetadataRetriever r3 = new android.media.MediaMetadataRetriever
            r3.<init>()
            if (r12 == 0) goto L_0x00b4
            java.lang.String r0 = r29.a()     // Catch:{ Exception -> 0x00eb }
            java.lang.String r0 = sg.bigo.ads.common.utils.e.d(r0)     // Catch:{ Exception -> 0x00eb }
            goto L_0x00b8
        L_0x00b4:
            java.lang.String r0 = r29.a()     // Catch:{ Exception -> 0x00eb }
        L_0x00b8:
            r3.setDataSource(r0)     // Catch:{ Exception -> 0x00eb }
            r0 = 18
            java.lang.String r0 = r3.extractMetadata(r0)     // Catch:{ Exception -> 0x00eb }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00eb }
            r11.a = r0     // Catch:{ Exception -> 0x00eb }
            r0 = 19
            java.lang.String r0 = r3.extractMetadata(r0)     // Catch:{ Exception -> 0x00eb }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00eb }
            r11.b = r0     // Catch:{ Exception -> 0x00eb }
            r0 = 9
            java.lang.String r0 = r3.extractMetadata(r0)     // Catch:{ Exception -> 0x00eb }
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00eb }
            r11.c = r4     // Catch:{ Exception -> 0x00eb }
            r0 = 12
            java.lang.String r0 = r3.extractMetadata(r0)     // Catch:{ Exception -> 0x00eb }
            r3.release()     // Catch:{ RuntimeException -> 0x00f9 }
            goto L_0x00f9
        L_0x00e9:
            r0 = move-exception
            goto L_0x00f3
        L_0x00eb:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00e9 }
            r3.release()     // Catch:{ RuntimeException -> 0x00f7 }
            goto L_0x00f7
        L_0x00f3:
            r3.release()     // Catch:{ RuntimeException -> 0x00f6 }
        L_0x00f6:
            throw r0
        L_0x00f7:
            java.lang.String r0 = ""
        L_0x00f9:
            sg.bigo.ads.core.player.a.d r3 = r28.b()
            sg.bigo.ads.core.player.a.h r3 = r3.d
            boolean r18 = r3.a()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List<sg.bigo.ads.api.core.n> r3 = r1.c
            java.util.Iterator r19 = r3.iterator()
        L_0x0113:
            boolean r3 = r19.hasNext()
            if (r3 == 0) goto L_0x01e7
            java.lang.Object r3 = r19.next()
            sg.bigo.ads.api.core.n r3 = (sg.bigo.ads.api.core.n) r3
            boolean r4 = a((sg.bigo.ads.api.core.n) r3, (sg.bigo.ads.common.d.a) r2)
            if (r4 != 0) goto L_0x013b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "not match addata="
            r4.<init>(r5)
            java.lang.String r3 = r3.V()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            sg.bigo.ads.common.d.b.a((java.lang.String) r3, (sg.bigo.ads.common.d.a) r2)
            goto L_0x0113
        L_0x013b:
            boolean r4 = r3.Y()
            if (r4 == 0) goto L_0x01ab
            if (r12 == 0) goto L_0x01ab
            long r13 = r2.h
            int r4 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r4 <= 0) goto L_0x0154
            long r13 = r2.f
            r21 = 100
            long r13 = r13 * r21
            long r5 = r2.h
            long r4 = r13 / r5
            goto L_0x0156
        L_0x0154:
            r4 = r16
        L_0x0156:
            if (r18 == 0) goto L_0x019a
            boolean r6 = r3.ai()
            if (r6 != 0) goto L_0x019a
            boolean r4 = r3.b(r4)
            if (r4 == 0) goto L_0x019a
            java.lang.String r4 = "Video partial download done, target callback."
            sg.bigo.ads.common.d.b.a((java.lang.String) r4, (sg.bigo.ads.common.d.a) r2)
            r10.add(r3)
            java.lang.String r4 = r2.b
            long r5 = r2.f
            r13 = 1024(0x400, double:5.06E-321)
            long r13 = r5 / r13
            int r9 = r2.j
            r21 = 2
            boolean r6 = r2.n
            java.lang.String r22 = "video"
            r5 = r30
            r23 = r6
            r6 = r31
            r15 = r8
            r24 = r9
            r8 = r13
            r14 = r10
            r10 = r24
            r13 = r11
            r11 = r21
            r25 = r12
            r12 = r22
            r26 = r13
            r20 = 1
            r13 = r23
            sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) r3, (java.lang.String) r4, (int) r5, (long) r6, (long) r8, (int) r10, (int) r11, (java.lang.String) r12, (boolean) r13)
            goto L_0x01a2
        L_0x019a:
            r15 = r8
            r14 = r10
            r26 = r11
            r25 = r12
            r20 = 1
        L_0x01a2:
            r10 = r14
            r8 = r15
            r13 = r20
            r12 = r25
            r11 = r26
            goto L_0x01e3
        L_0x01ab:
            r15 = r8
            r14 = r10
            r26 = r11
            r20 = r13
            r13 = r12
            if (r13 != 0) goto L_0x01d9
            r14.add(r3)
            r15.add(r3)
            java.lang.String r4 = r2.b
            long r5 = r2.f
            r7 = 1024(0x400, double:5.06E-321)
            long r8 = r5 / r7
            int r10 = r2.j
            r11 = 2
            boolean r12 = r2.n
            java.lang.String r21 = "video"
            r5 = r30
            r6 = r31
            r22 = r12
            r12 = r21
            r27 = r13
            r13 = r22
            sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) r3, (java.lang.String) r4, (int) r5, (long) r6, (long) r8, (int) r10, (int) r11, (java.lang.String) r12, (boolean) r13)
            goto L_0x01db
        L_0x01d9:
            r27 = r13
        L_0x01db:
            r10 = r14
            r8 = r15
            r13 = r20
            r11 = r26
            r12 = r27
        L_0x01e3:
            r14 = r30
            goto L_0x0113
        L_0x01e7:
            r15 = r8
            r14 = r10
            r26 = r11
            r27 = r12
            r20 = r13
            java.util.List<sg.bigo.ads.api.core.n> r3 = r1.c
            r3.removeAll(r15)
            boolean r3 = sg.bigo.ads.common.utils.o.b(r0)
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x01fe
            r2.o = r0
        L_0x01fe:
            java.util.Iterator r4 = r14.iterator()
        L_0x0202:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x025f
            java.lang.Object r5 = r4.next()
            sg.bigo.ads.api.core.n r5 = (sg.bigo.ads.api.core.n) r5
            boolean r6 = r5.ai()
            if (r6 != 0) goto L_0x0202
            if (r3 == 0) goto L_0x0219
            r5.a((java.lang.String) r0)
        L_0x0219:
            long r6 = r2.h
            r8 = r26
            r8.d = r6
            boolean r6 = r29.c()
            r8.e = r6
            r5.a((sg.bigo.ads.api.core.m) r8)
            java.util.Map<java.lang.String, sg.bigo.ads.core.player.a$a> r6 = r1.d
            java.lang.String r7 = r5.U()
            java.lang.Object r6 = r6.remove(r7)
            sg.bigo.ads.core.player.a$a r6 = (sg.bigo.ads.core.player.a.C0146a) r6
            if (r6 == 0) goto L_0x0250
            java.lang.String r7 = "listener is valid, execute AdProxy successful callback"
            sg.bigo.ads.common.d.b.a((java.lang.String) r7, (sg.bigo.ads.common.d.a) r2)
            sg.bigo.ads.api.core.n$d r7 = r5.T()
            r13 = r27
            if (r7 == 0) goto L_0x0246
            r7.a((boolean) r13)
        L_0x0246:
            if (r30 != 0) goto L_0x024b
            r7 = r20
            goto L_0x024c
        L_0x024b:
            r7 = 0
        L_0x024c:
            r6.a(r7)
            goto L_0x0257
        L_0x0250:
            r13 = r27
            java.lang.String r6 = "Not found target listener."
            sg.bigo.ads.common.d.b.a((java.lang.String) r6, (sg.bigo.ads.common.d.a) r2)
        L_0x0257:
            r5.aj()
            r26 = r8
            r27 = r13
            goto L_0x0202
        L_0x025f:
            r13 = r27
            if (r13 != 0) goto L_0x0266
            r28.e()
        L_0x0266:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.player.a.a(sg.bigo.ads.common.d.a, int, long):void");
    }

    public final void a(sg.bigo.ads.common.d.a aVar, String str, long j) {
        sg.bigo.ads.common.d.a aVar2 = aVar;
        b.a("callback download failed error= ".concat(String.valueOf(str)), aVar2);
        b.a("callback download failed error= ".concat(String.valueOf(str)), aVar2);
        Iterator<n> it = this.c.iterator();
        boolean z = !o.b(aVar2.o);
        while (it.hasNext()) {
            n next = it.next();
            if (a(next, aVar2)) {
                if (z) {
                    next.a(aVar2.o);
                }
                sg.bigo.ads.core.d.a.a(next, aVar2.b, str, j, aVar2.f / 1024, 2, "video", aVar2.n);
                C0146a remove = this.d.remove(next.U());
                if (remove != null) {
                    b.a("listener is valid, execute AdProxy failure callback", aVar2);
                    o.a(str, -1);
                    remove.a();
                    this.d.remove(next.U());
                } else {
                    String str2 = str;
                }
                it.remove();
            } else {
                String str3 = str;
            }
        }
        e();
    }

    public final d b() {
        d dVar = this.h;
        if (dVar != null) {
            return dVar;
        }
        d d2 = d();
        this.h = d2;
        return d2;
    }

    public final void c() {
        this.g = System.currentTimeMillis();
        b.a("start resource delete task", (sg.bigo.ads.common.d.a) null);
        c.a(1, new Runnable() {
            public final void run() {
                a.this.a(new File(i.b()));
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }
}
