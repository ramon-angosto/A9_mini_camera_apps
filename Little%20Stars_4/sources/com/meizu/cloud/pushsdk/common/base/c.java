package com.meizu.cloud.pushsdk.common.base;

import android.text.TextUtils;
import android.util.Log;
import com.meizu.cloud.pushsdk.common.b.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class c implements c.a {
    private String a;
    private BufferedWriter b;
    private b c = new b("lo");

    public c(String str) {
        this.a = str;
    }

    private synchronized void a() throws IOException {
        if (!TextUtils.isEmpty(this.a)) {
            File file = new File(this.a);
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(file, "logs_v2.txt");
                if (file2.exists() || file2.createNewFile()) {
                    boolean z = false;
                    if (file2.length() >= 31457280) {
                        String parent = file2.getParent();
                        File file3 = new File(parent, "logs_v2_old.txt");
                        if (file3.exists()) {
                            if (file3.delete() && file2.renameTo(new File(parent, "logs_v2_old.txt"))) {
                                this.b = new BufferedWriter(new FileWriter(file2, z));
                            }
                        } else if (file2.renameTo(new File(parent, "logs_v2_old.txt"))) {
                            this.b = new BufferedWriter(new FileWriter(file2, z));
                        }
                    }
                    z = true;
                    this.b = new BufferedWriter(new FileWriter(file2, z));
                } else {
                    Log.e("EncryptLogger", "create new file " + "logs_v2.txt" + " failed!");
                }
            } else {
                Log.e("EncryptLogger", "create dir " + this.a + " failed!");
            }
        }
    }

    private synchronized void b() {
        if (this.b != null) {
            try {
                this.b.close();
            } catch (IOException unused) {
            }
        }
    }

    public void a(c.a.C0045a aVar, String str, String str2) {
        try {
            a();
            if (this.b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/");
                sb.append(aVar == c.a.C0045a.DEBUG ? "D" : aVar == c.a.C0045a.INFO ? "I" : aVar == c.a.C0045a.WARN ? "W" : "E");
                sb.append(": ");
                sb.append(str2);
                this.b.append(this.c.a(sb.toString().getBytes(Charset.forName("UTF-8"))));
                this.b.append("\r\n");
                this.b.flush();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            b();
            throw th;
        }
        b();
    }
}
