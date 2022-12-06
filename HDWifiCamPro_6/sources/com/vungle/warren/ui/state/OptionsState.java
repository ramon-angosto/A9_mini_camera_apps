package com.vungle.warren.ui.state;

public interface OptionsState {
    boolean getBoolean(String str, boolean z);

    Integer getInt(String str, int i);

    String getString(String str);

    void put(String str, int i);

    void put(String str, String str2);

    void put(String str, boolean z);
}
