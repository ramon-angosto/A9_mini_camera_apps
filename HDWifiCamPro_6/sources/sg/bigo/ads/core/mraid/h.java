package sg.bigo.ads.core.mraid;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.widget.Toast;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import sg.bigo.ads.common.utils.g;

public final class h {
    private static final String[] a = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    private static Set<String> b = new HashSet();

    static class a extends AsyncTask<String, Void, Boolean> {
        private final Context a;
        private final C0145a b;

        /* renamed from: sg.bigo.ads.core.mraid.h$a$a  reason: collision with other inner class name */
        interface C0145a {
            void a();

            void b();
        }

        public a(Context context, C0145a aVar) {
            this.a = context.getApplicationContext();
            this.b = aVar;
        }

        /* JADX WARNING: type inference failed for: r7v14, types: [java.io.OutputStream, java.io.FileOutputStream] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(java.lang.String[] r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x008c
                int r0 = r7.length
                if (r0 == 0) goto L_0x008c
                r0 = 0
                r1 = r7[r0]
                if (r1 != 0) goto L_0x000c
                goto L_0x008c
            L_0x000c:
                java.io.File r1 = sg.bigo.ads.common.utils.n.d()
                r1.mkdirs()
                r7 = r7[r0]
                r2 = 0
                sg.bigo.ads.common.l.b.a r3 = new sg.bigo.ads.common.l.b.a     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                r3.<init>(r7)     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                sg.bigo.ads.common.l.c r3 = sg.bigo.ads.common.l.g.a(r3)     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                T r4 = r3.a     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                if (r4 != 0) goto L_0x002c
            L_0x0023:
                java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                a((java.io.Closeable) r2)
                a((java.io.Closeable) r2)
                return r7
            L_0x002c:
                T r4 = r3.a     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                sg.bigo.ads.common.l.c.a r4 = (sg.bigo.ads.common.l.c.a) r4     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                java.io.InputStream r4 = r4.b     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                if (r4 != 0) goto L_0x0035
                goto L_0x0023
            L_0x0035:
                java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                r5.<init>(r4)     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
                T r3 = r3.a     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                sg.bigo.ads.common.l.c.a r3 = (sg.bigo.ads.common.l.c.a) r3     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                sg.bigo.ads.common.utils.g<java.util.List<java.lang.String>> r3 = r3.c     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                java.lang.String r7 = a((java.lang.String) r7, (sg.bigo.ads.common.utils.g<java.util.List<java.lang.String>>) r3)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r3.<init>(r1, r7)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                r7.<init>(r3)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
                a((java.io.InputStream) r5, (java.io.OutputStream) r7)     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                sg.bigo.ads.core.mraid.h$b r2 = new sg.bigo.ads.core.mraid.h$b     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                r2.<init>(r1, r0)     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                android.media.MediaScannerConnection r0 = new android.media.MediaScannerConnection     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                android.content.Context r1 = r6.a     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                r2.c = r0     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                r0.connect()     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0075, all -> 0x0070 }
                a((java.io.Closeable) r5)
            L_0x006c:
                a((java.io.Closeable) r7)
                return r0
            L_0x0070:
                r0 = move-exception
                goto L_0x0083
            L_0x0072:
                r7 = move-exception
                goto L_0x0085
            L_0x0074:
                r7 = r2
            L_0x0075:
                r2 = r5
                goto L_0x007b
            L_0x0077:
                r7 = move-exception
                r5 = r2
                goto L_0x0085
            L_0x007a:
                r7 = r2
            L_0x007b:
                java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0081 }
                a((java.io.Closeable) r2)
                goto L_0x006c
            L_0x0081:
                r0 = move-exception
                r5 = r2
            L_0x0083:
                r2 = r7
                r7 = r0
            L_0x0085:
                a((java.io.Closeable) r5)
                a((java.io.Closeable) r2)
                throw r7
            L_0x008c:
                java.lang.Boolean r7 = java.lang.Boolean.FALSE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.mraid.h.a.doInBackground(java.lang.String[]):java.lang.Boolean");
        }

        private static String a(String str, g<List<String>> gVar) {
            if (gVar == null) {
                return null;
            }
            String name = new File(String.valueOf(str.hashCode())).getName();
            List a2 = gVar.a("content-type");
            if (a2 == null || a2.isEmpty()) {
                return name;
            }
            if (a2.get(0) == null) {
                return name;
            }
            for (String str2 : ((String) a2.get(0)).split(";")) {
                if (str2.contains("image/")) {
                    String str3 = "." + str2.split("/")[1];
                    if (name.endsWith(str3)) {
                        return name;
                    }
                    return name + str3;
                }
            }
            return name;
        }

        private static void a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception unused) {
                    sg.bigo.ads.common.k.a.a(0, "MraidBridge", "Unable to close stream. Ignoring.");
                }
            }
        }

        private static void a(InputStream inputStream, OutputStream outputStream) {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool == null || !bool.booleanValue()) {
                this.b.b();
            } else {
                this.b.a();
            }
        }
    }

    static class b implements MediaScannerConnection.MediaScannerConnectionClient {
        private final String a;
        private final String b;
        /* access modifiers changed from: private */
        public MediaScannerConnection c;

        private b(String str) {
            this.a = str;
            this.b = null;
        }

        /* synthetic */ b(String str, byte b2) {
            this(str);
        }

        public final void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.a, this.b);
            }
        }

        public final void onScanCompleted(String str, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }

    interface c {
        void a(d dVar);
    }

    private static Date a(String str) {
        String[] strArr = a;
        int length = strArr.length;
        Date date = null;
        int i = 0;
        while (i < length) {
            try {
                date = new SimpleDateFormat(strArr[i], Locale.US).parse(str);
                if (date != null) {
                    break;
                }
                i++;
            } catch (ParseException unused) {
            }
        }
        return date;
    }

    static void a(Context context, Map<String, String> map) {
        String str;
        Map<String, String> map2 = map;
        if (d(context)) {
            try {
                HashMap hashMap = new HashMap();
                if (!map2.containsKey("description") || !map2.containsKey("start")) {
                    throw new IllegalArgumentException("Missing start and description fields");
                }
                hashMap.put(CampaignEx.JSON_KEY_TITLE, map2.get("description"));
                if (!map2.containsKey("start") || map2.get("start") == null) {
                    throw new IllegalArgumentException("Invalid calendar event: start is null.");
                }
                Date a2 = a(map2.get("start"));
                if (a2 != null) {
                    hashMap.put("beginTime", Long.valueOf(a2.getTime()));
                    if (map2.containsKey(TtmlNode.END) && map2.get(TtmlNode.END) != null) {
                        Date a3 = a(map2.get(TtmlNode.END));
                        if (a3 != null) {
                            hashMap.put("endTime", Long.valueOf(a3.getTime()));
                        } else {
                            throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                        }
                    }
                    if (map2.containsKey(RequestParameters.SUBRESOURCE_LOCATION)) {
                        hashMap.put("eventLocation", map2.get(RequestParameters.SUBRESOURCE_LOCATION));
                    }
                    if (map2.containsKey("summary")) {
                        hashMap.put("description", map2.get("summary"));
                    }
                    if (map2.containsKey("transparency")) {
                        hashMap.put("availability", Integer.valueOf(map2.get("transparency").equals("transparent") ? 1 : 0));
                    }
                    StringBuilder sb = new StringBuilder();
                    if (map2.containsKey("frequency")) {
                        String str2 = map2.get("frequency");
                        int parseInt = map2.containsKey("interval") ? Integer.parseInt(map2.get("interval")) : -1;
                        if ("daily".equals(str2)) {
                            sb.append("FREQ=DAILY;");
                            if (parseInt != -1) {
                                str = "INTERVAL=" + parseInt + ";";
                            }
                        } else if ("weekly".equals(str2)) {
                            sb.append("FREQ=WEEKLY;");
                            if (parseInt != -1) {
                                sb.append("INTERVAL=" + parseInt + ";");
                            }
                            if (map2.containsKey("daysInWeek")) {
                                String b2 = b(map2.get("daysInWeek"));
                                if (b2 != null) {
                                    str = "BYDAY=" + b2 + ";";
                                } else {
                                    throw new IllegalArgumentException("invalid ");
                                }
                            }
                        } else if ("monthly".equals(str2)) {
                            sb.append("FREQ=MONTHLY;");
                            if (parseInt != -1) {
                                sb.append("INTERVAL=" + parseInt + ";");
                            }
                            if (map2.containsKey("daysInMonth")) {
                                String c2 = c(map2.get("daysInMonth"));
                                if (c2 != null) {
                                    str = "BYMONTHDAY=" + c2 + ";";
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                        }
                        sb.append(str);
                    }
                    hashMap.put("rrule", sb.toString());
                    Intent type = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
                    for (String str3 : hashMap.keySet()) {
                        Object obj = hashMap.get(str3);
                        if (obj instanceof Long) {
                            type.putExtra(str3, ((Long) obj).longValue());
                        } else if (obj instanceof Integer) {
                            type.putExtra(str3, ((Integer) obj).intValue());
                        } else {
                            type.putExtra(str3, (String) obj);
                        }
                    }
                    type.setFlags(268435456);
                    context.startActivity(type);
                    return;
                }
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            } catch (ActivityNotFoundException unused) {
                sg.bigo.ads.common.k.a.a(0, "MraidBridge", "no calendar app installed");
                throw new d("Action is unsupported on this device - no calendar app installed");
            } catch (IllegalArgumentException e) {
                sg.bigo.ads.common.k.a.a(0, "MraidBridge", "create calendar: invalid parameters " + e.getMessage());
                throw new d((Throwable) e);
            } catch (Exception e2) {
                sg.bigo.ads.common.k.a.a(0, "MraidBridge", "could not create calendar event");
                throw new d((Throwable) e2);
            }
        } else {
            sg.bigo.ads.common.k.a.a(0, "MraidBridge", "unsupported action createCalendarEvent for devices pre-ICS");
            throw new d("Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
        }
    }

    private static <P> void a(final AsyncTask<P, ?, ?> asyncTask, final P... pArr) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, pArr);
            return;
        }
        sg.bigo.ads.common.k.a.a(0, 3, "MraidBridge", "Posting AsyncTask to main thread for execution.");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, pArr);
            }
        });
    }

    static boolean a(Activity activity) {
        return (activity.getWindow() == null || (activity.getWindow().getAttributes().flags & 16777216) == 0) ? false : true;
    }

    static boolean a(Context context) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return a(context, intent);
    }

    private static boolean a(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (Exception unused) {
        }
    }

    private static boolean a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Exception unused) {
        }
    }

    private static String b(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String[] split = str.split(",");
        for (String parseInt : split) {
            int parseInt2 = Integer.parseInt(parseInt);
            if (parseInt2 == 7) {
                parseInt2 = 0;
            }
            if (!zArr[parseInt2]) {
                StringBuilder sb2 = new StringBuilder();
                switch (parseInt2) {
                    case 0:
                        str2 = "SU";
                        break;
                    case 1:
                        str2 = "MO";
                        break;
                    case 2:
                        str2 = "TU";
                        break;
                    case 3:
                        str2 = "WE";
                        break;
                    case 4:
                        str2 = "TH";
                        break;
                    case 5:
                        str2 = "FR";
                        break;
                    case 6:
                        str2 = "SA";
                        break;
                    default:
                        throw new IllegalArgumentException("invalid day of week ".concat(String.valueOf(parseInt2)));
                }
                sb2.append(str2);
                sb2.append(",");
                sb.append(sb2.toString());
                zArr[parseInt2] = true;
            }
        }
        if (split.length != 0) {
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
    }

    static boolean b(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return a(context, intent);
    }

    private static String c(String str) {
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String[] split = str.split(",");
        for (String parseInt : split) {
            int parseInt2 = Integer.parseInt(parseInt);
            int i = parseInt2 + 31;
            if (!zArr[i]) {
                StringBuilder sb2 = new StringBuilder();
                if (parseInt2 == 0 || parseInt2 < -31 || parseInt2 > 31) {
                    throw new IllegalArgumentException("invalid day of month ".concat(String.valueOf(parseInt2)));
                }
                sb2.append(String.valueOf(parseInt2));
                sb2.append(",");
                sb.append(sb2.toString());
                zArr[i] = true;
            }
        }
        if (split.length != 0) {
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
    }

    public static boolean c(Context context) {
        return "mounted".equals(Environment.getExternalStorageState()) && a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    static boolean d(Context context) {
        return a(context, new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event"));
    }

    /* access modifiers changed from: package-private */
    public final void a(final Context context, String str, final c cVar) {
        if (b.contains(str)) {
            sg.bigo.ads.common.k.a.a(0, 3, "MraidBridge", "Image downloading task has been created");
            return;
        }
        b.add(str);
        a(new a(context, new a.C0145a() {
            public final void a() {
                sg.bigo.ads.common.k.a.a(0, 3, "MraidBridge", "Image successfully saved.");
            }

            public final void b() {
                Toast.makeText(context, "Image failed to download.", 0).show();
                sg.bigo.ads.common.k.a.a(0, "MraidBridge", "Error downloading and saving image file.");
                cVar.a(new d("Error downloading and saving image file."));
            }
        }), (P[]) new String[]{str});
    }
}
