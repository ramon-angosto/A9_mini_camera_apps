package com.shix.shixipc.order;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.shix.shixipc.utils.CommonUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtils {
    public static void getRequest(String str, Map<String, String> map, String str2, OnResponseListener onResponseListener) {
        CommonUtil.Log(1, "getRequest url:" + str);
        StringBuffer stringBuffer = new StringBuffer(str);
        if (onResponseListener != null) {
            try {
                CommonUtil.Log(1, "getRequest sb.toString():" + stringBuffer.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(stringBuffer.toString()).openConnection();
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
                httpURLConnection.setConnectTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(stringBuffer.toString().getBytes(str2));
                outputStream.close();
                CommonUtil.Log(1, "getRequest con.getResponseCode():" + httpURLConnection.getResponseCode());
                if (httpURLConnection.getResponseCode() == 200) {
                    onSuccess(str2, onResponseListener, httpURLConnection);
                    CommonUtil.Log(1, "getRequest con.getResponseCode() == 200");
                }
            } catch (Exception e) {
                CommonUtil.Log(1, "getRequest error:" + e.toString());
                e.printStackTrace();
                onError(onResponseListener, e);
            }
        }
    }

    public static void postRequest(String str, Map<String, String> map, String str2, OnResponseListener onResponseListener) {
        StringBuffer stringBuffer = new StringBuffer();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                stringBuffer.append((String) next.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) next.getValue());
                stringBuffer.append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (onResponseListener != null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
                httpURLConnection.setConnectTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                byte[] bytes = stringBuffer.toString().getBytes();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bytes);
                outputStream.close();
                if (httpURLConnection.getResponseCode() == 200) {
                    onSuccess(str2, onResponseListener, httpURLConnection);
                }
            } catch (Exception e) {
                e.printStackTrace();
                onError(onResponseListener, e);
            }
        }
    }

    private static void onError(OnResponseListener onResponseListener, Exception exc) {
        onResponseListener.onError(exc.toString());
    }

    private static void onSuccess(String str, OnResponseListener onResponseListener, HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        if (inputStream != null) {
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str2 = new String(byteArrayOutputStream.toByteArray(), str);
                    CommonUtil.Log(1, "getRequest str:" + str2);
                    onResponseListener.onSuccess(str2);
                    return;
                }
            }
        }
    }
}
