package com.mbridge.msdk.foundation.fragment;

import android.view.KeyEvent;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }
}
