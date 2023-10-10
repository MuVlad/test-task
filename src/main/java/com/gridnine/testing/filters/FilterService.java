package com.gridnine.testing.filters;


import com.gridnine.testing.repository.Repository;

public abstract class FilterService<T> implements Filter<T> {

    protected final Repository<T> repository;

    protected FilterService(Repository<T> repository) {
        this.repository = repository;
    }
}
