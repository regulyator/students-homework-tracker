package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.data.repository.HomeWorkRepository;
import com.regulyator.hwtracker.data.service.data.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeWorkRepository homeWorkRepository;

    @Autowired
    public HomeworkServiceImpl(HomeWorkRepository homeWorkRepository) {
        this.homeWorkRepository = homeWorkRepository;
    }

    @Override
    public HomeWorkDto save(HomeWorkDto entity) {
        return null;
    }

    @Override
    public HomeWorkDto getById(String id) {
        return null;
    }

    @Override
    public List<HomeWorkDto> getAll() {
        return null;
    }

    @Override
    public void removeById(String id) {

    }
}
