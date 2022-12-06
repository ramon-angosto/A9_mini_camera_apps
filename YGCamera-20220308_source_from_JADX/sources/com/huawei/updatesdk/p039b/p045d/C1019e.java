package com.huawei.updatesdk.p039b.p045d;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p034b.p036b.C0987b;
import com.huawei.updatesdk.p039b.p047f.C1030c;
import com.huawei.updatesdk.support.p051pm.PackageInstallerActivity;
import java.io.File;

/* renamed from: com.huawei.updatesdk.b.d.e */
public class C1019e {
    /* renamed from: a */
    public static void m1904a(int i, int i2) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("INSTALL_STATE", i);
        bundle.putInt("INSTALL_TYPE", i2);
        intent.putExtras(bundle);
        C1030c.m1937b().mo15009c(C0987b.m1761a(intent));
    }

    /* renamed from: a */
    public static void m1905a(Context context, String str, String str2) {
        m1904a(3, 1);
        File file = new File(str);
        if (!file.exists() || !file.isFile() || file.length() <= 0) {
            C0968a.m1682b("InstallProcess", "system install failed,file not existed filePath:" + str);
            m1904a(4, -10003);
            return;
        }
        Intent intent = new Intent(context, PackageInstallerActivity.class);
        intent.putExtra("install_path", str);
        intent.putExtra("install_packagename", str2);
        if (!(context instanceof Activity)) {
            intent.setFlags(402653184);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            m1904a(4, -10002);
            C0968a.m1681a("InstallProcess", " can not start install !", e);
        }
    }
}
