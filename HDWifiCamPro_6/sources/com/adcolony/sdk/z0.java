package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
import com.adcolony.sdk.e0;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import org.json.JSONException;

class z0 {
    private static ExecutorService a = h();
    static Handler b;

    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        a(Context context, String str, int i) {
            this.a = context;
            this.b = str;
            this.c = i;
        }

        public void run() {
            Toast.makeText(this.a, this.b, this.c).show();
        }
    }

    interface b extends Runnable {
        boolean a();
    }

    static boolean a(ExecutorService executorService, Runnable runnable) {
        try {
            executorService.execute(runnable);
            return true;
        } catch (RejectedExecutionException unused) {
            return false;
        }
    }

    static String b(Context context, String str) {
        return b(c(context), str);
    }

    static SharedPreferences c(Context context) {
        try {
            Class.forName("androidx.preference.PreferenceManager");
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (ClassNotFoundException unused) {
            return context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        }
    }

    @Deprecated
    static int d() {
        Context a2 = a.a();
        if (a2 == null) {
            return 0;
        }
        try {
            return a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            new e0.a().a("Failed to retrieve package info.").a(e0.i);
            return 0;
        }
    }

    private static Handler e() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return null;
        }
        if (b == null) {
            b = new Handler(mainLooper);
        }
        return b;
    }

    static int f(String str) {
        try {
            return (int) Long.parseLong(str, 16);
        } catch (NumberFormatException unused) {
            new e0.a().a("Unable to parse '").a(str).a("' as a color.").a(e0.g);
            return -16777216;
        }
    }

    static boolean g() {
        Context a2 = a.a();
        return a2 != null && Build.VERSION.SDK_INT >= 24 && (a2 instanceof Activity) && ((Activity) a2).isInMultiWindowMode();
    }

    static ExecutorService h() {
        return new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    static class c {
        private long a;
        private long b = System.currentTimeMillis();

        c(long j) {
            a(j);
        }

        /* access modifiers changed from: package-private */
        public void a(long j) {
            this.a = j;
            this.b = System.currentTimeMillis() + this.a;
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public long c() {
            return this.b - this.a;
        }

        /* access modifiers changed from: package-private */
        public long d() {
            long currentTimeMillis = this.b - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                return 0;
            }
            return currentTimeMillis;
        }

        public String toString() {
            return String.valueOf(((double) d()) / 1000.0d);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return d() == 0;
        }
    }

    static boolean a(Runnable runnable) {
        return a(a, runnable);
    }

    static String b(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, (String) null);
        } catch (ClassCastException unused) {
            e0.a aVar = new e0.a();
            aVar.a("Key " + str + " in SharedPreferences ").a("does not have a String value.").a(e0.g);
            return null;
        }
    }

    static int a(Context context, String str) {
        return a(c(context), str);
    }

    static int a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            e0.a aVar = new e0.a();
            aVar.a("Key " + str + " in SharedPreferences ").a("does not have an int value.").a(e0.g);
            return -1;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", r1).parse(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd", r1).parse(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Date g(java.lang.String r5) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "yyyy-MM-dd'T'HH:mmZ"
            r0.<init>(r2, r1)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r3 = "yyyy-MM-dd'T'HH:mm:ssZ"
            r2.<init>(r3, r1)
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyy-MM-dd"
            r3.<init>(r4, r1)
            java.util.Date r5 = r0.parse(r5)     // Catch:{ Exception -> 0x001c }
            return r5
        L_0x001c:
            java.util.Date r5 = r2.parse(r5)     // Catch:{ Exception -> 0x0021 }
            return r5
        L_0x0021:
            java.util.Date r5 = r3.parse(r5)     // Catch:{ Exception -> 0x0026 }
            return r5
        L_0x0026:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.z0.g(java.lang.String):java.util.Date");
    }

    static f1 c(f1 f1Var) {
        f1Var.a(new String[]{"ads_to_restore"});
        return f1Var;
    }

    static int f(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    static f1 b(f1 f1Var) {
        f1Var.r("launch_metadata");
        return f1Var;
    }

    static boolean e(String str) {
        if (str != null && str.length() <= 128) {
            return true;
        }
        new e0.a().a("String must be non-null and the max length is 128 characters.").a(e0.f);
        return false;
    }

    static String b() {
        Application application;
        Context a2 = a.a();
        if (a2 == null) {
            return "";
        }
        if (a2 instanceof Application) {
            application = (Application) a2;
        } else {
            application = ((Activity) a2).getApplication();
        }
        PackageManager packageManager = application.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(a2.getPackageName(), 0)).toString();
        } catch (Exception unused) {
            new e0.a().a("Failed to retrieve application label.").a(e0.i);
            return "";
        }
    }

    static boolean c(String str) {
        Application application;
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        try {
            if (a2 instanceof Application) {
                application = (Application) a2;
            } else {
                application = ((Activity) a2).getApplication();
            }
            application.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    static f1 a(f1 f1Var) {
        f1 f1Var2 = f1Var;
        f1Var2.a(new String[]{"data_path", "media_path", "temp_storage_path", "device_api", "display_dpi", "mac_address", "memory_class", "memory_used_mb", "model", "arch", "timezone_ietf", "timezone_gmt_m", "timezone_dst_m", "density", "dark_mode", "launch_metadata"});
        return f1Var2;
    }

    static String d(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    static String f() {
        Context a2 = a.a();
        return (!(a2 instanceof Activity) || a2.getResources().getConfiguration().orientation != 1) ? "landscape" : "portrait";
    }

    static int d(String str) {
        str.hashCode();
        if (!str.equals("portrait")) {
            return !str.equals("landscape") ? -1 : 1;
        }
        return 0;
    }

    static e1 e(Context context) {
        e1 a2 = c0.a();
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                if (packageInfo.requestedPermissions != null) {
                    a2 = c0.a();
                    int i = 0;
                    while (true) {
                        String[] strArr = packageInfo.requestedPermissions;
                        if (i >= strArr.length) {
                            break;
                        }
                        a2.b(strArr[i]);
                        i++;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return a2;
    }

    static String c() {
        Context a2 = a.a();
        if (a2 == null) {
            return "1.0";
        }
        try {
            return a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            new e0.a().a("Failed to retrieve package info.").a(e0.i);
            return "1.0";
        }
    }

    static int a(String str) {
        CRC32 crc32 = new CRC32();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            crc32.update(str.charAt(i));
        }
        return (int) crc32.getValue();
    }

    static boolean c(Runnable runnable) {
        Handler e;
        if (runnable == null || (e = e()) == null) {
            return false;
        }
        e.removeCallbacks(runnable);
        return true;
    }

    static String b(String str) {
        try {
            return d1.a(str);
        } catch (Exception unused) {
            return null;
        }
    }

    static boolean b(Runnable runnable) {
        Handler e;
        if (runnable == null || (e = e()) == null) {
            return false;
        }
        if (e.getLooper() != Looper.myLooper()) {
            return e.post(runnable);
        }
        runnable.run();
        return true;
    }

    static String a() {
        return UUID.randomUUID().toString();
    }

    static e1 a(int i) {
        e1 a2 = c0.a();
        for (int i2 = 0; i2 < i; i2++) {
            c0.a(a2, a());
        }
        return a2;
    }

    static boolean a(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        if (j <= 0) {
            return b(runnable);
        }
        Handler e = e();
        if (e != null) {
            return e.postDelayed(runnable, j);
        }
        return false;
    }

    static boolean b(AudioManager audioManager) {
        if (audioManager == null) {
            new e0.a().a("isAudioEnabled() called with a null AudioManager").a(e0.i);
            return false;
        }
        try {
            if (audioManager.getStreamVolume(3) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            new e0.a().a("Exception occurred when accessing AudioManager.getStreamVolume: ").a(e.toString()).a(e0.i);
            return false;
        }
    }

    static boolean a(b bVar) {
        Handler e;
        if (bVar == null || (e = e()) == null) {
            return false;
        }
        e.removeCallbacks(bVar);
        if (bVar.a()) {
            return true;
        }
        if (e.getLooper() == Looper.myLooper()) {
            bVar.run();
            return true;
        }
        e.post(bVar);
        return true;
    }

    static double a(AudioManager audioManager) {
        if (audioManager == null) {
            new e0.a().a("getAudioVolume() called with a null AudioManager").a(e0.i);
            return 0.0d;
        }
        try {
            double streamVolume = (double) audioManager.getStreamVolume(3);
            double streamMaxVolume = (double) audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume == 0.0d) {
                return 0.0d;
            }
            return streamVolume / streamMaxVolume;
        } catch (Exception e) {
            new e0.a().a("Exception occurred when accessing AudioManager: ").a(e.toString()).a(e0.i);
            return 0.0d;
        }
    }

    static int b(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            i = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        } else {
            i = context.getResources().getIdentifier("navigation_bar_height_landscape", "dimen", "android");
        }
        if (i > 0) {
            return context.getResources().getDimensionPixelSize(i);
        }
        return 0;
    }

    static String b(e1 e1Var) throws JSONException {
        String str = "";
        for (int i = 0; i < e1Var.b(); i++) {
            if (i > 0) {
                str = str + ",";
            }
            str = str + e1Var.b(i);
        }
        return str;
    }

    static int b(v0 v0Var) {
        int i = 0;
        try {
            Context a2 = a.a();
            if (a2 != null) {
                int i2 = (int) (a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0).lastUpdateTime / 1000);
                f1 g = v0Var.g();
                boolean z = true;
                if (!g.a("last_update")) {
                    i = 2;
                } else if (c0.d(g, "last_update") != i2) {
                    i = 1;
                } else {
                    z = false;
                }
                if (z) {
                    c0.b(g, "last_update", i2);
                    v0Var.a(g);
                }
            }
        } catch (Exception unused) {
        }
        return i;
    }

    static AudioManager a(Context context) {
        if (context != null) {
            return (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        }
        new e0.a().a("getAudioManager called with a null Context").a(e0.i);
        return null;
    }

    static boolean a(String str, File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to process file for MD5", e);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                            new e0.a().a("Exception on closing MD5 input stream").a(e0.i);
                        }
                        throw th;
                    }
                }
                boolean equals = str.equals(String.format("%40s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0'));
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    new e0.a().a("Exception on closing MD5 input stream").a(e0.i);
                }
                return equals;
            } catch (FileNotFoundException unused3) {
                new e0.a().a("Exception while getting FileInputStream").a(e0.i);
                return false;
            }
        } catch (NoSuchAlgorithmException unused4) {
            new e0.a().a("Exception while getting Digest").a(e0.i);
            return false;
        }
    }

    static int b(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[1]) / a.b().n().s());
    }

    private static void b(Vibrator vibrator, long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            a(vibrator, j);
        } else {
            vibrator.vibrate(j);
        }
    }

    static String a(e1 e1Var) throws JSONException {
        String str = "";
        for (int i = 0; i < e1Var.b(); i++) {
            if (i > 0) {
                str = str + ",";
            }
            switch (e1Var.b(i)) {
                case 1:
                    str = str + "MO";
                    break;
                case 2:
                    str = str + "TU";
                    break;
                case 3:
                    str = str + "WE";
                    break;
                case 4:
                    str = str + "TH";
                    break;
                case 5:
                    str = str + "FR";
                    break;
                case 6:
                    str = str + "SA";
                    break;
                case 7:
                    str = str + "SU";
                    break;
            }
        }
        return str;
    }

    static boolean a(Intent intent, boolean z) {
        try {
            Context a2 = a.a();
            if (a2 == null) {
                return false;
            }
            if (!(a2 instanceof Activity)) {
                intent.addFlags(268435456);
            }
            AdColonyInterstitial j = a.b().j();
            if (j != null && j.i()) {
                j.e().f();
            }
            if (z) {
                a2.startActivity(Intent.createChooser(intent, "Handle this via..."));
                return true;
            }
            a2.startActivity(intent);
            return true;
        } catch (Exception e) {
            new e0.a().a(e.toString()).a(e0.g);
            return false;
        }
    }

    static boolean a(Intent intent) {
        return a(intent, false);
    }

    static boolean a(String str, int i) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        b((Runnable) new a(a2, str, i));
        return true;
    }

    static String a(v0 v0Var) {
        f1 g = v0Var.g();
        String h = c0.h(g, "adc_alt_id");
        if (!h.isEmpty()) {
            return h;
        }
        String a2 = a();
        c0.a(g, "adc_alt_id", a2);
        v0Var.a(g);
        return a2;
    }

    static int a(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[0]) / a.b().n().s());
    }

    static boolean a(Context context, long j) {
        try {
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            if (vibrator == null || !vibrator.hasVibrator()) {
                return false;
            }
            b(vibrator, j);
            return true;
        } catch (Exception unused) {
            new e0.a().a("Vibrate command failed.").a(e0.f);
            return false;
        }
    }

    private static void a(Vibrator vibrator, long j) {
        vibrator.vibrate(VibrationEffect.createOneShot(j, -1));
    }
}
