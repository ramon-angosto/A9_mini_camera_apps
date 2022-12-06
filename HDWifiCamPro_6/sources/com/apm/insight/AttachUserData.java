package com.apm.insight;

import java.util.Map;

public interface AttachUserData {
    Map<? extends String, ? extends String> getUserData(CrashType crashType);
}
