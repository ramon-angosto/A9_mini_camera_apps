package com.mbridge.msdk.foundation.same.report.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: CrashHandlerUtil */
public class a implements Thread.UncaughtExceptionHandler {
    private static volatile a c;
    Handler a = new Handler() {
        public final void handleMessage(Message message) {
            Context context;
            HashMap hashMap;
            super.handleMessage(message);
            if (message.what == 101 && (context = (Context) a.this.b.get()) != null && (message.obj instanceof HashMap) && (hashMap = (HashMap) message.obj) != null) {
                new c(context).a((String) hashMap.get("crashinfo"), (File) hashMap.get("file"));
            }
        }
    };
    /* access modifiers changed from: private */
    public WeakReference<Context> b;
    private Thread.UncaughtExceptionHandler d;
    private Throwable e;

    private a(Context context) {
        this.b = new WeakReference<>(context);
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public final void a() {
        this.d = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private String a(Throwable th, String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            Context context = (Context) this.b.get();
            if (context == null) {
                return "";
            }
            float f = (float) ((((double) Runtime.getRuntime().totalMemory()) * 1.0d) / 1048576.0d);
            float freeMemory = (float) ((((double) Runtime.getRuntime().freeMemory()) * 1.0d) / 1048576.0d);
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            long usableSpace = externalStorageDirectory.getUsableSpace();
            String str3 = "appversionname";
            Object obj = "-1";
            long totalSpace = externalStorageDirectory.getTotalSpace();
            String formatFileSize = Formatter.formatFileSize(context, usableSpace);
            String formatFileSize2 = Formatter.formatFileSize(context, totalSpace);
            jSONObject.put("max_memory", String.valueOf((float) ((((double) Runtime.getRuntime().maxMemory()) * 1.0d) / 1048576.0d)));
            jSONObject.put("memoryby_app", String.valueOf(f));
            jSONObject.put("remaining_memory", (double) freeMemory);
            jSONObject.put("sdcard_remainder", formatFileSize);
            jSONObject.put("totalspacestr", formatFileSize2);
            jSONObject.put("crashtime", str);
            String b2 = com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.SDK_APP_ID);
            if (!TextUtils.isEmpty(b2)) {
                jSONObject.put("appid", b2);
            }
            try {
                jSONObject.put("osversion", Build.VERSION.SDK_INT);
                jSONObject.put("appversioncode", b(context));
                str2 = str3;
                try {
                    jSONObject.put(str2, c(context));
                    jSONObject.put("appname", d(context));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str2 = str3;
                jSONObject.put("osversion", 0);
                Object obj2 = obj;
                jSONObject.put("appversioncode", obj2);
                jSONObject.put(str2, obj2);
                jSONObject.put("appname", "");
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                jSONObject.put("crashinfo", stringWriter.toString());
                String jSONObject2 = jSONObject.toString();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000052");
                stringBuffer.append("&exception=" + jSONObject2);
                return stringBuffer.toString();
            }
            StringWriter stringWriter2 = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter2));
            jSONObject.put("crashinfo", stringWriter2.toString());
            String jSONObject22 = jSONObject.toString();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("key=2000052");
            stringBuffer2.append("&exception=" + jSONObject22);
            return stringBuffer2.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    private int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private static String c(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("", e2.getMessage());
            return "";
        }
    }

    private String d(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            this.e = th;
            com.mbridge.msdk.b.a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
            if (b2 == null) {
                b2 = b.a().b();
            }
            String s = b2.s() == null ? "mbridge" : b2.s();
            List<String> a2 = a(s, "<mvpackage>(.*?)</mvpackage>");
            if (a2.size() > 0) {
                for (int i = 0; i < a2.size(); i++) {
                    a(a(th), a2.get(i), th, thread);
                }
                return;
            }
            a(a(th), s, th, thread);
        } catch (Exception e2) {
            a(thread, th);
            e2.printStackTrace();
        }
    }

    private String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stackTrace.length; i++) {
            sb.append(stackTrace[i].toString() + "\n");
        }
        return sb.toString();
    }

    private void a(String str, String str2, Throwable th, Thread thread) {
        if (str.contains(str2)) {
            HashMap<String, Object> b2 = b();
            if (b2 != null && b2.get("file") != null) {
                Message obtain = Message.obtain();
                HashMap hashMap = new HashMap();
                hashMap.put("crashinfo", a(th, (String) b2.get("time")));
                hashMap.put("file", b2.get("file"));
                obtain.obj = hashMap;
                obtain.what = 101;
                this.a.sendMessage(obtain);
                a(thread, th);
                return;
            }
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    private void a(Thread thread, Throwable th) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        Process.killProcess(Process.myPid());
    }

    private HashMap<String, Object> b() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (this.e == null) {
            return null;
        }
        String b2 = e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO);
        File file = new File(b2 + "/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        File file2 = new File(b2 + "/" + "sdkcrash" + format + ".txt");
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
            printWriter.println(a(this.e, format));
            printWriter.println("====");
            this.e.printStackTrace(printWriter);
            printWriter.close();
            hashMap.put("file", file2);
            hashMap.put("time", format);
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
