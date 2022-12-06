package com.tzh.ipcamera.presenter;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import com.tzh.ipcamera.presenter.bean.FileBean;
import com.tzh.ipcamera.presenter.bean.TFDateBean;
import com.tzh.ipcamera.presenter.bean.TFJsonBean;
import com.tzh.ipcamera.presenter.utils.ListParser;
import com.tzh.ipcamera.view.delegate.FileRequestDelegate;
import com.tzh.ipcamera.view.delegate.IRecordFileInterface;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import shix.ihdbell.project.BridgeService;

public class FileListUtils implements IRecordFileInterface {
    public static final int PHOTO = 1;
    public static final int TFCARD_NO_FILE = -1;
    public static final int TFCARD_UNKNOW_ERROR = -3;
    public static final int TFCARD_UN_INSERT = -2;
    public static final int VIDEO = 0;
    private int curPage = 1;
    public FileRequestDelegate fileRequestDelegate = null;
    private int fileType = 0;
    LogUtils logUtils = LogUtils.setLogger(FileListUtils.class);
    private Context mContext = null;
    private String strDate = "";
    private TFDateBean tfDateBean;
    private List<TFDateBean> tfDateBeans = new ArrayList();

    public FileListUtils(Context context, int i) {
        this.mContext = context;
        this.fileType = i;
        ListParser.getInstance(context);
    }

    public void registerListener(FileRequestDelegate fileRequestDelegate2) {
        this.logUtils.e("###start register listener");
        BridgeService.setRecordFileInterface(this);
        this.fileRequestDelegate = fileRequestDelegate2;
    }

    public void unregisterListener() {
        this.logUtils.e("###stop register listener");
        BridgeService.setRecordFileInterface((IRecordFileInterface) null);
        this.fileRequestDelegate = null;
    }

    public int getDateListID(String str) {
        int i = 0;
        for (TFDateBean tFDateBean : this.tfDateBeans) {
            if (tFDateBean.strFileDate.equals(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void setFileDateList(List<FileBean> list) {
        for (FileBean next : list) {
            String str = next.filename;
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf >= 0 && str.toLowerCase().endsWith(".avi")) {
                try {
                    String substring = str.substring(lastIndexOf + 1, lastIndexOf + 15);
                    int dateListID = getDateListID(substring);
                    if (dateListID == -1) {
                        this.tfDateBean = new TFDateBean();
                        TFDateBean tFDateBean = this.tfDateBean;
                        tFDateBean.strFileDate = substring;
                        tFDateBean.dateFileList.add(next);
                        this.tfDateBeans.add(this.tfDateBean);
                    } else {
                        this.tfDateBeans.get(dateListID).dateFileList.add(next);
                    }
                } catch (Exception unused) {
                    this.tfDateBean = new TFDateBean();
                    TFDateBean tFDateBean2 = this.tfDateBean;
                    tFDateBean2.strFileDate = EnvironmentCompat.MEDIA_UNKNOWN;
                    tFDateBean2.dateFileList.add(next);
                    this.tfDateBeans.add(this.tfDateBean);
                }
            }
        }
    }

    public void startGetTFFile(String str, int i, int i2) {
        String format = String.format("/getfilelist.cgi?loginuse=admin&loginpas=admin&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass + "&type=" + i + "&page=" + i2 + "&count=" + 50, new Object[0]);
        this.logUtils.e(format);
        NativeCaller.TransferMessage(str, format, 1);
    }

    private class ComparatorByDate implements Comparator<TFDateBean> {
        private ComparatorByDate() {
        }

        public int compare(TFDateBean tFDateBean, TFDateBean tFDateBean2) {
            return tFDateBean2.getStrFileDate().compareToIgnoreCase(tFDateBean.getStrFileDate());
        }
    }

    public void onRecordFileNotify(String str, int i, byte[] bArr, int i2) {
        try {
            TFJsonBean startParse = ListParser.getInstance(this.mContext).startParse(new String(bArr, "UTF-8"));
            if (startParse == null) {
                this.fileRequestDelegate.didTFCardGetListFail();
                return;
            }
            LogUtils logUtils2 = this.logUtils;
            logUtils2.e("###tfJsonBean " + startParse.result);
            if (startParse.result == -1) {
                this.logUtils.e("###result:TFCARD_NO_FILE");
                if (this.fileRequestDelegate != null) {
                    this.fileRequestDelegate.didTFCardNoFile();
                }
            } else if (startParse.result == -2) {
                if (this.fileRequestDelegate != null) {
                    this.fileRequestDelegate.didTFCardUnInsert();
                }
                this.logUtils.e("###result:TFCARD_UN_INSERT");
            } else if (startParse.result == -3) {
                if (this.fileRequestDelegate != null) {
                    this.fileRequestDelegate.didTFCardUnknowError();
                }
                this.logUtils.e("###result:TFCARD_UNKNOW_ERROR");
            } else {
                if (startParse != null) {
                    setFileDateList(startParse.files);
                }
                this.fileRequestDelegate.didTFCardGetList(this.fileType, this.tfDateBeans);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
