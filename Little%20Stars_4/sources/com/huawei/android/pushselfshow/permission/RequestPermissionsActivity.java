package com.huawei.android.pushselfshow.permission;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.SelfShowReceiver;
import com.huawei.android.pushselfshow.utils.a;
import java.util.ArrayList;
import java.util.Arrays;

public class RequestPermissionsActivity extends Activity {
    private static final String[] a = {"android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private Intent b = null;
    private String[] c = new String[0];

    public static void a(Context context, Intent intent) {
        e.b("PushSelfShowLog", "enter startPermissionActivity");
        if (context != null) {
            Intent intent2 = new Intent(context.getApplicationContext(), RequestPermissionsActivity.class);
            intent2.addFlags(276824064);
            if (intent != null) {
                intent2.putExtra("previous_intent", intent);
            }
            try {
                context.startActivity(intent2);
            } catch (ActivityNotFoundException e) {
                e.c("PushSelfShowLog", e.toString(), e);
            }
        }
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 23 && !a(context, a);
    }

    protected static boolean a(Context context, String[] strArr) {
        if (context == null || strArr == null || strArr.length == 0) {
            return false;
        }
        for (String str : strArr) {
            if (context.checkSelfPermission(str) != 0) {
                e.a("PushSelfShowLog", str + " need request");
                return false;
            }
        }
        return true;
    }

    private boolean a(String str) {
        return Arrays.asList(a()).contains(str);
    }

    private boolean a(String[] strArr) {
        int i = 0;
        while (i < strArr.length) {
            if (checkSelfPermission(strArr[i]) == 0 || !a(strArr[i])) {
                i++;
            } else {
                e.b("PushSelfShowLog", "request permissions failed:" + strArr[i]);
                return false;
            }
        }
        e.b("PushSelfShowLog", "request all permissions success:");
        return true;
    }

    private boolean a(String[] strArr, int[] iArr) {
        int i = 0;
        while (i < strArr.length) {
            if (iArr[i] == 0 || !a(strArr[i])) {
                i++;
            } else {
                e.a("PushSelfShowLog", "request permissions failed:" + strArr[i]);
                return false;
            }
        }
        e.a("PushSelfShowLog", "request all permissions success:");
        return true;
    }

    private void b(String[] strArr) {
        try {
            Intent intent = new Intent("huawei.intent.action.REQUEST_PERMISSIONS");
            intent.setPackage("com.huawei.systemmanager");
            intent.putExtra("KEY_HW_PERMISSION_ARRAY", strArr);
            intent.putExtra("KEY_HW_PERMISSION_PKG", getPackageName());
            if (a.a((Context) this, "com.huawei.systemmanager", intent).booleanValue()) {
                try {
                    e.b("PushSelfShowLog", "checkAndRequestPermission: systemmanager permission activity is exist");
                    startActivityForResult(intent, 1357);
                } catch (Exception e) {
                    e.c("PushSelfShowLog", "checkAndRequestPermission: Exception", e);
                }
            } else {
                e.b("PushSelfShowLog", "checkAndRequestPermission: systemmanager permission activity is not exist");
                requestPermissions(strArr, 1357);
            }
        } catch (Exception e2) {
            e.c("PushSelfShowLog", e2.toString(), e2);
        }
    }

    private void c() {
        ArrayList arrayList = new ArrayList();
        for (String str : b()) {
            if (checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() != 0) {
            this.c = (String[]) arrayList.toArray(new String[arrayList.size()]);
            b(this.c);
            return;
        }
        e.a("PushSelfShowLog", "unsatisfiedPermissions size is 0, finish");
        finish();
    }

    /* access modifiers changed from: protected */
    public String[] a() {
        return a;
    }

    /* access modifiers changed from: protected */
    public String[] b() {
        return a;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (1357 == i) {
            if (i2 == 0) {
                try {
                    e.b("PushSelfShowLog", "onActivityResult: RESULT_CANCELED");
                } catch (Exception e) {
                    e.c("PushSelfShowLog", e.toString(), e);
                    return;
                }
            } else if (-1 == i2) {
                e.b("PushSelfShowLog", "onActivityResult: RESULT_OK");
                if (!(this.c == null || this.c.length == 0 || !a(this.c))) {
                    e.b("PushSelfShowLog", "onActivityResult: Permission is granted");
                    new SelfShowReceiver().onReceive(this, this.b);
                }
            }
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        e.a((Context) this);
        e.b("PushSelfShowLog", "enter RequestPermissionsActivity onCreate");
        requestWindowFeature(1);
        Intent intent = getIntent();
        if (intent == null) {
            str = "enter RequestPermissionsActivity onCreate, intent is null, finish";
        } else if (Build.VERSION.SDK_INT < 23) {
            str = "enter RequestPermissionsActivity onCreate, SDK version is less than 23, finish";
        } else {
            try {
                if (intent.getExtras() != null) {
                    this.b = (Intent) intent.getExtras().get("previous_intent");
                }
            } catch (Exception e) {
                e.c("PushSelfShowLog", e.toString(), e);
            }
            e.a("PushSelfShowLog", "savedInstanceState is " + bundle);
            if (bundle == null) {
                c();
                return;
            }
            return;
        }
        e.b("PushSelfShowLog", str);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        e.a("PushSelfShowLog", "enter RequestPermissionsActivity onDestroy");
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        e.a("PushSelfShowLog", "enter RequestPermissionsActivity onNewIntent");
        super.onNewIntent(intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        e.b("PushSelfShowLog", "RequestPermissionsActivity onRequestPermissionsResult");
        if (1357 == i && strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0 && a(strArr, iArr) && this.b != null) {
            new SelfShowReceiver().onReceive(this, this.b);
        }
        finish();
    }
}
