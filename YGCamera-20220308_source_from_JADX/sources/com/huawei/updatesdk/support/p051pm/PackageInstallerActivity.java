package com.huawei.updatesdk.support.p051pm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.updatesdk.fileprovider.UpdateSdkFileProvider;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0981c;
import com.huawei.updatesdk.p025a.p034b.p036b.C0987b;
import com.huawei.updatesdk.p039b.p045d.C1019e;
import java.io.File;

/* renamed from: com.huawei.updatesdk.support.pm.PackageInstallerActivity */
public class PackageInstallerActivity extends Activity {
    /* renamed from: a */
    private Intent m2130a(Context context, String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || str.contains("../") || str.contains("..") || str.contains("%00") || str.contains(".\\.\\") || str.contains("./")) {
            throw new IllegalArgumentException("getNomalInstallIntent: Not a standard path");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.INSTALL_PACKAGE");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            uri = UpdateSdkFileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + UpdateSdkFileProvider.AUTHORITIES_SUFFIX, new File(str));
        } else {
            uri = Uri.fromFile(new File(str));
        }
        intent.setData(uri);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1000 == i) {
            if (i2 == 0) {
                C1019e.m1904a(7, 0);
            } else {
                int i3 = -10004;
                if (intent != null) {
                    i3 = C0987b.m1761a(intent).mo14896a("android.intent.extra.INSTALL_RESULT", -10004);
                }
                if (!(i3 == 0 || i3 == 1)) {
                    C1019e.m1904a(4, i3);
                }
            }
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        requestWindowFeature(1);
        C0981c.m1734d().mo14890a(getWindow());
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            str = "PackageInstallerActivity error intent";
        } else {
            C0987b a = C0987b.m1761a(intent);
            String a2 = a.mo14898a("install_path");
            String a3 = a.mo14898a("install_packagename");
            if (TextUtils.isEmpty(a2)) {
                C1019e.m1904a(4, -3);
                finish();
                str = "PackageInstallerActivity can not find filePath.";
            } else {
                try {
                    Intent a4 = m2130a(this, a2);
                    a4.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                    a4.putExtra("android.intent.extra.RETURN_RESULT", true);
                    C0968a.m1683c("PackageInstallerActivity", " onCreate filePath:" + a2 + ",packageName:" + a3 + ",taskId:" + getTaskId());
                    startActivityForResult(a4, 1000);
                    return;
                } catch (Exception unused) {
                    C0968a.m1682b("PackageInstallerActivity", "can not start install action");
                    C1019e.m1904a(4, -2);
                    finish();
                    return;
                }
            }
        }
        C0968a.m1682b("PackageInstallerActivity", str);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        finishActivity(1000);
        super.onDestroy();
    }
}
