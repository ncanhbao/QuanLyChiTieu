package com.qlct.service.impl;

import com.qlct.pojo.Igroups;
import com.qlct.repository.GroupRepository;
import com.qlct.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Igroups> getGroups() {
        return groupRepository.getGroups();
    }
}
