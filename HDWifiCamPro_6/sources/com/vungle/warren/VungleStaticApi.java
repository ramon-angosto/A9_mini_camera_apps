package com.vungle.warren;

import java.util.Collection;

public interface VungleStaticApi {
    Collection<String> getValidPlacements();

    boolean isInitialized();
}
