package com.shix.shixipc.utils;

import com.alibaba.sdk.android.oss.common.utils.IOUtils;
import com.bumptech.glide.load.Key;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {
    public static String doHttpPost(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println("发起的数据:" + str);
        byte[] bytes = str.getBytes();
        InputStream inputStream = null;
        try {
            URLConnection openConnection = new URL(str2).openConnection();
            openConnection.setDoOutput(true);
            openConnection.setDoInput(true);
            openConnection.setUseCaches(false);
            openConnection.setRequestProperty("content-Type", "application/json");
            openConnection.setRequestProperty("charset", "utf-8");
            openConnection.setRequestProperty("Content-length", String.valueOf(bytes.length));
            System.out.println(String.valueOf(bytes.length));
            DataOutputStream dataOutputStream = new DataOutputStream(openConnection.getOutputStream());
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            dataOutputStream.close();
            InputStream inputStream2 = openConnection.getInputStream();
            String str3 = new String(IOUtils.readStreamAsBytesArray(inputStream2), Key.STRING_CHARSET_NAME);
            if ("".equals(str3.trim())) {
                System.out.println("返回空");
            }
            PrintStream printStream2 = System.out;
            printStream2.println("返回数据为:" + str3);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused) {
                    return "0";
                }
            }
            return str3;
        } catch (Exception e) {
            e.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            return "0";
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                    return "0";
                }
            }
            throw th;
        }
    }
}
