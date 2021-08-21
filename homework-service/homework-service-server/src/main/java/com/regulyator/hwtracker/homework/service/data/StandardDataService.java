package com.regulyator.hwtracker.homework.service.data;

import java.util.List;

public interface StandardDataService<T> {

    T save(T t);

    T getById(String id);

    List<T> getAll();

    void removeById(String id);
}
