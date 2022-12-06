package com.huawei.android.pushselfshow.richpush.favorites;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.pushselfshow.richpush.html.HtmlViewer;
import com.huawei.android.pushselfshow.utils.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import object.p2pipcam.utils.DataBaseHelper;

public class FavoritesActivity implements c.a {
    com.huawei.android.pushselfshow.utils.c a = new com.huawei.android.pushselfshow.utils.c(this);
    /* access modifiers changed from: private */
    public Activity b;
    /* access modifiers changed from: private */
    public ImageView c;
    /* access modifiers changed from: private */
    public TextView d;
    /* access modifiers changed from: private */
    public TextView e;
    /* access modifiers changed from: private */
    public b f;
    /* access modifiers changed from: private */
    public ListView g;
    private LinearLayout h;
    /* access modifiers changed from: private */
    public a i;
    /* access modifiers changed from: private */
    public ImageView j;
    private ImageView k;
    private TextView l;
    /* access modifiers changed from: private */
    public boolean m = false;
    private byte[] n = null;
    private byte[] o = null;
    /* access modifiers changed from: private */
    public AlertDialog p = null;

    private class a implements View.OnClickListener {
        private Context b;

        private a(Context context) {
            this.b = context;
        }

        /* synthetic */ a(FavoritesActivity favoritesActivity, Context context, c cVar) {
            this(context);
        }

        public void onClick(View view) {
            if (FavoritesActivity.this.m) {
                FavoritesActivity.this.e();
                return;
            }
            FavoritesActivity.this.c.setVisibility(4);
            FavoritesActivity.this.e.setVisibility(8);
            FavoritesActivity.this.e.setText("");
            TextView g = FavoritesActivity.this.d;
            Context context = this.b;
            g.setText(context.getString(com.huawei.android.pushselfshow.utils.d.a(context, "hwpush_msg_collect")));
            FavoritesActivity.this.f.c();
            FavoritesActivity.this.i.a(true);
            FavoritesActivity.this.g.setOnItemClickListener(new e(FavoritesActivity.this, (c) null));
            FavoritesActivity.this.g.setLongClickable(true);
        }
    }

    private class b implements View.OnClickListener {
        /* access modifiers changed from: private */
        public Context b;

        private b(Context context) {
            this.b = context;
        }

        /* synthetic */ b(FavoritesActivity favoritesActivity, Context context, c cVar) {
            this(context);
        }

        public void onClick(View view) {
            String str;
            try {
                str = this.b.getResources().getQuantityString(com.huawei.android.pushselfshow.utils.d.b(this.b, "hwpush_delete_tip"), FavoritesActivity.this.c());
            } catch (Resources.NotFoundException e) {
                com.huawei.android.pushagent.c.a.e.c("PushSelfShowLog", e.toString(), e);
                str = "";
            }
            FavoritesActivity favoritesActivity = FavoritesActivity.this;
            Context context = this.b;
            AlertDialog unused = favoritesActivity.p = new AlertDialog.Builder(context, com.huawei.android.pushselfshow.utils.a.h(context)).setTitle(str).setPositiveButton(com.huawei.android.pushselfshow.utils.d.a(this.b, "hwpush_delete"), new d(this)).setNegativeButton(com.huawei.android.pushselfshow.utils.d.a(this.b, "hwpush_cancel"), (DialogInterface.OnClickListener) null).create();
            FavoritesActivity.this.p.show();
            FavoritesActivity.this.p.getButton(-1).setTextColor(Color.parseColor("#ffd43e25"));
        }
    }

    private class c implements AdapterView.OnItemClickListener {
        private Context b;

        private c(Context context) {
            this.b = context;
        }

        /* synthetic */ c(FavoritesActivity favoritesActivity, Context context, c cVar) {
            this(context);
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            CheckBox checkBox = (CheckBox) view.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.b, "hwpush_delCheck"));
            f a2 = FavoritesActivity.this.i.getItem(i);
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
                a2.a(false);
            } else {
                checkBox.setChecked(true);
                a2.a(true);
            }
            FavoritesActivity.this.i.a(i, a2);
            List<f> a3 = FavoritesActivity.this.i.a();
            int i2 = 0;
            for (f a4 : a3) {
                if (a4.a()) {
                    i2++;
                }
            }
            if (i2 > 0) {
                FavoritesActivity.this.e.setVisibility(0);
                FavoritesActivity.this.e.setText(String.valueOf(i2));
                FavoritesActivity.this.f.b(FavoritesActivity.this.j);
                if (i2 == a3.size()) {
                    FavoritesActivity.this.a(this.b, true);
                    return;
                }
            } else {
                FavoritesActivity.this.e.setVisibility(8);
                FavoritesActivity.this.e.setText("");
                FavoritesActivity.this.f.a(FavoritesActivity.this.j);
            }
            FavoritesActivity.this.a(this.b, false);
        }
    }

    private class d implements AdapterView.OnItemLongClickListener {
        private d() {
        }

        /* synthetic */ d(FavoritesActivity favoritesActivity, c cVar) {
            this();
        }

        public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
            FavoritesActivity.this.d();
            FavoritesActivity.this.f.b(FavoritesActivity.this.j);
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(i));
            FavoritesActivity.this.i.a(false, (Set) hashSet);
            FavoritesActivity.this.e.setVisibility(0);
            FavoritesActivity.this.e.setText("1");
            return true;
        }
    }

    private class e implements AdapterView.OnItemClickListener {
        private e() {
        }

        /* synthetic */ e(FavoritesActivity favoritesActivity, c cVar) {
            this();
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            f a2 = FavoritesActivity.this.i.getItem(i);
            Intent intent = new Intent("com.huawei.android.push.intent.RICHPUSH");
            intent.putExtra(DataBaseHelper.KEY_TYPE, a2.b().D);
            intent.putExtra("selfshow_info", a2.b().c());
            intent.putExtra("selfshow_token", a2.b().d());
            intent.putExtra("selfshow_from_list", true);
            intent.setFlags(268468240);
            intent.setPackage(FavoritesActivity.this.b.getPackageName());
            FavoritesActivity.this.b.finish();
            FavoritesActivity.this.b.startActivity(intent);
        }
    }

    private class f implements View.OnClickListener {
        private Context b;

        private f(Context context) {
            this.b = context;
        }

        /* synthetic */ f(FavoritesActivity favoritesActivity, Context context, c cVar) {
            this(context);
        }

        public void onClick(View view) {
            boolean z;
            Iterator it = FavoritesActivity.this.i.a().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((f) it.next()).a()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            FavoritesActivity.this.i.a(z, (Set) null);
            if (z) {
                FavoritesActivity.this.e.setVisibility(0);
                FavoritesActivity.this.e.setText(String.valueOf(FavoritesActivity.this.i.getCount()));
                FavoritesActivity.this.f.b(FavoritesActivity.this.j);
                FavoritesActivity.this.a(this.b, true);
                return;
            }
            FavoritesActivity.this.e.setVisibility(8);
            FavoritesActivity.this.e.setText("");
            FavoritesActivity.this.f.a(FavoritesActivity.this.j);
            FavoritesActivity.this.a(this.b, false);
        }
    }

    private ContentValues a(Cursor cursor, String str) {
        ContentValues contentValues = new ContentValues();
        if (cursor == null || TextUtils.isEmpty(str)) {
            com.huawei.android.pushagent.c.a.e.d("PushSelfShowLog", "getContentValues, cursor or table is null");
            return contentValues;
        }
        if ("notify".equals(str)) {
            String string = cursor.getString(cursor.getColumnIndex(PushConstants.WEB_URL));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("bmp"));
            contentValues.put(PushConstants.WEB_URL, string);
            contentValues.put("bmp", blob);
        } else if ("pushmsg".equals(str)) {
            String string2 = cursor.getString(cursor.getColumnIndex(PushConstants.WEB_URL));
            byte[] blob2 = cursor.getBlob(cursor.getColumnIndex("msg"));
            contentValues.put(PushConstants.WEB_URL, string2);
            try {
                contentValues.put(Constants.EXTRA_KEY_TOKEN, " ".getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                com.huawei.android.pushagent.c.a.e.c("PushSelfShowLog", e2.toString(), e2);
            }
            contentValues.put("msg", blob2);
        }
        return contentValues;
    }

    private View a() {
        View inflate = this.b.getLayoutInflater().inflate(com.huawei.android.pushselfshow.utils.d.c(this.b, "hwpush_collection_listview"), (ViewGroup) null);
        this.g = (ListView) inflate.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.b, "hwpush_collection_list"));
        this.i = new a(this.b);
        this.g.setAdapter(this.i);
        this.g.setLongClickable(true);
        this.g.setOnItemLongClickListener(new d(this, (c) null));
        this.g.setOnItemClickListener(new e(this, (c) null));
        return inflate;
    }

    /* access modifiers changed from: private */
    public synchronized void a(Context context) {
        try {
            com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "enter syncDb");
            String c2 = com.huawei.android.pushselfshow.utils.a.c(context, "push.db");
            File file = new File(c2);
            if (!file.exists()) {
                com.huawei.android.pushagent.c.a.e.b("PushSelfShowLog", "sdcard db is not exist");
                return;
            }
            com.huawei.android.pushagent.c.a.e.b("PushSelfShowLog", "sync db from sdcard");
            a(context, c2, "notify");
            a(context, c2, "pushmsg");
            if (!file.delete()) {
                com.huawei.android.pushagent.c.a.e.d("PushSelfShowLog", "delete sdcard db failed!");
            }
        } catch (Exception e2) {
            com.huawei.android.pushagent.c.a.e.c("PushSelfShowLog", e2.toString(), e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v17, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r14v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r14v12 */
    /* JADX WARNING: type inference failed for: r14v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0133 A[SYNTHETIC, Splitter:B:100:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0144 A[SYNTHETIC, Splitter:B:107:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0157 A[SYNTHETIC, Splitter:B:118:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0168 A[SYNTHETIC, Splitter:B:125:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0179 A[SYNTHETIC, Splitter:B:132:0x0179] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x018a A[SYNTHETIC, Splitter:B:139:0x018a] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0111 A[SYNTHETIC, Splitter:B:86:0x0111] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0122 A[SYNTHETIC, Splitter:B:93:0x0122] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.content.Context r18, java.lang.String r19, java.lang.String r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            monitor-enter(r17)
            java.lang.String r2 = "PushSelfShowLog"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a3 }
            r3.<init>()     // Catch:{ all -> 0x01a3 }
            java.lang.String r4 = "enter syncTable:"
            r3.append(r4)     // Catch:{ all -> 0x01a3 }
            r3.append(r0)     // Catch:{ all -> 0x01a3 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.b(r2, r3)     // Catch:{ all -> 0x01a3 }
            boolean r2 = android.text.TextUtils.isEmpty(r19)     // Catch:{ all -> 0x01a3 }
            if (r2 != 0) goto L_0x019a
            boolean r2 = android.text.TextUtils.isEmpty(r20)     // Catch:{ all -> 0x01a3 }
            if (r2 == 0) goto L_0x0029
            goto L_0x019a
        L_0x0029:
            r12 = 0
            com.huawei.android.pushselfshow.utils.a.b r2 = com.huawei.android.pushselfshow.utils.a.b.a((android.content.Context) r18)     // Catch:{ Exception -> 0x0101, all -> 0x00fa }
            android.database.sqlite.SQLiteDatabase r13 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0101, all -> 0x00fa }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r2 = r13
            r3 = r20
            android.database.Cursor r14 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00f7, all -> 0x00f3 }
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r14 == 0) goto L_0x004b
            int r3 = r14.getCount()     // Catch:{ Exception -> 0x00ef, all -> 0x00e9 }
            int r2 = r2 - r3
            r15 = r2
            goto L_0x004d
        L_0x004b:
            r15 = 1000(0x3e8, float:1.401E-42)
        L_0x004d:
            java.lang.String r2 = "PushSelfShowLog"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ef, all -> 0x00e9 }
            r3.<init>()     // Catch:{ Exception -> 0x00ef, all -> 0x00e9 }
            java.lang.String r4 = "canInsertDataNum is:"
            r3.append(r4)     // Catch:{ Exception -> 0x00ef, all -> 0x00e9 }
            r3.append(r15)     // Catch:{ Exception -> 0x00ef, all -> 0x00e9 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00ef, all -> 0x00e9 }
            com.huawei.android.pushagent.c.a.e.a(r2, r3)     // Catch:{ Exception -> 0x00ef, all -> 0x00e9 }
            if (r15 <= 0) goto L_0x00a0
            com.huawei.android.pushselfshow.utils.a.b r2 = com.huawei.android.pushselfshow.utils.a.b.a((android.content.Context) r18, (java.lang.String) r19)     // Catch:{ Exception -> 0x00ef, all -> 0x00e9 }
            android.database.sqlite.SQLiteDatabase r16 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x00ef, all -> 0x00e9 }
            r3 = 1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r16
            r4 = r20
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x009d }
            if (r2 == 0) goto L_0x009b
        L_0x007f:
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x0097, all -> 0x0093 }
            if (r3 == 0) goto L_0x009b
            int r3 = r2.getPosition()     // Catch:{ Exception -> 0x0097, all -> 0x0093 }
            if (r3 >= r15) goto L_0x009b
            android.content.ContentValues r3 = r1.a((android.database.Cursor) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0097, all -> 0x0093 }
            r13.insert(r0, r12, r3)     // Catch:{ Exception -> 0x0097, all -> 0x0093 }
            goto L_0x007f
        L_0x0093:
            r0 = move-exception
            r12 = r2
            goto L_0x0154
        L_0x0097:
            r0 = move-exception
            r12 = r2
            goto L_0x0106
        L_0x009b:
            r12 = r2
            goto L_0x00a2
        L_0x009d:
            r0 = move-exception
            goto L_0x0106
        L_0x00a0:
            r16 = r12
        L_0x00a2:
            if (r12 == 0) goto L_0x00b3
            r12.close()     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00b3
        L_0x00a8:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r3, r2)     // Catch:{ all -> 0x01a3 }
        L_0x00b3:
            if (r14 == 0) goto L_0x00c4
            r14.close()     // Catch:{ Exception -> 0x00b9 }
            goto L_0x00c4
        L_0x00b9:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r3, r2)     // Catch:{ all -> 0x01a3 }
        L_0x00c4:
            if (r16 == 0) goto L_0x00d5
            r16.close()     // Catch:{ Exception -> 0x00ca }
            goto L_0x00d5
        L_0x00ca:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r3, r2)     // Catch:{ all -> 0x01a3 }
        L_0x00d5:
            if (r13 == 0) goto L_0x0151
            r13.close()     // Catch:{ Exception -> 0x00dc }
            goto L_0x0151
        L_0x00dc:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x01a3 }
        L_0x00e4:
            com.huawei.android.pushagent.c.a.e.c(r0, r3, r2)     // Catch:{ all -> 0x01a3 }
            goto L_0x0151
        L_0x00e9:
            r0 = move-exception
            r2 = r0
            r16 = r12
            goto L_0x0155
        L_0x00ef:
            r0 = move-exception
            r16 = r12
            goto L_0x0106
        L_0x00f3:
            r0 = move-exception
            r2 = r0
            r14 = r12
            goto L_0x00fe
        L_0x00f7:
            r0 = move-exception
            r14 = r12
            goto L_0x0104
        L_0x00fa:
            r0 = move-exception
            r2 = r0
            r13 = r12
            r14 = r13
        L_0x00fe:
            r16 = r14
            goto L_0x0155
        L_0x0101:
            r0 = move-exception
            r13 = r12
            r14 = r13
        L_0x0104:
            r16 = r14
        L_0x0106:
            java.lang.String r2 = "PushSelfShowLog"
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0153 }
            com.huawei.android.pushagent.c.a.e.c(r2, r3, r0)     // Catch:{ all -> 0x0153 }
            if (r12 == 0) goto L_0x0120
            r12.close()     // Catch:{ Exception -> 0x0115 }
            goto L_0x0120
        L_0x0115:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r3, r2)     // Catch:{ all -> 0x01a3 }
        L_0x0120:
            if (r14 == 0) goto L_0x0131
            r14.close()     // Catch:{ Exception -> 0x0126 }
            goto L_0x0131
        L_0x0126:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r3, r2)     // Catch:{ all -> 0x01a3 }
        L_0x0131:
            if (r16 == 0) goto L_0x0142
            r16.close()     // Catch:{ Exception -> 0x0137 }
            goto L_0x0142
        L_0x0137:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r3, r2)     // Catch:{ all -> 0x01a3 }
        L_0x0142:
            if (r13 == 0) goto L_0x0151
            r13.close()     // Catch:{ Exception -> 0x0148 }
            goto L_0x0151
        L_0x0148:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x01a3 }
            goto L_0x00e4
        L_0x0151:
            monitor-exit(r17)
            return
        L_0x0153:
            r0 = move-exception
        L_0x0154:
            r2 = r0
        L_0x0155:
            if (r12 == 0) goto L_0x0166
            r12.close()     // Catch:{ Exception -> 0x015b }
            goto L_0x0166
        L_0x015b:
            r0 = move-exception
            r3 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r4 = r3.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r4, r3)     // Catch:{ all -> 0x01a3 }
        L_0x0166:
            if (r14 == 0) goto L_0x0177
            r14.close()     // Catch:{ Exception -> 0x016c }
            goto L_0x0177
        L_0x016c:
            r0 = move-exception
            r3 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r4 = r3.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r4, r3)     // Catch:{ all -> 0x01a3 }
        L_0x0177:
            if (r16 == 0) goto L_0x0188
            r16.close()     // Catch:{ Exception -> 0x017d }
            goto L_0x0188
        L_0x017d:
            r0 = move-exception
            r3 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r4 = r3.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r4, r3)     // Catch:{ all -> 0x01a3 }
        L_0x0188:
            if (r13 == 0) goto L_0x0199
            r13.close()     // Catch:{ Exception -> 0x018e }
            goto L_0x0199
        L_0x018e:
            r0 = move-exception
            r3 = r0
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r4 = r3.toString()     // Catch:{ all -> 0x01a3 }
            com.huawei.android.pushagent.c.a.e.c(r0, r4, r3)     // Catch:{ all -> 0x01a3 }
        L_0x0199:
            throw r2     // Catch:{ all -> 0x01a3 }
        L_0x019a:
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r2 = "syncTable, dbPath or table is null"
            com.huawei.android.pushagent.c.a.e.d(r0, r2)     // Catch:{ all -> 0x01a3 }
            monitor-exit(r17)
            return
        L_0x01a3:
            r0 = move-exception
            monitor-exit(r17)
            goto L_0x01a7
        L_0x01a6:
            throw r0
        L_0x01a7:
            goto L_0x01a6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.richpush.favorites.FavoritesActivity.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void a(Context context, boolean z) {
        String str;
        int color;
        if (z) {
            this.l.setText(com.huawei.android.pushselfshow.utils.d.a(context, "hwpush_unselectall"));
            this.l.setTextColor(context.getResources().getColor(com.huawei.android.pushselfshow.utils.d.e(context, "hwpush_select_color")));
            Drawable drawable = context.getResources().getDrawable(com.huawei.android.pushselfshow.utils.d.f(context, "hwpush_ic_toolbar_multiple1"));
            try {
                int identifier = context.getResources().getIdentifier("colorful_emui", "color", "androidhwext");
                if (!(identifier == 0 || (color = context.getResources().getColor(identifier)) == 0)) {
                    drawable.setTint(color);
                    this.l.setTextColor(color);
                }
            } catch (Resources.NotFoundException e2) {
                str = e2.toString();
                com.huawei.android.pushagent.c.a.e.d("PushSelfShowLog", str);
                this.k.setBackgroundDrawable(drawable);
                return;
            } catch (Exception e3) {
                str = e3.toString();
                com.huawei.android.pushagent.c.a.e.d("PushSelfShowLog", str);
                this.k.setBackgroundDrawable(drawable);
                return;
            }
            this.k.setBackgroundDrawable(drawable);
            return;
        }
        this.k.setBackgroundDrawable(context.getResources().getDrawable(com.huawei.android.pushselfshow.utils.d.f(context, "hwpush_ic_toolbar_multiple")));
        this.l.setText(com.huawei.android.pushselfshow.utils.d.a(context, "hwpush_selectall"));
        this.l.setTextColor(context.getResources().getColor(com.huawei.android.pushselfshow.utils.d.e(context, "hwpush_text_color_history_url")));
    }

    private void b() {
        if (this.i != null && this.g != null && this.h != null) {
            com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "count:" + this.i.getCount());
            if (this.i.getCount() == 0) {
                this.g.setVisibility(8);
                this.h.setVisibility(0);
                return;
            }
            this.g.setVisibility(0);
            this.h.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public int c() {
        a aVar = this.i;
        int i2 = 0;
        if (aVar == null) {
            return 0;
        }
        for (f fVar : aVar.a()) {
            if (fVar != null && fVar.a()) {
                i2++;
            }
        }
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "selectItemsNum:" + i2);
        return i2;
    }

    /* access modifiers changed from: private */
    public void d() {
        this.c.setVisibility(0);
        this.d.setText(com.huawei.android.pushselfshow.utils.d.a(this.b, "hwpush_deltitle"));
        this.f.b();
        this.g.setOnItemClickListener(new c(this, this.b, (c) null));
        this.i.a(false);
        this.g.setLongClickable(false);
        if (1 == this.i.a().size()) {
            a((Context) this.b, true);
        } else {
            a((Context) this.b, false);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        Intent intent = new Intent("com.huawei.android.push.intent.RICHPUSH");
        intent.putExtra(DataBaseHelper.KEY_TYPE, "html");
        intent.putExtra("selfshow_info", this.n);
        intent.putExtra("selfshow_token", this.o);
        intent.setFlags(268468240);
        intent.setPackage(this.b.getPackageName());
        this.b.finish();
        this.b.startActivity(intent);
    }

    public void handleMessage(Message message) {
        try {
            int i2 = message.what;
            if (i2 == 1000) {
                com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "mHandler MSG_LOAD_DONE");
                this.g.setAdapter(this.i);
                b();
                if (this.m) {
                    d();
                }
            } else if (i2 == 1001) {
                com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "mHandler MSG_DELETE_DONE");
                if (this.m) {
                    e();
                    return;
                }
                this.g.setAdapter(this.i);
                this.c.performClick();
                b();
            }
        } catch (Exception e2) {
            com.huawei.android.pushagent.c.a.e.c("PushSelfShowLog", "handleMessage error:" + message.what + Constants.ACCEPT_TIME_SEPARATOR_SP + e2.toString(), e2);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "FavoritesActivity onActivityResult");
    }

    public void onCreate(Intent intent) {
        int j2;
        int color;
        TextView textView;
        Drawable drawable;
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "FavoritesActivity onCreate");
        try {
            this.m = intent.getBooleanExtra("selfshowMsgOutOfBound", false);
            this.n = intent.getByteArrayExtra("selfshow_info");
            this.o = intent.getByteArrayExtra("selfshow_token");
            RelativeLayout relativeLayout = new RelativeLayout(this.b);
            View a2 = a();
            this.h = (LinearLayout) a2.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.b, "hwpush_no_collection_view"));
            com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "mNoCollectionLayout:" + this.h);
            relativeLayout.addView(a2);
            new Thread(new c(this)).start();
            this.b.setContentView(relativeLayout);
            this.f = new b(this.b);
            this.f.a((View) relativeLayout);
            this.f.a();
            this.c = (ImageView) this.b.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.b, "hwpush_bt_delete"));
            this.d = (TextView) this.b.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.b, "hwpush_txt_delitem"));
            this.e = (TextView) this.b.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.b, "hwpush_txt_delnum"));
            com.huawei.android.pushselfshow.utils.a.a((Context) this.b, this.d);
            com.huawei.android.pushselfshow.utils.a.a((Context) this.b, this.e);
            if (com.huawei.android.pushselfshow.utils.a.d() && -1 != (j2 = com.huawei.android.pushselfshow.utils.a.j(this.b))) {
                if (j2 == 0) {
                    color = this.b.getResources().getColor(com.huawei.android.pushselfshow.utils.d.e(this.b, "hwpush_black"));
                    this.c.setImageDrawable(this.b.getResources().getDrawable(com.huawei.android.pushselfshow.utils.d.f(this.b, "hwpush_ic_cancel_light")));
                    textView = this.e;
                    drawable = this.b.getResources().getDrawable(com.huawei.android.pushselfshow.utils.d.f(this.b, "hwpush_pic_ab_number_light"));
                } else {
                    color = this.b.getResources().getColor(com.huawei.android.pushselfshow.utils.d.e(this.b, "hwpush_white"));
                    this.c.setImageDrawable(this.b.getResources().getDrawable(com.huawei.android.pushselfshow.utils.d.f(this.b, "hwpush_ic_cancel")));
                    textView = this.e;
                    drawable = this.b.getResources().getDrawable(com.huawei.android.pushselfshow.utils.d.f(this.b, "hwpush_pic_ab_number"));
                }
                textView.setBackground(drawable);
                this.d.setTextColor(color);
                this.e.setTextColor(color);
            }
            this.k = (ImageView) this.b.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.b, "hwpush_bt_selectall_img"));
            this.j = (ImageView) this.b.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.b, "hwpush_bt_delete_img"));
            this.l = (TextView) this.b.findViewById(com.huawei.android.pushselfshow.utils.d.d(this.b, "hwpush_bt_selectall_txt"));
            this.c.setOnClickListener(new a(this, this.b, (c) null));
            this.k.setOnClickListener(new f(this, this.b, (c) null));
            this.j.setOnClickListener(new b(this, this.b, (c) null));
            if (this.m) {
                this.f.a(this.j);
            }
        } catch (RuntimeException e2) {
            com.huawei.android.pushagent.c.a.e.c("PushSelfShowLog", "call" + HtmlViewer.class.getName() + " onCreate(Intent intent) err: " + e2.toString(), e2);
        }
    }

    public void onDestroy() {
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "FavoritesActivity onDestroy");
        AlertDialog alertDialog = this.p;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.p.dismiss();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "FavoritesActivity onKeyDown");
        if (i2 == 4 && keyEvent.getAction() == 0) {
            boolean z = this.c.getVisibility() == 0;
            if (this.m) {
                e();
            } else if (z) {
                this.c.performClick();
            } else {
                this.b.finish();
            }
        }
        return true;
    }

    public void onPause() {
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "FavoritesActivity onPause");
    }

    public void onRestart() {
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "FavoritesActivity onRestart");
    }

    public void onResume() {
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "FavoritesActivity onResume");
    }

    public void onStart() {
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "FavoritesActivity onStart");
    }

    public void onStop() {
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "FavoritesActivity onStop");
    }

    public void setActivity(Activity activity) {
        this.b = activity;
    }
}
