package com.shix.shixipc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.SystemValue;
import shix.cykj.camera.R;

public class CameraSelectAdapter extends BaseAdapter {
    public boolean hasSelect = false;
    private ViewHolder holder;
    private LayoutInflater inflater;

    public long getItemId(int i) {
        return (long) i;
    }

    public CameraSelectAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return SystemValue.arrayList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = this.inflater.inflate(R.layout.camera_select_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.tvID = (TextView) view.findViewById(R.id.cameraDevID);
            this.holder.tvName = (TextView) view.findViewById(R.id.cameraDevName);
            this.holder.textPPPPStatus = (TextView) view.findViewById(R.id.textPPPPStatus);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
        this.holder.tvID.setText(cameraParamsBean.getDev_Did());
        this.holder.tvName.setText(cameraParamsBean.getDev_name());
        switch (cameraParamsBean.getDev_p2pstatus()) {
            case 0:
                i2 = R.string.pppp_status_connecting;
                break;
            case 1:
                i2 = R.string.pppp_status_initialing;
                break;
            case 2:
                i2 = R.string.pppp_status_online;
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
                break;
            default:
                i2 = R.string.pppp_status_unknown;
                break;
        }
        this.holder.textPPPPStatus.setText(i2);
        return view;
    }

    private class ViewHolder {
        TextView textPPPPStatus;
        TextView tvID;
        TextView tvName;

        private ViewHolder() {
        }
    }
}
