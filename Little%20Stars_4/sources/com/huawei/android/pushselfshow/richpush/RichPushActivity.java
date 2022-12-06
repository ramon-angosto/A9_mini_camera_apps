package com.huawei.android.pushselfshow.richpush;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.favorites.FavoritesActivity;
import com.huawei.android.pushselfshow.richpush.html.HtmlViewer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import object.p2pipcam.utils.DataBaseHelper;

public class RichPushActivity extends Activity {
    public static final String TAG = "PushSelfShowLog";
    String a = "";
    private Class b;
    private Object c;
    private HashMap d = null;
    public Activity m_activity = this;
    public boolean mkInstance = false;

    private HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("html", HtmlViewer.class);
        hashMap.put("favorite", FavoritesActivity.class);
        return hashMap;
    }

    private void a(String str, Class[] clsArr, Object[] objArr) {
        StringBuilder sb;
        String str2;
        if (this.b != null && this.c != null && !TextUtils.isEmpty(str) && clsArr != null && objArr != null) {
            try {
                this.b.getDeclaredMethod(str, clsArr).invoke(this.c, objArr);
                return;
            } catch (NoSuchMethodException e) {
                sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(" doesn't has ");
                sb.append(str);
                sb.append(" method,err info ");
                str2 = e.toString();
            } catch (IllegalAccessException e2) {
                sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(" doesn't has ");
                sb.append(str);
                sb.append(" method,err info ");
                str2 = e2.toString();
            } catch (IllegalArgumentException e3) {
                sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(" doesn't has ");
                sb.append(str);
                sb.append(" method,err info ");
                str2 = e3.toString();
            } catch (InvocationTargetException e4) {
                sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(" doesn't has ");
                sb.append(str);
                sb.append(" method,err info ");
                str2 = e4.toString();
            }
        } else {
            return;
        }
        sb.append(str2);
        e.a("PushSelfShowLog", sb.toString());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        e.a("PushSelfShowLog", "enter onActivityResult of RichPush");
        if (!this.mkInstance) {
            super.onActivityResult(i, i2, intent);
        }
        a("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
    }

    public void onCreate(Bundle bundle) {
        String str;
        StringBuilder sb;
        this.m_activity.requestWindowFeature(1);
        this.m_activity.setRequestedOrientation(5);
        if (!this.mkInstance) {
            super.onCreate(bundle);
        }
        e.a((Context) this.m_activity);
        e.a("PushSelfShowLog", "enter onCreate of RichPush ");
        HashMap hashMap = this.d;
        if (hashMap == null || hashMap.isEmpty()) {
            this.d = a();
        }
        Intent intent = this.m_activity.getIntent();
        e.a("PushSelfShowLog", "enter onCreate of RichPush  intent " + intent);
        if (intent == null) {
            finish();
            return;
        }
        if (bundle != null) {
            intent.putExtra("collect_img_disable", bundle.getBoolean("collect_img_disable"));
        }
        try {
            this.a = intent.getStringExtra(DataBaseHelper.KEY_TYPE);
        } catch (Exception unused) {
            e.d("PushSelfShowLog", "getStringExtra type error");
        }
        e.a("PushSelfShowLog", "the showType is :" + this.a);
        if (this.d.containsKey(this.a)) {
            this.b = (Class) this.d.get(this.a);
            try {
                this.c = this.b.getConstructor(new Class[0]).newInstance(new Object[0]);
                Method declaredMethod = this.b.getDeclaredMethod("setActivity", new Class[]{Activity.class});
                e.a("PushSelfShowLog", "call setActivity in RichPush!");
                declaredMethod.invoke(this.c, new Object[]{this.m_activity});
                this.b.getDeclaredMethod("onCreate", new Class[]{Intent.class}).invoke(this.c, new Object[]{intent});
                return;
            } catch (NoSuchMethodException e) {
                sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(" doesn't has onCreate method,err info ");
                str = e.toString();
            } catch (InstantiationException e2) {
                sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(" doesn't has onCreate method,err info ");
                str = e2.toString();
            } catch (IllegalAccessException e3) {
                sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(" doesn't has onCreate method,err info ");
                str = e3.toString();
            } catch (IllegalArgumentException e4) {
                sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(" doesn't has onCreate method,err info ");
                str = e4.toString();
            } catch (InvocationTargetException e5) {
                sb = new StringBuilder();
                sb.append(this.b.getName());
                sb.append(" doesn't has onCreate method,err info ");
                str = e5.toString();
            }
        } else {
            e.a("PushSelfShowLog", "the showType is invalid");
            finish();
            return;
        }
        sb.append(str);
        e.a("PushSelfShowLog", sb.toString());
    }

    public void onDestroy() {
        e.a("PushSelfShowLog", "enter onDestroy of RichPush");
        if (!this.mkInstance) {
            super.onDestroy();
        }
        a("onDestroy", new Class[0], new Object[0]);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        e.a("PushSelfShowLog", "enter onKeyDown of RichPush");
        a("onKeyDown", new Class[]{Integer.TYPE, KeyEvent.class}, new Object[]{Integer.valueOf(i), keyEvent});
        return true;
    }

    public void onPause() {
        e.a("PushSelfShowLog", "enter onPause of RichPush");
        if (!this.mkInstance) {
            super.onPause();
        }
        a("onPause", new Class[0], new Object[0]);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        e.a("PushSelfShowLog", "enter onRequestPermissionsResult of RichPush");
        if (!this.mkInstance) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
        a("onRequestPermissionsResult", new Class[]{Integer.TYPE, String[].class, int[].class}, new Object[]{Integer.valueOf(i), strArr, iArr});
    }

    public void onRestart() {
        e.a("PushSelfShowLog", "enter onRestart of RichPush");
        if (!this.mkInstance) {
            super.onRestart();
        }
        a("onRestart", new Class[0], new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        e.a("PushSelfShowLog", "enter onResume of RichPush");
        if (!this.mkInstance) {
            super.onResume();
        }
        a("onResume", new Class[0], new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        e.a("PushSelfShowLog", "enter onSaveInstanceState of RichPush");
        if (!this.mkInstance) {
            super.onSaveInstanceState(bundle);
        }
        a("onSaveInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
    }

    public void onStart() {
        e.a("PushSelfShowLog", "enter onStart of RichPush");
        if (!this.mkInstance) {
            super.onStart();
        }
        a("onStart", new Class[0], new Object[0]);
    }

    public void onStop() {
        e.a("PushSelfShowLog", "enter onStop of RichPush， and mkInstance is " + this.mkInstance + "and pActivityClass is " + this.b + ",and pActivityInstance is " + this.c);
        if (!this.mkInstance) {
            super.onStop();
        }
        a("onStop", new Class[0], new Object[0]);
    }

    public void setActivity(Activity activity) {
        this.m_activity = activity;
        this.mkInstance = true;
    }
}
