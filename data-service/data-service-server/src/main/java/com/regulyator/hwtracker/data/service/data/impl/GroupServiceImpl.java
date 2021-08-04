package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.domain.Group;
import com.regulyator.hwtracker.data.dto.GroupDto;
import com.regulyator.hwtracker.data.exception.EntityNotFoundException;
import com.regulyator.hwtracker.data.repository.GroupRepository;
import com.regulyator.hwtracker.data.service.data.GroupService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository,
                            ModelMapper modelMapper) {
        this.groupRepository = groupRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GroupDto save(@NonNull GroupDto groupDto) {
        final var savedGroup = groupRepository.save(modelMapper.map(groupDto, Group.class));
        return modelMapper.map(savedGroup, GroupDto.class);
    }

    @Override
    public GroupDto getById(@NonNull String id) {
        return groupRepository
                .findById(id)
                .map(group -> modelMapper.map(group, GroupDto.class))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<GroupDto> getAll() {
        return groupRepository.findAll().stream()
                .map(group -> modelMapper.map(group, GroupDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(@NonNull String id) {
        groupRepository.deleteById(id);
    }
}
