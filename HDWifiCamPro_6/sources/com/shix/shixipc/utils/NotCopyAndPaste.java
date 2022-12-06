package com.shix.shixipc.utils;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

public class NotCopyAndPaste implements ActionMode.Callback {
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return false;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }
}
