package shix.homeeye.camera.wxapi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class NetworkUtil {
    public static final int CHECK_TOKEN = 2;
    public static final int GET_IMG = 5;
    public static final int GET_INFO = 4;
    public static final int GET_TOKEN = 1;
    public static final int REFRESH_TOKEN = 3;
    /* access modifiers changed from: private */
    public static String TAG = "MicroMsg.NetworkUtil";

    public static void sendWxAPI(Handler handler, String str, int i) {
        new HttpsThread(handler, str, i).start();
    }

    public static void getImage(Handler handler, String str, int i) {
        new HttpsThread(handler, str, i).start();
    }

    static class HttpsThread extends Thread {
        private Handler handler;
        private String httpsUrl;
        private int msgTag;

        public HttpsThread(Handler handler2, String str, int i) {
            this.handler = handler2;
            this.httpsUrl = str;
            this.msgTag = i;
        }

        public void run() {
            if (this.msgTag == 5) {
                try {
                    byte[] httpURLConnectionGet = httpURLConnectionGet(this.httpsUrl);
                    Message obtain = Message.obtain();
                    obtain.what = this.msgTag;
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("imgdata", httpURLConnectionGet);
                    obtain.setData(bundle);
                    this.handler.sendMessage(obtain);
                } catch (Exception e) {
                    Log.e(NetworkUtil.TAG, e.getMessage());
                }
            } else {
                try {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.httpsUrl).openConnection();
                    httpsURLConnection.setAllowUserInteraction(false);
                    httpsURLConnection.setInstanceFollowRedirects(true);
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.connect();
                    if (httpsURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpsURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                                sb.append("\n");
                            } else {
                                inputStream.close();
                                String sb2 = sb.toString();
                                Log.i(NetworkUtil.TAG, sb2);
                                Message obtain2 = Message.obtain();
                                obtain2.what = this.msgTag;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("result", sb2);
                                obtain2.setData(bundle2);
                                this.handler.sendMessage(obtain2);
                                return;
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e(NetworkUtil.TAG, e2.getMessage());
                }
            }
        }

        private static byte[] httpURLConnectionGet(String str) throws Exception {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection == null) {
                Log.i(NetworkUtil.TAG, "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= 300) {
                httpURLConnection.disconnect();
                Log.w(NetworkUtil.TAG, "dz[httpURLConnectionGet 300]");
                return null;
            }
            byte[] readStream = readStream(httpURLConnection.getInputStream());
            httpURLConnection.disconnect();
            return readStream;
        }

        private static byte[] readStream(InputStream inputStream) throws IOException {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return byteArray;
                }
            }
        }
    }
}
