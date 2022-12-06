package com.tzh.ipcamera.view.delegate;

public interface FileRequestDelegate {
    void didTFCardGetList(int i, Object obj);

    void didTFCardGetListFail();

    void didTFCardNoFile();

    void didTFCardUnInsert();

    void didTFCardUnknowError();
}
