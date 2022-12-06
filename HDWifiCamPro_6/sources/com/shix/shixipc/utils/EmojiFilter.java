package com.shix.shixipc.utils;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

public class EmojiFilter implements InputFilter {
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66).matcher(charSequence).find()) {
            return "";
        }
        return null;
    }
}
