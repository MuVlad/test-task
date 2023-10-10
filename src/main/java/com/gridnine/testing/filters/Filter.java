package com.gridnine.testing.filters;

import java.util.List;

public interface Filter<T> {
    List<T> filter();
}
