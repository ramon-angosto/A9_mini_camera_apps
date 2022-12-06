package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.xiaomi.push.providers.a */
public class C1942a extends SQLiteOpenHelper {

    /* renamed from: a */
    private static int f3570a = 1;

    /* renamed from: a */
    public static final Object f3571a = new Object();

    /* renamed from: a */
    private static final String[] f3572a = {Constants.PACKAGE_NAME, "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public C1942a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f3570a);
    }

    /* renamed from: a */
    private void m4737a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i = 0; i < f3572a.length - 1; i += 2) {
            if (i != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(f3572a[i]);
            sb.append(" ");
            sb.append(f3572a[i + 1]);
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f3571a) {
            try {
                m4737a(sQLiteDatabase);
            } catch (SQLException e) {
                C1524b.m2155a((Throwable) e);
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
