package com.huawei.updatesdk.fileprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import java.io.File;

public class UpdateSdkFileProvider extends ContentProvider {
    public static final String AUTHORITIES_SUFFIX = ".updateSdk.fileProvider";
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final String TAG = "UpdateSdkFileProvider";
    private static C1051a mWStrategy;
    private String authority;

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static Object[] copyOf(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    private static String[] copyOf(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static synchronized C1051a createWiseDistPathStrategy(Context context, String str) {
        C1051a aVar;
        synchronized (UpdateSdkFileProvider.class) {
            if (mWStrategy == null) {
                mWStrategy = new C1052b(str);
                if (context.getFilesDir() != null) {
                    mWStrategy.mo15042a("updatesdkapk", buildPath(context.getFilesDir(), "/"));
                }
            }
            aVar = mWStrategy;
        }
        return aVar;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        createWiseDistPathStrategy(context, str);
        return mWStrategy.mo15040a(file);
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("WiseDist Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            String str = providerInfo.authority;
            this.authority = str;
            createWiseDistPathStrategy(context, str);
        } else {
            throw new SecurityException("WiseDist Provider must grant uri permissions");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r2 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension("apk");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getType(android.net.Uri r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0023
            java.lang.String r0 = r2.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0023
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = "apk"
            boolean r2 = r2.endsWith(r0)
            if (r2 == 0) goto L_0x0023
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r2 = r2.getMimeTypeFromExtension(r0)
            if (r2 == 0) goto L_0x0023
            return r2
        L_0x0023:
            java.lang.String r2 = "application/octet-stream"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.fileprovider.UpdateSdkFileProvider.getType(android.net.Uri):java.lang.String");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        if (uri == null || uri.getAuthority() == null || !uri.getAuthority().equals(this.authority)) {
            return null;
        }
        File a = mWStrategy.mo15041a(uri);
        if (a.getName().endsWith("apk")) {
            return ParcelFileDescriptor.open(a, 268435456);
        }
        C0968a.m1682b(TAG, "can not open this file.");
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File a = mWStrategy.mo15041a(uri);
        if (strArr == null) {
            strArr = COLUMNS;
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
        String[] copyOf = copyOf(strArr3, i2);
        Object[] copyOf2 = copyOf(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
