package com.alibaba.sdk.android.oss.model;

public enum ObjectPermission {
    Private("private"),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default("default"),
    Unknown("");
    
    private String permissionString;

    private ObjectPermission(String str) {
        this.permissionString = str;
    }

    public static ObjectPermission parsePermission(String str) {
        for (ObjectPermission objectPermission : new ObjectPermission[]{Private, PublicRead, PublicReadWrite, Default}) {
            if (objectPermission.permissionString.equals(str)) {
                return objectPermission;
            }
        }
        return Unknown;
    }

    public String toString() {
        return this.permissionString;
    }
}
