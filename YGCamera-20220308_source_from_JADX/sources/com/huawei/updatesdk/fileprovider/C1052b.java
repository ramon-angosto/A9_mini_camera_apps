package com.huawei.updatesdk.fileprovider;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.fileprovider.b */
class C1052b implements C1051a {

    /* renamed from: a */
    private final String f1426a;

    /* renamed from: b */
    private final HashMap<String, File> f1427b = new HashMap<>();

    protected C1052b(String str) {
        this.f1426a = str;
    }

    /* renamed from: a */
    public Uri mo15040a(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry next : this.f1427b.entrySet()) {
                String path = ((File) next.getValue()).getPath();
                if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = next;
                }
            }
            if (entry != null) {
                String path2 = ((File) entry.getValue()).getPath();
                boolean endsWith = path2.endsWith("/");
                int length = path2.length();
                if (!endsWith) {
                    length++;
                }
                String substring = canonicalPath.substring(length);
                return new Uri.Builder().scheme(RemoteMessageConst.Notification.CONTENT).authority(this.f1426a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
            }
            throw new IllegalArgumentException("wisedist: Failed to find configured root that contains");
        } catch (Exception unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for wisedist");
        }
    }

    /* renamed from: a */
    public File mo15041a(Uri uri) {
        try {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f1427b.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("wisedist: Unable to find configured root for");
            } else if (TextUtils.isEmpty(decode2) || decode2.contains("../") || decode2.contains("..") || decode2.contains("%00") || decode2.contains(".\\.\\") || decode2.contains("./")) {
                throw new IllegalArgumentException("wisedist: Not a standard path");
            } else {
                try {
                    File canonicalFile = new File(file, decode2).getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("wisedist: Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("wisedist: Failed to resolve canonical path for");
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("UpdateSDKFileProvider error: " + e.toString());
        }
    }

    /* renamed from: a */
    public void mo15042a(String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f1427b.put(str, file.getCanonicalFile());
            } catch (Exception unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for root");
            }
        } else {
            throw new IllegalArgumentException("wisedist Name must not be empty");
        }
    }
}
