package com.mbridge.msdk.foundation.download.resource;

import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;

class ResourceStrategyExecutor implements IResourceStrategy {
    private ResourceStrategy resourceStrategy;

    public ResourceStrategyExecutor(ResourceStrategy resourceStrategy2) {
        this.resourceStrategy = resourceStrategy2;
    }

    public void processResource(MBResourceManager mBResourceManager, IDatabaseHelper iDatabaseHelper, ResourceConfig resourceConfig) {
        ResourceStrategy resourceStrategy2 = this.resourceStrategy;
        if (resourceStrategy2 != null) {
            try {
                resourceStrategy2.processResource(mBResourceManager, iDatabaseHelper, resourceConfig);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getResourceStrategyName() {
        return this.resourceStrategy.getResourceStrategyName();
    }
}
