package com.huawei.android.pushagent.b.d.a;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import java.util.regex.PatternSyntaxException;

public class a implements b {
    public long a;
    public long b;
    public long c;
    public long d;

    public a() {
    }

    public a(long j, long j2) {
        this.a = j;
        this.b = j2;
        this.c = 0;
        this.d = 0;
    }

    public String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(4);
        stringBuffer.append(";");
        stringBuffer.append(this.a);
        stringBuffer.append(";");
        stringBuffer.append(this.b);
        stringBuffer.append(";");
        stringBuffer.append(this.c);
        stringBuffer.append(";");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d8 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00da A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(long r11) {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "enter FlowSimpleControl::canApply(num:"
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = ", curVol:"
            r0.append(r1)
            long r1 = r10.c
            r0.append(r1)
            java.lang.String r1 = ", maxVol:"
            r0.append(r1)
            long r1 = r10.b
            r0.append(r1)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PushLogAC2705"
            com.huawei.android.pushagent.c.a.e.a(r1, r0)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            long r2 = r0.longValue()
            long r4 = r10.d
            r6 = 0
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x008e
            long r2 = r0.longValue()
            long r4 = r10.d
            long r2 = r2 - r4
            long r4 = r10.a
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x0051
            goto L_0x008e
        L_0x0051:
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            java.util.Calendar r2 = java.util.Calendar.getInstance(r2)     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            long r3 = r10.d     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            r2.setTimeInMillis(r3)     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            r3 = 2
            int r4 = r2.get(r3)     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            long r8 = r0.longValue()     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            r2.setTimeInMillis(r8)     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            int r2 = r2.get(r3)     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            if (r4 == r2) goto L_0x00cf
            long r2 = r0.longValue()     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            r10.d = r2     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            r10.c = r6     // Catch:{ IllegalArgumentException -> 0x0085, ArrayIndexOutOfBoundsException -> 0x007f, Exception -> 0x0079 }
            goto L_0x00cf
        L_0x0079:
            r0 = move-exception
            java.lang.String r2 = r0.toString()
            goto L_0x008a
        L_0x007f:
            r0 = move-exception
            java.lang.String r2 = r0.toString()
            goto L_0x008a
        L_0x0085:
            r0 = move-exception
            java.lang.String r2 = r0.toString()
        L_0x008a:
            com.huawei.android.pushagent.c.a.e.c(r1, r2, r0)
            goto L_0x00cf
        L_0x008e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = " fistrControlTime:"
            r2.append(r3)
            java.util.Date r3 = new java.util.Date
            long r4 = r10.d
            r3.<init>(r4)
            r2.append(r3)
            java.lang.String r3 = " interval:"
            r2.append(r3)
            long r3 = r0.longValue()
            long r8 = r10.d
            long r3 = r3 - r8
            r2.append(r3)
            java.lang.String r3 = " statInterval:"
            r2.append(r3)
            long r3 = r10.a
            r2.append(r3)
            java.lang.String r3 = " change fistrControlTime to cur"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.huawei.android.pushagent.c.a.e.a(r1, r2)
            long r0 = r0.longValue()
            r10.d = r0
            r10.c = r6
        L_0x00cf:
            long r0 = r10.c
            long r0 = r0 + r11
            long r11 = r10.b
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x00da
            r11 = 1
            goto L_0x00db
        L_0x00da:
            r11 = 0
        L_0x00db:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.d.a.a.a(long):boolean");
    }

    public boolean a(b bVar) {
        if (!(bVar instanceof a)) {
            return false;
        }
        a aVar = (a) bVar;
        return this.a == aVar.a && this.b == aVar.b;
    }

    public boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                e.b("PushLogAC2705", "in loadFromString, info is empty!");
                return false;
            }
            e.a("PushLogAC2705", "begin to parse:" + str);
            String[] split = str.split(";");
            if (split.length == 0) {
                return false;
            }
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt == 4) {
                if (parseInt == split.length - 1) {
                    this.a = Long.parseLong(split[1]);
                    this.b = Long.parseLong(split[2]);
                    this.c = Long.parseLong(split[3]);
                    this.d = Long.parseLong(split[4]);
                    return true;
                }
            }
            e.d("PushLogAC2705", "in fileNum:" + parseInt + ", but need " + 4 + " parse " + str + " failed");
            return false;
        } catch (Exception | NumberFormatException | PatternSyntaxException unused) {
        }
    }

    public boolean b(long j) {
        this.c += j;
        return true;
    }
}
