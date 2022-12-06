package com.xiaomi.clientreport.processor;

import com.xiaomi.clientreport.data.C1526a;
import java.util.ArrayList;
import java.util.HashMap;

public interface IEventProcessor extends C1539c, C1540d {
    String bytesToString(byte[] bArr);

    void setEventMap(HashMap<String, ArrayList<C1526a>> hashMap);

    byte[] stringToBytes(String str);
}
