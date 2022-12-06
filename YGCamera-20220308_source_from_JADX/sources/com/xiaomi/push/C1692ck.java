package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1685ci;

/* renamed from: com.xiaomi.push.ck */
class C1692ck implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f1945a;

    /* renamed from: a */
    final /* synthetic */ C1685ci.C1686a f1946a;

    C1692ck(C1685ci.C1686a aVar, Context context) {
        this.f1946a = aVar;
        this.f1945a = context;
    }

    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a = this.f1946a.mo17307a();
            if (a != null && a.isOpen()) {
                a.beginTransaction();
                this.f1946a.mo17317a(this.f1945a, a);
                a.setTransactionSuccessful();
            }
            if (a != null) {
                try {
                    a.endTransaction();
                } catch (Exception e) {
                    e = e;
                    C1524b.m2155a((Throwable) e);
                    this.f1946a.mo17316a(this.f1945a);
                }
            }
            if (this.f1946a.f1926a != null) {
                this.f1946a.f1926a.close();
            }
        } catch (Exception e2) {
            C1524b.m2155a((Throwable) e2);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    e = e3;
                    C1524b.m2155a((Throwable) e);
                    this.f1946a.mo17316a(this.f1945a);
                }
            }
            if (this.f1946a.f1926a != null) {
                this.f1946a.f1926a.close();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    C1524b.m2155a((Throwable) e4);
                    this.f1946a.mo17316a(this.f1945a);
                    throw th;
                }
            }
            if (this.f1946a.f1926a != null) {
                this.f1946a.f1926a.close();
            }
            this.f1946a.mo17316a(this.f1945a);
            throw th;
        }
        this.f1946a.mo17316a(this.f1945a);
    }
}
