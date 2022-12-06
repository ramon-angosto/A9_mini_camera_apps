package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BksUtil {

    /* renamed from: a */
    private static final String f1219a = "BksUtil";

    /* renamed from: b */
    private static final String f1220b = "com.huawei.hwid";

    /* renamed from: c */
    private static final String f1221c = "com.huawei.hwid";

    /* renamed from: d */
    private static final String f1222d = "com.huawei.hms";

    /* renamed from: e */
    private static final String f1223e = "com.huawei.hwid.tv";

    /* renamed from: f */
    private static final Uri f1224f = Uri.parse("content://com.huawei.hwid");

    /* renamed from: g */
    private static final String f1225g = "files/hmsrootcas.bks";

    /* renamed from: h */
    private static final String f1226h = "4.0.2.300";

    /* renamed from: i */
    private static final String f1227i = "aegis";

    /* renamed from: j */
    private static final String f1228j = "hmsrootcas.bks";

    /* renamed from: k */
    private static final long f1229k = 604800000;

    /* renamed from: l */
    private static final String f1230l = "last_update_time";

    /* renamed from: m */
    private static final String f1231m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";

    /* renamed from: n */
    private static final String f1232n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";

    /* renamed from: o */
    private static final String f1233o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";

    /* renamed from: p */
    private static final String[] f1234p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", f1233o};

    /* renamed from: q */
    private static final String f1235q = "";

    /* renamed from: r */
    private static final String f1236r = "bks_hash";

    private BksUtil() {
    }

    /* renamed from: a */
    private static void m1535a(InputStream inputStream, Context context) {
        if (inputStream != null && context != null) {
            String a = m1533a(context);
            if (!new File(a).exists()) {
                m1532a(a);
            }
            File file = new File(a, "hmsrootcas.bks");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = null;
            try {
                C0946g.m1580c(f1219a, "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, bArr.length);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            C0945f.m1571a((OutputStream) fileOutputStream2);
                            return;
                        }
                    }
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        C0946g.m1579b(f1219a, " IOException");
                        C0945f.m1571a((OutputStream) fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        C0945f.m1571a((OutputStream) fileOutputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C0945f.m1571a((OutputStream) fileOutputStream2);
                    throw th;
                }
            } catch (IOException unused2) {
                C0946g.m1579b(f1219a, " IOException");
                C0945f.m1571a((OutputStream) fileOutputStream);
            }
        }
    }

    /* renamed from: a */
    private static boolean m1536a(int i) {
        return i >= 40002300;
    }

    /* renamed from: b */
    private static String m1538b(Context context) {
        return m1533a(context) + File.separator + "hmsrootcas.bks";
    }

    /* renamed from: c */
    private static boolean m1543c(Context context) {
        return new File(m1533a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    public static synchronized InputStream getBksFromTss(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream;
        synchronized (BksUtil.class) {
            C0946g.m1580c(f1219a, "get bks from tss begin");
            if (context != null) {
                C0942c.m1557a(context);
            }
            Context a = C0942c.m1556a();
            ByteArrayInputStream byteArrayInputStream2 = null;
            if (a == null) {
                C0946g.m1579b(f1219a, "context is null");
                return null;
            } else if (!m1541b(C0947h.m1583a("com.huawei.hwid")) && !m1541b(C0947h.m1583a("com.huawei.hms"))) {
                C0946g.m1579b(f1219a, "hms version code is too low : " + C0947h.m1583a("com.huawei.hwid"));
                return null;
            } else if (m1544c(a, "com.huawei.hwid") || m1540b(a, "com.huawei.hms")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    inputStream = a.getContentResolver().openInputStream(Uri.withAppendedPath(f1224f, f1225g));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    } catch (Exception unused) {
                        try {
                            C0946g.m1579b(f1219a, "Get bks from HMS_VERSION_CODE exception : No content provider");
                            C0945f.m1570a(inputStream);
                            C0945f.m1571a((OutputStream) byteArrayOutputStream);
                            C0945f.m1570a((InputStream) byteArrayInputStream2);
                            InputStream filesBksIS = getFilesBksIS(a);
                            return filesBksIS;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayInputStream = byteArrayInputStream2;
                            C0945f.m1570a(inputStream);
                            C0945f.m1571a((OutputStream) byteArrayOutputStream);
                            C0945f.m1570a((InputStream) byteArrayInputStream);
                            throw th;
                        }
                    }
                    try {
                        String a2 = C0948i.m1587a(f1236r, "", a);
                        String b = m1539b(byteArrayOutputStream.toByteArray());
                        if (m1543c(a)) {
                            if (a2.equals(b)) {
                                C0946g.m1580c(f1219a, "bks not update");
                                C0945f.m1570a(inputStream);
                                C0945f.m1571a((OutputStream) byteArrayOutputStream);
                                C0945f.m1570a((InputStream) byteArrayInputStream);
                                InputStream filesBksIS2 = getFilesBksIS(a);
                                return filesBksIS2;
                            }
                        }
                        C0946g.m1580c(f1219a, "update bks and sp");
                        m1535a((InputStream) byteArrayInputStream, a);
                        C0948i.m1593b(f1236r, b, a);
                        C0945f.m1570a(inputStream);
                        C0945f.m1571a((OutputStream) byteArrayOutputStream);
                        C0945f.m1570a((InputStream) byteArrayInputStream);
                    } catch (Exception unused2) {
                        byteArrayInputStream2 = byteArrayInputStream;
                        C0946g.m1579b(f1219a, "Get bks from HMS_VERSION_CODE exception : No content provider");
                        C0945f.m1570a(inputStream);
                        C0945f.m1571a((OutputStream) byteArrayOutputStream);
                        C0945f.m1570a((InputStream) byteArrayInputStream2);
                        InputStream filesBksIS22 = getFilesBksIS(a);
                        return filesBksIS22;
                    } catch (Throwable th2) {
                        th = th2;
                        C0945f.m1570a(inputStream);
                        C0945f.m1571a((OutputStream) byteArrayOutputStream);
                        C0945f.m1570a((InputStream) byteArrayInputStream);
                        throw th;
                    }
                } catch (Exception unused3) {
                    inputStream = null;
                    C0946g.m1579b(f1219a, "Get bks from HMS_VERSION_CODE exception : No content provider");
                    C0945f.m1570a(inputStream);
                    C0945f.m1571a((OutputStream) byteArrayOutputStream);
                    C0945f.m1570a((InputStream) byteArrayInputStream2);
                    InputStream filesBksIS222 = getFilesBksIS(a);
                    return filesBksIS222;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    byteArrayInputStream = byteArrayInputStream2;
                    C0945f.m1570a(inputStream);
                    C0945f.m1571a((OutputStream) byteArrayOutputStream);
                    C0945f.m1570a((InputStream) byteArrayInputStream);
                    throw th;
                }
                InputStream filesBksIS2222 = getFilesBksIS(a);
                return filesBksIS2222;
            } else {
                C0946g.m1579b(f1219a, "hms sign error");
                return null;
            }
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (!m1543c(context)) {
            return null;
        }
        C0946g.m1580c(f1219a, "getFilesBksIS ");
        try {
            return new FileInputStream(m1538b(context));
        } catch (FileNotFoundException unused) {
            C0946g.m1579b(f1219a, "FileNotFoundExceptio: ");
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m1541b(String str) {
        int i;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C0946g.m1580c(f1219a, "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = f1226h.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        for (int i3 = 0; i3 < max; i3++) {
            if (i3 < length) {
                try {
                    i = Integer.parseInt(split[i3]);
                } catch (Exception e) {
                    C0946g.m1579b(f1219a, " exception : " + e.getMessage());
                    if (i3 >= length2) {
                        return true;
                    }
                    return false;
                }
            } else {
                i = 0;
            }
            if (i3 < length2) {
                i2 = Integer.parseInt(split2[i3]);
            } else {
                i2 = 0;
            }
            if (i < i2) {
                return false;
            }
            if (i > i2) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m1544c(Context context, String str) {
        byte[] a = m1537a(context, str);
        for (String equalsIgnoreCase : f1234p) {
            if (equalsIgnoreCase.equalsIgnoreCase(m1542c(a))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static String m1542c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return m1534a(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            Log.e(f1219a, "NoSuchAlgorithmException" + e.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    private static boolean m1540b(Context context, String str) {
        return f1233o.equalsIgnoreCase(m1542c(m1537a(context, str)));
    }

    /* renamed from: a */
    private static int m1532a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            C0946g.m1582e(f1219a, "The directory  has already exists");
            return 1;
        } else if (file.mkdirs()) {
            C0946g.m1577a(f1219a, "create directory  success");
            return 0;
        } else {
            C0946g.m1579b(f1219a, "create directory  failed");
            return -1;
        }
    }

    /* renamed from: b */
    private static String m1539b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return m1534a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            C0946g.m1579b(f1219a, "inputstraem exception");
            return "";
        }
    }

    /* renamed from: a */
    private static String m1533a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + f1227i;
        }
        return context.getApplicationContext().getFilesDir() + File.separator + f1227i;
    }

    /* renamed from: a */
    private static byte[] m1537a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e(f1219a, "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(str, 64)) == null)) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(f1219a, "PackageManager.NameNotFoundException : " + e.getMessage());
        } catch (Exception e2) {
            Log.e(f1219a, "get pm exception : " + e2.getMessage());
        }
        return new byte[0];
    }

    /* renamed from: a */
    private static String m1534a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
