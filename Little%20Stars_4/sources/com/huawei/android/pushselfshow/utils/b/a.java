package com.huawei.android.pushselfshow.utils.b;

import com.google.zxing.common.StringUtils;
import com.huawei.android.pushagent.c.a.e;
import java.io.File;

public class a {
    private String a;
    private String b;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static File a(String str, String str2) {
        String[] split = str2.split("/");
        File file = new File(str);
        int i = 0;
        while (i < split.length - 1) {
            try {
                i++;
                file = new File(file, new String(split[i].getBytes("8859_1"), StringUtils.GB2312));
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return file;
            }
        }
        e.a("PushSelfShowLog", "file1 = " + file);
        if (!file.exists() && !file.mkdirs()) {
            e.a("PushSelfShowLog", "ret.mkdirs faild");
        }
        String str3 = new String(split[split.length - 1].getBytes("8859_1"), StringUtils.GB2312);
        e.a("PushSelfShowLog", "substr = " + str3);
        File file2 = new File(file, str3);
        try {
            e.a("PushSelfShowLog", "file2 = " + file2);
            return file2;
        } catch (Exception e2) {
            file = file2;
            e = e2;
            e.printStackTrace();
            return file;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v28, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v35, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v36, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v38, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v55, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v59, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v39, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v41, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0276, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0277, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "zFileIn.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0294, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0295, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "is.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02b3, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "os.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02d1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02d2, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:?, code lost:
        r1 = "tempFOS.close error:" + r1.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x030c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x030d, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "zFileIn.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x032a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x032b, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "is.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0348, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0349, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "os.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0367, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0368, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:?, code lost:
        r1 = "tempFOS.close error:" + r1.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x03c0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x03c1, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "is.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x03de, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x03df, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "os.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x03fc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x03fd, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:?, code lost:
        r1 = "tempFOS.close error:" + r1.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0427, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0428, code lost:
        r1 = r0;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x042d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x042e, code lost:
        r1 = r0;
        r11 = r2;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0434, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0435, code lost:
        r1 = r0;
        r11 = r2;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x043b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x043c, code lost:
        r1 = r0;
        r11 = r2;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0442, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0443, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "zFileIn.close error:" + r3.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x045b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x045c, code lost:
        r1 = r0;
        r11 = r2;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0468, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0469, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "is.close error:" + r3.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0486, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0487, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "os.close error:" + r3.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x04a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x04a5, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "tempFOS.close error:" + r3.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x04d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x04d8, code lost:
        r1 = r0;
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x04dc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x04dd, code lost:
        r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x04e4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x04e5, code lost:
        r1 = r0;
        r11 = r2;
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x04ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x04eb, code lost:
        r1 = r0;
        r11 = r2;
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x04f0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x04f1, code lost:
        r1 = r0;
        r11 = r2;
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x0550, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x0551, code lost:
        r1 = r0;
        r2 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x057a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x057b, code lost:
        r1 = r0;
        r2 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x05ec, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x05ed, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", r3 + r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0181, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0182, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "zFileIn.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x019d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x019e, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "is.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01ba, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "os.close error:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01d7, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r1 = "tempFOS.close error:" + r1.getMessage();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0272 A[SYNTHETIC, Splitter:B:129:0x0272] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0290 A[SYNTHETIC, Splitter:B:136:0x0290] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02ae A[SYNTHETIC, Splitter:B:143:0x02ae] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02cc A[SYNTHETIC, Splitter:B:150:0x02cc] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0308 A[SYNTHETIC, Splitter:B:163:0x0308] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0326 A[SYNTHETIC, Splitter:B:170:0x0326] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0344 A[SYNTHETIC, Splitter:B:177:0x0344] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0362 A[SYNTHETIC, Splitter:B:184:0x0362] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x039e A[SYNTHETIC, Splitter:B:197:0x039e] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03bc A[SYNTHETIC, Splitter:B:204:0x03bc] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x03da A[SYNTHETIC, Splitter:B:211:0x03da] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x03f8 A[SYNTHETIC, Splitter:B:218:0x03f8] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0423 A[SYNTHETIC, Splitter:B:228:0x0423] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0427 A[ExcHandler: all (r0v32 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r16 
      PHI: (r16v6 java.lang.String) = (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String) binds: [B:259:0x04a0, B:263:0x04a6, B:260:?, B:252:0x0482, B:256:0x0488, B:257:?, B:253:?, B:245:0x0464, B:249:0x046a, B:250:?, B:246:?, B:228:0x0423, B:240:0x0444, B:241:?, B:229:?, B:218:0x03f8, B:222:0x03fe, B:219:?, B:211:0x03da, B:215:0x03e0, B:216:?, B:212:?, B:204:0x03bc, B:208:0x03c2, B:209:?, B:205:?, B:197:0x039e, B:201:0x03a4, B:202:?, B:198:?, B:184:0x0362, B:188:0x0369, B:185:?, B:177:0x0344, B:181:0x034a, B:182:?, B:178:?, B:170:0x0326, B:174:0x032c, B:175:?, B:171:?, B:163:0x0308, B:167:0x030e, B:168:?, B:164:?, B:150:0x02cc, B:154:0x02d3, B:151:?, B:143:0x02ae, B:147:0x02b4, B:148:?, B:144:?, B:136:0x0290, B:140:0x0296, B:141:?, B:137:?, B:129:0x0272, B:133:0x0278, B:134:?, B:130:?, B:69:0x0199, B:75:0x01b5, B:81:0x01d1, B:85:0x01d8, B:82:?, B:79:0x01bb, B:80:?, B:76:?, B:73:0x019f, B:74:?, B:70:?, B:63:0x017d, B:67:0x0183, B:68:?, B:64:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:81:0x01d1] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x042d A[ExcHandler: NoSuchElementException (r0v31 'e' java.util.NoSuchElementException A[CUSTOM_DECLARE]), PHI: r16 
      PHI: (r16v5 java.lang.String) = (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String) binds: [B:259:0x04a0, B:263:0x04a6, B:260:?, B:252:0x0482, B:256:0x0488, B:257:?, B:253:?, B:245:0x0464, B:249:0x046a, B:250:?, B:246:?, B:228:0x0423, B:240:0x0444, B:241:?, B:229:?, B:218:0x03f8, B:222:0x03fe, B:219:?, B:211:0x03da, B:215:0x03e0, B:216:?, B:212:?, B:204:0x03bc, B:208:0x03c2, B:209:?, B:205:?, B:197:0x039e, B:201:0x03a4, B:202:?, B:198:?, B:184:0x0362, B:188:0x0369, B:185:?, B:177:0x0344, B:181:0x034a, B:182:?, B:178:?, B:170:0x0326, B:174:0x032c, B:175:?, B:171:?, B:163:0x0308, B:167:0x030e, B:168:?, B:164:?, B:150:0x02cc, B:154:0x02d3, B:151:?, B:143:0x02ae, B:147:0x02b4, B:148:?, B:144:?, B:136:0x0290, B:140:0x0296, B:141:?, B:137:?, B:129:0x0272, B:133:0x0278, B:134:?, B:130:?, B:69:0x0199, B:75:0x01b5, B:81:0x01d1, B:85:0x01d8, B:82:?, B:79:0x01bb, B:80:?, B:76:?, B:73:0x019f, B:74:?, B:70:?, B:63:0x017d, B:67:0x0183, B:68:?, B:64:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:63:0x017d] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0434 A[ExcHandler: IllegalStateException (r0v30 'e' java.lang.IllegalStateException A[CUSTOM_DECLARE]), PHI: r16 
      PHI: (r16v4 java.lang.String) = (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String) binds: [B:259:0x04a0, B:263:0x04a6, B:260:?, B:252:0x0482, B:256:0x0488, B:257:?, B:253:?, B:245:0x0464, B:249:0x046a, B:250:?, B:246:?, B:228:0x0423, B:240:0x0444, B:241:?, B:229:?, B:218:0x03f8, B:222:0x03fe, B:219:?, B:211:0x03da, B:215:0x03e0, B:216:?, B:212:?, B:204:0x03bc, B:208:0x03c2, B:209:?, B:205:?, B:197:0x039e, B:201:0x03a4, B:202:?, B:198:?, B:184:0x0362, B:188:0x0369, B:185:?, B:177:0x0344, B:181:0x034a, B:182:?, B:178:?, B:170:0x0326, B:174:0x032c, B:175:?, B:171:?, B:163:0x0308, B:167:0x030e, B:168:?, B:164:?, B:150:0x02cc, B:154:0x02d3, B:151:?, B:143:0x02ae, B:147:0x02b4, B:148:?, B:144:?, B:136:0x0290, B:140:0x0296, B:141:?, B:137:?, B:129:0x0272, B:133:0x0278, B:134:?, B:130:?, B:69:0x0199, B:75:0x01b5, B:81:0x01d1, B:85:0x01d8, B:82:?, B:79:0x01bb, B:80:?, B:76:?, B:73:0x019f, B:74:?, B:70:?, B:63:0x017d, B:67:0x0183, B:68:?, B:64:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:63:0x017d] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x043b A[ExcHandler: ZipException (r0v29 'e' java.util.zip.ZipException A[CUSTOM_DECLARE]), PHI: r16 
      PHI: (r16v3 java.lang.String) = (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v7 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v10 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v14 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v18 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String), (r16v38 java.lang.String) binds: [B:259:0x04a0, B:263:0x04a6, B:260:?, B:252:0x0482, B:256:0x0488, B:257:?, B:253:?, B:245:0x0464, B:249:0x046a, B:250:?, B:246:?, B:228:0x0423, B:240:0x0444, B:241:?, B:229:?, B:218:0x03f8, B:222:0x03fe, B:219:?, B:211:0x03da, B:215:0x03e0, B:216:?, B:212:?, B:204:0x03bc, B:208:0x03c2, B:209:?, B:205:?, B:197:0x039e, B:201:0x03a4, B:202:?, B:198:?, B:184:0x0362, B:188:0x0369, B:185:?, B:177:0x0344, B:181:0x034a, B:182:?, B:178:?, B:170:0x0326, B:174:0x032c, B:175:?, B:171:?, B:163:0x0308, B:167:0x030e, B:168:?, B:164:?, B:150:0x02cc, B:154:0x02d3, B:151:?, B:143:0x02ae, B:147:0x02b4, B:148:?, B:144:?, B:136:0x0290, B:140:0x0296, B:141:?, B:137:?, B:129:0x0272, B:133:0x0278, B:134:?, B:130:?, B:69:0x0199, B:75:0x01b5, B:81:0x01d1, B:85:0x01d8, B:82:?, B:79:0x01bb, B:80:?, B:76:?, B:73:0x019f, B:74:?, B:70:?, B:63:0x017d, B:67:0x0183, B:68:?, B:64:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:63:0x017d] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0464 A[SYNTHETIC, Splitter:B:245:0x0464] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0482 A[SYNTHETIC, Splitter:B:252:0x0482] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04a0 A[SYNTHETIC, Splitter:B:259:0x04a0] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04d7 A[ExcHandler: all (r0v22 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:22:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x054b A[SYNTHETIC, Splitter:B:311:0x054b] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0575 A[SYNTHETIC, Splitter:B:321:0x0575] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x059e A[SYNTHETIC, Splitter:B:331:0x059e] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x05c6 A[SYNTHETIC, Splitter:B:341:0x05c6] */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x05e8 A[SYNTHETIC, Splitter:B:349:0x05e8] */
    /* JADX WARNING: Removed duplicated region for block: B:365:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:366:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:367:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:368:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:308:0x0531=Splitter:B:308:0x0531, B:328:0x0586=Splitter:B:328:0x0586, B:318:0x055d=Splitter:B:318:0x055d, B:338:0x05ae=Splitter:B:338:0x05ae} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r2 = "/"
            java.lang.String r3 = "os.write error:"
            java.lang.String r4 = "upZipFile error:"
            java.lang.String r5 = "tempFOS.close error:"
            java.lang.String r6 = "os.close error:"
            java.lang.String r7 = "is.close error:"
            java.lang.String r8 = "zFileIn.close error:"
            java.lang.String r9 = "zfile.close error:"
            java.lang.String r10 = "PushSelfShowLog"
            java.lang.String r12 = r1.b     // Catch:{ ZipException -> 0x05aa, IOException -> 0x0582, IllegalStateException -> 0x0559, NoSuchElementException -> 0x052b, all -> 0x0525 }
            boolean r12 = r12.endsWith(r2)     // Catch:{ ZipException -> 0x05aa, IOException -> 0x0582, IllegalStateException -> 0x0559, NoSuchElementException -> 0x052b, all -> 0x0525 }
            if (r12 != 0) goto L_0x004b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0046, IOException -> 0x0041, IllegalStateException -> 0x003c, NoSuchElementException -> 0x0035, all -> 0x0030 }
            r12.<init>()     // Catch:{ ZipException -> 0x0046, IOException -> 0x0041, IllegalStateException -> 0x003c, NoSuchElementException -> 0x0035, all -> 0x0030 }
            java.lang.String r13 = r1.b     // Catch:{ ZipException -> 0x0046, IOException -> 0x0041, IllegalStateException -> 0x003c, NoSuchElementException -> 0x0035, all -> 0x0030 }
            r12.append(r13)     // Catch:{ ZipException -> 0x0046, IOException -> 0x0041, IllegalStateException -> 0x003c, NoSuchElementException -> 0x0035, all -> 0x0030 }
            r12.append(r2)     // Catch:{ ZipException -> 0x0046, IOException -> 0x0041, IllegalStateException -> 0x003c, NoSuchElementException -> 0x0035, all -> 0x0030 }
            java.lang.String r2 = r12.toString()     // Catch:{ ZipException -> 0x0046, IOException -> 0x0041, IllegalStateException -> 0x003c, NoSuchElementException -> 0x0035, all -> 0x0030 }
            r1.b = r2     // Catch:{ ZipException -> 0x0046, IOException -> 0x0041, IllegalStateException -> 0x003c, NoSuchElementException -> 0x0035, all -> 0x0030 }
            goto L_0x004b
        L_0x0030:
            r0 = move-exception
            r1 = r0
            r3 = r9
            goto L_0x0528
        L_0x0035:
            r0 = move-exception
            r1 = r0
            r18 = r4
            r3 = r9
            goto L_0x0530
        L_0x003c:
            r0 = move-exception
            r1 = r0
            r3 = r9
            goto L_0x055c
        L_0x0041:
            r0 = move-exception
            r1 = r0
            r3 = r9
            goto L_0x0585
        L_0x0046:
            r0 = move-exception
            r1 = r0
            r3 = r9
            goto L_0x05ad
        L_0x004b:
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x05aa, IOException -> 0x0582, IllegalStateException -> 0x0559, NoSuchElementException -> 0x052b, all -> 0x0525 }
            java.io.File r12 = new java.io.File     // Catch:{ ZipException -> 0x05aa, IOException -> 0x0582, IllegalStateException -> 0x0559, NoSuchElementException -> 0x052b, all -> 0x0525 }
            java.lang.String r13 = r1.a     // Catch:{ ZipException -> 0x05aa, IOException -> 0x0582, IllegalStateException -> 0x0559, NoSuchElementException -> 0x052b, all -> 0x0525 }
            r12.<init>(r13)     // Catch:{ ZipException -> 0x05aa, IOException -> 0x0582, IllegalStateException -> 0x0559, NoSuchElementException -> 0x052b, all -> 0x0525 }
            r2.<init>(r12)     // Catch:{ ZipException -> 0x05aa, IOException -> 0x0582, IllegalStateException -> 0x0559, NoSuchElementException -> 0x052b, all -> 0x0525 }
            java.util.Enumeration r12 = r2.entries()     // Catch:{ ZipException -> 0x051f, IOException -> 0x0519, IllegalStateException -> 0x0514, NoSuchElementException -> 0x050d, all -> 0x0508 }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r14 = new byte[r13]     // Catch:{ ZipException -> 0x051f, IOException -> 0x0519, IllegalStateException -> 0x0514, NoSuchElementException -> 0x050d, all -> 0x0508 }
        L_0x005f:
            boolean r15 = r12.hasMoreElements()     // Catch:{ ZipException -> 0x051f, IOException -> 0x0519, IllegalStateException -> 0x0514, NoSuchElementException -> 0x050d, all -> 0x0508 }
            if (r15 == 0) goto L_0x04f6
            java.lang.Object r15 = r12.nextElement()     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            java.util.zip.ZipEntry r15 = (java.util.zip.ZipEntry) r15     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            boolean r16 = r15.isDirectory()     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            java.lang.String r11 = "ze.getName() = "
            if (r16 == 0) goto L_0x00d5
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            r13.<init>()     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            r13.append(r11)     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            r17 = r12
            java.lang.String r12 = r15.getName()     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            r13.append(r12)     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            java.lang.String r12 = r13.toString()     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            com.huawei.android.pushagent.c.a.e.a(r10, r12)     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            r12.<init>()     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            java.lang.String r13 = r1.b     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            r12.append(r13)     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            java.lang.String r13 = r15.getName()     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            r12.append(r13)     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            java.lang.String r12 = r12.toString()     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            java.lang.String r13 = new java.lang.String     // Catch:{ ZipException -> 0x04f0, IOException -> 0x04ea, IllegalStateException -> 0x04e4, NoSuchElementException -> 0x04dc, all -> 0x04d7 }
            r18 = r4
            java.lang.String r4 = "8859_1"
            byte[] r4 = r12.getBytes(r4)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.String r12 = "GB2312"
            r13.<init>(r4, r12)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            r4.<init>()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.String r12 = "str = "
            r4.append(r12)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            r4.append(r13)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.String r4 = r4.toString()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            com.huawei.android.pushagent.c.a.e.a(r10, r4)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.io.File r4 = new java.io.File     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            r4.<init>(r13)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            boolean r4 = r4.mkdir()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            if (r4 == 0) goto L_0x00d9
            r12 = r17
            r4 = r18
            r13 = 1024(0x400, float:1.435E-42)
            goto L_0x005f
        L_0x00d5:
            r18 = r4
            r17 = r12
        L_0x00d9:
            java.lang.String r4 = r1.b     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.String r12 = r15.getName()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.io.File r4 = a(r4, r12)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            boolean r12 = r4.isDirectory()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            if (r12 == 0) goto L_0x0106
            r2.close()     // Catch:{ IOException -> 0x00ed }
            goto L_0x0105
        L_0x00ed:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.huawei.android.pushagent.c.a.e.a(r10, r2)
        L_0x0105:
            return
        L_0x0106:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            r12.<init>()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            r12.append(r11)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.String r11 = r15.getName()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            r12.append(r11)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.String r11 = ",output file :"
            r12.append(r11)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.String r11 = r4.getAbsolutePath()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            r12.append(r11)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.String r11 = r12.toString()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            com.huawei.android.pushagent.c.a.e.a(r10, r11)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            java.lang.String r11 = r15.getName()     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            if (r11 == 0) goto L_0x0154
            java.lang.String r3 = "ze.getName() is empty= "
            com.huawei.android.pushagent.c.a.e.a(r10, r3)     // Catch:{ ZipException -> 0x04cf, IOException -> 0x04c7, IllegalStateException -> 0x04bf, NoSuchElementException -> 0x04bd, all -> 0x04d7 }
            r2.close()     // Catch:{ IOException -> 0x013b }
            goto L_0x0153
        L_0x013b:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.huawei.android.pushagent.c.a.e.a(r10, r2)
        L_0x0153:
            return
        L_0x0154:
            java.io.InputStream r11 = r2.getInputStream(r15)     // Catch:{ IOException -> 0x037e, IllegalStateException -> 0x02e8, IndexOutOfBoundsException -> 0x0252, all -> 0x0248 }
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0241, IllegalStateException -> 0x023a, IndexOutOfBoundsException -> 0x0234, all -> 0x022e }
            r12.<init>(r4)     // Catch:{ IOException -> 0x0241, IllegalStateException -> 0x023a, IndexOutOfBoundsException -> 0x0234, all -> 0x022e }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0227, IllegalStateException -> 0x0220, IndexOutOfBoundsException -> 0x021a, all -> 0x0214 }
            r4.<init>(r12)     // Catch:{ IOException -> 0x0227, IllegalStateException -> 0x0220, IndexOutOfBoundsException -> 0x021a, all -> 0x0214 }
            java.io.BufferedInputStream r13 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x020e, IllegalStateException -> 0x0208, IndexOutOfBoundsException -> 0x0202, all -> 0x01fc }
            r13.<init>(r11)     // Catch:{ IOException -> 0x020e, IllegalStateException -> 0x0208, IndexOutOfBoundsException -> 0x0202, all -> 0x01fc }
        L_0x0167:
            r15 = 0
            r16 = r9
            r1 = 1024(0x400, float:1.435E-42)
            int r9 = r13.read(r14, r15, r1)     // Catch:{ IOException -> 0x01f8, IllegalStateException -> 0x01f4, IndexOutOfBoundsException -> 0x01f0 }
            r1 = -1
            if (r9 == r1) goto L_0x017b
            r4.write(r14, r15, r9)     // Catch:{ IOException -> 0x01f8, IllegalStateException -> 0x01f4, IndexOutOfBoundsException -> 0x01f0 }
            r1 = r19
            r9 = r16
            goto L_0x0167
        L_0x017b:
            if (r11 == 0) goto L_0x0199
            r11.close()     // Catch:{ IOException -> 0x0181, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0199
        L_0x0181:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r8)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r9.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x0199:
            r13.close()     // Catch:{ IOException -> 0x019d, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x01b5
        L_0x019d:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r7)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r9.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x01b5:
            r4.close()     // Catch:{ IOException -> 0x01b9, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x01d1
        L_0x01b9:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r6)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x01d1:
            r12.close()     // Catch:{ IOException -> 0x01d6, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0413
        L_0x01d6:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r5)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x01eb:
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0413
        L_0x01f0:
            r0 = move-exception
            r1 = r0
            goto L_0x025a
        L_0x01f4:
            r0 = move-exception
            r1 = r0
            goto L_0x02f0
        L_0x01f8:
            r0 = move-exception
            r1 = r0
            goto L_0x0386
        L_0x01fc:
            r0 = move-exception
            r16 = r9
            r1 = r0
            goto L_0x024f
        L_0x0202:
            r0 = move-exception
            r16 = r9
            r1 = r0
            goto L_0x0259
        L_0x0208:
            r0 = move-exception
            r16 = r9
            r1 = r0
            goto L_0x02ef
        L_0x020e:
            r0 = move-exception
            r16 = r9
            r1 = r0
            goto L_0x0385
        L_0x0214:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            goto L_0x024f
        L_0x021a:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            goto L_0x0259
        L_0x0220:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            goto L_0x02ef
        L_0x0227:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            goto L_0x0385
        L_0x022e:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            goto L_0x024e
        L_0x0234:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            goto L_0x0258
        L_0x023a:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            goto L_0x02ee
        L_0x0241:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            goto L_0x0384
        L_0x0248:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            r11 = 0
        L_0x024e:
            r12 = 0
        L_0x024f:
            r13 = 0
            goto L_0x0421
        L_0x0252:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            r11 = 0
        L_0x0258:
            r12 = 0
        L_0x0259:
            r13 = 0
        L_0x025a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x041f }
            r9.<init>()     // Catch:{ all -> 0x041f }
            r9.append(r3)     // Catch:{ all -> 0x041f }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x041f }
            r9.append(r1)     // Catch:{ all -> 0x041f }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x041f }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ all -> 0x041f }
            if (r11 == 0) goto L_0x028e
            r11.close()     // Catch:{ IOException -> 0x0276, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x028e
        L_0x0276:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r8)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r9.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x028e:
            if (r13 == 0) goto L_0x02ac
            r13.close()     // Catch:{ IOException -> 0x0294, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x02ac
        L_0x0294:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r7)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r9.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x02ac:
            if (r4 == 0) goto L_0x02ca
            r4.close()     // Catch:{ IOException -> 0x02b2, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x02ca
        L_0x02b2:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r6)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x02ca:
            if (r12 == 0) goto L_0x0413
            r12.close()     // Catch:{ IOException -> 0x02d1, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0413
        L_0x02d1:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r5)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x01eb
        L_0x02e8:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            r11 = 0
        L_0x02ee:
            r12 = 0
        L_0x02ef:
            r13 = 0
        L_0x02f0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x041f }
            r9.<init>()     // Catch:{ all -> 0x041f }
            r9.append(r3)     // Catch:{ all -> 0x041f }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x041f }
            r9.append(r1)     // Catch:{ all -> 0x041f }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x041f }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ all -> 0x041f }
            if (r11 == 0) goto L_0x0324
            r11.close()     // Catch:{ IOException -> 0x030c, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0324
        L_0x030c:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r8)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r9.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x0324:
            if (r13 == 0) goto L_0x0342
            r13.close()     // Catch:{ IOException -> 0x032a, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0342
        L_0x032a:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r7)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r9.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x0342:
            if (r4 == 0) goto L_0x0360
            r4.close()     // Catch:{ IOException -> 0x0348, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0360
        L_0x0348:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r6)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x0360:
            if (r12 == 0) goto L_0x0413
            r12.close()     // Catch:{ IOException -> 0x0367, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0413
        L_0x0367:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r5)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x01eb
        L_0x037e:
            r0 = move-exception
            r16 = r9
            r1 = r0
            r4 = 0
            r11 = 0
        L_0x0384:
            r12 = 0
        L_0x0385:
            r13 = 0
        L_0x0386:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x041f }
            r9.<init>()     // Catch:{ all -> 0x041f }
            r9.append(r3)     // Catch:{ all -> 0x041f }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x041f }
            r9.append(r1)     // Catch:{ all -> 0x041f }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x041f }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ all -> 0x041f }
            if (r11 == 0) goto L_0x03ba
            r11.close()     // Catch:{ IOException -> 0x03a2, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x03ba
        L_0x03a2:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r8)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r9.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x03ba:
            if (r13 == 0) goto L_0x03d8
            r13.close()     // Catch:{ IOException -> 0x03c0, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x03d8
        L_0x03c0:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r7)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r9.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x03d8:
            if (r4 == 0) goto L_0x03f6
            r4.close()     // Catch:{ IOException -> 0x03de, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x03f6
        L_0x03de:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r6)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x03f6:
            if (r12 == 0) goto L_0x0413
            r12.close()     // Catch:{ IOException -> 0x03fc, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0413
        L_0x03fc:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r5)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r1)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r1 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x01eb
        L_0x0413:
            r13 = 1024(0x400, float:1.435E-42)
            r1 = r19
            r9 = r16
            r12 = r17
            r4 = r18
            goto L_0x005f
        L_0x041f:
            r0 = move-exception
            r1 = r0
        L_0x0421:
            if (r11 == 0) goto L_0x0462
            r11.close()     // Catch:{ IOException -> 0x0442, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0462
        L_0x0427:
            r0 = move-exception
            r1 = r0
            r3 = r16
            goto L_0x05e6
        L_0x042d:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r16
            goto L_0x0531
        L_0x0434:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r16
            goto L_0x04c3
        L_0x043b:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r16
            goto L_0x04d3
        L_0x0442:
            r0 = move-exception
            r3 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r8)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r9.append(r3)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r3 = r9.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r3)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0462
        L_0x045b:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r16
            goto L_0x04cb
        L_0x0462:
            if (r13 == 0) goto L_0x0480
            r13.close()     // Catch:{ IOException -> 0x0468, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x0480
        L_0x0468:
            r0 = move-exception
            r3 = r0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r8.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r8.append(r7)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r8.append(r3)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r3 = r8.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r3)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x0480:
            if (r4 == 0) goto L_0x049e
            r4.close()     // Catch:{ IOException -> 0x0486, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x049e
        L_0x0486:
            r0 = move-exception
            r3 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r6)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r3)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r3 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r3)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x049e:
            if (r12 == 0) goto L_0x04bc
            r12.close()     // Catch:{ IOException -> 0x04a4, ZipException -> 0x043b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            goto L_0x04bc
        L_0x04a4:
            r0 = move-exception
            r3 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.<init>()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r5)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            r4.append(r3)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            java.lang.String r3 = r4.toString()     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
            com.huawei.android.pushagent.c.a.e.a(r10, r3)     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x04bc:
            throw r1     // Catch:{ ZipException -> 0x043b, IOException -> 0x045b, IllegalStateException -> 0x0434, NoSuchElementException -> 0x042d, all -> 0x0427 }
        L_0x04bd:
            r0 = move-exception
            goto L_0x04df
        L_0x04bf:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r9
        L_0x04c3:
            r4 = r18
            goto L_0x055d
        L_0x04c7:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r9
        L_0x04cb:
            r4 = r18
            goto L_0x0586
        L_0x04cf:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r9
        L_0x04d3:
            r4 = r18
            goto L_0x05ae
        L_0x04d7:
            r0 = move-exception
            r1 = r0
            r3 = r9
            goto L_0x05e6
        L_0x04dc:
            r0 = move-exception
            r18 = r4
        L_0x04df:
            r1 = r0
            r11 = r2
            r3 = r9
            goto L_0x0531
        L_0x04e4:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r9
            goto L_0x055d
        L_0x04ea:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r9
            goto L_0x0586
        L_0x04f0:
            r0 = move-exception
            r1 = r0
            r11 = r2
            r3 = r9
            goto L_0x05ae
        L_0x04f6:
            r16 = r9
            r2.close()     // Catch:{ IOException -> 0x04fd }
            goto L_0x05e2
        L_0x04fd:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = r16
            goto L_0x05d1
        L_0x0508:
            r0 = move-exception
            r3 = r9
            r1 = r0
            goto L_0x05e6
        L_0x050d:
            r0 = move-exception
            r18 = r4
            r3 = r9
            r1 = r0
            r11 = r2
            goto L_0x0531
        L_0x0514:
            r0 = move-exception
            r3 = r9
            r1 = r0
            r11 = r2
            goto L_0x055d
        L_0x0519:
            r0 = move-exception
            r3 = r9
            r1 = r0
            r11 = r2
            goto L_0x0586
        L_0x051f:
            r0 = move-exception
            r3 = r9
            r1 = r0
            r11 = r2
            goto L_0x05ae
        L_0x0525:
            r0 = move-exception
            r3 = r9
            r1 = r0
        L_0x0528:
            r2 = 0
            goto L_0x05e6
        L_0x052b:
            r0 = move-exception
            r18 = r4
            r3 = r9
            r1 = r0
        L_0x0530:
            r11 = 0
        L_0x0531:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05e3 }
            r2.<init>()     // Catch:{ all -> 0x05e3 }
            r4 = r18
            r2.append(r4)     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x05e3 }
            r2.append(r1)     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x05e3 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ all -> 0x05e3 }
            if (r11 == 0) goto L_0x05e2
            r11.close()     // Catch:{ IOException -> 0x0550 }
            goto L_0x05e2
        L_0x0550:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x05d1
        L_0x0559:
            r0 = move-exception
            r3 = r9
            r1 = r0
        L_0x055c:
            r11 = 0
        L_0x055d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05e3 }
            r2.<init>()     // Catch:{ all -> 0x05e3 }
            r2.append(r4)     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x05e3 }
            r2.append(r1)     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x05e3 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ all -> 0x05e3 }
            if (r11 == 0) goto L_0x05e2
            r11.close()     // Catch:{ IOException -> 0x057a }
            goto L_0x05e2
        L_0x057a:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x05d1
        L_0x0582:
            r0 = move-exception
            r3 = r9
            r1 = r0
        L_0x0585:
            r11 = 0
        L_0x0586:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05e3 }
            r2.<init>()     // Catch:{ all -> 0x05e3 }
            r2.append(r4)     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x05e3 }
            r2.append(r1)     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x05e3 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ all -> 0x05e3 }
            if (r11 == 0) goto L_0x05e2
            r11.close()     // Catch:{ IOException -> 0x05a2 }
            goto L_0x05e2
        L_0x05a2:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L_0x05d1
        L_0x05aa:
            r0 = move-exception
            r3 = r9
            r1 = r0
        L_0x05ad:
            r11 = 0
        L_0x05ae:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05e3 }
            r2.<init>()     // Catch:{ all -> 0x05e3 }
            r2.append(r4)     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x05e3 }
            r2.append(r1)     // Catch:{ all -> 0x05e3 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x05e3 }
            com.huawei.android.pushagent.c.a.e.a(r10, r1)     // Catch:{ all -> 0x05e3 }
            if (r11 == 0) goto L_0x05e2
            r11.close()     // Catch:{ IOException -> 0x05ca }
            goto L_0x05e2
        L_0x05ca:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L_0x05d1:
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.huawei.android.pushagent.c.a.e.a(r10, r1)
        L_0x05e2:
            return
        L_0x05e3:
            r0 = move-exception
            r1 = r0
            r2 = r11
        L_0x05e6:
            if (r2 == 0) goto L_0x0604
            r2.close()     // Catch:{ IOException -> 0x05ec }
            goto L_0x0604
        L_0x05ec:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r2 = r2.getMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.huawei.android.pushagent.c.a.e.a(r10, r2)
        L_0x0604:
            goto L_0x0606
        L_0x0605:
            throw r1
        L_0x0606:
            goto L_0x0605
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.b.a.a():void");
    }
}
