package shix.ihdbell.project;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.jxl.app.littlestars.project.R;
import object.p2pipcam.content.ContentCommon;

public class AboutActivity extends BaseActivity {
    private static final String LOG_TAG = "AboutActivity";
    private Button btnBack;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.e(LOG_TAG, "AboutActivity onCreate");
        requestWindowFeature(1);
        setContentView(R.layout.about);
        this.btnBack = (Button) findViewById(R.id.back);
        this.btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AboutActivity.this.finish();
                AboutActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
        findViewById(R.id.setting_deamon).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AboutActivity.this.checkTwoDimension();
            }
        });
    }

    public boolean checkPackage(String str) {
        if (str != null && !"".equals(str)) {
            try {
                getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_MENU));
            return false;
        } else if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        } else {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_BACK));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f A[SYNTHETIC, Splitter:B:34:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0099 A[SYNTHETIC, Splitter:B:39:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a5 A[SYNTHETIC, Splitter:B:45:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00af A[SYNTHETIC, Splitter:B:50:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkTwoDimension() {
        /*
            r7 = this;
            java.lang.String r0 = "Damin.apk"
            java.lang.String r1 = "com.zhao.damon"
            boolean r2 = r7.checkPackage(r1)
            if (r2 != 0) goto L_0x00b8
            r1 = 0
            android.content.res.AssetManager r2 = r7.getAssets()     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            java.io.InputStream r2 = r2.open(r0)     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            r3.<init>(r4, r0)     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x005b }
        L_0x0025:
            int r4 = r2.read(r1)     // Catch:{ IOException -> 0x005b }
            r5 = -1
            if (r4 == r5) goto L_0x0031
            r5 = 0
            r0.write(r1, r5, r4)     // Catch:{ IOException -> 0x005b }
            goto L_0x0025
        L_0x0031:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ IOException -> 0x005b }
            r1.<init>()     // Catch:{ IOException -> 0x005b }
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r4)     // Catch:{ IOException -> 0x005b }
            java.lang.String r4 = "android.intent.action.VIEW"
            r1.setAction(r4)     // Catch:{ IOException -> 0x005b }
            android.net.Uri r3 = android.net.Uri.fromFile(r3)     // Catch:{ IOException -> 0x005b }
            java.lang.String r4 = "application/vnd.android.package-archive"
            r1.setDataAndType(r3, r4)     // Catch:{ IOException -> 0x005b }
            r7.startActivity(r1)     // Catch:{ IOException -> 0x005b }
            if (r2 == 0) goto L_0x0056
            r2.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0056:
            r0.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00d1
        L_0x005b:
            r1 = move-exception
            goto L_0x0070
        L_0x005d:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x00a3
        L_0x0062:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0070
        L_0x0067:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x00a3
        L_0x006c:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L_0x0070:
            java.lang.String r3 = "tag"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r4.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = "exception:"
            r4.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = r1.getMessage()     // Catch:{ all -> 0x00a2 }
            r4.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a2 }
            android.util.Log.d(r3, r4)     // Catch:{ all -> 0x00a2 }
            r1.printStackTrace()     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x0097
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0097:
            if (r0 == 0) goto L_0x00d1
            r0.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00d1
        L_0x009d:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00d1
        L_0x00a2:
            r1 = move-exception
        L_0x00a3:
            if (r2 == 0) goto L_0x00ad
            r2.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            r2 = move-exception
            r2.printStackTrace()
        L_0x00ad:
            if (r0 == 0) goto L_0x00b7
            r0.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b7:
            throw r1
        L_0x00b8:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r2 = "android.intent.action.MAIN"
            r0.<init>(r2)
            java.lang.String r2 = "android.intent.category.LAUNCHER"
            r0.addCategory(r2)
            android.content.ComponentName r2 = new android.content.ComponentName
            java.lang.String r3 = "com.zhao.damon.MainActivity"
            r2.<init>(r1, r3)
            r0.setComponent(r2)
            r7.startActivity(r0)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.AboutActivity.checkTwoDimension():void");
    }
}
