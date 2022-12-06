package com.meizu.cloud.pushsdk.b.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.meizu.cloud.pushsdk.b.b.b;
import com.meizu.cloud.pushsdk.b.f.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import object.p2pipcam.utils.DataBaseHelper;

public class a {
    private String a = a.class.getSimpleName();
    private SQLiteDatabase b;
    private b c;
    private String[] d = {DataBaseHelper.KEY_ID, "eventData", "dateCreated"};
    private long e = -1;
    private int f;

    public a(Context context, int i) {
        this.c = b.a(context);
        a();
        this.f = i;
        String str = this.a;
        c.b(str, "DB Path: " + this.b.getPath(), new Object[0]);
    }

    public void a(com.meizu.cloud.pushsdk.b.a.a aVar) {
        b(aVar);
    }

    public void a() {
        if (!d()) {
            this.b = this.c.getWritableDatabase();
            this.b.enableWriteAheadLogging();
        }
    }

    public long b(com.meizu.cloud.pushsdk.b.a.a aVar) {
        if (d()) {
            byte[] a2 = a((Map<String, String>) aVar.a());
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("eventData", a2);
            this.e = this.b.insert("events", (String) null, contentValues);
        }
        String str = this.a;
        c.b(str, "Added event to database: " + this.e, new Object[0]);
        return this.e;
    }

    public boolean a(long j) {
        int i;
        if (d()) {
            SQLiteDatabase sQLiteDatabase = this.b;
            i = sQLiteDatabase.delete("events", "id=" + j, (String[]) null);
        } else {
            i = -1;
        }
        String str = this.a;
        c.b(str, "Removed event from database: " + j, new Object[0]);
        return i == 1;
    }

    private static byte[] a(Map<String, String> map) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Map<String, String> a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return hashMap;
        } catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Map<String, Object>> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (d()) {
            Cursor query = this.b.query("events", this.d, str, (String[]) null, (String) null, (String) null, str2);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                HashMap hashMap = new HashMap();
                hashMap.put(DataBaseHelper.KEY_ID, Long.valueOf(query.getLong(0)));
                hashMap.put("eventData", a(query.getBlob(1)));
                hashMap.put("dateCreated", query.getString(2));
                query.moveToNext();
                arrayList.add(hashMap);
            }
            query.close();
        }
        return arrayList;
    }

    public long b() {
        return DatabaseUtils.queryNumEntries(this.b, "events");
    }

    public b c() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (Map next : a(this.f)) {
            com.meizu.cloud.pushsdk.b.a.c cVar = new com.meizu.cloud.pushsdk.b.a.c();
            cVar.a((Map) next.get("eventData"));
            linkedList.add((Long) next.get(DataBaseHelper.KEY_ID));
            arrayList.add(cVar);
        }
        return new b(arrayList, linkedList);
    }

    public List<Map<String, Object>> a(int i) {
        return a((String) null, "id ASC LIMIT " + i);
    }

    public boolean d() {
        SQLiteDatabase sQLiteDatabase = this.b;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }
}
