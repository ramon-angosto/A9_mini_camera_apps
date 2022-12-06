package sg.bigo.ads.common;

import android.content.Context;
import sg.bigo.ads.common.k.a;

public abstract class c implements d {
    private final Runnable a = new Runnable() {
        public final void run() {
            c.this.n();
        }
    };
    public final Context b;
    public boolean c;

    public c(Context context) {
        this.b = context;
        this.c = false;
    }

    private void p() {
        this.c = true;
        a.a(0, 3, b(), "onDataSaved, ".concat(String.valueOf(this)));
    }

    /* access modifiers changed from: protected */
    public abstract String a_();

    /* access modifiers changed from: protected */
    public abstract String b();

    /* access modifiers changed from: protected */
    public void l() {
        this.c = true;
        a.a(0, 3, b(), "onDataLoaded, ".concat(String.valueOf(this)));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:18|19|20|21|22|23|24|25|26|27|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:38|39|40|41) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:46|47|48|49) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x006a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0097 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00ab */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0093 A[SYNTHETIC, Splitter:B:38:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a7 A[SYNTHETIC, Splitter:B:46:0x00a7] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x0097=Splitter:B:40:0x0097, B:24:0x006a=Splitter:B:24:0x006a, B:48:0x00ab=Splitter:B:48:0x00ab} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m() {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            r1 = 5
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0084 }
            java.lang.String r4 = sg.bigo.ads.common.i.a()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r5 = r9.a_()     // Catch:{ Exception -> 0x0084 }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0084 }
            byte[] r4 = sg.bigo.ads.common.utils.f.b(r3)     // Catch:{ Exception -> 0x0084 }
            if (r4 != 0) goto L_0x0026
            java.lang.String r3 = r9.b()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r4 = "data file not exist"
            r5 = 4
            sg.bigo.ads.common.k.a.a(r2, r5, r3, r4)     // Catch:{ Exception -> 0x0084 }
            r9.l()     // Catch:{ all -> 0x00b8 }
            monitor-exit(r9)
            return
        L_0x0026:
            byte[] r5 = sg.bigo.ads.common.utils.m.b(r4)     // Catch:{ Exception -> 0x0084 }
            if (r5 != 0) goto L_0x004a
            java.lang.String r5 = r9.b()     // Catch:{ Exception -> 0x0084 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0084 }
            java.lang.String r7 = "data decrypt failed length="
            r6.<init>(r7)     // Catch:{ Exception -> 0x0084 }
            int r4 = r4.length     // Catch:{ Exception -> 0x0084 }
            r6.append(r4)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0084 }
            sg.bigo.ads.common.k.a.a(r2, r5, r4)     // Catch:{ Exception -> 0x0084 }
            r3.delete()     // Catch:{ Exception -> 0x0084 }
            r9.l()     // Catch:{ all -> 0x00b8 }
            monitor-exit(r9)
            return
        L_0x004a:
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0084 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0084 }
            int r0 = r3.available()     // Catch:{ Exception -> 0x007d, all -> 0x0078 }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x007d, all -> 0x0078 }
            r3.read(r0)     // Catch:{ Exception -> 0x007d, all -> 0x0078 }
            android.os.Parcel r4 = android.os.Parcel.obtain()     // Catch:{ Exception -> 0x007d, all -> 0x0078 }
            int r5 = r0.length     // Catch:{ Exception -> 0x007d, all -> 0x0078 }
            r4.unmarshall(r0, r2, r5)     // Catch:{ Exception -> 0x007d, all -> 0x0078 }
            r4.setDataPosition(r2)     // Catch:{ Exception -> 0x007d, all -> 0x0078 }
            r9.b(r4)     // Catch:{ Exception -> 0x007d, all -> 0x0078 }
            r3.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x0073
        L_0x006a:
            java.lang.String r0 = r9.b()     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = "close data input stream failed"
            sg.bigo.ads.common.k.a.a(r2, r1, r0, r3)     // Catch:{ all -> 0x00b8 }
        L_0x0073:
            r9.l()     // Catch:{ all -> 0x00b8 }
            monitor-exit(r9)
            return
        L_0x0078:
            r0 = move-exception
            r8 = r3
            r3 = r0
            r0 = r8
            goto L_0x00a5
        L_0x007d:
            r0 = move-exception
            r8 = r3
            r3 = r0
            r0 = r8
            goto L_0x0085
        L_0x0082:
            r3 = move-exception
            goto L_0x00a5
        L_0x0084:
            r3 = move-exception
        L_0x0085:
            r3.printStackTrace()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = r9.b()     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "DataFile load failed"
            sg.bigo.ads.common.k.a.a(r2, r1, r3, r4)     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x00a0
            r0.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x00a0
        L_0x0097:
            java.lang.String r0 = r9.b()     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = "close data input stream failed"
            sg.bigo.ads.common.k.a.a(r2, r1, r0, r3)     // Catch:{ all -> 0x00b8 }
        L_0x00a0:
            r9.l()     // Catch:{ all -> 0x00b8 }
            monitor-exit(r9)
            return
        L_0x00a5:
            if (r0 == 0) goto L_0x00b4
            r0.close()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00b4
        L_0x00ab:
            java.lang.String r0 = r9.b()     // Catch:{ all -> 0x00b8 }
            java.lang.String r4 = "close data input stream failed"
            sg.bigo.ads.common.k.a.a(r2, r1, r0, r4)     // Catch:{ all -> 0x00b8 }
        L_0x00b4:
            r9.l()     // Catch:{ all -> 0x00b8 }
            throw r3     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.c.m():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:17|18|(3:20|(2:22|(1:24))(2:26|(1:28))|25)|(6:29|30|31|32|(1:36)|(2:37|38))|59|60|61|62|63|64|65|66|67) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:83|84|85|86) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:92|93|94|95) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:9|10|11|12|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0036 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x013b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x016f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x0184 */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011f A[SYNTHETIC, Splitter:B:56:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014b A[SYNTHETIC, Splitter:B:69:0x014b] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0180 A[SYNTHETIC, Splitter:B:92:0x0180] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:94:0x0184=Splitter:B:94:0x0184, B:12:0x0036=Splitter:B:12:0x0036, B:63:0x013b=Splitter:B:63:0x013b, B:85:0x016f=Splitter:B:85:0x016f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void n() {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.Runnable r0 = r10.a     // Catch:{ all -> 0x0191 }
            sg.bigo.ads.common.f.c.a((java.lang.Runnable) r0)     // Catch:{ all -> 0x0191 }
            r0 = 0
            r1 = 5
            r2 = 0
            android.os.Parcel r3 = android.os.Parcel.obtain()     // Catch:{ Exception -> 0x015a, all -> 0x0156 }
            r10.a(r3)     // Catch:{ Exception -> 0x015a, all -> 0x0156 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x015a, all -> 0x0156 }
            r4.<init>()     // Catch:{ Exception -> 0x015a, all -> 0x0156 }
            byte[] r3 = r3.marshall()     // Catch:{ Exception -> 0x0154 }
            r4.write(r3)     // Catch:{ Exception -> 0x0154 }
            r4.flush()     // Catch:{ Exception -> 0x0154 }
            byte[] r3 = r4.toByteArray()     // Catch:{ Exception -> 0x0154 }
            byte[] r3 = sg.bigo.ads.common.utils.m.a(r3)     // Catch:{ Exception -> 0x0154 }
            if (r3 != 0) goto L_0x0044
            java.lang.String r0 = r10.b()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r3 = "## data encrypt failed."
            sg.bigo.ads.common.k.a.a(r2, r0, r3)     // Catch:{ Exception -> 0x0154 }
            r4.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003f
        L_0x0036:
            java.lang.String r0 = r10.b()     // Catch:{ all -> 0x0191 }
            java.lang.String r3 = "close output stream failed"
            sg.bigo.ads.common.k.a.a(r2, r1, r0, r3)     // Catch:{ all -> 0x0191 }
        L_0x003f:
            r10.p()     // Catch:{ all -> 0x0191 }
            monitor-exit(r10)
            return
        L_0x0044:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0154 }
            java.lang.String r6 = sg.bigo.ads.common.i.a()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r7 = r10.a_()     // Catch:{ Exception -> 0x0154 }
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x0154 }
            java.io.File r6 = sg.bigo.ads.common.utils.f.a((java.io.File) r5)     // Catch:{ Exception -> 0x0154 }
            boolean r7 = r5.exists()     // Catch:{ Exception -> 0x0154 }
            if (r7 == 0) goto L_0x009a
            boolean r7 = r6.exists()     // Catch:{ Exception -> 0x0154 }
            if (r7 != 0) goto L_0x007f
            boolean r7 = r5.renameTo(r6)     // Catch:{ Exception -> 0x0154 }
            if (r7 != 0) goto L_0x009a
            java.lang.String r7 = "IOUtils"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0154 }
            java.lang.String r9 = "rename locked file failed: "
            r8.<init>(r9)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r9 = r5.getName()     // Catch:{ Exception -> 0x0154 }
            r8.append(r9)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0154 }
        L_0x007b:
            sg.bigo.ads.common.k.a.a(r2, r7, r8)     // Catch:{ Exception -> 0x0154 }
            goto L_0x009a
        L_0x007f:
            boolean r7 = r5.delete()     // Catch:{ Exception -> 0x0154 }
            if (r7 != 0) goto L_0x009a
            java.lang.String r7 = "IOUtils"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0154 }
            java.lang.String r9 = "delete locked file failed: "
            r8.<init>(r9)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r9 = r5.getName()     // Catch:{ Exception -> 0x0154 }
            r8.append(r9)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0154 }
            goto L_0x007b
        L_0x009a:
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00de }
            r7.<init>(r5)     // Catch:{ Exception -> 0x00de }
            r7.write(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            java.io.FileDescriptor r0 = r7.getFD()     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            r0.sync()     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            boolean r0 = r6.exists()     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            if (r0 == 0) goto L_0x00cc
            boolean r0 = r6.delete()     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            if (r0 != 0) goto L_0x00cc
            java.lang.String r0 = "IOUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            java.lang.String r8 = "delete backup file failed: "
            r3.<init>(r8)     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            r3.append(r6)     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
            sg.bigo.ads.common.k.a.a(r2, r0, r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d5 }
        L_0x00cc:
            r7.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x0125
        L_0x00d0:
            r0 = move-exception
        L_0x00d1:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0154 }
            goto L_0x0125
        L_0x00d5:
            r0 = move-exception
            r3 = r0
            r0 = r7
            goto L_0x0149
        L_0x00da:
            r0 = r7
            goto L_0x00de
        L_0x00dc:
            r3 = move-exception
            goto L_0x0149
        L_0x00de:
            java.lang.String r3 = "IOUtils"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = "write file "
            r6.<init>(r7)     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = r5.getPath()     // Catch:{ all -> 0x00dc }
            r6.append(r7)     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = " failed"
            r6.append(r7)     // Catch:{ all -> 0x00dc }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00dc }
            sg.bigo.ads.common.k.a.a(r2, r3, r6)     // Catch:{ all -> 0x00dc }
            boolean r3 = r5.exists()     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x011d
            boolean r3 = r5.delete()     // Catch:{ all -> 0x00dc }
            if (r3 != 0) goto L_0x011d
            java.lang.String r3 = "IOUtils"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = "delete locked file with exception failed: "
            r6.<init>(r7)     // Catch:{ all -> 0x00dc }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x00dc }
            r6.append(r5)     // Catch:{ all -> 0x00dc }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x00dc }
            sg.bigo.ads.common.k.a.a(r2, r3, r5)     // Catch:{ all -> 0x00dc }
        L_0x011d:
            if (r0 == 0) goto L_0x0125
            r0.close()     // Catch:{ IOException -> 0x0123 }
            goto L_0x0125
        L_0x0123:
            r0 = move-exception
            goto L_0x00d1
        L_0x0125:
            java.lang.String r0 = r10.b()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r3 = "data saved:"
            java.lang.String r5 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r3 = r3.concat(r5)     // Catch:{ Exception -> 0x0154 }
            r5 = 4
            sg.bigo.ads.common.k.a.a(r2, r5, r0, r3)     // Catch:{ Exception -> 0x0154 }
            r4.close()     // Catch:{ IOException -> 0x013b }
            goto L_0x0144
        L_0x013b:
            java.lang.String r0 = r10.b()     // Catch:{ all -> 0x0191 }
            java.lang.String r3 = "close output stream failed"
            sg.bigo.ads.common.k.a.a(r2, r1, r0, r3)     // Catch:{ all -> 0x0191 }
        L_0x0144:
            r10.p()     // Catch:{ all -> 0x0191 }
            monitor-exit(r10)
            return
        L_0x0149:
            if (r0 == 0) goto L_0x0153
            r0.close()     // Catch:{ IOException -> 0x014f }
            goto L_0x0153
        L_0x014f:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0154 }
        L_0x0153:
            throw r3     // Catch:{ Exception -> 0x0154 }
        L_0x0154:
            r0 = move-exception
            goto L_0x015d
        L_0x0156:
            r3 = move-exception
            r4 = r0
            r0 = r3
            goto L_0x017e
        L_0x015a:
            r3 = move-exception
            r4 = r0
            r0 = r3
        L_0x015d:
            r0.printStackTrace()     // Catch:{ all -> 0x017d }
            java.lang.String r0 = r10.b()     // Catch:{ all -> 0x017d }
            java.lang.String r3 = "data save failed"
            sg.bigo.ads.common.k.a.a(r2, r1, r0, r3)     // Catch:{ all -> 0x017d }
            if (r4 == 0) goto L_0x0178
            r4.close()     // Catch:{ IOException -> 0x016f }
            goto L_0x0178
        L_0x016f:
            java.lang.String r0 = r10.b()     // Catch:{ all -> 0x0191 }
            java.lang.String r3 = "close output stream failed"
            sg.bigo.ads.common.k.a.a(r2, r1, r0, r3)     // Catch:{ all -> 0x0191 }
        L_0x0178:
            r10.p()     // Catch:{ all -> 0x0191 }
            monitor-exit(r10)
            return
        L_0x017d:
            r0 = move-exception
        L_0x017e:
            if (r4 == 0) goto L_0x018d
            r4.close()     // Catch:{ IOException -> 0x0184 }
            goto L_0x018d
        L_0x0184:
            java.lang.String r3 = r10.b()     // Catch:{ all -> 0x0191 }
            java.lang.String r4 = "close output stream failed"
            sg.bigo.ads.common.k.a.a(r2, r1, r3, r4)     // Catch:{ all -> 0x0191 }
        L_0x018d:
            r10.p()     // Catch:{ all -> 0x0191 }
            throw r0     // Catch:{ all -> 0x0191 }
        L_0x0191:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.c.n():void");
    }

    public final void o() {
        sg.bigo.ads.common.f.c.a(this.a);
        sg.bigo.ads.common.f.c.a(1, this.a);
    }
}
