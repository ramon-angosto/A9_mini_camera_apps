package com.shix.shixipc.utils;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.HashSet;
import java.util.Set;

public class EmojiFilterOne implements InputFilter {
    private static Set<String> filterSet = new HashSet();

    static {
        addUnicodeRangeToSet(filterSet, 128513, 128591);
        addUnicodeRangeToSet(filterSet, 9986, 10160);
        addUnicodeRangeToSet(filterSet, 128640, 128704);
        addUnicodeRangeToSet(filterSet, 9410, 127569);
        addUnicodeRangeToSet(filterSet, 128512, 128566);
        addUnicodeRangeToSet(filterSet, 128641, 128709);
        addUnicodeRangeToSet(filterSet, 127757, 128359);
    }

    private static void addUnicodeRangeToSet(Set<String> set, int i, int i2) {
        if (set != null && i <= i2) {
            while (i <= i2) {
                filterSet.add(new String(new int[]{i}, 0, 1));
                i++;
            }
        }
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return filterSet.contains(charSequence.toString()) ? "" : charSequence;
    }
}
