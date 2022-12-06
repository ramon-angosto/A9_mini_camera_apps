package com.apm.insight.k;

import androidx.browser.trusted.sharing.ShareTarget;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.apm.insight.h;
import com.apm.insight.l.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class j {
    private final String a = ("AAA" + System.currentTimeMillis() + "AAA");
    private HttpURLConnection b;
    private String c;
    private boolean d;
    private f e;
    private m f;

    public j(String str, String str2, boolean z) {
        this.c = str2;
        this.d = z;
        this.b = (HttpURLConnection) new URL(str).openConnection();
        this.b.setUseCaches(false);
        this.b.setDoOutput(true);
        this.b.setDoInput(true);
        this.b.setRequestMethod(ShareTarget.METHOD_POST);
        HttpURLConnection httpURLConnection = this.b;
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + this.a);
        if (z) {
            this.b.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
            this.f = new m(this.b.getOutputStream());
            return;
        }
        this.e = new f(this.b.getOutputStream());
    }

    public String a() {
        ArrayList<String> arrayList = new ArrayList<>();
        byte[] bytes = ("\r\n--" + this.a + "--" + "\r\n").getBytes();
        if (this.d) {
            this.f.write(bytes);
            this.f.b();
            this.f.a();
        } else {
            this.e.write(bytes);
            this.e.flush();
            this.e.a();
        }
        int responseCode = this.b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.b.disconnect();
            StringBuilder sb = new StringBuilder();
            for (String append : arrayList) {
                sb.append(append);
            }
            return sb.toString();
        }
        throw new IOException("Server returned non-OK status: " + responseCode);
    }

    public void a(String str, File file, Map<String, String> map) {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.a);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"; filename=\"");
        sb.append(name);
        sb.append("\"");
        for (Map.Entry next : map.entrySet()) {
            sb.append("; ");
            sb.append((String) next.getKey());
            sb.append("=\"");
            sb.append((String) next.getValue());
            sb.append("\"");
        }
        sb.append("\r\n");
        sb.append("Content-Transfer-Encoding: binary");
        sb.append("\r\n");
        sb.append("\r\n");
        if (this.d) {
            this.f.write(sb.toString().getBytes());
        } else {
            this.e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.d) {
                this.f.write(bArr, 0, read);
            } else {
                this.e.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.d) {
            this.f.write("\r\n".getBytes());
            return;
        }
        this.e.write("\r\n".getBytes());
        this.e.flush();
    }

    public void a(String str, String str2) {
        a(str, str2, false);
    }

    public void a(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.a);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append("\r\n");
        sb.append("Content-Type: text/plain; charset=");
        sb.append(this.c);
        sb.append("\r\n");
        sb.append("\r\n");
        try {
            if (this.d) {
                this.f.write(sb.toString().getBytes());
            } else {
                this.e.write(sb.toString().getBytes());
            }
        } catch (IOException unused) {
        }
        byte[] bytes = str2.getBytes();
        if (z) {
            bytes = h.i().getEncryptImpl().a(bytes);
        }
        try {
            if (this.d) {
                this.f.write(bytes);
                this.f.write("\r\n".getBytes());
                return;
            }
            this.e.write(bytes);
            this.e.write("\r\n".getBytes());
        } catch (IOException unused2) {
        }
    }

    public void a(String str, File... fileArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.a);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"; filename=\"");
        sb.append(str);
        sb.append("\"");
        sb.append("\r\n");
        sb.append("Content-Transfer-Encoding: binary");
        sb.append("\r\n");
        sb.append("\r\n");
        if (this.d) {
            this.f.write(sb.toString().getBytes());
        } else {
            this.e.write(sb.toString().getBytes());
        }
        i.a(this.d ? this.f : this.e, fileArr);
        if (this.d) {
            this.f.write("\r\n".getBytes());
            return;
        }
        this.e.write("\r\n".getBytes());
        this.e.flush();
    }
}
