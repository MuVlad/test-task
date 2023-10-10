package com.gridnine.testing.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
}
