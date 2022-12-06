package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbbanner.common.a.c;
import com.mbridge.msdk.mbbanner.common.b.d;
import com.mbridge.msdk.mbbanner.common.b.e;
import com.mbridge.msdk.mbbanner.common.b.f;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.mbbanner.common.util.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: BannerLoader */
public class b {
    private static final String a = b.class.getSimpleName();
    /* access modifiers changed from: private */
    public Context b;
    private int c = 0;
    private c d;
    /* access modifiers changed from: private */
    public a e;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.mbbanner.common.b.b f;
    /* access modifiers changed from: private */
    public d g;
    /* access modifiers changed from: private */
    public volatile boolean h = false;
    private Timer i = new Timer();
    private volatile List<String> j = new ArrayList();
    private volatile boolean k = false;
    private volatile boolean l = false;
    private volatile boolean m = false;

    public b(Context context, c cVar, com.mbridge.msdk.mbbanner.common.b.b bVar, a aVar) {
        this.b = context.getApplicationContext();
        this.d = cVar;
        this.f = bVar;
        this.e = aVar;
    }

    private void a(String str) {
        if (this.m) {
            return;
        }
        if ((this.k || this.l) && this.j.size() == 0) {
            this.h = true;
            this.m = true;
            this.i.cancel();
            this.e.a(this.f, str);
            this.g.a(str);
        }
    }

    public final void a(String str, int i2, String str2, boolean z) {
        if (!z) {
            this.i.cancel();
            this.h = true;
            this.e.b(this.f, str);
            this.g.a(str);
        } else if (i2 == 1) {
            synchronized (this) {
                this.j.remove(str2);
                if (this.j.size() == 0) {
                    a(str);
                }
            }
        } else if (i2 == 2) {
            this.l = true;
            a(str);
        } else if (i2 == 3) {
            this.k = true;
            a(str);
        }
    }

    public final void a(String str, String str2, com.mbridge.msdk.mbbanner.common.a.b bVar, d dVar) {
        boolean z;
        try {
            this.g = dVar;
            AnonymousClass2 r11 = new com.mbridge.msdk.mbbanner.common.f.a() {
                public final void a(CampaignUnit campaignUnit) {
                    try {
                        b.this.e.a(b.this.f, campaignUnit, this.d);
                        b.a(b.this, this.d, campaignUnit);
                    } catch (Exception e) {
                        b.this.e.a(b.this.f, e.getMessage(), this.d);
                        b.this.g.a(this.d);
                    }
                }

                public final void a(int i, String str) {
                    b.this.e.a(b.this.f, str, this.d);
                    b.this.g.a(this.d);
                }
            };
            r11.d = str2;
            r11.e = str;
            r11.f = 296;
            com.mbridge.msdk.mbbanner.common.e.a aVar = new com.mbridge.msdk.mbbanner.common.e.a(this.b);
            this.c = b(str2);
            com.mbridge.msdk.foundation.same.net.h.d a2 = com.mbridge.msdk.mbbanner.common.a.d.a(false, this.b, str2, this.d.a(), this.c, bVar);
            String e2 = u.e(str2);
            if (!TextUtils.isEmpty(e2)) {
                a2.a("j", e2);
            }
            String c2 = bVar.c();
            if (!TextUtils.isEmpty(c2)) {
                r11.a(c2);
                z = true;
            } else {
                z = false;
            }
            this.e.a(z);
            if (!com.mbridge.msdk.foundation.same.net.g.d.c().b() || z) {
                aVar.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().a(c2), a2, r11);
            } else {
                aVar.b(1, com.mbridge.msdk.foundation.same.net.g.d.c().a(c2), a2, r11);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            this.e.a(this.f, e3.getMessage(), str2);
            this.g.a(str2);
        }
    }

    private List<CampaignEx> a(String str, CampaignUnit campaignUnit) {
        ArrayList arrayList = new ArrayList();
        if (campaignUnit != null) {
            try {
                if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    for (int i2 = 0; i2 < ads.size(); i2++) {
                        CampaignEx campaignEx = ads.get(i2);
                        if (!(campaignEx == null || campaignEx.getOfferType() == 99 || (TextUtils.isEmpty(campaignEx.getBannerUrl()) && TextUtils.isEmpty(campaignEx.getBannerHtml()) && TextUtils.isEmpty(campaignEx.getImageUrl())))) {
                            if (u.b(campaignEx)) {
                                campaignEx.setRtinsType(u.c(this.b, campaignEx.getPackageName()) ? 1 : 2);
                            }
                            if (campaignEx.getWtick() != 1) {
                                if (u.c(this.b, campaignEx.getPackageName())) {
                                    if (u.b(campaignEx)) {
                                        arrayList.add(campaignEx);
                                    } else {
                                        u.a(str, campaignEx, com.mbridge.msdk.foundation.same.a.v);
                                    }
                                }
                            }
                            arrayList.add(campaignEx);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    private void a(String str, List<CampaignEx> list) {
        if (list != null && list.size() > 0) {
            for (CampaignEx next : list) {
                if (!TextUtils.isEmpty(next.getImageUrl())) {
                    this.j.add(next.getImageUrl());
                    com.mbridge.msdk.foundation.same.c.b.a(this.b).a(next.getImageUrl(), (com.mbridge.msdk.foundation.same.c.c) new f(this, str));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064 A[SYNTHETIC, Splitter:B:24:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0091 A[SYNTHETIC, Splitter:B:37:0x0091] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x009a
            r0 = 0
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.b(r2)     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.y.a(r8)     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r3)     // Catch:{ Exception -> 0x005e }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x005e }
            if (r4 == 0) goto L_0x0025
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x005e }
        L_0x0025:
            java.lang.String r4 = ".html"
            java.lang.String r3 = r3.concat(r4)     // Catch:{ Exception -> 0x005e }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x005e }
            r4.<init>(r2, r3)     // Catch:{ Exception -> 0x005e }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x005e }
            r2.getPath()     // Catch:{ Exception -> 0x005e }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005e }
            r2.<init>(r4)     // Catch:{ Exception -> 0x005e }
            byte[] r0 = r8.getBytes()     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r2.write(r0)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r2.flush()     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            java.lang.String r0 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r2.close()     // Catch:{ Exception -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0052:
            r1 = r0
            goto L_0x006c
        L_0x0054:
            r7 = move-exception
            r0 = r2
            goto L_0x008f
        L_0x0057:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x005f
        L_0x005c:
            r7 = move-exception
            goto L_0x008f
        L_0x005e:
            r2 = move-exception
        L_0x005f:
            r2.printStackTrace()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x006c
            r0.close()     // Catch:{ Exception -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006c:
            java.io.File r0 = new java.io.File
            r0.<init>(r1)
            boolean r2 = r0.exists()
            r3 = 2
            if (r2 == 0) goto L_0x008a
            boolean r2 = r0.isFile()
            if (r2 == 0) goto L_0x008a
            boolean r0 = r0.canRead()
            if (r0 != 0) goto L_0x0085
            goto L_0x008a
        L_0x0085:
            r0 = 1
            r6.a((java.lang.String) r7, (int) r3, (java.lang.String) r8, (boolean) r0)
            goto L_0x009a
        L_0x008a:
            r0 = 0
            r6.a((java.lang.String) r7, (int) r3, (java.lang.String) r8, (boolean) r0)
            goto L_0x009a
        L_0x008f:
            if (r0 == 0) goto L_0x0099
            r0.close()     // Catch:{ Exception -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0099:
            throw r7
        L_0x009a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.b.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private int b(String str) {
        try {
            int b2 = this.d.b();
            if (b2 > this.d.c()) {
                return 0;
            }
            return b2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    static /* synthetic */ void a(b bVar, final String str, final CampaignUnit campaignUnit) {
        if (campaignUnit == null) {
            bVar.e.a(bVar.f, "campaignUnit is NULL!", str);
            bVar.g.a(str);
            return;
        }
        List<CampaignEx> a2 = bVar.a(str, campaignUnit);
        new Thread(new Runnable() {
            public final void run() {
                j.a((com.mbridge.msdk.foundation.db.f) g.a(b.this.b)).b();
                CampaignUnit campaignUnit = campaignUnit;
                if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    BannerUtils.uisList(b.this.b, campaignUnit.getAds());
                }
            }
        }).start();
        if (a2 == null || a2.size() == 0) {
            bVar.e.a(bVar.f, "Need show campaign list is NULL!", str);
            bVar.g.a(str);
            return;
        }
        bVar.i.schedule(new TimerTask() {
            public final void run() {
                if (!b.this.h) {
                    boolean unused = b.this.h = true;
                    b.this.a(str, -1, "", false);
                }
            }
        }, (long) 60000);
        bVar.d.a(campaignUnit.getSessionId());
        int i2 = bVar.c;
        int i3 = 0;
        if (a2 != null) {
            try {
                if (a2.size() > 0) {
                    i2 += a2.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (i2 > bVar.d.c()) {
            i2 = 0;
        }
        if (x.b(str)) {
            bVar.d.a(i2);
        }
        CampaignEx campaignEx = a2.get(0);
        String trim = campaignEx.getBannerUrl().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (!TextUtils.isEmpty(trim)) {
                com.mbridge.msdk.videocommon.download.g.a().a(trim, new e(bVar, str));
            }
            if (a2 != null && a2.size() > 0) {
                while (i3 < a2.size()) {
                    a2.get(i3).setBannerUrl(campaignEx.getBannerUrl());
                    a2.get(i3).setHasMBTplMark(true);
                    i3++;
                }
            }
        } else {
            String trim2 = campaignEx.getBannerHtml().trim();
            if (!TextUtils.isEmpty(trim2)) {
                String a3 = bVar.a(str, trim2);
                if (a2 != null && a2.size() > 0) {
                    while (i3 < a2.size()) {
                        a2.get(i3).setBannerHtml(a3);
                        a2.get(i3).setHasMBTplMark(trim2.contains("<MBTPLMARK>"));
                        i3++;
                    }
                }
            } else {
                bVar.l = true;
                bVar.k = true;
            }
        }
        bVar.a(str, a2);
    }
}
