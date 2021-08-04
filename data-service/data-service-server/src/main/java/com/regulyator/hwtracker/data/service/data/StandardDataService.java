package com.regulyator.hwtracker.data.service.data;

import java.util.List;

public interface StandardDataService<T> {

    T save(T entity);

    T getById(String id);

    List<T> getAll();

    void removeById(String id);
}
