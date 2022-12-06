package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation<T> implements Transformation<T> {

    /* renamed from: id */
    private String f53id;
    private final Collection<? extends Transformation<T>> transformations;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length >= 1) {
            this.transformations = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public MultiTransformation(Collection<? extends Transformation<T>> collection) {
        if (collection.size() >= 1) {
            this.transformations = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public Resource<T> transform(Resource<T> resource, int i, int i2) {
        Resource<T> resource2 = resource;
        for (Transformation transform : this.transformations) {
            Resource<T> transform2 = transform.transform(resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform2)) {
                resource2.recycle();
            }
            resource2 = transform2;
        }
        return resource2;
    }

    public String getId() {
        if (this.f53id == null) {
            StringBuilder sb = new StringBuilder();
            for (Transformation id : this.transformations) {
                sb.append(id.getId());
            }
            this.f53id = sb.toString();
        }
        return this.f53id;
    }
}
