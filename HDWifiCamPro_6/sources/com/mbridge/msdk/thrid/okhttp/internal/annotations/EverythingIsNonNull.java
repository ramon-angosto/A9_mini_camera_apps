package com.mbridge.msdk.thrid.okhttp.internal.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@TypeQualifierDefault({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Nonnull
@Retention(RetentionPolicy.RUNTIME)
public @interface EverythingIsNonNull {
}
