package com.huawei.android.pushselfshow.richpush.html;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushselfshow.richpush.html.api.ExposedJsApi;
import com.huawei.android.pushselfshow.richpush.tools.Console;
import com.huawei.android.pushselfshow.utils.c;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import object.p2pipcam.utils.DataBaseHelper;

public class HtmlViewer implements c.a {
    public static final String TAG = "PushSelfShowLog";
    PageProgressView a;
    com.huawei.android.pushselfshow.utils.c b = new com.huawei.android.pushselfshow.utils.c(this);
    com.huawei.android.pushselfshow.utils.c c = new com.huawei.android.pushselfshow.utils.c(this);
    /* access modifiers changed from: private */
    public Activity d;
    public com.huawei.android.pushselfshow.utils.b.b dtl = null;
    /* access modifiers changed from: private */
    public WebView e;
    /* access modifiers changed from: private */
    public com.huawei.android.pushselfshow.richpush.tools.a f;
    /* access modifiers changed from: private */
    public com.huawei.android.pushselfshow.b.a g = null;
    private String h;
    private ExposedJsApi i;
    /* access modifiers changed from: private */
    public ImageView j;
    /* access modifiers changed from: private */
    public ImageView k;
    private ImageView l;
    /* access modifiers changed from: private */
    public ImageView m;
    /* access modifiers changed from: private */
    public TextView n;
    /* access modifiers changed from: private */
    public a o;
    private boolean p;
    private boolean q = false;
    /* access modifiers changed from: private */
    public boolean r = false;
    /* access modifiers changed from: private */
    public AlertDialog s = null;
    private AlertDialog t = null;
    /* access modifiers changed from: private */
    public boolean u = false;

    private class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(HtmlViewer htmlViewer, b bVar) {
            this();
        }

        public void onClick(View view) {
            if (HtmlViewer.this.e != null && HtmlViewer.this.e.canGoBack()) {
                e.a("PushSelfShowLog", "can go back " + HtmlViewer.this.e.canGoBack());
                HtmlViewer.this.e.goBack();
            }
        }
    }

    private class b implements View.OnClickListener {
        private Context b;

        private b(Context context) {
            this.b = context;
        }

        /* synthetic */ b(HtmlViewer htmlViewer, Context context, b bVar) {
            this(context);
        }

        public void onClick(View view) {
            h hVar = new h(this.b, "push_client_self_info");
            if (!hVar.e("isFirstCollect")) {
                AlertDialog unused = HtmlViewer.this.s = new AlertDialog.Builder(this.b).setPositiveButton(com.huawei.android.pushselfshow.utils.d.a(this.b, "hwpush_collect_tip_known"), new k(this, hVar)).setView(((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(com.huawei.android.pushselfshow.utils.d.c(this.b, "hwpush_collect_tip_dialog"), (ViewGroup) null)).create();
                HtmlViewer.this.s.show();
                return;
            }
            HtmlViewer htmlViewer = HtmlViewer.this;
            htmlViewer.a(htmlViewer.d);
        }
    }

    private class c implements View.OnClickListener {
        private c() {
        }

        /* synthetic */ c(HtmlViewer htmlViewer, b bVar) {
            this();
        }

        public void onClick(View view) {
            if (HtmlViewer.this.e != null && HtmlViewer.this.e.canGoForward()) {
                e.a("PushSelfShowLog", " can Go Forward " + HtmlViewer.this.e.canGoForward());
                HtmlViewer.this.e.goForward();
            }
        }
    }

    private class d implements View.OnClickListener {
        private d() {
        }

        /* synthetic */ d(HtmlViewer htmlViewer, b bVar) {
            this();
        }

        public void onClick(View view) {
            HtmlViewer.this.setProgress(0);
            HtmlViewer.this.e.reload();
        }
    }

    private void a() {
        this.e.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 16) {
            this.e.removeJavascriptInterface("searchBoxJavaBridge_");
            this.e.removeJavascriptInterface("accessibility");
            this.e.removeJavascriptInterface("accessibilityTraversal");
        }
        if (Build.VERSION.SDK_INT <= 18) {
            this.e.getSettings().setSavePassword(false);
        }
        this.e.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.e.getSettings().setLoadsImagesAutomatically(true);
        this.e.getSettings().setDomStorageEnabled(true);
        this.e.getSettings().setSupportZoom(true);
        this.e.setScrollBarStyle(0);
        this.e.setHorizontalScrollBarEnabled(false);
        this.e.setVerticalScrollBarEnabled(false);
        this.e.getSettings().setSupportMultipleWindows(true);
        this.e.setDownloadListener(new b(this));
        this.e.setOnTouchListener(new c(this));
        this.e.setWebChromeClient(new d(this));
        this.e.setWebViewClient(new e(this));
    }

    /* access modifiers changed from: private */
    public void a(Activity activity) {
        if (activity != null) {
            this.o.a(this.m);
            this.u = true;
            if (Build.VERSION.SDK_INT < 23 || com.huawei.android.pushselfshow.utils.a.e(activity) || !com.huawei.android.pushselfshow.utils.a.f(activity) || activity.checkSelfPermission("com.huawei.pushagent.permission.RICHMEDIA_PROVIDER") == 0) {
                new Thread(new h(this, activity)).start();
                return;
            }
            a(new String[]{"com.huawei.pushagent.permission.RICHMEDIA_PROVIDER"});
        }
    }

    private void a(String[] strArr) {
        Activity activity;
        try {
            Intent intent = new Intent("huawei.intent.action.REQUEST_PERMISSIONS");
            intent.setPackage("com.huawei.systemmanager");
            intent.putExtra("KEY_HW_PERMISSION_ARRAY", strArr);
            intent.putExtra("KEY_HW_PERMISSION_PKG", this.d.getPackageName());
            if (com.huawei.android.pushselfshow.utils.a.a((Context) this.d, "com.huawei.systemmanager", intent).booleanValue()) {
                try {
                    e.b("PushSelfShowLog", "checkAndRequestPermission: systemmanager permission activity is exist");
                    this.d.startActivityForResult(intent, 10003);
                } catch (Exception e2) {
                    e.c("PushSelfShowLog", "checkAndRequestPermission: Exception", e2);
                    activity = this.d;
                }
            } else {
                e.b("PushSelfShowLog", "checkAndRequestPermission: systemmanager permission activity is not exist");
                activity = this.d;
                activity.requestPermissions(strArr, 10003);
            }
        } catch (Exception e3) {
            e.c("PushSelfShowLog", e3.toString(), e3);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v2, types: [android.database.Cursor] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r3 == 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "currentExistCount:" + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r3 != 0) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r3.close();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(android.app.Activity r7) {
        /*
            r6 = this;
            java.lang.String r0 = "PushSelfShowLog"
            r1 = 0
            if (r7 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r2 = "SELECT pushmsg._id,pushmsg.msg,pushmsg.token,pushmsg.url,notify.bmp FROM pushmsg LEFT OUTER JOIN notify ON pushmsg.url = notify.url order by pushmsg._id desc limit 1000;"
            r3 = 0
            com.huawei.android.pushselfshow.richpush.a.b r4 = com.huawei.android.pushselfshow.richpush.a.b.a()     // Catch:{ Exception -> 0x0021 }
            android.net.Uri r5 = com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider.a.f     // Catch:{ Exception -> 0x0021 }
            android.database.Cursor r3 = r4.a((android.content.Context) r7, (android.net.Uri) r5, (java.lang.String) r2, (java.lang.String[]) r3)     // Catch:{ Exception -> 0x0021 }
            if (r3 == 0) goto L_0x0019
            int r1 = r3.getCount()     // Catch:{ Exception -> 0x0021 }
        L_0x0019:
            if (r3 == 0) goto L_0x002c
        L_0x001b:
            r3.close()
            goto L_0x002c
        L_0x001f:
            r7 = move-exception
            goto L_0x0041
        L_0x0021:
            r7 = move-exception
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x001f }
            com.huawei.android.pushagent.c.a.e.c(r0, r2, r7)     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x002c
            goto L_0x001b
        L_0x002c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "currentExistCount:"
            r7.append(r2)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            com.huawei.android.pushagent.c.a.e.a(r0, r7)
            return r1
        L_0x0041:
            if (r3 == 0) goto L_0x0046
            r3.close()
        L_0x0046:
            goto L_0x0048
        L_0x0047:
            throw r7
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.richpush.html.HtmlViewer.b(android.app.Activity):int");
    }

    private void c(Activity activity) {
        this.t = new AlertDialog.Builder(activity, com.huawei.android.pushselfshow.utils.a.h(activity)).setTitle(com.huawei.android.pushselfshow.utils.d.a(activity, "hwpush_dialog_limit_title")).setMessage(com.huawei.android.pushselfshow.utils.d.a(activity, "hwpush_dialog_limit_message")).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(com.huawei.android.pushselfshow.utils.d.a(activity, "hwpush_dialog_limit_ok"), new j(this)).setOnDismissListener(new i(this, activity)).create();
        this.t.show();
    }

    /* access modifiers changed from: private */
    public void d(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent("com.huawei.android.push.intent.RICHPUSH");
            intent.putExtra(DataBaseHelper.KEY_TYPE, "favorite");
            com.huawei.android.pushselfshow.b.a aVar = this.g;
            if (aVar != null) {
                intent.putExtra("selfshow_info", aVar.c());
                intent.putExtra("selfshow_token", this.g.d());
            }
            intent.setFlags(268468240);
            intent.putExtra("selfshowMsgOutOfBound", true);
            intent.setPackage(activity.getPackageName());
            activity.finish();
            activity.startActivity(intent);
        }
    }

    public void downLoadFailed() {
        e.a("PushSelfShowLog", "downLoadFailed:");
        this.c = null;
        showErrorHtmlURI(com.huawei.android.pushselfshow.utils.a.a((Context) this.d, "富媒体文件下载失败", "Failed to load the message."));
    }

    public void downLoadSuccess(String str) {
        try {
            e.a("PushSelfShowLog", "downLoadSuccess:" + str + "，and start loadLocalZip");
            loadLocalZip(str);
        } catch (Exception e2) {
            e.c("PushSelfShowLog", "downLoadSuccess failed", e2);
        }
    }

    public void enableJavaJS(String str) {
        ExposedJsApi exposedJsApi;
        try {
            e.a("PushSelfShowLog", "enable JavaJs support and indexFileUrl is " + str);
            String str2 = null;
            if (str != null) {
                str2 = str.substring(0, str.lastIndexOf("/"));
            }
            e.a("PushSelfShowLog", "m_activity is " + this.d);
            e.a("PushSelfShowLog", "webView is " + this.e);
            e.a("PushSelfShowLog", "localPath is " + str2);
            if (this.g.G != 0) {
                e.a("PushSelfShowLog", "pushmsg.needUserId true");
                exposedJsApi = new ExposedJsApi(this.d, this.e, str2, true);
            } else {
                e.a("PushSelfShowLog", "pushmsg.needUserId false");
                exposedJsApi = new ExposedJsApi(this.d, this.e, str2, false);
            }
            this.i = exposedJsApi;
            this.e.addJavascriptInterface(new Console(), "console");
            this.e.addJavascriptInterface(this.i, "_nativeApi");
        } catch (Exception e2) {
            e.c("PushSelfShowLog", "enable JavaJs support failed ", e2);
        }
    }

    public void handleMessage(Message message) {
        e.a("PushSelfShowLog", "handleMessage " + message.what + Constants.ACCEPT_TIME_SEPARATOR_SP + message.toString());
        int i2 = message.what;
        if (i2 == 1) {
            downLoadSuccess((String) message.obj);
        } else if (i2 == 2) {
            downLoadFailed();
        } else if (i2 != 3 && i2 == 1000) {
            c(this.d);
        }
    }

    public void loadLocalZip(String str) {
        if (str != null && str.length() > 0) {
            this.h = com.huawei.android.pushselfshow.richpush.tools.d.a(this.d, str);
            String str2 = this.h;
            if (str2 == null || str2.length() <= 0) {
                e.d("PushSelfShowLog", "check index.html file failed");
                this.c = null;
            } else {
                Uri fromFile = Uri.fromFile(new File(this.h));
                enableJavaJS(this.h);
                this.g.C = fromFile.toString();
                com.huawei.android.pushselfshow.b.a aVar = this.g;
                aVar.E = "text/html_local";
                this.f.a(aVar);
                this.e.loadUrl(fromFile.toString());
                return;
            }
        }
        showErrorHtmlURI(com.huawei.android.pushselfshow.utils.a.a((Context) this.d, "富媒体内容不正确", "Invalid content."));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        try {
            e.a("PushSelfShowLog", "run HtmlViewer onActivityResult");
            if (this.i != null) {
                this.i.onActivityResult(i2, i3, intent);
            }
            if (10003 == i2) {
                if (i3 == 0) {
                    e.b("PushSelfShowLog", "onActivityResult: RESULT_CANCELED");
                    this.o.b(this.m);
                } else if (-1 == i3) {
                    e.b("PushSelfShowLog", "onActivityResult: RESULT_OK");
                    if (this.d.checkSelfPermission("com.huawei.pushagent.permission.RICHMEDIA_PROVIDER") == 0) {
                        e.b("PushSelfShowLog", "onActivityResult: Permission is granted");
                        new Thread(new f(this)).start();
                        return;
                    }
                    this.o.b(this.m);
                } else {
                    return;
                }
                this.u = false;
            }
        } catch (Exception e2) {
            e.c("PushSelfShowLog", e2.toString(), e2);
        }
    }

    public void onCreate(Intent intent) {
        int j2;
        Resources resources;
        int e2;
        if (intent == null) {
            e.b("PushSelfShowLog", "onCreate, intent is null");
            return;
        }
        try {
            this.p = intent.getBooleanExtra("selfshow_from_list", false);
            this.u = intent.getBooleanExtra("collect_img_disable", false);
            e.a("PushSelfShowLog", "mCollectImgDisable:" + this.u);
            this.f = new com.huawei.android.pushselfshow.richpush.tools.a(this.d);
            this.d.setRequestedOrientation(5);
            RelativeLayout relativeLayout = new RelativeLayout(this.d);
            String str = null;
            RelativeLayout relativeLayout2 = (RelativeLayout) this.d.getLayoutInflater().inflate(com.huawei.android.pushselfshow.utils.d.c(this.d, "hwpush_msg_show"), (ViewGroup) null);
            relativeLayout.addView(relativeLayout2);
            this.d.setContentView(relativeLayout);
            this.o = new a(this.d);
            this.o.a((View) relativeLayout);
            this.o.a();
            this.j = (ImageView) relativeLayout2.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.d, "hwpush_bt_back_img"));
            this.k = (ImageView) relativeLayout2.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.d, "hwpush_bt_forward_img"));
            this.l = (ImageView) relativeLayout2.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.d, "hwpush_bt_refresh_img"));
            this.a = (PageProgressView) relativeLayout2.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.d, "hwpush_progressbar"));
            this.m = (ImageView) relativeLayout2.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.d, "hwpush_bt_collect_img"));
            this.n = (TextView) relativeLayout2.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.d, "hwpush_msg_title"));
            com.huawei.android.pushselfshow.utils.a.a((Context) this.d, this.n);
            if (com.huawei.android.pushselfshow.utils.a.d() && -1 != (j2 = com.huawei.android.pushselfshow.utils.a.j(this.d))) {
                if (j2 == 0) {
                    resources = this.d.getResources();
                    e2 = com.huawei.android.pushselfshow.utils.d.e(this.d, "hwpush_black");
                } else {
                    resources = this.d.getResources();
                    e2 = com.huawei.android.pushselfshow.utils.d.e(this.d, "hwpush_white");
                }
                this.n.setTextColor(resources.getColor(e2));
                relativeLayout2.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.d, "hwpush_title_bar_bottom_line")).setVisibility(0);
            }
            this.j.setOnClickListener(new a(this, (b) null));
            this.k.setOnClickListener(new c(this, (b) null));
            this.l.setOnClickListener(new d(this, (b) null));
            this.m.setOnClickListener(new b(this, this.d, (b) null));
            if (this.p || this.u) {
                this.o.a(this.m);
                this.u = true;
            }
            this.e = (WebView) relativeLayout2.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.d, "hwpush_msg_show_view"));
            a();
            if (intent.hasExtra("selfshow_info")) {
                this.g = new com.huawei.android.pushselfshow.b.a(intent.getByteArrayExtra("selfshow_info"), intent.getByteArrayExtra("selfshow_token"));
                if (!this.g.b()) {
                    e.a("PushSelfShowLog", "parseMessage failed");
                    return;
                }
                e.a("PushSelfShowLog", "pushmsg.rpct:" + this.g.E);
                this.f.a(this.g);
            } else {
                e.a("PushSelfShowLog", "pushmsg is null");
                showErrorHtmlURI(com.huawei.android.pushselfshow.utils.a.a((Context) this.d, "富媒体内容不正确", "Invalid content."));
            }
            if (this.g != null) {
                e.a("PushSelfShowLog", "fileurl :" + this.g.C + ", the pushmsg is " + this.g.toString());
            } else {
                e.a("PushSelfShowLog", "pushmsg is null :");
                this.g = new com.huawei.android.pushselfshow.b.a();
            }
            e.b("PushSelfShowLog", "pushmsg.rpct:" + this.g.E);
            if ("application/zip".equals(this.g.E)) {
                if (-1 == com.huawei.android.pushagent.c.a.b.a((Context) this.d)) {
                    e.a("PushSelfShowLog", "no network. can not load message");
                    return;
                }
                this.dtl = new com.huawei.android.pushselfshow.utils.b.b(this.c, this.d, this.g.C, com.huawei.android.pushselfshow.richpush.tools.b.a("application/zip"));
                this.dtl.b();
            } else if ("application/zip_local".equals(this.g.E)) {
                loadLocalZip(this.g.C);
            } else {
                if (!"text/html".equals(this.g.E)) {
                    if (!"text/html_local".equals(this.g.E)) {
                        showErrorHtmlURI(com.huawei.android.pushselfshow.utils.a.a((Context) this.d, "富媒体内容不正确", "Invalid content."));
                        return;
                    }
                }
                if ("text/html_local".equals(this.g.E)) {
                    str = this.g.C;
                }
                enableJavaJS(str);
                this.e.loadUrl(this.g.C);
            }
        } catch (RuntimeException e3) {
            e.c("PushSelfShowLog", "call" + HtmlViewer.class.getName() + " onCreate(Intent intent) err: " + e3.toString(), e3);
        }
    }

    public void onDestroy() {
        try {
            if (this.s != null && this.s.isShowing()) {
                this.s.dismiss();
            }
            if (this.t != null && this.t.isShowing()) {
                this.t.dismiss();
            }
            if (this.i != null) {
                this.i.onDestroy();
            }
            if (this.h != null && !this.r) {
                String substring = this.h.substring(0, this.h.lastIndexOf("/"));
                e.a("PushSelfShowLog", "try to remove dir " + substring);
                com.huawei.android.pushselfshow.utils.a.a(new File(substring));
            }
            if (this.dtl != null && this.dtl.e) {
                e.a("PushSelfShowLog", "cancel ProgressDialog loading dialog when richpush file is downloading");
                this.dtl.a();
                this.c = null;
            }
            this.e.stopLoading();
            this.e = null;
        } catch (Exception | IndexOutOfBoundsException unused) {
            e.a("PushSelfShowLog", "remove unsuccess ,maybe removed before");
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || keyEvent.getAction() != 0) {
            return true;
        }
        if (this.p) {
            Intent intent = new Intent("com.huawei.android.push.intent.RICHPUSH");
            intent.putExtra(DataBaseHelper.KEY_TYPE, "favorite");
            intent.setPackage(this.d.getPackageName());
            this.d.finish();
            this.d.startActivity(intent);
            return true;
        }
        this.d.finish();
        return true;
    }

    public void onPause() {
        ExposedJsApi exposedJsApi = this.i;
        if (exposedJsApi != null) {
            exposedJsApi.onPause();
        }
        try {
            this.e.getClass().getMethod("onPause", new Class[0]).invoke(this.e, (Object[]) null);
        } catch (Exception e2) {
            e.c("PushSelfShowLog", "htmlviewer onpause error", e2);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        e.a("PushSelfShowLog", "enter HtmlViewer onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            this.o.b(this.m);
            this.u = false;
            return;
        }
        new Thread(new g(this)).start();
    }

    public void onResume() {
        ExposedJsApi exposedJsApi = this.i;
        if (exposedJsApi != null) {
            exposedJsApi.onResume();
        }
        try {
            this.e.getClass().getMethod("onResume", new Class[0]).invoke(this.e, (Object[]) null);
        } catch (Exception e2) {
            e.c("PushSelfShowLog", "htmlviewer onResume error", e2);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("collect_img_disable", this.u);
    }

    public void onStop() {
        ExposedJsApi exposedJsApi = this.i;
        if (exposedJsApi != null) {
            exposedJsApi.onPause();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x011b A[SYNTHETIC, Splitter:B:30:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x016a A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0210 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x018f A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0210 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01b3 A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0210 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String prepareJS(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "push1.0.js"
            java.lang.String r3 = "/"
            java.lang.String r4 = "."
            java.lang.String r5 = "prepareJS"
            java.lang.String r6 = "http://open.hicloud.com/android/push1.0.js"
            java.lang.String r7 = "PushSelfShowLog"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            android.app.Activity r9 = r1.d     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r9 = com.huawei.android.pushselfshow.utils.b.b.b(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            android.app.Activity r9 = r1.d     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r9 = r9.getPackageName()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r10 = ""
            java.lang.String r9 = r9.replace(r4, r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r8 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.io.File r9 = new java.io.File     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.<init>(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            boolean r9 = r9.exists()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r9 != 0) goto L_0x0051
            java.io.File r9 = new java.io.File     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.<init>(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            boolean r9 = r9.mkdirs()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r9 == 0) goto L_0x0051
            java.lang.String r9 = "mkdir true"
            com.huawei.android.pushagent.c.a.e.e(r7, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
        L_0x0051:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r10 = "prepareJS fileHeader is "
            r9.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r9 = r9.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            com.huawei.android.pushagent.c.a.e.e(r7, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9 = 0
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r10.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r11 = java.io.File.separator     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r10.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r11 = "newpush.js"
            r10.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r10 = r10.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.io.File r11 = new java.io.File     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            boolean r12 = r11.exists()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r13 = -1
            if (r12 == 0) goto L_0x00e4
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            long r11 = r11.lastModified()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            long r14 = r14 - r11
            r11 = 1300000000(0x4d7c6d00, double:6.422853396E-315)
            int r16 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r16 <= 0) goto L_0x00d2
            java.lang.String r11 = "new push.js may be out of date ,or try to update"
            com.huawei.android.pushagent.c.a.e.a(r7, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            android.app.Activity r11 = r1.d     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            int r11 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r11 == r13) goto L_0x0117
            com.huawei.android.pushselfshow.utils.b.b r11 = new com.huawei.android.pushselfshow.utils.b.b     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            android.app.Activity r12 = r1.d     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            boolean r11 = r11.b(r12, r6, r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r11 == 0) goto L_0x0117
            java.io.File r11 = new java.io.File     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            boolean r11 = r11.exists()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r11 == 0) goto L_0x0117
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r11 = "prepareJS dlUtil.downLoadSgThread  pushUrl is "
            r9.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r9 = r9.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
        L_0x00ce:
            com.huawei.android.pushagent.c.a.e.e(r7, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            goto L_0x0116
        L_0x00d2:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r11 = "prepareJS  not arrival update  pushUrl is "
            r9.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r9 = r9.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            goto L_0x00ce
        L_0x00e4:
            android.app.Activity r11 = r1.d     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            int r11 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r11 == r13) goto L_0x0117
            com.huawei.android.pushselfshow.utils.b.b r11 = new com.huawei.android.pushselfshow.utils.b.b     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            android.app.Activity r12 = r1.d     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            boolean r11 = r11.b(r12, r6, r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r11 == 0) goto L_0x0117
            java.io.File r11 = new java.io.File     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            boolean r11 = r11.exists()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r11 == 0) goto L_0x0117
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r11 = "prepareJS new js isnot exist, so  downloaded  pushUrl is "
            r9.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r9 = r9.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            goto L_0x00ce
        L_0x0116:
            r9 = r10
        L_0x0117:
            java.lang.String r10 = "  pushUrl is "
            if (r9 == 0) goto L_0x0125
            int r11 = r9.length()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r11 != 0) goto L_0x0122
            goto L_0x0125
        L_0x0122:
            r8 = r9
            goto L_0x01ad
        L_0x0125:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r11 = r11.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            com.huawei.android.pushagent.c.a.e.e(r7, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r8 = java.io.File.separator     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r8 = r11.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r12 = "  pushjsPath is "
            r11.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r11 = r11.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            com.huawei.android.pushagent.c.a.e.e(r7, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.io.File r11 = new java.io.File     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            boolean r11 = r11.exists()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r11 == 0) goto L_0x018f
            java.io.File r11 = new java.io.File     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            boolean r11 = r11.delete()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r11 == 0) goto L_0x017a
            java.lang.String r11 = "delete pushjsPath success"
            com.huawei.android.pushagent.c.a.e.a(r7, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
        L_0x017a:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r12 = "prepareJS new js  is not prepared so use local  pushUrl is "
            r11.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r9 = r11.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
        L_0x018b:
            com.huawei.android.pushagent.c.a.e.e(r7, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            goto L_0x0192
        L_0x018f:
            java.lang.String r9 = " new File(pushjsPath) not exists() "
            goto L_0x018b
        L_0x0192:
            android.app.Activity r9 = r1.d     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r12 = "pushresources"
            r11.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r12 = java.io.File.separator     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r11.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r2 = r11.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            com.huawei.android.pushselfshow.utils.a.b(r9, r2, r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
        L_0x01ad:
            int r2 = r8.length()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            if (r2 <= 0) goto L_0x0216
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r2.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r2.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r2.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            com.huawei.android.pushagent.c.a.e.e(r7, r2)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            int r2 = r8.lastIndexOf(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r2 = r8.substring(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r10 = 7
            int r3 = r0.lastIndexOf(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r0 = r0.substring(r10, r3)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.append(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r9.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r0 = r9.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r3 = " pushUrlName is %s,destPath is %s "
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r10 = 0
            r9[r10] = r2     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r10 = 1
            r9[r10] = r0     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r7, (java.lang.String) r3, (java.lang.Object[]) r9)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.io.File r3 = new java.io.File     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r3.<init>(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.io.File r8 = new java.io.File     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r8.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            com.huawei.android.pushselfshow.utils.a.a((java.io.File) r3, (java.io.File) r8)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r0.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r0.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            r0.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            java.lang.String r0 = r0.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0212, Exception -> 0x0210 }
            return r0
        L_0x0210:
            r0 = move-exception
            goto L_0x0213
        L_0x0212:
            r0 = move-exception
        L_0x0213:
            com.huawei.android.pushagent.c.a.e.d(r7, r5, r0)
        L_0x0216:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.richpush.html.HtmlViewer.prepareJS(java.lang.String):java.lang.String");
    }

    public void setActivity(Activity activity) {
        this.d = activity;
    }

    public void setProgress(int i2) {
        if (i2 >= 100) {
            this.a.a(10000);
            this.a.setVisibility(4);
            this.q = false;
            return;
        }
        if (!this.q) {
            this.a.setVisibility(0);
            this.q = true;
        }
        this.a.a((i2 * 10000) / 100);
    }

    public void showErrorHtmlURI(String str) {
        Activity activity;
        String str2;
        com.huawei.android.pushselfshow.b.a aVar;
        try {
            String a2 = new com.huawei.android.pushselfshow.richpush.tools.c(this.d, str).a();
            e.a("PushSelfShowLog", "showErrorHtmlURI,filePath is " + a2);
            if (a2 != null && a2.length() > 0) {
                Uri fromFile = Uri.fromFile(new File(a2));
                enableJavaJS((String) null);
                this.e.loadUrl(fromFile.toString());
            }
        } catch (Exception e2) {
            e.c("PushSelfShowLog", "showErrorHtmlURI failed", e2);
        }
        if (com.huawei.android.pushselfshow.utils.a.a((Context) this.d, "富媒体文件下载失败", "Failed to load the message.").equals(str)) {
            activity = this.d;
            aVar = this.g;
            str2 = "12";
        } else {
            activity = this.d;
            aVar = this.g;
            str2 = "6";
        }
        com.huawei.android.pushselfshow.utils.a.a((Context) activity, str2, aVar);
    }
}
