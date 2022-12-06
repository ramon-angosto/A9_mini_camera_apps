package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.g.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MIMManager */
public final class i {
    private static volatile String d;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<CampaignEx> a;
    /* access modifiers changed from: private */
    public volatile b b;
    /* access modifiers changed from: private */
    public final AtomicBoolean c;
    /* access modifiers changed from: private */
    public volatile Boolean e;
    private CampaignEx f;
    private int g;
    private Context h;

    /* compiled from: MIMManager */
    private static final class a {
        /* access modifiers changed from: private */
        public static final i a = new i();
    }

    private i() {
        this.g = 0;
        this.a = new CopyOnWriteArrayList<>();
        this.c = new AtomicBoolean(false);
    }

    public static i a() {
        return a.a;
    }

    public final void a(CampaignEx campaignEx) {
        try {
            if (this.e != null && campaignEx != null && this.e.booleanValue()) {
                this.f = campaignEx;
                this.a.add(campaignEx);
            }
        } catch (Exception e2) {
            q.d("MIMManager", e2.getMessage());
        }
    }

    public final void b(CampaignEx campaignEx) {
        try {
            if (this.e != null && campaignEx != null && this.e.booleanValue()) {
                this.f = null;
                try {
                    this.a.remove(campaignEx);
                } catch (Exception e2) {
                    q.a("MIMManager", e2.getMessage());
                }
            }
        } catch (Exception e3) {
            q.d("MIMManager", e3.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final CampaignEx b() {
        return this.f;
    }

    public final void c() {
        this.g++;
    }

    public final void d() {
        this.g--;
        if (this.g <= 0) {
            Context context = this.h;
            if (this.b != null && context != null) {
                try {
                    context.unregisterReceiver(this.b);
                } catch (Exception e2) {
                    q.a("MIMManager", e2.getMessage());
                } catch (Throwable th) {
                    this.f = null;
                    this.a.clear();
                    this.a = null;
                    this.b = null;
                    this.h = null;
                    throw th;
                }
                this.f = null;
                this.a.clear();
                this.a = null;
                this.b = null;
                this.h = null;
            }
        }
    }

    public final void a(final Context context) {
        this.h = context;
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
            public final void run() {
                if (i.this.c.compareAndSet(false, true)) {
                    try {
                        Boolean unused = i.this.e = i.this.g();
                    } catch (Exception e) {
                        q.a("MIMManager", e.getMessage());
                    }
                    if (i.this.e != null && i.this.e.booleanValue() && context != null) {
                        try {
                            b unused2 = i.this.b = new b();
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(l.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                            intentFilter.addAction(l.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                            intentFilter.addAction(l.b("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                            context.registerReceiver(i.this.b, intentFilter);
                        } catch (Exception e2) {
                            q.a("MIMManager", e2.getMessage());
                        }
                    }
                }
            }
        });
    }

    public final Boolean e() {
        return this.e;
    }

    /* access modifiers changed from: private */
    public Boolean g() {
        Cursor cursor;
        Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
        Boolean bool = null;
        if (g2 != null) {
            try {
                if (g2.getContentResolver() != null) {
                    try {
                        cursor = g2.getContentResolver().query(Uri.parse(l.b("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), (String[]) null, (String) null, (String[]) null, (String) null);
                    } catch (Exception unused) {
                        cursor = null;
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("support"));
                                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("null") && (string.equalsIgnoreCase("false") || string.equalsIgnoreCase("true"))) {
                                    bool = Boolean.valueOf(Boolean.parseBoolean(string));
                                }
                            } catch (Exception e2) {
                                q.a("MIMManager", e2.getMessage());
                            }
                            try {
                                d = cursor.getString(cursor.getColumnIndex("detailStyle"));
                            } catch (Exception e3) {
                                q.a("MIMManager", e3.getMessage());
                            }
                        }
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                            q.a("MIMManager", e4.getMessage());
                        }
                    }
                }
            } catch (Exception e5) {
                q.d("MIMManager", e5.getMessage());
            }
        }
        return bool;
    }

    public final String f() {
        try {
            if (d == null) {
                return "";
            }
            return String.format("[%s]", new Object[]{d});
        } catch (Exception unused) {
            return "";
        }
    }

    /* compiled from: MIMManager */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        public final void onReceive(Context context, Intent intent) {
            Runnable runnable;
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && !action.equals(l.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN=")) && !action.equals(l.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN=")) && action.equals(l.b("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"))) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        int i = extras.getInt("statusCode", -1);
                        String string = extras.getString("packageName", "");
                        if (i == -1) {
                            return;
                        }
                        if (!TextUtils.isEmpty(string)) {
                            CampaignEx a = a.a.a(string);
                            if (a != null) {
                                i a2 = a.a;
                                if (i == 3001) {
                                    runnable = new Runnable(context, a) {
                                        final /* synthetic */ Context a;
                                        final /* synthetic */ CampaignEx b;

                                        {
                                            this.a = r2;
                                            this.b = r3;
                                        }

                                        public final void run() {
                                            String[] m;
                                            try {
                                                i iVar = i.this;
                                                Context context = this.a;
                                                CampaignEx campaignEx = this.b;
                                                if (campaignEx != null) {
                                                    try {
                                                        com.mbridge.msdk.foundation.entity.i nativeVideoTracking = campaignEx.getNativeVideoTracking();
                                                        if (nativeVideoTracking != null && (m = nativeVideoTracking.m()) != null) {
                                                            for (String a2 : m) {
                                                                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), a2, false, false);
                                                            }
                                                        }
                                                    } catch (Exception e) {
                                                        q.d("MIMManager", e.getMessage());
                                                    }
                                                }
                                            } catch (Exception e2) {
                                                q.d("MIMManager", e2.getMessage());
                                            }
                                        }
                                    };
                                } else if (i == 3002) {
                                    runnable = new Runnable(context, a) {
                                        final /* synthetic */ Context a;
                                        final /* synthetic */ CampaignEx b;

                                        {
                                            this.a = r2;
                                            this.b = r3;
                                        }

                                        public final void run() {
                                            String[] n;
                                            try {
                                                i iVar = i.this;
                                                Context context = this.a;
                                                CampaignEx campaignEx = this.b;
                                                if (campaignEx != null) {
                                                    try {
                                                        com.mbridge.msdk.foundation.entity.i nativeVideoTracking = campaignEx.getNativeVideoTracking();
                                                        if (nativeVideoTracking != null && (n = nativeVideoTracking.n()) != null) {
                                                            for (String a2 : n) {
                                                                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), a2, false, false);
                                                            }
                                                        }
                                                    } catch (Exception e) {
                                                        q.d("MIMManager", e.getMessage());
                                                    }
                                                }
                                            } catch (Exception e2) {
                                                q.d("MIMManager", e2.getMessage());
                                            }
                                        }
                                    };
                                } else if (i != 3008) {
                                    runnable = null;
                                } else {
                                    runnable = new Runnable(context, a) {
                                        final /* synthetic */ Context a;
                                        final /* synthetic */ CampaignEx b;

                                        {
                                            this.a = r2;
                                            this.b = r3;
                                        }

                                        public final void run() {
                                            String[] o;
                                            try {
                                                i iVar = i.this;
                                                Context context = this.a;
                                                CampaignEx campaignEx = this.b;
                                                if (campaignEx != null) {
                                                    try {
                                                        com.mbridge.msdk.foundation.entity.i nativeVideoTracking = campaignEx.getNativeVideoTracking();
                                                        if (!(nativeVideoTracking == null || (o = nativeVideoTracking.o()) == null)) {
                                                            for (String a2 : o) {
                                                                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), a2, false, false);
                                                            }
                                                        }
                                                    } catch (Exception e) {
                                                        q.d("MIMManager", e.getMessage());
                                                    }
                                                }
                                                if (i.this.a == null || !i.this.a.contains(this.b)) {
                                                    return;
                                                }
                                            } catch (Exception e2) {
                                                q.d("MIMManager", e2.getMessage());
                                                if (i.this.a == null || !i.this.a.contains(this.b)) {
                                                    return;
                                                }
                                            } catch (Throwable th) {
                                                if (i.this.a != null && i.this.a.contains(this.b)) {
                                                    i.this.a.remove(this.b);
                                                }
                                                throw th;
                                            }
                                            i.this.a.remove(this.b);
                                        }
                                    };
                                }
                                if (runnable != null) {
                                    com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
                                }
                                com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable(context, "dm_page_status", a.a.b(), i) {
                                    final /* synthetic */ Context a;
                                    final /* synthetic */ String b;
                                    final /* synthetic */ CampaignEx c;
                                    final /* synthetic */ int d;

                                    {
                                        this.a = r2;
                                        this.b = r3;
                                        this.c = r4;
                                        this.d = r5;
                                    }

                                    public final void run() {
                                        try {
                                            if (this.a != null && !TextUtils.isEmpty(this.b) && this.c != null) {
                                                StringBuffer stringBuffer = new StringBuffer();
                                                stringBuffer.append("key=2000100&");
                                                stringBuffer.append("network_type=");
                                                stringBuffer.append(m.n(this.a));
                                                stringBuffer.append("&");
                                                if (!TextUtils.isEmpty(this.c.getRequestIdNotice())) {
                                                    stringBuffer.append("rid_n=");
                                                    stringBuffer.append(this.c.getRequestIdNotice());
                                                    stringBuffer.append("&");
                                                }
                                                if (!TextUtils.isEmpty(this.c.getRequestId())) {
                                                    stringBuffer.append("rid=");
                                                    stringBuffer.append(this.c.getRequestId());
                                                    stringBuffer.append("&");
                                                }
                                                if (!TextUtils.isEmpty(this.c.getCampaignUnitId())) {
                                                    stringBuffer.append("unit_id=");
                                                    stringBuffer.append(this.c.getCampaignUnitId());
                                                    stringBuffer.append("&");
                                                }
                                                if (!TextUtils.isEmpty(this.c.getId())) {
                                                    stringBuffer.append("cid=");
                                                    stringBuffer.append(this.c.getId());
                                                    stringBuffer.append("&");
                                                }
                                                stringBuffer.append("status=");
                                                stringBuffer.append(this.b);
                                                stringBuffer.append("&");
                                                stringBuffer.append("code=");
                                                stringBuffer.append(this.d);
                                                if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                                                    com.mbridge.msdk.foundation.same.report.a.a().a(stringBuffer.toString());
                                                    return;
                                                }
                                                new com.mbridge.msdk.foundation.same.report.d.a(this.a).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(stringBuffer.toString(), this.a), (e) null);
                                            }
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                            q.d("MIMManager", e2.getMessage());
                                        } catch (Throwable th) {
                                            q.d("MIMManager", th.getMessage());
                                        }
                                    }
                                });
                            }
                        }
                    }
                } catch (Exception e) {
                    q.d("MIMManager", e.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public CampaignEx a(String str) {
        try {
            if (this.f != null && TextUtils.equals(this.f.getPackageName(), str)) {
                return this.f;
            }
            if (this.a == null || this.a.size() <= 0) {
                return null;
            }
            Iterator<CampaignEx> it = this.a.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null && TextUtils.equals(next.getPackageName(), str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e2) {
            q.d("MIMManager", e2.getMessage());
            return null;
        }
    }
}
