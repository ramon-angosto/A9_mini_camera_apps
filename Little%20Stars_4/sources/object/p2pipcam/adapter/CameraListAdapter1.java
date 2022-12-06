package object.p2pipcam.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.io.File;
import java.util.Iterator;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.DataBaseHelper;
import shix.ihdbell.project.IpcamClientActivity1;

public class CameraListAdapter1 extends BaseAdapter {
    private static final String LOG_TAG = "CameraListAdapter";
    private Context context = null;
    private String dids;
    private DataBaseHelper helper = null;
    /* access modifiers changed from: private */
    public IpcamClientActivity1 ipcamClientActivity;
    private boolean isFirst = true;
    public boolean isSearching = false;
    private LayoutInflater listContainer = null;
    private Matrix matrix;

    public long getItemId(int i) {
        return (long) i;
    }

    public CameraListAdapter1(Context context2, IpcamClientActivity1 ipcamClientActivity1) {
        this.ipcamClientActivity = ipcamClientActivity1;
        this.context = context2;
        this.listContainer = LayoutInflater.from(context2);
        this.helper = DataBaseHelper.getInstance(this.context);
    }

    public int getCount() {
        return SystemValue.arrayList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        CameraListItem cameraListItem;
        int i2;
        synchronized (this) {
            int i3 = 0;
            while (true) {
                Bitmap bitmap = null;
                if (i3 < SystemValue.arrayList.size()) {
                    CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i3);
                    String did = cameraParamsBean.getDid();
                    Cursor queryAllPicture = this.helper.queryAllPicture(did);
                    int count = queryAllPicture.getCount();
                    this.isFirst = true;
                    while (queryAllPicture.moveToNext()) {
                        String string = queryAllPicture.getString(queryAllPicture.getColumnIndex(DataBaseHelper.KEY_FILEPATH));
                        if (!new File(string).exists()) {
                            count--;
                            Log.d("tag", "delResult:" + this.helper.deleteVideoOrPicture(did, string, DataBaseHelper.TYPE_PICTURE));
                        } else if (this.isFirst) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = 5;
                            bitmap = BitmapFactory.decodeFile(string, options);
                            this.isFirst = false;
                        }
                    }
                    if (queryAllPicture != null) {
                        queryAllPicture.close();
                    }
                    cameraParamsBean.setBmp(bitmap);
                    cameraParamsBean.setSum_pic(count);
                    i3++;
                } else {
                    CameraParamsBean cameraParamsBean2 = SystemValue.arrayList.get(i);
                    if (view == null) {
                        cameraListItem = new CameraListItem();
                        if (SystemValue.TAG_CAMERLIST == 0) {
                            view2 = this.listContainer.inflate(R.layout.camera_list_item, (ViewGroup) null);
                            cameraListItem.alerm_check_box = (CheckBox) view2.findViewById(R.id.alerm_check_box);
                        } else {
                            view2 = this.listContainer.inflate(R.layout.camera_list_item_f, (ViewGroup) null);
                            cameraListItem.alerm_check_box = (CheckBox) view2.findViewById(R.id.alerm_check_box);
                        }
                        cameraListItem.imgSnapShot = (ImageView) view2.findViewById(R.id.imgSnapshot);
                        cameraListItem.devName = (TextView) view2.findViewById(R.id.cameraDevName);
                        cameraListItem.devID = (TextView) view2.findViewById(R.id.cameraDevID);
                        cameraListItem.devStatus = (TextView) view2.findViewById(R.id.textPPPPStatus);
                        cameraListItem.imgBtnSetting = (ImageButton) view2.findViewById(R.id.imgBtnPPPPSetting);
                        view2.setTag(cameraListItem);
                    } else {
                        CameraListItem cameraListItem2 = (CameraListItem) view.getTag();
                        if (cameraParamsBean2.getIndex1() == 1) {
                            cameraListItem2.alerm_check_box.setSelected(true);
                        } else {
                            cameraListItem2.alerm_check_box.setSelected(false);
                        }
                        cameraListItem2.alerm_check_box.setOnCheckedChangeListener(new MyCheckOnclick(i, cameraListItem2.alerm_check_box));
                        view2 = view;
                        cameraListItem = cameraListItem2;
                    }
                    cameraListItem.imgBtnSetting.setOnTouchListener(new MyOnTouchListener(i));
                    cameraListItem.devName.setText(cameraParamsBean2.getName());
                    cameraListItem.devID.setText(cameraParamsBean2.getDid());
                    Bitmap bmp = cameraParamsBean2.getBmp();
                    if (bmp != null) {
                        cameraListItem.imgSnapShot.setBackgroundDrawable(new BitmapDrawable(bmp));
                    } else {
                        Bitmap firstPic = getFirstPic(cameraParamsBean2.getDid());
                        if (firstPic != null) {
                            cameraListItem.imgSnapShot.setBackgroundDrawable(new BitmapDrawable(firstPic));
                        } else {
                            cameraListItem.imgSnapShot.setBackgroundResource(R.drawable.vidicon);
                        }
                    }
                    view2.setOnTouchListener(new MyOnTouchLister(i));
                    int status = cameraParamsBean2.getStatus();
                    this.dids = cameraParamsBean2.getDid();
                    int i4 = -1873408;
                    switch (status) {
                        case 0:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_connecting;
                            break;
                        case 1:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_initialing;
                            break;
                        case 2:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_online;
                            break;
                        case 3:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_connect_failed;
                            break;
                        case 4:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_disconnect;
                            break;
                        case 5:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_invalid_id;
                            break;
                        case 6:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.device_not_on_line;
                            break;
                        case 7:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_connect_timeout;
                            break;
                        case 8:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_connect_log_errer;
                            break;
                        case 9:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_connect_user_login;
                            break;
                        case 10:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_connect_pwd_cuo;
                            break;
                        default:
                            cameraListItem.imgBtnSetting.setImageResource(R.drawable.setting_btn_no);
                            i2 = R.string.pppp_status_unknown;
                            break;
                    }
                    i4 = SupportMenu.CATEGORY_MASK;
                    cameraListItem.devStatus.setText(i2);
                    cameraListItem.devStatus.setTextColor(i4);
                }
            }
        }
        return view2;
    }

    private Bitmap getFirstPic(String str) {
        String str2;
        Cursor queryFirstpic = this.helper.queryFirstpic(str);
        if (queryFirstpic.getCount() > 0) {
            queryFirstpic.moveToNext();
            str2 = queryFirstpic.getString(queryFirstpic.getColumnIndex(DataBaseHelper.KEY_FILEPATH));
        } else {
            str2 = null;
        }
        if (queryFirstpic != null) {
            queryFirstpic.close();
        }
        if (str2 != null) {
            return BitmapFactory.decodeFile(str2);
        }
        return null;
    }

    public CameraParamsBean getItemCamera(int i) {
        return SystemValue.arrayList.get(i);
    }

    public boolean AddCamera(String str, String str2, String str3, String str4) {
        if (!CheckCameraInfo(str2)) {
            return false;
        }
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        cameraParamsBean.setAuthority(false);
        cameraParamsBean.setName(str);
        cameraParamsBean.setDid(str2);
        cameraParamsBean.setUser(str3);
        cameraParamsBean.setPwd(str4);
        cameraParamsBean.setStatus(-1);
        cameraParamsBean.setMode(-1);
        cameraParamsBean.setBmp((Bitmap) null);
        synchronized (this) {
            SystemValue.arrayList.add(cameraParamsBean);
        }
        return true;
    }

    public void upadeUserAuthority(String str, String str2, String str3) {
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            CameraParamsBean next = it.next();
            if (next.getDid().equals(str)) {
                String user = next.getUser();
                String pwd = next.getPwd();
                if (!str2.equals(user) || !str3.equals(pwd)) {
                    next.setAuthority(false);
                    return;
                } else {
                    next.setAuthority(true);
                    return;
                }
            }
        }
    }

    public boolean UpdataCameraDevType(String str, int i) {
        synchronized (this) {
            Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
            while (it.hasNext()) {
                CameraParamsBean next = it.next();
                if (next.getDid().equals(str)) {
                    next.setDevType(i);
                    return true;
                }
            }
            return false;
        }
    }

    public void upadeUserServer(String str, String str2) {
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            CameraParamsBean next = it.next();
            if (next.getDid().equals(str)) {
                next.setStrServer(str2);
            }
        }
    }

    public boolean UpdateCameraImage(String str, Bitmap bitmap) {
        synchronized (this) {
            this.matrix = new Matrix();
            this.matrix.postScale(0.2f, 0.2f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), this.matrix, true);
            int size = SystemValue.arrayList.size();
            for (int i = 0; i < size; i++) {
                CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
                if (cameraParamsBean.getDid().equals(str)) {
                    cameraParamsBean.setBmp(createBitmap);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean UpdataCameraStatus(String str, int i) {
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i2);
                if (!str.equals(cameraParamsBean.getDid())) {
                    i2++;
                } else if (cameraParamsBean.getStatus() == i) {
                    return false;
                } else {
                    cameraParamsBean.setStatus(i);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean UpdataCameraType(String str, int i) {
        synchronized (this) {
            Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
            while (it.hasNext()) {
                CameraParamsBean next = it.next();
                if (next.getDid().equals(str)) {
                    if (next.getMode() == i) {
                        return false;
                    }
                    next.setMode(i);
                    return true;
                }
            }
            return false;
        }
    }

    private boolean CheckCameraInfo(String str) {
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            for (int i = 0; i < size; i++) {
                if (SystemValue.arrayList.get(i).getDid().equals(str)) {
                    return false;
                }
            }
            return true;
        }
    }

    public CameraParamsBean getOnItem(int i) {
        synchronized (this) {
            if (i > SystemValue.arrayList.size() - 1) {
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
            int status = cameraParamsBean.getStatus();
            String did = cameraParamsBean.getDid();
            Intent intent = new Intent("camera_status_change");
            intent.putExtra(ContentCommon.STR_CAMERA_ID, did);
            intent.putExtra(ContentCommon.STR_PPPP_STATUS, status);
            this.context.sendBroadcast(intent);
        }
    }

    public boolean delCamera(String str) {
        Log.d(LOG_TAG, "Call delCamera");
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            for (int i = 0; i < size; i++) {
                if (SystemValue.arrayList.get(i).getDid().equals(str)) {
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
                if (str.equals(cameraParamsBean.getDid())) {
                    cameraParamsBean.setName(str2);
                    cameraParamsBean.setDid(str3);
                    cameraParamsBean.setUser(str4);
                    cameraParamsBean.setPwd(str5);
                    cameraParamsBean.setAuthority(false);
                    cameraParamsBean.setStatus(-1);
                    return true;
                }
            }
            return false;
        }
    }

    public final class CameraListItem {
        public CheckBox alerm_check_box;
        public TextView devID;
        public TextView devName;
        public TextView devStatus;
        public TextView devType;
        public ImageButton imgBtnSetting;
        public ImageView imgSnapShot;
        public Button leftBtn;

        public CameraListItem() {
        }
    }

    private class MyOnTouchLister implements View.OnTouchListener {
        private int position;

        public MyOnTouchLister(int i) {
            this.position = i;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(this.position);
            return false;
        }
    }

    private class MyCheckOnclick implements CompoundButton.OnCheckedChangeListener {
        private CheckBox checkBox;
        private int position;

        public MyCheckOnclick(int i, CheckBox checkBox2) {
            this.position = i;
            this.checkBox = checkBox2;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(this.position);
            if (z) {
                String str = "doorbell_control.cgi?index=1&value=1&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass;
                Log.d("test", "shix-cgi5:" + str);
                NativeCaller.TransferMessage(cameraParamsBean.getDid(), str, 1);
                this.checkBox.setSelected(true);
                return;
            }
            String str2 = "doorbell_control.cgi?index=1&value=0&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass;
            Log.d("test", "shix-cgi5:" + str2);
            NativeCaller.TransferMessage(cameraParamsBean.getDid(), str2, 1);
            this.checkBox.setSelected(false);
        }
    }

    private class MyOnTouchListener implements View.OnTouchListener {
        private int position;

        public MyOnTouchListener(int i) {
            this.position = i;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 || CameraListAdapter1.this.ipcamClientActivity == null) {
                return false;
            }
            CameraListAdapter1.this.ipcamClientActivity.showSetting(this.position);
            return false;
        }
    }
}
