package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.zip.GZIPInputStream;

class w {
    private LinkedList<Runnable> a = new LinkedList<>();
    private boolean b;

    class a implements j0 {

        /* renamed from: com.adcolony.sdk.w$a$a  reason: collision with other inner class name */
        class C0010a implements Runnable {
            final /* synthetic */ h0 a;

            C0010a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                boolean unused = w.this.g(this.a);
                w.this.a();
            }
        }

        a() {
        }

        public void a(h0 h0Var) {
            w.this.a((Runnable) new C0010a(h0Var));
        }
    }

    class b implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                boolean unused = w.this.a(this.a, new File(c0.h(this.a.a(), "filepath")));
                w.this.a();
            }
        }

        b() {
        }

        public void a(h0 h0Var) {
            w.this.a((Runnable) new a(h0Var));
        }
    }

    class c implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                boolean unused = w.this.d(this.a);
                w.this.a();
            }
        }

        c() {
        }

        public void a(h0 h0Var) {
            w.this.a((Runnable) new a(h0Var));
        }
    }

    class d implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                String unused = w.this.e(this.a);
                w.this.a();
            }
        }

        d() {
        }

        public void a(h0 h0Var) {
            w.this.a((Runnable) new a(h0Var));
        }
    }

    class e implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                boolean unused = w.this.f(this.a);
                w.this.a();
            }
        }

        e() {
        }

        public void a(h0 h0Var) {
            w.this.a((Runnable) new a(h0Var));
        }
    }

    class f implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                boolean unused = w.this.b(this.a);
                w.this.a();
            }
        }

        f() {
        }

        public void a(h0 h0Var) {
            w.this.a((Runnable) new a(h0Var));
        }
    }

    class g implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                boolean unused = w.this.c(this.a);
                w.this.a();
            }
        }

        g() {
        }

        public void a(h0 h0Var) {
            w.this.a((Runnable) new a(h0Var));
        }
    }

    class h implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                boolean unused = w.this.h(this.a);
                w.this.a();
            }
        }

        h() {
        }

        public void a(h0 h0Var) {
            w.this.a((Runnable) new a(h0Var));
        }
    }

    class i implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                boolean unused = w.this.a(this.a);
                w.this.a();
            }
        }

        i() {
        }

        public void a(h0 h0Var) {
            w.this.a((Runnable) new a(h0Var));
        }
    }

    w() {
    }

    /* access modifiers changed from: private */
    public boolean c(h0 h0Var) {
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "filepath");
        a.b().z().h();
        f1 b2 = c0.b();
        try {
            int d2 = c0.d(a2, "offset");
            int d3 = c0.d(a2, "size");
            boolean b3 = c0.b(a2, "gunzip");
            String h3 = c0.h(a2, "output_filepath");
            w0 w0Var = new w0(new FileInputStream(h2), d2, d3);
            InputStream gZIPInputStream = b3 ? new GZIPInputStream(w0Var, 1024) : w0Var;
            if (h3.equals("")) {
                StringBuilder sb = new StringBuilder(gZIPInputStream.available());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr, 0, 1024);
                    if (read < 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, "ISO-8859-1"));
                }
                c0.b(b2, "size", sb.length());
                c0.a(b2, DataSchemeDataSource.SCHEME_DATA, sb.toString());
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(h3);
                byte[] bArr2 = new byte[1024];
                int i2 = 0;
                while (true) {
                    int read2 = gZIPInputStream.read(bArr2, 0, 1024);
                    if (read2 < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr2, 0, read2);
                    i2 += read2;
                }
                fileOutputStream.close();
                c0.b(b2, "size", i2);
            }
            gZIPInputStream.close();
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            return true;
        } catch (IOException unused) {
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            return false;
        } catch (OutOfMemoryError unused2) {
            new e0.a().a("Out of memory error - disabling AdColony.").a(e0.h);
            a.b().b(true);
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean d(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "filepath");
        a.b().z().h();
        f1 b2 = c0.b();
        String[] list = new File(h2).list();
        if (list != null) {
            e1 a2 = c0.a();
            for (String str : list) {
                f1 b3 = c0.b();
                c0.a(b3, ImagePagerActivity.FILENAME, str);
                if (new File(h2 + str).isDirectory()) {
                    c0.b(b3, "is_folder", true);
                } else {
                    c0.b(b3, "is_folder", false);
                }
                c0.a(a2, b3);
            }
            c0.b(b2, "success", true);
            c0.a(b2, "entries", a2);
            h0Var.a(b2).c();
            return true;
        }
        c0.b(b2, "success", false);
        h0Var.a(b2).c();
        return false;
    }

    /* access modifiers changed from: private */
    public String e(h0 h0Var) {
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "filepath");
        String h3 = c0.h(a2, "encoding");
        boolean z = h3 != null && h3.equals("utf8");
        a.b().z().h();
        f1 b2 = c0.b();
        try {
            StringBuilder a3 = a(h2, z);
            c0.b(b2, "success", true);
            c0.a(b2, DataSchemeDataSource.SCHEME_DATA, a3.toString());
            h0Var.a(b2).c();
            return a3.toString();
        } catch (IOException unused) {
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            return "";
        }
    }

    /* access modifiers changed from: private */
    public boolean f(h0 h0Var) {
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "filepath");
        String h3 = c0.h(a2, "new_filepath");
        a.b().z().h();
        f1 b2 = c0.b();
        try {
            if (new File(h2).renameTo(new File(h3))) {
                c0.b(b2, "success", true);
                h0Var.a(b2).c();
                return true;
            }
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            return false;
        } catch (Exception unused) {
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean g(h0 h0Var) {
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "filepath");
        String h3 = c0.h(a2, DataSchemeDataSource.SCHEME_DATA);
        boolean equals = c0.h(a2, "encoding").equals("utf8");
        a.b().z().h();
        f1 b2 = c0.b();
        try {
            a(h2, h3, equals);
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            return true;
        } catch (IOException unused) {
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fb, code lost:
        new com.adcolony.sdk.e0.a().a("Out of memory error - disabling AdColony.").a(com.adcolony.sdk.e0.h);
        com.adcolony.sdk.a.b().b(true);
        com.adcolony.sdk.c0.b(r5, "success", false);
        r0.a(r5).c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x011f, code lost:
        r2 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:1:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(com.adcolony.sdk.h0 r21) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "success"
            com.adcolony.sdk.f1 r2 = r21.a()
            java.lang.String r3 = "filepath"
            java.lang.String r3 = com.adcolony.sdk.c0.h(r2, r3)
            java.lang.String r4 = "bundle_path"
            java.lang.String r4 = com.adcolony.sdk.c0.h(r2, r4)
            java.lang.String r5 = "bundle_filenames"
            com.adcolony.sdk.e1 r2 = com.adcolony.sdk.c0.a((com.adcolony.sdk.f1) r2, (java.lang.String) r5)
            com.adcolony.sdk.k r5 = com.adcolony.sdk.a.b()
            com.adcolony.sdk.v0 r5 = r5.z()
            r5.h()
            com.adcolony.sdk.f1 r5 = com.adcolony.sdk.c0.b()
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r8.<init>(r4)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            java.lang.String r10 = "r"
            r9.<init>(r8, r10)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r10 = 32
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r9.readInt()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            int r11 = r9.readInt()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            com.adcolony.sdk.e1 r12 = new com.adcolony.sdk.e1     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r12.<init>()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r14 = new byte[r13]     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r15 = 0
        L_0x004a:
            if (r15 >= r11) goto L_0x00e1
            int r16 = r15 * 44
            int r6 = r16 + 8
            r17 = r8
            long r7 = (long) r6     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r9.seek(r7)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r9.read(r10)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r9.readInt()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            int r6 = r9.readInt()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            int r7 = r9.readInt()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r12.f(r7)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00b7 }
            r8.<init>()     // Catch:{ JSONException -> 0x00b7 }
            r8.append(r3)     // Catch:{ JSONException -> 0x00b7 }
            java.lang.Object r13 = r2.a((int) r15)     // Catch:{ JSONException -> 0x00b7 }
            r8.append(r13)     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00b7 }
            r18 = r2
            r13 = r3
            long r2 = (long) r6
            r9.seek(r2)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r2.<init>(r8)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            int r3 = r7 / 1024
            int r7 = r7 % 1024
            r6 = 0
        L_0x008b:
            if (r6 >= r3) goto L_0x009d
            r16 = r3
            r3 = 1024(0x400, float:1.435E-42)
            r8 = 0
            r9.read(r14, r8, r3)     // Catch:{ IOException -> 0x00b5, OutOfMemoryError -> 0x00fb }
            r2.write(r14, r8, r3)     // Catch:{ IOException -> 0x00b5, OutOfMemoryError -> 0x00fb }
            int r6 = r6 + 1
            r3 = r16
            goto L_0x008b
        L_0x009d:
            r3 = 1024(0x400, float:1.435E-42)
            r8 = 0
            r9.read(r14, r8, r7)     // Catch:{ IOException -> 0x00b5, OutOfMemoryError -> 0x00fb }
            r2.write(r14, r8, r7)     // Catch:{ IOException -> 0x00b5, OutOfMemoryError -> 0x00fb }
            r2.close()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            int r15 = r15 + 1
            r8 = r17
            r2 = r18
            r19 = r13
            r13 = r3
            r3 = r19
            goto L_0x004a
        L_0x00b5:
            r2 = r8
            goto L_0x0120
        L_0x00b7:
            com.adcolony.sdk.e0$a r2 = new com.adcolony.sdk.e0$a     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r2.<init>()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            java.lang.String r3 = "Couldn't extract file name at index "
            com.adcolony.sdk.e0$a r2 = r2.a((java.lang.String) r3)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            com.adcolony.sdk.e0$a r2 = r2.a((int) r15)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            java.lang.String r3 = " unpacking ad unit bundle at "
            com.adcolony.sdk.e0$a r2 = r2.a((java.lang.String) r3)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            com.adcolony.sdk.e0$a r2 = r2.a((java.lang.String) r4)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            com.adcolony.sdk.e0 r3 = com.adcolony.sdk.e0.h     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r2.a((com.adcolony.sdk.e0) r3)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r2 = 0
            com.adcolony.sdk.c0.b((com.adcolony.sdk.f1) r5, (java.lang.String) r1, (boolean) r2)     // Catch:{ IOException -> 0x0120, OutOfMemoryError -> 0x00fb }
            com.adcolony.sdk.h0 r3 = r0.a(r5)     // Catch:{ IOException -> 0x0120, OutOfMemoryError -> 0x00fb }
            r3.c()     // Catch:{ IOException -> 0x0120, OutOfMemoryError -> 0x00fb }
            return r2
        L_0x00e1:
            r17 = r8
            r9.close()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r17.delete()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r2 = 1
            com.adcolony.sdk.c0.b((com.adcolony.sdk.f1) r5, (java.lang.String) r1, (boolean) r2)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            java.lang.String r2 = "file_sizes"
            com.adcolony.sdk.c0.a((com.adcolony.sdk.f1) r5, (java.lang.String) r2, (com.adcolony.sdk.e1) r12)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            com.adcolony.sdk.h0 r2 = r0.a(r5)     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r2.c()     // Catch:{ IOException -> 0x011f, OutOfMemoryError -> 0x00fb }
            r0 = 1
            return r0
        L_0x00fb:
            com.adcolony.sdk.e0$a r2 = new com.adcolony.sdk.e0$a
            r2.<init>()
            java.lang.String r3 = "Out of memory error - disabling AdColony."
            com.adcolony.sdk.e0$a r2 = r2.a((java.lang.String) r3)
            com.adcolony.sdk.e0 r3 = com.adcolony.sdk.e0.h
            r2.a((com.adcolony.sdk.e0) r3)
            com.adcolony.sdk.k r2 = com.adcolony.sdk.a.b()
            r3 = 1
            r2.b((boolean) r3)
            r2 = 0
            com.adcolony.sdk.c0.b((com.adcolony.sdk.f1) r5, (java.lang.String) r1, (boolean) r2)
            com.adcolony.sdk.h0 r0 = r0.a(r5)
            r0.c()
            return r2
        L_0x011f:
            r2 = 0
        L_0x0120:
            com.adcolony.sdk.e0$a r3 = new com.adcolony.sdk.e0$a
            r3.<init>()
            java.lang.String r6 = "Failed to find or open ad unit bundle at path: "
            com.adcolony.sdk.e0$a r3 = r3.a((java.lang.String) r6)
            com.adcolony.sdk.e0$a r3 = r3.a((java.lang.String) r4)
            com.adcolony.sdk.e0 r4 = com.adcolony.sdk.e0.i
            r3.a((com.adcolony.sdk.e0) r4)
            com.adcolony.sdk.c0.b((com.adcolony.sdk.f1) r5, (java.lang.String) r1, (boolean) r2)
            com.adcolony.sdk.h0 r0 = r0.a(r5)
            r0.c()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.w.h(com.adcolony.sdk.h0):boolean");
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a.a("FileSystem.save", (j0) new a());
        a.a("FileSystem.delete", (j0) new b());
        a.a("FileSystem.listing", (j0) new c());
        a.a("FileSystem.load", (j0) new d());
        a.a("FileSystem.rename", (j0) new e());
        a.a("FileSystem.exists", (j0) new f());
        a.a("FileSystem.extract", (j0) new g());
        a.a("FileSystem.unpack_bundle", (j0) new h());
        a.a("FileSystem.create_directory", (j0) new i());
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z) throws IOException {
        BufferedWriter bufferedWriter;
        if (z) {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str), h.a));
        } else {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str)));
        }
        bufferedWriter.write(str2);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /* access modifiers changed from: private */
    public boolean a(h0 h0Var, File file) {
        a.b().z().h();
        f1 b2 = c0.b();
        if (a(file)) {
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            return true;
        }
        c0.b(b2, "success", false);
        h0Var.a(b2).c();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(File file) {
        try {
            if (!file.isDirectory()) {
                return file.delete();
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            String[] list = file.list();
            if (list.length > 0) {
                return a(new File(file, list[0]));
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public StringBuilder a(String str, boolean z) throws IOException {
        BufferedReader bufferedReader;
        File file = new File(str);
        StringBuilder sb = new StringBuilder((int) file.length());
        if (z) {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), h.a));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append("\n");
            } else {
                bufferedReader.close();
                return sb;
            }
        }
    }

    private boolean a(String str) {
        return new File(str).exists();
    }

    /* access modifiers changed from: private */
    public boolean a(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "filepath");
        a.b().z().h();
        f1 b2 = c0.b();
        try {
            if (new File(h2).mkdir()) {
                c0.b(b2, "success", true);
                h0Var.a(b2).c();
                return true;
            }
            c0.b(b2, "success", false);
            return false;
        } catch (Exception unused) {
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a(Runnable runnable) {
        if (!this.a.isEmpty() || this.b) {
            this.a.push(runnable);
            return;
        }
        this.b = true;
        runnable.run();
    }

    /* access modifiers changed from: private */
    public void a() {
        this.b = false;
        if (!this.a.isEmpty()) {
            this.b = true;
            this.a.removeLast().run();
        }
    }

    /* access modifiers changed from: private */
    public boolean b(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "filepath");
        a.b().z().h();
        f1 b2 = c0.b();
        try {
            boolean a2 = a(h2);
            c0.b(b2, IronSourceConstants.EVENTS_RESULT, a2);
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            return a2;
        } catch (Exception e2) {
            c0.b(b2, IronSourceConstants.EVENTS_RESULT, false);
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            e2.printStackTrace();
            return false;
        }
    }
}
