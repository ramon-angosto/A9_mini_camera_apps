package com.unad.sdk.dto;

import java.io.Serializable;

public class SourceVO implements Serializable {
    private String id;
    private int index;
    private int rate;
    private String source;

    public String getId() {
        return this.id;
    }

    public int getIndex() {
        return this.index;
    }

    public int getRate() {
        return this.rate;
    }

    public String getSource() {
        return this.source;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setRate(int i) {
        this.rate = i;
    }

    public void setSource(String str) {
        this.source = str;
    }
}
