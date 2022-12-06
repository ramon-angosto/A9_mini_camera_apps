package com.apm.insight.runtime;

import android.text.TextUtils;
import com.apm.insight.b;
import com.apm.insight.h;
import com.apm.insight.l.f;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;

public class k {
    private static j a;

    public static JSONArray a(String str) {
        BufferedReader bufferedReader;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            bufferedReader = new BufferedReader(new FileReader(str));
            try {
                File file = new File(str);
                if (file.length() > 512000) {
                    bufferedReader.skip(file.length() - 512000);
                }
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        jSONArray.put(readLine);
                    } else {
                        com.apm.insight.l.k.a((Closeable) bufferedReader);
                        return jSONArray;
                    }
                }
            } catch (IOException e) {
                e = e;
                try {
                    e.printStackTrace();
                    com.apm.insight.l.k.a((Closeable) bufferedReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    com.apm.insight.l.k.a((Closeable) bufferedReader);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
            e.printStackTrace();
            com.apm.insight.l.k.a((Closeable) bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            com.apm.insight.l.k.a((Closeable) bufferedReader);
            throw th;
        }
    }

    public static void a(j jVar) {
        a = jVar;
    }

    public static JSONArray b(String str) {
        if (a != null && h.f().equals(str)) {
            try {
                return a(a.a());
            } catch (Throwable th) {
                b.a().a("NPTH_CATCH", th);
            }
        }
        try {
            return a(f.a(str, h.i().getLogcatDumpCount(), h.i().getLogcatLevel()).getAbsolutePath());
        } catch (Throwable th2) {
            b.a().a("NPTH_CATCH", th2);
            return null;
        }
    }
}
