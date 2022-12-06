package com.iab.omid.library.bigosg.h.a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class b extends AsyncTask<Object, Void, String> {
    a d;
    protected final C0078b e;

    public interface a {
        void a();
    }

    /* renamed from: com.iab.omid.library.bigosg.h.a.b$b  reason: collision with other inner class name */
    public interface C0078b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(C0078b bVar) {
        this.e = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
