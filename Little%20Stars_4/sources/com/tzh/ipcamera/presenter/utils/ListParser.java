package com.tzh.ipcamera.presenter.utils;

import android.content.Context;
import com.google.gson.Gson;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.presenter.bean.TFJsonBean;

public class ListParser {
    public static final int NOFILE = 1;
    public static final int NO_TF_INSERT = 2;
    public static final int PHOTO = 0;
    public static final int SUCCESS = 0;
    public static final int TF_ERR = 3;
    public static final int VIDEO = 0;
    private static ListParser mInstance;
    LogUtils logUtils = LogUtils.setLogger(ListParser.class);
    public Context mContext = null;

    private ListParser(Context context) {
        this.mContext = context;
    }

    public static ListParser getInstance(Context context) {
        synchronized (ListParser.class) {
            if (mInstance == null) {
                mInstance = new ListParser(context);
            }
        }
        return mInstance;
    }

    public TFJsonBean startParse(String str) {
        try {
            return (TFJsonBean) new Gson().fromJson(str, TFJsonBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
