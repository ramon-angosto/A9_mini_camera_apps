package com.apm.insight.l;

import android.os.Build;
import android.text.TextUtils;
import com.apm.insight.l.e;
import com.apm.insight.nativecrash.NativeImpl;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class v {
    private static final StackTraceElement a = new StackTraceElement("", "", "", 0);

    public static class a {
        public int a = -1;
        public int b = -1;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.a);
                jSONObject.put(TtmlNode.END, this.b);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            int i2 = 0;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (i2 <= 256) {
                        linkedList.add(readLine);
                        sb.append(readLine);
                        sb.append(10);
                    } else {
                        linkedList2.add(readLine);
                        if (linkedList2.size() > 256) {
                            linkedList2.poll();
                            i++;
                        }
                    }
                    i2++;
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        k.a((Closeable) bufferedReader);
        if (!linkedList2.isEmpty()) {
            if (i != 0) {
                sb.append("\t... skip ");
                sb.append(i);
                sb.append(" lines\n");
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(10);
            }
        }
        return sb.toString();
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            a(th, printWriter);
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Throwable unused) {
            printWriter.close();
            return "";
        }
    }

    public static String a(Throwable th, Thread thread, PrintStream printStream, e.a aVar) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        } catch (Throwable unused) {
            messageDigest = null;
        }
        e eVar = new e(printStream, messageDigest, aVar);
        try {
            a(th, (PrintWriter) eVar);
        } catch (Throwable unused2) {
        }
        eVar.close();
        if (messageDigest != null) {
            return a(messageDigest.digest());
        }
        return null;
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement a2 : stackTraceElementArr) {
            a(a2, sb);
        }
        return sb.toString();
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    public static JSONArray a(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (aVar.a == -1) {
                if (a(stackTraceElementArr[i].getClassName(), strArr)) {
                    aVar.a = i;
                    aVar.b = i;
                }
            } else if (!a(stackTraceElementArr[i].getClassName(), strArr)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.a != -1) {
            aVar.b = stackTraceElementArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    public static JSONArray a(String[] strArr, String[] strArr2) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < strArr.length; i++) {
            if (aVar.a == -1) {
                if (a(strArr[i], strArr2)) {
                    aVar.a = i;
                    aVar.b = i;
                }
            } else if (!a(strArr[i], strArr2)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.a != -1) {
            aVar.b = strArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    private static void a(StackTraceElement stackTraceElement, int i) {
        String str;
        String valueOf;
        try {
            a("\tat ", i);
            a(stackTraceElement.getClassName(), i);
            a(".", i);
            a(stackTraceElement.getMethodName(), i);
            if (stackTraceElement.isNativeMethod()) {
                str = "(Native Method)";
            } else {
                if (stackTraceElement.getFileName() != null) {
                    if (stackTraceElement.getLineNumber() >= 0) {
                        a("(", i);
                        a(stackTraceElement.getFileName(), i);
                        a(":", i);
                        valueOf = String.valueOf(stackTraceElement.getLineNumber());
                    } else {
                        a("(", i);
                        valueOf = stackTraceElement.getFileName();
                    }
                } else if (stackTraceElement.getLineNumber() >= 0) {
                    a("(Unknown Source:", i);
                    valueOf = String.valueOf(stackTraceElement.getLineNumber());
                } else {
                    str = "(Unknown Source)";
                }
                a(valueOf, i);
                a(")", i);
                a("\n", i);
            }
            a(str, i);
            a("\n", i);
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, int i) {
        NativeImpl.a(i, str);
    }

    public static void a(Throwable th, int i) {
        try {
            c(th, i);
        } catch (Throwable unused) {
        }
    }

    private static void a(Throwable th, int i, String str, String str2) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        try {
            NativeImpl.a(i, str2);
            NativeImpl.a(i, str);
        } catch (Throwable unused) {
        }
        b(th, i);
        for (StackTraceElement a2 : stackTrace) {
            a(a2, i);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable a3 : th.getSuppressed()) {
                a(a3, i, "Suppressed: ", str2 + "\t");
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, i, "Caused by: ", str2);
        }
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (th != null && printWriter != null) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            printWriter.println(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            boolean z = stackTrace.length > 384;
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (z && i2 > 256) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("\t... skip ");
                    sb.append((stackTrace.length - i2) - 128);
                    sb.append(" lines");
                    printWriter.println(sb.toString());
                    break;
                }
                printWriter.println("\tat " + stackTraceElement);
                i2++;
                i++;
            }
            if (z) {
                for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                    printWriter.println("\tat " + stackTrace[length2]);
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable a2 : th.getSuppressed()) {
                    a(a2, printWriter, stackTrace, "Suppressed: ", "\t", (Set<Throwable>) newSetFromMap, 128);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, printWriter, stackTrace, "Caused by: ", "", (Set<Throwable>) newSetFromMap, 128);
            }
        }
    }

    private static void a(Throwable th, PrintWriter printWriter, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        Throwable th2 = th;
        PrintWriter printWriter2 = printWriter;
        String str3 = str2;
        Set<Throwable> set2 = set;
        int i2 = i;
        if (set2.contains(th2)) {
            printWriter2.println("\t[CIRCULAR REFERENCE:" + th2 + "]");
            return;
        }
        set2.add(th2);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i2;
        printWriter2.println(str3 + str + th2);
        int length = stackTrace.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            if (z && i4 > i2) {
                printWriter2.println("\t... skip " + ((stackTrace.length - i4) - (i2 / 2)) + " lines");
                break;
            }
            printWriter2.println("\tat " + stackTraceElement);
            i4++;
            i3++;
        }
        if (z) {
            for (int length2 = stackTrace.length - (i2 / 2); length2 < stackTrace.length; length2++) {
                printWriter2.println("\tat " + stackTrace[length2]);
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable a2 : th.getSuppressed()) {
                int i5 = i2 / 2;
                a(a2, printWriter, stackTrace, "Suppressed: ", str3 + "\t", set, i5 > 10 ? i5 : 10);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i6 = i2 / 2;
            a(cause, printWriter, stackTrace, "Caused by: ", str2, set, i6 > 10 ? i6 : 10);
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list) {
        if (th != null && list != null) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            list.add(a);
            StackTraceElement[] stackTrace = th.getStackTrace();
            boolean z = stackTrace.length > 384;
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (z && i2 > 256) {
                    list.add(a);
                    break;
                }
                list.add(stackTraceElement);
                i2++;
                i++;
            }
            if (z) {
                for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                    list.add(stackTrace[length2]);
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable a2 : th.getSuppressed()) {
                    a(a2, list, stackTrace, "Suppressed: ", "\t", (Set<Throwable>) newSetFromMap, 128);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, list, stackTrace, "Caused by: ", "", (Set<Throwable>) newSetFromMap, 128);
            }
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        Throwable th2 = th;
        List<StackTraceElement> list2 = list;
        Set<Throwable> set2 = set;
        int i2 = i;
        if (set2.contains(th2)) {
            list2.add(a);
            return;
        }
        set2.add(th2);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i2;
        list2.add(a);
        int length = stackTrace.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            if (z && i4 > i2) {
                list2.add(a);
                break;
            }
            list2.add(stackTraceElement);
            i4++;
            i3++;
        }
        if (z) {
            for (int length2 = stackTrace.length - (i2 / 2); length2 < stackTrace.length; length2++) {
                list2.add(stackTrace[length2]);
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable a2 : th.getSuppressed()) {
                int i5 = i2 / 2;
                a(a2, list, stackTrace, "Suppressed: ", str2 + "\t", set, i5 > 10 ? i5 : 10);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i6 = i2 / 2;
            a(cause, list, stackTrace, "Caused by: ", str2, set, i6 > 10 ? i6 : 10);
        }
    }

    public static boolean a(String str, String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String contains : strArr) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONObject b(String str) {
        boolean z;
        String str2 = str;
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry next : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread thread = (Thread) next.getKey();
                String name = thread.getName();
                if (!c(name)) {
                    if (str2 != null) {
                        if (!str2.equals(name) && !name.startsWith(str2)) {
                            if (name.endsWith(str2)) {
                            }
                        }
                    }
                    jSONObject2.put("thread_name", thread.getName() + "(" + thread.getId() + ")");
                    StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
                    if (stackTraceElementArr != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                            jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        z = jSONArray2.length() > 0;
                    } else {
                        z = true;
                    }
                    if (z) {
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void b(Throwable th, int i) {
        th.getClass().getName();
        String localizedMessage = th.getLocalizedMessage();
        try {
            a(th.getClass().getName(), i);
            if (localizedMessage != null) {
                a(": ", i);
                a(localizedMessage, i);
            }
            a("\n", i);
        } catch (Throwable unused) {
        }
    }

    public static StackTraceElement[] b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        try {
            a(th, (List<StackTraceElement>) arrayList);
        } catch (Throwable unused) {
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    private static void c(Throwable th, int i) {
        if (th != null && i > 0) {
            b(th, i);
            for (StackTraceElement a2 : th.getStackTrace()) {
                a(a2, i);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable a3 : th.getSuppressed()) {
                    a(a3, i, "Suppressed: ", "\t");
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, i, "Caused by: ", "");
            }
        }
    }

    private static boolean c(String str) {
        Set<String> a2 = j.a();
        if (a2.contains(str)) {
            return true;
        }
        for (String next : a2) {
            if (!TextUtils.isEmpty(str) && str.startsWith(next)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if ((th instanceof OutOfMemoryError) && (th.getMessage().contains("allocate") || th.getMessage().contains("thrown"))) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
                return true;
            }
        }
        return false;
    }
}
