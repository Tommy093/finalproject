package com.mechanicproject.repository;

import com.mechanicproject.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

}
