package com.vungle.warren.omsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.iab.omid.library.vungle.Omid;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OMInjector {
    private static final String OM_SDK_JS = "omsdk.js";
    private static final String OM_SESSION_JS = "omsdk-session.js";
    /* access modifiers changed from: private */
    public AtomicReference<Context> contextRef;
    private Handler uiHandler = new Handler(Looper.getMainLooper());

    public OMInjector(Context context) {
        this.contextRef = new AtomicReference<>(context.getApplicationContext());
    }

    public void init() {
        this.uiHandler.post(new Runnable() {
            public void run() {
                if (!Omid.isActive()) {
                    Omid.activate((Context) OMInjector.this.contextRef.get());
                    SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.OM_SDK).addData(SessionAttribute.ENABLED, true).addData(SessionAttribute.SUCCESS, Omid.isActive()).build());
                }
            }
        });
    }

    public List<File> injectJsFiles(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(writeToFile(Res.OM_JS, new File(file, OM_SDK_JS)));
        arrayList.add(writeToFile(Res.OM_SESSION_JS, new File(file, OM_SESSION_JS)));
        return arrayList;
    }

    private File writeToFile(String str, File file) throws IOException {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str);
                fileWriter2.flush();
                closeQuietly(fileWriter2);
                return file;
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                closeQuietly(fileWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(fileWriter);
            throw th;
        }
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
