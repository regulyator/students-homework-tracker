package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.domain.HomeWork;
import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.data.exception.EntityNotFoundException;
import com.regulyator.hwtracker.data.repository.HomeWorkRepository;
import com.regulyator.hwtracker.data.service.data.HomeworkService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeWorkRepository homeWorkRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeworkServiceImpl(HomeWorkRepository homeWorkRepository,
                               ModelMapper modelMapper) {
        this.homeWorkRepository = homeWorkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HomeWorkDto save(@NonNull HomeWorkDto homeWorkDto) {
        final var savedHomeWork = homeWorkRepository.save(modelMapper.map(homeWorkDto, HomeWork.class));
        return modelMapper.map(savedHomeWork, HomeWorkDto.class);
    }

    @Override
    public HomeWorkDto getById(@NonNull String id) {
        return homeWorkRepository
                .findById(id)
                .map(homeWork -> modelMapper.map(homeWork, HomeWorkDto.class))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<HomeWorkDto> getAll() {
        return homeWorkRepository.findAll().stream()
                .map(homeWork -> modelMapper.map(homeWork, HomeWorkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(@NonNull String id) {
        homeWorkRepository.deleteById(id);
    }
}
