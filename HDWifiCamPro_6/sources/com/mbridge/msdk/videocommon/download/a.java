package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.n;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.y;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CampaignDownLoadTask */
public final class a implements Serializable {
    /* access modifiers changed from: private */
    public boolean A;
    private int B;
    private File C;
    /* access modifiers changed from: private */
    public int D = 1;
    private int E;
    private int F;
    private int G;
    private OnDownloadStateListener H = new OnDownloadStateListener() {
        public final void onDownloadStart(DownloadMessage downloadMessage) {
            int unused = a.this.e = 1;
            if (a.this.u == null) {
                o unused2 = a.this.u = o.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
            }
            a.this.u.a(a.this.i, a.this.l, a.this.p, a.this.e);
        }

        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            try {
                q.d("CampaignDownLoadTask", "onDownloadComplete callback : " + a.this.o + "    " + a.this.l);
                if (a.this.u == null) {
                    o unused = a.this.u = o.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                }
                a.this.u.a(a.this.m, a.this.o, 5);
                String videoMD5Value = a.this.i.getVideoMD5Value();
                if (!TextUtils.isEmpty(videoMD5Value)) {
                    try {
                        if (videoMD5Value.equals(n.a(new File(a.this.n)))) {
                            a.this.a(a.this.o, true);
                            a.this.c(a.this.f(3));
                            return;
                        }
                    } catch (Throwable th) {
                        q.a("CampaignDownLoadTask", th.getMessage(), th);
                    }
                    a.this.a("Video download complete but MD5 check failed");
                    return;
                }
                a.this.a(a.this.o, false);
                a.this.c(a.this.f(3));
            } catch (Exception e) {
                q.d("CampaignDownLoadTask", e.getMessage());
            }
        }

        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            if (a.this.x != null && a.this.x.getStatus() != DownloadStatus.CANCELLED) {
                String message = (downloadError == null || downloadError.getException() == null) ? "Video Download Error" : downloadError.getException().getMessage();
                a.this.p();
                a.this.a(3, message);
                a.this.a(message);
            }
        }
    };
    private OnProgressStateListener I = new OnProgressStateListener() {
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                long unused = a.this.o = downloadProgress.getCurrent();
                long unused2 = a.this.l = downloadProgress.getTotal();
                int unused3 = a.this.z = downloadProgress.getCurrentDownloadRate();
                if (a.this.s != 100 && downloadProgress.getCurrentDownloadRate() >= a.this.s) {
                    q.d("CampaignDownLoadTask", "Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate = " + a.this.s + " " + a.this.c);
                    if (!a.this.d) {
                        boolean unused4 = a.this.d = true;
                        if (!a.this.A) {
                            a.this.c(a.this.f(1));
                            a.this.a(downloadProgress.getCurrent(), false);
                        }
                        if (a.this.x != null && a.this.D == 2 && !a.this.A) {
                            a.this.x.cancel(downloadMessage);
                        }
                    }
                }
            } catch (Exception e) {
                q.d("CampaignDownLoadTask", e.getMessage());
            }
        }
    };
    private boolean a = false;
    private int b = 1;
    /* access modifiers changed from: private */
    public int c;
    /* access modifiers changed from: private */
    public boolean d = false;
    /* access modifiers changed from: private */
    public volatile int e = 0;
    private CopyOnWriteArrayList<d> f = new CopyOnWriteArrayList<>();
    private com.mbridge.msdk.videocommon.listener.a g;
    private com.mbridge.msdk.videocommon.listener.a h;
    /* access modifiers changed from: private */
    public CampaignEx i;
    private String j;
    private Context k;
    /* access modifiers changed from: private */
    public long l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public long o = 0;
    /* access modifiers changed from: private */
    public String p;
    private boolean q = false;
    private long r;
    /* access modifiers changed from: private */
    public int s = 100;
    private boolean t = false;
    /* access modifiers changed from: private */
    public o u;
    private boolean v = false;
    private String w;
    /* access modifiers changed from: private */
    public DownloadRequest x;
    private DownloadMessage y;
    /* access modifiers changed from: private */
    public int z;

    public a(Context context, CampaignEx campaignEx, String str, int i2) {
        String str2;
        CampaignEx campaignEx2 = campaignEx;
        if (context != null || campaignEx2 != null) {
            this.E = com.mbridge.msdk.foundation.same.a.B;
            this.F = com.mbridge.msdk.foundation.same.a.C;
            this.G = com.mbridge.msdk.foundation.same.a.A;
            this.r = System.currentTimeMillis();
            this.k = com.mbridge.msdk.foundation.controller.a.e().g();
            this.i = campaignEx2;
            this.j = str;
            this.b = i2;
            CampaignEx campaignEx3 = this.i;
            if (campaignEx3 != null) {
                this.m = campaignEx3.getVideoUrlEncode();
            }
            String str3 = this.m;
            if (!TextUtils.isEmpty(str3)) {
                str2 = SameMD5.getMD5(y.a(str3.trim()));
            } else {
                str2 = "";
            }
            this.w = str2;
            this.n = e.b(c.MBRIDGE_VC) + File.separator;
            this.p = this.n + this.w;
            q.b("CampaignDownLoadTask", this.i.getAppName() + " videoLocalPath:" + this.p + " videoUrl: " + this.i.getVideoUrlEncode() + " " + this.s);
            try {
                if (!TextUtils.isEmpty(this.m)) {
                    File file = null;
                    if (!TextUtils.isEmpty(this.n)) {
                        file = new File(this.n);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    }
                    if (file != null && file.exists() && (this.C == null || !this.C.exists())) {
                        this.C = new File(file + "/.nomedia");
                        if (!this.C.exists()) {
                            this.C.createNewFile();
                        }
                    }
                    o a2 = o.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                    l a3 = a2.a(this.m, "");
                    if (a3 != null) {
                        this.o = a3.b();
                        if (this.e != 2) {
                            this.e = a3.d();
                        }
                        if (this.e == 1) {
                            this.e = 2;
                        }
                        this.l = (long) a3.c();
                        if (a3.a() > 0) {
                            this.r = a3.a();
                        }
                        if (this.e == 5) {
                            if (new File(this.n + this.w).exists()) {
                                this.p = this.n + this.w;
                            } else {
                                o();
                            }
                        } else if (this.e != 0) {
                            this.p = this.n + this.w;
                        }
                    } else {
                        a2.a(this.m, this.r);
                    }
                    String str4 = this.m;
                    if (TextUtils.isEmpty(str4)) {
                        this.h.a("VideoUrl is NULL, Please check it.", "");
                    } else if (this.e == 1) {
                        q.a("CampaignDownLoadTask", "Run : Task is RUNNING, Will return.");
                    } else if (this.e == 5) {
                        q.a("CampaignDownLoadTask", "Run : Video Done, Will callback.");
                        if (this.g != null) {
                            this.g.a(this.m);
                        }
                        if (this.h != null) {
                            this.h.a(this.m);
                        }
                        try {
                            File file2 = new File(this.p);
                            if (file2.exists() && file2.isFile()) {
                                file2.setLastModified(System.currentTimeMillis());
                            }
                        } catch (Exception e2) {
                            q.d("CampaignDownLoadTask", e2.getMessage());
                        }
                    } else if (this.b == 3) {
                        q.a("CampaignDownLoadTask", "Run : Dlnet is 3, Will callback.");
                        a(0, false);
                    } else {
                        if (this.i.getReady_rate() == 0) {
                            if (this.g != null) {
                                this.g.a(this.m);
                            }
                            if (this.h != null) {
                                this.h.a(this.m);
                            }
                        }
                        this.y = new DownloadMessage(new Object(), str4, this.w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
                        this.x = MBDownloadManager.getInstance().download(this.y).withReadTimeout((long) this.E).withConnectTimeout((long) this.G).withWriteTimeout((long) this.F).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(3).withDirectoryPathInternal(this.n).withDownloadStateListener(this.H).withProgressStateListener(this.I).build();
                    }
                }
            } catch (Exception e3) {
                q.b("CampaignDownLoadTask", e3.getMessage());
            }
        }
    }

    public final String a() {
        return this.m;
    }

    public final void a(int i2) {
        this.b = i2;
    }

    public final void b(int i2) {
        this.c = i2;
    }

    public final boolean b() {
        return this.v;
    }

    public final void a(boolean z2) {
        this.v = z2;
    }

    public final long c() {
        return this.r;
    }

    public final void b(boolean z2) {
        this.q = z2;
    }

    public final String d() {
        return this.p;
    }

    public final long e() {
        return this.l;
    }

    public final int f() {
        return this.e;
    }

    public final void a(int i2, int i3) {
        this.e = i2;
        if (this.u == null) {
            this.u = o.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
        }
        this.u.a(this.m, (long) i3, i2);
    }

    public final CampaignEx g() {
        return this.i;
    }

    public final void a(CampaignEx campaignEx) {
        this.i = campaignEx;
    }

    public final void c(int i2) {
        this.s = i2;
    }

    public final long h() {
        return this.o;
    }

    public final void d(int i2) {
        this.B = i2;
    }

    public final void e(int i2) {
        this.D = i2;
    }

    public final void a(long j2, boolean z2) {
        o oVar;
        q.d("CampaignDownLoadTask", "setStateToDone ： mProgressSize" + this.o + "  progressSize" + j2 + "  " + this.z + "%   FileSize : " + this.l + "  " + this.i.getAppName());
        long j3 = 0;
        if (this.s != 100 || this.b == 3 || j2 == this.l || z2) {
            this.e = 5;
            a(1, "");
            long j4 = this.l;
            if (!(j4 == 0 || (oVar = this.u) == null)) {
                oVar.b(this.m, j4);
            }
            this.a = false;
            a(j2, this.e);
            return;
        }
        File file = new File(this.p);
        if (file.exists()) {
            j3 = file.length();
        }
        q.d("CampaignDownLoadTask", "progressSize = " + j2 + " fileSize = " + this.l + " " + z2 + " absFileSize = " + j3);
        a("File size is not match witch download size.");
    }

    public final void a(String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = this.g;
        if (aVar != null) {
            aVar.a(str, this.m);
        }
        com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.a(str, this.m);
        }
        q.d("CampaignDownLoadTask", "Video download stop : " + str);
        if (this.e != 4 && this.e != 2 && this.e != 5) {
            this.e = 4;
            CampaignEx campaignEx = this.i;
            if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || this.i.getRsIgnoreCheckRule().size() <= 0 || !this.i.getRsIgnoreCheckRule().contains(0)) {
                a(this.o, this.e);
            } else {
                q.b("CampaignDownLoadTask", "Is not check video download status");
            }
        }
    }

    public final void i() {
        q.d("CampaignDownLoadTask", "start()");
        try {
            if (!TextUtils.isEmpty(this.m)) {
                if (this.m != null) {
                    q.d("CampaignDownLoadTask", new URL(this.m).getPath());
                }
                if (this.s == 0 && this.D == 2) {
                    q.d("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                    return;
                }
                DownloadRequest downloadRequest = this.x;
                if (downloadRequest != null) {
                    downloadRequest.start();
                }
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.a("VideoUrl is not illegal, Please check it.", "");
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void j() {
        try {
            this.A = true;
            if (this.D == 1) {
                q.d("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.D);
                return;
            }
            q.d("CampaignDownLoadTask", "resume()");
            if (this.y == null) {
                this.y = new DownloadMessage(new Object(), this.m, this.w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            }
            this.x = MBDownloadManager.getInstance().download(this.y).withReadTimeout((long) this.E).withConnectTimeout((long) this.G).withWriteTimeout((long) this.F).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(3).withDirectoryPathInternal(this.n).withDownloadStateListener(this.H).withProgressStateListener(this.I).build();
            this.x.start();
            c(f(2));
        } catch (Exception e2) {
            q.d("CampaignDownLoadTask", e2.getMessage());
        }
    }

    public final void b(String str) {
        p();
        a(2, str);
        this.e = 4;
    }

    public final void a(d dVar) {
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(dVar);
        }
    }

    public final String k() {
        String str = "";
        if (this.b == 3) {
            return str;
        }
        String str2 = this.n + this.w;
        File file = new File(str2);
        try {
            if (!file.exists()) {
                str = "file is not exist ";
            } else if (!file.isFile()) {
                str = "file is not file ";
            } else if (!file.canRead()) {
                str = "file can not read ";
            } else if (file.length() > 0) {
                this.p = str2;
            } else {
                str = "file length is 0 ";
            }
        } catch (Throwable th) {
            q.d("CampaignDownLoadTask", th.getMessage());
            str = th.getMessage();
        }
        if (this.e == 5 && !TextUtils.isEmpty(str)) {
            o();
        }
        return str;
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.g = aVar;
    }

    public final void b(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.h = aVar;
    }

    private void a(long j2, int i2) {
        this.o = j2;
        int i3 = this.s;
        if (100 * j2 >= ((long) i3) * this.l && !this.t && i2 != 4) {
            if (i3 != 100 || i2 == 5) {
                this.t = true;
                q.d("CampaignDownLoadTask", "UpdateListener : state: " + i2 + " progress : " + j2);
                String k2 = k();
                if (TextUtils.isEmpty(k2)) {
                    com.mbridge.msdk.videocommon.listener.a aVar = this.g;
                    if (aVar != null) {
                        aVar.a(this.m);
                    }
                    com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
                    if (aVar2 != null) {
                        aVar2.a(this.m);
                    }
                } else {
                    com.mbridge.msdk.videocommon.listener.a aVar3 = this.g;
                    if (aVar3 != null) {
                        aVar3.a("file is not effective " + k2, this.m);
                    }
                    com.mbridge.msdk.videocommon.listener.a aVar4 = this.h;
                    if (aVar4 != null) {
                        aVar4.a("file is not effective " + k2, this.m);
                    }
                }
            } else {
                this.e = 5;
                return;
            }
        }
        if (!this.a && j2 > 0) {
            this.a = true;
            if (this.u == null) {
                this.u = o.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
            }
            this.u.a(this.m, j2, this.e);
        }
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList != null) {
            Iterator<d> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.a(j2, i2);
                }
            }
        }
    }

    public final void l() {
        if (this.f != null) {
            this.f = null;
        }
    }

    private void o() {
        if (this.u == null) {
            this.u = o.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
        }
        try {
            this.u.b(this.m);
            File file = new File(this.p);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        } catch (Throwable th) {
            this.e = 0;
            throw th;
        }
        this.e = 0;
    }

    public final void m() {
        try {
            o();
            if (this.i == null || this.i.getPlayable_ads_without_video() != 2) {
                com.mbridge.msdk.videocommon.a.a a2 = com.mbridge.msdk.videocommon.a.a.a();
                if (a2 != null) {
                    a2.a(this.i);
                }
                this.e = 0;
                return;
            }
            this.e = 0;
        } catch (Exception unused) {
            q.d("CampaignDownLoadTask", "del file is failed");
        } catch (Throwable th) {
            this.e = 0;
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        try {
            Class<?> cls = Class.forName("com.mbridge.msdk.reward.a.a");
            Object newInstance = cls.newInstance();
            cls.getMethod("insertExcludeId", new Class[]{String.class, CampaignEx.class}).invoke(newInstance, new Object[]{this.j, this.i});
            Class<?> cls2 = Class.forName("com.mbridge.msdk.mbnative.controller.NativeController");
            Object newInstance2 = cls2.newInstance();
            cls2.getMethod("insertExcludeId", new Class[]{String.class, CampaignEx.class}).invoke(newInstance2, new Object[]{this.j, this.i});
        } catch (Exception e2) {
            q.d("CampaignDownLoadTask", e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        p a2 = p.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
        long j2 = 0;
        if (this.r != 0) {
            j2 = System.currentTimeMillis() - this.r;
        }
        m mVar = new m(this.k, this.i, i2, Long.toString(j2), this.l, this.B);
        mVar.n(this.i.getId());
        mVar.e(this.i.getVideoUrlEncode());
        mVar.p(str);
        mVar.k(this.i.getRequestId());
        mVar.m(this.j);
        a2.a(mVar);
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                    com.mbridge.msdk.foundation.same.report.a.a().a(str);
                    return;
                }
                new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.e().g()).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(str, com.mbridge.msdk.foundation.controller.a.e().g(), this.j), (com.mbridge.msdk.foundation.same.net.e) null);
            } catch (Exception e2) {
                q.d("CampaignDownLoadTask", e2.getMessage());
            }
        }
    }

    public final String n() {
        try {
            File file = new File(this.p);
            if (file.exists() && file.isFile()) {
                return this.p;
            }
        } catch (Exception e2) {
            q.d("CampaignDownLoadTask", e2.getMessage());
        }
        return this.m;
    }

    /* access modifiers changed from: private */
    public String f(int i2) {
        if (this.i == null || TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.i.getRequestId()) || TextUtils.isEmpty(this.i.getVideoUrlEncode())) {
            return "";
        }
        return "key=" + "2000077" + "&" + "unit_id=" + this.j + "&" + "rid=" + this.i.getRequestId() + "&" + "rid_n=" + this.i.getRequestIdNotice() + "&" + "package_name=" + com.mbridge.msdk.foundation.controller.a.e().b() + "&" + "app_id=" + com.mbridge.msdk.foundation.controller.a.e().h() + "&" + "video_url=" + URLEncoder.encode(this.i.getVideoUrlEncode()) + "&" + "process_size=" + this.o + "&" + "file_size=" + this.l + "&" + "ready_rate=" + this.s + "&" + "cd_rate=" + this.c + "&" + "cid=" + this.i.getId() + "&" + "type=" + this.e + "&" + "video_download_status=" + i2;
    }
}
