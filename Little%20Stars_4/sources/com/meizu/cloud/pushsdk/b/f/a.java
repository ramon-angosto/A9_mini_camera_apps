package com.meizu.cloud.pushsdk.b.f;

import android.content.Context;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final String a = "a";

    public static boolean a(String str, Map map, Context context) {
        try {
            c.b(a, "Attempting to save: %s", map);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            c.b(a, " + Successfully saved KV Pairs to: %s", str);
            return true;
        } catch (IOException e) {
            c.a(a, " + Exception saving vars map: %s", e.getMessage());
            return false;
        }
    }

    public static Map a(String str, Context context) {
        try {
            c.b(a, "Attempting to retrieve map from: %s", str);
            ObjectInputStream objectInputStream = new ObjectInputStream(context.openFileInput(str));
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            c.b(a, " + Retrieved map from file: %s", hashMap);
            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            c.a(a, " + Exception getting vars map: %s", e.getMessage());
            return null;
        }
    }
}
