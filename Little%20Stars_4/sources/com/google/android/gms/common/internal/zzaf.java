package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.R;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;

public final class zzaf extends Button {
    public zzaf(Context context) {
        this(context, (AttributeSet) null);
    }

    public zzaf(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private void zza(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i);
        setMinWidth(i);
    }

    private void zza(Resources resources, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = zzf(i2, R.drawable.common_plus_signin_btn_icon_dark, R.drawable.common_plus_signin_btn_icon_light, R.drawable.common_plus_signin_btn_icon_dark);
            i6 = R.drawable.common_plus_signin_btn_text_dark;
            i5 = R.drawable.common_plus_signin_btn_text_light;
            i4 = R.drawable.common_plus_signin_btn_text_dark;
        } else {
            i3 = zzf(i2, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light);
            i6 = R.drawable.common_google_signin_btn_text_dark;
            i5 = R.drawable.common_google_signin_btn_text_light;
            i4 = R.drawable.common_google_signin_btn_text_light;
        }
        setBackgroundDrawable(resources.getDrawable(zzd(i, i3, zzf(i2, i6, i5, i4))));
    }

    private boolean zza(Scope[] scopeArr) {
        if (scopeArr == null) {
            return false;
        }
        for (Scope zzrw : scopeArr) {
            String zzrw2 = zzrw.zzrw();
            if ((zzrw2.contains("/plus.") && !zzrw2.equals(Scopes.PLUS_ME)) || zzrw2.equals(Scopes.GAMES)) {
                return true;
            }
        }
        return false;
    }

    private void zzb(Resources resources, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = R.color.common_plus_signin_btn_text_dark;
            i5 = R.color.common_plus_signin_btn_text_light;
            i4 = R.color.common_plus_signin_btn_text_dark;
        } else {
            i3 = R.color.common_google_signin_btn_text_dark;
            i5 = R.color.common_google_signin_btn_text_light;
            i4 = R.color.common_google_signin_btn_text_light;
        }
        setTextColor((ColorStateList) zzaa.zzz(resources.getColorStateList(zzf(i2, i3, i5, i4))));
        if (i == 0) {
            i6 = R.string.common_signin_button_text;
        } else if (i == 1) {
            i6 = R.string.common_signin_button_text_long;
        } else if (i == 2) {
            setText((CharSequence) null);
            setTransformationMethod((TransformationMethod) null);
        } else {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Unknown button size: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
        setText(resources.getString(i6));
        setTransformationMethod((TransformationMethod) null);
    }

    private int zzd(int i, int i2, int i3) {
        if (i == 0 || i == 1) {
            return i3;
        }
        if (i == 2) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Unknown button size: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    private int zzf(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    public void zza(Resources resources, int i, int i2, Scope[] scopeArr) {
        boolean zza = zza(scopeArr);
        zza(resources);
        zza(resources, i, i2, zza);
        zzb(resources, i, i2, zza);
    }
}
