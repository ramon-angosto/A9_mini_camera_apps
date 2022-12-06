package com.shix.shixipc.utils;

import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class UploadUtil {
    private static final String CHARSET = "utf-8";
    private static final String TAG = "uploadFile";
    private static final int TIME_OUT = 10000;

    public static String uploadFile(String str, File file, String str2, String str3) {
        String uuid = UUID.randomUUID().toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestProperty("connection", "keep-alive");
            httpURLConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, str3);
            CommonUtil.Log(1, "sign:" + str3);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_MULTIPART + ";boundary=" + uuid);
            if (file == null) {
                return null;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            stringBuffer.append(uuid);
            stringBuffer.append("\r\n");
            String str4 = str + "--photos--20211127--2021-11-27-22-23-19-0.jpg";
            CommonUtil.Log(1, "file.getName():" + str4);
            stringBuffer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + str4 + "\"" + "\r\n");
            StringBuilder sb = new StringBuilder();
            sb.append("Content-Type: application/octet-stream; charset=utf-8");
            sb.append("\r\n");
            stringBuffer.append(sb.toString());
            stringBuffer.append("\r\n");
            CommonUtil.Log(1, "ZHAOSTART:   " + stringBuffer.toString());
            dataOutputStream.write(stringBuffer.toString().getBytes());
            FileInputStream fileInputStream = new FileInputStream(file);
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
            byte[] bytes = ("--" + uuid + "--" + "\r\n").getBytes();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ZHAOEND:   ");
            sb2.append(("--" + uuid + "--" + "\r\n").toString());
            CommonUtil.Log(1, sb2.toString());
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            Log.e(TAG, "response code:" + httpURLConnection.getResponseCode());
            Log.e(TAG, "request success");
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer2 = new StringBuffer();
            while (true) {
                int read2 = inputStream.read();
                if (read2 != -1) {
                    stringBuffer2.append((char) read2);
                } else {
                    String stringBuffer3 = stringBuffer2.toString();
                    Log.e(TAG, "result : " + stringBuffer3);
                    return stringBuffer3;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
