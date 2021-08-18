package com.regulyator.hwtracker.homework.service.data.impl;

import com.regulyator.hwtracker.data.dto.HomeWorkDto;
import com.regulyator.hwtracker.data.dto.StudentHomeworkInformationDto;
import com.regulyator.hwtracker.homework.domain.HomeWork;
import com.regulyator.hwtracker.homework.exception.EntityNotFoundException;
import com.regulyator.hwtracker.homework.repository.HomeWorkRepository;
import com.regulyator.hwtracker.homework.service.data.HomeWorkService;
import com.regulyator.hwtracker.homework.service.external.DataExchangeApiServiceClient;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class HomeWorkServiceImpl implements HomeWorkService {
    private final HomeWorkRepository homeWorkRepository;
    private final DataExchangeApiServiceClient dataExchangeApiServiceClient;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeWorkServiceImpl(HomeWorkRepository homeWorkRepository,
                               DataExchangeApiServiceClient dataExchangeApiServiceClient,
                               ModelMapper modelMapper) {
        this.homeWorkRepository = homeWorkRepository;
        this.dataExchangeApiServiceClient = dataExchangeApiServiceClient;
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
    public List<HomeWorkDto> getAllGroupHomeWork(@NonNull String groupId) {
        return homeWorkRepository.findAllByGroupId(groupId).stream()
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
        initStudentsForNewHomeWork(homeWorkDto);
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

    private void initStudentsForNewHomeWork(HomeWorkDto homeWorkDto) {
        if (StringUtils.hasText(homeWorkDto.getGroupId())
                && (Objects.isNull(homeWorkDto.getStudents()) || homeWorkDto.getStudents().isEmpty())) {

            var group = dataExchangeApiServiceClient.getGroupDtoById(homeWorkDto.getGroupId());
            group.ifPresent(groupDto -> {
                var homeworkStudents = groupDto.getStudents().stream()
                        .map(studentDto ->
                                StudentHomeworkInformationDto.builder()
                                        .studentId(studentDto.getId())
                                        .build())
                        .collect(Collectors.toList());
                homeWorkDto.setStudents(homeworkStudents);
            });

        }
    }
}
