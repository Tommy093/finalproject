package com.mechanicproject.service;

import com.mechanicproject.entity.Privilege;
import com.mechanicproject.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeService {
    private PrivilegeRepository privilegeRepository;

    @Autowired
    public PrivilegeService(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    void save(Privilege privilege){
        privilegeRepository.save(privilege);
    }
}
