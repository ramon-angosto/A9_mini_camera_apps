package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* renamed from: com.huawei.secure.android.common.ssl.util.e */
public class C0944e extends AsyncTask<Context, Integer, Boolean> {

    /* renamed from: a */
    private static final String f1242a = C0944e.class.getSimpleName();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            String str = f1242a;
            C0946g.m1579b(str, "doInBackground: exception : " + e.getMessage());
            inputStream = null;
        }
        String str2 = f1242a;
        C0946g.m1577a(str2, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream == null) {
            return false;
        }
        C0945f.m1570a(inputStream);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        C0946g.m1577a(f1242a, "onPreExecute");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            C0946g.m1580c(f1242a, "onPostExecute: upate done");
        } else {
            C0946g.m1579b(f1242a, "onPostExecute: upate failed");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        C0946g.m1580c(f1242a, "onProgressUpdate");
    }
}
