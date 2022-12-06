package com.shix.shixipc;

import android.os.Environment;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.cykj.camera.R;

public class BaseFragment extends Fragment {
    public boolean checkChina(String str, int i) {
        return false;
    }

    public void showToast(String str) {
        Toast.makeText(getActivity(), str, 0).show();
    }

    public void showToast(int i) {
        Toast.makeText(getActivity(), getResources().getString(i), 0).show();
    }

    public void showToastLong(int i) {
        Toast.makeText(getActivity(), getResources().getString(i), 1).show();
    }

    public String returnString(int i) {
        return getResources().getString(i);
    }

    public void StartPPPP(String str, String str2, String str3, String str4) {
        String str5;
        String substring = str.substring(0, 3);
        if (substring.equalsIgnoreCase("GBE")) {
            str5 = "EBGAEIBIKHJJGFJKEOGIFKEFHCMCHMNBG";
        } else {
            str5 = substring.equalsIgnoreCase("OBJ") ? "EBGAEOBOKHJMHMJMENGKFIEEHBMDHNNEGNEBBCCCBII" : "EBGAEIBIKHJJGFJJEEHOFAENHLNBHGNMHMFDAADAAOJNKNKG";
        }
        NativeCaller.StartPPPP(str, str2, str3, str5);
    }

    public void StartPPPP(String str, String str2, String str3) {
        NativeCaller.StartPPPP(str, str2, str3, ContentCommon.SERVER_STRING);
    }

    public void StopPPPP(String str) {
        CommonUtil.Log(1, "StartPPPP--StopPPPP停止连接 " + str);
        NativeCaller.StopPPPP(str);
    }

    class MyStopThread extends Thread {
        private String strdidTest;

        public MyStopThread(String str) {
            this.strdidTest = str;
        }

        public void run() {
            NativeCaller.StopPPPP(this.strdidTest);
            super.run();
        }
    }

    class MyStartThread extends Thread {
        private String strdidTest;
        private String strpwdTest;
        private String strserverTest;
        private String struserTest;

        public MyStartThread(String str, String str2, String str3, String str4) {
            this.strdidTest = str;
            this.struserTest = str2;
            this.strpwdTest = str3;
            this.strserverTest = str4;
        }

        public void run() {
            CommonUtil.Log(1, "SHIXDEV---StartPPP1 strdidTest:" + this.strdidTest);
            NativeCaller.StartPPPP(this.strdidTest, this.struserTest, this.strpwdTest, this.strserverTest);
            super.run();
        }
    }

    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public boolean checkChinaDID(String str) {
        return str == null || !str.startsWith("DGKC");
    }

    public boolean checkChina1(String str, int i) {
        if (i == 0) {
            return false;
        }
        if (SystemValue.isInCn == 1) {
            return true;
        }
        if (SystemValue.isInCn == 2) {
            return false;
        }
        return CommonUtil.isCN(getContext()) || getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI");
    }
}
