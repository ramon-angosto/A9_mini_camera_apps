package com.google.ads.mediation.pangle;

import android.os.Bundle;

public class PangleExtras {

    static class Keys {
        static final String USER_DATA = "user_data";

        Keys() {
        }
    }

    public static class Builder {
        private String userData;

        public Builder setUserData(String str) {
            this.userData = str;
            return this;
        }

        public Bundle build() {
            Bundle bundle = new Bundle();
            bundle.putString("user_data", this.userData);
            return bundle;
        }
    }
}
