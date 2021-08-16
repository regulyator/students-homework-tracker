package com.regulyator.hwtracker.homework.service.data.impl;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.homework.domain.HomeWork;
import com.regulyator.hwtracker.homework.exception.EntityNotFoundException;
import com.regulyator.hwtracker.homework.repository.HomeWorkRepository;
import com.regulyator.hwtracker.homework.service.data.HomeWorkService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeWorkServiceImpl implements HomeWorkService {
    private final HomeWorkRepository homeWorkRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeWorkServiceImpl(HomeWorkRepository homeWorkRepository,
                               ModelMapper modelMapper) {
        this.homeWorkRepository = homeWorkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HomeWorkDto> getAllActiveHomeworks() {
        var nowDate = new Date();
        return homeWorkRepository.findAllByHomeworkStartBeforeAndHomeworkEndAfter(nowDate, nowDate).stream()
                .map(group -> modelMapper.map(group, HomeWorkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<HomeWorkDto> getAllHomeWorkByPeriod(@NonNull Date start, @NonNull Date end) {
        return homeWorkRepository.findAllByHomeworkStartBeforeAndHomeworkEndAfter(start, end).stream()
                .map(group -> modelMapper.map(group, HomeWorkDto.class))
                .collect(Collectors.toList());
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
                .map(course -> modelMapper.map(course, HomeWorkDto.class))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<HomeWorkDto> getAll() {
        return homeWorkRepository.findAll().stream()
                .map(group -> modelMapper.map(group, HomeWorkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(@NonNull String id) {
        homeWorkRepository.deleteById(id);
    }
}
