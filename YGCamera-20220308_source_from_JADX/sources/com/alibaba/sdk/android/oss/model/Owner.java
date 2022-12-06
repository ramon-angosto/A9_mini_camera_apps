package com.alibaba.sdk.android.oss.model;

import java.io.Serializable;

public class Owner implements Serializable {
    private static final long serialVersionUID = -1942759024112448066L;
    private String displayName;

    /* renamed from: id */
    private String f44id;

    public Owner() {
        this((String) null, (String) null);
    }

    public Owner(String str, String str2) {
        this.f44id = str;
        this.displayName = str2;
    }

    public String toString() {
        return "Owner [name=" + getDisplayName() + ",id=" + getId() + "]";
    }

    public String getId() {
        return this.f44id;
    }

    public void setId(String str) {
        this.f44id = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Owner)) {
            return false;
        }
        Owner owner = (Owner) obj;
        String id = owner.getId();
        String displayName2 = owner.getDisplayName();
        String id2 = getId();
        String displayName3 = getDisplayName();
        if (id == null) {
            id = "";
        }
        if (displayName2 == null) {
            displayName2 = "";
        }
        if (id2 == null) {
            id2 = "";
        }
        if (displayName3 == null) {
            displayName3 = "";
        }
        if (!id.equals(id2) || !displayName2.equals(displayName3)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f44id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
