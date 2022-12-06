package com.aliyun.sls.android.producer;

import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;

public class LogProducerHttpTool {
    private static final String VERSION = "sls-android-sdk_v2.5.14";
    protected static AtomicLong localServerDeltaTime = new AtomicLong(0);

    public static int android_http_post(String str, String[] strArr, byte[] bArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            httpURLConnection.setRequestProperty("User-agent", VERSION);
            if (strArr != null) {
                int length = strArr.length / 2;
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    httpURLConnection.setRequestProperty(strArr[i2], strArr[i2 + 1]);
                }
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            dataOutputStream.close();
            String headerField = httpURLConnection.getHeaderField("x-log-time");
            if (headerField != null && !"".equals(headerField)) {
                long parseLong = Long.parseLong(headerField);
                if (parseLong > 1500000000 && parseLong < 4294967294L) {
                    long currentTimeMillis = parseLong - (System.currentTimeMillis() / 1000);
                    if (currentTimeMillis > 600 || currentTimeMillis < -600) {
                        localServerDeltaTime.set(currentTimeMillis);
                    }
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode / 100 == 2) {
                return responseCode;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    Log.w(VERSION, sb.toString());
                    return responseCode;
                }
            }
        } catch (Exception e) {
            Log.w(VERSION, "exception", e);
            return -1;
        }
    }
}
