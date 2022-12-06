package com.baidu.mapapi;

import java.util.ArrayList;

public class MKSuggestionResult {
    private int a = 0;
    private ArrayList<MKSuggestionInfo> b;

    /* access modifiers changed from: package-private */
    public void a(ArrayList<MKSuggestionInfo> arrayList) {
        this.b = arrayList;
    }

    public ArrayList<MKSuggestionInfo> getAllSuggestions() {
        return this.b;
    }

    public MKSuggestionInfo getSuggestion(int i) {
        ArrayList<MKSuggestionInfo> arrayList = this.b;
        if (arrayList == null || this.a <= i) {
            return null;
        }
        return arrayList.get(i);
    }

    public int getSuggestionNum() {
        ArrayList<MKSuggestionInfo> arrayList = this.b;
        this.a = arrayList != null ? arrayList.size() : 0;
        return this.a;
    }
}
