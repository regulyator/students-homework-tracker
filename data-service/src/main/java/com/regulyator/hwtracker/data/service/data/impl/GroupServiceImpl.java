package com.regulyator.hwtracker.data.service.data.impl;

import com.regulyator.hwtracker.data.dto.GroupDto;
import com.regulyator.hwtracker.data.repository.GroupRepository;
import com.regulyator.hwtracker.data.service.data.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupDto save(GroupDto entity) {
        return null;
    }

    @Override
    public GroupDto getById(String id) {
        return null;
    }

    @Override
    public List<GroupDto> getAll() {
        return null;
    }

    @Override
    public void removeById(String id) {

    }
}
