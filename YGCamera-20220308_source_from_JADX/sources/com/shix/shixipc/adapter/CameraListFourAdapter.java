package com.shix.shixipc.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import java.io.File;
import shix.cykj.camera.R;

public class CameraListFourAdapter extends BaseAdapter {
    private static final String LOG_TAG = "CameraListAdapter";
    private Context context = null;
    private String dids;

    /* renamed from: gl */
    private int f1567gl = 0;
    public boolean isSearching = false;
    private LayoutInflater listContainer = null;
    private Matrix matrix;

    public long getItemId(int i) {
        return (long) i;
    }

    public final class CameraListItem {
        public RelativeLayout cameralistrootview;
        public TextView devID;
        public TextView devName;
        public TextView devStatus;
        public TextView devType;
        public ImageView im_play;
        public ImageButton imgBtnSetting;
        public ImageView imgSnapShot;
        public ImageView ivState;
        public Button leftBtn;
        public LinearLayout linear_for;
        public LinearLayout llAlarm;
        public LinearLayout llPic;
        public LinearLayout llSetting;
        public LinearLayout llVideo;
        public TextView textDeafualPwd;
        public View viewItem1;

        public CameraListItem() {
        }
    }

    public CameraListFourAdapter(Context context2) {
        this.context = context2;
        this.listContainer = LayoutInflater.from(context2);
    }

    public void setGl(int i) {
        this.f1567gl = i;
    }

    public int getCount() {
        return SystemValue.arrayList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        CameraListItem cameraListItem;
        View view2;
        int i2;
        synchronized (this) {
            this.f1567gl = 0;
            if (view == null) {
                cameraListItem = new CameraListItem();
                if (this.f1567gl == 1) {
                    view2 = this.listContainer.inflate(R.layout.camera_list_item_other, (ViewGroup) null);
                    cameraListItem.llAlarm = (LinearLayout) view2.findViewById(R.id.llAlarm);
                    cameraListItem.llVideo = (LinearLayout) view2.findViewById(R.id.llVideo);
                    cameraListItem.llPic = (LinearLayout) view2.findViewById(R.id.llPic);
                    cameraListItem.llSetting = (LinearLayout) view2.findViewById(R.id.llSetting);
                    cameraListItem.viewItem1 = view2.findViewById(R.id.viewItem1);
                    cameraListItem.im_play = (ImageView) view2.findViewById(R.id.im_play);
                } else {
                    view2 = this.listContainer.inflate(R.layout.camera_list_item, (ViewGroup) null);
                }
                cameraListItem.linear_for = (LinearLayout) view2.findViewById(R.id.linear_for);
                cameraListItem.imgSnapShot = (ImageView) view2.findViewById(R.id.imgSnapshot);
                cameraListItem.devName = (TextView) view2.findViewById(R.id.cameraDevName);
                cameraListItem.devID = (TextView) view2.findViewById(R.id.cameraDevID);
                cameraListItem.devStatus = (TextView) view2.findViewById(R.id.textPPPPStatus);
                cameraListItem.imgBtnSetting = (ImageButton) view2.findViewById(R.id.imgBtnPPPPSetting);
                cameraListItem.cameralistrootview = (RelativeLayout) view2.findViewById(R.id.cameralistrootview);
                cameraListItem.textDeafualPwd = (TextView) view2.findViewById(R.id.textDeafualPwd);
                cameraListItem.ivState = (ImageView) view2.findViewById(R.id.ivState);
                view2.setTag(cameraListItem);
            } else {
                view2 = view;
                cameraListItem = (CameraListItem) view.getTag();
            }
            if (this.f1567gl == 1) {
                MyOnTouchListener myOnTouchListener = new MyOnTouchListener(i);
                MyOnTouchListener myOnTouchListener2 = new MyOnTouchListener(i);
                MyOnTouchListener myOnTouchListener3 = new MyOnTouchListener(i);
                MyOnTouchListener myOnTouchListener4 = new MyOnTouchListener(i);
                cameraListItem.llAlarm.setOnTouchListener(myOnTouchListener);
                cameraListItem.llVideo.setOnTouchListener(myOnTouchListener2);
                cameraListItem.llPic.setOnTouchListener(myOnTouchListener3);
                cameraListItem.llSetting.setOnTouchListener(myOnTouchListener4);
            } else {
                cameraListItem.imgBtnSetting.setOnTouchListener(new MyOnTouchListener(i));
            }
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
            cameraListItem.devName.setText(cameraParamsBean.getDev_name());
            cameraListItem.devID.setText(cameraParamsBean.getDev_Did());
            Bitmap firstPic = getFirstPic(cameraParamsBean.getDev_Did());
            if (firstPic != null) {
                cameraListItem.imgSnapShot.setImageResource(R.mipmap.qh_trans);
                cameraListItem.imgSnapShot.setBackgroundDrawable(new BitmapDrawable(firstPic));
            }
            int dev_p2pstatus = cameraParamsBean.getDev_p2pstatus();
            this.dids = cameraParamsBean.getDev_Did();
            this.context.getResources().getColor(R.color.color_n_status_offline);
            switch (dev_p2pstatus) {
                case 0:
                    i2 = R.string.pppp_status_connecting;
                    break;
                case 1:
                    i2 = R.string.pppp_status_initialing;
                    break;
                case 2:
                    i2 = R.string.pppp_status_online;
                    this.context.getResources().getColor(R.color.color_qh_addtxt);
                    break;
                case 3:
                    i2 = R.string.pppp_status_connect_failed;
                    break;
                case 4:
                    i2 = R.string.pppp_status_disconnect;
                    break;
                case 5:
                    i2 = R.string.pppp_status_invalid_id;
                    break;
                case 6:
                    i2 = R.string.device_not_on_line;
                    break;
                case 7:
                    i2 = R.string.pppp_status_connect_timeout;
                    break;
                case 8:
                    i2 = R.string.pppp_status_connect_log_errer;
                    this.context.getResources().getColor(R.color.color_pass_word);
                    break;
                default:
                    i2 = R.string.pppp_status_unknown;
                    break;
            }
            String dev_Pwd = cameraParamsBean.getDev_Pwd();
            if (dev_p2pstatus == 2 && this.f1567gl == 1 && dev_Pwd != null && dev_Pwd.length() != 0 && dev_Pwd.length() >= 3 && !dev_Pwd.equalsIgnoreCase("admin") && !dev_Pwd.equalsIgnoreCase("12345") && !dev_Pwd.equalsIgnoreCase("654321") && !dev_Pwd.equalsIgnoreCase("123456789")) {
                dev_Pwd.equalsIgnoreCase("987654321");
            }
            if (this.f1567gl == 1) {
                cameraListItem.devStatus.setText(i2);
            } else {
                cameraListItem.devStatus.setText(this.context.getResources().getString(i2));
            }
        }
        return view2;
    }

    private class MyOnTouchListener implements View.OnTouchListener {
        private int position;

        public MyOnTouchListener(int i) {
            this.position = i;
            CommonUtil.Log(1, "zhaogenghuai position:" + i);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            CommonUtil.Log(1, "zhaogenghuai position1:" + this.position);
            motionEvent.getAction();
            return true;
        }
    }

    public CameraParamsBean getItemCamera(int i) {
        return SystemValue.arrayList.get(i);
    }

    public boolean AddCamera(String str, String str2, String str3, String str4) {
        if (!CheckCameraInfo(str2)) {
            return false;
        }
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        cameraParamsBean.setDev_name(str);
        cameraParamsBean.setDev_Did(str2);
        cameraParamsBean.setDev_User(str3);
        cameraParamsBean.setDev_Pwd(str4);
        synchronized (this) {
            SystemValue.arrayList.add(cameraParamsBean);
            ContentCommon.SHIX_saveDev(cameraParamsBean);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean UpdataCameraResetrict(java.lang.String r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "zhaogenghuaiUpdataCameraStatus did:"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = "  resetrict:"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r1 = 1
            com.shix.shixipc.utils.CommonUtil.Log(r1, r0)
            monitor-enter(r6)
            java.util.ArrayList<com.shix.shixipc.bean.CameraParamsBean> r0 = com.shix.shixipc.system.SystemValue.arrayList     // Catch:{ all -> 0x004e }
            int r0 = r0.size()     // Catch:{ all -> 0x004e }
            r2 = 0
            r3 = 0
        L_0x0026:
            if (r3 >= r0) goto L_0x004c
            java.util.ArrayList<com.shix.shixipc.bean.CameraParamsBean> r4 = com.shix.shixipc.system.SystemValue.arrayList     // Catch:{ all -> 0x004e }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x004e }
            com.shix.shixipc.bean.CameraParamsBean r4 = (com.shix.shixipc.bean.CameraParamsBean) r4     // Catch:{ all -> 0x004e }
            java.lang.String r5 = r4.getDev_Did()     // Catch:{ all -> 0x004e }
            boolean r5 = r7.equals(r5)     // Catch:{ all -> 0x004e }
            if (r5 == 0) goto L_0x0049
            r4.setResetrict(r8)     // Catch:{ all -> 0x004e }
            if (r9 == 0) goto L_0x0042
            r4.setDevMode(r9)     // Catch:{ all -> 0x004e }
        L_0x0042:
            if (r10 == 0) goto L_0x0047
            r4.setDevType(r10)     // Catch:{ all -> 0x004e }
        L_0x0047:
            monitor-exit(r6)     // Catch:{ all -> 0x004e }
            return r1
        L_0x0049:
            int r3 = r3 + 1
            goto L_0x0026
        L_0x004c:
            monitor-exit(r6)     // Catch:{ all -> 0x004e }
            return r2
        L_0x004e:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x0051:
            throw r7
        L_0x0052:
            goto L_0x0051
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.adapter.CameraListFourAdapter.UpdataCameraResetrict(java.lang.String, int, int, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean UpdataCameraStatus(java.lang.String r7, int r8) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "zhaogenghuaiUpdataCameraStatus did:"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = "  status:"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r1 = 1
            com.shix.shixipc.utils.CommonUtil.Log(r1, r0)
            monitor-enter(r6)
            java.util.ArrayList<com.shix.shixipc.bean.CameraParamsBean> r0 = com.shix.shixipc.system.SystemValue.arrayList     // Catch:{ all -> 0x0052 }
            int r0 = r0.size()     // Catch:{ all -> 0x0052 }
            r2 = 0
            r3 = 0
        L_0x0026:
            if (r3 >= r0) goto L_0x0050
            java.util.ArrayList<com.shix.shixipc.bean.CameraParamsBean> r4 = com.shix.shixipc.system.SystemValue.arrayList     // Catch:{ all -> 0x0052 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x0052 }
            com.shix.shixipc.bean.CameraParamsBean r4 = (com.shix.shixipc.bean.CameraParamsBean) r4     // Catch:{ all -> 0x0052 }
            java.lang.String r5 = r4.getDev_Did()     // Catch:{ all -> 0x0052 }
            boolean r5 = r7.equals(r5)     // Catch:{ all -> 0x0052 }
            if (r5 == 0) goto L_0x004d
            int r7 = r4.getDev_p2pstatus()     // Catch:{ all -> 0x0052 }
            if (r7 != r8) goto L_0x0042
            monitor-exit(r6)     // Catch:{ all -> 0x0052 }
            return r2
        L_0x0042:
            r4.setDev_p2pstatus(r8)     // Catch:{ all -> 0x0052 }
            r7 = 6
            if (r8 != r7) goto L_0x004b
            r4.setCheckint(r2)     // Catch:{ all -> 0x0052 }
        L_0x004b:
            monitor-exit(r6)     // Catch:{ all -> 0x0052 }
            return r1
        L_0x004d:
            int r3 = r3 + 1
            goto L_0x0026
        L_0x0050:
            monitor-exit(r6)     // Catch:{ all -> 0x0052 }
            return r2
        L_0x0052:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0055:
            throw r7
        L_0x0056:
            goto L_0x0055
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.adapter.CameraListFourAdapter.UpdataCameraStatus(java.lang.String, int):boolean");
    }

    private boolean CheckCameraInfo(String str) {
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            for (int i = 0; i < size; i++) {
                if (SystemValue.arrayList.get(i).getDev_Did().equals(str)) {
                    return false;
                }
            }
            return true;
        }
    }

    public CameraParamsBean getOnItem(int i) {
        synchronized (this) {
            if (i > SystemValue.arrayList.size()) {
                return null;
            }
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
            return cameraParamsBean;
        }
    }

    public void sendCameraStatus() {
        int size = SystemValue.arrayList.size();
        for (int i = 0; i < size; i++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
            int dev_p2pstatus = cameraParamsBean.getDev_p2pstatus();
            String dev_Did = cameraParamsBean.getDev_Did();
            Intent intent = new Intent("camera_status_change");
            intent.putExtra(ContentCommon.STR_CAMERA_ID, dev_Did);
            intent.putExtra(ContentCommon.STR_PPPP_STATUS, dev_p2pstatus);
            this.context.sendBroadcast(intent);
        }
    }

    public boolean delCamera(String str) {
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            for (int i = 0; i < size; i++) {
                if (SystemValue.arrayList.get(i).getDev_Did().equals(str)) {
                    SystemValue.arrayList.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean UpdateCamera(String str, String str2, String str3, String str4, String str5) {
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            for (int i = 0; i < size; i++) {
                CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
                if (str.equals(cameraParamsBean.getDev_Did())) {
                    cameraParamsBean.setDev_name(str2);
                    cameraParamsBean.setDev_Did(str3);
                    cameraParamsBean.setDev_User(str4);
                    cameraParamsBean.setDev_Pwd(str5);
                    cameraParamsBean.setDev_p2pstatus(-1);
                    ContentCommon.SHIX_saveDev(cameraParamsBean);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean UpdateCameraImage(String str, Bitmap bitmap) {
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            for (int i = 0; i < size; i++) {
                if (SystemValue.arrayList.get(i).getDev_Did().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    private Bitmap getFirstPic(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), "YGCamera/picid");
        File file2 = new File(file, str + ".jpg");
        if (!file2.exists()) {
            CommonUtil.Log(1, "zhaogenghuai  !file.exists()");
            return null;
        }
        CommonUtil.Log(1, "zhaogenghuai path:" + file2.getAbsolutePath());
        return BitmapFactory.decodeFile(file2.getAbsolutePath());
    }
}
