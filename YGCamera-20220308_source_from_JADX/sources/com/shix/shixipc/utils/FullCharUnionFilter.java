package com.shix.shixipc.utils;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.Toast;
import com.xiaomi.mipush.sdk.Constants;
import shix.cykj.camera.R;

public class FullCharUnionFilter implements InputFilter {
    private Context mContext;

    public FullCharUnionFilter(Context context) {
        this.mContext = context;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String stringToAscii = stringToAscii(charSequence.toString());
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        String[] split = stringToAscii.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int i5 = 0;
        while (i5 < split.length) {
            int parseInt = Integer.parseInt(split[i5]);
            if ((parseInt >= 32 && parseInt <= 126) || parseInt == 8364 || parseInt == 65509) {
                i5++;
            } else if (i == i2) {
                return "";
            } else {
                Context context = this.mContext;
                Toast.makeText(context, context.getString(R.string.tip_not_spcialchar), 0).show();
                return "";
            }
        }
        return null;
    }

    public String stringToAscii(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i != charArray.length - 1) {
                stringBuffer.append(charArray[i]);
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            } else {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }
}
