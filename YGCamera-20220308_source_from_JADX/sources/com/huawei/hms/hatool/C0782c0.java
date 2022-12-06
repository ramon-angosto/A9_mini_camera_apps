package com.huawei.hms.hatool;

import com.huawei.hms.android.HwBuildEx;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.hms.hatool.c0 */
public class C0782c0 {

    /* renamed from: a */
    public String f603a = C0777b.m729f().getFilesDir().getPath();

    /* renamed from: b */
    public static boolean m756b(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    C0841y.m1087c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                m756b(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: d */
    public static boolean m757d() {
        return m756b(new File(C0777b.m729f().getFilesDir().getPath() + "/" + "hms"));
    }

    /* renamed from: a */
    public String mo13923a() {
        String str;
        String str2;
        String str3;
        String str4;
        String c = mo13930c();
        if (mo13929b()) {
            C0841y.m1087c("hmsSdk", "refresh components");
            str = EncryptUtil.generateSecureRandomStr(128);
            mo13925a("aprpap", str);
            str2 = EncryptUtil.generateSecureRandomStr(128);
            mo13925a("febdoc", str2);
            str3 = EncryptUtil.generateSecureRandomStr(128);
            mo13925a("marfil", str3);
            str4 = EncryptUtil.generateSecureRandomStr(128);
            mo13925a("maywnj", str4);
            C0796g0.m833b(C0777b.m729f(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            str = mo13928b("aprpap");
            str2 = mo13928b("febdoc");
            str3 = mo13928b("marfil");
            str4 = mo13928b("maywnj");
        }
        return HexUtil.byteArray2HexStr(PBKDF2.pbkdf2(mo13927a(str, str2, str3, c), HexUtil.hexStr2ByteArray(str4), HwBuildEx.VersionCodes.CUR_DEVELOPMENT, 16));
    }

    /* renamed from: a */
    public final String mo13924a(String str) {
        return this.f603a + "/hms/component/".replace("component", str);
    }

    /* renamed from: a */
    public final void mo13925a(String str, String str2) {
        File file = new File(mo13924a(str));
        String a = mo13924a(str);
        File file2 = new File(a, "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            C0841y.m1087c("hmsSdk", "file directory is mkdirs");
        }
        if (mo13926a(file2)) {
            C0826r0.m1016a(file2, str2);
        } else {
            C0841y.m1092f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    /* renamed from: a */
    public final boolean mo13926a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            C0841y.m1092f("hmsSdk", "create new file error!");
            return false;
        }
    }

    /* renamed from: a */
    public final char[] mo13927a(String str, String str2, String str3, String str4) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        byte[] hexStr2ByteArray4 = HexUtil.hexStr2ByteArray(str4);
        int length = hexStr2ByteArray.length;
        if (length > hexStr2ByteArray2.length) {
            length = hexStr2ByteArray2.length;
        }
        if (length > hexStr2ByteArray3.length) {
            length = hexStr2ByteArray3.length;
        }
        if (length > hexStr2ByteArray4.length) {
            length = hexStr2ByteArray4.length;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((hexStr2ByteArray[i] ^ hexStr2ByteArray2[i]) ^ hexStr2ByteArray3[i]) ^ hexStr2ByteArray4[i]);
        }
        return cArr;
    }

    /* renamed from: b */
    public final String mo13928b(String str) {
        String a = mo13924a(str);
        File file = new File(a, "hianalytics_" + str);
        if (mo13926a(file)) {
            return C0826r0.m1013a(file);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(128);
        C0826r0.m1016a(file, generateSecureRandomStr);
        return generateSecureRandomStr;
    }

    /* renamed from: b */
    public final boolean mo13929b() {
        long a = C0796g0.m828a(C0777b.m729f(), "Privacy_MY", "assemblyFlash", -1);
        if (-1 != a) {
            return System.currentTimeMillis() - a > 31536000000L;
        }
        C0841y.m1087c("hmsSdk", "First init components");
        return true;
    }

    /* renamed from: c */
    public final String mo13930c() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }
}
