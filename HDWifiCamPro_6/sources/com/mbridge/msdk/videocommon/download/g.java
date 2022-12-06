package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.videocommon.download.f;
import com.mbridge.msdk.videocommon.download.h;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: H5DownLoadManager */
public class g {
    private static g c;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<String> a;
    private ConcurrentMap<String, b> b;
    private j d;
    /* access modifiers changed from: private */
    public h e;
    private boolean f = false;

    /* compiled from: H5DownLoadManager */
    public interface a {
        void a(String str);

        void a(String str, String str2);
    }

    /* compiled from: H5DownLoadManager */
    public interface b extends a {
    }

    /* compiled from: H5DownLoadManager */
    public interface c {
        void a();

        void a(String str);

        void a(String str, byte[] bArr, String str2);
    }

    /* compiled from: H5DownLoadManager */
    public interface d extends a {
    }

    private g() {
        try {
            this.d = j.a();
            this.e = h.a.a;
            this.a = new CopyOnWriteArrayList<>();
            this.b = new ConcurrentHashMap();
            com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
            if (b2 != null) {
                this.f = b2.i(1);
            }
        } catch (Throwable th) {
            q.a("H5DownLoadManager", th.getMessage(), th);
        }
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (c == null) {
                c = new g();
            }
            gVar = c;
        }
        return gVar;
    }

    public final String a(String str) {
        j jVar = this.d;
        if (jVar != null) {
            return jVar.a(str);
        }
        return null;
    }

    public final void a(final String str, final a aVar) {
        if (!this.f) {
            try {
                q.d("H5DownLoadManager", "download url:" + str);
                if (!this.a.contains(str)) {
                    this.a.add(str);
                    f.a.a.a(new com.mbridge.msdk.foundation.same.e.a() {
                        public final void b() {
                        }

                        public final void a() {
                            if (!TextUtils.isEmpty(g.this.e.b(str))) {
                                g.this.a.remove(str);
                                a aVar = aVar;
                                if (aVar != null) {
                                    aVar.a(str);
                                    return;
                                }
                                return;
                            }
                            e.a(str, new c() {
                                public final void a() {
                                }

                                public final void a(String str, byte[] bArr, String str2) {
                                    try {
                                        g.this.a.remove(str2);
                                        if (bArr != null && bArr.length > 0) {
                                            if (g.this.e.a(str2, bArr)) {
                                                if (aVar != null) {
                                                    aVar.a(str2);
                                                }
                                            } else if (aVar != null) {
                                                aVar.a(str2, "save file failed");
                                            }
                                        }
                                    } catch (Exception e) {
                                        if (MBridgeConstans.DEBUG) {
                                            e.printStackTrace();
                                        }
                                        if (aVar != null) {
                                            aVar.a(str2, e.getMessage());
                                        }
                                    }
                                }

                                public final void a(String str) {
                                    try {
                                        g.this.a.remove(str);
                                        if (aVar != null) {
                                            aVar.a(str, str);
                                        }
                                    } catch (Exception e) {
                                        if (MBridgeConstans.DEBUG) {
                                            e.printStackTrace();
                                        }
                                        if (aVar != null) {
                                            aVar.a(str, str);
                                        }
                                    }
                                }
                            }, true);
                        }
                    });
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        } else if (!TextUtils.isEmpty(str)) {
            try {
                new URL(str);
                String md5 = SameMD5.getMD5(y.a(str));
                MBDownloadManager.getInstance().download(new DownloadMessage(new Object(), str, md5 + ".html", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_HTML)).withReadTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout(20000).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML) + "/").withDownloadStateListener(new OnDownloadStateListener() {
                    public final void onDownloadStart(DownloadMessage downloadMessage) {
                    }

                    public final void onDownloadComplete(DownloadMessage downloadMessage) {
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.a(str);
                        }
                    }

                    public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.a(str, downloadError.getException().getMessage());
                        }
                    }
                }).build().start();
            } catch (Exception unused) {
                if (aVar != null) {
                    aVar.a("zip url is unlawful", str);
                }
            }
        } else if (aVar != null) {
            aVar.a("zip url is null", str);
        }
    }

    public final void b(String str, a aVar) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                String path = Uri.parse(str).getPath();
                if (!TextUtils.isEmpty(path)) {
                    if (path.toLowerCase().endsWith(".zip")) {
                        final d dVar = (d) aVar;
                        if (!this.f) {
                            try {
                                if (TextUtils.isEmpty(this.d.a(str))) {
                                    if (this.b.containsKey(str)) {
                                        b bVar = (b) this.b.get(str);
                                        if (bVar != null) {
                                            bVar.a(dVar);
                                            return;
                                        }
                                        return;
                                    }
                                    b bVar2 = new b(this.b, this.d, dVar, str);
                                    this.b.put(str, bVar2);
                                    e.a(str, bVar2, true);
                                    return;
                                } else if (dVar != null) {
                                    dVar.a(str);
                                    return;
                                } else {
                                    return;
                                }
                            } catch (Exception e2) {
                                if (dVar != null) {
                                    dVar.a(str, "downloadzip failed");
                                }
                                if (MBridgeConstans.DEBUG) {
                                    e2.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        } else if (!TextUtils.isEmpty(str)) {
                            try {
                                new URL(str);
                                String b2 = e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
                                String md5 = SameMD5.getMD5(y.a(str));
                                final String str2 = b2 + "/" + md5;
                                MBDownloadManager.getInstance().download(new DownloadMessage(new Object(), str, md5 + ".zip", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP)).withReadTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout(20000).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(b2 + "/").withDownloadStateListener(new OnDownloadStateListener() {
                                    public final void onDownloadStart(DownloadMessage downloadMessage) {
                                    }

                                    public final void onDownloadComplete(DownloadMessage downloadMessage) {
                                        try {
                                            if (TextUtils.isEmpty(j.a().a(downloadMessage.getDownloadUrl()))) {
                                                MBResourceManager.getInstance().unZip(downloadMessage.getSaveFilePath(), str2);
                                            }
                                            if (dVar != null) {
                                                dVar.a(downloadMessage.getDownloadUrl());
                                            }
                                        } catch (IOException e) {
                                            d dVar = dVar;
                                            if (dVar != null) {
                                                dVar.a(downloadMessage.getDownloadUrl(), e.getMessage());
                                            }
                                        }
                                    }

                                    public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                                        if (!TextUtils.isEmpty(j.a().a(downloadMessage.getDownloadUrl()))) {
                                            d dVar = dVar;
                                            if (dVar != null) {
                                                dVar.a(downloadMessage.getDownloadUrl());
                                                return;
                                            }
                                            return;
                                        }
                                        d dVar2 = dVar;
                                        if (dVar2 != null) {
                                            dVar2.a(downloadMessage.getDownloadUrl(), downloadError.getException().getMessage());
                                        }
                                    }
                                }).build().start();
                                return;
                            } catch (Exception unused) {
                                if (dVar != null) {
                                    dVar.a(str, "zip url is unlawful");
                                    return;
                                }
                                return;
                            }
                        } else if (dVar != null) {
                            dVar.a(str, "zip url is null");
                            return;
                        } else {
                            return;
                        }
                    } else {
                        a(str, aVar);
                        return;
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (aVar != null) {
            aVar.a(str, "The URL does not contain a path ");
        }
    }

    public final String b(String str) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                Uri parse = Uri.parse(str);
                String path = parse.getPath();
                if (TextUtils.isEmpty(path) || !TextUtils.isEmpty(parse.getQueryParameter("urlDebug"))) {
                    return str;
                }
                if (path.toLowerCase().endsWith(".zip")) {
                    return a(str);
                }
                return this.e != null ? this.e.a(str) : str;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }
}
