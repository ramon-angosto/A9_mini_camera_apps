package com.huawei.hms.common.internal;

import com.huawei.hms.utils.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class TransactionIdCreater {
    private static final int API_SIZE = 6;
    private static final int APPID_SIZE = 9;
    private static final char FILL_BYTE = '0';

    public static String getId(String str, String str2) {
        return StringUtil.addByteForNum(str, 9, FILL_BYTE) + StringUtil.addByteForNum(str2, 6, FILL_BYTE) + new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(new Date()) + String.format(Locale.ENGLISH, "%06d", new Object[]{Integer.valueOf(new Random().nextInt(1000000))});
    }
}
