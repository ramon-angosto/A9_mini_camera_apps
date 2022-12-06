package com.huawei.hms.update.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.huawei.hms.availableupdate.C0658l;
import java.io.File;
import java.io.FileNotFoundException;

public class UpdateProvider extends ContentProvider {
    public static final String AUTHORITIES_SUFFIX = ".hms.update.provider";

    /* renamed from: a */
    public static final String[] f999a = {"_display_name", "_size"};

    /* renamed from: b */
    public static C0658l f1000b = new C0658l();

    /* renamed from: a */
    public static int m1392a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    public static File getLocalFile(Context context, String str) {
        f1000b.mo13275a(context.getApplicationContext());
        return f1000b.mo13273a(str);
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        f1000b.mo13275a(context.getApplicationContext());
        return f1000b.mo13271a(file, str);
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        f1000b.mo13275a(getContext().getApplicationContext());
        return f1000b.mo13272a(uri).delete() ? 1 : 0;
    }

    public String getType(Uri uri) {
        if (getContext() == null) {
            return OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        f1000b.mo13275a(getContext().getApplicationContext());
        String name = f1000b.mo13272a(uri).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1));
            if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                return mimeTypeFromExtension;
            }
        }
        return OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        f1000b.mo13275a(getContext().getApplicationContext());
        return ParcelFileDescriptor.open(f1000b.mo13272a(uri), m1392a(str));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        f1000b.mo13275a(getContext().getApplicationContext());
        File a = f1000b.mo13272a(uri);
        if (strArr == null) {
            strArr = f999a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(a.length());
            }
            i2 = i;
        }
        String[] a2 = m1394a(strArr3, i2);
        Object[] a3 = m1393a(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(a2, 1);
        matrixCursor.addRow(a3);
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    /* renamed from: a */
    public static String[] m1394a(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* renamed from: a */
    public static Object[] m1393a(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
