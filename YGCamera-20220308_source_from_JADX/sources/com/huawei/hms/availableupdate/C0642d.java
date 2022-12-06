package com.huawei.hms.availableupdate;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.IOUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.huawei.hms.availableupdate.d */
/* compiled from: UpdateDownload */
public class C0642d implements C0645e {

    /* renamed from: a */
    public final Context f364a;

    /* renamed from: b */
    public final C0657k f365b = new C0656j();

    /* renamed from: c */
    public final C0631a f366c = new C0631a();

    /* renamed from: d */
    public C0649f f367d;

    /* renamed from: e */
    public File f368e;

    /* renamed from: com.huawei.hms.availableupdate.d$a */
    /* compiled from: UpdateDownload */
    public class C0643a extends C0634b {

        /* renamed from: b */
        public long f369b = 0;

        /* renamed from: c */
        public int f370c = C0642d.this.f366c.mo13213a();

        /* renamed from: d */
        public final /* synthetic */ int f371d;

        /* renamed from: e */
        public final /* synthetic */ String f372e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0643a(File file, int i, int i2, String str) {
            super(file, i);
            this.f371d = i2;
            this.f372e = str;
        }

        /* renamed from: a */
        public final void mo13240a(int i) {
            C0642d.this.f366c.mo13214a(C0642d.this.mo13239b(), i, this.f372e);
            C0642d.this.mo13236a(2100, i, this.f371d);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            super.write(bArr, i, i2);
            this.f370c += i2;
            if (this.f370c <= 209715200) {
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.f369b) > 1000) {
                    this.f369b = currentTimeMillis;
                    mo13240a(this.f370c);
                }
                int i3 = this.f370c;
                if (i3 == this.f371d) {
                    mo13240a(i3);
                }
            }
        }
    }

    public C0642d(Context context) {
        this.f364a = context.getApplicationContext();
    }

    /* renamed from: b */
    public Context mo13239b() {
        return this.f364a;
    }

    /* renamed from: a */
    public final synchronized void mo13237a(C0649f fVar) {
        this.f367d = fVar;
    }

    /* renamed from: a */
    public final synchronized void mo13236a(int i, int i2, int i3) {
        C0649f fVar = this.f367d;
        if (fVar != null) {
            fVar.mo13230a(i, i2, i3, this.f368e);
        }
    }

    /* renamed from: a */
    public void mo13228a() {
        HMSLog.m1379i("UpdateDownload", "Enter cancel.");
        mo13237a((C0649f) null);
        this.f365b.mo13267a();
    }

    /* renamed from: a */
    public void mo13229a(C0649f fVar, C0653g gVar) {
        Checker.checkNonNull(fVar, "callback must not be null.");
        HMSLog.m1379i("UpdateDownload", "Enter downloadPackage.");
        mo13237a(fVar);
        if (gVar == null || !gVar.mo13265a()) {
            HMSLog.m1377e("UpdateDownload", "In downloadPackage, Invalid update info.");
            mo13236a(2201, 0, 0);
        } else if (!"mounted".equals(Environment.getExternalStorageState())) {
            HMSLog.m1377e("UpdateDownload", "In downloadPackage, Invalid external storage for downloading file.");
            mo13236a(2204, 0, 0);
        } else {
            String str = gVar.f389b;
            if (TextUtils.isEmpty(str)) {
                HMSLog.m1377e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ");
                mo13236a(2201, 0, 0);
                return;
            }
            Context context = this.f364a;
            this.f368e = UpdateProvider.getLocalFile(context, str + ".apk");
            File file = this.f368e;
            if (file == null) {
                HMSLog.m1377e("UpdateDownload", "In downloadPackage, Failed to get local file for downloading.");
                mo13236a(2204, 0, 0);
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || (!parentFile.mkdirs() && !parentFile.isDirectory())) {
                HMSLog.m1377e("UpdateDownload", "In downloadPackage, Failed to create directory for downloading file.");
                mo13236a(2201, 0, 0);
            } else if (parentFile.getUsableSpace() < ((long) (gVar.f391d * 3))) {
                HMSLog.m1377e("UpdateDownload", "In downloadPackage, No space for downloading file.");
                mo13236a(2203, 0, 0);
            } else {
                try {
                    mo13238a(gVar);
                } catch (C0655i unused) {
                    HMSLog.m1380w("UpdateDownload", "In downloadPackage, Canceled to download the update file.");
                    mo13236a(2101, 0, 0);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo13238a(C0653g gVar) throws C0655i {
        HMSLog.m1379i("UpdateDownload", "Enter downloadPackage.");
        C0634b bVar = null;
        try {
            String str = gVar.f389b;
            if (TextUtils.isEmpty(str)) {
                HMSLog.m1377e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ");
                mo13236a(2201, 0, 0);
                this.f365b.close();
                IOUtils.closeQuietly((OutputStream) null);
                return;
            }
            this.f366c.mo13215a(mo13239b(), str);
            if (!this.f366c.mo13219b(gVar.f390c, gVar.f391d, gVar.f392e)) {
                this.f366c.mo13216a(gVar.f390c, gVar.f391d, gVar.f392e);
                bVar = mo13235a(this.f368e, gVar.f391d, str);
            } else if (this.f366c.mo13213a() != this.f366c.mo13217b()) {
                bVar = mo13235a(this.f368e, gVar.f391d, str);
                bVar.mo13224a((long) this.f366c.mo13213a());
            } else if (FileUtil.verifyHash(gVar.f392e, this.f368e)) {
                mo13236a((int) Constants.ASSEMBLE_PUSH_RETRY_INTERVAL, 0, 0);
                this.f365b.close();
                IOUtils.closeQuietly((OutputStream) null);
                return;
            } else {
                this.f366c.mo13216a(gVar.f390c, gVar.f391d, gVar.f392e);
                bVar = mo13235a(this.f368e, gVar.f391d, str);
            }
            int a = this.f365b.mo13266a(gVar.f390c, bVar, this.f366c.mo13213a(), this.f366c.mo13217b(), this.f364a);
            if (a != 200 && a != 206) {
                HMSLog.m1377e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package, HTTP code: " + a);
                mo13236a(2201, 0, 0);
                this.f365b.close();
                IOUtils.closeQuietly((OutputStream) bVar);
            } else if (!FileUtil.verifyHash(gVar.f392e, this.f368e)) {
                mo13236a(2202, 0, 0);
                this.f365b.close();
                IOUtils.closeQuietly((OutputStream) bVar);
            } else {
                mo13236a((int) Constants.ASSEMBLE_PUSH_RETRY_INTERVAL, 0, 0);
                this.f365b.close();
                IOUtils.closeQuietly((OutputStream) bVar);
            }
        } catch (IOException e) {
            HMSLog.m1377e("UpdateDownload", "In DownloadHelper.downloadPackage, Failed to download." + e.getMessage());
            mo13236a(2201, 0, 0);
        } catch (Throwable th) {
            this.f365b.close();
            IOUtils.closeQuietly((OutputStream) bVar);
            throw th;
        }
    }

    /* renamed from: a */
    public final C0634b mo13235a(File file, int i, String str) throws IOException {
        return new C0643a(file, i, i, str);
    }
}
