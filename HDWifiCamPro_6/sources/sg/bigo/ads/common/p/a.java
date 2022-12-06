package sg.bigo.ads.common.p;

import java.io.File;
import java.io.FileFilter;
import sg.bigo.ads.common.n.b;

public final class a {
    private static boolean a = false;
    private static boolean b = false;
    private static int c = 1;
    private static long d;

    /* renamed from: sg.bigo.ads.common.p.a$a  reason: collision with other inner class name */
    final class C0126a implements FileFilter {
        C0126a() {
        }

        public final boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static int a() {
        if (a) {
            return c;
        }
        int intValue = ((Integer) b.b("sp_cpu_core_num", 0, 0)).intValue();
        c = intValue;
        if (intValue != 0) {
            a = true;
        } else {
            try {
                c = new File("/sys/devices/system/cpu/").listFiles(new C0126a()).length;
            } catch (Throwable unused) {
            }
            if (c <= 1) {
                c = Runtime.getRuntime().availableProcessors();
            }
            a = true;
            b.a("sp_cpu_core_num", Integer.valueOf(c), 0);
        }
        return c;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0088 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00df */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long b() {
        /*
            boolean r0 = b
            r1 = 0
            if (r0 == 0) goto L_0x000d
            long r3 = d
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x000d
            return r3
        L_0x000d:
            java.lang.Long r0 = java.lang.Long.valueOf(r1)
            java.lang.String r3 = "sp_cpu_max_freq"
            r4 = 1
            java.lang.Object r0 = sg.bigo.ads.common.n.b.b(r3, r0, r4)
            java.lang.Long r0 = (java.lang.Long) r0
            long r5 = r0.longValue()
            d = r5
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0029
            b = r4
        L_0x0026:
            long r0 = d
            return r0
        L_0x0029:
            r0 = -1
            r1 = 0
            r5 = r0
            r2 = r1
        L_0x002d:
            int r6 = a()     // Catch:{ Exception -> 0x00ee }
            if (r2 >= r6) goto L_0x0094
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ee }
            java.lang.String r7 = "/sys/devices/system/cpu/cpu"
            r6.<init>(r7)     // Catch:{ Exception -> 0x00ee }
            r6.append(r2)     // Catch:{ Exception -> 0x00ee }
            java.lang.String r7 = "/cpufreq/cpuinfo_max_freq"
            r6.append(r7)     // Catch:{ Exception -> 0x00ee }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00ee }
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00ee }
            r7.<init>(r6)     // Catch:{ Exception -> 0x00ee }
            boolean r6 = r7.exists()     // Catch:{ Exception -> 0x00ee }
            if (r6 == 0) goto L_0x0091
            boolean r6 = r7.canRead()     // Catch:{ Exception -> 0x00ee }
            if (r6 == 0) goto L_0x0091
            r6 = 128(0x80, float:1.794E-43)
            byte[] r8 = new byte[r6]     // Catch:{ Exception -> 0x00ee }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00ee }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00ee }
            r9.read(r8)     // Catch:{ NumberFormatException -> 0x0088, all -> 0x008c }
            r7 = r1
        L_0x0064:
            byte r10 = r8[r7]     // Catch:{ NumberFormatException -> 0x0088, all -> 0x008c }
            boolean r10 = java.lang.Character.isDigit(r10)     // Catch:{ NumberFormatException -> 0x0088, all -> 0x008c }
            if (r10 == 0) goto L_0x0071
            if (r7 >= r6) goto L_0x0071
            int r7 = r7 + 1
            goto L_0x0064
        L_0x0071:
            java.lang.String r6 = new java.lang.String     // Catch:{ NumberFormatException -> 0x0088, all -> 0x008c }
            r6.<init>(r8, r1, r7)     // Catch:{ NumberFormatException -> 0x0088, all -> 0x008c }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x0088, all -> 0x008c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x0088, all -> 0x008c }
            int r7 = r6.intValue()     // Catch:{ NumberFormatException -> 0x0088, all -> 0x008c }
            if (r7 <= r5) goto L_0x0088
            int r5 = r6.intValue()     // Catch:{ NumberFormatException -> 0x0088, all -> 0x008c }
        L_0x0088:
            r9.close()     // Catch:{ Exception -> 0x00ee }
            goto L_0x0091
        L_0x008c:
            r1 = move-exception
            r9.close()     // Catch:{ Exception -> 0x00ee }
            throw r1     // Catch:{ Exception -> 0x00ee }
        L_0x0091:
            int r2 = r2 + 1
            goto L_0x002d
        L_0x0094:
            if (r5 != r0) goto L_0x00ef
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x00ee }
            java.lang.String r6 = "/proc/cpuinfo"
            r2.<init>(r6)     // Catch:{ Exception -> 0x00ee }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ee }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00ee }
        L_0x00a2:
            java.lang.String r7 = r6.readLine()     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            if (r7 == 0) goto L_0x00df
            java.lang.String r8 = ":"
            r9 = 2
            java.lang.String[] r7 = r7.split(r8, r9)     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            java.lang.String r8 = "cpu MHz"
            r9 = r7[r1]     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            java.lang.String r10 = "[\\t\\n\\r]"
            java.lang.String r11 = ""
            java.lang.String r9 = r9.replaceAll(r10, r11)     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            if (r8 == 0) goto L_0x00a2
            r8 = r7[r4]     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            java.lang.String r9 = "."
            boolean r8 = r8.contains(r9)     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            if (r8 == 0) goto L_0x00d3
            r7 = r7[r4]     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            double r7 = java.lang.Double.parseDouble(r7)     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            int r7 = (int) r7     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            goto L_0x00d9
        L_0x00d3:
            r7 = r7[r4]     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x00df, all -> 0x00e6 }
        L_0x00d9:
            int r7 = r7 * 1000
            if (r7 <= r5) goto L_0x00a2
            r5 = r7
            goto L_0x00a2
        L_0x00df:
            r2.close()     // Catch:{ Exception -> 0x00ee }
            r6.close()     // Catch:{ Exception -> 0x00ee }
            goto L_0x00ef
        L_0x00e6:
            r1 = move-exception
            r2.close()     // Catch:{ Exception -> 0x00ee }
            r6.close()     // Catch:{ Exception -> 0x00ee }
            throw r1     // Catch:{ Exception -> 0x00ee }
        L_0x00ee:
            r5 = r0
        L_0x00ef:
            b = r4
            int r5 = r5 / 1000
            long r0 = (long) r5
            d = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            sg.bigo.ads.common.n.b.a(r3, r0, r4)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.p.a.b():long");
    }
}
