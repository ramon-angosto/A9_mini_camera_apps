package com.baidu.mapapi;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class s {
    static s b = null;
    static boolean c = false;
    ArrayList<File> a = new ArrayList<>();
    /* access modifiers changed from: private */
    public boolean d = false;
    private String e;
    /* access modifiers changed from: private */
    public Handler f = new t(this);

    class a extends Thread {
        File a;

        public a(File file) {
            this.a = file;
            Log.d("kal", "upload file:" + this.a.getAbsolutePath());
        }

        public void a() {
            if (!this.a.exists()) {
                s.this.a.remove(this.a);
            }
            s.a().c();
        }

        public void run() {
            try {
                if (s.c) {
                    Log.d("kal", "UploadWorker:begin uploading.");
                }
                HashMap hashMap = new HashMap();
                hashMap.put("ver", "2");
                hashMap.put("pd", "mapsdk");
                hashMap.put("im", Mj.k);
                hashMap.put("os", "android");
                String uuid = UUID.randomUUID().toString();
                HttpURLConnection a2 = d.a("http://ulog.imap.baidu.com/up");
                if (s.c) {
                    Log.d("kal", "UploadWorker:begin get connection ok.");
                }
                a2.setReadTimeout(5000);
                a2.setDoInput(true);
                a2.setDoOutput(true);
                a2.setUseCaches(false);
                a2.setRequestMethod("POST");
                a2.setRequestProperty("connection", "keep-alive");
                a2.setRequestProperty("Charsert", "UTF-8");
                a2.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data" + ";boundary=" + uuid);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb.append("--");
                    sb.append(uuid);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data; name=\"" + ((String) entry.getKey()) + "\"" + "\r\n");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Content-Type: text/plain; charset=");
                    sb2.append("UTF-8");
                    sb2.append("\r\n");
                    sb.append(sb2.toString());
                    sb.append("Content-Transfer-Encoding: 8bit" + "\r\n");
                    sb.append("\r\n");
                    sb.append((String) entry.getValue());
                    sb.append("\r\n");
                }
                DataOutputStream dataOutputStream = new DataOutputStream(a2.getOutputStream());
                dataOutputStream.write(sb.toString().getBytes());
                if (s.c) {
                    Log.d("kal", "UploadWorker:write header is ok.");
                }
                if (this.a != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("--");
                    sb3.append(uuid);
                    sb3.append("\r\n");
                    sb3.append("Content-Disposition: form-data; name=\"datafile\"; filename=\"" + this.a.getName() + "\"" + "\r\n");
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Content-Type: application/octet-stream; charset=");
                    sb4.append("UTF-8");
                    sb4.append("\r\n");
                    sb3.append(sb4.toString());
                    sb3.append("\r\n");
                    dataOutputStream.write(sb3.toString().getBytes());
                    FileInputStream fileInputStream = new FileInputStream(this.a);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                    dataOutputStream.write("\r\n".getBytes());
                    if (s.c) {
                        Log.d("kal", "UploadWorker: write data is ok.");
                    }
                }
                dataOutputStream.write(("--" + uuid + "--" + "\r\n").getBytes());
                dataOutputStream.flush();
                int responseCode = a2.getResponseCode();
                dataOutputStream.close();
                a2.disconnect();
                if (responseCode == 200) {
                    synchronized (s.this.a) {
                        boolean unused = s.this.d = false;
                        if (s.c) {
                            Log.d("kal", "remove file:" + this.a.getAbsolutePath());
                        }
                        s.this.a.remove(this.a);
                        if (s.c) {
                            Log.d("kal", "updateList size: " + s.this.a.size());
                        }
                        this.a.delete();
                        if (s.this.a.size() > 0) {
                            s.this.f.sendMessageDelayed(s.this.f.obtainMessage(1), 2000);
                        } else {
                            s.this.f.sendEmptyMessage(2);
                        }
                    }
                    return;
                }
                synchronized (s.this.a) {
                    boolean unused2 = s.this.d = false;
                    if (s.this.a.size() > 0) {
                        s.this.f.sendMessageDelayed(s.this.f.obtainMessage(1), 2000);
                    } else {
                        s.this.f.sendEmptyMessage(2);
                    }
                }
                return;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            a();
        }
    }

    public static s a() {
        if (b == null) {
            b = new s();
        }
        return b;
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.a.size() > 0) {
            if (c) {
                Log.d("kal", "started.");
            }
            this.d = true;
            new a(this.a.get(0)).start();
        }
    }

    private void b(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (!file2.getName().contains("udclog") && !this.a.contains(file2)) {
                        this.a.add(file2);
                    }
                }
                b();
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (c) {
            Log.d("kal", "stoped.");
        }
        this.d = false;
        String str = this.e;
        if (str != null) {
            b(new File(str));
        }
    }

    public String a(String str, String str2) {
        String AppendRecord = Mj.AppendRecord(str, str2);
        if (AppendRecord != null && !"".equals(AppendRecord)) {
            a(new File(AppendRecord));
        }
        return AppendRecord;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        b(new File(context.getFilesDir(), "udc/"));
    }

    public void a(File file) {
        synchronized (this.a) {
            if (!this.a.contains(file)) {
                this.a.add(file);
                this.e = file.getParent();
                if (!this.d) {
                    b();
                }
            }
        }
    }
}
