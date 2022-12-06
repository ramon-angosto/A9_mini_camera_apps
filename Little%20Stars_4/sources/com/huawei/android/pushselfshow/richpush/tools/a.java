package com.huawei.android.pushselfshow.richpush.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.a.c;
import com.huawei.android.pushselfshow.utils.d;
import java.io.File;
import object.p2pipcam.utils.DataBaseHelper;

public class a {
    public Resources a;
    public Activity b;
    private com.huawei.android.pushselfshow.b.a c = null;

    public a(Activity activity) {
        this.b = activity;
        this.a = activity.getResources();
    }

    public void a() {
        try {
            e.a("PushSelfShowLog", "creat shortcut");
            Intent intent = new Intent();
            intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            Bitmap decodeResource = BitmapFactory.decodeResource(this.b.getResources(), d.f(this.b, "hwpush_main_icon"));
            intent.putExtra("android.intent.extra.shortcut.NAME", this.b.getResources().getString(d.a(this.b, "hwpush_msg_collect")));
            intent.putExtra("android.intent.extra.shortcut.ICON", decodeResource);
            intent.putExtra("duplicate", false);
            Intent intent2 = new Intent("com.huawei.android.push.intent.RICHPUSH");
            intent2.putExtra(DataBaseHelper.KEY_TYPE, "favorite");
            intent2.addFlags(1476395008);
            String str = "com.huawei.android.pushagent";
            if (!com.huawei.android.pushselfshow.utils.a.b((Context) this.b, str)) {
                str = this.b.getPackageName();
            }
            intent2.setPackage(str);
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            this.b.sendBroadcast(intent);
        } catch (Exception e) {
            e.d("PushSelfShowLog", "creat shortcut error", e);
        }
    }

    public void a(com.huawei.android.pushselfshow.b.a aVar) {
        this.c = aVar;
    }

    public void b() {
        File parentFile;
        try {
            if (this.c != null) {
                if (this.c.C != null) {
                    e.e("PushSelfShowLog", "the rpl is " + this.c.C);
                    String substring = this.c.C.startsWith("file://") ? this.c.C.substring(7) : this.c.C;
                    e.e("PushSelfShowLog", "filePath is " + substring);
                    if ("text/html_local".equals(this.c.E) && (parentFile = new File(substring).getParentFile()) != null && parentFile.isDirectory() && this.c.C.contains("richpush")) {
                        String absolutePath = parentFile.getAbsolutePath();
                        String replace = absolutePath.replace("richpush", "shotcut");
                        e.b("PushSelfShowLog", "srcDir is %s ,destDir is %s", absolutePath, replace);
                        if (com.huawei.android.pushselfshow.utils.a.a(absolutePath, replace)) {
                            this.c.C = Uri.fromFile(new File(replace + File.separator + "index.html")).toString();
                        } else {
                            Toast.makeText(this.b, com.huawei.android.pushselfshow.utils.a.a((Context) this.b, "内容保存失败", "Save Failed"), 0).show();
                            return;
                        }
                    }
                    e.a("PushSelfShowLog", "insert data into db");
                    a();
                    boolean a2 = c.a(this.b, this.c.q, this.c);
                    e.e("PushSelfShowLog", "insert result is " + a2);
                    if (a2) {
                        com.huawei.android.pushselfshow.utils.a.a((Context) this.b, "14", this.c);
                        return;
                    } else {
                        e.d("PushSelfShowLog", "save icon fail");
                        return;
                    }
                }
            }
            Toast.makeText(this.b, com.huawei.android.pushselfshow.utils.a.a((Context) this.b, "内容保存失败", "Save Failed"), 0).show();
        } catch (Exception e) {
            e.c("PushSelfShowLog", "SaveBtnClickListener error ", e);
        }
    }
}
