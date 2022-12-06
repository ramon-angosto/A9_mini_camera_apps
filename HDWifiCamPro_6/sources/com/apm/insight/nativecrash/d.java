package com.apm.insight.nativecrash;

import com.apm.insight.b;
import com.apm.insight.l.k;
import com.apm.insight.l.o;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d {
    private static final Pattern i = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    private static final Pattern j = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
    private static final Pattern k = Pattern.compile("^Abort message: (.*)$");
    private static final Pattern l = Pattern.compile("^Crash message: (.*)$");
    private static final Pattern m = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Map<String, String> h = new HashMap();

    public d(File file) {
        b(o.b(file));
    }

    private void b(File file) {
        BufferedReader bufferedReader;
        String str;
        if (file.exists() && file.length() != 0) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                int i2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null || i2 >= 64) {
                            break;
                        }
                        if (this.a != null || !readLine.startsWith("pid: ")) {
                            if (this.e == null) {
                                if (readLine.startsWith("signal ")) {
                                    Matcher matcher = j.matcher(readLine);
                                    if (matcher.find() && matcher.groupCount() == 3) {
                                        String replace = matcher.group(1).replace(" ", "");
                                        String replace2 = matcher.group(2).replace(" ", "");
                                        int indexOf = replace2.indexOf("frompid");
                                        if (indexOf > 0) {
                                            replace2 = replace2.substring(0, indexOf) + ")";
                                        }
                                        this.e = "Signal " + replace + ", Code " + replace2 + "\n";
                                    }
                                }
                            }
                            if (this.f == null && readLine.startsWith("Abort ")) {
                                Matcher matcher2 = k.matcher(readLine);
                                if (matcher2.find() && matcher2.groupCount() == 1) {
                                    str = "abort message: " + matcher2.group(1) + "\n";
                                }
                            } else if (this.f == null && readLine.startsWith("Crash ")) {
                                Matcher matcher3 = l.matcher(readLine);
                                if (matcher3.find() && matcher3.groupCount() == 1) {
                                    str = "crash message: " + matcher3.group(1) + "\n";
                                }
                            } else if (this.g == null && readLine.startsWith("backtrace:")) {
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String readLine2 = bufferedReader.readLine();
                                    if (readLine2 == null || !readLine2.startsWith("    #")) {
                                        i2++;
                                        this.g = sb.toString();
                                    } else {
                                        sb.append(readLine2.substring(4));
                                        sb.append(10);
                                    }
                                }
                                i2++;
                                this.g = sb.toString();
                            } else if (this.h.isEmpty() && readLine.startsWith("build id:")) {
                                while (true) {
                                    String readLine3 = bufferedReader.readLine();
                                    if (readLine3 == null) {
                                        break;
                                    } else if (!readLine3.contains("BuildId:")) {
                                        break;
                                    } else {
                                        Matcher matcher4 = m.matcher(readLine3);
                                        if (matcher4.find()) {
                                            String group = matcher4.group(1);
                                            String group2 = matcher4.group(2);
                                            String group3 = matcher4.group(3);
                                            if (group.equals(DataSchemeDataSource.SCHEME_DATA)) {
                                                this.h.put(group2, group3);
                                            }
                                        }
                                    }
                                }
                            }
                            this.f = str;
                        } else {
                            Matcher matcher5 = i.matcher(readLine);
                            if (matcher5.find() && matcher5.groupCount() == 4) {
                                this.a = matcher5.group(1);
                                this.b = matcher5.group(2);
                                this.d = matcher5.group(3);
                                this.c = matcher5.group(4);
                            }
                        }
                        i2++;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            b.a().a("NPTH_CATCH", th);
                            k.a((Closeable) bufferedReader);
                        } catch (Throwable th2) {
                            k.a((Closeable) bufferedReader);
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                b.a().a("NPTH_CATCH", th);
                k.a((Closeable) bufferedReader);
            }
            k.a((Closeable) bufferedReader);
        }
    }

    public String a() {
        return this.g;
    }

    public void a(File file) {
        File b2 = o.b(file);
        if (b2.exists()) {
            b2.renameTo(new File(b2.getAbsoluteFile() + ".old"));
        }
        NativeImpl.a(file);
        b(o.b(file));
    }

    public Map<String, String> b() {
        return this.h;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        String str = this.e;
        if (str != null) {
            sb.append(str);
        }
        String str2 = this.f;
        if (str2 != null) {
            sb.append(str2);
        }
        String str3 = this.g;
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }
}
