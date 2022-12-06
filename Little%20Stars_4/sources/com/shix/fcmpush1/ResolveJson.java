package com.shix.fcmpush1;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class ResolveJson {
    private static HashMap<String, String> hashMap = new HashMap<>();

    protected static HashMap<String, String> resolve(Context context) {
        try {
            InputStream open = context.getResources().getAssets().open("google-services.json");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            createHashMap(new String(byteArrayOutputStream.toByteArray(), "ISO-8859-1"));
            byteArrayOutputStream.close();
            open.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    private static void createHashMap(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("project_info");
        JSONObject jSONObject3 = jSONObject.getJSONArray("client").getJSONObject(0);
        JSONObject jSONObject4 = jSONObject3.getJSONArray("api_key").getJSONObject(0);
        hashMap.put("ProjectId", jSONObject2.getString("project_id"));
        hashMap.put("ApiKey", jSONObject4.getString("current_key"));
        hashMap.put("ApplicationId", jSONObject3.getJSONObject("client_info").getString("mobilesdk_app_id"));
        hashMap.put("DatabaseUrl", jSONObject2.getString("firebase_url"));
        hashMap.put("GcmSenderId", jSONObject2.getString("project_number"));
    }
}
