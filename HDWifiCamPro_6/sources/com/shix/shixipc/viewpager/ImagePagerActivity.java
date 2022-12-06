package com.shix.shixipc.viewpager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.shix.qhipc.R;
import com.shix.shixipc.gridview.GridItem;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.SystemBarTintManager;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ImagePagerActivity extends FragmentActivity {
    public static final String BROAD_ACTION = "action_delete";
    public static final String FILENAME = "filename";
    public static final String INDEX = "index";
    /* access modifiers changed from: private */
    public List<Fragment> fragments = new ArrayList();
    /* access modifiers changed from: private */
    public TextView indicator;
    /* access modifiers changed from: private */
    public ImagePagerAdapter mAdapter;
    /* access modifiers changed from: private */
    public ArrayList<GridItem> mGirdList;
    private HackyViewPager mPager;
    /* access modifiers changed from: private */
    public GridItem mSelectGridItem;
    /* access modifiers changed from: private */
    public TextView nb;
    /* access modifiers changed from: private */
    public int pagerPosition = 0;
    /* access modifiers changed from: private */
    public String time;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_image_detail_pager);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        getIntentData();
        initView();
        setListeners();
        initData();
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImagePagerActivity.this.setResult(0, new Intent());
                ImagePagerActivity.this.finish();
            }
        });
        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImagePagerActivity.this.showDeleteDialog();
            }
        });
        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImagePagerActivity.this.shareImage();
            }
        });
    }

    public void SetTab(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);
        systemBarTintManager.setStatusBarTintResource(i);
    }

    private void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    private void setListeners() {
        this.mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                ImagePagerActivity.this.indicator.setText(ImagePagerActivity.this.getString(R.string.viewpager_indicator, new Object[]{Integer.valueOf(i + 1), Integer.valueOf(ImagePagerActivity.this.fragments.size())}));
                ImagePagerActivity imagePagerActivity = ImagePagerActivity.this;
                String unused = imagePagerActivity.time = ((GridItem) imagePagerActivity.mGirdList.get(i)).getTime();
                ImagePagerActivity imagePagerActivity2 = ImagePagerActivity.this;
                GridItem unused2 = imagePagerActivity2.mSelectGridItem = (GridItem) imagePagerActivity2.mGirdList.get(i);
                int unused3 = ImagePagerActivity.this.pagerPosition = i;
                ImagePagerActivity.this.nb.setText(ImagePagerActivity.this.time);
            }
        });
    }

    private void getIntentData() {
        this.pagerPosition = getIntent().getIntExtra("position", 0);
        this.mGirdList = getIntent().getParcelableArrayListExtra("girdlst");
        this.mSelectGridItem = this.mGirdList.get(this.pagerPosition);
        Iterator<GridItem> it = this.mGirdList.iterator();
        while (it.hasNext()) {
            this.fragments.add(ImageDetailFragment.newInstance(it.next().getPath()));
        }
    }

    private void initData() {
        this.mAdapter = new ImagePagerAdapter(getSupportFragmentManager());
        this.mPager.setAdapter(this.mAdapter);
        this.mPager.setCurrentItem(this.pagerPosition);
    }

    private void initView() {
        this.nb = (TextView) findViewById(R.id.tv_camera);
        this.mPager = (HackyViewPager) findViewById(R.id.pager);
        this.indicator = (TextView) findViewById(R.id.indicator);
        this.indicator.setText(getString(R.string.viewpager_indicator, new Object[]{Integer.valueOf(this.pagerPosition + 1), Integer.valueOf(this.fragments.size())}));
    }

    private String getFilePathByContentResolver(Context context, Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null) {
            try {
                if (query.getCount() == 1) {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                }
                return str;
            } finally {
                query.close();
            }
        } else {
            throw new IllegalArgumentException("Query on " + uri + " returns null result.");
        }
    }

    public void shareImage() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            Uri savePicToSDcard = savePicToSDcard(BitmapFactory.decodeFile(this.mGirdList.get(this.pagerPosition).getPath()));
            CommonUtil.Log(1, "shareImage:" + savePicToSDcard.getPath());
            if (Build.VERSION.SDK_INT > 23) {
                intent.setFlags(1);
            }
            intent.putExtra("android.intent.extra.STREAM", savePicToSDcard);
            startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_title)));
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.net.Uri] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ce A[SYNTHETIC, Splitter:B:37:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00da A[SYNTHETIC, Splitter:B:45:0x00da] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.net.Uri savePicToSDcard(android.graphics.Bitmap r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = r6.getStrDate()     // Catch:{ all -> 0x00e3 }
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00c7 }
            java.io.File r3 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "LDDDD/pic"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x00c7 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00c7 }
            if (r3 != 0) goto L_0x001a
            r2.mkdirs()     // Catch:{ Exception -> 0x00c7 }
        L_0x001a:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00c7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c7 }
            r4.<init>()     // Catch:{ Exception -> 0x00c7 }
            r4.append(r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = ".jpg"
            r4.append(r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00c7 }
            r3.<init>(r2, r0)     // Catch:{ Exception -> 0x00c7 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c7 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00c7 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r4 = 90
            boolean r2 = r7.compress(r2, r4, r0)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r2 == 0) goto L_0x0042
            r0.flush()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
        L_0x0042:
            java.lang.String r2 = r3.getPath()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r4 = 23
            if (r3 > r4) goto L_0x0095
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            java.lang.String r7 = android.provider.MediaStore.Images.Media.insertImage(r2, r7, r3, r4)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r2 = "test"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.<init>()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r4 = "zhaogenghuai savepath:"
            r3.append(r4)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.append(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.util.Log.d(r2, r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r7 == 0) goto L_0x00b3
            int r2 = r7.length()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r2 <= 0) goto L_0x00b3
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r2.<init>(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r7 = r6.getFilePathByContentResolver(r6, r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.<init>(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.net.Uri r1 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r2.setData(r1)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r6.sendBroadcast(r2)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            goto L_0x00b3
        L_0x0095:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r7.<init>()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = r6.getPackageName()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r7.append(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = ".fileprovider"
            r7.append(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r6, r7, r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
        L_0x00b3:
            r0.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00bb:
            r0 = r1
            goto L_0x00d6
        L_0x00bd:
            r7 = move-exception
            goto L_0x00d8
        L_0x00bf:
            r7 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x00c9
        L_0x00c4:
            r7 = move-exception
            r0 = r1
            goto L_0x00d8
        L_0x00c7:
            r7 = move-exception
            r0 = r1
        L_0x00c9:
            r7.printStackTrace()     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x00d6
            r1.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00d6:
            monitor-exit(r6)
            return r0
        L_0x00d8:
            if (r0 == 0) goto L_0x00e2
            r0.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00e2
        L_0x00de:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00e2:
            throw r7     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.viewpager.ImagePagerActivity.savePicToSDcard(android.graphics.Bitmap):android.net.Uri");
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    /* access modifiers changed from: protected */
    public void showDeleteDialog() {
        CommonUtil.Log(2, "zhaogenghuai showDeleteDialog");
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(this);
        instance.withMessage((CharSequence) getString(R.string.tips_msg_delete_snapshot)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                CommonUtil.Log(2, "zhaogenghuai setButton1Click");
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                CommonUtil.Log(2, "zhaogenghuai setButton2Click");
                instance.dismiss();
                File file = new File(((GridItem) ImagePagerActivity.this.mGirdList.get(ImagePagerActivity.this.pagerPosition)).getPath());
                CommonUtil.Log(2, "zhaogenghuai path:" + ((GridItem) ImagePagerActivity.this.mGirdList.get(ImagePagerActivity.this.pagerPosition)).getPath());
                file.delete();
                Intent intent = new Intent();
                intent.putExtra(ImagePagerActivity.INDEX, ImagePagerActivity.this.pagerPosition);
                intent.setAction(ImagePagerActivity.BROAD_ACTION);
                ImagePagerActivity.this.sendBroadcast(intent);
                ImagePagerActivity.this.fragments.remove(ImagePagerActivity.this.pagerPosition);
                ImagePagerActivity.this.mGirdList.remove(ImagePagerActivity.this.pagerPosition);
                ImagePagerActivity.this.mAdapter.notifyDataSetChanged();
                if (ImagePagerActivity.this.fragments.size() == 0) {
                    ImagePagerActivity.this.finish();
                    ImagePagerActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                    return;
                }
                ImagePagerActivity imagePagerActivity = ImagePagerActivity.this;
                ImagePagerActivity.this.indicator.setText(imagePagerActivity.getString(R.string.viewpager_indicator, new Object[]{Integer.valueOf(imagePagerActivity.pagerPosition + 1), Integer.valueOf(ImagePagerActivity.this.fragments.size())}));
                ImagePagerActivity imagePagerActivity2 = ImagePagerActivity.this;
                String unused = imagePagerActivity2.time = ((GridItem) imagePagerActivity2.mGirdList.get(ImagePagerActivity.this.pagerPosition)).getTime();
                ImagePagerActivity.this.nb.setText(ImagePagerActivity.this.time);
            }
        }).show();
    }

    private class ImagePagerAdapter extends FragmentStatePagerAdapter {
        public ImagePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return ImagePagerActivity.this.fragments.size();
        }

        public Fragment getItem(int i) {
            return (Fragment) ImagePagerActivity.this.fragments.get(i);
        }

        public int getItemPosition(Object obj) {
            ImagePagerAdapter unused = ImagePagerActivity.this.mAdapter;
            return -2;
        }
    }
}
