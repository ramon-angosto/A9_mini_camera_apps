package com.tzh.ipcamera.presenter.bean;

import java.util.ArrayList;
import java.util.List;

public class TFDateBean {
    public String cmd;
    public int curPage;
    public List<FileBean> dateFileList = new ArrayList();
    public int result;
    public String strFileDate;
    public int totalPage;
    public int type;

    public String getStrFileDate() {
        return this.strFileDate;
    }
}
