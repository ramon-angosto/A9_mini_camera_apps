package com.shix.shixipc.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.utils.CommonUtil;
import java.io.File;
import java.util.ArrayList;

public class AlarmActivityAdapter extends BaseAdapter {
    private Context context;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private ArrayList<CameraParamsBean> list = null;

    public long getItemId(int i) {
        return (long) i;
    }

    public AlarmActivityAdapter(Context context2, ArrayList<CameraParamsBean> arrayList) {
        this.list = arrayList;
        this.context = context2;
        this.inflater = LayoutInflater.from(this.context);
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = this.inflater.inflate(R.layout.alarmactivity_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.name = (TextView) view.findViewById(R.id.tv_name);
            this.holder.did = (TextView) view.findViewById(R.id.tv_did);
            this.holder.status = (TextView) view.findViewById(R.id.tv_status);
            this.holder.imgSnapShot = (ImageView) view.findViewById(R.id.imgSnapshot);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        CameraParamsBean cameraParamsBean = this.list.get(i);
        int dev_p2pstatus = cameraParamsBean.getDev_p2pstatus();
        int color = this.context.getResources().getColor(R.color.color_n_status_offline);
        Bitmap firstPic = getFirstPic(cameraParamsBean.getDev_Did());
        if (firstPic != null) {
            this.holder.imgSnapShot.setImageResource(R.mipmap.qh_trans);
            this.holder.imgSnapShot.setBackgroundDrawable(new BitmapDrawable(firstPic));
        }
        switch (dev_p2pstatus) {
            case 0:
                i2 = R.string.pppp_status_connecting;
                break;
            case 1:
                i2 = R.string.pppp_status_initialing;
                break;
            case 2:
                i2 = R.string.pppp_status_online;
                color = this.context.getResources().getColor(R.color.color_qh_addtxt);
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
                color = this.context.getResources().getColor(R.color.color_pass_word);
                break;
            default:
                i2 = R.string.pppp_status_unknown;
                break;
        }
        this.holder.status.setTextColor(color);
        this.holder.status.setText(i2);
        this.holder.name.setText(cameraParamsBean.getDev_name());
        this.holder.did.setText(cameraParamsBean.getDev_Did());
        return view;
    }

    private Bitmap getFirstPic(String str) {
        File file = new File(CommonUtil.getSDFilePath(), "HDWiFiCam/picid");
        File file2 = new File(file, str + ".jpg");
        if (!file2.exists()) {
            CommonUtil.Log(1, "zhaogenghuai  !file.exists()");
            return null;
        }
        CommonUtil.Log(1, "zhaogenghuai path:" + file2.getAbsolutePath());
        return BitmapFactory.decodeFile(file2.getAbsolutePath());
    }

    public CameraParamsBean getItemCam(int i) {
        return this.list.get(i);
    }

    private class ViewHolder {
        ImageView arrow;
        RelativeLayout cameralistrootview;
        TextView did;
        ImageView imgSnapShot;
        TextView name;
        TextView status;

        private ViewHolder() {
        }
    }
}
