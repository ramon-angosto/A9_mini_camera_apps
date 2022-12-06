package com.vungle.warren.network.converters;

import java.io.IOException;

public interface Converter<In, Out> {
    Out convert(In in) throws IOException;
}
