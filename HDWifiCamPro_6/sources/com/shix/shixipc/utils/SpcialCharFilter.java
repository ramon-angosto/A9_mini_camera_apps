package com.shix.shixipc.utils;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.Toast;
import com.shix.qhipc.R;

public class SpcialCharFilter implements InputFilter {
    private Context mContext;

    public SpcialCharFilter(Context context) {
        this.mContext = context;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String stringToAscii = stringToAscii(charSequence.toString());
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        String[] split = stringToAscii.split(",");
        int i5 = 0;
        while (i5 < split.length) {
            int parseInt = Integer.parseInt(split[i5]);
            if (parseInt > 32 && parseInt <= 126 && parseInt != 34 && parseInt != 38 && parseInt != 92 && parseInt != 61 && parseInt != 43) {
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
                stringBuffer.append(",");
            } else {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }
}
