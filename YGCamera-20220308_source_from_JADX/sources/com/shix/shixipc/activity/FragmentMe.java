package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import shix.cykj.camera.R;

public class FragmentMe extends BaseFragment implements View.OnClickListener {
    private static LogoutInterface logoutInterface;
    private Button btnLogout;
    private SharedPreferences preSHIX;
    int tag = 0;
    private TextView tv_name;
    private TextView tv_size;

    public interface LogoutInterface {
        void LogOutClick();
    }

    public static void setLogoutInterface(LogoutInterface logoutInterface2) {
        logoutInterface = logoutInterface2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_me, viewGroup, false);
        this.tv_size = (TextView) inflate.findViewById(R.id.tv_size);
        this.tv_name = (TextView) inflate.findViewById(R.id.tv_name);
        this.btnLogout = (Button) inflate.findViewById(R.id.btnLogout);
        this.btnLogout.setOnClickListener(this);
        inflate.findViewById(R.id.rl_ys).setOnClickListener(this);
        inflate.findViewById(R.id.rl_help).setOnClickListener(this);
        this.preSHIX = getActivity().getSharedPreferences(ContentCommon.SHIXLOGUSERPWD, 0);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        String string = this.preSHIX.getString(ContentCommon.SHIX_LONGIN_USER, "");
        TextView textView = this.tv_name;
        textView.setText(string + "");
        TextView textView2 = this.tv_size;
        textView2.setText(SystemValue.arrayList.size() + " " + getResources().getString(R.string.main_me_dev));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10);
        }
        int id = view.getId();
        if (id == R.id.btnLogout) {
            LogoutInterface logoutInterface2 = logoutInterface;
            if (logoutInterface2 != null) {
                logoutInterface2.LogOutClick();
            }
        } else if (id == R.id.rl_help) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), MenuHelepActivity.class);
            intent.putExtra("position", 1);
            startActivity(intent);
        } else if (id == R.id.rl_ys) {
            Intent intent2 = new Intent();
            intent2.setClass(getActivity(), MenuHelepActivity.class);
            intent2.putExtra("position", 0);
            startActivity(intent2);
        }
    }
}
