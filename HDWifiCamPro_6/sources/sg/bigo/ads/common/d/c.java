package sg.bigo.ads.common.d;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.l.b;
import sg.bigo.ads.common.l.c.d;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.l.h;

public abstract class c {
    public String a = "";
    public boolean b = false;
    protected int c = 0;
    protected boolean d = false;

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    /* access modifiers changed from: protected */
    public abstract boolean a(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract String b();

    /* access modifiers changed from: protected */
    public final void b(String str, String str2) {
        File file = new File(b());
        if (file.exists() || file.mkdir()) {
            try {
                FileWriter fileWriter = new FileWriter(new File(file, c()));
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
                a.a(0, 4, a(), "Write JS file successfully");
                a(str2);
            } catch (Exception e) {
                e.printStackTrace();
                String a2 = a();
                a.a(0, a2, "write JS file error: " + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean b(String str);

    /* access modifiers changed from: protected */
    public abstract String c();

    public final void c(final String str) {
        if (!TextUtils.isEmpty(str)) {
            g.a(new sg.bigo.ads.common.l.b.a(sg.bigo.ads.common.o.a.a(), str), new b<sg.bigo.ads.common.l.b.a, d>() {
                public final /* synthetic */ sg.bigo.ads.common.l.c.c a(sg.bigo.ads.common.l.c.a aVar) {
                    return new d(aVar);
                }

                public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, sg.bigo.ads.common.l.c.c cVar2) {
                    String a2 = ((d) cVar2).a();
                    if (TextUtils.isEmpty(a2) || !c.this.b(a2)) {
                        c.this.h();
                        return;
                    }
                    c cVar3 = c.this;
                    cVar3.a = a2;
                    cVar3.b = true;
                    a.a(0, 4, cVar3.a(), "Fetch js from network successfully");
                    sg.bigo.ads.common.f.c.a(0, new Runnable() {
                        public final void run() {
                            c.this.b(c.this.a, str);
                        }
                    });
                }

                public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, h hVar) {
                    String a2 = c.this.a();
                    a.a(0, 5, a2, "fetch js from network fail: " + hVar.getMessage());
                    c.this.h();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public abstract String d();

    /* access modifiers changed from: protected */
    public abstract String e();

    /* access modifiers changed from: protected */
    public abstract String f();

    public final void g() {
        if (a(e(), f())) {
            String a2 = a();
            a.a(0, 3, a2, "start fetch newest js content: " + e());
            c(e());
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        if (this.b) {
            return;
        }
        if (this.c >= 2) {
            a.a(0, 5, a(), "the retry times has reached the limit");
            if (!this.d) {
                this.d = true;
                if (!TextUtils.isEmpty(e())) {
                    a.a(0, 3, a(), "start fetch newest js content: " + e());
                    c(e());
                    return;
                }
                return;
            }
            return;
        }
        a.a(0, 3, a(), "try to re-fetch JS content...");
        this.c++;
        c(d());
    }

    public final String i() {
        File file = new File(b() + File.separator + c());
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    fileInputStream.close();
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            String a2 = a();
            a.a(0, a2, "get JS from file error: " + e.getMessage());
            return null;
        }
    }

    public final boolean j() {
        return new File(b() + File.separator + c()).exists();
    }
}
